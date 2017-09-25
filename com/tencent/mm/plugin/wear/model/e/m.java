package com.tencent.mm.plugin.wear.model.e;

import android.os.Looper;
import com.tencent.mm.c.c.c;
import com.tencent.mm.e.a.si;
import com.tencent.mm.e.a.sk;
import com.tencent.mm.i.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.protocal.c.bdp;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.protocal.c.boj;
import com.tencent.mm.protocal.c.bok;
import com.tencent.mm.protocal.c.bol;
import com.tencent.mm.protocal.c.bom;
import com.tencent.mm.protocal.c.boq;
import com.tencent.mm.protocal.c.bpm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public final class m extends a {

    private static class a extends d {
        private bom rUv;

        public a(bom com_tencent_mm_protocal_c_bom) {
            this.rUv = com_tencent_mm_protocal_c_bom;
        }

        protected final void execute() {
            String lX = q.lX(this.rUv.umH);
            w.i("MicroMsg.Wear.HttpReplyServer", "get fileName=%s", new Object[]{lX});
            w.i("MicroMsg.Wear.HttpReplyServer", "get fullPath=%s", new Object[]{q.E(lX, false)});
            InputStream byteArrayInputStream = new ByteArrayInputStream(this.rUv.tgI.toByteArray());
            c cVar = new c(8000, 16000);
            cVar.bz(r0);
            byte[] bArr = new byte[320];
            int i = 0;
            while (true) {
                try {
                    i = byteArrayInputStream.read(bArr, 0, 320);
                } catch (IOException e) {
                }
                if (i > 0) {
                    cVar.a(new com.tencent.mm.c.b.g.a(bArr, i), 0, false);
                } else {
                    cVar.ps();
                    w.i("MicroMsg.Wear.HttpReplyServer", "amr compress finish");
                    q.K(lX, (int) this.rUv.unc);
                    com.tencent.mm.modelvoice.m.LA().run();
                    w.i("MicroMsg.Wear.HttpReplyServer", "run service to send the voice");
                    ap.yY();
                    com.tencent.mm.u.c.wW().Ro(this.rUv.umH);
                    return;
                }
            }
        }

        public final String getName() {
            return "SendVioceMsgTask";
        }
    }

    public final List<Integer> bvW() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11022));
        arrayList.add(Integer.valueOf(11023));
        arrayList.add(Integer.valueOf(11025));
        arrayList.add(Integer.valueOf(11024));
        arrayList.add(Integer.valueOf(11026));
        arrayList.add(Integer.valueOf(11029));
        return arrayList;
    }

    protected final boolean vL(int i) {
        switch (i) {
            case 11023:
            case 11025:
                return true;
            default:
                return false;
        }
    }

    protected final byte[] l(int i, byte[] bArr) {
        switch (i) {
            case 11022:
                bom com_tencent_mm_protocal_c_bom = new bom();
                try {
                    com_tencent_mm_protocal_c_bom.aD(bArr);
                } catch (IOException e) {
                }
                com.tencent.mm.plugin.wear.model.a.bvG().rTu.a(new a(com_tencent_mm_protocal_c_bom));
                com.tencent.mm.plugin.wear.model.a.bvG().rTq.IE(com_tencent_mm_protocal_c_bom.umH);
                com.tencent.mm.plugin.wear.model.c.a.dv(2, com_tencent_mm_protocal_c_bom.tdM);
                com.tencent.mm.plugin.wear.model.c.a.vJ(2);
                break;
            case 11023:
                bol com_tencent_mm_protocal_c_bol = new bol();
                try {
                    com_tencent_mm_protocal_c_bol.aD(bArr);
                } catch (IOException e2) {
                }
                com.tencent.mm.plugin.messenger.a.d.aJW().A(com_tencent_mm_protocal_c_bol.umH, com_tencent_mm_protocal_c_bol.tGa, o.fG(com_tencent_mm_protocal_c_bol.umH));
                ap.yY();
                com.tencent.mm.u.c.wW().Ro(com_tencent_mm_protocal_c_bol.umH);
                com.tencent.mm.plugin.wear.model.c.a.dv(3, com_tencent_mm_protocal_c_bol.tdM);
                com.tencent.mm.plugin.wear.model.c.a.vJ(5);
                break;
            case 11024:
                boj com_tencent_mm_protocal_c_boj = new boj();
                try {
                    com_tencent_mm_protocal_c_boj.aD(bArr);
                } catch (IOException e3) {
                }
                ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().l(ab.getContext(), com_tencent_mm_protocal_c_boj.umH, com_tencent_mm_protocal_c_boj.tuy);
                ap.yY();
                com.tencent.mm.u.c.wW().Ro(com_tencent_mm_protocal_c_boj.umH);
                com.tencent.mm.plugin.wear.model.c.a.dv(7, com_tencent_mm_protocal_c_boj.tdM);
                com.tencent.mm.plugin.wear.model.c.a.vJ(3);
                break;
            case 11025:
                bok com_tencent_mm_protocal_c_bok = new bok();
                try {
                    com_tencent_mm_protocal_c_bok.aD(bArr);
                } catch (IOException e4) {
                }
                com.tencent.mm.plugin.messenger.a.d.aJW().A(com_tencent_mm_protocal_c_bok.umH, com_tencent_mm_protocal_c_bok.tGa, o.fG(com_tencent_mm_protocal_c_bok.umH));
                ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().l(ab.getContext(), com_tencent_mm_protocal_c_bok.umH, com_tencent_mm_protocal_c_bok.tuy);
                ap.yY();
                com.tencent.mm.u.c.wW().Ro(com_tencent_mm_protocal_c_bok.umH);
                com.tencent.mm.plugin.wear.model.c.a.dv(8, com_tencent_mm_protocal_c_bok.tdM);
                com.tencent.mm.plugin.wear.model.c.a.vJ(4);
                break;
            case 11026:
                boq com_tencent_mm_protocal_c_boq = new boq();
                try {
                    com_tencent_mm_protocal_c_boq.aD(bArr);
                } catch (IOException e5) {
                }
                com.tencent.mm.plugin.wear.model.a.bvG();
                bnp com_tencent_mm_protocal_c_bnp = com.tencent.mm.plugin.wear.model.a.bvG().rTo.rTF.rUt;
                if (com_tencent_mm_protocal_c_bnp != null) {
                    w.i("MicroMsg.Wear.WearBizLogic", "receive step count %d | time %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_boq.unh), com.tencent.mm.pluginsdk.j.o.Z("yyyy-MM-dd HH:mm:ss", com_tencent_mm_protocal_c_boq.uni / 1000)});
                    bpm com_tencent_mm_protocal_c_bpm = new bpm();
                    bdp com_tencent_mm_protocal_c_bdp = new bdp();
                    com_tencent_mm_protocal_c_bdp.jOa = com_tencent_mm_protocal_c_boq.unh > 0 ? com_tencent_mm_protocal_c_boq.unh : 0;
                    com_tencent_mm_protocal_c_bdp.tvD = (int) (com_tencent_mm_protocal_c_boq.uni / 1000);
                    Calendar instance = Calendar.getInstance();
                    instance.setTimeInMillis(com_tencent_mm_protocal_c_boq.uni);
                    com_tencent_mm_protocal_c_bdp.ueQ = instance.get(1);
                    com_tencent_mm_protocal_c_bdp.ueR = instance.get(2) + 1;
                    com_tencent_mm_protocal_c_bdp.ueS = instance.get(5);
                    com_tencent_mm_protocal_c_bdp.ueT = instance.get(11);
                    com_tencent_mm_protocal_c_bdp.ueU = instance.get(12);
                    com_tencent_mm_protocal_c_bdp.ueV = instance.get(13);
                    com_tencent_mm_protocal_c_bpm.unR.add(com_tencent_mm_protocal_c_bdp);
                    b skVar = new sk();
                    try {
                        skVar.gac.data = com_tencent_mm_protocal_c_bpm.toByteArray();
                    } catch (IOException e6) {
                    }
                    skVar.gac.fEG = 4;
                    skVar.gac.fwJ = com_tencent_mm_protocal_c_bnp.umA;
                    skVar.gac.fGl = "gh_43f2581f6fd6";
                    com.tencent.mm.sdk.b.a.urY.m(skVar);
                    break;
                }
                w.e("MicroMsg.Wear.WearBizLogic", "logicRequest is null");
                break;
            case 11029:
                if (com.tencent.mm.plugin.wear.model.a.bvG().rTo.bvL() && g.sV().getInt("WearLuckyBlock", 0) == 0) {
                    long j = 0;
                    try {
                        j = Long.valueOf(new String(bArr)).longValue();
                    } catch (Exception e7) {
                    }
                    b siVar = new si();
                    siVar.fZQ.action = 1;
                    siVar.fZQ.fEU = j;
                    com.tencent.mm.sdk.b.a.urY.a(siVar, Looper.getMainLooper());
                    com.tencent.mm.plugin.wear.model.c.a.dv(11, 0);
                    com.tencent.mm.plugin.wear.model.c.a.vJ(11);
                    break;
                }
                return null;
                break;
        }
        return null;
    }
}
