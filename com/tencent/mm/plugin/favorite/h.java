package com.tencent.mm.plugin.favorite;

import android.content.Context;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.bj.g;
import com.tencent.mm.e.a.fn;
import com.tencent.mm.e.a.pt;
import com.tencent.mm.e.b.eb;
import com.tencent.mm.plugin.favorite.b.ab;
import com.tencent.mm.plugin.favorite.b.e;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.b.k;
import com.tencent.mm.plugin.favorite.b.l;
import com.tencent.mm.plugin.favorite.b.p;
import com.tencent.mm.plugin.favorite.b.t;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.plugin.favorite.c.d;
import com.tencent.mm.plugin.favorite.c.f;
import com.tencent.mm.pluginsdk.ui.applet.d.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.wcdb.FileUtils;
import java.io.File;
import java.util.HashMap;

public final class h implements am {
    private e lDA;
    private f lDB;
    private d lDC;
    private t lDD;
    private a lDE = new a();
    private b lDF = new b();
    private f lDG = new f();
    private e lDH = new e();
    private g lDI = new g();
    private d lDJ = new d();
    public eb lDK = null;
    private l lDL;
    private volatile boolean lDM = false;
    private byte[] lDN = new byte[0];
    private c lDO = new c<fn>(this) {
        final /* synthetic */ h lDQ;

        {
            this.lDQ = r2;
            this.usg = fn.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            fn fnVar = (fn) bVar;
            if (fnVar != null && (fnVar instanceof fn)) {
                if (fnVar.fKl.fKm != null && (fnVar.fKl.fKm instanceof a) && fnVar.fKl.fDi != null && (fnVar.fKl.fDi instanceof Context)) {
                    j bT = h.ata().bT(fnVar.fKl.fFx);
                    a aVar = (a) fnVar.fKl.fKm;
                    Context context = (Context) fnVar.fKl.fDi;
                    com.tencent.mm.plugin.favorite.ui.c.e.a(aVar, context, bT);
                    com.tencent.mm.plugin.favorite.ui.c.e.b(aVar, context, bT);
                }
                fnVar.fKl.fFx = 0;
                fnVar.fKl.fKm = null;
                fnVar.fKl.fDi = null;
            }
            return false;
        }
    };
    private c lDP = new c<pt>(this) {
        final /* synthetic */ h lDQ;

        {
            this.lDQ = r2;
            this.usg = pt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            w.i("MicroMsg.StartFavServiceListener", "runService");
            h.asR().run();
            h.asU().run();
            h.asQ().run();
            h.asS().run();
            h.asY().run();
            return false;
        }
    };
    private k lDt;
    private com.tencent.mm.plugin.favorite.b.b lDu;
    private com.tencent.mm.plugin.favorite.c.h lDv;
    private com.tencent.mm.plugin.favorite.c.c lDw;
    private com.tencent.mm.plugin.favorite.c.b lDx;
    private p lDy;
    private com.tencent.mm.plugin.favorite.b.h lDz;

    public static h asP() {
        h hVar = (h) ap.yR().gs("plugin.favorite");
        if (hVar == null) {
            hVar = new h();
            ap.yR().a("plugin.favorite", hVar);
        }
        if (hVar.lDM) {
            w.w("MicroMsg.SubCoreFav", "getCore need reset DB now, befor synchronized %b", new Object[]{Boolean.valueOf(hVar.lDM)});
            synchronized (hVar.lDN) {
                if (hVar.lDM) {
                    hVar.lDK = eb.pO();
                    hVar.lDM = false;
                }
                w.i("MicroMsg.SubCoreFav", "getCore need reset DB now, after synchronized %b", new Object[]{Boolean.valueOf(hVar.lDM)});
            }
        }
        return hVar;
    }

    public static com.tencent.mm.plugin.favorite.c.h asQ() {
        if (ap.zb()) {
            if (asP().lDv == null) {
                asP().lDv = new com.tencent.mm.plugin.favorite.c.h();
            }
            return asP().lDv;
        }
        throw new com.tencent.mm.u.b();
    }

    public static com.tencent.mm.plugin.favorite.c.b asR() {
        if (ap.zb()) {
            if (asP().lDx == null) {
                asP().lDx = new com.tencent.mm.plugin.favorite.c.b();
            }
            return asP().lDx;
        }
        throw new com.tencent.mm.u.b();
    }

    public static f asS() {
        if (ap.zb()) {
            if (asP().lDB == null) {
                asP().lDB = new f();
            }
            return asP().lDB;
        }
        throw new com.tencent.mm.u.b();
    }

    public static t asT() {
        if (ap.zb()) {
            if (asP().lDD == null) {
                asP().lDD = new t();
            }
            return asP().lDD;
        }
        throw new com.tencent.mm.u.b();
    }

    public static com.tencent.mm.plugin.favorite.c.c asU() {
        if (ap.zb()) {
            if (asP().lDw == null) {
                asP().lDw = new com.tencent.mm.plugin.favorite.c.c();
            }
            return asP().lDw;
        }
        throw new com.tencent.mm.u.b();
    }

    public static com.tencent.mm.plugin.favorite.b.b asV() {
        if (ap.zb()) {
            if (asP().lDu == null) {
                asP().lDu = new com.tencent.mm.plugin.favorite.b.b(asP().lDK);
            }
            return asP().lDu;
        }
        throw new com.tencent.mm.u.b();
    }

