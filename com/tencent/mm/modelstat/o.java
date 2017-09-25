package com.tencent.mm.modelstat;

import android.util.Base64;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.bdi;
import com.tencent.mm.protocal.c.bdj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class o {

    public enum a {
        Chat(1),
        TalkChat(2),
        Sns(3);
        
        public int value;

        private a(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public static void a(String str, d dVar) {
        if (dVar != null) {
            b(str, dVar);
        }
    }

    public static void b(String str, d dVar) {
        if (!bg.mA(str) && dVar != null) {
            bdj kS = kS(str);
            dVar.n("Source", (kS == null ? -1 : kS.cGa) + ",");
            dVar.n("SnsStatExt", a(kS));
        }
    }

    public static bdj kS(String str) {
        if (bg.mA(str)) {
            return null;
        }
        byte[] decode = Base64.decode(str, 0);
        bdi com_tencent_mm_protocal_c_bdi = new bdi();
        try {
            com_tencent_mm_protocal_c_bdi.aD(decode);
        } catch (Exception e) {
            w.e("MicroMsg.SnsStatExtUtil", "", new Object[]{e});
        }
        return com_tencent_mm_protocal_c_bdi.ueA;
    }

    public static String a(String str, PString pString) {
        if (bg.mA(str)) {
            return "";
        }
        byte[] decode = Base64.decode(str, 0);
        bdi com_tencent_mm_protocal_c_bdi = new bdi();
        try {
            com_tencent_mm_protocal_c_bdi.aD(decode);
            String str2 = com_tencent_mm_protocal_c_bdi.ueA.ueE;
            String str3 = com_tencent_mm_protocal_c_bdi.ueA.ueD;
            str2 = String.format("snsId=%s&uxInfo=%s&source=%d&snsStatExt=%s", new Object[]{URLEncoder.encode(str2, "UTF-8"), URLEncoder.encode(str3, "UTF-8"), Integer.valueOf(com_tencent_mm_protocal_c_bdi.ueA.cGa), URLEncoder.encode(a(com_tencent_mm_protocal_c_bdi.ueA), "UTF-8")});
            pString.value = com_tencent_mm_protocal_c_bdi.ueC == null ? "" : com_tencent_mm_protocal_c_bdi.ueC.mpy;
            return str2;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SnsStatExtUtil", e, "", new Object[0]);
            return "";
        }
    }

    public static String a(bdj com_tencent_mm_protocal_c_bdj) {
        if (com_tencent_mm_protocal_c_bdj != null) {
            String str = com_tencent_mm_protocal_c_bdj.ueE;
            String str2 = "";
            if (!bg.mA(str)) {
                String[] split = str.split("\\|");
                if (split != null && split.length > 0) {
                    str2 = split[0];
                }
            }
            try {
                return String.format("expId=%d&adgroup_id=%s&snsId=%s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bdj.ueF), URLEncoder.encode(str2, "UTF-8"), com_tencent_mm_protocal_c_bdj.ueD});
            } catch (UnsupportedEncodingException e) {
                w.e("MicroMsg.SnsStatExtUtil", "", new Object[]{e});
            }
        }
        return "";
    }

    public static String z(au auVar) {
        if (auVar == null) {
            return "";
        }
        String str = null;
        if (auVar.axO()) {
            com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(auVar.field_content);
            if (ek == null || bg.mA(ek.fUY)) {
                return "";
            }
            str = ek.fUY;
        }
        if (!auVar.bMm()) {
            return str;
        }
        r lH = t.lH(auVar.field_imgPath);
        if (lH == null || bg.mA(lH.fUY)) {
            return "";
        }
        return lH.fUY;
    }
}
