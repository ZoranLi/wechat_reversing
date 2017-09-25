package com.tencent.mm.modelvoice;

import android.database.Cursor;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.e.a.ih;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.plugin.appbrand.jsapi.f.e;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.ay.b;
import com.tencent.mm.u.m;
import com.tencent.mm.y.d;
import com.tencent.mm.y.h;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import junit.framework.Assert;

public final class q {
    private static HashMap<String, WeakReference<h>> ico = new HashMap();

    public static boolean lU(String str) {
        if (str == null) {
            return false;
        }
        p mg = m.Ly().mg(str);
        if (mg == null || mg.iar >= 250) {
            return false;
        }
        mg.iar++;
        mg.fRW = 8192;
        return a(mg);
    }

    public static int gP(int i) {
        return ((i - 6) / 32) * 20;
    }

    public static b an(String str, String str2) {
        u Ly = m.Ly();
        String js = js(str2);
        switch (bg.getInt(str, -1)) {
            case 1:
                if (Ly.icy.get(js) == null) {
                    Ly.icy.put(js, new l(js));
                }
                return (b) Ly.icy.get(js);
            case 4:
                if (Ly.icz.get(js) == null) {
                    Ly.icz.put(js, new h(js));
                }
                return (b) Ly.icz.get(js);
            default:
                if (Ly.icx.get(js) == null) {
                    Ly.icx.put(js, new a(js));
                }
                return (b) Ly.icx.get(js);
        }
    }

    public static b lV(String str) {
        u Ly = m.Ly();
        String js = js(str);
        switch (o.lS(str)) {
            case 0:
                if (Ly.icx.get(js) == null) {
                    Ly.icx.put(js, new a(js));
                }
                return (b) Ly.icx.get(js);
            case 1:
                if (Ly.icy.get(js) == null) {
                    Ly.icy.put(js, new l(js));
                }
                return (b) Ly.icy.get(js);
            case 2:
                if (Ly.icz.get(js) == null) {
                    Ly.icz.put(js, new h(js));
                }
                return (b) Ly.icz.get(js);
            default:
                if (Ly.icx.get(js) == null) {
                    Ly.icx.put(js, new a(js));
                }
                return (b) Ly.icx.get(js);
        }
    }

    public static void lW(String str) {
        u Ly = m.Ly();
        String js = js(str);
        a aVar;
        switch (o.lS(str)) {
            case 0:
                aVar = (a) Ly.icx.get(js);
                if (aVar != null) {
                    aVar.Lu();
                    Ly.icx.remove(js);
                    return;
                }
                return;
            case 1:
                l lVar = (l) Ly.icy.get(js);
                if (lVar != null) {
                    lVar.Lu();
                    Ly.icy.remove(js);
                    return;
                }
                return;
            case 2:
                h hVar = (h) Ly.icz.get(js);
                if (hVar != null) {
                    hVar.Lu();
                    Ly.icz.remove(js);
                    return;
                }
                return;
            default:
                aVar = (a) Ly.icx.get(js);
                if (aVar != null) {
                    aVar.Lu();
                    Ly.icx.remove(js);
                    return;
                }
                return;
        }
    }

    public static String js(String str) {
        if (bg.mA(str)) {
            return null;
        }
        return E(str, false);
    }

    public static String E(String str, boolean z) {
        a aVar = new a();
        String a = com.tencent.mm.sdk.platformtools.h.a(xf(), "msg_", str, ".amr", 2);
        w.i("MicroMsg.VoiceLogic", "getAmrFullPath cost: " + aVar.se());
        if (bg.mA(a)) {
            return null;
        }
        if (z || new File(a).exists()) {
            return a;
        }
        String str2 = xe() + str;
        if (new File(str2 + ".amr").exists()) {
            j.p(str2 + ".amr", a, true);
            return a;
        } else if (!new File(str2).exists()) {
            return a;
        } else {
            j.p(str2, a, true);
            return a;
        }
    }

