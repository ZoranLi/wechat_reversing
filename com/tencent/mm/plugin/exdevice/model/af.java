package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.e.a.sk;
import com.tencent.mm.plugin.exdevice.b.k.f;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.model.i.a;
import com.tencent.mm.plugin.exdevice.service.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class af implements e {
    c gKr = new c<sk>(this) {
        final /* synthetic */ af leA;

        {
            this.leA = r2;
            this.usg = sk.class.getName().hashCode();
        }

        private boolean a(final sk skVar) {
            boolean z = true;
            if (skVar instanceof sk) {
                switch (skVar.gac.fEG) {
                    case 1:
                        w.i("MicroMsg.WearHardDeviceLogic", "receive register deviceId=%s", new Object[]{skVar.gac.fwJ});
                        i.ldm.a(ab.getContext(), new a(this) {
                            final /* synthetic */ AnonymousClass1 leC;

                            public final void dI(boolean z) {
                                if (z) {
                                    af.S(skVar.gac.fwJ, true);
                                    return;
                                }
                                w.e("MicroMsg.WearHardDeviceLogic", "GetBoundDeviceLogic Fail, deviceId=%s|deviceType=%s", new Object[]{skVar.gac.fwJ, skVar.gac.fGl});
                                af.S(skVar.gac.fwJ, false);
                            }
                        });
                        break;
                    case 3:
                        b vj = ad.apt().vj(skVar.gac.fwJ);
                        sk.a aVar = skVar.gac;
                        if (vj == null) {
                            z = false;
                        }
                        aVar.fHO = z;
                        break;
                    case 4:
                        w.i("MicroMsg.WearHardDeviceLogic", "receive send deviceId=%s", new Object[]{skVar.gac.fwJ});
                        ap.vd().a(538, this.leA);
                        ap.vd().a(new w(0, skVar.gac.fGl, skVar.gac.fwJ, f.aoX(), bg.Nz(), skVar.gac.data, 1), 0);
                        break;
                    case 7:
                        ap.vd().a(541, this.leA);
                        ap.vd().a(new r("AndroidWear", skVar.gac.fGl, skVar.gac.fwJ, 1, new byte[0]), 0);
                        break;
                    case 11:
                        if (!bg.bb(ab.getContext(), ab.getPackageName() + ":exdevice")) {
                            d.bU(ab.getContext());
                            break;
                        }
                        break;
                }
            }
            return false;
        }
    };

    public af() {
        com.tencent.mm.sdk.b.a.urY.b(this.gKr);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof r) {
            ap.vd().b(541, this);
            r rVar = (r) kVar;
            if (i == 0 && i2 == 0) {
                T(rVar.ldD, true);
            } else {
                T(rVar.ldD, false);
            }
        } else if (kVar instanceof w) {
            ap.vd().b(538, this);
            w wVar = (w) kVar;
            if (i == 0 && i2 == 0) {
                U(wVar.ldF, true);
            } else {
                U(wVar.ldF, false);
            }
        }
    }

    public static void S(String str, boolean z) {
        w.i("MicroMsg.WearHardDeviceLogic", "publish register response deviceId=%s | isSuccess=%b", new Object[]{str, Boolean.valueOf(z)});
        com.tencent.mm.sdk.b.b skVar = new sk();
        skVar.gac.fEG = 2;
        skVar.gac.fHO = z;
        skVar.gac.fwJ = str;
        com.tencent.mm.sdk.b.a.urY.m(skVar);
    }

    private static void T(String str, boolean z) {
        w.i("MicroMsg.WearHardDeviceLogic", "publish auth response deviceId=%s | isSuccess=%b", new Object[]{str, Boolean.valueOf(z)});
        com.tencent.mm.sdk.b.b skVar = new sk();
        skVar.gac.fEG = 8;
        skVar.gac.fHO = z;
        skVar.gac.fwJ = str;
        com.tencent.mm.sdk.b.a.urY.m(skVar);
    }

    private static void U(String str, boolean z) {
        w.i("MicroMsg.WearHardDeviceLogic", "publish send response deviceId=%s | isSuccess=%b", new Object[]{str, Boolean.valueOf(z)});
        com.tencent.mm.sdk.b.b skVar = new sk();
        skVar.gac.fEG = 5;
        skVar.gac.fHO = z;
        skVar.gac.fwJ = str;
        com.tencent.mm.sdk.b.a.urY.m(skVar);
    }
}
