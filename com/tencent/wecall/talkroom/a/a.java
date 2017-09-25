package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.k;
import com.tencent.pb.common.b.a.a.ad;
import com.tencent.pb.common.b.a.a.ai;
import com.tencent.pb.common.b.a.a.ax;
import com.tencent.pb.common.b.a.a.i;
import com.tencent.pb.common.b.d;

public final class a extends d {
    public int mUm = 0;
    public String mwM = null;
    public int wLa;
    public long xkb = 0;
    public int xlQ;

    public a(String str, int i, long j, int i2, int i3) {
        com.tencent.pb.common.c.d.d("MicroMsg.Voip", this.wKV, "NetSceneAckVoiceGroup");
        e iVar = new i();
        try {
            iVar.groupId = str;
            this.mwM = str;
            iVar.rhn = i;
            this.mUm = i;
            iVar.rho = j;
            this.xkb = j;
            this.xlQ = i3;
            this.wLa = i2;
            ai aiVar = new ai();
            aiVar.tZn = 0;
            ax axVar = new ax();
            axVar.type = 3;
            axVar.wOL = aiVar;
            iVar.wLK = axVar;
            this.mlJ = 3;
            this.wLa = i2;
        } catch (Exception e) {
            com.tencent.pb.common.c.d.k(this.wKV, "NetSceneAckVoiceGroup constructor", e);
        }
        c(k.CTRL_BYTE, iVar);
    }

    public final int getType() {
        return v.CTRL_INDEX;
    }

    protected final Object bs(byte[] bArr) {
        com.tencent.pb.common.c.d.d("MicroMsg.Voip", this.wKV, "data2Resp");
        if (bArr == null) {
            return null;
        }
        try {
            return (ad) e.a(new ad(), bArr, bArr.length);
        } catch (Exception e) {
            com.tencent.pb.common.c.d.k(this.wKV, "data2Resp", e.getMessage());
            return null;
        }
    }

    protected final String ccP() {
        return "CsCmd.Cmd_V_CSVoiceAckReq";
    }
}
