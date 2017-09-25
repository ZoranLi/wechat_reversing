package com.tencent.mm.r.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ahb;
import com.tencent.mm.protocal.c.ahc;
import com.tencent.mm.protocal.c.bqo;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class a extends k implements j {
    private final b gUA;
    private e gWW;
    private a<a> gWX;

    public interface a<T extends k> {
        void b(int i, int i2, String str, T t);
    }

    public a(String str, LinkedList<String> linkedList, a<a> aVar) {
        this(str, linkedList, 0, -1, aVar);
    }

    public a(String str, LinkedList<String> linkedList, int i, int i2, a<a> aVar) {
        this(str, linkedList, i, i2);
        this.gWX = aVar;
    }

    private a(String str, LinkedList<String> linkedList, int i, int i2) {
        w.i("MicroMsg.webview.NetSceneJSAuthorize", "NetSceneJSLogin doScene appId [%s], versionType [%d], extScene[%d]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new ahb();
        aVar.hsn = new ahc();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-authorize";
        aVar.hsl = 1157;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ahb com_tencent_mm_protocal_c_ahb = (ahb) this.gUA.hsj.hsr;
        if (i2 > 0) {
            com_tencent_mm_protocal_c_ahb.tLK = new bqo();
            com_tencent_mm_protocal_c_ahb.tLK.scene = i2;
        }
        com_tencent_mm_protocal_c_ahb.mtb = str;
        com_tencent_mm_protocal_c_ahb.tLH = linkedList;
        com_tencent_mm_protocal_c_ahb.tLJ = i;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.webview.NetSceneJSAuthorize", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.gWW != null) {
            this.gWW.a(i2, i3, str, this);
        }
        if (this.gWX != null) {
            this.gWX.b(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1157;
    }

    public final ahc uD() {
        return (ahc) this.gUA.hsk.hsr;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.i("MicroMsg.webview.NetSceneJSAuthorize", "doScene");
        this.gWW = eVar2;
        return a(eVar, this.gUA, this);
    }
}
