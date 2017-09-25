package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.appbrand.jsapi.e.c;
import com.tencent.mm.protocal.c.amj;
import com.tencent.mm.protocal.c.amk;
import com.tencent.mm.protocal.c.aml;
import com.tencent.mm.protocal.c.amm;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class af extends k implements j {
    private final b gUA;
    private e gUD;
    public int lFF;
    public g lFG;
    private LinkedList<amm> lFH;
    private LinkedList<amj> lFI;
    public String lFJ;
    public int type;

    private af(int i, LinkedList<amj> linkedList, LinkedList<amm> linkedList2, int i2) {
        this.gUD = null;
        a aVar = new a();
        aVar.hsm = new amk();
        aVar.hsn = new aml();
        aVar.uri = "/cgi-bin/micromsg-bin/modfavitem";
        aVar.hsl = 426;
        aVar.hso = c.CTRL_INDEX;
        aVar.hsp = 1000000216;
        this.gUA = aVar.BE();
        this.lFH = linkedList2;
        this.lFI = linkedList;
        this.lFF = i;
        this.type = i2;
    }

    public af(int i, LinkedList<amj> linkedList, LinkedList<amm> linkedList2) {
        this(i, (LinkedList) linkedList, (LinkedList) linkedList2, 0);
    }

    public af(int i, g gVar) {
        this(i, gVar.field_modItem.lFI, gVar.field_modItem.tza, 1);
        this.lFG = gVar;
    }

    public af(int i, LinkedList<amj> linkedList, LinkedList<amm> linkedList2, String str) {
        this(i, (LinkedList) linkedList, (LinkedList) linkedList2, 0);
        this.lFJ = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (this.lFI == null || this.lFI.size() == 0) {
            return -1;
        }
        amk com_tencent_mm_protocal_c_amk = (amk) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_amk.tRe = this.lFI.size();
        if (this.lFH != null) {
            com_tencent_mm_protocal_c_amk.tRg = this.lFH.size();
            com_tencent_mm_protocal_c_amk.tiQ = this.lFH;
        } else {
            com_tencent_mm_protocal_c_amk.tRg = 0;
            com_tencent_mm_protocal_c_amk.tiQ = new LinkedList();
        }
        if (!bg.mA(this.lFJ)) {
            com_tencent_mm_protocal_c_amk.tRh = this.lFJ;
        }
        com_tencent_mm_protocal_c_amk.tRe = this.lFI.size();
        com_tencent_mm_protocal_c_amk.tRf = this.lFI;
        com_tencent_mm_protocal_c_amk.teS = this.lFF;
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final long atS() {
        if (this.lFG == null) {
            return -1;
        }
        return this.lFG.field_localId;
    }

    public final int atT() {
        if (this.lFG == null) {
            return -1;
        }
        return this.lFG.field_type;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneModFavItem", "favId: " + this.lFF + ", netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 426;
    }
}
