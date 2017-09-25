package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.aq;
import com.tencent.pb.common.b.a.a.z;
import com.tencent.pb.common.b.d;
import com.tencent.wecall.talkroom.model.c;

public final class f extends d {
    public f(String str, int i, long j, int i2) {
        com.tencent.pb.common.c.d.d("MicroMsg.Voip", this.wKV, "eixt", str, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2));
        e fVar = new com.tencent.pb.common.b.a.a.f();
        try {
            fVar.groupId = str;
            fVar.rhn = i;
            fVar.rho = j;
            fVar.fOl = i2;
            this.mlJ = 2;
            this.wLa = c.chs().We(str);
        } catch (Exception e) {
            com.tencent.pb.common.c.d.k(this.wKV, "NetSceneExitVoiceRoom constructor", e);
        }
        c(143, fVar);
    }

    public final int getType() {
        return aq.CTRL_INDEX;
    }

    protected final Object bs(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return (z) e.a(new z(), bArr, bArr.length);
        } catch (Exception e) {
            com.tencent.pb.common.c.d.k(this.wKV, "data2Resp", e.getMessage());
            return null;
        }
    }

    protected final String ccP() {
        return "CsCmd.Cmd_V_CSExitVoiceRoomReq";
    }
}
