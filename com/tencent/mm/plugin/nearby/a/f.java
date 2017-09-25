package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.R;
import com.tencent.mm.av.h;
import com.tencent.mm.av.l;
import com.tencent.mm.bj.g;
import com.tencent.mm.e.a.id;
import com.tencent.mm.e.a.ig;
import com.tencent.mm.e.a.ih;
import com.tencent.mm.e.a.ii;
import com.tencent.mm.e.a.ji;
import com.tencent.mm.e.a.jj;
import com.tencent.mm.e.a.qd;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode;
import com.tencent.mm.pluginsdk.e.d;
import com.tencent.mm.protocal.c.ajc;
import com.tencent.mm.protocal.c.aje;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.y.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class f implements am {
    private c ksx = new c<qd>(this) {
        final /* synthetic */ f nVL;

        {
            this.nVL = r2;
            this.usg = qd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            qd qdVar = (qd) bVar;
            if (qdVar.fXi.fXj.equals(ji.class.getName())) {
                if (qdVar.fXi.fJA == 1) {
                    this.nVL.nVH.bCx();
                } else {
                    this.nVL.nVH.aFC();
                }
            } else if (qdVar.fXi.fXj.equals(jj.class.getName())) {
                if (qdVar.fXi.fJA == 1) {
                    this.nVL.nVI.bCx();
                } else {
                    this.nVL.nVI.aFC();
                }
            } else if (qdVar.fXi.fXj.equals(id.class.getName())) {
                if (qdVar.fXi.fJA == 1) {
                    this.nVL.nVJ.Rg();
                } else {
                    this.nVL.nVJ.unregister();
                }
            }
            return false;
        }
    };
    private c nVF = new c<ih>(this) {
        final /* synthetic */ f nVL;

        {
            this.nVL = r2;
            this.usg = ih.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            int i = 3;
            ih ihVar = (ih) bVar;
            ay.b bVar2 = ihVar.fNR.fNS;
            ce ceVar = ihVar.fNR.fCZ;
            if (bVar2.hmR != null && bVar2.scene == 1) {
                ap.yY();
                com.tencent.mm.u.c.vr().set(73729, Integer.valueOf(1));
                h hVar = new h();
                hVar.field_content = ceVar.field_content;
                hVar.field_createtime = bg.Ny();
                hVar.field_imgpath = "";
                hVar.field_sayhicontent = ab.getContext().getString(R.l.eDk);
                hVar.field_sayhiuser = ceVar.field_talker;
                hVar.field_scene = 18;
                if (ceVar.field_status > 3) {
                    i = ceVar.field_status;
                }
                hVar.field_status = i;
                hVar.field_svrid = ceVar.field_msgSvrId;
                hVar.field_talker = ceVar.field_talker;
                hVar.field_type = 34;
                hVar.field_isSend = 0;
                hVar.field_sayhiencryptuser = ceVar.field_talker;
                hVar.field_ticket = bVar2.hmR;
                l.Kz().a(hVar);
                b igVar = new ig();
                igVar.fNP.fNQ = ceVar.field_talker;
                a.urY.m(igVar);
            }
            return false;
        }
    };
    private c nVG = new c<ii>(this) {
        final /* synthetic */ f nVL;

        {
            this.nVL = r2;
            this.usg = ii.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ii iiVar = (ii) bVar;
            switch (iiVar.fNT.fJA) {
                case 1:
                    b.bs(iiVar.fNT.fNV, iiVar.fNT.fNW);
                    break;
                case 2:
                    b.cV(iiVar.fNT.fNW);
                    break;
                case 3:
                    iiVar.fNU.fFj = b.aOA();
                    break;
                case 4:
                    b.aOB();
                    break;
                case 5:
                    b.aOC();
                    break;
                case 6:
                    b.BG(iiVar.fNT.fNV);
                    break;
                case 7:
                    ii.b bVar2 = iiVar.fNU;
                    ap.yY();
                    Long l = (Long) com.tencent.mm.u.c.vr().get(8210, null);
                    boolean z = l == null ? true : System.currentTimeMillis() > l.longValue();
                    bVar2.fFj = z;
                    break;
                default:
                    w.e("MicroMsg.SubCoreNearby", "LbsroomLogicEvent unkown opcode!");
                    break;
            }
            return false;
        }
    };
    com.tencent.mm.pluginsdk.e.c<ji> nVH = new com.tencent.mm.pluginsdk.e.c<ji>(this) {
        final /* synthetic */ f nVL;

        {
            this.nVL = r1;
        }

        public final /* synthetic */ b a(int i, k kVar, b bVar) {
            ji jiVar = (ji) bVar;
            c cVar = (c) kVar;
            jiVar.fPE.fPK = cVar.aOD();
            jiVar.fPE.fPM = cVar.aOE();
            jiVar.fPE.fPL = cVar.aOF();
            jiVar.fPE.fJA = jiVar.fPD.fJA;
            return jiVar;
        }

        public final /* synthetic */ boolean a(b bVar) {
            ji jiVar = (ji) bVar;
            if (jiVar.fPD.fPm) {
                com.tencent.mm.pluginsdk.e.c.k(jiVar);
            } else {
                l(jiVar);
            }
            return false;
        }

        public final /* synthetic */ k b(b bVar) {
            ji jiVar = (ji) bVar;
            return new c(jiVar.fPD.fJA, jiVar.fPD.fPF, jiVar.fPD.fOb, jiVar.fPD.fPG, jiVar.fPD.fPH, jiVar.fPD.fPI, jiVar.fPD.fPJ);
        }

        public final int ajb() {
            return JsApiScanCode.CTRL_INDEX;
        }
    };
    com.tencent.mm.pluginsdk.e.c<jj> nVI = new com.tencent.mm.pluginsdk.e.c<jj>(this) {
        final /* synthetic */ f nVL;

        {
            this.nVL = r1;
        }

        public final /* synthetic */ b a(int i, k kVar, b bVar) {
            jj jjVar = (jj) bVar;
            e eVar = (e) kVar;
            jjVar.fPO.fOw = ((aje) eVar.gUA.hsk.hsr).ksW;
            jj.b bVar2 = jjVar.fPO;
            LinkedList linkedList = ((aje) eVar.gUA.hsk.hsr).teK;
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    ajc com_tencent_mm_protocal_c_ajc = (ajc) it.next();
                    ap.yY();
                    com.tencent.mm.u.c.xB().eI(com_tencent_mm_protocal_c_ajc.jNj, com_tencent_mm_protocal_c_ajc.tBM);
                }
            }
            bVar2.fPA = linkedList;
            return jjVar;
        }

        public final /* synthetic */ boolean a(b bVar) {
            jj jjVar = (jj) bVar;
            if (jjVar.fPN.fPm) {
                com.tencent.mm.pluginsdk.e.c.k(jjVar);
            } else {
                l(jjVar);
            }
            return false;
        }

        public final /* synthetic */ k b(b bVar) {
            return new e(((jj) bVar).fPN.fNV);
        }

        public final int ajb() {
            return 377;
        }
    };
    d nVJ = new d(this) {
        final /* synthetic */ f nVL;

        {
            this.nVL = r1;
        }

        public final b xW(String str) {
            b idVar = new id();
            idVar.fNH.fDz = str;
            return idVar;
        }

        public final j aBJ() {
            return l.Kz();
        }
    };
    private ar.a nVK = new ar.a(this) {
        final /* synthetic */ f nVL;

        {
            this.nVL = r1;
        }

        public final void a(ar arVar, x xVar) {
            if (arVar != null && xVar != null && xVar.tA()) {
                l.Kz().ld(xVar.field_username);
            }
        }
    };

    public final void onAccountRelease() {
        ap.yY();
        com.tencent.mm.u.c.wR().b(this.nVK);
        a.urY.c(this.nVG);
        a.urY.c(this.ksx);
        a.urY.c(this.nVH);
        a.urY.c(this.nVI);
        this.nVF.dead();
    }

    public final HashMap<Integer, g.c> uh() {
        return null;
    }

    public final void eD(int i) {
        if ((i & 512) != 0) {
            aOG();
        }
    }

    public static void aOG() {
        l.Kz().Ku();
        ap.vd().a(new c(2, 0.0f, 0.0f, 0, 0, "", ""), 0);
    }

    public final void aM(boolean z) {
        ap.yY();
        com.tencent.mm.u.c.wR().a(this.nVK);
        a.urY.b(this.ksx);
        a.urY.b(this.nVG);
        a.urY.b(this.nVH);
        a.urY.b(this.nVI);
        this.nVF.bIy();
    }

    public final void aN(boolean z) {
    }
}
