package com.tencent.mm.modelmulti;

import com.tencent.mm.e.a.nw;
import com.tencent.mm.e.a.ny;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsimple.ai;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aw;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.protocal.c.alq;
import com.tencent.mm.protocal.c.alr;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.axw;
import com.tencent.mm.protocal.c.axx;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.aj;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.wcdb.database.SQLiteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import junit.framework.Assert;

public final class j extends k implements com.tencent.mm.network.j {
    private static final List<aj> hKG = new ArrayList();
    public long fGM;
    private b gUA;
    public e gUD;
    private final List<au> hKH = new LinkedList();
    public int hKI = 3;
    public boolean hKJ = false;
    public final List<au> hKK = new ArrayList();
    private au hKL = null;
    public com.tencent.mm.plugin.messenger.foundation.a.k hKM = null;

    public j(String str, String str2, int i, int i2, Object obj) {
        w.d("MicroMsg.NetSceneSendMsg", "dktext :%s", bg.bJZ());
        if (!bg.mA(str)) {
            au auVar = new au();
            auVar.dv(1);
            auVar.cH(str);
            auVar.z(ay.gk(str));
            auVar.dw(1);
            auVar.setContent(str2);
            auVar.setType(i);
            String a = a(((o) h.h(o.class)).s(auVar), obj, i2);
            if (!bg.mA(a)) {
                auVar.cN(a);
                w.d("MicroMsg.NetSceneSendMsg", "NetSceneSendMsg:MsgSource:%s", auVar.gxF);
            }
            try {
                this.fGM = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().b(auVar, true);
                if (this.fGM == -1) {
                    c.oTb.a(111, 255, 1, false);
                }
                Assert.assertTrue(this.fGM != -1);
                w.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.fGM);
            } catch (SQLiteException e) {
                c.oTb.a(111, 255, 1, false);
                throw e;
            }
        }
    }

    public j(String str, String str2, int i) {
        boolean z = false;
        w.d("MicroMsg.NetSceneSendMsg", "dktext :%s", bg.bJZ());
        if (!bg.mA(str)) {
            au auVar = new au();
            auVar.dv(1);
            auVar.cH(str);
            auVar.z(ay.gk(str));
            auVar.dw(1);
            auVar.setContent(str2);
            auVar.setType(i);
            String s = ((o) h.h(o.class)).s(auVar);
            if (!bg.mA(s)) {
                auVar.cN(s);
                w.d("MicroMsg.NetSceneSendMsg", "NetSceneSendMsg:MsgSource:%s", auVar.gxF);
            }
            try {
                this.fGM = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().b(auVar, true);
                if (this.fGM == -1) {
                    c.oTb.a(111, 255, 1, false);
                }
                if (this.fGM != -1) {
                    z = true;
                }
                Assert.assertTrue(z);
                w.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.fGM);
            } catch (SQLiteException e) {
                c.oTb.a(111, 255, 1, false);
                throw e;
            }
        }
    }

    public j(long j) {
        w.i("MicroMsg.NetSceneSendMsg", "resend msg , local id = " + j);
        this.fGM = j;
        this.hKL = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().cA(j);
        if (this.hKL == null) {
            w.e("MicroMsg.NetSceneSendMsg", "resend msg , msg is null localid:%d", Long.valueOf(j));
        }
    }

    public j() {
        w.d("MicroMsg.NetSceneSendMsg", "dktext :%s", bg.bJZ());
        w.i("MicroMsg.NetSceneSendMsg", "empty msg sender created");
    }

    public final boolean BI() {
        return true;
    }

    protected final int ub() {
        return 10;
    }

    public final boolean BJ() {
        boolean BJ = super.BJ();
        if (BJ) {
            c.oTb.a(111, 254, 1, false);
        }
        return BJ;
    }

    protected final int a(p pVar) {
        return this.hKH.size() > 0 ? b.hsT : b.hsU;
    }

    private static String a(String str, Object obj, int i) {
        String str2 = "MicroMsg.NetSceneSendMsg";
        String str3 = "[mergeMsgSource] rawSource:%s args is null:%s flag:%s";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(obj == null);
        objArr[2] = Integer.valueOf(i);
        w.i(str2, str3, objArr);
        if (!bg.mA(str) && !str.startsWith("<msgsource>")) {
            w.w("MicroMsg.NetSceneSendMsg", "[mergeMsgSource] WTF the msgsource is right? %s", str);
            return str;
        } else if (i != 291 || !(obj instanceof HashMap)) {
            return str;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            if (bg.mA(str)) {
                stringBuffer.append("<msgsource>");
            }
            for (Entry entry : ((HashMap) obj).entrySet()) {
                str2 = (String) entry.getValue();
                String str4 = (String) entry.getKey();
                if (bg.mA(str2) || bg.mA(str4)) {
                    w.w("MicroMsg.NetSceneSendMsg", "%s %s", str4, str2);
                } else {
                    stringBuffer.append("<").append(str4).append(">");
                    stringBuffer.append(str2);
                    stringBuffer.append("</").append(str4).append(">");
                }
            }
            if (!bg.mA(str)) {
                return str.replace("<msgsource>", "<msgsource>" + stringBuffer.toString());
            }
            stringBuffer.append("</msgsource>");
            return stringBuffer.toString();
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        List aKe;
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
        if (this.hKL == null) {
            aKe = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().aKe();
        } else {
            if (this.hKL.field_status != 5) {
                w.w("MicroMsg.NetSceneSendMsg", "msg:%d status:%d should not be resend !", Long.valueOf(this.hKL.field_msgId), Integer.valueOf(this.hKL.field_status));
            }
            this.hKL.dv(1);
            ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().a(this.fGM, this.hKL);
            List arrayList = new ArrayList();
            arrayList.add(this.hKL);
            this.hKL = null;
            aKe = arrayList;
        }
        if (aKe.size() == 0) {
            w.w("MicroMsg.NetSceneSendMsg", "no sending message");
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
                if (this.hKM == null) {
                    this.hKM = ((o) h.h(o.class)).Hw();
                }
                w.i("MicroMsg.NetSceneSendMsg", "using message source assembler %s", this.hKM);
                this.hKM.a(com_tencent_mm_protocal_c_alq, auVar);
                w.i("MicroMsg.NetSceneSendMsg", "reqCmd.MsgSource:%s", com_tencent_mm_protocal_c_alq.tfi);
                com_tencent_mm_protocal_c_axw.jNe.add(com_tencent_mm_protocal_c_alq);
                com_tencent_mm_protocal_c_axw.jNd = com_tencent_mm_protocal_c_axw.jNe.size();
                this.hKH.add(auVar);
            }
        }
        int a = a(eVar, this.gUA, this);
        if (a >= 0) {
            return a;
        }
        w.i("MicroMsg.NetSceneSendMsg", "mark all failed. do scene %d", Integer.valueOf(a));
        Hs();
        return a;
    }

    public final int getType() {
        return 522;
    }

    private void ge(int i) {
        if (this.hKH == null) {
            w.e("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent, sendingList is null");
        } else if (i >= this.hKH.size() || i < 0) {
            w.e("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent, index:%d, sendingList.size:%d", Integer.valueOf(i), Integer.valueOf(this.hKH.size()));
        } else {
            q((au) this.hKH.get(i));
        }
    }

    static void q(au auVar) {
        com.tencent.mm.sdk.b.b nwVar = new nw();
        nwVar.fVc.fCZ = auVar;
        com.tencent.mm.sdk.b.a.urY.m(nwVar);
        w.d("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent for msgId:%d", Long.valueOf(auVar.field_msgId));
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            List list = ((axx) this.gUA.hsk.hsr).jNe;
            ArrayList arrayList = new ArrayList();
            if (this.hKH.size() == list.size()) {
                int i4 = 0;
                while (i4 < list.size()) {
                    alr com_tencent_mm_protocal_c_alr = (alr) list.get(i4);
                    if (com_tencent_mm_protocal_c_alr.thX != 0 || r.ijD) {
                        c.oTb.a(111, 252, 1, false);
                        if (com_tencent_mm_protocal_c_alr.thX == -49 || r.ijD) {
                            w.i("MicroMsg.NetSceneSendMsg", "summerdktext send msg failed: item ret code[%d], index[%d], testVerifyPsw[%b], retryVerifyCount[%d]", Integer.valueOf(com_tencent_mm_protocal_c_alr.thX), Integer.valueOf(i4), Boolean.valueOf(r.ijD), Integer.valueOf(this.hKI));
                            if (this.hKJ) {
                                this.hKK.add((au) this.hKH.get(i4));
                            } else if (this.hKI < 0) {
                                gf(i4);
                                this.gUD.a(4, com_tencent_mm_protocal_c_alr.thX, str, this);
                                ge(i4);
                                return;
                            } else {
                                this.hKJ = true;
                                this.hKI--;
                                this.hKK.add((au) this.hKH.get(i4));
                                final String str2 = str;
                                h.vL().D(new Runnable(this) {
                                    final /* synthetic */ j hKO;

                                    public final void run() {
                                        new ai(5, "", "", "", "", false, 1, false).a(this.hKO.hsD, new e(this) {
                                            final /* synthetic */ AnonymousClass1 hKP;

                                            {
                                                this.hKP = r1;
                                            }

                                            public final void a(int i, int i2, String str, k kVar) {
                                                kVar.hsJ = true;
                                                w.i("MicroMsg.NetSceneSendMsg", "summerdktext verifypsw onSceneEnd[%d, %d] needVerifyPswList size[%d] errMsg[%s] verifyingPsw[%b], retryVerifyCount[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.hKP.hKO.hKK.size()), str, Boolean.valueOf(this.hKP.hKO.hKJ), Integer.valueOf(this.hKP.hKO.hKI));
                                                if (i == 0 && i2 == 0) {
                                                    this.hKP.hKO.hKK.clear();
                                                    this.hKP.hKO.jP(str);
                                                } else {
                                                    int i3;
                                                    List list = this.hKP.hKO.hKK;
                                                    for (i3 = 0; i3 < list.size(); i3++) {
                                                        j.r((au) list.get(i3));
                                                    }
                                                    this.hKP.hKO.gUD.a(4, -49, str2, this.hKP.hKO);
                                                    list = this.hKP.hKO.hKK;
                                                    for (i3 = 0; i3 < list.size(); i3++) {
                                                        j.q((au) list.get(i3));
                                                    }
                                                    this.hKP.hKO.hKK.clear();
                                                }
                                                this.hKP.hKO.hKJ = false;
                                                r.ijD = false;
                                            }
                                        });
                                    }
                                });
                            }
                        } else {
                            gf(i4);
                            this.gUD.a(4, com_tencent_mm_protocal_c_alr.thX, str, this);
                            ge(i4);
                            return;
                        }
                    }
                    long j = ((au) this.hKH.get(i4)).field_msgId;
                    w.i("MicroMsg.NetSceneSendMsg", "msg local id = " + j + ", SvrId = " + com_tencent_mm_protocal_c_alr.tfk + " sent successfully!");
                    au cA = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().cA(j);
                    cA.y(com_tencent_mm_protocal_c_alr.tfk);
                    w.d("MicroMsg.NetSceneSendMsg", "dkmsgid  set svrmsgid %d -> %d", Long.valueOf(com_tencent_mm_protocal_c_alr.tfk), Integer.valueOf(r.iiX));
                    if (10007 == r.iiW && r.iiX != 0) {
                        cA.y((long) r.iiX);
                        r.iiX = 0;
                    }
                    cA.dv(2);
                    ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().a(j, cA);
                    if (this.hKH == null) {
                        w.e("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent, sendingList is null");
                    } else if (i4 >= this.hKH.size() || i4 < 0) {
                        w.e("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent, index:%d, sendingList.size:%d", Integer.valueOf(i4), Integer.valueOf(this.hKH.size()));
                    } else {
                        w.d("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent for msgId:%d", Long.valueOf(((au) this.hKH.get(i4)).field_msgId));
                        au cA2 = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().cA(j);
                        com.tencent.mm.sdk.b.b nyVar = new ny();
                        nyVar.fVe.fCZ = cA2;
                        com.tencent.mm.sdk.b.a.urY.m(nyVar);
                    }
                    arrayList.add(Integer.valueOf(i4));
                    if (1 == com_tencent_mm_protocal_c_alr.jOc) {
                        c.oTb.a(11942, true, false, Long.valueOf(com_tencent_mm_protocal_c_alr.tfk));
                        c.oTb.a(11945, false, true, Long.valueOf(com_tencent_mm_protocal_c_alr.tfk));
                        c.oTb.a(11946, false, false, Long.valueOf(com_tencent_mm_protocal_c_alr.tfk));
                        c.oTb.a(90, 0, 1, false);
                        c.oTb.a(90, 1, 1, true);
                    }
                    i4++;
                }
                w.i("MicroMsg.NetSceneSendMsg", "summerdktext total  [%d]msgs sent successfully, [%d]msgs need verifypsw", Integer.valueOf(i4 - this.hKK.size()), Integer.valueOf(this.hKK.size()));
            }
            w.d("MicroMsg.NetSceneSendMsg", "summerdktext send finish, continue send SENDING msg verifyingPsw[%b]", Boolean.valueOf(this.hKJ));
            if (this.hKJ) {
                this.gUD.a(i2, i3, str, this);
                return;
            } else {
                jP(str);
                return;
            }
        }
        c.oTb.a(111, (long) (i2 + 40), 1, true);
        c.oTb.a(111, 253, 1, false);
        w.i("MicroMsg.NetSceneSendMsg", "mark all failed. onGYNetEnd. errType:%d errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        Hs();
        this.gUD.a(i2, i3, str, this);
        for (int i5 = 0; i5 < this.hKH.size(); i5++) {
            ge(i5);
        }
        w.d("MicroMsg.NetSceneSendMsg", "send fail, continue send SENDING msg");
        jP(str);
    }

    public final void jP(String str) {
        w.d("MicroMsg.NetSceneSendMsg", "continue send msg in list");
        int a = a(this.hsD, this.gUD);
        if (a == -2) {
            this.gUD.a(0, 0, str, this);
        } else if (a < 0) {
            this.gUD.a(3, -1, str, this);
        }
    }

    public static void a(aj ajVar) {
        hKG.remove(ajVar);
    }

    private void Hs() {
        for (int i = 0; i < this.hKH.size(); i++) {
            gf(i);
        }
    }

    private void gf(int i) {
        w.d("MicroMsg.NetSceneSendMsg", "markMsgFailed for id:%d", Long.valueOf(((au) this.hKH.get(i)).field_msgId));
        r(r0);
    }

    static void r(au auVar) {
        auVar.dv(5);
        c.oTb.a(111, 30, 1, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().a(auVar.field_msgId, auVar);
        for (aj ajVar : hKG) {
            String str = auVar.field_talker;
            String str2 = auVar.field_content;
            ajVar.ge(str);
        }
    }
}
