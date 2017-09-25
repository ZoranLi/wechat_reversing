package com.tencent.mm.plugin.tmassistant.a;

import com.tencent.mm.bj.g;
import com.tencent.mm.e.a.fu;
import com.tencent.mm.e.a.fw;
import com.tencent.mm.e.a.fx;
import com.tencent.mm.e.a.fy;
import com.tencent.mm.e.a.fz;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.u.am;
import java.util.HashMap;

public final class b implements am {
    private a raD;
    private c raE = new c<fu>(this) {
        final /* synthetic */ b raJ;

        {
            this.raJ = r2;
            this.usg = fu.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            fu fuVar = (fu) bVar;
            a bok = this.raJ.bok();
            a aVar = new a();
            aVar.tL(fuVar.fKQ.fKS);
            aVar.tM(fuVar.fKQ.fKT);
            aVar.be(fuVar.fKQ.fileSize);
            aVar.tN(fuVar.fKQ.fyF);
            aVar.tO(fuVar.fKQ.fKU);
            aVar.la(fuVar.fKQ.fileType);
            aVar.setAppId(fuVar.fKQ.appId);
            aVar.dn(fuVar.fKQ.fKV);
            aVar.do(fuVar.fKQ.fKW);
            aVar.kHa.kGY = fuVar.fKQ.fKX;
            aVar.bl(fuVar.fKQ.packageName);
            aVar.dp(fuVar.fKQ.fKY);
            aVar.kc(fuVar.fKQ.scene);
            fuVar.fKR.fCw = bok.a(aVar.kHa);
            return true;
        }
    };
    private c raF = new c<fy>(this) {
        final /* synthetic */ b raJ;

        {
            this.raJ = r2;
            this.usg = fy.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            fy fyVar = (fy) bVar;
            fyVar.fLj.count = this.raJ.bok().aT(fyVar.fLi.fCw);
            return true;
        }
    };
    private c raG = new c<fx>(this) {
        final /* synthetic */ b raJ;

        {
            this.raJ = r2;
            this.usg = fx.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            fx fxVar = (fx) bVar;
            FileDownloadTaskInfo aU = this.raJ.bok().aU(fxVar.fLe.fCw);
            fxVar.fLf.url = aU.url;
            fxVar.fLf.status = aU.status;
            fxVar.fLf.path = aU.path;
            fxVar.fLf.fFW = aU.fFW;
            fxVar.fLf.fLg = aU.fLg;
            fxVar.fLf.fLh = aU.fLh;
            return true;
        }
    };
    private c raH = new c<fw>(this) {
        final /* synthetic */ b raJ;

        {
            this.raJ = r2;
            this.usg = fw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            fw fwVar = (fw) bVar;
            fwVar.fLd.fDU = this.raJ.bok().aV(fwVar.fLc.fCw);
            return true;
        }
    };
    private c raI = new c<fz>(this) {
        final /* synthetic */ b raJ;

        {
            this.raJ = r2;
            this.usg = fz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            fz fzVar = (fz) bVar;
            fzVar.fLl.fDU = this.raJ.bok().aW(fzVar.fLk.fCw);
            return true;
        }
    };

    public final a bok() {
        if (this.raD == null) {
            this.raD = new a();
        }
        return this.raD;
    }

    public final void aM(boolean z) {
        com.tencent.mm.sdk.b.a.urY.b(this.raE);
        com.tencent.mm.sdk.b.a.urY.b(this.raF);
        com.tencent.mm.sdk.b.a.urY.b(this.raG);
        com.tencent.mm.sdk.b.a.urY.b(this.raH);
        com.tencent.mm.sdk.b.a.urY.b(this.raI);
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.urY.c(this.raE);
        com.tencent.mm.sdk.b.a.urY.c(this.raF);
        com.tencent.mm.sdk.b.a.urY.c(this.raG);
        com.tencent.mm.sdk.b.a.urY.c(this.raH);
        com.tencent.mm.sdk.b.a.urY.c(this.raI);
    }

    public final HashMap<Integer, g.c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aN(boolean z) {
    }
}
