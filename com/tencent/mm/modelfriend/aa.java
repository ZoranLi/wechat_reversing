package com.tencent.mm.modelfriend;

import com.tencent.mm.a.g;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ajw;
import com.tencent.mm.protocal.c.alu;
import com.tencent.mm.protocal.c.bhr;
import com.tencent.mm.protocal.c.bhs;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class aa extends k implements j {
    private int fJK;
    private e gUD;
    public final List<String> hBO;
    public final List<String> hBP;
    private final String hBQ = ((String) c.vr().get(6, null));
    private int hBR = 0;
    private int hBS = 0;

    public aa(List<String> list, List<String> list2) {
        ap.yY();
        this.hBO = list;
        this.hBP = list2;
        this.fJK = 1;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 0;
        this.gUD = eVar2;
        if ((this.hBO == null || this.hBO.size() == 0) && (this.hBP == null || this.hBP.size() == 0)) {
            w.i("MicroMsg.NetSceneUploadMContact", "listMobile or listEmile is null or zero");
            return -1;
        }
        a aVar = new a();
        aVar.hsm = new bhr();
        aVar.hsn = new bhs();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadmcontact";
        aVar.hsl = com.tencent.mm.plugin.appbrand.jsapi.map.e.CTRL_INDEX;
        aVar.hso = 0;
        aVar.hsp = 0;
        p BE = aVar.BE();
        bhr com_tencent_mm_protocal_c_bhr = (bhr) BE.hsj.hsr;
        com_tencent_mm_protocal_c_bhr.tjy = this.hBQ;
        com_tencent_mm_protocal_c_bhr.jNj = m.xL();
        com_tencent_mm_protocal_c_bhr.thO = this.fJK;
        int i2 = com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        while (i2 > 0) {
            if (this.hBO != null && this.hBR < this.hBO.size()) {
                if (this.hBO.get(this.hBR) != null) {
                    alu com_tencent_mm_protocal_c_alu = new alu();
                    com_tencent_mm_protocal_c_alu.v = (String) this.hBO.get(this.hBR);
                    linkedList.add(com_tencent_mm_protocal_c_alu);
                }
                this.hBR++;
                i2--;
            }
            if (this.hBP != null && this.hBS < this.hBP.size()) {
                if (this.hBP.get(this.hBS) != null) {
                    ajw com_tencent_mm_protocal_c_ajw = new ajw();
                    com_tencent_mm_protocal_c_ajw.v = (String) this.hBP.get(this.hBS);
                    linkedList2.add(com_tencent_mm_protocal_c_ajw);
                }
                this.hBS++;
                i2--;
            }
            if ((this.hBP == null || this.hBS >= this.hBP.size()) && (this.hBO == null || this.hBR >= this.hBO.size())) {
                break;
            }
        }
        com_tencent_mm_protocal_c_bhr.tNl = linkedList;
        com_tencent_mm_protocal_c_bhr.uhc = linkedList.size();
        com_tencent_mm_protocal_c_bhr.uhe = linkedList2;
        com_tencent_mm_protocal_c_bhr.uhd = linkedList2.size();
        String str = "MicroMsg.NetSceneUploadMContact";
        StringBuilder append = new StringBuilder("doscene in:[").append(this.hBP == null ? 0 : this.hBP.size()).append(",");
        if (this.hBO != null) {
            i = this.hBO.size();
        }
        w.v(str, append.append(i).append("] index:[").append(this.hBS).append(",").append(this.hBR).append("] req:[").append(com_tencent_mm_protocal_c_bhr.uhe.size()).append(",").append(com_tencent_mm_protocal_c_bhr.tNl.size()).append("]").toString());
        return a(eVar, BE, this);
    }

    public final boolean BI() {
        return true;
    }

    protected final int a(p pVar) {
        bhr com_tencent_mm_protocal_c_bhr = (bhr) ((b) pVar).hsj.hsr;
        int size = com_tencent_mm_protocal_c_bhr.uhe.size() + com_tencent_mm_protocal_c_bhr.tNl.size();
        if (size == 0 || size > com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX) {
            w.e("MicroMsg.NetSceneUploadMContact", "security checked failed : exceed max send count");
            return b.hsU;
        } else if (com_tencent_mm_protocal_c_bhr.tjy == null || com_tencent_mm_protocal_c_bhr.tjy.length() <= 0) {
            w.e("MicroMsg.NetSceneUploadMContact", "security checked failed : moblie null");
            return b.hsU;
        } else if (com_tencent_mm_protocal_c_bhr.jNj != null && com_tencent_mm_protocal_c_bhr.jNj.length() > 0) {
            return b.hsT;
        } else {
            w.e("MicroMsg.NetSceneUploadMContact", "security checked failed : username null");
            return b.hsU;
        }
    }

    protected final int ub() {
        return 10;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneUploadMContact", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (i2 == 0 && i3 == 0) {
            bhr com_tencent_mm_protocal_c_bhr = (bhr) ((b) pVar).hsj.hsr;
            m.E(G(com_tencent_mm_protocal_c_bhr.uhe));
            m.E(H(com_tencent_mm_protocal_c_bhr.tNl));
            if ((this.hBP == null || this.hBS >= this.hBP.size()) && (this.hBO == null || this.hBR >= this.hBO.size())) {
                this.gUD.a(i2, i3, str, this);
                return;
            } else if (a(this.hsD, this.gUD) < 0) {
                this.gUD.a(i2, i3, str, this);
                return;
            } else {
                return;
            }
        }
        w.e("MicroMsg.NetSceneUploadMContact", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.gUD.a(i2, i3, str, this);
    }

    private static List<String> G(List<ajw> list) {
        List<String> arrayList = new ArrayList();
        if (list == null || list.size() == 0) {
            w.i("MicroMsg.NetSceneUploadMContact", "the req emai list is empty");
            return arrayList;
        }
        for (ajw com_tencent_mm_protocal_c_ajw : list) {
            arrayList.add(com_tencent_mm_protocal_c_ajw.v);
        }
        return arrayList;
    }

    private static List<String> H(List<alu> list) {
        List<String> arrayList = new ArrayList();
        if (list == null || list.size() == 0) {
            w.i("MicroMsg.NetSceneUploadMContact", "the req mobile list is empty");
            return arrayList;
        }
        for (alu com_tencent_mm_protocal_c_alu : list) {
            arrayList.add(g.n(com.tencent.mm.pluginsdk.a.Di(com_tencent_mm_protocal_c_alu.v).getBytes()));
        }
        return arrayList;
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.map.e.CTRL_INDEX;
    }
}
