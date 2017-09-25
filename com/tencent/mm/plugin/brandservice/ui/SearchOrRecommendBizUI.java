package com.tencent.mm.plugin.brandservice.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.brandservice.a.g;
import com.tencent.mm.plugin.brandservice.ui.BizSearchResultItemContainer.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper;
import com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.List;

public class SearchOrRecommendBizUI extends MMActivity implements b {
    private BizSearchResultItemContainer jZJ;
    private int jZM = 0;
    private int jZp = 0;
    private ProgressDialog kbu = null;
    private SearchViewNotRealTimeHelper kbv;

    protected final int getLayoutId() {
        return R.i.cZK;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jZp = getIntent().getIntExtra("intent_extra_entry_flag", 0);
        this.jZM = getIntent().getIntExtra("fromScene", 0);
        KC();
        if (g.aea()) {
            ap.vd().a(456, new e(this) {
                final /* synthetic */ SearchOrRecommendBizUI kbw;

                {
                    this.kbw = r1;
                }

                public final void a(int i, int i2, String str, k kVar) {
                    if (kVar == null) {
                        w.e("MicroMsg.BrandService.SearchOrRecommendBizUI", "NetScene is null.");
                    } else if (kVar.getType() != 456) {
                        w.e("MicroMsg.BrandService.SearchOrRecommendBizUI", "The NetScene is not a RecommendGroupNetScene.");
                    } else {
                        ap.vd().b(456, this);
                        w.i("MicroMsg.BrandService.SearchOrRecommendBizUI", "errType(%d) , errCode(%d) , errMsg(%s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                        if (i == 0 && i2 == 0) {
                            List aeb = g.aeb();
                            final f fVar = this.kbw.jZJ == null ? null : (f) this.kbw.jZJ.kaf;
                            if (fVar != null && aeb != null && aeb.size() > 0) {
                                int i3;
                                if (fVar.getCount() == 0) {
                                    i3 = 1;
                                } else {
                                    i3 = 0;
                                }
                                fVar.kbq = aeb;
                                if (i3 != 0) {
                                    af.v(new Runnable(this) {
                                        final /* synthetic */ AnonymousClass1 kby;

                                        public final void run() {
                                            w.i("MicroMsg.BrandService.SearchOrRecommendBizUI", "Has got recommend groups, so notifyDataSetChanged.");
                                            fVar.notifyDataSetChanged();
                                        }
                                    });
                                }
                            }
                        }
                    }
                }
            });
            ap.vd().a(new g(), 0);
        }
        final String stringExtra = getIntent().getStringExtra("Search_Str");
        if (!bg.mA(stringExtra)) {
            new ae(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ SearchOrRecommendBizUI kbw;

                public final void run() {
                    this.kbw.kbv.Ug(stringExtra);
                    this.kbw.kbv.woq.performClick();
                }
            });
        }
    }

    public void onDestroy() {
        super.onDestroy();
        com.tencent.mm.modelbiz.w.DP().DB();
    }

    protected final void KC() {
        zi(R.l.eaw);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SearchOrRecommendBizUI kbw;

            {
                this.kbw = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kbw.aHf();
                this.kbw.finish();
                return true;
            }
        });
        this.kbv = (SearchViewNotRealTimeHelper) findViewById(R.h.cBe);
        SearchViewNotRealTimeHelper searchViewNotRealTimeHelper = this.kbv;
        searchViewNotRealTimeHelper.vqz.setTextColor(getResources().getColor(R.e.aVo));
        this.kbv.Q(getString(R.l.eaw));
        searchViewNotRealTimeHelper = this.kbv;
        searchViewNotRealTimeHelper.vqz.setHintTextColor(getResources().getColor(R.e.aUn));
        this.kbv.vqz.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        searchViewNotRealTimeHelper = this.kbv;
        if (searchViewNotRealTimeHelper.wkh != null) {
            searchViewNotRealTimeHelper.wkh.setVisibility(8);
        }
        this.kbv.wor = new a(this) {
            final /* synthetic */ SearchOrRecommendBizUI kbw;

            {
                this.kbw = r1;
            }

            public final boolean mQ(String str) {
                sb(str);
                return true;
            }

            public final void sb(String str) {
                if (bg.mA(str)) {
                    com.tencent.mm.ui.base.g.bl(this.kbw.uSU.uTo, this.kbw.getString(R.l.eau));
                    return;
                }
                this.kbw.aHf();
                this.kbw.jZJ.az(str, 0);
            }

            public final void aes() {
                this.kbw.aHj();
            }
        };
        this.jZJ = (BizSearchResultItemContainer) findViewById(R.h.cAk);
        this.jZJ.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ SearchOrRecommendBizUI kbw;

            {
                this.kbw = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.kbw.kbv.clearFocus();
                this.kbw.aHf();
                return false;
            }
        });
        c fVar = new f(this);
        fVar.kbq = g.aeb();
        this.jZJ.a(fVar);
        this.jZJ.d(1);
        this.jZJ.cY(false);
        this.jZJ.kao = 1;
        this.jZJ.kc(this.jZM);
        this.jZJ.kak = this;
    }

    public final void aeh() {
        Context context = this.uSU.uTo;
        getString(R.l.dIO);
        this.kbu = com.tencent.mm.ui.base.g.a(context, getString(R.l.eav), true, new OnCancelListener(this) {
            final /* synthetic */ SearchOrRecommendBizUI kbw;

            {
                this.kbw = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                BizSearchResultItemContainer a = this.kbw.jZJ;
                ap.vd().c(a.kaj);
                a.kah.kau = false;
            }
        });
    }

    public final void aei() {
        if (this.kbu != null) {
            this.kbu.dismiss();
            this.kbu = null;
        }
    }
}
