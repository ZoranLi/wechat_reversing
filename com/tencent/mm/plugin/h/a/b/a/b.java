package com.tencent.mm.plugin.h.a.b.a;

import com.tencent.mm.plugin.h.a.b.h;
import com.tencent.mm.sdk.platformtools.w;

public class b extends a {
    public static final String TAG = b.class.getName();
    public static String jSN = h.jSH;
    public static String jSO = h.jSI;
    public static String jSP = h.jSJ;
    private final int jSQ;
    private final int jSR;
    private final int jSS;
    private final int jST;
    private final int jSU;
    b jSV;
    a jSW;
    int jSX;

    private class a {
        public boolean jSY = false;
        public double jSZ = 0.0d;
        public int jTa = 0;
        public int jTb = 0;
        public int jTc = 0;
        public c jTd = new c();
        final /* synthetic */ b jTe;

        public a(b bVar) {
            this.jTe = bVar;
        }
    }

    private class b {
        public boolean jSY = false;
        public int jTa = 0;
        public int jTb = 0;
        public int jTc = 0;
        public c jTd = new c();
        final /* synthetic */ b jTe;
        public double jTf = 0.0d;
        public double jTg = 0.0d;
        public double jTh = 0.0d;

        public b(b bVar) {
            this.jTe = bVar;
        }
    }

    public static class c {
        public int jTi = 0;
        public int jTj = 0;
        public int jTk = 0;
        public int jTl = 0;
        public int jTm = 0;
        public int jTn = 0;

        public final boolean t(byte[] bArr, int i) {
            String str = b.TAG;
            String str2 = "data size = %d, offset = %d, lenght = %d";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(bArr == null ? 0 : bArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(7);
            w.d(str, str2, objArr);
            if (bArr == null || i < 0 || bArr.length < i + 7) {
                w.e(b.TAG, "data input error");
                return false;
            }
            this.jTi = (bArr[i] & 255) + ((bArr[i + 1] & 255) << 8);
            this.jTj = bArr[i + 2] & 255;
            this.jTk = bArr[i + 3] & 255;
            this.jTl = bArr[i + 4] & 255;
            this.jTm = bArr[i + 5] & 255;
            this.jTn = bArr[i + 6] & 255;
            w.d(b.TAG, "year = %d, month = %d, day = %d, hours = %d, minutes = %d, seconds = %d", new Object[]{Integer.valueOf(this.jTi), Integer.valueOf(this.jTj), Integer.valueOf(this.jTk), Integer.valueOf(this.jTl), Integer.valueOf(this.jTm), Integer.valueOf(this.jTn)});
            return true;
        }
    }

    public b() {
        this.jSQ = 1;
        this.jSR = 2;
        this.jSS = 4;
        this.jST = 8;
        this.jSU = 16;
        this.jSL = null;
        this.jSM = 2;
        this.jSe = 8;
        this.jSV = null;
    }

    static double s(byte[] bArr, int i) {
        int i2 = (bArr[i + 1] << 8) & 65280;
        int i3 = (i2 >> 12) - 16;
        int i4 = i2 & 3840;
        int i5 = (bArr[i] & 255) + (65280 & i4);
        double pow = ((double) i5) * Math.pow(10.0d, (double) i3);
        w.d(TAG, "hbyte=" + i2 + " hvalue=" + i4 + " value=" + i5 + " exp=" + i3);
        return pow;
    }

    public final byte[] adj() {
        return null;
    }
}
