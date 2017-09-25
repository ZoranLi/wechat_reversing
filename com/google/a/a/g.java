package com.google.a.a;

public final class g {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final int[] aIr = new int[0];
    public static final long[] aIs = new long[0];
    public static final float[] aIt = new float[0];
    public static final double[] aIu = new double[0];
    public static final boolean[] aIv = new boolean[0];
    public static final byte[][] aIw = new byte[0][];
    public static final byte[] aIx = new byte[0];

    static int cK(int i) {
        return i & 7;
    }

    public static int cL(int i) {
        return i >>> 3;
    }

    static int au(int i, int i2) {
        return (i << 3) | i2;
    }

    public static boolean a(a aVar, int i) {
        return aVar.cz(i);
    }

    public static final int b(a aVar, int i) {
        int i2 = 1;
        int position = aVar.getPosition();
        aVar.cz(i);
        while (aVar.mK() == i) {
            aVar.cz(i);
            i2++;
        }
        aVar.cC(position);
        return i2;
    }
}
