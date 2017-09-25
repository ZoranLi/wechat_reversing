package com.tencent.mm.plugin.radar.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.protocal.c.atj;
import com.tencent.mm.protocal.c.atk;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.x.h;
import com.tencent.mm.x.n;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.List;

public final class b extends k implements j {
    int fJA;
    private float fOb;
    private float fPF;
    private int fPG;
    private int fPH;
    private String fPI;
    private String fPJ;
    com.tencent.mm.y.b gUA;
    private e gUD;

    public b(int i, float f, float f2, int i2, int i3, String str, String str2) {
        if (i == 0) {
            w.e("MicroMsg.NetSceneRadarSearch", "opcode is wrong!");
            return;
        }
        this.fJA = i;
        this.fPJ = str2;
        this.fPH = i3;
        this.fOb = f;
        this.fPF = f2;
        this.fPI = str;
        this.fPG = i2;
    }

    public b() {
        this(2, 0.0f, 0.0f, 0, 0, "", "");
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneRadarSearch", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        if (this.fJA == 1 && i2 == 0) {
            List arrayList = new ArrayList();
            atk com_tencent_mm_protocal_c_atk = (atk) this.gUA.hsk.hsr;
            for (int i4 = 0; i4 < com_tencent_mm_protocal_c_atk.teK.size(); i4++) {
                ati com_tencent_mm_protocal_c_ati = (ati) com_tencent_mm_protocal_c_atk.teK.get(i4);
                h hVar = new h();
                if (com_tencent_mm_protocal_c_ati.jNj != null) {
                    hVar.username = com_tencent_mm_protocal_c_ati.jNj;
                } else {
                    hVar.username = com_tencent_mm_protocal_c_ati.twU;
                }
                hVar.hrA = ((ati) com_tencent_mm_protocal_c_atk.teK.get(i4)).tuS;
                hVar.aV(true);
                arrayList.add(hVar);
            }
            n.Bm().z(arrayList);
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 425;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        a aVar = new a();
        aVar.hsm = new atj();
        aVar.hsn = new atk();
        aVar.uri = "/cgi-bin/micromsg-bin/mmradarsearch";
        aVar.hsl = 425;
        aVar.hso = ag.CTRL_INDEX;
        aVar.hsp = 1000000209;
        this.gUA = aVar.BE();
        atj com_tencent_mm_protocal_c_atj = (atj) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_atj.tce = this.fJA;
        com_tencent_mm_protocal_c_atj.twS = this.fPJ;
        com_tencent_mm_protocal_c_atj.twT = this.fPH;
        com_tencent_mm_protocal_c_atj.tna = this.fOb;
        com_tencent_mm_protocal_c_atj.tmZ = this.fPF;
        com_tencent_mm_protocal_c_atj.twR = this.fPI;
        com_tencent_mm_protocal_c_atj.twQ = this.fPG;
        return a(eVar, this.gUA, this);
    }

    public final int aVz() {
        return ((atk) this.gUA.hsk.hsr).ksW;
    }
}
