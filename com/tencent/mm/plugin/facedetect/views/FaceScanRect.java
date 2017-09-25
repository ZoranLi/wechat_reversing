package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.facedetect.a.c;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.sdk.platformtools.w;

public class FaceScanRect extends RelativeLayout {
    public View lCU;
    private ImageView lCV;
    private ImageView lCW;
    private ImageView lCX;
    private ImageView lCY;
    private ImageView lCZ;
    private ImageView lDa;
    private ImageView lDb;
    private ImageView lDc;
    public ImageView[] lDd;
    private ScaleAnimation lDe;
    private ScaleAnimation lDf;
    private ScaleAnimation lDg;
    private ScaleAnimation lDh;
    public TranslateAnimation lDi;
    public b lDj;
    public ViewGroup lDk;
    public View lDl;
    public int lDm;

    private enum a {
        ;

        static {
            lDn = 1;
            lDo = 2;
            lDp = 3;
            lDq = new int[]{lDn, lDo, lDp};
        }
    }

    public interface b {
        void asx();
    }

    public FaceScanRect(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceScanRect(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lCU = null;
        this.lCV = null;
        this.lCW = null;
        this.lCX = null;
        this.lCY = null;
        this.lCZ = null;
        this.lDa = null;
        this.lDb = null;
        this.lDc = null;
        this.lDd = null;
        this.lDe = null;
        this.lDf = null;
        this.lDg = null;
        this.lDh = null;
        this.lDi = null;
        this.lDj = null;
        this.lDk = null;
        this.lDl = null;
        LayoutInflater.from(context).inflate(g.ltB, this, true);
        this.lCU = findViewById(e.lte);
        this.lCV = (ImageView) findViewById(e.ltc);
        this.lCW = (ImageView) findViewById(e.ltd);
        this.lCX = (ImageView) findViewById(e.lsZ);
        this.lCY = (ImageView) findViewById(e.lsY);
        this.lCZ = (ImageView) findViewById(e.ltb);
        this.lDa = (ImageView) findViewById(e.lta);
        this.lDb = (ImageView) findViewById(e.lsW);
        this.lDc = (ImageView) findViewById(e.lsX);
        this.lDl = findViewById(e.lsN);
        this.lDk = (ViewGroup) findViewById(e.lsK);
        this.lDd = new ImageView[]{this.lCV, this.lCW, this.lCX, this.lCY, this.lCZ, this.lDa, this.lDb, this.lDc};
        this.lDm = a.lDp;
        this.lDi = new TranslateAnimation(2, 0.0f, 2, 1.0f, 2, 0.0f, 2, 0.0f);
        this.lDi.setRepeatCount(-1);
        this.lDi.setRepeatMode(1);
        this.lDi.setDuration(1000);
    }

    public final void b(AnimationListener animationListener) {
        if (this.lDm == a.lDo) {
            w.w("MicroMsg.FaceScanRect", "hy: already closed");
            if (animationListener != null) {
                animationListener.onAnimationEnd(null);
                return;
            }
            return;
        }
        this.lDm = a.lDo;
        int width = getWidth();
        int height = getHeight();
        int dimensionPixelSize = getResources().getDimensionPixelSize(c.lsq);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(c.lsr);
        float f = ((float) (((width - (dimensionPixelSize * 2)) - (dimensionPixelSize2 * 2)) + dimensionPixelSize2)) / ((float) dimensionPixelSize2);
        float f2 = ((float) (((height - (dimensionPixelSize * 2)) - (dimensionPixelSize2 * 2)) + dimensionPixelSize2)) / ((float) dimensionPixelSize2);
        w.i("MicroMsg.FaceScanRect", "hy: horizontalScale : %f, verticalScale : %f", new Object[]{Float.valueOf(f), Float.valueOf(f2)});
        this.lDe = new ScaleAnimation(1.0f, f, 1.0f, 1.0f, 1, 0.0f, 1, 0.0f);
        this.lDe.setFillAfter(true);
        this.lDe.setDuration(1500);
        this.lDe.setInterpolator(getContext(), 17563654);
        this.lDe.setAnimationListener(animationListener);
        this.lDf = new ScaleAnimation(1.0f, f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.lDf.setFillAfter(true);
        this.lDf.setDuration(1500);
        this.lDf.setInterpolator(getContext(), 17563654);
        this.lDg = new ScaleAnimation(1.0f, 1.0f, 1.0f, f2, 1, 0.0f, 1, 0.0f);
        this.lDg.setFillAfter(true);
        this.lDg.setDuration(1500);
        this.lDg.setInterpolator(getContext(), 17563654);
        this.lDh = new ScaleAnimation(1.0f, 1.0f, 1.0f, f2, 1, 0.0f, 1, 1.0f);
        this.lDh.setFillAfter(true);
        this.lDh.setDuration(1500);
        this.lDh.setInterpolator(getContext(), 17563654);
        this.lCV.startAnimation(this.lDe);
        this.lCY.startAnimation(this.lDh);
        this.lCZ.startAnimation(this.lDg);
        this.lDc.startAnimation(this.lDf);
        this.lDl.setVisibility(8);
        this.lCU.setBackground(null);
        this.lDl.clearAnimation();
        for (ImageView backgroundColor : this.lDd) {
            backgroundColor.setBackgroundColor(getResources().getColor(com.tencent.mm.plugin.facedetect.a.b.lsm));
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.lDj != null) {
            this.lDj.asx();
        }
    }
}
