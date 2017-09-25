package com.tencent.mm.plugin.facedetect.model;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.e.a.hd;
import com.tencent.mm.e.a.hd.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;

public final class j extends c<hd> {
    public j() {
        this.usg = hd.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean z = false;
        hd hdVar = (hd) bVar;
        if (hdVar == null) {
            w.e("MicroMsg.FaceGetIsSupportListener", "hy: event is null");
            return false;
        }
        f fVar = f.lvS;
        boolean arF = f.arF();
        f fVar2 = f.lvS;
        boolean arG = f.arG();
        if (!arF) {
            hdVar.fMz.fMB = CdnLogic.MediaType_FAVORITE_FILE;
            hdVar.fMz.fMC = "No front camera";
        } else if (arG) {
            hdVar.fMz.fMC = "ok";
        } else {
            hdVar.fMz.fMB = CdnLogic.MediaType_FAVORITE_VIDEO;
            hdVar.fMz.fMC = "No necessary model found";
        }
        a aVar = hdVar.fMz;
        f fVar3 = f.lvS;
        aVar.fMD = f.arJ();
        aVar = hdVar.fMz;
        if (arF && arG) {
            z = true;
        }
        aVar.fMA = z;
        return true;
    }
}
