package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.voiceprint.ui.a.a;
import com.tencent.mm.sdk.platformtools.w;

public class VoiceTipInfoView extends LinearLayout {
    TextView jhl;
    public ProgressBar kYg;
    TextView rdG;
    boolean reg = false;
    private boolean reh = false;
    private TextView rei;
    private boolean rej = false;
    private float rek = 0.0f;

    public VoiceTipInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = LayoutInflater.from(context).inflate(R.i.dpJ, this, true);
        this.kYg = (ProgressBar) inflate.findViewById(R.h.cbI);
        boQ();
        this.jhl = (TextView) inflate.findViewById(R.h.cNi);
        this.rdG = (TextView) inflate.findViewById(R.h.cNk);
        this.rei = (TextView) inflate.findViewById(R.h.cNj);
        reset();
    }

    public final void reset() {
        this.rdG.setTextSize(0, getContext().getResources().getDimension(R.f.bbu));
        this.rek = this.rdG.getTextSize();
        this.rdG.clearAnimation();
        w.d("MicroMsg.VoiceTipInfoView", "mTipSize %f", new Object[]{Float.valueOf(this.rek)});
    }

    public final void boP() {
        w.d("MicroMsg.VoiceTipInfoView", "mProgressBar show");
        this.kYg.setVisibility(0);
    }

    public final void boQ() {
        w.d("MicroMsg.VoiceTipInfoView", "mProgressBar hide");
        this.kYg.setVisibility(8);
    }

    public final void HB(String str) {
        this.rdG.setText(str);
        this.rdG.setVisibility(0);
    }

    public final void uH(int i) {
        this.jhl.setText(i);
        this.jhl.setVisibility(0);
    }

    public final void boR() {
        w.d("MicroMsg.VoiceTipInfoView", "showTitle, titleTv.getVisibility:%d, mAnimingTitle:%b", new Object[]{Integer.valueOf(this.jhl.getVisibility()), Boolean.valueOf(this.reg)});
        if ((this.jhl.getVisibility() == 4 || this.jhl.getVisibility() == 8) && !this.reg) {
            this.jhl.clearAnimation();
            this.reg = true;
            View view = this.jhl;
            Context context = getContext();
            a anonymousClass2 = new a(this) {
                final /* synthetic */ VoiceTipInfoView rel;

                {
                    this.rel = r1;
                }

                public final void boH() {
                }

                public final void boI() {
                    this.rel.jhl.setVisibility(0);
                    this.rel.reg = false;
                }
            };
            Animation loadAnimation = AnimationUtils.loadAnimation(context, R.a.aQX);
            loadAnimation.setDuration(300);
            loadAnimation.setFillAfter(true);
            loadAnimation.setRepeatCount(0);
            loadAnimation.setAnimationListener(new com.tencent.mm.plugin.voiceprint.ui.a.AnonymousClass4(anonymousClass2));
            view.startAnimation(loadAnimation);
            return;
        }
        w.d("MicroMsg.VoiceTipInfoView", "showTitle, directly set to VISIBLE");
        this.jhl.clearAnimation();
        this.jhl.setVisibility(0);
        this.jhl.invalidate();
    }

    public final void boS() {
        this.rdG.setVisibility(8);
    }

    public final void boT() {
        if (this.rei.getVisibility() != 4 || this.rej) {
            this.rei.clearAnimation();
            this.rei.setVisibility(0);
            return;
        }
        this.rei.clearAnimation();
        this.rej = true;
        View view = this.rei;
        getContext();
        a anonymousClass4 = new a(this) {
            final /* synthetic */ VoiceTipInfoView rel;

            {
                this.rel = r1;
            }

            public final void boH() {
            }

            public final void boI() {
                this.rel.rei.setVisibility(0);
                this.rel.rej = false;
            }
        };
        Animation translateAnimation = new TranslateAnimation(1, -1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(200);
        translateAnimation.setFillAfter(true);
        translateAnimation.setRepeatCount(0);
        translateAnimation.setAnimationListener(new com.tencent.mm.plugin.voiceprint.ui.a.AnonymousClass5(anonymousClass4));
        view.startAnimation(translateAnimation);
    }

    public final void boU() {
        if (this.rei.getVisibility() != 0 || this.rej) {
            this.rei.clearAnimation();
            this.rei.setVisibility(4);
            return;
        }
        this.rei.clearAnimation();
        this.rej = true;
        a.a(this.rei, getContext(), new a(this) {
            final /* synthetic */ VoiceTipInfoView rel;

            {
                this.rel = r1;
            }

            public final void boH() {
            }

            public final void boI() {
                this.rel.rei.setVisibility(4);
                this.rel.rej = false;
            }
        });
    }

    public final void uI(int i) {
        this.rei.setText(i);
    }
}
