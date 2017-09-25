package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ai;
import android.support.v4.view.am;
import android.support.v4.view.an;
import android.support.v4.view.r;
import android.support.v4.view.s;
import android.support.v4.view.z;
import android.support.v4.widget.q;
import android.support.v7.a.a.f;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window.Callback;
import com.tencent.mm.plugin.gif.MMGIFException;

public class ActionBarOverlayLayout extends ViewGroup implements r, t {
    static final int[] xQ = new int[]{android.support.v7.a.a.a.actionBarSize, 16842841};
    private final s Dj;
    private u HI;
    private boolean Ix;
    private int Sa;
    public int Sb = 0;
    private ContentFrameLayout Sc;
    private ActionBarContainer Sd;
    private Drawable Se;
    private boolean Sf;
    public boolean Sg;
    public boolean Sh;
    private boolean Si;
    private int Sj;
    public int Sk;
    private final Rect Sl = new Rect();
    private final Rect Sm = new Rect();
    private final Rect Sn = new Rect();
    private final Rect So = new Rect();
    private final Rect Sp = new Rect();
    private final Rect Sq = new Rect();
    public a Sr;
    private final int Ss = 600;
    private q St;
    private ai Su;
    private final am Sv = new an(this) {
        final /* synthetic */ ActionBarOverlayLayout Sy;

        {
            this.Sy = r1;
        }

        public final void q(View view) {
            this.Sy.Su = null;
            this.Sy.Si = false;
        }

        public final void as(View view) {
            this.Sy.Su = null;
            this.Sy.Si = false;
        }
    };
    private final Runnable Sw = new Runnable(this) {
        final /* synthetic */ ActionBarOverlayLayout Sy;

        {
            this.Sy = r1;
        }

        public final void run() {
            this.Sy.dS();
            this.Sy.Su = z.V(this.Sy.Sd).r(0.0f).a(this.Sy.Sv);
        }
    };
    private final Runnable Sx = new Runnable(this) {
        final /* synthetic */ ActionBarOverlayLayout Sy;

        {
            this.Sy = r1;
        }

        public final void run() {
            this.Sy.dS();
            this.Sy.Su = z.V(this.Sy.Sd).r((float) (-this.Sy.Sd.getHeight())).a(this.Sy.Sv);
        }
    };

    public static class LayoutParams extends MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public interface a {
        void A(boolean z);

        void da();

        void db();

        void dc();

        void onWindowVisibilityChanged(int i);
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
        this.Dj = new s(this);
    }

