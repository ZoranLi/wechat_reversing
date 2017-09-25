package com.tencent.mm.modelbiz;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aia;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class u extends k implements j {
    public b gUA;
    private e gUD;
    public String hwg;
    public int hwh;
    public String tag;

    public u(String str, LinkedList<String> linkedList) {
        this(str, linkedList, (byte) 0);
    }

    private u(String str, LinkedList<String> linkedList, byte b) {
        this.hwh = 1;
        a aVar = new a();
        aVar.hsm = new aia();
        aVar.hsn = new aib();
        aVar.uri = "/cgi-bin/mmkf-bin/kfgetinfolist";
        aVar.hsl = 675;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        aia com_tencent_mm_protocal_c_aia = (aia) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_aia.tMd = str;
        com_tencent_mm_protocal_c_aia.tMg = linkedList;
        this.hwg = str;
        this.hwh = 1;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneKFGetInfoList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 675;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        w.i("MicroMsg.NetSceneKFGetInfoList", "do scene");
        return a(eVar, this.gUA, this);
    }

    public final aib DE() {
        if (this.gUA == null || this.gUA.hsk.hsr == null) {
            return null;
        }
        return (aib) this.gUA.hsk.hsr;
    }
}
