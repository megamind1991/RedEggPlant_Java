package com.rep.base;


public class SetSpecialBit {
    public static void main(String[] argv) throws Exception {
        byte value = 2;
        int bit = 2;
        boolean on = true;
        // 可以设置byte shot int long 的bit位的值 用于标签
        System.out.println(setBit(value, bit, on));
    }//  w  w w  .j  a  v  a2 s.  com

    /**
     * sets the specified bit to a value
     * @param value the base value
     * @param bit the bit number
     * @param on set it to on or not
     * @return value with the bit set
     */
    public static byte setBit(byte value, int bit, boolean on) {
        if (bit < 0 || bit >= 8)
            throw new IllegalArgumentException("invalid bit position");
        byte pos = (byte) (1 << bit);
        if (on)
            return (byte) (value | pos);
        else
            return (byte) (value & ~pos);
    }

    /**
     * sets the specified bit to a value
     * @param value the base value
     * @param bit the bit number
     * @param on set it to on or not
     * @return value with the bit set
     */
    public static short setBit(short value, int bit, boolean on) {
        if (bit < 0 || bit >= 16)
            throw new IllegalArgumentException("invalid bit position");
        short pos = (short) (1 << bit);
        if (on)
            return (short) (value | pos);
        else
            return (short) (value & ~pos);
    }

    /**
     * sets the specified bit to a value
     * @param value the base value
     * @param bit the bit number
     * @param on set it to on or not
     * @return value with the bit set
     */
    public static int setBit(int value, int bit, boolean on) {
        if (bit < 0 || bit >= 32)
            throw new IllegalArgumentException("invalid bit position");
        int pos = 1 << bit;
        if (on)
            return value | pos;
        else
            return value & ~pos;
    }

    /**
     * sets the specified bit to a value
     * @param value the base value
     * @param bit the bit number
     * @param on set it to on or not
     * @return value with the bit set
     */
    public static long setBit(long value, int bit, boolean on) {
        if (bit < 0 || bit >= 64)
            throw new IllegalArgumentException("invalid bit position");
        long pos = 1L << bit;
        if (on)
            return value | pos;
        else
            return value & ~pos;
    }
}