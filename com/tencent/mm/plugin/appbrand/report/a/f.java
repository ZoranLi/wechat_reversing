package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.mm.plugin.appbrand.h;

public final class f {
    public String appId;
    public int fCM;
    public String fFF;
    public int fWF;
    public final h ixi;
    public volatile long jgN;
    public volatile boolean jgO = false;
    public int jgP;
    public int jgQ;
    public long jgR;
    public long jgS;
    public String jgl;
    public int scene;

    public f(h hVar) {
        this.ixi = hVar;
    }

    public final String toString() {
        return "kv_14576{, networkType='" + this.jgl + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.fWF + ", appState=" + this.fCM + ", scene=" + this.scene + ", sessionId='" + this.fFF + '\'' + ", is_download_code=" + this.jgP + ", is_load_x5=" + this.jgQ + ", cost_time=" + this.jgR + ", event_time=" + this.jgS + '}';
    }
}
