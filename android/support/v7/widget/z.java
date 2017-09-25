package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.p;
import android.support.v7.widget.RecyclerView.p.a;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

public abstract class z extends p {
    protected final DecelerateInterpolator Ej = new DecelerateInterpolator();
    protected final LinearInterpolator XN = new LinearInterpolator();
    protected PointF XO;
    private final float XP;
    protected int XQ = 0;
    protected int XR = 0;

    public abstract PointF aW(int i);

    public z(Context context) {
        this.XP = a(context.getResources().getDisplayMetrics());
    }

    protected final void a(View view, a aVar) {
        int i = 1;
        int i2 = 0;
        int i3 = (this.XO == null || this.XO.x == 0.0f) ? 0 : this.XO.x > 0.0f ? 1 : -1;
        h hVar = this.YQ;
        if (hVar == null || !hVar.eR()) {
            i3 = 0;
        } else {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            i3 = e(h.bi(view) - layoutParams.leftMargin, layoutParams.rightMargin + h.bk(view), hVar.getPaddingLeft(), hVar.aar - hVar.getPaddingRight(), i3);
        }
        if (this.XO == null || this.XO.y == 0.0f) {
            i = 0;
        } else if (this.XO.y <= 0.0f) {
            i = -1;
        }
        h hVar2 = this.YQ;
        if (hVar2 != null && hVar2.eS()) {
            layoutParams = (LayoutParams) view.getLayoutParams();
            i2 = e(h.bj(view) - layoutParams.topMargin, layoutParams.bottomMargin + h.bl(view), hVar2.getPaddingTop(), hVar2.RQ - hVar2.getPaddingBottom(), i);
        }
        int ceil = (int) Math.ceil(((double) aZ((int) Math.sqrt((double) ((i3 * i3) + (i2 * i2))))) / 0.3356d);
        if (ceil > 0) {
            aVar.a(-i3, -i2, ceil, this.Ej);
        }
    }

    protected final void a(int i, int i2, a aVar) {
        if (this.aak.Zf.getChildCount() == 0) {
            stop();
            return;
        }
        this.XQ = K(this.XQ, i);
        this.XR = K(this.XR, i2);
        if (this.XQ == 0 && this.XR == 0) {
            PointF aW = aW(this.aaG);
            if (aW == null || (aW.x == 0.0f && aW.y == 0.0f)) {
                aVar.aaN = this.aaG;
                stop();
                return;
            }
            double sqrt = Math.sqrt((double) ((aW.x * aW.x) + (aW.y * aW.y)));
            aW.x = (float) (((double) aW.x) / sqrt);
            aW.y = (float) (((double) aW.y) / sqrt);
            this.XO = aW;
            this.XQ = (int) (aW.x * 10000.0f);
            this.XR = (int) (aW.y * 10000.0f);
            aVar.a((int) (((float) this.XQ) * 1.2f), (int) (((float) this.XR) * 1.2f), (int) (((float) aZ(10000)) * 1.2f), this.XN);
        }
    }

    protected final void onStop() {
        this.XR = 0;
        this.XQ = 0;
        this.XO = null;
    }

    public float a(DisplayMetrics displayMetrics) {
        return 25.0f / ((float) displayMetrics.densityDpi);
    }

    public int aZ(int i) {
        return (int) Math.ceil((double) (((float) Math.abs(i)) * this.XP));
    }

    private static int K(int i, int i2) {
        int i3 = i - i2;
        if (i * i3 <= 0) {
            return 0;
        }
        return i3;
    }

    private static int e(int i, int i2, int i3, int i4, int i5) {
        switch (i5) {
            case -1:
                return i3 - i;
            case 0:
                int i6 = i3 - i;
                if (i6 > 0) {
                    return i6;
                }
                i6 = i4 - i2;
                return i6 >= 0 ? 0 : i6;
            case 1:
                return i4 - i2;
            default:
                throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }
}
