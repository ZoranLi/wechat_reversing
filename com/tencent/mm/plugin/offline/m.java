package com.tencent.mm.plugin.offline;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.R;
import com.tencent.mm.e.a.si;
import com.tencent.mm.plugin.offline.a.r;
import com.tencent.mm.plugin.offline.a.r.a;
import com.tencent.mm.plugin.offline.a.r.f;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.ui.e;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class m implements a {
    c nod = new c<si>(this) {
        final /* synthetic */ m oco;

        {
            this.oco = r2;
            this.usg = si.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            si siVar = (si) bVar;
            if (siVar instanceof si) {
                switch (siVar.fZQ.action) {
                    case 3:
                        if (!com.tencent.mm.pluginsdk.g.a.aCG()) {
                            if (!com.tencent.mm.plugin.wallet_core.model.m.btS().bul()) {
                                if (!com.tencent.mm.plugin.wallet_core.model.m.btS().buj()) {
                                    if (!com.tencent.mm.plugin.wallet_core.model.m.btS().bum() || !com.tencent.mm.plugin.offline.c.a.aQL()) {
                                        if (!com.tencent.mm.plugin.wallet_core.model.m.btS().bum() || com.tencent.mm.plugin.offline.c.a.aQL()) {
                                            if (com.tencent.mm.plugin.wallet_core.model.m.btS().bun()) {
                                                siVar.fZR.fZS = 3;
                                                break;
                                            }
                                        }
                                        siVar.fZR.fZS = 4;
                                        break;
                                    }
                                    k.aQd();
                                    e aQf = k.aQf();
                                    w.i("MicroMsg.OfflineCodesMgr", "generatetKey scene %s isSnapshot %s stack: %s", new Object[]{Integer.valueOf(9), Integer.valueOf(0), bg.bJZ().toString()});
                                    String l = aQf.l(9, 0, "");
                                    Bitmap b = com.tencent.mm.bf.a.a.b(ab.getContext(), l, 5, 0);
                                    Bitmap b2 = com.tencent.mm.bf.a.a.b(ab.getContext(), l, 0, 3);
                                    siVar.fZR.fZS = 1;
                                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                    b.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                                    siVar.fZR.fZW = byteArrayOutputStream.toByteArray();
                                    byteArrayOutputStream.reset();
                                    b2.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                                    siVar.fZR.fZX = byteArrayOutputStream.toByteArray();
                                    siVar.fZR.fZY = e.UN(l);
                                    String aQV = com.tencent.mm.plugin.offline.c.a.aQV();
                                    Bankcard bankcard = null;
                                    for (Bankcard bankcard2 : com.tencent.mm.plugin.offline.c.a.ge(true)) {
                                        Bankcard bankcard22;
                                        if (bankcard22.field_bindSerial == null || !bankcard22.field_bindSerial.equals(aQV)) {
                                            bankcard22 = bankcard;
                                        }
                                        bankcard = bankcard22;
                                    }
                                    if (bankcard == null) {
                                        w.i("MicroMsg.Wear.WearOfflineLogic", "get payway fail");
                                        break;
                                    }
                                    siVar.fZR.fZZ = ab.getContext().getString(R.l.fkV, new Object[]{bankcard.field_desc});
                                    w.i("MicroMsg.Wear.WearOfflineLogic", "payway %s", new Object[]{siVar.fZR.fZZ});
                                    break;
                                }
                                siVar.fZR.fZS = 3;
                                break;
                            }
                            siVar.fZR.fZS = 2;
                            break;
                        }
                        siVar.fZR.fZS = 5;
                        break;
                        break;
                }
            }
            return false;
        }
    };

    public m() {
        com.tencent.mm.sdk.b.a.urY.b(this.nod);
        k.aQd();
        k.aQe().a(this);
    }

    private static void ag(int i, String str) {
        b siVar = new si();
        siVar.fZQ.fZS = i;
        siVar.fZQ.action = 4;
        siVar.fZQ.content = str;
        com.tencent.mm.sdk.b.a.urY.m(siVar);
    }

    public final boolean a(r.c cVar) {
        if (cVar.odh == 6) {
            f fVar = (f) cVar;
            if (fVar.odo.rGe == null || fVar.odo.rGe.size() <= 0) {
                ag(9, ab.getContext().getString(R.l.fkR));
            } else {
                Commodity commodity = (Commodity) fVar.odo.rGe.get(0);
                ag(0, ab.getContext().getString(R.l.flO, new Object[]{e.d(commodity.kBc, commodity.oga)}));
            }
        } else if (cVar.odh == 8) {
            ag(6, ab.getContext().getString(R.l.fkR));
        } else if (cVar.odh == 5) {
            ag(7, bg.ap(((r.e) cVar).odl, ""));
        } else if (cVar.odh == 4) {
            ag(8, ab.getContext().getString(R.l.fkS));
        }
        return false;
    }
}
