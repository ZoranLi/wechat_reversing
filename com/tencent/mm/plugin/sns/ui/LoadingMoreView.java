package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;

public class LoadingMoreView extends LinearLayout {
    private Context context;
    private ImageView fMY;
    protected LinearLayout kiA;
    protected LinearLayout kiz;
    protected LinearLayout quA;
    protected LinearLayout quB;
    protected TextView quC;

    public LoadingMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    public LoadingMoreView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    private void init() {
        View inflate = LayoutInflater.from(this.context).inflate(g.pHP, this, true);
        this.fMY = (ImageView) findViewById(f.boj);
        this.kiz = (LinearLayout) inflate.findViewById(f.cbN);
        this.kiA = (LinearLayout) inflate.findViewById(f.cbL);
        this.quA = (LinearLayout) inflate.findViewById(f.pGb);
        this.quB = (LinearLayout) inflate.findViewById(f.pDz);
        this.quC = (TextView) inflate.findViewById(f.pDA);
        this.kiz.setVisibility(0);
        this.kiA.setVisibility(8);
        this.quA.setVisibility(8);
        this.quB.setVisibility(8);
        Animation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        this.fMY.startAnimation(rotateAnimation);
    }

    public final void hG(boolean z) {
        this.kiz.setVisibility(8);
        if (z) {
            this.quA.setVisibility(0);
            this.kiA.setVisibility(8);
        } else {
            this.kiA.setVisibility(0);
            this.quA.setVisibility(8);
        }
        this.quB.setVisibility(8);
    }

    public final void tO(int i) {
        this.kiz.setVisibility(8);
        this.quA.setVisibility(8);
        this.kiA.setVisibility(8);
        this.quB.setVisibility(0);
        if (i == MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN) {
            this.quC.setText(getContext().getResources().getString(j.pMh));
        } else if (i == MMBitmapFactory.ERROR_ILLEGAL_IDATA_CHUNK) {
            this.quC.setText(getContext().getResources().getString(j.pKy));
        } else if (i == 2004) {
            this.quC.setText(getContext().getResources().getString(j.pMi));
        }
    }
}
