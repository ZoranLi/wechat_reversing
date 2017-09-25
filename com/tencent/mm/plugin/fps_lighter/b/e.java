package com.tencent.mm.plugin.fps_lighter.b;

import com.tencent.gmtrace.GMTrace;
import com.tencent.gmtrace.GMTraceHandler;
import com.tencent.mm.sdk.platformtools.w;
import java.util.List;

public final class e extends GMTraceHandler {
    public boolean fOV = false;
    public int lPT;
    private int lPU;
    c lPV;

    public e(c cVar) {
        this.lPV = cVar;
    }

    public final void stopTrace() {
        if (this.fOV) {
            GMTrace.stopTrace();
            this.lPU = GMTrace.getMainThreadIndex();
            w.i("MicroMsg.FpsGMTraceHandler", "[stopTrace] start:%s end:%s", new Object[]{Integer.valueOf(this.lPT), Integer.valueOf(this.lPU)});
            this.fOV = false;
        }
    }

    public static int avH() {
        return GMTrace.getMainThreadIndex();
    }

    public final void avI() {
        if (this.fOV) {
            this.lPT = GMTrace.getMainThreadIndex();
        } else {
            w.e("MicroMsg.FpsGMTraceHandler", "its never start!");
        }
    }

    public final List<Integer> getPointId() {
        return null;
    }

    public final void syncDo(int i, long j) {
    }

    public final void postBufferData(boolean z) {
    }
}
