package com.tencent.mm.plugin.favorite.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.plugin.favorite.c.g;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.a.b;
import com.tencent.mm.plugin.favorite.ui.base.a;
import com.tencent.mm.plugin.favorite.ui.c.a.c;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.r;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FavCleanUI extends MMActivity implements c {
    protected ae hgN = new ae(Looper.getMainLooper());
    private HandlerThread lGC;
    protected ae lGD;
    protected View lGE;
    private View lGF;
    private Runnable lGK = new Runnable(this) {
        final /* synthetic */ FavCleanUI lHc;

        {
            this.lHc = r1;
        }

        public final void run() {
            if (this.lHc.lGU != null) {
                this.lHc.lGU.auq();
            }
            this.lHc.auc();
        }
    };
    protected Runnable lGL = new Runnable(this) {
        final /* synthetic */ FavCleanUI lHc;

        {
            this.lHc = r1;
        }

        public final void run() {
            if (this.lHc.lGU != null) {
                if (this.lHc.lGU.isEmpty() || SystemClock.elapsedRealtime() - this.lHc.lGz >= 1000) {
                    this.lHc.lGw = false;
                    this.lHc.lGz = SystemClock.elapsedRealtime();
                    w.v("MicroMsg.FavCleanUI", "do refresh job");
                    FavCleanUI.d(this.lHc);
                    if (this.lHc.lGx) {
                        w.v("MicroMsg.FavCleanUI", "do scroll to first");
                        this.lHc.lGV.setSelection(0);
                        this.lHc.lGx = false;
                        return;
                    }
                    return;
                }
                w.d("MicroMsg.FavCleanUI", "try refresh, time limit, now %d last %d delay %d", new Object[]{Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(this.lHc.lGz), Integer.valueOf(1000)});
                this.lHc.hgN.postDelayed(this, 500);
            }
        }
    };
    private g lGT;
    private b lGU;
    private ListView lGV;
    private TextView lGW;
    private a lGX;
    private boolean lGY = false;
    private int lGZ = 0;
    private boolean lGw = false;
    protected boolean lGx = false;
    private long lGz = 0;
    private com.tencent.mm.plugin.favorite.b.c.a lHa = new com.tencent.mm.plugin.favorite.b.c.a(this) {
        final /* synthetic */ FavCleanUI lHc;

        {
            this.lHc = r1;
        }

        public final void onFinish() {
            w.i("MicroMsg.FavCleanUI", "FavCleanFirstLoader onFinish()");
            FavCleanUI.c(this.lHc);
            FavCleanUI.d(this.lHc);
        }
    };
    private e lHb = new e(this) {
        final /* synthetic */ FavCleanUI lHc;

        {
            this.lHc = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            w.i("MicroMsg.FavCleanUI", "on getfavinfo scene end");
            if (this.lHc.lGX != null) {
                this.lHc.lGX.lJy = x.atE();
            }
        }
    };

    static /* synthetic */ boolean a(FavCleanUI favCleanUI) {
        if (favCleanUI.lGV.getChildAt(favCleanUI.lGV.getChildCount() - 1) == null || favCleanUI.lGV.getLastVisiblePosition() != favCleanUI.lGV.getAdapter().getCount() - 1) {
            return false;
        }
        w.i("MicroMsg.FavCleanUI", "at bottom call back");
        return true;
    }

    static /* synthetic */ void b(FavCleanUI favCleanUI) {
        w.v("MicroMsg.FavCleanUI", "on pull down callback");
        if (favCleanUI.lGU.lJl) {
            w.i("MicroMsg.FavCleanUI", "has shown all, do not load data");
        } else if (favCleanUI.lGw) {
            w.w("MicroMsg.FavCleanUI", "onBottomLoadData loading, return");
        } else {
            favCleanUI.lGw = true;
            favCleanUI.ed(true);
            w.i("MicroMsg.FavCleanUI", "on bottom load data listener");
            favCleanUI.lGD.removeCallbacks(favCleanUI.lGK);
            favCleanUI.lGD.post(favCleanUI.lGK);
        }
    }

    static /* synthetic */ void c(FavCleanUI favCleanUI) {
        favCleanUI.lGT = new g(ab.getContext(), 16);
        favCleanUI.lGU = new b(favCleanUI.lGT, true);
        favCleanUI.lGU.lJj = favCleanUI;
        favCleanUI.lGV.setAdapter(favCleanUI.lGU);
        favCleanUI.lGV.setOnItemClickListener(new OnItemClickListener(favCleanUI) {
            final /* synthetic */ FavCleanUI lHc;

            {
                this.lHc = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.lHc.lGU != null) {
                    this.lHc.lGU.onItemClick(adapterView, view, i, j);
                }
            }
        });
        favCleanUI.lGV.setOnTouchListener(null);
        favCleanUI.lGV.setOnItemLongClickListener(null);
    }

    static /* synthetic */ void d(FavCleanUI favCleanUI) {
        favCleanUI.lGU.notifyDataSetChanged();
        if (favCleanUI.lGU.isEmpty()) {
            favCleanUI.ec(true);
            if (8 != favCleanUI.lGV.getVisibility()) {
                favCleanUI.lGV.setVisibility(8);
            }
        } else {
            favCleanUI.ec(false);
            if (favCleanUI.lGX != null) {
                favCleanUI.lGX.show();
            }
            if (favCleanUI.lGV.getVisibility() != 0) {
                favCleanUI.lGV.setVisibility(0);
            }
        }
        favCleanUI.ed(false);
    }

    protected final int getLayoutId() {
        return R.i.dci;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lGZ = getIntent().getIntExtra("key_enter_fav_cleanui_from", 0);
        this.lGC = com.tencent.mm.sdk.f.e.Qu(getClass().getName() + "_handlerThread_" + System.currentTimeMillis());
        this.lGC.start();
        this.lGD = new ae(this.lGC.getLooper());
        this.lGV = (ListView) findViewById(R.h.bOh);
        zi(R.l.ehv);
        this.lGY = true;
        ap.vd().a(new com.tencent.mm.plugin.favorite.b.ae(), 0);
        ap.vd().a(438, this.lHb);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FavCleanUI lHc;

            {
                this.lHc = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lHc.finish();
                return true;
            }
        });
        ViewStub viewStub = (ViewStub) findViewById(R.h.bLS);
        if (viewStub != null) {
            this.lGF = viewStub.inflate();
        } else {
            this.lGF = findViewById(R.h.bPi);
        }
        this.lGW = (TextView) findViewById(R.h.bLQ);
        this.lGF.setVisibility(0);
        this.lGW.setVisibility(8);
        this.lGV.removeFooterView(this.lGE);
        if (this.lGX != null) {
            this.lGX.hide();
        }
        this.lGE = r.eC(this).inflate(R.i.dcv, null);
        this.lGV.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ FavCleanUI lHc;

            {
                this.lHc = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0 && FavCleanUI.a(this.lHc)) {
                    w.i("MicroMsg.FavCleanUI", "force bottom load data");
                    FavCleanUI.b(this.lHc);
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        if (this.lGY) {
            this.lGX = new a();
            a aVar = this.lGX;
            View findViewById = findViewById(R.h.bOg);
            aVar.lJB = false;
            aVar.lJC = findViewById;
            this.lGX.lJD = new a.a(this) {
                final /* synthetic */ FavCleanUI lHc;

                {
                    this.lHc = r1;
                }

                public final void aud() {
                    com.tencent.mm.ui.base.g.a(this.lHc.uSU.uTo, this.lHc.getString(R.l.ehu), "", new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass5 lHd;

                        {
                            this.lHd = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            long auu = this.lHd.lHc.lGU.auu();
                            final List ee = this.lHd.lHc.lGU.ee(true);
                            a f = this.lHd.lHc.lGX;
                            f.lJy += auu;
                            x.cb(x.atG() - auu);
                            if (!ee.isEmpty()) {
                                com.tencent.mm.plugin.report.service.g.oUh.i(14110, new Object[]{Integer.valueOf(this.lHd.lHc.lGZ), Integer.valueOf(ee.size()), Integer.valueOf((int) ((((double) auu) * 1.0d) / 1024.0d))});
                                final Dialog a = com.tencent.mm.ui.base.g.a(this.lHd.lHc.uSU.uTo, this.lHd.lHc.getString(R.l.ehD), false, null);
                                ap.vL().D(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass1 lHg;

                                    public final void run() {
                                        x.au(ee);
                                        af.v(new Runnable(this) {
                                            final /* synthetic */ AnonymousClass1 lHh;

                                            {
                                                this.lHh = r1;
                                            }

                                            public final void run() {
                                                b e = this.lHh.lHg.lHd.lHc.lGU;
                                                List<j> list = ee;
                                                if (e.lIY != null) {
                                                    List arrayList = new ArrayList();
                                                    for (j jVar : e.lIY) {
                                                        if (jVar != null) {
                                                            Object obj;
                                                            for (j jVar2 : list) {
                                                                if (jVar2 != null && jVar.field_localId == jVar2.field_localId) {
                                                                    obj = 1;
                                                                    break;
                                                                }
                                                            }
                                                            obj = null;
                                                            if (obj == null) {
                                                                arrayList.add(jVar);
                                                            }
                                                        }
                                                    }
                                                    e.lIY = arrayList;
                                                    arrayList = new ArrayList();
                                                    for (Long l : e.lJb) {
                                                        Object obj2;
                                                        for (j jVar3 : list) {
                                                            if (jVar3 != null && l.equals(Long.valueOf(jVar3.field_localId))) {
                                                                obj2 = 1;
                                                                break;
                                                            }
                                                        }
                                                        obj2 = null;
                                                        if (obj2 == null) {
                                                            arrayList.add(l);
                                                        }
                                                    }
                                                    e.lJb = arrayList;
                                                }
                                                this.lHh.lHg.lHd.lHc.lGU.notifyDataSetChanged();
                                                this.lHh.lHg.lHd.lHc.lGX.auv();
                                                a.dismiss();
                                            }

                                            public final String toString() {
                                                return super.toString() + "|batchDelFavItems";
                                            }
                                        });
                                    }
                                });
                                com.tencent.mm.plugin.report.service.g.oUh.i(11125, new Object[]{Integer.valueOf(ee.size()), Integer.valueOf(3)});
                            }
                        }
                    }, null);
                }
            };
            this.lGY = false;
        }
        com.tencent.mm.plugin.favorite.b.c.atc().a(this.lHa);
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.plugin.favorite.b.c atc = com.tencent.mm.plugin.favorite.b.c.atc();
        com.tencent.mm.plugin.favorite.b.c.a aVar = this.lHa;
        if (atc.lEd.contains(aVar)) {
            atc.lEd.remove(aVar);
        }
        if (this.lGT != null) {
            this.lGT.destory();
            this.lGT = null;
        }
        if (this.lGU != null) {
            this.lGU.finish();
        }
        this.lGC.quit();
        ap.vd().b(438, this.lHb);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        w.d("MicroMsg.FavCleanUI", "on create options menu");
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    protected final void auc() {
        w.i("MicroMsg.FavCleanUI", "on storage change, try refresh job");
        this.hgN.removeCallbacks(this.lGL);
        this.hgN.post(this.lGL);
    }

    private void ec(boolean z) {
        if (z) {
            this.lGF.setVisibility(8);
            this.lGW.setVisibility(0);
            this.lGV.removeFooterView(this.lGE);
            if (this.lGX != null) {
                this.lGX.hide();
                return;
            }
            return;
        }
        this.lGF.setVisibility(8);
        this.lGW.setVisibility(8);
        this.lGV.removeFooterView(this.lGE);
        if (this.lGX != null) {
            this.lGX.show();
        }
    }

    private void ed(boolean z) {
        if (!z) {
            this.lGV.removeFooterView(this.lGE);
        } else if (this.lGV.getFooterViewsCount() == 0) {
            this.lGV.addFooterView(this.lGE);
        }
    }

    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    public final void ci(long j) {
        j bT = h.ata().bT(j);
        if (!(bT == null || bT.field_favProto == null || bT.field_favProto.tzn.size() == 0)) {
            Iterator it = bT.field_favProto.tzn.iterator();
            while (it.hasNext()) {
                long j2 = ((rm) it.next()).txD;
            }
        }
        if (this.lGU.lJk) {
            boolean z;
            a aVar = this.lGX;
            if (this.lGU.aut() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (aVar.lJB) {
                aVar.kzq.setEnabled(z);
            }
            a aVar2 = this.lGX;
            List ee = this.lGU.ee(false);
            j2 = this.lGU.auu();
            if (ee.size() == 0 || j2 <= 0) {
                aVar2.auv();
                return;
            }
            aVar2.kzw.setText(aVar2.kzw.getContext().getString(R.l.eht, new Object[]{com.tencent.mm.plugin.favorite.c.bP(j2)}));
            aVar2.kzq.setEnabled(true);
        }
    }
}
