package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.rd;
import com.tencent.mm.protocal.c.re;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class m extends k implements j, e {
    private b gUA;
    private e gUD;
    private boolean lva = false;
    public String lvb = null;
    public boolean lvc = false;
    private String lvd = "";

    public m(long j, String str, String str2, String str3, String str4) {
        a aVar = new a();
        aVar.hsm = new rd();
        aVar.hsn = new re();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/faceidentify";
        aVar.hsl = 1080;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        rd rdVar = (rd) this.gUA.hsj.hsr;
        rdVar.fTO = str;
        rdVar.twJ = j;
        rdVar.twF = str2;
        rdVar.twL = str3;
        rdVar.twK = str4;
    }

    public final int getType() {
        return 1080;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneFaceVerifyFace", "alvinluo NetSceneFacePicThirdVerifyFace errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        re reVar = (re) ((b) pVar).hsk.hsr;
        w.i("MicroMsg.NetSceneFaceVerifyFace", "identity_id: %s", new Object[]{reVar.twM});
        this.lvb = reVar.twM;
        this.lvc = reVar.twN;
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final String arn() {
        return this.lvb;
    }

    public final boolean arm() {
        return this.lvc;
    }
}
