package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.location.model.f;
import com.tencent.mm.pluginsdk.ui.a.b;

public class TrackPoint extends LinearLayout {
    private ImageView hBi;
    public double iSP = -1.0d;
    public double iSQ = -1.0d;
    public double iSR = -1.0d;
    public double iSS = -1.0d;
    private Context mContext;
    public ImageView niJ;
    public ImageView niK;
    public View niL;
    private double niM = 0.0d;
    private String username;
    public boolean visible = true;

    public TrackPoint(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    public TrackPoint(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        View inflate = View.inflate(this.mContext, R.i.dph, this);
        this.hBi = (ImageView) inflate.findViewById(R.h.cJz);
        this.niJ = (ImageView) inflate.findViewById(R.h.cJB);
        this.niK = (ImageView) inflate.findViewById(R.h.cJA);
        this.niK.setVisibility(4);
        this.niL = inflate.findViewById(R.h.cJy);
        this.hBi.setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ TrackPoint niN;

            {
                this.niN = r1;
            }

            public final boolean onLongClick(View view) {
                if (this.niN.niL.getVisibility() == 0) {
                    this.niN.niL.setVisibility(4);
                } else {
                    this.niN.niL.setVisibility(0);
                }
                return false;
            }
        });
        this.niJ.requestFocus();
    }

    public final void b(OnClickListener onClickListener) {
        this.niJ.setOnClickListener(onClickListener);
    }

    public final void c(OnClickListener onClickListener) {
        this.hBi.setOnClickListener(onClickListener);
    }

    public final void zH(String str) {
        this.username = str;
        this.niJ.setTag(str);
        b.m(this.hBi, str);
        this.hBi.setTag(str);
    }

    public final void aHz() {
        this.visible = false;
        this.niL.setVisibility(4);
    }

    public final void aHA() {
        this.visible = true;
        this.niL.setVisibility(0);
    }

    public final void i(double d) {
        float f = (float) this.niM;
        float f2 = (float) d;
        Animation rotateAnimation = new RotateAnimation(f.s(f, f2), f.r(f, f2), 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(200);
        rotateAnimation.setFillAfter(true);
        this.niJ.startAnimation(rotateAnimation);
        this.niM = d;
    }

    public final void aHB() {
        this.niK.setVisibility(4);
    }
}
