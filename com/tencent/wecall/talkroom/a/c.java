package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.pb.common.b.a.a.b;
import com.tencent.pb.common.b.a.a.w;
import com.tencent.pb.common.b.d;

public final class c extends d {
    public c(String str, int i, int i2) {
        com.tencent.pb.common.c.d.d("MicroMsg.Voip", this.wKV, "NetSceneCancelCreateVoiceGroup");
        e bVar = new b();
        try {
            bVar.wLG = str;
            bVar.fOl = i;
            this.mlJ = 3;
            this.wLa = i2;
        } catch (Exception e) {
            com.tencent.pb.common.c.d.k(this.wKV, "NetSceneCancelCreateVoiceGroup constructor", e);
        }
        c(183, bVar);
    }

    public final int getType() {
        return bv.CTRL_INDEX;
    }

    protected final Object bs(byte[] bArr) {
        com.tencent.pb.common.c.d.d("MicroMsg.Voip", this.wKV, "data2Resp");
        if (bArr == null) {
            return null;
        }
        try {
            return (w) e.a(new w(), bArr, bArr.length);
        } catch (Exception e) {
            com.tencent.pb.common.c.d.k(this.wKV, "data2Resp", e.getMessage());
            return null;
        }
    }

    protected final String ccP() {
        return "CsCmd.Cmd_V_CSCancelCreateVoiceGroupReq";
    }
}
