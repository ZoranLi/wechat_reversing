package com.tencent.mm.plugin.sight.base;

import com.tencent.mm.sdk.platformtools.bg;

public final class a {
    public int height = 0;
    public int hzL = 0;
    public int hzY = 0;
    public int lMh = 0;
    public int nFY = 0;
    public int ptw = 0;
    public int width = 0;

    public final int bbO() {
        return bg.ex((long) this.lMh);
    }

    public final String toString() {
        return "[ videoDuration: " + this.lMh + " videoBitrate: " + this.hzY + " width: " + this.width + " height: " + this.height + " frameRate: " + this.nFY + " audioChannel: " + this.ptw + " audioBitrate: " + this.hzL + "]";
    }
}
