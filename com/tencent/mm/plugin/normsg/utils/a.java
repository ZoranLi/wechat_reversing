package com.tencent.mm.plugin.normsg.utils;

public final class a {
    private static final char[] nZF = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String f(byte[] bArr, int i, int i2) {
        char[] cArr = new char[((i2 - i) * 2)];
        int i3 = 0;
        while (i < i2) {
            byte b = bArr[i];
            int i4 = i3 + 1;
            cArr[i3] = nZF[(b >>> 4) & 15];
            i3 = i4 + 1;
            cArr[i4] = nZF[b & 15];
            i++;
        }
        return new String(cArr);
    }
}
