package com.tencent.mm.plugin.appbrand.g;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.sdk.WebView;

public class o extends FrameLayout {
    View Ih;
    private int iE;
    boolean jdA = false;
    private boolean jdB = false;
    private boolean jdC = false;
    private boolean jdD = false;
    private int jdE;
    private int jdF;
    private int jdG;
    private ObjectAnimator jdH = null;
    View jdw;
    FrameLayout jdx;
    FrameLayout jdy;
    public boolean jdz = true;

    public o(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(-1, -1));
        this.iE = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public final void cb(boolean z) {
        this.jdz = !z;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.jdz) {
            return this.jdD;
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            return false;
        }
        if (this.jdC) {
            return true;
        }
        switch (action) {
            case 0:
                if (Wa()) {
                    this.jdE = (int) motionEvent.getX();
                    this.jdF = (int) motionEvent.getY();
                    this.jdG = (int) motionEvent.getY();
                    break;
                }
                break;
            case 2:
                if (Wa()) {
                    action = ((int) motionEvent.getX()) - this.jdE;
                    int y = ((int) motionEvent.getY()) - this.jdF;
                    if (Math.abs(y) > this.iE && Math.abs(y) > Math.abs(action) && y > 0) {
                        this.jdC = true;
                        return true;
                    }
                }
                break;
        }
        return false;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jdz) {
            if (this.jdD) {
                VX();
            }
            return this.jdD;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.jdG = (int) motionEvent.getY();
                return true;
            case 1:
            case 3:
                if (this.jdy.getTranslationY() <= ((float) this.jdw.getHeight()) || !this.jdA) {
                    VX();
                } else {
                    VW();
                }
                return true;
            case 2:
                int y = (((int) motionEvent.getY()) - this.jdG) >> 1;
                int height = getHeight();
                if (y <= height) {
                    height = y;
                }
                if (this.jdB) {
                    height += Wb();
                }
                height = Math.max(height, 0);
                w.d("MicroMsg.AppBrandPullDownView", "real diff: %d, calc diff: %d", new Object[]{Integer.valueOf(r4), Integer.valueOf(height)});
                this.jdy.setTranslationY((float) Math.min(getHeight(), height));
                ie(height);
                return true;
            default:
                return false;
        }
    }

    protected final void VW() {
        ig(Wb());
        if (!this.jdB) {
            VY();
        }
        this.jdC = true;
        this.jdB = true;
        this.jdD = true;
    }

    protected final void VX() {
        ig(0);
        if (this.jdB) {
            VZ();
        }
        this.jdC = false;
        this.jdB = false;
        this.jdD = false;
    }

    protected void VY() {
    }

    protected void VZ() {
    }

    protected void ie(int i) {
    }

    public final void if(int i) {
        this.jdx.setBackgroundColor(i);
    }

    private boolean Wa() {
        if (!(this.Ih instanceof WebView)) {
            return this.Ih.getScrollY() == 0;
        } else {
            if (((WebView) this.Ih).getView().getScrollY() == 0) {
                return true;
            }
            return false;
        }
    }

    protected int Wb() {
        return this.jdw.getHeight();
    }

    private void ig(int i) {
        int translationY = (int) this.jdy.getTranslationY();
        if (translationY != i) {
            w.i("MicroMsg.AppBrandPullDownView", "fastScrollTo from = %s, to = %s", new Object[]{Integer.valueOf(translationY), Integer.valueOf(i)});
            if (this.jdH != null) {
                this.jdH.cancel();
            }
            long abs = (long) ((((float) Math.abs(translationY - i)) / ((float) Wb())) * 250.0f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.jdy, "translationY", new float[]{(float) translationY, (float) i});
            ofFloat.setDuration(Math.min(abs, 250));
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.start();
            ofFloat.addUpdateListener(new AnimatorUpdateListener(this) {
                final /* synthetic */ o jdI;

                {
                    this.jdI = r1;
                }

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.jdI.ie((int) ((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            this.jdH = ofFloat;
        }
    }
}
