package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.R;

public final class d extends FrameLayout implements i<int[]> {
    private boolean Zo;
    private boolean Zp;
    private final Drawable jys;
    public LinearLayout jyt;
    private g jyu;
    public final com.tencent.mm.plugin.appbrand.widget.picker.YANumberPicker.a jyv = new com.tencent.mm.plugin.appbrand.widget.picker.YANumberPicker.a(this) {
        final /* synthetic */ d jyw;

        {
            this.jyw = r1;
        }

        public final void a(YANumberPicker yANumberPicker, int i) {
            if (this.jyw.jyu != null) {
                int intValue = ((Integer) yANumberPicker.getTag(R.h.bpj)).intValue();
                g a = this.jyw.jyu;
                Object obj = new int[]{intValue, i};
                if (a.jyI != null) {
                    a.jyI.aK(obj);
                }
            }
        }
    };

    public static final class a {
        public final String[] jyx;
        public final int jyy;

        public a(String[] strArr, int i) {
            this.jyx = strArr;
            this.jyy = Math.max(0, Math.min(i, strArr.length - 1));
        }
    }

    class AnonymousClass2 extends f {
        final /* synthetic */ d jyw;

        public AnonymousClass2(d dVar, Context context) {
            this.jyw = dVar;
            super(context);
        }
    }

    public final /* synthetic */ Object ZF() {
        int i = 0;
        int ZG = ZG();
        if (ZG <= 0) {
            return new int[0];
        }
        Object obj = new int[ZG];
        while (i < ZG) {
            obj[i] = iZ(i).getValue();
            i++;
        }
        return obj;
    }

    @android.support.a.a
    public d(Context context) {
        super(context);
        this.jys = context.getResources().getDrawable(R.g.bcc);
        this.jyt = new LinearLayout(context);
        this.jyt.setPadding(com.tencent.mm.bg.a.fromDPToPix(context, 2), 0, com.tencent.mm.bg.a.fromDPToPix(context, 2), 0);
        this.jyt.setOrientation(0);
        addView(this.jyt, new LayoutParams(-1, -1, 17));
        this.jyt.setDividerDrawable(this.jys);
        this.jyt.setShowDividers(2);
    }

    public final void S(boolean z) {
        if (this.Zp != z) {
            this.Zp = z;
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            } else if (this.Zo) {
                requestLayout();
            }
        }
    }

    public final void requestLayout() {
        if (this.Zp) {
            this.Zo = true;
        } else {
            super.requestLayout();
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Zp) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Zp) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final f iZ(int i) {
        if (i >= 0 && this.jyt != null) {
            return (f) this.jyt.getChildAt(i);
        }
        return null;
    }

    public final int ZG() {
        return this.jyt == null ? 0 : this.jyt.getChildCount();
    }

    public final void ja(int i) {
        if (i > 0) {
            int ZG = ZG() - 1;
            while (i > 0) {
                this.jyt.removeViewAt(ZG);
                ZG--;
                i--;
            }
        }
    }

    public final View getView() {
        return this;
    }

    public final void a(g gVar) {
        this.jyu = gVar;
    }

    public final void ZD() {
        int ZG = ZG();
        for (int i = 0; i < ZG; i++) {
            f iZ = iZ(i);
            if (iZ != null) {
                iZ.ZQ();
            }
        }
    }

    public final void b(g gVar) {
        this.jyu = gVar;
    }

    public final void ZE() {
        this.jyu = null;
    }
}
