package com.rep.base;

import java.io.File;
import java.io.IOException;

import com.rep.base.BitmapEncoder;

public class TRDataToBitmapTest {
    private byte[] makeImage() {
        byte[] result = null;

        try {
            String[] inputData = new String[34];
            inputData[0] = "1";
            inputData[1] = "일반음식점";
            inputData[2] = "130,000";
            inputData[3] = "0001";
            inputData[4] = "0001";
            inputData[5] = "Y";
            inputData[6] = "아이폰";
            inputData[7] = "12:34:34:35:92:84:83:33";
            inputData[8] = "10.33.124.98";
            inputData[9] = "중국";
            inputData[10] = "";
            inputData[11] = "ABD238SDP";
            inputData[12] = "ADT003"; //	가맹점번호.
            inputData[13] = "니뽕내뽕";
            inputData[14] = "10%";
            inputData[15] = "100,000";
            inputData[16] = "Y"; //	직전거래 이용여부.
            inputData[17] = "N"; //	MO.
            inputData[18] = "N"; //	ARS
            inputData[19] = "N"; //	불량가맹점 여부.
            inputData[20] = "Y"; //	문자 수신여부.
            inputData[21] = "12:00-14:00";
            inputData[22] = "20171118182022382";
            inputData[23] = "20171023145609123"; //	동일회원 다른카드 최근 이용일시.
            inputData[24] = "미국";
            inputData[25] = "2,000,000";
            inputData[26] = "유흥";
            inputData[27] = "12";
            inputData[28] = "18273642921";
            inputData[29] = "3011048372";
            inputData[30] = "애플코리아";
            inputData[31] = "Y";
            inputData[32] = "N";
            inputData[33] = "N";

            result = new byte[34 * 34];
            for (int i = 0; i < 34; i++) {
                /**
                 * 의도적으로 정사각형의 이미지를 생성하기 위해서, 바이트 사이즈를 맞추는 부분입니다. 34바이트 * 34바이트.
                 * 위 항목 중에서 가장 길이가 긴 데이터 기준으로 이미지의 사이즈가 정해집니다.
                 */
                System.out.println(String.format("%1$-34s", inputData[i]));
                System.out.println((String.format("%1$-34s", inputData[i])).getBytes());
                byte[] tmpByte = (String.format("%1$-34s", inputData[i])).getBytes();
                System.arraycopy(tmpByte, 0, result, (i * 34), 34);
            }

            return result;
        } catch (Exception e) {
//			Logger.error(e);
            return null;
        }
    }


    public static void main(String[] args) throws IOException {
        try {
            TRDataToBitmapTest bmpEnc = new TRDataToBitmapTest();

            byte[] inputData = bmpEnc.makeImage();

            BitmapEncoder bmEn = new BitmapEncoder();
            bmEn.encodeToBitmap(inputData, new File("./3-bytes.bmp"));


            //byte[] threebytes = bmEn.decodeFromBitmap(new File("./3-bytes.bmp"));
            return;
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}