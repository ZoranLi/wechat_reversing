package com.tencent.mm.u;

import android.database.Cursor;
import com.tencent.mm.bj.g;
import com.tencent.mm.compatible.b.e;
import com.tencent.mm.e.a.z;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.kernel.e.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.c;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.ll;
import com.tencent.mm.protocal.c.wx;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.p;
import com.tencent.mm.protocal.q;
import com.tencent.mm.protocal.s;
import com.tencent.mm.protocal.t;
import com.tencent.mm.protocal.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.as.b;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.j;
import com.tencent.mm.storage.l;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.c.a;
import com.tencent.mm.y.d;
import com.tencent.mm.y.n;
import com.tencent.mm.y.r;
import com.tencent.mm.y.v;
import com.tencent.smtt.utils.TbsLog;
import junit.framework.Assert;

public final class ap {
    private static ap hlY = null;
    public final c hlP;
    public final ae hlX;
    private e hlZ = null;
    public bn hma = null;
    private final int hmb = 1;
    final a hmc;
    bq hmd = new bq();
    bj hme = new bj();
    e hmf = new e();
    bs hmg = new bs();
    r hmh = new r();
    ar.a hmi = new ar.a(this) {
        final /* synthetic */ ap hmm;

        {
            this.hmm = r1;
        }

        public final void a(ar arVar, x xVar) {
            String str = xVar.field_username;
            if (x.eO(xVar.field_username)) {
                xVar.setUsername(x.QR(xVar.field_username));
            }
            if (bg.mA(xVar.pB())) {
                xVar.bS(c.mq(xVar.field_nickname));
            }
            if (bg.mA(xVar.pC())) {
                xVar.bT(c.mp(xVar.field_nickname));
            }
            if (bg.mA(xVar.field_conRemarkPYShort)) {
                xVar.bW(c.mq(xVar.field_conRemark));
            }
            if (bg.mA(xVar.field_conRemarkPYFull)) {
                xVar.bV(c.mp(xVar.field_conRemark));
            }
            if (o.d(xVar)) {
                xVar.dc(43);
                xVar.bS(c.mq(xVar.tK()));
                xVar.bT(c.mp(xVar.tK()));
                xVar.bV(c.mp(xVar.tL()));
                xVar.bW(xVar.tL());
                return;
            }
            if (o.fE(str)) {
                x xVar2;
                xVar.tc();
                xVar.dh(4);
                xVar.dc(33);
                if (xVar == null) {
                    xVar2 = new x();
                } else {
                    xVar2 = xVar;
                }
                xVar2.setUsername(str);
                xVar2.tc();
                v.x(xVar2);
                xVar2.tl();
            }
            if (xVar.tC()) {
                xVar.dc(xVar.sZ());
            }
            if (o.fu(str)) {
                w.i("MicroMsg.MMCore", "update official account helper showhead %d", Integer.valueOf(31));
                xVar.dc(31);
            }
            if (xVar.tA()) {
                ap.yY();
                c.wW().e(new String[]{str}, "@blacklist");
            }
            w.d("MicroMsg.MMCore", "onPreInsertContact2: %s, %s", xVar.field_username, xVar.pB());
        }
    };
    as.a hmj = new as.a(this) {
        final /* synthetic */ ap hmm;

        {
            this.hmm = r1;
        }

        public final void a(ae aeVar, as asVar) {
            if (aeVar != null) {
                if (!x.QM(aeVar.field_username) && !x.QO(aeVar.field_username) && !x.eO(aeVar.field_username) && !o.eV(aeVar.field_username)) {
                    return;
                }
                au Ak;
                b oG;
                PString pString;
                PString pString2;
                PInt pInt;
                if (x.eO(aeVar.field_username)) {
                    ae aeVar2;
                    Object obj;
                    aj Rm = asVar.Rm("floatbottle");
                    if (Rm == null) {
                        aeVar2 = new ae("floatbottle");
                        obj = 1;
                    } else {
                        aj ajVar = Rm;
                        obj = null;
                    }
                    aeVar2.du(1);
                    aeVar2.dt(h.xI());
                    ap.yY();
                    Ak = c.wT().Ak(" and not ( type = 10000 and isSend != 2 ) ");
                    if (Ak == null || Ak.field_msgId <= 0) {
                        aeVar2.bLB();
                    } else {
                        aeVar2.W(Ak);
                        aeVar2.setContent(x.QR(Ak.field_talker) + ":" + Ak.field_content);
                        aeVar2.ct(Integer.toString(Ak.field_type));
                        oG = asVar.oG();
                        if (oG != null) {
                            pString = new PString();
                            pString2 = new PString();
                            pInt = new PInt();
                            Ak.cH("floatbottle");
                            Ak.setContent(aeVar2.field_content);
                            oG.a(Ak, pString, pString2, pInt, false);
                            aeVar2.cu(pString.value);
                            aeVar2.cv(pString2.value);
                            aeVar2.dx(pInt.value);
                        }
                    }
                    if (obj != null) {
                        asVar.d(aeVar2);
                    } else {
                        asVar.a(aeVar2, aeVar2.field_username);
                    }
                } else if (!x.QM(aeVar.field_username) && !x.QO(aeVar.field_username)) {
                    if (o.eV(aeVar.field_username) && !bg.mA(aeVar.field_parentRef)) {
                        Object obj2;
                        Object obj3;
                        ae aeVar3;
                        aj Rm2 = asVar.Rm(aeVar.field_parentRef);
                        w.v("MicroMsg.MMCore", "postConvExt, username = %s, parentRef = %s", aeVar.field_username, aeVar.field_parentRef);
                        if (aeVar.field_parentRef.equals("officialaccounts")) {
                            obj2 = null;
                        } else {
                            obj2 = 1;
                        }
                        if (Rm2 == null) {
                            Rm2 = new ae(aeVar.field_parentRef);
                            if (obj2 != null) {
                                Rm2.eB(2097152);
                            }
                            obj3 = 1;
                            aeVar3 = Rm2;
                        } else {
                            obj3 = null;
                            aj ajVar2 = Rm2;
                        }
                        w.i("MicroMsg.MMCore", "enterprise cvs count is %d", Integer.valueOf(aeVar3.field_unReadCount));
                        ap.yY();
                        String Rx = c.wW().Rx(aeVar.field_parentRef);
                        ap.yY();
                        Ak = c.wT().Ai(Rx);
                        if (Ak == null || Ak.field_msgId <= 0) {
                            aeVar3.bLB();
                            w.i("MicroMsg.MMCore", "lastOfMsg is null or MsgId <= 0, lastConvBiz is %s", Rx);
                        } else {
                            aeVar3.W(Ak);
                            aeVar3.setContent(Ak.field_talker + ":" + Ak.field_content);
                            aeVar3.ct(Integer.toString(Ak.field_type));
                            oG = asVar.oG();
                            if (oG != null) {
                                pString = new PString();
                                pString2 = new PString();
                                pInt = new PInt();
                                Ak.cH(aeVar.field_parentRef);
                                Ak.setContent(aeVar3.field_content);
                                oG.a(Ak, pString, pString2, pInt, true);
                                aeVar3.cu(pString.value);
                                aeVar3.cv(pString2.value);
                                aeVar3.dx(pInt.value);
                            }
                        }
                        Object obj4 = null;
                        if (obj2 != null) {
                            ap.yY();
                            if (c.wW().Rw(aeVar3.field_username) <= 0) {
                                obj4 = 1;
                            }
                        }
                        if (obj4 != null) {
                            asVar.Rl(aeVar3.field_username);
                        } else if (obj3 != null) {
                            asVar.d(aeVar3);
                        } else {
                            asVar.a(aeVar3, aeVar3.field_username);
                        }
                    }
                    if ("@blacklist".equals(aeVar.field_parentRef)) {
                        ap.yY();
                        af Rc = c.wR().Rc(aeVar.field_username);
                        if (Rc != null && !bg.mA(Rc.field_username) && !Rc.tA()) {
                            ap.yY();
                            c.wW().e(new String[]{aeVar.field_username}, "");
                        }
                    }
                }
            }
        }
    };
    as.a hmk = new as.a(this) {
        final /* synthetic */ ap hmm;

        {
            this.hmm = r1;
        }

        public final void a(ae aeVar, as asVar) {
            if (aeVar != null) {
            }
        }
    };
    f hml = new f();

