package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect;
import com.tencent.pb.common.b.a.a.ac;
import com.tencent.pb.common.b.a.a.h;
import com.tencent.pb.common.b.d;
import com.tencent.wecall.talkroom.model.c;

public final class k extends d {
    public int mUm;
    public String mwM;
    public long xkb;

    public k(String str, int i, long j, int i2) {
        com.tencent.pb.common.c.d.d("MicroMsg.Voip", this.wKV, "NetSceneSwitchVideoGroup");
        e hVar = new h();
        try {
            hVar.groupId = str;
            this.mwM = str;
            hVar.mNL = i;
            this.mUm = i;
            hVar.mNM = j;
            this.xkb = j;
            hVar.action = i2;
            this.mlJ = 3;
            this.wLa = c.chs().We(str);
        } catch (Exception e) {
            com.tencent.pb.common.c.d.k(this.wKV, "NetSceneSwitchVideoGroup constructor", e);
        }
        c(com.tencent.mm.plugin.appbrand.jsapi.f.h.CTRL_INDEX, hVar);
    }

    public final int getType() {
        return JsApiCheckIsSupportFaceDetect.CTRL_INDEX;
    }

    protected final Object bs(byte[] bArr) {
        com.tencent.pb.common.c.d.d("MicroMsg.Voip", this.wKV, "data2Resp");
        if (bArr == null) {
            return null;
        }
        try {
            return (ac) e.a(new ac(), bArr, bArr.length);
        } catch (Exception e) {
            com.tencent.pb.common.c.d.k(this.wKV, "data2Resp", e.getMessage());
            return null;
        }
    }

    protected final String ccP() {
        return "CsCmd.Cmd_V_CSSwitchVideoGroupReq";
    }
}
