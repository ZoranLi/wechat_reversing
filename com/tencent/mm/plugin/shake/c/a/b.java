package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.protocal.c.zd;
import com.tencent.mm.protocal.c.ze;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class b extends k implements j {
    private final com.tencent.mm.y.b gUA;
    private e gUD;
    public e poL;

    public b(float f, float f2) {
        a aVar = new a();
        aVar.hsm = new zd();
        aVar.hsn = new ze();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/getlbscard";
        aVar.hsl = 1251;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        zd zdVar = (zd) this.gUA.hsj.hsr;
        zdVar.fOb = f2;
        zdVar.fPF = f;
    }

    public final int getType() {
        return 1251;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetLbsCard", "onGYNetEnd, getType = 1251" + " errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            ze zeVar = (ze) this.gUA.hsk.hsr;
            if (zeVar != null) {
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                if (!zeVar.tFm) {
                    w.e("MicroMsg.NetSceneGetLbsCard", "getlbscard have_card is false, no card , don't handle");
                } else if (zeVar.tFq <= currentTimeMillis) {
                    w.e("MicroMsg.NetSceneGetLbsCard", "getlbscard entrance_endtime: " + zeVar.tFq + " is <= currentTime:" + currentTimeMillis + " , don't handle");
                } else if (TextUtils.isEmpty(zeVar.kdE)) {
                    w.e("MicroMsg.NetSceneGetLbsCard", "getlbscard card_tp_id is empty , don't handle");
                } else {
                    w.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_card is true");
                    if (zeVar.tFn) {
                        w.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_red_dot is true");
                    } else {
                        w.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_red_dot is false");
                    }
                    this.poL = new e();
                    this.poL.kfr = 1;
                    this.poL.kdE = zeVar.kdE;
                    this.poL.fVm = zeVar.fVm;
                    this.poL.title = zeVar.title;
                    this.poL.kdH = zeVar.kdH;
                    this.poL.kdI = zeVar.kdI;
                    this.poL.keT = zeVar.keT;
                    this.poL.kdG = zeVar.kdG;
                    this.poL.hib = zeVar.hib;
                    this.poL.poM = 0;
                    this.poL.poP = zeVar.poP;
                    this.poL.poQ = zeVar.poQ;
                    this.poL.poR = zeVar.poR;
                    this.poL.poS = zeVar.poS;
                    this.poL.poT = "";
                    this.poL.kdL = zeVar.kdL;
                    this.poL.poU = zeVar.poU;
                    this.poL.poV = zeVar.poV;
                    m.baY().poO = this.poL.poT;
                    w.i("MicroMsg.NetSceneGetLbsCard", "getlbscard entrance_endtime: " + zeVar.tFq + " is <= currentTime:" + currentTimeMillis);
                    w.i("MicroMsg.NetSceneGetLbsCard", "getlbscard activity_type: " + zeVar.tFs);
                    ap.yY();
                    c.vr().a(com.tencent.mm.storage.w.a.uzp, Integer.valueOf(currentTimeMillis));
                    ap.yY();
                    c.vr().a(com.tencent.mm.storage.w.a.uzq, Integer.valueOf(zeVar.tFq));
                    ap.yY();
                    c.vr().a(com.tencent.mm.storage.w.a.uzr, zeVar.tFt);
                    ap.yY();
                    c.vr().a(com.tencent.mm.storage.w.a.uzu, zeVar.tFr);
                    ap.yY();
                    c.vr().a(com.tencent.mm.storage.w.a.uzv, Integer.valueOf(zeVar.tFs));
                    String bbo = com.tencent.mm.plugin.shake.c.c.a.bbo();
                    w.i("MicroMsg.NetSceneGetLbsCard", "getlbscard msg reddotid is " + zeVar.tFo);
                    w.i("MicroMsg.NetSceneGetLbsCard", "getlbscard pre reddotid is " + bbo);
                    if (TextUtils.isEmpty(zeVar.tFo)) {
                        w.i("MicroMsg.NetSceneGetLbsCard", "getlbscard resp.red_dot_id is empty");
                    }
                    if (TextUtils.isEmpty(bbo)) {
                        w.i("MicroMsg.NetSceneGetLbsCard", "getlbscard pre_red_dot_id is empty, resp.red_dot_id is not empty");
                        com.tencent.mm.q.c.uk().t(262155, true);
                        ap.yY();
                        c.vr().a(com.tencent.mm.storage.w.a.uzz, zeVar.tFo);
                        ap.yY();
                        c.vr().a(com.tencent.mm.storage.w.a.uzA, zeVar.tFp);
                    } else if (!bbo.equals(zeVar.tFo)) {
                        w.i("MicroMsg.NetSceneGetLbsCard", "getlbscard redDotId and msg.reddotid is not empty, but no equals");
                        com.tencent.mm.q.c.uk().t(262155, true);
                        ap.yY();
                        c.vr().a(com.tencent.mm.storage.w.a.uzz, zeVar.tFo);
                        ap.yY();
                        c.vr().a(com.tencent.mm.storage.w.a.uzA, zeVar.tFp);
                    } else if (bbo.equals(zeVar.tFo)) {
                        w.i("MicroMsg.NetSceneGetLbsCard", "redDotId equals msg.reddotid");
                    }
                    g.oUh.A(11721, zeVar.kdE);
                }
            } else {
                w.e("MicroMsg.NetSceneGetLbsCard", "getlbscard resp is null");
            }
        }
        this.gUD.a(i2, i3, str, this);
    }
}
