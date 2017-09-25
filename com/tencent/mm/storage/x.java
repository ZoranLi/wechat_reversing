package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.j.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class x extends a implements Cloneable {
    public String uIG = null;
    public CharSequence uyS;

    public x(String str) {
        super(str);
    }

    public static boolean QM(String str) {
        return str != null ? str.endsWith("@t.qq.com") : false;
    }

    public static boolean QN(String str) {
        return str != null ? str.endsWith("@qr") : false;
    }

    public static boolean QO(String str) {
        return str != null ? str.endsWith("@qqim") : false;
    }

    public static boolean QP(String str) {
        return str != null ? str.endsWith("@fb") : false;
    }

    public static boolean eO(String str) {
        if (str != null) {
            return str.contains("@bottle:") || str.endsWith("@bottle");
        } else {
            return false;
        }
    }

    public static boolean yC(int i) {
        return (i & 8) > 0;
    }

    public static boolean em(String str) {
        return str != null ? str.endsWith("@app") : false;
    }

    public static boolean aO(String str, boolean z) {
        if (bg.mA(str)) {
            w.e("MicroMsg.Contact", "Contact invisibleUsername username == null or nil");
            return false;
        }
        String z2 = ((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sW().z("HideWechatID", "idprefix");
        if (z2 == null) {
            z2 = "wx_;wxid_;gh_;a0;a1;a2;a3;a4;a5;a6;a7;a8;a9;q0;q1;q2;q3;q4;q5;q6;q7;q8;q9;qq0;qq1;qq2;qq3;qq4;qq5;qq6;qq7;qq8;qq9;f0;f1;f2;f3;f4;f5;f6;f7;f8;f9;F0;F1;F2;F3;F4;F5;F6;F7;F8;F9;";
        }
        String[] split = z2.split(";");
        int i = 0;
        while (i < split.length) {
            if (split[i] == null || !str.startsWith(split[i])) {
                i++;
            } else if (split[i].equals("wxid_") && z) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean QQ(String str) {
        return aO(str, false);
    }

    public static boolean bLd() {
        return false;
    }

    public static String QR(String str) {
        if (eO(str)) {
            String[] split = str.split(":");
            if (split == null || split.length <= 0) {
                return str;
            }
            return split[0];
        } else if (str == null || !str.contains("@")) {
            return str + "@bottle";
        } else {
            return "";
        }
    }

    public final boolean bLe() {
        return (this.field_verifyFlag & 8) > 0;
    }

    public static int bLf() {
        return 16;
    }

    public static int bLg() {
        return 8;
    }

    public final boolean bLh() {
        return ((long) (((int) bg.Ny()) - this.gkI)) > 86400;
    }

    public static String h(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndex("username"));
    }

    public final void ck(String str) {
        super.ck(str);
        bLj();
    }

    public final String getCountryCode() {
        String str = this.gkH;
        if (bg.mA(str)) {
            return "";
        }
        String[] split = str.split("_");
        if (split == null || split.length <= 0) {
            return "";
        }
        return bg.mz(split[0]);
    }

    public final String bLi() {
        String str = this.gkH;
        if (bg.mA(str)) {
            return "";
        }
        String[] split = str.split("_");
        if (split == null || split.length < 2) {
            return "";
        }
        return bg.mz(split[1]);
    }

    public final String getCityCode() {
        String str = this.gkH;
        if (bg.mA(str)) {
            return "";
        }
        String[] split = str.split("_");
        if (split == null || split.length < 3) {
            return "";
        }
        return bg.mz(split[2]);
    }

    @Deprecated
    public final void cf(String str) {
        super.cf(str);
    }

    @Deprecated
    public final void cg(String str) {
        super.cg(str);
    }

    public final String getProvince() {
        return super.getProvince();
    }

    public final String getCity() {
        return super.getCity();
    }

    public final void bLj() {
        String str = this.gkH;
        if (!bg.mA(str)) {
            String[] split = str.split("_");
            if (split.length <= 0) {
                return;
            }
            if (split.length > 2) {
                if (RegionCodeDecoder.RR(split[0])) {
                    super.cf(RegionCodeDecoder.bMP().eL(split[0], split[1]));
                } else {
                    super.cf(RegionCodeDecoder.bMP().RS(split[0]));
                }
                super.cg(RegionCodeDecoder.bMP().ac(split[0], split[1], split[2]));
            } else if (split.length == 2) {
                super.cf(RegionCodeDecoder.bMP().RS(split[0]));
                super.cg(RegionCodeDecoder.bMP().eL(split[0], split[1]));
            } else {
                super.cf(RegionCodeDecoder.bMP().RS(split[0]));
                super.cg("");
            }
        }
    }

    public final x bLk() {
        try {
            return (x) super.clone();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Contact", e, "", new Object[0]);
            w.e("MicroMsg.Contact", "clone Contact error. e: " + e.toString());
            return null;
        }
    }
}
