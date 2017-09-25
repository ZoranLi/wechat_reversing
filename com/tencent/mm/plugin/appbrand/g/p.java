package com.tencent.mm.plugin.appbrand.g;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;

public final class p extends o {
    a jdJ;
    b jdK;
    private boolean jdL;
    private LinearLayout jdM;
    TextView jdN;
    private View jdO;
    ImageView jdP;
    ImageView jdQ;
    ImageView jdR;
    private long jdS;

    public interface a {
        void VU();
    }

    public interface b {
        void id(int i);
    }

    public p(Context context, r rVar) {
        super(context);
        this.jdL = false;
        this.jdS = 0;
        rVar.wwU = this;
        rVar.caI();
        this.jdM = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.i.cUl, this, false);
        View view = this.jdM;
        this.jdw = view;
        this.jdx = new FrameLayout(getContext());
        this.jdx.setLayoutParams(new LayoutParams(-1, -1));
        this.jdx.addView(view);
        this.Ih = rVar;
        this.jdy = new FrameLayout(getContext());
        this.jdy.setLayoutParams(new LayoutParams(-1, -1));
        this.jdy.addView(rVar);
        addView(this.jdx);
        addView(this.jdy);
        this.jdN = (TextView) findViewById(R.h.bps);
        this.jdO = findViewById(R.h.bpo);
        this.jdP = (ImageView) findViewById(R.h.bpp);
        this.jdQ = (ImageView) findViewById(R.h.bpq);
        this.jdR = (ImageView) findViewById(R.h.bpr);
    }

    protected final void VY() {
        ((AnimationDrawable) this.jdP.getDrawable()).start();
        ((AnimationDrawable) this.jdQ.getDrawable()).start();
        ((AnimationDrawable) this.jdR.getDrawable()).start();
        if (this.jdJ != null) {
            this.jdJ.VU();
        }
        this.jdS = System.currentTimeMillis();
    }

    protected final void VZ() {
        Wd();
    }

    protected final void ie(int i) {
        if (this.jdK != null) {
            this.jdK.id(i);
        }
        if (this.jdL) {
            if (i > this.jdM.getHeight()) {
                i = this.jdM.getHeight();
            }
            this.jdM.setTranslationY((float) (i - this.jdM.getHeight()));
        }
    }

    public final void Wc() {
        long currentTimeMillis = System.currentTimeMillis() - this.jdS;
        if (currentTimeMillis < 1000) {
            postDelayed(new Runnable(this) {
                final /* synthetic */ p jdT;

                {
                    this.jdT = r1;
                }

                public final void run() {
                    this.jdT.VX();
                }
            }, 1000 - currentTimeMillis);
        } else {
            VX();
        }
    }

    protected final int Wb() {
        return this.jdM.getHeight();
    }

    public final void ca(boolean z) {
        this.jdL = z;
        this.jdA = z;
        this.jdO.setVisibility(z ? 0 : 4);
    }

    public final void Wd() {
        ((AnimationDrawable) this.jdP.getDrawable()).stop();
        ((AnimationDrawable) this.jdP.getDrawable()).selectDrawable(0);
        ((AnimationDrawable) this.jdQ.getDrawable()).stop();
        ((AnimationDrawable) this.jdQ.getDrawable()).selectDrawable(0);
        ((AnimationDrawable) this.jdR.getDrawable()).stop();
        ((AnimationDrawable) this.jdR.getDrawable()).selectDrawable(0);
    }

    static AnimationDrawable a(int i, float[] fArr) {
        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.setOneShot(false);
        animationDrawable.addFrame(f(i, fArr[0]), 0);
        animationDrawable.addFrame(f(i, fArr[1]), e.CTRL_INDEX);
        animationDrawable.addFrame(f(i, fArr[2]), e.CTRL_INDEX);
        animationDrawable.addFrame(f(i, fArr[3]), e.CTRL_INDEX);
        return animationDrawable;
    }

    private static Drawable f(int i, float f) {
        Drawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.setIntrinsicHeight(32);
        shapeDrawable.setIntrinsicWidth(32);
        shapeDrawable.getPaint().setColor(i);
        shapeDrawable.getPaint().setAlpha((int) (255.0f * f));
        return shapeDrawable;
    }
}
