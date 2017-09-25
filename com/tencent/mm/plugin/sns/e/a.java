package com.tencent.mm.plugin.sns.e;

import com.tencent.mm.e.a.oy;
import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.an;

public final class a implements b {
    public c pRm = new c<oy>(this) {
        final /* synthetic */ a pRn;

        {
            this.pRn = r2;
            this.usg = oy.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            oy oyVar = (oy) bVar;
            if (oyVar instanceof oy) {
                if (oyVar.fVU.fEG == 1) {
                    w.i("MicroMsg.FTS.FTSSnsImageDownloadLogic", "start do download id %s", new Object[]{oyVar.fVU.fVV.mQY});
                    e eVar = new e(oyVar.fVU.fVV);
                    eVar.pQS = 1;
                    eVar.nif = oyVar.fVU.fVV.mQY;
                    if (oyVar.fVU.fVV.jOc == 6) {
                        ae.beG().a(oyVar.fVU.fVV, 5, eVar, an.uJO);
                    } else {
                        ae.beG().a(oyVar.fVU.fVV, 1, eVar, an.uJO);
                    }
                } else if (oyVar.fVU.fEG == 3) {
                    String du = am.du(ae.getAccSnsPath(), oyVar.fVU.mediaId);
                    String EB = i.EB(oyVar.fVU.mediaId);
                    oyVar.fVU.path = du + EB;
                }
            }
            return false;
        }
    };

    public a() {
        com.tencent.mm.sdk.b.a.urY.b(this.pRm);
        ae.beG().a(this);
    }

    public final void ES(String str) {
        w.i("MicroMsg.FTS.FTSSnsImageDownloadLogic", "onThumbFinish mediaId=%s", new Object[]{str});
        com.tencent.mm.sdk.b.b oyVar = new oy();
        oyVar.fVU.fEG = 2;
        oyVar.fVU.mediaId = str;
        String du = am.du(ae.getAccSnsPath(), str);
        oyVar.fVU.path = du + i.EB(str);
        com.tencent.mm.sdk.b.a.urY.m(oyVar);
    }

    public final void ao(String str, boolean z) {
    }

    public final void bdD() {
    }

    public final void ap(String str, boolean z) {
    }
}
