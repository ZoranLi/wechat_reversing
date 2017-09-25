package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.c;
import com.tencent.pb.common.b.a.a.af;
import com.tencent.pb.common.b.d;

public final class j extends d {
    public String mwM;

    public final int getType() {
        return c.CTRL_INDEX;
    }

    protected final Object bs(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return (af) e.a(new af(), bArr, bArr.length);
        } catch (Exception e) {
            com.tencent.pb.common.c.d.k(this.wKV, "data2Resp", e);
            return null;
        }
    }

    protected final String ccP() {
        return "CsCmd.Cmd_V_CSVoiceMemberWhisperReq";
    }
}