    public static String lX(String str) {
        String mf = u.mf(m.xL());
        p pVar = new p();
        pVar.fyF = mf;
        pVar.fSf = str;
        pVar.iam = System.currentTimeMillis() / 1000;
        pVar.clientId = mf;
        pVar.ian = System.currentTimeMillis() / 1000;
        pVar.status = 1;
        pVar.iah = m.xL();
        pVar.fRW = -1;
        if (!m.Ly().b(pVar)) {
            return null;
        }
        w.i("MicroMsg.VoiceLogic", "startRecord insert voicestg success");
        return mf;
    }

    public static boolean a(String str, h hVar) {
        if (str == null) {
            return false;
        }
        p mg = m.Ly().mg(str);
        if (mg == null) {
            w.d("MicroMsg.VoiceLogic", "startSend null record : " + str);
            return false;
        } else if (mg.status != 1) {
            return false;
        } else {
            mg.status = 2;
            mg.fRW = 64;
            ico.put(str, new WeakReference(hVar));
            return a(mg);
        }
    }

    public static boolean lY(String str) {
        if (str == null) {
            return false;
        }
        w.d("MicroMsg.VoiceLogic", "Mark Canceled fileName[" + str + "]");
        p mg = m.Ly().mg(str);
        if (mg == null) {
            return false;
        }
        mg.status = 8;
        mg.hrs = o.lx(str);
        mg.fRW = 64;
        return a(mg);
    }

    public static boolean lZ(String str) {
        if (str == null) {
            return false;
        }
        p mg = m.Ly().mg(str);
        if (mg == null) {
            w.d("MicroMsg.VoiceLogic", "cancel null download : " + str);
            return true;
        }
        w.d("MicroMsg.VoiceLogic", "cancel download : " + str + " SvrlId:" + mg.fTQ);
        if (mg.fTQ != 0) {
            ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().E(mg.fSf, mg.fTQ);
        }
        return mb(str);
    }

    public static boolean ma(String str) {
        if (str == null) {
            return false;
        }
        p mg = m.Ly().mg(str);
        if (mg == null) {
            w.i("MicroMsg.VoiceLogic", "cancel null record : " + str);
            return true;
        }
        w.i("MicroMsg.VoiceLogic", "cancel record : " + str + " LocalId:" + mg.iaq);
        if (mg.iaq != 0) {
            ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().cB((long) mg.iaq);
        }
        return mb(str);
    }

    public static boolean mb(String str) {
        if (bg.mA(str)) {
            return false;
        }
        m.Ly().gR(str);
        lW(str);
        return new File(js(str)).delete();
    }

    public static boolean K(String str, int i) {
        return j(str, i, 0);
    }

    private static boolean j(String str, int i, int i2) {
        if (str == null) {
            return false;
        }
        w.d("MicroMsg.VoiceLogic", "StopRecord fileName[" + str + "], fullPath[" + js(str) + "]");
        p mg = m.Ly().mg(str);
        if (mg == null) {
            return false;
        }
        if (!(mg.status == 97 || mg.status == 98)) {
            mg.status = 3;
        }
        mg.hrs = o.lx(str);
        if (mg.hrs <= 0) {
            lA(str);
            return false;
        }
        mg.ian = System.currentTimeMillis() / 1000;
        mg.icm = i;
        mg.fRW = 3424;
        au auVar = new au();
        auVar.cH(mg.fSf);
        auVar.setType(34);
        auVar.dw(1);
        auVar.cI(str);
        if (mg.status == 97) {
            auVar.dv(2);
            auVar.setContent(n.b(mg.iah, (long) mg.icm, false));
        } else if (mg.status == 98) {
            auVar.dv(5);
            auVar.setContent(n.b(mg.iah, -1, true));
        } else {
            auVar.dv(1);
            auVar.setContent(n.b(mg.iah, (long) mg.icm, false));
        }
        auVar.z(ay.gk(mg.fSf));
        auVar.yF(i2);
        com.tencent.mm.h.a.a.qB().b(auVar);
        mg.iaq = (int) ay.i(auVar);
        boolean a = a(mg);
        ico.remove(str);
        return a;
    }

