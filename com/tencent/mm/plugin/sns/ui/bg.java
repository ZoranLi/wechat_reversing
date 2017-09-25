package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.protocal.c.bbk;

public final class bg {
    Context mContext;
    int pPk = -1;
    private au pZQ;
    FrameLayout pZl;
    SnsCommentShowAbLayout qKW = null;
    LinearLayout qzE;
    LinearLayout qzF;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ View qKX;
        final /* synthetic */ bg qKY;
        final /* synthetic */ View zG;

        AnonymousClass1(bg bgVar, View view, View view2) {
            this.qKY = bgVar;
            this.zG = view;
            this.qKX = view2;
        }

        public final void run() {
            this.qKY.c(this.zG, this.qKX);
        }
    }

    class a {
        View pOr = null;
        String pZF;
        final /* synthetic */ bg qKY;

        public a(bg bgVar, String str, View view) {
            this.qKY = bgVar;
            this.pZF = str;
            this.pOr = view;
        }
    }

    public bg(Context context, au auVar, FrameLayout frameLayout) {
        this.mContext = context;
        this.pZQ = auVar;
        this.pZl = frameLayout;
    }

    final void cB(final View view) {
        view.clearAnimation();
        view.startAnimation(this.pZQ.qzD);
        this.pZQ.qzD.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ bg qKY;

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                if (view != null) {
                    view.setVisibility(8);
                    this.qKY.biz();
                }
            }
        });
    }

    public final void c(View view, View view2) {
        c cVar = (c) view.getTag();
        m Gg = ae.beL().Gg(cVar.fGN);
        if (Gg != null) {
            b gz = b.gz(740);
            bbk n = ai.n(Gg);
            gz.kG(i.g(Gg)).gC(Gg.field_type).bp(Gg.tE(32)).kG(Gg.bhI()).kG(Gg.field_userName).gC(n == null ? 0 : n.ucl).gC(n == null ? 0 : n.uco);
            gz.JE();
        }
        view2.setVisibility(0);
        view2.startAnimation(this.pZQ.qzC);
        this.qzE = (LinearLayout) view2.findViewById(f.pBi);
        this.qzE.setOnClickListener(this.pZQ.pZk.qNv);
        this.qzE.setOnTouchListener(this.pZQ.qtw);
        this.qzF = (LinearLayout) view2.findViewById(f.pBA);
        this.qzF.setOnClickListener(this.pZQ.pZk.qNw);
        this.qzF.setOnTouchListener(this.pZQ.qtw);
        this.qzF.setTag(cVar);
        this.qzE.setTag(cVar);
        ImageView imageView = (ImageView) this.qzF.findViewById(f.pBz);
        ImageView imageView2 = (ImageView) this.qzE.findViewById(f.pBa);
        TextView textView = (TextView) this.qzF.findViewById(f.pBB);
        TextView textView2 = (TextView) this.qzE.findViewById(f.pBj);
        if (u.GD(cVar.fVJ)) {
            this.qzE.setEnabled(false);
            this.qzF.setEnabled(false);
            textView2.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.sns.i.c.pza));
            if (cVar.knu == 11) {
                imageView.setImageResource(com.tencent.mm.plugin.sns.i.i.pIR);
                imageView2.setImageResource(com.tencent.mm.plugin.sns.i.i.pIU);
            } else {
                imageView.setImageResource(com.tencent.mm.plugin.sns.i.i.pIT);
                imageView2.setImageResource(com.tencent.mm.plugin.sns.i.i.pIV);
            }
            textView.setText(this.mContext.getString(j.pLI));
            textView.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.sns.i.c.pza));
        } else {
            this.qzE.setEnabled(true);
            if (cVar.knu == 11) {
                imageView.setImageResource(e.pzM);
                imageView2.setImageResource(e.pzN);
                textView.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.sns.i.c.pzb));
                textView2.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.sns.i.c.pzb));
            } else {
                imageView.setImageResource(e.pzE);
                textView.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.sns.i.c.white));
                textView2.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.sns.i.c.white));
            }
            this.qzF.setEnabled(true);
            if (cVar.qLQ == 0) {
                textView.setText(this.mContext.getString(j.pLI));
            } else {
                textView.setText(this.mContext.getString(j.pLi));
            }
        }
        if (cVar.knu == 11) {
            this.qzF.setBackgroundResource(e.pzO);
            this.qzE.setBackgroundResource(e.pzP);
        }
    }

    public final boolean biz() {
        if (this.qKW == null) {
            return false;
        }
        this.pZl.removeView(this.qKW);
        this.qKW = null;
        return true;
    }
}
