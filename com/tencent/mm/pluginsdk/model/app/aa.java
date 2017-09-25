package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.kq;
import com.tencent.mm.protocal.c.kr;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class aa extends k implements j {
    private b gUA;
    private e gUD;
    private a sDH;

    public interface a {
        void H(String str, int i, int i2);
    }

    public aa(String str, String str2, String str3, int i, a aVar) {
        com.tencent.mm.y.b.a aVar2 = new com.tencent.mm.y.b.a();
        aVar2.hsm = new kq();
        aVar2.hsn = new kr();
        aVar2.uri = "/cgi-bin/micromsg-bin/checkmd5";
        this.gUA = aVar2.BE();
        kq kqVar = (kq) this.gUA.hsj.hsr;
        kqVar.fileid = str;
        kqVar.fFW = str2;
        kqVar.tqW = str3;
        kqVar.tqX = i;
        this.sDH = aVar;
        w.i("MicroMsg.NetSceneCheckMd5", "summersafecdn NetSceneCheckMd5 fileid[%s], md5[%s], newmd5[%s], crc[%d], stack[%s]", kqVar.fileid, kqVar.fFW, kqVar.tqW, Integer.valueOf(kqVar.tqX), bg.bJZ());
    }

    public final int getType() {
        return 939;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneCheckMd5", "summersafecdn onGYNetEnd [%d, %d, %s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.gUD.a(i2, i3, str, this);
        if (this.sDH != null) {
            a aVar;
            String str2;
            a aVar2;
            if (i2 == 0 && i3 == 0) {
                kr krVar = (kr) ((b) pVar).hsk.hsr;
                aVar = this.sDH;
                if (krVar != null) {
                    str2 = krVar.aeskey;
                    aVar.H(str2, i2, i3);
                }
                aVar2 = aVar;
            } else {
                aVar2 = this.sDH;
            }
            aVar = aVar2;
            str2 = "";
            aVar.H(str2, i2, i3);
        }
    }
}
