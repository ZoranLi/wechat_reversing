package com.tencent.mm.plugin.location.model;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.bi;
import com.tencent.mm.e.a.el;
import com.tencent.mm.e.a.ft;
import com.tencent.mm.e.a.hn;
import com.tencent.mm.e.a.ij;
import com.tencent.mm.e.a.ik;
import com.tencent.mm.e.a.nb;
import com.tencent.mm.e.a.qk;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.plugin.location.ui.impl.d;
import com.tencent.mm.protocal.c.awg;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.e;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.y.k;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class l implements am {
    private c nbC = new c();
    private a nbD = new a();
    private b nbE = new b();
    private com.tencent.mm.plugin.location.model.a.a nbF;
    private int nbG = 0;
    private e nbH = new b();
    private e nbI = new n();
    private o nbJ = null;
    private p nbK = null;
    private i nbL = null;
    private m nbM = null;
    private d nbN = new d();
    private k nbO = null;
    private j nbP = null;
    private com.tencent.mm.y.e nbQ = new com.tencent.mm.y.e(this) {
        final /* synthetic */ l nbW;

        {
            this.nbW = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            if (i == 0 && i2 == 0) {
                z zVar = (z) kVar;
                awg Jw = zVar.Jw();
                if (Jw.jOc == 0) {
                    long j = zVar.fGM;
                    String kD = z.kD(Jw.tlo);
                    ap.yY();
                    au cA = com.tencent.mm.u.c.wT().cA(j);
                    if (cA.bMj()) {
                        cA.cJ(kD);
                        ap.yY();
                        com.tencent.mm.u.c.wT().a(j, cA);
                    }
                }
            }
        }
    };
    private com.tencent.mm.sdk.b.c nbR = new com.tencent.mm.sdk.b.c<el>(this) {
        final /* synthetic */ l nbW;

        {
            this.nbW = r2;
            this.usg = el.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            el elVar = (el) bVar;
            w.i("MicroMsg.SubCoreLocation", "exit track trackMgr:%s event:%s", new Object[]{com.tencent.mm.pluginsdk.l.a.sBx.aGl(), elVar.fIn.username});
            l.aGe().stop();
            if (!bg.mA(com.tencent.mm.pluginsdk.l.a.sBy.aGv())) {
                l.aGe().oD(1);
                com.tencent.mm.sdk.b.b qkVar = new qk();
                qkVar.fXu.fXx = true;
                com.tencent.mm.sdk.b.a.urY.m(qkVar);
            }
            if (!bg.mA(elVar.fIn.username)) {
                com.tencent.mm.plugin.location.a.a zr = l.aGf().zr(elVar.fIn.username);
                if (zr != null) {
                    zr.fPA.remove(m.xL());
                    l.aGf().a(elVar.fIn.username, zr.fPA, zr.latitude, zr.longitude, zr.naK, null, null);
                    if (com.tencent.mm.pluginsdk.l.a.sBr != null) {
                        com.tencent.mm.pluginsdk.l.a.sBr.a(elVar.fIn.username, null, null, null, 1);
                    }
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c nbS = new com.tencent.mm.sdk.b.c<nb>(this) {
        final /* synthetic */ l nbW;

        {
            this.nbW = r2;
            this.usg = nb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            nb nbVar = (nb) bVar;
            w.d("MicroMsg.SubCoreLocation", "trackEvent state " + nbVar.fUk.fCp);
            if (nbVar.fUk.fCp) {
                if (l.aGe().aGj() && l.aGe().ncj) {
                    l.aGe().aGk();
                }
            } else if (l.aGe().aGj()) {
                o aGe = l.aGe();
                w.d("MicorMsg.TrackRefreshManager", "pause refresh");
                aGe.ncj = true;
                if (aGe.hvP != null) {
                    aGe.hvP.c(aGe.gKp);
                }
                if (aGe.nca != null) {
                    aGe.nca.b(aGe.ncp);
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c nbT = new com.tencent.mm.sdk.b.c<hn>(this) {
        final /* synthetic */ l nbW;

        {
            this.nbW = r2;
            this.usg = hn.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            hn hnVar = (hn) bVar;
            j aGd = l.aGd();
            ce ceVar = hnVar.fMW.fCZ;
            ImageView imageView = hnVar.fMW.fMY;
            ProgressBar progressBar = hnVar.fMW.fNa;
            ImageView imageView2 = hnVar.fMW.fMZ;
            int i = hnVar.fMW.fNb;
            int i2 = hnVar.fMW.w;
            int i3 = hnVar.fMW.h;
            String str = ceVar.field_content;
            if (!bg.mA(str)) {
                aGd.w = i2;
                aGd.h = i3;
                if (aGd.w <= 0 || aGd.h <= 0) {
                    aGd.w = com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX;
                    aGd.h = com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX;
                }
                boolean z = ceVar.field_isSend == 0;
                if (o.dH(ceVar.field_talker) && z) {
                    int gh = ay.gh(str);
                    if (gh != -1) {
                        str = str.substring(gh + 1).trim();
                    }
                }
                ap.yY();
                com.tencent.mm.storage.au.b Aw = com.tencent.mm.u.c.wT().Aw(str);
                if (ceVar.gxL == 5 || aGd.nbv.contains(Long.valueOf(ceVar.field_msgId))) {
                    w.i("MicroMsg.StaticMapMsgLogic", "this has die %d errCount %d", new Object[]{Long.valueOf(ceVar.field_msgId), Integer.valueOf(ceVar.gxL)});
                    imageView2.setVisibility(0);
                    progressBar.setVisibility(8);
                } else {
                    com.tencent.mm.pluginsdk.location.b bVar2 = new com.tencent.mm.pluginsdk.location.b(ceVar.field_msgId, (float) Aw.naO, (float) Aw.naP, (int) (((double) Aw.fOd) * 1.1d), 0);
                    progressBar.setVisibility(0);
                    imageView2.setVisibility(8);
                    k aGc = l.aGc();
                    aGc.w = i2;
                    aGc.h = i3;
                    if (aGc.w <= 0 || aGc.h <= 0) {
                        aGc.w = com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX;
                        aGc.h = com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX;
                    }
                    String b = k.b(bVar2);
                    if (com.tencent.mm.a.e.aO(b)) {
                        if (!ap.zb()) {
                            b = "";
                        }
                    } else if (aGc.nbx == null || !aGc.nbx.toString().equals(bVar2.toString())) {
                        Iterator it = aGc.nbw.iterator();
                        while (it.hasNext()) {
                            if (bVar2.toString().equals(((com.tencent.mm.pluginsdk.location.b) it.next()).toString())) {
                                w.i("MicroMsg.StaticMapServer", "has add queue");
                                aGc.Gj();
                                b = "";
                                break;
                            }
                        }
                        aGc.nbw.add(bVar2);
                        w.i("MicroMsg.StaticMapServer", "task size %d w%d h %d", new Object[]{Integer.valueOf(aGc.nbw.size()), Integer.valueOf(aGc.w), Integer.valueOf(aGc.h)});
                        aGc.Gj();
                        b = "";
                    } else {
                        w.i("MicroMsg.StaticMapServer", "has add queue");
                        aGc.Gj();
                        b = "";
                    }
                    if (bg.mA(b) || !com.tencent.mm.a.e.aO(b)) {
                        aGd.nbq.put(Long.valueOf(bVar2.sBS), Aw);
                        aGd.nbu.put(Long.valueOf(ceVar.field_msgId), Integer.valueOf(i));
                        aGd.nbt.put(Aw, ceVar);
                        aGd.nbp.put(Long.valueOf(ceVar.field_msgId), new WeakReference(imageView));
                        aGd.nbr.put(Long.valueOf(ceVar.field_msgId), new WeakReference(progressBar));
                        aGd.nbs.put(Long.valueOf(ceVar.field_msgId), new WeakReference(imageView2));
                        aGd.start();
                    } else {
                        w.d("MicroMsg.StaticMapMsgLogic", "readloc from local %d", new Object[]{Integer.valueOf(i)});
                        if (ap.zb()) {
                            Bitmap a = n.GS().a(ceVar.field_msgId, b, i, aGd.w, aGd.h, z);
                            if (!(a == null || a.isRecycled())) {
                                imageView.setImageBitmap(a);
                                progressBar.setVisibility(8);
                                imageView2.setVisibility(0);
                            }
                        }
                    }
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c nbU = new com.tencent.mm.sdk.b.c<bi>(this) {
        final /* synthetic */ l nbW;

        {
            this.nbW = r2;
            this.usg = bi.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            com.tencent.mm.pluginsdk.location.a aGd = l.aGd();
            w.i("MicroMsg.StaticMapMsgLogic", "clean task");
            aGd.nbp.clear();
            aGd.nbt.clear();
            aGd.nbu.clear();
            aGd.nbr.clear();
            aGd.nbs.clear();
            aGd.nbv.clear();
            aGd.nbq.clear();
            l.aGc().a(aGd);
            l.aGc().a(aGd);
            return false;
        }
    };
    private com.tencent.mm.u.bp.a nbV = new com.tencent.mm.u.bp.a(this) {
        final /* synthetic */ l nbW;

        {
            this.nbW = r1;
        }

        public final void a(com.tencent.mm.y.d.a aVar) {
            new n().b(aVar);
        }
    };

    private static final class a extends com.tencent.mm.sdk.b.c<ft> {
        private a() {
            this.usg = ft.class.getName().hashCode();
        }

        /* synthetic */ a(byte b) {
            this();
            this.usg = ft.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ft ftVar = (ft) bVar;
            if (!(ftVar instanceof ft)) {
                return false;
            }
            l.J(ftVar.fKO.fCZ);
            return true;
        }
    }

    private static final class b extends com.tencent.mm.sdk.b.c<ij> {
        private b() {
            this.usg = ij.class.getName().hashCode();
        }

        /* synthetic */ b(byte b) {
            this();
            this.usg = ij.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ij ijVar = (ij) bVar;
            if (!(ijVar instanceof ij)) {
                return false;
            }
            w.d("MicroMsg.SubCoreLocation", "e.data.eventType : " + ijVar.fNX.fNZ);
            switch (ijVar.fNX.fNZ) {
                case 0:
                    ijVar.fNY.path = e.a(ijVar.fNX.fOa, ijVar.fNX.filename, ijVar.fNX.view);
                    break;
                case 1:
                    com.tencent.mm.pluginsdk.location.b bVar2 = new com.tencent.mm.pluginsdk.location.b(-1, ijVar.fNX.fOb, ijVar.fNX.fOc, ijVar.fNX.fOd, 1);
                    ijVar.fNY.path = k.b(bVar2);
                    break;
                case 2:
                    ap.vd().a(new g(ijVar.fNX.fOb, ijVar.fNX.fOc, ijVar.fNX.fOd, ijVar.fNX.width, ijVar.fNX.height, ijVar.fNX.filename, v.bIN()), 0);
                    break;
                case 3:
                    g gVar = (g) ijVar.fNX.fGg;
                    ijVar.fNY.path = gVar.nbc;
                    break;
            }
            return true;
        }
    }

    private static final class c extends com.tencent.mm.sdk.b.c<ik> {
        private volatile boolean Ps;

        private c() {
            this.Ps = false;
            this.usg = ik.class.getName().hashCode();
        }

        /* synthetic */ c(byte b) {
            this();
            this.usg = ik.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ik ikVar = (ik) bVar;
            if (!(ikVar instanceof ik)) {
                return false;
            }
            w.d("MicroMsg.SubCoreLocation", "e.data.eventType : " + ikVar.fOe.fNZ);
            switch (ikVar.fOe.fNZ) {
                case 0:
                    l.aGb().naU = new HashSet();
                    this.Ps = true;
                    return true;
                case 1:
                    if (this.Ps) {
                        String[] I = l.aGb().I(ikVar.fOe.fCZ);
                        ikVar.fOf.fOh = I[0];
                        ikVar.fOf.fOi = I[1];
                        return true;
                    }
                    ikVar.fOf.fOh = "err_not_started";
                    return true;
                case 2:
                    if (!this.Ps) {
                        return true;
                    }
                    l.aGb().aFW();
                    return true;
                default:
                    return true;
            }
        }
    }

    private static l aGa() {
        l lVar = (l) ap.yR().gs("plugin.location");
        if (lVar != null) {
            return lVar;
        }
        Object lVar2 = new l();
        ap.yR().a("plugin.location", lVar2);
        return lVar2;
    }

    public static com.tencent.mm.plugin.location.model.a.a aGb() {
        h.vG().uQ();
        if (aGa().nbF == null) {
            aGa().nbF = new com.tencent.mm.plugin.location.model.a.a();
        }
        return aGa().nbF;
    }

    public static k aGc() {
        h.vG().uQ();
        if (aGa().nbO == null) {
            aGa().nbO = new k();
        }
        return aGa().nbO;
    }

    public static j aGd() {
        h.vG().uQ();
        if (aGa().nbP == null) {
            aGa().nbP = new j();
        }
        return aGa().nbP;
    }

    public static o aGe() {
        if (aGa().nbJ == null) {
            aGa().nbJ = new o();
        }
        return aGa().nbJ;
    }

    public static p aGf() {
        if (aGa().nbK == null) {
            aGa().nbK = new p();
        }
        return aGa().nbK;
    }

    public static i aGg() {
        if (aGa().nbL == null) {
            aGa().nbL = new i();
        }
        return aGa().nbL;
    }

    public static m aGh() {
        if (aGa().nbM == null) {
            aGa().nbM = new m();
        }
        return aGa().nbM;
    }

    public static void J(au auVar) {
        if (auVar != null && auVar.field_msgId != 0) {
            com.tencent.mm.storage.au.b RG = com.tencent.mm.storage.au.b.RG(auVar.field_content);
            ap.vd().a(new z((float) RG.naP, (float) RG.naO, auVar.field_msgId), 0);
        }
    }

    public static String aGi() {
        StringBuilder stringBuilder = new StringBuilder();
        ap.yY();
        return stringBuilder.append(com.tencent.mm.u.c.xu()).append("trackroom/").toString();
    }

    public final HashMap<Integer, com.tencent.mm.bj.g.c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        com.tencent.mm.y.d.c.a(Integer.valueOf(48), this.nbH);
        com.tencent.mm.y.d.c.a(Integer.valueOf(61), this.nbI);
        ap.getSysCmdMsgExtension().a("trackmsg", this.nbV, true);
        ap.vd().a(424, this.nbQ);
        com.tencent.mm.sdk.b.a.urY.b(this.nbC);
        com.tencent.mm.sdk.b.a.urY.b(this.nbD);
        com.tencent.mm.sdk.b.a.urY.b(this.nbR);
        com.tencent.mm.sdk.b.a.urY.b(this.nbS);
        com.tencent.mm.sdk.b.a.urY.b(this.nbT);
        com.tencent.mm.sdk.b.a.urY.b(this.nbU);
        com.tencent.mm.sdk.b.a.urY.b(this.nbE);
        com.tencent.mm.pluginsdk.l.a.sBx = aGe();
        com.tencent.mm.pluginsdk.l.a.sBy = aGf();
        com.tencent.mm.be.a.a.a.upb = aGh();
        h.vG().uQ();
        if (aGa().nbN == null) {
            aGa().nbN = new d();
        }
        com.tencent.mm.plugin.p.c.a.nja = aGa().nbN;
    }

    public final void onAccountRelease() {
        if (this.nbJ != null) {
            this.nbJ.nck = null;
            this.nbJ.stop();
            this.nbJ.oD(1);
        }
        com.tencent.mm.y.d.c.aA(Integer.valueOf(48));
        com.tencent.mm.y.d.c.aA(Integer.valueOf(61));
        ap.getSysCmdMsgExtension().b("trackmsg", this.nbV, true);
        ap.vd().b(424, this.nbQ);
        com.tencent.mm.sdk.b.a.urY.c(this.nbC);
        com.tencent.mm.sdk.b.a.urY.c(this.nbD);
        com.tencent.mm.sdk.b.a.urY.c(this.nbR);
        com.tencent.mm.sdk.b.a.urY.c(this.nbS);
        com.tencent.mm.sdk.b.a.urY.c(this.nbT);
        com.tencent.mm.sdk.b.a.urY.c(this.nbU);
        com.tencent.mm.sdk.b.a.urY.c(this.nbE);
        if (this.nbL != null) {
            i iVar = this.nbL;
            iVar.aFZ();
            iVar.iSM.clear();
        }
        if (this.nbO != null) {
            this.nbO.stop();
        }
        if (this.nbP != null) {
            aGc().a(this.nbP);
        }
    }

    public final void aN(boolean z) {
    }
}
