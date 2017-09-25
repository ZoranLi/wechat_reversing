package com.tencent.mm.modelfriend;

import com.tencent.mm.e.b.af;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ajw;
import com.tencent.mm.protocal.c.ajx;
import com.tencent.mm.protocal.c.alu;
import com.tencent.mm.protocal.c.bcp;
import com.tencent.mm.protocal.c.my;
import com.tencent.mm.protocal.c.zj;
import com.tencent.mm.protocal.c.zk;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.x.h;
import com.tencent.mm.x.n;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class v extends k implements j {
    b gUA;
    private e gUD = null;
    private List<String> hBH;
    private List<String> hBa;

    public v() {
        FG();
        zj zjVar = (zj) this.gUA.hsj.hsr;
        zjVar.tuy = "";
        zjVar.tFN = null;
        zjVar.tFM = 0;
        zjVar.tFL = null;
        zjVar.tFK = 0;
        zjVar.mtF = 0;
        zjVar.tdM = 1;
    }

    public v(List<String> list, List<String> list2) {
        FG();
        if ((list != null && list.size() != 0) || (list2 != null && list2.size() != 0)) {
            this.hBa = list;
            this.hBH = list2;
            zj zjVar = (zj) this.gUA.hsj.hsr;
            zjVar.tuy = "";
            zjVar.mtF = 2;
            zjVar.tdM = 1;
        }
    }

    private void FG() {
        a aVar = new a();
        aVar.hsm = new zj();
        aVar.hsn = new zk();
        aVar.uri = "/cgi-bin/micromsg-bin/getmfriend";
        aVar.hsl = 142;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
    }

    public final void FH() {
        zj zjVar = (zj) this.gUA.hsj.hsr;
        ap.yY();
        zjVar.tuy = (String) c.vr().get(65828, null);
        zjVar.mtF = 1;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        zj zjVar = (zj) this.gUA.hsj.hsr;
        if (zjVar.mtF == 2) {
            if ((this.hBa == null || this.hBa.size() == 0) && (this.hBH == null || this.hBH.size() == 0)) {
                w.e("MicroMsg.NetSceneGetMFriend", "doScene failed, mobile list and email list empty.");
                return -1;
            }
            LinkedList linkedList;
            if (this.hBa != null && this.hBa.size() > 0) {
                w.d("MicroMsg.NetSceneGetMFriend", "doScene get mobile list size:%d", Integer.valueOf(this.hBa.size()));
                linkedList = new LinkedList();
                for (String str : this.hBa) {
                    alu com_tencent_mm_protocal_c_alu = new alu();
                    com_tencent_mm_protocal_c_alu.v = str;
                    linkedList.add(com_tencent_mm_protocal_c_alu);
                }
                zjVar.tFL = linkedList;
                zjVar.tFK = linkedList.size();
            }
            if (this.hBH != null && this.hBH.size() > 0) {
                w.d("MicroMsg.NetSceneGetMFriend", "doScene get email list size:%d", Integer.valueOf(this.hBH.size()));
                linkedList = new LinkedList();
                for (String str2 : this.hBH) {
                    ajw com_tencent_mm_protocal_c_ajw = new ajw();
                    com_tencent_mm_protocal_c_ajw.v = str2;
                    linkedList.add(com_tencent_mm_protocal_c_ajw);
                }
                zjVar.tFN = linkedList;
                zjVar.tFM = linkedList.size();
            }
        }
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 32;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        zk zkVar = (zk) this.gUA.hsk.hsr;
        zj zjVar = (zj) this.gUA.hsj.hsr;
        if (i2 == 4 && i3 == -68) {
            this.gUD.a(i2, i3, zkVar.tZe.tiE.tZr, this);
        } else if (i2 == 0 && i3 == 0) {
            w.d("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
            ap.yY();
            String mz = bg.mz((String) c.vr().get(65828, null));
            if (!(zjVar.mtF != 1 || bg.mA(zkVar.tuy) || zkVar.tuy.equals(mz))) {
                ap.yY();
                c.vr().set(65828, zkVar.tuy);
                af.FZ().Fe();
            }
            if (zkVar.msI == null) {
                w.e("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  friendlist null");
                return;
            }
            w.i("MicroMsg.NetSceneGetMFriend", "onGYNetEnd friend list size:%d", Integer.valueOf(zkVar.msI.size()));
            ap.yY();
            long cs = c.wO().cs(Thread.currentThread().getId());
            for (int i4 = 0; i4 < zkVar.msI.size(); i4++) {
                ajx com_tencent_mm_protocal_c_ajx = (ajx) zkVar.msI.get(i4);
                if (com_tencent_mm_protocal_c_ajx == null) {
                    w.e("MicroMsg.NetSceneGetMFriend", "Err getFriendList null");
                } else {
                    b ja = af.FY().ja(com_tencent_mm_protocal_c_ajx.hAC);
                    if (ja != null || zjVar.mtF == 1) {
                        ap.yY();
                        c.xB().eI(com_tencent_mm_protocal_c_ajx.tgG, com_tencent_mm_protocal_c_ajx.tBM);
                        h hVar = new h();
                        if (zjVar.mtF == 1) {
                            if (com_tencent_mm_protocal_c_ajx.tNA == null) {
                                w.e("MicroMsg.NetSceneGetMFriend", "ERR: facebook friend return null info");
                            } else {
                                hVar.gkt = com_tencent_mm_protocal_c_ajx.tNA.oUv;
                                hVar.hAX = com_tencent_mm_protocal_c_ajx.tNA.tws;
                                com.tencent.mm.x.b.gY(com_tencent_mm_protocal_c_ajx.tNA.oUv);
                                hVar.hAW = com_tencent_mm_protocal_c_ajx.tNA.msj;
                                hVar.gtR = com_tencent_mm_protocal_c_ajx.hAI;
                                hVar.gkC = com_tencent_mm_protocal_c_ajx.hAF;
                                hVar.gkB = com_tencent_mm_protocal_c_ajx.hAE;
                                hVar.signature = com_tencent_mm_protocal_c_ajx.hAG;
                                hVar.gkA = com_tencent_mm_protocal_c_ajx.hAH;
                                hVar.gkr = com_tencent_mm_protocal_c_ajx.hAD;
                                hVar.aIO = com_tencent_mm_protocal_c_ajx.tNz;
                                hVar.hAw = com.tencent.mm.platformtools.c.mq(com_tencent_mm_protocal_c_ajx.tNA.msj);
                                hVar.hAx = com.tencent.mm.platformtools.c.mp(com_tencent_mm_protocal_c_ajx.tNA.msj);
                                hVar.username = com_tencent_mm_protocal_c_ajx.tgG;
                            }
                        } else if (bg.mA(com_tencent_mm_protocal_c_ajx.tgG)) {
                            w.w("MicroMsg.NetSceneGetMFriend", "username null for mobile");
                        }
                        k kVar = new k();
                        kVar.username = com_tencent_mm_protocal_c_ajx.tgG;
                        kVar.gkB = com_tencent_mm_protocal_c_ajx.hAE;
                        kVar.gkC = com_tencent_mm_protocal_c_ajx.hAF;
                        kVar.signature = com_tencent_mm_protocal_c_ajx.hAG;
                        kVar.gkr = com_tencent_mm_protocal_c_ajx.hAD;
                        kVar.gkA = com_tencent_mm_protocal_c_ajx.hAH;
                        af afVar = null;
                        if (!bg.mA(com_tencent_mm_protocal_c_ajx.tgG)) {
                            ap.yY();
                            afVar = c.wR().Rc(com_tencent_mm_protocal_c_ajx.tgG);
                            if (afVar == null || !com_tencent_mm_protocal_c_ajx.tgG.equals(afVar.field_username)) {
                                afVar = null;
                            } else if (!(bg.mA(com_tencent_mm_protocal_c_ajx.hAI) || com_tencent_mm_protocal_c_ajx.hAI.equals(afVar.pA()))) {
                                afVar.bO(com_tencent_mm_protocal_c_ajx.hAI);
                                ap.yY();
                                c.wR().a(afVar.field_username, afVar);
                            }
                        }
                        if (bg.mA(com_tencent_mm_protocal_c_ajx.tgG)) {
                            Assert.assertTrue("mobile friend never go here", zjVar.mtF == 1);
                            hVar.status = 102;
                        } else if (afVar == null || !com.tencent.mm.j.a.ez(afVar.field_type)) {
                            hVar.status = 100;
                            if (ja != null) {
                                w.v("MicroMsg.NetSceneGetMFriend", "onGYNetEnd update status on, nick:" + com_tencent_mm_protocal_c_ajx.tNz + " realName:" + ja.ER() + "  MFriend:" + com_tencent_mm_protocal_c_ajx.toString());
                                ja.status = 1;
                                ja.username = com_tencent_mm_protocal_c_ajx.tgG;
                                ja.aIO = com_tencent_mm_protocal_c_ajx.tNz;
                                ja.hAw = com.tencent.mm.platformtools.c.mq(com_tencent_mm_protocal_c_ajx.tNA.msj);
                                ja.hAx = com.tencent.mm.platformtools.c.mp(com_tencent_mm_protocal_c_ajx.tNA.msj);
                                ja.hAB = ja.sZ();
                                a(ja, com_tencent_mm_protocal_c_ajx);
                                ja.fRW = -1;
                                af.FY().a(ja.EP(), ja);
                                h hVar2 = new h();
                                hVar2.username = com_tencent_mm_protocal_c_ajx.tgG;
                                hVar2.hrB = com_tencent_mm_protocal_c_ajx.tqb;
                                hVar2.hrA = com_tencent_mm_protocal_c_ajx.tqc;
                                hVar2.aV(true);
                                hVar2.gkq = 3;
                                n.Bm().a(hVar2);
                            }
                        } else {
                            hVar.status = 101;
                            if (ja != null) {
                                w.v("MicroMsg.NetSceneGetMFriend", "onGYNetEnd update status friend, nick:" + com_tencent_mm_protocal_c_ajx.tNz + "  md5:" + com_tencent_mm_protocal_c_ajx.hAC);
                                ja.status = 2;
                                ja.username = com_tencent_mm_protocal_c_ajx.tgG;
                                ja.aIO = com_tencent_mm_protocal_c_ajx.tNz;
                                ja.hAB = ja.sZ();
                                a(ja, com_tencent_mm_protocal_c_ajx);
                                ja.fRW = -1;
                                af.FY().a(ja.EP(), ja);
                                com.tencent.mm.x.b.u(com_tencent_mm_protocal_c_ajx.tgG, 3);
                            }
                        }
                        if (zjVar.mtF == 1) {
                            af.FZ().a(hVar);
                        }
                        af.Ga().a(kVar);
                    } else {
                        w.e("MicroMsg.NetSceneGetMFriend", "Err MD5 not found is AddrUploadStg, nickName: " + com_tencent_mm_protocal_c_ajx.tNz + " md5: " + com_tencent_mm_protocal_c_ajx.hAC);
                    }
                }
            }
            ap.yY();
            c.wO().aD(cs);
            this.gUD.a(i2, i3, str, this);
        } else {
            w.e("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
            this.gUD.a(i2, i3, str, this);
        }
    }

    private static void a(b bVar, ajx com_tencent_mm_protocal_c_ajx) {
        bVar.hAC = com_tencent_mm_protocal_c_ajx.hAC;
        bVar.hAD = com_tencent_mm_protocal_c_ajx.hAD;
        bVar.hAE = com_tencent_mm_protocal_c_ajx.hAE;
        bVar.hAF = com_tencent_mm_protocal_c_ajx.hAF;
        bVar.hAG = com_tencent_mm_protocal_c_ajx.hAG;
        bVar.hAH = com_tencent_mm_protocal_c_ajx.hAH;
        bVar.hAI = com_tencent_mm_protocal_c_ajx.hAI;
        bVar.hAJ = com_tencent_mm_protocal_c_ajx.hAJ;
        bVar.hAL = com_tencent_mm_protocal_c_ajx.hAL;
        bVar.hAK = com_tencent_mm_protocal_c_ajx.hAK;
        bVar.hAM = com_tencent_mm_protocal_c_ajx.hAM;
        bVar.hAN = com_tencent_mm_protocal_c_ajx.hAN;
        bcp com_tencent_mm_protocal_c_bcp = com_tencent_mm_protocal_c_ajx.tMV;
        if (com_tencent_mm_protocal_c_bcp != null) {
            bVar.hAO = com_tencent_mm_protocal_c_bcp.hAO;
            bVar.hAP = com_tencent_mm_protocal_c_bcp.hAP;
            bVar.hAQ = com_tencent_mm_protocal_c_bcp.hAQ;
        }
        my myVar = com_tencent_mm_protocal_c_ajx.tMW;
        if (myVar != null) {
            bVar.hAR = myVar.hAR;
            bVar.hAS = myVar.hAS;
            bVar.hAT = myVar.hAT;
            bVar.hAU = myVar.hAU;
        }
    }
}
