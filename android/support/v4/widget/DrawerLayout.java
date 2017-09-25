package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.view.af;
import android.support.v4.view.g;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout extends ViewGroup implements h {
    static final c BZ;
    private static final boolean Bw = (VERSION.SDK_INT >= 19);
    private static final boolean Bx;
    private static final int[] ym = new int[]{16842931};
    private int BA;
    private int BB;
    private float BC;
    private Paint BD;
    final u BE;
    final u BF;
    private final f BG;
    private final f BH;
    int BI;
    private int BJ;
    private int BK;
    private int BL;
    private int BM;
    private boolean BN;
    boolean BO;
    private Drawable BP;
    private Drawable BQ;
    CharSequence BR;
    CharSequence BS;
    private Object BT;
    private Drawable BU;
    private Drawable BV;
    private Drawable BW;
    private Drawable BX;
    private final ArrayList<View> BY;
    private final b By;
    private float Bz;
    List<Object> eE;
    private boolean hp;
    private Drawable hq;
    private boolean pd;
    private float xC;
    private float xD;
    private boolean yW;

    public static class LayoutParams extends MarginLayoutParams {
        private float Cb;
        private boolean Cc;
        private int Cd;
        public int gravity = 0;

        static /* synthetic */ int b(LayoutParams layoutParams, int i) {
            int i2 = layoutParams.Cd | i;
            layoutParams.Cd = i2;
            return i2;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.ym);
            this.gravity = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = layoutParams.gravity;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    protected static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Ce = 0;
        int Cf;
        int Cg;
        int Ch;
        int Ci;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.Ce = parcel.readInt();
            this.Cf = parcel.readInt();
            this.Cg = parcel.readInt();
            this.Ch = parcel.readInt();
            this.Ci = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Ce);
            parcel.writeInt(this.Cf);
            parcel.writeInt(this.Cg);
            parcel.writeInt(this.Ch);
            parcel.writeInt(this.Ci);
        }
    }

    interface c {
        int G(Object obj);

        void a(View view, Object obj, int i);

        void a(MarginLayoutParams marginLayoutParams, Object obj, int i);

        void aB(View view);

        Drawable l(Context context);
    }

    class a extends android.support.v4.view.a {
        final /* synthetic */ DrawerLayout Ca;
        private final Rect gG = new Rect();

        a(DrawerLayout drawerLayout) {
            this.Ca = drawerLayout;
        }

        public final void a(View view, android.support.v4.view.a.b bVar) {
            if (DrawerLayout.Bw) {
                super.a(view, bVar);
            } else {
                android.support.v4.view.a.b a = android.support.v4.view.a.b.a(bVar);
                super.a(view, a);
                bVar.setSource(view);
                ViewParent K = z.K(view);
                if (K instanceof View) {
                    bVar.setParent((View) K);
                }
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
                a.recycle();
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (DrawerLayout.aA(childAt)) {
                        bVar.addChild(childAt);
                    }
                }
            }
            bVar.setClassName(DrawerLayout.class.getName());
            bVar.setFocusable(false);
            bVar.setFocused(false);
            bVar.a(android.support.v4.view.a.b.a.zM);
            bVar.a(android.support.v4.view.a.b.a.zN);
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.class.getName());
        }

        public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() != 32) {
                return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            List text = accessibilityEvent.getText();
            View a = this.Ca.cn();
            if (a != null) {
                int av = this.Ca.av(a);
                View view2 = this.Ca;
                av = android.support.v4.view.f.getAbsoluteGravity(av, z.J(view2));
                Object obj = av == 3 ? view2.BR : av == 5 ? view2.BS : null;
                if (obj != null) {
                    text.add(obj);
                }
            }
            return true;
        }

        public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.Bw || DrawerLayout.aA(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    final class b extends android.support.v4.view.a {
        final /* synthetic */ DrawerLayout Ca;

        b(DrawerLayout drawerLayout) {
            this.Ca = drawerLayout;
        }

        public final void a(View view, android.support.v4.view.a.b bVar) {
            super.a(view, bVar);
            if (!DrawerLayout.aA(view)) {
                bVar.setParent(null);
            }
        }
    }

    static class d implements c {
        d() {
        }

        public final void aB(View view) {
            g.aB(view);
        }

        public final void a(View view, Object obj, int i) {
            g.a(view, obj, i);
        }

        public final void a(MarginLayoutParams marginLayoutParams, Object obj, int i) {
            g.a(marginLayoutParams, obj, i);
        }

        public final int G(Object obj) {
            return g.G(obj);
        }

        public final Drawable l(Context context) {
            return g.l(context);
        }
    }

    static class e implements c {
        e() {
        }

        public final void aB(View view) {
        }

        public final void a(View view, Object obj, int i) {
        }

        public final void a(MarginLayoutParams marginLayoutParams, Object obj, int i) {
        }

        public final int G(Object obj) {
            return 0;
        }

        public final Drawable l(Context context) {
            return null;
        }
    }

    private class f extends android.support.v4.widget.u.a {
        final /* synthetic */ DrawerLayout Ca;
        final int Cj;
        u Ck;
        private final Runnable Cl = new Runnable(this) {
            final /* synthetic */ f Cm;

            {
                this.Cm = r1;
            }

            public final void run() {
                View af;
                int i = 0;
                f fVar = this.Cm;
                int i2 = fVar.Ck.EV;
                boolean z = fVar.Cj == 3;
                if (z) {
                    af = fVar.Ca.af(3);
                    i2 = (af != null ? -af.getWidth() : 0) + i2;
                } else {
                    i2 = fVar.Ca.getWidth() - i2;
                    af = fVar.Ca.af(5);
                }
                if (af == null) {
                    return;
                }
                if (((z && af.getLeft() < i2) || (!z && af.getLeft() > i2)) && fVar.Ca.at(af) == 0) {
                    LayoutParams layoutParams = (LayoutParams) af.getLayoutParams();
                    fVar.Ck.e(af, i2, af.getTop());
                    layoutParams.Cc = true;
                    fVar.Ca.invalidate();
                    fVar.cp();
                    DrawerLayout drawerLayout = fVar.Ca;
                    if (!drawerLayout.BO) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                        int childCount = drawerLayout.getChildCount();
                        while (i < childCount) {
                            drawerLayout.getChildAt(i).dispatchTouchEvent(obtain);
                            i++;
                        }
                        obtain.recycle();
                        drawerLayout.BO = true;
                    }
                }
            }
        };

        public f(DrawerLayout drawerLayout, int i) {
            this.Ca = drawerLayout;
            this.Cj = i;
        }

        public final void cl() {
            this.Ca.removeCallbacks(this.Cl);
        }

        public final boolean b(View view, int i) {
            return DrawerLayout.ax(view) && this.Ca.m(view, this.Cj) && this.Ca.at(view) == 0;
        }

        public final void j(int i) {
            int size;
            DrawerLayout drawerLayout = this.Ca;
            View view = this.Ck.EY;
            int i2 = drawerLayout.BE.EK;
            int i3 = drawerLayout.BF.EK;
            i2 = (i2 == 1 || i3 == 1) ? 1 : (i2 == 2 || i3 == 2) ? 2 : 0;
            if (view != null && i == 0) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if (layoutParams.Cb == 0.0f) {
                    layoutParams = (LayoutParams) view.getLayoutParams();
                    if ((layoutParams.Cd & 1) == 1) {
                        layoutParams.Cd = 0;
                        if (drawerLayout.eE != null) {
                            for (size = drawerLayout.eE.size() - 1; size >= 0; size--) {
                                drawerLayout.eE.get(size);
                            }
                        }
                        drawerLayout.d(view, false);
                        if (drawerLayout.hasWindowFocus()) {
                            View rootView = drawerLayout.getRootView();
                            if (rootView != null) {
                                rootView.sendAccessibilityEvent(32);
                            }
                        }
                    }
                } else if (layoutParams.Cb == 1.0f) {
                    layoutParams = (LayoutParams) view.getLayoutParams();
                    if ((layoutParams.Cd & 1) == 0) {
                        layoutParams.Cd = 1;
                        if (drawerLayout.eE != null) {
                            for (size = drawerLayout.eE.size() - 1; size >= 0; size--) {
                                drawerLayout.eE.get(size);
                            }
                        }
                        drawerLayout.d(view, true);
                        if (drawerLayout.hasWindowFocus()) {
                            drawerLayout.sendAccessibilityEvent(32);
                        }
                        view.requestFocus();
                    }
                }
            }
            if (i2 != drawerLayout.BI) {
                drawerLayout.BI = i2;
                if (drawerLayout.eE != null) {
                    for (size = drawerLayout.eE.size() - 1; size >= 0; size--) {
                        drawerLayout.eE.get(size);
                    }
                }
            }
        }

        public final void a(View view, int i, int i2) {
            float f;
            int width = view.getWidth();
            if (this.Ca.m(view, 3)) {
                f = ((float) (width + i)) / ((float) width);
            } else {
                f = ((float) (this.Ca.getWidth() - i)) / ((float) width);
            }
            this.Ca.i(view, f);
            view.setVisibility(f == 0.0f ? 4 : 0);
            this.Ca.invalidate();
        }

        public final void f(View view, int i) {
            ((LayoutParams) view.getLayoutParams()).Cc = false;
            cp();
        }

        final void cp() {
            int i = 3;
            if (this.Cj == 3) {
                i = 5;
            }
            View af = this.Ca.af(i);
            if (af != null) {
                this.Ca.az(af);
            }
        }

        public final void a(View view, float f, float f2) {
            int i;
            float au = DrawerLayout.au(view);
            int width = view.getWidth();
            if (this.Ca.m(view, 3)) {
                i = (f > 0.0f || (f == 0.0f && au > 0.5f)) ? 0 : -width;
            } else {
                i = this.Ca.getWidth();
                if (f < 0.0f || (f == 0.0f && au > 0.5f)) {
                    i -= width;
                }
            }
            this.Ck.q(i, view.getTop());
            this.Ca.invalidate();
        }

        public final void cq() {
            this.Ca.postDelayed(this.Cl, 160);
        }

        public final void n(int i, int i2) {
            View af;
            if ((i & 1) == 1) {
                af = this.Ca.af(3);
            } else {
                af = this.Ca.af(5);
            }
            if (af != null && this.Ca.at(af) == 0) {
                this.Ck.n(af, i2);
            }
        }

        public final int s(View view) {
            return DrawerLayout.ax(view) ? view.getWidth() : 0;
        }

        public final int d(View view, int i) {
            if (this.Ca.m(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = this.Ca.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }

        public final int c(View view, int i) {
            return view.getTop();
        }
    }

    static /* synthetic */ boolean aA(View view) {
        return (z.G(view) == 4 || z.G(view) == 2) ? false : true;
    }

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 21) {
            z = false;
        }
        Bx = z;
        if (VERSION.SDK_INT >= 21) {
            BZ = new d();
        } else {
            BZ = new e();
        }
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.By = new b(this);
        this.BB = -1728053248;
        this.BD = new Paint();
        this.yW = true;
        this.BJ = 3;
        this.BK = 3;
        this.BL = 3;
        this.BM = 3;
        this.BU = null;
        this.BV = null;
        this.BW = null;
        this.BX = null;
        setDescendantFocusability(262144);
        float f = getResources().getDisplayMetrics().density;
        this.BA = (int) ((64.0f * f) + 0.5f);
        float f2 = 400.0f * f;
        this.BG = new f(this, 3);
        this.BH = new f(this, 5);
        this.BE = u.a((ViewGroup) this, 1.0f, this.BG);
        this.BE.EW = 1;
        this.BE.EU = f2;
        this.BG.Ck = this.BE;
        this.BF = u.a((ViewGroup) this, 1.0f, this.BH);
        this.BF.EW = 2;
        this.BF.EU = f2;
        this.BH.Ck = this.BF;
        setFocusableInTouchMode(true);
        z.i(this, 1);
        z.a((View) this, new a(this));
        af.b(this);
        if (z.aa(this)) {
            BZ.aB(this);
            this.hq = BZ.l(context);
        }
        this.Bz = f * 10.0f;
        this.BY = new ArrayList();
    }

    public final void k(Object obj, boolean z) {
        this.BT = obj;
        this.hp = z;
        boolean z2 = !z && getBackground() == null;
        setWillNotDraw(z2);
        requestLayout();
    }

    private void m(int i, int i2) {
        int absoluteGravity = android.support.v4.view.f.getAbsoluteGravity(i2, z.J(this));
        switch (i2) {
            case 3:
                this.BJ = i;
                break;
            case 5:
                this.BK = i;
                break;
            case 8388611:
                this.BL = i;
                break;
            case 8388613:
                this.BM = i;
                break;
        }
        if (i != 0) {
            (absoluteGravity == 3 ? this.BE : this.BF).cancel();
        }
        View af;
        switch (i) {
            case 1:
                af = af(absoluteGravity);
                if (af != null) {
                    az(af);
                    return;
                }
                return;
            case 2:
                af = af(absoluteGravity);
                if (af != null) {
                    ay(af);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final int at(View view) {
        if (ax(view)) {
            int i = ((LayoutParams) view.getLayoutParams()).gravity;
            int J = z.J(this);
            switch (i) {
                case 3:
                    if (this.BJ != 3) {
                        return this.BJ;
                    }
                    i = J == 0 ? this.BL : this.BM;
                    if (i != 3) {
                        return i;
                    }
                    break;
                case 5:
                    if (this.BK != 3) {
                        return this.BK;
                    }
                    i = J == 0 ? this.BM : this.BL;
                    if (i != 3) {
                        return i;
                    }
                    break;
                case 8388611:
                    if (this.BL != 3) {
                        return this.BL;
                    }
                    i = J == 0 ? this.BJ : this.BK;
                    if (i != 3) {
                        return i;
                    }
                    break;
                case 8388613:
                    if (this.BM != 3) {
                        return this.BM;
                    }
                    i = J == 0 ? this.BK : this.BJ;
                    if (i != 3) {
                        return i;
                    }
                    break;
            }
            return 0;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    final void d(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z || ax(childAt)) && !(z && childAt == view)) {
                z.i(childAt, 4);
            } else {
                z.i(childAt, 1);
            }
        }
    }

    final void i(View view, float f) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f != layoutParams.Cb) {
            layoutParams.Cb = f;
            if (this.eE != null) {
                for (int size = this.eE.size() - 1; size >= 0; size--) {
                    this.eE.get(size);
                }
            }
        }
    }

    static float au(View view) {
        return ((LayoutParams) view.getLayoutParams()).Cb;
    }

    final int av(View view) {
        return android.support.v4.view.f.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).gravity, z.J(this));
    }

    final boolean m(View view, int i) {
        return (av(view) & i) == i;
    }

    private View cm() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((LayoutParams) childAt.getLayoutParams()).Cd & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    final View af(int i) {
        int absoluteGravity = android.support.v4.view.f.getAbsoluteGravity(i, z.J(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((av(childAt) & 7) == absoluteGravity) {
                return childAt;
            }
        }
        return null;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.yW = true;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.yW = true;
    }

    protected void onMeasure(int i, int i2) {
        Object obj;
        int J;
        Object obj2;
        Object obj3;
        int childCount;
        int i3;
        View childAt;
        MarginLayoutParams marginLayoutParams;
        int absoluteGravity;
        int av;
        Object obj4;
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (!(mode == 1073741824 && mode2 == 1073741824)) {
            if (isInEditMode()) {
                if (mode != Integer.MIN_VALUE && mode == 0) {
                    size = com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX;
                }
                if (mode2 != Integer.MIN_VALUE && mode2 == 0) {
                    mode = size;
                    size = com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX;
                    setMeasuredDimension(mode, size);
                    if (this.BT == null && z.aa(this)) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    J = z.J(this);
                    obj2 = null;
                    obj3 = null;
                    childCount = getChildCount();
                    for (i3 = 0; i3 < childCount; i3++) {
                        childAt = getChildAt(i3);
                        if (childAt.getVisibility() != 8) {
                            marginLayoutParams = (LayoutParams) childAt.getLayoutParams();
                            if (obj != null) {
                                absoluteGravity = android.support.v4.view.f.getAbsoluteGravity(marginLayoutParams.gravity, J);
                                if (z.aa(childAt)) {
                                    BZ.a(marginLayoutParams, this.BT, absoluteGravity);
                                } else {
                                    BZ.a(childAt, this.BT, absoluteGravity);
                                }
                            }
                            if (aw(childAt)) {
                                childAt.measure(MeasureSpec.makeMeasureSpec((mode - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, 1073741824), MeasureSpec.makeMeasureSpec((size - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin, 1073741824));
                            } else if (ax(childAt)) {
                                throw new IllegalStateException("Child " + childAt + " at index " + i3 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                            } else {
                                if (Bx && z.X(childAt) != this.Bz) {
                                    z.g(childAt, this.Bz);
                                }
                                av = av(childAt) & 7;
                                obj4 = av != 3 ? 1 : null;
                                if ((obj4 != null || r5 == null) && (obj4 != null || r4 == null)) {
                                    if (obj4 == null) {
                                        obj2 = 1;
                                    } else {
                                        obj3 = 1;
                                    }
                                    childAt.measure(getChildMeasureSpec(i, (this.BA + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin, marginLayoutParams.width), getChildMeasureSpec(i2, marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
                                } else {
                                    StringBuilder stringBuilder = new StringBuilder("Child drawer has absolute gravity ");
                                    String toHexString = (av & 3) == 3 ? "LEFT" : (av & 5) == 5 ? "RIGHT" : Integer.toHexString(av);
                                    throw new IllegalStateException(stringBuilder.append(toHexString).append(" but this DrawerLayout already has a drawer view along that edge").toString());
                                }
                            }
                        }
                    }
                }
            }
            throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
        }
        mode = size;
        size = size2;
        setMeasuredDimension(mode, size);
        if (this.BT == null) {
        }
        obj = null;
        J = z.J(this);
        obj2 = null;
        obj3 = null;
        childCount = getChildCount();
        for (i3 = 0; i3 < childCount; i3++) {
            childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                marginLayoutParams = (LayoutParams) childAt.getLayoutParams();
                if (obj != null) {
                    absoluteGravity = android.support.v4.view.f.getAbsoluteGravity(marginLayoutParams.gravity, J);
                    if (z.aa(childAt)) {
                        BZ.a(marginLayoutParams, this.BT, absoluteGravity);
                    } else {
                        BZ.a(childAt, this.BT, absoluteGravity);
                    }
                }
                if (aw(childAt)) {
                    childAt.measure(MeasureSpec.makeMeasureSpec((mode - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, 1073741824), MeasureSpec.makeMeasureSpec((size - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin, 1073741824));
                } else if (ax(childAt)) {
                    throw new IllegalStateException("Child " + childAt + " at index " + i3 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                } else {
                    z.g(childAt, this.Bz);
                    av = av(childAt) & 7;
                    if (av != 3) {
                    }
                    if (obj4 != null) {
                    }
                    if (obj4 == null) {
                        obj3 = 1;
                    } else {
                        obj2 = 1;
                    }
                    childAt.measure(getChildMeasureSpec(i, (this.BA + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin, marginLayoutParams.width), getChildMeasureSpec(i2, marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
                }
            }
        }
    }

    private static boolean c(Drawable drawable, int i) {
        if (drawable == null || !android.support.v4.b.a.a.c(drawable)) {
            return false;
        }
        android.support.v4.b.a.a.b(drawable, i);
        return true;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.pd = true;
        int i5 = i3 - i;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (aw(childAt)) {
                    childAt.layout(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + childAt.getMeasuredWidth(), layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int a;
                    float f;
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (m(childAt, 3)) {
                        a = ((int) (((float) measuredWidth) * layoutParams.Cb)) + (-measuredWidth);
                        f = ((float) (measuredWidth + a)) / ((float) measuredWidth);
                    } else {
                        a = i5 - ((int) (((float) measuredWidth) * layoutParams.Cb));
                        f = ((float) (i5 - a)) / ((float) measuredWidth);
                    }
                    Object obj = f != layoutParams.Cb ? 1 : null;
                    int i7;
                    switch (layoutParams.gravity & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                        case 16:
                            int i8 = i4 - i2;
                            i7 = (i8 - measuredHeight) / 2;
                            if (i7 < layoutParams.topMargin) {
                                i7 = layoutParams.topMargin;
                            } else if (i7 + measuredHeight > i8 - layoutParams.bottomMargin) {
                                i7 = (i8 - layoutParams.bottomMargin) - measuredHeight;
                            }
                            childAt.layout(a, i7, measuredWidth + a, measuredHeight + i7);
                            break;
                        case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*80*/:
                            i7 = i4 - i2;
                            childAt.layout(a, (i7 - layoutParams.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + a, i7 - layoutParams.bottomMargin);
                            break;
                        default:
                            childAt.layout(a, layoutParams.topMargin, measuredWidth + a, measuredHeight + layoutParams.topMargin);
                            break;
                    }
                    if (obj != null) {
                        i(childAt, f);
                    }
                    int i9 = layoutParams.Cb > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i9) {
                        childAt.setVisibility(i9);
                    }
                }
            }
        }
        this.pd = false;
        this.yW = false;
    }

    public void requestLayout() {
        if (!this.pd) {
            super.requestLayout();
        }
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((LayoutParams) getChildAt(i).getLayoutParams()).Cb);
        }
        this.BC = f;
        if ((this.BE.cH() | this.BF.cH()) != 0) {
            z.F(this);
        }
    }

    public void onRtlPropertiesChanged(int i) {
        if (!Bx) {
            Drawable drawable;
            int J = z.J(this);
            if (J == 0) {
                if (this.BU != null) {
                    c(this.BU, J);
                    drawable = this.BU;
                }
                drawable = this.BW;
            } else {
                if (this.BV != null) {
                    c(this.BV, J);
                    drawable = this.BV;
                }
                drawable = this.BW;
            }
            this.BP = drawable;
            J = z.J(this);
            if (J == 0) {
                if (this.BV != null) {
                    c(this.BV, J);
                    drawable = this.BV;
                }
                drawable = this.BX;
            } else {
                if (this.BU != null) {
                    c(this.BU, J);
                    drawable = this.BU;
                }
                drawable = this.BX;
            }
            this.BQ = drawable;
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.hp && this.hq != null) {
            int G = BZ.G(this.BT);
            if (G > 0) {
                this.hq.setBounds(0, 0, getWidth(), G);
                this.hq.draw(canvas);
            }
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        int right;
        int height = getHeight();
        boolean aw = aw(view);
        int i = 0;
        int width = getWidth();
        int save = canvas.save();
        if (aw) {
            int childCount = getChildCount();
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt != view && childAt.getVisibility() == 0) {
                    Drawable background = childAt.getBackground();
                    Object obj = background != null ? background.getOpacity() == -1 ? 1 : null : null;
                    if (obj != null && ax(childAt) && childAt.getHeight() >= height) {
                        if (m(childAt, 3)) {
                            right = childAt.getRight();
                            if (right <= i) {
                                right = i;
                            }
                            i = right;
                            right = width;
                        } else {
                            right = childAt.getLeft();
                            if (right < width) {
                            }
                        }
                        i2++;
                        width = right;
                    }
                }
                right = width;
                i2++;
                width = right;
            }
            canvas.clipRect(i, 0, width, getHeight());
        }
        right = width;
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        if (this.BC > 0.0f && aw) {
            this.BD.setColor((((int) (((float) ((this.BB & WebView.NIGHT_MODE_COLOR) >>> 24)) * this.BC)) << 24) | (this.BB & 16777215));
            canvas.drawRect((float) i, 0.0f, (float) right, (float) getHeight(), this.BD);
        } else if (this.BP != null && m(view, 3)) {
            right = this.BP.getIntrinsicWidth();
            i = view.getRight();
            r2 = Math.max(0.0f, Math.min(((float) i) / ((float) this.BE.EV), 1.0f));
            this.BP.setBounds(i, view.getTop(), right + i, view.getBottom());
            this.BP.setAlpha((int) (255.0f * r2));
            this.BP.draw(canvas);
        } else if (this.BQ != null && m(view, 5)) {
            right = this.BQ.getIntrinsicWidth();
            i = view.getLeft();
            r2 = Math.max(0.0f, Math.min(((float) (getWidth() - i)) / ((float) this.BF.EV), 1.0f));
            this.BQ.setBounds(i - right, view.getTop(), i, view.getBottom());
            this.BQ.setAlpha((int) (255.0f * r2));
            this.BQ.draw(canvas);
        }
        return drawChild;
    }

    private static boolean aw(View view) {
        return ((LayoutParams) view.getLayoutParams()).gravity == 0;
    }

    static boolean ax(View view) {
        int absoluteGravity = android.support.v4.view.f.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).gravity, z.J(view));
        if ((absoluteGravity & 3) != 0) {
            return true;
        }
        if ((absoluteGravity & 5) != 0) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r10) {
        /*
        r9 = this;
        r1 = 1;
        r2 = 0;
        r0 = android.support.v4.view.o.d(r10);
        r3 = r9.BE;
        r3 = r3.j(r10);
        r4 = r9.BF;
        r4 = r4.j(r10);
        r4 = r4 | r3;
        switch(r0) {
            case 0: goto L_0x003b;
            case 1: goto L_0x00ad;
            case 2: goto L_0x0064;
            case 3: goto L_0x00ad;
            default: goto L_0x0016;
        };
    L_0x0016:
        r0 = r2;
    L_0x0017:
        if (r4 != 0) goto L_0x0039;
    L_0x0019:
        if (r0 != 0) goto L_0x0039;
    L_0x001b:
        r4 = r9.getChildCount();
        r3 = r2;
    L_0x0020:
        if (r3 >= r4) goto L_0x00bb;
    L_0x0022:
        r0 = r9.getChildAt(r3);
        r0 = r0.getLayoutParams();
        r0 = (android.support.v4.widget.DrawerLayout.LayoutParams) r0;
        r0 = r0.Cc;
        if (r0 == 0) goto L_0x00b6;
    L_0x0032:
        r0 = r1;
    L_0x0033:
        if (r0 != 0) goto L_0x0039;
    L_0x0035:
        r0 = r9.BO;
        if (r0 == 0) goto L_0x003a;
    L_0x0039:
        r2 = r1;
    L_0x003a:
        return r2;
    L_0x003b:
        r0 = r10.getX();
        r3 = r10.getY();
        r9.xC = r0;
        r9.xD = r3;
        r5 = r9.BC;
        r6 = 0;
        r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1));
        if (r5 <= 0) goto L_0x00be;
    L_0x004e:
        r5 = r9.BE;
        r0 = (int) r0;
        r3 = (int) r3;
        r0 = r5.r(r0, r3);
        if (r0 == 0) goto L_0x00be;
    L_0x0058:
        r0 = aw(r0);
        if (r0 == 0) goto L_0x00be;
    L_0x005e:
        r0 = r1;
    L_0x005f:
        r9.BN = r2;
        r9.BO = r2;
        goto L_0x0017;
    L_0x0064:
        r5 = r9.BE;
        r0 = r5.EL;
        r6 = r0.length;
        r0 = r2;
    L_0x006a:
        if (r0 >= r6) goto L_0x00ab;
    L_0x006c:
        r3 = r5.an(r0);
        if (r3 == 0) goto L_0x00a6;
    L_0x0072:
        r3 = r5.EN;
        r3 = r3[r0];
        r7 = r5.EL;
        r7 = r7[r0];
        r3 = r3 - r7;
        r7 = r5.EO;
        r7 = r7[r0];
        r8 = r5.EM;
        r8 = r8[r0];
        r7 = r7 - r8;
        r3 = r3 * r3;
        r7 = r7 * r7;
        r3 = r3 + r7;
        r7 = r5.iE;
        r8 = r5.iE;
        r7 = r7 * r8;
        r7 = (float) r7;
        r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1));
        if (r3 <= 0) goto L_0x00a4;
    L_0x0091:
        r3 = r1;
    L_0x0092:
        if (r3 == 0) goto L_0x00a8;
    L_0x0094:
        r0 = r1;
    L_0x0095:
        if (r0 == 0) goto L_0x0016;
    L_0x0097:
        r0 = r9.BG;
        r0.cl();
        r0 = r9.BH;
        r0.cl();
        r0 = r2;
        goto L_0x0017;
    L_0x00a4:
        r3 = r2;
        goto L_0x0092;
    L_0x00a6:
        r3 = r2;
        goto L_0x0092;
    L_0x00a8:
        r0 = r0 + 1;
        goto L_0x006a;
    L_0x00ab:
        r0 = r2;
        goto L_0x0095;
    L_0x00ad:
        r9.t(r1);
        r9.BN = r2;
        r9.BO = r2;
        goto L_0x0016;
    L_0x00b6:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x0020;
    L_0x00bb:
        r0 = r2;
        goto L_0x0033;
    L_0x00be:
        r0 = r2;
        goto L_0x005f;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.BE.k(motionEvent);
        this.BF.k(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & 255) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.xC = x;
                this.xD = y;
                this.BN = false;
                this.BO = false;
                break;
            case 1:
                boolean z;
                x = motionEvent.getX();
                y = motionEvent.getY();
                View r = this.BE.r((int) x, (int) y);
                if (r != null && aw(r)) {
                    x -= this.xC;
                    y -= this.xD;
                    int i = this.BE.iE;
                    if ((x * x) + (y * y) < ((float) (i * i))) {
                        View cm = cm();
                        if (cm != null) {
                            z = at(cm) == 2;
                            t(z);
                            this.BN = false;
                            break;
                        }
                    }
                }
                z = true;
                t(z);
                this.BN = false;
            case 3:
                t(true);
                this.BN = false;
                this.BO = false;
                break;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.BN = z;
        if (z) {
            t(true);
        }
    }

    private void t(boolean z) {
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (ax(childAt) && (!z || layoutParams.Cc)) {
                int width = childAt.getWidth();
                if (m(childAt, 3)) {
                    i |= this.BE.e(childAt, -width, childAt.getTop());
                } else {
                    i |= this.BF.e(childAt, getWidth(), childAt.getTop());
                }
                layoutParams.Cc = false;
            }
        }
        this.BG.cl();
        this.BH.cl();
        if (i != 0) {
            invalidate();
        }
    }

    private void ay(View view) {
        if (ax(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.yW) {
                layoutParams.Cb = 1.0f;
                layoutParams.Cd = 1;
                d(view, true);
            } else {
                LayoutParams.b(layoutParams, 2);
                if (m(view, 3)) {
                    this.BE.e(view, 0, view.getTop());
                } else {
                    this.BF.e(view, getWidth() - view.getWidth(), view.getTop());
                }
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public final void az(View view) {
        if (ax(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.yW) {
                layoutParams.Cb = 0.0f;
                layoutParams.Cd = 0;
            } else {
                LayoutParams.b(layoutParams, 4);
                if (m(view, 3)) {
                    this.BE.e(view, -view.getWidth(), view.getTop());
                } else {
                    this.BF.e(view, getWidth(), view.getTop());
                }
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        return layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (getDescendantFocusability() != 393216) {
            int childCount = getChildCount();
            int i3 = 0;
            Object obj = null;
            while (i3 < childCount) {
                Object obj2;
                View childAt = getChildAt(i3);
                if (!ax(childAt)) {
                    this.BY.add(childAt);
                    obj2 = obj;
                } else if (ax(childAt)) {
                    if ((((LayoutParams) childAt.getLayoutParams()).Cd & 1) == 1) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if (obj2 != null) {
                        childAt.addFocusables(arrayList, i, i2);
                        obj2 = 1;
                    }
                    obj2 = obj;
                } else {
                    throw new IllegalArgumentException("View " + childAt + " is not a drawer");
                }
                i3++;
                obj = obj2;
            }
            if (obj == null) {
                int size = this.BY.size();
                for (int i4 = 0; i4 < size; i4++) {
                    View view = (View) this.BY.get(i4);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i, i2);
                    }
                }
            }
            this.BY.clear();
        }
    }

    private View cn() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (ax(childAt)) {
                if (ax(childAt)) {
                    Object obj;
                    if (((LayoutParams) childAt.getLayoutParams()).Cb > 0.0f) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        return childAt;
                    }
                } else {
                    throw new IllegalArgumentException("View " + childAt + " is not a drawer");
                }
            }
        }
        return null;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (cn() != null) {
                g.b(keyEvent);
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View cn = cn();
        if (cn != null && at(cn) == 0) {
            t(false);
        }
        if (cn != null) {
            return true;
        }
        return false;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (savedState.Ce != 0) {
                View af = af(savedState.Ce);
                if (af != null) {
                    ay(af);
                }
            }
            if (savedState.Cf != 3) {
                m(savedState.Cf, 3);
            }
            if (savedState.Cg != 3) {
                m(savedState.Cg, 5);
            }
            if (savedState.Ch != 3) {
                m(savedState.Ch, 8388611);
            }
            if (savedState.Ci != 3) {
                m(savedState.Ci, 8388613);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
            Object obj = layoutParams.Cd == 1 ? 1 : null;
            Object obj2;
            if (layoutParams.Cd == 2) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj != null || r4 != null) {
                savedState.Ce = layoutParams.gravity;
                break;
            }
        }
        savedState.Cf = this.BJ;
        savedState.Cg = this.BK;
        savedState.Ch = this.BL;
        savedState.Ci = this.BM;
        return savedState;
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (cm() != null || ax(view)) {
            z.i(view, 4);
        } else {
            z.i(view, 1);
        }
        if (!Bw) {
            z.a(view, this.By);
        }
    }
}
