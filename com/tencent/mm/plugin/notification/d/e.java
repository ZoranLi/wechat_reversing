package com.tencent.mm.plugin.notification.d;

import com.tencent.mm.bj.g;
import com.tencent.mm.e.a.ca;
import com.tencent.mm.e.a.fl;
import com.tencent.mm.e.a.kd;
import com.tencent.mm.e.a.ke;
import com.tencent.mm.e.a.mt;
import com.tencent.mm.e.a.mu;
import com.tencent.mm.i.f;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.notification.a.a;
import com.tencent.mm.plugin.notification.c.c;
import com.tencent.mm.plugin.notification.ui.FailSendMsgNotification;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class e implements am {
    private static e oaI = null;
    public c oaJ = null;
    public c oaK = null;
    private a oaL = null;
    public boolean oaM = false;
    private com.tencent.mm.sdk.b.c oaN = new com.tencent.mm.sdk.b.c<mt>(this) {
        final /* synthetic */ e oaT;

        {
            this.oaT = r2;
            this.usg = mt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            this.oaT.oaJ.aPt();
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c oaO = new com.tencent.mm.sdk.b.c<mu>(this) {
        final /* synthetic */ e oaT;

        {
            this.oaT = r2;
            this.usg = mu.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            this.oaT.oaK.aPt();
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c oaP = new com.tencent.mm.sdk.b.c<kd>(this) {
        final /* synthetic */ e oaT;

        {
            this.oaT = r2;
            this.usg = kd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            this.oaT.oaJ.aPx();
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c oaQ = new com.tencent.mm.sdk.b.c<ke>(this) {
        final /* synthetic */ e oaT;

        {
            this.oaT = r2;
            this.usg = ke.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            this.oaT.oaK.aPx();
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c oaR = new com.tencent.mm.sdk.b.c<ca>(this) {
        final /* synthetic */ e oaT;

        {
            this.oaT = r2;
            this.usg = ca.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            this.oaT.oaJ.aPz().dismiss();
            this.oaT.oaK.aPz().dismiss();
            w.i("MicroMsg.SubCoreNotification", "dismiss all fail msg notification");
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c oaS = new com.tencent.mm.sdk.b.c<fl>(this) {
        final /* synthetic */ e oaT;

        {
            this.oaT = r2;
            this.usg = fl.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            fl flVar = (fl) bVar;
            this.oaT.oaM = flVar.fKb.fCF;
            return false;
        }
    };

    private e() {
        a.init();
        if (this.oaK == null) {
            this.oaK = new d();
        }
        if (this.oaJ == null) {
            this.oaJ = new c();
        }
    }

    public static FailSendMsgNotification qJ(int i) {
        if (i == 2 && aPN().oaK != null) {
            w.d("MicroMsg.SubCoreNotification", "get sns notificaiton");
            return aPN().oaK.aPz();
        } else if (i != 1 || aPN().oaJ == null) {
            return null;
        } else {
            w.d("MicroMsg.SubCoreNotification", "get msg notificaiton");
            return aPN().oaJ.aPz();
        }
    }

    public static e aPN() {
        if (oaI == null) {
            oaI = new e();
            ap.yR().a("plugin.notification", oaI);
        }
        return oaI;
    }

    public final HashMap<Integer, g.c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        this.oaJ.aPI();
        this.oaJ.aPJ();
        this.oaK.aPI();
        this.oaK.aPJ();
        if (this.oaL == null) {
            this.oaL = new a();
        }
        Object obj = this.oaL;
        if (ap.zb()) {
            w.d("MicroMsg.NotificationObserver", "added");
            try {
                ap.yY();
                com.tencent.mm.u.c.wW().a(obj);
                obj.nZS = true;
            } catch (Throwable e) {
                w.e("MicroMsg.NotificationObserver", "exception:%s", new Object[]{bg.g(e)});
            }
        } else {
            w.e("MicroMsg.NotificationObserver", "account not ready!");
        }
        com.tencent.mm.sdk.b.a.urY.b(this.oaN);
        com.tencent.mm.sdk.b.a.urY.b(this.oaO);
        com.tencent.mm.sdk.b.a.urY.b(this.oaP);
        com.tencent.mm.sdk.b.a.urY.b(this.oaQ);
        com.tencent.mm.sdk.b.a.urY.b(this.oaR);
        com.tencent.mm.sdk.b.a.urY.b(this.oaS);
        f.sO();
        ap.getNotification().dO(f.sR());
        ap.getNotification().ax(false);
        w.d("MicroMsg.SubCoreNotification", "onAccountPostReset");
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
        this.oaJ.aPK();
        this.oaJ.aPL();
        this.oaK.aPK();
        this.oaK.aPL();
        if (this.oaL != null) {
            m.b bVar = this.oaL;
            if (ap.zb()) {
                try {
                    ap.yY();
                    com.tencent.mm.u.c.wW().b(bVar);
                } catch (Throwable e) {
                    w.e("MicroMsg.NotificationObserver", "exception:%s", new Object[]{bg.g(e)});
                }
            }
        }
        com.tencent.mm.sdk.b.a.urY.c(this.oaN);
        com.tencent.mm.sdk.b.a.urY.c(this.oaO);
        com.tencent.mm.sdk.b.a.urY.c(this.oaP);
        com.tencent.mm.sdk.b.a.urY.c(this.oaQ);
        com.tencent.mm.sdk.b.a.urY.c(this.oaR);
        com.tencent.mm.sdk.b.a.urY.c(this.oaS);
        ap.getNotification().dO(0);
        ap.getNotification().ax(true);
        w.d("MicroMsg.SubCoreNotification", "onAccountRelease");
    }

    public static boolean aPO() {
        return aPN().oaM;
    }

    public static ArrayList<Long> P(au auVar) {
        if (auVar == null) {
            return null;
        }
        ap.yY();
        com.tencent.mm.u.c.wT().a(auVar.field_msgId, auVar);
        ArrayList aKd = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().aKd();
        ArrayList<Long> arrayList = new ArrayList();
        Iterator it = aKd.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((au) it.next()).field_msgId));
        }
        return arrayList;
    }
}
