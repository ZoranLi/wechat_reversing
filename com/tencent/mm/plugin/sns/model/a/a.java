package com.tencent.mm.plugin.sns.model.a;

import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.an;

public final class a {
    public String fFW = "";
    public String mediaId = "";
    public e pQM = null;
    public String pTT = "";
    public String pTX = "";
    public alh pTY;
    public an pYA;
    public boolean pYx = false;
    public boolean pYy = false;
    public int pYz = 0;
    public String url = "";

    public a(String str) {
        this.mediaId = str;
    }

    public final boolean init() {
        this.pTT = am.du(ae.getAccSnsPath(), this.mediaId);
        return true;
    }

    public final String bfv() {
        if (this.pYz == 4) {
            return i.p(this.pTY);
        }
        if (this.pYz == 6) {
            return i.q(this.pTY);
        }
        return this.pYx ? i.n(this.pTY) : i.m(this.pTY);
    }

    public final String getPath() {
        if (bg.mA(this.pTT)) {
            init();
        }
        return this.pTT;
    }
}
