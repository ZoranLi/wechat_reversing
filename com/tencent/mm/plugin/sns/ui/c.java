package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.ui.b.b;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.r;

public final class c {
    private Context mContext;
    private int pPk = -1;
    private b pZk;
    private FrameLayout pZl;
    AbsoluteLayout pZm = null;
    protected Animation pZn;
    protected Animation pZo;
    public boolean pZp = false;
    private com.tencent.mm.plugin.sns.f.b qoN;
    Button qoO;

    class a {
        View pOr = null;
        String pZF;
        final /* synthetic */ c qoP;

        public a(c cVar, String str, View view) {
            this.qoP = cVar;
            this.pZF = str;
            this.pOr = view;
        }
    }

    public c(Context context, b bVar, FrameLayout frameLayout, com.tencent.mm.plugin.sns.f.b bVar2) {
        this.mContext = context;
        this.qoN = bVar2;
        this.pZk = bVar;
        this.pZl = frameLayout;
        this.pZn = new ScaleAnimation(1.0f, 1.0f, 0.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.pZn = AnimationUtils.loadAnimation(context, com.tencent.mm.plugin.sns.i.a.pyR);
        this.pZo = new ScaleAnimation(1.0f, 1.0f, 1.0f, 0.0f, 1, 1.0f, 1, 0.0f);
        this.pZo = AnimationUtils.loadAnimation(context, com.tencent.mm.plugin.sns.i.a.pyS);
    }

    public final boolean ct(final View view) {
        if (ae.beD().bfC() && this.qoN != null) {
            int cq = this.qoN.cq(view);
            if (cq == 0 || cq == 1) {
                return true;
            }
            w.i("MicroMsg.AdNotLikeHelper", "abtest error return 2");
        }
        if (this.pZp) {
            return false;
        }
        if (this.pZm != null) {
            if (this.pZm.getTag() instanceof a) {
                final View view2 = ((a) this.pZm.getTag()).pOr;
                this.pZp = true;
                view2.startAnimation(this.pZo);
                this.pZo.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ c qoP;

                    public final void onAnimationStart(Animation animation) {
                        this.qoP.pZp = true;
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        if (view2 != null) {
                            view2.clearAnimation();
                            view2.setVisibility(8);
                            this.qoP.bfB();
                        }
                        this.qoP.pZp = false;
                    }
                });
            } else {
                bfB();
            }
            return false;
        } else if (view.getTag() == null || !(view.getTag() instanceof com.tencent.mm.plugin.sns.data.b)) {
            return false;
        } else {
            com.tencent.mm.plugin.sns.data.b bVar = (com.tencent.mm.plugin.sns.data.b) view.getTag();
            String str = bVar.fGN;
            this.pZm = new AbsoluteLayout(this.mContext);
            this.pZm.setId(f.cTF);
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            this.pZl.addView(this.pZm);
            int a = BackwardSupportUtil.b.a(this.mContext, 150.0f);
            int a2 = BackwardSupportUtil.b.a(this.mContext, 17.0f);
            BackwardSupportUtil.b.a(this.mContext, 40.0f);
            final View inflate = r.eC(this.mContext).inflate(g.pGD, null);
            TextView textView = (TextView) inflate.findViewById(f.pAQ);
            String ea = v.ea(ab.getContext());
            com.tencent.mm.plugin.sns.storage.b bVar2 = bVar.pQK.qKz;
            if (bVar2 != null) {
                CharSequence charSequence = "";
                if ("zh_CN".equals(ea)) {
                    charSequence = bVar2.qeo;
                } else if ("zh_TW".equals(ea) || "zh_HK".equals(ea)) {
                    charSequence = bVar2.qeq;
                } else if ("en".equals(ea)) {
                    charSequence = bVar2.qep;
                }
                if (!bg.mA(charSequence)) {
                    textView.setText(charSequence);
                }
            }
            Rect rect = new Rect();
            int dr = e.dr(this.mContext);
            int[] blm = bVar.pQK.blm();
            w.d("MicroMsg.AdNotLikeHelper", "addCommentView getLocationInWindow " + blm[0] + "  " + blm[1] + " height: " + dr);
            this.pPk = e.ds(this.mContext);
            ViewGroup.LayoutParams layoutParams2 = new AbsoluteLayout.LayoutParams(-2, -2, blm[0] - a, ((blm[1] - this.pPk) - dr) + a2);
            this.pZm.setTag(new a(this, str, inflate));
            this.pZm.addView(inflate, layoutParams2);
            inflate.setVisibility(8);
            this.pZp = true;
            new com.tencent.mm.sdk.platformtools.ae().post(new Runnable(this) {
                final /* synthetic */ c qoP;

                public final void run() {
                    this.qoP.c(view, inflate);
                }
            });
            return true;
        }
    }

    public final void c(View view, View view2) {
        com.tencent.mm.plugin.sns.data.b bVar = (com.tencent.mm.plugin.sns.data.b) view.getTag();
        view2.setVisibility(0);
        this.pZp = true;
        this.pZn.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ c qoP;

            {
                this.qoP = r1;
            }

            public final void onAnimationStart(Animation animation) {
                this.qoP.pZp = true;
            }

            public final void onAnimationEnd(Animation animation) {
                this.qoP.pZp = false;
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        view2.startAnimation(this.pZn);
        this.qoO = (Button) view2.findViewById(f.pAJ);
        this.qoO.setOnClickListener(this.pZk.qNA);
        this.qoO.setOnTouchListener(bg.bJY());
        this.qoO.setTag(bVar);
    }

    public final boolean bfB() {
        if (this.qoN != null && ae.beD().bfC()) {
            this.qoN.bfB();
        }
        if (this.pZm != null) {
            this.pZl.removeView(this.pZm);
            this.pZm = null;
            return true;
        }
        this.pZp = false;
        return false;
    }
}
