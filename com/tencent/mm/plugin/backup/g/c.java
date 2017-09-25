package com.tencent.mm.plugin.backup.g;

import com.tencent.mm.ap.b;
import com.tencent.mm.ap.n;
import com.tencent.mm.av.m;
import com.tencent.mm.bj.g;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelbiz.d;
import com.tencent.mm.modelstat.l;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.plugin.chatroom.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.aa;

public final class c {
    private String cachePath;
    String gYf;
    public g gYg = null;
    private t gYi;
    private ba gYj;
    private b hOt;
    private s hZU;
    private d hwj;
    private u icg;
    public f jIA;
    aa jIB;
    private m jIC;
    private com.tencent.mm.x.g jID;
    private l jIE;
    private n jIF;
    public k jIG;
    public i jIH;
    private com.tencent.mm.pluginsdk.model.app.c jII;
    public com.tencent.mm.bj.f jIJ = null;
    public Boolean jIK = null;
    private ar jIv;
    private com.tencent.mm.plugin.messenger.foundation.a.a.c jIw;
    private as jIx;
    private com.tencent.mm.ah.f jIy;
    private com.tencent.mm.storage.a.f jIz;
    public int uin = 0;

    public final void k(String str, String str2, int i) {
        w.i("MicroMsg.TempStorage", "accPath %s, cachePath %s, accUin:%d", new Object[]{str, str2, Integer.valueOf(i)});
        this.uin = i;
        this.gYf = str;
        this.cachePath = str2;
    }

    final void abJ() {
        this.gYi = new t(this.gYg);
        com.tencent.mm.plugin.messenger.foundation.a.i iVar = (com.tencent.mm.plugin.messenger.foundation.a.i) h.h(com.tencent.mm.plugin.messenger.foundation.a.i.class);
        this.jIv = iVar.d(this.gYg);
        this.jIx = iVar.e(this.gYg);
        this.jIw = iVar.a(this.gYg, this.jIv, this.jIx);
        this.jIw.a(new am(this.jIw));
        this.jIw.a(new o(this.jIw));
        this.jIA = iVar.f(this.gYg);
        this.jIy = new com.tencent.mm.ah.f(this.gYg);
        if (com.tencent.mm.bb.d.Jt("emoji")) {
            this.jIz = new com.tencent.mm.storage.a.f(this.gYg);
        }
        this.jIB = ((a) h.h(a.class)).c(this.gYg);
        this.jID = new com.tencent.mm.x.g(this.gYg);
        this.icg = new u(this.gYg);
        this.hZU = new s(this.gYg);
        this.jIC = new m(this.gYg);
        this.jIE = new l(this.gYg);
        this.jIF = new n(this.gYg);
        this.hOt = new b(this.gYg);
        this.jIG = new k(this.gYg);
        this.jIH = new i(this.gYg);
        this.jII = new com.tencent.mm.pluginsdk.model.app.c(this.gYg);
        this.hwj = new d(this.gYg);
        this.gYj = new ba(this.gYi);
        this.gYj.c(new j.a(this) {
            final /* synthetic */ c jIL;

            {
                this.jIL = r1;
            }

            public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
                p.du(str);
            }
        });
        this.gYj.bMT();
    }

    public final void wL() {
        w.i("MicroMsg.TempStorage", "closeDB isTempDb:%s datadb:%s memdb:%s %s", new Object[]{this.jIK, this.gYg, this.jIJ, bg.bJZ()});
        if (this.jIK == null || this.jIK.booleanValue()) {
            if (this.gYg != null) {
                w.i("MicroMsg.TempStorage", "closeDB true DB[%s]!!! ", new Object[]{this.gYg});
                this.gYg.wL();
                this.gYg = null;
            }
            if (this.jIJ != null) {
                com.tencent.mm.bj.f fVar = this.jIJ;
                com.tencent.mm.bj.f.uLT = bg.bJZ().toString();
                if (fVar.uLy != null) {
                    fVar.uLy.close();
                    fVar.uLy = null;
                }
                this.jIJ = null;
            }
            this.jIK = null;
            return;
        }
        this.jIK = null;
    }

    public final t vr() {
        if (this.uin != 0) {
            return this.gYi;
        }
        throw new com.tencent.mm.u.b();
    }

    public final ar wR() {
        if (this.uin != 0) {
            return this.jIv;
        }
        throw new com.tencent.mm.u.b();
    }

    public final com.tencent.mm.plugin.messenger.foundation.a.a.c wT() {
        if (this.uin != 0) {
            return this.jIw;
        }
        throw new com.tencent.mm.u.b();
    }

    public final as wW() {
        if (this.uin != 0) {
            return this.jIx;
        }
        throw new com.tencent.mm.u.b();
    }

    public final com.tencent.mm.ah.f GS() {
        if (this.uin != 0) {
            return this.jIy;
        }
        throw new com.tencent.mm.u.b();
    }

    public final com.tencent.mm.storage.a.f abK() {
        if (this.uin != 0) {
            return this.jIz;
        }
        throw new com.tencent.mm.u.b();
    }

    public final s KV() {
        if (this.uin != 0) {
            return this.hZU;
        }
        throw new com.tencent.mm.u.b();
    }

    public final String xi() {
        if (this.uin != 0) {
            return this.gYf + "emoji/";
        }
        throw new com.tencent.mm.u.b();
    }

    public final com.tencent.mm.pluginsdk.model.app.c abL() {
        if (this.uin != 0) {
            return this.jII;
        }
        throw new com.tencent.mm.u.b();
    }
}
