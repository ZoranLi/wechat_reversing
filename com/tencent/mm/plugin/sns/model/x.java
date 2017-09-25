package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.mm.e.a.pj;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.appbrand.jsapi.share.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.protocal.c.bcl;
import com.tencent.mm.protocal.c.bcm;
import com.tencent.mm.protocal.c.ca;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public final class x extends k implements j, d {
    private static Vector<String> pTQ = new Vector();
    public int Ul = 0;
    final int fFq;
    private b gUA;
    public e gUD;
    private boolean hRa = false;
    public boolean pTN;
    private long pTO = 0;
    long pTP = 0;
    public int pTR = 0;
    public int pTS = 0;
    private long pUG = 0;
    private boolean pUH = false;
    private boolean pUI = false;
    private long pUo = 0;
    private String pUp = "";

    public static synchronized boolean Fb(String str) {
        boolean z;
        synchronized (x.class) {
            if (pTQ.contains(str)) {
                z = false;
            } else {
                pTQ.add(str);
                z = true;
            }
        }
        return z;
    }

    public static synchronized boolean Fc(String str) {
        synchronized (x.class) {
            pTQ.remove(str);
        }
        return true;
    }

    public x(long j) {
        int i;
        long j2;
        long currentTimeMillis = System.currentTimeMillis();
        a aVar = new a();
        aVar.hsm = new bcl();
        aVar.hsn = new bcm();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnstimeline";
        aVar.hsl = g.CTRL_INDEX;
        aVar.hso = 98;
        aVar.hsp = 1000000098;
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
        this.pTO = j;
        this.pTN = j == 0;
        this.fFq = 2;
        bcl com_tencent_mm_protocal_c_bcl = (bcl) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bcl.udw = i;
        com_tencent_mm_protocal_c_bcl.ubY = j;
        int bfj = ae.beB().bfj();
        n beL = ae.beL();
        if (this.pTN) {
            j2 = 0;
        } else {
            j2 = j;
        }
        this.pTP = beL.f(j2, bfj, true);
        com_tencent_mm_protocal_c_bcl.udt = this.pTP;
        com_tencent_mm_protocal_c_bcl.udu = c.a(this.pTP, j, "@__weixintimtline");
        if (this.pTN) {
            this.pUo = ae.beL().f(0, 1, true);
            w.i("MicroMsg.NetSceneSnsTimeLine", "newerid " + this.pUo);
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
                w.d("MicroMsg.NetSceneSnsTimeLine", "request adsession %s", new Object[]{Gk.field_adsession});
                com_tencent_mm_protocal_c_bcl.ubE = new avw().bb(Gk.field_adsession);
            }
        }
        this.pUG = j;
        w.i("MicroMsg.NetSceneSnsTimeLine", " This req nextCount: " + bfj + " max:" + j + " min:" + this.pTP + " ReqTime:" + com_tencent_mm_protocal_c_bcl.udu + " nettype: " + i);
        w.d("MicroMsg.NetSceneSnsTimeLine", "maxId: %s minId: %s lastReqTime: %s", new Object[]{i.df(j), i.df(this.pTP), Integer.valueOf(r3)});
        w.d("MicroMsg.NetSceneSnsTimeLine", "NetSceneSnsTimeLine %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    private void beh() {
        n beL = ae.beL();
        Cursor a = beL.gUz.a(n.tG(3), null, 2);
        int i = 0;
        while (a.moveToNext()) {
            i++;
        }
        a.close();
        if (i < 3 && i > 0) {
            this.pUI = true;
        } else if (i == 0) {
            this.pUH = true;
        }
    }

    private void a(bcm com_tencent_mm_protocal_c_bcm, String str) {
        ai.a("@__weixintimtline", this.fFq, com_tencent_mm_protocal_c_bcm.tiQ, str);
        this.pTP = ((bbk) com_tencent_mm_protocal_c_bcm.tiQ.getLast()).tmx;
        if (this.pTO == 0) {
            this.pTO = ((bbk) com_tencent_mm_protocal_c_bcm.tiQ.getFirst()).tmx;
        } else {
            this.pTO = c.dj(this.pTO);
        }
        c.b("@__weixintimtline", this.pTO, this.pTP, com_tencent_mm_protocal_c_bcm.udx);
        try {
            Iterator it = com_tencent_mm_protocal_c_bcm.tiQ.iterator();
            while (it.hasNext()) {
                bbk com_tencent_mm_protocal_c_bbk = (bbk) it.next();
                if (com_tencent_mm_protocal_c_bbk.ucu == 0) {
                    m dG = ae.beL().dG(com_tencent_mm_protocal_c_bbk.tmx);
                    if (!(dG == null || dG.bhd() == null || dG.field_type != 15)) {
                        try {
                            String str2 = ((alh) dG.bhd().ufB.tsO.get(0)).msN;
                            com.tencent.mm.plugin.report.service.g.oUh.i(14388, new Object[]{Long.valueOf(com_tencent_mm_protocal_c_bbk.tmx), Integer.valueOf(4), str2, Integer.valueOf(0)});
                        } catch (Exception e) {
                        }
                    }
                }
            }
        } catch (Exception e2) {
        }
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneSnsTimeLine", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        bcm com_tencent_mm_protocal_c_bcm = (bcm) ((b) pVar).hsk.hsr;
        if (pVar.zg().sZC == 207 || pVar.zg().sZC == 0) {
            if (com_tencent_mm_protocal_c_bcm.ucd != null) {
                w.d("MicroMsg.NetSceneSnsTimeLine", "serverConfig  " + com_tencent_mm_protocal_c_bcm.ucd.udp + " " + com_tencent_mm_protocal_c_bcm.ucd.udo);
                int i4 = com_tencent_mm_protocal_c_bcm.ucd.udp;
                com.tencent.mm.plugin.sns.c.a.pQH = i4;
                if (i4 <= 0) {
                    com.tencent.mm.plugin.sns.c.a.pQH = Integer.MAX_VALUE;
                }
                v.uzf = com_tencent_mm_protocal_c_bcm.ucd.udo;
            }
            this.pTR = com_tencent_mm_protocal_c_bcm.ucb;
            this.pTS = com_tencent_mm_protocal_c_bcm.ucc;
            w.i("MicroMsg.NetSceneSnsTimeLine", "for same md5 count: " + com_tencent_mm_protocal_c_bcm.ucb + " , objCount:  " + com_tencent_mm_protocal_c_bcm.tRg + " cflag : " + com_tencent_mm_protocal_c_bcm.ucc);
            this.Ul = com_tencent_mm_protocal_c_bcm.tRg;
            String dg = i.dg(this.pTO);
            if (com_tencent_mm_protocal_c_bcm.tiQ.isEmpty()) {
                w.i("MicroMsg.NetSceneSnsTimeLine", " respone is Empty");
            } else {
                w.i("MicroMsg.NetSceneSnsTimeLine", "respone size " + com_tencent_mm_protocal_c_bcm.tiQ.size() + " Max " + ((bbk) com_tencent_mm_protocal_c_bcm.tiQ.getFirst()).tmx + " " + i.df(((bbk) com_tencent_mm_protocal_c_bcm.tiQ.getFirst()).tmx) + "  respone min  " + ((bbk) com_tencent_mm_protocal_c_bcm.tiQ.getLast()).tmx + " " + i.df(((bbk) com_tencent_mm_protocal_c_bcm.tiQ.getLast()).tmx));
            }
            if (this.pTN) {
                this.Ul = com_tencent_mm_protocal_c_bcm.tRg;
                if (this.pUp.equals(com_tencent_mm_protocal_c_bcm.ubX)) {
                    this.pTP = ae.beL().f(this.pTN ? 0 : this.pUG, this.pTR, true);
                    w.i("MicroMsg.NetSceneSnsTimeLine", "md5 is no change!! the new minid %s", new Object[]{Long.valueOf(this.pTP)});
                    beh();
                    Fc("@__weixintimtline");
                    this.gUD.a(i2, i3, str, this);
                    return;
                }
                ca caVar;
                String str2;
                String a;
                w.d("MicroMsg.NetSceneSnsTimeLine", "fp resp list size " + com_tencent_mm_protocal_c_bcm.tiQ.size() + " adsize : " + com_tencent_mm_protocal_c_bcm.udy);
                ae.beO().e("@__weixintimtline", com_tencent_mm_protocal_c_bcm.ubX, com.tencent.mm.platformtools.n.a(com_tencent_mm_protocal_c_bcm.ubE));
                for (int i5 = 0; i5 < com_tencent_mm_protocal_c_bcm.udz.size(); i5++) {
                    caVar = (ca) com_tencent_mm_protocal_c_bcm.udz.get(i5);
                    if (this.hRa) {
                        str2 = ae.xv() + "ad.proto";
                        try {
                            byte[] toByteArray = caVar.toByteArray();
                            com.tencent.mm.a.e.b(str2, toByteArray, toByteArray.length);
                        } catch (Exception e) {
                            w.e("MicroMsg.NetSceneSnsTimeLine", "save error " + e.getMessage());
                        }
                    }
                    str2 = com.tencent.mm.platformtools.n.a(caVar.tfv);
                    a = com.tencent.mm.platformtools.n.a(caVar.tfu.ubD);
                    String b = com.tencent.mm.platformtools.n.b(caVar.tfu.ubC.ucj);
                    w.i("MicroMsg.NetSceneSnsTimeLine", "skXml " + str2);
                    w.i("MicroMsg.NetSceneSnsTimeLine", "adXml " + a);
                    w.i("MicroMsg.NetSceneSnsTimeLine", "snsXml " + b + "\r\n");
                }
                if (this.hRa && com_tencent_mm_protocal_c_bcm.udz.size() == 0) {
                    try {
                        byte[] d = com.tencent.mm.a.e.d(ae.xv() + "ad.proto", 0, -1);
                        ca caVar2 = new ca();
                        caVar2.aD(d);
                        com_tencent_mm_protocal_c_bcm.udz.add(caVar2);
                        com_tencent_mm_protocal_c_bcm.udy = com_tencent_mm_protocal_c_bcm.udz.size();
                        w.d("MicroMsg.NetSceneSnsTimeLine", "read from path " + com_tencent_mm_protocal_c_bcm.udy);
                        if (com_tencent_mm_protocal_c_bcm.udz.size() > 0) {
                            caVar = (ca) com_tencent_mm_protocal_c_bcm.udz.get(0);
                            String a2 = com.tencent.mm.platformtools.n.a(caVar.tfv);
                            str2 = com.tencent.mm.platformtools.n.a(caVar.tfu.ubD);
                            a = com.tencent.mm.platformtools.n.b(caVar.tfu.ubC.ucj);
                            w.i("MicroMsg.NetSceneSnsTimeLine", "skXml " + a2);
                            w.i("MicroMsg.NetSceneSnsTimeLine", "adXml " + str2);
                            w.i("MicroMsg.NetSceneSnsTimeLine", "snsXml " + a + "\r\n");
                            b(caVar);
                        }
                    } catch (Exception e2) {
                        w.e("MicroMsg.NetSceneSnsTimeLine", "read error " + e2.getMessage());
                    }
                }
                a.e(com_tencent_mm_protocal_c_bcm.udz, com_tencent_mm_protocal_c_bcm.tiQ);
                a.ag(com_tencent_mm_protocal_c_bcm.udz);
                if (com_tencent_mm_protocal_c_bcm.udy == 0) {
                    w.i("MicroMsg.NetSceneSnsTimeLine", "recv %d recommend", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bcm.udA)});
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
                        this.pTP = this.pTO;
                    } else {
                        ae.beL().Gm(i.dg(((bbk) com_tencent_mm_protocal_c_bcm.tiQ.getFirst()).tmx));
                        ae.beL().Gl(i.dg(((bbk) com_tencent_mm_protocal_c_bcm.tiQ.getLast()).tmx));
                        a(com_tencent_mm_protocal_c_bcm, dg);
                        a.ah(com_tencent_mm_protocal_c_bcm.tiQ);
                    }
                    this.pUH = true;
                    Fc("@__weixintimtline");
                    this.gUD.a(i2, i3, str, this);
                    return;
                }
                if (com_tencent_mm_protocal_c_bcm.tiQ.isEmpty()) {
                    ae.beL().bhO();
                    this.pTP = this.pTO;
                    this.pUH = true;
                } else {
                    a(com_tencent_mm_protocal_c_bcm, dg);
                    a.ah(com_tencent_mm_protocal_c_bcm.tiQ);
                }
                Fc("@__weixintimtline");
                this.gUD.a(i2, i3, str, this);
                return;
            }
            w.d("MicroMsg.NetSceneSnsTimeLine", "np resp list size " + com_tencent_mm_protocal_c_bcm.tiQ.size());
            if (com_tencent_mm_protocal_c_bcm.tiQ.isEmpty()) {
                ae.beL().Gl(dg);
                this.pUH = true;
                this.pTP = this.pTO;
            } else {
                a(com_tencent_mm_protocal_c_bcm, dg);
            }
            Fc("@__weixintimtline");
            this.gUD.a(i2, i3, str, this);
            return;
        }
        Fc("@__weixintimtline");
        this.gUD.a(i2, i3, str, this);
    }

    private static boolean b(ca caVar) {
        if (!am.isWifi(ab.getContext())) {
            return false;
        }
        try {
            com.tencent.mm.modelsns.e.kL(com.tencent.mm.platformtools.n.b(caVar.tfu.ubC.ucj));
            ae.beG();
            b.bdP();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public final int getType() {
        return g.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final String getUserName() {
        return "@__weixintimtline";
    }

    public final boolean bdS() {
        return this.pTN;
    }

    public final boolean bdT() {
        return this.pUH;
    }

    public final boolean bdU() {
        return this.pUI;
    }

    public final boolean bdV() {
        return false;
    }

    public final long bdW() {
        return this.pTP;
    }

    public final boolean bdX() {
        return false;
    }

    public final long bdY() {
        return 0;
    }
}
