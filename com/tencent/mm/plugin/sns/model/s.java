package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.e.a.pj;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.protocal.c.bcl;
import com.tencent.mm.protocal.c.bcm;
import com.tencent.mm.protocal.c.ca;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class s extends k implements j {
    public int Ul = 0;
    final int fFq;
    private b gUA;
    public e gUD;
    private long pTP = 0;
    public int pTR = 0;
    public int pTS = 0;
    private long pUo = 0;
    private String pUp = "";

    public s() {
        int i;
        a aVar = new a();
        aVar.hsm = new bcl();
        aVar.hsn = new bcm();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnspreloadingtimeline";
        aVar.hsl = 718;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        if (am.isWifi(ab.getContext())) {
            i = 1;
        } else if (am.is3G(ab.getContext())) {
            i = 3;
        } else if (am.is4G(ab.getContext())) {
            i = 4;
        } else if (am.is2G(ab.getContext())) {
            i = 2;
        } else {
            i = 0;
        }
        this.fFq = 2;
        bcl com_tencent_mm_protocal_c_bcl = (bcl) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bcl.udw = i;
        com_tencent_mm_protocal_c_bcl.ubY = 0;
        int bfj = ae.beB().bfj();
        this.pTP = ae.beL().f(0, bfj, true);
        com_tencent_mm_protocal_c_bcl.udt = this.pTP;
        com_tencent_mm_protocal_c_bcl.udu = c.a(this.pTP, 0, "@__weixintimtline");
        this.pUo = ae.beL().f(0, 1, true);
        w.i("MicroMsg.NetSceneSnsPreTimeLine", "newerid " + this.pUo);
        com_tencent_mm_protocal_c_bcl.udv = this.pUo;
        com.tencent.mm.plugin.sns.storage.k Gk = ae.beO().Gk("@__weixintimtline");
        this.pUp = Gk == null ? "" : Gk.field_md5;
        if (this.pUp == null) {
            this.pUp = "";
        }
        com_tencent_mm_protocal_c_bcl.ubX = this.pUp;
        if (Gk == null || Gk.field_adsession == null) {
            com_tencent_mm_protocal_c_bcl.ubE = new avw().bb(new byte[0]);
        } else {
            w.d("MicroMsg.NetSceneSnsPreTimeLine", "request adsession %s", new Object[]{Gk.field_adsession});
            com_tencent_mm_protocal_c_bcl.ubE = new avw().bb(Gk.field_adsession);
        }
        w.i("MicroMsg.NetSceneSnsPreTimeLine", " This req nextCount: " + bfj + " min:" + this.pTP + " ReqTime:" + com_tencent_mm_protocal_c_bcl.udu + " nettype: " + i);
        w.d("MicroMsg.NetSceneSnsPreTimeLine", "minId: %s lastReqTime: %s", new Object[]{i.df(this.pTP), Integer.valueOf(r7)});
    }

    private void a(bcm com_tencent_mm_protocal_c_bcm, String str) {
        ai.a("@__weixintimtline", this.fFq, com_tencent_mm_protocal_c_bcm.tiQ, str);
        this.pTP = ((bbk) com_tencent_mm_protocal_c_bcm.tiQ.getLast()).tmx;
        c.b("@__weixintimtline", ((bbk) com_tencent_mm_protocal_c_bcm.tiQ.getFirst()).tmx, this.pTP, com_tencent_mm_protocal_c_bcm.udx);
        Iterator it = com_tencent_mm_protocal_c_bcm.tiQ.iterator();
        while (it.hasNext()) {
            bbk com_tencent_mm_protocal_c_bbk = (bbk) it.next();
            if (com_tencent_mm_protocal_c_bbk.ucu == 0) {
                m dG = ae.beL().dG(com_tencent_mm_protocal_c_bbk.tmx);
                if (!(dG == null || dG.bhd() == null)) {
                    List<alh> list = dG.bhd().ufB.tsO;
                    for (alh com_tencent_mm_protocal_c_alh : list) {
                        Object obj = list.size() <= 1 ? 1 : null;
                        if (com_tencent_mm_protocal_c_alh != null) {
                            String e = i.e(com_tencent_mm_protocal_c_alh);
                            int i = obj != null ? 1 : 0;
                            String du = am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY);
                            if (FileOp.aO(du + e) || FileOp.aO(du + i.l(com_tencent_mm_protocal_c_alh)) || FileOp.aO(du + i.m(com_tencent_mm_protocal_c_alh))) {
                                w.i("MicroMsg.NetSceneSnsPreTimeLine", "dealwithMedia exist:%s", new Object[]{com_tencent_mm_protocal_c_alh.mQY});
                            } else {
                                w.i("MicroMsg.NetSceneSnsPreTimeLine", "dealwithMedia ready to download:%s", new Object[]{com_tencent_mm_protocal_c_alh.mQY});
                                com.tencent.mm.plugin.sns.data.e eVar = new com.tencent.mm.plugin.sns.data.e(com_tencent_mm_protocal_c_alh);
                                eVar.pQS = i;
                                eVar.nif = com_tencent_mm_protocal_c_alh.mQY;
                                ae.beG().a(com_tencent_mm_protocal_c_alh, 1, eVar, an.uJE);
                            }
                        }
                    }
                    if (dG.field_type == 15) {
                        aq beJ = ae.beJ();
                        if (dG != null) {
                            w.i("MicroMsg.SnsVideoService", "%d add preload video[%s]", new Object[]{Integer.valueOf(beJ.hashCode()), dG.bhy()});
                            synchronized (beJ.pXD) {
                                beJ.pXD.addFirst(dG);
                            }
                        }
                        try {
                            String str2 = ((alh) dG.bhd().ufB.tsO.get(0)).msN;
                            g.oUh.i(14388, new Object[]{Long.valueOf(com_tencent_mm_protocal_c_bbk.tmx), Integer.valueOf(4), str2, Integer.valueOf(0)});
                        } catch (Exception e2) {
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        ae.beJ().bfo();
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneSnsPreTimeLine", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        bcm com_tencent_mm_protocal_c_bcm = (bcm) ((b) pVar).hsk.hsr;
        if (pVar.zg().sZC == 207 || pVar.zg().sZC == 0) {
            if (com_tencent_mm_protocal_c_bcm.ucd != null) {
                w.d("MicroMsg.NetSceneSnsPreTimeLine", "serverConfig  " + com_tencent_mm_protocal_c_bcm.ucd.udp + " " + com_tencent_mm_protocal_c_bcm.ucd.udo);
                int i4 = com_tencent_mm_protocal_c_bcm.ucd.udp;
                com.tencent.mm.plugin.sns.c.a.pQH = i4;
                if (i4 <= 0) {
                    com.tencent.mm.plugin.sns.c.a.pQH = Integer.MAX_VALUE;
                }
                v.uzf = com_tencent_mm_protocal_c_bcm.ucd.udo;
            }
            this.pTR = com_tencent_mm_protocal_c_bcm.ucb;
            this.pTS = com_tencent_mm_protocal_c_bcm.ucc;
            w.i("MicroMsg.NetSceneSnsPreTimeLine", "for same md5 count: " + com_tencent_mm_protocal_c_bcm.ucb + " , objCount:  " + com_tencent_mm_protocal_c_bcm.tRg + " cflag : " + com_tencent_mm_protocal_c_bcm.ucc);
            this.Ul = com_tencent_mm_protocal_c_bcm.tRg;
            String dg = i.dg(0);
            if (com_tencent_mm_protocal_c_bcm.tiQ.isEmpty()) {
                w.i("MicroMsg.NetSceneSnsPreTimeLine", " respone is Empty");
            } else {
                w.i("MicroMsg.NetSceneSnsPreTimeLine", "respone size " + com_tencent_mm_protocal_c_bcm.tiQ.size() + " Max " + ((bbk) com_tencent_mm_protocal_c_bcm.tiQ.getFirst()).tmx + " " + i.df(((bbk) com_tencent_mm_protocal_c_bcm.tiQ.getFirst()).tmx) + "  respone min  " + ((bbk) com_tencent_mm_protocal_c_bcm.tiQ.getLast()).tmx + " " + i.df(((bbk) com_tencent_mm_protocal_c_bcm.tiQ.getLast()).tmx));
            }
            this.Ul = com_tencent_mm_protocal_c_bcm.tRg;
            if (this.pUp.equals(com_tencent_mm_protocal_c_bcm.ubX)) {
                this.pTP = ae.beL().f(0, this.pTR, true);
                w.i("MicroMsg.NetSceneSnsPreTimeLine", "md5 is no change!! the new minid %s", new Object[]{Long.valueOf(this.pTP)});
                x.Fc("@__weixintimtline");
                this.gUD.a(i2, i3, str, this);
                return;
            }
            w.d("MicroMsg.NetSceneSnsPreTimeLine", "fp resp list size " + com_tencent_mm_protocal_c_bcm.tiQ.size() + " adsize : " + com_tencent_mm_protocal_c_bcm.udy);
            ae.beO().e("@__weixintimtline", com_tencent_mm_protocal_c_bcm.ubX, n.a(com_tencent_mm_protocal_c_bcm.ubE));
            for (int i5 = 0; i5 < com_tencent_mm_protocal_c_bcm.udz.size(); i5++) {
                ca caVar = (ca) com_tencent_mm_protocal_c_bcm.udz.get(i5);
                String a = n.a(caVar.tfv);
                String a2 = n.a(caVar.tfu.ubD);
                String b = n.b(caVar.tfu.ubC.ucj);
                w.i("MicroMsg.NetSceneSnsPreTimeLine", "skXml " + a);
                w.i("MicroMsg.NetSceneSnsPreTimeLine", "adXml " + a2);
                w.i("MicroMsg.NetSceneSnsPreTimeLine", "snsXml " + b + "\r\n");
            }
            a.e(com_tencent_mm_protocal_c_bcm.udz, com_tencent_mm_protocal_c_bcm.tiQ);
            a.ag(com_tencent_mm_protocal_c_bcm.udz);
            if (com_tencent_mm_protocal_c_bcm.udy == 0) {
                w.i("MicroMsg.NetSceneSnsPreTimeLine", "recv %d recommend", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bcm.udA)});
                a.d(com_tencent_mm_protocal_c_bcm.udB, com_tencent_mm_protocal_c_bcm.tiQ);
                a.af(com_tencent_mm_protocal_c_bcm.udB);
            }
            LinkedList linkedList = new LinkedList();
            Iterator it = com_tencent_mm_protocal_c_bcm.tiQ.iterator();
            while (it.hasNext()) {
                linkedList.add(Long.valueOf(((bbk) it.next()).tmx));
            }
            com.tencent.mm.sdk.b.b pjVar = new pj();
            pjVar.fWl.fWm = linkedList;
            com.tencent.mm.sdk.b.a.urY.m(pjVar);
            if (pVar.zg().sZC == 207) {
                if (com_tencent_mm_protocal_c_bcm.tiQ.isEmpty()) {
                    ae.beL().bhO();
                } else {
                    ae.beL().Gm(i.dg(((bbk) com_tencent_mm_protocal_c_bcm.tiQ.getFirst()).tmx));
                    ae.beL().Gl(i.dg(((bbk) com_tencent_mm_protocal_c_bcm.tiQ.getLast()).tmx));
                    a(com_tencent_mm_protocal_c_bcm, dg);
                    a.ah(com_tencent_mm_protocal_c_bcm.tiQ);
                }
                x.Fc("@__weixintimtline");
                this.gUD.a(i2, i3, str, this);
                return;
            }
            if (com_tencent_mm_protocal_c_bcm.tiQ.isEmpty()) {
                ae.beL().bhO();
            } else {
                a(com_tencent_mm_protocal_c_bcm, dg);
                a.ah(com_tencent_mm_protocal_c_bcm.tiQ);
            }
            x.Fc("@__weixintimtline");
            this.gUD.a(i2, i3, str, this);
            return;
        }
        x.Fc("@__weixintimtline");
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 718;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
