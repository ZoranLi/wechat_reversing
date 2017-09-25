package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.a.b.l;
import android.support.v4.view.a.f;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.p;
import android.support.v7.widget.RecyclerView.q;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public final class StaggeredGridLayoutManager extends h {
    private int WG;
    public int Xd;
    public boolean Xr;
    boolean Xs;
    private boolean Xu;
    int Xv;
    int Xw;
    private b[] acY;
    ab acZ;
    ab ada;
    private int adb;
    private final y adc;
    private BitSet add;
    LazySpanLookup ade;
    private int adf;
    private boolean adg;
    private boolean adh;
    private SavedState adi;
    private int adj;
    private final a adk;
    private boolean adl;
    private final Runnable adm;
    private final Rect gG;

    static class LazySpanLookup {
        List<FullSpanItem> adr;
        int[] mData;

        static class FullSpanItem implements Parcelable {
            public static final Creator<FullSpanItem> CREATOR = new Creator<FullSpanItem>() {
                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new FullSpanItem[i];
                }
            };
            int ads;
            int[] adt;
            boolean adu;
            int kC;

            public FullSpanItem(Parcel parcel) {
                boolean z = true;
                this.kC = parcel.readInt();
                this.ads = parcel.readInt();
                if (parcel.readInt() != 1) {
                    z = false;
                }
                this.adu = z;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.adt = new int[readInt];
                    parcel.readIntArray(this.adt);
                }
            }

            final int bB(int i) {
                return this.adt == null ? 0 : this.adt[i];
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.kC);
                parcel.writeInt(this.ads);
                parcel.writeInt(this.adu ? 1 : 0);
                if (this.adt == null || this.adt.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(this.adt.length);
                parcel.writeIntArray(this.adt);
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.kC + ", mGapDir=" + this.ads + ", mHasUnwantedGapAfter=" + this.adu + ", mGapPerSpan=" + Arrays.toString(this.adt) + '}';
            }
        }

        final int bx(int i) {
            if (this.adr != null) {
                for (int size = this.adr.size() - 1; size >= 0; size--) {
                    if (((FullSpanItem) this.adr.get(size)).kC >= i) {
                        this.adr.remove(size);
                    }
                }
            }
            return by(i);
        }

        final int by(int i) {
            if (this.mData == null) {
                return -1;
            }
            if (i >= this.mData.length) {
                return -1;
            }
            int i2;
            if (this.adr != null) {
                FullSpanItem bA = bA(i);
                if (bA != null) {
                    this.adr.remove(bA);
                }
                int size = this.adr.size();
                int i3 = 0;
                while (i3 < size) {
                    if (((FullSpanItem) this.adr.get(i3)).kC >= i) {
                        break;
                    }
                    i3++;
                }
                i3 = -1;
                if (i3 != -1) {
                    bA = (FullSpanItem) this.adr.get(i3);
                    this.adr.remove(i3);
                    i2 = bA.kC;
                    if (i2 != -1) {
                        Arrays.fill(this.mData, i, this.mData.length, -1);
                        return this.mData.length;
                    }
                    Arrays.fill(this.mData, i, i2 + 1, -1);
                    return i2 + 1;
                }
            }
            i2 = -1;
            if (i2 != -1) {
                Arrays.fill(this.mData, i, i2 + 1, -1);
                return i2 + 1;
            }
            Arrays.fill(this.mData, i, this.mData.length, -1);
            return this.mData.length;
        }

        final void bz(int i) {
            if (this.mData == null) {
                this.mData = new int[(Math.max(i, 10) + 1)];
                Arrays.fill(this.mData, -1);
            } else if (i >= this.mData.length) {
                Object obj = this.mData;
                int length = this.mData.length;
                while (length <= i) {
                    length *= 2;
                }
                this.mData = new int[length];
                System.arraycopy(obj, 0, this.mData, 0, obj.length);
                Arrays.fill(this.mData, obj.length, this.mData.length, -1);
            }
        }

        final void clear() {
            if (this.mData != null) {
                Arrays.fill(this.mData, -1);
            }
            this.adr = null;
        }

        final void ae(int i, int i2) {
            if (this.mData != null && i < this.mData.length) {
                bz(i + i2);
                System.arraycopy(this.mData, i + i2, this.mData, i, (this.mData.length - i) - i2);
                Arrays.fill(this.mData, this.mData.length - i2, this.mData.length, -1);
                if (this.adr != null) {
                    int i3 = i + i2;
                    for (int size = this.adr.size() - 1; size >= 0; size--) {
                        FullSpanItem fullSpanItem = (FullSpanItem) this.adr.get(size);
                        if (fullSpanItem.kC >= i) {
                            if (fullSpanItem.kC < i3) {
                                this.adr.remove(size);
                            } else {
                                fullSpanItem.kC -= i2;
                            }
                        }
                    }
                }
            }
        }

        final void af(int i, int i2) {
            if (this.mData != null && i < this.mData.length) {
                bz(i + i2);
                System.arraycopy(this.mData, i, this.mData, i + i2, (this.mData.length - i) - i2);
                Arrays.fill(this.mData, i, i + i2, -1);
                if (this.adr != null) {
                    for (int size = this.adr.size() - 1; size >= 0; size--) {
                        FullSpanItem fullSpanItem = (FullSpanItem) this.adr.get(size);
                        if (fullSpanItem.kC >= i) {
                            fullSpanItem.kC += i2;
                        }
                    }
                }
            }
        }

        public final void a(FullSpanItem fullSpanItem) {
            if (this.adr == null) {
                this.adr = new ArrayList();
            }
            int size = this.adr.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = (FullSpanItem) this.adr.get(i);
                if (fullSpanItem2.kC == fullSpanItem.kC) {
                    this.adr.remove(i);
                }
                if (fullSpanItem2.kC >= fullSpanItem.kC) {
                    this.adr.add(i, fullSpanItem);
                    return;
                }
            }
            this.adr.add(fullSpanItem);
        }

        public final FullSpanItem bA(int i) {
            if (this.adr == null) {
                return null;
            }
            for (int size = this.adr.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.adr.get(size);
                if (fullSpanItem.kC == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public final FullSpanItem n(int i, int i2, int i3) {
            if (this.adr == null) {
                return null;
            }
            int size = this.adr.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.adr.get(i4);
                if (fullSpanItem.kC >= i2) {
                    return null;
                }
                if (fullSpanItem.kC >= i && (i3 == 0 || fullSpanItem.ads == i3 || fullSpanItem.adu)) {
                    return fullSpanItem;
                }
            }
            return null;
        }
    }

    public static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int XK;
        boolean XM;
        boolean Xr;
        boolean adh;
        List<FullSpanItem> adr;
        int adv;
        int adw;
        int[] adx;
        int ady;
        int[] adz;

        SavedState(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            this.XK = parcel.readInt();
            this.adv = parcel.readInt();
            this.adw = parcel.readInt();
            if (this.adw > 0) {
                this.adx = new int[this.adw];
                parcel.readIntArray(this.adx);
            }
            this.ady = parcel.readInt();
            if (this.ady > 0) {
                this.adz = new int[this.ady];
                parcel.readIntArray(this.adz);
            }
            this.Xr = parcel.readInt() == 1;
            if (parcel.readInt() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.XM = z;
            if (parcel.readInt() != 1) {
                z2 = false;
            }
            this.adh = z2;
            this.adr = parcel.readArrayList(FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.adw = savedState.adw;
            this.XK = savedState.XK;
            this.adv = savedState.adv;
            this.adx = savedState.adx;
            this.ady = savedState.ady;
            this.adz = savedState.adz;
            this.Xr = savedState.Xr;
            this.XM = savedState.XM;
            this.adh = savedState.adh;
            this.adr = savedState.adr;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            int i3 = 1;
            parcel.writeInt(this.XK);
            parcel.writeInt(this.adv);
            parcel.writeInt(this.adw);
            if (this.adw > 0) {
                parcel.writeIntArray(this.adx);
            }
            parcel.writeInt(this.ady);
            if (this.ady > 0) {
                parcel.writeIntArray(this.adz);
            }
            if (this.Xr) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (this.XM) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (!this.adh) {
                i3 = 0;
            }
            parcel.writeInt(i3);
            parcel.writeList(this.adr);
        }
    }

    private class a {
        boolean XC;
        final /* synthetic */ StaggeredGridLayoutManager adn;
        boolean ado;
        int kC;
        int wa;
    }

    class b {
        public ArrayList<View> adA;
        int adB;
        int adC;
        int adD;
        final /* synthetic */ StaggeredGridLayoutManager adn;
        final int mIndex;

        final int bC(int i) {
            if (this.adB != Integer.MIN_VALUE) {
                return this.adB;
            }
            if (this.adA.size() == 0) {
                return i;
            }
            gM();
            return this.adB;
        }

        private void gM() {
            View view = (View) this.adA.get(0);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            this.adB = this.adn.acZ.aV(view);
            if (layoutParams.adq) {
                FullSpanItem bA = this.adn.ade.bA(layoutParams.aas.ge());
                if (bA != null && bA.ads == -1) {
                    this.adB -= bA.bB(this.mIndex);
                }
            }
        }

        final int gN() {
            if (this.adB != Integer.MIN_VALUE) {
                return this.adB;
            }
            gM();
            return this.adB;
        }

        final int bD(int i) {
            if (this.adC != Integer.MIN_VALUE) {
                return this.adC;
            }
            if (this.adA.size() == 0) {
                return i;
            }
            gO();
            return this.adC;
        }

        private void gO() {
            View view = (View) this.adA.get(this.adA.size() - 1);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            this.adC = this.adn.acZ.aW(view);
            if (layoutParams.adq) {
                FullSpanItem bA = this.adn.ade.bA(layoutParams.aas.ge());
                if (bA != null && bA.ads == 1) {
                    this.adC = bA.bB(this.mIndex) + this.adC;
                }
            }
        }

        final int gP() {
            if (this.adC != Integer.MIN_VALUE) {
                return this.adC;
            }
            gO();
            return this.adC;
        }

        final void bq(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.adp = this;
            this.adA.add(0, view);
            this.adB = Integer.MIN_VALUE;
            if (this.adA.size() == 1) {
                this.adC = Integer.MIN_VALUE;
            }
            if (layoutParams.aas.isRemoved() || layoutParams.aas.gs()) {
                this.adD += this.adn.acZ.aX(view);
            }
        }

        final void br(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.adp = this;
            this.adA.add(view);
            this.adC = Integer.MIN_VALUE;
            if (this.adA.size() == 1) {
                this.adB = Integer.MIN_VALUE;
            }
            if (layoutParams.aas.isRemoved() || layoutParams.aas.gs()) {
                this.adD += this.adn.acZ.aX(view);
            }
        }

        final void clear() {
            this.adA.clear();
            this.adB = Integer.MIN_VALUE;
            this.adC = Integer.MIN_VALUE;
            this.adD = 0;
        }

        final void bE(int i) {
            this.adB = i;
            this.adC = i;
        }

        final void gQ() {
            int size = this.adA.size();
            View view = (View) this.adA.remove(size - 1);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.adp = null;
            if (layoutParams.aas.isRemoved() || layoutParams.aas.gs()) {
                this.adD -= this.adn.acZ.aX(view);
            }
            if (size == 1) {
                this.adB = Integer.MIN_VALUE;
            }
            this.adC = Integer.MIN_VALUE;
        }

        final void gR() {
            View view = (View) this.adA.remove(0);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.adp = null;
            if (this.adA.size() == 0) {
                this.adC = Integer.MIN_VALUE;
            }
            if (layoutParams.aas.isRemoved() || layoutParams.aas.gs()) {
                this.adD -= this.adn.acZ.aX(view);
            }
            this.adB = Integer.MIN_VALUE;
        }

        final void bF(int i) {
            if (this.adB != Integer.MIN_VALUE) {
                this.adB += i;
            }
            if (this.adC != Integer.MIN_VALUE) {
                this.adC += i;
            }
        }

        public final View ag(int i, int i2) {
            View view = null;
            int size;
            View view2;
            if (i2 == -1) {
                size = this.adA.size();
                int i3 = 0;
                while (i3 < size) {
                    view2 = (View) this.adA.get(i3);
                    if (!view2.isFocusable()) {
                        break;
                    }
                    boolean z;
                    if (h.be(view2) > i) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z != this.adn.Xr) {
                        break;
                    }
                    i3++;
                    view = view2;
                }
                return view;
            }
            for (size = this.adA.size() - 1; size >= 0; size--) {
                view2 = (View) this.adA.get(size);
                if (!view2.isFocusable()) {
                    break;
                }
                Object obj;
                if (h.be(view2) > i) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != (!this.adn.Xr ? 1 : null)) {
                    break;
                }
                view = view2;
            }
            return view;
        }
    }

    public static class LayoutParams extends android.support.v7.widget.RecyclerView.LayoutParams {
        b adp;
        boolean adq;

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

        public final int gL() {
            if (this.adp == null) {
                return -1;
            }
            return this.adp.mIndex;
        }
    }

    private boolean gH() {
        if (getChildCount() == 0 || this.adf == 0 || !this.hi) {
            return false;
        }
        int gJ;
        int gK;
        if (this.Xs) {
            gJ = gJ();
            gK = gK();
        } else {
            gJ = gK();
            gK = gJ();
        }
        if (gJ == 0 && gI() != null) {
            this.ade.clear();
            this.aam = true;
            requestLayout();
            return true;
        } else if (!this.adl) {
            return false;
        } else {
            int i = this.Xs ? -1 : 1;
            FullSpanItem n = this.ade.n(gJ, gK + 1, i);
            if (n == null) {
                this.adl = false;
                this.ade.bx(gK + 1);
                return false;
            }
            FullSpanItem n2 = this.ade.n(gJ, n.kC, i * -1);
            if (n2 == null) {
                this.ade.bx(n.kC);
            } else {
                this.ade.bx(n2.kC + 1);
            }
            this.aam = true;
            requestLayout();
            return true;
        }
    }

    public final void bi(int i) {
        if (i == 0) {
            gH();
        }
    }

    public final void a(RecyclerView recyclerView, m mVar) {
        removeCallbacks(this.adm);
        for (int i = 0; i < this.WG; i++) {
            this.acY[i].clear();
        }
    }

    private View gI() {
        int i;
        int i2;
        int childCount = getChildCount() - 1;
        BitSet bitSet = new BitSet(this.WG);
        bitSet.set(0, this.WG, true);
        boolean z = (this.Xd == 1 && eU()) ? true : true;
        if (this.Xs) {
            i = -1;
        } else {
            i = childCount + 1;
            childCount = 0;
        }
        if (childCount < i) {
            i2 = 1;
        } else {
            i2 = -1;
        }
        int i3 = childCount;
        while (i3 != i) {
            boolean z2;
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (bitSet.get(layoutParams.adp.mIndex)) {
                b bVar = layoutParams.adp;
                if (this.Xs) {
                    if (bVar.gP() < this.acZ.fk()) {
                        z2 = !((LayoutParams) ((View) bVar.adA.get(bVar.adA.size() + -1)).getLayoutParams()).adq;
                    }
                    z2 = false;
                } else {
                    if (bVar.gN() > this.acZ.fj()) {
                        z2 = !((LayoutParams) ((View) bVar.adA.get(0)).getLayoutParams()).adq;
                    }
                    z2 = false;
                }
                if (z2) {
                    return childAt;
                }
                bitSet.clear(layoutParams.adp.mIndex);
            }
            if (!(layoutParams.adq || i3 + i2 == i)) {
                View childAt2 = getChildAt(i3 + i2);
                int aW;
                if (this.Xs) {
                    childCount = this.acZ.aW(childAt);
                    aW = this.acZ.aW(childAt2);
                    if (childCount < aW) {
                        return childAt;
                    }
                    if (childCount == aW) {
                        z2 = true;
                    }
                    z2 = false;
                } else {
                    childCount = this.acZ.aV(childAt);
                    aW = this.acZ.aV(childAt2);
                    if (childCount > aW) {
                        return childAt;
                    }
                    if (childCount == aW) {
                        z2 = true;
                    }
                    z2 = false;
                }
                if (z2) {
                    boolean z3;
                    if (layoutParams.adp.mIndex - ((LayoutParams) childAt2.getLayoutParams()).adp.mIndex < 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z >= false) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z2 != z3) {
                        return childAt;
                    }
                } else {
                    continue;
                }
            }
            i3 += i2;
        }
        return null;
    }

    public final void q(String str) {
        if (this.adi == null) {
            super.q(str);
        }
    }

    private void eT() {
        boolean z = true;
        if (this.Xd == 1 || !eU()) {
            z = this.Xr;
        } else if (this.Xr) {
            z = false;
        }
        this.Xs = z;
    }

    private boolean eU() {
        return z.J(this.aak) == 1;
    }

    public final void a(Rect rect, int i, int i2) {
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.Xd == 1) {
            paddingTop = h.j(i2, paddingTop + rect.height(), z.U(this.aak));
            paddingLeft = h.j(i, paddingLeft + (this.adb * this.WG), z.T(this.aak));
        } else {
            paddingLeft = h.j(i, paddingLeft + rect.width(), z.T(this.aak));
            paddingTop = h.j(i2, paddingTop + (this.adb * this.WG), z.U(this.aak));
        }
        setMeasuredDimension(paddingLeft, paddingTop);
    }

    public final void c(m mVar, q qVar) {
        Object obj = 1;
        while (true) {
            a aVar = this.adk;
            aVar.kC = -1;
            aVar.wa = Integer.MIN_VALUE;
            aVar.XC = false;
            aVar.ado = false;
            if (!(this.adi == null && this.Xv == -1) && qVar.getItemCount() == 0) {
                d(mVar);
                return;
            }
            int i;
            int i2;
            Object obj2;
            int childCount;
            int i3;
            if (this.adi != null) {
                if (this.adi.adw > 0) {
                    if (this.adi.adw == this.WG) {
                        for (i = 0; i < this.WG; i++) {
                            this.acY[i].clear();
                            i2 = this.adi.adx[i];
                            if (i2 != Integer.MIN_VALUE) {
                                i2 = this.adi.XM ? i2 + this.acZ.fk() : i2 + this.acZ.fj();
                            }
                            this.acY[i].bE(i2);
                        }
                    } else {
                        SavedState savedState = this.adi;
                        savedState.adx = null;
                        savedState.adw = 0;
                        savedState.ady = 0;
                        savedState.adz = null;
                        savedState.adr = null;
                        this.adi.XK = this.adi.adv;
                    }
                }
                this.adh = this.adi.adh;
                boolean z = this.adi.Xr;
                q(null);
                if (!(this.adi == null || this.adi.Xr == z)) {
                    this.adi.Xr = z;
                }
                this.Xr = z;
                requestLayout();
                eT();
                if (this.adi.XK != -1) {
                    this.Xv = this.adi.XK;
                    aVar.XC = this.adi.XM;
                } else {
                    aVar.XC = this.Xs;
                }
                if (this.adi.ady > 1) {
                    this.ade.mData = this.adi.adz;
                    this.ade.adr = this.adi.adr;
                }
            } else {
                eT();
                aVar.XC = this.Xs;
            }
            if (qVar.aaW || this.Xv == -1) {
                obj2 = null;
            } else if (this.Xv < 0 || this.Xv >= qVar.getItemCount()) {
                this.Xv = -1;
                this.Xw = Integer.MIN_VALUE;
                obj2 = null;
            } else {
                if (this.adi == null || this.adi.XK == -1 || this.adi.adw <= 0) {
                    View aV = aV(this.Xv);
                    if (aV != null) {
                        aVar.kC = this.Xs ? gJ() : gK();
                        if (this.Xw != Integer.MIN_VALUE) {
                            if (aVar.XC) {
                                aVar.wa = (this.acZ.fk() - this.Xw) - this.acZ.aW(aV);
                            } else {
                                aVar.wa = (this.acZ.fj() + this.Xw) - this.acZ.aV(aV);
                            }
                            obj2 = 1;
                        } else if (this.acZ.aX(aV) > this.acZ.fl()) {
                            aVar.wa = aVar.XC ? this.acZ.fk() : this.acZ.fj();
                        } else {
                            i = this.acZ.aV(aV) - this.acZ.fj();
                            if (i < 0) {
                                aVar.wa = -i;
                            } else {
                                i = this.acZ.fk() - this.acZ.aW(aV);
                                if (i < 0) {
                                    aVar.wa = i;
                                } else {
                                    aVar.wa = Integer.MIN_VALUE;
                                }
                            }
                        }
                    } else {
                        aVar.kC = this.Xv;
                        if (this.Xw == Integer.MIN_VALUE) {
                            aVar.XC = bw(aVar.kC) == 1;
                            aVar.wa = aVar.XC ? aVar.adn.acZ.fk() : aVar.adn.acZ.fj();
                        } else {
                            i = this.Xw;
                            if (aVar.XC) {
                                aVar.wa = aVar.adn.acZ.fk() - i;
                            } else {
                                aVar.wa = i + aVar.adn.acZ.fj();
                            }
                        }
                        aVar.ado = true;
                    }
                } else {
                    aVar.wa = Integer.MIN_VALUE;
                    aVar.kC = this.Xv;
                }
                obj2 = 1;
            }
            if (obj2 == null) {
                int itemCount;
                if (this.adg) {
                    itemCount = qVar.getItemCount();
                    for (i2 = getChildCount() - 1; i2 >= 0; i2--) {
                        i = h.be(getChildAt(i2));
                        if (i >= 0 && i < itemCount) {
                            break;
                        }
                    }
                    i = 0;
                } else {
                    itemCount = qVar.getItemCount();
                    childCount = getChildCount();
                    for (i2 = 0; i2 < childCount; i2++) {
                        i = h.be(getChildAt(i2));
                        if (i >= 0 && i < itemCount) {
                            break;
                        }
                    }
                    i = 0;
                }
                aVar.kC = i;
                aVar.wa = Integer.MIN_VALUE;
            }
            if (this.adi == null && !(aVar.XC == this.adg && eU() == this.adh)) {
                this.ade.clear();
                aVar.ado = true;
            }
            if (getChildCount() > 0 && (this.adi == null || this.adi.adw <= 0)) {
                if (aVar.ado) {
                    for (i = 0; i < this.WG; i++) {
                        this.acY[i].clear();
                        if (aVar.wa != Integer.MIN_VALUE) {
                            this.acY[i].bE(aVar.wa);
                        }
                    }
                } else {
                    for (i2 = 0; i2 < this.WG; i2++) {
                        b bVar = this.acY[i2];
                        boolean z2 = this.Xs;
                        i3 = aVar.wa;
                        i = z2 ? bVar.bD(Integer.MIN_VALUE) : bVar.bC(Integer.MIN_VALUE);
                        bVar.clear();
                        if (i != Integer.MIN_VALUE && ((!z2 || i >= bVar.adn.acZ.fk()) && (z2 || i <= bVar.adn.acZ.fj()))) {
                            if (i3 != Integer.MIN_VALUE) {
                                i += i3;
                            }
                            bVar.adC = i;
                            bVar.adB = i;
                        }
                    }
                }
            }
            b(mVar);
            this.adc.WR = false;
            this.adl = false;
            br(this.ada.fl());
            a(aVar.kC, qVar);
            if (aVar.XC) {
                bs(-1);
                a(mVar, this.adc, qVar);
                bs(1);
                this.adc.WT = aVar.kC + this.adc.WU;
                a(mVar, this.adc, qVar);
            } else {
                bs(1);
                a(mVar, this.adc, qVar);
                bs(-1);
                this.adc.WT = aVar.kC + this.adc.WU;
                a(mVar, this.adc, qVar);
            }
            if (this.ada.getMode() != 1073741824) {
                float f = 0.0f;
                i3 = getChildCount();
                childCount = 0;
                while (childCount < i3) {
                    float max;
                    View childAt = getChildAt(childCount);
                    float aX = (float) this.ada.aX(childAt);
                    if (aX >= f) {
                        max = Math.max(f, ((LayoutParams) childAt.getLayoutParams()).adq ? (1.0f * aX) / ((float) this.WG) : aX);
                    } else {
                        max = f;
                    }
                    childCount++;
                    f = max;
                }
                childCount = this.adb;
                i = Math.round(((float) this.WG) * f);
                if (this.ada.getMode() == Integer.MIN_VALUE) {
                    i = Math.min(i, this.ada.fl());
                }
                br(i);
                if (this.adb != childCount) {
                    for (i2 = 0; i2 < i3; i2++) {
                        View childAt2 = getChildAt(i2);
                        LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
                        if (!layoutParams.adq) {
                            if (eU() && this.Xd == 1) {
                                childAt2.offsetLeftAndRight(((-((this.WG - 1) - layoutParams.adp.mIndex)) * this.adb) - ((-((this.WG - 1) - layoutParams.adp.mIndex)) * childCount));
                            } else {
                                int i4 = layoutParams.adp.mIndex * this.adb;
                                i = layoutParams.adp.mIndex * childCount;
                                if (this.Xd == 1) {
                                    childAt2.offsetLeftAndRight(i4 - i);
                                } else {
                                    childAt2.offsetTopAndBottom(i4 - i);
                                }
                            }
                        }
                    }
                }
            }
            if (getChildCount() > 0) {
                if (this.Xs) {
                    a(mVar, qVar, true);
                    b(mVar, qVar, false);
                } else {
                    b(mVar, qVar, true);
                    a(mVar, qVar, false);
                }
            }
            obj2 = null;
            if (!(obj == null || qVar.aaW)) {
                obj = (this.adf == 0 || getChildCount() <= 0 || (!this.adl && gI() == null)) ? null : 1;
                if (obj != null) {
                    removeCallbacks(this.adm);
                    if (gH()) {
                        obj2 = 1;
                    }
                }
                this.Xv = -1;
                this.Xw = Integer.MIN_VALUE;
            }
            this.adg = aVar.XC;
            this.adh = eU();
            this.adi = null;
            if (obj2 != null) {
                obj = null;
            } else {
                return;
            }
        }
    }

    private void br(int i) {
        this.adb = i / this.WG;
        this.adj = MeasureSpec.makeMeasureSpec(i, this.ada.getMode());
    }

    public final boolean eQ() {
        return this.adi == null;
    }

    public final int b(q qVar) {
        return h(qVar);
    }

    private int h(q qVar) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        ab abVar = this.acZ;
        View Z = Z(!this.Xu);
        if (this.Xu) {
            z = false;
        }
        return ah.a(qVar, abVar, Z, aa(z), this, this.Xu, this.Xs);
    }

    public final int c(q qVar) {
        return h(qVar);
    }

    public final int d(q qVar) {
        return i(qVar);
    }

    private int i(q qVar) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        ab abVar = this.acZ;
        View Z = Z(!this.Xu);
        if (this.Xu) {
            z = false;
        }
        return ah.a(qVar, abVar, Z, aa(z), this, this.Xu);
    }

    public final int e(q qVar) {
        return i(qVar);
    }

    public final int f(q qVar) {
        return j(qVar);
    }

    private int j(q qVar) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        ab abVar = this.acZ;
        View Z = Z(!this.Xu);
        if (this.Xu) {
            z = false;
        }
        return ah.b(qVar, abVar, Z, aa(z), this, this.Xu);
    }

    public final int g(q qVar) {
        return j(qVar);
    }

    private void a(View view, int i, int i2, boolean z) {
        a(view, this.gG);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = i(i, layoutParams.leftMargin + this.gG.left, layoutParams.rightMargin + this.gG.right);
        int i4 = i(i2, layoutParams.topMargin + this.gG.top, layoutParams.bottomMargin + this.gG.bottom);
        if (a(view, i3, i4, (android.support.v7.widget.RecyclerView.LayoutParams) layoutParams)) {
            view.measure(i3, i4);
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

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.adi = (SavedState) parcelable;
            requestLayout();
        }
    }

    public final Parcelable onSaveInstanceState() {
        if (this.adi != null) {
            return new SavedState(this.adi);
        }
        SavedState savedState = new SavedState();
        savedState.Xr = this.Xr;
        savedState.XM = this.adg;
        savedState.adh = this.adh;
        if (this.ade == null || this.ade.mData == null) {
            savedState.ady = 0;
        } else {
            savedState.adz = this.ade.mData;
            savedState.ady = savedState.adz.length;
            savedState.adr = this.ade.adr;
        }
        if (getChildCount() > 0) {
            int i;
            savedState.XK = this.adg ? gJ() : gK();
            View aa = this.Xs ? aa(true) : Z(true);
            if (aa == null) {
                i = -1;
            } else {
                i = h.be(aa);
            }
            savedState.adv = i;
            savedState.adw = this.WG;
            savedState.adx = new int[this.WG];
            for (i = 0; i < this.WG; i++) {
                int bD;
                if (this.adg) {
                    bD = this.acY[i].bD(Integer.MIN_VALUE);
                    if (bD != Integer.MIN_VALUE) {
                        bD -= this.acZ.fk();
                    }
                } else {
                    bD = this.acY[i].bC(Integer.MIN_VALUE);
                    if (bD != Integer.MIN_VALUE) {
                        bD -= this.acZ.fj();
                    }
                }
                savedState.adx[i] = bD;
            }
        } else {
            savedState.XK = -1;
            savedState.adv = -1;
            savedState.adw = 0;
        }
        return savedState;
    }

    public final void a(m mVar, q qVar, View view, android.support.v4.view.a.b bVar) {
        int i = 1;
        int i2 = -1;
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            int gL;
            int i3;
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (this.Xd == 0) {
                gL = layoutParams2.gL();
                if (layoutParams2.adq) {
                    i = this.WG;
                }
                i3 = gL;
                gL = i;
                i = -1;
            } else {
                gL = layoutParams2.gL();
                if (layoutParams2.adq) {
                    i = this.WG;
                    i3 = -1;
                    i2 = gL;
                    gL = -1;
                } else {
                    i3 = -1;
                    i2 = gL;
                    gL = -1;
                }
            }
            bVar.k(l.a(i3, gL, i2, i, layoutParams2.adq));
            return;
        }
        super.b(view, bVar);
    }

    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            f a = android.support.v4.view.a.a.a(accessibilityEvent);
            View Z = Z(false);
            View aa = aa(false);
            if (Z != null && aa != null) {
                int be = h.be(Z);
                int be2 = h.be(aa);
                if (be < be2) {
                    a.setFromIndex(be);
                    a.setToIndex(be2);
                    return;
                }
                a.setFromIndex(be2);
                a.setToIndex(be);
            }
        }
    }

    public final int a(m mVar, q qVar) {
        if (this.Xd == 0) {
            return this.WG;
        }
        return super.a(mVar, qVar);
    }

    public final int b(m mVar, q qVar) {
        if (this.Xd == 1) {
            return this.WG;
        }
        return super.b(mVar, qVar);
    }

    private View Z(boolean z) {
        int fj = this.acZ.fj();
        int fk = this.acZ.fk();
        int childCount = getChildCount();
        View view = null;
        int i = 0;
        while (i < childCount) {
            View childAt = getChildAt(i);
            int aV = this.acZ.aV(childAt);
            if (this.acZ.aW(childAt) > fj && aV < fk) {
                if (aV >= fj || !z) {
                    return childAt;
                }
                if (view == null) {
                    i++;
                    view = childAt;
                }
            }
            childAt = view;
            i++;
            view = childAt;
        }
        return view;
    }

    private View aa(boolean z) {
        int fj = this.acZ.fj();
        int fk = this.acZ.fk();
        View view = null;
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            int aV = this.acZ.aV(childAt);
            int aW = this.acZ.aW(childAt);
            if (aW > fj && aV < fk) {
                if (aW <= fk || !z) {
                    return childAt;
                }
                if (view == null) {
                    childCount--;
                    view = childAt;
                }
            }
            childAt = view;
            childCount--;
            view = childAt;
        }
        return view;
    }

    private void a(m mVar, q qVar, boolean z) {
        int bu = bu(Integer.MIN_VALUE);
        if (bu != Integer.MIN_VALUE) {
            bu = this.acZ.fk() - bu;
            if (bu > 0) {
                bu -= -c(-bu, mVar, qVar);
                if (z && bu > 0) {
                    this.acZ.ba(bu);
                }
            }
        }
    }

    private void b(m mVar, q qVar, boolean z) {
        int bt = bt(Integer.MAX_VALUE);
        if (bt != Integer.MAX_VALUE) {
            bt -= this.acZ.fj();
            if (bt > 0) {
                bt -= c(bt, mVar, qVar);
                if (z && bt > 0) {
                    this.acZ.ba(-bt);
                }
            }
        }
    }

    private void a(int i, q qVar) {
        int i2;
        int i3;
        boolean z;
        y yVar;
        boolean z2 = false;
        this.adc.WS = 0;
        this.adc.WT = i;
        if (fU()) {
            i2 = qVar.aaG;
            if (i2 != -1) {
                if (this.Xs == (i2 < i)) {
                    i2 = this.acZ.fl();
                    i3 = 0;
                } else {
                    i3 = this.acZ.fl();
                    i2 = 0;
                }
                if (this.aak == null && this.aak.Zc) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.adc.WX = i2 + this.acZ.getEnd();
                    this.adc.WW = -i3;
                } else {
                    this.adc.WW = this.acZ.fj() - i3;
                    this.adc.WX = i2 + this.acZ.fk();
                }
                this.adc.WY = false;
                this.adc.WR = true;
                yVar = this.adc;
                if (this.acZ.getMode() == 0 && this.acZ.getEnd() == 0) {
                    z2 = true;
                }
                yVar.WZ = z2;
            }
        }
        i2 = 0;
        i3 = 0;
        if (this.aak == null) {
        }
        z = false;
        if (z) {
            this.adc.WX = i2 + this.acZ.getEnd();
            this.adc.WW = -i3;
        } else {
            this.adc.WW = this.acZ.fj() - i3;
            this.adc.WX = i2 + this.acZ.fk();
        }
        this.adc.WY = false;
        this.adc.WR = true;
        yVar = this.adc;
        z2 = true;
        yVar.WZ = z2;
    }

    private void bs(int i) {
        int i2 = 1;
        this.adc.WV = i;
        y yVar = this.adc;
        if (this.Xs != (i == -1)) {
            i2 = -1;
        }
        yVar.WU = i2;
    }

    public final void bg(int i) {
        super.bg(i);
        for (int i2 = 0; i2 < this.WG; i2++) {
            this.acY[i2].bF(i);
        }
    }

    public final void bh(int i) {
        super.bh(i);
        for (int i2 = 0; i2 < this.WG; i2++) {
            this.acY[i2].bF(i);
        }
    }

    public final void A(int i, int i2) {
        m(i, i2, 2);
    }

    public final void z(int i, int i2) {
        m(i, i2, 1);
    }

    public final void eM() {
        this.ade.clear();
        requestLayout();
    }

    public final void C(int i, int i2) {
        m(i, i2, 8);
    }

    public final void B(int i, int i2) {
        m(i, i2, 4);
    }

    private void m(int i, int i2, int i3) {
        int i4;
        int i5;
        int gJ = this.Xs ? gJ() : gK();
        if (i3 != 8) {
            i4 = i + i2;
            i5 = i;
        } else if (i < i2) {
            i4 = i2 + 1;
            i5 = i;
        } else {
            i4 = i + 1;
            i5 = i2;
        }
        this.ade.by(i5);
        switch (i3) {
            case 1:
                this.ade.af(i, i2);
                break;
            case 2:
                this.ade.ae(i, i2);
                break;
            case 8:
                this.ade.ae(i, 1);
                this.ade.af(i2, 1);
                break;
        }
        if (i4 > gJ) {
            if (i5 <= (this.Xs ? gK() : gJ())) {
                requestLayout();
            }
        }
    }

    private int a(m mVar, y yVar, q qVar) {
        int i;
        int fj;
        this.add.set(0, this.WG, true);
        if (this.adc.WZ) {
            if (yVar.WV == 1) {
                i = Integer.MAX_VALUE;
            } else {
                i = Integer.MIN_VALUE;
            }
        } else if (yVar.WV == 1) {
            i = yVar.WX + yVar.WS;
        } else {
            i = yVar.WW - yVar.WS;
        }
        ad(yVar.WV, i);
        int fk = this.Xs ? this.acZ.fk() : this.acZ.fj();
        Object obj = null;
        while (true) {
            Object obj2 = (yVar.WT < 0 || yVar.WT >= qVar.getItemCount()) ? null : 1;
            if (obj2 != null && (this.adc.WZ || !this.add.isEmpty())) {
                b bVar;
                int i2;
                int i3;
                int bD;
                View bk = mVar.bk(yVar.WT);
                yVar.WT += yVar.WU;
                LayoutParams layoutParams = (LayoutParams) bk.getLayoutParams();
                int ge = layoutParams.aas.ge();
                LazySpanLookup lazySpanLookup = this.ade;
                int i4 = (lazySpanLookup.mData == null || ge >= lazySpanLookup.mData.length) ? -1 : lazySpanLookup.mData[ge];
                Object obj3 = i4 == -1 ? 1 : null;
                if (obj3 != null) {
                    if (layoutParams.adq) {
                        bVar = this.acY[0];
                    } else {
                        if (bv(yVar.WV)) {
                            i4 = this.WG - 1;
                            i2 = -1;
                            i3 = -1;
                        } else {
                            i4 = 0;
                            i2 = this.WG;
                            i3 = 1;
                        }
                        int i5;
                        int fj2;
                        int i6;
                        b bVar2;
                        int i7;
                        if (yVar.WV == 1) {
                            bVar = null;
                            i5 = Integer.MAX_VALUE;
                            fj2 = this.acZ.fj();
                            i6 = i4;
                            while (i6 != i2) {
                                bVar2 = this.acY[i6];
                                bD = bVar2.bD(fj2);
                                if (bD < i5) {
                                    i7 = bD;
                                } else {
                                    bVar2 = bVar;
                                    i7 = i5;
                                }
                                i6 += i3;
                                i5 = i7;
                                bVar = bVar2;
                            }
                        } else {
                            bVar = null;
                            i5 = Integer.MIN_VALUE;
                            fj2 = this.acZ.fk();
                            i6 = i4;
                            while (i6 != i2) {
                                bVar2 = this.acY[i6];
                                bD = bVar2.bC(fj2);
                                if (bD > i5) {
                                    i7 = bD;
                                } else {
                                    bVar2 = bVar;
                                    i7 = i5;
                                }
                                i6 += i3;
                                i5 = i7;
                                bVar = bVar2;
                            }
                        }
                    }
                    lazySpanLookup = this.ade;
                    lazySpanLookup.bz(ge);
                    lazySpanLookup.mData[ge] = bVar.mIndex;
                } else {
                    bVar = this.acY[i4];
                }
                layoutParams.adp = bVar;
                if (yVar.WV == 1) {
                    super.c(bk, -1, false);
                } else {
                    super.c(bk, 0, false);
                }
                if (layoutParams.adq) {
                    if (this.Xd == 1) {
                        a(bk, this.adj, h.b(this.RQ, this.aaq, 0, layoutParams.height, true), false);
                    } else {
                        a(bk, h.b(this.aar, this.aap, 0, layoutParams.width, true), this.adj, false);
                    }
                } else if (this.Xd == 1) {
                    a(bk, h.b(this.adb, this.aap, 0, layoutParams.width, false), h.b(this.RQ, this.aaq, 0, layoutParams.height, true), false);
                } else {
                    a(bk, h.b(this.aar, this.aap, 0, layoutParams.width, true), h.b(this.adb, this.aaq, 0, layoutParams.height, false), false);
                }
                FullSpanItem fullSpanItem;
                if (yVar.WV == 1) {
                    i3 = layoutParams.adq ? bu(fk) : bVar.bD(fk);
                    i2 = i3 + this.acZ.aX(bk);
                    if (obj3 == null || !layoutParams.adq) {
                        i4 = i3;
                        i3 = i2;
                    } else {
                        fullSpanItem = new FullSpanItem();
                        fullSpanItem.adt = new int[this.WG];
                        for (i4 = 0; i4 < this.WG; i4++) {
                            fullSpanItem.adt[i4] = i3 - this.acY[i4].bD(i3);
                        }
                        fullSpanItem.ads = -1;
                        fullSpanItem.kC = ge;
                        this.ade.a(fullSpanItem);
                        i4 = i3;
                        i3 = i2;
                    }
                } else {
                    i3 = layoutParams.adq ? bt(fk) : bVar.bC(fk);
                    i2 = i3 - this.acZ.aX(bk);
                    if (obj3 != null && layoutParams.adq) {
                        fullSpanItem = new FullSpanItem();
                        fullSpanItem.adt = new int[this.WG];
                        for (i4 = 0; i4 < this.WG; i4++) {
                            fullSpanItem.adt[i4] = this.acY[i4].bC(i3) - i3;
                        }
                        fullSpanItem.ads = 1;
                        fullSpanItem.kC = ge;
                        this.ade.a(fullSpanItem);
                    }
                    i4 = i2;
                }
                if (layoutParams.adq && yVar.WU == -1) {
                    if (obj3 == null) {
                        Object obj4;
                        if (yVar.WV == 1) {
                            bD = this.acY[0].bD(Integer.MIN_VALUE);
                            for (i2 = 1; i2 < this.WG; i2++) {
                                if (this.acY[i2].bD(Integer.MIN_VALUE) != bD) {
                                    obj4 = null;
                                    break;
                                }
                            }
                            obj4 = 1;
                            obj4 = obj4 == null ? 1 : null;
                        } else {
                            bD = this.acY[0].bC(Integer.MIN_VALUE);
                            for (i2 = 1; i2 < this.WG; i2++) {
                                if (this.acY[i2].bC(Integer.MIN_VALUE) != bD) {
                                    obj4 = null;
                                    break;
                                }
                            }
                            obj4 = 1;
                            obj4 = obj4 == null ? 1 : null;
                        }
                        if (obj4 != null) {
                            FullSpanItem bA = this.ade.bA(ge);
                            if (bA != null) {
                                bA.adu = true;
                            }
                        }
                    }
                    this.adl = true;
                }
                if (yVar.WV == 1) {
                    if (layoutParams.adq) {
                        for (i2 = this.WG - 1; i2 >= 0; i2--) {
                            this.acY[i2].br(bk);
                        }
                    } else {
                        layoutParams.adp.br(bk);
                    }
                } else if (layoutParams.adq) {
                    for (i2 = this.WG - 1; i2 >= 0; i2--) {
                        this.acY[i2].bq(bk);
                    }
                } else {
                    layoutParams.adp.bq(bk);
                }
                if (eU() && this.Xd == 1) {
                    i2 = layoutParams.adq ? this.ada.fk() : this.ada.fk() - (((this.WG - 1) - bVar.mIndex) * this.adb);
                    bD = i2;
                    i2 -= this.ada.aX(bk);
                } else {
                    i2 = layoutParams.adq ? this.ada.fj() : (bVar.mIndex * this.adb) + this.ada.fj();
                    bD = this.ada.aX(bk) + i2;
                }
                if (this.Xd == 1) {
                    h(bk, i2, i4, bD, i3);
                } else {
                    h(bk, i4, i2, i3, bD);
                }
                if (layoutParams.adq) {
                    ad(this.adc.WV, i);
                } else {
                    a(bVar, this.adc.WV, i);
                }
                a(mVar, this.adc);
                if (this.adc.WY && bk.isFocusable()) {
                    if (layoutParams.adq) {
                        this.add.clear();
                    } else {
                        this.add.set(bVar.mIndex, false);
                    }
                }
                obj = 1;
            } else if (obj == null) {
                a(mVar, this.adc);
            }
        }
        if (obj == null) {
            a(mVar, this.adc);
        }
        if (this.adc.WV == -1) {
            fj = this.acZ.fj() - bt(this.acZ.fj());
        } else {
            fj = bu(this.acZ.fk()) - this.acZ.fk();
        }
        return fj > 0 ? Math.min(yVar.WS, fj) : 0;
    }

    private void a(m mVar, y yVar) {
        int i = 1;
        if (yVar.WR && !yVar.WZ) {
            if (yVar.WS == 0) {
                if (yVar.WV == -1) {
                    b(mVar, yVar.WX);
                } else {
                    a(mVar, yVar.WW);
                }
            } else if (yVar.WV == -1) {
                r3 = yVar.WW;
                int i2 = yVar.WW;
                r1 = this.acY[0].bC(i2);
                while (i < this.WG) {
                    r2 = this.acY[i].bC(i2);
                    if (r2 > r1) {
                        r1 = r2;
                    }
                    i++;
                }
                i = r3 - r1;
                if (i < 0) {
                    i = yVar.WX;
                } else {
                    i = yVar.WX - Math.min(i, yVar.WS);
                }
                b(mVar, i);
            } else {
                r3 = yVar.WX;
                r1 = this.acY[0].bD(r3);
                while (i < this.WG) {
                    r2 = this.acY[i].bD(r3);
                    if (r2 < r1) {
                        r1 = r2;
                    }
                    i++;
                }
                i = r1 - yVar.WX;
                if (i < 0) {
                    i = yVar.WW;
                } else {
                    i = Math.min(i, yVar.WS) + yVar.WW;
                }
                a(mVar, i);
            }
        }
    }

    private static void h(View view, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        h.g(view, layoutParams.leftMargin + i, layoutParams.topMargin + i2, i3 - layoutParams.rightMargin, i4 - layoutParams.bottomMargin);
    }

    private void ad(int i, int i2) {
        for (int i3 = 0; i3 < this.WG; i3++) {
            if (!this.acY[i3].adA.isEmpty()) {
                a(this.acY[i3], i, i2);
            }
        }
    }

    private void a(b bVar, int i, int i2) {
        int i3 = bVar.adD;
        if (i == -1) {
            if (i3 + bVar.gN() <= i2) {
                this.add.set(bVar.mIndex, false);
            }
        } else if (bVar.gP() - i3 >= i2) {
            this.add.set(bVar.mIndex, false);
        }
    }

    private int bt(int i) {
        int bC = this.acY[0].bC(i);
        for (int i2 = 1; i2 < this.WG; i2++) {
            int bC2 = this.acY[i2].bC(i);
            if (bC2 < bC) {
                bC = bC2;
            }
        }
        return bC;
    }

    private int bu(int i) {
        int bD = this.acY[0].bD(i);
        for (int i2 = 1; i2 < this.WG; i2++) {
            int bD2 = this.acY[i2].bD(i);
            if (bD2 > bD) {
                bD = bD2;
            }
        }
        return bD;
    }

    private void a(m mVar, int i) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.acZ.aW(childAt) <= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.adq) {
                    int i2 = 0;
                    while (i2 < this.WG) {
                        if (this.acY[i2].adA.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.WG; i2++) {
                        this.acY[i2].gR();
                    }
                } else if (layoutParams.adp.adA.size() != 1) {
                    layoutParams.adp.gR();
                } else {
                    return;
                }
                a(childAt, mVar);
            } else {
                return;
            }
        }
    }

    private void b(m mVar, int i) {
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            if (this.acZ.aV(childAt) >= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.adq) {
                    int i2 = 0;
                    while (i2 < this.WG) {
                        if (this.acY[i2].adA.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.WG; i2++) {
                        this.acY[i2].gQ();
                    }
                } else if (layoutParams.adp.adA.size() != 1) {
                    layoutParams.adp.gQ();
                } else {
                    return;
                }
                a(childAt, mVar);
                childCount--;
            } else {
                return;
            }
        }
    }

    private boolean bv(int i) {
        if (this.Xd == 0) {
            boolean z;
            if (i == -1) {
                z = true;
            } else {
                z = false;
            }
            if (z != this.Xs) {
                return true;
            }
            return false;
        }
        if (((i == -1) == this.Xs) != eU()) {
            return false;
        }
        return true;
    }

    public final boolean eS() {
        return this.Xd == 1;
    }

    public final boolean eR() {
        return this.Xd == 0;
    }

    public final int a(int i, m mVar, q qVar) {
        return c(i, mVar, qVar);
    }

    public final int b(int i, m mVar, q qVar) {
        return c(i, mVar, qVar);
    }

    public final int bw(int i) {
        if (getChildCount() != 0) {
            if ((i < gK()) != this.Xs) {
                return -1;
            }
            return 1;
        } else if (this.Xs) {
            return 1;
        } else {
            return -1;
        }
    }

    public final void a(RecyclerView recyclerView, int i) {
        p anonymousClass1 = new z(this, recyclerView.getContext()) {
            final /* synthetic */ StaggeredGridLayoutManager adn;

            public final PointF aW(int i) {
                int bw = this.adn.bw(i);
                if (bw == 0) {
                    return null;
                }
                if (this.adn.Xd == 0) {
                    return new PointF((float) bw, 0.0f);
                }
                return new PointF(0.0f, (float) bw);
            }
        };
        anonymousClass1.aaG = i;
        a(anonymousClass1);
    }

    public final void aX(int i) {
        if (!(this.adi == null || this.adi.XK == i)) {
            SavedState savedState = this.adi;
            savedState.adx = null;
            savedState.adw = 0;
            savedState.XK = -1;
            savedState.adv = -1;
        }
        this.Xv = i;
        this.Xw = Integer.MIN_VALUE;
        requestLayout();
    }

    private int c(int i, m mVar, q qVar) {
        int gJ;
        int i2;
        if (i > 0) {
            gJ = gJ();
            i2 = 1;
        } else {
            i2 = -1;
            gJ = gK();
        }
        this.adc.WR = true;
        a(gJ, qVar);
        bs(i2);
        this.adc.WT = gJ + this.adc.WU;
        i2 = Math.abs(i);
        this.adc.WS = i2;
        gJ = a(mVar, this.adc, qVar);
        if (i2 >= gJ) {
            i = i < 0 ? -gJ : gJ;
        }
        this.acZ.ba(-i);
        this.adg = this.Xs;
        return i;
    }

    private int gJ() {
        int childCount = getChildCount();
        return childCount == 0 ? 0 : h.be(getChildAt(childCount - 1));
    }

    private int gK() {
        if (getChildCount() == 0) {
            return 0;
        }
        return h.be(getChildAt(0));
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

    public final View a(View view, int i, m mVar, q qVar) {
        int i2 = 0;
        if (getChildCount() == 0) {
            return null;
        }
        View bf = bf(view);
        if (bf == null) {
            return null;
        }
        int i3;
        eT();
        switch (i) {
            case 1:
                i3 = -1;
                break;
            case 2:
                i3 = 1;
                break;
            case 17:
                if (this.Xd != 0) {
                    i3 = Integer.MIN_VALUE;
                    break;
                }
                i3 = -1;
                break;
            case 33:
                if (this.Xd != 1) {
                    i3 = Integer.MIN_VALUE;
                    break;
                }
                i3 = -1;
                break;
            case 66:
                if (this.Xd != 0) {
                    i3 = Integer.MIN_VALUE;
                    break;
                }
                i3 = 1;
                break;
            case 130:
                if (this.Xd != 1) {
                    i3 = Integer.MIN_VALUE;
                    break;
                }
                i3 = 1;
                break;
            default:
                i3 = Integer.MIN_VALUE;
                break;
        }
        if (i3 == Integer.MIN_VALUE) {
            return null;
        }
        int gJ;
        View ag;
        LayoutParams layoutParams = (LayoutParams) bf.getLayoutParams();
        boolean z = layoutParams.adq;
        b bVar = layoutParams.adp;
        if (i3 == 1) {
            gJ = gJ();
        } else {
            gJ = gK();
        }
        a(gJ, qVar);
        bs(i3);
        this.adc.WT = this.adc.WU + gJ;
        this.adc.WS = (int) (0.33333334f * ((float) this.acZ.fl()));
        this.adc.WY = true;
        this.adc.WR = false;
        a(mVar, this.adc, qVar);
        this.adg = this.Xs;
        if (!z) {
            ag = bVar.ag(gJ, i3);
            if (!(ag == null || ag == bf)) {
                return ag;
            }
        }
        if (bv(i3)) {
            for (int i4 = this.WG - 1; i4 >= 0; i4--) {
                View ag2 = this.acY[i4].ag(gJ, i3);
                if (ag2 != null && ag2 != bf) {
                    return ag2;
                }
            }
        } else {
            while (i2 < this.WG) {
                ag = this.acY[i2].ag(gJ, i3);
                if (ag != null && ag != bf) {
                    return ag;
                }
                i2++;
            }
        }
        return null;
    }
}
