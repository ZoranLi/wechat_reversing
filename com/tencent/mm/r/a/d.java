package com.tencent.mm.r.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ahd;
import com.tencent.mm.protocal.c.ahe;
import com.tencent.mm.protocal.c.bqo;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class d extends k implements j {
    private final b gUA;
    private e gWW;
    private a<d> gXa;

    public interface a<T extends k> {
        void b(int i, int i2, String str, T t);
    }

    public d(String str, LinkedList<String> linkedList, int i, String str2, int i2, int i3, a<d> aVar) {
        this(str, linkedList, 0, str2, 0, i3, -1, aVar);
    }

    public d(String str, LinkedList<String> linkedList, int i, String str2, int i2, int i3, int i4, a<d> aVar) {
        this(str, (LinkedList) linkedList, i, str2, i2, i3, i4);
        this.gXa = aVar;
    }

    private d(String str, LinkedList<String> linkedList, int i, String str2, int i2, int i3, int i4) {
        w.i("MicroMsg.webview.NetSceneJSLoginConfirm", "NetSceneJSLogin doScene appId [%s], login_type [%d], state [%s], versionType [%d], opt [%d], extScene [%d]", new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new ahd();
        aVar.hsn = new ahe();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-login-confirm";
        aVar.hsl = 1117;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ahd com_tencent_mm_protocal_c_ahd = (ahd) this.gUA.hsj.hsr;
        if (i4 > 0) {
            com_tencent_mm_protocal_c_ahd.tLK = new bqo();
            com_tencent_mm_protocal_c_ahd.tLK.scene = i4;
        }
        com_tencent_mm_protocal_c_ahd.mtb = str;
        com_tencent_mm_protocal_c_ahd.tLH = linkedList;
        com_tencent_mm_protocal_c_ahd.tLM = i;
        com_tencent_mm_protocal_c_ahd.tLN = str2;
        com_tencent_mm_protocal_c_ahd.tLJ = i2;
        com_tencent_mm_protocal_c_ahd.tLI = i3;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.webview.NetSceneJSLoginConfirm", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.gWW != null) {
            this.gWW.a(i2, i3, str, this);
        }
        if (this.gXa != null) {
            this.gXa.b(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1117;
    }

    public final ahe uG() {
        return (ahe) this.gUA.hsk.hsr;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.i("MicroMsg.webview.NetSceneJSLoginConfirm", "doScene");
        this.gWW = eVar2;
        return a(eVar, this.gUA, this);
    }
}
