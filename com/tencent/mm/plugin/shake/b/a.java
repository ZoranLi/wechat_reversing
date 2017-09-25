package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.e.b.af;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.azi;
import com.tencent.mm.protocal.c.azj;
import com.tencent.mm.protocal.c.azk;
import com.tencent.mm.protocal.c.my;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ar;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.x.h;
import com.tencent.mm.x.n;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.List;

public final class a extends k implements j {
    private b gUA;
    private e gUD;
    private String khk;
    List<d> pob;
    private int poc;
    int ret;

    public a(byte[] bArr) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new azj();
        aVar.hsn = new azk();
        aVar.uri = "/cgi-bin/micromsg-bin/shakeget";
        aVar.hsl = 162;
        aVar.hso = 57;
        aVar.hsp = 1000000057;
        this.gUA = aVar.BE();
        azj com_tencent_mm_protocal_c_azj = (azj) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_azj.tij = new avw().bb(bArr);
        com_tencent_mm_protocal_c_azj.uaI = 1;
        com_tencent_mm_protocal_c_azj.tNc = new avw().bb(d.nZC.aPl());
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.d("MicroMsg.NetSceneShakeGet", "doScene");
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 162;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneShakeGet", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        azk com_tencent_mm_protocal_c_azk = (azk) this.gUA.hsk.hsr;
        this.pob = new LinkedList();
        this.poc = com_tencent_mm_protocal_c_azk.uaK;
        this.ret = com_tencent_mm_protocal_c_azk.thX;
        this.khk = com_tencent_mm_protocal_c_azk.opH;
        int i4 = com_tencent_mm_protocal_c_azk.jNd;
        w.d("MicroMsg.NetSceneShakeGet", "size:" + i4);
        ap.yY();
        ar wR = c.wR();
        if (i4 > 0) {
            e baS = m.baS();
            baS.baK();
            w.i("MicroMsg.NewShakeItemStorage", "delOldRecord count:" + i4);
            if (baS.gUz.eE("shakeitem1", "DELETE FROM shakeitem1 WHERE shakeItemID NOT IN ( SELECT shakeItemID FROM shakeitem1 ORDER BY shakeItemID DESC LIMIT " + (100 > i4 ? 100 - i4 : 0) + " )")) {
                w.i("MicroMsg.NewShakeItemStorage", "delOldRecord success count:" + i4);
                baS.doNotify();
            }
            for (i4--; i4 >= 0; i4--) {
                if (!m.xL().equals(((azi) com_tencent_mm_protocal_c_azk.uaJ.get(i4)).jNj)) {
                    BizInfo hO = com.tencent.mm.modelbiz.w.DH().hO(((azi) com_tencent_mm_protocal_c_azk.uaJ.get(i4)).jNj);
                    hO.field_username = ((azi) com_tencent_mm_protocal_c_azk.uaJ.get(i4)).jNj;
                    hO.field_brandList = ((azi) com_tencent_mm_protocal_c_azk.uaJ.get(i4)).hAN;
                    my myVar = ((azi) com_tencent_mm_protocal_c_azk.uaJ.get(i4)).tMW;
                    if (myVar != null) {
                        hO.field_brandFlag = myVar.hAR;
                        hO.field_brandInfo = myVar.hAT;
                        hO.field_brandIconURL = myVar.hAU;
                        hO.field_extInfo = myVar.hAS;
                    }
                    if (!com.tencent.mm.modelbiz.w.DH().e(hO)) {
                        com.tencent.mm.modelbiz.w.DH().d(hO);
                    }
                }
                d dVar = new d((azi) com_tencent_mm_protocal_c_azk.uaJ.get(i4));
                h hVar = new h();
                hVar.username = dVar.field_username;
                hVar.aV(dVar.field_hasHDImg > 0);
                hVar.gkq = dVar.field_imgstatus;
                hVar.hrB = ((azi) com_tencent_mm_protocal_c_azk.uaJ.get(i4)).tqb;
                hVar.hrA = ((azi) com_tencent_mm_protocal_c_azk.uaJ.get(i4)).tqc;
                n.Bm().a(hVar);
                hVar.fRW = -1;
                w.d("MicroMsg.NetSceneShakeGet", "dkhurl search %s b[%s] s[%s]", new Object[]{hVar.getUsername(), hVar.Bs(), hVar.Bt()});
                dVar.field_reserved2 = wR.QY(dVar.field_username) ? 1 : 0;
                af Rc = wR.Rc(dVar.field_username);
                if (Rc != null && ((int) Rc.gTQ) > 0) {
                    baS.Ed(Rc.field_username);
                    baS.Ed(Rc.field_encryptUsername);
                }
                baS.a(dVar, false);
                ap.yY();
                c.xB().o(dVar.field_username, this.poc, ((azi) com_tencent_mm_protocal_c_azk.uaJ.get(i4)).tBM);
                dVar.scene = this.poc;
                this.pob.add(dVar);
                w.v("MicroMsg.NetSceneShakeGet", "item info: " + dVar.field_username + " " + dVar.field_nickname);
            }
        }
        this.gUD.a(i2, i3, str, this);
    }
}