    public static int a(String str, int i, long j, String str2, int i2, int i3) {
        if (str == null) {
            return -1;
        }
        w.d("MicroMsg.VoiceLogic", "dkmsgid UpdateAfterSend file:[" + str + "] newOff:" + i + " SvrID:" + j + " clientID:" + str2 + " hasSendEndFlag " + i2);
        p mg = m.Ly().mg(str);
        if (mg == null) {
            return -1;
        }
        mg.hYV = i;
        mg.ian = System.currentTimeMillis() / 1000;
        mg.fRW = 264;
        if (bg.mA(mg.clientId) && str2 != null) {
            mg.clientId = str2;
            mg.fRW |= 512;
        }
        if (mg.fTQ == 0 && j != 0) {
            mg.fTQ = j;
            mg.fRW |= 4;
        }
        int i4 = 0;
        if (mg.hrs <= i && mg.status == 3 && i2 == 1) {
            mg.status = 99;
            mg.fRW |= 64;
            au cA = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().cA((long) mg.iaq);
            cA.cH(mg.fSf);
            cA.y(mg.fTQ);
            cA.dv(2);
            cA.setContent(n.b(mg.iah, (long) mg.icm, false));
            cA.yF(i3);
            ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().a((long) mg.iaq, cA);
            w.d("MicroMsg.VoiceLogic", "END!!! updateSend  file:" + str + " total:" + mg.hrs + " status:" + mg.status + " netTimes:" + mg.iar + " msgId:" + cA.field_msgId);
            i4 = 1;
            lW(str);
        }
        if (a(mg)) {
            return i4;
        }
        return -4;
    }

