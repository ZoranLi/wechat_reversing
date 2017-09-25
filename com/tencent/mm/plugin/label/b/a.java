package com.tencent.mm.plugin.label.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.c;
import com.tencent.mm.protocal.c.aim;
import com.tencent.mm.protocal.c.bl;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.z;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a extends k implements j {
    private final b gUA;
    private e gUD;
    private LinkedList<aim> mYU = new LinkedList();

    public a(String str) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new bl();
        aVar.hsn = new bm();
        aVar.uri = "/cgi-bin/micromsg-bin/addcontactlabel";
        aVar.hsl = 635;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        if (!bg.mA(str)) {
            aim com_tencent_mm_protocal_c_aim = new aim();
            com_tencent_mm_protocal_c_aim.tMu = str;
            this.mYU.add(com_tencent_mm_protocal_c_aim);
        }
    }

    public a(List<String> list) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new bl();
        aVar.hsn = new bm();
        aVar.uri = "/cgi-bin/micromsg-bin/addcontactlabel";
        aVar.hsl = 635;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                aim com_tencent_mm_protocal_c_aim = new aim();
                com_tencent_mm_protocal_c_aim.tMu = (String) list.get(i);
                this.mYU.add(com_tencent_mm_protocal_c_aim);
            }
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.d("MicroMsg.Label.NetSceneAddContactLabel", "cpan[doScene].");
        this.gUD = eVar2;
        bl blVar = (bl) this.gUA.hsj.hsr;
        if (this.mYU == null || this.mYU.size() <= 0) {
            w.e("MicroMsg.Label.NetSceneAddContactLabel", "cpan[doScene] label list is null.");
            eVar2.a(3, -1, "[doScene]empty contact list.", this);
            return 0;
        }
        blVar.teP = this.mYU;
        blVar.teO = this.mYU.size();
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.Label.NetSceneAddContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        bm aFH = aFH();
        if (aFH != null) {
            LinkedList linkedList = aFH.teP;
            List arrayList = new ArrayList();
            int size = linkedList.size();
            for (int i4 = 0; i4 < size; i4++) {
                aim com_tencent_mm_protocal_c_aim = (aim) linkedList.get(i4);
                z zVar = new z();
                zVar.field_labelID = com_tencent_mm_protocal_c_aim.tMv;
                zVar.field_labelName = com_tencent_mm_protocal_c_aim.tMu;
                zVar.field_labelPYFull = c.mp(com_tencent_mm_protocal_c_aim.tMu);
                zVar.field_labelPYShort = c.mq(com_tencent_mm_protocal_c_aim.tMu);
                zVar.field_isTemporary = false;
                arrayList.add(zVar);
            }
            com.tencent.mm.plugin.label.e.aFF().bY(arrayList);
            com.tencent.mm.plugin.label.e.aFF().bZ(arrayList);
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 635;
    }

    public final bm aFH() {
        return (bm) this.gUA.hsk.hsr;
    }
}
