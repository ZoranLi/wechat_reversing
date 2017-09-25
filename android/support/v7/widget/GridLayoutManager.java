package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.a.b.l;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.q;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

public final class GridLayoutManager extends LinearLayoutManager {
    boolean WF = false;
    public int WG = -1;
    int[] WH;
    View[] WI;
    final SparseIntArray WJ = new SparseIntArray();
    final SparseIntArray WK = new SparseIntArray();
    public b WL = new a();
    final Rect WM = new Rect();

    public static abstract class b {
        final SparseIntArray WP = new SparseIntArray();
        private boolean WQ = false;

        public abstract int aT(int i);

        final int E(int i, int i2) {
            if (!this.WQ) {
                return D(i, i2);
            }
            int i3 = this.WP.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            i3 = D(i, i2);
            this.WP.put(i, i3);
            return i3;
        }

        public int D(int i, int i2) {
            int aT = aT(i);
            if (aT == i2) {
                return 0;
            }
            int size;
            int i3;
            int i4;
            if (this.WQ && this.WP.size() > 0) {
                size = this.WP.size() - 1;
                i3 = 0;
                while (i3 <= size) {
                    i4 = (i3 + size) >>> 1;
                    if (this.WP.keyAt(i4) < i) {
                        i3 = i4 + 1;
                    } else {
                        size = i4 - 1;
                    }
                }
                size = i3 - 1;
                size = (size < 0 || size >= this.WP.size()) ? -1 : this.WP.keyAt(size);
                if (size >= 0) {
                    i3 = this.WP.get(size) + aT(size);
                    size++;
                    i4 = size;
                    while (i4 < i) {
                        size = aT(i4);
                        i3 += size;
                        if (i3 == i2) {
                            size = 0;
                        } else if (i3 <= i2) {
                            size = i3;
                        }
                        i4++;
                        i3 = size;
                    }
                    if (i3 + aT > i2) {
                        return i3;
                    }
                    return 0;
                }
            }
            size = 0;
            i3 = 0;
            i4 = size;
            while (i4 < i) {
                size = aT(i4);
                i3 += size;
                if (i3 == i2) {
                    size = 0;
                } else if (i3 <= i2) {
                    size = i3;
                }
                i4++;
                i3 = size;
            }
            if (i3 + aT > i2) {
                return 0;
            }
            return i3;
        }

