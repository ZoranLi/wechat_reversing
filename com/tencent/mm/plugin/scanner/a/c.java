package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.gz;
import com.tencent.mm.protocal.c.ha;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class c extends k implements j {
    public b gUA;
    private e gUD;

    public c(String str, LinkedList<String> linkedList, int i, String str2, double d, double d2) {
        a aVar = new a();
        aVar.hsm = new gz();
        aVar.hsn = new ha();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscangetactioninfo";
        aVar.hsl = 1068;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        gz gzVar = (gz) this.gUA.hsj.hsr;
        gzVar.tgW = str;
        gzVar.tdM = i;
        gzVar.tlc = str2;
        gzVar.tlb = linkedList;
        gzVar.tle = d2;
        gzVar.tld = d;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetActionInfo", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1068;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
