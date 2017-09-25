package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ka;
import com.tencent.mm.protocal.c.kb;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class y extends k implements j {
    private b gUA;
    private e gUD;
    private final b sDF;

    public y(b bVar, String str, String str2, String str3, String str4, String str5) {
        a aVar = new a();
        aVar.hsm = new ka();
        aVar.hsn = new kb();
        aVar.uri = "/cgi-bin/micromsg-bin/checkbigfiledownload";
        this.gUA = aVar.BE();
        this.sDF = bVar;
        ka kaVar = (ka) this.gUA.hsj.hsr;
        kaVar.tng = str;
        kaVar.tqf = bVar.field_totalLen;
        kaVar.tqg = str2;
        kaVar.hNZ = str3;
        kaVar.tqh = str4;
        kaVar.mvV = str5;
        ap.yY();
        kaVar.mvU = (String) c.vr().get(2, (Object) "");
        kaVar.tgM = com.tencent.mm.modelcdntran.b.hxN;
        w.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig AESKey[%s] FileMd5[%s] FileName[%s] FileExt[%s] FileSize[%d] FileType[%d] stack[%s]", bg.Qj(kaVar.tng), kaVar.tqg, kaVar.hNZ, kaVar.tqh, Long.valueOf(kaVar.tqf), Integer.valueOf(kaVar.tgM), bg.bJZ());
    }

    public final int getType() {
        return 728;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig onGYNetEnd [%d, %d, %s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            kb kbVar = (kb) ((b) pVar).hsk.hsr;
            this.sDF.field_signature = kbVar.hAG;
            this.sDF.field_fakeAeskey = kbVar.tqj;
            this.sDF.field_fakeSignature = kbVar.tqk;
            boolean c = an.abL().c(this.sDF, new String[0]);
            w.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig onGYNetEnd field_signature[%s], field_fakeAeskey[%s], field_fakeSignature[%s], update[%b]", bg.Qj(this.sDF.field_signature), bg.Qj(this.sDF.field_fakeAeskey), bg.Qj(this.sDF.field_fakeSignature), Boolean.valueOf(c));
        }
        this.gUD.a(i2, i3, str, this);
    }
}
