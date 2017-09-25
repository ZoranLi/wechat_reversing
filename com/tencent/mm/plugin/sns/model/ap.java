package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.a.e;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class ap {
    public static String ap(int i, String str) {
        String a = d.a("snsvideo", (long) i, "sns", str);
        if (bg.mA(a)) {
            return null;
        }
        return a;
    }

    public static String lu(String str) {
        if (bg.mA(str)) {
            return "";
        }
        w.d("MicroMsg.SnsVideoLogic", "gen sns[%s] video file name [%s]", new Object[]{str, "SNS_" + str});
        return "SNS_" + str;
    }

    public static String Fr(String str) {
        if (bg.mA(str)) {
            return "";
        }
        int indexOf = str.indexOf("SNS_");
        if (indexOf < 0) {
            return "";
        }
        String str2 = "";
        try {
            return str.substring(indexOf + 4);
        } catch (Exception e) {
            return str2;
        }
    }

    public static String Fs(String str) {
        if (bg.mA(str)) {
            return null;
        }
        w.i("MicroMsg.SnsVideoLogic", "get sns video dir %s mediaId %s", new Object[]{am.du(ae.getAccSnsPath(), str), str});
        return am.du(ae.getAccSnsPath(), str);
    }

    public static String C(alh com_tencent_mm_protocal_c_alh) {
        if (com_tencent_mm_protocal_c_alh == null) {
            return null;
        }
        w.i("MicroMsg.SnsVideoLogic", "get sns video path %s", new Object[]{am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY) + i.j(com_tencent_mm_protocal_c_alh)});
        return am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY) + i.j(com_tencent_mm_protocal_c_alh);
    }

    public static String a(String str, alh com_tencent_mm_protocal_c_alh) {
        String str2;
        if (com_tencent_mm_protocal_c_alh == null) {
            str2 = null;
        } else {
            str2 = am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY) + i.p(com_tencent_mm_protocal_c_alh);
            w.i("MicroMsg.SnsVideoLogic", "get sns video tmp path %s", new Object[]{str2});
        }
        if (e.aO(str2)) {
            w.i("MicroMsg.SnsVideoLogic", "it needn't download video[%s] because of the video is self. %s", new Object[]{str, str2});
            return str2;
        }
        str2 = C(com_tencent_mm_protocal_c_alh);
        boolean aO = e.aO(str2);
        r Ft = Ft(str);
        if (Ft == null) {
            if (aO) {
                w.i("MicroMsg.SnsVideoLogic", "it old version already download video[%s]. path :%s", new Object[]{str, str2});
                return str2;
            }
            w.i("MicroMsg.SnsVideoLogic", "video info is null and file is no exists, return null.[%s]", new Object[]{str});
            return null;
        } else if (aO && Ft.Lk()) {
            w.i("MicroMsg.SnsVideoLogic", "it had download sns video[%s] finish. %s", new Object[]{str, str2});
            return str2;
        } else {
            w.i("MicroMsg.SnsVideoLogic", "it don't download video[%s] finish. file[%b] status[%d], return null.", new Object[]{str, Boolean.valueOf(aO), Integer.valueOf(Ft.status)});
            return null;
        }
    }

    public static boolean bK(String str, int i) {
        if (bg.mA(str)) {
            w.w("MicroMsg.SnsVideoLogic", "init sns record, but snsLocalId is null");
            return false;
        }
        String lu = lu(str);
        r rVar = new r();
        rVar.fyF = lu;
        rVar.iam = bg.Ny();
        rVar.status = 130;
        rVar.hzv = i;
        w.i("MicroMsg.SnsVideoLogic", "init sns Record filename %s, insert %b", new Object[]{lu, Boolean.valueOf(o.KV().a(rVar))});
        return o.KV().a(rVar);
    }

    public static boolean c(r rVar, int i) {
        rVar.status = 130;
        rVar.hzv = i;
        rVar.fRW = 268435712;
        w.i("MicroMsg.SnsVideoLogic", "update sns Record filename %s, update %b", new Object[]{rVar.getFileName(), Boolean.valueOf(o.KV().b(rVar))});
        return o.KV().b(rVar);
    }

    public static boolean dw(String str, String str2) {
        int i;
        boolean a;
        r Ft = Ft(str);
        if (Ft == null) {
            Ft = new r();
            Ft.fyF = lu(str);
            i = 1;
        } else {
            i = 0;
        }
        Ft.iam = bg.Ny();
        Ft.fVC = str2;
        Ft.status = 199;
        if (i != 0) {
            a = o.KV().a(Ft);
        } else {
            Ft.fRW = 33555200;
            a = o.KV().b(Ft);
        }
        w.i("MicroMsg.SnsVideoLogic", "post sns video snsLocalId %s, md5 %s ret %b", new Object[]{str, str2, Boolean.valueOf(a)});
        return a;
    }

    public static r Ft(String str) {
        if (bg.mA(str)) {
            return null;
        }
        return t.lH(lu(str));
    }
}
