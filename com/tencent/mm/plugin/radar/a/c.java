package com.tencent.mm.plugin.radar.a;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.e.a.ff;
import com.tencent.mm.e.a.ll;
import com.tencent.mm.e.b.af;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class c implements com.tencent.mm.sdk.e.m.b {
    public Context context = null;
    ae handler = new ae();
    public com.tencent.mm.u.bp.a lew = new com.tencent.mm.u.bp.a(this) {
        final String oGA = ".sysmsg.addcontact.type";
        final String oGB = ".sysmsg.addcontact.username";
        final String oGC = ".sysmsg.addcontact.encryptusername";
        final /* synthetic */ c oGz;

        {
            this.oGz = r2;
        }

        public final void a(com.tencent.mm.y.d.a aVar) {
            Map q = bh.q(n.a(aVar.hst.tff), "sysmsg");
            if (((String) q.get(".sysmsg.addcontact.type")).equals("1")) {
                String str = (String) q.get(".sysmsg.addcontact.username");
                String str2 = (String) q.get(".sysmsg.addcontact.encryptusername");
                if (str == null || str.equals("") || str2 == null || str2.equals("")) {
                    w.e("MicroMsg.RadarAddContact", "error! server return incorrect content! : %s", new Object[]{r2});
                    return;
                }
                af xVar = new x();
                xVar.setUsername(str);
                xVar.bX(str2);
                this.oGz.I(xVar);
                w.d("MicroMsg.RadarAddContact", "receive contact added system message useranme %s, encypt %s", new Object[]{xVar.field_username, xVar.field_encryptUsername});
            }
        }
    };
    public LinkedList<String> oGv = new LinkedList();
    public HashMap<String, String> oGw = new HashMap();
    public b oGx = null;
    public com.tencent.mm.sdk.b.c oGy = new com.tencent.mm.sdk.b.c<ll>(this) {
        final /* synthetic */ c oGz;

        {
            this.oGz = r2;
            this.usg = ll.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            String str = ((ll) bVar).fSq.fSs;
            af a = c.a(com.tencent.mm.storage.au.d.RI(str));
            this.oGz.H(a);
            c cVar = this.oGz;
            cVar.oGw.put(a.field_username, str);
            cVar.oGw.put(a.field_encryptUsername, str);
            ap.yY();
            ar wR = com.tencent.mm.u.c.wR();
            if (!wR.Re(a.field_encryptUsername)) {
                wR.Q(a);
            }
            w.d("MicroMsg.RadarAddContact", "receive verify mssage %s, encypt %s", new Object[]{a.field_username, a.field_encryptUsername});
            c cVar2 = this.oGz;
            if (cVar2.oGx != null) {
                cVar2.handler.post(new AnonymousClass5(cVar2, a));
            }
            return false;
        }
    };

    class AnonymousClass5 implements Runnable {
        final /* synthetic */ x oGE;
        final /* synthetic */ c oGz;

        AnonymousClass5(c cVar, x xVar) {
            this.oGz = cVar;
            this.oGE = xVar;
        }

        public final void run() {
            this.oGz.oGx.J(this.oGE);
        }
    }

    class AnonymousClass7 implements Runnable {
        final /* synthetic */ String hqR;
        final /* synthetic */ String htn;
        final /* synthetic */ long oGD;
        final /* synthetic */ boolean oGF;
        final /* synthetic */ boolean oGG;
        final /* synthetic */ c oGz;

        AnonymousClass7(c cVar, boolean z, boolean z2, String str, String str2, long j) {
            this.oGz = cVar;
            this.oGF = z;
            this.oGG = z2;
            this.htn = str;
            this.hqR = str2;
            this.oGD = j;
        }

        public final void run() {
            this.oGz.oGx.a(this.oGF, this.oGG, this.htn, this.hqR, this.oGD);
        }
    }

    class AnonymousClass8 implements Runnable {
        final /* synthetic */ String hqR;
        final /* synthetic */ String htn;
        final /* synthetic */ long oGD;
        final /* synthetic */ boolean oGF;
        final /* synthetic */ c oGz;

        AnonymousClass8(c cVar, boolean z, String str, String str2, long j) {
            this.oGz = cVar;
            this.oGF = z;
            this.htn = str;
            this.hqR = str2;
            this.oGD = j;
        }

        public final void run() {
            this.oGz.oGx.a(this.oGF, this.htn, this.hqR, this.oGD);
        }
    }

    class a implements e {
        String jia;
        private c oGH;
        LinkedList<String> oGI = new LinkedList();
        LinkedList<Integer> oGJ;
        final /* synthetic */ c oGz;

        public a(c cVar, c cVar2) {
            this.oGz = cVar;
            this.oGH = cVar2;
        }

        public final void onStart() {
            ap.vd().a(30, this);
        }

        private void b(boolean z, boolean z2, String str, String str2) {
            ap.vd().b(30, this);
            if (this.oGH != null) {
                this.oGH.a(z, z2, str, str2);
            }
        }

        public final void a(int i, int i2, String str, k kVar) {
            w.d("MicroMsg.RadarAddContact", "onSceneEnd, errType = " + i + ", errCode = " + i2);
            if (kVar.getType() != 30) {
                w.w("MicroMsg.RadarAddContact", "not expected scene,  type = " + kVar.getType());
            } else if (((com.tencent.mm.pluginsdk.model.n) kVar).fJK == 2) {
                if (i == 0 && i2 == 0) {
                    b(false, true, this.jia, "");
                    return;
                }
                if (i == 4 && i2 == -34) {
                    str = this.oGz.context.getString(R.l.eld);
                } else if (i == 4 && i2 == -94) {
                    str = this.oGz.context.getString(R.l.ele);
                } else if (i != 4 || (!(i2 == -24 || i2 == -101) || bg.mA(str))) {
                    str = this.oGz.context.getString(R.l.eRk);
                }
                b(false, false, this.jia, str);
            } else if (i == 0 && i2 == 0) {
                b(true, false, this.jia, "");
            } else if (i2 == -44) {
                ap.vd().a(new com.tencent.mm.pluginsdk.model.n(2, this.oGI, this.oGJ, "", ""), 0);
            } else if (i2 == -87) {
                b(false, false, this.jia, this.oGz.context.getString(R.l.dXI));
            } else if (i2 != -24 || bg.mA(str)) {
                String string;
                if (i == 4 && i2 == -22) {
                    string = this.oGz.context.getString(R.l.dCh);
                } else {
                    string = this.oGz.context.getString(R.l.dCg);
                }
                b(false, false, this.jia, string);
            } else {
                b(false, false, this.jia, str);
            }
        }
    }

    public interface b {
        void I(x xVar);

        void J(x xVar);

        void a(boolean z, String str, String str2, long j);

        void a(boolean z, boolean z2, String str, String str2, long j);
    }

    interface c {
        void a(boolean z, boolean z2, String str, String str2);
    }

    public enum d {
        Stranger,
        Verifying,
        Added,
        NeedVerify
    }

    class AnonymousClass4 implements c {
        final /* synthetic */ String izs;
        final /* synthetic */ long oGD;
        final /* synthetic */ c oGz;

        public AnonymousClass4(c cVar, String str, long j) {
            this.oGz = cVar;
            this.izs = str;
            this.oGD = j;
        }

        public final void a(boolean z, boolean z2, String str, String str2) {
            boolean z3;
            if (z) {
                ap.yY();
                x Rc = com.tencent.mm.u.c.wR().Rc(str);
                if (Rc == null || ((int) Rc.gTQ) == 0) {
                    af a = c.a(com.tencent.mm.storage.au.d.RI(this.izs));
                    ap.yY();
                    if (!com.tencent.mm.u.c.wR().R(a)) {
                        w.e("MicroMsg.RadarAddContact", "canAddContact fail, insert fail");
                        z = false;
                    }
                    ap.yY();
                    Rc = com.tencent.mm.u.c.wR().Rc(a.field_username);
                }
                w.d("MicroMsg.RadarAddContact", "verifyContact return ok");
                o.p(Rc);
                c.by(str, 1);
                z3 = z;
            } else {
                w.d("MicroMsg.RadarAddContact", "verifyContact return not ok");
                z3 = z;
            }
            c cVar = this.oGz;
            long j = this.oGD;
            if (cVar.oGx != null) {
                cVar.handler.post(new AnonymousClass8(cVar, z3, str2, str, j));
            }
        }
    }

    public c(b bVar, Context context) {
        this.context = context;
        this.oGx = bVar;
    }

    public final long De(final String str) {
        boolean z;
        final long currentTimeMillis = System.currentTimeMillis();
        a aVar = new a(this, new c(this) {
            final /* synthetic */ c oGz;

            public final void a(boolean z, boolean z2, String str, String str2) {
                if (z) {
                    ap.yY();
                    com.tencent.mm.j.a Rc = com.tencent.mm.u.c.wR().Rc(str);
                    if (((int) Rc.gTQ) > 0) {
                        o.p(Rc);
                    }
                    c.by(str, 1);
                    if (this.oGz.oGv.contains(str)) {
                        this.oGz.oGv.remove(str);
                    }
                    w.d("MicroMsg.RadarAddContact", "addContact %s return ok", new Object[]{str});
                } else if (z2) {
                    if (!this.oGz.oGv.contains(str)) {
                        this.oGz.oGv.add(str);
                    }
                    c.by(str, 2);
                    w.d("MicroMsg.RadarAddContact", "addContact has sent verify to %s", new Object[]{str});
                } else {
                    w.d("MicroMsg.RadarAddContact", "addContact return not ok, user canceled or error");
                }
                c cVar = this.oGz;
                long j = currentTimeMillis;
                if (cVar.oGx != null) {
                    cVar.handler.post(new AnonymousClass7(cVar, z, z2, str2, str, j));
                }
            }
        });
        List linkedList = new LinkedList();
        linkedList.add(Integer.valueOf(48));
        if (str == null || str.length() <= 0) {
            z = false;
        } else {
            z = true;
        }
        Assert.assertTrue(z);
        Assert.assertTrue(true);
        aVar.onStart();
        aVar.oGJ = linkedList;
        aVar.jia = str;
        aVar.oGI.add(str);
        ap.vd().a(new com.tencent.mm.pluginsdk.model.n(2, aVar.oGI, linkedList, "", ""), 0);
        return currentTimeMillis;
    }

    public final d Df(String str) {
        d dVar = d.Stranger;
        ap.yY();
        af Rc = com.tencent.mm.u.c.wR().Rc(str);
        if (Rc == null || ((int) Rc.gTQ) == 0) {
            if (this.oGv.contains(str)) {
                dVar = d.Verifying;
            } else {
                dVar = d.Stranger;
            }
        } else if (com.tencent.mm.j.a.ez(Rc.field_type)) {
            dVar = d.Added;
        } else if (this.oGw.containsKey(str)) {
            dVar = d.NeedVerify;
        } else if (this.oGv.contains(str)) {
            dVar = d.Verifying;
        } else {
            dVar = d.Stranger;
        }
        w.d("MicroMsg.RadarAddContact", "query username(%s) status %s", new Object[]{str, dVar});
        return dVar;
    }

    public final void H(x xVar) {
        if (this.oGv.contains(xVar.field_username)) {
            this.oGv.remove(xVar.field_username);
        }
        if (this.oGv.contains(xVar.field_encryptUsername)) {
            this.oGv.remove(xVar.field_encryptUsername);
        }
    }

    public static void by(String str, int i) {
        com.tencent.mm.sdk.b.b ffVar = new ff();
        ffVar.fJI.fJK = 0;
        ffVar.fJI.fJL = str;
        ffVar.fJI.state = i;
        com.tencent.mm.sdk.b.a.urY.m(ffVar);
    }

    public static x a(com.tencent.mm.storage.au.d dVar) {
        x xVar = new x();
        if (dVar != null) {
            xVar.setUsername(dVar.rUK);
            xVar.bX(dVar.uKj);
            xVar.bO(dVar.gtR);
            xVar.bR(dVar.fFa);
            xVar.bS(dVar.hCe);
            xVar.bT(dVar.hCf);
            xVar.di(dVar.gkr);
            xVar.ce(dVar.signature);
            xVar.cf(dVar.getProvince());
            xVar.cg(dVar.getCity());
        } else {
            w.e("MicroMsg.RadarAddContact", "verify is null! must be parsed error before!");
        }
        return xVar;
    }

    public final void a(int i, m mVar, Object obj) {
        w.d("MicroMsg.RadarAddContact", "onNotifyChange event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
        if (obj == null || !(obj instanceof String)) {
            w.e("MicroMsg.RadarAddContact", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        String str = (String) obj;
        ap.yY();
        af Rc = com.tencent.mm.u.c.wR().Rc(str);
        if (Rc != null && com.tencent.mm.j.a.ez(Rc.field_type)) {
            w.d("MicroMsg.RadarAddContact", "ContactStg onNotifyChange %s", new Object[]{str});
            I(Rc);
        }
    }

    public final void I(final x xVar) {
        H(xVar);
        this.oGw.remove(xVar.field_username);
        this.oGw.remove(xVar.field_encryptUsername);
        if (this.oGx != null) {
            this.handler.post(new Runnable(this) {
                final /* synthetic */ c oGz;

                public final void run() {
                    this.oGz.oGx.I(xVar);
                }
            });
        }
    }
}
