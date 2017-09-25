package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aw;
import com.tencent.mm.protocal.c.alq;
import com.tencent.mm.protocal.c.alr;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.axw;
import com.tencent.mm.protocal.c.axx;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.aj;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.ba;
import com.tencent.mm.u.m;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class c extends k implements j {
    private static final List<aj> hKG = new ArrayList();
    private static final Set<Long> rfg = new HashSet();
    private long fGM;
    private b gUA;
    private e gUD;
    private final List<au> hKH = new LinkedList();

    public c(String str, String str2, int i) {
        boolean z = true;
        w.d("MicroMsg.NetSceneSendMsg", "dktext :" + bg.bJZ());
        if (!bg.mA(str)) {
            au auVar = new au();
            auVar.dv(1);
            auVar.cH(str);
            auVar.z(ay.gk(str));
            auVar.dw(1);
            auVar.setContent(str2);
            auVar.setType(i);
            ap.yY();
            this.fGM = com.tencent.mm.u.c.wT().L(auVar);
            if (this.fGM == -1) {
                z = false;
            }
            Assert.assertTrue(z);
            w.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.fGM);
        }
    }

    public c() {
        w.d("MicroMsg.NetSceneSendMsg", "dktext :" + bg.bJZ());
        w.i("MicroMsg.NetSceneSendMsg", "empty msg sender created");
    }

    protected final int ub() {
        return 10;
    }

    protected final int a(p pVar) {
        return this.hKH.size() > 0 ? k.b.hsT : k.b.hsU;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        a aVar = new a();
        aVar.hsm = new axw();
        aVar.hsn = new axx();
        aVar.uri = "/cgi-bin/micromsg-bin/newsendmsg";
        aVar.hsl = 522;
        aVar.hso = aw.CTRL_BYTE;
        aVar.hsp = 1000000237;
        this.gUA = aVar.BE();
        axw com_tencent_mm_protocal_c_axw = (axw) this.gUA.hsj.hsr;
        ap.yY();
        List aKe = com.tencent.mm.u.c.wT().aKe();
        if (aKe.size() == 0) {
            w.i("MicroMsg.NetSceneSendMsg", "no sending message");
            return -2;
        }
        this.hKH.clear();
        for (int i = 0; i < aKe.size(); i++) {
            au auVar = (au) aKe.get(i);
            if (auVar.field_isSend == 1) {
                alq com_tencent_mm_protocal_c_alq = new alq();
                com_tencent_mm_protocal_c_alq.tfe = new avx().OV(auVar.field_talker);
                com_tencent_mm_protocal_c_alq.ogM = (int) (auVar.field_createTime / 1000);
                com_tencent_mm_protocal_c_alq.jOc = auVar.field_type;
                com_tencent_mm_protocal_c_alq.opI = auVar.field_content;
                com_tencent_mm_protocal_c_alq.tQw = com.tencent.mm.u.k.f(m.xL(), auVar.field_createTime).hashCode();
                com_tencent_mm_protocal_c_alq.tfi = ba.zA();
                com_tencent_mm_protocal_c_axw.jNe.add(com_tencent_mm_protocal_c_alq);
                com_tencent_mm_protocal_c_axw.jNd = com_tencent_mm_protocal_c_axw.jNe.size();
                this.hKH.add(auVar);
            }
        }
        int a = a(eVar, this.gUA, this);
        if (a >= 0) {
            return a;
        }
        Hs();
        return a;
    }

    public final int getType() {
        return 522;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            List list = ((axx) this.gUA.hsk.hsr).jNe;
            if (this.hKH.size() == list.size()) {
                int i4 = 0;
                while (i4 < list.size()) {
                    alr com_tencent_mm_protocal_c_alr = (alr) list.get(i4);
                    if (com_tencent_mm_protocal_c_alr.thX != 0) {
                        w.e("MicroMsg.NetSceneSendMsg", "send msg failed: item ret code=" + com_tencent_mm_protocal_c_alr.thX);
                        gf(i4);
                        this.gUD.a(4, com_tencent_mm_protocal_c_alr.thX, str, this);
                        return;
                    }
                    long j = ((au) this.hKH.get(i4)).field_msgId;
                    w.i("MicroMsg.NetSceneSendMsg", "msg local id = " + j + ", SvrId = " + com_tencent_mm_protocal_c_alr.tfk + " sent successfully!");
                    ap.yY();
                    au cA = com.tencent.mm.u.c.wT().cA(j);
                    cA.y(com_tencent_mm_protocal_c_alr.tfk);
                    cA.dv(2);
                    ap.yY();
                    com.tencent.mm.u.c.wT().a(j, cA);
                    i4++;
                }
                w.i("MicroMsg.NetSceneSendMsg", "total " + i4 + " msgs sent successfully");
            }
            int a = a(this.hsD, this.gUD);
            if (a == -2) {
                this.gUD.a(0, 0, str, this);
                return;
            } else if (a < 0) {
                this.gUD.a(3, -1, str, this);
                return;
            } else {
                return;
            }
        }
        Hs();
        this.gUD.a(i2, i3, str, this);
    }

    private void Hs() {
        for (int i = 0; i < this.hKH.size(); i++) {
            gf(i);
        }
    }

    private void gf(int i) {
        au auVar = (au) this.hKH.get(i);
        auVar.dv(5);
        ap.yY();
        com.tencent.mm.u.c.wT().a(auVar.field_msgId, auVar);
        for (aj ajVar : hKG) {
            String str = auVar.field_talker;
            String str2 = auVar.field_content;
            ajVar.ge(str);
        }
    }
}
