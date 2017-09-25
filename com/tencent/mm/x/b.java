package com.tencent.mm.x;

import android.graphics.Bitmap;
import com.tencent.mm.a.o;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.c.ame;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.m;

public final class b {
    public static String Q(String str, String str2) {
        return str + "?access_token=" + str2;
    }

    public static Bitmap gW(String str) {
        return a(str + "@google", false, -1);
    }

    private static String gX(String str) {
        return "http://graph.facebook.com/" + str + "/picture";
    }

    public static void gY(String str) {
        if (!bg.mA(str)) {
            String str2 = str + "@fb";
            h hs = n.Bm().hs(str2);
            if (hs == null || !str2.equals(hs.getUsername()) || 3 != hs.gkq) {
                if (hs == null) {
                    hs = new h();
                }
                hs.username = str2;
                hs.gkq = 3;
                hs.hrB = gX(str);
                hs.hrA = gX(str);
                hs.aV(true);
                hs.fRW = 31;
                n.Bm().a(hs);
            }
        }
    }

    public static Bitmap gZ(String str) {
        return a(str + "@fb", false, -1);
    }

    public static long ha(String str) {
        long j = -1;
        if (x.QP(str)) {
            try {
                j = bg.getLong(str.split("@")[0], -1);
            } catch (Exception e) {
            }
        }
        return j;
    }

    private static String P(long j) {
        return new o(j) + "@qqim";
    }

    public static long hb(String str) {
        long j = -1;
        if (x.QO(str)) {
            try {
                j = bg.getLong(str.split("@")[0], -1);
            } catch (Exception e) {
            }
        }
        return j;
    }

    public static boolean d(long j, int i) {
        if (i != 3) {
            return false;
        }
        return hc(P(j));
    }

    public static boolean hc(String str) {
        if (str == null) {
            w.w("MicroMsg.AvatarLogic", "setQQAvatarImgFlag failed : invalid username");
            return false;
        } else if (str.endsWith("@qqim")) {
            h hVar = new h();
            hVar.username = str;
            hVar.gkq = 3;
            hVar.fRW = 3;
            return n.Bm().a(hVar);
        } else {
            w.w("MicroMsg.AvatarLogic", "setQQAvatarImgFlag failed : invalid username");
            return false;
        }
    }

    public static Bitmap Q(long j) {
        return a(P(j), false, -1);
    }

    public static boolean u(String str, int i) {
        if (bg.mA(str)) {
            return false;
        }
        h hs = n.Bm().hs(str);
        if (hs != null && str.equals(hs.getUsername()) && i == hs.gkq) {
            return true;
        }
        if (hs == null) {
            hs = new h();
        }
        hs.username = str;
        hs.gkq = i;
        hs.fRW = 3;
        return n.Bm().a(hs);
    }

    public static Bitmap b(String str, int i, int i2, int i3) {
        if (bg.mA(str) || !h.vG().uV()) {
            return null;
        }
        Bitmap bitmap;
        n.Bl();
        w.d("MicroMsg.AvatarStorage", "getHDBitmap user:%s, width:%d, height:%d", str, Integer.valueOf(i), Integer.valueOf(i2));
        if (bg.mA(str)) {
            bitmap = null;
        } else {
            bitmap = d.a(d.r(str, true), i, i2, null, 0, 0, 1);
        }
        if (bitmap == null) {
            final e eVar = new e();
            eVar.a(str, new com.tencent.mm.x.e.b() {
                public final int aM(int i, int i2) {
                    eVar.Bp();
                    w.i("MicroMsg.AvatarLogic", "getHDHeadImage onSceneEnd: errType=%d, errCode=%d", Integer.valueOf(i), Integer.valueOf(i2));
                    return 0;
                }
            });
            return a(str, false, i3);
        } else if (i3 > 5) {
            return d.a(bitmap, false, (float) i3);
        } else {
            return bitmap;
        }
    }

    public static Bitmap a(String str, boolean z, int i) {
        if (bg.mA(str) || !h.vG().uV()) {
            return null;
        }
        if (!h.vI().vu()) {
            return n.Bl().aS(ab.getContext());
        }
        if (x.eO(str)) {
            str = x.QR(str);
        }
        return n.Bz().b(str, z, i);
    }

    public static String hd(String str) {
        if (bg.mA(str) || !h.vG().uV() || !h.vI().vu()) {
            return null;
        }
        if (x.eO(str)) {
            n.Bl();
            return d.r(x.QR(str), false);
        }
        n.Bl();
        return d.r(str, false);
    }

    public static void he(String str) {
        h hs = n.Bm().hs(str);
        if (hs != null && str.equals(hs.getUsername())) {
            hs.hrD = 0;
            hs.fRW = 64;
            n.Bm().a(hs);
        }
    }

    public static h a(String str, ame com_tencent_mm_protocal_c_ame) {
        h hVar = new h();
        hVar.fRW = -1;
        hVar.username = str;
        hVar.hrA = com_tencent_mm_protocal_c_ame.tqc;
        hVar.hrB = com_tencent_mm_protocal_c_ame.tqb;
        w.i("MicroMsg.AvatarLogic", "dkhurl contact %s b[%s] s[%s]", hVar.getUsername(), hVar.Bs(), hVar.Bt());
        hVar.aV(com_tencent_mm_protocal_c_ame.tQG != 0);
        if (com_tencent_mm_protocal_c_ame.tQB == 3 || com_tencent_mm_protocal_c_ame.tQB == 4) {
            hVar.gkq = com_tencent_mm_protocal_c_ame.tQB;
        } else if (com_tencent_mm_protocal_c_ame.tQB == 2) {
            hVar.gkq = 3;
            if (!m.xL().equals(str)) {
                n.Bl();
                d.s(str, false);
                n.Bl();
                d.s(str, true);
                n.Bz().hf(str);
            }
        }
        return hVar;
    }
}
