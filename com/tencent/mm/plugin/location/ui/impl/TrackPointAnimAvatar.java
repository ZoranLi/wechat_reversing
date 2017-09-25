package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mm.R;

public class TrackPointAnimAvatar extends RelativeLayout {
    private ImageView hBi;
    private Context mContext;
    private LinearLayout niO;
    private Animation niP;
    private Animation niQ;

    public TrackPointAnimAvatar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    public TrackPointAnimAvatar(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        View inflate = View.inflate(this.mContext, R.i.dpi, this);
        this.niO = (LinearLayout) inflate.findViewById(R.h.boH);
        this.hBi = (ImageView) inflate.findViewById(R.h.boG);
        this.niP = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -0.5f);
        this.niP.setDuration(500);
        this.niP.setFillAfter(true);
        this.niQ = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -0.5f, 1, 0.0f);
        this.niQ.setDuration(500);
        this.niQ.setFillAfter(true);
        this.niP.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ TrackPointAnimAvatar niR;

            {
                this.niR = r1;
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                this.niR.bringToFront();
                this.niR.niO.startAnimation(this.niR.niQ);
            }
        });
        this.niQ.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ TrackPointAnimAvatar niR;

            {
                this.niR = r1;
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                this.niR.bringToFront();
                this.niR.niO.startAnimation(this.niR.niP);
            }
        });
    }
}
