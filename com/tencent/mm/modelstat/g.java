package com.tencent.mm.modelstat;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class g {
    long beginTime;
    long endTime;
    boolean fZK;
    long hWh;
    long hWi;
    long hWj;
    int rtType;

    public g(int i, boolean z, long j) {
        this.rtType = i;
        this.fZK = z;
        this.hWh = j;
        this.hWi = 0;
    }

    public final void Ka() {
        if (this.hWi == 0) {
            this.beginTime = bg.Nz();
            this.hWj = bg.NA();
        }
        this.hWi++;
    }

    public final void ar(long j) {
        if (this.hWh == 0) {
            this.hWh = j;
        }
        this.hWj = bg.NA() - this.hWj;
        this.endTime = bg.Nz();
        w.d("MicroMsg.MultiSceneStat", "FIN: TIME:" + (this.endTime - this.beginTime) + " datalen:" + this.hWh + " Count:" + this.hWi + " type:" + this.rtType);
        WatchDogPushReceiver.a(this);
    }
}
