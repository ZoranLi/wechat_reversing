package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.bce;
import com.tencent.mm.protocal.c.bch;
import com.tencent.mm.protocal.c.bci;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.List;

public final class v extends k implements j {
    private int fJA;
    private b gUA;
    public e gUD;
    private long pUE;
    private int scene = 0;

    public v(int i, long j, String str, int i2, List<String> list, int i3) {
        w.d("MicroMsg.NetSceneSnsTagMemberOption", "opCode " + i + " tagName " + str + " memberList " + list.size() + " scene " + i3);
        this.fJA = i;
        this.pUE = j;
        this.scene = i3;
        a aVar = new a();
        aVar.hsm = new bch();
        aVar.hsn = new bci();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnstagmemberoption";
        aVar.hsl = 291;
        aVar.hso = 115;
        aVar.hsp = 1000000115;
        this.gUA = aVar.BE();
        bch com_tencent_mm_protocal_c_bch = (bch) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bch.tce = i;
        com_tencent_mm_protocal_c_bch.udq = j;
        com_tencent_mm_protocal_c_bch.muQ = str;
        com_tencent_mm_protocal_c_bch.jNd = i2;
        com_tencent_mm_protocal_c_bch.tdM = this.scene;
        LinkedList linkedList = new LinkedList();
        for (String OV : list) {
            linkedList.add(new avx().OV(OV));
        }
        com_tencent_mm_protocal_c_bch.jNe = linkedList;
        w.d("MicroMsg.NetSceneSnsTagMemberOption", "rr.req.rImpl " + com_tencent_mm_protocal_c_bch.toString());
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 291;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneSnsTagMemberOption", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            bce com_tencent_mm_protocal_c_bce = ((bci) ((b) pVar).hsk.hsr).uds;
            w.d("MicroMsg.NetSceneSnsTagMemberOption", "Resp.rImpl " + com_tencent_mm_protocal_c_bce.toString());
            s dI = ae.beQ().dI(com_tencent_mm_protocal_c_bce.udq);
            dI.field_tagId = com_tencent_mm_protocal_c_bce.udq;
            dI.field_tagName = bg.ap(com_tencent_mm_protocal_c_bce.muQ, "");
            switch (this.fJA) {
                case 1:
                case 2:
                case 3:
                    dI.field_count = com_tencent_mm_protocal_c_bce.jNd;
                    dI.bw(com_tencent_mm_protocal_c_bce.jNe);
                    break;
            }
            ae.beQ().a(dI);
            this.gUD.a(i2, i3, str, this);
            return;
        }
        this.gUD.a(i2, i3, str, this);
    }
}
