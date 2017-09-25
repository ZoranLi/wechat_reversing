package com.tencent.mm.modelsimple;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bfr;
import com.tencent.mm.protocal.c.bfs;
import com.tencent.mm.protocal.c.ch;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class ah extends k implements j {
    private final b gUA;
    private e gUD;

    public ah(String str, int i, LinkedList<ch> linkedList) {
        w.i("MicroMsg.NetSceneTranslateLink", "ticket link = " + str + "; scene = " + i);
        a aVar = new a();
        aVar.hsm = new bfr();
        aVar.hsn = new bfs();
        aVar.uri = "/cgi-bin/mmbiz-bin/translatelink";
        this.gUA = aVar.BE();
        bfr com_tencent_mm_protocal_c_bfr = (bfr) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bfr.hSX = str;
        com_tencent_mm_protocal_c_bfr.scene = i;
        com_tencent_mm_protocal_c_bfr.ugd = linkedList;
    }

    public final int getType() {
        return 1200;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneTranslateLink", "swap deep link with ticket onGYNetEnd:[%d,%d,%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.gUD.a(i2, i3, str, this);
    }

    public final String Jy() {
        bfs com_tencent_mm_protocal_c_bfs = (bfs) this.gUA.hsk.hsr;
        if (com_tencent_mm_protocal_c_bfs == null) {
            return null;
        }
        return com_tencent_mm_protocal_c_bfs.uge;
    }

    public final bfs Jz() {
        if (this.gUA == null || this.gUA.hsk.hsr == null) {
            return null;
        }
        return (bfs) this.gUA.hsk.hsr;
    }
}
