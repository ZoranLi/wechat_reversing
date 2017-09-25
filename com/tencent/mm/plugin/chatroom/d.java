package com.tencent.mm.plugin.chatroom;

import com.tencent.mm.e.a.je;
import com.tencent.mm.e.a.jf;
import com.tencent.mm.e.a.jg;
import com.tencent.mm.e.a.jh;
import com.tencent.mm.e.a.jl;
import com.tencent.mm.e.a.qd;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.chatroom.c.a;
import com.tencent.mm.plugin.chatroom.d.e;
import com.tencent.mm.plugin.chatroom.d.f;
import com.tencent.mm.plugin.chatroom.d.g;
import com.tencent.mm.plugin.chatroom.d.i;
import com.tencent.mm.plugin.chatroom.d.l;
import com.tencent.mm.pluginsdk.e.c;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.k;
import java.util.HashMap;

public class d implements am {
    private static a ksy;
    public c<je> kss = new c<je>(this) {
        final /* synthetic */ d ksz;

        {
            this.ksz = r1;
        }

        public final /* bridge */ /* synthetic */ b a(int i, k kVar, b bVar) {
            return (je) bVar;
        }

        public final /* synthetic */ boolean a(b bVar) {
            je jeVar = (je) bVar;
            if (jeVar.fPk.fPm) {
                c.k(jeVar);
            } else {
                l(jeVar);
            }
            return false;
        }

        public final /* synthetic */ k b(b bVar) {
            return new e(((je) bVar).fPk.fPl);
        }

        public final int ajb() {
            return 181;
        }
    };
    public c<jh> kst = new c<jh>(this) {
        final /* synthetic */ d ksz;

        {
            this.ksz = r1;
        }

        public final /* bridge */ /* synthetic */ b a(int i, k kVar, b bVar) {
            return (jh) bVar;
        }

        public final /* synthetic */ boolean a(b bVar) {
            jh jhVar = (jh) bVar;
            if (jhVar.fPB.fPm) {
                c.k(jhVar);
            } else {
                l(jhVar);
            }
            return false;
        }

        public final /* synthetic */ k b(b bVar) {
            jh jhVar = (jh) bVar;
            return new i(jhVar.fPB.chatroomName, jhVar.fPB.fPC);
        }

        public final int ajb() {
            return 551;
        }
    };
    public c<jg> ksu = new c<jg>(this) {
        final /* synthetic */ d ksz;

        {
            this.ksz = r1;
        }

        public final /* bridge */ /* synthetic */ b a(int i, k kVar, b bVar) {
            jg jgVar = (jg) bVar;
            jgVar.fPz.errCode = i;
            return jgVar;
        }

        public final /* synthetic */ boolean a(b bVar) {
            jg jgVar = (jg) bVar;
            if (jgVar.fPy.fPm) {
                c.k(jgVar);
            } else {
                l(jgVar);
            }
            return false;
        }

        public final /* synthetic */ k b(b bVar) {
            jg jgVar = (jg) bVar;
            return new g(jgVar.fPy.chatroomName, jgVar.fPy.fPA, jgVar.fPy.scene);
        }

        public final int ajb() {
            return 179;
        }
    };
    public c<jl> ksv = new c<jl>(this) {
        final /* synthetic */ d ksz;

        {
            this.ksz = r1;
        }

        public final /* bridge */ /* synthetic */ b a(int i, k kVar, b bVar) {
            jl jlVar = (jl) bVar;
            jlVar.fPS.errCode = i;
            return jlVar;
        }

        public final /* synthetic */ boolean a(b bVar) {
            jl jlVar = (jl) bVar;
            if (jlVar.fPR.fPm) {
                c.k(jlVar);
            } else {
                l(jlVar);
            }
            return false;
        }

        public final /* synthetic */ k b(b bVar) {
            jl jlVar = (jl) bVar;
            return new l(jlVar.fPR.fPT, jlVar.fPR.chatroomName);
        }

        public final int ajb() {
            return 700;
        }
    };
    public c<jf> ksw = new c<jf>(this) {
        final /* synthetic */ d ksz;

        {
            this.ksz = r1;
        }

        public final /* bridge */ /* synthetic */ b a(int i, k kVar, b bVar) {
            jf jfVar = (jf) bVar;
            f fVar = (f) kVar;
            jfVar.fPo.fPr = fVar.fPr;
            jfVar.fPo.fPs = fVar.fPs;
            jfVar.fPo.fPt = fVar.fPt;
            jfVar.fPo.fPu = fVar.ksM;
            jfVar.fPo.fPx = fVar.fPx;
            jfVar.fPo.fPv = fVar.fPv;
            jfVar.fPo.fPw = fVar.fPw;
            return jfVar;
        }

        public final /* synthetic */ boolean a(b bVar) {
            jf jfVar = (jf) bVar;
            if (jfVar.fPn.fPm) {
                c.k(jfVar);
            } else {
                l(jfVar);
            }
            return false;
        }

        public final /* synthetic */ k b(b bVar) {
            jf jfVar = (jf) bVar;
            return new f(jfVar.fPn.fPp, jfVar.fPn.fPq);
        }

        public final int ajb() {
            return 119;
        }
    };
    private com.tencent.mm.sdk.b.c ksx = new com.tencent.mm.sdk.b.c<qd>(this) {
        final /* synthetic */ d ksz;

        {
            this.ksz = r2;
            this.usg = qd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            qd qdVar = (qd) bVar;
            if (qdVar.fXi.fXj.equals(je.class.getName())) {
                if (qdVar.fXi.fJA == 1) {
                    this.ksz.kss.bCx();
                } else {
                    this.ksz.kss.aFC();
                }
            } else if (qdVar.fXi.fXj.equals(jh.class.getName())) {
                if (qdVar.fXi.fJA == 1) {
                    this.ksz.kst.bCx();
                } else {
                    this.ksz.kst.aFC();
                }
            } else if (qdVar.fXi.fXj.equals(jf.class.getName())) {
                if (qdVar.fXi.fJA == 1) {
                    this.ksz.ksw.bCx();
                } else {
                    this.ksz.ksw.aFC();
                }
            } else if (qdVar.fXi.fXj.equals(jg.class.getName())) {
                if (qdVar.fXi.fJA == 1) {
                    this.ksz.ksu.bCx();
                } else {
                    this.ksz.ksu.aFC();
                }
            } else if (qdVar.fXi.fXj.equals(jl.class.getName())) {
                if (qdVar.fXi.fJA == 1) {
                    this.ksz.ksv.bCx();
                } else {
                    this.ksz.ksv.aFC();
                }
            }
            return false;
        }
    };