    private void init(Context context) {
        boolean z = true;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(xQ);
        this.Sa = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.Se = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.Se == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion >= 19) {
            z = false;
        }
        this.Sf = z;
        this.St = q.a(context, null);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dS();
    }

    public static void dP() {
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        init(getContext());
        z.Z(this);
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        boolean z;
        boolean z2 = true;
        if (VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        dQ();
        int i2 = this.Sk ^ i;
        this.Sk = i;
        boolean z3 = (i & 4) == 0;
        if ((i & 256) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.Sr != null) {
            a aVar = this.Sr;
            if (z) {
                z2 = false;
            }
            aVar.A(z2);
            if (z3 || !z) {
                this.Sr.da();
            } else {
                this.Sr.db();
            }
        }
        if ((i2 & 256) != 0 && this.Sr != null) {
            z.Z(this);
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.Sb = i;
        if (this.Sr != null) {
            this.Sr.onWindowVisibilityChanged(i);
        }
    }

    private static boolean a(View view, Rect rect, boolean z) {
        boolean z2 = false;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.leftMargin != rect.left) {
            layoutParams.leftMargin = rect.left;
            z2 = true;
        }
        if (layoutParams.topMargin != rect.top) {
            layoutParams.topMargin = rect.top;
            z2 = true;
        }
        if (layoutParams.rightMargin != rect.right) {
            layoutParams.rightMargin = rect.right;
            z2 = true;
        }
        if (!z || layoutParams.bottomMargin == rect.bottom) {
            return z2;
        }
        layoutParams.bottomMargin = rect.bottom;
        return true;
    }

    protected boolean fitSystemWindows(Rect rect) {
        dQ();
        z.Y(this);
        boolean a = a(this.Sd, rect, false);
        this.So.set(rect);
        at.a(this, this.So, this.Sl);
        if (!this.Sm.equals(this.Sl)) {
            this.Sm.set(this.Sl);
            a = true;
        }
        if (a) {
            requestLayout();
        }
        return true;
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        dQ();
        measureChildWithMargins(this.Sd, i, 0, i2, 0);
        LayoutParams layoutParams = (LayoutParams) this.Sd.getLayoutParams();
        int max = Math.max(0, (this.Sd.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin);
        int max2 = Math.max(0, layoutParams.bottomMargin + (this.Sd.getMeasuredHeight() + layoutParams.topMargin));
        int combineMeasuredStates = at.combineMeasuredStates(0, z.N(this.Sd));
        boolean z = (z.Y(this) & 256) != 0;
        if (z) {
            i3 = this.Sa;
            if (this.Sh && this.Sd.RJ != null) {
                i3 += this.Sa;
            }
        } else {
            i3 = this.Sd.getVisibility() != 8 ? this.Sd.getMeasuredHeight() : 0;
        }
        this.Sn.set(this.Sl);
        this.Sp.set(this.So);
        Rect rect;
        Rect rect2;
        if (this.Sg || z) {
            rect = this.Sp;
            rect.top = i3 + rect.top;
            rect2 = this.Sp;
            rect2.bottom += 0;
        } else {
            rect = this.Sn;
            rect.top = i3 + rect.top;
            rect2 = this.Sn;
            rect2.bottom += 0;
        }
        a(this.Sc, this.Sn, true);
        if (!this.Sq.equals(this.Sp)) {
            this.Sq.set(this.Sp);
            this.Sc.e(this.Sp);
        }
        measureChildWithMargins(this.Sc, i, 0, i2, 0);
        layoutParams = (LayoutParams) this.Sc.getLayoutParams();
        int max3 = Math.max(max, (this.Sc.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin);
        i3 = Math.max(max2, layoutParams.bottomMargin + (this.Sc.getMeasuredHeight() + layoutParams.topMargin));
        int combineMeasuredStates2 = at.combineMeasuredStates(combineMeasuredStates, z.N(this.Sc));
        setMeasuredDimension(z.resolveSizeAndState(Math.max(max3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, combineMeasuredStates2), z.resolveSizeAndState(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int i6 = layoutParams.leftMargin + paddingLeft;
                int i7 = layoutParams.topMargin + paddingTop;
                childAt.layout(i6, i7, childAt.getMeasuredWidth() + i6, childAt.getMeasuredHeight() + i7);
            }
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.Se != null && !this.Sf) {
            int bottom = this.Sd.getVisibility() == 0 ? (int) ((((float) this.Sd.getBottom()) + z.S(this.Sd)) + 0.5f) : 0;
            this.Se.setBounds(0, bottom, getWidth(), this.Se.getIntrinsicHeight() + bottom);
            this.Se.draw(canvas);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.Sd.getVisibility() != 0) {
            return false;
        }
        return this.Ix;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.Dj.xn = i;
        this.Sj = dR();
        dS();
        if (this.Sr != null) {
            this.Sr.dc();
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.Sj += i2;
        az(this.Sj);
    }

    public void onStopNestedScroll(View view) {
        if (this.Ix && !this.Si) {
            if (this.Sj <= this.Sd.getHeight()) {
                dS();
                postDelayed(this.Sw, 600);
                return;
            }
            dS();
            postDelayed(this.Sx, 600);
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        boolean z2 = false;
        if (!this.Ix || !z) {
            return false;
        }
        this.St.a(0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.St.getFinalY() > this.Sd.getHeight()) {
            z2 = true;
        }
        if (z2) {
            dS();
            this.Sx.run();
        } else {
            dS();
            this.Sw.run();
        }
        this.Si = true;
        return true;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public int getNestedScrollAxes() {
        return this.Dj.xn;
    }

    private void dQ() {
        if (this.Sc == null) {
            u uVar;
            this.Sc = (ContentFrameLayout) findViewById(f.JM);
            this.Sd = (ActionBarContainer) findViewById(f.JN);
            View findViewById = findViewById(f.JL);
            if (findViewById instanceof u) {
                uVar = (u) findViewById;
            } else if (findViewById instanceof Toolbar) {
                uVar = ((Toolbar) findViewById).gZ();
            } else {
                throw new IllegalStateException("Can't make a decor toolbar out of " + findViewById.getClass().getSimpleName());
            }
            this.HI = uVar;
        }
    }

    public final void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.Ix) {
            this.Ix = z;
            if (!z) {
                dS();
                az(0);
            }
        }
    }

    public final int dR() {
        return this.Sd != null ? -((int) z.S(this.Sd)) : 0;
    }

    private void az(int i) {
        dS();
        z.c(this.Sd, (float) (-Math.max(0, Math.min(i, this.Sd.getHeight()))));
    }

    private void dS() {
        removeCallbacks(this.Sw);
        removeCallbacks(this.Sx);
        if (this.Su != null) {
            this.Su.cancel();
        }
    }

    public final void b(Callback callback) {
        dQ();
        this.HI.b(callback);
    }

    public final void e(CharSequence charSequence) {
        dQ();
        this.HI.e(charSequence);
    }

    public final void aA(int i) {
        boolean z = true;
        dQ();
        switch (i) {
            case MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM /*109*/:
                this.Sg = true;
                if (getContext().getApplicationInfo().targetSdkVersion >= 19) {
                    z = false;
                }
                this.Sf = z;
                return;
            default:
                return;
        }
    }

    public final boolean dT() {
        dQ();
        return this.HI.dT();
    }

    public final boolean isOverflowMenuShowing() {
        dQ();
        return this.HI.isOverflowMenuShowing();
    }

    public final boolean dU() {
        dQ();
        return this.HI.dU();
    }

    public final boolean showOverflowMenu() {
        dQ();
        return this.HI.showOverflowMenu();
    }

    public final boolean hideOverflowMenu() {
        dQ();
        return this.HI.hideOverflowMenu();
    }

    public final void dV() {
        dQ();
        this.HI.dV();
    }

    public final void a(Menu menu, android.support.v7.view.menu.l.a aVar) {
        dQ();
        this.HI.a(menu, aVar);
    }

    public final void dW() {
        dQ();
        this.HI.dismissPopupMenus();
    }
}