    public static com.tencent.mm.plugin.favorite.b.h asW() {
        if (ap.zb()) {
            if (asP().lDz == null) {
                asP().lDz = new com.tencent.mm.plugin.favorite.b.h(asP().lDK);
            }
            return asP().lDz;
        }
        throw new com.tencent.mm.u.b();
    }

    public static e asX() {
        if (ap.zb()) {
            if (asP().lDA == null) {
                asP().lDA = new e(asP().lDK);
            }
            return asP().lDA;
        }
        throw new com.tencent.mm.u.b();
    }

    public static d asY() {
        if (ap.zb()) {
            if (asP().lDC == null) {
                asP().lDC = new d();
            }
            return asP().lDC;
        }
        throw new com.tencent.mm.u.b();
    }

    public static p asZ() {
        if (ap.zb()) {
            if (asP().lDy == null) {
                asP().lDy = new p(asP().lDK);
            }
            return asP().lDy;
        }
        throw new com.tencent.mm.u.b();
    }

    public static k ata() {
        if (ap.zb()) {
            if (asP().lDt == null) {
                asP().lDt = new k(asP().lDK);
            }
            return asP().lDt;
        }
        throw new com.tencent.mm.u.b();
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        w.i("MicroMsg.SubCoreFav", "onAccountPostReset updated:%b", new Object[]{Boolean.valueOf(z)});
        this.lDM = true;
        com.tencent.mm.sdk.b.a.urY.b(this.lDE);
        com.tencent.mm.sdk.b.a.urY.b(this.lDF);
        com.tencent.mm.sdk.b.a.urY.b(this.lDH);
        com.tencent.mm.sdk.b.a.urY.b(this.lDG);
        com.tencent.mm.sdk.b.a.urY.b(this.lDP);
        com.tencent.mm.sdk.b.a.urY.b(this.lDI);
        com.tencent.mm.sdk.b.a.urY.b(this.lDJ);
        com.tencent.mm.sdk.b.a.urY.a(this.lDO);
        File file = new File(x.atx());
        if (!(file.exists() && file.isDirectory())) {
            w.d("MicroMsg.SubCoreFav", "fav root dir not exists, try to make it");
            file.mkdirs();
        }
        file = new File(x.aty());
        if (!(file.exists() && file.isDirectory())) {
            w.d("MicroMsg.SubCoreFav", "fav web dir not exists, try to make it");
            file.mkdirs();
        }
        file = new File(x.atA());
        if (!(file.exists() && file.isDirectory())) {
            w.d("MicroMsg.SubCoreFav", "fav attach dir not exists, try to make it");
            file.mkdirs();
        }
        file = new File(x.atz());
        if (!(file.exists() && file.isDirectory())) {
            w.d("MicroMsg.SubCoreFav", "fav voice dir not exists, try to make it");
            file.mkdirs();
        }
        this.lDL = new l();
        asV().a(this.lDL);
        ata().c(this.lDL);
        ((com.tencent.mm.plugin.fts.a.l) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.fts.a.l.class)).registerIndexStorage(new com.tencent.mm.plugin.favorite.a.a());
        ((com.tencent.mm.plugin.fts.a.l) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.fts.a.l.class)).registerNativeLogic(6, new com.tencent.mm.plugin.favorite.a.b());
        com.tencent.mm.plugin.fts.d.h.a(new com.tencent.mm.plugin.favorite.ui.b.d());
        com.tencent.mm.plugin.fts.d.h.a(new com.tencent.mm.plugin.favorite.ui.b.b());
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
        this.lDM = false;
        com.tencent.mm.sdk.b.a.urY.c(this.lDE);
        com.tencent.mm.sdk.b.a.urY.c(this.lDF);
        com.tencent.mm.sdk.b.a.urY.c(this.lDH);
        com.tencent.mm.sdk.b.a.urY.c(this.lDP);
        com.tencent.mm.sdk.b.a.urY.c(this.lDG);
        com.tencent.mm.sdk.b.a.urY.c(this.lDI);
        com.tencent.mm.sdk.b.a.urY.c(this.lDJ);
        com.tencent.mm.sdk.b.a.urY.c(this.lDO);
        ((com.tencent.mm.plugin.fts.a.l) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.fts.a.l.class)).unregisterIndexStorage(256);
        ((com.tencent.mm.plugin.fts.a.l) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.fts.a.l.class)).unregisterNativeLogic(6);
        com.tencent.mm.plugin.fts.d.h.mV(FileUtils.S_IWUSR);
        com.tencent.mm.plugin.fts.d.h.mV(4176);
        asV().b(this.lDL);
        ata().f(this.lDL);
        this.lDL = null;
        com.tencent.mm.plugin.favorite.c.c asU = asU();
        asU.pr();
        asU.fBt.KH();
        asU.fBo = 0;
        ap.b(asU.hyk);
        Object asR = asR();
        asR.pr();
        asR.fBt.KH();
        ap.vd().b(TencentLocation.ERROR_UNKNOWN, asR);
        ap.b(asR.hyk);
        com.tencent.mm.y.e asQ = asQ();
        asQ.pr();
        asQ.fBt.KH();
        asQ.fBo = 0;
        ap.vd().b(401, asQ);
        asQ = asS();
        asQ.pr();
        asQ.fBt.KH();
        asQ.fBo = 0;
        ap.vd().b(426, asQ);
        asR = asY();
        ap.vd().b(426, asR);
        ap.vd().b(401, asR);
        asR.lGd.clear();
        ab.atO();
        if (this.lDK != null) {
            this.lDK.wL();
        }
    }

    public final HashMap<Integer, g.c> uh() {
        return null;
    }
}
