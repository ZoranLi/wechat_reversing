package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import java.util.ArrayList;
import java.util.List;

public class ShuffleView extends FrameLayout {
    public static DisplayMetrics ihQ;
    private boolean nlA;
    private int nlB = getResources().getDimensionPixelSize(R.f.bap);
    private int nlC = 2500;
    GestureDetector nlD = new GestureDetector(new OnGestureListener(this) {
        final /* synthetic */ ShuffleView nlE;

        {
            this.nlE = r1;
        }

        public final boolean onDown(MotionEvent motionEvent) {
            w.d("ShuffleView", "gesture down");
            switch (this.nlE.nlf.nlJ) {
                case 4:
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    int i = 0;
                    while (i < this.nlE.nls) {
                        Rect a = this.nlE.oP(i);
                        if (a == null || !a.contains(x, y)) {
                            i++;
                        } else {
                            View view = (View) this.nlE.nle.get(i);
                            if (this.nlE.nlo != view && this.nlE.nlo != null) {
                                this.nlE.aHQ();
                            } else if (this.nlE.nlo == view) {
                                w.i("ShuffleView", "down on the select card");
                                return true;
                            }
                            ShuffleView.b(this.nlE, i);
                            return true;
                        }
                    }
                    return false;
                default:
                    return false;
            }
        }

        public final void onShowPress(MotionEvent motionEvent) {
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            switch (this.nlE.nlf.nlJ) {
                case 4:
                    if (this.nlE.nlo != null) {
                        w.d("ShuffleView", "click the select card");
                        if (this.nlE.nll != null) {
                            this.nlE.nll.cm(this.nlE.nlp, this.nlE.nls);
                        }
                        this.nlE.aHQ();
                    }
                    if (this.nlE.nlq != null) {
                        if (this.nlE.nll != null) {
                            this.nlE.nll.oK(this.nlE.nls);
                        }
                        this.nlE.oO(this.nlE.nlr);
                    }
                    return true;
                default:
                    return false;
            }
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (motionEvent2.getActionMasked() == 2) {
                int x = (int) motionEvent2.getX();
                int y = (int) motionEvent2.getY();
                switch (this.nlE.nlf.nlJ) {
                    case 4:
                        View view;
                        if (Math.abs(f2) < ((float) this.nlE.nlB)) {
                            for (int i = 0; i < this.nlE.nls; i++) {
                                Rect a = this.nlE.oP(i);
                                if (a != null && a.contains(x, y)) {
                                    view = (View) this.nlE.nle.get(i);
                                    if (this.nlE.nlo != view && this.nlE.nlo != null) {
                                        this.nlE.aHQ();
                                    } else if (this.nlE.nlo == view) {
                                        w.i("ShuffleView", "scroll on the select card");
                                    }
                                    if (this.nlE.nlq != view) {
                                        this.nlE.aHR();
                                        ShuffleView.b(this.nlE, i);
                                    }
                                }
                            }
                        }
                        if (Math.abs(f) < ((float) this.nlE.nlB)) {
                            w.d("ShuffleView", "scroll distanceY:" + f2);
                            if (this.nlE.nlq != null) {
                                view = this.nlE.nlq;
                            } else if (this.nlE.nlo != null) {
                                view = this.nlE.nlo;
                            } else {
                                view = null;
                            }
                            if (view != null) {
                                w.i("ShuffleView", "scroll translationY:" + view.getTranslationY() + "," + (view.getHeight() / 7));
                                if (((int) view.getTranslationY()) > (-view.getHeight()) / 7) {
                                    if (view.getTranslationY() != 0.0f) {
                                        if (f2 >= 0.0f) {
                                            if (((int) (view.getTranslationY() - f2)) > (-view.getHeight()) / 7) {
                                                view.setTranslationY(view.getTranslationY() - f2);
                                                break;
                                            }
                                            view.setTranslationY((float) ((-view.getHeight()) / 7));
                                            break;
                                        } else if (view.getTranslationY() - f2 < 0.0f) {
                                            view.setTranslationY(view.getTranslationY() - f2);
                                            break;
                                        } else {
                                            view.setTranslationY(0.0f);
                                            break;
                                        }
                                    } else if (f2 > 0.0f && Math.abs(f2) > ((float) this.nlE.nlB)) {
                                        if (((int) f2) < view.getHeight() / 7) {
                                            view.setTranslationY(view.getTranslationY() - f2);
                                            break;
                                        }
                                        view.setTranslationY((float) ((-view.getHeight()) / 7));
                                        break;
                                    }
                                } else if (f2 < 0.0f && Math.abs(f2) > ((float) this.nlE.nlB)) {
                                    if (((int) f2) <= (-view.getHeight()) / 7) {
                                        view.setTranslationY(0.0f);
                                    } else {
                                        view.setTranslationY(view.getTranslationY() - f2);
                                    }
                                    if (view == this.nlE.nlo) {
                                        this.nlE.nlq = this.nlE.nlo;
                                        this.nlE.nlr = this.nlE.nlp;
                                        if (this.nlE.nlj.isStarted()) {
                                            w.i("ShuffleView", "scroll when select view is animation");
                                            this.nlE.nlj.cancel();
                                        }
                                        this.nlE.nlo = null;
                                        this.nlE.nlp = 0;
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                }
            }
            return false;
        }

        public final void onLongPress(MotionEvent motionEvent) {
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            w.i("ShuffleView", "fling up " + f2);
            if (f2 >= ((float) (-this.nlE.nlC))) {
                return false;
            }
            switch (this.nlE.nlf.nlJ) {
                case 4:
                    if (this.nlE.nlo != null) {
                        this.nlE.aHQ();
                    }
                    if (this.nlE.nlq != null) {
                        if (this.nlE.nll != null) {
                            this.nlE.nll.oK(this.nlE.nls);
                        }
                        this.nlE.oO(this.nlE.nlr);
                        break;
                    }
                    break;
            }
            return true;
        }
    });
    List<View> nle = new ArrayList();
    c nlf = new c();
    ValueAnimator nlg;
    private ValueAnimator nlh;
    ValueAnimator nli;
    ValueAnimator nlj;
    a nlk;
    b nll;
    View nlm;
    private View nln;
    View nlo;
    int nlp;
    View nlq;
    int nlr;
    int nls;
    private float nlt;
    private float nlu;
    private final float nlv = 0.23f;
    private final float nlw = 0.28f;
    private final float nlx = 0.33f;
    private ArrayList<Float> nly = new ArrayList();
    private ArrayList<Float> nlz = new ArrayList();

    interface a {
        void a(ValueAnimator valueAnimator, View view);
    }

    interface b {
        void cl(int i, int i2);

        void cm(int i, int i2);

        void oK(int i);
    }

    static class c {
        public int nlI = 1;
        public int nlJ = 1;
        public int nlK = 2;
        public float nlL = 0.01f;
        public float nlM = 0.01f;
        public int nlN = m.CTRL_INDEX;
        public int nlO = 80;

        c() {
        }
    }

    static /* synthetic */ void b(ShuffleView shuffleView, int i) {
        if (i >= 0 && i < shuffleView.nls) {
            w.i("ShuffleView", "touch card " + i);
            if (shuffleView.nlj.isStarted()) {
                shuffleView.nlj.cancel();
            }
            shuffleView.nlj.removeAllUpdateListeners();
            shuffleView.nlj.removeAllListeners();
            shuffleView.nlq = (View) shuffleView.nle.get(i);
            shuffleView.nlr = i;
            switch (shuffleView.nlf.nlJ) {
                case 4:
                    if (i > 0) {
                        final int i2 = i - 1;
                        final int i3 = (shuffleView.nls - 1) - i;
                        shuffleView.nlj.addUpdateListener(new AnimatorUpdateListener(shuffleView) {
                            final /* synthetic */ ShuffleView nlE;

                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                int i = 0;
                                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                if (floatValue == 0.0f) {
                                    this.nlE.nly.clear();
                                    this.nlE.nlz.clear();
                                    while (i < this.nlE.nls) {
                                        this.nlE.nly.add(Float.valueOf(((View) this.nlE.nle.get(i)).getTranslationX()));
                                        this.nlE.nlz.add(Float.valueOf(((View) this.nlE.nle.get(i)).getTranslationY()));
                                        i++;
                                    }
                                    return;
                                }
                                int i2;
                                if (i2 > 0) {
                                    for (i2 = 0; i2 < this.nlE.nlr - 1; i2++) {
                                        ((View) this.nlE.nle.get(i2)).setTranslationX((((Float) this.nlE.nly.get(i2)).floatValue() * (1.0f - floatValue)) + ((this.nlE.oM(i2) - (((float) (i2 + 1)) * ShuffleView.j(this.nlE))) * floatValue));
                                        ((View) this.nlE.nle.get(i2)).setTranslationY((((Float) this.nlE.nlz.get(i2)).floatValue() * (1.0f - floatValue)) + (this.nlE.oN(i2) * floatValue));
                                    }
                                    ((View) this.nlE.nle.get(this.nlE.nlr - 1)).setTranslationX((((Float) this.nlE.nly.get(this.nlE.nlr - 1)).floatValue() * (1.0f - floatValue)) + ((this.nlE.oM(this.nlE.nlr - 1) - ((ShuffleView.j(this.nlE) * ((float) i2)) / 2.0f)) * floatValue));
                                } else {
                                    for (i2 = 0; i2 < this.nlE.nlr; i2++) {
                                        ((View) this.nlE.nle.get(i2)).setTranslationX((((Float) this.nlE.nly.get(i2)).floatValue() * (1.0f - floatValue)) + (this.nlE.oM(i2) * floatValue));
                                        ((View) this.nlE.nle.get(i2)).setTranslationY((((Float) this.nlE.nlz.get(i2)).floatValue() * (1.0f - floatValue)) + (this.nlE.oN(i2) * floatValue));
                                    }
                                }
                                if (i3 > 0) {
                                    this.nlE.nlq.setTranslationX((((Float) this.nlE.nly.get(this.nlE.nlr)).floatValue() * (1.0f - floatValue)) + ((this.nlE.oM(this.nlE.nlr) + ((ShuffleView.j(this.nlE) * ((float) i3)) / 2.0f)) * floatValue));
                                    this.nlE.nlq.setTranslationY((((Float) this.nlE.nlz.get(this.nlE.nlr)).floatValue() * (1.0f - floatValue)) + (this.nlE.oN(this.nlE.nlr) * floatValue));
                                    for (i2 = this.nlE.nlr + 1; i2 < this.nlE.nls; i2++) {
                                        ((View) this.nlE.nle.get(i2)).setTranslationX((((Float) this.nlE.nly.get(i2)).floatValue() * (1.0f - floatValue)) + ((this.nlE.oM(i2) + (((float) (this.nlE.nls - i2)) * ShuffleView.j(this.nlE))) * floatValue));
                                        ((View) this.nlE.nle.get(i2)).setTranslationY((((Float) this.nlE.nlz.get(i2)).floatValue() * (1.0f - floatValue)) + (this.nlE.oN(i2) * floatValue));
                                    }
                                    return;
                                }
                                for (i2 = this.nlE.nlr; i2 < this.nlE.nls; i2++) {
                                    ((View) this.nlE.nle.get(i2)).setTranslationX((((Float) this.nlE.nly.get(i2)).floatValue() * (1.0f - floatValue)) + (this.nlE.oM(i2) * floatValue));
                                    ((View) this.nlE.nle.get(i2)).setTranslationY((((Float) this.nlE.nlz.get(i2)).floatValue() * (1.0f - floatValue)) + (this.nlE.oN(i2) * floatValue));
                                }
                            }
                        });
                    } else {
                        shuffleView.nlj.addUpdateListener(new AnimatorUpdateListener(shuffleView) {
                            final /* synthetic */ ShuffleView nlE;

                            {
                                this.nlE = r1;
                            }

                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                if (floatValue == 0.0f) {
                                    this.nlE.nly.clear();
                                    this.nlE.nlz.clear();
                                    for (int i = 0; i < this.nlE.nls; i++) {
                                        this.nlE.nly.add(Float.valueOf(((View) this.nlE.nle.get(i)).getTranslationX()));
                                        this.nlE.nlz.add(Float.valueOf(((View) this.nlE.nle.get(i)).getTranslationY()));
                                    }
                                    return;
                                }
                                ((View) this.nlE.nle.get(0)).setTranslationX((((Float) this.nlE.nly.get(0)).floatValue() * (1.0f - floatValue)) + (this.nlE.oM(0) * floatValue));
                                ((View) this.nlE.nle.get(0)).setTranslationY((((Float) this.nlE.nlz.get(0)).floatValue() * (1.0f - floatValue)) + (this.nlE.oN(0) * floatValue));
                                for (int i2 = 1; i2 < this.nlE.nls; i2++) {
                                    ((View) this.nlE.nle.get(i2)).setTranslationX((((Float) this.nlE.nly.get(i2)).floatValue() * (1.0f - floatValue)) + (this.nlE.oM(i2) * floatValue));
                                    ((View) this.nlE.nle.get(i2)).setTranslationY((((Float) this.nlE.nlz.get(i2)).floatValue() * (1.0f - floatValue)) + (this.nlE.oN(i2) * floatValue));
                                }
                            }
                        });
                    }
                    if (shuffleView.nll != null) {
                        shuffleView.nll.cl(shuffleView.nlr, shuffleView.nls);
                        break;
                    }
                    break;
            }
            shuffleView.nlj.start();
        }
    }

    static /* synthetic */ float g(ShuffleView shuffleView) {
        if (shuffleView.nlo != null) {
            float width = (0.33f * ((float) shuffleView.nlo.getWidth())) - shuffleView.nlt;
            int i = shuffleView.nlp - 1;
            int i2 = (shuffleView.nls - 1) - shuffleView.nlp;
            int i3 = 0;
            if (i > 0) {
                i3 = i + 0;
            }
            if (i2 > 0) {
                i3 += i2;
            }
            if (i3 > 0) {
                return (width * 2.0f) / ((float) i3);
            }
        }
        return 0.0f;
    }

    static /* synthetic */ float j(ShuffleView shuffleView) {
        if (shuffleView.nlq != null) {
            float width = (0.28f * ((float) shuffleView.nlq.getWidth())) - shuffleView.nlt;
            int i = shuffleView.nlr - 1;
            int i2 = (shuffleView.nls - 1) - shuffleView.nlr;
            int i3 = 0;
            if (i > 0) {
                i3 = i + 0;
            }
            if (i2 > 0) {
                i3 += i2;
            }
            if (i3 > 0) {
                return (width * 2.0f) / ((float) i3);
            }
        }
        return 0.0f;
    }

    public ShuffleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void aHO() {
        if (this.nls > 1) {
            w.d("ShuffleView", "card width: %d,height: %d", new Object[]{Integer.valueOf(((View) this.nle.get(0)).getWidth()), Integer.valueOf(((View) this.nle.get(0)).getHeight())});
            if (this.nlf.nlI == 2) {
                this.nlt = (((float) ((View) this.nle.get(0)).getWidth()) * DownloadHelper.SAVE_FATOR) / ((float) this.nls);
                if (this.nlt > ((float) ((View) this.nle.get(0)).getWidth()) * 0.23f) {
                    this.nlt = ((float) ((View) this.nle.get(0)).getWidth()) * 0.23f;
                    return;
                }
                return;
            } else if (this.nlf.nlI == 1) {
                this.nlu = (((float) ((View) this.nle.get(0)).getHeight()) * 1.0f) / ((float) this.nls);
                return;
            } else {
                return;
            }
        }
        this.nlt = 0.0f;
        this.nlu = 0.0f;
    }

    final void y(View view, int i) {
        if (this.nlf.nlI == 1) {
            view.setScaleX(1.0f - (this.nlf.nlL * ((float) i)));
            view.setTranslationY(oN(i));
        } else if (this.nlf.nlI == 2) {
            view.setScaleY(1.0f - (this.nlf.nlM * ((float) i)));
            view.setTranslationX(oM(i));
        }
    }

    public final float oM(int i) {
        if (this.nlf.nlI == 2 && this.nls > 0) {
            if (this.nlf.nlJ == 3) {
                return ((((float) (this.nls - 1)) * 0.5f) * this.nlt) - (this.nlt * ((float) i));
            }
            if (this.nlf.nlJ == 4) {
                return (this.nlt * ((float) i)) - ((((float) (this.nls - 1)) * 0.5f) * this.nlt);
            }
        }
        return 0.0f;
    }

    public final float oN(int i) {
        if (this.nlf.nlI == 1) {
            if (this.nlf.nlJ == 1) {
                return ((((float) (this.nls - 1)) * 0.5f) * this.nlu) - (this.nlu * ((float) i));
            }
            if (this.nlf.nlJ == 2) {
                return (this.nlu * ((float) i)) - ((((float) (this.nls - 1)) * 0.5f) * this.nlu);
            }
        }
        return 0.0f;
    }

    final int aHP() {
        return (int) (Math.random() * ((double) this.nls));
    }

    private void aHQ() {
        if (this.nlo != null) {
            w.i("ShuffleView", "selectView != null, cancel select");
            if (this.nlj.isStarted()) {
                this.nlj.cancel();
            }
            this.nlj.removeAllUpdateListeners();
            this.nlj.removeAllListeners();
            switch (this.nlf.nlJ) {
                case 4:
                    if (this.nlp >= 0) {
                        this.nlj.addUpdateListener(new AnimatorUpdateListener(this) {
                            final /* synthetic */ ShuffleView nlE;

                            {
                                this.nlE = r1;
                            }

                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                int i = 0;
                                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                if (floatValue == 0.0f) {
                                    this.nlE.nly.clear();
                                    this.nlE.nlz.clear();
                                    while (i < this.nlE.nls) {
                                        this.nlE.nly.add(Float.valueOf(((View) this.nlE.nle.get(i)).getTranslationX()));
                                        this.nlE.nlz.add(Float.valueOf(((View) this.nlE.nle.get(i)).getTranslationY()));
                                        i++;
                                    }
                                    return;
                                }
                                for (int i2 = 0; i2 < this.nlE.nls; i2++) {
                                    ((View) this.nlE.nle.get(i2)).setTranslationX((((Float) this.nlE.nly.get(i2)).floatValue() * (1.0f - floatValue)) + (this.nlE.oM(i2) * floatValue));
                                    ((View) this.nlE.nle.get(i2)).setTranslationY((((Float) this.nlE.nlz.get(i2)).floatValue() * (1.0f - floatValue)) + (this.nlE.oN(i2) * floatValue));
                                }
                            }
                        });
                        break;
                    }
                    break;
            }
            this.nlo = null;
            this.nlp = 0;
            this.nlj.start();
        }
    }

    final void oO(int i) {
        if (i >= 0 && i < this.nls) {
            w.i("ShuffleView", "select card " + i);
            if (this.nlj.isStarted()) {
                this.nlj.cancel();
            }
            this.nlj.removeAllUpdateListeners();
            this.nlj.removeAllListeners();
            this.nlo = (View) this.nle.get(i);
            this.nlp = i;
            this.nlq = null;
            this.nlr = -1;
            switch (this.nlf.nlJ) {
                case 4:
                    if (i <= 0) {
                        this.nlj.addUpdateListener(new AnimatorUpdateListener(this) {
                            final /* synthetic */ ShuffleView nlE;

                            {
                                this.nlE = r1;
                            }

                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                int i = 0;
                                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                if (floatValue == 0.0f) {
                                    this.nlE.nly.clear();
                                    this.nlE.nlz.clear();
                                    while (i < this.nlE.nls) {
                                        this.nlE.nly.add(Float.valueOf(((View) this.nlE.nle.get(i)).getTranslationX()));
                                        this.nlE.nlz.add(Float.valueOf(((View) this.nlE.nle.get(i)).getTranslationY()));
                                        i++;
                                    }
                                    return;
                                }
                                this.nlE.nlo.setTranslationY((((Float) this.nlE.nlz.get(0)).floatValue() * (1.0f - floatValue)) - ((((float) this.nlE.nlo.getHeight()) * floatValue) / 7.0f));
                                for (int i2 = 1; i2 < this.nlE.nls; i2++) {
                                    ((View) this.nlE.nle.get(i2)).setTranslationX((((Float) this.nlE.nly.get(i2)).floatValue() * (1.0f - floatValue)) + (this.nlE.oM(i2) * floatValue));
                                    ((View) this.nlE.nle.get(i2)).setTranslationY((((Float) this.nlE.nlz.get(i2)).floatValue() * (1.0f - floatValue)) + (this.nlE.oN(i2) * floatValue));
                                }
                            }
                        });
                        break;
                    }
                    final int i2 = i - 1;
                    final int i3 = (this.nls - 1) - i;
                    this.nlj.addUpdateListener(new AnimatorUpdateListener(this) {
                        final /* synthetic */ ShuffleView nlE;

                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int i = 0;
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (floatValue == 0.0f) {
                                this.nlE.nly.clear();
                                this.nlE.nlz.clear();
                                while (i < this.nlE.nls) {
                                    this.nlE.nly.add(Float.valueOf(((View) this.nlE.nle.get(i)).getTranslationX()));
                                    this.nlE.nlz.add(Float.valueOf(((View) this.nlE.nle.get(i)).getTranslationY()));
                                    i++;
                                }
                                return;
                            }
                            int i2;
                            if (i2 > 0) {
                                for (i2 = 0; i2 < this.nlE.nlp - 1; i2++) {
                                    ((View) this.nlE.nle.get(i2)).setTranslationX((((Float) this.nlE.nly.get(i2)).floatValue() * (1.0f - floatValue)) + ((this.nlE.oM(i2) - (((float) (i2 + 1)) * ShuffleView.g(this.nlE))) * floatValue));
                                    ((View) this.nlE.nle.get(i2)).setTranslationY((((Float) this.nlE.nlz.get(i2)).floatValue() * (1.0f - floatValue)) + (this.nlE.oN(i2) * floatValue));
                                }
                                ((View) this.nlE.nle.get(this.nlE.nlp - 1)).setTranslationX((((Float) this.nlE.nly.get(this.nlE.nlp - 1)).floatValue() * (1.0f - floatValue)) + ((this.nlE.oM(this.nlE.nlp - 1) - ((ShuffleView.g(this.nlE) * ((float) i2)) / 2.0f)) * floatValue));
                                ((View) this.nlE.nle.get(this.nlE.nlp - 1)).setTranslationY((((Float) this.nlE.nlz.get(this.nlE.nlp - 1)).floatValue() * (1.0f - floatValue)) + (this.nlE.oN(this.nlE.nlp - 1) * floatValue));
                            } else {
                                for (i2 = 0; i2 < this.nlE.nlp; i2++) {
                                    ((View) this.nlE.nle.get(i2)).setTranslationX((((Float) this.nlE.nly.get(i2)).floatValue() * (1.0f - floatValue)) + (this.nlE.oM(i2) * floatValue));
                                    ((View) this.nlE.nle.get(i2)).setTranslationY((((Float) this.nlE.nlz.get(i2)).floatValue() * (1.0f - floatValue)) + (this.nlE.oN(i2) * floatValue));
                                }
                            }
                            if (i3 > 0) {
                                this.nlE.nlo.setTranslationX((((Float) this.nlE.nly.get(this.nlE.nlp)).floatValue() * (1.0f - floatValue)) + ((this.nlE.oM(this.nlE.nlp) + ((ShuffleView.g(this.nlE) * ((float) i3)) / 2.0f)) * floatValue));
                                for (i2 = this.nlE.nlp + 1; i2 < this.nlE.nls; i2++) {
                                    ((View) this.nlE.nle.get(i2)).setTranslationX((((Float) this.nlE.nly.get(i2)).floatValue() * (1.0f - floatValue)) + ((this.nlE.oM(i2) + (((float) (this.nlE.nls - i2)) * ShuffleView.g(this.nlE))) * floatValue));
                                    ((View) this.nlE.nle.get(i2)).setTranslationY((((Float) this.nlE.nlz.get(i2)).floatValue() * (1.0f - floatValue)) + (this.nlE.oN(i2) * floatValue));
                                }
                            } else {
                                for (i2 = this.nlE.nlp; i2 < this.nlE.nls; i2++) {
                                    ((View) this.nlE.nle.get(i2)).setTranslationX((((Float) this.nlE.nly.get(i2)).floatValue() * (1.0f - floatValue)) + (this.nlE.oM(i2) * floatValue));
                                    ((View) this.nlE.nle.get(i2)).setTranslationY((((Float) this.nlE.nlz.get(i2)).floatValue() * (1.0f - floatValue)) + (this.nlE.oN(i2) * floatValue));
                                }
                            }
                            this.nlE.nlo.setTranslationY((((Float) this.nlE.nlz.get(this.nlE.nlp)).floatValue() * (1.0f - floatValue)) - ((((float) this.nlE.nlo.getHeight()) * floatValue) / 7.0f));
                        }
                    });
                    break;
            }
            this.nlj.start();
        }
    }

    private void aHR() {
        if (this.nlq != null) {
            w.i("ShuffleView", "touchView != null,cancel touch");
            if (this.nlj.isStarted()) {
                this.nlj.cancel();
            }
            this.nlj.removeAllUpdateListeners();
            this.nlj.removeAllListeners();
            switch (this.nlf.nlJ) {
                case 4:
                    if (this.nlr >= 0) {
                        this.nlj.addUpdateListener(new AnimatorUpdateListener(this) {
                            final /* synthetic */ ShuffleView nlE;

                            {
                                this.nlE = r1;
                            }

                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                int i = 0;
                                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                if (floatValue == 0.0f) {
                                    this.nlE.nly.clear();
                                    this.nlE.nlz.clear();
                                    while (i < this.nlE.nls) {
                                        this.nlE.nly.add(Float.valueOf(((View) this.nlE.nle.get(i)).getTranslationX()));
                                        this.nlE.nlz.add(Float.valueOf(((View) this.nlE.nle.get(i)).getTranslationY()));
                                        i++;
                                    }
                                    return;
                                }
                                for (int i2 = 0; i2 < this.nlE.nls; i2++) {
                                    ((View) this.nlE.nle.get(i2)).setTranslationX((((Float) this.nlE.nly.get(i2)).floatValue() * (1.0f - floatValue)) + (this.nlE.oM(i2) * floatValue));
                                    ((View) this.nlE.nle.get(i2)).setTranslationY((((Float) this.nlE.nlz.get(i2)).floatValue() * (1.0f - floatValue)) + (this.nlE.oN(i2) * floatValue));
                                }
                            }
                        });
                        break;
                    }
                    break;
            }
            this.nlq = null;
            this.nlr = -1;
            this.nlj.start();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.nlA) {
            return true;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.nls <= 0) {
            return false;
        }
        w.d("ShuffleView", "y:%d,packet largest:%d", new Object[]{Integer.valueOf(y), Integer.valueOf((getHeight() - ((View) this.nle.get(0)).getHeight()) - (((View) this.nle.get(0)).getHeight() / 7))});
        if (y >= (getHeight() - ((View) this.nle.get(0)).getHeight()) - (((View) this.nle.get(0)).getHeight() / 7)) {
            int i;
            for (i = 0; i < this.nls; i++) {
                Rect oP = oP(i);
                if (oP != null && oP.contains(x, y)) {
                    i = 1;
                    break;
                }
            }
            boolean z = false;
            if (i == 0) {
                w.d("ShuffleView", "event %d out of cards,%d,%d", new Object[]{Integer.valueOf(motionEvent.getActionMasked()), Integer.valueOf(x), Integer.valueOf(y)});
                if (this.nlo != null && motionEvent.getActionMasked() == 0) {
                    if (this.nll != null) {
                        this.nll.cm(this.nlp, this.nls);
                    }
                    aHQ();
                } else if (this.nlq != null && this.nlq.getTranslationY() == ((float) ((-this.nlq.getHeight()) / 7))) {
                    if (this.nll != null) {
                        this.nll.oK(this.nls);
                    }
                    oO(this.nlr);
                } else if (this.nlq != null) {
                    aHR();
                }
            }
            if (this.nls <= 1) {
                return false;
            }
            w.i("ShuffleView", "ret:%s,action:%s", new Object[]{Boolean.valueOf(this.nlD.onTouchEvent(motionEvent)), Integer.valueOf(motionEvent.getActionMasked())});
            if (!this.nlD.onTouchEvent(motionEvent) && motionEvent.getActionMasked() == 1) {
                if (this.nlq != null && this.nlq.getTranslationY() == ((float) ((-this.nlq.getHeight()) / 7))) {
                    if (this.nll != null) {
                        this.nll.oK(this.nls);
                    }
                    oO(this.nlr);
                } else if (this.nlq != null) {
                    aHR();
                }
            }
            return true;
        } else if (this.nlo != null && motionEvent.getActionMasked() == 0) {
            if (this.nll != null) {
                this.nll.cm(this.nlp, this.nls);
            }
            aHQ();
            return false;
        } else if (this.nlq != null && this.nlq.getTranslationY() == ((float) ((-this.nlq.getHeight()) / 7))) {
            if (this.nll != null) {
                this.nll.oK(this.nls);
            }
            oO(this.nlr);
            return false;
        } else if (this.nlq == null) {
            return false;
        } else {
            aHR();
            return false;
        }
    }

    private Rect oP(int i) {
        if (i >= 0 && i < this.nls) {
            View view = (View) this.nle.get(i);
            switch (this.nlf.nlJ) {
                case 4:
                    if (i == 0) {
                        return new Rect(view.getLeft() + ((int) view.getTranslationX()), view.getTop() + ((int) view.getTranslationY()), view.getRight() + ((int) view.getTranslationX()), ((int) view.getTranslationY()) + view.getBottom());
                    }
                    View view2 = (View) this.nle.get(i - 1);
                    return new Rect(((int) view2.getTranslationX()) + view2.getRight(), view.getTop() + ((int) view.getTranslationY()), view.getRight() + ((int) view.getTranslationX()), ((int) view.getTranslationY()) + view.getBottom());
            }
        }
        return null;
    }

    final void oQ(final int i) {
        this.nli.removeAllUpdateListeners();
        this.nli.removeAllListeners();
        if (this.nle.size() < this.nls) {
            this.nls--;
            if (this.nls == 1) {
                ((View) this.nle.get(0)).findViewById(R.h.ceD).setVisibility(0);
            }
            aHO();
            this.nli.addUpdateListener(new AnimatorUpdateListener(this) {
                final /* synthetic */ ShuffleView nlE;

                {
                    this.nlE = r1;
                }

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int i = 0;
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue == 0.0f) {
                        this.nlE.nly.clear();
                        this.nlE.nlz.clear();
                        while (i < this.nlE.nls) {
                            this.nlE.nly.add(Float.valueOf(((View) this.nlE.nle.get(i)).getTranslationX()));
                            this.nlE.nlz.add(Float.valueOf(((View) this.nlE.nle.get(i)).getTranslationY()));
                            i++;
                        }
                        return;
                    }
                    for (int i2 = 0; i2 < this.nlE.nls; i2++) {
                        View view = (View) this.nlE.nle.get(i2);
                        if (this.nlE.nlf.nlI == 1) {
                            view.setScaleX((((Float) valueAnimator.getAnimatedValue()).floatValue() * this.nlE.nlf.nlL) + (1.0f - (this.nlE.nlf.nlL * ((float) (i2 + 1)))));
                            view.setTranslationY((((Float) this.nlE.nlz.get(i2)).floatValue() * (1.0f - floatValue)) + (floatValue * this.nlE.oN(i2)));
                        } else if (this.nlE.nlf.nlI == 2) {
                            view.setScaleY((((Float) valueAnimator.getAnimatedValue()).floatValue() * this.nlE.nlf.nlM) + (1.0f - (this.nlE.nlf.nlM * ((float) (i2 + 1)))));
                            view.setTranslationX((((Float) this.nlE.nly.get(i2)).floatValue() * (1.0f - floatValue)) + (floatValue * this.nlE.oM(i2)));
                        }
                    }
                }
            });
            this.nli.addListener(new AnimatorListener(this) {
                final /* synthetic */ ShuffleView nlE;

                {
                    this.nlE = r1;
                }

                public final void onAnimationStart(Animator animator) {
                    this.nlE.nlA = true;
                }

                public final void onAnimationEnd(Animator animator) {
                    this.nlE.nlA = false;
                    this.nlE.nlq = null;
                    this.nlE.nlr = -1;
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
        } else {
            this.nln = (View) this.nle.get(this.nls - 1);
            y(this.nln, this.nls - 1);
            addView(this.nln, 0);
            if (this.nlh != null) {
                switch (this.nlf.nlK) {
                    case 1:
                        this.nln.setTranslationY((float) (-ihQ.heightPixels));
                        break;
                    case 2:
                        this.nln.setTranslationY((float) ihQ.heightPixels);
                        break;
                    case 3:
                        this.nln.setTranslationX((float) (-ihQ.widthPixels));
                        break;
                    case 4:
                        this.nln.setTranslationX((float) ihQ.widthPixels);
                        break;
                }
            }
            this.nln.setVisibility(4);
            this.nli.addUpdateListener(new AnimatorUpdateListener(this) {
                final /* synthetic */ ShuffleView nlE;

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    for (int i = i; i < this.nlE.nls - 1; i++) {
                        View view = (View) this.nlE.nle.get(i);
                        if (this.nlE.nlf.nlI == 1) {
                            view.setScaleX((((Float) valueAnimator.getAnimatedValue()).floatValue() * this.nlE.nlf.nlL) + (1.0f - (this.nlE.nlf.nlL * ((float) (i + 1)))));
                            if (this.nlE.nlf.nlJ == 2) {
                                view.setTranslationY(this.nlE.oN(i + 1) - (((Float) valueAnimator.getAnimatedValue()).floatValue() * this.nlE.nlu));
                            } else if (this.nlE.nlf.nlJ == 1) {
                                view.setTranslationY((((Float) valueAnimator.getAnimatedValue()).floatValue() * this.nlE.nlu) + this.nlE.oN(i + 1));
                            }
                        } else if (this.nlE.nlf.nlI == 2) {
                            view.setScaleY((((Float) valueAnimator.getAnimatedValue()).floatValue() * this.nlE.nlf.nlM) + (1.0f - (this.nlE.nlf.nlM * ((float) (i + 1)))));
                            if (this.nlE.nlf.nlJ == 3) {
                                view.setTranslationX((((Float) valueAnimator.getAnimatedValue()).floatValue() * this.nlE.nlt) + this.nlE.oM(i + 1));
                            } else if (this.nlE.nlf.nlJ == 4) {
                                view.setTranslationX(this.nlE.oM(i + 1) - (((Float) valueAnimator.getAnimatedValue()).floatValue() * this.nlE.nlt));
                            }
                        }
                    }
                }
            });
            this.nli.addListener(new AnimatorListener(this) {
                final /* synthetic */ ShuffleView nlE;

                {
                    this.nlE = r1;
                }

                public final void onAnimationStart(Animator animator) {
                    this.nlE.nlA = true;
                }

                public final void onAnimationEnd(Animator animator) {
                    this.nlE.nlA = false;
                    this.nlE.nln.setVisibility(0);
                    if (this.nlE.nlh != null) {
                        this.nlE.nlh.start();
                    }
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
        }
        this.nli.start();
    }
}
