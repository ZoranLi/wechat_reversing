package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.plugin.aa.a.c;
import com.tencent.mm.plugin.aa.a.g;
import com.tencent.mm.plugin.aa.a.j;
import com.tencent.mm.protocal.c.q;
import com.tencent.mm.protocal.c.s;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.vending.app.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.y.e;

public class f extends a {
    c ioF = new c();
    g ioG = new g();
    j ioH = new j();

    class AnonymousClass1 implements com.tencent.mm.vending.c.a<Void, com.tencent.mm.y.a.a<q>> {
        final /* synthetic */ f ioI;
        final /* synthetic */ b ior;

        AnonymousClass1(f fVar, b bVar) {
            this.ioI = fVar;
            this.ior = bVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.y.a.a aVar = (com.tencent.mm.y.a.a) obj;
            w.i("MicroMsg.PaylistAAInteractor", "errType: %s, errCode: %s, retCode: %s, retMsg: %s", new Object[]{Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), Integer.valueOf(((q) aVar.fYb).kAC), ((q) aVar.fYb).kAD});
            this.ior.resume();
            return wCE;
        }
    }

    class AnonymousClass2 implements com.tencent.mm.vending.c.a<Void, com.tencent.mm.y.a.a<s>> {
        final /* synthetic */ f ioI;
        final /* synthetic */ b ior;

        AnonymousClass2(f fVar, b bVar) {
            this.ioI = fVar;
            this.ior = bVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.y.a.a aVar = (com.tencent.mm.y.a.a) obj;
            w.i("MicroMsg.PaylistAAInteractor", "on urgeAAPay finish, errType: %s, errCode: %s", new Object[]{Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode)});
            if (aVar.errType == 0 && aVar.errCode == 0) {
                s sVar = (s) aVar.fYb;
                w.i("MicroMsg.PaylistAAInteractor", "on urgeAAPay finish, retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(sVar.kAC), sVar.kAD});
                if (sVar.kAC == 0) {
                    w.i("MicroMsg.PaylistAAInteractor", "on urgeAAPay success");
                    com.tencent.mm.plugin.aa.a.imw.ou();
                    this.ior.s(new Object[]{Boolean.valueOf(true)});
                    com.tencent.mm.plugin.report.service.g.oUh.a(407, 24, 1, false);
                } else {
                    if (sVar.kAC <= 0 || bg.mA(sVar.kAD)) {
                        this.ior.bJ(Boolean.valueOf(false));
                    } else {
                        this.ior.bJ(sVar.kAD);
                    }
                    com.tencent.mm.plugin.report.service.g.oUh.a(407, 26, 1, false);
                }
            } else {
                this.ior.bJ(Boolean.valueOf(false));
                com.tencent.mm.plugin.report.service.g.oUh.a(407, 25, 1, false);
            }
            return wCE;
        }
    }

    protected final void onCreate() {
        super.onCreate();
        e NL = this.ioF.NL();
        w.i("MicroMsg.AAGetPaylistDetailLogic", "init");
        ap.vd().a(1695, NL);
        ap.vd().a(1629, this.ioG.NS());
        this.ioH.NV().init();
    }

    protected final void onDestroy() {
        super.onDestroy();
        e NL = this.ioF.NL();
        w.i("MicroMsg.AAGetPaylistDetailLogic", "unInit");
        ap.vd().b(1695, NL);
        ap.vd().b(1629, this.ioG.NS());
        this.ioH.NV().NU();
    }
}
