package com.tencent.mm.ui.snackbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.s.a.g;
import com.tencent.mm.ui.snackbar.b.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import java.util.LinkedList;
import java.util.Queue;

class SnackContainer extends FrameLayout {
    private final Runnable lnM = new Runnable(this) {
        final /* synthetic */ SnackContainer wjZ;

        {
            this.wjZ = r1;
        }

        public final void run() {
            if (this.wjZ.getVisibility() == 0) {
                this.wjZ.startAnimation(this.wjZ.wjX);
            }
        }
    };
    private AnimationSet vKd;
    Queue<a> wjW = new LinkedList();
    private AnimationSet wjX;
    private float wjY;

    private static class a {
        final TextView ngf;
        final View wkb;
        final TextView wkc;
        final Snack wkd;
        final c wke;

        public a(Snack snack, View view, c cVar) {
            this.wkb = view;
            this.ngf = (TextView) view.findViewById(g.hdc);
            this.wkc = (TextView) view.findViewById(g.hde);
            this.wkd = snack;
            this.wke = cVar;
        }
    }

    public SnackContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    SnackContainer(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        viewGroup.addView(this, new LayoutParams(-1, -1));
        setVisibility(8);
        setId(g.hdd);
        init();
    }

    private void init() {
        this.vKd = new AnimationSet(false);
        Animation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.vKd.setInterpolator(new DecelerateInterpolator(DownloadHelper.SAVE_FATOR));
        this.vKd.addAnimation(translateAnimation);
        this.vKd.addAnimation(alphaAnimation);
        this.wjX = new AnimationSet(false);
        translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, 1.0f);
        alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        this.wjX.addAnimation(translateAnimation);
        this.wjX.addAnimation(alphaAnimation);
        this.wjX.setDuration(300);
        this.wjX.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ SnackContainer wjZ;

            {
                this.wjZ = r1;
            }

            public final void onAnimationStart(Animation animation) {
                if (!this.wjZ.isEmpty() && ((a) this.wjZ.wjW.peek()).wke != null) {
                    a.lD(false);
                    ((a) this.wjZ.wjW.peek()).wke.azo();
                }
            }

            public final void onAnimationEnd(Animation animation) {
                this.wjZ.removeAllViews();
                if (!this.wjZ.wjW.isEmpty()) {
                    SnackContainer.a((a) this.wjZ.wjW.poll());
                }
                if (this.wjZ.isEmpty()) {
                    this.wjZ.setVisibility(8);
                } else {
                    this.wjZ.a((a) this.wjZ.wjW.peek(), false);
                }
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.vKd.cancel();
        this.wjX.cancel();
        removeCallbacks(this.lnM);
        this.wjW.clear();
    }

    public final boolean isEmpty() {
        return this.wjW.isEmpty();
    }

    public final boolean isShowing() {
        return !this.wjW.isEmpty();
    }

    public final void hide() {
        removeCallbacks(this.lnM);
        this.lnM.run();
    }

    final void a(final a aVar, boolean z) {
        setVisibility(0);
        if (aVar.wke != null) {
            a.lD(true);
            aVar.wke.azn();
        }
        addView(aVar.wkb);
        aVar.wkc.setText(aVar.wkd.mMessage);
        if (aVar.wkd.wjI != null) {
            aVar.ngf.setVisibility(0);
            aVar.ngf.setText(aVar.wkd.wjI);
        } else {
            aVar.ngf.setVisibility(8);
        }
        this.vKd.setDuration(500);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.s.a.a.aQX);
        loadAnimation.setDuration(500);
        startAnimation(this.vKd);
        loadAnimation.setStartOffset(200);
        aVar.ngf.startAnimation(loadAnimation);
        aVar.wkc.startAnimation(loadAnimation);
        if (aVar.wkd.wjL > (short) 0) {
            postDelayed(this.lnM, (long) aVar.wkd.wjL);
        }
        aVar.wkb.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ SnackContainer wjZ;

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                float y = motionEvent.getY();
                switch (motionEvent.getAction()) {
                    case 4:
                        this.wjZ.removeCallbacks(this.wjZ.lnM);
                        SnackContainer.a(aVar);
                        this.wjZ.startAnimation(this.wjZ.wjX);
                        if (!this.wjZ.wjW.isEmpty()) {
                            this.wjZ.wjW.clear();
                            break;
                        }
                        break;
                }
                this.wjZ.wjY = y;
                return true;
            }
        });
    }

    private static void a(a aVar) {
        if (aVar.wke != null) {
            a.lD(false);
            aVar.wke.onHide();
        }
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if ((i == 0 && a.asn()) || 8 == i) {
            removeAllViews();
            if (!this.wjW.isEmpty()) {
                a((a) this.wjW.poll());
            }
            if (isEmpty()) {
                setVisibility(8);
            } else {
                a((a) this.wjW.peek(), false);
            }
            a.lD(false);
        }
    }
}
