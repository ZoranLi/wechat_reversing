package com.tencent.mm.plugin.gesture.a;

import android.util.Base64;
import com.tencent.mm.protocal.c.apc;
import com.tencent.mm.protocal.c.apd;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.io.ByteArrayOutputStream;

public final class b {
    private static long mHQ = -1;

    public static e aCv() {
        ap.yY();
        t vr = c.vr();
        if (vr == null) {
            return new e();
        }
        Object obj = vr.get(339969, null);
        if (obj == null) {
            return new e();
        }
        return new e().au(yg((String) obj));
    }

    public static void j(long j, long j2) {
        ap.yY();
        t vr = c.vr();
        if (vr != null) {
            e eVar = new e();
            eVar.mHZ = j;
            eVar.mIa = j2;
            vr.set(339969, as(eVar.toByteArray()));
            vr.jY(true);
        }
    }

    public static void aCw() {
        ap.yY();
        t vr = c.vr();
        if (vr != null) {
            vr.set(339969, null);
            vr.jY(true);
        }
    }

    public static long aCx() {
        return mHQ;
    }

    public static void co(long j) {
        mHQ = j;
    }

    public static void aCy() {
        mHQ = -1;
    }

    public static e aCz() {
        ap.yY();
        t vr = c.vr();
        if (vr == null) {
            return new e();
        }
        Object obj = vr.get(339971, null);
        if (obj == null) {
            return new e();
        }
        return new e().au(yg((String) obj));
    }

    public static void k(long j, long j2) {
        ap.yY();
        t vr = c.vr();
        if (vr != null) {
            e eVar = new e();
            eVar.mHZ = j;
            eVar.mIa = j2;
            vr.set(339971, as(eVar.toByteArray()));
            vr.jY(true);
        }
    }

    public static void aCA() {
        ap.yY();
        t vr = c.vr();
        if (vr != null) {
            vr.set(339971, null);
            vr.jY(true);
        }
    }

    public static apc aCB() {
        ap.yY();
        t vr = c.vr();
        if (vr == null) {
            return null;
        }
        String str = (String) vr.get(339989, null);
        if (bg.mA(str)) {
            return null;
        }
        try {
            return (apc) new apc().aD(Base64.decode(str, 2));
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e, "", new Object[0]);
            return null;
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e2, "", new Object[0]);
            return null;
        }
    }

    public static void a(apc com_tencent_mm_protocal_c_apc) {
        ap.yY();
        t vr = c.vr();
        if (vr != null) {
            try {
                vr.set(339989, Base64.encodeToString(com_tencent_mm_protocal_c_apc.toByteArray(), 2));
                vr.jY(true);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e, "", new Object[0]);
            }
        }
    }

    public static apd aCC() {
        ap.yY();
        t vr = c.vr();
        if (vr == null) {
            return null;
        }
        String str = (String) vr.get(339990, null);
        if (bg.mA(str)) {
            return null;
        }
        try {
            return (apd) new apd().aD(Base64.decode(str, 2));
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e, "", new Object[0]);
            return null;
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e2, "", new Object[0]);
            return null;
        }
    }

    public static void a(apd com_tencent_mm_protocal_c_apd) {
        ap.yY();
        t vr = c.vr();
        if (vr != null) {
            try {
                vr.set(339990, Base64.encodeToString(com_tencent_mm_protocal_c_apd.toByteArray(), 2));
                vr.jY(true);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e, "", new Object[0]);
            }
        }
    }

    public static int aCD() {
        ap.yY();
        t vr = c.vr();
        if (vr == null) {
            return -1;
        }
        Object obj = vr.get(339972, null);
        if (obj == null) {
            return -1;
        }
        return ((Integer) obj).intValue();
    }

    public static void nR(int i) {
        ap.yY();
        t vr = c.vr();
        if (vr != null) {
            vr.set(339972, Integer.valueOf(i));
            vr.jY(true);
        }
    }

    public static void aCE() {
        ap.yY();
        t vr = c.vr();
        if (vr != null) {
            vr.set(339972, null);
            vr.jY(true);
        }
    }

    private static String as(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() < 2) {
                stringBuilder.append('0');
            }
            stringBuilder.append(toHexString);
        }
        return stringBuilder.toString();
    }

    private static byte[] yg(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < str.length(); i += 2) {
            byteArrayOutputStream.write(Integer.parseInt(str.substring(i, i + 2), 16));
        }
        return byteArrayOutputStream.toByteArray();
    }
}