    public static boolean yQ() {
        return hlY == null;
    }

    public static void a(m mVar) {
        h.vJ();
        h.vH().a(mVar);
    }

    public static void b(m mVar) {
        h.vJ();
        h.vH().b(mVar);
    }

    public static void a(ad adVar) {
        com.tencent.mm.kernel.b.a(adVar);
    }

    public static void eb(String str) {
        com.tencent.mm.kernel.a.eb(str);
    }

    public static bn yR() {
        return yU().hma;
    }

    public static br vK() {
        yU();
        return h.vK();
    }

    public static void a(ac acVar) {
        com.tencent.mm.kernel.e vI = h.vI();
        synchronized (vI.gYd) {
            vI.gYd.add(acVar);
        }
    }

    public static boolean yS() {
        return com.tencent.mm.kernel.a.uO();
    }

    public static void aT(boolean z) {
        com.tencent.mm.kernel.a.aQ(z);
    }

    public static byte[] vc() {
        try {
            h.vJ();
            return h.vH().vc();
        } catch (Throwable e) {
            w.w("MicroMsg.MMCore", "get session key error, %s", e.getMessage());
            w.e("MicroMsg.MMCore", "exception:%s", bg.g(e));
            return null;
        }
    }

    public static void a(ae aeVar, n.a aVar) {
        hlY = new ap(aeVar, aVar);
        com.tencent.mm.modelstat.n.bl(ab.getContext());
    }

