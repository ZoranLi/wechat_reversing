package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ail;
import com.tencent.mm.protocal.c.arj;
import com.tencent.mm.protocal.c.rb;
import com.tencent.mm.protocal.c.rc;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class l extends k implements j {
    private b gUA;
    private e gUD;
    public LinkedList<ail> luX = null;
    public arj luY = null;
    public String luZ = null;

    public l(String str, String str2) {
        a aVar = new a();
        aVar.hsm = new rb();
        aVar.hsn = new rc();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/faceidentifyprepage";
        aVar.hsl = 1147;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        rb rbVar = (rb) this.gUA.hsj.hsr;
        rbVar.fTO = str;
        rbVar.twF = str2;
    }

    public final int getType() {
        return 1147;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneFaceGetConfirmPageInfo", "alvinluo errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        rc rcVar = (rc) ((b) pVar).hsk.hsr;
        if (rcVar != null) {
            this.luX = rcVar.tpz;
            this.luY = rcVar.twG;
            this.luZ = rcVar.twI;
            if (this.gUD != null) {
                this.gUD.a(i2, i3, str, this);
            }
        }
    }
}
