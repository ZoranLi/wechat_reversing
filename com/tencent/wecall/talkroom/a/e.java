package com.tencent.wecall.talkroom.a;

import com.tencent.mm.plugin.appbrand.jsapi.map.k;
import com.tencent.mm.plugin.appbrand.jsapi.share.f;
import com.tencent.pb.common.b.a.a.ai;
import com.tencent.pb.common.b.a.a.ax;
import com.tencent.pb.common.b.a.a.y;
import com.tencent.pb.common.b.d;

public final class e extends d {
    public int mUm = 0;
    public String mwM = null;
    public long xkb = 0;
    public int xlS = 0;

    public e(e eVar) {
        this.mwM = eVar.mwM;
        this.mUm = eVar.mUm;
        this.xkb = eVar.xkb;
        this.xlS = eVar.xlS;
        this.wKX = eVar.wKX;
        this.wKZ = eVar.wKZ;
        this.wLa = eVar.wLa;
        this.mlJ = 1;
    }

    public e(String str, int i, long j, byte[] bArr, int i2, int i3) {
        com.tencent.pb.common.c.d.d("MicroMsg.Voip", this.wKV, "enter", str, Integer.valueOf(i), Long.valueOf(j));
        com.google.a.a.e eVar = new com.tencent.pb.common.b.a.a.e();
        try {
            eVar.groupId = str;
            this.mwM = str;
            eVar.rhn = i;
            this.mUm = i;
            eVar.rho = j;
            this.xkb = j;
            eVar.wLS = i3;
            this.xlS = i3;
            ai aiVar = new ai();
            if (bArr != null) {
                aiVar.buffer = bArr;
                aiVar.tZn = bArr.length;
            } else {
                aiVar.tZn = 0;
            }
            ax axVar = new ax();
            axVar.type = 3;
            axVar.wOL = aiVar;
            eVar.wLK = axVar;
            this.mlJ = 2;
            this.wLa = i2;
            eVar.wLM = 2;
        } catch (Exception e) {
            com.tencent.pb.common.c.d.k(this.wKV, "NetSceneEnterVoiceRoom constructor", e);
        }
        c(k.CTRL_INDEX, eVar);
    }

    public final int getType() {
        return f.CTRL_INDEX;
    }

    protected final Object bs(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return (y) com.google.a.a.e.a(new y(), bArr, bArr.length);
        } catch (Exception e) {
            com.tencent.pb.common.c.d.k(this.wKV, "data2Resp", e.getMessage());
            return null;
        }
    }

    protected final String ccP() {
        return "CsCmd.Cmd_V_CSEnterVoiceRoomReq";
    }
}
