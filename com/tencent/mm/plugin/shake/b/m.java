package com.tencent.mm.plugin.shake.b;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.e.a.jb;
import com.tencent.mm.e.a.mk;
import com.tencent.mm.e.a.oe;
import com.tencent.mm.e.a.qd;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.c.a.d;
import com.tencent.mm.plugin.shake.c.a.f;
import com.tencent.mm.plugin.shake.d.a.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.as.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bp;
import com.tencent.mm.u.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class m implements am {
    private static HashMap<Integer, c> gJr;
    private a hmk = new a(this) {
        final /* synthetic */ m poI;

        {
            this.poI = r1;
        }

        public final void a(ae aeVar, as asVar) {
            if (aeVar != null && o.fy(aeVar.field_username)) {
                aeVar.setUsername("");
            }
        }
    };
    private com.tencent.mm.sdk.b.c ksx = new com.tencent.mm.sdk.b.c<qd>(this) {
        final /* synthetic */ m poI;

        {
            this.poI = r2;
            this.usg = qd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            qd qdVar = (qd) bVar;
            if (qdVar.fXi.fXj.equals(oe.class.getName())) {
                if (qdVar.fXi.fJA == 1) {
                    this.poI.poD.Rg();
                } else {
                    this.poI.poD.unregister();
                }
            }
            return false;
        }
    };
    public com.tencent.mm.sdk.platformtools.ae mHandler = new com.tencent.mm.sdk.platformtools.ae(Looper.getMainLooper());
    private com.tencent.mm.sdk.b.c nTr = new com.tencent.mm.sdk.b.c<jb>(this) {
        final /* synthetic */ m poI;

        {
            this.poI = r2;
            this.usg = jb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            jb jbVar = (jb) bVar;
            if (jbVar instanceof jb) {
                switch (jbVar.fOW.action) {
                    case -4:
                        Cursor baH = m.baS().baH();
                        jbVar.fOX.fKC = new ArrayList();
                        while (baH != null && baH.moveToNext()) {
                            d dVar = new d();
                            dVar.b(baH);
                            jbVar.fOX.fKC.add(i.a(dVar.field_lvbuffer, 0));
                        }
                        if (baH != null) {
                            baH.close();
                            break;
                        }
                        break;
                }
            }
            return false;
        }
    };
    private ar.a nVK = new ar.a(this) {
        final /* synthetic */ m poI;

        {
            this.poI = r1;
        }

        public final void a(ar arVar, x xVar) {
            if (arVar != null && xVar != null && xVar.tA()) {
                m.baS().Ed(xVar.field_username);
            }
        }
    };
    private d poA;
    private com.tencent.mm.plugin.shake.d.a.o poB;
    private n poC = new n();
    com.tencent.mm.pluginsdk.e.d poD = new com.tencent.mm.pluginsdk.e.d(this) {
        final /* synthetic */ m poI;

        {
            this.poI = r1;
        }

        public final b xW(String str) {
            b oeVar = new oe();
            oeVar.fVo.fDz = str;
            return oeVar;
        }

        public final j aBJ() {
            return m.baT();
        }
    };
    private bp.a poE = new bp.a(this) {
        final /* synthetic */ m poI;

        {
            this.poI = r1;
        }

        public final void a(com.tencent.mm.y.d.a aVar) {
            m.baR();
            if (m.baW() != 0) {
                m.baR();
                m.baW();
                String a = n.a(aVar.hst.tff);
                w.v("MicroMsg.ShakeMsgMgr", "func[onResvMsg] content:" + a);
                if (bg.mA(a)) {
                    w.d("MicroMsg.ShakeMsgMgr", "func[onResvMsg] Msg content empty");
                    return;
                }
                Map q = bh.q(a, "sysmsg");
                int i = bg.getInt((String) q.get(".sysmsg.shake.$type"), 0);
                switch (i) {
                    case 1:
                        f fVar = new f();
                        i = bg.getInt((String) q.get(".sysmsg.shake.shaketv.msgtype"), 0);
                        if (i == 0) {
                            fVar.field_type = 1;
                            fVar.field_subtype = i;
                            fVar.field_svrid = aVar.hst.tfk;
                            fVar.field_createtime = bg.Ny();
                            fVar.field_tag = (String) q.get(".sysmsg.shake.shaketv.jumpurl");
                            fVar.field_status = 0;
                            fVar.field_title = (String) q.get(".sysmsg.shake.shaketv.title");
                            fVar.field_thumburl = (String) q.get(".sysmsg.shake.shaketv.iconurl");
                            fVar.field_desc = (String) q.get(".sysmsg.shake.shaketv.desc");
                            fVar.field_reserved1 = bg.mz((String) q.get(".sysmsg.shake.shaketv.pid"));
                            m.baT().a(fVar);
                            return;
                        }
                        w.w("MicroMsg.ShakeMsgMgr", "Unknown subType:" + i);
                        return;
                    default:
                        w.d("MicroMsg.ShakeMsgMgr", "Unrecognized type :" + i);
                        return;
                }
            }
            w.w("MicroMsg.SubCoreShake", "func[onRecieveMsg] getShakeMsgMgr null");
        }
    };
    private com.tencent.mm.sdk.b.c poF = new com.tencent.mm.sdk.b.c<mk>(this) {
        final /* synthetic */ m poI;

        {
            this.poI = r2;
            this.usg = mk.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (((mk) bVar) instanceof mk) {
                g.oUh.i(10221, new Object[]{Integer.valueOf(r6.fTH.scene)});
            } else {
                w.e("MicroMsg.SubCoreShake", "mismatch event listener for ReportClickFindFriendShakeEvent");
            }
            return false;
        }
    };
    private bp.a poG = new bp.a(this) {
        final /* synthetic */ m poI;

        {
            this.poI = r1;
        }

        public final void a(final com.tencent.mm.y.d.a aVar) {
            final String a = n.a(aVar.hst.tff);
            if (a == null || a.length() == 0) {
                w.e("MicroMsg.SubCoreShake", "onReceiveMsg, ShakeCardEntranceMsg msgContent is null");
            } else {
                this.poI.mHandler.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass4 poJ;

                    public final void run() {
                        m.baX().d(a, aVar.hst.tfk, 0);
                    }
                });
            }
        }
    };
    private bp.a poH = new bp.a(this) {
        final /* synthetic */ m poI;

        {
            this.poI = r1;
        }

        public final void a(final com.tencent.mm.y.d.a aVar) {
            final String a = n.a(aVar.hst.tff);
            if (a == null || a.length() == 0) {
                w.e("MicroMsg.SubCoreShake", "onReceiveMsg, ShakeCardRedDotMsg msgContent is null");
            } else {
                this.poI.mHandler.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass5 poK;

                    public final void run() {
                        m.baX().d(a, aVar.hst.tfk, 1);
                    }
                });
            }
        }
    };
    private e pox;
    private g poy;
    private f poz;

    public static m baR() {
        m mVar = (m) ap.yR().gs("plugin.shake");
        if (mVar != null) {
            return mVar;
        }
        Object mVar2 = new m();
        ap.yR().a("plugin.shake", mVar2);
        return mVar2;
    }

    public static e baS() {
        h.vG().uQ();
        if (baR().pox == null) {
            m baR = baR();
            ap.yY();
            baR.pox = new e(com.tencent.mm.u.c.wO());
        }
        return baR().pox;
    }

    public static g baT() {
        h.vG().uQ();
        if (baR().poy == null) {
            m baR = baR();
            ap.yY();
            baR.poy = new g(com.tencent.mm.u.c.wO());
        }
        return baR().poy;
    }

    public static com.tencent.mm.plugin.shake.d.a.o baU() {
        h.vG().uQ();
        if (baR().poB == null) {
            m baR = baR();
            ap.yY();
            baR.poB = new com.tencent.mm.plugin.shake.d.a.o(com.tencent.mm.u.c.wO());
        }
        return baR().poB;
    }

    public final void onAccountRelease() {
        ap.yY();
        com.tencent.mm.u.c.wW().c(this.hmk);
        com.tencent.mm.sdk.b.a.urY.c(this.ksx);
        com.tencent.mm.sdk.b.a.urY.c(this.poF);
        com.tencent.mm.sdk.b.a.urY.c(this.poC);
        com.tencent.mm.sdk.b.a.urY.c(this.nTr);
        ap.yY();
        com.tencent.mm.u.c.wR().b(this.nVK);
        ap.getSysCmdMsgExtension().b("shake", this.poE, true);
        ap.getSysCmdMsgExtension().b("ShakeCardEntrance", this.poG, true);
        ap.getSysCmdMsgExtension().b("ShakeCardRedDot", this.poH, true);
        l.a.sBu = null;
    }

    static {
        HashMap hashMap = new HashMap();
        gJr = hashMap;
        hashMap.put(Integer.valueOf("SHAKEITEM_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return e.gUx;
            }
        });
        gJr.put(Integer.valueOf("SHAKEMSG_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return g.gUx;
            }
        });
        gJr.put(Integer.valueOf("SHAKETVHISTORY_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return com.tencent.mm.plugin.shake.d.a.o.gUx;
            }
        });
        gJr.put(Integer.valueOf("SHAKENEWYEARFRIENDINFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return k.gUx;
            }
        });
    }

    public final HashMap<Integer, c> uh() {
        return gJr;
    }

    public final void eD(int i) {
        if ((i & 256) != 0) {
            baV();
        }
    }

    public static void baV() {
        baS().baJ();
        com.tencent.mm.av.l.KA().Ku();
    }

    public final void aM(boolean z) {
        l.a.sBu = new h();
        ap.yY();
        com.tencent.mm.u.c.wW().b(this.hmk);
        com.tencent.mm.sdk.b.a.urY.b(this.ksx);
        com.tencent.mm.sdk.b.a.urY.b(this.poF);
        com.tencent.mm.sdk.b.a.urY.b(this.poC);
        com.tencent.mm.sdk.b.a.urY.b(this.nTr);
        ap.yY();
        com.tencent.mm.u.c.wR().a(this.nVK);
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ m poI;

            {
                this.poI = r1;
            }

            public final void run() {
                if (ap.zb()) {
                    ap.yY();
                    bg.d(com.tencent.mm.u.c.xk(), "Sk", 604800000);
                }
            }

            public final String toString() {
                return super.toString() + "|onAccountPostReset";
            }
        });
        ap.getSysCmdMsgExtension().a("shake", this.poE, true);
        ap.getSysCmdMsgExtension().a("ShakeCardEntrance", this.poG, true);
        ap.getSysCmdMsgExtension().a("ShakeCardRedDot", this.poH, true);
        this.poz = null;
        this.poA = null;
    }

    public final void aN(boolean z) {
    }

    public static int baW() {
        h.vG().uQ();
        return i.pol;
    }

    public static String jC(String str) {
        if (!ap.zb()) {
            return "";
        }
        r1 = new Object[2];
        ap.yY();
        r1[0] = com.tencent.mm.u.c.xk();
        r1[1] = com.tencent.mm.a.g.n(str.getBytes());
        return String.format("%s/Sk_%s", r1);
    }

    public static String dl(String str, String str2) {
        if (!ap.zb() || bg.mA(str)) {
            return "";
        }
        r1 = new Object[3];
        ap.yY();
        r1[0] = com.tencent.mm.u.c.xk();
        r1[1] = str2;
        r1[2] = com.tencent.mm.a.g.n(str.getBytes());
        return String.format("%s/Sk%s_%s", r1);
    }

    public static f baX() {
        h.vG().uQ();
        if (baR().poz == null) {
            baR().poz = new f();
        }
        return baR().poz;
    }

    public static d baY() {
        h.vG().uQ();
        if (baR().poA == null) {
            baR().poA = new d();
        }
        return baR().poA;
    }
}
