package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.ab;
import com.tencent.pb.common.b.a.a.g;
import com.tencent.pb.common.b.d;
import com.tencent.wecall.talkroom.model.c;

public final class i extends d {
    public i(String str, int i, long j, int i2) {
        com.tencent.pb.common.c.d.d("MicroMsg.Voip", this.wKV, "NetSceneRejectVoiceGroup");
        e gVar = new g();
        try {
            gVar.groupId = str;
            gVar.rhn = i;
            gVar.rho = j;
            gVar.fOl = i2;
            this.mlJ = 3;
            this.wLa = c.chs().We(str);
        } catch (Exception e) {
            com.tencent.pb.common.c.d.k(this.wKV, "NetSceneRejectVoiceGroup constructor", e);
        }
        c(181, gVar);
    }

    public final int getType() {
        return 207;
    }

    protected final Object bs(byte[] bArr) {
        com.tencent.pb.common.c.d.d("MicroMsg.Voip", this.wKV, "data2Resp");
        if (bArr == null) {
            return null;
        }
        try {
            return (ab) e.a(new ab(), bArr, bArr.length);
        } catch (Exception e) {
            com.tencent.pb.common.c.d.k(this.wKV, "data2Resp", e.getMessage());
            return null;
        }
    }

    protected final String ccP() {
        return "CsCmd.Cmd_V_CSRejectEnterVoiceRoomReq";
    }
}