        public final int F(int i, int i2) {
            int aT = aT(i);
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i3 < i) {
                int aT2 = aT(i3);
                i5 += aT2;
                if (i5 == i2) {
                    i4++;
                    aT2 = 0;
                } else if (i5 > i2) {
                    i4++;
                } else {
                    aT2 = i5;
                }
                i3++;
                i5 = aT2;
            }
            if (i5 + aT > i2) {
                return i4 + 1;
            }
            return i4;
        }
    }

    public static class LayoutParams extends android.support.v7.widget.RecyclerView.LayoutParams {
        int WN = -1;
        int WO = 0;

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
    }

    public static final class a extends b {
        public final int aT(int i) {
            return 1;
        }

        public final int D(int i, int i2) {
            return i % i2;
        }
    }

    public GridLayoutManager(Context context, int i) {
        aS(i);
    }

    public GridLayoutManager() {
        super(1, false);
        aS(4);
    }

    public final int a(m mVar, q qVar) {
        if (this.Xd == 0) {
            return this.WG;
        }
        if (qVar.getItemCount() <= 0) {
            return 0;
        }
        return a(mVar, qVar, qVar.getItemCount() - 1) + 1;
    }

    public final int b(m mVar, q qVar) {
        if (this.Xd == 1) {
            return this.WG;
        }
        if (qVar.getItemCount() <= 0) {
            return 0;
        }
        return a(mVar, qVar, qVar.getItemCount() - 1) + 1;
    }

    public final void a(m mVar, q qVar, View view, android.support.v4.view.a.b bVar) {
        boolean z = false;
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            int a = a(mVar, qVar, layoutParams2.aas.ge());
            int i;
            int i2;
            if (this.Xd == 0) {
                i = layoutParams2.WN;
                i2 = layoutParams2.WO;
                boolean z2 = this.WG > 1 && layoutParams2.WO == this.WG;
                bVar.k(l.a(i, i2, a, 1, z2));
                return;
            }
            i = layoutParams2.WN;
            i2 = layoutParams2.WO;
            if (this.WG > 1 && layoutParams2.WO == this.WG) {
                z = true;
            }
            bVar.k(l.a(a, 1, i, i2, z));
            return;
        }
        super.b(view, bVar);
    }

    public final void c(m mVar, q qVar) {
        if (qVar.aaW) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
                int ge = layoutParams.aas.ge();
                this.WJ.put(ge, layoutParams.WO);
                this.WK.put(ge, layoutParams.WN);
            }
        }
        super.c(mVar, qVar);
        this.WJ.clear();
        this.WK.clear();
        if (!qVar.aaW) {
            this.WF = false;
        }
    }

    public final void z(int i, int i2) {
        this.WL.WP.clear();
    }

    public final void eM() {
        this.WL.WP.clear();
    }

    public final void A(int i, int i2) {
        this.WL.WP.clear();
    }

    public final void B(int i, int i2) {
        this.WL.WP.clear();
    }

    public final void C(int i, int i2) {
        this.WL.WP.clear();
    }

    public final android.support.v7.widget.RecyclerView.LayoutParams eN() {
        if (this.Xd == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    public final android.support.v7.widget.RecyclerView.LayoutParams a(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public final android.support.v7.widget.RecyclerView.LayoutParams e(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public final boolean a(android.support.v7.widget.RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    private void eO() {
        int paddingRight;
        if (this.Xd == 1) {
            paddingRight = (this.aar - getPaddingRight()) - getPaddingLeft();
        } else {
            paddingRight = (this.RQ - getPaddingBottom()) - getPaddingTop();
        }
        aR(paddingRight);
    }

    public final void a(Rect rect, int i, int i2) {
        if (this.WH == null) {
            super.a(rect, i, i2);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.Xd == 1) {
            paddingTop = h.j(i2, paddingTop + rect.height(), z.U(this.aak));
            paddingLeft = h.j(i, paddingLeft + this.WH[this.WH.length - 1], z.T(this.aak));
        } else {
            paddingLeft = h.j(i, paddingLeft + rect.width(), z.T(this.aak));
            paddingTop = h.j(i2, paddingTop + this.WH[this.WH.length - 1], z.U(this.aak));
        }
        setMeasuredDimension(paddingLeft, paddingTop);
    }

    private void aR(int i) {
        int i2 = 0;
        int[] iArr = this.WH;
        int i3 = this.WG;
        if (!(iArr != null && iArr.length == i3 + 1 && iArr[iArr.length - 1] == i)) {
            iArr = new int[(i3 + 1)];
        }
        iArr[0] = 0;
        int i4 = i / i3;
        int i5 = i % i3;
        int i6 = 0;
        for (int i7 = 1; i7 <= i3; i7++) {
            int i8;
            i2 += i5;
            if (i2 <= 0 || i3 - i2 >= i5) {
                i8 = i4;
            } else {
                i8 = i4 + 1;
                i2 -= i3;
            }
            i6 += i8;
            iArr[i7] = i6;
        }
        this.WH = iArr;
    }

    final void a(m mVar, q qVar, a aVar, int i) {
        Object obj = 1;
        super.a(mVar, qVar, aVar, i);
        eO();
        if (qVar.getItemCount() > 0 && !qVar.aaW) {
            if (i != 1) {
                obj = null;
            }
            int b = b(mVar, qVar, aVar.kC);
            if (obj != null) {
                while (b > 0 && aVar.kC > 0) {
                    aVar.kC--;
                    b = b(mVar, qVar, aVar.kC);
                }
            } else {
                int itemCount = qVar.getItemCount() - 1;
                int i2 = aVar.kC;
                while (i2 < itemCount) {
                    int b2 = b(mVar, qVar, i2 + 1);
                    if (b2 <= b) {
                        break;
                    }
                    i2++;
                    b = b2;
                }
                aVar.kC = i2;
            }
        }
        eP();
    }

    private void eP() {
        if (this.WI == null || this.WI.length != this.WG) {
            this.WI = new View[this.WG];
        }
    }

    public final int a(int i, m mVar, q qVar) {
        eO();
        eP();
        return super.a(i, mVar, qVar);
    }

    public final int b(int i, m mVar, q qVar) {
        eO();
        eP();
        return super.b(i, mVar, qVar);
    }

    final View a(m mVar, q qVar, int i, int i2, int i3) {
        int i4;
        View view = null;
        eV();
        int fj = this.Xp.fj();
        int fk = this.Xp.fk();
        if (i2 > i) {
            i4 = 1;
        } else {
            i4 = -1;
        }
        View view2 = null;
        while (i != i2) {
            View view3;
            View childAt = getChildAt(i);
            int be = h.be(childAt);
            if (be >= 0 && be < i3 && b(mVar, qVar, be) == 0) {
                if (((android.support.v7.widget.RecyclerView.LayoutParams) childAt.getLayoutParams()).aas.isRemoved()) {
                    if (view2 == null) {
                        view3 = view;
                        i += i4;
                        view = view3;
                        view2 = childAt;
                    }
                } else if (this.Xp.aV(childAt) < fk && this.Xp.aW(childAt) >= fj) {
                    return childAt;
                } else {
                    if (view == null) {
                        view3 = childAt;
                        childAt = view2;
                        i += i4;
                        view = view3;
                        view2 = childAt;
                    }
                }
            }
            view3 = view;
            childAt = view2;
            i += i4;
            view = view3;
            view2 = childAt;
        }
        return view != null ? view : view2;
    }

    private int a(m mVar, q qVar, int i) {
        if (!qVar.aaW) {
            return this.WL.F(i, this.WG);
        }
        int bj = mVar.bj(i);
        if (bj == -1) {
            return 0;
        }
        return this.WL.F(bj, this.WG);
    }

    private int b(m mVar, q qVar, int i) {
        if (!qVar.aaW) {
            return this.WL.E(i, this.WG);
        }
        int i2 = this.WK.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = mVar.bj(i);
        if (i2 == -1) {
            return 0;
        }
        return this.WL.E(i2, this.WG);
    }

    private int c(m mVar, q qVar, int i) {
        if (!qVar.aaW) {
            return this.WL.aT(i);
        }
        int i2 = this.WJ.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = mVar.bj(i);
        if (i2 == -1) {
            return 1;
        }
        return this.WL.aT(i2);
    }

    final void a(m mVar, q qVar, c cVar, b bVar) {
        boolean z;
        int i;
        View a;
        int fm = this.Xp.fm();
        Object obj = fm != 1073741824 ? 1 : null;
        int i2 = getChildCount() > 0 ? this.WH[this.WG] : 0;
        if (obj != null) {
            eO();
        }
        if (cVar.WU == 1) {
            z = true;
        } else {
            z = false;
        }
        int i3 = this.WG;
        if (z) {
            i = 0;
        } else {
            i3 = b(mVar, qVar, cVar.WT) + c(mVar, qVar, cVar.WT);
            i = 0;
        }
        while (i < this.WG && cVar.k(qVar) && i3 > 0) {
            int i4 = cVar.WT;
            int c = c(mVar, qVar, i4);
            if (c <= this.WG) {
                i3 -= c;
                if (i3 < 0) {
                    break;
                }
                a = cVar.a(mVar);
                if (a == null) {
                    break;
                }
                this.WI[i] = a;
                i++;
            } else {
                throw new IllegalArgumentException("Item at position " + i4 + " requires " + c + " spans but GridLayoutManager has only " + this.WG + " spans.");
            }
        }
        if (i == 0) {
            bVar.mFinished = true;
            return;
        }
        int b;
        int i5;
        int i6;
        int i7 = 0;
        float f = 0.0f;
        a(mVar, qVar, i, z);
        int i8 = 0;
        while (i8 < i) {
            a = this.WI[i8];
            if (cVar.XJ == null) {
                if (z) {
                    super.c(a, -1, false);
                } else {
                    super.c(a, 0, false);
                }
            } else if (z) {
                super.c(a, -1, true);
            } else {
                super.c(a, 0, true);
            }
            LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
            c = h.b(this.WH[layoutParams.WN + layoutParams.WO] - this.WH[layoutParams.WN], fm, 0, this.Xd == 0 ? layoutParams.height : layoutParams.width, false);
            b = h.b(this.Xp.fl(), this.Xp.getMode(), 0, this.Xd == 1 ? layoutParams.height : layoutParams.width, true);
            if (this.Xd == 1) {
                a(a, c, b, layoutParams.height == -1, false);
            } else {
                a(a, b, c, layoutParams.width == -1, false);
            }
            i3 = this.Xp.aX(a);
            if (i3 <= i7) {
                i3 = i7;
            }
            float aY = (((float) this.Xp.aY(a)) * 1.0f) / ((float) layoutParams.WO);
            if (aY <= f) {
                aY = f;
            }
            i8++;
            f = aY;
            i7 = i3;
        }
        if (obj != null) {
            aR(Math.max(Math.round(((float) this.WG) * f), i2));
            i5 = 0;
            i6 = 0;
            while (i6 < i) {
                a = this.WI[i6];
                LayoutParams layoutParams2 = (LayoutParams) a.getLayoutParams();
                c = h.b(this.WH[layoutParams2.WN + layoutParams2.WO] - this.WH[layoutParams2.WN], 1073741824, 0, this.Xd == 0 ? layoutParams2.height : layoutParams2.width, false);
                b = h.b(this.Xp.fl(), this.Xp.getMode(), 0, this.Xd == 1 ? layoutParams2.height : layoutParams2.width, true);
                if (this.Xd == 1) {
                    a(a, c, b, false, true);
                } else {
                    a(a, b, c, false, true);
                }
                i3 = this.Xp.aX(a);
                if (i3 <= i5) {
                    i3 = i5;
                }
                i6++;
                i5 = i3;
            }
        } else {
            i5 = i7;
        }
        b = MeasureSpec.makeMeasureSpec(i5, 1073741824);
        for (i6 = 0; i6 < i; i6++) {
            a = this.WI[i6];
            if (this.Xp.aX(a) != i5) {
                layoutParams2 = (LayoutParams) a.getLayoutParams();
                c = h.b(this.WH[layoutParams2.WN + layoutParams2.WO] - this.WH[layoutParams2.WN], 1073741824, 0, this.Xd == 0 ? layoutParams2.height : layoutParams2.width, false);
                if (this.Xd == 1) {
                    a(a, c, b, true, true);
                } else {
                    a(a, b, c, true, true);
                }
            }
        }
        bVar.XD = i5;
        b = 0;
        c = 0;
        i4 = 0;
        i3 = 0;
        if (this.Xd == 1) {
            if (cVar.WV == -1) {
                i3 = cVar.wa;
                i4 = i3 - i5;
            } else {
                i4 = cVar.wa;
                i3 = i4 + i5;
            }
        } else if (cVar.WV == -1) {
            c = cVar.wa;
            b = c - i5;
        } else {
            b = cVar.wa;
            c = b + i5;
        }
        int i9 = b;
        b = c;
        c = i4;
        i4 = i3;
        for (int i10 = 0; i10 < i; i10++) {
            View view = this.WI[i10];
            layoutParams2 = (LayoutParams) view.getLayoutParams();
            if (this.Xd != 1) {
                c = this.WH[layoutParams2.WN] + getPaddingTop();
                i4 = this.Xp.aY(view) + c;
            } else if (eU()) {
                b = getPaddingLeft() + this.WH[layoutParams2.WN + layoutParams2.WO];
                i9 = b - this.Xp.aY(view);
            } else {
                i9 = this.WH[layoutParams2.WN] + getPaddingLeft();
                b = this.Xp.aY(view) + i9;
            }
            h.g(view, layoutParams2.leftMargin + i9, layoutParams2.topMargin + c, b - layoutParams2.rightMargin, i4 - layoutParams2.bottomMargin);
            if (layoutParams2.aas.isRemoved() || layoutParams2.aas.gs()) {
                bVar.XE = true;
            }
            bVar.OE |= view.isFocusable();
        }
        Arrays.fill(this.WI, null);
    }

    private void a(View view, int i, int i2, boolean z, boolean z2) {
        a(view, this.WM);
        android.support.v7.widget.RecyclerView.LayoutParams layoutParams = (android.support.v7.widget.RecyclerView.LayoutParams) view.getLayoutParams();
        if (z || this.Xd == 1) {
            i = i(i, layoutParams.leftMargin + this.WM.left, layoutParams.rightMargin + this.WM.right);
        }
        if (z || this.Xd == 0) {
            i2 = i(i2, layoutParams.topMargin + this.WM.top, layoutParams.bottomMargin + this.WM.bottom);
        }
        boolean a = z2 ? (this.aao && h.k(view.getMeasuredWidth(), i, layoutParams.width) && h.k(view.getMeasuredHeight(), i2, layoutParams.height)) ? false : true : a(view, i, i2, layoutParams);
        if (a) {
            view.measure(i, i2);
        }
    }

    private static int i(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return MeasureSpec.makeMeasureSpec(Math.max(0, (MeasureSpec.getSize(i) - i2) - i3), mode);
        }
        return i;
    }

    private void a(m mVar, q qVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (z) {
            i2 = 1;
            i3 = 0;
        } else {
            i3 = i - 1;
            i2 = -1;
            i = -1;
        }
        if (this.Xd == 1 && eU()) {
            i4 = this.WG - 1;
            i5 = i3;
            i6 = -1;
        } else {
            i4 = 0;
            i5 = i3;
            i6 = 1;
        }
        while (i5 != i) {
            View view = this.WI[i5];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.WO = c(mVar, qVar, h.be(view));
            if (i6 != -1 || layoutParams.WO <= 1) {
                layoutParams.WN = i4;
            } else {
                layoutParams.WN = i4 - (layoutParams.WO - 1);
            }
            i5 += i2;
            i4 = (layoutParams.WO * i6) + i4;
        }
    }

    public final void aS(int i) {
        if (i != this.WG) {
            this.WF = true;
            if (i <= 0) {
                throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
            }
            this.WG = i;
            this.WL.WP.clear();
        }
    }

    public final View a(View view, int i, m mVar, q qVar) {
        View bf = bf(view);
        if (bf == null) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) bf.getLayoutParams();
        int a = layoutParams.WN;
        int a2 = layoutParams.WN + layoutParams.WO;
        if (super.a(view, i, mVar, qVar) == null) {
            return null;
        }
        int childCount;
        int i2;
        int i3;
        if (((aY(i) == 1) != this.Xs ? 1 : null) != null) {
            childCount = getChildCount() - 1;
            i2 = -1;
            i3 = -1;
        } else {
            childCount = 0;
            i2 = 1;
            i3 = getChildCount();
        }
        Object obj = (this.Xd == 1 && eU()) ? 1 : null;
        View view2 = null;
        int i4 = -1;
        int i5 = 0;
        int i6 = childCount;
        while (i6 != i3) {
            View childAt = getChildAt(i6);
            if (childAt == bf) {
                break;
            }
            View view3;
            if (childAt.isFocusable()) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                int a3 = layoutParams.WN;
                int a4 = layoutParams.WN + layoutParams.WO;
                if (a3 == a && a4 == a2) {
                    return childAt;
                }
                Object obj2 = null;
                if (view2 == null) {
                    obj2 = 1;
                } else {
                    int min = Math.min(a4, a2) - Math.max(a3, a);
                    if (min > i5) {
                        obj2 = 1;
                    } else if (min == i5) {
                        if (obj == (a3 > i4 ? 1 : null)) {
                            obj2 = 1;
                        }
                    }
                }
                if (obj2 != null) {
                    i5 = layoutParams.WN;
                    childCount = Math.min(a4, a2) - Math.max(a3, a);
                    view3 = childAt;
                    view2 = view3;
                    i6 += i2;
                    i4 = i5;
                    i5 = childCount;
                }
            }
            childCount = i5;
            i5 = i4;
            view3 = view2;
            view2 = view3;
            i6 += i2;
            i4 = i5;
            i5 = childCount;
        }
        return view2;
    }

    public final boolean eQ() {
        return this.Xy == null && !this.WF;
    }
}
