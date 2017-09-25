package com.tencent.mm.plugin.qmessage.a;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.e.a.qh;
import com.tencent.mm.e.b.af;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.map.c;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.fa;
import com.tencent.mm.protocal.c.fb;
import com.tencent.mm.protocal.c.mh;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class b extends k implements j {
    private e gUD;
    private Set<String> oyz;

    public b(Set<String> set) {
        Assert.assertTrue(true);
        this.oyz = set;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        List<String> linkedList = new LinkedList();
        for (String add : this.oyz) {
            linkedList.add(add);
        }
        if (linkedList.size() == 0) {
            w.e("MicroMsg.NetSceneBatchGetContactProfile", g.sd() + "doScene reqSize ==0");
            return -1;
        }
        a aVar = new a();
        aVar.hsm = new fa();
        aVar.hsn = new fb();
        aVar.uri = "/cgi-bin/micromsg-bin/batchgetcontactprofile";
        aVar.hsl = c.CTRL_INDEX;
        aVar.hso = 28;
        aVar.hsp = 1000000028;
        p BE = aVar.BE();
        LinkedList linkedList2 = new LinkedList();
        for (String add2 : linkedList) {
            linkedList2.add(n.mw(add2));
        }
        ((fa) BE.hsj.hsr).tiO = linkedList2;
        ((fa) BE.hsj.hsr).tiN = 1;
        ((fa) BE.hsj.hsr).jNd = linkedList2.size();
        return a(eVar, BE, this);
    }

    protected final int a(p pVar) {
        return com.tencent.mm.y.k.b.hsT;
    }

    public final int getType() {
        return c.CTRL_INDEX;
    }

    protected final int ub() {
        return 50;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            if (g(pVar) && this.oyz.size() > 0) {
                a(this.hsD, this.gUD);
            }
            w.d("MicroMsg.NetSceneBatchGetContactProfile", "left cnt = " + this.oyz.size());
            this.gUD.a(i2, i3, str, this);
            return;
        }
        this.gUD.a(i2, i3, str, this);
    }

    private boolean g(p pVar) {
        fb fbVar = (fb) ((com.tencent.mm.y.b) pVar).hsk.hsr;
        if (fbVar == null) {
            w.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp: resp is null");
            return false;
        } else if (pVar.zg().sZC == 1) {
            w.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp : endless loop, should stop");
            return false;
        } else if (pVar.zg().sZC == -1) {
            w.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp : server err, can try again");
            return true;
        } else {
            List list = fbVar.tiP;
            if (list == null) {
                return false;
            }
            for (int i = 0; i < list.size(); i++) {
                mh mhVar;
                boolean z;
                try {
                    mhVar = (mh) new mh().aD(n.a((avw) list.get(i)));
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.NetSceneBatchGetContactProfile", e, "", new Object[0]);
                    w.e("MicroMsg.NetSceneBatchGetContactProfile", "ContactProfile.parseFrom fail");
                    mhVar = null;
                }
                if (mhVar == null || mhVar.jNj == null) {
                    w.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: profile name is null");
                    z = false;
                } else if (this.oyz.contains(mhVar.jNj)) {
                    this.oyz.remove(mhVar.jNj);
                    ap.yY();
                    af Rc = com.tencent.mm.u.c.wR().Rc(mhVar.jNj);
                    if (Rc == null || ((int) Rc.gTQ) == 0) {
                        w.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: did not find this contact");
                        z = false;
                    } else {
                        Rc.setUsername(mhVar.jNj);
                        Rc.bO(mhVar.hAI);
                        Rc.setType(mhVar.tsx & mhVar.tsy);
                        Rc.bR(mhVar.jOp);
                        Rc.bS(mhVar.tsv);
                        Rc.bT(mhVar.tsw);
                        Rc.di(mhVar.hAD);
                        Rc.bP(mhVar.tsz);
                        Rc.bV(mhVar.tsC);
                        Rc.bW(mhVar.tsB);
                        Rc.dl(mhVar.tsD);
                        Rc.bQ(mhVar.tsG);
                        Rc.dm(mhVar.tsH);
                        ap.yY();
                        if (com.tencent.mm.u.c.wR().a(Rc.field_username, Rc) == -1) {
                            w.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile:update contact failed");
                        }
                        if (x.QO(mhVar.jNj)) {
                            d CJ = g.aUe().CJ(mhVar.jNj);
                            if (CJ == null || bg.mz(CJ.getUsername()).length() <= 0) {
                                w.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: did not find qcontact");
                                z = false;
                            } else {
                                CJ.extInfo = mhVar.mvZ;
                                CJ.oyC = (long) mhVar.tsJ;
                                CJ.oyD = (long) mhVar.tsK;
                                CJ.fRW = 52;
                                if (!g.aUe().a(mhVar.jNj, CJ)) {
                                    w.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile:update qcontact failed");
                                }
                            }
                        }
                        if (x.QM(mhVar.jNj)) {
                            com.tencent.mm.sdk.b.b qhVar = new qh();
                            qhVar.fXn.opType = 0;
                            qhVar.fXn.fSf = mhVar.jNj;
                            qhVar.fXn.fSg = mhVar.tsJ;
                            qhVar.fXn.fSh = mhVar.tsA;
                            com.tencent.mm.sdk.b.a.urY.m(qhVar);
                        }
                        z = true;
                    }
                } else {
                    w.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: resp data not in req");
                    z = false;
                }
                if (!z) {
                    return false;
                }
            }
            return true;
        }
    }
}
