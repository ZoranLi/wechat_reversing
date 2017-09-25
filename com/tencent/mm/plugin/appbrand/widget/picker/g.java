package com.tencent.mm.plugin.appbrand.widget.picker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public class g extends RelativeLayout {
    private static final int jyJ = Color.parseColor("#F9F9F9");
    private final int jyC;
    private final int jyD;
    public i jyE;
    FrameLayout jyF;
    public a jyG;
    private boolean jyH;
    public b jyI;

    public interface a<T> {
        void c(boolean z, T t);
    }

    public interface b<T> {
        void aK(T t);
    }

    final void ZI() {
        this.jyG = null;
        this.jyI = null;
    }

    private void d(boolean z, Object obj) {
        if (!this.jyH && this.jyG != null) {
            this.jyH = true;
            this.jyG.c(z, obj);
            this.jyH = false;
        }
    }

    public g(Context context) {
        super(context);
        this.jyC = com.tencent.mm.bg.a.fromDPToPix(context, 48);
        this.jyD = com.tencent.mm.bg.a.fromDPToPix(context, 240);
        setClickable(true);
        setLongClickable(true);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.jyD);
        layoutParams.addRule(12);
        View frameLayout = new FrameLayout(getContext());
        frameLayout.setId(R.h.bpn);
        frameLayout.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ g jyK;

            {
                this.jyK = r1;
            }

            public final void onClick(View view) {
            }
        });
        frameLayout.setBackgroundColor(jyJ);
        this.jyF = frameLayout;
        addView(frameLayout, layoutParams);
        layoutParams = new RelativeLayout.LayoutParams(-1, this.jyC);
        layoutParams.addRule(2, R.h.bpn);
        frameLayout = new RelativeLayout(getContext());
        View bC = bC(R.l.dXk, R.e.aUd);
        bC.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ g jyK;

            {
                this.jyK = r1;
            }

            public final void onClick(View view) {
                this.jyK.d(true, this.jyK.jyE == null ? null : this.jyK.jyE.ZF());
            }
        });
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams2.addRule(11);
        frameLayout.addView(bC, layoutParams2);
        bC = bC(R.l.dXi, R.e.aTe);
        bC.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ g jyK;

            {
                this.jyK = r1;
            }

            public final void onClick(View view) {
                this.jyK.d(false, null);
            }
        });
        layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams2.addRule(9);
        frameLayout.addView(bC, layoutParams2);
        frameLayout.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ g jyK;

            {
                this.jyK = r1;
            }

            public final void onClick(View view) {
            }
        });
        frameLayout.setBackgroundColor(jyJ);
        addView(frameLayout, layoutParams);
    }

    public void show() {
        if (this.jyE == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (this.jyE != null) {
            this.jyE.a(this);
        }
    }

    public void hide() {
        super.setVisibility(8);
        d(false, null);
        if (this.jyE != null) {
            this.jyE.ZD();
        }
    }

    public void setVisibility(int i) {
        if (i != 0) {
            hide();
        } else {
            super.setVisibility(i);
        }
    }

    @SuppressLint({"WrongCall"})
    protected final void bB(int i, int i2) {
        super.onMeasure(i, i2);
    }

    protected void onMeasure(int i, int i2) {
        if (isShown()) {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(this.jyC + this.jyD, 1073741824));
        } else {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(0, Integer.MIN_VALUE));
        }
    }

    private View bC(int i, int i2) {
        View textView = new TextView(new ContextThemeWrapper(getContext(), R.m.foI));
        textView.setTextColor(getResources().getColor(i2));
        textView.setText(i);
        textView.setGravity(17);
        return textView;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ZI();
        removeAllViews();
    }
}
