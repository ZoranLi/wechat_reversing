package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.sdk.platformtools.w;

public final class p implements f {
    volatile int frameCount = 0;
    long jYB = 0;
    int lKi;
    boolean nCV;
    long nDD = 0;
    int nFK = -1;
    int nFL = -1;
    int nFM = -1;
    int nFN = -1;
    int nFO = -1;
    int neJ;

    public p(boolean z, int i, int i2, int i3) {
        this.nCV = z;
        this.nFL = i;
        this.neJ = i2;
        this.lKi = i3;
        w.i("MicroMsg.MMSightX264YUVRecorder", "create MMSightX264YUVRecorder, needRotateEachFrame: %s, initRotate: %s, targetWidth: %s, targetHeight: %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(this.nFL), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public final void stop() {
        this.frameCount = 0;
        this.jYB = 0;
    }

    public final long aLx() {
        if (0 != this.jYB) {
            return System.currentTimeMillis() - this.jYB;
        }
        w.w("MicroMsg.MMSightX264YUVRecorder", "do not start record");
        return 0;
    }
}
