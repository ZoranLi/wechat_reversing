package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.pb.common.b.a.a.aa;
import com.tencent.pb.common.b.d;

public final class g extends d {
    public String mwM;

    public final int getType() {
        return ag.CTRL_INDEX;
    }

    protected final Object bs(byte[] bArr) {
        com.tencent.pb.common.c.d.d("MicroMsg.Voip", this.wKV, "data2Resp");
        if (bArr == null) {
            return null;
        }
        try {
            return (aa) e.a(new aa(), bArr, bArr.length);
        } catch (Exception e) {
            com.tencent.pb.common.c.d.k(this.wKV, "data2Resp", e.getMessage());
            return null;
        }
    }

    protected final String ccP() {
        return "CsCmd.Cmd_V_CSModifyVoiceGroupInfoReq";
    }
}
