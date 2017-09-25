package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import com.tencent.mm.plugin.appbrand.jsapi.w;
import com.tencent.pb.b.a.a;
import com.tencent.pb.common.b.a.a.ai;
import com.tencent.pb.common.b.a.a.aq;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.ax;
import com.tencent.pb.common.b.a.a.x;

public final class d extends com.tencent.pb.common.b.d {
    public int mType;
    public String xka;
    public boolean xlR = true;

    public d(String str, String[] strArr, byte[] bArr, String str2, av avVar, int i, int i2, long j, String str3, boolean z, String str4) {
        com.tencent.pb.common.c.d.d("MicroMsg.Voip", this.wKV, "create");
        e dVar = new com.tencent.pb.common.b.a.a.d();
        try {
            dVar.wLG = str;
            this.xka = str;
            dVar.wLL = i;
            this.wLa = i;
            if (avVar != null) {
                dVar.wLN = avVar;
            }
            aq aqVar = new aq();
            aqVar.name = str2;
            aqVar.wNQ = str4;
            aqVar.wNP = a.cdm();
            aqVar.fKw = i2;
            this.mType = i2;
            this.xlR = z;
            aqVar.wNI = j;
            dVar.wLI = aqVar;
            dVar.wLP = strArr;
            if (str3 == null) {
                str3 = "";
            }
            dVar.wLO = str3;
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
            dVar.wLK = axVar;
            this.mlJ = 3;
            dVar.wLM = 2;
        } catch (Exception e) {
            com.tencent.pb.common.c.d.k(this.wKV, "NetSceneCreateVoiceGroup constructor", e);
        }
        c(w.CTRL_INDEX, dVar);
    }

    public final int getType() {
        return bh.CTRL_INDEX;
    }

    protected final Object bs(byte[] bArr) {
        com.tencent.pb.common.c.d.d("MicroMsg.Voip", this.wKV, "data2Resp");
        if (bArr == null) {
            return null;
        }
        try {
            return (x) e.a(new x(), bArr, bArr.length);
        } catch (Exception e) {
            com.tencent.pb.common.c.d.k(this.wKV, "data2Resp", e.getMessage());
            return null;
        }
    }

    protected final String ccP() {
        return "CsCmd.Cmd_V_CSCreateVoiceGroupReq";
    }
}
