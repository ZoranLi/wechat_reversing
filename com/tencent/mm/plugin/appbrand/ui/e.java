package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.widget.j;
import com.tencent.mm.sdk.platformtools.w;

public final class e extends LinearLayout implements com.tencent.mm.plugin.appbrand.widget.j.a {
    public final String ivH;
    private final a[] jkN;
    private final SparseArray<b> jkO;
    private final SparseArray<b> jkP;
    private int jkQ;
    public com.tencent.mm.plugin.appbrand.e.b jkR = new com.tencent.mm.plugin.appbrand.e.b(this) {
        final /* synthetic */ e jkS;

        {
            this.jkS = r1;
        }

        public final void onDestroy() {
            super.onDestroy();
            AppBrandPerformanceManager.qy(this.jkS.ivH);
        }

        public final void a(c cVar) {
            super.a(cVar);
            AppBrandPerformanceManager.qy(this.jkS.ivH);
        }

        public final void onResume() {
            super.onResume();
            AppBrandPerformanceManager.qx(this.jkS.ivH);
        }
    };

    private class a extends TextView {
        final /* synthetic */ e jkS;

        public a(e eVar, Context context) {
            this.jkS = eVar;
            super(context);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(getContext(), 5);
            layoutParams.setMargins(0, fromDPToPix, 0, fromDPToPix);
            setLayoutParams(layoutParams);
            setTextSize(1, 12.0f);
            setTextColor(-7171438);
        }
    }

    private class b extends TextView {
        final /* synthetic */ e jkS;
        private String mTitle;
        private String mValue;

        static /* synthetic */ void a(b bVar, String str) {
            bVar.mValue = str;
            bVar.update();
        }

        static /* synthetic */ void b(b bVar, String str) {
            bVar.mTitle = str;
            bVar.update();
        }

        public b(e eVar, Context context) {
            this.jkS = eVar;
            super(context);
            setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            setTextSize(1, 12.0f);
            setTextColor(-419430401);
        }

        private void update() {
            setText(String.format("%s: %s", new Object[]{this.mTitle, this.mValue}));
        }
    }

    static /* synthetic */ void a(e eVar, int i, String str) {
        Integer num = (Integer) com.tencent.mm.plugin.appbrand.performance.b.jeR.get(i);
        if (num == null) {
            w.e("MicroMsg.AppBrandUIPerformancePanel", "insertPerformanceData no such performance type: %d", new Object[]{Integer.valueOf(i)});
            return;
        }
        String string = eVar.getContext().getString(num.intValue());
        b bVar = (b) eVar.jkP.get(i);
        if (bVar == null) {
            bVar = new b(eVar, eVar.getContext());
            b.b(bVar, string);
            int i2 = (i / 100) - 1;
            if (i2 >= 4) {
                w.e("MicroMsg.AppBrandUIPerformancePanel", "insertPerformanceLabelView group index is invalid.");
                bVar = null;
            } else {
                if (i2 == 3) {
                    eVar.addView(bVar);
                } else {
                    eVar.addView(bVar, eVar.indexOfChild(eVar.jkN[i2 + 1]));
                }
                eVar.jkP.put(i, bVar);
            }
        }
        if (bVar == null) {
            w.e("MicroMsg.AppBrandUIPerformancePanel", "insertPerformanceData label view is null.");
        } else {
            b.a(bVar, str);
        }
    }

    static /* synthetic */ void a(e eVar, String str, String str2) {
        b bVar = (b) eVar.jkO.get(str.hashCode());
        if (bVar == null) {
            bVar = new b(eVar, eVar.getContext());
            b.b(bVar, str);
            eVar.addView(bVar);
            eVar.jkO.put(str.hashCode(), bVar);
        }
        b.a(bVar, str2);
    }

    public e(Context context, String str) {
        super(context);
        this.ivH = str;
        this.jkO = new SparseArray();
        this.jkP = new SparseArray();
        this.jkN = new a[4];
        setClickable(false);
        int i = getContext().getResources().getDisplayMetrics().widthPixels;
        int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(getContext(), 10);
        int fromDPToPix2 = com.tencent.mm.bg.a.fromDPToPix(getContext(), 4);
        LayoutParams layoutParams = new FrameLayout.LayoutParams((i * 3) / 5, -2);
        layoutParams.gravity = 53;
        setLayoutParams(layoutParams);
        Xd();
        setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
        setOrientation(1);
        Drawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((float) fromDPToPix2);
        gradientDrawable.setColor(-652403418);
        setBackground(gradientDrawable);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 2);
        View textView = new TextView(getContext());
        View view = new View(getContext());
        textView.setTextColor(-1);
        textView.setLayoutParams(layoutParams2);
        textView.setTextSize(1, 14.0f);
        textView.setText(getContext().getString(R.l.dFv));
        addView(textView);
        layoutParams3.setMargins(0, com.tencent.mm.bg.a.fromDPToPix(getContext(), 10), 0, 0);
        view.setLayoutParams(layoutParams3);
        view.setBackgroundColor(1728053247);
        addView(view);
        Xe();
        j.s((Activity) getContext()).a(this);
    }

    private void Xd() {
        if (getLayoutParams() != null && (getLayoutParams() instanceof MarginLayoutParams)) {
            ((MarginLayoutParams) getLayoutParams()).topMargin = com.tencent.mm.plugin.appbrand.widget.b.bG(getContext()) + this.jkQ;
            requestLayout();
        }
    }

    private void Xe() {
        for (int i = 0; i < 4; i++) {
            View aVar = new a(this, getContext());
            aVar.setText(getContext().getString(com.tencent.mm.plugin.appbrand.performance.b.jeQ[i]));
            this.jkN[i] = aVar;
            addView(aVar);
        }
    }

    public final void D(final int i, final String str) {
        d.runOnUiThread(new Runnable(this) {
            final /* synthetic */ e jkS;

            public final void run() {
                e.a(this.jkS, i, str);
            }
        });
    }

    public final void bi(final String str, final String str2) {
        d.runOnUiThread(new Runnable(this) {
            final /* synthetic */ e jkS;

            public final void run() {
                e.a(this.jkS, str, str2);
            }
        });
    }

    public final void ix(int i) {
        this.jkQ = i;
        Xd();
    }
}
