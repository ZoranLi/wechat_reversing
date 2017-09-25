package com.tencent.mm.plugin.game.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.model.ad;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.model.m;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.q;
import com.tencent.mm.u.q.b;
import com.tencent.mm.ui.MMActivity;

public class GameDetailRankUI extends MMActivity {
    public static String EXTRA_SESSION_ID = "extra_session_id";
    public static String mzo = "gameDetailRankDataKey";
    private String appId;
    private ListView mzl;
    private GameRankHeadView mzm;
    private h mzn;

    public static class a {
        public String mzq;
        public String mzr;
        c mzs;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b fP = q.yC().fP(getIntent().getStringExtra(EXTRA_SESSION_ID));
        if (fP == null) {
            finish();
            return;
        }
        a aVar = (a) fP.get(mzo);
        this.mzl = (ListView) findViewById(R.h.bTJ);
        if (!(bg.mA(aVar.mzq) || bg.mA(aVar.mzr))) {
            View inflate = ((LayoutInflater) this.uSU.uTo.getSystemService("layout_inflater")).inflate(R.i.deB, this.mzl, false);
            this.mzm = (GameRankHeadView) inflate.findViewById(R.h.bUP);
            this.mzl.addHeaderView(inflate);
            GameRankHeadView gameRankHeadView = this.mzm;
            gameRankHeadView.iUO.setText(aVar.mzq);
            gameRankHeadView.mDV.setText(aVar.mzr);
            gameRankHeadView.mrp = aVar.mzs;
            gameRankHeadView.mrp.fTL = 1203;
            gameRankHeadView.mrp.position = 2;
            if (gameRankHeadView.mzz == null) {
                gameRankHeadView.mzz = new m(gameRankHeadView.mrp);
            }
            gameRankHeadView.mzz.cj(gameRankHeadView.getContext());
            gameRankHeadView.mzz.aAK();
            gameRankHeadView.aCb();
            if (gameRankHeadView.mzx != null) {
                l.a(gameRankHeadView.mzx);
            } else {
                gameRankHeadView.mzx = new l.b(gameRankHeadView) {
                    final /* synthetic */ GameRankHeadView mDX;

                    {
                        this.mDX = r1;
                    }

                    public final void g(int i, String str, boolean z) {
                        if (this.mDX.mrp != null) {
                            this.mDX.mzz.cj(this.mDX.getContext());
                            this.mDX.mzz.aAK();
                            if (z) {
                                this.mDX.aCb();
                            }
                        }
                    }
                };
                l.a(gameRankHeadView.mzx);
            }
            gameRankHeadView.myV.setOnClickListener(gameRankHeadView);
        }
        this.mzn = new h(this);
        this.mzn.Ds = R.i.dev;
        this.mzl.setAdapter(this.mzn);
        this.appId = aVar.mzs.field_appId;
        if (bg.mA(this.appId)) {
            finish();
            return;
        }
        KC();
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ GameDetailRankUI mzp;

            {
                this.mzp = r1;
            }

            public final void run() {
                this.mzp.mzn.a(new ad(this.mzp.appId));
            }
        });
    }

    public void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
        l.b(this.mzm.mzx);
    }

    protected final int getLayoutId() {
        return R.i.deu;
    }

    protected final void KC() {
        qP(g.m(this.uSU.uTo, this.appId));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ GameDetailRankUI mzp;

            {
                this.mzp = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.mzp.finish();
                return true;
            }
        });
    }
}
