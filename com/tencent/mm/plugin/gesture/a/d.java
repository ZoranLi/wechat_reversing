package com.tencent.mm.plugin.gesture.a;

import android.app.Activity;
import android.os.SystemClock;
import com.tencent.mm.a.o;
import com.tencent.mm.e.a.gq;
import com.tencent.mm.e.a.qz;
import com.tencent.mm.i.g;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.mm.plugin.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.protocal.c.apc;
import com.tencent.mm.protocal.c.apd;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class d implements am {
    public HashSet<WeakReference<Activity>> mHS;
    private boolean mHT;
    private boolean mHU;
    private Object mHV;
    private c mHW;
    private c mHX;

    public d() {
        this.mHS = null;
        this.mHT = false;
        this.mHU = false;
        this.mHV = new Object();
        this.mHW = new c<gq>(this) {
            final /* synthetic */ d mHY;

            {
                this.mHY = r2;
                this.usg = gq.class.getName().hashCode();
            }

            private boolean a(gq gqVar) {
                long aCx;
                long elapsedRealtime;
                switch (gqVar.fLW.fLY) {
                    case 0:
                        if (!(gqVar.fLW.activity instanceof GestureGuardLogicUI)) {
                            if (!this.mHY.aCI()) {
                                aCx = b.aCx();
                                elapsedRealtime = (SystemClock.elapsedRealtime() - aCx) / 1000;
                                if ((aCx != -1 && elapsedRealtime < ((long) a.mHO) && !d.aCH()) || !this.mHY.aCG()) {
                                    w.d("MicroMsg.SubCoreGestureGuard", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
                                    gqVar.fLX.data = Integer.valueOf(16);
                                    this.mHY.mHS.add(new WeakReference(gqVar.fLW.activity));
                                    break;
                                }
                                w.d("MicroMsg.SubCoreGestureGuard", "REQUEST_PROTECT_ME_ONCREATE indicates needs verify.");
                                gqVar.fLX.data = Integer.valueOf(17);
                                break;
                            }
                            w.d("MicroMsg.SubCoreGestureGuard", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
                            gqVar.fLX.data = Integer.valueOf(16);
                            this.mHY.mHS.add(new WeakReference(gqVar.fLW.activity));
                            this.mHY.eK(false);
                            break;
                        }
                        w.d("MicroMsg.SubCoreGestureGuard", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
                        gqVar.fLX.data = Integer.valueOf(16);
                        break;
                        break;
                    case 1:
                        if (!(gqVar.fLW.activity instanceof GestureGuardLogicUI)) {
                            if (!this.mHY.aCI()) {
                                if (!this.mHY.aCJ()) {
                                    aCx = b.aCx();
                                    elapsedRealtime = (SystemClock.elapsedRealtime() - aCx) / 1000;
                                    if ((aCx == -1 || elapsedRealtime >= ((long) a.mHO) || d.aCH()) && this.mHY.aCG()) {
                                        w.d("MicroMsg.SubCoreGestureGuard", "REQUEST_PROTECT_ME_ONRESUME indicates needs verify.");
                                        gqVar.fLX.data = Integer.valueOf(17);
                                    } else {
                                        w.d("MicroMsg.SubCoreGestureGuard", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                                        gqVar.fLX.data = Integer.valueOf(16);
                                    }
                                    this.mHY.mHS.add(new WeakReference(gqVar.fLW.activity));
                                    break;
                                }
                                w.d("MicroMsg.SubCoreGestureGuard", "REQUEST_PROTECT_ME_ONRESUME indicates reenter.");
                                this.mHY.eK(false);
                                this.mHY.eL(false);
                                gqVar.fLX.data = Integer.valueOf(18);
                                break;
                            }
                            w.d("MicroMsg.SubCoreGestureGuard", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                            this.mHY.eK(false);
                            this.mHY.eL(false);
                            gqVar.fLX.data = Integer.valueOf(16);
                            break;
                        }
                        w.d("MicroMsg.SubCoreGestureGuard", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                        gqVar.fLX.data = Integer.valueOf(16);
                        break;
                    case 2:
                        gqVar.fLX.data = Boolean.valueOf(this.mHY.aCG());
                        break;
                    case 3:
                        gqVar.fLX.data = Boolean.valueOf(d.aCH());
                        break;
                    case 4:
                        this.mHY.aCK();
                        break;
                }
                gqVar.fLW.activity = null;
                return false;
            }
        };
        this.mHX = new c<qz>(this) {
            final /* synthetic */ d mHY;

            {
                this.mHY = r2;
                this.usg = qz.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                apd com_tencent_mm_protocal_c_apd = ((qz) bVar).fXY.fXZ;
                b.aCy();
                if (d.b(com_tencent_mm_protocal_c_apd)) {
                    w.i("MicroMsg.SubCoreGestureGuard", "tom update PatternLockInfo, sign_len:%d,valid:%b,status:%d,ver:%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_apd.tUg.tZn), Boolean.valueOf(d.b(com_tencent_mm_protocal_c_apd)), Integer.valueOf(com_tencent_mm_protocal_c_apd.tUh), Integer.valueOf(com_tencent_mm_protocal_c_apd.tUf)});
                    b.a(com_tencent_mm_protocal_c_apd);
                } else {
                    w.w("MicroMsg.SubCoreGestureGuard", "UserInfoExt.PatternLockInfo is null or invalid.");
                }
                return false;
            }
        };
        this.mHS = new HashSet();
    }

    public static d aCF() {
        w.d("MicroMsg.SubCoreGestureGuard", "GestureGuard getCore");
        d dVar = (d) ap.yR().gs("plugin.gesture");
        if (dVar != null) {
            return dVar;
        }
        Object dVar2 = new d();
        ap.yR().a("plugin.gesture", dVar2);
        return dVar2;
    }

    public final void aM(boolean z) {
        w.d("MicroMsg.SubCoreGestureGuard", "GestureGuard onAccountPostReset.");
        if (!a.urY.d(this.mHW)) {
            a.urY.b(this.mHW);
        }
        if (!a.urY.d(this.mHX)) {
            a.urY.b(this.mHX);
        }
        String str = null;
        try {
            str = g.sV().getValue("PatternLockTimeInterval");
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SubCoreGestureGuard", e, "", new Object[0]);
        }
        if (bg.mA(str)) {
            w.d("MicroMsg.SubCoreGestureGuard", "PatternLockInterval keeps default value.");
            a.mHO = e.CTRL_INDEX;
            return;
        }
        int i = bg.getInt(str, 0);
        if (i >= 0) {
            w.d("MicroMsg.SubCoreGestureGuard", String.format("Dynamic config for PatternLockInterval override default config, newval=%d", new Object[]{Integer.valueOf(i)}));
            a.mHO = i;
            return;
        }
        w.d("MicroMsg.SubCoreGestureGuard", "PatternLockInterval keeps default value.");
        a.mHO = e.CTRL_INDEX;
    }

    public final void onAccountRelease() {
        w.d("MicroMsg.SubCoreGestureGuard", "GestureGuard onAccountRelease");
        if (a.urY.d(this.mHW)) {
            a.urY.c(this.mHW);
        }
        if (a.urY.d(this.mHX)) {
            a.urY.c(this.mHX);
        }
        this.mHS.clear();
    }

    private static byte[] at(byte[] bArr) {
        String str = "0123456789abcdef";
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < bArr.length - 1; i += 2) {
            byteArrayOutputStream.write((str.indexOf(Character.toLowerCase(bArr[i])) << 4) | str.indexOf(Character.toLowerCase(bArr[i + 1])));
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static void a(e eVar) {
        if (eVar.mHZ != -1) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime < eVar.mHZ) {
                eVar.mHZ = elapsedRealtime;
                eVar.mIa += elapsedRealtime;
                w.d("MicroMsg.SubCoreGestureGuard", String.format("Rebooted, need to add additional %d ms, now elapsed %d ms", new Object[]{Long.valueOf(elapsedRealtime), Long.valueOf(eVar.mIa)}));
                return;
            }
            eVar.mIa = (elapsedRealtime - eVar.mHZ) + eVar.mIa;
            eVar.mHZ = elapsedRealtime;
        }
    }

    public static boolean b(apc com_tencent_mm_protocal_c_apc) {
        if (com_tencent_mm_protocal_c_apc == null || com_tencent_mm_protocal_c_apc.tUe == null || com_tencent_mm_protocal_c_apc.tUe.tZp == null) {
            return false;
        }
        byte[] bArr = com_tencent_mm_protocal_c_apc.tUe.tZp.sYA;
        if (bArr.length == 0 || (bArr.length & 1) != 0) {
            return false;
        }
        long longValue = new o(com_tencent_mm_protocal_c_apc.uin).longValue();
        bArr = at(bArr);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(com_tencent_mm_protocal_c_apc.version);
        if (com_tencent_mm_protocal_c_apc.tUc.tZq) {
            stringBuilder.append(new String(com_tencent_mm_protocal_c_apc.tUc.tZp.sYA));
        }
        stringBuilder.append(longValue);
        w.d("MicroMsg.SubCoreGestureGuard", String.format("verifyPatternBuffer, ret:%d", new Object[]{Integer.valueOf(UtilsJni.doEcdsaVerify(a.mHP, stringBuilder.toString().getBytes(), bArr))}));
        if (UtilsJni.doEcdsaVerify(a.mHP, stringBuilder.toString().getBytes(), bArr) != 1) {
            return false;
        }
        return true;
    }

    public static boolean b(apd com_tencent_mm_protocal_c_apd) {
        if (com_tencent_mm_protocal_c_apd == null || com_tencent_mm_protocal_c_apd.tUg == null || com_tencent_mm_protocal_c_apd.tUg.tZp == null) {
            return false;
        }
        byte[] bArr = com_tencent_mm_protocal_c_apd.tUg.tZp.sYA;
        if (bArr.length == 0 || (bArr.length & 1) != 0) {
            return false;
        }
        boolean z;
        bArr = at(bArr);
        ap.yY();
        long longValue = new o(com.tencent.mm.u.c.uH()).longValue();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(com_tencent_mm_protocal_c_apd.tUf);
        stringBuilder.append(longValue);
        int doEcdsaVerify = UtilsJni.doEcdsaVerify(a.mHP, stringBuilder.toString().getBytes(), bArr);
        if ((doEcdsaVerify == 1 || com_tencent_mm_protocal_c_apd.tUh != 1) && !(doEcdsaVerify == 1 && com_tencent_mm_protocal_c_apd.tUh == 0)) {
            z = false;
        } else {
            z = true;
        }
        w.d("MicroMsg.SubCoreGestureGuard", String.format("verifyPatternInfo, verifyRes:%d ret:%b", new Object[]{Integer.valueOf(doEcdsaVerify), Boolean.valueOf(z)}));
        return z;
    }

    public final boolean aCG() {
        int i = -1;
        if (!ap.zb() || ap.uP()) {
            w.w("MicroMsg.SubCoreGestureGuard", "not login !!");
            return false;
        }
        boolean z;
        boolean b;
        apd aCC = b.aCC();
        apc aCB = b.aCB();
        if (aCC == null) {
            int i2 = 1;
        } else {
            z = false;
        }
        if (aCB == null) {
            int i3 = 1;
        } else {
            boolean z2 = false;
        }
        if (i2 == 0) {
            z = b(aCC);
        } else {
            z = false;
        }
        String str = "MicroMsg.SubCoreGestureGuard";
        String str2 = "tom isUserSetGesturePwd serverInfo:%s status:%d  svrinfoValid:%s";
        Object[] objArr = new Object[3];
        objArr[0] = aCC;
        objArr[1] = Integer.valueOf(aCC == null ? -1 : aCC.tUh);
        objArr[2] = Boolean.valueOf(z);
        w.i(str, str2, objArr);
        if (i3 == 0) {
            b = b(aCB);
        } else {
            b = false;
        }
        String str3 = "MicroMsg.SubCoreGestureGuard";
        str = "tom isUserSetGesturePwd localBuff:%s status:%d  localBuffValid:%s";
        Object[] objArr2 = new Object[3];
        objArr2[0] = aCB;
        if (aCB != null) {
            i = aCB.tUd;
        }
        objArr2[1] = Integer.valueOf(i);
        objArr2[2] = Boolean.valueOf(b);
        w.i(str3, str, objArr2);
        if (z) {
            if (b) {
                try {
                    w.i("MicroMsg.SubCoreGestureGuard", "Both info & buff are valid, choose one to trust.");
                    if (aCC.tUf > aCB.version) {
                        w.i("MicroMsg.SubCoreGestureGuard", "srvInfoVer:%d, localBuffVer:%d, srvInfo wins.", new Object[]{Integer.valueOf(aCC.tUf), Integer.valueOf(aCB.version)});
                        if (aCC.tUh == 1) {
                            return true;
                        }
                        return false;
                    } else if (aCC.tUf == aCB.version) {
                        w.i("MicroMsg.SubCoreGestureGuard", "srvInfoVer:%d, localBuffVer:%d, draw.", new Object[]{Integer.valueOf(aCC.tUf), Integer.valueOf(aCB.version)});
                        if (aCC.tUh == 1) {
                            return true;
                        }
                        return false;
                    } else {
                        w.i("MicroMsg.SubCoreGestureGuard", "srvInfoVer:%d, localBuffVer:%d, localBuff wins.", new Object[]{Integer.valueOf(aCC.tUf), Integer.valueOf(aCB.version)});
                        if (aCB.tUd == 1) {
                            return true;
                        }
                        return false;
                    }
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.SubCoreGestureGuard", e, "isUserSetGesturePwd throw an exception.", new Object[0]);
                    return false;
                }
            }
            w.i("MicroMsg.SubCoreGestureGuard", "Info is valid but buf is invalid, we trust info this time.");
            if (aCC.tUh == 1) {
                return true;
            }
            return false;
        } else if (b) {
            w.i("MicroMsg.SubCoreGestureGuard", "Info is invalid but buff is valid, we trust buff this time.");
            if (aCB.tUd == 1) {
                return true;
            }
            return false;
        } else {
            w.w("MicroMsg.SubCoreGestureGuard", "Both buff & info are invalid, do not activate this time and wait for next sync.");
            return false;
        }
    }

    public static boolean aCH() {
        e aCv = b.aCv();
        if (aCv.mHZ == -1) {
            return false;
        }
        a(aCv);
        if (aCv.mIa / 1000 < 600) {
            b.j(aCv.mHZ, aCv.mIa);
            return true;
        }
        b.aCw();
        return false;
    }

    public final void eK(boolean z) {
        synchronized (this.mHV) {
            this.mHT = z;
        }
    }

    public final boolean aCI() {
        boolean z;
        synchronized (this.mHV) {
            z = this.mHT;
        }
        return z;
    }

    public final void eL(boolean z) {
        synchronized (this.mHV) {
            this.mHU = z;
        }
    }

    public final boolean aCJ() {
        boolean z;
        synchronized (this.mHV) {
            z = this.mHU;
        }
        return z;
    }

    public final void aCK() {
        synchronized (this.mHV) {
            this.mHU = true;
        }
    }

    public static byte[] aG(List<c> list) {
        if (list == null) {
            throw new IllegalArgumentException("pattern is null");
        }
        int size = list.size();
        byte[] bArr = new byte[size];
        for (int i = 0; i < size; i++) {
            c cVar = (c) list.get(i);
            bArr[i] = (byte) ((cVar.kTJ + (cVar.kTI * 3)) + 1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < size; i2++) {
            stringBuilder.append(bArr[i2]);
        }
        String stringBuilder2 = stringBuilder.toString();
        return com.tencent.mm.a.g.n((com.tencent.mm.a.g.n((com.tencent.mm.a.g.n(stringBuilder2.getBytes()) + m.xL()).getBytes()) + stringBuilder2).getBytes()).getBytes();
    }

    public final HashMap<Integer, com.tencent.mm.bj.g.c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aN(boolean z) {
    }
}
