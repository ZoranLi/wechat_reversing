package com.tencent.mm.plugin.mmsight;

import com.tencent.mm.bj.g;
import com.tencent.mm.e.a.ox;
import com.tencent.mm.e.a.pg;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.x.a;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.l;
import com.tencent.mm.plugin.mmsight.model.m;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import java.util.HashMap;

public class e implements am {
    private m nAM = new m();
    private c nAN = new c<ox>(this) {
        final /* synthetic */ e nAP;

        {
            this.nAP = r2;
            this.usg = ox.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ox oxVar = (ox) bVar;
            oxVar.fVS.result = d.kE(oxVar.fVR.fVT);
            return true;
        }
    };
    private c nAO = new c<pg>(this) {
        final /* synthetic */ e nAP;

        {
            this.nAP = r2;
            this.usg = pg.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            pg pgVar = (pg) bVar;
            if (l.a(pgVar.fWg.fVT, d.Eu().Ew(), pgVar.fWg.fWi, pgVar.fWg.fWk)) {
                pgVar.fWg.fWj.run();
                pgVar.fWh.result = l.b(pgVar.fWg.fVT, d.Eu().Ew(), pgVar.fWg.fWi, pgVar.fWg.fWk);
            } else {
                pgVar.fWh.result = 1;
            }
            return false;
        }
    };

    public final HashMap<Integer, g.c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        a La = o.La();
        m mVar = this.nAM;
        w.j("MicroMsg.VideoService", "addVideoMsgSendCallback %s", new Object[]{mVar});
        if (!(mVar == null || La.iaW == null || La.iaW.contains(mVar))) {
            La.iaW.add(mVar);
        }
        com.tencent.mm.sdk.b.a.urY.a(this.nAO);
        com.tencent.mm.sdk.b.a.urY.b(this.nAN);
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
        a La = o.La();
        m mVar = this.nAM;
        if (!(mVar == null || La.iaW == null)) {
            La.iaW.remove(mVar);
        }
        com.tencent.mm.sdk.b.a.urY.c(this.nAO);
        j.nEA.wl();
        com.tencent.mm.sdk.b.a.urY.c(this.nAN);
    }
}
