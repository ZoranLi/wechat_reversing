package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.m;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView extends LinearLayoutCompat implements android.support.v7.view.menu.f.b, m {
    private Context Rx;
    boolean SC;
    private int SL;
    private int Ta;
    ActionMenuPresenter Tb;
    private android.support.v7.view.menu.l.a Tc;
    private android.support.v7.view.menu.f.a Td;
    private boolean Te;
    private int Tf;
    private int Tg;
    d Th;
    f dW;

    public interface a {
        boolean dm();

        boolean dn();
    }

    public interface d {
        boolean ee();
    }

    public static class LayoutParams extends android.support.v7.widget.LinearLayoutCompat.LayoutParams {
        @ExportedProperty
        public boolean Tj;
        @ExportedProperty
        public int Tk;
        @ExportedProperty
        public int Tl;
        @ExportedProperty
        public boolean Tm;
        @ExportedProperty
        public boolean Tn;
        boolean To;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.Tj = layoutParams.Tj;
        }

        public LayoutParams() {
            super(-2, -2);
            this.Tj = false;
        }
    }

    private class b implements android.support.v7.view.menu.l.a {
        final /* synthetic */ ActionMenuView Ti;

        public b(ActionMenuView actionMenuView) {
            this.Ti = actionMenuView;
        }

        public final void a(f fVar, boolean z) {
        }

        public final boolean d(f fVar) {
            return false;
        }
    }

    private class c implements android.support.v7.view.menu.f.a {
        final /* synthetic */ ActionMenuView Ti;

        public c(ActionMenuView actionMenuView) {
            this.Ti = actionMenuView;
        }

        public final boolean a(f fVar, MenuItem menuItem) {
            return this.Ti.Th != null && this.Ti.Th.ee();
        }

        public final void b(f fVar) {
            if (this.Ti.Td != null) {
                this.Ti.Td.b(fVar);
            }
        }
    }

    public final /* synthetic */ android.support.v7.widget.LinearLayoutCompat.LayoutParams c(AttributeSet attributeSet) {
        return b(attributeSet);
    }

    protected final /* synthetic */ android.support.v7.widget.LinearLayoutCompat.LayoutParams d(android.view.ViewGroup.LayoutParams layoutParams) {
        return c(layoutParams);
    }

    protected final /* synthetic */ android.support.v7.widget.LinearLayoutCompat.LayoutParams ed() {
        return eb();
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return eb();
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return b(attributeSet);
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return c(layoutParams);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Xa = false;
        float f = context.getResources().getDisplayMetrics().density;
        this.SL = (int) (56.0f * f);
        this.Tg = (int) (f * 4.0f);
        this.Rx = context;
        this.Ta = 0;
    }

    public final void setPopupTheme(int i) {
        if (this.Ta != i) {
            this.Ta = i;
            if (i == 0) {
                this.Rx = getContext();
            } else {
                this.Rx = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public final void a(ActionMenuPresenter actionMenuPresenter) {
        this.Tb = actionMenuPresenter;
        this.Tb.a(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        if (this.Tb != null) {
            this.Tb.f(false);
            if (this.Tb.isOverflowMenuShowing()) {
                this.Tb.hideOverflowMenu();
                this.Tb.showOverflowMenu();
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        boolean z = this.Te;
        this.Te = MeasureSpec.getMode(i) == 1073741824;
        if (z != this.Te) {
            this.Tf = 0;
        }
        int size = MeasureSpec.getSize(i);
        if (!(!this.Te || this.dW == null || size == this.Tf)) {
            this.Tf = size;
            this.dW.h(true);
        }
        int childCount = getChildCount();
        int i3;
        if (!this.Te || childCount <= 0) {
            for (i3 = 0; i3 < childCount; i3++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i2);
        size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        i3 = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int i4 = size - i3;
        int i5 = i4 / this.SL;
        size = i4 % this.SL;
        if (i5 == 0) {
            setMeasuredDimension(i4, 0);
            return;
        }
        int i6;
        Object obj;
        int i7 = this.SL + (size / i5);
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        i3 = 0;
        Object obj2 = null;
        long j = 0;
        int childCount2 = getChildCount();
        int i11 = 0;
        while (i11 < childCount2) {
            int i12;
            int i13;
            long j2;
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                boolean z2 = childAt instanceof ActionMenuItemView;
                i6 = i3 + 1;
                if (z2) {
                    childAt.setPadding(this.Tg, 0, this.Tg, 0);
                }
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.To = false;
                layoutParams.Tl = 0;
                layoutParams.Tk = 0;
                layoutParams.Tm = false;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                z = z2 && ((ActionMenuItemView) childAt).hasText();
                layoutParams.Tn = z;
                int d = d(childAt, i7, layoutParams.Tj ? 1 : i5, childMeasureSpec, paddingTop);
                i9 = Math.max(i9, d);
                if (layoutParams.Tm) {
                    i3 = i10 + 1;
                } else {
                    i3 = i10;
                }
                if (layoutParams.Tj) {
                    obj = 1;
                } else {
                    obj = obj2;
                }
                int i14 = i5 - d;
                i10 = Math.max(i8, childAt.getMeasuredHeight());
                if (d == 1) {
                    long j3 = ((long) (1 << i11)) | j;
                    i12 = i10;
                    i13 = i14;
                    i10 = i3;
                    obj2 = obj;
                    j2 = j3;
                    i5 = i9;
                    childCount = i6;
                } else {
                    childCount = i6;
                    i5 = i9;
                    long j4 = j;
                    i12 = i10;
                    i13 = i14;
                    obj2 = obj;
                    i10 = i3;
                    j2 = j4;
                }
            } else {
                childCount = i3;
                j2 = j;
                i12 = i8;
                i13 = i5;
                i5 = i9;
            }
            i11++;
            i9 = i5;
            i8 = i12;
            i5 = i13;
            j = j2;
            i3 = childCount;
        }
        Object obj3 = (obj2 == null || i3 != 2) ? null : 1;
        Object obj4 = null;
        long j5 = j;
        paddingTop = i5;
        while (i10 > 0 && paddingTop > 0) {
            i6 = Integer.MAX_VALUE;
            j = 0;
            i5 = 0;
            int i15 = 0;
            while (i15 < childCount2) {
                layoutParams = (LayoutParams) getChildAt(i15).getLayoutParams();
                if (layoutParams.Tm) {
                    if (layoutParams.Tk < i6) {
                        i5 = layoutParams.Tk;
                        j = (long) (1 << i15);
                        size = 1;
                    } else if (layoutParams.Tk == i6) {
                        j |= (long) (1 << i15);
                        size = i5 + 1;
                        i5 = i6;
                    }
                    i15++;
                    i6 = i5;
                    i5 = size;
                }
                size = i5;
                i5 = i6;
                i15++;
                i6 = i5;
                i5 = size;
            }
            j5 |= j;
            if (i5 > paddingTop) {
                break;
            }
            i15 = i6 + 1;
            i6 = 0;
            i5 = paddingTop;
            long j6 = j5;
            while (i6 < childCount2) {
                View childAt2 = getChildAt(i6);
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if ((((long) (1 << i6)) & j) != 0) {
                    if (obj3 != null && layoutParams.Tn && i5 == 1) {
                        childAt2.setPadding(this.Tg + i7, 0, this.Tg, 0);
                    }
                    layoutParams.Tk++;
                    layoutParams.To = true;
                    size = i5 - 1;
                } else if (layoutParams.Tk == i15) {
                    j6 |= (long) (1 << i6);
                    size = i5;
                } else {
                    size = i5;
                }
                i6++;
                i5 = size;
            }
            j5 = j6;
            i11 = 1;
            paddingTop = i5;
        }
        j = j5;
        obj = (obj2 == null && i3 == 1) ? 1 : null;
        if (paddingTop <= 0 || j == 0 || (paddingTop >= i3 - 1 && obj == null && i9 <= 1)) {
            obj3 = obj4;
        } else {
            float f;
            View childAt3;
            float bitCount = (float) Long.bitCount(j);
            if (obj == null) {
                if (!((1 & j) == 0 || ((LayoutParams) getChildAt(0).getLayoutParams()).Tn)) {
                    bitCount -= 0.5f;
                }
                if (!((((long) (1 << (childCount2 - 1))) & j) == 0 || ((LayoutParams) getChildAt(childCount2 - 1).getLayoutParams()).Tn)) {
                    f = bitCount - 0.5f;
                    i3 = f <= 0.0f ? (int) (((float) (paddingTop * i7)) / f) : 0;
                    i5 = 0;
                    obj3 = obj4;
                    while (i5 < childCount2) {
                        if ((((long) (1 << i5)) & j) != 0) {
                            childAt3 = getChildAt(i5);
                            layoutParams = (LayoutParams) childAt3.getLayoutParams();
                            if (childAt3 instanceof ActionMenuItemView) {
                                layoutParams.Tl = i3;
                                layoutParams.To = true;
                                if (i5 == 0 && !layoutParams.Tn) {
                                    layoutParams.leftMargin = (-i3) / 2;
                                }
                                obj = 1;
                            } else if (layoutParams.Tj) {
                                if (i5 != 0) {
                                    layoutParams.leftMargin = i3 / 2;
                                }
                                if (i5 != childCount2 - 1) {
                                    layoutParams.rightMargin = i3 / 2;
                                }
                            } else {
                                layoutParams.Tl = i3;
                                layoutParams.To = true;
                                layoutParams.rightMargin = (-i3) / 2;
                                obj = 1;
                            }
                            i5++;
                            obj3 = obj;
                        }
                        obj = obj3;
                        i5++;
                        obj3 = obj;
                    }
                }
            }
            f = bitCount;
            if (f <= 0.0f) {
            }
            i5 = 0;
            obj3 = obj4;
            while (i5 < childCount2) {
                if ((((long) (1 << i5)) & j) != 0) {
                    childAt3 = getChildAt(i5);
                    layoutParams = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        layoutParams.Tl = i3;
                        layoutParams.To = true;
                        layoutParams.leftMargin = (-i3) / 2;
                        obj = 1;
                    } else if (layoutParams.Tj) {
                        if (i5 != 0) {
                            layoutParams.leftMargin = i3 / 2;
                        }
                        if (i5 != childCount2 - 1) {
                            layoutParams.rightMargin = i3 / 2;
                        }
                    } else {
                        layoutParams.Tl = i3;
                        layoutParams.To = true;
                        layoutParams.rightMargin = (-i3) / 2;
                        obj = 1;
                    }
                    i5++;
                    obj3 = obj;
                }
                obj = obj3;
                i5++;
                obj3 = obj;
            }
        }
        if (obj3 != null) {
            for (i3 = 0; i3 < childCount2; i3++) {
                childAt = getChildAt(i3);
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.To) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(layoutParams.Tl + (layoutParams.Tk * i7), 1073741824), childMeasureSpec);
                }
            }
        }
        if (mode == 1073741824) {
            i8 = size2;
        }
        setMeasuredDimension(i4, i8);
    }

    static int d(View view, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        boolean z2 = false;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i3) - i4, MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        if (actionMenuItemView == null || !actionMenuItemView.hasText()) {
            z = false;
        } else {
            z = true;
        }
        if (i2 <= 0 || (z && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(MeasureSpec.makeMeasureSpec(i * i2, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            i5 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i5++;
            }
            if (z && r1 < 2) {
                i5 = 2;
            }
        }
        if (!layoutParams.Tj && z) {
            z2 = true;
        }
        layoutParams.Tm = z2;
        layoutParams.Tk = i5;
        view.measure(MeasureSpec.makeMeasureSpec(i5 * i, 1073741824), makeMeasureSpec);
        return i5;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.Te) {
            LayoutParams layoutParams;
            int measuredWidth;
            int paddingLeft;
            int i5;
            int childCount = getChildCount();
            int i6 = (i4 - i2) / 2;
            int i7 = this.Xk;
            int i8 = 0;
            int paddingRight = ((i3 - i) - getPaddingRight()) - getPaddingLeft();
            Object obj = null;
            boolean bw = at.bw(this);
            int i9 = 0;
            while (i9 < childCount) {
                View childAt = getChildAt(i9);
                if (childAt.getVisibility() != 8) {
                    layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (layoutParams.Tj) {
                        measuredWidth = childAt.getMeasuredWidth();
                        if (aB(i9)) {
                            measuredWidth += i7;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        if (bw) {
                            paddingLeft = getPaddingLeft() + layoutParams.leftMargin;
                            i5 = paddingLeft + measuredWidth;
                        } else {
                            i5 = (getWidth() - getPaddingRight()) - layoutParams.rightMargin;
                            paddingLeft = i5 - measuredWidth;
                        }
                        int i10 = i6 - (measuredHeight / 2);
                        childAt.layout(paddingLeft, i10, i5, measuredHeight + i10);
                        i5 = paddingRight - measuredWidth;
                        obj = 1;
                        measuredWidth = i8;
                    } else {
                        i5 = paddingRight - (layoutParams.rightMargin + (childAt.getMeasuredWidth() + layoutParams.leftMargin));
                        aB(i9);
                        measuredWidth = i8 + 1;
                    }
                } else {
                    i5 = paddingRight;
                    measuredWidth = i8;
                }
                i9++;
                i8 = measuredWidth;
                paddingRight = i5;
            }
            if (childCount == 1 && obj == null) {
                View childAt2 = getChildAt(0);
                measuredWidth = childAt2.getMeasuredWidth();
                paddingLeft = childAt2.getMeasuredHeight();
                paddingRight = ((i3 - i) / 2) - (measuredWidth / 2);
                i8 = i6 - (paddingLeft / 2);
                childAt2.layout(paddingRight, i8, measuredWidth + paddingRight, paddingLeft + i8);
                return;
            }
            i5 = i8 - (obj != null ? 0 : 1);
            paddingRight = Math.max(0, i5 > 0 ? paddingRight / i5 : 0);
            View childAt3;
            int i11;
            if (bw) {
                measuredWidth = getWidth() - getPaddingRight();
                paddingLeft = 0;
                while (paddingLeft < childCount) {
                    childAt3 = getChildAt(paddingLeft);
                    layoutParams = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3.getVisibility() == 8 || layoutParams.Tj) {
                        i5 = measuredWidth;
                    } else {
                        measuredWidth -= layoutParams.rightMargin;
                        i9 = childAt3.getMeasuredWidth();
                        i7 = childAt3.getMeasuredHeight();
                        i11 = i6 - (i7 / 2);
                        childAt3.layout(measuredWidth - i9, i11, measuredWidth, i7 + i11);
                        i5 = measuredWidth - ((layoutParams.leftMargin + i9) + paddingRight);
                    }
                    paddingLeft++;
                    measuredWidth = i5;
                }
                return;
            }
            measuredWidth = getPaddingLeft();
            paddingLeft = 0;
            while (paddingLeft < childCount) {
                childAt3 = getChildAt(paddingLeft);
                layoutParams = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() == 8 || layoutParams.Tj) {
                    i5 = measuredWidth;
                } else {
                    measuredWidth += layoutParams.leftMargin;
                    i9 = childAt3.getMeasuredWidth();
                    i7 = childAt3.getMeasuredHeight();
                    i11 = i6 - (i7 / 2);
                    childAt3.layout(measuredWidth, i11, measuredWidth + i9, i7 + i11);
                    i5 = ((layoutParams.rightMargin + i9) + paddingRight) + measuredWidth;
                }
                paddingLeft++;
                measuredWidth = i5;
            }
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismissPopupMenus();
    }

    private static LayoutParams eb() {
        LayoutParams layoutParams = new LayoutParams();
        layoutParams.gravity = 16;
        return layoutParams;
    }

    private LayoutParams b(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected static LayoutParams c(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return eb();
        }
        LayoutParams layoutParams2 = layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : new LayoutParams(layoutParams);
        if (layoutParams2.gravity > 0) {
            return layoutParams2;
        }
        layoutParams2.gravity = 16;
        return layoutParams2;
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof LayoutParams);
    }

    public static LayoutParams ec() {
        LayoutParams eb = eb();
        eb.Tj = true;
        return eb;
    }

    public final boolean f(h hVar) {
        return this.dW.a((MenuItem) hVar, null, 0);
    }

    public final void a(f fVar) {
        this.dW = fVar;
    }

    public final Menu getMenu() {
        if (this.dW == null) {
            Context context = getContext();
            this.dW = new f(context);
            this.dW.a(new c(this));
            this.Tb = new ActionMenuPresenter(context);
            this.Tb.dX();
            this.Tb.dV = this.Tc != null ? this.Tc : new b(this);
            this.dW.a(this.Tb, this.Rx);
            this.Tb.a(this);
        }
        return this.dW;
    }

    public final void a(android.support.v7.view.menu.l.a aVar, android.support.v7.view.menu.f.a aVar2) {
        this.Tc = aVar;
        this.Td = aVar2;
    }

    public final void dismissPopupMenus() {
        if (this.Tb != null) {
            this.Tb.dY();
        }
    }

    private boolean aB(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof a)) {
            z = ((a) childAt).dn() | 0;
        }
        return (i <= 0 || !(childAt2 instanceof a)) ? z : ((a) childAt2).dm() | z;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }
}
