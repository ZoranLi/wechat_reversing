package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.smtt.sdk.WebView;

public class ThreeDotsLoadingView extends FrameLayout {
    private boolean AJ = false;
    private ViewGroup wxU;
    private ImageView wxV;
    private ImageView wxW;
    private ImageView wxX;

    public ThreeDotsLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ThreeDotsLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.wxU = (ViewGroup) LayoutInflater.from(context).inflate(h.hdW, this, true);
        this.wxV = (ImageView) this.wxU.findViewById(g.hcw);
        this.wxW = (ImageView) this.wxU.findViewById(g.hcx);
        this.wxX = (ImageView) this.wxU.findViewById(g.hcy);
        this.wxV.setImageDrawable(b(new float[]{0.1f, 0.4f, 0.2f, 0.1f}));
        this.wxW.setImageDrawable(b(new float[]{0.1f, 0.1f, 0.4f, 0.2f}));
        this.wxX.setImageDrawable(b(new float[]{0.1f, 0.2f, 0.1f, 0.4f}));
    }

    public void setVisibility(int i) {
        if (8 == i || 4 == i) {
            Wd();
        }
        super.setVisibility(i);
    }

    public final void caQ() {
        if (!this.AJ) {
            this.AJ = true;
            ((AnimationDrawable) this.wxV.getDrawable()).start();
            ((AnimationDrawable) this.wxW.getDrawable()).start();
            ((AnimationDrawable) this.wxX.getDrawable()).start();
        }
    }

    public final void Wd() {
        this.AJ = false;
        ((AnimationDrawable) this.wxV.getDrawable()).stop();
        ((AnimationDrawable) this.wxW.getDrawable()).stop();
        ((AnimationDrawable) this.wxX.getDrawable()).stop();
    }

    private static AnimationDrawable b(float[] fArr) {
        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.setOneShot(false);
        animationDrawable.addFrame(f(WebView.NIGHT_MODE_COLOR, fArr[0]), 0);
        animationDrawable.addFrame(f(WebView.NIGHT_MODE_COLOR, fArr[1]), e.CTRL_INDEX);
        animationDrawable.addFrame(f(WebView.NIGHT_MODE_COLOR, fArr[2]), e.CTRL_INDEX);
        animationDrawable.addFrame(f(WebView.NIGHT_MODE_COLOR, fArr[3]), e.CTRL_INDEX);
        return animationDrawable;
    }

    private static Drawable f(int i, float f) {
        Drawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.setIntrinsicHeight(32);
        shapeDrawable.setIntrinsicWidth(32);
        shapeDrawable.getPaint().setColor(WebView.NIGHT_MODE_COLOR);
        shapeDrawable.getPaint().setAlpha((int) (255.0f * f));
        return shapeDrawable;
    }
}
