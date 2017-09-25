package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.design.a.h;
import android.support.design.a.i;
import android.support.v4.view.ap;
import android.support.v4.view.o;
import android.support.v4.view.r;
import android.support.v4.view.s;
import android.support.v4.view.t;
import android.support.v4.view.z;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.WebView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements r {
    static final String gU;
    static final Class<?>[] gV = new Class[]{Context.class, AttributeSet.class};
    static final ThreadLocal<Map<String, Constructor<Behavior>>> gW = new ThreadLocal();
    static final Comparator<View> gY;
    static final g gZ;
    private ap eD;
    final Comparator<View> gX;
    final List<View> ha;
    private final List<View> hb;
    private final List<View> hc;
    final Rect hd;
    final Rect he;
    private final Rect hf;
    private final int[] hg;
    private boolean hh;
    private boolean hi;
    private int[] hj;
    private View hk;
    private View hl;
    private View hm;
    private e hn;
    private boolean ho;
    private boolean hp;
    private Drawable hq;
    private OnHierarchyChangeListener hr;
    private final s hs;

    public static abstract class Behavior<V extends View> {
        public Behavior(Context context, AttributeSet attributeSet) {
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean e(View view) {
            return false;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
            return false;
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void b(CoordinatorLayout coordinatorLayout, V v, int i) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int[] iArr) {
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, float f, boolean z) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
            return false;
        }

        public static ap a(ap apVar) {
            return apVar;
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        public Parcelable b(CoordinatorLayout coordinatorLayout, V v) {
            return BaseSavedState.EMPTY_STATE;
        }
    }

    protected static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = android.support.v4.os.b.a(new android.support.v4.os.c<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        });
        SparseArray<Parcelable> hG;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.hG = new SparseArray(readInt);
            for (int i = 0; i < readInt; i++) {
                this.hG.append(iArr[i], readParcelableArray[i]);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 0;
            super.writeToParcel(parcel, i);
            int size = this.hG != null ? this.hG.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            while (i2 < size) {
                iArr[i2] = this.hG.keyAt(i2);
                parcelableArr[i2] = (Parcelable) this.hG.valueAt(i2);
                i2++;
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface b {
        Class<? extends Behavior> value();
    }

    private class c implements OnHierarchyChangeListener {
        final /* synthetic */ CoordinatorLayout ht;

        public c(CoordinatorLayout coordinatorLayout) {
            this.ht = coordinatorLayout;
        }

        public final void onChildViewAdded(View view, View view2) {
            if (this.ht.hr != null) {
                this.ht.hr.onChildViewAdded(view, view2);
            }
        }

        public final void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout coordinatorLayout = this.ht;
            int size = coordinatorLayout.ha.size();
            int i = 0;
            Object obj = null;
            while (i < size) {
                Object obj2;
                View view3 = (View) coordinatorLayout.ha.get(i);
                if (view3 == view2) {
                    obj2 = 1;
                } else {
                    if (obj != null) {
                        view3.getLayoutParams();
                    }
                    obj2 = obj;
                }
                i++;
                obj = obj2;
            }
            if (this.ht.hr != null) {
                this.ht.hr.onChildViewRemoved(view, view2);
            }
        }
    }

    public static class d extends MarginLayoutParams {
        public int gravity = 0;
        View hA;
        boolean hB;
        boolean hC;
        boolean hD;
        final Rect hE = new Rect();
        Object hF;
        Behavior hu;
        boolean hv = false;
        public int hw = 0;
        public int hx = -1;
        int hy = -1;
        View hz;

        public d() {
            super(-2, -2);
        }

        d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.bL);
            this.gravity = obtainStyledAttributes.getInteger(i.bM, 0);
            this.hy = obtainStyledAttributes.getResourceId(i.bN, -1);
            this.hw = obtainStyledAttributes.getInteger(i.bO, 0);
            this.hx = obtainStyledAttributes.getInteger(i.bQ, -1);
            this.hv = obtainStyledAttributes.hasValue(i.bP);
            if (this.hv) {
                this.hu = CoordinatorLayout.a(context, attributeSet, obtainStyledAttributes.getString(i.bP));
            }
            obtainStyledAttributes.recycle();
        }

        public d(d dVar) {
            super(dVar);
        }

        public d(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public d(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public final void a(Behavior behavior) {
            if (this.hu != behavior) {
                this.hu = behavior;
                this.hF = null;
                this.hv = true;
            }
        }

        final boolean c(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 == this.hA || (this.hu != null && this.hu.e(view2));
        }
    }

    class e implements OnPreDrawListener {
        final /* synthetic */ CoordinatorLayout ht;

        e(CoordinatorLayout coordinatorLayout) {
            this.ht = coordinatorLayout;
        }

        public final boolean onPreDraw() {
            this.ht.i(false);
            return true;
        }
    }

    static class f implements Comparator<View> {
        f() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            View view = (View) obj2;
            float ak = z.ak((View) obj);
            float ak2 = z.ak(view);
            if (ak > ak2) {
                return -1;
            }
            return ak < ak2 ? 1 : 0;
        }
    }

    private class a implements t {
        final /* synthetic */ CoordinatorLayout ht;

        public a(CoordinatorLayout coordinatorLayout) {
            this.ht = coordinatorLayout;
        }

        public final ap a(View view, ap apVar) {
            return CoordinatorLayout.a(this.ht, apVar);
        }
    }

    static /* synthetic */ ap a(CoordinatorLayout coordinatorLayout, ap apVar) {
        boolean z = true;
        int i = 0;
        if (coordinatorLayout.eD == apVar) {
            return apVar;
        }
        ap apVar2;
        coordinatorLayout.eD = apVar;
        boolean z2 = apVar != null && apVar.getSystemWindowInsetTop() > 0;
        coordinatorLayout.hp = z2;
        if (coordinatorLayout.hp || coordinatorLayout.getBackground() != null) {
            z = false;
        }
        coordinatorLayout.setWillNotDraw(z);
        if (apVar.isConsumed()) {
            apVar2 = apVar;
        } else {
            int childCount = coordinatorLayout.getChildCount();
            ap apVar3 = apVar;
            while (i < childCount) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (z.aa(childAt) && ((d) childAt.getLayoutParams()).hu != null) {
                    apVar2 = Behavior.a(apVar3);
                    if (apVar2.isConsumed()) {
                        break;
                    }
                } else {
                    apVar2 = apVar3;
                }
                i++;
                apVar3 = apVar2;
            }
            apVar2 = apVar3;
        }
        coordinatorLayout.requestLayout();
        return apVar2;
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return new d();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new d(getContext(), attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        if (layoutParams instanceof d) {
            return new d((d) layoutParams);
        }
        return layoutParams instanceof MarginLayoutParams ? new d((MarginLayoutParams) layoutParams) : new d(layoutParams);
    }

    static {
        Package packageR = CoordinatorLayout.class.getPackage();
        gU = packageR != null ? packageR.getName() : null;
        if (VERSION.SDK_INT >= 21) {
            gY = new f();
            gZ = new h();
        } else {
            gY = null;
            gZ = null;
        }
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        int i2 = 0;
        super(context, attributeSet, i);
        this.gX = new Comparator<View>(this) {
            final /* synthetic */ CoordinatorLayout ht;

            {
                this.ht = r1;
            }

            public final /* synthetic */ int compare(Object obj, Object obj2) {
                View view = (View) obj;
                View view2 = (View) obj2;
                if (view != view2) {
                    if (((d) view.getLayoutParams()).c(this.ht, view, view2)) {
                        return 1;
                    }
                    if (((d) view2.getLayoutParams()).c(this.ht, view2, view)) {
                        return -1;
                    }
                }
                return 0;
            }
        };
        this.ha = new ArrayList();
        this.hb = new ArrayList();
        this.hc = new ArrayList();
        this.hd = new Rect();
        this.he = new Rect();
        this.hf = new Rect();
        this.hg = new int[2];
        this.hs = new s(this);
        t.g(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.bK, i, h.aP);
        int resourceId = obtainStyledAttributes.getResourceId(i.bR, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.hj = resources.getIntArray(resourceId);
            float f = resources.getDisplayMetrics().density;
            int length = this.hj.length;
            while (i2 < length) {
                int[] iArr = this.hj;
                iArr[i2] = (int) (((float) iArr[i2]) * f);
                i2++;
            }
        }
        this.hq = obtainStyledAttributes.getDrawable(i.bS);
        obtainStyledAttributes.recycle();
        if (gZ != null) {
            gZ.a(this, new a(this));
        }
        super.setOnHierarchyChangeListener(new c(this));
    }

    public void setOnHierarchyChangeListener(OnHierarchyChangeListener onHierarchyChangeListener) {
        this.hr = onHierarchyChangeListener;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        R();
        if (this.ho) {
            if (this.hn == null) {
                this.hn = new e(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.hn);
        }
        if (this.eD == null && z.aa(this)) {
            z.Z(this);
        }
        this.hi = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        R();
        if (this.ho && this.hn != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.hn);
        }
        if (this.hm != null) {
            onStopNestedScroll(this.hm);
        }
        this.hi = false;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        int i = 0;
        Drawable drawable = this.hq;
        if (drawable != null && drawable.isStateful()) {
            i = drawable.setState(drawableState) | 0;
        }
        if (i != 0) {
            invalidate();
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.hq;
    }

    public void setVisibility(int i) {
        boolean z;
        super.setVisibility(i);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.hq != null && this.hq.isVisible() != z) {
            this.hq.setVisible(z, false);
        }
    }

    private void R() {
        if (this.hk != null) {
            Behavior behavior = ((d) this.hk.getLayoutParams()).hu;
            if (behavior != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                behavior.b(this, this.hk, obtain);
                obtain.recycle();
            }
            this.hk = null;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((d) getChildAt(i).getLayoutParams()).hB = false;
        }
        this.hh = false;
    }

    private boolean a(MotionEvent motionEvent, int i) {
        boolean z;
        boolean z2 = false;
        Object obj = null;
        int d = o.d(motionEvent);
        List list = this.hb;
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        int i2 = childCount - 1;
        while (i2 >= 0) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i2) : i2));
            i2--;
        }
        if (gY != null) {
            Collections.sort(list, gY);
        }
        int size = list.size();
        int i3 = 0;
        MotionEvent motionEvent2 = null;
        while (i3 < size) {
            Object obj2;
            MotionEvent motionEvent3;
            View view = (View) list.get(i3);
            d dVar = (d) view.getLayoutParams();
            Behavior behavior = dVar.hu;
            if ((!z2 && obj == null) || d == 0) {
                if (!(z2 || behavior == null)) {
                    switch (i) {
                        case 0:
                            z2 = behavior.a(this, view, motionEvent);
                            break;
                        case 1:
                            z2 = behavior.b(this, view, motionEvent);
                            break;
                    }
                    if (z2) {
                        this.hk = view;
                    }
                }
                z = z2;
                if (dVar.hu == null) {
                    dVar.hB = false;
                }
                boolean z3 = dVar.hB;
                if (dVar.hB) {
                    isChildrenDrawingOrderEnabled = true;
                } else {
                    isChildrenDrawingOrderEnabled = dVar.hB | 0;
                    dVar.hB = isChildrenDrawingOrderEnabled;
                }
                Object obj3 = (!isChildrenDrawingOrderEnabled || z3) ? null : 1;
                if (isChildrenDrawingOrderEnabled && obj3 == null) {
                    list.clear();
                    return z;
                }
                MotionEvent motionEvent4 = motionEvent2;
                obj2 = obj3;
                motionEvent3 = motionEvent4;
            } else if (behavior != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                } else {
                    motionEvent3 = motionEvent2;
                }
                switch (i) {
                    case 0:
                        behavior.a(this, view, motionEvent3);
                        obj2 = obj;
                        z = z2;
                        continue;
                    case 1:
                        behavior.b(this, view, motionEvent3);
                        break;
                }
                obj2 = obj;
                z = z2;
            } else {
                motionEvent3 = motionEvent2;
                z = z2;
                obj2 = obj;
            }
            i3++;
            obj = obj2;
            z2 = z;
            motionEvent2 = motionEvent3;
        }
        z = z2;
        list.clear();
        return z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int d = o.d(motionEvent);
        if (d == 0) {
            R();
        }
        boolean a = a(motionEvent, 0);
        if (d == 1 || d == 3) {
            R();
        }
        return a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        int d = o.d(motionEvent);
        MotionEvent motionEvent2;
        if (this.hk == null) {
            boolean a = a(motionEvent, 1);
            if (a) {
                z = a;
            } else {
                z = a;
                z2 = false;
                if (this.hk == null) {
                    z2 |= super.onTouchEvent(motionEvent);
                    motionEvent2 = null;
                } else if (z) {
                    motionEvent2 = null;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    super.onTouchEvent(motionEvent2);
                }
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                if (d == 1 || d == 3) {
                    R();
                }
                return z2;
            }
        }
        z = false;
        Behavior behavior = ((d) this.hk.getLayoutParams()).hu;
        z2 = behavior != null ? behavior.b(this, this.hk, motionEvent) : false;
        if (this.hk == null) {
            z2 |= super.onTouchEvent(motionEvent);
            motionEvent2 = null;
        } else if (z) {
            motionEvent2 = null;
        } else {
            long uptimeMillis2 = SystemClock.uptimeMillis();
            motionEvent2 = MotionEvent.obtain(uptimeMillis2, uptimeMillis2, 3, 0.0f, 0.0f, 0);
            super.onTouchEvent(motionEvent2);
        }
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        R();
        return z2;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z && !this.hh) {
            R();
            this.hh = true;
        }
    }

    private int s(int i) {
        if (this.hj == null) {
            new StringBuilder("No keylines defined for ").append(this).append(" - attempted index lookup ").append(i);
            return 0;
        } else if (i >= 0 && i < this.hj.length) {
            return this.hj[i];
        } else {
            new StringBuilder("Keyline index ").append(i).append(" out of range for ").append(this);
            return 0;
        }
    }

    static Behavior a(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(gU)) {
            str = gU + '.' + str;
        }
        try {
            Map map;
            Map map2 = (Map) gW.get();
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                gW.set(hashMap);
                map = hashMap;
            } else {
                map = map2;
            }
            Constructor constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, true, context.getClassLoader()).getConstructor(gV);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (Behavior) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Throwable e) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e);
        }
    }

    private static d m(View view) {
        d dVar = (d) view.getLayoutParams();
        if (!dVar.hv) {
            b bVar = null;
            for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                bVar = (b) cls.getAnnotation(b.class);
                if (bVar != null) {
                    break;
                }
            }
            b bVar2 = bVar;
            if (bVar2 != null) {
                try {
                    dVar.a((Behavior) bVar2.value().newInstance());
                } catch (Exception e) {
                    new StringBuilder("Default behavior class ").append(bVar2.value().getName()).append(" could not be instantiated. Did you forget a default constructor?");
                }
            }
            dVar.hv = true;
        }
        return dVar;
    }

    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    public final void a(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        Object obj;
        this.ha.clear();
        int childCount = getChildCount();
        for (i3 = 0; i3 < childCount; i3++) {
            ViewParent childAt = getChildAt(i3);
            d m = m(childAt);
            if (m.hy == -1) {
                m.hA = null;
                m.hz = null;
            } else {
                View view;
                ViewParent parent;
                if (m.hz != null) {
                    Object obj2;
                    if (m.hz.getId() != m.hy) {
                        obj2 = null;
                    } else {
                        view = m.hz;
                        parent = m.hz.getParent();
                        while (parent != this) {
                            if (parent == null || parent == childAt) {
                                m.hA = null;
                                m.hz = null;
                                obj2 = null;
                                break;
                            }
                            if (parent instanceof View) {
                                view = (View) parent;
                            }
                            parent = parent.getParent();
                        }
                        m.hA = view;
                        obj2 = 1;
                    }
                    if (obj2 != null) {
                        continue;
                    }
                }
                m.hz = findViewById(m.hy);
                if (m.hz != null) {
                    if (m.hz != this) {
                        view = m.hz;
                        parent = m.hz.getParent();
                        while (parent != this && parent != null) {
                            if (parent != childAt) {
                                if (parent instanceof View) {
                                    view = (View) parent;
                                }
                                parent = parent.getParent();
                            } else if (isInEditMode()) {
                                m.hA = null;
                                m.hz = null;
                            } else {
                                throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                            }
                        }
                        m.hA = view;
                    } else if (isInEditMode()) {
                        m.hA = null;
                        m.hz = null;
                    } else {
                        throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                    }
                } else if (isInEditMode()) {
                    m.hA = null;
                    m.hz = null;
                } else {
                    throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + getResources().getResourceName(m.hy) + " to anchor view " + childAt);
                }
            }
            this.ha.add(childAt);
        }
        a(this.ha, this.gX);
        S();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        i3 = getPaddingBottom();
        int J = z.J(this);
        Object obj3;
        if (J == 1) {
            obj3 = 1;
        } else {
            obj3 = null;
        }
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        int i4 = paddingLeft + paddingRight;
        int i5 = paddingTop + i3;
        childCount = getSuggestedMinimumWidth();
        i3 = getSuggestedMinimumHeight();
        if (this.eD == null || !z.aa(this)) {
            obj = null;
        } else {
            obj = 1;
        }
        int size3 = this.ha.size();
        int i6 = 0;
        int i7 = 0;
        int i8 = i3;
        int i9 = childCount;
        while (i6 < size3) {
            int i10;
            View view2 = (View) this.ha.get(i6);
            d dVar = (d) view2.getLayoutParams();
            int i11 = 0;
            if (dVar.hx >= 0 && mode != 0) {
                int s = s(dVar.hx);
                paddingTop = android.support.v4.view.f.getAbsoluteGravity(u(dVar.gravity), J) & 7;
                if ((paddingTop == 3 && r9 == null) || (paddingTop == 5 && r9 != null)) {
                    i11 = Math.max(0, (size - paddingRight) - s);
                } else if ((paddingTop == 5 && r9 == null) || (paddingTop == 3 && r9 != null)) {
                    i11 = Math.max(0, s - paddingLeft);
                }
            }
            if (obj == null || z.aa(view2)) {
                i10 = i2;
                childCount = i;
            } else {
                paddingTop = this.eD.getSystemWindowInsetTop() + this.eD.getSystemWindowInsetBottom();
                childCount = MeasureSpec.makeMeasureSpec(size - (this.eD.getSystemWindowInsetLeft() + this.eD.getSystemWindowInsetRight()), mode);
                i10 = MeasureSpec.makeMeasureSpec(size2 - paddingTop, mode2);
            }
            Behavior behavior = dVar.hu;
            if (behavior == null || !behavior.a(this, view2, childCount, i11, i10, 0)) {
                a(view2, childCount, i11, i10, 0);
            }
            i11 = Math.max(i9, ((view2.getMeasuredWidth() + i4) + dVar.leftMargin) + dVar.rightMargin);
            childCount = Math.max(i8, ((view2.getMeasuredHeight() + i5) + dVar.topMargin) + dVar.bottomMargin);
            i6++;
            i7 = z.combineMeasuredStates(i7, z.N(view2));
            i8 = childCount;
            i9 = i11;
        }
        setMeasuredDimension(z.resolveSizeAndState(i9, i, WebView.NIGHT_MODE_COLOR & i7), z.resolveSizeAndState(i8, i2, i7 << 16));
    }

    public final void e(View view, int i) {
        Object obj;
        d dVar = (d) view.getLayoutParams();
        if (dVar.hz != null || dVar.hy == -1) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        } else if (dVar.hz != null) {
            View view2 = dVar.hz;
            view.getLayoutParams();
            Rect rect = this.hd;
            Rect rect2 = this.he;
            x.a(this, view2, rect);
            a(view, i, rect, rect2);
            view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
        } else if (dVar.hx >= 0) {
            int i2;
            int i3 = dVar.hx;
            dVar = (d) view.getLayoutParams();
            int absoluteGravity = android.support.v4.view.f.getAbsoluteGravity(u(dVar.gravity), i);
            int i4 = absoluteGravity & 7;
            absoluteGravity &= MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
            int width = getWidth();
            int height = getHeight();
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            if (i == 1) {
                i3 = width - i3;
            }
            i3 = s(i3) - measuredWidth;
            switch (i4) {
                case 1:
                    i2 = i3 + (measuredWidth / 2);
                    break;
                case 5:
                    i2 = i3 + measuredWidth;
                    break;
                default:
                    i2 = i3;
                    break;
            }
            switch (absoluteGravity) {
                case 16:
                    i3 = (measuredHeight / 2) + 0;
                    break;
                case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*80*/:
                    i3 = measuredHeight + 0;
                    break;
                default:
                    i3 = 0;
                    break;
            }
            int max = Math.max(getPaddingLeft() + dVar.leftMargin, Math.min(i2, ((width - getPaddingRight()) - measuredWidth) - dVar.rightMargin));
            int max2 = Math.max(getPaddingTop() + dVar.topMargin, Math.min(i3, ((height - getPaddingBottom()) - measuredHeight) - dVar.bottomMargin));
            view.layout(max, max2, max + measuredWidth, max2 + measuredHeight);
        } else {
            dVar = (d) view.getLayoutParams();
            Rect rect3 = this.hd;
            rect3.set(getPaddingLeft() + dVar.leftMargin, getPaddingTop() + dVar.topMargin, (getWidth() - getPaddingRight()) - dVar.rightMargin, (getHeight() - getPaddingBottom()) - dVar.bottomMargin);
            if (!(this.eD == null || !z.aa(this) || z.aa(view))) {
                rect3.left += this.eD.getSystemWindowInsetLeft();
                rect3.top += this.eD.getSystemWindowInsetTop();
                rect3.right -= this.eD.getSystemWindowInsetRight();
                rect3.bottom -= this.eD.getSystemWindowInsetBottom();
            }
            Rect rect4 = this.he;
            android.support.v4.view.f.apply(t(dVar.gravity), view.getMeasuredWidth(), view.getMeasuredHeight(), rect3, rect4, i);
            view.layout(rect4.left, rect4.top, rect4.right, rect4.bottom);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int J = z.J(this);
        int size = this.ha.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = (View) this.ha.get(i5);
            Behavior behavior = ((d) view.getLayoutParams()).hu;
            if (behavior == null || !behavior.a(this, view, J)) {
                e(view, J);
            }
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.hp && this.hq != null) {
            int systemWindowInsetTop = this.eD != null ? this.eD.getSystemWindowInsetTop() : 0;
            if (systemWindowInsetTop > 0) {
                this.hq.setBounds(0, 0, getWidth(), systemWindowInsetTop);
                this.hq.draw(canvas);
            }
        }
    }

    final void a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.set(0, 0, 0, 0);
        } else if (z) {
            x.a(this, view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    private void a(View view, int i, Rect rect, Rect rect2) {
        d dVar = (d) view.getLayoutParams();
        int i2 = dVar.gravity;
        if (i2 == 0) {
            i2 = 17;
        }
        i2 = android.support.v4.view.f.getAbsoluteGravity(i2, i);
        int absoluteGravity = android.support.v4.view.f.getAbsoluteGravity(t(dVar.hw), i);
        int i3 = i2 & 7;
        int i4 = i2 & MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
        i2 = absoluteGravity & 7;
        int i5 = absoluteGravity & MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        switch (i2) {
            case 1:
                absoluteGravity = (rect.width() / 2) + rect.left;
                break;
            case 5:
                absoluteGravity = rect.right;
                break;
            default:
                absoluteGravity = rect.left;
                break;
        }
        switch (i5) {
            case 16:
                i2 = rect.top + (rect.height() / 2);
                break;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*80*/:
                i2 = rect.bottom;
                break;
            default:
                i2 = rect.top;
                break;
        }
        switch (i3) {
            case 1:
                absoluteGravity -= measuredWidth / 2;
                break;
            case 5:
                break;
            default:
                absoluteGravity -= measuredWidth;
                break;
        }
        switch (i4) {
            case 16:
                i2 -= measuredHeight / 2;
                break;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*80*/:
                break;
            default:
                i2 -= measuredHeight;
                break;
        }
        i3 = getWidth();
        i4 = getHeight();
        absoluteGravity = Math.max(getPaddingLeft() + dVar.leftMargin, Math.min(absoluteGravity, ((i3 - getPaddingRight()) - measuredWidth) - dVar.rightMargin));
        int max = Math.max(getPaddingTop() + dVar.topMargin, Math.min(i2, ((i4 - getPaddingBottom()) - measuredHeight) - dVar.bottomMargin));
        rect2.set(absoluteGravity, max, absoluteGravity + measuredWidth, max + measuredHeight);
    }

    private static int t(int i) {
        return i == 0 ? 8388659 : i;
    }

    private static int u(int i) {
        return i == 0 ? 8388661 : i;
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        view.getLayoutParams();
        return super.drawChild(canvas, view, j);
    }

    final void i(boolean z) {
        int J = z.J(this);
        int size = this.ha.size();
        for (int i = 0; i < size; i++) {
            int i2;
            d dVar;
            View view = (View) this.ha.get(i);
            d dVar2 = (d) view.getLayoutParams();
            for (i2 = 0; i2 < i; i2++) {
                Behavior behavior;
                if (dVar2.hA == ((View) this.ha.get(i2))) {
                    dVar = (d) view.getLayoutParams();
                    if (dVar.hz != null) {
                        Rect rect = this.hd;
                        Rect rect2 = this.he;
                        Rect rect3 = this.hf;
                        x.a(this, dVar.hz, rect);
                        a(view, false, rect2);
                        a(view, J, rect, rect3);
                        int i3 = rect3.left - rect2.left;
                        int i4 = rect3.top - rect2.top;
                        if (i3 != 0) {
                            view.offsetLeftAndRight(i3);
                        }
                        if (i4 != 0) {
                            view.offsetTopAndBottom(i4);
                        }
                        if (i3 != 0 || i4 != 0) {
                            behavior = dVar.hu;
                            if (behavior != null) {
                                behavior.b(this, view, dVar.hz);
                            }
                        }
                    }
                }
            }
            Rect rect4 = this.hd;
            Rect rect5 = this.he;
            rect4.set(((d) view.getLayoutParams()).hE);
            a(view, true, rect5);
            if (!rect4.equals(rect5)) {
                ((d) view.getLayoutParams()).hE.set(rect5);
                for (i2 = i + 1; i2 < size; i2++) {
                    View view2 = (View) this.ha.get(i2);
                    dVar = (d) view2.getLayoutParams();
                    behavior = dVar.hu;
                    if (behavior != null && behavior.e(view)) {
                        if (z || !dVar.hD) {
                            behavior.b(this, view2, view);
                            if (z) {
                                dVar.hD = false;
                            }
                        } else {
                            dVar.hD = false;
                        }
                    }
                }
            }
        }
    }

    public final List<View> n(View view) {
        d dVar = (d) view.getLayoutParams();
        List<View> list = this.hc;
        list.clear();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != view && dVar.c(this, view, childAt)) {
                list.add(childAt);
            }
        }
        return list;
    }

    private void S() {
        boolean z;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            d dVar = (d) childAt.getLayoutParams();
            if (dVar.hz != null) {
                z = true;
            } else {
                int childCount2 = getChildCount();
                for (int i2 = 0; i2 < childCount2; i2++) {
                    View childAt2 = getChildAt(i2);
                    if (childAt2 != childAt && dVar.c(this, childAt, childAt2)) {
                        z = true;
                        break;
                    }
                }
                z = false;
            }
            if (z) {
                z = true;
                break;
            }
        }
        z = false;
        if (z == this.ho) {
            return;
        }
        if (z) {
            if (this.hi) {
                if (this.hn == null) {
                    this.hn = new e(this);
                }
                getViewTreeObserver().addOnPreDrawListener(this.hn);
            }
            this.ho = true;
            return;
        }
        if (this.hi && this.hn != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.hn);
        }
        this.ho = false;
    }

    public final boolean b(View view, int i, int i2) {
        Rect rect = this.hd;
        x.a(this, view, rect);
        return rect.contains(i, i2);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof d) && super.checkLayoutParams(layoutParams);
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        int childCount = getChildCount();
        int i2 = 0;
        boolean z = false;
        while (i2 < childCount) {
            boolean z2;
            View childAt = getChildAt(i2);
            d dVar = (d) childAt.getLayoutParams();
            Behavior behavior = dVar.hu;
            if (behavior != null) {
                boolean a = behavior.a(this, childAt, view, i);
                z |= a;
                dVar.hC = a;
                z2 = z;
            } else {
                dVar.hC = false;
                z2 = z;
            }
            i2++;
            z = z2;
        }
        return z;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.hs.xn = i;
        this.hl = view;
        this.hm = view2;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).getLayoutParams();
        }
    }

    public void onStopNestedScroll(View view) {
        this.hs.xn = 0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            d dVar = (d) childAt.getLayoutParams();
            if (dVar.hC) {
                Behavior behavior = dVar.hu;
                if (behavior != null) {
                    behavior.a(this, childAt, view);
                }
                dVar.hC = false;
                dVar.hD = false;
            }
        }
        this.hl = null;
        this.hm = null;
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = 0;
        boolean z = false;
        while (i5 < childCount) {
            boolean z2;
            View childAt = getChildAt(i5);
            d dVar = (d) childAt.getLayoutParams();
            if (dVar.hC) {
                Behavior behavior = dVar.hu;
                if (behavior != null) {
                    behavior.b(this, childAt, i4);
                    z2 = true;
                    i5++;
                    z = z2;
                }
            }
            z2 = z;
            i5++;
            z = z2;
        }
        if (z) {
            i(true);
        }
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        int i3 = 0;
        int i4 = 0;
        Object obj = null;
        int childCount = getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            int max;
            int max2;
            Object obj2;
            View childAt = getChildAt(i5);
            d dVar = (d) childAt.getLayoutParams();
            if (dVar.hC) {
                Behavior behavior = dVar.hu;
                if (behavior != null) {
                    int[] iArr2 = this.hg;
                    this.hg[1] = 0;
                    iArr2[0] = 0;
                    behavior.a(this, childAt, view, i2, this.hg);
                    max = i > 0 ? Math.max(i3, this.hg[0]) : Math.min(i3, this.hg[0]);
                    max2 = i2 > 0 ? Math.max(i4, this.hg[1]) : Math.min(i4, this.hg[1]);
                    obj2 = 1;
                    i5++;
                    i4 = max2;
                    i3 = max;
                    obj = obj2;
                }
            }
            obj2 = obj;
            max = i3;
            max2 = i4;
            i5++;
            i4 = max2;
            i3 = max;
            obj = obj2;
        }
        iArr[0] = i3;
        iArr[1] = i4;
        if (obj != null) {
            i(true);
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        int childCount = getChildCount();
        int i = 0;
        boolean z2 = false;
        while (i < childCount) {
            boolean a;
            View childAt = getChildAt(i);
            d dVar = (d) childAt.getLayoutParams();
            if (dVar.hC) {
                Behavior behavior = dVar.hu;
                if (behavior != null) {
                    a = behavior.a(this, childAt, f2, z) | z2;
                    i++;
                    z2 = a;
                }
            }
            a = z2;
            i++;
            z2 = a;
        }
        if (z2) {
            i(true);
        }
        return z2;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        int childCount = getChildCount();
        int i = 0;
        boolean z = false;
        while (i < childCount) {
            boolean a;
            View childAt = getChildAt(i);
            d dVar = (d) childAt.getLayoutParams();
            if (dVar.hC) {
                Behavior behavior = dVar.hu;
                if (behavior != null) {
                    a = behavior.a(this, childAt, view, f, f2) | z;
                    i++;
                    z = a;
                }
            }
            a = z;
            i++;
            z = a;
        }
        return z;
    }

    public int getNestedScrollAxes() {
        return this.hs.xn;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            SparseArray sparseArray = savedState.hG;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                int id = childAt.getId();
                Behavior behavior = m(childAt).hu;
                if (!(id == -1 || behavior == null)) {
                    Parcelable parcelable2 = (Parcelable) sparseArray.get(id);
                    if (parcelable2 != null) {
                        behavior.a(this, childAt, parcelable2);
                    }
                }
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior behavior = ((d) childAt.getLayoutParams()).hu;
            if (!(id == -1 || behavior == null)) {
                Parcelable b = behavior.b(this, childAt);
                if (b != null) {
                    sparseArray.append(id, b);
                }
            }
        }
        savedState.hG = sparseArray;
        return savedState;
    }

    private static void a(List<View> list, Comparator<View> comparator) {
        if (list != null && list.size() >= 2) {
            int i;
            View[] viewArr = new View[list.size()];
            list.toArray(viewArr);
            for (int i2 = 0; i2 < r5; i2++) {
                i = i2;
                for (int i3 = i2 + 1; i3 < r5; i3++) {
                    if (comparator.compare(viewArr[i3], viewArr[i]) < 0) {
                        i = i3;
                    }
                }
                if (i2 != i) {
                    View view = viewArr[i];
                    viewArr[i] = viewArr[i2];
                    viewArr[i2] = view;
                }
            }
            list.clear();
            for (Object add : viewArr) {
                list.add(add);
            }
        }
    }
}
