package com.tencent.mm.plugin.e;

import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.j;

public final class a extends com.tencent.mm.plugin.mmsight.a.a {
    private d ivE;
    private VideoTransPara ivF;

    public static class a implements com.tencent.mm.plugin.mmsight.a.a.a {
        public final com.tencent.mm.plugin.mmsight.a.a Pl() {
            return new a();
        }
    }

    public final void a(com.tencent.mm.remoteservice.d dVar, VideoTransPara videoTransPara) {
        if (dVar != null) {
            CaptureMMProxy.createProxy(new CaptureMMProxy(dVar));
        }
        j.b(videoTransPara);
        this.ivF = videoTransPara;
    }

    public final d Pk() {
        if (this.ivF != null) {
            k.aLr();
            this.ivE = k.c(this.ivF);
        }
        return this.ivE;
    }
}
