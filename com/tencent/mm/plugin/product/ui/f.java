package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.ln;
import com.tencent.mm.e.a.rz;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.plugin.product.b.h;
import com.tencent.mm.plugin.product.b.i;
import com.tencent.mm.plugin.product.b.j;
import com.tencent.mm.plugin.product.b.l;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aue;
import com.tencent.mm.protocal.c.bz;
import com.tencent.mm.protocal.c.ru;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.util.HashMap;
import java.util.LinkedList;

public final class f implements e {
    static int hPi = 0;
    public Activity oqR;
    public boolean oqS = false;
    public boolean oqT = false;
    public c oqU;
    public a oqV;
    private com.tencent.mm.sdk.b.c oqW = new com.tencent.mm.sdk.b.c<rz>(this) {
        final /* synthetic */ f oqY;

        {
            this.oqY = r2;
            this.usg = rz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            rz rzVar = (rz) bVar;
            if (!(rzVar instanceof rz)) {
                w.f("MicroMsg.MallProductUI", "mismatched event");
                return false;
            } else if (rzVar.fZv.result != -1) {
                w.i("MicroMsg.MallProductUI", "MallProduct pay result : cancel");
                return true;
            } else if (this.oqY.oqT) {
                return true;
            } else {
                w.i("MicroMsg.MallProductUI", "MallProduct pay result : ok");
                this.oqY.aTr();
                this.oqY.oqT = true;
                return true;
            }
        }
    };

    class AnonymousClass1 implements com.tencent.mm.sdk.platformtools.af.a {
        final /* synthetic */ m oqX;
        final /* synthetic */ f oqY;
        private volatile int result;
        final /* synthetic */ Intent val$intent;

        AnonymousClass1(f fVar, Intent intent, m mVar) {
            this.oqY = fVar;
            this.val$intent = intent;
            this.oqX = mVar;
        }

        public final boolean Bn() {
            f fVar = this.oqY;
            Intent intent = this.val$intent;
            m mVar = this.oqX;
            f.hPi = intent.getIntExtra("key_product_scene", 3);
            String stringExtra = intent.getStringExtra("key_product_info");
            String stringExtra2 = intent.getStringExtra("key_product_id");
            String stringExtra3 = intent.getStringExtra("key_source_url");
            c cVar = fVar.oqU;
            if (!bg.mA(stringExtra3)) {
                cVar.ooY = stringExtra3;
            }
            int i = -2;
            w.i("MicroMsg.MallProductUI", "Scene : " + f.hPi);
            switch (f.hPi) {
                case 1:
                case 2:
                case 4:
                    if (!bg.mA(stringExtra)) {
                        mVar = m.b(mVar, stringExtra);
                        if (mVar == null) {
                            i = -1;
                            break;
                        }
                        fVar.oqU.a(mVar, null);
                        stringExtra2 = mVar.opv;
                        i = 0;
                        break;
                    }
                    break;
                case 3:
                    if (!bg.mA(stringExtra)) {
                        mVar = m.a(mVar, stringExtra);
                        if (mVar == null) {
                            i = -1;
                            break;
                        }
                        fVar.oqU.a(mVar, null);
                        stringExtra2 = mVar.opv;
                        i = 0;
                        break;
                    }
                    break;
            }
            if (bg.mA(stringExtra2)) {
                i = -1;
            } else {
                ap.vd().a(new h(mVar, stringExtra2), 0);
            }
            this.result = i;
            return true;
        }

        public final boolean Bo() {
            switch (this.result) {
                case -1:
                    if (this.oqY.oqV != null) {
                        this.oqY.oqV.n(0, -1, this.oqY.oqR.getString(R.l.ezO));
                        break;
                    }
                    break;
                case 0:
                    if (this.oqY.oqV != null) {
                        this.oqY.oqV.n(0, 0, "");
                        break;
                    }
                    break;
            }
            return true;
        }

        public final String toString() {
            return super.toString() + "|initData";
        }
    }

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ f oqY;
        final /* synthetic */ ln oqZ;

        AnonymousClass2(f fVar, ln lnVar) {
            this.oqY = fVar;
            this.oqZ = lnVar;
        }

