package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.R;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.k;
import java.util.ArrayList;

public class ShareCardListUI extends CardBaseUI implements d, a {
    private String kez = null;
    private b.a kgP = null;
    private f kiH;
    private e kiI;
    private i kiJ;
    private boolean kiK = false;
    private boolean kiL = true;
    private boolean kiM = false;
    private boolean kiN = true;
    private boolean kiO = true;
    private boolean kiP = false;
    private String kiQ = "";
    private boolean kiR = false;
    private boolean kiS = false;
    private boolean kiT = false;
    private int kiU = 0;
    private boolean kiV = false;
    private long kiW = 0;
    boolean kiX = false;
    private long kiY = 0;
    private final long kiZ = 500;
    private b kiy;
    private boolean kja = false;
    private boolean kjb = false;
    private long mStartTime = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        long currentTimeMillis = System.currentTimeMillis();
        this.mStartTime = currentTimeMillis;
        this.kiW = currentTimeMillis;
        KC();
        ap.vd().a(1164, this);
        al.agh().a(this);
        agP();
        al.agi().c(this);
    }

    protected void onDestroy() {
        if (this.kiV) {
            aeH();
        }
        this.kiH.kiy = null;
        this.kiI.kiy = null;
        this.kiy.kgP = null;
        ap.vd().b(1164, this);
        al.agh().b(this);
        b.agy();
        al.agi().f(this);
        long currentTimeMillis = System.currentTimeMillis() - this.kiW;
        if (TextUtils.isEmpty(this.kez)) {
            g.oUh.i(13219, new Object[]{"ShareCardListUI", Integer.valueOf(1), "", "", Long.valueOf(currentTimeMillis)});
        } else {
            g.oUh.i(13219, new Object[]{"ShareCardListUI", Integer.valueOf(0), "", "", Long.valueOf(currentTimeMillis)});
        }
        super.onDestroy();
    }

    protected void onResume() {
        db(true);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mStartTime != 0) {
            int i = (int) (currentTimeMillis - this.mStartTime);
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(281);
            iDKey.SetKey(56);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(281);
            iDKey2.SetKey(57);
            iDKey2.SetValue(i);
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            g.oUh.b(arrayList, true);
            this.mStartTime = 0;
        }
        super.onResume();
    }

    private void db(boolean z) {
        w.i("MicroMsg.ShareCardListUI", "doRefreshData() >> updateView() shouldGetLayout %s fromOnresume %s", new Object[]{Boolean.valueOf(this.kiL), Boolean.valueOf(z)});
        if (this.kiL) {
            this.kiL = false;
            this.kiR = false;
            this.kiN = true;
            this.kiQ = "";
            w.d("MicroMsg.ShareCardListUI", "doRefreshData() >> doNetSceneGetCardsHomePageLayout()");
            if (!z) {
                agO();
            } else if (this.kiV && this.kiX) {
                aeG();
            }
        }
        agL();
    }

    protected void onPause() {
        super.onPause();
        this.kiL = false;
        this.kiM = true;
    }

    protected final BaseAdapter aeC() {
        return new c(this.uSU.uTo);
    }

    protected final void KC() {
        super.KC();
        w.i("MicroMsg.ShareCardListUI", "checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null))});
        this.kiV = r0;
        if (this.kiV) {
            agK();
            return;
        }
        w.e("MicroMsg.ShareCardListUI", "location permission is denied, doGetLayout");
        agN();
    }

    private void agK() {
        w.d("MicroMsg.ShareCardListUI", "initLocation");
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ ShareCardListUI kjc;

            {
                this.kjc = r1;
            }

            public final void run() {
                this.kjc.hvP = c.Gk();
                this.kjc.aeF();
                this.kjc.kiX = true;
                w.d("MicroMsg.ShareCardListUI", "initLocation end");
            }
        });
    }

    protected final void aeK() {
        w.i("MicroMsg.ShareCardListUI", "onMPermissionGranted LocationPermissionGranted " + this.kiV);
        if (!this.kiV) {
            this.kiV = true;
            agK();
        }
    }

    protected final void aeA() {
        zi(R.l.dRL);
        this.kiy = new b(this);
        this.kgP = new b.a(this) {
            final /* synthetic */ ShareCardListUI kjc;

            {
                this.kjc = r1;
            }
        };
        this.kiy.kgP = this.kgP;
        this.kiy.init();
        this.kiU = b.agv();
        if (this.kiJ == null) {
            this.kiJ = new i(this, this.uSU.ipu);
            i iVar = this.kiJ;
            iVar.kjd = View.inflate(iVar.kdb, R.i.cWW, null);
            iVar.kje = (TextView) iVar.kjd.findViewById(R.h.bxx);
            iVar.kjf = (TextView) iVar.kjd.findViewById(R.h.bxy);
            iVar.ar();
        }
        if (this.kiH == null) {
            this.kiH = new f(this, this.uSU.ipu);
            f fVar = this.kiH;
            fVar.kiC = (ImageView) fVar.khv.findViewById(R.h.coh);
            fVar.kiE = (TextView) fVar.khv.findViewById(R.h.coj);
            fVar.kiD = (TextView) fVar.khv.findViewById(R.h.cok);
            this.kiH.kiy = this.kiy;
        }
        if (this.kiI == null) {
            this.kiI = new e(this);
            this.kiI.kiy = this.kiy;
            this.kiI.agF();
            e eVar = this.kiI;
            OnClickListener anonymousClass3 = new OnClickListener(this) {
                final /* synthetic */ ShareCardListUI kjc;

                {
                    this.kjc = r1;
                }

                public final void onClick(View view) {
                    if (b.agx() && b.agw()) {
                        this.kjc.kiU = 2;
                    } else if (b.agw()) {
                        this.kjc.kiU = 3;
                    }
                    g.oUh.i(11582, new Object[]{"OperChangeOtherCity ", Integer.valueOf(0), Integer.valueOf(0), "", "", ""});
                    al.agf().putValue("key_share_card_show_type", Integer.valueOf(this.kjc.kiU));
                    this.kjc.agM();
                    this.kjc.kiI.ar();
                    b.kgQ = true;
                }
            };
            if (eVar.kix != null) {
                eVar.kix.setOnClickListener(anonymousClass3);
            }
        }
        if (this.kcu != null) {
            this.kcu.addView(this.kiJ.kjd);
        }
        if (this.kcv != null) {
            this.kcv.addView(this.kiI.kix);
        }
        this.kcr.setVisibility(0);
        this.kcr.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ ShareCardListUI kjc;

            {
                this.kjc = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (absListView.getLastVisiblePosition() == absListView.getCount() - 1 && !this.kjc.kiO && this.kjc.kiU != 4) {
                    w.d("MicroMsg.ShareCardListUI", "onScroll() >> doNetSceneGetCardsHomePageLayout()");
                    this.kjc.agO();
                }
            }
        });
        Integer num;
        if (getIntent() == null || !getIntent().getBooleanExtra("KEY_IS_SHOW_SHARE_CARD_ENTRANCE_TIPS", true)) {
            ap.yY();
            num = (Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uAR, Integer.valueOf(0));
            if (!(num == null || num.intValue() == 1)) {
                ap.yY();
                com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uAR, Integer.valueOf(1));
            }
        } else {
            ap.yY();
            num = (Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uAR, Integer.valueOf(0));
            if (num == null || num.intValue() != 1) {
                ap.yY();
                com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uAR, Integer.valueOf(1));
                com.tencent.mm.plugin.card.b.d.c(this, R.i.cXb, R.l.dRS, "");
            }
        }
        this.kez = getIntent().getStringExtra("KEY_CARD_TP_ID");
        this.kiQ = getIntent().getStringExtra("key_layout_buff");
        if (!bg.mA(this.kiQ)) {
            this.kiL = false;
        }
        if (!bg.mA(this.kez)) {
            this.kiK = true;
            this.kiM = true;
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        agP();
        if (intent != null) {
            this.kez = intent.getStringExtra("KEY_CARD_TP_ID");
            if (!bg.mA(this.kez)) {
                this.kiK = true;
                this.kiM = true;
            }
        }
    }

    private void agL() {
        long currentTimeMillis = System.currentTimeMillis() - this.kiY;
        if (!this.kja || currentTimeMillis >= 1000) {
            w.d("MicroMsg.ShareCardListUI", "try2UpdateView isDoingUpdateView %s,interval %s", new Object[]{Boolean.valueOf(this.kja), Long.valueOf(currentTimeMillis)});
            this.kja = true;
            if (currentTimeMillis < 500) {
                af.f(new Runnable(this) {
                    final /* synthetic */ ShareCardListUI kjc;

                    {
                        this.kjc = r1;
                    }

                    public final void run() {
                        this.kjc.kja = false;
                        if (this.kjc.isFinishing()) {
                            w.w("MicroMsg.ShareCardListUI", "Activity is finished!!!");
                        } else {
                            this.kjc.agL();
                        }
                    }
                }, 500);
                return;
            }
            if (this.kiU == 0 || this.kiU == 4 || ((this.kiU == 2 && !(b.agx() && b.agw())) || ((this.kiU == 1 && (!b.agx() || b.agw())) || (this.kiU == 3 && (!b.agw() || b.agx()))))) {
                this.kiU = b.agv();
            }
            al.agf().putValue("key_share_card_show_type", Integer.valueOf(this.kiU));
            w.i("MicroMsg.ShareCardListUI", "updateView() currentType is %s, canShowLocalCity %s, canShowOtherCity %s", new Object[]{Integer.valueOf(this.kiU), Boolean.valueOf(b.agx()), Boolean.valueOf(b.agw())});
            f fVar = this.kiH;
            fVar.kiD.setVisibility(0);
            fVar.kiC.setImageDrawable(fVar.kdb.getResources().getDrawable(R.g.bdp));
            fVar.kiD.setText(R.l.dRG);
            fVar.kiE.setText(R.l.dRF);
            LayoutParams layoutParams = (LayoutParams) fVar.kiC.getLayoutParams();
            layoutParams.topMargin = fVar.kdb.getResources().getDimensionPixelOffset(R.f.aYS);
            fVar.kiC.setLayoutParams(layoutParams);
            fVar.kiC.invalidate();
            if (b.agx() || b.agw()) {
                this.kiI.ar();
                this.kiJ.ar();
                if (this.kiU == 4 && this.kcr.getEmptyView() != null) {
                    this.kcr.setEmptyView(null);
                    this.kcr.invalidate();
                }
            } else {
                this.kiI.agJ();
                this.kiJ.kjd.setVisibility(8);
                if (this.kcr.getEmptyView() != this.kct) {
                    this.kcr.setEmptyView(this.kct);
                    this.kcr.invalidate();
                }
            }
            agM();
            this.kiY = System.currentTimeMillis();
            this.kja = false;
            return;
        }
        w.d("MicroMsg.ShareCardListUI", "DoingUpdateView return");
    }

    private void agM() {
        if (this.kcs instanceof c) {
            c cVar = (c) this.kcs;
            cVar.kiv = this.kiU;
            cVar.a(null, null);
        }
    }

    protected final void aeI() {
        this.kiT = true;
        if (this.kiR) {
            w.e("MicroMsg.ShareCardListUI", "onLocationFinish, has do GetShareCardLayout,don't get again");
            if (this.kiV) {
                aeH();
                return;
            }
            return;
        }
        w.d("MicroMsg.ShareCardListUI", "onLocationFinish()");
        this.kiR = true;
        agN();
        aeH();
    }

    protected final void aeJ() {
        if (this.kiS || this.kiR) {
            aeH();
            return;
        }
        this.kiS = true;
        w.i("MicroMsg.ShareCardListUI", "onLocationFail()");
        agN();
    }

    private void agN() {
        if (b.agz() && b.agA()) {
            w.i("MicroMsg.ShareCardListUI", "doGetLayout() no data to load");
            this.kiO = true;
            return;
        }
        if (!(b.agz() && b.agA())) {
            this.kiN = false;
        }
        w.i("MicroMsg.ShareCardListUI", "doGetLayout() >> doNetSceneGetCardsHomePageLayout()");
        agO();
        al.agg().m("", "", 4);
    }

    private void agO() {
        if (this.kiP) {
            w.e("MicroMsg.ShareCardListUI", "doNetSceneGetCardsHomePageLayout, isDoingGetData is true");
            return;
        }
        if (!(!bg.mA(this.kiQ) || b.agx() || b.agw() || b.agx() || b.agw())) {
            this.kiI.agG();
            this.kcr.setEmptyView(null);
            this.kcr.invalidate();
            this.kjb = true;
        }
        if (this.kiN && !bg.mA(this.kiQ)) {
            this.kiQ = "";
        }
        this.kiP = true;
        ap.vd().a(new com.tencent.mm.plugin.card.sharecard.model.b((double) al.agg().gKj, (double) al.agg().gKk, this.kiQ), 0);
    }

    protected final boolean aeD() {
        return super.aeD();
    }

    protected final boolean aeE() {
        return false;
    }

    protected final void b(com.tencent.mm.plugin.card.base.b bVar) {
        if (bVar != null) {
            b.sx(bVar.afn());
        }
        super.b(bVar);
    }

    protected final void c(com.tencent.mm.plugin.card.base.b bVar) {
        super.c(bVar);
    }

    protected final void a(com.tencent.mm.plugin.card.base.b bVar) {
        Intent intent = new Intent(this, CardDetailUI.class);
        w.i("MicroMsg.ShareCardListUI", "card tp id:" + bVar.afn());
        w.i("MicroMsg.ShareCardListUI", "card id:" + bVar.afm());
        intent.putExtra("key_card_id", al.agi().sF(bVar.afn()));
        intent.putExtra("key_card_tp_id", bVar.afn());
        intent.putExtra("key_is_share_card", true);
        intent.putExtra("key_from_scene", 3);
        startActivity(intent);
        b.sC(bVar.afn());
    }

    public final void a(int i, int i2, String str, k kVar) {
        boolean z = true;
        super.a(i, i2, str, kVar);
        if (i != 0 || i2 != 0) {
            if (kVar instanceof com.tencent.mm.plugin.card.sharecard.model.b) {
                if (this.kjb) {
                    this.kjb = false;
                    this.kiI.agH();
                    this.kcr.setEmptyView(this.kct);
                    this.kcr.invalidate();
                }
                this.kiP = false;
                this.kiO = true;
            }
            w.i("MicroMsg.ShareCardListUI", "share card list ui, onSceneEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (kVar instanceof com.tencent.mm.plugin.card.sharecard.model.b) {
            com.tencent.mm.plugin.card.sharecard.model.b bVar = (com.tencent.mm.plugin.card.sharecard.model.b) kVar;
            this.kiP = false;
            this.kiQ = bVar.kgX;
            this.kiy.N(bVar.kfG, this.kiN);
            if (!(b.agz() && b.agA())) {
                this.kiN = false;
            }
            if (!(b.agz() && b.agA())) {
                z = false;
            }
            this.kiO = z;
            w.i("MicroMsg.ShareCardListUI", "NetSceneGetShareCardsLayout() >> updateView()");
            agL();
        }
    }

    public final void aft() {
        b.agu();
        this.kiL = true;
        w.i("MicroMsg.ShareCardListUI", "onDBchange() shouldRefreshDataOnDbChange %s  mIsActive %s hasLocationInfo %s", new Object[]{Boolean.valueOf(this.kiM), Boolean.valueOf(this.kcx), Boolean.valueOf(this.kiT)});
        if (this.kiM && this.kcx && this.kiT) {
            db(false);
        } else {
            agL();
        }
        this.kiM = false;
    }

    public final void a(String str, l lVar) {
        w.d("MicroMsg.ShareCardListUI", "onNotifyChange");
        this.kiL = true;
    }

    private void agP() {
        int intExtra = getIntent().getIntExtra("key_from_scene", 22);
        boolean aC = com.tencent.mm.q.c.uk().aC(262152, 266256);
        boolean aD = com.tencent.mm.q.c.uk().aD(262152, 266256);
        boolean a = com.tencent.mm.q.c.uk().a(com.tencent.mm.storage.w.a.uAz, com.tencent.mm.storage.w.a.uAB);
        boolean a2 = com.tencent.mm.q.c.uk().a(com.tencent.mm.storage.w.a.uAA, com.tencent.mm.storage.w.a.uAC);
        ap.yY();
        String mz = bg.mz((String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uAF, null));
        if (aC) {
            g.oUh.i(11324, new Object[]{"ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(2), Integer.valueOf(intExtra), "", Integer.valueOf(0), mz});
        } else if (aD) {
            g.oUh.i(11324, new Object[]{"ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(intExtra), "", Integer.valueOf(0), mz});
        } else if (a && !a2) {
            g.oUh.i(11324, new Object[]{"ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(3), Integer.valueOf(intExtra), "", Integer.valueOf(0), mz});
        } else if (a && a2) {
            g.oUh.i(11324, new Object[]{"ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(4), Integer.valueOf(intExtra), "", Integer.valueOf(0), mz});
        } else if (a2) {
            g.oUh.i(11324, new Object[]{"ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(5), Integer.valueOf(intExtra), "", Integer.valueOf(0), mz});
        } else {
            g.oUh.i(11324, new Object[]{"ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(intExtra), "", Integer.valueOf(0), mz});
        }
    }
}
