package com.tencent.mm.plugin.bbom;

import com.tencent.mm.e.a.cx;
import com.tencent.mm.e.a.gu;
import com.tencent.mm.e.a.kg;
import com.tencent.mm.e.a.qf;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.protocal.c.ap;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.ba;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.x.b;

public final class a implements com.tencent.mm.plugin.auth.a.a {
    public final void a(f fVar, g gVar, boolean z) {
        if ((gVar.sZm.ugx & 2) != 0) {
            ap apVar = gVar.sZm.ugz;
            if (!z) {
                com.tencent.mm.u.ap.yY();
                c.eD(apVar.tdB);
            }
            ao.hlW.gf(b.hd(m.xL()));
            if (apVar.tdy != 0) {
                com.tencent.mm.u.ap.yY();
                c.wZ().bo(apVar.tdy + "@qqim", 3);
            }
            b.d((long) apVar.tdy, 3);
        } else {
            w.w("MicroMsg.BigBallAuthHandle", "summerauth updateProfile acctsect not set!");
        }
        n.gI(1);
        if (z) {
            com.tencent.mm.sdk.b.b guVar = new gu();
            guVar.fMf.fMg = false;
            com.tencent.mm.sdk.b.a.urY.m(guVar);
            guVar = new qf();
            guVar.fXk.fXl = true;
            com.tencent.mm.sdk.b.a.urY.m(guVar);
            return;
        }
        com.tencent.mm.u.ap.vL().D(new Runnable(this) {
            final /* synthetic */ a jPL;

            {
                this.jPL = r1;
            }

            public final void run() {
                ba.gp("ver" + d.sYN);
                an.aRs().bQ(com.tencent.mm.plugin.w.a.aRr().bDa());
                com.tencent.mm.sdk.b.a aVar = com.tencent.mm.sdk.b.a.urY;
                if (aVar == null) {
                    w.e("MicroMsg.BigBallAuthHandle", "EventPool is null.");
                    return;
                }
                com.tencent.mm.sdk.b.b guVar = new gu();
                guVar.fMf.fMg = true;
                aVar.m(guVar);
                guVar = new qf();
                guVar.fXk.fXl = true;
                aVar.m(guVar);
                aVar.m(new cx());
                aVar.m(new kg());
                q.Hy().gg(3);
                w.i("MicroMsg.BigBallAuthHandle", "summerbadcr triggerSync bgfg after manual auth");
            }

            public final String toString() {
                return super.toString() + "|onGYNetEnd2";
            }
        });
    }

    public final void a(y.b bVar, String str, int i, String str2, String str3, int i2) {
        ao.hlW.gf(b.hd(m.xL()));
        b.d((long) i, 3);
        com.tencent.mm.u.ap.yY();
        c.wZ().bo(bVar.taf.tSD, 2);
        if (i != 0) {
            com.tencent.mm.u.ap.yY();
            c.wZ().bo(i + "@qqim", 3);
        }
    }
}
