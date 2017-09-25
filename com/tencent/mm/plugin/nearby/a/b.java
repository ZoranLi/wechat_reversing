package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.e.b.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.ay.a;
import com.tencent.mm.u.c;

public final class b {
    public static final int nVB = 1;
    private static final /* synthetic */ int[] nVC = new int[]{nVB};

    public static boolean cY(String str, String str2) {
        af xVar = new x();
        xVar.bR(str2);
        xVar.setUsername(str);
        ap.yY();
        ar wR = c.wR();
        w.d("MicroMsg.LbsroomLogic", "Save lbsroom contact name:" + xVar.field_username);
        if (!wR.Re(xVar.field_username)) {
            wR.R(xVar);
        }
        ap.yY();
        c.vr().set(143873, str);
        ap.yY();
        c.vr().set(143874, Long.valueOf(bg.Ny()));
        return true;
    }

    public static void bs(String str, int i) {
        ap.yY();
        ap.vd().a(new d(str, (int) bg.az(bg.c((Long) c.vr().get(143874, Long.valueOf(0)))), i), 0);
    }

    public static void cV(int i) {
        ap.yY();
        String mz = bg.mz((String) c.vr().get(143873, ""));
        if (!mz.equals("")) {
            ap.yY();
            if (bg.az(bg.c((Long) c.vr().get(143874, Long.valueOf(0)))) < 7200) {
                bs(mz, i);
            } else {
                BG(mz);
            }
        }
    }

    public static boolean aOA() {
        ap.yY();
        return bg.f((Integer) c.vr().get(143875, Integer.valueOf(0))) == 1;
    }

    public static void aOB() {
        ap.yY();
        c.vr().set(143875, Integer.valueOf(1));
    }

    public static void aOC() {
        ap.yY();
        c.vr().set(143875, Integer.valueOf(0));
    }

    public static void BG(String str) {
        ap.yY();
        ar wR = c.wR();
        if (wR.Re(str)) {
            wR.Ri(str);
        }
        ay.a(str, new a() {
            public final boolean zs() {
                return false;
            }

            public final void zr() {
            }
        });
        ap.yY();
        c.vr().set(143873, "");
        ap.yY();
        c.vr().set(143874, Long.valueOf(0));
        aOC();
    }
}
