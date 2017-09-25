package com.tencent.mm.plugin.subapp.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.io.File;
import junit.framework.Assert;

public final class h {
    public static String at(String str, boolean z) {
        ap.yY();
        String a = com.tencent.mm.sdk.platformtools.h.a(c.xg(), "recbiz_", str, ".rec", 2);
        if (bg.mA(a)) {
            return null;
        }
        return (z || !new File(a).exists()) ? a : a;
    }

    public static boolean ma(String str) {
        if (str == null) {
            return false;
        }
        g Hl = Hl(str);
        if (Hl == null) {
            w.d("MicroMsg.VoiceRemindLogic", "cancel null record : " + str);
            return true;
        }
        w.d("MicroMsg.VoiceRemindLogic", "cancel record : " + str + " LocalId:" + Hl.field_msglocalid);
        if (Hl.field_msglocalid != 0) {
            ap.yY();
            c.wT().cB((long) Hl.field_msglocalid);
        }
        if (str == null) {
            return false;
        }
        d.bmZ().gR(str);
        lW(str);
        return new File(at(str, false)).delete();
    }

    static void lW(String str) {
        d.bmZ().lW(at(str, false));
    }

    public static g Hl(String str) {
        k bmZ = d.bmZ();
        g gVar = null;
        String str2 = "SELECT filename, user, msgid, offset, filenowsize, totallen, status, createtime, lastmodifytime, clientid, voicelenght, msglocalid, human, voiceformat, nettimes, reserved1, reserved2" + " FROM VoiceRemindInfo WHERE filename= ?";
        Cursor a = bmZ.gUz.a(str2, new String[]{str}, 2);
        if (a.moveToFirst()) {
            gVar = new g();
            gVar.b(a);
        }
        a.close();
        return gVar;
    }

    public static boolean lA(String str) {
        boolean z = false;
        if (str != null) {
            g Hl = Hl(str);
            if (Hl == null) {
                w.e("MicroMsg.VoiceRemindLogic", "Set error failed file:" + str);
            } else {
                Hl.field_status = 98;
                Hl.field_lastmodifytime = System.currentTimeMillis() / 1000;
                Hl.fRW = 320;
                z = a(Hl);
                w.d("MicroMsg.VoiceRemindLogic", "setError file:" + str + " msgid:" + Hl.field_msglocalid + " old stat:" + Hl.field_status);
                if (Hl.field_msglocalid == 0 || bg.mA(Hl.field_user)) {
                    w.e("MicroMsg.VoiceRemindLogic", "setError failed msg id:" + Hl.field_msglocalid + " user:" + Hl.field_user);
                } else {
                    ap.yY();
                    au cA = c.wT().cA((long) Hl.field_msglocalid);
                    cA.x((long) Hl.field_msglocalid);
                    cA.dv(5);
                    cA.cH(Hl.field_user);
                    cA.setContent(f.b(Hl.field_human, -1, true));
                    ap.yY();
                    c.wT().a(cA.field_msgId, cA);
                }
            }
        }
        return z;
    }

    static boolean a(g gVar) {
        if (gVar == null || gVar.fRW == -1) {
            return false;
        }
        k bmZ = d.bmZ();
        Assert.assertTrue(gVar.field_filename.length() > 0);
        Assert.assertTrue(gVar != null);
        ContentValues pv = gVar.pv();
        if (pv.size() <= 0) {
            w.e("MicroMsg.VoiceRemindStorage", "update failed, no values set");
            return false;
        }
        if (bmZ.gUz.update("VoiceRemindInfo", pv, "filename= ?", new String[]{r4}) <= 0) {
            return false;
        }
        bmZ.doNotify();
        return true;
    }

    public static c Hm(String str) {
        k bmZ = d.bmZ();
        String at = at(str, false);
        if (bmZ.qTv.get(at) == null) {
            bmZ.qTv.put(at, new c(at));
        }
        return (c) bmZ.qTv.get(at);
    }
}