    public static int a(p pVar, byte[] bArr, int i, String str, String str2, d.a aVar) {
        a aVar2 = new a();
        p ax = m.Ly().ax(pVar.fTQ);
        if (ax != null && ax.status == 99) {
            return 0;
        }
        if (((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().x(pVar.fSf, pVar.fTQ).field_msgSvrId == pVar.fTQ && ax == null) {
            return 0;
        }
        if (ax != null) {
            pVar.fyF = ax.fyF;
        } else {
            pVar.fyF = u.mf(pVar.iah);
        }
        pVar.fRW |= 1;
        w.d("MicroMsg.VoiceLogic", g.sd() + "checktime :" + aVar2.se());
        boolean z = false;
        if (bArr != null && bArr.length > 1) {
            boolean z2;
            if (ax != null) {
                w.e("MicroMsg.VoiceLogic", "Sync Voice Buf , But  VoiceInfo is not new !");
            }
            String str3 = pVar.ibe;
            String str4 = pVar.fyF;
            int write = an(str3, str4).write(bArr, bArr.length, 0);
            if (write < 0) {
                w.e("MicroMsg.VoiceLogic", "Write Failed File:" + str4 + " newOffset:" + write + " voiceFormat:" + str3);
                z2 = false;
            } else if (bArr.length != write) {
                w.e("MicroMsg.VoiceLogic", "Write File:" + str4 + " fileOff:" + write + " bufLen:" + bArr.length + " voiceFormat:" + str3);
                z2 = false;
            } else {
                w.i("MicroMsg.VoiceLogic", "writeVoiceFile file:[" + str4 + "] + buf:" + bArr.length + " voiceFormat:" + str3);
                lW(str4);
                z2 = true;
            }
            z = z2;
        }
        w.d("MicroMsg.VoiceLogic", g.sd() + "checktime :" + aVar2.se());
        pVar.ian = System.currentTimeMillis() / 1000;
        pVar.fRW |= 256;
        if (z) {
            pVar.status = 99;
        } else if (pVar.hrs == 0) {
            pVar.status = 5;
        } else {
            pVar.status = 6;
        }
        pVar.fRW |= 64;
        if (ax == null) {
            if (z) {
                pVar.iaq = (int) a(pVar, z, i, str, str2, aVar);
            }
            if (aVar != null) {
                pVar.gxE = ay.c(aVar);
                if (aVar.hst != null) {
                    pVar.hJR = aVar.hst.tfl;
                }
            }
            w.d("MicroMsg.VoiceLogic", g.sd() + "checktime :" + aVar2.se());
            pVar.fRW = -1;
            w.d("MicroMsg.VoiceLogic", "Insert fileName:" + pVar.fyF + " stat:" + pVar.status + " net:" + pVar.hYV + " total:" + pVar.hrs);
            if (m.Ly().b(pVar)) {
                w.d("MicroMsg.VoiceLogic", g.sd() + "checktime :" + aVar2.se());
                if (z) {
                    return 1;
                }
            }
            w.d("MicroMsg.VoiceLogic", "Insert Error fileName:" + pVar.fyF + " stat:" + pVar.status + " net:" + pVar.hYV + " total:" + pVar.hrs);
            return -2;
        }
        w.d("MicroMsg.VoiceLogic", "Sync Update file:" + pVar.fyF + " stat:" + pVar.status);
        if (!a(pVar)) {
            return -44;
        }
        if (z) {
            a(pVar, aVar);
            return 1;
        }
        if (ax != null && ax.iaj == pVar.hrs) {
            a(ax.fyF, ax.iaj, aVar);
            w.w("MicroMsg.VoiceLogic", "Sync TotalLen not Change (send endflag but TotoalLen == FileLen) :" + ax.fyF);
        }
        w.i("MicroMsg.VoiceLogic", "summerbadcr setRecvSync end ret 0 and start run addMsgInfo[%s], syncWithBufSucc[%b], stack[%s]", aVar, Boolean.valueOf(z), bg.bJZ());
        m.LA().run();
        return 0;
    }

    private static boolean a(p pVar, d.a aVar) {
        try {
            pVar.iaq = (int) a(pVar, true, 3, "", pVar.gxF, aVar);
            pVar.fRW |= 2048;
            return a(pVar);
        } catch (Throwable e) {
            w.e("MicroMsg.VoiceLogic", "exception:%s", bg.g(e));
            return false;
        }
    }

    private static long a(p pVar, boolean z, int i, String str, String str2, d.a aVar) {
        if (((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().cC(pVar.fTQ)) {
            w.i("MicroMsg.VoiceLogic", "[oneliang] msg svrid:%s,it is in delete msg list,may be revoke msg come first,msg info insert last,so no need to add msg info and delete voice info", Long.valueOf(pVar.fTQ));
            if (bg.mz(pVar.fyF).length() > 0) {
                m.Ly().gR(pVar.fyF);
            } else {
                w.i("MicroMsg.VoiceLogic", "[oneliang] the length of voice info file name is zero");
            }
            return -1;
        }
        au auVar = new au();
        auVar.y(pVar.fTQ);
        auVar.cI(pVar.fyF);
        auVar.z(ay.i(pVar.fSf, pVar.iam));
        auVar.cH(pVar.fSf);
        auVar.dw(m.eH(pVar.iah) ? 1 : 0);
        auVar.setType(34);
        auVar.cM(str);
        auVar.yF(pVar.ibl);
        auVar.dv(i);
        if (aVar == null) {
            int i2 = pVar.gxE;
            if (i2 != 0) {
                w.i("MicroMsg.VoiceLogic", "summerbadcr createMsgInfo flag has set[%d]", Integer.valueOf(i2));
                auVar.dF(i2);
                if (auVar.field_msgId == 0 && auVar.field_isSend == 0 && (i2 & 2) != 0) {
                    auVar.z(ay.a(auVar.field_talker, pVar.iam, true, auVar.field_msgSeq));
                }
            }
            if (pVar.hJR != 0) {
                auVar.B((long) pVar.hJR);
            }
            w.i("MicroMsg.VoiceLogic", "summerbadcr insert voice addMsgInfo is null but flag[%d], msgSeq[%d]", Integer.valueOf(i2), Integer.valueOf(pVar.hJR));
        } else {
            ay.a(auVar, aVar);
        }
        w.i("MicroMsg.VoiceLogic", "summerbadcr create voice msg info, msgSource : %s", str2);
        if (!bg.mA(str2)) {
            auVar.cN(str2);
            auVar.cO(ay.gn(str2));
        }
        if (z) {
            auVar.setContent(n.b(pVar.iah, (long) pVar.icm, false));
        } else {
            auVar.setContent(n.b(pVar.iah, 0, false));
        }
        if (!bg.mA(str2)) {
            auVar.cN(str2);
            auVar.cO(ay.gn(str2));
            b gm = ay.gm(str2);
            if (gm != null) {
                auVar.cO(gm.hmQ);
                auVar.cL(gm.hmP);
                w.i("MicroMsg.VoiceLogic", "bizClientMsgId = %s", gm.hmP);
                if (gm.hmR != null) {
                    com.tencent.mm.sdk.b.b ihVar = new ih();
                    ihVar.fNR.fCZ = auVar;
                    ihVar.fNR.fNS = gm;
                    com.tencent.mm.sdk.b.a.urY.m(ihVar);
                }
            }
        }
        w.i("MicroMsg.VoiceLogic", "summerbadcr parseVoiceMsg svrId[%d], msgseq[%d]", Long.valueOf(auVar.field_msgSvrId), Long.valueOf(auVar.field_msgSeq));
        return ay.i(auVar);
    }

    public static int a(String str, int i, d.a aVar) {
        if (str == null) {
            return -1;
        }
        p mg = m.Ly().mg(str);
        if (mg == null) {
            return -1;
        }
        mg.iaj = i;
        mg.ian = System.currentTimeMillis() / 1000;
        mg.fRW = e.CTRL_INDEX;
        int i2 = 0;
        if (mg.hrs > 0 && i >= mg.hrs) {
            a(mg, aVar);
            mg.status = 99;
            mg.fRW |= 64;
            w.d("MicroMsg.VoiceLogic", "END!!! updateRecv  file:" + str + " newsize:" + i + " total:" + mg.hrs + " status:" + mg.status + " netTimes:" + mg.iar);
            i2 = 1;
            lW(str);
        }
        w.d("MicroMsg.VoiceLogic", "updateRecv file:" + str + " newsize:" + i + " total:" + mg.hrs + " status:" + mg.status);
        if (a(mg)) {
            return i2;
        }
        return -3;
    }

    public static boolean lB(String str) {
        p mg = m.Ly().mg(str);
        if (mg == null) {
            return false;
        }
        if (mg.status == 3) {
            au cA = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().cA((long) mg.iaq);
            cA.setContent(n.b(mg.iah, (long) mg.icm, false));
            cA.dv(2);
            ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().a((long) mg.iaq, cA);
        }
        mg.status = 97;
        mg.ian = System.currentTimeMillis() / 1000;
        mg.fRW = 320;
        return a(mg);
    }

    public static boolean gQ(int i) {
        au cA = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().cA((long) i);
        if (cA.field_msgId == 0 || cA.field_imgPath == null) {
            return false;
        }
        if (bg.mA(cA.field_imgPath)) {
            return false;
        }
        p mg = m.Ly().mg(cA.field_imgPath);
        if (mg == null || bg.mA(mg.fyF)) {
            return false;
        }
        mg.status = 3;
        mg.hYV = 0;
        mg.iam = System.currentTimeMillis() / 1000;
        mg.ian = System.currentTimeMillis() / 1000;
        mg.fRW = 8648;
        boolean a = a(mg);
        w.d("MicroMsg.VoiceLogic", " file:" + mg.fyF + " msgid:" + mg.iaq + "  stat:" + mg.status);
        if (mg.iaq == 0 || bg.mA(mg.fSf)) {
            w.e("MicroMsg.VoiceLogic", " failed msg id:" + mg.iaq + " user:" + mg.fSf);
            return a;
        }
        cA.dv(1);
        ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().a(cA.field_msgId, cA);
        m.LA().run();
        return true;
    }

    public static String c(String str, String str2, int i) {
        if (bg.mA(str)) {
            return null;
        }
        if (!(bg.mA(str2) || str2.startsWith("amr_") || str2.startsWith("spx_"))) {
            str2.startsWith("silk_");
        }
        String lX = lX(str);
        if (bg.mA(lX) || !j.p(js(str2), js(lX), false)) {
            return null;
        }
        j(lX, i, 1);
        return lX;
    }

    public static boolean lA(String str) {
        com.tencent.mm.plugin.report.service.g.oUh.a(111, 234, 1, false);
        if (str == null) {
            return false;
        }
        p mg = m.Ly().mg(str);
        if (mg == null) {
            w.e("MicroMsg.VoiceLogic", "Set error failed file:" + str);
            return false;
        }
        mg.status = 98;
        mg.ian = System.currentTimeMillis() / 1000;
        mg.fRW = 320;
        boolean a = a(mg);
        w.d("MicroMsg.VoiceLogic", "setError file:" + str + " msgid:" + mg.iaq + " old stat:" + mg.status);
        if (mg.iaq == 0 || bg.mA(mg.fSf)) {
            w.e("MicroMsg.VoiceLogic", "setError failed msg id:" + mg.iaq + " user:" + mg.fSf);
            return a;
        }
        au cA = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().cA((long) mg.iaq);
        c.oTb.a(111, 33, 1, true);
        cA.x((long) mg.iaq);
        cA.dv(5);
        cA.cH(mg.fSf);
        cA.setContent(n.b(mg.iah, -1, true));
        ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().a(cA.field_msgId, cA);
        return a;
    }

    public static au mc(String str) {
        if (str == null) {
            return null;
        }
        p mg = m.Ly().mg(str);
        if (mg != null) {
            return ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().cA((long) mg.iaq);
        }
        return null;
    }

    public static p md(String str) {
        return m.Ly().mg(str);
    }

    public static List<p> LD() {
        int i;
        List<p> list;
        u Ly = m.Ly();
        Cursor a = Ly.hnH.a(("SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId" + " FROM voiceinfo") + " WHERE Status<97 and User!=\"_USER_FOR_THROWBOTTLE_\"   order by CreateTime", null, 2);
        int i2 = 0;
        if (a.moveToFirst()) {
            List<p> arrayList = new ArrayList();
            do {
                p pVar = new p();
                pVar.b(a);
                arrayList.add(pVar);
                i2++;
            } while (a.moveToNext());
            List<p> list2 = arrayList;
            i = i2;
            list = list2;
        } else {
            i = 0;
            list = null;
        }
        w.d("MicroMsg.VoiceStorage", "getUnfinishInfo resCount:" + i);
        a.close();
        return list;
    }

    private static boolean a(p pVar) {
        if (pVar == null || pVar.fRW == -1) {
            return false;
        }
        return m.Ly().a(pVar.fyF, pVar);
    }

    public static float B(au auVar) {
        boolean z = auVar != null && auVar.bLZ();
        Assert.assertTrue(z);
        float f = ((float) new n(auVar.field_content).time) / 1000.0f;
        if (f < 1.0f) {
            f = 1.0f;
        }
        return ((float) Math.round(f * 10.0f)) / 10.0f;
    }

    public static float aw(long j) {
        float f = 60.0f;
        float f2 = 1.0f;
        float f3 = ((float) j) / 1000.0f;
        if (f3 >= 1.0f) {
            f2 = f3;
        }
        if (f2 <= 60.0f) {
            f = f2;
        }
        return (float) Math.round(f);
    }

    public static boolean C(au auVar) {
        if (auVar == null || !auVar.bLZ()) {
            return false;
        }
        return new n(auVar.field_content).iai;
    }

    public static boolean D(au auVar) {
        if (auVar == null || !auVar.bLZ() || auVar.field_isSend == 1) {
            return false;
        }
        if (new n(auVar.field_content).time != 0) {
            return false;
        }
        return true;
    }

    public static void E(au auVar) {
        if (auVar != null && auVar.bLZ()) {
            ce cA = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().cA(auVar.field_msgId);
            if (cA.field_msgId == auVar.field_msgId) {
                n nVar = new n(cA.field_content);
                if (!nVar.iai) {
                    nVar.iai = true;
                    auVar.setContent(nVar.iah + ":" + nVar.time + ":" + (nVar.iai ? 1 : 0) + "\n");
                    ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().a(auVar.field_msgId, auVar);
                }
            }
        }
    }

    public static int me(String str) {
        if (ico.get(str) != null) {
            h hVar = (h) ((WeakReference) ico.get(str)).get();
            if (hVar != null) {
                return (int) hVar.pn();
            }
        }
        return -1;
    }

    public static String xe() {
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.h.vJ();
        return stringBuilder.append(com.tencent.mm.kernel.h.vI().gYf).append("voice/").toString();
    }

    public static String xf() {
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.h.vJ();
        return stringBuilder.append(com.tencent.mm.kernel.h.vI().gYf).append("voice2/").toString();
    }
}
