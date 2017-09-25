package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bg.a;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;

public class AnimImageView extends TextView {
    private boolean aJi = false;
    private Context context;
    private AlphaAnimation oPI;
    private AnimationDrawable oPJ;
    private int type = 1;
    public boolean vgp = false;
    private AnimationDrawable vgq;

    public final void setType(int i) {
        this.type = i;
        if (this.vgp) {
            if (i == 2) {
                setBackgroundResource(R.e.aTc);
            } else {
                setBackgroundDrawable(a.a(this.context, R.g.bdT));
            }
        } else if (i == 2) {
            setBackgroundResource(R.e.aTd);
        } else {
            setBackgroundDrawable(a.a(this.context, R.g.bej));
        }
    }

    public final void bRB() {
        switch (this.type) {
            case 0:
                if (this.vgp) {
                    setBackgroundDrawable(a.a(this.context, R.g.bdT));
                } else {
                    setBackgroundDrawable(a.a(this.context, R.g.bej));
                }
                setAnimation(this.oPI);
                this.oPI.startNow();
                return;
            case 1:
                break;
            case 2:
                if (!this.vgp) {
                    setBackgroundResource(R.e.aTd);
                    break;
                } else {
                    setBackgroundResource(R.e.aTc);
                    break;
                }
            default:
                return;
        }
        if (!this.aJi) {
            this.aJi = true;
            if (this.vgp) {
                setCompoundDrawablesWithIntrinsicBounds(this.oPJ, null, null, null);
                this.oPJ.stop();
                this.oPJ.start();
                return;
            }
            setCompoundDrawablesWithIntrinsicBounds(null, null, this.vgq, null);
            this.vgq.stop();
            this.vgq.start();
        }
    }

    public final void aWX() {
        if (this.oPI != null && this.oPI.isInitialized()) {
            setAnimation(null);
        }
        if (this.type == 1 || this.type == 2) {
            this.aJi = false;
            setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            this.oPJ.stop();
            this.vgq.stop();
        }
    }

    public AnimImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        aWW();
    }

    public AnimImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        aWW();
    }

    private void aWW() {
        this.oPI = new AlphaAnimation(0.1f, 1.0f);
        this.oPI.setDuration(1000);
        this.oPI.setRepeatCount(-1);
        this.oPI.setRepeatMode(2);
        this.oPJ = new AnimationDrawable();
        Drawable drawable = getResources().getDrawable(R.k.dvA);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.oPJ.addFrame(drawable, e.CTRL_INDEX);
        drawable = getResources().getDrawable(R.k.dvB);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.oPJ.addFrame(drawable, e.CTRL_INDEX);
        drawable = getResources().getDrawable(R.k.dvC);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.oPJ.addFrame(drawable, e.CTRL_INDEX);
        this.oPJ.setOneShot(false);
        this.oPJ.setVisible(true, true);
        this.vgq = new AnimationDrawable();
        drawable = getResources().getDrawable(R.k.dvK);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.vgq.addFrame(drawable, e.CTRL_INDEX);
        drawable = getResources().getDrawable(R.k.dvL);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.vgq.addFrame(drawable, e.CTRL_INDEX);
        drawable = getResources().getDrawable(R.k.dvM);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.vgq.addFrame(drawable, e.CTRL_INDEX);
        this.vgq.setOneShot(false);
        this.vgq.setVisible(true, true);
    }

    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (Throwable th) {
        }
    }

    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Throwable th) {
        }
    }

    public int getBaseline() {
        try {
            return super.getBaseline();
        } catch (Throwable th) {
            return -1;
        }
    }

    public boolean onPreDraw() {
        try {
            return super.onPreDraw();
        } catch (Throwable th) {
            return true;
        }
    }
}
