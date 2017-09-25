package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.share.g;
import com.tencent.pb.common.b.a.a.ag;
import com.tencent.pb.common.b.a.a.j;
import com.tencent.pb.common.b.d;
import com.tencent.wecall.talkroom.model.c;

public final class h extends d {
    public String groupId;
    public int mNL;
    public long mNM;

    public h(String str, int i, long j, int i2) {
        com.tencent.pb.common.c.d.d("MicroMsg.Voip", this.wKV, "NetSceneRejectVoiceGroup");
        e jVar = new j();
        try {
            jVar.groupId = str;
            jVar.rhn = i;
            jVar.rho = j;
            jVar.mOs = i2;
            jVar.wLM = 2;
            this.mlJ = 3;
            this.wLa = c.chs().We(str);
        } catch (Exception e) {
            com.tencent.pb.common.c.d.k(this.wKV, "NetSceneRedirect constructor", e);
        }
        c(g.CTRL_INDEX, jVar);
    }

    public final int getType() {
        return g.CTRL_INDEX;
    }

    protected final Object bs(byte[] bArr) {
        com.tencent.pb.common.c.d.d("MicroMsg.Voip", this.wKV, "data2Resp");
        if (bArr == null) {
            return null;
        }
        try {
            return (ag) e.a(new ag(), bArr, bArr.length);
        } catch (Exception e) {
            com.tencent.pb.common.c.d.k(this.wKV, "data2Resp", e.getMessage());
            return null;
        }
    }

    protected final String ccP() {
        return "CsCmd.Cmd_V_CSVoiceRedirectReq";
    }
}
