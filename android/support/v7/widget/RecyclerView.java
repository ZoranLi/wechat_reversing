package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.view.w;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerView extends ViewGroup implements android.support.v4.view.p, w {
    private static final int[] YS = new int[]{16843830};
    private static final boolean YT;
    static final boolean YU;
    private static final Class<?>[] YV = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
    private static final Interpolator ZY = new Interpolator() {
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    };
    private final int[] Dd;
    private final int[] De;
    private final o YW;
    final m YX;
    private SavedState YY;
    e YZ;
    android.support.v4.widget.i ZA;
    public e ZB;
    private int ZC;
    private int ZD;
    private int ZE;
    private int ZF;
    private int ZG;
    private final int ZH;
    private final int ZI;
    private float ZJ;
    final s ZK;
    final q ZL;
    public k ZM;
    private List<k> ZN;
    boolean ZO;
    boolean ZP;
    private b ZQ;
    private boolean ZR;
    private ac ZS;
    private d ZT;
    private final int[] ZU;
    private android.support.v4.view.q ZV;
    private final int[] ZW;
    private Runnable ZX;
    private final b ZZ;
    s Za;
    final as Zb;
    private boolean Zc;
    private final Runnable Zd;
    private a Ze;
    public h Zf;
    private n Zg;
    public final ArrayList<g> Zh;
    public final ArrayList<j> Zi;
    public j Zj;
    private boolean Zk;
    public boolean Zl;
    boolean Zm;
    private int Zn;
    private boolean Zo;
    boolean Zp;
    private boolean Zq;
    private int Zr;
    private boolean Zs;
    private final boolean Zt;
    public List<i> Zu;
    boolean Zv;
    private int Zw;
    android.support.v4.widget.i Zx;
    android.support.v4.widget.i Zy;
    android.support.v4.widget.i Zz;
    private final Rect eq;
    private VelocityTracker fk;
    private int iE;
    private final AccessibilityManager jl;
    public int xV;

    public static class LayoutParams extends MarginLayoutParams {
        final Rect WM = new Rect();
        t aas;
        boolean aat = true;
        boolean aau = false;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        Parcelable aaF;

        SavedState(Parcel parcel) {
            super(parcel);
            this.aaF = parcel.readParcelable(h.class.getClassLoader());
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.aaF, 0);
        }
    }

    public static abstract class a<VH extends t> {
        public final b aab = new b();
        public boolean aac = false;

        public abstract VH a(ViewGroup viewGroup, int i);

        public abstract void a(VH vh, int i);

        public abstract int getItemCount();

        public void a(VH vh, int i, List<Object> list) {
            a((t) vh, i);
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public final void fQ() {
            if (this.aab.fR()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.aac = true;
        }

        public long getItemId(int i) {
            return -1;
        }

        public void a(VH vh) {
        }

        public final void a(c cVar) {
            this.aab.registerObserver(cVar);
        }

        public final void b(c cVar) {
            this.aab.unregisterObserver(cVar);
        }

        public final void bc(int i) {
            this.aab.P(i, 1);
        }

        public final void b(int i, Object obj) {
            this.aab.b(i, 1, obj);
        }

        public final void P(int i, int i2) {
            this.aab.P(i, i2);
        }

        public final void b(int i, int i2, Object obj) {
            this.aab.b(i, i2, obj);
        }

        public final void bd(int i) {
            this.aab.R(i, 1);
        }

        public final void Q(int i, int i2) {
            this.aab.Q(i, i2);
        }

        public final void R(int i, int i2) {
            this.aab.R(i, i2);
        }

        public final void be(int i) {
            this.aab.S(i, 1);
        }

        public final void S(int i, int i2) {
            this.aab.S(i, i2);
        }
    }

    static class b extends Observable<c> {
        b() {
        }

        public final boolean fR() {
            return !this.mObservers.isEmpty();
        }

        public final void notifyChanged() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).onChanged();
            }
        }

        public final void P(int i, int i2) {
            b(i, i2, null);
        }

        public final void b(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).c(i, i2, obj);
            }
        }

        public final void R(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).U(i, i2);
            }
        }

        public final void S(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).V(i, i2);
            }
        }

        public final void Q(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).W(i, i2);
            }
        }
    }

    public static abstract class c {
        public void onChanged() {
        }

        public void T(int i, int i2) {
        }

        public void c(int i, int i2, Object obj) {
            T(i, i2);
        }

        public void U(int i, int i2) {
        }

        public void V(int i, int i2) {
        }

        public void W(int i, int i2) {
        }
    }

    public interface d {
        int X(int i, int i2);
    }

    public static abstract class e {
        b aad = null;
        private ArrayList<a> aae = new ArrayList();
        public long aaf = 120;
        public long aag = 120;
        public long aah = 250;
        public long aai = 250;

        public interface a {
            void fT();
        }

        interface b {
            void l(t tVar);
        }

        public static class c {
            public int aaj;
            public int bottom;
            public int left;
            public int right;
            public int top;

            public c b(t tVar, int i) {
                View view = tVar.abf;
                this.left = view.getLeft();
                this.top = view.getTop();
                this.right = view.getRight();
                this.bottom = view.getBottom();
                return this;
            }
        }

        public abstract boolean a(t tVar, t tVar2, c cVar, c cVar2);

        public abstract void d(t tVar);

        public abstract boolean d(t tVar, c cVar, c cVar2);

        public abstract boolean e(t tVar, c cVar, c cVar2);

        public abstract void eJ();

        public abstract void eL();

        public abstract boolean f(t tVar, c cVar, c cVar2);

        public abstract boolean isRunning();

        public c a(q qVar, t tVar, int i, List<Object> list) {
            return new c().b(tVar, 0);
        }

        static int j(t tVar) {
            int i = tVar.uf & 14;
            if (tVar.gl()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int i2 = tVar.abg;
            int gf = tVar.gf();
            if (i2 == -1 || gf == -1 || i2 == gf) {
                return i;
            }
            return i | 2048;
        }

        public final void k(t tVar) {
            l(tVar);
            if (this.aad != null) {
                this.aad.l(tVar);
            }
        }

        public void l(t tVar) {
        }

        public final boolean a(a aVar) {
            boolean isRunning = isRunning();
            if (aVar != null) {
                if (isRunning) {
                    this.aae.add(aVar);
                } else {
                    aVar.fT();
                }
            }
            return isRunning;
        }

        public boolean m(t tVar) {
            return true;
        }

        public boolean a(t tVar, List<Object> list) {
            return m(tVar);
        }

        public final void fS() {
            int size = this.aae.size();
            for (int i = 0; i < size; i++) {
                ((a) this.aae.get(i)).fT();
            }
            this.aae.clear();
        }
    }

    public static abstract class g {
        public void a(Canvas canvas, RecyclerView recyclerView) {
        }

        public void b(Canvas canvas, RecyclerView recyclerView) {
        }

        public void a(Rect rect, View view, RecyclerView recyclerView) {
            ((LayoutParams) view.getLayoutParams()).aas.ge();
            rect.set(0, 0, 0, 0);
        }
    }

    public static abstract class h {
        int RQ;
        s Za;
        RecyclerView aak;
        p aal;
        public boolean aam = false;
        public boolean aan = false;
        boolean aao = true;
        int aap;
        int aaq;
        int aar;
        boolean hi = false;

        public abstract LayoutParams eN();

        final void y(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.aak = null;
                this.Za = null;
                this.aar = 0;
                this.RQ = 0;
            } else {
                this.aak = recyclerView;
                this.Za = recyclerView.Za;
                this.aar = recyclerView.getWidth();
                this.RQ = recyclerView.getHeight();
            }
            this.aap = 1073741824;
            this.aaq = 1073741824;
        }

        final void Y(int i, int i2) {
            this.aar = MeasureSpec.getSize(i);
            this.aap = MeasureSpec.getMode(i);
            if (this.aap == 0 && !RecyclerView.YU) {
                this.aar = 0;
            }
            this.RQ = MeasureSpec.getSize(i2);
            this.aaq = MeasureSpec.getMode(i2);
            if (this.aaq == 0 && !RecyclerView.YU) {
                this.RQ = 0;
            }
        }

        final void Z(int i, int i2) {
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MIN_VALUE;
            int childCount = getChildCount();
            if (childCount == 0) {
                this.aak.N(i, i2);
                return;
            }
            int i5 = 0;
            int i6 = Integer.MIN_VALUE;
            int i7 = Integer.MAX_VALUE;
            while (i5 < childCount) {
                View childAt = getChildAt(i5);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int bi = bi(childAt) - layoutParams.leftMargin;
                int bk = layoutParams.rightMargin + bk(childAt);
                int bj = bj(childAt) - layoutParams.topMargin;
                int bl = layoutParams.bottomMargin + bl(childAt);
                if (bi >= i7) {
                    bi = i7;
                }
                if (bk <= i6) {
                    bk = i6;
                }
                if (bj >= i3) {
                    bj = i3;
                }
                if (bl <= i4) {
                    bl = i4;
                }
                i5++;
                i6 = bk;
                i3 = bj;
                i7 = bi;
                i4 = bl;
            }
            this.aak.eq.set(i7, i3, i6, i4);
            a(this.aak.eq, i, i2);
        }

        public void a(Rect rect, int i, int i2) {
            setMeasuredDimension(j(i, (rect.width() + getPaddingLeft()) + getPaddingRight(), z.T(this.aak)), j(i2, (rect.height() + getPaddingTop()) + getPaddingBottom(), z.U(this.aak)));
        }

        public final void requestLayout() {
            if (this.aak != null) {
                this.aak.requestLayout();
            }
        }

        public static int j(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i);
            int size = MeasureSpec.getSize(i);
            switch (mode) {
                case Integer.MIN_VALUE:
                    return Math.min(size, Math.max(i2, i3));
                case 1073741824:
                    return size;
                default:
                    return Math.max(i2, i3);
            }
        }

        public void q(String str) {
            if (this.aak != null) {
                this.aak.q(str);
            }
        }

        public boolean eQ() {
            return false;
        }

        final void b(RecyclerView recyclerView, m mVar) {
            this.hi = false;
            a(recyclerView, mVar);
        }

        public final boolean removeCallbacks(Runnable runnable) {
            if (this.aak != null) {
                return this.aak.removeCallbacks(runnable);
            }
            return false;
        }

        public void a(RecyclerView recyclerView, m mVar) {
        }

        public void c(m mVar, q qVar) {
        }

        public boolean a(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public LayoutParams e(android.view.ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof MarginLayoutParams) {
                return new LayoutParams((MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }

        public LayoutParams a(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public int a(int i, m mVar, q qVar) {
            return 0;
        }

        public int b(int i, m mVar, q qVar) {
            return 0;
        }

        public boolean eR() {
            return false;
        }

        public boolean eS() {
            return false;
        }

        public void aX(int i) {
        }

        public void a(RecyclerView recyclerView, int i) {
        }

        public final void a(p pVar) {
            if (!(this.aal == null || pVar == this.aal || !this.aal.aaI)) {
                this.aal.stop();
            }
            this.aal = pVar;
            p pVar2 = this.aal;
            pVar2.aak = this.aak;
            pVar2.YQ = this;
            if (pVar2.aaG == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            pVar2.aak.ZL.aaG = pVar2.aaG;
            pVar2.aaI = true;
            pVar2.aaH = true;
            pVar2.aaJ = pVar2.aak.Zf.aV(pVar2.aaG);
            pVar2.aak.ZK.ga();
        }

        public final boolean fU() {
            return this.aal != null && this.aal.aaI;
        }

        void c(View view, int i, boolean z) {
            t aZ = RecyclerView.aZ(view);
            if (z || aZ.isRemoved()) {
                this.aak.Zb.v(aZ);
            } else {
                this.aak.Zb.w(aZ);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (aZ.gi() || aZ.gg()) {
                if (aZ.gg()) {
                    aZ.gh();
                } else {
                    aZ.gj();
                }
                this.Za.a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.aak) {
                int indexOfChild = this.Za.indexOfChild(view);
                if (i == -1) {
                    i = this.Za.getChildCount();
                }
                if (indexOfChild == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.aak.indexOfChild(view));
                } else if (indexOfChild != i) {
                    h hVar = this.aak.Zf;
                    View childAt = hVar.getChildAt(indexOfChild);
                    if (childAt == null) {
                        throw new IllegalArgumentException("Cannot move a child from non-existing index:" + indexOfChild);
                    }
                    hVar.bf(indexOfChild);
                    LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                    t aZ2 = RecyclerView.aZ(childAt);
                    if (aZ2.isRemoved()) {
                        hVar.aak.Zb.v(aZ2);
                    } else {
                        hVar.aak.Zb.w(aZ2);
                    }
                    hVar.Za.a(childAt, i, layoutParams2, aZ2.isRemoved());
                }
            } else {
                this.Za.a(view, i, false);
                layoutParams.aat = true;
                if (this.aal != null && this.aal.aaI) {
                    p pVar = this.aal;
                    if (RecyclerView.bb(view) == pVar.aaG) {
                        pVar.aaJ = view;
                    }
                }
            }
            if (layoutParams.aau) {
                aZ.abf.invalidate();
                layoutParams.aau = false;
            }
        }

        private void removeViewAt(int i) {
            if (getChildAt(i) != null) {
                s sVar = this.Za;
                int aM = sVar.aM(i);
                View childAt = sVar.VL.getChildAt(aM);
                if (childAt != null) {
                    if (sVar.VM.aO(aM)) {
                        sVar.aO(childAt);
                    }
                    sVar.VL.removeViewAt(aM);
                }
            }
        }

        public static int be(View view) {
            return ((LayoutParams) view.getLayoutParams()).aas.ge();
        }

        public final View bf(View view) {
            if (this.aak == null) {
                return null;
            }
            ViewParent viewParent = this.aak;
            ViewParent parent = view.getParent();
            View view2 = view;
            while (parent != null && parent != viewParent && (parent instanceof View)) {
                View view3 = (View) parent;
                view2 = view3;
                parent = view3.getParent();
            }
            if (parent == viewParent) {
                view3 = view2;
            } else {
                view3 = null;
            }
            if (view3 == null) {
                return null;
            }
            if (this.Za.aP(view3)) {
                return null;
            }
            return view3;
        }

        public View aV(int i) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                t aZ = RecyclerView.aZ(childAt);
                if (aZ != null && aZ.ge() == i && !aZ.gd() && (this.aak.ZL.aaW || !aZ.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        private void bf(int i) {
            getChildAt(i);
            this.Za.detachViewFromParent(i);
        }

        public final void a(View view, m mVar) {
            s sVar = this.Za;
            int indexOfChild = sVar.VL.indexOfChild(view);
            if (indexOfChild >= 0) {
                if (sVar.VM.aO(indexOfChild)) {
                    sVar.aO(view);
                }
                sVar.VL.removeViewAt(indexOfChild);
            }
            mVar.bn(view);
        }

        public final void a(int i, m mVar) {
            View childAt = getChildAt(i);
            removeViewAt(i);
            mVar.bn(childAt);
        }

        public final int getChildCount() {
            return this.Za != null ? this.Za.getChildCount() : 0;
        }

        public final View getChildAt(int i) {
            return this.Za != null ? this.Za.getChildAt(i) : null;
        }

        public final int getPaddingLeft() {
            return this.aak != null ? this.aak.getPaddingLeft() : 0;
        }

        public final int getPaddingTop() {
            return this.aak != null ? this.aak.getPaddingTop() : 0;
        }

        public final int getPaddingRight() {
            return this.aak != null ? this.aak.getPaddingRight() : 0;
        }

        public final int getPaddingBottom() {
            return this.aak != null ? this.aak.getPaddingBottom() : 0;
        }

        public void bg(int i) {
            if (this.aak != null) {
                RecyclerView recyclerView = this.aak;
                int childCount = recyclerView.Za.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    recyclerView.Za.getChildAt(i2).offsetLeftAndRight(i);
                }
            }
        }

        public void bh(int i) {
            if (this.aak != null) {
                RecyclerView recyclerView = this.aak;
                int childCount = recyclerView.Za.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    recyclerView.Za.getChildAt(i2).offsetTopAndBottom(i);
                }
            }
        }

        public final void b(m mVar) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                t aZ = RecyclerView.aZ(childAt);
                if (!aZ.gd()) {
                    if (!aZ.gl() || aZ.isRemoved() || this.aak.Ze.aac) {
                        bf(childCount);
                        mVar.bp(childAt);
                        this.aak.Zb.w(aZ);
                    } else {
                        removeViewAt(childCount);
                        mVar.n(aZ);
                    }
                }
            }
        }

        final void c(m mVar) {
            int size = mVar.aay.size();
            for (int i = size - 1; i >= 0; i--) {
                View view = ((t) mVar.aay.get(i)).abf;
                t aZ = RecyclerView.aZ(view);
                if (!aZ.gd()) {
                    aZ.U(false);
                    if (aZ.gn()) {
                        this.aak.removeDetachedView(view, false);
                    }
                    if (this.aak.ZB != null) {
                        this.aak.ZB.d(aZ);
                    }
                    aZ.U(true);
                    mVar.bo(view);
                }
            }
            mVar.aay.clear();
            if (mVar.aaz != null) {
                mVar.aaz.clear();
            }
            if (size > 0) {
                this.aak.invalidate();
            }
        }

        final boolean a(View view, int i, int i2, LayoutParams layoutParams) {
            return (!view.isLayoutRequested() && this.aao && k(view.getWidth(), i, layoutParams.width) && k(view.getHeight(), i2, layoutParams.height)) ? false : true;
        }

        static boolean k(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i2);
            int size = MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            switch (mode) {
                case Integer.MIN_VALUE:
                    if (size >= i) {
                        return true;
                    }
                    return false;
                case 0:
                    return true;
                case 1073741824:
                    if (size == i) {
                        return true;
                    }
                    return false;
                default:
                    return false;
            }
        }

        public static int b(int i, int i2, int i3, int i4, boolean z) {
            int i5 = 0;
            int max = Math.max(0, i - i3);
            if (z) {
                if (i4 >= 0) {
                    i5 = 1073741824;
                    max = i4;
                } else if (i4 == -1) {
                    switch (i2) {
                        case Integer.MIN_VALUE:
                        case 1073741824:
                            i5 = i2;
                            break;
                        default:
                            max = 0;
                            break;
                    }
                } else {
                    if (i4 == -2) {
                        max = 0;
                    }
                    max = 0;
                }
            } else if (i4 >= 0) {
                i5 = 1073741824;
                max = i4;
            } else if (i4 == -1) {
                i5 = i2;
            } else {
                if (i4 == -2) {
                    if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                        i5 = Integer.MIN_VALUE;
                    }
                }
                max = 0;
            }
            return MeasureSpec.makeMeasureSpec(max, i5);
        }

        public static int bg(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).WM;
            return rect.right + (view.getMeasuredWidth() + rect.left);
        }

        public static int bh(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).WM;
            return rect.bottom + (view.getMeasuredHeight() + rect.top);
        }

        public static void g(View view, int i, int i2, int i3, int i4) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).WM;
            view.layout(rect.left + i, rect.top + i2, i3 - rect.right, i4 - rect.bottom);
        }

        public static int bi(View view) {
            return view.getLeft() - ((LayoutParams) view.getLayoutParams()).WM.left;
        }

        public static int bj(View view) {
            return view.getTop() - ((LayoutParams) view.getLayoutParams()).WM.top;
        }

        public static int bk(View view) {
            return ((LayoutParams) view.getLayoutParams()).WM.right + view.getRight();
        }

        public static int bl(View view) {
            return ((LayoutParams) view.getLayoutParams()).WM.bottom + view.getBottom();
        }

        public final void a(View view, Rect rect) {
            if (this.aak == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(this.aak.bc(view));
            }
        }

        public View a(View view, int i, m mVar, q qVar) {
            return null;
        }

        public void eM() {
        }

        public void z(int i, int i2) {
        }

        public void A(int i, int i2) {
        }

        public void B(int i, int i2) {
        }

        public void C(int i, int i2) {
        }

        public int d(q qVar) {
            return 0;
        }

        public int b(q qVar) {
            return 0;
        }

        public int f(q qVar) {
            return 0;
        }

        public int e(q qVar) {
            return 0;
        }

        public int c(q qVar) {
            return 0;
        }

        public int g(q qVar) {
            return 0;
        }

        public final void aa(int i, int i2) {
            this.aak.N(i, i2);
        }

        public final void setMeasuredDimension(int i, int i2) {
            this.aak.setMeasuredDimension(i, i2);
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        final void fV() {
            if (this.aal != null) {
                this.aal.stop();
            }
        }

        public void bi(int i) {
        }

        public final void d(m mVar) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.aZ(getChildAt(childCount)).gd()) {
                    a(childCount, mVar);
                }
            }
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            boolean z = true;
            m mVar = this.aak.YX;
            q qVar = this.aak.ZL;
            android.support.v4.view.a.f a = android.support.v4.view.a.a.a(accessibilityEvent);
            if (this.aak != null) {
                if (!(z.h(this.aak, 1) || z.h(this.aak, -1) || z.g(this.aak, -1) || z.g(this.aak, 1))) {
                    z = false;
                }
                a.setScrollable(z);
                if (this.aak.Ze != null) {
                    a.setItemCount(this.aak.Ze.getItemCount());
                }
            }
        }

        final void b(View view, android.support.v4.view.a.b bVar) {
            t aZ = RecyclerView.aZ(view);
            if (aZ != null && !aZ.isRemoved() && !this.Za.aP(aZ.abf)) {
                a(this.aak.YX, this.aak.ZL, view, bVar);
            }
        }

        public void a(m mVar, q qVar, View view, android.support.v4.view.a.b bVar) {
            int be;
            int be2 = eS() ? be(view) : 0;
            if (eR()) {
                be = be(view);
            } else {
                be = 0;
            }
            bVar.k(android.support.v4.view.a.b.l.a(be2, 1, be, 1, false));
        }

        public int a(m mVar, q qVar) {
            if (this.aak == null || this.aak.Ze == null || !eS()) {
                return 1;
            }
            return this.aak.Ze.getItemCount();
        }

        public int b(m mVar, q qVar) {
            if (this.aak == null || this.aak.Ze == null || !eR()) {
                return 1;
            }
            return this.aak.Ze.getItemCount();
        }

        final void z(RecyclerView recyclerView) {
            Y(MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        boolean eX() {
            return false;
        }
    }

    public interface i {
        void bm(View view);
    }

    public interface j {
        void T(boolean z);

        boolean n(MotionEvent motionEvent);

        void o(MotionEvent motionEvent);
    }

    public static abstract class k {
        public void e(RecyclerView recyclerView, int i) {
        }

        public void c(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public static class l {
        SparseArray<ArrayList<t>> aav = new SparseArray();
        SparseIntArray aaw = new SparseIntArray();
        int aax = 0;
    }

    public final class m {
        final ArrayList<t> aaA = new ArrayList();
        final List<t> aaB = Collections.unmodifiableList(this.aay);
        private int aaC = 2;
        private l aaD;
        private r aaE;
        final /* synthetic */ RecyclerView aaa;
        final ArrayList<t> aay = new ArrayList();
        public ArrayList<t> aaz = null;

        public m(RecyclerView recyclerView) {
            this.aaa = recyclerView;
        }

        public final void clear() {
            this.aay.clear();
            fW();
        }

        public final int bj(int i) {
            if (i >= 0 && i < this.aaa.ZL.getItemCount()) {
                return !this.aaa.ZL.aaW ? i : this.aaa.YZ.aI(i);
            } else {
                throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + this.aaa.ZL.getItemCount());
            }
        }

        public final View bk(int i) {
            boolean z = true;
            if (i < 0 || i >= this.aaa.ZL.getItemCount()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + this.aaa.ZL.getItemCount());
            }
            boolean z2;
            t tVar;
            boolean z3;
            boolean z4;
            t tVar2;
            LayoutParams layoutParams;
            if (this.aaa.ZL.aaW) {
                t bm = bm(i);
                t tVar3 = bm;
                z2 = bm != null;
                tVar = tVar3;
            } else {
                tVar = null;
                z2 = false;
            }
            if (tVar == null) {
                tVar = o(i, false);
                if (tVar != null) {
                    if (tVar.isRemoved()) {
                        z3 = this.aaa.ZL.aaW;
                    } else if (tVar.kC < 0 || tVar.kC >= this.aaa.Ze.getItemCount()) {
                        throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + tVar);
                    } else {
                        z3 = (this.aaa.ZL.aaW || this.aaa.Ze.getItemViewType(tVar.kC) == tVar.abi) ? !this.aaa.Ze.aac || tVar.abh == this.aaa.Ze.getItemId(tVar.kC) : false;
                    }
                    if (z3) {
                        z2 = true;
                    } else {
                        tVar.addFlags(4);
                        if (tVar.gg()) {
                            this.aaa.removeDetachedView(tVar.abf, false);
                            tVar.gh();
                        } else if (tVar.gi()) {
                            tVar.gj();
                        }
                        n(tVar);
                        tVar = null;
                    }
                }
            }
            if (tVar == null) {
                int aI = this.aaa.YZ.aI(i);
                if (aI < 0 || aI >= this.aaa.Ze.getItemCount()) {
                    throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + aI + ").state:" + this.aaa.ZL.getItemCount());
                }
                View fZ;
                ArrayList arrayList;
                a h;
                ViewGroup viewGroup;
                int itemViewType = this.aaa.Ze.getItemViewType(aI);
                if (this.aaa.Ze.aac) {
                    tVar = b(this.aaa.Ze.getItemId(aI), itemViewType, false);
                    if (tVar != null) {
                        tVar.kC = aI;
                        z3 = true;
                        if (tVar == null && this.aaE != null) {
                            fZ = this.aaE.fZ();
                            if (fZ != null) {
                                tVar = this.aaa.aQ(fZ);
                                if (tVar == null) {
                                    throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                                } else if (tVar.gd()) {
                                    throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                                }
                            }
                        }
                        if (tVar == null) {
                            arrayList = (ArrayList) fX().aav.get(itemViewType);
                            if (arrayList != null || arrayList.isEmpty()) {
                                bm = null;
                            } else {
                                int size = arrayList.size() - 1;
                                bm = (t) arrayList.get(size);
                                arrayList.remove(size);
                            }
                            if (bm != null) {
                                bm.gq();
                                if (RecyclerView.YT && (bm.abf instanceof ViewGroup)) {
                                    c((ViewGroup) bm.abf, false);
                                }
                            }
                            tVar = bm;
                        }
                        if (tVar != null) {
                            h = this.aaa.Ze;
                            viewGroup = this.aaa;
                            android.support.v4.os.e.beginSection("RV CreateView");
                            tVar = h.a(viewGroup, itemViewType);
                            tVar.abi = itemViewType;
                            z4 = z3;
                            tVar2 = tVar;
                            android.support.v4.os.e.endSection();
                        } else {
                            z4 = z3;
                            tVar2 = tVar;
                        }
                    }
                }
                z3 = z2;
                fZ = this.aaE.fZ();
                if (fZ != null) {
                    tVar = this.aaa.aQ(fZ);
                    if (tVar == null) {
                        throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                    } else if (tVar.gd()) {
                        throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                    }
                }
                if (tVar == null) {
                    arrayList = (ArrayList) fX().aav.get(itemViewType);
                    if (arrayList != null) {
                    }
                    bm = null;
                    if (bm != null) {
                        bm.gq();
                        c((ViewGroup) bm.abf, false);
                    }
                    tVar = bm;
                }
                if (tVar != null) {
                    z4 = z3;
                    tVar2 = tVar;
                } else {
                    h = this.aaa.Ze;
                    viewGroup = this.aaa;
                    android.support.v4.os.e.beginSection("RV CreateView");
                    tVar = h.a(viewGroup, itemViewType);
                    tVar.abi = itemViewType;
                    z4 = z3;
                    tVar2 = tVar;
                    android.support.v4.os.e.endSection();
                }
            } else {
                tVar2 = tVar;
                z4 = z2;
            }
            if (z4 && !this.aaa.ZL.aaW && tVar2.bo(8192)) {
                tVar2.setFlags(0, 8192);
                if (this.aaa.ZL.aaX) {
                    this.aaa.a(tVar2, this.aaa.ZB.a(this.aaa.ZL, tVar2, e.j(tVar2) | Downloads.RECV_BUFFER_SIZE, tVar2.gp()));
                }
            }
            if (this.aaa.ZL.aaW && tVar2.isBound()) {
                tVar2.abj = i;
                z2 = false;
            } else if (!tVar2.isBound() || tVar2.gm() || tVar2.gl()) {
                int aI2 = this.aaa.YZ.aI(i);
                tVar2.abt = this.aaa;
                a h2 = this.aaa.Ze;
                tVar2.kC = aI2;
                if (h2.aac) {
                    tVar2.abh = h2.getItemId(aI2);
                }
                tVar2.setFlags(1, 519);
                android.support.v4.os.e.beginSection("RV OnBindView");
                h2.a(tVar2, aI2, tVar2.gp());
                tVar2.go();
                android.support.v4.os.e.endSection();
                View view = tVar2.abf;
                if (this.aaa.fB()) {
                    if (z.G(view) == 0) {
                        z.i(view, 1);
                    }
                    if (!z.D(view)) {
                        z.a(view, this.aaa.ZS.abu);
                    }
                }
                if (this.aaa.ZL.aaW) {
                    tVar2.abj = i;
                }
                z2 = true;
            } else {
                z2 = false;
            }
            android.view.ViewGroup.LayoutParams layoutParams2 = tVar2.abf.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams = (LayoutParams) this.aaa.generateDefaultLayoutParams();
                tVar2.abf.setLayoutParams(layoutParams);
            } else if (this.aaa.checkLayoutParams(layoutParams2)) {
                layoutParams = (LayoutParams) layoutParams2;
            } else {
                layoutParams = (LayoutParams) this.aaa.generateLayoutParams(layoutParams2);
                tVar2.abf.setLayoutParams(layoutParams);
            }
            layoutParams.aas = tVar2;
            if (!(z4 && r1)) {
                z = false;
            }
            layoutParams.aau = z;
            return tVar2.abf;
        }

        private void c(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    c((ViewGroup) childAt, true);
                }
            }
            if (!z) {
                return;
            }
            if (viewGroup.getVisibility() == 4) {
                viewGroup.setVisibility(0);
                viewGroup.setVisibility(4);
                return;
            }
            int visibility = viewGroup.getVisibility();
            viewGroup.setVisibility(4);
            viewGroup.setVisibility(visibility);
        }

        public final void bn(View view) {
            t aZ = RecyclerView.aZ(view);
            if (aZ.gn()) {
                this.aaa.removeDetachedView(view, false);
            }
            if (aZ.gg()) {
                aZ.gh();
            } else if (aZ.gi()) {
                aZ.gj();
            }
            n(aZ);
        }

        final void fW() {
            for (int size = this.aaA.size() - 1; size >= 0; size--) {
                bl(size);
            }
            this.aaA.clear();
        }

        final void bl(int i) {
            o((t) this.aaA.get(i));
            this.aaA.remove(i);
        }

        final void n(t tVar) {
            boolean z = true;
            int i = 0;
            if (tVar.gg() || tVar.abf.getParent() != null) {
                StringBuilder append = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:").append(tVar.gg()).append(" isAttached:");
                if (tVar.abf.getParent() == null) {
                    z = false;
                }
                throw new IllegalArgumentException(append.append(z).toString());
            } else if (tVar.gn()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + tVar);
            } else if (tVar.gd()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
            } else {
                boolean z2 = (tVar.uf & 16) == 0 && z.E(tVar.abf);
                if (this.aaa.Ze != null && z2) {
                    this.aaa.Ze;
                }
                if (tVar.gr()) {
                    boolean z3;
                    if (!tVar.bo(14)) {
                        int size = this.aaA.size();
                        if (size == this.aaC && size > 0) {
                            bl(0);
                        }
                        if (size < this.aaC) {
                            this.aaA.add(tVar);
                            z3 = true;
                            if (z3) {
                                o(tVar);
                                i = 1;
                                z = z3;
                            } else {
                                z = z3;
                            }
                        }
                    }
                    z3 = false;
                    if (z3) {
                        z = z3;
                    } else {
                        o(tVar);
                        i = 1;
                        z = z3;
                    }
                } else {
                    z = false;
                }
                this.aaa.Zb.x(tVar);
                if (!z && r1 == 0 && z2) {
                    tVar.abt = null;
                }
            }
        }

        private void o(t tVar) {
            z.a(tVar.abf, null);
            if (this.aaa.Zg != null) {
                this.aaa.Zg;
            }
            if (this.aaa.Ze != null) {
                this.aaa.Ze.a(tVar);
            }
            if (this.aaa.ZL != null) {
                this.aaa.Zb.x(tVar);
            }
            tVar.abt = null;
            l fX = fX();
            int i = tVar.abi;
            ArrayList arrayList = (ArrayList) fX.aav.get(i);
            if (arrayList == null) {
                arrayList = new ArrayList();
                fX.aav.put(i, arrayList);
                if (fX.aaw.indexOfKey(i) < 0) {
                    fX.aaw.put(i, 5);
                }
            }
            if (fX.aaw.get(i) > arrayList.size()) {
                tVar.gq();
                arrayList.add(tVar);
            }
        }

        final void bo(View view) {
            t aZ = RecyclerView.aZ(view);
            aZ.abq = null;
            aZ.abr = false;
            aZ.gj();
            n(aZ);
        }

        final void bp(View view) {
            t aZ = RecyclerView.aZ(view);
            if (!aZ.bo(12) && aZ.gs() && !RecyclerView.a(this.aaa, aZ)) {
                if (this.aaz == null) {
                    this.aaz = new ArrayList();
                }
                aZ.a(this, true);
                this.aaz.add(aZ);
            } else if (!aZ.gl() || aZ.isRemoved() || this.aaa.Ze.aac) {
                aZ.a(this, false);
                this.aay.add(aZ);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
            }
        }

        final void p(t tVar) {
            if (tVar.abr) {
                this.aaz.remove(tVar);
            } else {
                this.aay.remove(tVar);
            }
            tVar.abq = null;
            tVar.abr = false;
            tVar.gj();
        }

        private t bm(int i) {
            int i2 = 0;
            if (this.aaz != null) {
                int size = this.aaz.size();
                if (size != 0) {
                    t tVar;
                    int i3 = 0;
                    while (i3 < size) {
                        tVar = (t) this.aaz.get(i3);
                        if (tVar.gi() || tVar.ge() != i) {
                            i3++;
                        } else {
                            tVar.addFlags(32);
                            return tVar;
                        }
                    }
                    if (this.aaa.Ze.aac) {
                        int t = this.aaa.YZ.t(i, 0);
                        if (t > 0 && t < this.aaa.Ze.getItemCount()) {
                            long itemId = this.aaa.Ze.getItemId(t);
                            while (i2 < size) {
                                tVar = (t) this.aaz.get(i2);
                                if (tVar.gi() || tVar.abh != itemId) {
                                    i2++;
                                } else {
                                    tVar.addFlags(32);
                                    return tVar;
                                }
                            }
                        }
                    }
                    return null;
                }
            }
            return null;
        }

        private t o(int i, boolean z) {
            View view;
            int i2 = 0;
            int size = this.aay.size();
            int i3 = 0;
            while (i3 < size) {
                t tVar = (t) this.aay.get(i3);
                if (tVar.gi() || tVar.ge() != i || tVar.gl() || (!this.aaa.ZL.aaW && tVar.isRemoved())) {
                    i3++;
                } else {
                    tVar.addFlags(32);
                    return tVar;
                }
            }
            s sVar = this.aaa.Za;
            int size2 = sVar.VN.size();
            for (i3 = 0; i3 < size2; i3++) {
                View view2 = (View) sVar.VN.get(i3);
                t aQ = sVar.VL.aQ(view2);
                if (aQ.ge() == i && !aQ.gl() && !aQ.isRemoved()) {
                    view = view2;
                    break;
                }
            }
            view = null;
            if (view != null) {
                tVar = RecyclerView.aZ(view);
                s sVar2 = this.aaa.Za;
                i2 = sVar2.VL.indexOfChild(view);
                if (i2 < 0) {
                    throw new IllegalArgumentException("view is not a child, cannot hide " + view);
                } else if (sVar2.VM.get(i2)) {
                    sVar2.VM.clear(i2);
                    sVar2.aO(view);
                    int indexOfChild = this.aaa.Za.indexOfChild(view);
                    if (indexOfChild == -1) {
                        throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + tVar);
                    }
                    this.aaa.Za.detachViewFromParent(indexOfChild);
                    bp(view);
                    tVar.addFlags(8224);
                    return tVar;
                } else {
                    throw new RuntimeException("trying to unhide a view that was not hidden" + view);
                }
            }
            i3 = this.aaA.size();
            while (i2 < i3) {
                tVar = (t) this.aaA.get(i2);
                if (tVar.gl() || tVar.ge() != i) {
                    i2++;
                } else {
                    this.aaA.remove(i2);
                    return tVar;
                }
            }
            return null;
        }

        private t b(long j, int i, boolean z) {
            int size;
            for (size = this.aay.size() - 1; size >= 0; size--) {
                t tVar = (t) this.aay.get(size);
                if (tVar.abh == j && !tVar.gi()) {
                    if (i == tVar.abi) {
                        tVar.addFlags(32);
                        if (!tVar.isRemoved() || this.aaa.ZL.aaW) {
                            return tVar;
                        }
                        tVar.setFlags(2, 14);
                        return tVar;
                    }
                    this.aay.remove(size);
                    this.aaa.removeDetachedView(tVar.abf, false);
                    bo(tVar.abf);
                }
            }
            for (size = this.aaA.size() - 1; size >= 0; size--) {
                tVar = (t) this.aaA.get(size);
                if (tVar.abh == j) {
                    if (i == tVar.abi) {
                        this.aaA.remove(size);
                        return tVar;
                    }
                    bl(size);
                }
            }
            return null;
        }

        final l fX() {
            if (this.aaD == null) {
                this.aaD = new l();
            }
            return this.aaD;
        }
    }

    public interface n {
    }

    public static abstract class p {
        h YQ;
        public int aaG = -1;
        boolean aaH;
        boolean aaI;
        View aaJ;
        private final a aaK = new a();
        RecyclerView aak;

        public static class a {
            private int aaL;
            private int aaM;
            int aaN;
            private boolean aaO;
            private int aaP;
            private int ls;
            private Interpolator mInterpolator;

            public a() {
                this(0, 0);
            }

            private a(int i, int i2) {
                this.aaN = -1;
                this.aaO = false;
                this.aaP = 0;
                this.aaL = 0;
                this.aaM = 0;
                this.ls = Integer.MIN_VALUE;
                this.mInterpolator = null;
            }

            public final void A(RecyclerView recyclerView) {
                if (this.aaN >= 0) {
                    int i = this.aaN;
                    this.aaN = -1;
                    RecyclerView.d(recyclerView, i);
                    this.aaO = false;
                } else if (!this.aaO) {
                    this.aaP = 0;
                } else if (this.mInterpolator != null && this.ls <= 0) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (this.ls <= 0) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                } else {
                    if (this.mInterpolator != null) {
                        recyclerView.ZK.b(this.aaL, this.aaM, this.ls, this.mInterpolator);
                    } else if (this.ls == Integer.MIN_VALUE) {
                        recyclerView.ZK.smoothScrollBy(this.aaL, this.aaM);
                    } else {
                        recyclerView.ZK.l(this.aaL, this.aaM, this.ls);
                    }
                    this.aaP++;
                    this.aaO = false;
                }
            }

            public final void a(int i, int i2, int i3, Interpolator interpolator) {
                this.aaL = i;
                this.aaM = i2;
                this.ls = i3;
                this.mInterpolator = interpolator;
                this.aaO = true;
            }
        }

        protected abstract void a(int i, int i2, a aVar);

        protected abstract void a(View view, a aVar);

        protected abstract void onStop();

        protected final void stop() {
            if (this.aaI) {
                onStop();
                this.aak.ZL.aaG = -1;
                this.aaJ = null;
                this.aaG = -1;
                this.aaH = false;
                this.aaI = false;
                h hVar = this.YQ;
                if (hVar.aal == this) {
                    hVar.aal = null;
                }
                this.YQ = null;
                this.aak = null;
            }
        }

        public final void ab(int i, int i2) {
            boolean z = false;
            RecyclerView recyclerView = this.aak;
            if (!this.aaI || this.aaG == -1 || recyclerView == null) {
                stop();
            }
            this.aaH = false;
            if (this.aaJ != null) {
                if (RecyclerView.bb(this.aaJ) == this.aaG) {
                    View view = this.aaJ;
                    q qVar = recyclerView.ZL;
                    a(view, this.aaK);
                    this.aaK.A(recyclerView);
                    stop();
                } else {
                    this.aaJ = null;
                }
            }
            if (this.aaI) {
                q qVar2 = recyclerView.ZL;
                a(i, i2, this.aaK);
                if (this.aaK.aaN >= 0) {
                    z = true;
                }
                this.aaK.A(recyclerView);
                if (!z) {
                    return;
                }
                if (this.aaI) {
                    this.aaH = true;
                    recyclerView.ZK.ga();
                    return;
                }
                stop();
            }
        }
    }

    public static class q {
        public int aaG = -1;
        public int aaQ = 1;
        private SparseArray<Object> aaR;
        int aaS = 0;
        public int aaT = 0;
        public int aaU = 0;
        public boolean aaV = false;
        public boolean aaW = false;
        public boolean aaX = false;
        public boolean aaY = false;
        public boolean aaZ = false;
        public boolean aba = false;

        final void bn(int i) {
            if ((this.aaQ & i) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.aaQ));
            }
        }

        public final int getItemCount() {
            return this.aaW ? this.aaT - this.aaU : this.aaS;
        }

        public final String toString() {
            return "State{mTargetPosition=" + this.aaG + ", mData=" + this.aaR + ", mItemCount=" + this.aaS + ", mPreviousLayoutItemCount=" + this.aaT + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.aaU + ", mStructureChanged=" + this.aaV + ", mInPreLayout=" + this.aaW + ", mRunSimpleAnimations=" + this.aaX + ", mRunPredictiveAnimations=" + this.aaY + '}';
        }
    }

    public static abstract class r {
        public abstract View fZ();
    }

    private class s implements Runnable {
        final /* synthetic */ RecyclerView aaa;
        int abb;
        int abc;
        private boolean abd = false;
        private boolean abe = false;
        android.support.v4.widget.q iB;
        private Interpolator mInterpolator = RecyclerView.ZY;

        public s(RecyclerView recyclerView) {
            this.aaa = recyclerView;
            this.iB = android.support.v4.widget.q.a(recyclerView.getContext(), RecyclerView.ZY);
        }

        public final void run() {
            if (this.aaa.Zf == null) {
                stop();
                return;
            }
            this.abe = false;
            this.abd = true;
            this.aaa.fo();
            android.support.v4.widget.q qVar = this.iB;
            p pVar = this.aaa.Zf.aal;
            if (qVar.computeScrollOffset()) {
                int itemCount;
                int i;
                int currVelocity;
                int i2;
                View view;
                Object obj;
                Object obj2;
                int currX = qVar.getCurrX();
                int currY = qVar.getCurrY();
                int i3 = currX - this.abb;
                int i4 = currY - this.abc;
                int i5 = 0;
                int i6 = 0;
                this.abb = currX;
                this.abc = currY;
                int i7 = 0;
                int i8 = 0;
                if (this.aaa.Ze != null) {
                    this.aaa.fp();
                    this.aaa.fz();
                    android.support.v4.os.e.beginSection("RV Scroll");
                    if (i3 != 0) {
                        i5 = this.aaa.Zf.a(i3, this.aaa.YX, this.aaa.ZL);
                        i7 = i3 - i5;
                    }
                    if (i4 != 0) {
                        i6 = this.aaa.Zf.b(i4, this.aaa.YX, this.aaa.ZL);
                        i8 = i4 - i6;
                    }
                    android.support.v4.os.e.endSection();
                    this.aaa.fM();
                    this.aaa.fA();
                    this.aaa.R(false);
                    if (!(pVar == null || pVar.aaH || !pVar.aaI)) {
                        itemCount = this.aaa.ZL.getItemCount();
                        if (itemCount == 0) {
                            pVar.stop();
                            i = i7;
                            i7 = i6;
                            i6 = i;
                            if (!this.aaa.Zh.isEmpty()) {
                                this.aaa.invalidate();
                            }
                            if (z.C(this.aaa) != 2) {
                                this.aaa.M(i3, i4);
                            }
                            if (!(i6 == 0 && i8 == 0)) {
                                currVelocity = (int) qVar.getCurrVelocity();
                                if (i6 == currX) {
                                    itemCount = i6 >= 0 ? -currVelocity : i6 <= 0 ? currVelocity : 0;
                                    i2 = itemCount;
                                } else {
                                    i2 = 0;
                                }
                                if (i8 != currY) {
                                    currVelocity = 0;
                                } else if (i8 < 0) {
                                    currVelocity = -currVelocity;
                                } else if (i8 <= 0) {
                                    currVelocity = 0;
                                }
                                if (z.C(this.aaa) != 2) {
                                    view = this.aaa;
                                    if (i2 < 0) {
                                        view.fs();
                                        view.Zx.ag(-i2);
                                    } else if (i2 > 0) {
                                        view.ft();
                                        view.Zz.ag(i2);
                                    }
                                    if (currVelocity < 0) {
                                        view.fu();
                                        view.Zy.ag(-currVelocity);
                                    } else if (currVelocity > 0) {
                                        view.fv();
                                        view.ZA.ag(currVelocity);
                                    }
                                    if (!(i2 == 0 && currVelocity == 0)) {
                                        z.F(view);
                                    }
                                }
                                if ((i2 != 0 || i6 == currX || qVar.getFinalX() == 0) && (currVelocity != 0 || i8 == currY || qVar.getFinalY() == 0)) {
                                    qVar.abortAnimation();
                                }
                            }
                            if (!(i5 == 0 && i7 == 0)) {
                                this.aaa.O(i5, i7);
                            }
                            if (!this.aaa.awakenScrollBars()) {
                                this.aaa.invalidate();
                            }
                            obj = (i4 == 0 && this.aaa.Zf.eS() && i7 == i4) ? 1 : null;
                            obj2 = (i3 == 0 && this.aaa.Zf.eR() && i5 == i3) ? 1 : null;
                            obj2 = ((i3 == 0 || i4 != 0) && obj2 == null && obj == null) ? null : 1;
                            if (!qVar.isFinished() || obj2 == null) {
                                this.aaa.X(0);
                            } else {
                                ga();
                            }
                        } else {
                            if (pVar.aaG >= itemCount) {
                                pVar.aaG = itemCount - 1;
                            }
                            pVar.ab(i3 - i7, i4 - i8);
                        }
                    }
                }
                i = i7;
                i7 = i6;
                i6 = i;
                if (this.aaa.Zh.isEmpty()) {
                    this.aaa.invalidate();
                }
                if (z.C(this.aaa) != 2) {
                    this.aaa.M(i3, i4);
                }
                currVelocity = (int) qVar.getCurrVelocity();
                if (i6 == currX) {
                    i2 = 0;
                } else {
                    if (i6 >= 0) {
                        if (i6 <= 0) {
                        }
                    }
                    i2 = itemCount;
                }
                if (i8 != currY) {
                    currVelocity = 0;
                } else if (i8 < 0) {
                    currVelocity = -currVelocity;
                } else if (i8 <= 0) {
                    currVelocity = 0;
                }
                if (z.C(this.aaa) != 2) {
                    view = this.aaa;
                    if (i2 < 0) {
                        view.fs();
                        view.Zx.ag(-i2);
                    } else if (i2 > 0) {
                        view.ft();
                        view.Zz.ag(i2);
                    }
                    if (currVelocity < 0) {
                        view.fu();
                        view.Zy.ag(-currVelocity);
                    } else if (currVelocity > 0) {
                        view.fv();
                        view.ZA.ag(currVelocity);
                    }
                    z.F(view);
                }
                qVar.abortAnimation();
                this.aaa.O(i5, i7);
                if (this.aaa.awakenScrollBars()) {
                    this.aaa.invalidate();
                }
                if (i4 == 0) {
                }
                if (i3 == 0) {
                }
                if (i3 == 0) {
                }
                if (qVar.isFinished()) {
                }
                this.aaa.X(0);
            }
            if (pVar != null) {
                if (pVar.aaH) {
                    pVar.ab(0, 0);
                }
                if (!this.abe) {
                    pVar.stop();
                }
            }
            this.abd = false;
            if (this.abe) {
                ga();
            }
        }

        final void ga() {
            if (this.abd) {
                this.abe = true;
                return;
            }
            this.aaa.removeCallbacks(this);
            z.a(this.aaa, (Runnable) this);
        }

        public final void smoothScrollBy(int i, int i2) {
            int round;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            Object obj = abs > abs2 ? 1 : null;
            int sqrt = (int) Math.sqrt(0.0d);
            int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
            int width = obj != null ? this.aaa.getWidth() : this.aaa.getHeight();
            int i3 = width / 2;
            float sin = (((float) Math.sin((double) ((float) (((double) (Math.min(1.0f, (((float) sqrt2) * 1.0f) / ((float) width)) - 0.5f)) * 0.4712389167638204d)))) * ((float) i3)) + ((float) i3);
            if (sqrt > 0) {
                round = Math.round(1000.0f * Math.abs(sin / ((float) sqrt))) * 4;
            } else {
                round = (int) (((((float) (obj != null ? abs : abs2)) / ((float) width)) + 1.0f) * 300.0f);
            }
            l(i, i2, Math.min(round, MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN));
        }

        public final void l(int i, int i2, int i3) {
            b(i, i2, i3, RecyclerView.ZY);
        }

        public final void b(int i, int i2, int i3, Interpolator interpolator) {
            if (this.mInterpolator != interpolator) {
                this.mInterpolator = interpolator;
                this.iB = android.support.v4.widget.q.a(this.aaa.getContext(), interpolator);
            }
            this.aaa.X(2);
            this.abc = 0;
            this.abb = 0;
            this.iB.startScroll(0, 0, i, i2, i3);
            ga();
        }

        public final void stop() {
            this.aaa.removeCallbacks(this);
            this.iB.abortAnimation();
        }
    }

    public static abstract class t {
        private static final List<Object> abm = Collections.EMPTY_LIST;
        public final View abf;
        int abg = -1;
        public long abh = -1;
        public int abi = -1;
        int abj = -1;
        t abk = null;
        t abl = null;
        List<Object> abn = null;
        List<Object> abo = null;
        private int abp = 0;
        public m abq = null;
        public boolean abr = false;
        int abs = 0;
        RecyclerView abt;
        int kC = -1;
        public int uf;

        public t(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.abf = view;
        }

        final void p(int i, boolean z) {
            if (this.abg == -1) {
                this.abg = this.kC;
            }
            if (this.abj == -1) {
                this.abj = this.kC;
            }
            if (z) {
                this.abj += i;
            }
            this.kC += i;
            if (this.abf.getLayoutParams() != null) {
                ((LayoutParams) this.abf.getLayoutParams()).aat = true;
            }
        }

        final void gb() {
            this.abg = -1;
            this.abj = -1;
        }

        final boolean gd() {
            return (this.uf & FileUtils.S_IWUSR) != 0;
        }

        @Deprecated
        public final int getPosition() {
            return this.abj == -1 ? this.kC : this.abj;
        }

        public final int ge() {
            return this.abj == -1 ? this.kC : this.abj;
        }

        public final int gf() {
            if (this.abt == null) {
                return -1;
            }
            return this.abt.h(this);
        }

        final boolean gg() {
            return this.abq != null;
        }

        final void gh() {
            this.abq.p(this);
        }

        final boolean gi() {
            return (this.uf & 32) != 0;
        }

        final void gj() {
            this.uf &= -33;
        }

        final void gk() {
            this.uf &= -257;
        }

        final void a(m mVar, boolean z) {
            this.abq = mVar;
            this.abr = z;
        }

        final boolean gl() {
            return (this.uf & 4) != 0;
        }

        final boolean gm() {
            return (this.uf & 2) != 0;
        }

        final boolean isBound() {
            return (this.uf & 1) != 0;
        }

        final boolean isRemoved() {
            return (this.uf & 8) != 0;
        }

        final boolean bo(int i) {
            return (this.uf & i) != 0;
        }

        final boolean gn() {
            return (this.uf & 256) != 0;
        }

        final void setFlags(int i, int i2) {
            this.uf = (this.uf & (i2 ^ -1)) | (i & i2);
        }

        final void addFlags(int i) {
            this.uf |= i;
        }

        final void R(Object obj) {
            if (obj == null) {
                addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            } else if ((this.uf & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == 0) {
                if (this.abn == null) {
                    this.abn = new ArrayList();
                    this.abo = Collections.unmodifiableList(this.abn);
                }
                this.abn.add(obj);
            }
        }

        final void go() {
            if (this.abn != null) {
                this.abn.clear();
            }
            this.uf &= -1025;
        }

        final List<Object> gp() {
            if ((this.uf & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                return abm;
            }
            if (this.abn == null || this.abn.size() == 0) {
                return abm;
            }
            return this.abo;
        }

        final void gq() {
            this.uf = 0;
            this.kC = -1;
            this.abg = -1;
            this.abh = -1;
            this.abj = -1;
            this.abp = 0;
            this.abk = null;
            this.abl = null;
            go();
            this.abs = 0;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.kC + " id=" + this.abh + ", oldPos=" + this.abg + ", pLpos:" + this.abj);
            if (gg()) {
                stringBuilder.append(" scrap ").append(this.abr ? "[changeScrap]" : "[attachedScrap]");
            }
            if (gl()) {
                stringBuilder.append(" invalid");
            }
            if (!isBound()) {
                stringBuilder.append(" unbound");
            }
            if (gm()) {
                stringBuilder.append(" update");
            }
            if (isRemoved()) {
                stringBuilder.append(" removed");
            }
            if (gd()) {
                stringBuilder.append(" ignored");
            }
            if (gn()) {
                stringBuilder.append(" tmpDetached");
            }
            if (!gr()) {
                stringBuilder.append(" not recyclable(" + this.abp + ")");
            }
            Object obj = ((this.uf & 512) != 0 || gl()) ? 1 : null;
            if (obj != null) {
                stringBuilder.append(" undefined adapter position");
            }
            if (this.abf.getParent() == null) {
                stringBuilder.append(" no parent");
            }
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        public final void U(boolean z) {
            this.abp = z ? this.abp - 1 : this.abp + 1;
            if (this.abp < 0) {
                this.abp = 0;
                new StringBuilder("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ").append(this);
            } else if (!z && this.abp == 1) {
                this.uf |= 16;
            } else if (z && this.abp == 0) {
                this.uf &= -17;
            }
        }

        public final boolean gr() {
            return (this.uf & 16) == 0 && !z.E(this.abf);
        }

        final boolean gs() {
            return (this.uf & 2) != 0;
        }
    }

    private class f implements b {
        final /* synthetic */ RecyclerView aaa;

        public f(RecyclerView recyclerView) {
            this.aaa = recyclerView;
        }

        public final void l(t tVar) {
            boolean z = true;
            tVar.U(true);
            if (tVar.abk != null && tVar.abl == null) {
                tVar.abk = null;
            }
            tVar.abl = null;
            if ((tVar.uf & 16) == 0) {
                z = false;
            }
            if (!z && !RecyclerView.c(this.aaa, tVar.abf) && tVar.gn()) {
                this.aaa.removeDetachedView(tVar.abf, false);
            }
        }
    }

    private class o extends c {
        final /* synthetic */ RecyclerView aaa;

        public o(RecyclerView recyclerView) {
            this.aaa = recyclerView;
        }

        public final void onChanged() {
            this.aaa.q(null);
            boolean z = this.aaa.Ze.aac;
            this.aaa.ZL.aaV = true;
            RecyclerView.n(this.aaa);
            if (!this.aaa.YZ.et()) {
                this.aaa.requestLayout();
            }
        }

        public final void c(int i, int i2, Object obj) {
            Object obj2 = 1;
            this.aaa.q(null);
            e eVar = this.aaa.YZ;
            eVar.Uc.add(eVar.a(4, i, i2, obj));
            eVar.Ui |= 4;
            if (eVar.Uc.size() != 1) {
                obj2 = null;
            }
            if (obj2 != null) {
                fY();
            }
        }

        public final void U(int i, int i2) {
            int i3 = 1;
            this.aaa.q(null);
            e eVar = this.aaa.YZ;
            eVar.Uc.add(eVar.a(1, i, i2, null));
            eVar.Ui |= 1;
            if (eVar.Uc.size() != 1) {
                i3 = 0;
            }
            if (i3 != 0) {
                fY();
            }
        }

        public final void V(int i, int i2) {
            Object obj = 1;
            this.aaa.q(null);
            e eVar = this.aaa.YZ;
            eVar.Uc.add(eVar.a(2, i, i2, null));
            eVar.Ui |= 2;
            if (eVar.Uc.size() != 1) {
                obj = null;
            }
            if (obj != null) {
                fY();
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void W(int r6, int r7) {
            /*
            r5 = this;
            r4 = 0;
            r0 = 1;
            r1 = r5.aaa;
            r1.q(r4);
            r1 = r5.aaa;
            r1 = r1.YZ;
            if (r6 == r7) goto L_0x002c;
        L_0x000d:
            r2 = r1.Uc;
            r3 = 8;
            r3 = r1.a(r3, r6, r7, r4);
            r2.add(r3);
            r2 = r1.Ui;
            r2 = r2 | 8;
            r1.Ui = r2;
            r1 = r1.Uc;
            r1 = r1.size();
            if (r1 != r0) goto L_0x002c;
        L_0x0026:
            if (r0 == 0) goto L_0x002b;
        L_0x0028:
            r5.fY();
        L_0x002b:
            return;
        L_0x002c:
            r0 = 0;
            goto L_0x0026;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.o.W(int, int):void");
        }

        private void fY() {
            if (this.aaa.Zt && this.aaa.Zl && this.aaa.Zk) {
                z.a(this.aaa, this.aaa.Zd);
                return;
            }
            this.aaa.Zs = true;
            this.aaa.requestLayout();
        }
    }

    static /* synthetic */ void a(RecyclerView recyclerView, t tVar, c cVar, c cVar2) {
        recyclerView.f(tVar);
        tVar.U(false);
        if (recyclerView.ZB.d(tVar, cVar, cVar2)) {
            recyclerView.fD();
        }
    }

    static /* synthetic */ void a(RecyclerView recyclerView, View view) {
        aZ(view);
        if (recyclerView.Zu != null) {
            for (int size = recyclerView.Zu.size() - 1; size >= 0; size--) {
                recyclerView.Zu.get(size);
            }
        }
    }

    static /* synthetic */ boolean a(RecyclerView recyclerView, t tVar) {
        return recyclerView.ZB == null || recyclerView.ZB.a(tVar, tVar.gp());
    }

    static /* synthetic */ void b(RecyclerView recyclerView, t tVar, c cVar, c cVar2) {
        tVar.U(false);
        if (recyclerView.ZB.e(tVar, cVar, cVar2)) {
            recyclerView.fD();
        }
    }

    static /* synthetic */ boolean c(RecyclerView recyclerView, View view) {
        boolean z;
        boolean z2 = true;
        recyclerView.fp();
        s sVar = recyclerView.Za;
        int indexOfChild = sVar.VL.indexOfChild(view);
        if (indexOfChild == -1) {
            sVar.aO(view);
            z = true;
        } else if (sVar.VM.get(indexOfChild)) {
            sVar.VM.aO(indexOfChild);
            sVar.aO(view);
            sVar.VL.removeViewAt(indexOfChild);
            z = true;
        } else {
            z = false;
        }
        if (z) {
            t aZ = aZ(view);
            recyclerView.YX.p(aZ);
            recyclerView.YX.n(aZ);
        }
        if (z) {
            z2 = false;
        }
        recyclerView.R(z2);
        return z;
    }

    static /* synthetic */ void d(RecyclerView recyclerView, int i) {
        if (recyclerView.Zf != null) {
            recyclerView.Zf.aX(i);
            recyclerView.awakenScrollBars();
        }
    }

    static /* synthetic */ void n(RecyclerView recyclerView) {
        if (!recyclerView.Zv) {
            int i;
            recyclerView.Zv = true;
            int eG = recyclerView.Za.eG();
            for (i = 0; i < eG; i++) {
                t aZ = aZ(recyclerView.Za.aN(i));
                if (!(aZ == null || aZ.gd())) {
                    aZ.addFlags(512);
                }
            }
            m mVar = recyclerView.YX;
            int size = mVar.aaA.size();
            for (i = 0; i < size; i++) {
                t tVar = (t) mVar.aaA.get(i);
                if (tVar != null) {
                    tVar.addFlags(512);
                }
            }
        }
    }

    static {
        boolean z = VERSION.SDK_INT == 18 || VERSION.SDK_INT == 19 || VERSION.SDK_INT == 20;
        YT = z;
        if (VERSION.SDK_INT >= 23) {
            z = true;
        } else {
            z = false;
        }
        YU = z;
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        boolean z2 = true;
        super(context, attributeSet, i);
        this.YW = new o(this);
        this.YX = new m(this);
        this.Zb = new as();
        this.Zd = new Runnable(this) {
            final /* synthetic */ RecyclerView aaa;

            {
                this.aaa = r1;
            }

            public final void run() {
                if (this.aaa.Zm && !this.aaa.isLayoutRequested()) {
                    if (this.aaa.Zp) {
                        this.aaa.Zo = true;
                    } else {
                        this.aaa.fo();
                    }
                }
            }
        };
        this.eq = new Rect();
        this.Zh = new ArrayList();
        this.Zi = new ArrayList();
        this.Zn = 0;
        this.Zv = false;
        this.Zw = 0;
        this.ZB = new v();
        this.xV = 0;
        this.ZC = -1;
        this.ZJ = Float.MIN_VALUE;
        this.ZK = new s(this);
        this.ZL = new q();
        this.ZO = false;
        this.ZP = false;
        this.ZQ = new f(this);
        this.ZR = false;
        this.ZU = new int[2];
        this.Dd = new int[2];
        this.De = new int[2];
        this.ZW = new int[2];
        this.ZX = new Runnable(this) {
            final /* synthetic */ RecyclerView aaa;

            {
                this.aaa = r1;
            }

            public final void run() {
                if (this.aaa.ZB != null) {
                    this.aaa.ZB.eJ();
                }
                this.aaa.ZR = false;
            }
        };
        this.ZZ = new b(this) {
            final /* synthetic */ RecyclerView aaa;

            {
                this.aaa = r1;
            }

            public final void a(t tVar, c cVar, c cVar2) {
                this.aaa.YX.p(tVar);
                RecyclerView.a(this.aaa, tVar, cVar, cVar2);
            }

            public final void b(t tVar, c cVar, c cVar2) {
                RecyclerView.b(this.aaa, tVar, cVar, cVar2);
            }

            public final void c(t tVar, c cVar, c cVar2) {
                tVar.U(false);
                if (this.aaa.Zv) {
                    if (this.aaa.ZB.a(tVar, tVar, cVar, cVar2)) {
                        this.aaa.fD();
                    }
                } else if (this.aaa.ZB.f(tVar, cVar, cVar2)) {
                    this.aaa.fD();
                }
            }

            public final void i(t tVar) {
                this.aaa.Zf.a(tVar.abf, this.aaa.YX);
            }
        };
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        this.Zt = VERSION.SDK_INT >= 16;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.iE = viewConfiguration.getScaledTouchSlop();
        this.ZH = viewConfiguration.getScaledMinimumFlingVelocity();
        this.ZI = viewConfiguration.getScaledMaximumFlingVelocity();
        if (z.C(this) == 2) {
            z = true;
        } else {
            z = false;
        }
        setWillNotDraw(z);
        this.ZB.aad = this.ZQ;
        this.YZ = new e(new a(this) {
            final /* synthetic */ RecyclerView aaa;

            {
                this.aaa = r1;
            }

            public final t aJ(int i) {
                t aZ;
                RecyclerView recyclerView = this.aaa;
                int eG = recyclerView.Za.eG();
                for (int i2 = 0; i2 < eG; i2++) {
                    aZ = RecyclerView.aZ(recyclerView.Za.aN(i2));
                    if (aZ != null && !aZ.isRemoved() && aZ.kC == i) {
                        break;
                    }
                }
                aZ = null;
                if (aZ == null || this.aaa.Za.aP(aZ.abf)) {
                    return null;
                }
                return aZ;
            }

            public final void u(int i, int i2) {
                this.aaa.d(i, i2, true);
                this.aaa.ZO = true;
                q qVar = this.aaa.ZL;
                qVar.aaU += i2;
            }

            public final void v(int i, int i2) {
                this.aaa.d(i, i2, false);
                this.aaa.ZO = true;
            }

            public final void a(int i, int i2, Object obj) {
                int i3;
                RecyclerView recyclerView = this.aaa;
                int eG = recyclerView.Za.eG();
                int i4 = i + i2;
                for (i3 = 0; i3 < eG; i3++) {
                    View aN = recyclerView.Za.aN(i3);
                    t aZ = RecyclerView.aZ(aN);
                    if (aZ != null && !aZ.gd() && aZ.kC >= i && aZ.kC < i4) {
                        aZ.addFlags(2);
                        aZ.R(obj);
                        ((LayoutParams) aN.getLayoutParams()).aat = true;
                    }
                }
                m mVar = recyclerView.YX;
                eG = i + i2;
                for (i3 = mVar.aaA.size() - 1; i3 >= 0; i3--) {
                    t tVar = (t) mVar.aaA.get(i3);
                    if (tVar != null) {
                        i4 = tVar.ge();
                        if (i4 >= i && i4 < eG) {
                            tVar.addFlags(2);
                            mVar.bl(i3);
                        }
                    }
                }
                this.aaa.ZP = true;
            }

            public final void d(b bVar) {
                f(bVar);
            }

            private void f(b bVar) {
                switch (bVar.ou) {
                    case 1:
                        this.aaa.Zf.z(bVar.Uj, bVar.Ul);
                        return;
                    case 2:
                        this.aaa.Zf.A(bVar.Uj, bVar.Ul);
                        return;
                    case 4:
                        this.aaa.Zf.B(bVar.Uj, bVar.Ul);
                        return;
                    case 8:
                        this.aaa.Zf.C(bVar.Uj, bVar.Ul);
                        return;
                    default:
                        return;
                }
            }

            public final void e(b bVar) {
                f(bVar);
            }

            public final void w(int i, int i2) {
                int i3;
                RecyclerView recyclerView = this.aaa;
                int eG = recyclerView.Za.eG();
                for (i3 = 0; i3 < eG; i3++) {
                    t aZ = RecyclerView.aZ(recyclerView.Za.aN(i3));
                    if (!(aZ == null || aZ.gd() || aZ.kC < i)) {
                        aZ.p(i2, false);
                        recyclerView.ZL.aaV = true;
                    }
                }
                m mVar = recyclerView.YX;
                int size = mVar.aaA.size();
                for (i3 = 0; i3 < size; i3++) {
                    t tVar = (t) mVar.aaA.get(i3);
                    if (tVar != null && tVar.kC >= i) {
                        tVar.p(i2, true);
                    }
                }
                recyclerView.requestLayout();
                this.aaa.ZO = true;
            }

            public final void x(int i, int i2) {
                int i3;
                int i4;
                int i5;
                int i6;
                int i7 = -1;
                RecyclerView recyclerView = this.aaa;
                int eG = recyclerView.Za.eG();
                if (i < i2) {
                    i3 = -1;
                    i4 = i2;
                    i5 = i;
                } else {
                    i3 = 1;
                    i4 = i;
                    i5 = i2;
                }
                for (i6 = 0; i6 < eG; i6++) {
                    t aZ = RecyclerView.aZ(recyclerView.Za.aN(i6));
                    if (aZ != null && aZ.kC >= r4 && aZ.kC <= r3) {
                        if (aZ.kC == i) {
                            aZ.p(i2 - i, false);
                        } else {
                            aZ.p(i3, false);
                        }
                        recyclerView.ZL.aaV = true;
                    }
                }
                m mVar = recyclerView.YX;
                if (i < i2) {
                    i4 = i2;
                    i5 = i;
                } else {
                    i7 = 1;
                    i4 = i;
                    i5 = i2;
                }
                int size = mVar.aaA.size();
                for (i6 = 0; i6 < size; i6++) {
                    t tVar = (t) mVar.aaA.get(i6);
                    if (tVar != null && tVar.kC >= r4 && tVar.kC <= r3) {
                        if (tVar.kC == i) {
                            tVar.p(i2 - i, false);
                        } else {
                            tVar.p(i7, false);
                        }
                    }
                }
                recyclerView.requestLayout();
                this.aaa.ZO = true;
            }
        });
        this.Za = new s(new b(this) {
            final /* synthetic */ RecyclerView aaa;

            {
                this.aaa = r1;
            }

            public final int getChildCount() {
                return this.aaa.getChildCount();
            }

            public final void addView(View view, int i) {
                this.aaa.addView(view, i);
                RecyclerView.a(this.aaa, view);
            }

            public final int indexOfChild(View view) {
                return this.aaa.indexOfChild(view);
            }

            public final void removeViewAt(int i) {
                View childAt = this.aaa.getChildAt(i);
                if (childAt != null) {
                    this.aaa.bd(childAt);
                }
                this.aaa.removeViewAt(i);
            }

            public final View getChildAt(int i) {
                return this.aaa.getChildAt(i);
            }

            public final void removeAllViews() {
                int childCount = this.aaa.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    this.aaa.bd(getChildAt(i));
                }
                this.aaa.removeAllViews();
            }

            public final t aQ(View view) {
                return RecyclerView.aZ(view);
            }

            public final void attachViewToParent(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
                t aZ = RecyclerView.aZ(view);
                if (aZ != null) {
                    if (aZ.gn() || aZ.gd()) {
                        aZ.gk();
                    } else {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + aZ);
                    }
                }
                this.aaa.attachViewToParent(view, i, layoutParams);
            }

            public final void detachViewFromParent(int i) {
                View childAt = getChildAt(i);
                if (childAt != null) {
                    t aZ = RecyclerView.aZ(childAt);
                    if (aZ != null) {
                        if (!aZ.gn() || aZ.gd()) {
                            aZ.addFlags(256);
                        } else {
                            throw new IllegalArgumentException("called detach on an already detached child " + aZ);
                        }
                    }
                }
                this.aaa.detachViewFromParent(i);
            }

            public final void aR(View view) {
                t aZ = RecyclerView.aZ(view);
                if (aZ != null) {
                    aZ.abs = z.G(aZ.abf);
                    z.i(aZ.abf, 4);
                }
            }

            public final void aS(View view) {
                t aZ = RecyclerView.aZ(view);
                if (aZ != null) {
                    z.i(aZ.abf, aZ.abs);
                    aZ.abs = 0;
                }
            }
        });
        if (z.G(this) == 0) {
            z.i(this, 1);
        }
        this.jl = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.ZS = new ac(this);
        z.a((View) this, this.ZS);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.d.a.c.cC, i, 0);
            String string = obtainStyledAttributes.getString(android.support.v7.d.a.c.Oz);
            obtainStyledAttributes.recycle();
            if (string != null) {
                String trim = string.trim();
                if (trim.length() != 0) {
                    string = trim.charAt(0) == '.' ? context.getPackageName() + trim : trim.contains(".") ? trim : RecyclerView.class.getPackage().getName() + '.' + trim;
                    try {
                        Constructor constructor;
                        Object[] objArr;
                        Class asSubclass = (isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).loadClass(string).asSubclass(h.class);
                        try {
                            constructor = asSubclass.getConstructor(YV);
                            objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(0)};
                        } catch (Throwable e) {
                            constructor = asSubclass.getConstructor(new Class[0]);
                            objArr = null;
                        }
                        constructor.setAccessible(true);
                        a((h) constructor.newInstance(objArr));
                    } catch (Throwable e2) {
                        e2.initCause(e);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + string, e2);
                    } catch (Throwable e3) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + string, e3);
                    } catch (Throwable e32) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + string, e32);
                    } catch (Throwable e322) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + string, e322);
                    } catch (Throwable e3222) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + string, e3222);
                    } catch (Throwable e32222) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + string, e32222);
                    }
                }
            }
            if (VERSION.SDK_INT >= 21) {
                obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, YS, i, 0);
                z2 = obtainStyledAttributes.getBoolean(0, true);
                obtainStyledAttributes.recycle();
            }
        }
        setNestedScrollingEnabled(z2);
    }

    public void setClipToPadding(boolean z) {
        if (z != this.Zc) {
            fw();
        }
        this.Zc = z;
        super.setClipToPadding(z);
        if (this.Zm) {
            requestLayout();
        }
    }

    public void a(a aVar) {
        S(false);
        if (this.Ze != null) {
            this.Ze.b(this.YW);
        }
        if (this.ZB != null) {
            this.ZB.eL();
        }
        if (this.Zf != null) {
            this.Zf.d(this.YX);
            this.Zf.c(this.YX);
        }
        this.YX.clear();
        this.YZ.reset();
        a aVar2 = this.Ze;
        this.Ze = aVar;
        if (aVar != null) {
            aVar.a(this.YW);
        }
        m mVar = this.YX;
        a aVar3 = this.Ze;
        mVar.clear();
        l fX = mVar.fX();
        if (aVar2 != null) {
            fX.aax--;
        }
        if (fX.aax == 0) {
            fX.aav.clear();
        }
        if (aVar3 != null) {
            fX.aax++;
        }
        this.ZL.aaV = true;
        fL();
        requestLayout();
    }

    public a fn() {
        return this.Ze;
    }

    public int getBaseline() {
        if (this.Zf != null) {
            return -1;
        }
        return super.getBaseline();
    }

    public void a(h hVar) {
        if (hVar != this.Zf) {
            fq();
            if (this.Zf != null) {
                if (this.Zk) {
                    this.Zf.b(this, this.YX);
                }
                this.Zf.y(null);
            }
            this.YX.clear();
            s sVar = this.Za;
            a aVar = sVar.VM;
            while (true) {
                aVar.VO = 0;
                if (aVar.VP == null) {
                    break;
                }
                aVar = aVar.VP;
            }
            for (int size = sVar.VN.size() - 1; size >= 0; size--) {
                sVar.VL.aS((View) sVar.VN.get(size));
                sVar.VN.remove(size);
            }
            sVar.VL.removeAllViews();
            this.Zf = hVar;
            if (hVar != null) {
                if (hVar.aak != null) {
                    throw new IllegalArgumentException("LayoutManager " + hVar + " is already attached to a RecyclerView: " + hVar.aak);
                }
                this.Zf.y(this);
                if (this.Zk) {
                    this.Zf.hi = true;
                }
            }
            requestLayout();
        }
    }

    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.YY != null) {
            savedState.aaF = this.YY.aaF;
        } else if (this.Zf != null) {
            savedState.aaF = this.Zf.onSaveInstanceState();
        } else {
            savedState.aaF = null;
        }
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.YY = (SavedState) parcelable;
            super.onRestoreInstanceState(this.YY.getSuperState());
            if (this.Zf != null && this.YY.aaF != null) {
                this.Zf.onRestoreInstanceState(this.YY.aaF);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void f(t tVar) {
        View view = tVar.abf;
        boolean z = view.getParent() == this;
        this.YX.p(aQ(view));
        if (tVar.gn()) {
            this.Za.a(view, -1, view.getLayoutParams(), true);
        } else if (z) {
            s sVar = this.Za;
            int indexOfChild = sVar.VL.indexOfChild(view);
            if (indexOfChild < 0) {
                throw new IllegalArgumentException("view is not a child, cannot hide " + view);
            }
            sVar.VM.set(indexOfChild);
            sVar.aN(view);
        } else {
            this.Za.a(view, -1, true);
        }
    }

    private void X(int i) {
        if (i != this.xV) {
            this.xV = i;
            if (i != 2) {
                fr();
            }
            if (this.Zf != null) {
                this.Zf.bi(i);
            }
            if (this.ZM != null) {
                this.ZM.e(this, i);
            }
            if (this.ZN != null) {
                for (int size = this.ZN.size() - 1; size >= 0; size--) {
                    ((k) this.ZN.get(size)).e(this, i);
                }
            }
        }
    }

    public final void a(g gVar) {
        if (this.Zf != null) {
            this.Zf.q("Cannot add item decoration during a scroll  or layout");
        }
        if (this.Zh.isEmpty()) {
            setWillNotDraw(false);
        }
        this.Zh.add(gVar);
        fJ();
        requestLayout();
    }

    public final void a(d dVar) {
        if (dVar != this.ZT) {
            this.ZT = dVar;
            setChildrenDrawingOrderEnabled(this.ZT != null);
        }
    }

    public final void a(k kVar) {
        if (this.ZN == null) {
            this.ZN = new ArrayList();
        }
        this.ZN.add(kVar);
    }

    public void aX(int i) {
        if (!this.Zp) {
            fq();
            if (this.Zf != null) {
                this.Zf.aX(i);
                awakenScrollBars();
            }
        }
    }

    public final void smoothScrollToPosition(int i) {
        if (!this.Zp && this.Zf != null) {
            this.Zf.a(this, i);
        }
    }

    public void scrollTo(int i, int i2) {
    }

    public void scrollBy(int i, int i2) {
        if (this.Zf != null && !this.Zp) {
            boolean eR = this.Zf.eR();
            boolean eS = this.Zf.eS();
            if (eR || eS) {
                if (!eR) {
                    i = 0;
                }
                if (!eS) {
                    i2 = 0;
                }
                a(i, i2, null);
            }
        }
    }

    private void fo() {
        boolean z = false;
        if (!this.Zm) {
            return;
        }
        if (this.Zv) {
            android.support.v4.os.e.beginSection("RV FullInvalidate");
            fG();
            android.support.v4.os.e.endSection();
        } else if (!this.YZ.et()) {
        } else {
            if (this.YZ.aH(4) && !this.YZ.aH(11)) {
                android.support.v4.os.e.beginSection("RV PartialInvalidate");
                fp();
                this.YZ.er();
                if (!this.Zo) {
                    int childCount = this.Za.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        t aZ = aZ(this.Za.getChildAt(i));
                        if (aZ != null && !aZ.gd() && aZ.gs()) {
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        fG();
                    } else {
                        this.YZ.es();
                    }
                }
                R(true);
                android.support.v4.os.e.endSection();
            } else if (this.YZ.et()) {
                android.support.v4.os.e.beginSection("RV FullInvalidate");
                fG();
                android.support.v4.os.e.endSection();
            }
        }
    }

    private boolean a(int i, int i2, MotionEvent motionEvent) {
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        fo();
        if (this.Ze != null) {
            fp();
            fz();
            android.support.v4.os.e.beginSection("RV Scroll");
            if (i != 0) {
                i5 = this.Zf.a(i, this.YX, this.ZL);
                i3 = i - i5;
            }
            if (i2 != 0) {
                i6 = this.Zf.b(i2, this.YX, this.ZL);
                i4 = i2 - i6;
            }
            android.support.v4.os.e.endSection();
            fM();
            fA();
            R(false);
        }
        int i7 = i4;
        i4 = i5;
        i5 = i6;
        if (!this.Zh.isEmpty()) {
            invalidate();
        }
        if (dispatchNestedScroll(i4, i5, i3, i7, this.Dd)) {
            this.ZF -= this.Dd[0];
            this.ZG -= this.Dd[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation((float) this.Dd[0], (float) this.Dd[1]);
            }
            int[] iArr = this.ZW;
            iArr[0] = iArr[0] + this.Dd[0];
            iArr = this.ZW;
            iArr[1] = iArr[1] + this.Dd[1];
        } else if (z.C(this) != 2) {
            if (motionEvent != null) {
                float x = motionEvent.getX();
                float f = (float) i3;
                float y = motionEvent.getY();
                float f2 = (float) i7;
                Object obj = null;
                if (f < 0.0f) {
                    fs();
                    if (this.Zx.h((-f) / ((float) getWidth()), 1.0f - (y / ((float) getHeight())))) {
                        obj = 1;
                    }
                } else if (f > 0.0f) {
                    ft();
                    if (this.Zz.h(f / ((float) getWidth()), y / ((float) getHeight()))) {
                        obj = 1;
                    }
                }
                if (f2 < 0.0f) {
                    fu();
                    if (this.Zy.h((-f2) / ((float) getHeight()), x / ((float) getWidth()))) {
                        obj = 1;
                    }
                } else if (f2 > 0.0f) {
                    fv();
                    if (this.ZA.h(f2 / ((float) getHeight()), 1.0f - (x / ((float) getWidth())))) {
                        obj = 1;
                    }
                }
                if (!(obj == null && f == 0.0f && f2 == 0.0f)) {
                    z.F(this);
                }
            }
            M(i, i2);
        }
        if (!(i4 == 0 && i5 == 0)) {
            O(i4, i5);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (i4 == 0 && i5 == 0) {
            return false;
        }
        return true;
    }

    public int computeHorizontalScrollOffset() {
        if (this.Zf != null && this.Zf.eR()) {
            return this.Zf.b(this.ZL);
        }
        return 0;
    }

    public int computeHorizontalScrollExtent() {
        if (this.Zf != null && this.Zf.eR()) {
            return this.Zf.d(this.ZL);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        if (this.Zf != null && this.Zf.eR()) {
            return this.Zf.f(this.ZL);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        if (this.Zf != null && this.Zf.eS()) {
            return this.Zf.c(this.ZL);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        if (this.Zf != null && this.Zf.eS()) {
            return this.Zf.e(this.ZL);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        if (this.Zf != null && this.Zf.eS()) {
            return this.Zf.g(this.ZL);
        }
        return 0;
    }

    final void fp() {
        this.Zn++;
        if (this.Zn == 1 && !this.Zp) {
            this.Zo = false;
        }
    }

    final void R(boolean z) {
        if (this.Zn <= 0) {
            this.Zn = 1;
        }
        if (!z) {
            this.Zo = false;
        }
        if (this.Zn == 1) {
            if (!(!z || !this.Zo || this.Zp || this.Zf == null || this.Ze == null)) {
                fG();
            }
            if (!this.Zp) {
                this.Zo = false;
            }
        }
        this.Zn--;
    }

    public final void S(boolean z) {
        if (z != this.Zp) {
            q("Do not setLayoutFrozen in layout or scroll");
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                this.Zp = true;
                this.Zq = true;
                fq();
                return;
            }
            this.Zp = false;
            if (!(!this.Zo || this.Zf == null || this.Ze == null)) {
                requestLayout();
            }
            this.Zo = false;
        }
    }

    private void fq() {
        X(0);
        fr();
    }

    private void fr() {
        this.ZK.stop();
        if (this.Zf != null) {
            this.Zf.fV();
        }
    }

    private void M(int i, int i2) {
        int i3 = 0;
        if (!(this.Zx == null || this.Zx.isFinished() || i <= 0)) {
            i3 = this.Zx.cr();
        }
        if (!(this.Zz == null || this.Zz.isFinished() || i >= 0)) {
            i3 |= this.Zz.cr();
        }
        if (!(this.Zy == null || this.Zy.isFinished() || i2 <= 0)) {
            i3 |= this.Zy.cr();
        }
        if (!(this.ZA == null || this.ZA.isFinished() || i2 >= 0)) {
            i3 |= this.ZA.cr();
        }
        if (i3 != 0) {
            z.F(this);
        }
    }

    final void fs() {
        if (this.Zx == null) {
            this.Zx = new android.support.v4.widget.i(getContext());
            if (this.Zc) {
                this.Zx.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.Zx.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    final void ft() {
        if (this.Zz == null) {
            this.Zz = new android.support.v4.widget.i(getContext());
            if (this.Zc) {
                this.Zz.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.Zz.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    final void fu() {
        if (this.Zy == null) {
            this.Zy = new android.support.v4.widget.i(getContext());
            if (this.Zc) {
                this.Zy.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.Zy.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    final void fv() {
        if (this.ZA == null) {
            this.ZA = new android.support.v4.widget.i(getContext());
            if (this.Zc) {
                this.ZA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.ZA.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    private void fw() {
        this.ZA = null;
        this.Zy = null;
        this.Zz = null;
        this.Zx = null;
    }

    public View focusSearch(View view, int i) {
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (!(findNextFocus != null || this.Ze == null || this.Zf == null || fC() || this.Zp)) {
            fp();
            findNextFocus = this.Zf.a(view, i, this.YX, this.ZL);
            R(false);
        }
        return findNextFocus != null ? findNextFocus : super.focusSearch(view, i);
    }

    public void requestChildFocus(View view, View view2) {
        int i = (this.Zf.fU() || fC()) ? 1 : 0;
        if (i == 0 && view2 != null) {
            this.eq.set(0, 0, view2.getWidth(), view2.getHeight());
            android.view.ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                if (!layoutParams2.aat) {
                    Rect rect = layoutParams2.WM;
                    Rect rect2 = this.eq;
                    rect2.left -= rect.left;
                    rect2 = this.eq;
                    rect2.right += rect.right;
                    rect2 = this.eq;
                    rect2.top -= rect.top;
                    rect2 = this.eq;
                    rect2.bottom = rect.bottom + rect2.bottom;
                }
            }
            offsetDescendantRectToMyCoords(view2, this.eq);
            offsetRectIntoDescendantCoords(view, this.eq);
            requestChildRectangleOnScreen(view, this.eq, !this.Zm);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        h hVar = this.Zf;
        int paddingLeft = hVar.getPaddingLeft();
        int paddingTop = hVar.getPaddingTop();
        int paddingRight = hVar.aar - hVar.getPaddingRight();
        int paddingBottom = hVar.RQ - hVar.getPaddingBottom();
        int left = (view.getLeft() + rect.left) - view.getScrollX();
        int top = (view.getTop() + rect.top) - view.getScrollY();
        int width = left + rect.width();
        int height = top + rect.height();
        int min = Math.min(0, left - paddingLeft);
        int min2 = Math.min(0, top - paddingTop);
        int max = Math.max(0, width - paddingRight);
        paddingBottom = Math.max(0, height - paddingBottom);
        if (z.J(hVar.aak) != 1) {
            max = min != 0 ? min : Math.min(left - paddingLeft, max);
        } else if (max == 0) {
            max = Math.max(min, width - paddingRight);
        }
        min = min2 != 0 ? min2 : Math.min(top - paddingTop, paddingBottom);
        if (max == 0 && min == 0) {
            return false;
        }
        if (z) {
            scrollBy(max, min);
        } else if (!(this.Zf == null || this.Zp)) {
            if (!this.Zf.eR()) {
                max = 0;
            }
            if (!this.Zf.eS()) {
                min = 0;
            }
            if (!(max == 0 && min == 0)) {
                this.ZK.smoothScrollBy(max, min);
            }
        }
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        super.addFocusables(arrayList, i, i2);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.Zw = 0;
        this.Zk = true;
        this.Zm = false;
        if (this.Zf != null) {
            this.Zf.hi = true;
        }
        this.ZR = false;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.ZB != null) {
            this.ZB.eL();
        }
        this.Zm = false;
        fq();
        this.Zk = false;
        if (this.Zf != null) {
            this.Zf.b(this, this.YX);
        }
        removeCallbacks(this.ZX);
        a.hf();
    }

    public boolean isAttachedToWindow() {
        return this.Zk;
    }

    final void q(String str) {
        if (!fC()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
        }
        throw new IllegalStateException(str);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i = -1;
        if (this.Zp) {
            return false;
        }
        int i2;
        boolean z;
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.Zj = null;
        }
        int size = this.Zi.size();
        for (i2 = 0; i2 < size; i2++) {
            j jVar = (j) this.Zi.get(i2);
            if (jVar.n(motionEvent) && action != 3) {
                this.Zj = jVar;
                z = true;
                break;
            }
        }
        z = false;
        if (z) {
            fy();
            return true;
        } else if (this.Zf == null) {
            return false;
        } else {
            z = this.Zf.eR();
            boolean eS = this.Zf.eS();
            if (this.fk == null) {
                this.fk = VelocityTracker.obtain();
            }
            this.fk.addMovement(motionEvent);
            action = android.support.v4.view.o.d(motionEvent);
            size = android.support.v4.view.o.e(motionEvent);
            int i3;
            switch (action) {
                case 0:
                    if (this.Zq) {
                        this.Zq = false;
                    }
                    this.ZC = android.support.v4.view.o.c(motionEvent, 0);
                    i = (int) (motionEvent.getX() + 0.5f);
                    this.ZF = i;
                    this.ZD = i;
                    i = (int) (motionEvent.getY() + 0.5f);
                    this.ZG = i;
                    this.ZE = i;
                    if (this.xV == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        X(1);
                    }
                    int[] iArr = this.ZW;
                    this.ZW[1] = 0;
                    iArr[0] = 0;
                    if (z) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    if (eS) {
                        i3 |= 2;
                    }
                    startNestedScroll(i3);
                    break;
                case 1:
                    this.fk.clear();
                    stopNestedScroll();
                    break;
                case 2:
                    action = android.support.v4.view.o.b(motionEvent, this.ZC);
                    if (action >= 0) {
                        size = (int) (android.support.v4.view.o.d(motionEvent, action) + 0.5f);
                        action = (int) (android.support.v4.view.o.e(motionEvent, action) + 0.5f);
                        if (this.xV != 1) {
                            size -= this.ZD;
                            action -= this.ZE;
                            if (!z || Math.abs(size) <= this.iE) {
                                z = false;
                            } else {
                                this.ZF = ((size < 0 ? -1 : 1) * this.iE) + this.ZD;
                                z = true;
                            }
                            if (eS && Math.abs(action) > this.iE) {
                                i3 = this.ZE;
                                i2 = this.iE;
                                if (action >= 0) {
                                    i = 1;
                                }
                                this.ZG = i3 + (i * i2);
                                z = true;
                            }
                            if (z) {
                                X(1);
                                break;
                            }
                        }
                    }
                    new StringBuilder("Error processing scroll; pointer index for id ").append(this.ZC).append(" not found. Did any MotionEvents get skipped?");
                    return false;
                    break;
                case 3:
                    fy();
                    break;
                case 5:
                    this.ZC = android.support.v4.view.o.c(motionEvent, size);
                    i3 = (int) (android.support.v4.view.o.d(motionEvent, size) + 0.5f);
                    this.ZF = i3;
                    this.ZD = i3;
                    i3 = (int) (android.support.v4.view.o.e(motionEvent, size) + 0.5f);
                    this.ZG = i3;
                    this.ZE = i3;
                    break;
                case 6:
                    m(motionEvent);
                    break;
            }
            if (this.xV != 1) {
                return false;
            }
            return true;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.Zi.size();
        for (int i = 0; i < size; i++) {
            ((j) this.Zi.get(i)).T(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r13) {
        /*
        r12 = this;
        r4 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r2 = 0;
        r11 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r8 = 1;
        r1 = 0;
        r0 = r12.Zp;
        if (r0 != 0) goto L_0x000f;
    L_0x000b:
        r0 = r12.Zq;
        if (r0 == 0) goto L_0x0010;
    L_0x000f:
        return r1;
    L_0x0010:
        r0 = r13.getAction();
        r3 = r12.Zj;
        if (r3 == 0) goto L_0x001d;
    L_0x0018:
        if (r0 != 0) goto L_0x0040;
    L_0x001a:
        r3 = 0;
        r12.Zj = r3;
    L_0x001d:
        if (r0 == 0) goto L_0x0053;
    L_0x001f:
        r0 = r12.Zi;
        r5 = r0.size();
        r3 = r1;
    L_0x0026:
        if (r3 >= r5) goto L_0x0053;
    L_0x0028:
        r0 = r12.Zi;
        r0 = r0.get(r3);
        r0 = (android.support.v7.widget.RecyclerView.j) r0;
        r6 = r0.n(r13);
        if (r6 == 0) goto L_0x004f;
    L_0x0036:
        r12.Zj = r0;
        r0 = r8;
    L_0x0039:
        if (r0 == 0) goto L_0x0055;
    L_0x003b:
        r12.fy();
        r1 = r8;
        goto L_0x000f;
    L_0x0040:
        r3 = r12.Zj;
        r3.o(r13);
        r3 = 3;
        if (r0 == r3) goto L_0x004a;
    L_0x0048:
        if (r0 != r8) goto L_0x004d;
    L_0x004a:
        r0 = 0;
        r12.Zj = r0;
    L_0x004d:
        r0 = r8;
        goto L_0x0039;
    L_0x004f:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x0026;
    L_0x0053:
        r0 = r1;
        goto L_0x0039;
    L_0x0055:
        r0 = r12.Zf;
        if (r0 == 0) goto L_0x000f;
    L_0x0059:
        r0 = r12.Zf;
        r5 = r0.eR();
        r0 = r12.Zf;
        r6 = r0.eS();
        r0 = r12.fk;
        if (r0 != 0) goto L_0x006f;
    L_0x0069:
        r0 = android.view.VelocityTracker.obtain();
        r12.fk = r0;
    L_0x006f:
        r9 = android.view.MotionEvent.obtain(r13);
        r0 = android.support.v4.view.o.d(r13);
        r3 = android.support.v4.view.o.e(r13);
        if (r0 != 0) goto L_0x0085;
    L_0x007d:
        r7 = r12.ZW;
        r10 = r12.ZW;
        r10[r8] = r1;
        r7[r1] = r1;
    L_0x0085:
        r7 = r12.ZW;
        r7 = r7[r1];
        r7 = (float) r7;
        r10 = r12.ZW;
        r10 = r10[r8];
        r10 = (float) r10;
        r9.offsetLocation(r7, r10);
        switch(r0) {
            case 0: goto L_0x00a2;
            case 1: goto L_0x01ab;
            case 2: goto L_0x00e2;
            case 3: goto L_0x0268;
            case 4: goto L_0x0095;
            case 5: goto L_0x00c7;
            case 6: goto L_0x01a6;
            default: goto L_0x0095;
        };
    L_0x0095:
        if (r1 != 0) goto L_0x009c;
    L_0x0097:
        r0 = r12.fk;
        r0.addMovement(r9);
    L_0x009c:
        r9.recycle();
        r1 = r8;
        goto L_0x000f;
    L_0x00a2:
        r0 = android.support.v4.view.o.c(r13, r1);
        r12.ZC = r0;
        r0 = r13.getX();
        r0 = r0 + r11;
        r0 = (int) r0;
        r12.ZF = r0;
        r12.ZD = r0;
        r0 = r13.getY();
        r0 = r0 + r11;
        r0 = (int) r0;
        r12.ZG = r0;
        r12.ZE = r0;
        if (r5 == 0) goto L_0x0272;
    L_0x00be:
        r0 = r8;
    L_0x00bf:
        if (r6 == 0) goto L_0x00c3;
    L_0x00c1:
        r0 = r0 | 2;
    L_0x00c3:
        r12.startNestedScroll(r0);
        goto L_0x0095;
    L_0x00c7:
        r0 = android.support.v4.view.o.c(r13, r3);
        r12.ZC = r0;
        r0 = android.support.v4.view.o.d(r13, r3);
        r0 = r0 + r11;
        r0 = (int) r0;
        r12.ZF = r0;
        r12.ZD = r0;
        r0 = android.support.v4.view.o.e(r13, r3);
        r0 = r0 + r11;
        r0 = (int) r0;
        r12.ZG = r0;
        r12.ZE = r0;
        goto L_0x0095;
    L_0x00e2:
        r0 = r12.ZC;
        r0 = android.support.v4.view.o.b(r13, r0);
        if (r0 >= 0) goto L_0x0100;
    L_0x00ea:
        r0 = new java.lang.StringBuilder;
        r2 = "Error processing scroll; pointer index for id ";
        r0.<init>(r2);
        r2 = r12.ZC;
        r0 = r0.append(r2);
        r2 = " not found. Did any MotionEvents get skipped?";
        r0.append(r2);
        goto L_0x000f;
    L_0x0100:
        r2 = android.support.v4.view.o.d(r13, r0);
        r2 = r2 + r11;
        r4 = (int) r2;
        r0 = android.support.v4.view.o.e(r13, r0);
        r0 = r0 + r11;
        r7 = (int) r0;
        r0 = r12.ZF;
        r2 = r0 - r4;
        r0 = r12.ZG;
        r0 = r0 - r7;
        r3 = r12.De;
        r10 = r12.Dd;
        r3 = r12.dispatchNestedPreScroll(r2, r0, r3, r10);
        if (r3 == 0) goto L_0x014a;
    L_0x011d:
        r3 = r12.De;
        r3 = r3[r1];
        r2 = r2 - r3;
        r3 = r12.De;
        r3 = r3[r8];
        r0 = r0 - r3;
        r3 = r12.Dd;
        r3 = r3[r1];
        r3 = (float) r3;
        r10 = r12.Dd;
        r10 = r10[r8];
        r10 = (float) r10;
        r9.offsetLocation(r3, r10);
        r3 = r12.ZW;
        r10 = r3[r1];
        r11 = r12.Dd;
        r11 = r11[r1];
        r10 = r10 + r11;
        r3[r1] = r10;
        r3 = r12.ZW;
        r10 = r3[r8];
        r11 = r12.Dd;
        r11 = r11[r8];
        r10 = r10 + r11;
        r3[r8] = r10;
    L_0x014a:
        r3 = r12.xV;
        if (r3 == r8) goto L_0x0173;
    L_0x014e:
        if (r5 == 0) goto L_0x026f;
    L_0x0150:
        r3 = java.lang.Math.abs(r2);
        r10 = r12.iE;
        if (r3 <= r10) goto L_0x026f;
    L_0x0158:
        if (r2 <= 0) goto L_0x019a;
    L_0x015a:
        r3 = r12.iE;
        r2 = r2 - r3;
    L_0x015d:
        r3 = r8;
    L_0x015e:
        if (r6 == 0) goto L_0x016e;
    L_0x0160:
        r10 = java.lang.Math.abs(r0);
        r11 = r12.iE;
        if (r10 <= r11) goto L_0x016e;
    L_0x0168:
        if (r0 <= 0) goto L_0x019e;
    L_0x016a:
        r3 = r12.iE;
        r0 = r0 - r3;
    L_0x016d:
        r3 = r8;
    L_0x016e:
        if (r3 == 0) goto L_0x0173;
    L_0x0170:
        r12.X(r8);
    L_0x0173:
        r3 = r12.xV;
        if (r3 != r8) goto L_0x0095;
    L_0x0177:
        r3 = r12.Dd;
        r3 = r3[r1];
        r3 = r4 - r3;
        r12.ZF = r3;
        r3 = r12.Dd;
        r3 = r3[r8];
        r3 = r7 - r3;
        r12.ZG = r3;
        if (r5 == 0) goto L_0x01a2;
    L_0x0189:
        if (r6 == 0) goto L_0x01a4;
    L_0x018b:
        r0 = r12.a(r2, r0, r9);
        if (r0 == 0) goto L_0x0095;
    L_0x0191:
        r0 = r12.getParent();
        r0.requestDisallowInterceptTouchEvent(r8);
        goto L_0x0095;
    L_0x019a:
        r3 = r12.iE;
        r2 = r2 + r3;
        goto L_0x015d;
    L_0x019e:
        r3 = r12.iE;
        r0 = r0 + r3;
        goto L_0x016d;
    L_0x01a2:
        r2 = r1;
        goto L_0x0189;
    L_0x01a4:
        r0 = r1;
        goto L_0x018b;
    L_0x01a6:
        r12.m(r13);
        goto L_0x0095;
    L_0x01ab:
        r0 = r12.fk;
        r0.addMovement(r9);
        r0 = r12.fk;
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r7 = r12.ZI;
        r7 = (float) r7;
        r0.computeCurrentVelocity(r3, r7);
        if (r5 == 0) goto L_0x025e;
    L_0x01bc:
        r0 = r12.fk;
        r3 = r12.ZC;
        r0 = android.support.v4.view.y.a(r0, r3);
        r0 = -r0;
        r3 = r0;
    L_0x01c6:
        if (r6 == 0) goto L_0x0261;
    L_0x01c8:
        r0 = r12.fk;
        r5 = r12.ZC;
        r0 = android.support.v4.view.y.b(r0, r5);
        r0 = -r0;
    L_0x01d1:
        r5 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1));
        if (r5 != 0) goto L_0x01d9;
    L_0x01d5:
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x0255;
    L_0x01d9:
        r2 = (int) r3;
        r0 = (int) r0;
        r3 = r12.Zf;
        if (r3 == 0) goto L_0x0266;
    L_0x01df:
        r3 = r12.Zp;
        if (r3 != 0) goto L_0x0266;
    L_0x01e3:
        r3 = r12.Zf;
        r5 = r3.eR();
        r3 = r12.Zf;
        r6 = r3.eS();
        if (r5 == 0) goto L_0x01f9;
    L_0x01f1:
        r3 = java.lang.Math.abs(r2);
        r7 = r12.ZH;
        if (r3 >= r7) goto L_0x01fa;
    L_0x01f9:
        r2 = r1;
    L_0x01fa:
        if (r6 == 0) goto L_0x0204;
    L_0x01fc:
        r3 = java.lang.Math.abs(r0);
        r7 = r12.ZH;
        if (r3 >= r7) goto L_0x026d;
    L_0x0204:
        r3 = r1;
    L_0x0205:
        if (r2 != 0) goto L_0x0209;
    L_0x0207:
        if (r3 == 0) goto L_0x0266;
    L_0x0209:
        r0 = (float) r2;
        r7 = (float) r3;
        r0 = r12.dispatchNestedPreFling(r0, r7);
        if (r0 != 0) goto L_0x0266;
    L_0x0211:
        if (r5 != 0) goto L_0x0215;
    L_0x0213:
        if (r6 == 0) goto L_0x0264;
    L_0x0215:
        r0 = r8;
    L_0x0216:
        r5 = (float) r2;
        r6 = (float) r3;
        r12.dispatchNestedFling(r5, r6, r0);
        if (r0 == 0) goto L_0x0266;
    L_0x021d:
        r0 = r12.ZI;
        r0 = -r0;
        r5 = r12.ZI;
        r2 = java.lang.Math.min(r2, r5);
        r2 = java.lang.Math.max(r0, r2);
        r0 = r12.ZI;
        r0 = -r0;
        r5 = r12.ZI;
        r3 = java.lang.Math.min(r3, r5);
        r3 = java.lang.Math.max(r0, r3);
        r10 = r12.ZK;
        r0 = r10.aaa;
        r5 = 2;
        r0.X(r5);
        r10.abc = r1;
        r10.abb = r1;
        r0 = r10.iB;
        r5 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r7 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r6 = r4;
        r0.a(r1, r2, r3, r4, r5, r6, r7);
        r10.ga();
        r0 = r8;
    L_0x0253:
        if (r0 != 0) goto L_0x0258;
    L_0x0255:
        r12.X(r1);
    L_0x0258:
        r12.fx();
        r1 = r8;
        goto L_0x0095;
    L_0x025e:
        r3 = r2;
        goto L_0x01c6;
    L_0x0261:
        r0 = r2;
        goto L_0x01d1;
    L_0x0264:
        r0 = r1;
        goto L_0x0216;
    L_0x0266:
        r0 = r1;
        goto L_0x0253;
    L_0x0268:
        r12.fy();
        goto L_0x0095;
    L_0x026d:
        r3 = r0;
        goto L_0x0205;
    L_0x026f:
        r3 = r1;
        goto L_0x015e;
    L_0x0272:
        r0 = r1;
        goto L_0x00bf;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private void fx() {
        if (this.fk != null) {
            this.fk.clear();
        }
        stopNestedScroll();
        int i = 0;
        if (this.Zx != null) {
            i = this.Zx.cr();
        }
        if (this.Zy != null) {
            i |= this.Zy.cr();
        }
        if (this.Zz != null) {
            i |= this.Zz.cr();
        }
        if (this.ZA != null) {
            i |= this.ZA.cr();
        }
        if (i != 0) {
            z.F(this);
        }
    }

    private void fy() {
        fx();
        X(0);
    }

    private void m(MotionEvent motionEvent) {
        int e = android.support.v4.view.o.e(motionEvent);
        if (android.support.v4.view.o.c(motionEvent, e) == this.ZC) {
            e = e == 0 ? 1 : 0;
            this.ZC = android.support.v4.view.o.c(motionEvent, e);
            int d = (int) (android.support.v4.view.o.d(motionEvent, e) + 0.5f);
            this.ZF = d;
            this.ZD = d;
            e = (int) (android.support.v4.view.o.e(motionEvent, e) + 0.5f);
            this.ZG = e;
            this.ZE = e;
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f = 0.0f;
        if (!(this.Zf == null || this.Zp || (android.support.v4.view.o.g(motionEvent) & 2) == 0 || motionEvent.getAction() != 8)) {
            float f2;
            float f3;
            if (this.Zf.eS()) {
                f2 = -android.support.v4.view.o.f(motionEvent, 9);
            } else {
                f2 = 0.0f;
            }
            if (this.Zf.eR()) {
                f3 = android.support.v4.view.o.f(motionEvent, 10);
            } else {
                f3 = 0.0f;
            }
            if (!(f2 == 0.0f && f3 == 0.0f)) {
                if (this.ZJ == Float.MIN_VALUE) {
                    TypedValue typedValue = new TypedValue();
                    if (getContext().getTheme().resolveAttribute(16842829, typedValue, true)) {
                        this.ZJ = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
                    }
                    a((int) (f3 * f), (int) (f2 * f), motionEvent);
                }
                f = this.ZJ;
                a((int) (f3 * f), (int) (f2 * f), motionEvent);
            }
        }
        return false;
    }

    protected void onMeasure(int i, int i2) {
        boolean z = false;
        if (this.Zf == null) {
            N(i, i2);
        } else if (this.Zf.aan) {
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            this.Zf.aa(i, i2);
            if (!z && this.Ze != null) {
                if (this.ZL.aaQ == 1) {
                    fH();
                }
                this.Zf.Y(i, i2);
                this.ZL.aba = true;
                fI();
                this.Zf.Z(i, i2);
                if (this.Zf.eX()) {
                    this.Zf.Y(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.ZL.aba = true;
                    fI();
                    this.Zf.Z(i, i2);
                }
            }
        } else if (this.Zl) {
            this.Zf.aa(i, i2);
        } else {
            if (this.Zs) {
                fp();
                fF();
                if (this.ZL.aaY) {
                    this.ZL.aaW = true;
                } else {
                    this.YZ.eu();
                    this.ZL.aaW = false;
                }
                this.Zs = false;
                R(false);
            }
            if (this.Ze != null) {
                this.ZL.aaS = this.Ze.getItemCount();
            } else {
                this.ZL.aaS = 0;
            }
            fp();
            this.Zf.aa(i, i2);
            R(false);
            this.ZL.aaW = false;
        }
    }

    final void N(int i, int i2) {
        setMeasuredDimension(h.j(i, getPaddingLeft() + getPaddingRight(), z.T(this)), h.j(i2, getPaddingTop() + getPaddingBottom(), z.U(this)));
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            fw();
        }
    }

    public final void a(e eVar) {
        if (this.ZB != null) {
            this.ZB.eL();
            this.ZB.aad = null;
        }
        this.ZB = eVar;
        if (this.ZB != null) {
            this.ZB.aad = this.ZQ;
        }
    }

    private void fz() {
        this.Zw++;
    }

    private void fA() {
        this.Zw--;
        if (this.Zw <= 0) {
            this.Zw = 0;
            int i = this.Zr;
            this.Zr = 0;
            if (i != 0 && fB()) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(2048);
                android.support.v4.view.a.a.a(obtain, i);
                sendAccessibilityEventUnchecked(obtain);
            }
        }
    }

    final boolean fB() {
        return this.jl != null && this.jl.isEnabled();
    }

    private boolean fC() {
        return this.Zw > 0;
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        int i = 0;
        if (fC()) {
            int b;
            if (accessibilityEvent != null) {
                b = android.support.v4.view.a.a.b(accessibilityEvent);
            } else {
                b = 0;
            }
            if (b != 0) {
                i = b;
            }
            this.Zr = i | this.Zr;
            i = 1;
        }
        if (i == 0) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    private void fD() {
        if (!this.ZR && this.Zk) {
            z.a((View) this, this.ZX);
            this.ZR = true;
        }
    }

    private boolean fE() {
        return this.ZB != null && this.Zf.eQ();
    }

    private void fF() {
        boolean z;
        boolean z2 = true;
        if (this.Zv) {
            this.YZ.reset();
            fL();
            this.Zf.eM();
        }
        if (fE()) {
            this.YZ.er();
        } else {
            this.YZ.eu();
        }
        boolean z3;
        if (this.ZO || this.ZP) {
            z3 = true;
        } else {
            z3 = false;
        }
        q qVar = this.ZL;
        if (!this.Zm || this.ZB == null || (!(this.Zv || r0 || this.Zf.aam) || (this.Zv && !this.Ze.aac))) {
            z = false;
        } else {
            z = true;
        }
        qVar.aaX = z;
        q qVar2 = this.ZL;
        if (!(this.ZL.aaX && r0 && !this.Zv && fE())) {
            z2 = false;
        }
        qVar2.aaY = z2;
    }

    private void fG() {
        if (this.Ze != null && this.Zf != null) {
            boolean z;
            int i;
            int i2;
            this.ZL.aba = false;
            if (this.ZL.aaQ == 1) {
                fH();
                this.Zf.z(this);
                fI();
            } else {
                e eVar = this.YZ;
                if (eVar.Ud.isEmpty() || eVar.Uc.isEmpty()) {
                    z = false;
                } else {
                    i = 1;
                }
                if (i == 0 && this.Zf.aar == getWidth() && this.Zf.RQ == getHeight()) {
                    this.Zf.z(this);
                } else {
                    this.Zf.z(this);
                    fI();
                }
            }
            this.ZL.bn(4);
            fp();
            fz();
            this.ZL.aaQ = 1;
            if (this.ZL.aaX) {
                for (int childCount = this.Za.getChildCount() - 1; childCount >= 0; childCount--) {
                    t aZ = aZ(this.Za.getChildAt(childCount));
                    if (!aZ.gd()) {
                        long g = g(aZ);
                        c b = new c().b(aZ, 0);
                        t tVar = (t) this.Zb.afF.get(g);
                        if (!(tVar == null || tVar.gd())) {
                            boolean u = this.Zb.u(tVar);
                            boolean u2 = this.Zb.u(aZ);
                            if (!(u && tVar == aZ)) {
                                c c = this.Zb.c(tVar, 4);
                                this.Zb.c(aZ, b);
                                b = this.Zb.c(aZ, 8);
                                if (c == null) {
                                    int childCount2 = this.Za.getChildCount();
                                    i2 = 0;
                                    while (i2 < childCount2) {
                                        t aZ2 = aZ(this.Za.getChildAt(i2));
                                        if (aZ2 == aZ || g(aZ2) != g) {
                                            i2++;
                                        } else if (this.Ze == null || !this.Ze.aac) {
                                            throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + aZ2 + " \n View Holder 2:" + aZ);
                                        } else {
                                            throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + aZ2 + " \n View Holder 2:" + aZ);
                                        }
                                    }
                                    new StringBuilder("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ").append(tVar).append(" cannot be found but it is necessary for ").append(aZ);
                                } else {
                                    tVar.U(false);
                                    if (u) {
                                        f(tVar);
                                    }
                                    if (tVar != aZ) {
                                        if (u2) {
                                            f(aZ);
                                        }
                                        tVar.abk = aZ;
                                        f(tVar);
                                        this.YX.p(tVar);
                                        aZ.U(false);
                                        aZ.abl = tVar;
                                    }
                                    if (this.ZB.a(tVar, aZ, c, b)) {
                                        fD();
                                    }
                                }
                            }
                        }
                        this.Zb.c(aZ, b);
                    }
                }
                this.Zb.a(this.ZZ);
            }
            this.Zf.c(this.YX);
            this.ZL.aaT = this.ZL.aaS;
            this.Zv = false;
            this.ZL.aaX = false;
            this.ZL.aaY = false;
            this.Zf.aam = false;
            if (this.YX.aaz != null) {
                this.YX.aaz.clear();
            }
            fA();
            R(false);
            this.Zb.clear();
            i = this.ZU[0];
            i2 = this.ZU[1];
            if (this.Za.getChildCount() == 0) {
                z = (i == 0 && i2 == 0) ? false : true;
            } else {
                d(this.ZU);
                z = (this.ZU[0] == i && this.ZU[1] == i2) ? false : true;
            }
            if (z) {
                O(0, 0);
            }
        }
    }

    private void fH() {
        int childCount;
        int i;
        t aZ;
        this.ZL.bn(1);
        this.ZL.aba = false;
        fp();
        this.Zb.clear();
        fz();
        fF();
        q qVar = this.ZL;
        boolean z = this.ZL.aaX && this.ZP;
        qVar.aaZ = z;
        this.ZP = false;
        this.ZO = false;
        this.ZL.aaW = this.ZL.aaY;
        this.ZL.aaS = this.Ze.getItemCount();
        d(this.ZU);
        if (this.ZL.aaX) {
            childCount = this.Za.getChildCount();
            for (i = 0; i < childCount; i++) {
                aZ = aZ(this.Za.getChildAt(i));
                if (!aZ.gd() && (!aZ.gl() || this.Ze.aac)) {
                    this.Zb.b(aZ, this.ZB.a(this.ZL, aZ, e.j(aZ), aZ.gp()));
                    if (!(!this.ZL.aaZ || !aZ.gs() || aZ.isRemoved() || aZ.gd() || aZ.gl())) {
                        this.Zb.a(g(aZ), aZ);
                    }
                }
            }
        }
        if (this.ZL.aaY) {
            childCount = this.Za.eG();
            for (i = 0; i < childCount; i++) {
                aZ = aZ(this.Za.aN(i));
                if (!aZ.gd() && aZ.abg == -1) {
                    aZ.abg = aZ.kC;
                }
            }
            z = this.ZL.aaV;
            this.ZL.aaV = false;
            this.Zf.c(this.YX, this.ZL);
            this.ZL.aaV = z;
            for (childCount = 0; childCount < this.Za.getChildCount(); childCount++) {
                aZ = aZ(this.Za.getChildAt(childCount));
                if (!aZ.gd()) {
                    a aVar = (a) this.Zb.afE.get(aZ);
                    if (aVar == null || (aVar.flags & 4) == 0) {
                        z = false;
                    } else {
                        i = 1;
                    }
                    if (i == 0) {
                        i = e.j(aZ);
                        boolean bo = aZ.bo(8192);
                        if (!bo) {
                            i |= Downloads.RECV_BUFFER_SIZE;
                        }
                        c a = this.ZB.a(this.ZL, aZ, i, aZ.gp());
                        if (bo) {
                            a(aZ, a);
                        } else {
                            as asVar = this.Zb;
                            aVar = (a) asVar.afE.get(aZ);
                            if (aVar == null) {
                                aVar = a.he();
                                asVar.afE.put(aZ, aVar);
                            }
                            aVar.flags |= 2;
                            aVar.afG = a;
                        }
                    }
                }
            }
            fK();
        } else {
            fK();
        }
        fA();
        R(false);
        this.ZL.aaQ = 2;
    }

    private void fI() {
        boolean z;
        fp();
        fz();
        this.ZL.bn(6);
        this.YZ.eu();
        this.ZL.aaS = this.Ze.getItemCount();
        this.ZL.aaU = 0;
        this.ZL.aaW = false;
        this.Zf.c(this.YX, this.ZL);
        this.ZL.aaV = false;
        this.YY = null;
        q qVar = this.ZL;
        if (!this.ZL.aaX || this.ZB == null) {
            z = false;
        } else {
            z = true;
        }
        qVar.aaX = z;
        this.ZL.aaQ = 4;
        fA();
        R(false);
    }

    private void a(t tVar, c cVar) {
        tVar.setFlags(0, 8192);
        if (this.ZL.aaZ && tVar.gs() && !tVar.isRemoved() && !tVar.gd()) {
            this.Zb.a(g(tVar), tVar);
        }
        this.Zb.b(tVar, cVar);
    }

    private void d(int[] iArr) {
        int childCount = this.Za.getChildCount();
        if (childCount == 0) {
            iArr[0] = 0;
            iArr[1] = 0;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        int i3 = 0;
        while (i3 < childCount) {
            int ge;
            t aZ = aZ(this.Za.getChildAt(i3));
            if (!aZ.gd()) {
                ge = aZ.ge();
                if (ge < i) {
                    i = ge;
                }
                if (ge > i2) {
                    i2 = i;
                    i3++;
                    i = i2;
                    i2 = ge;
                }
            }
            ge = i2;
            i2 = i;
            i3++;
            i = i2;
            i2 = ge;
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    protected void removeDetachedView(View view, boolean z) {
        t aZ = aZ(view);
        if (aZ != null) {
            if (aZ.gn()) {
                aZ.gk();
            } else if (!aZ.gd()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + aZ);
            }
        }
        bd(view);
        super.removeDetachedView(view, z);
    }

    private long g(t tVar) {
        return this.Ze.aac ? tVar.abh : (long) tVar.kC;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        android.support.v4.os.e.beginSection("RV OnLayout");
        fG();
        android.support.v4.os.e.endSection();
        this.Zm = true;
    }

    public void requestLayout() {
        if (this.Zn != 0 || this.Zp) {
            this.Zo = true;
        } else {
            super.requestLayout();
        }
    }

    public final void fJ() {
        int i = 0;
        int eG = this.Za.eG();
        for (int i2 = 0; i2 < eG; i2++) {
            ((LayoutParams) this.Za.aN(i2).getLayoutParams()).aat = true;
        }
        m mVar = this.YX;
        eG = mVar.aaA.size();
        while (i < eG) {
            LayoutParams layoutParams = (LayoutParams) ((t) mVar.aaA.get(i)).abf.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.aat = true;
            }
            i++;
        }
    }

    public void draw(Canvas canvas) {
        int i;
        int i2;
        int i3 = 1;
        int i4 = 0;
        super.draw(canvas);
        int size = this.Zh.size();
        for (i = 0; i < size; i++) {
            ((g) this.Zh.get(i)).b(canvas, this);
        }
        if (this.Zx == null || this.Zx.isFinished()) {
            i2 = 0;
        } else {
            i = canvas.save();
            i2 = this.Zc ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) (i2 + (-getHeight())), 0.0f);
            if (this.Zx == null || !this.Zx.draw(canvas)) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            canvas.restoreToCount(i);
        }
        if (!(this.Zy == null || this.Zy.isFinished())) {
            size = canvas.save();
            if (this.Zc) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            if (this.Zy == null || !this.Zy.draw(canvas)) {
                i = 0;
            } else {
                i = 1;
            }
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.Zz == null || this.Zz.isFinished())) {
            size = canvas.save();
            int width = getWidth();
            if (this.Zc) {
                i = getPaddingTop();
            } else {
                i = 0;
            }
            canvas.rotate(90.0f);
            canvas.translate((float) (-i), (float) (-width));
            if (this.Zz == null || !this.Zz.draw(canvas)) {
                i = 0;
            } else {
                i = 1;
            }
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.ZA == null || this.ZA.isFinished())) {
            i = canvas.save();
            canvas.rotate(180.0f);
            if (this.Zc) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            if (this.ZA != null && this.ZA.draw(canvas)) {
                i4 = 1;
            }
            i2 |= i4;
            canvas.restoreToCount(i);
        }
        if (i2 != 0 || this.ZB == null || this.Zh.size() <= 0 || !this.ZB.isRunning()) {
            i3 = i2;
        }
        if (i3 != 0) {
            z.F(this);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.Zh.size();
        for (int i = 0; i < size; i++) {
            ((g) this.Zh.get(i)).a(canvas, this);
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.Zf.a((LayoutParams) layoutParams);
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        if (this.Zf != null) {
            return this.Zf.eN();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.Zf != null) {
            return this.Zf.a(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (this.Zf != null) {
            return this.Zf.e(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    private void fK() {
        int i = 0;
        int eG = this.Za.eG();
        for (int i2 = 0; i2 < eG; i2++) {
            t aZ = aZ(this.Za.aN(i2));
            if (!aZ.gd()) {
                aZ.gb();
            }
        }
        m mVar = this.YX;
        int size = mVar.aaA.size();
        for (eG = 0; eG < size; eG++) {
            ((t) mVar.aaA.get(eG)).gb();
        }
        size = mVar.aay.size();
        for (eG = 0; eG < size; eG++) {
            ((t) mVar.aay.get(eG)).gb();
        }
        if (mVar.aaz != null) {
            eG = mVar.aaz.size();
            while (i < eG) {
                ((t) mVar.aaz.get(i)).gb();
                i++;
            }
        }
    }

    final void d(int i, int i2, boolean z) {
        int i3 = i + i2;
        int eG = this.Za.eG();
        for (int i4 = 0; i4 < eG; i4++) {
            t aZ = aZ(this.Za.aN(i4));
            if (!(aZ == null || aZ.gd())) {
                if (aZ.kC >= i3) {
                    aZ.p(-i2, z);
                    this.ZL.aaV = true;
                } else if (aZ.kC >= i) {
                    int i5 = i - 1;
                    int i6 = -i2;
                    aZ.addFlags(8);
                    aZ.p(i6, z);
                    aZ.kC = i5;
                    this.ZL.aaV = true;
                }
            }
        }
        m mVar = this.YX;
        int i7 = i + i2;
        for (i3 = mVar.aaA.size() - 1; i3 >= 0; i3--) {
            t tVar = (t) mVar.aaA.get(i3);
            if (tVar != null) {
                if (tVar.kC >= i7) {
                    tVar.p(-i2, z);
                } else if (tVar.kC >= i) {
                    tVar.addFlags(8);
                    mVar.bl(i3);
                }
            }
        }
        requestLayout();
    }

    private void fL() {
        int i;
        int eG = this.Za.eG();
        for (i = 0; i < eG; i++) {
            t aZ = aZ(this.Za.aN(i));
            if (!(aZ == null || aZ.gd())) {
                aZ.addFlags(6);
            }
        }
        fJ();
        m mVar = this.YX;
        if (mVar.aaa.Ze == null || !mVar.aaa.Ze.aac) {
            mVar.fW();
            return;
        }
        int size = mVar.aaA.size();
        for (i = 0; i < size; i++) {
            t tVar = (t) mVar.aaA.get(i);
            if (tVar != null) {
                tVar.addFlags(6);
                tVar.R(null);
            }
        }
    }

    public final t aQ(View view) {
        Object parent = view.getParent();
        if (parent == null || parent == this) {
            return aZ(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    static t aZ(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).aas;
    }

    public static int ba(View view) {
        t aZ = aZ(view);
        return aZ != null ? aZ.gf() : -1;
    }

    public static int bb(View view) {
        t aZ = aZ(view);
        return aZ != null ? aZ.ge() : -1;
    }

    public final t bb(int i) {
        if (this.Zv) {
            return null;
        }
        int eG = this.Za.eG();
        for (int i2 = 0; i2 < eG; i2++) {
            t aZ = aZ(this.Za.aN(i2));
            if (aZ != null && !aZ.isRemoved() && h(aZ) == i) {
                return aZ;
            }
        }
        return null;
    }

    public final View j(float f, float f2) {
        for (int childCount = this.Za.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.Za.getChildAt(childCount);
            float R = z.R(childAt);
            float S = z.S(childAt);
            if (f >= ((float) childAt.getLeft()) + R && f <= R + ((float) childAt.getRight()) && f2 >= ((float) childAt.getTop()) + S && f2 <= ((float) childAt.getBottom()) + S) {
                return childAt;
            }
        }
        return null;
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    final Rect bc(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.aat) {
            return layoutParams.WM;
        }
        Rect rect = layoutParams.WM;
        rect.set(0, 0, 0, 0);
        int size = this.Zh.size();
        for (int i = 0; i < size; i++) {
            this.eq.set(0, 0, 0, 0);
            ((g) this.Zh.get(i)).a(this.eq, view, this);
            rect.left += this.eq.left;
            rect.top += this.eq.top;
            rect.right += this.eq.right;
            rect.bottom += this.eq.bottom;
        }
        layoutParams.aat = false;
        return rect;
    }

    final void O(int i, int i2) {
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        if (this.ZM != null) {
            this.ZM.c(this, i, i2);
        }
        if (this.ZN != null) {
            for (scrollY = this.ZN.size() - 1; scrollY >= 0; scrollY--) {
                ((k) this.ZN.get(scrollY)).c(this, i, i2);
            }
        }
    }

    private void fM() {
        int childCount = this.Za.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.Za.getChildAt(i);
            t aQ = aQ(childAt);
            if (!(aQ == null || aQ.abl == null)) {
                View view = aQ.abl.abf;
                int left = childAt.getLeft();
                int top = childAt.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    private void bd(View view) {
        aZ(view);
        if (this.Zu != null) {
            for (int size = this.Zu.size() - 1; size >= 0; size--) {
                ((i) this.Zu.get(size)).bm(view);
            }
        }
    }

    private int h(t tVar) {
        if (tVar.bo(524) || !tVar.isBound()) {
            return -1;
        }
        e eVar = this.YZ;
        int i = tVar.kC;
        int size = eVar.Uc.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = (b) eVar.Uc.get(i2);
            switch (bVar.ou) {
                case 1:
                    if (bVar.Uj > i) {
                        break;
                    }
                    i += bVar.Ul;
                    break;
                case 2:
                    if (bVar.Uj <= i) {
                        if (bVar.Uj + bVar.Ul <= i) {
                            i -= bVar.Ul;
                            break;
                        }
                        return -1;
                    }
                    continue;
                case 8:
                    if (bVar.Uj != i) {
                        if (bVar.Uj < i) {
                            i--;
                        }
                        if (bVar.Ul > i) {
                            break;
                        }
                        i++;
                        break;
                    }
                    i = bVar.Ul;
                    break;
                default:
                    break;
            }
        }
        return i;
    }

    public void setNestedScrollingEnabled(boolean z) {
        fN().setNestedScrollingEnabled(z);
    }

    public boolean isNestedScrollingEnabled() {
        return fN().xk;
    }

    public boolean startNestedScroll(int i) {
        return fN().startNestedScroll(i);
    }

    public void stopNestedScroll() {
        fN().stopNestedScroll();
    }

    public boolean hasNestedScrollingParent() {
        return fN().hasNestedScrollingParent();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return fN().dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return fN().dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return fN().dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return fN().dispatchNestedPreFling(f, f2);
    }

    public int getChildDrawingOrder(int i, int i2) {
        if (this.ZT == null) {
            return super.getChildDrawingOrder(i, i2);
        }
        return this.ZT.X(i, i2);
    }

    private android.support.v4.view.q fN() {
        if (this.ZV == null) {
            this.ZV = new android.support.v4.view.q(this);
        }
        return this.ZV;
    }
}
