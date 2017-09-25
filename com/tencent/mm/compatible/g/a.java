package com.tencent.mm.compatible.g;

import com.tencent.mm.sdk.platformtools.w;

public final class a {
    public int fFG;
    public String gSl;
    public long gSm;
    public int gSn;

    public a() {
        this.gSl = null;
        this.gSm = -1;
        this.gSn = -1;
        this.fFG = -1;
        this.gSl = null;
        this.gSm = -1;
        this.gSn = -1;
        this.fFG = -1;
    }

    public final String rW() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.gSl);
        stringBuffer.append(",");
        stringBuffer.append(this.gSm);
        stringBuffer.append(",");
        stringBuffer.append(this.gSn);
        stringBuffer.append(",");
        stringBuffer.append(this.fFG);
        w.d("MicroMsg.AudioRecorderInfo", " getStatInfo " + stringBuffer.toString());
        return stringBuffer.toString();
    }
}
