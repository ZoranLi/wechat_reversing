package com.tencent.mm.plugin.favorite.ui;

import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.b.eb;
import com.tencent.mm.plugin.favorite.b.ad;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.plugin.favorite.c.g;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.base.c;
import com.tencent.mm.plugin.favorite.ui.base.c.a;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.r;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public abstract class FavBaseUI extends MMActivity implements OnItemClickListener {
    protected ae hgN = new ae(Looper.getMainLooper());
    protected g lDs;
    protected ListView lGA;
    protected TextView lGB;
    private HandlerThread lGC;
    protected ae lGD;
    protected View lGE;
    private View lGF;
    protected c lGG;
    protected a lGH = null;
    private e lGI = new e(this) {
        final /* synthetic */ FavBaseUI lGO;

        {
            this.lGO = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            w.i("MicroMsg.FavoriteBaseUI", "on fav sync end");
            if (((ad) kVar).lFA) {
                w.i("MicroMsg.FavoriteBaseUI", "need batch get return");
                return;
            }
            w.i("MicroMsg.FavoriteBaseUI", "dismiss loading dialog");
            if (this.lGO.lGy) {
                this.lGO.lGy = false;
            }
            this.lGO.ea(false);
            this.lGO.auc();
        }
    };
    private e lGJ = new e(this) {
        final /* synthetic */ FavBaseUI lGO;

        {
            this.lGO = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            w.i("MicroMsg.FavoriteBaseUI", "on batch get end");
            if (this.lGO.lGy) {
                w.i("MicroMsg.FavoriteBaseUI", "init currently, dismiss dialog");
                this.lGO.lGy = false;
                this.lGO.ea(false);
            }
        }
    };
    private Runnable lGK = new Runnable(this) {
        final /* synthetic */ FavBaseUI lGO;

        {
            this.lGO = r1;
        }

        public final void run() {
            com.tencent.mm.plugin.favorite.ui.a.a atY = this.lGO.atY();
            atY.auq();
            atY.aur();
            this.lGO.auc();
        }
    };
    protected Runnable lGL = new Runnable(this) {
        final /* synthetic */ FavBaseUI lGO;

        {
            this.lGO = r1;
        }

        public final void run() {
            com.tencent.mm.plugin.favorite.ui.a.a atY = this.lGO.atY();
            if (atY.isEmpty() || SystemClock.elapsedRealtime() - this.lGO.lGz >= 1000) {
                this.lGO.lGw = false;
                this.lGO.lGz = SystemClock.elapsedRealtime();
                w.v("MicroMsg.FavoriteBaseUI", "do refresh job");
                atY.notifyDataSetChanged();
                this.lGO.a(atY);
                if (this.lGO.lGx) {
                    w.v("MicroMsg.FavoriteBaseUI", "do scroll to first");
                    this.lGO.lGA.setSelection(0);
                    this.lGO.lGx = false;
                    return;
                }
                return;
            }
            w.d("MicroMsg.FavoriteBaseUI", "try refresh, time limit, now %d last %d delay %d", new Object[]{Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(this.lGO.lGz), Integer.valueOf(1000)});
            this.lGO.hgN.postDelayed(this, 500);
        }
    };
    private Runnable lGM = new Runnable(this) {
        final /* synthetic */ FavBaseUI lGO;

        {
            this.lGO = r1;
        }

        public final void run() {
            this.lGO.atZ();
            this.lGO.atY().aur();
            this.lGO.auc();
        }
    };
    private j.a lGN = new j.a(this) {
        final /* synthetic */ FavBaseUI lGO;
        long lGP = 0;
        long lGQ = 1000;
        long lGR = 0;
        int lGS = 0;

        {
            this.lGO = r5;
        }

        public final void a(String str, l lVar) {
            if (bg.aB(this.lGR) < 1000) {
                this.lGS++;
            } else {
                this.lGS = 0;
                this.lGQ = 1000;
            }
            w.d("MicroMsg.FavoriteBaseUI", "on fav item info storage changed, postDelay %d", new Object[]{Long.valueOf(this.lGQ)});
            this.lGR = bg.NA();
            if (5 < this.lGS) {
                this.lGS = 0;
                this.lGQ += 1000;
                this.lGQ = Math.min(this.lGQ, 5000);
            }
            this.lGO.lGD.removeCallbacks(this.lGO.lGM);
            if (bg.aB(this.lGP) > this.lGQ) {
                this.lGP = bg.NA();
                this.lGO.lGD.post(this.lGO.lGM);
                return;
            }
            this.lGO.lGD.postDelayed(this.lGO.lGM, this.lGQ);
        }
    };
    private boolean lGw = false;
    protected boolean lGx = false;
    private boolean lGy = false;
    private long lGz = 0;

    public abstract com.tencent.mm.plugin.favorite.ui.a.a atY();

    protected abstract void atZ();

    protected abstract boolean aua();

    protected abstract void aub();

    static /* synthetic */ boolean a(FavBaseUI favBaseUI) {
        if (favBaseUI.lGA.getChildAt(favBaseUI.lGA.getChildCount() - 1) == null || favBaseUI.lGA.getLastVisiblePosition() != favBaseUI.lGA.getAdapter().getCount() - 1) {
            return false;
        }
        w.i("MicroMsg.FavoriteBaseUI", "at bottom call back");
        return true;
    }

    static /* synthetic */ boolean b(FavBaseUI favBaseUI) {
        w.v("MicroMsg.FavoriteBaseUI", "on pull down callback");
        if (!h.ata().n(favBaseUI.atY().auo(), favBaseUI.atY().getType())) {
            if (x.atB()) {
                w.w("MicroMsg.FavoriteBaseUI", "doing batchget, do not load data");
            } else if (favBaseUI.lGw) {
                w.w("MicroMsg.FavoriteBaseUI", "onBottomLoadData loading, return");
            } else {
                favBaseUI.lGw = true;
                w.i("MicroMsg.FavoriteBaseUI", "on bottom load data listener");
                favBaseUI.lGD.removeCallbacks(favBaseUI.lGK);
                favBaseUI.lGD.post(favBaseUI.lGK);
            }
        }
        return true;
    }

    protected final int getLayoutId() {
        return R.i.dcK;
    }

    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        if (!bDZ()) {
            w.e("MicroMsg.FavoriteBaseUI", "onCreate acc not ready finish");
            w.bIQ();
            finish();
            com.tencent.mm.plugin.report.service.g.oUh.a(598, 7, 1, false);
        } else if (h.ata().gUz == null) {
            h.asP().lDK = eb.pO();
            finish();
        } else {
            w.i("MicroMsg.FavoriteBaseUI", "onCreate MMCore.accHasReady[%b]", new Object[]{Boolean.valueOf(ap.zb())});
            ap.vd().a(new com.tencent.mm.plugin.favorite.b.ae(), 0);
            h.ata().c(this.lGN);
            ap.vd().a(400, this.lGI);
            ap.vd().a(402, this.lGJ);
            this.lGC = com.tencent.mm.sdk.f.e.Qu(getClass().getName() + "_handlerThread_" + System.currentTimeMillis());
            this.lGC.start();
            this.lGD = new ae(this.lGC.getLooper());
            this.lDs = new g(this.uSU.uTo, 64);
            KC();
            ap.yY();
            if (bg.f((Integer) com.tencent.mm.u.c.vr().get(8217, null)) == 0) {
                w.i("MicroMsg.FavoriteBaseUI", "do init data for first time");
                this.lGy = true;
                ap.vd().a(new ad(), 0);
                if (this.lGy) {
                    w.i("MicroMsg.FavoriteBaseUI", "show loading dialog");
                    if (atY() == null || atY().isEmpty()) {
                        ea(true);
                    }
                    eb(false);
                }
            } else {
                x.startSync();
                if (atY().isEmpty()) {
                    ea(true);
                    eb(false);
                    this.lGE.setVisibility(8);
                } else {
                    ea(false);
                    eb(false);
                }
            }
            h.asU().run();
            h.asR().run();
            h.asQ().run();
            h.asS().run();
            ap.vL().D(new Runnable(this) {
                final /* synthetic */ FavBaseUI lGO;

                {
                    this.lGO = r1;
                }

                public final void run() {
                    x.atC();
                }
            });
            w.d("MicroMsg.FavoriteBaseUI", "on create use %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        }
    }

    protected void onResume() {
        super.onResume();
        f.xT(5);
    }

    protected void onPause() {
        super.onPause();
        atY();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (h.ata().gUz != null) {
            this.lDs.destory();
            this.lDs = null;
            this.lGC.quit();
            h.ata().f(this.lGN);
            ap.vd().b(400, this.lGI);
            ap.vd().b(402, this.lGJ);
        }
    }

    protected final void KC() {
        long currentTimeMillis = System.currentTimeMillis();
        this.lGA = (ListView) findViewById(R.h.bPj);
        this.lGA.setDrawingCacheEnabled(false);
        AnonymousClass3 anonymousClass3 = new OnClickListener(this) {
            final /* synthetic */ FavBaseUI lGO;

            {
                this.lGO = r1;
            }

            public final void onClick(View view) {
                BackwardSupportUtil.c.a(this.lGO.lGA);
            }
        };
        initHeaderView();
        this.lGE = r.eC(this).inflate(R.i.dcv, null);
        this.lGA.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ FavBaseUI lGO;

            {
                this.lGO = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    return;
                }
                if (h.ata().n(this.lGO.atY().auo(), this.lGO.atY().getType())) {
                    w.v("MicroMsg.FavoriteBaseUI", "has shown all, do not load data");
                } else if (FavBaseUI.a(this.lGO)) {
                    w.i("MicroMsg.FavoriteBaseUI", "force bottom load data");
                    FavBaseUI.b(this.lGO);
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.lGA.setOnItemClickListener(this);
        this.lGA.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ FavBaseUI lGO;

            {
                this.lGO = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.lGO.aHf();
                return false;
            }
        });
        this.lGA.setAdapter(atY());
        a(atY());
        w.d("MicroMsg.FavoriteBaseUI", "init view use %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    protected final void ea(boolean z) {
        if (z) {
            if (this.lGF == null) {
                this.lGF = ((ViewStub) findViewById(R.h.bLS)).inflate();
            }
            this.lGF.setVisibility(0);
        } else if (this.lGF != null) {
            this.lGF.setVisibility(8);
        }
    }

    private void eb(boolean z) {
        if (z) {
            if (this.lGB == null) {
                this.lGB = (TextView) ((ViewStub) findViewById(R.h.bMd)).inflate().findViewById(R.h.bLQ);
            }
            this.lGB.setVisibility(0);
        } else if (this.lGB != null) {
            this.lGB.setVisibility(8);
        }
    }

    protected void initHeaderView() {
        this.lGG = new c(this.uSU.uTo);
        this.lGG.lJN = this.lGH;
        this.lGG.ef(false);
        this.lGG.lJL.setVisibility(8);
        this.lGG.lJM.setVisibility(8);
        w.d("MicroMsg.FavoriteBaseUI", "padding %s, %s", new Object[]{Integer.valueOf(this.lGG.getPaddingTop()), Integer.valueOf(this.lGG.getPaddingBottom())});
        this.lGA.addHeaderView(this.lGG);
    }

    protected void auc() {
        w.i("MicroMsg.FavoriteBaseUI", "on storage change, try refresh job");
        this.hgN.removeCallbacks(this.lGL);
        this.hgN.post(this.lGL);
    }

    protected final void a(com.tencent.mm.plugin.favorite.ui.a.a aVar) {
        if (aVar == null) {
            w.w("MicroMsg.FavoriteBaseUI", "handle empty view fail, adapter is null");
            return;
        }
        if (!aVar.isEmpty()) {
            ea(false);
            eb(false);
        } else if (aua()) {
            ea(true);
            eb(false);
        } else {
            ea(false);
            eb(true);
            aub();
        }
        if (aVar.isEmpty() || h.ata().n(aVar.auo(), aVar.getType())) {
            this.lGA.removeFooterView(this.lGE);
        } else if (this.lGA.getFooterViewsCount() == 0) {
            this.lGA.addFooterView(this.lGE);
        }
    }
}
