package com.tencent.mm.plugin.webview.c;

import com.tencent.mm.as.a;
import com.tencent.mm.as.d;
import com.tencent.mm.as.i;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.protocal.c.boz;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;

public final class f extends a implements j {
    private e gUD;
    private b hKp;
    private int hPp;
    private boz rWm;
    private int scene;

    public f(d.b bVar) {
        this.hPh = bVar.fDs;
        this.wa = bVar.offset;
        this.hPi = bVar.scene;
        this.hPg = bVar.fRO;
        this.hPp = bVar.hPp;
        if (bg.mA(bVar.fDs)) {
            w.e("MicroMsg.FTS.NetSceneWebSearch", "keyword is unavailable");
            return;
        }
        w.i("MicroMsg.FTS.NetSceneWebSearch", "Constructors: keyword=%s", new Object[]{bVar.fDs});
        this.scene = bVar.scene;
        b.a aVar = new b.a();
        aVar.hsl = 719;
        aVar.uri = "/cgi-bin/micromsg-bin/mmwebsearch";
        aVar.hsm = new boy();
        aVar.hsn = new boz();
        this.hKp = aVar.BE();
        boy com_tencent_mm_protocal_c_boy = (boy) this.hKp.hsj.hsr;
        com_tencent_mm_protocal_c_boy.tAN = bVar.fDs;
        com_tencent_mm_protocal_c_boy.tYD = bVar.hPp;
        com_tencent_mm_protocal_c_boy.tlY = (long) bVar.hPq;
        com_tencent_mm_protocal_c_boy.tOl = d.AU();
        com_tencent_mm_protocal_c_boy.tll = bVar.offset;
        com_tencent_mm_protocal_c_boy.umf = d.hPo;
        com_tencent_mm_protocal_c_boy.tZK = bVar.hPs;
        com_tencent_mm_protocal_c_boy.tdM = bVar.scene;
        com_tencent_mm_protocal_c_boy.tmb = bVar.hPt;
        com_tencent_mm_protocal_c_boy.unq = bVar.hPu;
        com_tencent_mm_protocal_c_boy.unr = bVar.hPv;
        com_tencent_mm_protocal_c_boy.unt = bVar.hPx;
        com_tencent_mm_protocal_c_boy.uns = bVar.hPw;
        com_tencent_mm_protocal_c_boy.unu = bVar.hPy;
        com_tencent_mm_protocal_c_boy.unv = bVar.hPD;
        com_tencent_mm_protocal_c_boy.hPC = bVar.hPC;
        com_tencent_mm_protocal_c_boy.unw = bVar.hPE;
        com_tencent_mm_protocal_c_boy.leO = bVar.aQd;
        com_tencent_mm_protocal_c_boy.umj = d.gm(bVar.scene);
        if (bVar.hPH != null) {
            try {
                com_tencent_mm_protocal_c_boy.uny = new com.tencent.mm.bd.b(bVar.hPH.toByteArray());
            } catch (Exception e) {
            }
        }
        if (bVar.hPG != null) {
            try {
                com_tencent_mm_protocal_c_boy.unx = new com.tencent.mm.bd.b(bVar.hPG.toByteArray());
            } catch (Exception e2) {
            }
        }
        String str = "MicroMsg.FTS.NetSceneWebSearch";
        String str2 = "contains location = %b | matchUserSize=%d | scene=%d | businessType=%d | isHomePage=%b | sceneActionType=%d | webViewId=%d";
        Object[] objArr = new Object[7];
        objArr[0] = Boolean.valueOf(com_tencent_mm_protocal_c_boy.tOl != null);
        objArr[1] = Integer.valueOf(bVar.hPs.size());
        objArr[2] = Integer.valueOf(bVar.scene);
        objArr[3] = Integer.valueOf(bVar.hPq);
        objArr[4] = Integer.valueOf(this.hPp);
        objArr[5] = Integer.valueOf(bVar.hPu);
        objArr[6] = Integer.valueOf(bVar.fRO);
        w.i(str, str2, objArr);
        if (com_tencent_mm_protocal_c_boy.tOl != null) {
            n.a(2005, com_tencent_mm_protocal_c_boy.tOl.tmZ, com_tencent_mm_protocal_c_boy.tOl.tna, com_tencent_mm_protocal_c_boy.tOl.twQ);
        }
    }

    public final int getType() {
        return 719;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        i.aX(this.scene, 2);
        i.aY(this.scene, 2);
        this.gUD = eVar2;
        return a(eVar, this.hKp, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.FTS.NetSceneWebSearch", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            i.aX(this.scene, 3);
            this.rWm = (boz) this.hKp.hsk.hsr;
            if (this.rWm != null) {
                w.v("MicroMsg.FTS.NetSceneWebSearch", "return data\n%s", new Object[]{this.rWm.tlt});
            }
            this.gUD.a(i2, i3, str, this);
            i.q(this.scene, i2, i3);
            return;
        }
        this.gUD.a(i2, i3, str, this);
        i.aX(this.scene, 4);
        i.q(this.scene, i2, i3);
    }

    public final String AS() {
        return this.rWm != null ? this.rWm.tlt : "";
    }

    public final int AT() {
        return this.rWm != null ? this.rWm.ump : 0;
    }
}