        public final void run() {
            w.d("MicroMsg.MallProductUI", "JSOAUTH errCode[%s], isAccept[%s]", new Object[]{Integer.valueOf(this.oqZ.fSx.errCode), Boolean.valueOf(this.oqZ.fSx.fSy)});
            if (this.oqZ.fSx.errCode == 0) {
                c cVar = this.oqY.oqU;
                ln lnVar = this.oqZ;
                bz bzVar = new bz();
                bzVar.jNj = lnVar.fSx.userName;
                bzVar.tfs = lnVar.fSx.fSA;
                bzVar.tft = lnVar.fSx.fSB;
                bzVar.hAE = lnVar.fSx.fSC;
                bzVar.hAF = lnVar.fSx.fSD;
                bzVar.hAM = lnVar.fSx.fSE;
                bzVar.mtg = lnVar.fSx.fSF;
                if (!(bg.mA(bzVar.jNj) || bg.mA(bzVar.tfs))) {
                    cVar.opb = bzVar;
                }
            }
            this.oqY.oqS = false;
        }
    }

    public interface a {
        void n(int i, int i2, String str);
    }

    public f(Activity activity, a aVar) {
        this.oqR = activity;
        com.tencent.mm.plugin.product.a.a.aSQ();
        this.oqU = com.tencent.mm.plugin.product.a.a.aSR();
        this.oqV = aVar;
    }

    public final void onStart() {
        ap.vd().a(553, this);
        ap.vd().a(554, this);
        ap.vd().a(555, this);
        ap.vd().a(556, this);
        ap.vd().a(557, this);
        ap.vd().a(578, this);
        ap.vd().a(579, this);
    }

    public final void onStop() {
        ap.vd().b(553, this);
        ap.vd().b(554, this);
        ap.vd().b(555, this);
        ap.vd().b(556, this);
        ap.vd().b(557, this);
        ap.vd().b(578, this);
        ap.vd().b(579, this);
    }

    public final void aTq() {
        m mVar = this.oqU.ooV;
        b cbVar = new cb();
        rv rvVar = new rv();
        rw rwVar = new rw();
        ru ruVar = new ru();
        rwVar.OD(com.tencent.mm.u.m.xL());
        rwVar.OE(com.tencent.mm.u.m.xL());
        rwVar.yj(11);
        rwVar.ep(bg.Nz());
        ruVar.Ow(mVar.opz.name);
        ruVar.Ox(this.oqU.aTk());
        ruVar.yg(mVar.opw);
        ruVar.Oz(this.oqU.a(mVar));
        ruVar.Oy(mVar.aTm());
        cbVar.fFA.title = mVar.opz.name;
        cbVar.fFA.desc = this.oqU.aTk();
        cbVar.fFA.fFC = rvVar;
        cbVar.fFA.type = 11;
        rvVar.a(rwVar);
        rvVar.b(ruVar);
        cbVar.fFA.activity = this.oqR;
        cbVar.fFA.fFH = 5;
        com.tencent.mm.sdk.b.a.urY.m(cbVar);
    }

    public final void aTr() {
        d aSS = com.tencent.mm.plugin.product.a.a.aSQ().aSS();
        aue aSY = this.oqU.aSY();
        if (!(aSY == null || bg.mA(aSY.mtg) || aSY.mtg.contains(";"))) {
            aSS.opn.remove(aSY.mtg);
            aSS.opn.add(aSY.mtg);
            aSS.aTl();
        }
        Intent intent = new Intent(this.oqR, MallProductUI.class);
        intent.putExtra("key_go_finish", true);
        intent.addFlags(67108864);
        this.oqR.startActivity(intent);
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.d("MicroMsg.MallProductUI", "errCode: " + i2 + ", errMsg: " + str);
        h hVar;
        if (i != 0 || i2 != 0) {
            switch (i2) {
                case -10010003:
                    w.i("MicroMsg.MallProductUI", "deal with MMBIZPAY_FUNC_ERR_NO_EXISTED_PRODUCT");
                    if (kVar instanceof h) {
                        hVar = (h) kVar;
                        this.oqU.a(hVar.opr, hVar.ops);
                        if (this.oqV != null) {
                            this.oqV.n(i, i2, str);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    w.i("MicroMsg.MallProductUI", "unkown errCode " + i2);
                    if (bg.mA(str)) {
                        str = i2 + " : " + this.oqR.getString(R.l.ezO);
                    }
                    if (this.oqV != null) {
                        this.oqV.n(i, i2, str);
                        return;
                    }
                    return;
            }
        } else if (kVar instanceof h) {
            hVar = (h) kVar;
            this.oqU.a(hVar.opr, hVar.ops);
            if (this.oqV != null) {
                this.oqV.n(i, i2, str);
            }
            if (bg.mA(hVar.opr.opv)) {
                g.oUh.i(11007, new Object[]{this.oqU.aSZ(), hVar.opq, Integer.valueOf(hPi), Integer.valueOf(1)});
                return;
            }
            g.oUh.i(11007, new Object[]{this.oqU.aSZ(), hVar.opr.opv, Integer.valueOf(hPi), Integer.valueOf(1)});
        } else if (kVar instanceof j) {
            j jVar = (j) kVar;
            r0 = this.oqU;
            r1 = jVar.ooX;
            r2 = jVar.opi;
            LinkedList linkedList = jVar.opj;
            r0.ooX = r1;
            r0.opj = linkedList;
            r0.opi = r2;
            r0.rd(0);
            this.oqR.startActivity(new Intent(this.oqR, MallProductSubmitUI.class));
            g.oUh.i(11009, new Object[]{this.oqU.aSZ(), this.oqU.ooV.opv, Integer.valueOf(hPi), Integer.valueOf(1)});
        } else if (!(kVar instanceof com.tencent.mm.plugin.product.b.f)) {
            if (kVar instanceof l) {
                r1 = ((l) kVar).opu;
                int i3 = 6;
                if (hPi == 7) {
                    i3 = MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED;
                }
                w.d("MicroMsg.MallProductUI", "payScene:" + i3);
                com.tencent.mm.pluginsdk.wallet.e.a(this.oqR, r1, this.oqU.getAppId(), i3, 3);
                com.tencent.mm.sdk.b.a.urY.b(this.oqW);
            } else if (kVar instanceof com.tencent.mm.plugin.product.b.k) {
                com.tencent.mm.ui.base.g.bl(this.oqR, this.oqR.getString(R.l.eAa));
                aTr();
            } else if (kVar instanceof com.tencent.mm.plugin.product.b.g) {
                try {
                    this.oqR.dismissDialog(-10002);
                } catch (Exception e) {
                    w.e("MicroMsg.MallProductUI", e.toString());
                }
                r0 = this.oqU;
                r0.opi = ((com.tencent.mm.plugin.product.b.g) kVar).opi;
                r0.rd(0);
            } else if (kVar instanceof i) {
                try {
                    this.oqR.dismissDialog(-10002);
                } catch (Exception e2) {
                    w.e("MicroMsg.MallProductUI", e2.toString());
                }
                i iVar = (i) kVar;
                r0 = this.oqU;
                r1 = iVar.mUrl;
                r2 = iVar.opt;
                if (!(bg.mA(r1) || r2 == null || r2.size() <= 0)) {
                    if (r0.opm == null) {
                        r0.opm = new HashMap();
                    }
                    r0.opm.put(r1, r2);
                }
                if (this.oqV != null) {
                    this.oqV.n(i, i2, str);
                }
            }
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    this.oqU.N(intent);
                    if (this.oqV != null) {
                        this.oqV.n(0, 0, "");
                    }
                    n vd = ap.vd();
                    c cVar = this.oqU;
                    vd.a(new com.tencent.mm.plugin.product.b.g(cVar.ooV != null ? cVar.ooV.opv : "", this.oqU.ooX, this.oqU.opb), 0);
                    return;
                }
                return;
            case 2:
                if (i2 == -1 && intent != null) {
                    this.oqU.N(intent);
                    ap.vd().a(new j(this.oqU.aTg(), hPi), 0);
                    return;
                }
                return;
            case 3:
                b rzVar = new rz();
                rzVar.fZv.context = this.oqR;
                rzVar.fZv.result = i;
                rzVar.fZv.intent = intent;
                this.oqW.a(rzVar);
                return;
            case 4:
                if (this.oqV != null) {
                    this.oqV.n(0, 0, "");
                    return;
                }
                return;
            case 10000:
                this.oqR.showDialog(-10002);
                ap.vd().a(new i(this.oqU.ooX, this.oqU.ope), 0);
                return;
            default:
                return;
        }
    }
}
