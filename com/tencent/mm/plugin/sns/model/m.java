package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.c.bay;
import com.tencent.mm.protocal.c.baz;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public final class m extends k implements j {
    private static Vector<String> pTQ = new Vector();
    private String desc = "";
    final int fFq;
    private b gUA;
    public e gUD;
    private boolean kgf = false;
    private ArrayList<com.tencent.mm.plugin.sns.storage.m> kha = new ArrayList();
    private boolean pTN;
    private long pTO = 0;
    private long pTP = 0;
    public int pTR = 0;
    public int pTS = 0;

    public static synchronized boolean Fb(String str) {
        boolean z;
        synchronized (m.class) {
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
        synchronized (m.class) {
            pTQ.remove(str);
        }
        return true;
    }

    public m(String str) {
        a aVar = new a();
        aVar.hsm = new bay();
        aVar.hsn = new baz();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsclassifytimeline";
        aVar.hsl = 601;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.pTO = 0;
        this.pTN = 0 == 0;
        this.fFq = 2;
        bay com_tencent_mm_protocal_c_bay = (bay) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bay.ubX = "";
        com_tencent_mm_protocal_c_bay.ubY = 0;
        com_tencent_mm_protocal_c_bay.ubZ = str;
        com_tencent_mm_protocal_c_bay.uca = 1;
        w.d("MicroMsg.NetSceneSnsClassifyTimeLine", "maxid %s classifyid %s classifyType %d", new Object[]{i.df(0), str, Integer.valueOf(0)});
    }

    private com.tencent.mm.plugin.sns.storage.m b(bbk com_tencent_mm_protocal_c_bbk) {
        com.tencent.mm.plugin.sns.storage.m mVar = new com.tencent.mm.plugin.sns.storage.m();
        String str = new String(com_tencent_mm_protocal_c_bbk.ucj.tZp.toByteArray());
        w.d("MicroMsg.NetSceneSnsClassifyTimeLine", "from server %d ", new Object[]{Long.valueOf(com_tencent_mm_protocal_c_bbk.tmx)});
        if (!mVar.Ge(str)) {
            return null;
        }
        com_tencent_mm_protocal_c_bbk.ucj.bb(new byte[0]);
        mVar.field_userName = com_tencent_mm_protocal_c_bbk.tgG;
        mVar.fN(com_tencent_mm_protocal_c_bbk.ogM);
        mVar.field_likeFlag = com_tencent_mm_protocal_c_bbk.uck;
        mVar.dC(com_tencent_mm_protocal_c_bbk.tmx);
        mVar.dE(com_tencent_mm_protocal_c_bbk.tmx);
        mVar.tC(this.fFq);
        try {
            mVar.aF(com_tencent_mm_protocal_c_bbk.toByteArray());
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.NetSceneSnsClassifyTimeLine", e, "", new Object[0]);
        }
        bfc bhd = mVar.bhd();
        bhd.jNj = com_tencent_mm_protocal_c_bbk.tgG;
        mVar.field_pravited = bhd.tPk;
        w.d("MicroMsg.NetSceneSnsClassifyTimeLine", "ext flag " + com_tencent_mm_protocal_c_bbk.tQZ);
        mVar.bhv();
        mVar.b(bhd);
        mVar.field_type = bhd.ufB.tsN;
        mVar.field_subType = bhd.ufB.tsP;
        return mVar;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneSnsClassifyTimeLine", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        baz com_tencent_mm_protocal_c_baz = (baz) ((b) pVar).hsk.hsr;
        if (pVar.zg().sZC == 207 || pVar.zg().sZC == 0 || pVar.zg().sZC == com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX) {
            this.kgf = pVar.zg().sZC == com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX;
            this.pTR = com_tencent_mm_protocal_c_baz.ucb;
            this.desc = com_tencent_mm_protocal_c_baz.tgT;
            i.dg(this.pTO);
            w.d("MicroMsg.NetSceneSnsClassifyTimeLine", "resp objCount %d desc %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_baz.tRg), this.desc});
            Iterator it = com_tencent_mm_protocal_c_baz.tiQ.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.sns.storage.m b = b((bbk) it.next());
                if (b != null) {
                    this.kha.add(b);
                }
            }
            Fc("@__classify_timeline");
            this.gUD.a(i2, i3, str, this);
            return;
        }
        Fc("@__classify_timeline");
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 601;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