    public static af getNotification() {
        return yU().hlX.getNotification();
    }

    public static y oH() {
        return yU().hlX.oH();
    }

    public static a yT() {
        return yU().hmc;
    }

    private ap(ae aeVar, n.a aVar) {
        this.hlX = aeVar;
        this.hma = new bn();
        this.hmc = new a(this) {
            final /* synthetic */ ap hmm;

            {
                this.hmm = r1;
            }

            public final void xH() {
                d.c.aA(Integer.valueOf(9999));
                d.c.aA(Integer.valueOf(41));
                d.c.aA(Integer.valueOf(21));
                d.c.aA(Integer.valueOf(35));
                d.c.aA(Integer.valueOf(-1879048175));
                d.c.aA(Integer.valueOf(-1879048174));
                this.hmm.hma.zQ();
            }

            public final void a(c cVar, boolean z) {
                w.i("MicroMsg.MMCore", "summeranrt2 onAccountPostReset tid:%d stack[%s]", Long.valueOf(Thread.currentThread().getId()), bg.bJZ());
                ap apVar = this.hmm;
                c.wR().a(apVar.hmi);
                c.wW().b(apVar.hmk);
                c.wW().a(apVar.hmj, null);
                d.c.a(Integer.valueOf(9999), apVar.hmd);
                d.c.a(Integer.valueOf(41), apVar.hme);
                d.c.a(Integer.valueOf(21), apVar.hmf);
                d.c.a(Integer.valueOf(35), apVar.hmf);
                d.c.a(Integer.valueOf(-1879048175), apVar.hmg);
                d.c.a(Integer.valueOf(-1879048174), apVar.hmh);
                bp sysCmdMsgExtension = ((com.tencent.mm.plugin.messenger.foundation.a.n) h.j(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension();
                sysCmdMsgExtension.a("addcontact", apVar.hml);
                sysCmdMsgExtension.a("dynacfg", apVar.hml);
                sysCmdMsgExtension.a("dynacfg_split", apVar.hml);
                sysCmdMsgExtension.a("banner", apVar.hml);
                sysCmdMsgExtension.a("midinfo", apVar.hml);
                sysCmdMsgExtension.a("revokemsg", apVar.hml);
                sysCmdMsgExtension.a("clouddelmsg", apVar.hml);
                sysCmdMsgExtension.a("updatepackage", apVar.hml);
                sysCmdMsgExtension.a("deletepackage", apVar.hml);
                sysCmdMsgExtension.a("delchatroommember", apVar.hml);
                sysCmdMsgExtension.a("WakenPush", apVar.hml);
                sysCmdMsgExtension.a("DisasterNotice", apVar.hml);
                sysCmdMsgExtension.a("EmotionKv", apVar.hml);
                sysCmdMsgExtension.a("globalalert", apVar.hml);
                sysCmdMsgExtension.a("yybsigcheck", apVar.hml);
                sysCmdMsgExtension.a("qy_status_notify", apVar.hml);
                sysCmdMsgExtension.a("qy_chat_update", apVar.hml);
                sysCmdMsgExtension.a("bindmobiletip", apVar.hml);
                sysCmdMsgExtension.a("ClientCheckConsistency", apVar.hml);
                sysCmdMsgExtension.a("ClientCheckHook", apVar.hml);
                sysCmdMsgExtension.a("ClientCheckGetAppList", apVar.hml);
                sysCmdMsgExtension.a("ClientCheckGetExtInfo", apVar.hml);
                sysCmdMsgExtension.a("functionmsg", apVar.hml);
                sysCmdMsgExtension.a("paymsg", apVar.hml);
                this.hmm.hma.aM(z);
                long currentTimeMillis = System.currentTimeMillis();
                ap.yY();
                long cs = c.wO().cs(Thread.currentThread().getId());
                if (z) {
                    c.wR().Ri("readerapp");
                    c.vr().set(256, Boolean.valueOf(true));
                    w.yF();
                    w.yF();
                    Cursor bLt = c.wR().bLt();
                    if (bLt.moveToFirst()) {
                        do {
                            af xVar = new x();
                            xVar.b(bLt);
                            xVar.to();
                            c.wR().a(xVar.field_username, xVar);
                        } while (bLt.moveToNext());
                    }
                    bLt.close();
                    ba.gp("ver" + com.tencent.mm.protocal.d.sYN);
                }
                v vVar = new v(this.hmm.hlP);
                if (z) {
                    v.w(c.wR().Rc("filehelper"));
                    String xL = m.xL();
                    if (!bg.mA(xL)) {
                        xVar = c.wR().Rc(xL);
                        if (((int) xVar.gTQ) == 0) {
                            xVar.setUsername(xL);
                            xVar.tc();
                            ap.yY();
                            c.wR().R(xVar);
                        } else if (!com.tencent.mm.j.a.ez(xVar.field_type)) {
                            xVar.tc();
                            ap.yY();
                            c.wR().a(xL, xVar);
                        }
                    }
                    v.a(z, "qqmail", false);
                    v.a(z, "floatbottle", false);
                    v.a(z, "shakeapp", false);
                    v.a(z, "lbsapp", false);
                    v.a(z, "medianote", false);
                    v.a(z, "newsapp", true);
                    c.wW().Rl("blogapp");
                    c.wT().Ao("blogapp");
                    c.wR().Ri("blogapp");
                    v.a(z, "facebookapp", true);
                    v.a(z, "qqfriend", false);
                    v.a(z, "masssendapp", true);
                    v.a(z, "feedsapp", true);
                    c.wW().Rl("tmessage");
                    c.wR().Ri("tmessage");
                    com.tencent.mm.j.a Rc = c.wR().Rc("voip");
                    com.tencent.mm.j.a Rc2 = c.wR().Rc("voipapp");
                    if (Rc2 == null) {
                        Rc2 = new x();
                    }
                    if (!(Rc == null || ((int) Rc.gTQ) == 0)) {
                        c.wR().Ri("voip");
                    }
                    if (((int) Rc2.gTQ) == 0) {
                        Rc2.setUsername("voipapp");
                        Rc2.tc();
                        v.x(Rc2);
                        Rc2.dh(4);
                        Rc2.tl();
                        c.wR().S(Rc2);
                    } else if (z) {
                        Rc2.tl();
                        c.wR().a("voipapp", Rc2);
                    }
                    Rc2 = c.wR().Rc("officialaccounts");
                    if (Rc2 == null) {
                        Rc2 = new x();
                    }
                    w.i("MicroMsg.HardCodeHelper", "hardcodeOfficialAccounts:update[%B], contactID[%d]", Boolean.valueOf(z), Integer.valueOf((int) Rc2.gTQ));
                    if (((int) Rc2.gTQ) == 0) {
                        Rc2.setUsername("officialaccounts");
                        Rc2.td();
                        v.x(Rc2);
                        Rc2.dh(3);
                        c.wR().S(Rc2);
                    } else if (z) {
                        w.i("MicroMsg.HardCodeHelper", "do update hardcode official accounts");
                        Rc2.td();
                        c.wR().a("officialaccounts", Rc2);
                    }
                    Rc = c.wR().Rc("voipaudio");
                    Rc2 = c.wR().Rc("voicevoipapp");
                    if (Rc2 == null) {
                        Rc2 = new x();
                    }
                    if (!(Rc == null || ((int) Rc.gTQ) == 0)) {
                        c.wR().Ri("voipaudio");
                    }
                    if (((int) Rc2.gTQ) == 0) {
                        Rc2.setUsername("voicevoipapp");
                        Rc2.tc();
                        v.x(Rc2);
                        Rc2.dh(4);
                        Rc2.tl();
                        c.wR().S(Rc2);
                    } else if (z) {
                        Rc2.tl();
                        c.wR().a("voicevoipapp", Rc2);
                    }
                    v.a(z, "voiceinputapp", false);
                    v.a(z, "linkedinplugin", false);
                    Rc2 = c.wR().Rc("notifymessage");
                    if (Rc2 == null) {
                        Rc2 = new x();
                    }
                    w.i("MicroMsg.HardCodeHelper", "hardcodeOfficialAccounts:update[%B], contactID[%d]", Boolean.valueOf(z), Integer.valueOf((int) Rc2.gTQ));
                    if (((int) Rc2.gTQ) == 0) {
                        Rc2.setUsername("notifymessage");
                        Rc2.td();
                        v.x(Rc2);
                        Rc2.dh(3);
                        c.wR().S(Rc2);
                    } else if (z) {
                        w.i("MicroMsg.HardCodeHelper", "do update hardcode official accounts");
                        Rc2.td();
                        c.wR().a("notifymessage", Rc2);
                    }
                    Rc2 = c.wR().Rc("appbrandcustomerservicemsg");
                    if (Rc2 == null) {
                        Rc2 = new x();
                    }
                    w.i("MicroMsg.HardCodeHelper", "hardcodeAppBrandServiceMessage:update[%B], contactID[%d]", Boolean.valueOf(z), Integer.valueOf((int) Rc2.gTQ));
                    if (((int) Rc2.gTQ) == 0) {
                        Rc2.setUsername("appbrandcustomerservicemsg");
                        Rc2.td();
                        v.x(Rc2);
                        Rc2.setType(0);
                        Rc2.dh(3);
                        c.wR().S(Rc2);
                    } else if (z) {
                        w.i("MicroMsg.HardCodeHelper", "do update app brand service message accunt");
                        Rc2.td();
                        c.wR().a("appbrandcustomerservicemsg", Rc2);
                    }
                    if (z) {
                        ap.yY();
                        c.wW().Rl("Weixin");
                        ap.yY();
                        c.wR().Ri("Weixin");
                    }
                }
                ap.yY();
                c.wO().aD(cs);
                w.i("MicroMsg.MMCore", "summeranrt dkwt set forceManual :%b, tid[%d], take[%s]ms, stack[%s]", Boolean.valueOf(z), Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), bg.bJZ());
                c.wW().a(ap.yU().hlX.oG());
            }

            public final void aN(boolean z) {
                this.hmm.hma.aN(z);
            }
        };
        h.vJ();
        h.vI().a(new com.tencent.mm.kernel.api.e(this) {
            final /* synthetic */ ap hmm;

            {
                this.hmm = r1;
            }

            public final void onDataBaseOpened(g gVar, g gVar2) {
                this.hmm.hmc.xH();
            }

            public final void onDataBaseClosed(g gVar, g gVar2) {
            }
        });
        h vJ = h.vJ();
        vJ.gYP.bI(new com.tencent.mm.kernel.api.c(this) {
            final /* synthetic */ ap hmm;

            {
                this.hmm = r1;
            }

            public final void onAccountInitialized(f fVar) {
                com.tencent.mm.plugin.report.service.g.oUh.a(598, 13, 1, false);
                long currentTimeMillis = System.currentTimeMillis();
                w.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized start tid[%d]", Long.valueOf(Thread.currentThread().getId()));
                c cVar = this.hmm.hlP;
                g gVar = h.vI().gYg;
                g gVar2 = h.vI().gYh;
                com.tencent.mm.plugin.messenger.foundation.a.a.c aJX = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX();
                aJX.a(new am(aJX));
                com.tencent.mm.storage.e hVar = new com.tencent.mm.storage.h(aJX);
                cVar.hkM = hVar;
                aJX.a(hVar);
                cVar.hkK = new bi(gVar, ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW());
                cVar.hkL = new bh(gVar, ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR());
                cVar.hkN = new com.tencent.mm.u.b.c();
                cVar.hkO = new com.tencent.mm.u.b.d();
                cVar.hkT = new com.tencent.mm.u.b.b();
                cVar.hkP = new com.tencent.mm.storage.ap(gVar);
                cVar.hkQ = new j(gVar);
                cVar.hkR = new com.tencent.mm.storage.n(gVar);
                cVar.hkS = new l(gVar);
                com.tencent.mm.plugin.report.service.g.oUh.a(598, 14, 1, false);
                w.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done initDB take[%d]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                this.hmm.hmc.a(this.hmm.hlP, fVar.gYz);
                com.tencent.mm.plugin.report.service.g.oUh.a(598, 15, 1, false);
                w.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done onAccountPostReset take[%d]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                this.hmm.hmc.aN(com.tencent.mm.compatible.util.f.rZ());
                com.tencent.mm.plugin.report.service.g.oUh.a(598, 16, 1, false);
                w.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done all take[%d]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }

            public final void onAccountRelease() {
                ap.yR().zR();
            }
        });
        h.vJ().gYQ.bI(aVar);
        this.hlP = new c();
        com.tencent.mm.plugin.report.service.g.oUh.a(99, 142, 1, false);
        r.a(new com.tencent.mm.plugin.zero.a.e(this) {
            final /* synthetic */ ap hmm;

            {
                this.hmm = r1;
            }

            public final byte[] a(k.d dVar, int i) {
                switch (i) {
                    case MMGIFException.D_GIF_ERR_WRONG_RECORD /*107*/:
                        return ((u.a) dVar).sZZ.tjF.tZp.toByteArray();
                    case com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX /*145*/:
                        return ((com.tencent.mm.protocal.m.a) dVar).sZG.tjF.tZp.toByteArray();
                    case 429:
                        return ((t.a) dVar).sZX.tjF.tZp.toByteArray();
                    case 481:
                        return ((p.a) dVar).sZO.tjF.tZp.toByteArray();
                    case 499:
                        return ((com.tencent.mm.plugin.report.b.c.a) dVar).oTn.tjF.tZp.toByteArray();
                    case 572:
                        return ((s.a) dVar).sZW.tjF.tZp.toByteArray();
                    case 616:
                        return ((at.a) dVar).hmt.tjF.tZp.toByteArray();
                    case 617:
                        return ((av.a) dVar).hmx.tjF.tZp.toByteArray();
                    case 618:
                        return ((au.a) dVar).hmv.tjF.tZp.toByteArray();
                    case 694:
                        return ((com.tencent.mm.plugin.report.b.b.a) dVar).oTn.tjF.tZp.toByteArray();
                    case 722:
                        return ((q.a) dVar).sZQ.tvI.tjF.tZp.toByteArray();
                    case 987:
                    case TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR /*997*/:
                        return ((ll) ((com.tencent.mm.y.b.b) dVar).hsr).trI.toByteArray();
                    case 989:
                        return ((wx) ((com.tencent.mm.y.b.b) dVar).hsr).trI.toByteArray();
                    case 1000:
                        return ((com.tencent.mm.protocal.j.a) dVar).sZq;
                    default:
                        return null;
                }
            }
        });
        h.vJ();
        com.tencent.mm.kernel.b vH = h.vH();
        vH.gXB.bI(new com.tencent.mm.kernel.api.d(this) {
            final /* synthetic */ ap hmm;

            {
                this.hmm = r1;
            }

            public final void b(com.tencent.mm.network.e eVar) {
                com.tencent.mm.modelstat.p.e(eVar);
                com.tencent.mm.modelstat.p.f(eVar);
            }
        });
    }

    public static ap yU() {
        Assert.assertNotNull("MMCore not initialized by MMApplication", hlY);
        return hlY;
    }

    public static v yV() {
        h.vJ();
        return h.vG().gXc;
    }

    public static com.tencent.mm.storage.s yW() {
        h.vJ();
        return h.vI().gXW;
    }

    public static com.tencent.mm.sdk.platformtools.af vL() {
        return h.vL();
    }

    public static bp getSysCmdMsgExtension() {
        return ((com.tencent.mm.plugin.messenger.foundation.a.n) h.j(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension();
    }

    public static String uY() {
        return com.tencent.mm.kernel.a.uY();
    }

    public static void uZ() {
        com.tencent.mm.kernel.a.uZ();
    }

    public static int ec(String str) {
        return com.tencent.mm.kernel.a.ec(str);
    }

    public static void yX() {
        com.tencent.mm.sdk.b.a.urY.m(new z());
    }

    public static c yY() {
        c cVar = yU().hlP;
        Assert.assertTrue("MMCore has not been initialize ?", cVar != null);
        return cVar;
    }

    public static n vd() {
        h.vJ();
        return h.vH().gXC;
    }

    public static e yZ() {
        return e.qE();
    }

    public static boolean za() {
        h.vG();
        return com.tencent.mm.kernel.a.uU();
    }

    public static boolean zb() {
        if (ab.bJb()) {
            return h.vG().uV();
        }
        return false;
    }

    public static boolean uP() {
        return com.tencent.mm.kernel.a.uP();
    }

    public static void hold() {
        com.tencent.mm.kernel.a.hold();
    }

    public static void unhold() {
        com.tencent.mm.kernel.a.unhold();
    }

    public static String uI() {
        h.vJ();
        h.vG();
        return com.tencent.mm.kernel.a.uI();
    }

    public static f zc() {
        return yU().hml;
    }
}