    private static d aiZ() {
        d dVar = (d) ap.yR().gs("plugin.chatroom");
        if (dVar == null) {
            synchronized (d.class) {
                if (dVar == null) {
                    dVar = new d();
                    ap.yR().a("plugin.chatroom", dVar);
                }
            }
        }
        return dVar;
    }

    private static a aja() {
        h.vG().uQ();
        aiZ();
        if (ksy == null) {
            aiZ();
            ksy = new a();
        }
        aiZ();
        return ksy;
    }

    public final HashMap<Integer, com.tencent.mm.bj.g.c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        com.tencent.mm.sdk.b.a.urY.b(this.ksx);
        com.tencent.mm.sdk.b.a.urY.b(this.kss);
        com.tencent.mm.sdk.b.a.urY.b(this.ksw);
        com.tencent.mm.sdk.b.a.urY.b(this.kst);
        com.tencent.mm.sdk.b.a.urY.b(this.ksu);
        com.tencent.mm.sdk.b.a.urY.b(this.ksv);
        a aja = aja();
        ap.getSysCmdMsgExtension().a("NewXmlChatRoomAccessVerifyApplication", aja.ksJ, true);
        ap.getSysCmdMsgExtension().a("NewXmlChatRoomAccessVerifyApproval", aja.ksJ, true);
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.urY.c(this.ksx);
        com.tencent.mm.sdk.b.a.urY.c(this.kss);
        com.tencent.mm.sdk.b.a.urY.c(this.ksw);
        com.tencent.mm.sdk.b.a.urY.c(this.kst);
        com.tencent.mm.sdk.b.a.urY.c(this.ksu);
        com.tencent.mm.sdk.b.a.urY.c(this.ksv);
        a aja = aja();
        ap.getSysCmdMsgExtension().b("NewXmlChatRoomAccessVerifyApplication", aja.ksJ, true);
        ap.getSysCmdMsgExtension().b("NewXmlChatRoomAccessVerifyApproval", aja.ksJ, true);
    }
}
