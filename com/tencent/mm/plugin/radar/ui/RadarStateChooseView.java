package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.radar.a.e.a;

public class RadarStateChooseView extends RelativeLayout {
    boolean oIl = false;
    Animation oIm = null;
    Animation oIn = null;
    boolean oIo = true;
    public a oIp = a.UnSelected;

    public RadarStateChooseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RadarStateChooseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    final void init() {
        if (this.oIm == null) {
            this.oIm = AnimationUtils.loadAnimation(getContext(), R.a.aRu);
            this.oIm.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ RadarStateChooseView oIq;

                {
                    this.oIq = r1;
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
        }
        if (this.oIn == null) {
            this.oIn = AnimationUtils.loadAnimation(getContext(), R.a.aRt);
            this.oIn.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ RadarStateChooseView oIq;

                {
                    this.oIq = r1;
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    this.oIq.oIl = false;
                    this.oIq.setVisibility(8);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    final void aVO() {
        switch (this.oIp) {
            case UnSelected:
                setVisibility(4);
                return;
            case Selected:
                setBackgroundResource(R.k.dzc);
                setVisibility(0);
                return;
            default:
                setVisibility(4);
                return;
        }
    }
}
