package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.smtt.sdk.WebView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SlidingPaneLayout extends ViewGroup {
    static final d DL;
    private Drawable DA;
    private final int DB;
    private boolean DC;
    private View DD;
    private float DE;
    private float DF;
    private int DG;
    private int DH;
    private final u DI;
    private boolean DJ;
    private final ArrayList<b> DK;
    private int Dx;
    private int Dy;
    private Drawable Dz;
    private final Rect gG;
    private float xC;
    private float xD;
    private boolean yK;
    private boolean yW;

    public static class LayoutParams extends MarginLayoutParams {
        private static final int[] xQ = new int[]{16843137};
        boolean DO;
        boolean DP;
        Paint DQ;
        public float weight = 0.0f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, xQ);
            this.weight = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean DR;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.DR = parcel.readInt() != 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.DR ? 1 : 0);
        }
    }

    private class b implements Runnable {
        final /* synthetic */ SlidingPaneLayout DM;
        final View DN;

        b(SlidingPaneLayout slidingPaneLayout, View view) {
            this.DM = slidingPaneLayout;
            this.DN = view;
        }

        public final void run() {
            if (this.DN.getParent() == this.DM) {
                z.a(this.DN, 0, null);
                this.DM.aF(this.DN);
            }
            this.DM.DK.remove(this);
        }
    }

    interface d {
        void b(SlidingPaneLayout slidingPaneLayout, View view);
    }

    class a extends android.support.v4.view.a {
        final /* synthetic */ SlidingPaneLayout DM;
        private final Rect gG = new Rect();

        a(SlidingPaneLayout slidingPaneLayout) {
            this.DM = slidingPaneLayout;
        }

        public final void a(View view, android.support.v4.view.a.b bVar) {
            android.support.v4.view.a.b a = android.support.v4.view.a.b.a(bVar);
            super.a(view, a);
            Rect rect = this.gG;
            a.getBoundsInParent(rect);
            bVar.setBoundsInParent(rect);
            a.getBoundsInScreen(rect);
            bVar.setBoundsInScreen(rect);
            bVar.setVisibleToUser(a.isVisibleToUser());
            bVar.setPackageName(a.getPackageName());
            bVar.setClassName(a.getClassName());
            bVar.setContentDescription(a.getContentDescription());
            bVar.setEnabled(a.isEnabled());
            bVar.setClickable(a.isClickable());
            bVar.setFocusable(a.isFocusable());
            bVar.setFocused(a.isFocused());
            bVar.setAccessibilityFocused(a.isAccessibilityFocused());
            bVar.setSelected(a.isSelected());
            bVar.setLongClickable(a.isLongClickable());
            bVar.addAction(a.getActions());
            android.support.v4.view.a.b.zK.d(bVar.zL, android.support.v4.view.a.b.zK.C(a.zL));
            a.recycle();
            bVar.setClassName(SlidingPaneLayout.class.getName());
            bVar.setSource(view);
            ViewParent K = z.K(view);
            if (K instanceof View) {
                bVar.setParent((View) K);
            }
            int childCount = this.DM.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.DM.getChildAt(i);
                if (!aH(childAt) && childAt.getVisibility() == 0) {
                    z.i(childAt, 1);
                    bVar.addChild(childAt);
                }
            }
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (aH(view)) {
                return false;
            }
            return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        private boolean aH(View view) {
            return this.DM.aG(view);
        }
    }

    private class c extends android.support.v4.widget.u.a {
        final /* synthetic */ SlidingPaneLayout DM;

        public c(SlidingPaneLayout slidingPaneLayout) {
            this.DM = slidingPaneLayout;
        }

        public final boolean b(View view, int i) {
            if (this.DM.yK) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).DO;
        }

        public final void j(int i) {
            if (this.DM.DI.EK != 0) {
                return;
            }
            if (this.DM.DE == 0.0f) {
                this.DM.aE(this.DM.DD);
                SlidingPaneLayout slidingPaneLayout = this.DM;
                this.DM.DD;
                slidingPaneLayout.sendAccessibilityEvent(32);
                this.DM.DJ = false;
                return;
            }
            slidingPaneLayout = this.DM;
            this.DM.DD;
            slidingPaneLayout.sendAccessibilityEvent(32);
            this.DM.DJ = true;
        }

        public final void f(View view, int i) {
            this.DM.cB();
        }

        public final void a(View view, int i, int i2) {
            SlidingPaneLayout.a(this.DM, i);
            this.DM.invalidate();
        }

        public final void a(View view, float f, float f2) {
            int paddingRight;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.DM.cD()) {
                paddingRight = layoutParams.rightMargin + this.DM.getPaddingRight();
                if (f < 0.0f || (f == 0.0f && this.DM.DE > 0.5f)) {
                    paddingRight += this.DM.DG;
                }
                paddingRight = (this.DM.getWidth() - paddingRight) - this.DM.DD.getWidth();
            } else {
                paddingRight = layoutParams.leftMargin + this.DM.getPaddingLeft();
                if (f > 0.0f || (f == 0.0f && this.DM.DE > 0.5f)) {
                    paddingRight += this.DM.DG;
                }
            }
            this.DM.DI.q(paddingRight, view.getTop());
            this.DM.invalidate();
        }

        public final int s(View view) {
            return this.DM.DG;
        }

        public final int d(View view, int i) {
            LayoutParams layoutParams = (LayoutParams) this.DM.DD.getLayoutParams();
            if (this.DM.cD()) {
                int width = this.DM.getWidth() - ((layoutParams.rightMargin + this.DM.getPaddingRight()) + this.DM.DD.getWidth());
                return Math.max(Math.min(i, width), width - this.DM.DG);
            }
            width = layoutParams.leftMargin + this.DM.getPaddingLeft();
            return Math.min(Math.max(i, width), this.DM.DG + width);
        }

        public final int c(View view, int i) {
            return view.getTop();
        }

        public final void n(int i, int i2) {
            this.DM.DI.n(this.DM.DD, i2);
        }
    }

    static class e implements d {
        e() {
        }

        public void b(SlidingPaneLayout slidingPaneLayout, View view) {
            z.b(slidingPaneLayout, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    static class f extends e {
        private Method DS;
        private Field DT;

        f() {
            try {
                this.DS = View.class.getDeclaredMethod("getDisplayList", null);
            } catch (NoSuchMethodException e) {
            }
            try {
                this.DT = View.class.getDeclaredField("mRecreateDisplayList");
                this.DT.setAccessible(true);
            } catch (NoSuchFieldException e2) {
            }
        }

        public final void b(SlidingPaneLayout slidingPaneLayout, View view) {
            if (this.DS == null || this.DT == null) {
                view.invalidate();
                return;
            }
            try {
                this.DT.setBoolean(view, true);
                this.DS.invoke(view, null);
            } catch (Exception e) {
            }
            super.b(slidingPaneLayout, view);
        }
    }

    static class g extends e {
        g() {
        }

        public final void b(SlidingPaneLayout slidingPaneLayout, View view) {
            z.a(view, ((LayoutParams) view.getLayoutParams()).DQ);
        }
    }

    static /* synthetic */ void a(SlidingPaneLayout slidingPaneLayout, int i) {
        if (slidingPaneLayout.DD == null) {
            slidingPaneLayout.DE = 0.0f;
            return;
        }
        boolean cD = slidingPaneLayout.cD();
        LayoutParams layoutParams = (LayoutParams) slidingPaneLayout.DD.getLayoutParams();
        int width = slidingPaneLayout.DD.getWidth();
        if (cD) {
            i = (slidingPaneLayout.getWidth() - i) - width;
        }
        slidingPaneLayout.DE = ((float) (i - ((cD ? layoutParams.rightMargin : layoutParams.leftMargin) + (cD ? slidingPaneLayout.getPaddingRight() : slidingPaneLayout.getPaddingLeft())))) / ((float) slidingPaneLayout.DG);
        if (slidingPaneLayout.DH != 0) {
            slidingPaneLayout.A(slidingPaneLayout.DE);
        }
        if (layoutParams.DP) {
            slidingPaneLayout.a(slidingPaneLayout.DD, slidingPaneLayout.DE, slidingPaneLayout.Dx);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 17) {
            DL = new g();
        } else if (i >= 16) {
            DL = new f();
        } else {
            DL = new e();
        }
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Dx = -858993460;
        this.yW = true;
        this.gG = new Rect();
        this.DK = new ArrayList();
        float f = context.getResources().getDisplayMetrics().density;
        this.DB = (int) ((32.0f * f) + 0.5f);
        ViewConfiguration.get(context);
        setWillNotDraw(false);
        z.a((View) this, new a(this));
        z.i(this, 1);
        this.DI = u.a((ViewGroup) this, 0.5f, new c(this));
        this.DI.EU = f * 400.0f;
    }

    final void aE(View view) {
        int left;
        int right;
        int top;
        int bottom;
        int childCount;
        int i;
        View childAt;
        int i2;
        int max;
        boolean cD = cD();
        int width = cD ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = cD ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view != null) {
            Object obj;
            if (z.L(view)) {
                obj = 1;
            } else {
                if (VERSION.SDK_INT < 18) {
                    Drawable background = view.getBackground();
                    if (background != null) {
                        obj = background.getOpacity() == -1 ? 1 : null;
                    }
                }
                obj = null;
            }
            if (obj != null) {
                left = view.getLeft();
                right = view.getRight();
                top = view.getTop();
                bottom = view.getBottom();
                childCount = getChildCount();
                i = 0;
                while (i < childCount) {
                    childAt = getChildAt(i);
                    if (childAt != view) {
                        if (cD) {
                            i2 = width;
                        } else {
                            i2 = paddingLeft;
                        }
                        max = Math.max(i2, childAt.getLeft());
                        int max2 = Math.max(paddingTop, childAt.getTop());
                        if (cD) {
                            i2 = paddingLeft;
                        } else {
                            i2 = width;
                        }
                        i2 = Math.min(i2, childAt.getRight());
                        int min = Math.min(height, childAt.getBottom());
                        if (max >= left || max2 < r3 || i2 > r4 || min > r2) {
                            i2 = 0;
                        } else {
                            i2 = 4;
                        }
                        childAt.setVisibility(i2);
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
        bottom = 0;
        top = 0;
        right = 0;
        left = 0;
        childCount = getChildCount();
        i = 0;
        while (i < childCount) {
            childAt = getChildAt(i);
            if (childAt != view) {
                if (cD) {
                    i2 = width;
                } else {
                    i2 = paddingLeft;
                }
                max = Math.max(i2, childAt.getLeft());
                int max22 = Math.max(paddingTop, childAt.getTop());
                if (cD) {
                    i2 = paddingLeft;
                } else {
                    i2 = width;
                }
                i2 = Math.min(i2, childAt.getRight());
                int min2 = Math.min(height, childAt.getBottom());
                if (max >= left) {
                }
                i2 = 0;
                childAt.setVisibility(i2);
                i++;
            } else {
                return;
            }
        }
    }

    final void cB() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.yW = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.yW = true;
        int size = this.DK.size();
        for (int i = 0; i < size; i++) {
            ((b) this.DK.get(i)).run();
        }
        this.DK.clear();
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            if (mode2 == 0) {
                if (!isInEditMode()) {
                    throw new IllegalStateException("Height must not be UNSPECIFIED");
                } else if (mode2 == 0) {
                    i3 = Integer.MIN_VALUE;
                    i4 = size;
                    size = com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX;
                }
            }
            i3 = mode2;
            i4 = size;
            size = size2;
        } else if (isInEditMode()) {
            if (mode != Integer.MIN_VALUE && mode == 0) {
                i3 = mode2;
                i4 = com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX;
                size = size2;
            }
            i3 = mode2;
            i4 = size;
            size = size2;
        } else {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        }
        switch (i3) {
            case Integer.MIN_VALUE:
                mode2 = 0;
                size2 = (size - getPaddingTop()) - getPaddingBottom();
                break;
            case 1073741824:
                mode2 = (size - getPaddingTop()) - getPaddingBottom();
                size2 = mode2;
                break;
            default:
                mode2 = 0;
                size2 = -1;
                break;
        }
        boolean z = false;
        int paddingLeft = (i4 - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        this.DD = null;
        int i5 = 0;
        int i6 = paddingLeft;
        int i7 = mode2;
        float f = 0.0f;
        while (i5 < childCount) {
            float f2;
            boolean z2;
            int makeMeasureSpec;
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.DP = false;
                mode2 = i6;
                mode = i7;
                f2 = f;
                z2 = z;
            } else {
                if (layoutParams.weight > 0.0f) {
                    f += layoutParams.weight;
                    if (layoutParams.width == 0) {
                        mode2 = i6;
                        mode = i7;
                        f2 = f;
                        z2 = z;
                    }
                }
                mode = layoutParams.leftMargin + layoutParams.rightMargin;
                if (layoutParams.width == -2) {
                    mode = MeasureSpec.makeMeasureSpec(paddingLeft - mode, Integer.MIN_VALUE);
                } else if (layoutParams.width == -1) {
                    mode = MeasureSpec.makeMeasureSpec(paddingLeft - mode, 1073741824);
                } else {
                    mode = MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
                }
                if (layoutParams.height == -2) {
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE);
                } else if (layoutParams.height == -1) {
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(size2, 1073741824);
                } else {
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                }
                childAt.measure(mode, makeMeasureSpec);
                mode = childAt.getMeasuredWidth();
                makeMeasureSpec = childAt.getMeasuredHeight();
                if (i3 == Integer.MIN_VALUE && makeMeasureSpec > i7) {
                    i7 = Math.min(makeMeasureSpec, size2);
                }
                makeMeasureSpec = i6 - mode;
                boolean z3 = makeMeasureSpec < 0;
                layoutParams.DO = z3;
                z3 |= z;
                if (layoutParams.DO) {
                    this.DD = childAt;
                }
                mode2 = makeMeasureSpec;
                f2 = f;
                z2 = z3;
                mode = i7;
            }
            i5++;
            z = z2;
            i7 = mode;
            i6 = mode2;
            f = f2;
        }
        if (z || f > 0.0f) {
            int i8 = paddingLeft - this.DB;
            for (i3 = 0; i3 < childCount; i3++) {
                View childAt2 = getChildAt(i3);
                if (childAt2.getVisibility() != 8) {
                    layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != 8) {
                        Object obj = (layoutParams.width != 0 || layoutParams.weight <= 0.0f) ? null : 1;
                        makeMeasureSpec = obj != null ? 0 : childAt2.getMeasuredWidth();
                        if (!z || childAt2 == this.DD) {
                            if (layoutParams.weight > 0.0f) {
                                if (layoutParams.width != 0) {
                                    mode = MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                } else if (layoutParams.height == -2) {
                                    mode = MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE);
                                } else if (layoutParams.height == -1) {
                                    mode = MeasureSpec.makeMeasureSpec(size2, 1073741824);
                                } else {
                                    mode = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                                }
                                if (z) {
                                    mode2 = paddingLeft - (layoutParams.rightMargin + layoutParams.leftMargin);
                                    i5 = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
                                    if (makeMeasureSpec != mode2) {
                                        childAt2.measure(i5, mode);
                                    }
                                } else {
                                    childAt2.measure(MeasureSpec.makeMeasureSpec(((int) ((layoutParams.weight * ((float) Math.max(0, i6))) / f)) + makeMeasureSpec, 1073741824), mode);
                                }
                            }
                        } else if (layoutParams.width < 0 && (makeMeasureSpec > i8 || layoutParams.weight > 0.0f)) {
                            if (obj == null) {
                                mode2 = MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            } else if (layoutParams.height == -2) {
                                mode2 = MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE);
                            } else if (layoutParams.height == -1) {
                                mode2 = MeasureSpec.makeMeasureSpec(size2, 1073741824);
                            } else {
                                mode2 = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                            }
                            childAt2.measure(MeasureSpec.makeMeasureSpec(i8, 1073741824), mode2);
                        }
                    }
                }
            }
        }
        setMeasuredDimension(i4, (getPaddingTop() + i7) + getPaddingBottom());
        this.DC = z;
        if (this.DI.EK != 0 && !z) {
            this.DI.abort();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean cD = cD();
        if (cD) {
            this.DI.EW = 2;
        } else {
            this.DI.EW = 1;
        }
        int i6 = i3 - i;
        int paddingRight = cD ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = cD ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.yW) {
            float f = (this.DC && this.DJ) ? 1.0f : 0.0f;
            this.DE = f;
        }
        int i7 = 0;
        int i8 = paddingRight;
        while (i7 < childCount) {
            int i9;
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                int i10;
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int i11 = 0;
                if (layoutParams.DO) {
                    int min = (Math.min(paddingRight, (i6 - paddingLeft) - this.DB) - i8) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.DG = min;
                    i9 = cD ? layoutParams.rightMargin : layoutParams.leftMargin;
                    layoutParams.DP = ((i8 + i9) + min) + (measuredWidth / 2) > i6 - paddingLeft;
                    i5 = (int) (((float) min) * this.DE);
                    i10 = i8 + (i9 + i5);
                    this.DE = ((float) i5) / ((float) this.DG);
                } else {
                    if (!this.DC || this.DH == 0) {
                        i5 = 0;
                    } else {
                        i5 = (int) ((1.0f - this.DE) * ((float) this.DH));
                    }
                    i11 = i5;
                    i10 = paddingRight;
                }
                if (cD) {
                    i9 = (i6 - i10) + i11;
                    i5 = i9 - measuredWidth;
                } else {
                    i5 = i10 - i11;
                    i9 = i5 + measuredWidth;
                }
                childAt.layout(i5, paddingTop, i9, childAt.getMeasuredHeight() + paddingTop);
                i5 = childAt.getWidth() + paddingRight;
                i9 = i10;
            } else {
                i5 = paddingRight;
                i9 = i8;
            }
            i7++;
            paddingRight = i5;
            i8 = i9;
        }
        if (this.yW) {
            if (this.DC) {
                if (this.DH != 0) {
                    A(this.DE);
                }
                if (((LayoutParams) this.DD.getLayoutParams()).DP) {
                    a(this.DD, this.DE, this.Dx);
                }
            } else {
                for (i5 = 0; i5 < childCount; i5++) {
                    a(getChildAt(i5), 0.0f, this.Dx);
                }
            }
            aE(this.DD);
        }
        this.yW = false;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.yW = true;
        }
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.DC) {
            this.DJ = view == this.DD;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
        r6 = this;
        r2 = 0;
        r1 = 1;
        r3 = android.support.v4.view.o.d(r7);
        r0 = r6.DC;
        if (r0 != 0) goto L_0x002b;
    L_0x000a:
        if (r3 != 0) goto L_0x002b;
    L_0x000c:
        r0 = r6.getChildCount();
        if (r0 <= r1) goto L_0x002b;
    L_0x0012:
        r0 = r6.getChildAt(r1);
        if (r0 == 0) goto L_0x002b;
    L_0x0018:
        r4 = r7.getX();
        r4 = (int) r4;
        r5 = r7.getY();
        r5 = (int) r5;
        r0 = android.support.v4.widget.u.f(r0, r4, r5);
        if (r0 != 0) goto L_0x003f;
    L_0x0028:
        r0 = r1;
    L_0x0029:
        r6.DJ = r0;
    L_0x002b:
        r0 = r6.DC;
        if (r0 == 0) goto L_0x0035;
    L_0x002f:
        r0 = r6.yK;
        if (r0 == 0) goto L_0x0041;
    L_0x0033:
        if (r3 == 0) goto L_0x0041;
    L_0x0035:
        r0 = r6.DI;
        r0.cancel();
        r2 = super.onInterceptTouchEvent(r7);
    L_0x003e:
        return r2;
    L_0x003f:
        r0 = r2;
        goto L_0x0029;
    L_0x0041:
        r0 = 3;
        if (r3 == r0) goto L_0x0046;
    L_0x0044:
        if (r3 != r1) goto L_0x004c;
    L_0x0046:
        r0 = r6.DI;
        r0.cancel();
        goto L_0x003e;
    L_0x004c:
        switch(r3) {
            case 0: goto L_0x005c;
            case 1: goto L_0x004f;
            case 2: goto L_0x007e;
            default: goto L_0x004f;
        };
    L_0x004f:
        r0 = r2;
    L_0x0050:
        r3 = r6.DI;
        r3 = r3.j(r7);
        if (r3 != 0) goto L_0x005a;
    L_0x0058:
        if (r0 == 0) goto L_0x003e;
    L_0x005a:
        r2 = r1;
        goto L_0x003e;
    L_0x005c:
        r6.yK = r2;
        r0 = r7.getX();
        r3 = r7.getY();
        r6.xC = r0;
        r6.xD = r3;
        r4 = r6.DD;
        r0 = (int) r0;
        r3 = (int) r3;
        r0 = android.support.v4.widget.u.f(r4, r0, r3);
        if (r0 == 0) goto L_0x004f;
    L_0x0074:
        r0 = r6.DD;
        r0 = r6.aG(r0);
        if (r0 == 0) goto L_0x004f;
    L_0x007c:
        r0 = r1;
        goto L_0x0050;
    L_0x007e:
        r0 = r7.getX();
        r3 = r7.getY();
        r4 = r6.xC;
        r0 = r0 - r4;
        r0 = java.lang.Math.abs(r0);
        r4 = r6.xD;
        r3 = r3 - r4;
        r3 = java.lang.Math.abs(r3);
        r4 = r6.DI;
        r4 = r4.iE;
        r4 = (float) r4;
        r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r4 <= 0) goto L_0x004f;
    L_0x009d:
        r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x004f;
    L_0x00a1:
        r0 = r6.DI;
        r0.cancel();
        r6.yK = r1;
        goto L_0x003e;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.SlidingPaneLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.DC) {
            return super.onTouchEvent(motionEvent);
        }
        this.DI.k(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & 255) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.xC = x;
                this.xD = y;
                break;
            case 1:
                if (aG(this.DD)) {
                    x = motionEvent.getX();
                    y = motionEvent.getY();
                    float f = x - this.xC;
                    float f2 = y - this.xD;
                    int i = this.DI.iE;
                    if ((f * f) + (f2 * f2) < ((float) (i * i)) && u.f(this.DD, (int) x, (int) y)) {
                        cC();
                        break;
                    }
                }
                break;
        }
        return true;
    }

    private boolean cC() {
        if (!this.yW && !z(0.0f)) {
            return false;
        }
        this.DJ = false;
        return true;
    }

    private void a(View view, float f, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f > 0.0f && i != 0) {
            int i2 = (((int) (((float) ((WebView.NIGHT_MODE_COLOR & i) >>> 24)) * f)) << 24) | (16777215 & i);
            if (layoutParams.DQ == null) {
                layoutParams.DQ = new Paint();
            }
            layoutParams.DQ.setColorFilter(new PorterDuffColorFilter(i2, Mode.SRC_OVER));
            if (z.I(view) != 2) {
                z.a(view, 2, layoutParams.DQ);
            }
            aF(view);
        } else if (z.I(view) != 0) {
            if (layoutParams.DQ != null) {
                layoutParams.DQ.setColorFilter(null);
            }
            Runnable bVar = new b(this, view);
            this.DK.add(bVar);
            z.a((View) this, bVar);
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean z;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save(2);
        if (!(!this.DC || layoutParams.DO || this.DD == null)) {
            canvas.getClipBounds(this.gG);
            if (cD()) {
                this.gG.left = Math.max(this.gG.left, this.DD.getRight());
            } else {
                this.gG.right = Math.min(this.gG.right, this.DD.getLeft());
            }
            canvas.clipRect(this.gG);
        }
        if (VERSION.SDK_INT < 11) {
            if (layoutParams.DP && this.DE > 0.0f) {
                if (!view.isDrawingCacheEnabled()) {
                    view.setDrawingCacheEnabled(true);
                }
                Bitmap drawingCache = view.getDrawingCache();
                if (drawingCache != null) {
                    canvas.drawBitmap(drawingCache, (float) view.getLeft(), (float) view.getTop(), layoutParams.DQ);
                    z = false;
                    canvas.restoreToCount(save);
                    return z;
                }
                new StringBuilder("drawChild: child view ").append(view).append(" returned null drawing cache");
            } else if (view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(false);
            }
        }
        z = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        return z;
    }

    private void aF(View view) {
        DL.b(this, view);
    }

    private boolean z(float f) {
        if (!this.DC) {
            return false;
        }
        int width;
        LayoutParams layoutParams = (LayoutParams) this.DD.getLayoutParams();
        if (cD()) {
            width = (int) (((float) getWidth()) - ((((float) (layoutParams.rightMargin + getPaddingRight())) + (((float) this.DG) * f)) + ((float) this.DD.getWidth())));
        } else {
            width = (int) (((float) (layoutParams.leftMargin + getPaddingLeft())) + (((float) this.DG) * f));
        }
        if (!this.DI.e(this.DD, width, this.DD.getTop())) {
            return false;
        }
        cB();
        z.F(this);
        return true;
    }

    public void computeScroll() {
        if (!this.DI.cH()) {
            return;
        }
        if (this.DC) {
            z.F(this);
        } else {
            this.DI.abort();
        }
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        if (cD()) {
            drawable = this.DA;
        } else {
            drawable = this.Dz;
        }
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && drawable != null) {
            int right;
            int i;
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (cD()) {
                right = childAt.getRight();
                i = right + intrinsicWidth;
            } else {
                i = childAt.getLeft();
                right = i - intrinsicWidth;
            }
            drawable.setBounds(right, top, i, bottom);
            drawable.draw(canvas);
        }
    }

    private void A(float f) {
        Object obj;
        int childCount;
        int i;
        View childAt;
        int i2;
        float f2;
        boolean cD = cD();
        LayoutParams layoutParams = (LayoutParams) this.DD.getLayoutParams();
        if (layoutParams.DP) {
            if ((cD ? layoutParams.rightMargin : layoutParams.leftMargin) <= 0) {
                obj = 1;
                childCount = getChildCount();
                for (i = 0; i < childCount; i++) {
                    childAt = getChildAt(i);
                    if (childAt != this.DD) {
                        i2 = (int) ((1.0f - this.DF) * ((float) this.DH));
                        this.DF = f;
                        i2 -= (int) ((1.0f - f) * ((float) this.DH));
                        if (cD) {
                            i2 = -i2;
                        }
                        childAt.offsetLeftAndRight(i2);
                        if (obj == null) {
                            if (cD) {
                                f2 = 1.0f - this.DF;
                            } else {
                                f2 = this.DF - 1.0f;
                            }
                            a(childAt, f2, this.Dy);
                        }
                    }
                }
            }
        }
        obj = null;
        childCount = getChildCount();
        for (i = 0; i < childCount; i++) {
            childAt = getChildAt(i);
            if (childAt != this.DD) {
                i2 = (int) ((1.0f - this.DF) * ((float) this.DH));
                this.DF = f;
                i2 -= (int) ((1.0f - f) * ((float) this.DH));
                if (cD) {
                    i2 = -i2;
                }
                childAt.offsetLeftAndRight(i2);
                if (obj == null) {
                    if (cD) {
                        f2 = 1.0f - this.DF;
                    } else {
                        f2 = this.DF - 1.0f;
                    }
                    a(childAt, f2, this.Dy);
                }
            }
        }
    }

    final boolean aG(View view) {
        if (view == null) {
            return false;
        }
        return this.DC && ((LayoutParams) view.getLayoutParams()).DP && this.DE > 0.0f;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        boolean z = this.DC ? !this.DC || this.DE == 1.0f : this.DJ;
        savedState.DR = z;
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (!savedState.DR) {
                cC();
            } else if (this.yW || z(1.0f)) {
                this.DJ = true;
            }
            this.DJ = savedState.DR;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    private boolean cD() {
        return z.J(this) == 1;
    }
}
