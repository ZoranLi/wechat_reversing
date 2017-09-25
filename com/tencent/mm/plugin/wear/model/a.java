package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.bj.g.c;
import com.tencent.mm.plugin.wear.model.e.e;
import com.tencent.mm.plugin.wear.model.e.f;
import com.tencent.mm.plugin.wear.model.e.g;
import com.tencent.mm.plugin.wear.model.e.h;
import com.tencent.mm.plugin.wear.model.e.k;
import com.tencent.mm.plugin.wear.model.e.l;
import com.tencent.mm.plugin.wear.model.e.m;
import com.tencent.mm.plugin.wear.model.e.n;
import com.tencent.mm.plugin.wear.model.e.o;
import com.tencent.mm.plugin.wear.model.e.q;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.g.b;
import com.tencent.mm.pluginsdk.l.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.d;
import java.util.HashMap;

public final class a implements am {
    q rTm;
    public r rTn;
    public d rTo;
    private e rTp;
    public g rTq;
    public b rTr;
    private WearMessageLogic rTs;
    private i rTt;
    public j rTu;
    public com.tencent.mm.plugin.wear.model.g.a rTv;
    private d rTw;

    public a() {
        w.i("MicroMsg.Wear.SubCoreWear", "Create SubCore, classLoader=%s", new Object[]{getClass().getClassLoader()});
    }

    public final HashMap<Integer, c> uh() {
        return null;
    }

    public static a bvG() {
        a aVar = (a) ap.yR().gs("plugin.wear");
        if (aVar != null) {
            return aVar;
        }
        Object aVar2 = new a();
        ap.yR().a("plugin.wear", aVar2);
        return aVar2;
    }

    public final void eD(int i) {
        w.i("MicroMsg.Wear.SubCoreWear", "clearPluginData, pluginFlag=%d", new Object[]{Integer.valueOf(i)});
    }

    public final void aM(boolean z) {
        ab.sBH = new c();
        w.i("MicroMsg.Wear.SubCoreWear", "onAccountPostReset, updated=%b", new Object[]{Boolean.valueOf(z)});
        this.rTm = new q();
        this.rTn = new r();
        this.rTu = new j();
        this.rTp = new e();
        this.rTq = new g();
        this.rTr = new b();
        this.rTo = new d();
        this.rTs = new WearMessageLogic();
        this.rTt = new i();
        this.rTv = new com.tencent.mm.plugin.wear.model.g.a();
        this.rTw = new b();
        d.c.a(Integer.valueOf(63), this.rTw);
        this.rTm.a(this.rTo.rTE);
        this.rTm.a(this.rTo.rTF);
        this.rTm.a(this.rTo.rTG);
        this.rTm.a(new h());
        this.rTm.a(new g());
        this.rTm.a(new com.tencent.mm.plugin.wear.model.e.d());
        this.rTm.a(new com.tencent.mm.plugin.wear.model.e.c());
        this.rTm.a(new e());
        this.rTm.a(new f());
        this.rTm.a(new k());
        this.rTm.a(new m());
        this.rTm.a(new o());
        this.rTm.a(new n());
        this.rTm.a(new l());
        this.rTu.a(new com.tencent.mm.plugin.wear.model.f.c(this) {
            final /* synthetic */ a rTx;

            {
                this.rTx = r1;
            }

            protected final void send() {
                r.a(20001, null, false);
                r.a(20008, null, false);
            }

            public final String getName() {
                return "PhoneStartTask";
            }
        });
        j jVar = this.rTu;
        AnonymousClass2 anonymousClass2 = new com.tencent.mm.plugin.wear.model.f.c(this) {
            final /* synthetic */ a rTx;

            {
                this.rTx = r1;
            }

            protected final void send() {
                this.rTx.rTo.bvM().bvV();
                r.a(20009, null, false);
                r.a(20017, null, false);
            }

            public final String getName() {
                return "SyncFileTask";
            }
        };
        if (jVar.kir != null) {
            jVar.kir.sendMessageDelayed(jVar.kir.obtainMessage(0, anonymousClass2), 5000);
        }
    }

    public final void aN(boolean z) {
        w.i("MicroMsg.Wear.SubCoreWear", "onSdcardMount, mounted=%b", new Object[]{Boolean.valueOf(z)});
    }

    public final void onAccountRelease() {
        d.c.aA(Integer.valueOf(63));
        this.rTw = null;
        w.i("MicroMsg.Wear.SubCoreWear", "onAccountRelease");
        this.rTm.rUG.clear();
        this.rTm = null;
        this.rTn = null;
        e eVar = this.rTp;
        eVar.irQ.KH();
        eVar.qrv.dead();
        eVar.rTK.dead();
        eVar.rTL.dead();
        eVar.rTM.dead();
        eVar.rTN.dead();
        eVar.rTO.dead();
        eVar.rTP.dead();
        eVar.gLi.dead();
        eVar.nod.dead();
        ap.yY();
        com.tencent.mm.u.c.wT().a(eVar.lpR);
        this.rTp = null;
        this.rTq = null;
        b bVar = this.rTr;
        com.tencent.mm.sdk.b.a.urY.c(bVar.rTz);
        ap.yY();
        com.tencent.mm.u.c.wR().b(bVar.maN);
        bVar.rTA.KH();
        this.rTr = null;
        d dVar = this.rTo;
        dVar.rTD.finish();
        dVar.rTH.reset();
        this.rTo = null;
        com.tencent.mm.sdk.platformtools.ab.getContext().unregisterReceiver(this.rTs);
        this.rTs = null;
        j jVar = this.rTu;
        if (jVar.handlerThread != null) {
            jVar.handlerThread.quit();
        }
        this.rTu = null;
        i iVar = this.rTt;
        iVar.gNq = null;
        iVar.bvQ();
        com.tencent.mm.sdk.platformtools.ab.getContext().unregisterReceiver(iVar.rUg);
        this.rTt = null;
    }
}
