package com.tencent.mm.r.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.agz;
import com.tencent.mm.protocal.c.aha;
import com.tencent.mm.protocal.c.bqo;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class b extends k implements j {
    private final com.tencent.mm.y.b gUA;
    private e gWW;
    private a<b> gWY;

    public interface a<T extends k> {
        void b(int i, int i2, String str, T t);
    }

    public b(String str, LinkedList<String> linkedList, int i, int i2, int i3, a<b> aVar) {
        this(str, (LinkedList) linkedList, i, i2, i3);
        this.gWY = aVar;
    }

    public b(String str, LinkedList<String> linkedList, int i, int i2, a<b> aVar) {
        this(str, linkedList, 0, i2, -1, aVar);
    }

    private b(String str, LinkedList<String> linkedList, int i, int i2, int i3) {
        w.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "NetSceneJSLogin doScene appId [%s], versionType [%d], opt [%d], extScene [%d]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new agz();
        aVar.hsn = new aha();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
        aVar.hsl = 1158;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        agz com_tencent_mm_protocal_c_agz = (agz) this.gUA.hsj.hsr;
        if (i3 > 0) {
            com_tencent_mm_protocal_c_agz.tLK = new bqo();
            com_tencent_mm_protocal_c_agz.tLK.scene = i3;
        }
        com_tencent_mm_protocal_c_agz.mtb = str;
        com_tencent_mm_protocal_c_agz.tLH = linkedList;
        com_tencent_mm_protocal_c_agz.tLJ = i;
        com_tencent_mm_protocal_c_agz.tLI = i2;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.gWW != null) {
            this.gWW.a(i2, i3, str, this);
        }
        if (this.gWY != null) {
            this.gWY.b(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1158;
    }

    public final aha uE() {
        return (aha) this.gUA.hsk.hsr;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "doScene");
        this.gWW = eVar2;
        return a(eVar, this.gUA, this);
    }
}
