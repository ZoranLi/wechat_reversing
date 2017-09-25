package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.kc;
import com.tencent.mm.protocal.c.kd;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class z extends k implements j {
    private b gUA;
    private e gUD;
    private final a sDG;

    public interface a {
        void a(String str, String str2, String str3, String str4, String str5, long j);
    }

    public z(com.tencent.mm.t.f.a aVar, String str, String str2, a aVar2) {
        com.tencent.mm.y.b.a aVar3 = new com.tencent.mm.y.b.a();
        aVar3.hsm = new kc();
        aVar3.hsn = new kd();
        aVar3.uri = "/cgi-bin/micromsg-bin/checkbigfileupload";
        this.gUA = aVar3.BE();
        kc kcVar = (kc) this.gUA.hsj.hsr;
        if (aVar != null) {
            kcVar.tng = aVar.hhE;
            kcVar.tqg = aVar.filemd5;
            kcVar.hNZ = aVar.title;
            kcVar.tqh = aVar.hhr;
            kcVar.tqf = (long) aVar.hhq;
        } else {
            g.Em();
            kcVar.tng = com.tencent.mm.modelcdntran.b.Ee();
            g.Em();
            kcVar.tqg = com.tencent.mm.modelcdntran.b.iJ(str);
            kcVar.hNZ = com.tencent.mm.a.e.aR(str);
            kcVar.tqh = com.tencent.mm.a.e.aQ(str);
            kcVar.tqf = (long) com.tencent.mm.a.e.aN(str);
        }
        kcVar.tgM = com.tencent.mm.modelcdntran.b.hxN;
        kcVar.mvU = str2;
        kcVar.mvV = m.xL();
        this.sDG = aVar2;
        w.i("MicroMsg.NetSceneCheckBigFileUpload", "summerbig NetSceneCheckBigFileUpload content[%s], aesKey[%s] md5[%s] FileName[%s] FileSize[%d] FileExt[%s] talker[%s], fromUserName[%s], stack[%s]", aVar, kcVar.tng, kcVar.tqg, kcVar.hNZ, Long.valueOf(kcVar.tqf), kcVar.tqh, kcVar.mvU, kcVar.mvV, bg.bJZ());
    }

    public final int getType() {
        return 727;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneCheckBigFileUpload", "summerbig onGYNetEnd [%d, %d, %s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.gUD.a(i2, i3, str, this);
            kc kcVar = (kc) ((b) pVar).hsj.hsr;
            kd kdVar = (kd) ((b) pVar).hsk.hsr;
            w.d("MicroMsg.NetSceneCheckBigFileUpload", "summersafecdn onGYNetEnd Signature[%s], fuin[%d], faeskey[%s], fSignature[%s]", kdVar.hAG, Integer.valueOf(kdVar.tqi), kdVar.tqj, kdVar.tqk);
            if (this.sDG != null) {
                this.sDG.a(kcVar.tqg, kcVar.tng, kdVar.hAG, kdVar.tqj, kdVar.tqk, kcVar.tqf);
                return;
            }
            return;
        }
        w.e("MicroMsg.NetSceneCheckBigFileUpload", "summerbig onGYNetEnd errType = " + i2 + ", errCode = " + i3);
        this.gUD.a(i2, i3, str, this);
        if (this.sDG != null) {
            this.sDG.a("", "", "", "", "", 0);
        }
    }
}
