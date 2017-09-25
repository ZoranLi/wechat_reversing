package com.tencent.c.e;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class c {
    public static byte[] cdL() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            String str = "http://pmir.3g.qq.com";
            int[] iArr = new int[]{-36, -46, -45, -77, -22, -10, 47, -77, -72, -69, -32, 25, 21, -21, -6, -75, -71, 31, -39, -49, -49};
            for (int i = 0; i < str.length(); i++) {
                stringBuffer.append((char) (str.charAt(i) + iArr[i]));
            }
            return stringBuffer.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    private static void a(byte[] bArr, int[] iArr) {
        int i = 0;
        int length = bArr.length >> 2;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i + 1;
            iArr[i2] = bArr[i] & 255;
            int i4 = i3 + 1;
            iArr[i2] = iArr[i2] | ((bArr[i3] & 255) << 8);
            i3 = i4 + 1;
            iArr[i2] = iArr[i2] | ((bArr[i4] & 255) << 16);
            i = i3 + 1;
            iArr[i2] = ((bArr[i3] & 255) << 24) | iArr[i2];
            i2++;
        }
        if (i < bArr.length) {
            i3 = i + 1;
            iArr[i2] = bArr[i] & 255;
            i = 8;
            while (i3 < bArr.length) {
                iArr[i2] = iArr[i2] | ((bArr[i3] & 255) << i);
                i3++;
                i += 8;
            }
        }
    }

    private static byte[] bw(byte[] bArr) {
        if (bArr == null || bArr.length <= 16) {
            return bArr;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            return instance.digest();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static byte[] j(byte[] bArr, byte[] bArr2) {
        int i = 0;
        byte[] bw = bw(bArr2);
        if (!(bArr == null || bw == null || bArr.length == 0)) {
            int i2;
            int length = bArr.length % 4 == 0 ? (bArr.length >>> 2) + 1 : (bArr.length >>> 2) + 2;
            int[] iArr = new int[length];
            a(bArr, iArr);
            iArr[length - 1] = bArr.length;
            length = bw.length % 4 == 0 ? bw.length >>> 2 : (bw.length >>> 2) + 1;
            if (length < 4) {
                length = 4;
            }
            int[] iArr2 = new int[length];
            for (i2 = 0; i2 < length; i2++) {
                iArr2[i2] = 0;
            }
            a(bw, iArr2);
            int length2 = iArr.length - 1;
            length = (52 / (length2 + 1)) + 6;
            int i3 = 0;
            int i4 = iArr[length2];
            while (true) {
                i2 = length - 1;
                if (length <= 0) {
                    break;
                }
                int i5;
                length = -1640531527 + i3;
                int i6 = (length >>> 2) & 3;
                i3 = 0;
                while (i3 < length2) {
                    i5 = iArr[i3 + 1];
                    i4 = (((i4 ^ iArr2[(i3 & 3) ^ i6]) + (i5 ^ length)) ^ (((i4 >>> 5) ^ (i5 << 2)) + ((i5 >>> 3) ^ (i4 << 4)))) + iArr[i3];
                    iArr[i3] = i4;
                    i3++;
                }
                i5 = iArr[0];
                i3 = (((iArr2[(i3 & 3) ^ i6] ^ i4) + (i5 ^ length)) ^ (((i4 >>> 5) ^ (i5 << 2)) + ((i5 >>> 3) ^ (i4 << 4)))) + iArr[length2];
                iArr[length2] = i3;
                i4 = i3;
                i3 = length;
                length = i2;
            }
            bArr = new byte[(iArr.length << 2)];
            i2 = iArr.length;
            length = bArr.length >> 2;
            if (length > i2) {
                length = i2;
            }
            i3 = 0;
            while (i3 < length) {
                i4 = i + 1;
                bArr[i] = (byte) (iArr[i3] & 255);
                i = i4 + 1;
                bArr[i4] = (byte) ((iArr[i3] >>> 8) & 255);
                i4 = i + 1;
                bArr[i] = (byte) ((iArr[i3] >>> 16) & 255);
                i = i4 + 1;
                bArr[i4] = (byte) ((iArr[i3] >>> 24) & 255);
                i3++;
            }
            if (i2 > length && i < bArr.length) {
                length = i + 1;
                bArr[i] = (byte) (iArr[i3] & 255);
                i = 8;
                while (i <= 24 && length < bArr.length) {
                    i2 = length + 1;
                    bArr[length] = (byte) ((iArr[i3] >>> i) & 255);
                    i += 8;
                    length = i2;
                }
            }
        }
        return bArr;
    }
}
