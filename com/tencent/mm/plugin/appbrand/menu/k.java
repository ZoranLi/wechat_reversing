package com.tencent.mm.plugin.appbrand.menu;

public final class k {
    public static final int jaA = 3;
    public static final int jaB = 4;
    public static final int jaC = 5;
    public static final int jaD = 6;
    public static final int jaE = 7;
    public static final int jaF = 8;
    public static final int jaG = 9;
    public static final int jaH = 10;
    public static final int jaI = 11;
    private static final /* synthetic */ int[] jaJ = new int[]{jay, jaz, jaA, jaB, jaC, jaD, jaE, jaF, jaG, jaH, jaI};
    public static final int jay = 1;
    public static final int jaz = 2;

    public static int hZ(int i) {
        for (int i2 : (int[]) jaJ.clone()) {
            if (i2 - 1 == i) {
                return i2;
            }
        }
        return 0;
    }
}
