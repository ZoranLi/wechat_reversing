package com.tencent.mm.u;

import com.tencent.mm.a.e;
import com.tencent.mm.bd.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.c.amw;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.wcdb.FileUtils;

public final class bg {
    public String countryCode = "";
    public int gkA = 0;
    public String gkF = "";
    public int gkr = 0;
    private String hnM = "";
    private String hnN = "";
    public String hnO = "";
    public String hnP = "";
    public String signature = "";

    private static class a {
        public static boolean N(String str, String str2) {
            if (com.tencent.mm.sdk.platformtools.bg.mA(str)) {
                return true;
            }
            String decode = decode(encode(str));
            if (com.tencent.mm.sdk.platformtools.bg.mA(decode) || !decode.equals(str2)) {
                return true;
            }
            return false;
        }

        private static String encode(String str) {
            char[] toCharArray = str.toCharArray();
            String str2 = "";
            try {
                int length = toCharArray.length;
                String str3 = str2;
                int i = 0;
                while (i < length) {
                    char c = toCharArray[i];
                    i++;
                    str3 = str3 + String.format("%02x", new Object[]{Integer.valueOf(c)});
                }
                return str3;
            } catch (Exception e) {
                return "";
            }
        }

        private static String decode(String str) {
            String str2 = "";
            if (com.tencent.mm.sdk.platformtools.bg.mA(str) || str.length() % 2 != 0) {
                return "";
            }
            String str3 = str2;
            int i = 0;
            while (i < str.length()) {
                try {
                    String str4 = str3 + ((char) Integer.parseInt(str.substring(i, i + 2), 16));
                    i += 2;
                    str3 = str4;
                } catch (Exception e) {
                    return "";
                }
            }
            return str3;
        }
    }

    public static bg zL() {
        bg bgVar = new bg();
        bgVar.gkA = 1;
        bgVar.gkr = com.tencent.mm.sdk.platformtools.bg.a((Integer) h.vI().vr().get(12290, null), 0);
        bgVar.hnM = (String) h.vI().vr().get(12293, null);
        bgVar.hnN = (String) h.vI().vr().get(12292, null);
        bgVar.signature = (String) h.vI().vr().get(12291, null);
        bgVar.gkF = (String) h.vI().vr().get(12307, null);
        bgVar.countryCode = (String) h.vI().vr().get(12324, null);
        bgVar.hnP = (String) h.vI().vr().get(12325, null);
        bgVar.hnO = (String) h.vI().vr().get(12326, null);
        return bgVar;
    }

    public static bg zM() {
        if (com.tencent.mm.sdk.platformtools.bg.a((Integer) h.vI().vr().get(12289, null), 0) == 0) {
            return null;
        }
        return zL();
    }

    public static amw a(bg bgVar) {
        h.vI().vr().set(12289, Integer.valueOf(bgVar.gkA));
        h.vI().vr().set(12290, Integer.valueOf(bgVar.gkr));
        if (a.N((String) h.vI().vr().get(12293, null), bgVar.getProvince())) {
            h.vI().vr().set(12293, bgVar.getProvince());
        }
        if (a.N((String) h.vI().vr().get(12292, null), bgVar.getCity())) {
            h.vI().vr().set(12292, bgVar.getCity());
        }
        if (a.N((String) h.vI().vr().get(12291, null), bgVar.signature)) {
            h.vI().vr().set(12291, bgVar.signature);
        }
        if (a.N((String) h.vI().vr().get(12307, null), bgVar.gkF)) {
            h.vI().vr().set(12307, bgVar.gkF);
        }
        if (a.N((String) h.vI().vr().get(12324, null), bgVar.countryCode)) {
            h.vI().vr().set(12324, bgVar.countryCode);
        }
        if (a.N((String) h.vI().vr().get(12325, null), bgVar.hnP)) {
            h.vI().vr().set(12325, bgVar.hnP);
        }
        if (a.N((String) h.vI().vr().get(12326, null), bgVar.hnO)) {
            h.vI().vr().set(12326, bgVar.hnO);
        }
        amw com_tencent_mm_protocal_c_amw = new amw();
        com_tencent_mm_protocal_c_amw.tRr = FileUtils.S_IWUSR;
        com_tencent_mm_protocal_c_amw.ttp = new avx().OV("");
        com_tencent_mm_protocal_c_amw.tLj = new avx().OV("");
        com_tencent_mm_protocal_c_amw.tdy = 0;
        com_tencent_mm_protocal_c_amw.tRs = new avx().OV("");
        com_tencent_mm_protocal_c_amw.tRt = new avx().OV("");
        com_tencent_mm_protocal_c_amw.jNB = 0;
        byte[] c = e.c("", 0, -1);
        com_tencent_mm_protocal_c_amw.tRp = new b(c == null ? new byte[0] : c);
        com_tencent_mm_protocal_c_amw.tRo = c == null ? 0 : c.length;
        com_tencent_mm_protocal_c_amw.hAD = bgVar.gkr;
        com_tencent_mm_protocal_c_amw.hAH = bgVar.gkA;
        com_tencent_mm_protocal_c_amw.hAG = com.tencent.mm.sdk.platformtools.bg.mz(bgVar.signature);
        com_tencent_mm_protocal_c_amw.hAF = com.tencent.mm.sdk.platformtools.bg.mz(bgVar.hnO);
        com_tencent_mm_protocal_c_amw.hAE = com.tencent.mm.sdk.platformtools.bg.mz(bgVar.hnP);
        com_tencent_mm_protocal_c_amw.tdB = 0;
        com_tencent_mm_protocal_c_amw.tMR = com.tencent.mm.sdk.platformtools.bg.mz(bgVar.gkF);
        com_tencent_mm_protocal_c_amw.tRy = 0;
        com_tencent_mm_protocal_c_amw.hAI = "";
        com_tencent_mm_protocal_c_amw.tMT = 0;
        com_tencent_mm_protocal_c_amw.tMS = "";
        com_tencent_mm_protocal_c_amw.hAM = com.tencent.mm.sdk.platformtools.bg.mz(bgVar.countryCode);
        return com_tencent_mm_protocal_c_amw;
    }

    public final String getCity() {
        if (!com.tencent.mm.sdk.platformtools.bg.mA(this.countryCode)) {
            if (com.tencent.mm.sdk.platformtools.bg.mA(this.hnP)) {
                this.hnN = "";
            } else if (com.tencent.mm.sdk.platformtools.bg.mA(this.hnO)) {
                this.hnN = RegionCodeDecoder.bMP().eL(this.countryCode, this.hnP);
            } else {
                this.hnN = RegionCodeDecoder.bMP().ac(this.countryCode, this.hnP, this.hnO);
            }
        }
        if (com.tencent.mm.sdk.platformtools.bg.mA(this.hnN)) {
            return com.tencent.mm.sdk.platformtools.bg.mz(this.hnO);
        }
        return this.hnN;
    }

    public final String getProvince() {
        if (!com.tencent.mm.sdk.platformtools.bg.mA(this.countryCode)) {
            if (com.tencent.mm.sdk.platformtools.bg.mA(this.hnP) || com.tencent.mm.sdk.platformtools.bg.mA(this.hnO) || !RegionCodeDecoder.RR(this.countryCode)) {
                this.hnM = RegionCodeDecoder.bMP().RS(this.countryCode);
            } else {
                this.hnM = RegionCodeDecoder.bMP().eL(this.countryCode, this.hnP);
            }
        }
        return com.tencent.mm.sdk.platformtools.bg.mA(this.hnM) ? com.tencent.mm.sdk.platformtools.bg.mz(this.hnP) : this.hnM;
    }
}
