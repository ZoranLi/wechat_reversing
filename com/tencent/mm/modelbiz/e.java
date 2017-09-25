package com.tencent.mm.modelbiz;

import com.tencent.mm.bd.a;
import com.tencent.mm.e.b.af;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.alx;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.ay.AnonymousClass3;
import com.tencent.wcdb.FileUtils;
import java.util.List;

public final class e {
    public static BizInfo hW(String str) {
        BizInfo hO = w.DH().hO(str);
        return hO.field_updateTime > 0 ? hO : null;
    }

    public static boolean hX(String str) {
        BizInfo hW = hW(str);
        if (hW != null && hW.CE()) {
            return true;
        }
        return false;
    }

    public static boolean hY(String str) {
        BizInfo hW = hW(str);
        if (hW == null) {
            return false;
        }
        return hW.CF();
    }

    public static boolean hZ(String str) {
        BizInfo hW = hW(str);
        if (hW != null && hW.CG()) {
            return true;
        }
        return false;
    }

    public static boolean ia(String str) {
        BizInfo hW = hW(str);
        if (hW != null && hW.CI()) {
            return true;
        }
        return false;
    }

    public static boolean ib(String str) {
        if (str == null) {
            return false;
        }
        BizInfo hW = hW(str);
        if (hW == null || !hW.CH()) {
            return false;
        }
        return true;
    }

    public static boolean dr(String str) {
        BizInfo hW = hW(str);
        if (hW != null && hW.CJ()) {
            return true;
        }
        return false;
    }

    public static boolean ic(String str) {
        BizInfo hW = hW(str);
        if (hW != null && hW.CK()) {
            return true;
        }
        return false;
    }

    public static boolean ie(String str) {
        BizInfo hW = hW(str);
        if (hW == null) {
            return false;
        }
        return hW.Cz();
    }

    public static void f(BizInfo bizInfo) {
        if (bizInfo == null) {
            w.e("MicroMsg.BizInfoStorageLogic", "updateBrandFlagForTempSession bizInfo is Null");
            return;
        }
        a com_tencent_mm_protocal_c_alx = new alx();
        com_tencent_mm_protocal_c_alx.hAR = bizInfo.field_brandFlag;
        com_tencent_mm_protocal_c_alx.jNj = bizInfo.field_username;
        af Rb = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rb(bizInfo.field_username);
        if (Rb == null || !com.tencent.mm.j.a.ez(Rb.field_type)) {
            ((h) com.tencent.mm.kernel.h.h(h.class)).wQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(58, com_tencent_mm_protocal_c_alx));
        } else {
            ((h) com.tencent.mm.kernel.h.h(h.class)).wQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(47, com_tencent_mm_protocal_c_alx));
        }
        boolean c = w.DH().c(bizInfo, new String[0]);
        w.i("MicroMsg.BizInfoStorageLogic", "updateBrandFlagForTempSession ret = %b, BrandFlag = %b", Boolean.valueOf(c), Integer.valueOf(bizInfo.field_brandFlag));
    }

    public static void g(BizInfo bizInfo) {
        if (bizInfo != null) {
            a com_tencent_mm_protocal_c_alx = new alx();
            com_tencent_mm_protocal_c_alx.hAR = bizInfo.field_brandFlag;
            com_tencent_mm_protocal_c_alx.jNj = bizInfo.field_username;
            ((h) com.tencent.mm.kernel.h.h(h.class)).wQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(47, com_tencent_mm_protocal_c_alx));
            w.DH().c(bizInfo, new String[0]);
        }
    }

    public static boolean Dn() {
        return w.DH().fx(1) > 0;
    }

    public static List<String> Do() {
        return w.DH().fw(2);
    }

    public static boolean Dp() {
        return w.DH().fx(4) > 0;
    }

    public static boolean Dq() {
        return w.DH().fx(8) > 0;
    }

    public static List<String> Dr() {
        return w.DH().fw(16);
    }

    public static boolean Ds() {
        return w.DH().fx(16) > 0;
    }

    public static List<String> Dt() {
        return w.DH().fw(32);
    }

    public static boolean Du() {
        return w.DH().fx(64) > 0;
    }

    public static List<String> Dv() {
        return w.DH().fw(FileUtils.S_IWUSR);
    }

    public static boolean Dw() {
        return w.DH().fx(FileUtils.S_IWUSR) > 0;
    }

    public static boolean Dx() {
        return w.DH().fx(256) > 0;
    }

    public static boolean Dy() {
        return w.DH().fx(512) > 0;
    }

    public static void if(String str) {
        ay.a(str, null);
        ((h) com.tencent.mm.kernel.h.h(h.class)).wW().Rl(str);
        BizInfo hW = hW(str);
        if (hW == null) {
            w.DO().gR(str);
            return;
        }
        if (hW.CH()) {
            ((h) com.tencent.mm.kernel.h.h(h.class)).wW().RB(str);
            w.DH();
            List hR = d.hR(str);
            if (hR == null || hR.size() <= 0) {
                w.d("MicroMsg.MsgInfoStorageLogic", "deleteMsgByTalkers, empty talkers");
            } else {
                w.d("MicroMsg.MsgInfoStorageLogic", "deleteMsgByTalkers");
                com.tencent.mm.kernel.h.vJ();
                com.tencent.mm.kernel.h.vL().D(new AnonymousClass3(hR, null));
            }
            for (int i = 0; i < hR.size(); i++) {
                String str2 = (String) hR.get(i);
                if (dr(str2)) {
                    com.tencent.mm.modelbiz.a.e.u(str2, true);
                }
                w.DH().hP(str2);
            }
        }
        if (hW.CJ()) {
            com.tencent.mm.modelbiz.a.e.u(str, true);
        }
        w.DH().c(hW);
        w.DO().gR(str);
    }
}
