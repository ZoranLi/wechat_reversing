package com.tencent.mm.plugin.appbrand.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.e.a.ad;
import com.tencent.mm.e.a.ae;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.e.a.fr;
import com.tencent.mm.e.a.if;
import com.tencent.mm.e.a.im;
import com.tencent.mm.e.a.ix;
import com.tencent.mm.e.a.ls;
import com.tencent.mm.e.a.n;
import com.tencent.mm.e.a.r;
import com.tencent.mm.e.a.ri;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.g.a;
import com.tencent.mm.plugin.appbrand.appcache.m;
import com.tencent.mm.plugin.appbrand.appstorage.b;
import com.tencent.mm.plugin.appbrand.b.f;
import com.tencent.mm.plugin.appbrand.b.j;
import com.tencent.mm.plugin.appbrand.b.k;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.o;
import com.tencent.mm.plugin.appbrand.config.p;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.s;
import com.tencent.mm.plugin.appbrand.dynamic.i.e;
import com.tencent.mm.plugin.appbrand.dynamic.i.i;
import com.tencent.mm.plugin.appbrand.launching.g;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public final class c implements am {
    private static volatile b ixM;
    private static volatile com.tencent.mm.plugin.appbrand.config.c ixN;
    private static volatile m ixO;
    private static volatile j ixP;
    private static volatile f ixQ;
    private static volatile o ixR;
    private static volatile g ixS;
    private static volatile com.tencent.mm.plugin.appbrand.dynamic.i.b ixT;
    private static volatile e ixU;
    private static volatile a ixV;
    private static volatile i ixW;
    private static volatile com.tencent.mm.plugin.appbrand.k.a ixX;
    private static com.tencent.mm.plugin.appbrand.jsapi.map.a ixY;
    private static com.tencent.mm.plugin.appbrand.c.c ixZ;
    private static com.tencent.mm.plugin.appbrand.c.b iya;
    private com.tencent.mm.sdk.e.j.a hoU = new com.tencent.mm.sdk.e.j.a(this) {
        final /* synthetic */ c iyy;

        {
            this.iyy = r1;
        }

        public final void a(String str, l lVar) {
            if (str != null && str.length() > 0 && "event_updated".equals(str)) {
                c.Qe();
            }
        }
    };
    private com.tencent.mm.network.m hyk = new com.tencent.mm.network.m.a(this) {
        final /* synthetic */ c iyy;

        {
            this.iyy = r1;
        }

        public final void cU(int i) {
            com.tencent.mm.plugin.appbrand.task.b.onNetworkChange();
        }
    };
    private as.a iyb = new com.tencent.mm.plugin.appbrand.j.a();
    private com.tencent.mm.vending.b.b iyc = null;
    private final com.tencent.mm.plugin.auth.a.a iyd = new com.tencent.mm.plugin.auth.a.a(this) {
        final /* synthetic */ c iyy;

        {
            this.iyy = r1;
        }

        public final void a(com.tencent.mm.protocal.i.f fVar, com.tencent.mm.protocal.i.g gVar, boolean z) {
            if (gVar != null && (gVar instanceof com.tencent.mm.protocal.i.e)) {
                d.vL().D(new Runnable(com.tencent.mm.plugin.appbrand.b.b.QQ()) {
                    final /* synthetic */ b iBw;

                    {
                        this.iBw = r1;
                    }

                    public final void run() {
                        this.iBw.a(1, 7, 0, true);
                    }
                });
            }
            k.hC(k.a.iCA);
        }

        public final void a(y.b bVar, String str, int i, String str2, String str3, int i2) {
        }
    };
    private final Set<com.tencent.mm.sdk.b.c> iye = new HashSet();
    private final com.tencent.mm.sdk.b.c<im> iyf = new com.tencent.mm.sdk.b.c<im>(this) {
        final /* synthetic */ c iyy;

        {
            this.iyy = r2;
            this.usg = im.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            switch (((im) bVar).fOk.fOl) {
                case 1:
                case 3:
                    com.tencent.mm.plugin.appbrand.task.b.ir(1);
                    break;
                default:
                    com.tencent.mm.plugin.appbrand.task.b.ir(0);
                    break;
            }
            com.tencent.mm.plugin.appbrand.dynamic.performance.b.Sl();
            return true;
        }
    };
    private final com.tencent.mm.sdk.b.c<ri> iyg = new com.tencent.mm.sdk.b.c<ri>(this) {
        final /* synthetic */ c iyy;

        {
            this.iyy = r2;
            this.usg = ri.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            boolean z = true;
            ri riVar = (ri) bVar;
            if (!bg.mA(riVar.fYq.fCJ)) {
                p.RG();
                String str = riVar.fYq.fCJ;
                int i = riVar.fYq.fYs;
                if (riVar.fYq.action != 1) {
                    z = false;
                }
                riVar.fYr.fYt = p.i(str, i, z);
            }
            return false;
        }
    };
    private final com.tencent.mm.sdk.b.c<r> iyh = new com.tencent.mm.sdk.b.c<r>(this) {
        final /* synthetic */ c iyy;

        {
            this.iyy = r2;
            this.usg = r.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            r rVar = (r) bVar;
            if (!bg.mA(rVar.fCU.fCJ)) {
                q.G(rVar.fCU.fCJ, false);
            }
            return true;
        }
    };
    private final com.tencent.mm.sdk.b.c<ix> iyi = new com.tencent.mm.sdk.b.c<ix>(this) {
        final /* synthetic */ c iyy;

        {
            this.iyy = r2;
            this.usg = ix.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            af afVar = ((ix) bVar).fOJ.fOK;
            if (x.em(afVar.field_username)) {
                afVar.setType(0);
                q.G(afVar.field_username, false);
            }
            return false;
        }
    };
    private final com.tencent.mm.sdk.b.c<ls> iyj = new com.tencent.mm.sdk.b.c<ls>(this) {
        final /* synthetic */ c iyy;

        {
            this.iyy = r2;
            this.usg = ls.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ce ceVar = ((ls) bVar).fSR.fCZ;
            if (ceVar != null) {
                String str = ceVar.field_talker;
                if (x.em(str)) {
                    c.PV().aL(str + "_unreadCount", String.valueOf(bg.getInt(c.PV().get(str + "_unreadCount", "0"), 0) + 1));
                    ap.yY();
                    aj Rm = com.tencent.mm.u.c.wW().Rm(str);
                    com.tencent.mm.plugin.appbrand.ipc.d.ac(p.on(str), Rm != null ? Rm.field_unReadCount : 0);
                }
            }
            return false;
        }
    };
    private final com.tencent.mm.sdk.b.c<n> iyk = new com.tencent.mm.sdk.b.c<n>(this) {
        final /* synthetic */ c iyy;

        {
            this.iyy = r2;
            this.usg = n.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            n nVar = (n) bVar;
            if (!bg.mA(nVar.fCH.fCJ)) {
                nVar.fCI.fCK = bg.getInt(c.PV().get(nVar.fCH.fCJ + "_unreadCount", "0"), 0);
            }
            return false;
        }
    };
    private final com.tencent.mm.sdk.b.c<com.tencent.mm.e.a.q> iyl = new com.tencent.mm.sdk.b.c<com.tencent.mm.e.a.q>(this) {
        final /* synthetic */ c iyy;

        {
            this.iyy = r2;
            this.usg = com.tencent.mm.e.a.q.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            com.tencent.mm.e.a.q qVar = (com.tencent.mm.e.a.q) bVar;
            if (!bg.mA(qVar.fCT.fCJ)) {
                String str = qVar.fCT.fCJ;
                c.PV().aL(str + "_unreadCount", qVar.fCT.fCK);
                com.tencent.mm.plugin.appbrand.ipc.d.ac(p.on(str), qVar.fCT.fCK);
            }
            return false;
        }
    };
    private final com.tencent.mm.sdk.b.c<com.tencent.mm.e.a.p> iym = new com.tencent.mm.sdk.b.c<com.tencent.mm.e.a.p>(this) {
        final /* synthetic */ c iyy;

        {
            this.iyy = r2;
            this.usg = com.tencent.mm.e.a.p.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            boolean eE = c.PV().iAL.eE("AppBrandCommonKVData", "update AppBrandCommonKVData set value = '0' where key like '%_unreadCount'");
            w.i("MicroMsg.AppBrandCommonKVDataStorage", "sql:%s, updateRet : %b", new Object[]{"update AppBrandCommonKVData set value = '0' where key like '%_unreadCount'", Boolean.valueOf(eE)});
            return true;
        }
    };
    private final com.tencent.mm.sdk.b.c<com.tencent.mm.e.a.l> iyn = new com.tencent.mm.sdk.b.c<com.tencent.mm.e.a.l>(this) {
        final /* synthetic */ c iyy;

        {
            this.iyy = r2;
            this.usg = com.tencent.mm.e.a.l.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            if (!((com.tencent.mm.e.a.l) bVar).fCE.fCF) {
                com.tencent.mm.plugin.appbrand.appcache.d.bF(false);
                d.vL().D(new Runnable(com.tencent.mm.plugin.appbrand.b.b.QQ()) {
                    final /* synthetic */ b iBw;

                    {
                        this.iBw = r1;
                    }

                    public final void run() {
                        if (h.vG().uV() && !a.QP()) {
                            this.iBw.a(2, ((g.Ri() ? 2 : 0) | 1) | 4, 0, true);
                        }
                    }
                });
            }
            return false;
        }
    };
    private final com.tencent.mm.sdk.b.c<com.tencent.mm.e.a.o> iyo = new com.tencent.mm.sdk.b.c<com.tencent.mm.e.a.o>(this) {
        final /* synthetic */ c iyy;

        {
            this.iyy = r2;
            this.usg = com.tencent.mm.e.a.o.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            com.tencent.mm.e.a.o oVar = (com.tencent.mm.e.a.o) bVar;
            com.tencent.mm.plugin.appbrand.report.a.a(oVar.fCL.fCJ, oVar.fCL.appId, oVar.fCL.fCM, oVar.fCL.scene, oVar.fCL.fCN, oVar.fCL.fCO, oVar.fCL.action, oVar.fCL.fCP, oVar.fCL.fCQ, oVar.fCL.fCR, oVar.fCL.fCS);
            return true;
        }
    };
    private final com.tencent.mm.sdk.b.c<com.tencent.mm.e.a.m> iyp = new com.tencent.mm.sdk.b.c<com.tencent.mm.e.a.m>(this) {
        final /* synthetic */ c iyy;

        {
            this.iyy = r2;
            this.usg = com.tencent.mm.e.a.m.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            q.G(((com.tencent.mm.e.a.m) bVar).fCG.username, true);
            return true;
        }
    };
    private final com.tencent.mm.sdk.b.c<bp> iyq = new com.tencent.mm.sdk.b.c<bp>(this) {
        final /* synthetic */ c iyy;

        {
            this.iyy = r2;
            this.usg = bp.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            bp bpVar = (bp) bVar;
            if (!bg.mA(bpVar.fEY.username)) {
                bpVar.fEZ.fFb = p.om(bpVar.fEY.username);
                if (bpVar.fEZ.fFb != null) {
                    s oj = p.oj(bpVar.fEY.username);
                    bpVar.fEZ.appId = oj.appId;
                    bpVar.fEZ.fFa = oj.fFa;
                }
            }
            return true;
        }
    };
    private final com.tencent.mm.sdk.b.c<if> iyr = new com.tencent.mm.sdk.b.c<if>(this) {
        final /* synthetic */ c iyy;

        {
            this.iyy = r2;
            this.usg = if.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppBrandStickyBannerLogic.b.t(((if) bVar).fNN.fNO);
            return true;
        }
    };
    private final com.tencent.mm.u.bp.a iys = new com.tencent.mm.plugin.appbrand.appcache.k();
    private com.tencent.mm.sdk.b.c iyt = new com.tencent.mm.sdk.b.c<com.tencent.mm.e.a.e>(this) {
        final /* synthetic */ c iyy;

        {
            this.iyy = r2;
            this.usg = com.tencent.mm.e.a.e.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            com.tencent.mm.plugin.appbrand.task.b.WG();
            return true;
        }
    };
    private com.tencent.mm.sdk.b.c iyu = new com.tencent.mm.sdk.b.c<ad>(this) {
        final /* synthetic */ c iyy;

        {
            this.iyy = r2;
            this.usg = ad.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            com.tencent.mm.sdk.b.b aeVar = new ae();
            aeVar.fDk.fDm = com.tencent.mm.plugin.appbrand.ui.banner.b.bC(ab.getContext());
            com.tencent.mm.sdk.b.a.urY.m(aeVar);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c iyv = new com.tencent.mm.sdk.b.c<fr>(this) {
        final /* synthetic */ c iyy;

        {
            this.iyy = r2;
            this.usg = fr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            fr frVar = (fr) bVar;
            w.i("MicroMsg.SubCoreAppBrand", "FetchAppBrandInfoForMusicEvent callback");
            frVar.fKJ.appId = a.iwi.iwg;
            frVar.fKJ.fKK = a.iwi.fKK;
            frVar.fKJ.fGs = a.iwi.fGs;
            frVar.fKJ.fKL = a.iwi.fKL;
            return true;
        }
    };
    private com.tencent.mm.sdk.b.c iyw = new com.tencent.mm.sdk.b.c<com.tencent.mm.e.a.e>(this) {
        final /* synthetic */ c iyy;

        {
            this.iyy = r2;
            this.usg = com.tencent.mm.e.a.e.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            if (!((com.tencent.mm.e.a.e) bVar).fCm.fCn) {
                ((com.tencent.mm.modelappbrand.e) h.h(com.tencent.mm.modelappbrand.e.class)).AM().exit();
            }
            return false;
        }
    };
    private final AppBrandGuideUI.a iyx = new AppBrandGuideUI.a();

    public static c PN() {
        c cVar = (c) ap.yR().gs("plugin.appbrand");
        if (cVar != null) {
            return cVar;
        }
        com.tencent.mm.modelappbrand.g gVar = (com.tencent.mm.modelappbrand.g) h.j(com.tencent.mm.modelappbrand.g.class);
        if (gVar != null) {
            return ((PluginAppBrand) gVar).getCore();
        }
        return cVar;
    }

    public final a PO() {
        StringBuilder stringBuilder = new StringBuilder();
        ap.yY();
        String stringBuilder2 = stringBuilder.append(com.tencent.mm.u.c.xu()).append("AppBrandComm.db").toString();
        if (ixV != null && stringBuilder2.equals(ixV.getPath())) {
            return ixV;
        }
        int hashCode = hashCode();
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf("AppKVStorageDBCreate".hashCode()), new com.tencent.mm.bj.g.c(this) {
            final /* synthetic */ c iyy;

            {
                this.iyy = r1;
            }

            public final String[] pP() {
                return b.gUx;
            }
        });
        hashMap.put(Integer.valueOf("AppBrandWxaPkgStorageDBCreate".hashCode()), new com.tencent.mm.bj.g.c(this) {
            final /* synthetic */ c iyy;

            {
                this.iyy = r1;
            }

            public final String[] pP() {
                return m.izG;
            }
        });
        hashMap.put(Integer.valueOf("AppBrandCommonConfigStorageCreate".hashCode()), new com.tencent.mm.bj.g.c(this) {
            final /* synthetic */ c iyy;

            {
                this.iyy = r1;
            }

            public final String[] pP() {
                return com.tencent.mm.plugin.appbrand.config.c.iCe;
            }
        });
        hashMap.put(Integer.valueOf("AppBrandLayoutStorageCreate".hashCode()), new com.tencent.mm.bj.g.c(this) {
            final /* synthetic */ c iyy;

            {
                this.iyy = r1;
            }

            public final String[] pP() {
                return j.iCe;
            }
        });
        hashMap.put(Integer.valueOf("AppBrandStarAppStorageCreate".hashCode()), new com.tencent.mm.bj.g.c(this) {
            final /* synthetic */ c iyy;

            {
                this.iyy = r1;
            }

            public final String[] pP() {
                return f.iCe;
            }
        });
        hashMap.put(Integer.valueOf("WxaAttributesTableCreate".hashCode()), new com.tencent.mm.bj.g.c(this) {
            final /* synthetic */ c iyy;

            {
                this.iyy = r1;
            }

            public final String[] pP() {
                return new String[]{WxaAttributes.iFy};
            }
        });
        hashMap.put(Integer.valueOf("LaunchWxaAppInfoCreate".hashCode()), new com.tencent.mm.bj.g.c(this) {
            final /* synthetic */ c iyy;

            {
                this.iyy = r1;
            }

            public final String[] pP() {
                return new String[]{g.iFy};
            }
        });
        hashMap.put(Integer.valueOf("DynamicMsgCacheDataCreate".hashCode()), new com.tencent.mm.bj.g.c(this) {
            final /* synthetic */ c iyy;

            {
                this.iyy = r1;
            }

            public final String[] pP() {
                return com.tencent.mm.plugin.appbrand.dynamic.i.b.iCe;
            }
        });
        hashMap.put(Integer.valueOf("LaunchWxaWidgetCacheCreate".hashCode()), new com.tencent.mm.bj.g.c(this) {
            final /* synthetic */ c iyy;

            {
                this.iyy = r1;
            }

            public final String[] pP() {
                return new String[]{e.iFy};
            }
        });
        hashMap.put(Integer.valueOf("WxaWidgetInfoStorageCreate".hashCode()), new com.tencent.mm.bj.g.c(this) {
            final /* synthetic */ c iyy;

            {
                this.iyy = r1;
            }

            public final String[] pP() {
                return i.iCe;
            }
        });
        hashMap.put(Integer.valueOf("AppBrandCommonKVBinaryDataStorage".hashCode()), new com.tencent.mm.bj.g.c(this) {
            final /* synthetic */ c iyy;

            {
                this.iyy = r1;
            }

            public final String[] pP() {
                return com.tencent.mm.plugin.appbrand.k.a.iCe;
            }
        });
        a a = com.tencent.mm.platformtools.g.a(hashCode, stringBuilder2, hashMap, true);
        ixV = a;
        return a;
    }

    public final HashMap<Integer, com.tencent.mm.bj.g.c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        w.d("MicroMsg.SubCoreAppBrand", "onAccountPostReset updated %b", new Object[]{Boolean.valueOf(z)});
        this.iyc = ((com.tencent.mm.plugin.auth.a.b) h.j(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(this.iyd);
        SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("app_brand_global_sp", 0);
        if (sharedPreferences != null) {
            Set stringSet = sharedPreferences.getStringSet("uin_set", new HashSet());
            if (stringSet != null) {
                StringBuilder stringBuilder = new StringBuilder();
                ap.yY();
                if (stringSet.add(stringBuilder.append(com.tencent.mm.u.c.uH()).toString())) {
                    Editor edit = sharedPreferences.edit();
                    edit.remove("uin_set");
                    edit.commit();
                    edit.putStringSet("uin_set", stringSet);
                    edit.commit();
                }
            }
        }
        for (com.tencent.mm.sdk.b.c bIy : this.iye) {
            bIy.bIy();
        }
        for (String a : com.tencent.mm.plugin.appbrand.appcache.k.izr.keySet()) {
            ap.getSysCmdMsgExtension().a(a, this.iys, true);
        }
        com.tencent.mm.plugin.appbrand.b.d.b.Rg();
        com.tencent.mm.plugin.appbrand.b.i.a.Rg();
        ap.yY();
        com.tencent.mm.u.c.wW().b(this.iyb);
        PO();
        ixM = new b(ixV);
        ixN = new com.tencent.mm.plugin.appbrand.config.c(ixV);
        ixO = new m(ixV);
        ixP = new j(ixV);
        ixQ = new f(ixV);
        ixS = new g(ixV);
        ixT = new com.tencent.mm.plugin.appbrand.dynamic.i.b(ixV);
        ixU = new e(ixV);
        ixW = new i(ixV);
        ixX = new com.tencent.mm.plugin.appbrand.k.a(ixV);
        PR();
        com.tencent.mm.plugin.appbrand.g.setup();
        p.RG();
        com.tencent.mm.plugin.appbrand.h.c.Wz().prepare();
        com.tencent.mm.plugin.appbrand.appcache.d.bF(true);
        if (((com.tencent.mm.plugin.fts.a.l) h.j(com.tencent.mm.plugin.fts.a.l.class)).isFTSContextReady()) {
            w.i("MicroMsg.FTS.WeApp", "register in search thread");
            ((com.tencent.mm.plugin.fts.a.l) h.j(com.tencent.mm.plugin.fts.a.l.class)).getFTSTaskDaemon().a(-131070, new com.tencent.mm.plugin.fts.a.a.a(this) {
                final /* synthetic */ c iyy;

                {
                    this.iyy = r1;
                }

                public final boolean execute() {
                    c.bE(true);
                    return true;
                }

                public final String getName() {
                    return "InitWeAppSearchTask";
                }
            });
        } else {
            w.i("MicroMsg.FTS.WeApp", "register in weapp thread");
            bE(false);
        }
        ap.a(this.hyk);
        com.tencent.mm.plugin.appbrand.dynamic.f.initialize();
        com.tencent.mm.plugin.appbrand.task.b.WG();
        com.tencent.mm.u.c.c.Az().c(this.hoU);
        com.tencent.mm.plugin.appbrand.launching.a.init();
        com.tencent.mm.plugin.appbrand.ui.banner.c cVar = this.iyx;
        AppBrandGuideUI.a.WL().registerActivityLifecycleCallbacks(cVar);
        AppBrandStickyBannerLogic.b.b(cVar);
        cVar.jin = false;
    }

    public static void bE(boolean z) {
        com.tencent.mm.plugin.fts.a.g cVar = new com.tencent.mm.plugin.appbrand.d.c();
        ((com.tencent.mm.plugin.fts.a.l) h.j(com.tencent.mm.plugin.fts.a.l.class)).registerIndexStorage(cVar);
        if (z) {
            cVar.create();
        }
        com.tencent.mm.plugin.fts.a.i bVar = new com.tencent.mm.plugin.appbrand.d.b();
        ((com.tencent.mm.plugin.fts.a.l) h.j(com.tencent.mm.plugin.fts.a.l.class)).registerNativeLogic(7, bVar);
        if (z) {
            bVar.create();
        }
        com.tencent.mm.plugin.fts.d.h.a(new com.tencent.mm.plugin.appbrand.d.g());
        com.tencent.mm.plugin.fts.d.h.a(new com.tencent.mm.plugin.appbrand.d.e());
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
        w.d("MicroMsg.SubCoreAppBrand", "onAccountRelease");
        if (this.iyc != null) {
            this.iyc.dead();
            this.iyc = null;
        }
        for (com.tencent.mm.sdk.b.c dead : this.iye) {
            dead.dead();
        }
        com.tencent.mm.plugin.appbrand.g.release();
        for (String b : com.tencent.mm.plugin.appbrand.appcache.k.izr.keySet()) {
            ap.getSysCmdMsgExtension().b(b, this.iys, true);
        }
        com.tencent.mm.plugin.appbrand.b.d.b.unregister();
        com.tencent.mm.plugin.appbrand.b.i.a.unregister();
        ap.yY();
        com.tencent.mm.u.c.wW().c(this.iyb);
        com.tencent.mm.plugin.appbrand.appcache.n.shutdown();
        ixM = null;
        ixR = null;
        ixN = null;
        ixO = null;
        ixP = null;
        ixQ = null;
        ixS = null;
        ixT = null;
        ixU = null;
        ixW = null;
        ixX = null;
        if (iya != null) {
            com.tencent.mm.plugin.appbrand.c.b bVar = iya;
            bVar.iDG.clear();
            bVar.iDH.clear();
            iya = null;
        }
        ixZ = null;
        if (ixV != null) {
            ixV.ha(hashCode());
            ixV = null;
        }
        com.tencent.mm.plugin.appbrand.launching.d.UU();
        com.tencent.mm.plugin.appbrand.b.b.release();
        p.release();
        com.tencent.mm.plugin.appbrand.h.c Wz = com.tencent.mm.plugin.appbrand.h.c.Wz();
        w.d("MicroMsg.WxaFTSSearchCore", "reset");
        com.tencent.mm.sdk.b.a.urY.c(Wz.jgW);
        com.tencent.mm.sdk.b.a.urY.c(Wz.jgX);
        com.tencent.mm.sdk.b.a.urY.c(Wz.jgY);
        d.XI();
        ((com.tencent.mm.plugin.fts.a.l) h.j(com.tencent.mm.plugin.fts.a.l.class)).unregisterIndexStorage(512);
        ((com.tencent.mm.plugin.fts.a.l) h.j(com.tencent.mm.plugin.fts.a.l.class)).unregisterNativeLogic(7);
        com.tencent.mm.plugin.fts.d.h.mV(com.tencent.mm.plugin.appbrand.jsapi.map.f.CTRL_INDEX);
        com.tencent.mm.plugin.fts.d.h.mV(4208);
        ap.b(this.hyk);
        com.tencent.mm.plugin.appbrand.dynamic.f.release();
        com.tencent.mm.u.c.c.Az().f(this.hoU);
        com.tencent.mm.plugin.appbrand.launching.a.release();
        AppBrandGuideUI.a aVar = this.iyx;
        AppBrandGuideUI.a.WL().unregisterActivityLifecycleCallbacks(aVar);
        AppBrandStickyBannerLogic.b.a(aVar);
        aVar.jin = false;
    }

    public c() {
        this.iye.add(this.iyn);
        this.iye.add(new com.tencent.mm.plugin.appbrand.launching.b());
        this.iye.add(this.iyo);
        this.iye.add(this.iyh);
        this.iye.add(this.iyi);
        this.iye.add(this.iyj);
        this.iye.add(this.iyg);
        this.iye.add(new com.tencent.mm.plugin.appbrand.config.d());
        this.iye.add(this.iyf);
        this.iye.add(com.tencent.mm.plugin.appbrand.b.a.iBs);
        this.iye.add(this.iyk);
        this.iye.add(this.iyl);
        this.iye.add(this.iym);
        this.iye.add(this.iyp);
        this.iye.add(this.iyt);
        this.iye.add(this.iyq);
        this.iye.add(this.iyu);
        this.iye.add(this.iyr);
        this.iye.add(this.iyv);
        this.iye.add(this.iyw);
    }

    public static AppBrandGuideUI.a PP() {
        return PN() == null ? null : PN().iyx;
    }

    public static b PQ() {
        return ixM;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.plugin.appbrand.config.o PR() {
        /*
        r1 = com.tencent.mm.plugin.appbrand.app.c.class;
        monitor-enter(r1);
        r0 = ixR;	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x0018;
    L_0x0007:
        r0 = ixR;	 Catch:{ all -> 0x0033 }
        r2 = r0.hnH;	 Catch:{ all -> 0x0033 }
        if (r2 == 0) goto L_0x0031;
    L_0x000d:
        r0 = r0.hnH;	 Catch:{ all -> 0x0033 }
        r0 = r0.bKn();	 Catch:{ all -> 0x0033 }
        if (r0 != 0) goto L_0x0031;
    L_0x0015:
        r0 = 1;
    L_0x0016:
        if (r0 != 0) goto L_0x002d;
    L_0x0018:
        r0 = ixV;	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x002d;
    L_0x001c:
        r0 = ixV;	 Catch:{ all -> 0x0033 }
        r0 = r0.bKn();	 Catch:{ all -> 0x0033 }
        if (r0 != 0) goto L_0x002d;
    L_0x0024:
        r0 = new com.tencent.mm.plugin.appbrand.config.o;	 Catch:{ all -> 0x0033 }
        r2 = ixV;	 Catch:{ all -> 0x0033 }
        r0.<init>(r2);	 Catch:{ all -> 0x0033 }
        ixR = r0;	 Catch:{ all -> 0x0033 }
    L_0x002d:
        monitor-exit(r1);	 Catch:{ all -> 0x0033 }
        r0 = ixR;
        return r0;
    L_0x0031:
        r0 = 0;
        goto L_0x0016;
    L_0x0033:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0033 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.app.c.PR():com.tencent.mm.plugin.appbrand.config.o");
    }

    public static g PS() {
        return ixS;
    }

    public static e PT() {
        return ixU;
    }

    public static i PU() {
        return ixW;
    }

    public static com.tencent.mm.plugin.appbrand.config.c PV() {
        if (!(ixN != null || ixV == null || ixV.bKn())) {
            ixN = new com.tencent.mm.plugin.appbrand.config.c(ixV);
        }
        return ixN;
    }

    public static j PW() {
        return ixP;
    }

    public static f PX() {
        return ixQ;
    }

    public static m PY() {
        return ixO;
    }

    public static com.tencent.mm.plugin.appbrand.dynamic.i.b PZ() {
        return ixT;
    }

    public static com.tencent.mm.plugin.appbrand.jsapi.map.a Qa() {
        if (ixY == null) {
            ixY = new com.tencent.mm.plugin.appbrand.jsapi.map.a();
        }
        return ixY;
    }

    public static com.tencent.mm.plugin.appbrand.c.c Qb() {
        if (ixZ == null) {
            ixZ = new com.tencent.mm.plugin.appbrand.c.c();
        }
        return ixZ;
    }

    public static com.tencent.mm.plugin.appbrand.c.b Qc() {
        if (iya == null) {
            iya = new com.tencent.mm.plugin.appbrand.c.b();
        }
        return iya;
    }

    public static com.tencent.mm.plugin.appbrand.k.a Qd() {
        return ixX;
    }

    public static void Qe() {
        int i;
        com.tencent.mm.storage.c dX = com.tencent.mm.u.c.c.Az().dX("100249");
        if (dX.isValid()) {
            i = bg.getInt((String) dX.bKK().get("appbrand_player"), -1);
        } else {
            i = -1;
        }
        ab.getContext().getSharedPreferences("system_config_prefs", 4).edit().putInt("appbrand_video_player", i).commit();
        w.i("MicroMsg.SubCoreAppBrand", "check appbrand video ab test[%d]", new Object[]{Integer.valueOf(i)});
    }
}
