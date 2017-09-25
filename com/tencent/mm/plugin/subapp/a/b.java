package com.tencent.mm.plugin.subapp.a;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ag.c;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class b implements c {

    private static class a implements e {
        public a() {
            ap.vd().a(167, (e) this);
            ap.vd().a(new a(), 0);
        }

        public final void a(int i, int i2, String str, k kVar) {
            ap.vd().b(167, (e) this);
        }
    }

    public final String eY(int i) {
        return U(i, true);
    }

    public final String eZ(int i) {
        return U(i, false);
    }

    private String U(int i, boolean z) {
        int i2 = 0;
        ap.yY();
        if (!com.tencent.mm.u.c.isSDCardAvailable()) {
            return null;
        }
        int i3;
        if (i != 0) {
            i3 = 0;
            while (i3 < 32) {
                i = (i >> 1) & Integer.MAX_VALUE;
                if (i == 0) {
                    break;
                }
                i3++;
            }
        } else {
            i3 = -1;
        }
        if (i3 != -1) {
            i2 = 1 << i3;
        }
        String u = i2 == 0 ? null : u(i2, z);
        if (com.tencent.mm.a.e.aO(u)) {
            return u;
        }
        yJ();
        return null;
    }

    public final void yJ() {
        ap.yY();
        if (com.tencent.mm.u.c.isSDCardAvailable()) {
            ap.yY();
            long a = bg.a((Long) com.tencent.mm.u.c.vr().get(66051, null), 0);
            long Nz = bg.Nz();
            if (432000000 <= Nz - a) {
                ap.yY();
                com.tencent.mm.u.c.vr().set(66051, Long.valueOf(Nz));
                a aVar = new a();
            }
        }
    }

    public final boolean fa(int i) {
        if (i == 0) {
            return false;
        }
        int i2 = 0;
        while (i2 < 32) {
            if (!com.tencent.mm.a.e.aO(u((1 << i2) & i, false)) || !com.tencent.mm.a.e.aO(u((1 << i2) & i, true))) {
                return false;
            }
            i2++;
        }
        return true;
    }

    public final String u(int i, boolean z) {
        if (i == 0) {
            return null;
        }
        return com.tencent.mm.compatible.util.e.gSA + "vuserpic_" + Integer.toHexString(i) + (z ? "_HD" : "") + ".png";
    }
}
