package com.tencent.tinker.a.b.b;

public final class a {
    public static String fd(long j) {
        char[] cArr = new char[16];
        for (int i = 0; i < 16; i++) {
            cArr[15 - i] = Character.forDigit(((int) j) & 15, 16);
            j >>= 4;
        }
        return new String(cArr);
    }

    public static String Dz(int i) {
        char[] cArr = new char[8];
        for (int i2 = 0; i2 < 8; i2++) {
            cArr[7 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    public static String DA(int i) {
        char[] cArr = new char[4];
        for (int i2 = 0; i2 < 4; i2++) {
            cArr[3 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    public static String DB(int i) {
        if (i == ((char) i)) {
            return DA(i);
        }
        return Dz(i);
    }

    public static String DC(int i) {
        int i2 = 0;
        char[] cArr = new char[9];
        if (i < 0) {
            cArr[0] = '-';
            i = -i;
        } else {
            cArr[0] = '+';
        }
        while (i2 < 8) {
            cArr[8 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
            i2++;
        }
        return new String(cArr);
    }
}
