package com.rep.base;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class BitmapEncoder {
    private final int BMP_SIZE_HEADER = 54;

    private final int BMP_SIZE_IMAGE_WIDTH = 4;

    private final int BMP_SIZE_PAYLOAD_LENGTH = 4;

    private final int BMP_SIZE_BMPUTIL_MAGIC = 4;

    private final int BMP_OFFSET_FILESIZE_BYTES = 2;

    private final int BMP_OFFSET_IMAGE_WIDTH = 18;

    private final int BMP_OFFSET_IMAGE_HEIGHT = 22;

    private final int BMP_OFFSET_IMAGE_DATA_BYTES = 34;

    private final int BMP_OFFSET_PAYLOAD_LENGTH = 38;

    private final int BMP_OFFSET_BMPUTIL_MAGIC = 42;

    private final byte UDEF = 0;

    private final byte[] BMP_HEADER = new byte[] {
        0x42, 0x4d, // signature, "BM"
        UDEF, UDEF, UDEF, UDEF, // size in bytes, filled dynamically
        0x00, 0x00, // reserved, must be zero
        0x00, 0x00, // reserved, must be zero
        0x36, 0x00, 0x00, 0x00, // offset to start of image data in bytes
        0x28, 0x00, 0x00, 0x00, // size of BITMAPINFOHEADER structure, must be 40 (0x28)
        UDEF, UDEF, UDEF, UDEF, // image width in pixels, filled dynamically
        UDEF, UDEF, UDEF, UDEF, // image height in pixels, filled dynamically
        0x01, 0x00, // number of planes, must be 1
        0x18, 0x00, // number of bits per pixel (1, 4, 8, or 24) -> 24 = 0x18
        0x00, 0x00, 0x00, 0x00, // compression type (0=none, 1=RLE-8, 2=RLE-4)
        UDEF, UDEF, UDEF, UDEF, // size of image data in bytes (including padding)
        UDEF, UDEF, UDEF, UDEF, // normally: horizontal resolution in pixels per meter (unreliable)
        UDEF, UDEF, UDEF, UDEF, // vertical resolution in pixels per meter (unreliable)
        0x00, 0x00, 0x00, 0x00, // number of colors in image, or zero
        0x00, 0x00, 0x00, 0x00, // number of important colors, or zero
    };

    private final byte[] BMPUTIL_MAGIC = new byte[] {
        0x30, 0x32, 0x30, 0x35
    };

    public void encodeToBitmap(File srcFile, File destFile) {
        try {
            this.encodeToBitmap(new FileInputStream(srcFile), srcFile.length(), new FileOutputStream(destFile));
            return;
        }
        catch (IOException ie) {
            ie.printStackTrace();
            return;
        }
        catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public void encodeToBitmap(byte[] srcBytes, File destFile) {
        try {
            encodeToBitmap(new ByteArrayInputStream(srcBytes), srcBytes.length, new FileOutputStream(destFile));
            return;
        }
        catch (IOException ie) {
            ie.printStackTrace();
            return;
        }
        catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public void encodeToBitmap(byte[] srcBytes, OutputStream destStream) {
        try {
            encodeToBitmap(new ByteArrayInputStream(srcBytes), srcBytes.length, destStream);
            return;
        }
        catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public void encodeToBitmap(InputStream srcStream, long srcStreamLength, OutputStream destStream) {
        try {
            if (srcStreamLength > Integer.MAX_VALUE) {
                System.out.println("File too big; max. " + Integer.MAX_VALUE + " bytes supported.");
                return;
            }

            int imageWidth = (int) Math.ceil(Math.sqrt((double) srcStreamLength / 3));
            int imageHeight = (int) Math.ceil((double) srcStreamLength / (double) imageWidth / 3);

            int rowPadding = 4 - (imageWidth * 3 % 4);
            int filesizeBytes = imageWidth * imageHeight * 3 + imageHeight * rowPadding + this.BMP_SIZE_HEADER;

            int imageBytesWithPadding = filesizeBytes - this.BMP_SIZE_HEADER;
            int payloadPadding = (int) (imageWidth * imageHeight * 3 - srcStreamLength);

            byte[] header = this.BMP_HEADER.clone();

            writeIntLE(header, this.BMP_OFFSET_FILESIZE_BYTES, filesizeBytes);
            writeIntLE(header, this.BMP_OFFSET_IMAGE_WIDTH, imageWidth);
            writeIntLE(header, this.BMP_OFFSET_IMAGE_HEIGHT, imageHeight);
            writeIntLE(header, this.BMP_OFFSET_IMAGE_DATA_BYTES, imageBytesWithPadding);
            writeIntLE(header, this.BMP_OFFSET_PAYLOAD_LENGTH, (int) srcStreamLength);

            System.arraycopy(this.BMPUTIL_MAGIC, 0, header, this.BMP_OFFSET_BMPUTIL_MAGIC, this.BMPUTIL_MAGIC.length);

            destStream.write(header, 0, header.length);
            byte[] row = new byte[imageWidth * 3];
            int read;

            while ((read = srcStream.read(row)) != -1) {
                destStream.write(row, 0, read);
                destStream.write(new byte[rowPadding]);
            }

            destStream.write(new byte[payloadPadding]);

            if (srcStream != null)
                srcStream.close();

            if (destStream != null)
                destStream.close();
        }
        catch (IOException ie) {
            ie.printStackTrace();
            return;
        }
        catch (Exception e) {
            e.printStackTrace();
            return;
        }
        finally {
            srcStream = null;
            destStream = null;
        }
    }

    public byte[] decodeFromBitmap(InputStream srcStream) {
        byte[] result = null;

        try {
            ByteArrayOutputStream destStream = new ByteArrayOutputStream();
            decodeFromBitmap(srcStream, destStream);

            result = destStream.toByteArray();
            return result;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] decodeFromBitmap(File srcFile) throws IOException {

        byte[] result = null;

        try {
            ByteArrayOutputStream destStream = new ByteArrayOutputStream();
            decodeFromBitmap(new FileInputStream(srcFile), destStream);

            result = destStream.toByteArray();
            return result;
        }
        catch (IOException ie) {
            ie.printStackTrace();
            return null;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void decodeFromBitmap(File srcFile, File destFile) {
        try {
            decodeFromBitmap(new FileInputStream(srcFile), new FileOutputStream(destFile));
            return;
        }
        catch (IOException ie) {
            ie.printStackTrace();
            return;
        }
        catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public void decodeFromBitmap(InputStream srcStream, OutputStream destStream) {
        long bytesRead = 0;

        try {
            bytesRead += srcStream.skip(this.BMP_OFFSET_IMAGE_WIDTH - bytesRead);
            byte[] imageWidthBytes = new byte[this.BMP_SIZE_IMAGE_WIDTH];
            bytesRead += srcStream.read(imageWidthBytes);
            int imageWidth = toIntLE(imageWidthBytes);

            bytesRead += srcStream.skip(this.BMP_OFFSET_PAYLOAD_LENGTH - bytesRead);
            byte[] payloadLengthBytes = new byte[this.BMP_SIZE_PAYLOAD_LENGTH];
            bytesRead += srcStream.read(payloadLengthBytes);
            int payloadLength = toIntLE(payloadLengthBytes);

            bytesRead += srcStream.skip(this.BMP_OFFSET_BMPUTIL_MAGIC - bytesRead);
            byte[] magicFieldBytes = new byte[this.BMP_SIZE_BMPUTIL_MAGIC];
            bytesRead += srcStream.read(magicFieldBytes);

            if (!Arrays.equals(this.BMPUTIL_MAGIC, magicFieldBytes)) {
                throw new IOException("Given bitmap does not contain encoded binary data.");
            }

            bytesRead += srcStream.skip(this.BMP_SIZE_HEADER - bytesRead);

            if (payloadLength > 0) {
                int rowPaddingLength = 4 - (imageWidth * 3 % 4);
                int rowLength = imageWidth * 3;

                byte[] row = new byte[rowLength];
                int read;
                int restOfPayload = payloadLength;

                while ((read = srcStream.read(row)) != -1) {
                    if (restOfPayload >= read) {
                        destStream.write(row, 0, read);
                        srcStream.skip(rowPaddingLength);

                        restOfPayload -= read;
                    }
                    else {
                        destStream.write(row, 0, restOfPayload);
                        break;
                    }
                }
            }

            if (srcStream != null)
                srcStream.close();

            if (destStream != null)
                destStream.close();

            return;
        }
        catch (IOException ie) {
            ie.printStackTrace();
            return;
        }
        catch (Exception e) {
            e.printStackTrace();
            return;
        }
        finally {
            srcStream = null;
            destStream = null;
        }

    }

    private void writeIntLE(byte[] bytes, int startoffset, int value) {
        try {
            bytes[startoffset] = (byte) (value);
            bytes[startoffset + 1] = (byte) (value >>> 8);
            bytes[startoffset + 2] = (byte) (value >>> 16);
            bytes[startoffset + 3] = (byte) (value >>> 24);

            return;
        }
        catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    private int toIntLE(byte[] value) {
        return ((value[3] & 0xff) << 24) | ((value[2] & 0xff) << 16) | ((value[1] & 0xff) << 8) | (value[0] & 0xff);
    }
}