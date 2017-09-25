package com.google.android.gms.c;

public final class bh {
    public static final int[] aCL = new int[0];
    public static final long[] aCM = new long[0];
    public static final float[] aCN = new float[0];
    public static final double[] aCO = new double[0];
    public static final boolean[] aCP = new boolean[0];
    public static final String[] aCQ = new String[0];
    public static final byte[][] aCR = new byte[0][];
    public static final byte[] aCS = new byte[0];

    static int an(int i, int i2) {
        return (i << 3) | i2;
    }

    public static final int b(aw awVar, int i) {
        int i2 = 1;
        int position = awVar.getPosition();
        awVar.cf(i);
        while (awVar.ll() == i) {
            awVar.cf(i);
            i2++;
        }
        awVar.ci(position);
        return i2;
    }

    static int ct(int i) {
        return i & 7;
    }

    public static int cu(int i) {
        return i >>> 3;
    }
}
