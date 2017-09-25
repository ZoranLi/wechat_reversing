package com.tencent.mm.plugin.fps_lighter.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.fps_lighter.b.b;
import com.tencent.mm.plugin.fps_lighter.b.c;
import com.tencent.mm.plugin.fps_lighter.b.e;
import com.tencent.mm.plugin.fps_lighter.b.g;
import com.tencent.mm.sdk.platformtools.w;

public final class a implements c {
    private c lPk;
    private int lPl;
    private int lPm;
    private e lPn = g.avJ().lQk;

    public a(c cVar) {
        this.lPk = cVar;
    }

    public final void a(int i, long j, long j2, int i2, int i3, boolean z, long j3, boolean z2) {
        if (com.tencent.mm.plugin.fps_lighter.e.a.mE(i2) == com.tencent.mm.plugin.fps_lighter.e.a.a.BAD && !z) {
            w.i("MicroMsg.FrameAnalyseCallback", "Scene:%s pre:%s droppedFrames:%s isInputHandling:%s isOnCreateConsuming:%s", new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Boolean.valueOf(z2), Boolean.valueOf(z)});
            b bVar = g.avJ().lQj;
            long[] mainThreadBuffer = !this.lPn.fOV ? null : GMTrace.getMainThreadBuffer();
            long startTime = j2 - GMTrace.getStartTime();
            w.i("MicroMsg.FPSAnalyser", "[immediateExec] preIndex:%s,curIndex：%s droopedCount:%s previousFrameMS:%s scene:%s isOnCreateConsuming:%s", new Object[]{Integer.valueOf(this.lPl), Integer.valueOf(e.avH()), Long.valueOf((long) i2), Long.valueOf(j - GMTrace.getStartTime()), Integer.valueOf(i), Boolean.valueOf(z)});
            Runnable aVar = new com.tencent.mm.plugin.fps_lighter.d.a(mainThreadBuffer, r4, r5, r6, r8, startTime, i3, i, z, j3, z2);
            aVar.lQK = bVar;
            g.avJ();
            g.MM().post(aVar);
        }
        this.lPl = this.lPm;
        this.lPm = this.lPn.lPT;
        this.lPn.avI();
    }

    public final void H(int i, boolean z) {
        if (i == Integer.MAX_VALUE) {
            if (z) {
                e eVar = g.avJ().lQk;
                if (!eVar.fOV) {
                    if (!GMTrace.isInit()) {
                        GMTrace.init(true);
                    }
                    GMTrace.startTrace();
                    eVar.lPT = GMTrace.getMainThreadIndex();
                    w.i("MicroMsg.FpsGMTraceHandler", "[startTrace] start:%s", new Object[]{Integer.valueOf(eVar.lPT)});
                    eVar.fOV = true;
                }
            } else {
                g.avJ().lQk.stopTrace();
            }
        }
        this.lPl = this.lPm;
        this.lPm = this.lPn.lPT;
        this.lPn.avI();
    }

    public final String toString() {
        return "MicroMsg.FrameAnalyseCallback";
    }
}
