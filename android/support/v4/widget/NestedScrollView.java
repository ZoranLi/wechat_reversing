package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.a.f;
import android.support.v4.view.o;
import android.support.v4.view.p;
import android.support.v4.view.q;
import android.support.v4.view.r;
import android.support.v4.view.s;
import android.support.v4.view.w;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.List;

public class NestedScrollView extends FrameLayout implements p, r, w {
    private static final a Dh = new a();
    private static final int[] Di = new int[]{16843130};
    private long CV;
    private i CW;
    private i CX;
    private boolean CY;
    private boolean CZ;
    private View Da;
    private boolean Db;
    private boolean Dc;
    private final int[] Dd;
    private final int[] De;
    private int Df;
    private SavedState Dg;
    private final s Dj;
    private final q Dk;
    private float Dl;
    public b Dm;
    private final Rect eq;
    private VelocityTracker fk;
    private int fl;
    private q iB;
    private boolean iC;
    private int iD;
    private int iE;
    private int yP;
    private int yQ;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public int Dn;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.Dn = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Dn);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.Dn + "}";
        }
    }

    public interface b {
        void b(NestedScrollView nestedScrollView);
    }

    static class a extends android.support.v4.view.a {
        a() {
        }

        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int min;
            switch (i) {
                case Downloads.RECV_BUFFER_SIZE /*4096*/:
                    min = Math.min(((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()) + nestedScrollView.getScrollY(), nestedScrollView.cy());
                    if (min == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.aj(min);
                    return true;
                case 8192:
                    min = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (min == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.aj(min);
                    return true;
                default:
                    return false;
            }
        }

        public final void a(View view, android.support.v4.view.a.b bVar) {
            super.a(view, bVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            bVar.setClassName(ScrollView.class.getName());
            if (nestedScrollView.isEnabled()) {
                int a = nestedScrollView.cy();
                if (a > 0) {
                    bVar.setScrollable(true);
                    if (nestedScrollView.getScrollY() > 0) {
                        bVar.addAction(8192);
                    }
                    if (nestedScrollView.getScrollY() < a) {
                        bVar.addAction(Downloads.RECV_BUFFER_SIZE);
                    }
                }
            }
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            f a = android.support.v4.view.a.a.a(accessibilityEvent);
            a.setScrollable(nestedScrollView.cy() > 0);
            f.Aq.g(a.Ar, nestedScrollView.getScrollX());
            f.Aq.h(a.Ar, nestedScrollView.getScrollY());
            f.Aq.j(a.Ar, nestedScrollView.getScrollX());
            f.Aq.k(a.Ar, nestedScrollView.cy());
        }
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eq = new Rect();
        this.CY = true;
        this.CZ = false;
        this.Da = null;
        this.iC = false;
        this.Dc = true;
        this.fl = -1;
        this.Dd = new int[2];
        this.De = new int[2];
        this.iB = q.a(getContext(), null);
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.iE = viewConfiguration.getScaledTouchSlop();
        this.yP = viewConfiguration.getScaledMinimumFlingVelocity();
        this.yQ = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Di, i, 0);
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        if (z != this.Db) {
            this.Db = z;
            requestLayout();
        }
        obtainStyledAttributes.recycle();
        this.Dj = new s(this);
        this.Dk = new q(this);
        setNestedScrollingEnabled(true);
        z.a((View) this, Dh);
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.Dk.setNestedScrollingEnabled(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.Dk.xk;
    }

    public boolean startNestedScroll(int i) {
        return this.Dk.startNestedScroll(i);
    }

    public void stopNestedScroll() {
        this.Dk.stopNestedScroll();
    }

    public boolean hasNestedScrollingParent() {
        return this.Dk.hasNestedScrollingParent();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.Dk.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.Dk.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.Dk.dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.Dk.dispatchNestedPreFling(f, f2);
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.Dj.xn = i;
        startNestedScroll(2);
    }

    public void onStopNestedScroll(View view) {
        this.Dj.xn = 0;
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int scrollY = getScrollY();
        scrollBy(0, i4);
        int scrollY2 = getScrollY() - scrollY;
        dispatchNestedScroll(0, scrollY2, 0, i4 - scrollY2, null);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        dispatchNestedPreScroll(i, i2, iArr, null);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        ak((int) f2);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public int getNestedScrollAxes() {
        return this.Dj.xn;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = (getChildAt(0).getBottom() - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public void addView(View view, int i) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i);
    }

    public void addView(View view, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i, layoutParams);
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.Dm != null) {
            this.Dm.b(this);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.Db && MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int measuredHeight = getMeasuredHeight();
            if (childAt.getMeasuredHeight() < measuredHeight) {
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), ((FrameLayout.LayoutParams) childAt.getLayoutParams()).width), MeasureSpec.makeMeasureSpec((measuredHeight - getPaddingTop()) - getPaddingBottom(), 1073741824));
            }
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    public final boolean executeKeyEvent(KeyEvent keyEvent) {
        boolean z;
        this.eq.setEmpty();
        View childAt = getChildAt(0);
        if (childAt != null) {
            z = getHeight() < (childAt.getHeight() + getPaddingTop()) + getPaddingBottom();
        } else {
            z = false;
        }
        View childAt2;
        if (z) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            switch (keyEvent.getKeyCode()) {
                case 19:
                    if (keyEvent.isAltPressed()) {
                        return fullScroll(33);
                    }
                    return arrowScroll(33);
                case 20:
                    if (keyEvent.isAltPressed()) {
                        return fullScroll(130);
                    }
                    return arrowScroll(130);
                case 62:
                    int i = keyEvent.isShiftPressed() ? 33 : 130;
                    boolean z2 = i == 130;
                    int height = getHeight();
                    if (z2) {
                        this.eq.top = getScrollY() + height;
                        int childCount = getChildCount();
                        if (childCount > 0) {
                            childAt2 = getChildAt(childCount - 1);
                            if (this.eq.top + height > childAt2.getBottom()) {
                                this.eq.top = childAt2.getBottom() - height;
                            }
                        }
                    } else {
                        this.eq.top = getScrollY() - height;
                        if (this.eq.top < 0) {
                            this.eq.top = 0;
                        }
                    }
                    this.eq.bottom = height + this.eq.top;
                    e(i, this.eq.top, this.eq.bottom);
                    return false;
                default:
                    return false;
            }
        } else if (!isFocused() || keyEvent.getKeyCode() == 4) {
            return false;
        } else {
            childAt2 = findFocus();
            if (childAt2 == this) {
                childAt2 = null;
            }
            childAt2 = FocusFinder.getInstance().findNextFocus(this, childAt2, 130);
            if (childAt2 == null || childAt2 == this || !childAt2.requestFocus(130)) {
                return false;
            }
            return true;
        }
    }

    private void cw() {
        if (this.fk == null) {
            this.fk = VelocityTracker.obtain();
        }
    }

    private void cx() {
        if (this.fk != null) {
            this.fk.recycle();
            this.fk = null;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            cx();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        int action = motionEvent.getAction();
        if (action == 2 && this.iC) {
            return true;
        }
        int y;
        switch (action & 255) {
            case 0:
                boolean z2;
                y = (int) motionEvent.getY();
                action = (int) motionEvent.getX();
                if (getChildCount() > 0) {
                    int scrollY = getScrollY();
                    View childAt = getChildAt(0);
                    z2 = y >= childAt.getTop() - scrollY && y < childAt.getBottom() - scrollY && action >= childAt.getLeft() && action < childAt.getRight();
                } else {
                    z2 = false;
                }
                if (!z2) {
                    this.iC = false;
                    cx();
                    break;
                }
                this.iD = y;
                this.fl = o.c(motionEvent, 0);
                if (this.fk == null) {
                    this.fk = VelocityTracker.obtain();
                } else {
                    this.fk.clear();
                }
                this.fk.addMovement(motionEvent);
                this.iB.computeScrollOffset();
                if (this.iB.isFinished()) {
                    z = false;
                }
                this.iC = z;
                startNestedScroll(2);
                break;
                break;
            case 1:
            case 3:
                this.iC = false;
                this.fl = -1;
                cx();
                if (this.iB.f(getScrollX(), getScrollY(), cy())) {
                    z.F(this);
                }
                stopNestedScroll();
                break;
            case 2:
                action = this.fl;
                if (action != -1) {
                    y = o.b(motionEvent, action);
                    if (y != -1) {
                        action = (int) o.e(motionEvent, y);
                        if (Math.abs(action - this.iD) > this.iE && (getNestedScrollAxes() & 2) == 0) {
                            this.iC = true;
                            this.iD = action;
                            cw();
                            this.fk.addMovement(motionEvent);
                            this.Df = 0;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                    new StringBuilder("Invalid pointerId=").append(action).append(" in onInterceptTouchEvent");
                    break;
                }
                break;
            case 6:
                h(motionEvent);
                break;
        }
        return this.iC;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        cw();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int d = o.d(motionEvent);
        if (d == 0) {
            this.Df = 0;
        }
        obtain.offsetLocation(0.0f, (float) this.Df);
        switch (d) {
            case 0:
                if (getChildCount() != 0) {
                    boolean z = !this.iB.isFinished();
                    this.iC = z;
                    if (z) {
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (!this.iB.isFinished()) {
                        this.iB.abortAnimation();
                    }
                    this.iD = (int) motionEvent.getY();
                    this.fl = o.c(motionEvent, 0);
                    startNestedScroll(2);
                    break;
                }
                return false;
            case 1:
                if (this.iC) {
                    VelocityTracker velocityTracker = this.fk;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.yQ);
                    d = (int) y.b(velocityTracker, this.fl);
                    if (Math.abs(d) > this.yP) {
                        ak(-d);
                    } else if (this.iB.f(getScrollX(), getScrollY(), cy())) {
                        z.F(this);
                    }
                }
                this.fl = -1;
                cz();
                break;
            case 2:
                int b = o.b(motionEvent, this.fl);
                if (b != -1) {
                    int i;
                    int e = (int) o.e(motionEvent, b);
                    d = this.iD - e;
                    if (dispatchNestedPreScroll(0, d, this.De, this.Dd)) {
                        d -= this.De[1];
                        obtain.offsetLocation(0.0f, (float) this.Dd[1]);
                        this.Df += this.Dd[1];
                    }
                    if (this.iC || Math.abs(d) <= this.iE) {
                        i = d;
                    } else {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.iC = true;
                        if (d > 0) {
                            i = d - this.iE;
                        } else {
                            i = d + this.iE;
                        }
                    }
                    if (this.iC) {
                        Object obj;
                        this.iD = e - this.Dd[1];
                        int scrollY = getScrollY();
                        int cy = cy();
                        d = z.C(this);
                        if (d == 0 || (d == 1 && cy > 0)) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (d(0, i, 0, getScrollY(), cy) && !hasNestedScrollingParent()) {
                            this.fk.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        if (!dispatchNestedScroll(0, scrollY2, 0, i - scrollY2, this.Dd)) {
                            if (obj != null) {
                                cA();
                                d = scrollY + i;
                                if (d < 0) {
                                    this.CW.h(((float) i) / ((float) getHeight()), o.d(motionEvent, b) / ((float) getWidth()));
                                    if (!this.CX.isFinished()) {
                                        this.CX.cr();
                                    }
                                } else if (d > cy) {
                                    this.CX.h(((float) i) / ((float) getHeight()), 1.0f - (o.d(motionEvent, b) / ((float) getWidth())));
                                    if (!this.CW.isFinished()) {
                                        this.CW.cr();
                                    }
                                }
                                if (!(this.CW == null || (this.CW.isFinished() && this.CX.isFinished()))) {
                                    z.F(this);
                                    break;
                                }
                            }
                        }
                        this.iD -= this.Dd[1];
                        obtain.offsetLocation(0.0f, (float) this.Dd[1]);
                        this.Df += this.Dd[1];
                        break;
                    }
                }
                new StringBuilder("Invalid pointerId=").append(this.fl).append(" in onTouchEvent");
                break;
                break;
            case 3:
                if (this.iC && getChildCount() > 0 && this.iB.f(getScrollX(), getScrollY(), cy())) {
                    z.F(this);
                }
                this.fl = -1;
                cz();
                break;
            case 5:
                d = o.e(motionEvent);
                this.iD = (int) o.e(motionEvent, d);
                this.fl = o.c(motionEvent, d);
                break;
            case 6:
                h(motionEvent);
                this.iD = (int) o.e(motionEvent, o.b(motionEvent, this.fl));
                break;
        }
        if (this.fk != null) {
            this.fk.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    private void h(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (o.c(motionEvent, action) == this.fl) {
            action = action == 0 ? 1 : 0;
            this.iD = (int) o.e(motionEvent, action);
            this.fl = o.c(motionEvent, action);
            if (this.fk != null) {
                this.fk.clear();
            }
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((o.g(motionEvent) & 2) != 0) {
            switch (motionEvent.getAction()) {
                case 8:
                    if (!this.iC) {
                        float f = o.f(motionEvent, 9);
                        if (f != 0.0f) {
                            if (this.Dl == 0.0f) {
                                TypedValue typedValue = new TypedValue();
                                Context context = getContext();
                                if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                                    this.Dl = typedValue.getDimension(context.getResources().getDisplayMetrics());
                                } else {
                                    throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
                                }
                            }
                            int i = (int) (f * this.Dl);
                            int cy = cy();
                            int scrollY = getScrollY();
                            i = scrollY - i;
                            if (i < 0) {
                                cy = 0;
                            } else if (i <= cy) {
                                cy = i;
                            }
                            if (cy != scrollY) {
                                super.scrollTo(getScrollX(), cy);
                                return true;
                            }
                        }
                    }
                    break;
            }
        }
        return false;
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    private boolean d(int i, int i2, int i3, int i4, int i5) {
        boolean z;
        int i6;
        boolean z2;
        z.C(this);
        computeHorizontalScrollRange();
        computeHorizontalScrollExtent();
        computeVerticalScrollRange();
        computeVerticalScrollExtent();
        int i7 = i3 + i;
        int i8 = i4 + i2;
        int i9 = i5 + 0;
        if (i7 > 0) {
            z = true;
            i6 = 0;
        } else if (i7 < 0) {
            z = true;
            i6 = 0;
        } else {
            i6 = i7;
            z = false;
        }
        if (i8 > i9) {
            i8 = i9;
            z2 = true;
        } else if (i8 < 0) {
            z2 = true;
            i8 = 0;
        } else {
            z2 = false;
        }
        if (z2) {
            this.iB.f(i6, i8, cy());
        }
        onOverScrolled(i6, i8, z, z2);
        if (z || z2) {
            return true;
        }
        return false;
    }

    private int cy() {
        if (getChildCount() > 0) {
            return Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
        }
        return 0;
    }

    private boolean fullScroll(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        this.eq.top = 0;
        this.eq.bottom = height;
        if (i2 != 0) {
            i2 = getChildCount();
            if (i2 > 0) {
                this.eq.bottom = getChildAt(i2 - 1).getBottom() + getPaddingBottom();
                this.eq.top = this.eq.bottom - height;
            }
        }
        return e(i, this.eq.top, this.eq.bottom);
    }

    private boolean e(int i, int i2, int i3) {
        boolean z;
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        Object obj = i == 33 ? 1 : null;
        List focusables = getFocusables(2);
        View view = null;
        Object obj2 = null;
        int size = focusables.size();
        int i5 = 0;
        while (i5 < size) {
            View view2;
            Object obj3;
            View view3 = (View) focusables.get(i5);
            int top = view3.getTop();
            int bottom = view3.getBottom();
            if (i2 < bottom && top < i3) {
                Object obj4 = (i2 >= top || bottom >= i3) ? null : 1;
                if (view == null) {
                    Object obj5 = obj4;
                    view2 = view3;
                    obj3 = obj5;
                } else {
                    Object obj6 = ((obj == null || top >= view.getTop()) && (obj != null || bottom <= view.getBottom())) ? null : 1;
                    if (obj2 != null) {
                        if (!(obj4 == null || obj6 == null)) {
                            view2 = view3;
                            obj3 = obj2;
                        }
                    } else if (obj4 != null) {
                        view2 = view3;
                        height = 1;
                    } else if (obj6 != null) {
                        view2 = view3;
                        obj3 = obj2;
                    }
                }
                i5++;
                view = view2;
                obj2 = obj3;
            }
            obj3 = obj2;
            view2 = view;
            i5++;
            view = view2;
            obj2 = obj3;
        }
        if (view == null) {
            view = this;
        }
        if (i2 < scrollY || i3 > i4) {
            ai(obj != null ? i2 - scrollY : i3 - i4);
            z = true;
        } else {
            z = false;
        }
        if (view != findFocus()) {
            view.requestFocus(i);
        }
        return z;
    }

    private boolean arrowScroll(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int height = (int) (0.5f * ((float) getHeight()));
        if (findNextFocus == null || !d(findNextFocus, height, getHeight())) {
            if (i == 33 && getScrollY() < height) {
                height = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                int bottom = getChildAt(0).getBottom();
                int scrollY = (getScrollY() + getHeight()) - getPaddingBottom();
                if (bottom - scrollY < height) {
                    height = bottom - scrollY;
                }
            }
            if (height == 0) {
                return false;
            }
            if (i != 130) {
                height = -height;
            }
            ai(height);
        } else {
            findNextFocus.getDrawingRect(this.eq);
            offsetDescendantRectToMyCoords(findNextFocus, this.eq);
            ai(computeScrollDeltaToGetChildRectOnScreen(this.eq));
            findNextFocus.requestFocus(i);
        }
        if (findFocus != null && findFocus.isFocused() && aC(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    private boolean aC(View view) {
        return !d(view, 0, getHeight());
    }

    private boolean d(View view, int i, int i2) {
        view.getDrawingRect(this.eq);
        offsetDescendantRectToMyCoords(view, this.eq);
        return this.eq.bottom + i >= getScrollY() && this.eq.top - i <= getScrollY() + i2;
    }

    private void ai(int i) {
        if (i == 0) {
            return;
        }
        if (this.Dc) {
            smoothScrollBy(0, i);
        } else {
            scrollBy(0, i);
        }
    }

    private void smoothScrollBy(int i, int i2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.CV > 250) {
                int max = Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
                int scrollY = getScrollY();
                int max2 = Math.max(0, Math.min(scrollY + i2, max)) - scrollY;
                q qVar = this.iB;
                qVar.Dw.a(qVar.Dv, getScrollX(), scrollY, 0, max2);
                z.F(this);
            } else {
                if (!this.iB.isFinished()) {
                    this.iB.abortAnimation();
                }
                scrollBy(i, i2);
            }
            this.CV = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public final void aj(int i) {
        smoothScrollBy(0 - getScrollX(), i - getScrollY());
    }

    public int computeVerticalScrollRange() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (getChildCount() == 0) {
            return height;
        }
        int bottom = getChildAt(0).getBottom();
        int scrollY = getScrollY();
        height = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        if (scrollY > height) {
            return bottom + (scrollY - height);
        }
        return bottom;
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    protected void measureChild(View view, int i, int i2) {
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), MeasureSpec.makeMeasureSpec(0, 0));
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width), MeasureSpec.makeMeasureSpec(marginLayoutParams.bottomMargin + marginLayoutParams.topMargin, 0));
    }

    public void computeScroll() {
        if (this.iB.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.iB.getCurrX();
            int currY = this.iB.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                int cy = cy();
                int C = z.C(this);
                Object obj = (C == 0 || (C == 1 && cy > 0)) ? 1 : null;
                d(currX - scrollX, currY - scrollY, scrollX, scrollY, cy);
                if (obj != null) {
                    cA();
                    if (currY <= 0 && scrollY > 0) {
                        this.CW.ag((int) this.iB.getCurrVelocity());
                    } else if (currY >= cy && scrollY < cy) {
                        this.CX.ag((int) this.iB.getCurrVelocity());
                    }
                }
            }
        }
    }

    private void aD(View view) {
        view.getDrawingRect(this.eq);
        offsetDescendantRectToMyCoords(view, this.eq);
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(this.eq);
        if (computeScrollDeltaToGetChildRectOnScreen != 0) {
            scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
        }
    }

    private int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < getChildAt(0).getHeight()) {
            i -= verticalFadingEdgeLength;
        }
        if (rect.bottom > i && rect.top > scrollY) {
            if (rect.height() > height) {
                scrollY = (rect.top - scrollY) + 0;
            } else {
                scrollY = (rect.bottom - i) + 0;
            }
            scrollY = Math.min(scrollY, getChildAt(0).getBottom() - i);
        } else if (rect.top >= scrollY || rect.bottom >= i) {
            scrollY = 0;
        } else {
            if (rect.height() > height) {
                scrollY = 0 - (i - rect.bottom);
            } else {
                scrollY = 0 - (scrollY - rect.top);
            }
            scrollY = Math.max(scrollY, -getScrollY());
        }
        return scrollY;
    }

    public void requestChildFocus(View view, View view2) {
        if (this.CY) {
            this.Da = view2;
        } else {
            aD(view2);
        }
        super.requestChildFocus(view, view2);
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        View findNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        if (findNextFocus == null || aC(findNextFocus)) {
            return false;
        }
        return findNextFocus.requestFocus(i, rect);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
        boolean z2 = computeScrollDeltaToGetChildRectOnScreen != 0;
        if (z2) {
            if (z) {
                scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            } else {
                smoothScrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            }
        }
        return z2;
    }

    public void requestLayout() {
        this.CY = true;
        super.requestLayout();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.CY = false;
        if (this.Da != null && a(this.Da, this)) {
            aD(this.Da);
        }
        this.Da = null;
        if (!this.CZ) {
            if (this.Dg != null) {
                scrollTo(getScrollX(), this.Dg.Dn);
                this.Dg = null;
            }
            int max = Math.max(0, (getChildCount() > 0 ? getChildAt(0).getMeasuredHeight() : 0) - (((i4 - i2) - getPaddingBottom()) - getPaddingTop()));
            if (getScrollY() > max) {
                scrollTo(getScrollX(), max);
            } else if (getScrollY() < 0) {
                scrollTo(getScrollX(), 0);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.CZ = true;
    }

    public void onAttachedToWindow() {
        this.CZ = false;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && d(findFocus, 0, i4)) {
            findFocus.getDrawingRect(this.eq);
            offsetDescendantRectToMyCoords(findFocus, this.eq);
            ai(computeScrollDeltaToGetChildRectOnScreen(this.eq));
        }
    }

    private static boolean a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && a((View) parent, view2);
    }

    public void fling(int i) {
        if (getChildCount() > 0) {
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            int height2 = getChildAt(0).getHeight();
            q qVar = this.iB;
            qVar.Dw.a(qVar.Dv, getScrollX(), getScrollY(), 0, i, 0, 0, 0, Math.max(0, height2 - height), 0, height / 2);
            z.F(this);
        }
    }

    private void ak(int i) {
        int scrollY = getScrollY();
        boolean z = (scrollY > 0 || i > 0) && (scrollY < cy() || i < 0);
        if (!dispatchNestedPreFling(0.0f, (float) i)) {
            dispatchNestedFling(0.0f, (float) i, z);
            if (z) {
                fling(i);
            }
        }
    }

    private void cz() {
        this.iC = false;
        cx();
        stopNestedScroll();
        if (this.CW != null) {
            this.CW.cr();
            this.CX.cr();
        }
    }

    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int d = d(i, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int d2 = d(i2, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (d != getScrollX() || d2 != getScrollY()) {
                super.scrollTo(d, d2);
            }
        }
    }

    private void cA() {
        if (z.C(this) == 2) {
            this.CW = null;
            this.CX = null;
        } else if (this.CW == null) {
            Context context = getContext();
            this.CW = new i(context);
            this.CX = new i(context);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.CW != null) {
            int save;
            int width;
            int scrollY = getScrollY();
            if (!this.CW.isFinished()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate((float) getPaddingLeft(), (float) Math.min(0, scrollY));
                this.CW.setSize(width, getHeight());
                if (this.CW.draw(canvas)) {
                    z.F(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.CX.isFinished()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                int height = getHeight();
                canvas.translate((float) ((-width) + getPaddingLeft()), (float) (Math.max(cy(), scrollY) + height));
                canvas.rotate(180.0f, (float) width, 0.0f);
                this.CX.setSize(width, height);
                if (this.CX.draw(canvas)) {
                    z.F(this);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    private static int d(int i, int i2, int i3) {
        if (i2 >= i3 || i < 0) {
            return 0;
        }
        if (i2 + i > i3) {
            return i3 - i2;
        }
        return i;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.Dg = savedState;
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.Dn = getScrollY();
        return savedState;
    }
}
