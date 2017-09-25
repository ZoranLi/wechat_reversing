package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.and;
import com.tencent.mm.protocal.c.ane;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class n extends k implements j {
    byte[] fYC;
    private final b gUA;
    private e gUD;
    int las;
    int lau;

    public n(int i, int i2, byte[] bArr) {
        String str;
        this.las = i;
        this.lau = i2;
        a aVar = new a();
        aVar.hsm = new and();
        aVar.hsn = new ane();
        switch (i2) {
            case 1918:
                str = "/cgi-bin/qcwxmultitalk-bin/createtalkroom";
                break;
            case 1919:
                str = "/cgi-bin/qcwxmultitalk-bin/entertalkroom";
                break;
            case 1927:
                str = "/cgi-bin/qcwxmultitalk-bin/exittalkroom";
                break;
            case 1928:
                str = "/cgi-bin/qcwxmultitalk-bin/cancelcreatetalkroom";
                break;
            case 1929:
                str = "/cgi-bin/qcwxmultitalk-bin/rejectentertalkroom";
                break;
            case 1931:
                str = "/cgi-bin/qcwxmultitalk-bin/addmembers";
                break;
            case 1932:
                str = "/cgi-bin/qcwxmultitalk-bin/hellotalkroom";
                break;
            case 1933:
                str = "/cgi-bin/qcwxmultitalk-bin/miscinfo";
                break;
            case 1935:
                str = "/cgi-bin/qcwxmultitalk-bin/voiceackreq";
                break;
            case 1937:
                str = "/cgi-bin/qcwxmultitalk-bin/oiceredirectreq";
                break;
            case 1938:
                str = "/cgi-bin/qcwxmultitalk-bin/getgroupinfobatch";
                break;
            case 1939:
                str = "/cgi-bin/qcwxmultitalk-bin/memberwhisper";
                break;
            default:
                str = "";
                break;
        }
        w.i("MicroMsg.MT.NetSceneMultiTalk", "netSceneMultiTalk cmdid %d cgiName %s", new Object[]{Integer.valueOf(i2), str});
        aVar.uri = str;
        aVar.hsl = this.lau;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ((and) this.gUA.hsj.hsr).tij = new avw().bb(bArr);
    }

    public final int getType() {
        return this.lau;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.MT.NetSceneMultiTalk", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " " + this.lau);
        this.fYC = com.tencent.mm.platformtools.n.a(((ane) ((b) pVar).hsk.hsr).tij);
        this.gUD.a(i2, i3, str, this);
    }
}
