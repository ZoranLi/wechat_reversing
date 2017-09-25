package com.tencent.mm.plugin.sns.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bg.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.ao.b;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bg;

public class SnsTranslateResultView extends LinearLayout {
    private static final int qJq = Color.parseColor("#19000000");
    private Drawable hJd;
    public TextView pby;
    private TextView qJo;
    public View qJp;
    private int qJr = -1;
    private float qJs = -1.0f;
    private int qJt = -1;

    public SnsTranslateResultView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(g.pIB, this);
        this.qJo = (TextView) findViewById(f.pFX);
        this.pby = (TextView) findViewById(f.pFY);
        this.qJp = findViewById(f.pGj);
        this.hJd = getResources().getDrawable(e.pAt);
        this.hJd.setBounds(0, 0, (int) (this.pby.getTextSize() * 0.8f), (int) (this.pby.getTextSize() * 0.8f));
        this.hJd.setColorFilter(qJq, Mode.SRC_IN);
    }

    public final void uh(int i) {
        this.pby.setCompoundDrawables(this.hJd, null, null, null);
        this.pby.setCompoundDrawablePadding(a.fromDPToPix(getContext(), 3));
        this.pby.setText(j.pMQ);
        com.tencent.mm.ui.tools.j.a(this.pby, null);
        this.qJo.setVisibility(4);
        this.qJr = i;
        this.pby.setTextSize(0, this.qJo.getTextSize());
        this.pby.setTextColor(getContext().getResources().getColor(c.pzg));
    }

    public final void ao(float f) {
        this.pby.setTextSize(1, f);
        this.qJs = f;
        this.qJt = 1;
    }

    public final void ap(float f) {
        this.pby.setTextSize(0, f);
        this.qJs = f;
        this.qJt = 0;
    }

    @TargetApi(11)
    public final void a(final b bVar, int i, String str, String str2, boolean z) {
        this.qJr = i;
        if (this.qJs != -1.0f || this.qJt != -1) {
            this.pby.setTextSize(this.qJt, this.qJs);
        } else if (this.qJr == 2) {
            this.pby.setTextSize(1, 14.0f * a.dI(getContext()));
        } else if (this.qJr == 1) {
            this.pby.setTextSize(1, 15.0f * a.dI(getContext()));
        }
        if (this.qJr == 2) {
            this.pby.setTextColor(getContext().getResources().getColor(c.pzf));
        } else if (this.qJr == 1) {
            this.pby.setTextColor(getContext().getResources().getColor(c.pzh));
        }
        if (bg.mA(str)) {
            this.pby.setText(j.pMO);
        } else {
            this.pby.setText(str);
            h.d(this.pby, 2);
        }
        this.pby.setCompoundDrawables(null, null, null, null);
        if (z && d.eo(11)) {
            com.tencent.mm.ui.tools.j.a(this.pby, new AnimatorListener(this) {
                final /* synthetic */ SnsTranslateResultView qJv;

                public final void onAnimationStart(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    if (bVar != null) {
                        ao.a(bVar);
                    }
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
        }
        if (bg.mA(str2)) {
            this.qJo.setText(j.dVL);
        } else {
            this.qJo.setText(str2);
        }
        this.qJo.setVisibility(0);
    }
}
