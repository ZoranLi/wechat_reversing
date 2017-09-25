package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.e.a.fu;
import com.tencent.mm.e.a.fv;
import com.tencent.mm.e.a.fw;
import com.tencent.mm.e.a.fx;
import com.tencent.mm.e.a.fy;
import com.tencent.mm.e.a.fz;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

final class k extends i {
    private c hoT = new c<fv>(this) {
        final /* synthetic */ k kHk;

        {
            this.kHk = r2;
            this.usg = fv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            fv fvVar = (fv) bVar;
            switch (fvVar.fKZ.fLa) {
                case 1:
                    this.kHk.kGM.h(fvVar.fKZ.id, fvVar.fKZ.path);
                    break;
                case 2:
                    this.kHk.kGM.aY(fvVar.fKZ.id);
                    break;
                case 4:
                    this.kHk.kGM.c(fvVar.fKZ.id, fvVar.fKZ.errCode, fvVar.fKZ.fLb);
                    break;
                case 5:
                    this.kHk.kGM.aX(fvVar.fKZ.id);
                    break;
                case 6:
                    this.kHk.kGM.i(fvVar.fKZ.id, fvVar.fKZ.path);
                    break;
                case 7:
                    this.kHk.kGM.aZ(fvVar.fKZ.id);
                    break;
                case 101:
                    e akM = e.akM();
                    akM.kGG = akM.akO();
                    break;
            }
            return true;
        }
    };

    public k(b bVar) {
        super(bVar);
        a.urY.b(this.hoT);
    }

    public final long a(f fVar) {
        b fuVar = new fu();
        fuVar.fKQ.fKS = fVar.iyZ;
        fuVar.fKQ.fKT = fVar.kGS;
        fuVar.fKQ.fileSize = fVar.kGT;
        fuVar.fKQ.fyF = fVar.mFileName;
        fuVar.fKQ.fKU = fVar.kGU;
        fuVar.fKQ.fileType = fVar.kGV;
        fuVar.fKQ.appId = fVar.ivH;
        fuVar.fKQ.fKV = fVar.kGW;
        fuVar.fKQ.fKW = fVar.kGX;
        fuVar.fKQ.fKX = fVar.kGY;
        fuVar.fKQ.packageName = fVar.fwY;
        fuVar.fKQ.fKY = fVar.kGZ;
        fuVar.fKQ.scene = fVar.hPi;
        a.urY.m(fuVar);
        return fuVar.fKR.fCw;
    }

    public final int aT(long j) {
        b fyVar = new fy();
        fyVar.fLi.fCw = j;
        a.urY.m(fyVar);
        return fyVar.fLj.count;
    }

    public final FileDownloadTaskInfo aU(long j) {
        b fxVar = new fx();
        fxVar.fLe.fCw = j;
        a.urY.m(fxVar);
        FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
        fileDownloadTaskInfo.id = j;
        fileDownloadTaskInfo.url = fxVar.fLf.url;
        fileDownloadTaskInfo.status = fxVar.fLf.status;
        fileDownloadTaskInfo.path = fxVar.fLf.path;
        fileDownloadTaskInfo.fFW = fxVar.fLf.fFW;
        fileDownloadTaskInfo.fLg = fxVar.fLf.fLg;
        fileDownloadTaskInfo.fLh = fxVar.fLf.fLh;
        return fileDownloadTaskInfo;
    }

    public final boolean aV(long j) {
        b fwVar = new fw();
        fwVar.fLc.fCw = j;
        a.urY.m(fwVar);
        return fwVar.fLd.fDU;
    }

    public final boolean aW(long j) {
        b fzVar = new fz();
        fzVar.fLk.fCw = j;
        a.urY.m(fzVar);
        return fzVar.fLl.fDU;
    }
}
