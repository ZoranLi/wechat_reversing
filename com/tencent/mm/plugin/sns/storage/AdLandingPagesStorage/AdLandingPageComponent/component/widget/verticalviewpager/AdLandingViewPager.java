package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.view.ViewPager.f;
import android.support.v4.view.ae;
import android.support.v4.view.o;
import android.support.v4.view.u;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.support.v4.widget.i;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import junit.framework.Assert;

public class AdLandingViewPager extends ViewGroup {
    private static final e qln = new e();
    private static final int[] ym = new int[]{16842931};
    private static final Comparator<b> yo = new Comparator<b>() {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((b) obj).position - ((b) obj2).position;
        }
    };
    private static final Interpolator yp = new Interpolator() {
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    };
    final ArrayList<b> eh = new ArrayList();
    private final Rect eq = new Rect();
    VelocityTracker fk;
    int fl = -1;
    private boolean iC;
    private int iE;
    private boolean pd;
    private final b qlj = new b();
    private d qlk;
    long qll;
    Method qlm;
    float xC;
    private float xD;
    private int xV = 0;
    private Drawable yA;
    private int yB;
    private int yC;
    float yD = -3.4028235E38f;
    float yE = Float.MAX_VALUE;
    private int yF;
    private int yG;
    private boolean yH;
    boolean yI;
    public int yJ = 1;
    private boolean yK;
    private int yL;
    private int yM;
    float yN;
    private float yO;
    private int yP;
    int yQ;
    private int yR;
    private int yS;
    boolean yT;
    private i yU;
    private i yV;
    private boolean yW = true;
    private boolean yX = false;
    private boolean yY;
    private int yZ;
    private int yn;
    public u yr;
    public int ys;
    private int yt = -1;
    private Parcelable yu = null;
    private ClassLoader yv = null;
    private Scroller yw;
    private int yz;
    android.support.v4.view.ViewPager.e zb;
    private android.support.v4.view.ViewPager.e zc;
    f ze;
    int zf;
    private ArrayList<View> zg;
    private final Runnable zi = new Runnable(this) {
        final /* synthetic */ AdLandingViewPager qlo;

        {
            this.qlo = r1;
        }

        public final void run() {
            this.qlo.X(0);
            this.qlo.populate();
        }
    };

    public static class LayoutParams extends android.view.ViewGroup.LayoutParams {
        public int gravity;
        int position;
        float zm = 0.0f;
        public boolean zo;
        boolean zp;
        int zq;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AdLandingViewPager.ym);
            this.gravity = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = android.support.v4.os.b.a(new android.support.v4.os.c<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        });
        int position;
        Parcelable zr;
        ClassLoader zt;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.position);
            parcel.writeParcelable(this.zr, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.position = parcel.readInt();
            this.zr = parcel.readParcelable(classLoader);
            this.zt = classLoader;
        }
    }

    interface a {
    }

    static class b {
        int position;
        Object zk;
        boolean zl;
        float zm;
        float zn;

        b() {
        }
    }

    class c extends android.support.v4.view.a {
        final /* synthetic */ AdLandingViewPager qlo;

        c(AdLandingViewPager adLandingViewPager) {
            this.qlo = adLandingViewPager;
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(AdLandingViewPager.class.getName());
            android.support.v4.view.a.f ch = android.support.v4.view.a.f.ch();
            ch.setScrollable(bY());
            if (accessibilityEvent.getEventType() == Downloads.RECV_BUFFER_SIZE && this.qlo.yr != null) {
                ch.setItemCount(this.qlo.yr.getCount());
                ch.setFromIndex(this.qlo.ys);
                ch.setToIndex(this.qlo.ys);
            }
        }

        public final void a(View view, android.support.v4.view.a.b bVar) {
            super.a(view, bVar);
            bVar.setClassName(AdLandingViewPager.class.getName());
            bVar.setScrollable(bY());
            if (this.qlo.canScrollHorizontally(1)) {
                bVar.addAction(Downloads.RECV_BUFFER_SIZE);
            }
            if (this.qlo.canScrollHorizontally(-1)) {
                bVar.addAction(8192);
            }
        }

        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            switch (i) {
                case Downloads.RECV_BUFFER_SIZE /*4096*/:
                    if (!this.qlo.canScrollHorizontally(1)) {
                        return false;
                    }
                    this.qlo.Y(this.qlo.ys + 1);
                    return true;
                case 8192:
                    if (!this.qlo.canScrollHorizontally(-1)) {
                        return false;
                    }
                    this.qlo.Y(this.qlo.ys - 1);
                    return true;
                default:
                    return false;
            }
        }

        private boolean bY() {
            return this.qlo.yr != null && this.qlo.yr.getCount() > 1;
        }
    }

    private class d extends DataSetObserver {
        final /* synthetic */ AdLandingViewPager qlo;

        private d(AdLandingViewPager adLandingViewPager) {
            this.qlo = adLandingViewPager;
        }

        public final void onChanged() {
            this.qlo.bQ();
        }

        public final void onInvalidated() {
            this.qlo.bQ();
        }
    }

    static class e implements Comparator<View> {
        e() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            LayoutParams layoutParams = (LayoutParams) ((View) obj).getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) ((View) obj2).getLayoutParams();
            if (layoutParams.zo != layoutParams2.zo) {
                return layoutParams.zo ? 1 : -1;
            } else {
                return layoutParams.position - layoutParams2.position;
            }
        }
    }

    public AdLandingViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context2 = getContext();
        this.yw = new Scroller(context2, yp);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context2);
        float f = context2.getResources().getDisplayMetrics().density;
        this.iE = ae.a(viewConfiguration);
        this.yP = (int) (400.0f * f);
        this.yQ = viewConfiguration.getScaledMaximumFlingVelocity();
        this.yU = new i(context2);
        this.yV = new i(context2);
        this.yR = (int) (25.0f * f);
        this.yS = (int) (2.0f * f);
        this.yL = (int) (16.0f * f);
        z.a(this, new c(this));
        if (z.G(this) == 0) {
            z.i(this, 1);
        }
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.zi);
        super.onDetachedFromWindow();
    }

    private void X(int i) {
        if (this.xV != i) {
            this.xV = i;
            if (this.ze != null) {
                Object obj = i != 0 ? 1 : null;
                int childCount = getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    z.a(getChildAt(i2), obj != null ? 2 : 0, null);
                }
            }
            if (this.zb != null) {
                this.zb.W(i);
            }
        }
    }

    public final void a(u uVar) {
        if (this.yr != null) {
            int i;
            this.yr.unregisterDataSetObserver(this.qlk);
            for (i = 0; i < this.eh.size(); i++) {
                b bVar = (b) this.eh.get(i);
                this.yr.a(this, bVar.position, bVar.zk);
            }
            this.yr.ba();
            this.eh.clear();
            i = 0;
            while (i < getChildCount()) {
                if (!((LayoutParams) getChildAt(i).getLayoutParams()).zo) {
                    removeViewAt(i);
                    i--;
                }
                i++;
            }
            this.ys = 0;
            scrollTo(0, 0);
        }
        this.yr = uVar;
        this.yn = 0;
        if (this.yr != null) {
            if (this.qlk == null) {
                this.qlk = new d();
            }
            this.yr.registerDataSetObserver(this.qlk);
            this.yI = false;
            boolean z = this.yW;
            this.yW = true;
            this.yn = this.yr.getCount();
            if (this.yt >= 0) {
                this.yr.a(this.yu, this.yv);
                a(this.yt, false, true);
                this.yt = -1;
                this.yu = null;
                this.yv = null;
            } else if (z) {
                requestLayout();
            } else {
                populate();
            }
        }
    }

    final int bP() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public final void Y(int i) {
        boolean z;
        this.yI = false;
        if (this.yW) {
            z = false;
        } else {
            z = true;
        }
        a(i, z, false);
    }

    public final void k(int i, boolean z) {
        this.yI = false;
        a(i, z, false);
    }

    private void a(int i, boolean z, boolean z2) {
        a(i, z, z2, 0);
    }

    final void a(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        if (this.yr == null || this.yr.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.ys != i || this.eh.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.yr.getCount()) {
                i = this.yr.getCount() - 1;
            }
            int i3 = this.yJ;
            if (i > this.ys + i3 || i < this.ys - i3) {
                for (int i4 = 0; i4 < this.eh.size(); i4++) {
                    ((b) this.eh.get(i4)).zl = true;
                }
            }
            if (this.ys != i) {
                z3 = true;
            }
            if (this.yW) {
                this.ys = i;
                if (z3 && this.zb != null) {
                    this.zb.V(i);
                }
                if (z3 && this.zc != null) {
                    this.zc.V(i);
                }
                requestLayout();
                return;
            }
            Z(i);
            a(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    private void a(int i, boolean z, int i2, boolean z2) {
        b ty = ty(i);
        int i3 = 0;
        if (ty != null) {
            i3 = (int) (((float) bP()) * Math.max(this.yD, Math.min(ty.zn, this.yE)));
        }
        if (z) {
            if (getChildCount() == 0) {
                setScrollingCacheEnabled(false);
            } else {
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int i4 = i3 - scrollX;
                int i5 = 0 - scrollY;
                if (i4 == 0 && i5 == 0) {
                    r(false);
                    populate();
                    X(0);
                } else {
                    setScrollingCacheEnabled(true);
                    X(2);
                    i3 = bP();
                    int i6 = i3 / 2;
                    float f = (float) i6;
                    float sin = (((float) i6) * ((float) Math.sin((double) ((float) (((double) (Math.min(1.0f, (1.0f * ((float) Math.abs(i4))) / ((float) i3)) - 0.5f)) * 0.4712389167638204d))))) + f;
                    int abs = Math.abs(i2);
                    if (abs > 0) {
                        i3 = Math.round(1000.0f * Math.abs(sin / ((float) abs))) * 4;
                    } else {
                        i3 = (int) (((((float) Math.abs(i4)) / ((((float) i3) * 1.0f) + ((float) this.yz))) + 3.0f) * 100.0f);
                    }
                    this.yw.startScroll(scrollX, scrollY, i4, i5, Math.min(i3, 600));
                    z.F(this);
                }
            }
            if (z2 && this.zb != null) {
                this.zb.V(i);
            }
            if (z2 && this.zc != null) {
                this.zc.V(i);
                return;
            }
            return;
        }
        if (z2 && this.zb != null) {
            this.zb.V(i);
        }
        if (z2 && this.zc != null) {
            this.zc.V(i);
        }
        r(false);
        scrollTo(i3, 0);
        ab(i3);
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.zf == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) ((View) this.zg.get(i2)).getLayoutParams()).zq;
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.yA;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.yA;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    private b cW(int i, int i2) {
        b bVar = new b();
        bVar.position = i;
        bVar.zk = this.yr.b(this, i);
        bVar.zm = 1.0f;
        if (i2 < 0 || i2 >= this.eh.size()) {
            this.eh.add(bVar);
        } else {
            this.eh.add(i2, bVar);
        }
        return bVar;
    }

    final void bQ() {
        boolean z;
        int count = this.yr.getCount();
        this.yn = count;
        if (this.eh.size() >= (this.yJ * 2) + 1 || this.eh.size() >= count) {
            z = false;
        } else {
            z = true;
        }
        boolean z2 = false;
        int i = this.ys;
        boolean z3 = z;
        int i2 = 0;
        while (i2 < this.eh.size()) {
            int i3;
            boolean z4;
            int max;
            boolean z5;
            b bVar = (b) this.eh.get(i2);
            int j = this.yr.j(bVar.zk);
            if (j != -1) {
                if (j == -2) {
                    this.eh.remove(i2);
                    i2--;
                    if (!z2) {
                        z2 = true;
                    }
                    this.yr.a(this, bVar.position, bVar.zk);
                    if (this.ys == bVar.position) {
                        i3 = i2;
                        z4 = z2;
                        max = Math.max(0, Math.min(this.ys, count - 1));
                        z5 = true;
                    } else {
                        i3 = i2;
                        z4 = z2;
                        max = i;
                        z5 = true;
                    }
                } else if (bVar.position != j) {
                    if (bVar.position == this.ys) {
                        i = j;
                    }
                    bVar.position = j;
                    i3 = i2;
                    z4 = z2;
                    max = i;
                    z5 = true;
                }
                z3 = z5;
                i = max;
                z2 = z4;
                i2 = i3 + 1;
            }
            i3 = i2;
            z4 = z2;
            max = i;
            z5 = z3;
            z3 = z5;
            i = max;
            z2 = z4;
            i2 = i3 + 1;
        }
        if (z2) {
            this.yr.ba();
        }
        Collections.sort(this.eh, yo);
        if (z3) {
            max = getChildCount();
            for (i2 = 0; i2 < max; i2++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i2).getLayoutParams();
                if (!layoutParams.zo) {
                    layoutParams.zm = 0.0f;
                }
            }
            a(i, false, true);
            requestLayout();
        }
    }

    public final void populate() {
        Z(this.ys);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void Z(int r19) {
        /*
        r18 = this;
        r3 = 0;
        r2 = 2;
        r0 = r18;
        r4 = r0.ys;
        r0 = r19;
        if (r4 == r0) goto L_0x0328;
    L_0x000a:
        r0 = r18;
        r2 = r0.ys;
        r0 = r19;
        if (r2 >= r0) goto L_0x0030;
    L_0x0012:
        r2 = 66;
    L_0x0014:
        r0 = r18;
        r3 = r0.ys;
        r0 = r18;
        r3 = r0.ty(r3);
        r0 = r19;
        r1 = r18;
        r1.ys = r0;
        r4 = r3;
        r3 = r2;
    L_0x0026:
        r0 = r18;
        r2 = r0.yr;
        if (r2 != 0) goto L_0x0033;
    L_0x002c:
        r18.bR();
    L_0x002f:
        return;
    L_0x0030:
        r2 = 17;
        goto L_0x0014;
    L_0x0033:
        r0 = r18;
        r2 = r0.yI;
        if (r2 == 0) goto L_0x003d;
    L_0x0039:
        r18.bR();
        goto L_0x002f;
    L_0x003d:
        r2 = r18.getWindowToken();
        if (r2 == 0) goto L_0x002f;
    L_0x0043:
        r0 = r18;
        r2 = r0.yJ;
        r5 = 0;
        r0 = r18;
        r6 = r0.ys;
        r6 = r6 - r2;
        r11 = java.lang.Math.max(r5, r6);
        r0 = r18;
        r5 = r0.yr;
        r12 = r5.getCount();
        r5 = r12 + -1;
        r0 = r18;
        r6 = r0.ys;
        r2 = r2 + r6;
        r13 = java.lang.Math.min(r5, r2);
        r0 = r18;
        r2 = r0.yn;
        if (r12 == r2) goto L_0x00d2;
    L_0x006a:
        r2 = r18.getResources();	 Catch:{ NotFoundException -> 0x00c8 }
        r3 = r18.getId();	 Catch:{ NotFoundException -> 0x00c8 }
        r2 = r2.getResourceName(r3);	 Catch:{ NotFoundException -> 0x00c8 }
    L_0x0076:
        r3 = new java.lang.IllegalStateException;
        r4 = new java.lang.StringBuilder;
        r5 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
        r4.<init>(r5);
        r0 = r18;
        r5 = r0.yn;
        r4 = r4.append(r5);
        r5 = ", found: ";
        r4 = r4.append(r5);
        r4 = r4.append(r12);
        r5 = " Pager id: ";
        r4 = r4.append(r5);
        r2 = r4.append(r2);
        r4 = " Pager class: ";
        r2 = r2.append(r4);
        r4 = r18.getClass();
        r2 = r2.append(r4);
        r4 = " Problematic adapter: ";
        r2 = r2.append(r4);
        r0 = r18;
        r4 = r0.yr;
        r4 = r4.getClass();
        r2 = r2.append(r4);
        r2 = r2.toString();
        r3.<init>(r2);
        throw r3;
    L_0x00c8:
        r2 = move-exception;
        r2 = r18.getId();
        r2 = java.lang.Integer.toHexString(r2);
        goto L_0x0076;
    L_0x00d2:
        r6 = 0;
        r2 = 0;
        r5 = r2;
    L_0x00d5:
        r0 = r18;
        r2 = r0.eh;
        r2 = r2.size();
        if (r5 >= r2) goto L_0x0325;
    L_0x00df:
        r0 = r18;
        r2 = r0.eh;
        r2 = r2.get(r5);
        r2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.b) r2;
        r7 = r2.position;
        r0 = r18;
        r8 = r0.ys;
        if (r7 < r8) goto L_0x0167;
    L_0x00f1:
        r7 = r2.position;
        r0 = r18;
        r8 = r0.ys;
        if (r7 != r8) goto L_0x0325;
    L_0x00f9:
        if (r2 != 0) goto L_0x0322;
    L_0x00fb:
        if (r12 <= 0) goto L_0x0322;
    L_0x00fd:
        r0 = r18;
        r2 = r0.ys;
        r0 = r18;
        r2 = r0.cW(r2, r5);
        r10 = r2;
    L_0x0108:
        if (r10 == 0) goto L_0x028b;
    L_0x010a:
        r9 = 0;
        r8 = r5 + -1;
        if (r8 < 0) goto L_0x016c;
    L_0x010f:
        r0 = r18;
        r2 = r0.eh;
        r2 = r2.get(r8);
        r2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.b) r2;
    L_0x0119:
        r14 = r18.bP();
        if (r14 > 0) goto L_0x016e;
    L_0x011f:
        r6 = 0;
    L_0x0120:
        r0 = r18;
        r7 = r0.ys;
        r7 = r7 + -1;
        r16 = r7;
        r7 = r9;
        r9 = r16;
        r17 = r8;
        r8 = r5;
        r5 = r17;
    L_0x0130:
        if (r9 < 0) goto L_0x01b4;
    L_0x0132:
        r15 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1));
        if (r15 < 0) goto L_0x017e;
    L_0x0136:
        if (r9 >= r11) goto L_0x017e;
    L_0x0138:
        if (r2 == 0) goto L_0x01b4;
    L_0x013a:
        r15 = r2.position;
        if (r9 != r15) goto L_0x0164;
    L_0x013e:
        r15 = r2.zl;
        if (r15 != 0) goto L_0x0164;
    L_0x0142:
        r0 = r18;
        r15 = r0.eh;
        r15.remove(r5);
        r0 = r18;
        r15 = r0.yr;
        r2 = r2.zk;
        r0 = r18;
        r15.a(r0, r9, r2);
        r5 = r5 + -1;
        r8 = r8 + -1;
        if (r5 < 0) goto L_0x017c;
    L_0x015a:
        r0 = r18;
        r2 = r0.eh;
        r2 = r2.get(r5);
        r2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.b) r2;
    L_0x0164:
        r9 = r9 + -1;
        goto L_0x0130;
    L_0x0167:
        r2 = r5 + 1;
        r5 = r2;
        goto L_0x00d5;
    L_0x016c:
        r2 = 0;
        goto L_0x0119;
    L_0x016e:
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r7 = r10.zm;
        r6 = r6 - r7;
        r7 = r18.getPaddingLeft();
        r7 = (float) r7;
        r15 = (float) r14;
        r7 = r7 / r15;
        r6 = r6 + r7;
        goto L_0x0120;
    L_0x017c:
        r2 = 0;
        goto L_0x0164;
    L_0x017e:
        if (r2 == 0) goto L_0x0198;
    L_0x0180:
        r15 = r2.position;
        if (r9 != r15) goto L_0x0198;
    L_0x0184:
        r2 = r2.zm;
        r7 = r7 + r2;
        r5 = r5 + -1;
        if (r5 < 0) goto L_0x0196;
    L_0x018b:
        r0 = r18;
        r2 = r0.eh;
        r2 = r2.get(r5);
        r2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.b) r2;
        goto L_0x0164;
    L_0x0196:
        r2 = 0;
        goto L_0x0164;
    L_0x0198:
        r2 = r5 + 1;
        r0 = r18;
        r2 = r0.cW(r9, r2);
        r2 = r2.zm;
        r7 = r7 + r2;
        r8 = r8 + 1;
        if (r5 < 0) goto L_0x01b2;
    L_0x01a7:
        r0 = r18;
        r2 = r0.eh;
        r2 = r2.get(r5);
        r2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.b) r2;
        goto L_0x0164;
    L_0x01b2:
        r2 = 0;
        goto L_0x0164;
    L_0x01b4:
        r6 = r10.zm;
        r9 = r8 + 1;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x0286;
    L_0x01be:
        r0 = r18;
        r2 = r0.eh;
        r2 = r2.size();
        if (r9 >= r2) goto L_0x0228;
    L_0x01c8:
        r0 = r18;
        r2 = r0.eh;
        r2 = r2.get(r9);
        r2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.b) r2;
        r7 = r2;
    L_0x01d3:
        if (r14 > 0) goto L_0x022a;
    L_0x01d5:
        r2 = 0;
        r5 = r2;
    L_0x01d7:
        r0 = r18;
        r2 = r0.ys;
        r2 = r2 + 1;
        r16 = r7;
        r7 = r9;
        r9 = r2;
        r2 = r16;
    L_0x01e3:
        if (r9 >= r12) goto L_0x0286;
    L_0x01e5:
        r11 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        if (r11 < 0) goto L_0x0238;
    L_0x01e9:
        if (r9 <= r13) goto L_0x0238;
    L_0x01eb:
        if (r2 == 0) goto L_0x0286;
    L_0x01ed:
        r11 = r2.position;
        if (r9 != r11) goto L_0x031b;
    L_0x01f1:
        r11 = r2.zl;
        if (r11 != 0) goto L_0x031b;
    L_0x01f5:
        r0 = r18;
        r11 = r0.eh;
        r11.remove(r7);
        r0 = r18;
        r11 = r0.yr;
        r2 = r2.zk;
        r0 = r18;
        r11.a(r0, r9, r2);
        r0 = r18;
        r2 = r0.eh;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x0236;
    L_0x0211:
        r0 = r18;
        r2 = r0.eh;
        r2 = r2.get(r7);
        r2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.b) r2;
    L_0x021b:
        r16 = r6;
        r6 = r2;
        r2 = r16;
    L_0x0220:
        r9 = r9 + 1;
        r16 = r2;
        r2 = r6;
        r6 = r16;
        goto L_0x01e3;
    L_0x0228:
        r7 = 0;
        goto L_0x01d3;
    L_0x022a:
        r2 = r18.getPaddingRight();
        r2 = (float) r2;
        r5 = (float) r14;
        r2 = r2 / r5;
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r2 + r5;
        r5 = r2;
        goto L_0x01d7;
    L_0x0236:
        r2 = 0;
        goto L_0x021b;
    L_0x0238:
        if (r2 == 0) goto L_0x025f;
    L_0x023a:
        r11 = r2.position;
        if (r9 != r11) goto L_0x025f;
    L_0x023e:
        r2 = r2.zm;
        r6 = r6 + r2;
        r7 = r7 + 1;
        r0 = r18;
        r2 = r0.eh;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x025d;
    L_0x024d:
        r0 = r18;
        r2 = r0.eh;
        r2 = r2.get(r7);
        r2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.b) r2;
    L_0x0257:
        r16 = r6;
        r6 = r2;
        r2 = r16;
        goto L_0x0220;
    L_0x025d:
        r2 = 0;
        goto L_0x0257;
    L_0x025f:
        r0 = r18;
        r2 = r0.cW(r9, r7);
        r7 = r7 + 1;
        r2 = r2.zm;
        r6 = r6 + r2;
        r0 = r18;
        r2 = r0.eh;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x0284;
    L_0x0274:
        r0 = r18;
        r2 = r0.eh;
        r2 = r2.get(r7);
        r2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.b) r2;
    L_0x027e:
        r16 = r6;
        r6 = r2;
        r2 = r16;
        goto L_0x0220;
    L_0x0284:
        r2 = 0;
        goto L_0x027e;
    L_0x0286:
        r0 = r18;
        r0.a(r10, r8, r4);
    L_0x028b:
        r0 = r18;
        r4 = r0.yr;
        if (r10 == 0) goto L_0x02d2;
    L_0x0291:
        r2 = r10.zk;
    L_0x0293:
        r4.d(r2);
        r0 = r18;
        r2 = r0.yr;
        r2.ba();
        r5 = r18.getChildCount();
        r2 = 0;
        r4 = r2;
    L_0x02a3:
        if (r4 >= r5) goto L_0x02d4;
    L_0x02a5:
        r0 = r18;
        r6 = r0.getChildAt(r4);
        r2 = r6.getLayoutParams();
        r2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.LayoutParams) r2;
        r2.zq = r4;
        r7 = r2.zo;
        if (r7 != 0) goto L_0x02ce;
    L_0x02b7:
        r7 = r2.zm;
        r8 = 0;
        r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1));
        if (r7 != 0) goto L_0x02ce;
    L_0x02be:
        r0 = r18;
        r6 = r0.cr(r6);
        if (r6 == 0) goto L_0x02ce;
    L_0x02c6:
        r7 = r6.zm;
        r2.zm = r7;
        r6 = r6.position;
        r2.position = r6;
    L_0x02ce:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x02a3;
    L_0x02d2:
        r2 = 0;
        goto L_0x0293;
    L_0x02d4:
        r18.bR();
        r2 = r18.hasFocus();
        if (r2 == 0) goto L_0x002f;
    L_0x02dd:
        r2 = r18.findFocus();
        if (r2 == 0) goto L_0x0319;
    L_0x02e3:
        r0 = r18;
        r2 = r0.cs(r2);
    L_0x02e9:
        if (r2 == 0) goto L_0x02f3;
    L_0x02eb:
        r2 = r2.position;
        r0 = r18;
        r4 = r0.ys;
        if (r2 == r4) goto L_0x002f;
    L_0x02f3:
        r2 = 0;
    L_0x02f4:
        r4 = r18.getChildCount();
        if (r2 >= r4) goto L_0x002f;
    L_0x02fa:
        r0 = r18;
        r4 = r0.getChildAt(r2);
        r0 = r18;
        r5 = r0.cr(r4);
        if (r5 == 0) goto L_0x0316;
    L_0x0308:
        r5 = r5.position;
        r0 = r18;
        r6 = r0.ys;
        if (r5 != r6) goto L_0x0316;
    L_0x0310:
        r4 = r4.requestFocus(r3);
        if (r4 != 0) goto L_0x002f;
    L_0x0316:
        r2 = r2 + 1;
        goto L_0x02f4;
    L_0x0319:
        r2 = 0;
        goto L_0x02e9;
    L_0x031b:
        r16 = r6;
        r6 = r2;
        r2 = r16;
        goto L_0x0220;
    L_0x0322:
        r10 = r2;
        goto L_0x0108;
    L_0x0325:
        r2 = r6;
        goto L_0x00f9;
    L_0x0328:
        r4 = r3;
        r3 = r2;
        goto L_0x0026;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.Z(int):void");
    }

    private void bR() {
        if (this.zf != 0) {
            if (this.zg == null) {
                this.zg = new ArrayList();
            } else {
                this.zg.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.zg.add(getChildAt(i));
            }
            Collections.sort(this.zg, qln);
        }
    }

    private void a(b bVar, int i, b bVar2) {
        float f;
        int i2;
        b bVar3;
        float f2;
        int i3;
        int count = this.yr.getCount();
        int bP = bP();
        if (bP > 0) {
            f = ((float) this.yz) / ((float) bP);
        } else {
            f = 0.0f;
        }
        if (bVar2 != null) {
            bP = bVar2.position;
            float f3;
            int i4;
            int i5;
            if (bP < bVar.position) {
                f3 = (bVar2.zn + bVar2.zm) + f;
                i2 = 0;
                i4 = bP + 1;
                while (i4 <= bVar.position && i2 < this.eh.size()) {
                    bVar3 = (b) this.eh.get(i2);
                    while (i4 > bVar3.position && i2 < this.eh.size() - 1) {
                        i2++;
                        bVar3 = (b) this.eh.get(i2);
                    }
                    i5 = i4;
                    f2 = f3;
                    i3 = i5;
                    while (i3 < bVar3.position) {
                        i3++;
                        f2 = (1.0f + f) + f2;
                    }
                    bVar3.zn = f2;
                    f2 += bVar3.zm + f;
                    bP = i3 + 1;
                    f3 = f2;
                    i4 = bP;
                }
            } else if (bP > bVar.position) {
                i2 = this.eh.size() - 1;
                f3 = bVar2.zn;
                i4 = bP - 1;
                while (i4 >= bVar.position && i2 >= 0) {
                    bVar3 = (b) this.eh.get(i2);
                    while (i4 < bVar3.position && i2 > 0) {
                        i2--;
                        bVar3 = (b) this.eh.get(i2);
                    }
                    i5 = i4;
                    f2 = f3;
                    i3 = i5;
                    while (i3 > bVar3.position) {
                        i3--;
                        f2 -= 1.0f + f;
                    }
                    f2 -= bVar3.zm + f;
                    bVar3.zn = f2;
                    bP = i3 - 1;
                    f3 = f2;
                    i4 = bP;
                }
            }
        }
        int size = this.eh.size();
        f2 = bVar.zn;
        i3 = bVar.position - 1;
        this.yD = bVar.position == 0 ? bVar.zn : -3.4028235E38f;
        this.yE = bVar.position == count + -1 ? (bVar.zn + bVar.zm) - 1.0f : Float.MAX_VALUE;
        for (i2 = i - 1; i2 >= 0; i2--) {
            bVar3 = (b) this.eh.get(i2);
            while (i3 > bVar3.position) {
                i3--;
                f2 -= 1.0f + f;
            }
            f2 -= bVar3.zm + f;
            bVar3.zn = f2;
            if (bVar3.position == 0) {
                this.yD = f2;
            }
            i3--;
        }
        f2 = (bVar.zn + bVar.zm) + f;
        i3 = bVar.position + 1;
        for (i2 = i + 1; i2 < size; i2++) {
            bVar3 = (b) this.eh.get(i2);
            while (i3 < bVar3.position) {
                i3++;
                f2 += 1.0f + f;
            }
            if (bVar3.position == count - 1) {
                this.yE = (bVar3.zm + f2) - 1.0f;
            }
            bVar3.zn = f2;
            f2 += bVar3.zm + f;
            i3++;
        }
        this.yX = false;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.position = this.ys;
        if (this.yr != null) {
            savedState.zr = this.yr.bb();
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (this.yr != null) {
                this.yr.a(savedState.zr, savedState.zt);
                a(savedState.position, false, true);
                return;
            }
            this.yt = savedState.position;
            this.yu = savedState.zr;
            this.yv = savedState.zt;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        android.view.ViewGroup.LayoutParams layoutParams2;
        if (checkLayoutParams(layoutParams)) {
            layoutParams2 = layoutParams;
        } else {
            layoutParams2 = generateLayoutParams(layoutParams);
        }
        Assert.assertNotNull(layoutParams2);
        LayoutParams layoutParams3 = (LayoutParams) layoutParams2;
        layoutParams3.zo |= view instanceof a;
        if (!this.pd) {
            super.addView(view, i, layoutParams2);
        } else if (layoutParams3 == null || !layoutParams3.zo) {
            layoutParams3.zp = true;
            addViewInLayout(view, i, layoutParams2);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    public void removeView(View view) {
        if (this.pd) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    private b cr(View view) {
        for (int i = 0; i < this.eh.size(); i++) {
            b bVar = (b) this.eh.get(i);
            if (this.yr.a(view, bVar.zk)) {
                return bVar;
            }
        }
        return null;
    }

    private b cs(View view) {
        while (true) {
            AdLandingViewPager parent = view.getParent();
            if (parent == this) {
                return cr(view);
            }
            if (parent != null && (parent instanceof View)) {
                view = parent;
            }
        }
        return null;
    }

    private b ty(int i) {
        for (int i2 = 0; i2 < this.eh.size(); i2++) {
            b bVar = (b) this.eh.get(i2);
            if (bVar.position == i) {
                return bVar;
            }
        }
        return null;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.yW = true;
    }

    protected void onMeasure(int i, int i2) {
        LayoutParams layoutParams;
        int i3;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.yM = Math.min(measuredWidth / 10, this.yL);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            int i5;
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams != null && layoutParams.zo) {
                    int i6 = layoutParams.gravity & 7;
                    int i7 = layoutParams.gravity & MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
                    i3 = Integer.MIN_VALUE;
                    i5 = Integer.MIN_VALUE;
                    Object obj = (i7 == 48 || i7 == 80) ? 1 : null;
                    Object obj2 = (i6 == 3 || i6 == 5) ? 1 : null;
                    if (obj != null) {
                        i3 = 1073741824;
                    } else if (obj2 != null) {
                        i5 = 1073741824;
                    }
                    if (layoutParams.width != -2) {
                        i7 = 1073741824;
                        i3 = layoutParams.width != -1 ? layoutParams.width : paddingLeft;
                    } else {
                        i7 = i3;
                        i3 = paddingLeft;
                    }
                    if (layoutParams.height != -2) {
                        i5 = 1073741824;
                        if (layoutParams.height != -1) {
                            measuredWidth = layoutParams.height;
                            childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                            if (obj != null) {
                                measuredHeight -= childAt.getMeasuredHeight();
                            } else if (obj2 != null) {
                                paddingLeft -= childAt.getMeasuredWidth();
                            }
                        }
                    }
                    measuredWidth = measuredHeight;
                    childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                    if (obj != null) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (obj2 != null) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
            }
        }
        this.yF = MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.yG = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.pd = true;
        populate();
        this.pd = false;
        i3 = getChildCount();
        for (i5 = 0; i5 < i3; i5++) {
            View childAt2 = getChildAt(i5);
            if (childAt2.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if ((layoutParams == null || !layoutParams.zo) && layoutParams != null) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (layoutParams.zm * ((float) paddingLeft)), 1073741824), this.yG);
                }
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            int i5 = this.yz;
            int i6 = this.yz;
            if (i3 <= 0 || this.eh.isEmpty()) {
                b ty = ty(this.ys);
                i5 = (int) ((ty != null ? Math.min(ty.zn, this.yE) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
                if (i5 != getScrollX()) {
                    r(false);
                    scrollTo(i5, getScrollY());
                    return;
                }
                return;
            }
            i6 = (int) (((float) (i5 + ((i - getPaddingLeft()) - getPaddingRight()))) * (((float) getScrollX()) / ((float) (i6 + ((i3 - getPaddingLeft()) - getPaddingRight())))));
            scrollTo(i6, getScrollY());
            if (!this.yw.isFinished()) {
                this.yw.startScroll(i6, 0, (int) (ty(this.ys).zn * ((float) i)), 0, this.yw.getDuration() - this.yw.timePassed());
            }
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int max;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = 0;
        int i8 = 0;
        while (i8 < childCount) {
            LayoutParams layoutParams;
            int measuredWidth;
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.zo) {
                    int i9 = layoutParams.gravity & MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
                    switch (layoutParams.gravity & 7) {
                        case 1:
                            max = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 3:
                            max = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case 5:
                            measuredWidth = (i5 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            max = measuredWidth;
                            break;
                        default:
                            max = paddingLeft;
                            break;
                    }
                    int i10;
                    switch (i9) {
                        case 16:
                            measuredWidth = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        case 48:
                            measuredWidth = childAt.getMeasuredHeight() + paddingTop;
                            i10 = paddingTop;
                            paddingTop = paddingBottom;
                            paddingBottom = measuredWidth;
                            measuredWidth = i10;
                            break;
                        case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*80*/:
                            measuredWidth = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                            i10 = paddingBottom + childAt.getMeasuredHeight();
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        default:
                            measuredWidth = paddingTop;
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                    }
                    max += scrollX;
                    childAt.layout(max, measuredWidth, childAt.getMeasuredWidth() + max, childAt.getMeasuredHeight() + measuredWidth);
                    measuredWidth = i7 + 1;
                    i7 = paddingBottom;
                    paddingBottom = paddingTop;
                    paddingTop = paddingRight;
                    paddingRight = paddingLeft;
                    i8++;
                    paddingLeft = paddingRight;
                    paddingRight = paddingTop;
                    paddingTop = i7;
                    i7 = measuredWidth;
                }
            }
            measuredWidth = i7;
            i7 = paddingTop;
            paddingTop = paddingRight;
            paddingRight = paddingLeft;
            i8++;
            paddingLeft = paddingRight;
            paddingRight = paddingTop;
            paddingTop = i7;
            i7 = measuredWidth;
        }
        max = (i5 - paddingLeft) - paddingRight;
        for (paddingRight = 0; paddingRight < childCount; paddingRight++) {
            View childAt2 = getChildAt(paddingRight);
            if (childAt2.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams.zo) {
                    b cr = cr(childAt2);
                    if (cr != null) {
                        i5 = ((int) (cr.zn * ((float) max))) + paddingLeft;
                        if (layoutParams.zp) {
                            layoutParams.zp = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (layoutParams.zm * ((float) max)), 1073741824), MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, 1073741824));
                        }
                        childAt2.layout(i5, paddingTop, childAt2.getMeasuredWidth() + i5, childAt2.getMeasuredHeight() + paddingTop);
                    }
                }
            }
        }
        this.yB = paddingTop;
        this.yC = i6 - paddingBottom;
        this.yZ = i7;
        if (this.yW) {
            a(this.ys, false, 0, false);
        }
        this.yW = false;
    }

    public void computeScroll() {
        if (this.yw.isFinished() || !this.yw.computeScrollOffset()) {
            r(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.yw.getCurrX();
        int currY = this.yw.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!ab(currX)) {
                this.yw.abortAnimation();
                scrollTo(0, currY);
            }
        }
        z.F(this);
    }

    final boolean ab(int i) {
        if (this.eh.size() == 0) {
            this.yY = false;
            a(0, 0.0f, 0);
            if (this.yY) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        b bgI = bgI();
        int bP = bP();
        int i2 = this.yz + bP;
        float f = ((float) this.yz) / ((float) bP);
        int i3 = bgI.position;
        float f2 = ((((float) i) / ((float) bP)) - bgI.zn) / (bgI.zm + f);
        bP = (int) (((float) i2) * f2);
        this.yY = false;
        a(i3, f2, bP);
        if (this.yY) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private void a(int i, float f, int i2) {
        int paddingLeft;
        int paddingRight;
        int i3;
        if (this.yZ > 0) {
            int scrollX = getScrollX();
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            i3 = 0;
            while (i3 < childCount) {
                int i4;
                View childAt = getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.zo) {
                    int max;
                    switch (layoutParams.gravity & 7) {
                        case 1:
                            max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        case 3:
                            max = childAt.getWidth() + paddingLeft;
                            i4 = paddingLeft;
                            paddingLeft = paddingRight;
                            paddingRight = max;
                            max = i4;
                            break;
                        case 5:
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            i4 = paddingRight + childAt.getMeasuredWidth();
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        default:
                            max = paddingLeft;
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                    }
                    max = (max + scrollX) - childAt.getLeft();
                    if (max != 0) {
                        childAt.offsetLeftAndRight(max);
                    }
                } else {
                    i4 = paddingRight;
                    paddingRight = paddingLeft;
                    paddingLeft = i4;
                }
                i3++;
                i4 = paddingLeft;
                paddingLeft = paddingRight;
                paddingRight = i4;
            }
        }
        if (this.zb != null) {
            this.zb.a(i, f, i2);
        }
        if (this.zc != null) {
            this.zc.a(i, f, i2);
        }
        if (this.ze != null) {
            paddingRight = getScrollX();
            i3 = getChildCount();
            for (paddingLeft = 0; paddingLeft < i3; paddingLeft++) {
                View childAt2 = getChildAt(paddingLeft);
                if (!((LayoutParams) childAt2.getLayoutParams()).zo) {
                    this.ze.h(childAt2, ((float) (childAt2.getLeft() - paddingRight)) / ((float) bP()));
                }
            }
        }
        this.yY = true;
    }

    private void r(boolean z) {
        int scrollX;
        boolean z2 = this.xV == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            this.yw.abortAnimation();
            scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.yw.getCurrX();
            int currY = this.yw.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
            }
        }
        this.yI = false;
        boolean z3 = z2;
        for (scrollX = 0; scrollX < this.eh.size(); scrollX++) {
            b bVar = (b) this.eh.get(scrollX);
            if (bVar.zl) {
                bVar.zl = false;
                z3 = true;
            }
        }
        if (!z3) {
            return;
        }
        if (z) {
            z.a(this, this.zi);
        } else {
            this.zi.run();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.iC = false;
            this.yK = false;
            this.fl = -1;
            if (this.fk == null) {
                return false;
            }
            this.fk.recycle();
            this.fk = null;
            return false;
        }
        if (action != 0) {
            if (this.iC) {
                return true;
            }
            if (this.yK) {
                return false;
            }
        }
        float x;
        switch (action) {
            case 0:
                x = motionEvent.getX();
                this.xC = x;
                this.yN = x;
                x = motionEvent.getY();
                this.xD = x;
                this.yO = x;
                this.fl = o.c(motionEvent, 0);
                this.yK = false;
                this.yw.computeScrollOffset();
                if (this.xV == 2 && Math.abs(this.yw.getFinalX() - this.yw.getCurrX()) > this.yS) {
                    this.yw.abortAnimation();
                    this.yI = false;
                    populate();
                    this.iC = true;
                    X(1);
                    break;
                }
                r(false);
                this.iC = false;
                break;
            case 2:
                action = this.fl;
                if (action != -1) {
                    action = o.b(motionEvent, action);
                    float d = o.d(motionEvent, action);
                    float f = d - this.yN;
                    float abs = Math.abs(f);
                    float e = o.e(motionEvent, action);
                    float abs2 = Math.abs(e - this.xD);
                    if (f != 0.0f) {
                        x = this.yN;
                        boolean z = (x < ((float) this.yM) && f > 0.0f) || (x > ((float) (getWidth() - this.yM)) && f < 0.0f);
                        if (!z && a(this, false, (int) f, (int) d, (int) e)) {
                            this.yN = d;
                            this.yO = e;
                            this.yK = true;
                            return false;
                        }
                    }
                    if (abs > ((float) this.iE) && 0.5f * abs > abs2) {
                        this.iC = true;
                        X(1);
                        this.yN = f > 0.0f ? this.xC + ((float) this.iE) : this.xC - ((float) this.iE);
                        this.yO = e;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > ((float) this.iE)) {
                        this.yK = true;
                    }
                    if (this.iC && o(d)) {
                        z.F(this);
                        break;
                    }
                }
                break;
            case 6:
                h(motionEvent);
                break;
        }
        if (this.fk == null) {
            this.fk = VelocityTracker.obtain();
        }
        this.fk.addMovement(motionEvent);
        return this.iC;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.yT) {
            return true;
        }
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || this.yr == null || this.yr.getCount() == 0) {
            return false;
        }
        if (this.fk == null) {
            this.fk = VelocityTracker.obtain();
        }
        this.fk.addMovement(motionEvent);
        float x;
        int bP;
        float f;
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.yw.abortAnimation();
                this.yI = false;
                populate();
                this.iC = true;
                X(1);
                x = motionEvent.getX();
                this.xC = x;
                this.yN = x;
                x = motionEvent.getY();
                this.xD = x;
                this.yO = x;
                this.fl = o.c(motionEvent, 0);
                break;
            case 1:
                if (this.iC) {
                    VelocityTracker velocityTracker = this.fk;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.yQ);
                    int a = (int) y.a(velocityTracker, this.fl);
                    this.yI = true;
                    bP = bP();
                    int scrollX = getScrollX();
                    b bgI = bgI();
                    int i = bgI.position;
                    f = ((((float) scrollX) / ((float) bP)) - bgI.zn) / bgI.zm;
                    bP = o.b(motionEvent, this.fl);
                    if (bP < 0) {
                        bP = 0;
                    }
                    a(a(i, f, a, (int) (o.d(motionEvent, bP) - this.xC)), true, true, a);
                    this.fl = -1;
                    cz();
                    z = this.yV.cr() | this.yU.cr();
                    break;
                }
                break;
            case 2:
                if (!this.iC) {
                    bP = o.b(motionEvent, this.fl);
                    float d = o.d(motionEvent, bP);
                    f = Math.abs(d - this.yN);
                    float e = o.e(motionEvent, bP);
                    x = Math.abs(e - this.yO);
                    if (f > ((float) this.iE) && f > x) {
                        this.iC = true;
                        if (d - this.xC > 0.0f) {
                            x = this.xC + ((float) this.iE);
                        } else {
                            x = this.xC - ((float) this.iE);
                        }
                        this.yN = x;
                        this.yO = e;
                        X(1);
                        setScrollingCacheEnabled(true);
                    }
                }
                if (this.iC) {
                    z = o(o.d(motionEvent, o.b(motionEvent, this.fl))) | 0;
                    break;
                }
                break;
            case 3:
                if (this.iC) {
                    a(this.ys, true, 0, false);
                    this.fl = -1;
                    cz();
                    z = this.yV.cr() | this.yU.cr();
                    break;
                }
                break;
            case 5:
                bP = o.e(motionEvent);
                this.yN = o.d(motionEvent, bP);
                this.fl = o.c(motionEvent, bP);
                break;
            case 6:
                h(motionEvent);
                this.yN = o.d(motionEvent, o.b(motionEvent, this.fl));
                break;
        }
        if (z) {
            z.F(this);
        }
        return true;
    }

    private boolean o(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = false;
        float f3 = this.yN - f;
        this.yN = f;
        float scrollX = ((float) getScrollX()) + f3;
        int bP = bP();
        float f4 = ((float) bP) * this.yD;
        float f5 = ((float) bP) * this.yE;
        b bVar = (b) this.eh.get(0);
        b bVar2 = (b) this.eh.get(this.eh.size() - 1);
        if (bVar.position != 0) {
            f4 = bVar.zn * ((float) bP);
            z = false;
        } else {
            z = true;
        }
        if (bVar2.position != this.yr.getCount() - 1) {
            f2 = bVar2.zn * ((float) bP);
            z2 = false;
        } else {
            f2 = f5;
        }
        if (scrollX < f4) {
            if (z) {
                z3 = this.yU.u(Math.abs(f4 - scrollX) / ((float) bP));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.yV.u(Math.abs(scrollX - f2) / ((float) bP));
            }
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.yN += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        ab((int) f4);
        return z3;
    }

    final b bgI() {
        float f;
        int bP = bP();
        float scrollX = bP > 0 ? ((float) getScrollX()) / ((float) bP) : 0.0f;
        if (bP > 0) {
            f = ((float) this.yz) / ((float) bP);
        } else {
            f = 0.0f;
        }
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = -1;
        int i2 = 0;
        Object obj = 1;
        b bVar = null;
        while (i2 < this.eh.size()) {
            int i3;
            b bVar2;
            b bVar3 = (b) this.eh.get(i2);
            b bVar4;
            if (obj != null || bVar3.position == i + 1) {
                bVar4 = bVar3;
                i3 = i2;
                bVar2 = bVar4;
            } else {
                bVar3 = this.qlj;
                bVar3.zn = (f2 + f3) + f;
                bVar3.position = i + 1;
                bVar3.zm = 1.0f;
                bVar4 = bVar3;
                i3 = i2 - 1;
                bVar2 = bVar4;
            }
            f2 = bVar2.zn;
            f3 = (bVar2.zm + f2) + f;
            if (obj == null && scrollX < f2) {
                return bVar;
            }
            if (scrollX < f3 || i3 == this.eh.size() - 1) {
                return bVar2;
            }
            f3 = f2;
            i = bVar2.position;
            obj = null;
            f2 = bVar2.zm;
            bVar = bVar2;
            i2 = i3 + 1;
        }
        return bVar;
    }

    final int a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.yR || Math.abs(i2) <= this.yP) {
            i = (int) ((i >= this.ys ? 0.85f : 0.15f) + (((float) i) + f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.eh.size() > 0) {
            return Math.max(((b) this.eh.get(0)).position, Math.min(i, ((b) this.eh.get(this.eh.size() - 1)).position));
        }
        return i;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int i = 0;
        int C = z.C(this);
        if (C == 0 || (C == 1 && this.yr != null && this.yr.getCount() > 1)) {
            int width;
            if (!this.yU.isFinished()) {
                C = canvas.save();
                i = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-i) + getPaddingTop()), this.yD * ((float) width));
                this.yU.setSize(i, width);
                i = this.yU.draw(canvas) | 0;
                canvas.restoreToCount(C);
            }
            if (!this.yV.isFinished()) {
                C = canvas.save();
                width = getWidth();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.yE + 1.0f)) * ((float) width));
                this.yV.setSize(height, width);
                i |= this.yV.draw(canvas);
                canvas.restoreToCount(C);
            }
        } else {
            this.yU.finish();
            this.yV.finish();
        }
        if (i != 0) {
            z.F(this);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.yz > 0 && this.yA != null && this.eh.size() > 0 && this.yr != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.yz) / ((float) width);
            b bVar = (b) this.eh.get(0);
            float f2 = bVar.zn;
            int size = this.eh.size();
            int i = bVar.position;
            int i2 = ((b) this.eh.get(size - 1)).position;
            int i3 = 0;
            int i4 = i;
            while (i4 < i2) {
                float f3;
                while (i4 > bVar.position && i3 < size) {
                    i3++;
                    bVar = (b) this.eh.get(i3);
                }
                if (i4 == bVar.position) {
                    f3 = (bVar.zn + bVar.zm) * ((float) width);
                    f2 = (bVar.zn + bVar.zm) + f;
                } else {
                    f3 = (1.0f + f2) * ((float) width);
                    f2 += 1.0f + f;
                }
                if (((float) this.yz) + f3 > ((float) scrollX)) {
                    this.yA.setBounds((int) f3, this.yB, (int) ((((float) this.yz) + f3) + 0.5f), this.yC);
                    this.yA.draw(canvas);
                }
                if (f3 <= ((float) (scrollX + width))) {
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    public final boolean bgJ() {
        if (this.iC) {
            return false;
        }
        this.yT = true;
        X(1);
        this.yN = 0.0f;
        this.xC = 0.0f;
        if (this.fk == null) {
            this.fk = VelocityTracker.obtain();
        } else {
            this.fk.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.fk.addMovement(obtain);
        obtain.recycle();
        this.qll = uptimeMillis;
        return true;
    }

    private void h(MotionEvent motionEvent) {
        int e = o.e(motionEvent);
        if (o.c(motionEvent, e) == this.fl) {
            e = e == 0 ? 1 : 0;
            this.yN = o.d(motionEvent, e);
            this.fl = o.c(motionEvent, e);
            if (this.fk != null) {
                this.fk.clear();
            }
        }
    }

    final void cz() {
        this.iC = false;
        this.yK = false;
        if (this.fk != null) {
            this.fk.recycle();
            this.fk = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.yH != z) {
            this.yH = z;
        }
    }

    public boolean canScrollHorizontally(int i) {
        if (this.yr == null) {
            return false;
        }
        int bP = bP();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX > ((int) (((float) bP) * this.yD))) {
                return true;
            }
            return false;
        } else if (i <= 0 || scrollX >= ((int) (((float) bP) * this.yE))) {
            return false;
        } else {
            return true;
        }
    }

    private boolean a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (z && z.g(view, -i)) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchKeyEvent(android.view.KeyEvent r5) {
        /*
        r4 = this;
        r0 = 0;
        r1 = 1;
        r2 = super.dispatchKeyEvent(r5);
        if (r2 != 0) goto L_0x0018;
    L_0x0008:
        r2 = r5.getAction();
        if (r2 != 0) goto L_0x0015;
    L_0x000e:
        r2 = r5.getKeyCode();
        switch(r2) {
            case 21: goto L_0x001a;
            case 22: goto L_0x0021;
            case 61: goto L_0x0028;
            default: goto L_0x0015;
        };
    L_0x0015:
        r2 = r0;
    L_0x0016:
        if (r2 == 0) goto L_0x0019;
    L_0x0018:
        r0 = r1;
    L_0x0019:
        return r0;
    L_0x001a:
        r2 = 17;
        r2 = r4.arrowScroll(r2);
        goto L_0x0016;
    L_0x0021:
        r2 = 66;
        r2 = r4.arrowScroll(r2);
        goto L_0x0016;
    L_0x0028:
        r2 = android.os.Build.VERSION.SDK_INT;
        r3 = 11;
        if (r2 < r3) goto L_0x0015;
    L_0x002e:
        r2 = android.support.v4.view.g.a(r5);
        if (r2 == 0) goto L_0x003a;
    L_0x0034:
        r2 = 2;
        r2 = r4.arrowScroll(r2);
        goto L_0x0016;
    L_0x003a:
        r2 = android.support.v4.view.g.a(r5, r1);
        if (r2 == 0) goto L_0x0015;
    L_0x0040:
        r2 = r4.arrowScroll(r1);
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean arrowScroll(int r10) {
        /*
        r9 = this;
        r1 = 0;
        r8 = 66;
        r7 = 17;
        r4 = 1;
        r3 = 0;
        r2 = r9.findFocus();
        if (r2 != r9) goto L_0x003e;
    L_0x000d:
        r0 = r1;
    L_0x000e:
        r1 = android.view.FocusFinder.getInstance();
        r1 = r1.findNextFocus(r9, r0, r10);
        if (r1 == 0) goto L_0x00b3;
    L_0x0018:
        if (r1 == r0) goto L_0x00b3;
    L_0x001a:
        if (r10 != r7) goto L_0x0098;
    L_0x001c:
        r2 = r9.eq;
        r2 = r9.a(r2, r1);
        r2 = r2.left;
        r3 = r9.eq;
        r3 = r9.a(r3, r0);
        r3 = r3.left;
        if (r0 == 0) goto L_0x0093;
    L_0x002e:
        if (r2 < r3) goto L_0x0093;
    L_0x0030:
        r0 = r9.bV();
    L_0x0034:
        if (r0 == 0) goto L_0x003d;
    L_0x0036:
        r1 = android.view.SoundEffectConstants.getContantForFocusDirection(r10);
        r9.playSoundEffect(r1);
    L_0x003d:
        return r0;
    L_0x003e:
        if (r2 == 0) goto L_0x00cb;
    L_0x0040:
        r0 = r2.getParent();
    L_0x0044:
        r5 = r0 instanceof android.view.ViewGroup;
        if (r5 == 0) goto L_0x00ce;
    L_0x0048:
        if (r0 != r9) goto L_0x007c;
    L_0x004a:
        r0 = r4;
    L_0x004b:
        if (r0 != 0) goto L_0x00cb;
    L_0x004d:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r0 = r2.getClass();
        r0 = r0.getSimpleName();
        r5.append(r0);
        r0 = r2.getParent();
    L_0x0061:
        r2 = r0 instanceof android.view.ViewGroup;
        if (r2 == 0) goto L_0x0081;
    L_0x0065:
        r2 = " => ";
        r2 = r5.append(r2);
        r6 = r0.getClass();
        r6 = r6.getSimpleName();
        r2.append(r6);
        r0 = r0.getParent();
        goto L_0x0061;
    L_0x007c:
        r0 = r0.getParent();
        goto L_0x0044;
    L_0x0081:
        r0 = new java.lang.StringBuilder;
        r2 = "arrowScroll tried to find focus based on non-child current focused view ";
        r0.<init>(r2);
        r2 = r5.toString();
        r0.append(r2);
        r0 = r1;
        goto L_0x000e;
    L_0x0093:
        r0 = r1.requestFocus();
        goto L_0x0034;
    L_0x0098:
        if (r10 != r8) goto L_0x00c8;
    L_0x009a:
        r2 = r9.eq;
        r2 = r9.a(r2, r1);
        r2 = r2.left;
        r3 = r9.eq;
        r3 = r9.a(r3, r0);
        r3 = r3.left;
        if (r0 == 0) goto L_0x00ae;
    L_0x00ac:
        if (r2 <= r3) goto L_0x00c2;
    L_0x00ae:
        r0 = r1.requestFocus();
        goto L_0x0034;
    L_0x00b3:
        if (r10 == r7) goto L_0x00b7;
    L_0x00b5:
        if (r10 != r4) goto L_0x00bd;
    L_0x00b7:
        r0 = r9.bV();
        goto L_0x0034;
    L_0x00bd:
        if (r10 == r8) goto L_0x00c2;
    L_0x00bf:
        r0 = 2;
        if (r10 != r0) goto L_0x00c8;
    L_0x00c2:
        r0 = r9.bW();
        goto L_0x0034;
    L_0x00c8:
        r0 = r3;
        goto L_0x0034;
    L_0x00cb:
        r0 = r2;
        goto L_0x000e;
    L_0x00ce:
        r0 = r3;
        goto L_0x004b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.arrowScroll(int):boolean");
    }

    private Rect a(Rect rect, View view) {
        Rect rect2;
        if (rect == null) {
            rect2 = new Rect();
        } else {
            rect2 = rect;
        }
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        AdLandingViewPager parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    private boolean bV() {
        if (this.ys <= 0) {
            return false;
        }
        k(this.ys - 1, true);
        return true;
    }

    private boolean bW() {
        if (this.yr == null || this.ys >= this.yr.getCount() - 1) {
            return false;
        }
        k(this.ys + 1, true);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        Assert.assertNotNull(arrayList);
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    b cr = cr(childAt);
                    if (cr != null && cr.position == this.ys) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                b cr = cr(childAt);
                if (cr != null && cr.position == this.ys) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3 = -1;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = 1;
            i2 = childCount;
            childCount = 0;
        } else {
            childCount--;
            i2 = -1;
        }
        while (childCount != i2) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                b cr = cr(childAt);
                if (cr != null && cr.position == this.ys && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            childCount += i3;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == Downloads.RECV_BUFFER_SIZE) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                b cr = cr(childAt);
                if (cr != null && cr.position == this.ys && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
