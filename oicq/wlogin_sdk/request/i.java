package oicq.wlogin_sdk.request;

import android.content.Context;
import java.security.SecureRandom;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.g;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

public final class i {
    public static byte[] xnC = new byte[0];
    public long _uin = 0;
    public Context xmZ = null;
    public int xnA = 0;
    byte[] xnB = new byte[0];
    byte[] xnD = new byte[0];
    int xnE = 0;
    byte[] xnF = new byte[0];
    byte[] xnG = new byte[0];
    byte[] xnH = new byte[0];
    byte[] xnI = new byte[0];
    byte[] xnJ = new byte[0];
    byte[] xnK = new byte[0];
    int xnL = 0;
    int xnM = 0;
    int xnN = 0;
    int xnO = 0;
    byte[] xnP = new byte[0];
    ErrMsg xnQ = new ErrMsg();
    byte[] xnR = new byte[0];
    byte[] xnS = new byte[4];
    byte[] xnT = new byte[0];
    c xnU = null;
    public SecureRandom xnr = new SecureRandom();
    public byte[] xns = util.ciw();
    public byte[] xnt = null;
    public byte[] xnu = new byte[16];
    public f xnv = new f();
    public g xnw = new g();
    public long xnx = 0;
    public int xny = 0;
    public long xnz = -1;

    public static long cin() {
        return System.currentTimeMillis() / 1000;
    }

    public final synchronized int a(long j, long j2, long j3, long j4, long j5, long j6, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8, byte[] bArr9, byte[] bArr10, byte[] bArr11, byte[] bArr12, byte[] bArr13, byte[] bArr14, byte[] bArr15, byte[] bArr16, byte[][] bArr17) {
        util.Wt("put siginfo:" + j + "," + j2 + "," + j3 + "," + j4 + "," + j5 + "," + j6 + "," + util.bV(bArr) + "," + util.bV(bArr2) + "," + util.bV(bArr3) + "," + util.bV(bArr4) + "," + util.bV(bArr5) + "," + util.bV(bArr6) + "," + util.bV(bArr7) + "," + util.bV(bArr8) + "," + util.bV(bArr9) + "," + util.bV(bArr10) + "," + util.bV(bArr11) + "," + util.bV(bArr12) + "," + util.bV(bArr13) + "," + util.bV(bArr14) + "," + util.bV(bArr15) + "," + util.bV(bArr16));
        String str = "";
        for (int i = 0; i < bArr17.length; i++) {
            str = new StringBuilder(String.valueOf(str)).append(String.format("reserve[%d]: %d ", new Object[]{Integer.valueOf(i), Long.valueOf(util.bV(bArr17[i]))})).toString();
        }
        util.Wt("reserve:" + str);
        return this.xnU.a(j, j2, j3, j4, j5, j6, bArr, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7, bArr8, bArr9, bArr10, bArr11, bArr12, bArr13, bArr14, bArr15, bArr16, bArr17);
    }

    public final synchronized WloginSigInfo y(long j, long j2) {
        WloginSigInfo y;
        util.fp("get_siginfo", "uin=" + j + "appid=522017402");
        y = this.xnU.y(j, 522017402);
        if (y != null) {
        }
        return y;
    }

    public final synchronized void i(Long l) {
        this.xnU.i(l);
    }
}
