package com.rep.base;

public class HaveSpecialBit {
    public static void main(String[] argv) throws Exception {
        byte value = 2;
        int bit = 2;
        // 判断一个字节的某一位是否有值
        System.out.println(getBit(value, bit));
    }/* from ww w . j a v a 2s . c o m */

    /**
     * gets the specified bit to a value
     * 
     * @param value the value to check
     * @param bit the bit number
     * @return if this bit is on
     */
    public static boolean getBit(byte value, int bit) {
        if (bit < 0 || bit >= 8)
            throw new IllegalArgumentException("invalid bit position");
        byte pos = (byte) (1 << bit);
        return (value & pos) != 0;
    }

    /**
     * sets the specified bit to a value
     * 
     * @param value the value to check
     * @param bit the bit number
     * @return if this bit is on
     */
    public static boolean getBit(short value, int bit) {
        if (bit < 0 || bit >= 16)
            throw new IllegalArgumentException("invalid bit position");
        short pos = (short) (1 << bit);
        return (value & pos) != 0;
    }

    /**
     * sets the specified bit to a value
     * 
     * @param value the value to check
     * @param bit the bit number
     * @return if this bit is on
     */
    public static boolean getBit(int value, int bit) {
        if (bit < 0 || bit >= 32)
            throw new IllegalArgumentException("invalid bit position");
        int pos = 1 << bit;
        return (value & pos) != 0;
    }

    /**
     * sets the specified bit to a value
     * 
     * @param value the value to check
     * @param bit the bit number
     * @return if this bit is on
     */
    public static boolean getBit(long value, int bit) {
        if (bit < 0 || bit >= 64)
            throw new IllegalArgumentException("invalid bit position");
        long pos = 1L << bit;
        return (value & pos) != 0;
    }
}