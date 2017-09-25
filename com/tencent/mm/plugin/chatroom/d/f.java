package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.e.b.af;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.all;
import com.tencent.mm.protocal.c.alm;
import com.tencent.mm.protocal.c.mu;
import com.tencent.mm.protocal.c.mv;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.x.h;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class f extends k implements j {
    public int fPr = 0;
    public String fPs;
    public final List<String> fPt;
    public final List<String> fPv;
    public List<String> fPw;
    public List<String> fPx;
    private final b gUA;
    private e gUD;
    public final List<String> ksM;

    public f(String str, List<String> list) {
        w.d("MicroMsg.NetSceneCreateChatRoom", "topic : " + str + " size : " + list.size() + " username : " + ((String) list.get(0)));
        a aVar = new a();
        aVar.hsm = new mu();
        aVar.hsn = new mv();
        aVar.uri = "/cgi-bin/micromsg-bin/createchatroom";
        aVar.hsl = 119;
        aVar.hso = 37;
        aVar.hsp = 1000000037;
        this.gUA = aVar.BE();
        mu muVar = (mu) this.gUA.hsj.hsr;
        muVar.ttd = n.mw(str);
        LinkedList linkedList = new LinkedList();
        for (String str2 : list) {
            all com_tencent_mm_protocal_c_all = new all();
            com_tencent_mm_protocal_c_all.ttv = n.mw(str2);
            linkedList.add(com_tencent_mm_protocal_c_all);
        }
        muVar.teK = linkedList;
        muVar.ksW = linkedList.size();
        this.fPt = new LinkedList();
        this.ksM = new LinkedList();
        this.fPv = new LinkedList();
        this.fPw = new LinkedList();
        this.fPx = new LinkedList();
        this.fPs = "";
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 119;
    }

    private static boolean a(mv mvVar) {
        if (!n.a(mvVar.teL).toLowerCase().endsWith("@chatroom") || mvVar.ksW == 0) {
            w.e("MicroMsg.NetSceneCreateChatRoom", "CreateChatroom: room:[" + mvVar.teL + "] listCnt:" + mvVar.ksW);
            return false;
        }
        af xVar = new x();
        xVar.bR(n.a(mvVar.ttd));
        xVar.bS(n.a(mvVar.ttf));
        xVar.bT(n.a(mvVar.ttg));
        xVar.setUsername(n.a(mvVar.teL));
        ap.yY();
        ar wR = c.wR();
        if (!wR.Re(xVar.field_username)) {
            wR.R(xVar);
        }
        h hVar = new h();
        hVar.username = xVar.field_username;
        hVar.hrB = mvVar.tqb;
        hVar.hrA = mvVar.tqc;
        hVar.gkq = 3;
        hVar.aV(false);
        hVar.fRW = -1;
        com.tencent.mm.x.n.Bm().a(hVar);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < mvVar.teK.size(); i++) {
            if (((alm) mvVar.teK.get(i)).tQk == 0) {
                af afVar;
                af Rc = wR.Rc(n.a(((alm) mvVar.teK.get(i)).ttv));
                if (((int) Rc.gTQ) != 0) {
                    Rc.tb();
                    wR.a(Rc.field_username, Rc);
                    afVar = Rc;
                } else {
                    afVar = com.tencent.mm.u.j.a(Rc, (alm) mvVar.teK.get(i));
                    wR.R(afVar);
                }
                arrayList.add(afVar.field_username);
            }
        }
        if (!arrayList.contains(m.xL())) {
            arrayList.add(m.xL());
            w.d("MicroMsg.NetSceneCreateChatRoom", "respon has not self add one " + arrayList.contains(m.xL()));
        }
        return com.tencent.mm.u.j.a(xVar.field_username, arrayList, m.xL());
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneCreateChatRoom", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        mv mvVar = (mv) this.gUA.hsk.hsr;
        this.fPs = n.a(mvVar.teL);
        int i4 = this.gUA.hsk.sZC;
        this.fPr = mvVar.ksW;
        ac(mvVar.teK);
        if (!bg.mA(this.fPs) && i4 == 0) {
            a(mvVar);
        }
        this.gUD.a(i2, i3, str, this);
    }

    private void ac(List<alm> list) {
        for (int i = 0; i < list.size(); i++) {
            int i2 = ((alm) list.get(i)).tQk;
            if (i2 == 0) {
                this.fPx.add(n.a(((alm) list.get(i)).ttv));
            } else if (i2 == 3) {
                w.d("MicroMsg.NetSceneCreateChatRoom", " blacklist : " + ((alm) list.get(i)).ttv);
                this.ksM.add(n.a(((alm) list.get(i)).ttv));
            } else if (i2 == 1) {
                w.d("MicroMsg.NetSceneCreateChatRoom", " not user : " + ((alm) list.get(i)).ttv);
                this.fPv.add(n.a(((alm) list.get(i)).ttv));
            } else if (i2 == 2) {
                w.d("MicroMsg.NetSceneCreateChatRoom", " invalid username : " + ((alm) list.get(i)).ttv);
                this.fPt.add(n.a(((alm) list.get(i)).ttv));
            } else if (i2 == 4) {
                w.d("MicroMsg.NetSceneCreateChatRoom", " verify user : " + ((alm) list.get(i)).ttv);
                this.fPw.add(n.a(((alm) list.get(i)).ttv));
            } else if (!(i2 == 5 || i2 == 6)) {
                w.w("MicroMsg.NetSceneCreateChatRoom", "unknown member status : status = " + i2);
            }
        }
    }
}
