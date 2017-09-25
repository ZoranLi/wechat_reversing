package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.v4.view.z;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ui.g;
import com.tencent.mm.ui.MMActivity;
import java.util.WeakHashMap;

@SuppressLint({"ViewConstructor"})
public final class l extends FrameLayout {
    private static final int jtC = R.h.bpu;
    private View jtD;
    private View jtE;
    int jtF = -1;
    private final int[] jtG = new int[2];
    com.tencent.mm.plugin.appbrand.widget.c.a jtH;
    private WeakHashMap<View, a> jtI = new WeakHashMap();
    private Runnable jtJ = new Runnable(this) {
        final /* synthetic */ l jtK;

        {
            this.jtK = r1;
        }

        public final void run() {
            if (this.jtK.jtD != null) {
                for (int i = 0; i < this.jtK.getChildCount(); i++) {
                    View childAt = this.jtK.getChildAt(i);
                    if (!(childAt == null || childAt == this.jtK.jtE || childAt == this.jtK.jtD)) {
                        l.bP(childAt);
                    }
                }
            }
        }
    };

    private static final class a {
        boolean jtL;
        int jtM = 8;
    }

    static /* synthetic */ void bP(View view) {
        if (view != null && view.getVisibility() != 8) {
            view.setVisibility(8);
        }
    }

    public static l bN(View view) {
        return (l) view.getRootView().findViewById(jtC);
    }

    public l(Context context, View view) {
        super(context);
        super.setId(jtC);
        this.jtE = view;
        super.addView(view);
    }

    protected final void onMeasure(int i, int i2) {
        if (this.jtF > 0) {
            i2 = MeasureSpec.makeMeasureSpec(this.jtF, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
            if (this.jtD == null || !this.jtD.isShown()) {
                Activity bB = g.bB(getContext());
                if (MMActivity.class.isInstance(bB) && ((MMActivity) bB).uSU.are()) {
                    return true;
                }
            }
            this.jtD.setVisibility(8);
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a aVar = (a) this.jtI.get(this.jtD);
        if (aVar != null && aVar.jtL && this.jtD != null && this.jtD.isShown() && motionEvent.getAction() == 0) {
            float rawY = motionEvent.getRawY();
            this.jtD.getLocationOnScreen(this.jtG);
            float f = (float) this.jtG[1];
            float height = ((float) this.jtD.getHeight()) + f;
            if (rawY < f || rawY > height) {
                this.jtD.setVisibility(8);
                return true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void setId(int i) {
    }

    public final void addView(View view) {
        if (view == this.jtE || view == this.jtD) {
            super.addView(view);
        }
    }

    public final void addView(View view, int i) {
        if (view == this.jtE || view == this.jtD) {
            super.addView(view, i);
        }
    }

    public final void addView(View view, int i, int i2) {
        if (view == this.jtE || view == this.jtD) {
            super.addView(view, i, i2);
        }
    }

    public final void addView(View view, LayoutParams layoutParams) {
        if (view == this.jtE || view == this.jtD) {
            super.addView(view, layoutParams);
        }
    }

    public final void addView(View view, int i, LayoutParams layoutParams) {
        if (view == this.jtE || view == this.jtD) {
            super.addView(view, i, layoutParams);
        }
    }

    protected final boolean addViewInLayout(View view, int i, LayoutParams layoutParams) {
        return false;
    }

    protected final boolean addViewInLayout(View view, int i, LayoutParams layoutParams, boolean z) {
        return false;
    }

    public final void h(View view, boolean z) {
        if (this.jtD != null) {
            this.jtD.setVisibility(8);
            this.jtD = null;
        }
        if (this != view.getParent()) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.jtD = view;
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            super.addView(view, layoutParams);
            a aVar = new a();
            aVar.jtL = z;
            this.jtI.put(view, aVar);
        }
    }

    public final void bO(View view) {
        h(view, false);
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Object obj = null;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            if (!(childAt == null || childAt == this.jtE)) {
                a aVar = (a) this.jtI.get(childAt);
                if (aVar != null) {
                    if (z.aj(this) && r2 == null && aVar.jtM != 0 && childAt.getVisibility() == 0) {
                        this.jtD = childAt;
                        obj = 1;
                        post(this.jtJ);
                    }
                    aVar.jtM = childAt.getVisibility();
                }
            }
        }
        super.onLayout(z, i, i2, i3, i4);
        if (this.jtH != null) {
            this.jtH.bQ(this);
        }
    }
}
