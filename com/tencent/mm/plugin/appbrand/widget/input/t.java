package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.ui.a.c;
import com.tenpay.android.wechat.MyKeyboardWindow;

public final class t extends LinearLayout {
    private static final int jtC = R.h.bpa;
    private boolean juo = false;
    b jup;
    a juq;
    EditText kM;

    public interface b {
        void onDone();
    }

    private static final class a extends MyKeyboardWindow {
        a(Context context) {
            super(context);
            if (VERSION.SDK_INT >= 14) {
                setAccessibilityDelegate(new c());
            }
        }

        protected final void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            setInputEditText(null);
        }
    }

    public static t bR(View view) {
        return (t) view.getRootView().findViewById(jtC);
    }

    public static t bS(View view) {
        t bR = bR(view);
        if (bR != null) {
            return bR;
        }
        l bN = l.bN(view);
        if (bN == null) {
            return null;
        }
        bR = new t(view.getContext());
        bN.h(bR, false);
        return bR;
    }

    private t(Context context) {
        super(context);
        super.setId(jtC);
        setOrientation(1);
        setBackgroundResource(R.e.aVj);
        LayoutParams layoutParams = new LayoutParams(-1, com.tencent.mm.bg.a.fromDPToPix(getContext(), 30));
        View relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ t jur;

            {
                this.jur = r1;
            }

            public final void onClick(View view) {
                this.jur.onDone();
                this.jur.setVisibility(8);
            }
        });
        relativeLayout.setBackgroundResource(R.g.bkJ);
        View imageView = new ImageView(getContext());
        imageView.setImageResource(R.g.bkI);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        relativeLayout.addView(imageView, layoutParams2);
        addView(relativeLayout, layoutParams);
        layoutParams = new LayoutParams(-1, com.tencent.mm.bg.a.fromDPToPix(getContext(), 240));
        relativeLayout = new a(getContext());
        this.juq = relativeLayout;
        addView(relativeLayout, layoutParams);
    }

    private void onDone() {
        if (!this.juo && this.jup != null) {
            this.juo = true;
            this.jup.onDone();
            this.juo = false;
        }
    }

    public final void setId(int i) {
    }

    public final void setVisibility(int i) {
        if (getVisibility() != i || (getVisibility() != 0 && getVisibility() != 8)) {
            if (i != 0) {
                super.setVisibility(8);
                onDone();
                return;
            }
            super.setVisibility(i);
        }
    }

    public final void setInputEditText(EditText editText) {
        this.kM = editText;
        this.juq.setInputEditText(editText);
    }

    final void YU() {
        if (this.kM != null) {
            this.kM.clearFocus();
            this.kM = null;
            this.jup = null;
            this.juo = false;
        }
    }

    protected final void onMeasure(int i, int i2) {
        if (isShown()) {
            i2 = MeasureSpec.makeMeasureSpec(com.tencent.mm.bg.a.fromDPToPix(getContext(), 270), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeAllViews();
    }
}
