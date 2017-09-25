package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.cf;
import com.tencent.pb.common.b.a.a.ah;
import com.tencent.pb.common.b.a.a.k;
import com.tencent.pb.common.b.d;
import com.tencent.wecall.talkroom.model.c;

public final class l extends d {
    public int mUm;
    public String mwM;
    public long xkb;

    public l(String str, int i, long j, int i2, int i3) {
        com.tencent.pb.common.c.d.d("MicroMsg.Voip", this.wKV, "hello", str, Integer.valueOf(i), Long.valueOf(j));
        e kVar = new k();
        kVar.wLX = i3;
        kVar.rhn = i;
        this.mUm = i;
        kVar.rho = j;
        this.xkb = j;
        kVar.groupId = str;
        this.mwM = str;
        kVar.mOs = i2;
        try {
            this.wLa = c.chs().We(str);
        } catch (Exception e) {
            com.tencent.pb.common.c.d.k(this.wKV, "NetSceneVoiceRoomHello constructor", e);
        }
        c(147, kVar);
    }

    public final int getType() {
        return cf.CTRL_INDEX;
    }

    protected final Object bs(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return (ah) e.a(new ah(), bArr, bArr.length);
        } catch (Exception e) {
            com.tencent.pb.common.c.d.k(this.wKV, "data2Resp", e.getMessage());
            return null;
        }
    }

    protected final String ccP() {
        return "CsCmd.Cmd_V_CSVoiceRoomHelloReq";
    }
}
