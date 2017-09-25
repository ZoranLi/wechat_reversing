package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.e.b.af;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.protocal.c.ame;
import com.tencent.mm.protocal.c.bcp;
import com.tencent.mm.protocal.c.fi;
import com.tencent.mm.protocal.c.fj;
import com.tencent.mm.protocal.c.fk;
import com.tencent.mm.protocal.c.fl;
import com.tencent.mm.protocal.c.fm;
import com.tencent.mm.protocal.c.my;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import java.util.Iterator;
import java.util.LinkedList;

public final class k extends com.tencent.mm.y.k implements j {
    private e gWW = null;
    private b ldw = null;
    private String[] ldx;

    public k(String[] strArr, String str) {
        this.ldx = strArr;
        w.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "NetSceneBatchSearchHardDevice, %s, list = %d", new Object[]{str, Integer.valueOf(1)});
        a aVar = new a();
        aVar.hsm = new fk();
        aVar.hsn = new fl();
        aVar.hsl = 542;
        aVar.uri = "/cgi-bin/micromsg-bin/batchsearchharddevice";
        aVar.hso = 0;
        aVar.hsp = 0;
        this.ldw = aVar.BE();
        fk fkVar = (fk) this.ldw.hsj.hsr;
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i <= 0; i++) {
            String str2 = strArr[0];
            if (str2 != null) {
                fj fjVar = new fj();
                fjVar.tiU = str2;
                linkedList.add(fjVar);
                w.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "NetSceneBatchSearchHardDevice, item = %s", new Object[]{str2});
            }
        }
        fkVar.tiV = linkedList;
        if (!bg.mA(str)) {
            fi fiVar = new fi();
            fiVar.tiT = str;
            fkVar.tiW = fiVar;
        }
        fkVar.tiX = 3;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "onGYNetEnd, netId = %d, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.ldx != null && this.ldx.length == 1) {
            w.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "device mac is  = %s", new Object[]{this.ldx[0]});
        }
        if (pVar == null) {
            w.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "null == rr");
        } else if (this.ldw.hsl != pVar.getType()) {
            w.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "mReqResp.getType(%d) != rr.getType(%d)", new Object[]{Integer.valueOf(this.ldw.hsl), Integer.valueOf(pVar.getType())});
        } else {
            if (i2 == 0 && i3 == 0) {
                Iterator it = apl().tiY.iterator();
                while (it.hasNext()) {
                    fm fmVar = (fm) it.next();
                    w.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "BatchSearchHardDeviceResp, ret = %d, bind ticket = %s, mac = %s, device name = %s", new Object[]{Integer.valueOf(fmVar.thX), fmVar.tiZ, fmVar.tiU, fmVar.jNn});
                    if (fmVar.tja == null) {
                        w.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "null == item.Contact");
                    } else {
                        ame com_tencent_mm_protocal_c_ame = fmVar.tja;
                        if (com_tencent_mm_protocal_c_ame == null) {
                            w.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "unable to parse mod contact");
                        } else {
                            String a = n.a(com_tencent_mm_protocal_c_ame.ttp);
                            String mz = bg.mz(com_tencent_mm_protocal_c_ame.tQL);
                            if (bg.mA(a) && bg.mA(mz)) {
                                w.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "processModContact user is null user:%s enuser:%s", new Object[]{a, mz});
                            } else {
                                w.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "processModContact : %s", new Object[]{a});
                                ap.yY();
                                af Rc = c.wR().Rc(a);
                                if (Rc == null || !a.equals(Rc.field_encryptUsername)) {
                                    af xVar = new x(a);
                                    xVar.bO(com_tencent_mm_protocal_c_ame.hAI);
                                    xVar.setType(com_tencent_mm_protocal_c_ame.tsx & com_tencent_mm_protocal_c_ame.tsy);
                                    if (!bg.mA(mz)) {
                                        xVar.bX(mz);
                                    } else if (Rc != null && ((int) Rc.gTQ) > 0) {
                                        xVar.bX(Rc.field_encryptUsername);
                                    }
                                    xVar.gTQ = Rc == null ? 0 : (long) ((int) Rc.gTQ);
                                    xVar.bR(n.a(com_tencent_mm_protocal_c_ame.tLj));
                                    xVar.bS(n.a(com_tencent_mm_protocal_c_ame.ttf));
                                    xVar.bT(n.a(com_tencent_mm_protocal_c_ame.ttg));
                                    xVar.di(com_tencent_mm_protocal_c_ame.hAD);
                                    xVar.dl(com_tencent_mm_protocal_c_ame.tsD);
                                    xVar.bQ(n.a(com_tencent_mm_protocal_c_ame.tQF));
                                    xVar.dm(com_tencent_mm_protocal_c_ame.tsH);
                                    xVar.dn(com_tencent_mm_protocal_c_ame.hAH);
                                    xVar.ck(RegionCodeDecoder.ab(com_tencent_mm_protocal_c_ame.hAM, com_tencent_mm_protocal_c_ame.hAE, com_tencent_mm_protocal_c_ame.hAF));
                                    xVar.ce(com_tencent_mm_protocal_c_ame.hAG);
                                    xVar.de(com_tencent_mm_protocal_c_ame.tMP);
                                    xVar.cj(com_tencent_mm_protocal_c_ame.tMQ);
                                    xVar.setSource(com_tencent_mm_protocal_c_ame.tfW);
                                    xVar.dd(com_tencent_mm_protocal_c_ame.tMT);
                                    xVar.bU(com_tencent_mm_protocal_c_ame.tMS);
                                    if (o.fK(com_tencent_mm_protocal_c_ame.tMR)) {
                                        xVar.ci(com_tencent_mm_protocal_c_ame.tMR);
                                    }
                                    xVar.dp((int) bg.Ny());
                                    xVar.bP(n.a(com_tencent_mm_protocal_c_ame.tQl));
                                    xVar.bV(n.a(com_tencent_mm_protocal_c_ame.tQn));
                                    xVar.bW(n.a(com_tencent_mm_protocal_c_ame.tQm));
                                    xVar.cl(com_tencent_mm_protocal_c_ame.tgT);
                                    xVar.cm(com_tencent_mm_protocal_c_ame.tQV);
                                    if (!(Rc == null || bg.mz(Rc.gkL).equals(bg.mz(com_tencent_mm_protocal_c_ame.tQV)))) {
                                        com.tencent.mm.ar.c.Ih();
                                        com.tencent.mm.ar.c.jW(a);
                                    }
                                    ap.yY();
                                    c.wR().Rh(a);
                                    if (bg.mA(xVar.field_username)) {
                                        w.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "dkinit dealModContactExtInfo failed invalid contact");
                                    } else {
                                        String str2 = xVar.field_username;
                                        com.tencent.mm.x.n.Bm().a(com.tencent.mm.x.b.a(str2, com_tencent_mm_protocal_c_ame));
                                        bcp com_tencent_mm_protocal_c_bcp = com_tencent_mm_protocal_c_ame.tMV;
                                        if (!(xVar.field_username.endsWith("@chatroom") || com_tencent_mm_protocal_c_bcp == null)) {
                                            w.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsFlag modcontact " + com_tencent_mm_protocal_c_bcp.hAO + " " + com_tencent_mm_protocal_c_ame.ttp);
                                            w.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBg modcontact " + com_tencent_mm_protocal_c_bcp.hAP);
                                            w.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBgId modcontact " + com_tencent_mm_protocal_c_bcp.hAQ);
                                            w.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBgId modcontact " + com_tencent_mm_protocal_c_bcp.udF);
                                            if (m.pQB != null) {
                                                m.pQB.a(xVar.field_username, com_tencent_mm_protocal_c_bcp);
                                            }
                                        }
                                        String xL = com.tencent.mm.u.m.xL();
                                        if (!(xL == null || xL.equals(str2))) {
                                            BizInfo hO = com.tencent.mm.modelbiz.w.DH().hO(str2);
                                            hO.field_username = str2;
                                            hO.field_brandList = com_tencent_mm_protocal_c_ame.hAN;
                                            my myVar = com_tencent_mm_protocal_c_ame.tMW;
                                            if (myVar != null) {
                                                hO.field_brandFlag = myVar.hAR;
                                                hO.field_brandInfo = myVar.hAT;
                                                hO.field_brandIconURL = myVar.hAU;
                                                hO.field_extInfo = myVar.hAS;
                                                hO.field_attrSyncVersion = null;
                                                hO.field_incrementUpdateTime = 0;
                                            }
                                            if (!com.tencent.mm.modelbiz.w.DH().e(hO)) {
                                                com.tencent.mm.modelbiz.w.DH().d(hO);
                                            }
                                            xVar.dq(hO.field_type);
                                        }
                                    }
                                    xVar.dg(com_tencent_mm_protocal_c_ame.tQU);
                                    if (!(com_tencent_mm_protocal_c_ame.tQQ == null || com_tencent_mm_protocal_c_ame.tQQ.tfr == null)) {
                                        xVar.cn(com_tencent_mm_protocal_c_ame.tQQ.tfr.tjr);
                                        xVar.co(com_tencent_mm_protocal_c_ame.tQQ.tfr.tjs);
                                        xVar.cp(com_tencent_mm_protocal_c_ame.tQQ.tfr.tjt);
                                    }
                                    if (o.fE(a)) {
                                        xVar.tl();
                                    }
                                    if (xVar.bLe()) {
                                        xVar.to();
                                    }
                                    if (bg.mA(mz)) {
                                        ap.yY();
                                        c.wR().Q(xVar);
                                    } else {
                                        ap.yY();
                                        c.wR().b(mz, xVar);
                                    }
                                    if (!(Rc == null || (Rc.field_type & 2048) == (xVar.field_type & 2048))) {
                                        if ((xVar.field_type & 2048) != 0) {
                                            ap.yY();
                                            c.wW().Rr(xVar.field_username);
                                        } else {
                                            ap.yY();
                                            c.wW().Rs(xVar.field_username);
                                        }
                                    }
                                } else {
                                    w.w("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "cat's replace user with stranger");
                                }
                            }
                        }
                    }
                }
            }
            this.gWW.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 542;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gWW = eVar2;
        return a(eVar, this.ldw, this);
    }

    public final fl apl() {
        if (this.ldw == null || this.ldw.hsk.hsr == null) {
            return null;
        }
        return (fl) this.ldw.hsk.hsr;
    }
}
