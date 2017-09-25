package com.tencent.mm.r.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ahf;
import com.tencent.mm.protocal.c.ahg;
import com.tencent.mm.protocal.c.bqo;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class c extends k implements j {
    private final b gUA;
    private e gWW;
    private a<c> gWZ;

    public interface a<T extends k> {
        void b(int i, int i2, String str, T t);
    }

    public c(String str, LinkedList<String> linkedList, String str2, String str3, a<c> aVar) {
        this(str, linkedList, 0, str2, str3, 0, -1, aVar);
    }

    public c(String str, LinkedList<String> linkedList, int i, String str2, String str3, int i2, int i3, a<c> aVar) {
        this(str, linkedList, i, str2, str3, i2, i3);
        this.gWZ = aVar;
    }

    private c(String str, LinkedList<String> linkedList, int i, String str2, String str3, int i2, int i3) {
        w.i("MicroMsg.webview.NetSceneJSLogin", "NetSceneJSLogin doScene appId [%s], loginType [%d], url [%s], state [%s], versionType [%d], extScene [%d]", new Object[]{str, Integer.valueOf(i), str2, str3, Integer.valueOf(i2), Integer.valueOf(i3)});
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new ahf();
        aVar.hsn = new ahg();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-login";
        aVar.hsl = 1029;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ahf com_tencent_mm_protocal_c_ahf = (ahf) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_ahf.mtb = str;
        com_tencent_mm_protocal_c_ahf.tLH = linkedList;
        com_tencent_mm_protocal_c_ahf.tLM = i;
        com_tencent_mm_protocal_c_ahf.msN = str2;
        com_tencent_mm_protocal_c_ahf.tLN = str3;
        com_tencent_mm_protocal_c_ahf.tLJ = i2;
        if (i3 > 0) {
            com_tencent_mm_protocal_c_ahf.tLK = new bqo();
            com_tencent_mm_protocal_c_ahf.tLK.scene = i3;
        }
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.webview.NetSceneJSLogin", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.gWW != null) {
            this.gWW.a(i2, i3, str, this);
        }
        if (this.gWZ != null) {
            this.gWZ.b(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1029;
    }

    public final ahg uF() {
        return (ahg) this.gUA.hsk.hsr;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.i("MicroMsg.webview.NetSceneJSLogin", "doScene");
        this.gWW = eVar2;
        return a(eVar, this.gUA, this);
    }
}
