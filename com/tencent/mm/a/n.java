package com.tencent.mm.a;

public final class n {
    public static byte[] cP(int i) {
        int i2 = 0;
        byte[] bArr = new byte[4];
        for (int i3 = 0; i3 < 4; i3++) {
            bArr[i3] = (byte) ((i >> (i3 * 8)) & 255);
        }
        byte[] bArr2 = new byte[4];
        while (i2 < 4) {
            bArr2[i2] = bArr[3 - i2];
            i2++;
        }
        return bArr2;
    }

    public static int p(byte[] bArr) {
        return ((((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16)) | ((bArr[1] & 255) << 8)) | ((bArr[0] & 255) << 0);
    }

    public static int c(byte[] bArr, int i) {
        return ((((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16)) | ((bArr[i + 2] & 255) << 8)) | ((bArr[i + 3] & 255) << 0);
    }
}
