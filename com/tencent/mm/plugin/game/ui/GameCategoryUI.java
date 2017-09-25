package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ab;
import com.tencent.mm.plugin.game.model.at;
import com.tencent.mm.plugin.game.ui.l.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class GameCategoryUI extends MMActivity implements e {
    private View jAt;
    private Dialog jjI;
    private int mType;
    private int mqT = 0;
    private int mqY = 0;
    private ListView mxl;
    private k mxm;
    private boolean mxn = false;
    private boolean mxo = false;
    private int mxp;
    private String mxq;
    private j mxr = new j();
    private a mxs = new a(this) {
        final /* synthetic */ GameCategoryUI mxu;

        {
            this.mxu = r1;
        }

        public final void nE(int i) {
            int firstVisiblePosition = this.mxu.mxl.getFirstVisiblePosition();
            int lastVisiblePosition = this.mxu.mxl.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                this.mxu.mxm.x(this.mxu.mxl.getChildAt(i - firstVisiblePosition), i);
            }
        }
    };
    private OnScrollListener mxt = new OnScrollListener(this) {
        final /* synthetic */ GameCategoryUI mxu;

        {
            this.mxu = r1;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && this.mxu.mxo && !this.mxu.mxn) {
                this.mxu.jAt.setVisibility(0);
                this.mxu.aBP();
            }
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };

    static /* synthetic */ void a(GameCategoryUI gameCategoryUI, ab abVar, boolean z) {
        gameCategoryUI.mxo = abVar.mqW.muC;
        if (z) {
            gameCategoryUI.mxm.O(abVar.mqX);
        } else {
            gameCategoryUI.mxm.P(abVar.mqX);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("extra_type", 0);
        this.mxp = getIntent().getIntExtra("extra_category_id", 0);
        this.mxq = getIntent().getStringExtra("extra_category_name");
        this.mqT = getIntent().getIntExtra("game_report_from_scene", 0);
        ap.vd().a(1220, this);
        qP(this.mxq);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ GameCategoryUI mxu;

            {
                this.mxu = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.mxu.finish();
                return true;
            }
        });
        if (!bg.mA(SubCoreGameCenter.aBz())) {
            a(0, R.l.eYk, R.k.dsV, new OnMenuItemClickListener(this) {
                final /* synthetic */ GameCategoryUI mxu;

                {
                    this.mxu = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    Intent intent = new Intent(this.mxu, GameSearchUI.class);
                    switch (this.mxu.mType) {
                        case 1:
                            intent.putExtra("game_report_from_scene", 1602);
                            break;
                        case 2:
                            intent.putExtra("game_report_from_scene", 1502);
                            break;
                    }
                    this.mxu.startActivity(intent);
                    return true;
                }
            });
        }
        this.mxl = (ListView) findViewById(R.h.bSF);
        this.mxl.setOnItemClickListener(this.mxr);
        this.mxr.nC(this.mqT);
        this.mxl.setOnScrollListener(this.mxt);
        this.mxm = new k(this);
        this.mxm.nC(this.mqT);
        this.mxm.a(this.mxs);
        this.jAt = ((LayoutInflater) this.uSU.uTo.getSystemService("layout_inflater")).inflate(R.i.deP, this.mxl, false);
        this.jAt.setVisibility(8);
        this.mxl.addFooterView(this.jAt);
        this.mxl.setAdapter(this.mxm);
        this.jjI = c.cm(this);
        this.jjI.show();
        aBP();
    }

    public void onDestroy() {
        super.onDestroy();
        ap.vd().b(1220, this);
        this.mxm.clear();
    }

    protected final int getLayoutId() {
        return R.i.ded;
    }

    private void aBP() {
        ap.vd().a(new at(this.mqY, this.mType, this.mxp), 0);
        this.mxn = true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            final com.tencent.mm.bd.a aVar = ((at) kVar).ldw.hsk.hsr;
            ap.vL().D(new Runnable(this) {
                final /* synthetic */ GameCategoryUI mxu;

                public final void run() {
                    final ab abVar = new ab(aVar, this.mxu.mType, this.mxu.mqY);
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass5 mxx;

                        public final void run() {
                            GameCategoryUI.a(this.mxx.mxu, abVar, this.mxx.mxu.mqY != 0);
                            this.mxx.mxu.mxn = false;
                            this.mxx.mxu.jAt.setVisibility(8);
                            this.mxx.mxu.mqY = this.mxx.mxu.mqY + 15;
                            if (this.mxx.mxu.jjI != null) {
                                this.mxx.mxu.jjI.dismiss();
                            }
                        }
                    });
                }
            });
            return;
        }
        w.e("MicroMsg.GameCategoryUI", "errType: %d, errCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        w.i("MicroMsg.GameCategoryUI", "requestCode = %d, resultCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i != 1) {
            w.e("MicroMsg.GameCategoryUI", "error request code");
            return;
        }
        String str = null;
        if (intent != null) {
            str = intent.getStringExtra("game_app_id");
        }
        switch (i2) {
            case 2:
                if (!bg.mA(str)) {
                    this.mxm.xY(str);
                    this.mxm.ya(str);
                    return;
                }
                return;
            case 3:
                if (!bg.mA(str)) {
                    this.mxm.xZ(str);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
