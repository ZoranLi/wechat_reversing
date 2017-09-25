package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.ao;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.pb.common.b.a.a.v;
import com.tencent.pb.common.b.d;
import com.tencent.wecall.talkroom.model.c;

public final class b extends d {
    public int mUm;
    public String mwM;
    public long xkb;

    public b(String str, int i, long j, String[] strArr) {
        com.tencent.pb.common.c.d.d("MicroMsg.Voip", this.wKV, "addmember", str);
        e aVar = new a();
        try {
            aVar.groupId = str;
            this.mwM = str;
            aVar.rhn = i;
            this.mUm = i;
            aVar.rho = j;
            this.xkb = j;
            aVar.wLF = strArr;
            aVar.rhn = i;
            this.mlJ = 3;
            this.wLa = c.chs().We(str);
        } catch (Exception e) {
            com.tencent.pb.common.c.d.k(this.wKV, "NetSceneAddVoiceGroupMember constructor", e);
        }
        c(com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX, aVar);
    }

    public final int getType() {
        return ao.CTRL_INDEX;
    }

    protected final Object bs(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return (v) e.a(new v(), bArr, bArr.length);
        } catch (Exception e) {
            com.tencent.pb.common.c.d.k(this.wKV, "data2Resp", e.getMessage());
            return null;
        }
    }

    protected final String ccP() {
        return "CsCmd.Cmd_V_CSAddVoiceGroupMemberReq";
    }
}
