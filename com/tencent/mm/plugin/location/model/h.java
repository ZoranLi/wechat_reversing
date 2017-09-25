package com.tencent.mm.plugin.location.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.location.ui.impl.f;
import com.tencent.mm.protocal.c.aoy;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.zq;
import com.tencent.mm.protocal.c.zr;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class h extends k implements j {
    public int errCode;
    public int errType;
    public int fJA;
    public String fPf;
    public List<f> fRK = new ArrayList();
    public final b gUA;
    private e gUD;
    private Runnable hSV;
    public String iGy;
    public boolean kgf = false;
    public byte[] nbd;
    public byte[] nbe = null;
    public String nbf = "";
    public int nbg;

    public h(byte[] bArr, double d, double d2, int i, int i2, double d3, double d4, String str, String str2) {
        a aVar = new a();
        aVar.hsm = new zq();
        aVar.hsn = new zr();
        aVar.hsn = new zr();
        aVar.uri = "/cgi-bin/micromsg-bin/getpoilist";
        aVar.hsl = 457;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        zq zqVar = (zq) this.gUA.hsj.hsr;
        zqVar.tFu = bArr == null ? new avw() : new avw().bb(bArr);
        zqVar.tAN = str2;
        zqVar.tle = d;
        zqVar.tld = d2;
        zqVar.tdM = i;
        zqVar.tce = i2;
        zqVar.tFW = d4;
        zqVar.tFV = d3;
        zqVar.tFw = 1;
        this.fJA = zqVar.tce;
        this.nbf = str;
        this.nbd = bArr;
        w.i("MicroMsg.NetSceneGetPoiList", "lat %f lng %f scene %d opcode %d oriLat %f oriLng %f" + bArr, new Object[]{Double.valueOf(d), Double.valueOf(d2), Integer.valueOf(i), Integer.valueOf(i2), Double.valueOf(d4), Double.valueOf(d3)});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.d("MicroMsg.NetSceneGetPoiList", "scene done");
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 457;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneGetPoiList", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + "errMsg:" + str);
        this.errType = i2;
        this.errCode = i3;
        this.fPf = str;
        zr zrVar = (zr) this.gUA.hsk.hsr;
        this.fRK.clear();
        w.d("MicroMsg.NetSceneGetPoiList", "url " + zrVar.tFD + " " + zrVar.tGa + " " + zrVar.msN + " " + zrVar.tmb);
        w.d("MicroMsg.NetSceneGetPoiList", "autoInterval: %d", new Object[]{Integer.valueOf(zrVar.tFE)});
        this.iGy = zrVar.tmb;
        this.nbg = zrVar.tFE;
        if (zrVar.tFY != null) {
            w.d("MicroMsg.NetSceneGetPoiList", "poi result %d ", new Object[]{Integer.valueOf(zrVar.tFY.size())});
            if (zrVar.tFY.size() > 0) {
                w.d("MicroMsg.NetSceneGetPoiList", "addr %s, province %s, street %s, city %s", new Object[]{((aoy) zrVar.tFY.get(0)).tTU, ((aoy) zrVar.tFY.get(0)).hAE, ((aoy) zrVar.tFY.get(0)).tti, ((aoy) zrVar.tFY.get(0)).hAF});
            }
            Iterator it = zrVar.tFY.iterator();
            while (it.hasNext()) {
                this.fRK.add(new f((aoy) it.next(), this.iGy));
            }
        }
        if (zrVar.tFu != null) {
            this.nbe = n.a(zrVar.tFu);
        }
        this.kgf = zrVar.tFZ == 1;
        this.gUD.a(i2, i3, str, this);
        if (this.hSV != null) {
            this.hSV.run();
        }
    }

    public final boolean isFirst() {
        return this.nbd == null;
    }
}
