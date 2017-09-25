package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.e;
import android.support.v4.view.u;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mm.R;
import com.tencent.mm.ah.a.c.g;
import com.tencent.mm.ah.a.d.b;
import com.tencent.mm.ah.n;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.s.a.f;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMDotView;

@com.tencent.mm.ui.base.a(19)
public class GameGalleryUI extends MMActivity implements e {
    private String appId = "";
    private MMDotView kSg;
    private ViewPager kSh;
    private int lvp = -1;
    private int mAG = 0;

    private static class a extends u {
        private String[] mAH = new String[0];
        private View[] mAI;
        public Context mContext;

        public a(Context context, String[] strArr) {
            this.mContext = context;
            if (strArr != null) {
                this.mAH = strArr;
            }
            this.mAI = new View[this.mAH.length];
        }

        public final Object b(ViewGroup viewGroup, int i) {
            View view = this.mAI[i];
            if (view == null) {
                View inflate = View.inflate(this.mContext, R.i.deD, null);
                this.mAI[i] = inflate;
                ImageView imageView = (ImageView) inflate.findViewById(R.h.bTV);
                final ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.h.bTX);
                progressBar.setVisibility(0);
                com.tencent.mm.ah.a.a GW = n.GW();
                String str = this.mAH[i];
                com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
                aVar.hIK = true;
                GW.a(str, imageView, aVar.Hg(), new g(this) {
                    final /* synthetic */ a mAK;

                    public final void jK(String str) {
                    }

                    public final void a(String str, View view, b bVar) {
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 mAL;

                            {
                                this.mAL = r1;
                            }

                            public final void run() {
                                progressBar.setVisibility(8);
                            }
                        });
                    }
                });
                view = inflate;
            }
            viewGroup.addView(view);
            view.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a mAK;

                {
                    this.mAK = r1;
                }

                public final void onClick(View view) {
                    ((MMActivity) this.mAK.mContext).finish();
                }
            });
            return view;
        }

        public final void a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public final int getCount() {
            return this.mAH.length;
        }

        public final boolean a(View view, Object obj) {
            return view == obj;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.uSU.bQg();
        this.kSh = (ViewPager) findViewById(R.h.bTU);
        this.kSg = (MMDotView) findViewById(R.h.bTW);
        String[] stringArrayExtra = getIntent().getStringArrayExtra("URLS");
        if (stringArrayExtra == null) {
            finish();
            return;
        }
        int intExtra = getIntent().getIntExtra("CURRENT", 0);
        if (intExtra < 0 || intExtra >= stringArrayExtra.length) {
            intExtra = 0;
        }
        this.appId = getIntent().getStringExtra("REPORT_APPID");
        this.lvp = getIntent().getIntExtra("REPORT_SCENE", -1);
        this.mAG = getIntent().getIntExtra("SOURCE_SCENE", 0);
        this.kSh.a(new a(this, stringArrayExtra));
        this.kSh.zb = this;
        this.kSh.k(intExtra, false);
        MMDotView mMDotView = this.kSg;
        mMDotView.viU = f.bid;
        mMDotView.viV = f.hbP;
        this.kSg.Ad(stringArrayExtra.length);
        this.kSg.Ae(intExtra);
        if (intExtra == 0) {
            ai.a(this, this.lvp, 1202, 1, 12, this.appId, this.mAG, null);
        }
    }

    protected final int getLayoutId() {
        return R.i.bTU;
    }

    public final void a(int i, float f, int i2) {
    }

    public final void V(int i) {
        this.kSg.Ae(i);
        ai.a(this, this.lvp, 1202, i + 1, 12, this.appId, this.mAG, null);
    }

    public final void W(int i) {
    }
}
