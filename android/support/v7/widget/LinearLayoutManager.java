package android.support.v7.widget;

import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.a.f;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.p;
import android.support.v7.widget.RecyclerView.q;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.ab.AnonymousClass2;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager extends h {
    int Xd;
    private c Xo;
    ab Xp;
    private boolean Xq;
    private boolean Xr;
    boolean Xs;
    private boolean Xt;
    private boolean Xu;
    public int Xv;
    public int Xw;
    private boolean Xx;
    public SavedState Xy;
    final a Xz;

    public static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public int XK;
        int XL;
        boolean XM;

        SavedState(Parcel parcel) {
            boolean z = true;
            this.XK = parcel.readInt();
            this.XL = parcel.readInt();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.XM = z;
        }

        public SavedState(SavedState savedState) {
            this.XK = savedState.XK;
            this.XL = savedState.XL;
            this.XM = savedState.XM;
        }

        final boolean fd() {
            return this.XK >= 0;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.XK);
            parcel.writeInt(this.XL);
            parcel.writeInt(this.XM ? 1 : 0);
        }
    }

    class a {
        final /* synthetic */ LinearLayoutManager XA;
        int XB;
        boolean XC;
        int kC;

        a(LinearLayoutManager linearLayoutManager) {
            this.XA = linearLayoutManager;
        }

        final void fc() {
            this.XB = this.XC ? this.XA.Xp.fk() : this.XA.Xp.fj();
        }

        public final String toString() {
            return "AnchorInfo{mPosition=" + this.kC + ", mCoordinate=" + this.XB + ", mLayoutFromEnd=" + this.XC + '}';
        }

        public final void aT(View view) {
            if (this.XC) {
                this.XB = this.XA.Xp.aW(view) + this.XA.Xp.fi();
            } else {
                this.XB = this.XA.Xp.aV(view);
            }
            this.kC = h.be(view);
        }
    }

    protected static class b {
        public boolean OE;
        public int XD;
        public boolean XE;
        public boolean mFinished;

        protected b() {
        }
    }

    static class c {
        boolean WR = true;
        int WS;
        int WT;
        int WU;
        int WV;
        boolean WZ;
        int XF;
        int XG = 0;
        boolean XH = false;
        int XI;
        List<t> XJ = null;
        int wa;

        c() {
        }

        final boolean k(q qVar) {
            return this.WT >= 0 && this.WT < qVar.getItemCount();
        }

        final View a(m mVar) {
            if (this.XJ != null) {
                int size = this.XJ.size();
                int i = 0;
                while (i < size) {
                    View view = ((t) this.XJ.get(i)).abf;
                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                    if (layoutParams.aas.isRemoved() || this.WT != layoutParams.aas.ge()) {
                        i++;
                    } else {
                        aU(view);
                        return view;
                    }
                }
                return null;
            }
            View bk = mVar.bk(this.WT);
            this.WT += this.WU;
            return bk;
        }

        public final void aU(View view) {
            View view2;
            int size = this.XJ.size();
            View view3 = null;
            int i = Integer.MAX_VALUE;
            int i2 = 0;
            while (i2 < size) {
                int ge;
                View view4;
                view2 = ((t) this.XJ.get(i2)).abf;
                LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
                if (!(view2 == view || layoutParams.aas.isRemoved())) {
                    ge = (layoutParams.aas.ge() - this.WT) * this.WU;
                    if (ge >= 0 && ge < i) {
                        if (ge == 0) {
                            break;
                        }
                        view4 = view2;
                        i2++;
                        view3 = view4;
                        i = ge;
                    }
                }
                ge = i;
                view4 = view3;
                i2++;
                view3 = view4;
                i = ge;
            }
            view2 = view3;
            if (view2 == null) {
                this.WT = -1;
            } else {
                this.WT = ((LayoutParams) view2.getLayoutParams()).aas.ge();
            }
        }
    }

    public LinearLayoutManager() {
        this(1, false);
    }

    public LinearLayoutManager(int i, boolean z) {
        this.Xr = false;
        this.Xs = false;
        this.Xt = false;
        this.Xu = true;
        this.Xv = -1;
        this.Xw = Integer.MIN_VALUE;
        this.Xy = null;
        this.Xz = new a(this);
        setOrientation(i);
        q(null);
        if (this.Xr) {
            this.Xr = false;
            requestLayout();
        }
        this.aan = true;
    }

    public LayoutParams eN() {
        return new LayoutParams(-2, -2);
    }

    public final void a(RecyclerView recyclerView, m mVar) {
        super.a(recyclerView, mVar);
        if (this.Xx) {
            d(mVar);
            mVar.clear();
        }
    }

    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            f a = android.support.v4.view.a.a.a(accessibilityEvent);
            a.setFromIndex(fa());
            a.setToIndex(fb());
        }
    }

    public final Parcelable onSaveInstanceState() {
        if (this.Xy != null) {
            return new SavedState(this.Xy);
        }
        Parcelable savedState = new SavedState();
        if (getChildCount() > 0) {
            eV();
            boolean z = this.Xq ^ this.Xs;
            savedState.XM = z;
            View eZ;
            if (z) {
                eZ = eZ();
                savedState.XL = this.Xp.fk() - this.Xp.aW(eZ);
                savedState.XK = h.be(eZ);
                return savedState;
            }
            eZ = eY();
            savedState.XK = h.be(eZ);
            savedState.XL = this.Xp.aV(eZ) - this.Xp.fj();
            return savedState;
        }
        savedState.XK = -1;
        return savedState;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.Xy = (SavedState) parcelable;
            requestLayout();
        }
    }

    public final boolean eR() {
        return this.Xd == 0;
    }

    public final boolean eS() {
        return this.Xd == 1;
    }

    public final void setOrientation(int i) {
        if (i == 0 || i == 1) {
            q(null);
            if (i != this.Xd) {
                this.Xd = i;
                this.Xp = null;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i);
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

    public final View aV(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int be = i - h.be(getChildAt(0));
        if (be >= 0 && be < childCount) {
            View childAt = getChildAt(be);
            if (h.be(childAt) == i) {
                return childAt;
            }
        }
        return super.aV(i);
    }

    public int a(q qVar) {
        int i;
        if (qVar.aaG != -1) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            return this.Xp.fl();
        }
        return 0;
    }

    public void a(RecyclerView recyclerView, int i) {
        p anonymousClass1 = new z(this, recyclerView.getContext()) {
            final /* synthetic */ LinearLayoutManager XA;

            public final PointF aW(int i) {
                return this.XA.aW(i);
            }
        };
        anonymousClass1.aaG = i;
        a(anonymousClass1);
    }

    public final PointF aW(int i) {
        int i2 = 1;
        boolean z = false;
        if (getChildCount() == 0) {
            return null;
        }
        if (i < h.be(getChildAt(0))) {
            z = true;
        }
        if (z != this.Xs) {
            i2 = -1;
        }
        if (this.Xd == 0) {
            return new PointF((float) i2, 0.0f);
        }
        return new PointF(0.0f, (float) i2);
    }

    public void c(m mVar, q qVar) {
        if (!(this.Xy == null && this.Xv == -1) && qVar.getItemCount() == 0) {
            d(mVar);
            return;
        }
        Object obj;
        View aV;
        int fi;
        int aX;
        int fj;
        int min;
        int fk;
        if (this.Xy != null && this.Xy.fd()) {
            this.Xv = this.Xy.XK;
        }
        eV();
        this.Xo.WR = false;
        eT();
        a aVar = this.Xz;
        aVar.kC = -1;
        aVar.XB = Integer.MIN_VALUE;
        aVar.XC = false;
        this.Xz.XC = this.Xs ^ this.Xt;
        a aVar2 = this.Xz;
        if (qVar.aaW || this.Xv == -1) {
            obj = null;
        } else if (this.Xv < 0 || this.Xv >= qVar.getItemCount()) {
            this.Xv = -1;
            this.Xw = Integer.MIN_VALUE;
            obj = null;
        } else {
            aVar2.kC = this.Xv;
            if (this.Xy == null || !this.Xy.fd()) {
                if (this.Xw == Integer.MIN_VALUE) {
                    aV = aV(this.Xv);
                    if (aV == null) {
                        if (getChildCount() > 0) {
                            aVar2.XC = (this.Xv < h.be(getChildAt(0))) == this.Xs;
                        }
                        aVar2.fc();
                    } else if (this.Xp.aX(aV) > this.Xp.fl()) {
                        aVar2.fc();
                    } else if (this.Xp.aV(aV) - this.Xp.fj() < 0) {
                        aVar2.XB = this.Xp.fj();
                        aVar2.XC = false;
                    } else if (this.Xp.fk() - this.Xp.aW(aV) < 0) {
                        aVar2.XB = this.Xp.fk();
                        aVar2.XC = true;
                    } else {
                        aVar2.XB = aVar2.XC ? this.Xp.aW(aV) + this.Xp.fi() : this.Xp.aV(aV);
                    }
                    obj = 1;
                } else {
                    aVar2.XC = this.Xs;
                    if (this.Xs) {
                        aVar2.XB = this.Xp.fk() - this.Xw;
                    } else {
                        aVar2.XB = this.Xp.fj() + this.Xw;
                    }
                }
                obj = 1;
            } else {
                aVar2.XC = this.Xy.XM;
                if (aVar2.XC) {
                    aVar2.XB = this.Xp.fk() - this.Xy.XL;
                } else {
                    aVar2.XB = this.Xp.fj() + this.Xy.XL;
                }
                obj = 1;
            }
        }
        if (obj == null) {
            if (getChildCount() != 0) {
                View view;
                if (this.aak == null) {
                    view = null;
                } else {
                    aV = this.aak.getFocusedChild();
                    view = (aV == null || this.Za.aP(aV)) ? null : aV;
                }
                if (view != null) {
                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                    if (layoutParams.aas.isRemoved() || layoutParams.aas.ge() < 0 || layoutParams.aas.ge() >= qVar.getItemCount()) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj != null) {
                        fi = aVar2.XA.Xp.fi();
                        if (fi >= 0) {
                            aVar2.aT(view);
                        } else {
                            aVar2.kC = h.be(view);
                            if (aVar2.XC) {
                                fi = (aVar2.XA.Xp.fk() - fi) - aVar2.XA.Xp.aW(view);
                                aVar2.XB = aVar2.XA.Xp.fk() - fi;
                                if (fi > 0) {
                                    aX = aVar2.XB - aVar2.XA.Xp.aX(view);
                                    fj = aVar2.XA.Xp.fj();
                                    min = aX - (Math.min(aVar2.XA.Xp.aV(view) - fj, 0) + fj);
                                    if (min < 0) {
                                        aVar2.XB = Math.min(fi, -min) + aVar2.XB;
                                    }
                                }
                            } else {
                                aX = aVar2.XA.Xp.aV(view);
                                fj = aX - aVar2.XA.Xp.fj();
                                aVar2.XB = aX;
                                if (fj > 0) {
                                    fi = (aVar2.XA.Xp.fk() - Math.min(0, (aVar2.XA.Xp.fk() - fi) - aVar2.XA.Xp.aW(view))) - (aX + aVar2.XA.Xp.aX(view));
                                    if (fi < 0) {
                                        aVar2.XB -= Math.min(fj, -fi);
                                    }
                                }
                            }
                        }
                        obj = 1;
                        if (obj == null) {
                            aVar2.fc();
                            if (this.Xt) {
                                fi = qVar.getItemCount() - 1;
                            } else {
                                fi = 0;
                            }
                            aVar2.kC = fi;
                        }
                    }
                }
                if (this.Xq == this.Xt) {
                    aV = aVar2.XC ? d(mVar, qVar) : e(mVar, qVar);
                    if (aV != null) {
                        aVar2.aT(aV);
                        if (!qVar.aaW && eQ()) {
                            obj = (this.Xp.aV(aV) >= this.Xp.fk() || this.Xp.aW(aV) < this.Xp.fj()) ? 1 : null;
                            if (obj != null) {
                                aVar2.XB = aVar2.XC ? this.Xp.fk() : this.Xp.fj();
                            }
                        }
                        obj = 1;
                        if (obj == null) {
                            aVar2.fc();
                            if (this.Xt) {
                                fi = 0;
                            } else {
                                fi = qVar.getItemCount() - 1;
                            }
                            aVar2.kC = fi;
                        }
                    }
                }
            }
            obj = null;
            if (obj == null) {
                aVar2.fc();
                if (this.Xt) {
                    fi = qVar.getItemCount() - 1;
                } else {
                    fi = 0;
                }
                aVar2.kC = fi;
            }
        }
        min = a(qVar);
        if (this.Xo.XI >= 0) {
            fi = 0;
        } else {
            int i = min;
            min = 0;
            fi = i;
        }
        fi += this.Xp.fj();
        min += this.Xp.getEndPadding();
        if (!(!qVar.aaW || this.Xv == -1 || this.Xw == Integer.MIN_VALUE)) {
            View aV2 = aV(this.Xv);
            if (aV2 != null) {
                if (this.Xs) {
                    fk = (this.Xp.fk() - this.Xp.aW(aV2)) - this.Xw;
                } else {
                    fk = this.Xw - (this.Xp.aV(aV2) - this.Xp.fj());
                }
                if (fk > 0) {
                    fi += fk;
                } else {
                    min -= fk;
                }
            }
        }
        fk = this.Xz.XC ? this.Xs ? 1 : -1 : this.Xs ? -1 : 1;
        a(mVar, qVar, this.Xz, fk);
        b(mVar);
        this.Xo.WZ = eW();
        this.Xo.XH = qVar.aaW;
        if (this.Xz.XC) {
            b(this.Xz);
            this.Xo.XG = fi;
            a(mVar, this.Xo, qVar, false);
            fi = this.Xo.wa;
            fk = this.Xo.WT;
            if (this.Xo.WS > 0) {
                min += this.Xo.WS;
            }
            a(this.Xz);
            this.Xo.XG = min;
            c cVar = this.Xo;
            cVar.WT += this.Xo.WU;
            a(mVar, this.Xo, qVar, false);
            min = this.Xo.wa;
            if (this.Xo.WS > 0) {
                aX = this.Xo.WS;
                J(fk, fi);
                this.Xo.XG = aX;
                a(mVar, this.Xo, qVar, false);
                fi = this.Xo.wa;
            }
            i = min;
            min = fi;
            fi = i;
        } else {
            a(this.Xz);
            this.Xo.XG = min;
            a(mVar, this.Xo, qVar, false);
            min = this.Xo.wa;
            aX = this.Xo.WT;
            if (this.Xo.WS > 0) {
                fi += this.Xo.WS;
            }
            b(this.Xz);
            this.Xo.XG = fi;
            c cVar2 = this.Xo;
            cVar2.WT += this.Xo.WU;
            a(mVar, this.Xo, qVar, false);
            fk = this.Xo.wa;
            if (this.Xo.WS > 0) {
                fi = this.Xo.WS;
                I(aX, min);
                this.Xo.XG = fi;
                a(mVar, this.Xo, qVar, false);
                fi = this.Xo.wa;
                min = fk;
            } else {
                fi = min;
                min = fk;
            }
        }
        if (getChildCount() <= 0) {
            fk = min;
            min = fi;
        } else if ((this.Xs ^ this.Xt) != 0) {
            fk = a(fi, mVar, qVar, true);
            min += fk;
            fi += fk;
            fk = b(min, mVar, qVar, false);
            fi += fk;
            fk = min + fk;
            min = fi;
        } else {
            fk = b(min, mVar, qVar, true);
            min += fk;
            fi += fk;
            fk = a(fi, mVar, qVar, false);
            fi += fk;
            fk = min + fk;
            min = fi;
        }
        if (qVar.aaY && getChildCount() != 0 && !qVar.aaW && eQ()) {
            int i2 = 0;
            fj = 0;
            List list = mVar.aaB;
            int size = list.size();
            int be = h.be(getChildAt(0));
            int i3 = 0;
            while (i3 < size) {
                t tVar = (t) list.get(i3);
                if (tVar.isRemoved()) {
                    fi = fj;
                    aX = i2;
                } else {
                    if (((tVar.ge() < be) != this.Xs ? -1 : 1) == -1) {
                        aX = this.Xp.aX(tVar.abf) + i2;
                        fi = fj;
                    } else {
                        fi = this.Xp.aX(tVar.abf) + fj;
                        aX = i2;
                    }
                }
                i3++;
                i2 = aX;
                fj = fi;
            }
            this.Xo.XJ = list;
            if (i2 > 0) {
                J(h.be(eY()), fk);
                this.Xo.XG = i2;
                this.Xo.WS = 0;
                this.Xo.aU(null);
                a(mVar, this.Xo, qVar, false);
            }
            if (fj > 0) {
                I(h.be(eZ()), min);
                this.Xo.XG = fj;
                this.Xo.WS = 0;
                this.Xo.aU(null);
                a(mVar, this.Xo, qVar, false);
            }
            this.Xo.XJ = null;
        }
        if (!qVar.aaW) {
            this.Xv = -1;
            this.Xw = Integer.MIN_VALUE;
            ab abVar = this.Xp;
            abVar.YR = abVar.fl();
        }
        this.Xq = this.Xt;
        this.Xy = null;
    }

    void a(m mVar, q qVar, a aVar, int i) {
    }

    private int a(int i, m mVar, q qVar, boolean z) {
        int fk = this.Xp.fk() - i;
        if (fk <= 0) {
            return 0;
        }
        fk = -c(-fk, mVar, qVar);
        int i2 = i + fk;
        if (!z) {
            return fk;
        }
        i2 = this.Xp.fk() - i2;
        if (i2 <= 0) {
            return fk;
        }
        this.Xp.ba(i2);
        return fk + i2;
    }

    private int b(int i, m mVar, q qVar, boolean z) {
        int fj = i - this.Xp.fj();
        if (fj <= 0) {
            return 0;
        }
        fj = -c(fj, mVar, qVar);
        int i2 = i + fj;
        if (!z) {
            return fj;
        }
        i2 -= this.Xp.fj();
        if (i2 <= 0) {
            return fj;
        }
        this.Xp.ba(-i2);
        return fj - i2;
    }

    private void a(a aVar) {
        I(aVar.kC, aVar.XB);
    }

    private void I(int i, int i2) {
        this.Xo.WS = this.Xp.fk() - i2;
        this.Xo.WU = this.Xs ? -1 : 1;
        this.Xo.WT = i;
        this.Xo.WV = 1;
        this.Xo.wa = i2;
        this.Xo.XF = Integer.MIN_VALUE;
    }

    private void b(a aVar) {
        J(aVar.kC, aVar.XB);
    }

    private void J(int i, int i2) {
        this.Xo.WS = i2 - this.Xp.fj();
        this.Xo.WT = i;
        this.Xo.WU = this.Xs ? 1 : -1;
        this.Xo.WV = -1;
        this.Xo.wa = i2;
        this.Xo.XF = Integer.MIN_VALUE;
    }

    protected final boolean eU() {
        return z.J(this.aak) == 1;
    }

    final void eV() {
        if (this.Xo == null) {
            this.Xo = new c();
        }
        if (this.Xp == null) {
            ab anonymousClass1;
            switch (this.Xd) {
                case 0:
                    anonymousClass1 = new android.support.v7.widget.ab.AnonymousClass1(this);
                    break;
                case 1:
                    anonymousClass1 = new AnonymousClass2(this);
                    break;
                default:
                    throw new IllegalArgumentException("invalid orientation");
            }
            this.Xp = anonymousClass1;
        }
    }

    public final void aX(int i) {
        this.Xv = i;
        this.Xw = Integer.MIN_VALUE;
        if (this.Xy != null) {
            this.Xy.XK = -1;
        }
        requestLayout();
    }

    public int a(int i, m mVar, q qVar) {
        if (this.Xd == 1) {
            return 0;
        }
        return c(i, mVar, qVar);
    }

    public int b(int i, m mVar, q qVar) {
        if (this.Xd == 0) {
            return 0;
        }
        return c(i, mVar, qVar);
    }

    public final int b(q qVar) {
        return h(qVar);
    }

    public final int c(q qVar) {
        return h(qVar);
    }

    public final int d(q qVar) {
        return i(qVar);
    }

    public final int e(q qVar) {
        return i(qVar);
    }

    public final int f(q qVar) {
        return j(qVar);
    }

    public final int g(q qVar) {
        return j(qVar);
    }

    private int h(q qVar) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        eV();
        ab abVar = this.Xp;
        View O = O(!this.Xu);
        if (this.Xu) {
            z = false;
        }
        return ah.a(qVar, abVar, O, P(z), this, this.Xu, this.Xs);
    }

    private int i(q qVar) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        eV();
        ab abVar = this.Xp;
        View O = O(!this.Xu);
        if (this.Xu) {
            z = false;
        }
        return ah.a(qVar, abVar, O, P(z), this, this.Xu);
    }

    private int j(q qVar) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        eV();
        ab abVar = this.Xp;
        View O = O(!this.Xu);
        if (this.Xu) {
            z = false;
        }
        return ah.b(qVar, abVar, O, P(z), this, this.Xu);
    }

    private void a(int i, int i2, boolean z, q qVar) {
        int i3 = -1;
        int i4 = 1;
        this.Xo.WZ = eW();
        this.Xo.XG = a(qVar);
        this.Xo.WV = i;
        View eZ;
        c cVar;
        if (i == 1) {
            c cVar2 = this.Xo;
            cVar2.XG += this.Xp.getEndPadding();
            eZ = eZ();
            cVar = this.Xo;
            if (!this.Xs) {
                i3 = 1;
            }
            cVar.WU = i3;
            this.Xo.WT = h.be(eZ) + this.Xo.WU;
            this.Xo.wa = this.Xp.aW(eZ);
            i3 = this.Xp.aW(eZ) - this.Xp.fk();
        } else {
            eZ = eY();
            cVar = this.Xo;
            cVar.XG += this.Xp.fj();
            cVar = this.Xo;
            if (!this.Xs) {
                i4 = -1;
            }
            cVar.WU = i4;
            this.Xo.WT = h.be(eZ) + this.Xo.WU;
            this.Xo.wa = this.Xp.aV(eZ);
            i3 = (-this.Xp.aV(eZ)) + this.Xp.fj();
        }
        this.Xo.WS = i2;
        if (z) {
            c cVar3 = this.Xo;
            cVar3.WS -= i3;
        }
        this.Xo.XF = i3;
    }

    private boolean eW() {
        return this.Xp.getMode() == 0 && this.Xp.getEnd() == 0;
    }

    private int c(int i, m mVar, q qVar) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        this.Xo.WR = true;
        eV();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        a(i2, abs, true, qVar);
        int a = this.Xo.XF + a(mVar, this.Xo, qVar, false);
        if (a < 0) {
            return 0;
        }
        if (abs > a) {
            i = i2 * a;
        }
        this.Xp.ba(-i);
        this.Xo.XI = i;
        return i;
    }

    public final void q(String str) {
        if (this.Xy == null) {
            super.q(str);
        }
    }

    private void a(m mVar, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    a(i3, mVar);
                }
                return;
            }
            while (i > i2) {
                a(i, mVar);
                i--;
            }
        }
    }

    private void a(m mVar, c cVar) {
        if (cVar.WR && !cVar.WZ) {
            int i;
            int childCount;
            int end;
            if (cVar.WV == -1) {
                i = cVar.XF;
                childCount = getChildCount();
                if (i >= 0) {
                    end = this.Xp.getEnd() - i;
                    if (this.Xs) {
                        for (i = 0; i < childCount; i++) {
                            if (this.Xp.aV(getChildAt(i)) < end) {
                                a(mVar, 0, i);
                                return;
                            }
                        }
                        return;
                    }
                    for (i = childCount - 1; i >= 0; i--) {
                        if (this.Xp.aV(getChildAt(i)) < end) {
                            a(mVar, childCount - 1, i);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            childCount = cVar.XF;
            if (childCount >= 0) {
                end = getChildCount();
                if (this.Xs) {
                    for (i = end - 1; i >= 0; i--) {
                        if (this.Xp.aW(getChildAt(i)) > childCount) {
                            a(mVar, end - 1, i);
                            return;
                        }
                    }
                    return;
                }
                for (i = 0; i < end; i++) {
                    if (this.Xp.aW(getChildAt(i)) > childCount) {
                        a(mVar, 0, i);
                        return;
                    }
                }
            }
        }
    }

    private int a(m mVar, c cVar, q qVar, boolean z) {
        int i = cVar.WS;
        if (cVar.XF != Integer.MIN_VALUE) {
            if (cVar.WS < 0) {
                cVar.XF += cVar.WS;
            }
            a(mVar, cVar);
        }
        int i2 = cVar.WS + cVar.XG;
        b bVar = new b();
        while (true) {
            if ((!cVar.WZ && i2 <= 0) || !cVar.k(qVar)) {
                break;
            }
            bVar.XD = 0;
            bVar.mFinished = false;
            bVar.XE = false;
            bVar.OE = false;
            a(mVar, qVar, cVar, bVar);
            if (!bVar.mFinished) {
                cVar.wa += bVar.XD * cVar.WV;
                if (!(bVar.XE && this.Xo.XJ == null && qVar.aaW)) {
                    cVar.WS -= bVar.XD;
                    i2 -= bVar.XD;
                }
                if (cVar.XF != Integer.MIN_VALUE) {
                    cVar.XF += bVar.XD;
                    if (cVar.WS < 0) {
                        cVar.XF += cVar.WS;
                    }
                    a(mVar, cVar);
                }
                if (z && bVar.OE) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.WS;
    }

    void a(m mVar, q qVar, c cVar, b bVar) {
        View a = cVar.a(mVar);
        if (a == null) {
            bVar.mFinished = true;
            return;
        }
        int aY;
        int i;
        LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
        if (cVar.XJ == null) {
            if (this.Xs == (cVar.WV == -1)) {
                super.c(a, -1, false);
            } else {
                super.c(a, 0, false);
            }
        } else {
            if (this.Xs == (cVar.WV == -1)) {
                super.c(a, -1, true);
            } else {
                super.c(a, 0, true);
            }
        }
        LayoutParams layoutParams2 = (LayoutParams) a.getLayoutParams();
        Rect bc = this.aak.bc(a);
        int i2 = (bc.left + bc.right) + 0;
        int i3 = (bc.bottom + bc.top) + 0;
        i2 = h.b(this.aar, this.aap, i2 + (((getPaddingLeft() + getPaddingRight()) + layoutParams2.leftMargin) + layoutParams2.rightMargin), layoutParams2.width, eR());
        i3 = h.b(this.RQ, this.aaq, i3 + (((getPaddingTop() + getPaddingBottom()) + layoutParams2.topMargin) + layoutParams2.bottomMargin), layoutParams2.height, eS());
        if (a(a, i2, i3, layoutParams2)) {
            a.measure(i2, i3);
        }
        bVar.XD = this.Xp.aX(a);
        if (this.Xd == 1) {
            if (eU()) {
                i3 = this.aar - getPaddingRight();
                aY = i3 - this.Xp.aY(a);
            } else {
                aY = getPaddingLeft();
                i3 = this.Xp.aY(a) + aY;
            }
            if (cVar.WV == -1) {
                i2 = aY;
                aY = cVar.wa - bVar.XD;
                i = i3;
                i3 = cVar.wa;
            } else {
                i2 = aY;
                aY = cVar.wa;
                i = i3;
                i3 = cVar.wa + bVar.XD;
            }
        } else {
            aY = getPaddingTop();
            i3 = this.Xp.aY(a) + aY;
            if (cVar.WV == -1) {
                i = cVar.wa;
                i2 = cVar.wa - bVar.XD;
            } else {
                i2 = cVar.wa;
                i = cVar.wa + bVar.XD;
            }
        }
        h.g(a, i2 + layoutParams.leftMargin, aY + layoutParams.topMargin, i - layoutParams.rightMargin, i3 - layoutParams.bottomMargin);
        if (layoutParams.aas.isRemoved() || layoutParams.aas.gs()) {
            bVar.XE = true;
        }
        bVar.OE = a.isFocusable();
    }

    final boolean eX() {
        if (!(this.aaq == 1073741824 || this.aap == 1073741824)) {
            boolean z;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (z) {
                return true;
            }
        }
        return false;
    }

    final int aY(int i) {
        switch (i) {
            case 1:
                return -1;
            case 2:
                return 1;
            case 17:
                if (this.Xd != 0) {
                    return Integer.MIN_VALUE;
                }
                return -1;
            case 33:
                if (this.Xd != 1) {
                    return Integer.MIN_VALUE;
                }
                return -1;
            case 66:
                return this.Xd == 0 ? 1 : Integer.MIN_VALUE;
            case 130:
                return this.Xd == 1 ? 1 : Integer.MIN_VALUE;
            default:
                return Integer.MIN_VALUE;
        }
    }

    private View eY() {
        return getChildAt(this.Xs ? getChildCount() - 1 : 0);
    }

    private View eZ() {
        return getChildAt(this.Xs ? 0 : getChildCount() - 1);
    }

    private View O(boolean z) {
        if (this.Xs) {
            return a(getChildCount() - 1, -1, z, true);
        }
        return a(0, getChildCount(), z, true);
    }

    private View P(boolean z) {
        if (this.Xs) {
            return a(0, getChildCount(), z, true);
        }
        return a(getChildCount() - 1, -1, z, true);
    }

    private View d(m mVar, q qVar) {
        return this.Xs ? f(mVar, qVar) : g(mVar, qVar);
    }

    private View e(m mVar, q qVar) {
        return this.Xs ? g(mVar, qVar) : f(mVar, qVar);
    }

    private View f(m mVar, q qVar) {
        return a(mVar, qVar, 0, getChildCount(), qVar.getItemCount());
    }

    private View g(m mVar, q qVar) {
        return a(mVar, qVar, getChildCount() - 1, -1, qVar.getItemCount());
    }

    View a(m mVar, q qVar, int i, int i2, int i3) {
        View view = null;
        eV();
        int fj = this.Xp.fj();
        int fk = this.Xp.fk();
        int i4 = i2 > i ? 1 : -1;
        View view2 = null;
        while (i != i2) {
            View view3;
            View childAt = getChildAt(i);
            int be = h.be(childAt);
            if (be >= 0 && be < i3) {
                if (((LayoutParams) childAt.getLayoutParams()).aas.isRemoved()) {
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

    public final int fa() {
        View a = a(0, getChildCount(), false, true);
        return a == null ? -1 : h.be(a);
    }

    public final int fb() {
        View a = a(getChildCount() - 1, -1, false, true);
        if (a == null) {
            return -1;
        }
        return h.be(a);
    }

    public final View a(int i, int i2, boolean z, boolean z2) {
        eV();
        int fj = this.Xp.fj();
        int fk = this.Xp.fk();
        int i3 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int aV = this.Xp.aV(childAt);
            int aW = this.Xp.aW(childAt);
            if (aV < fk && aW > fj) {
                if (!z) {
                    return childAt;
                }
                if (aV >= fj && aW <= fk) {
                    return childAt;
                }
                if (z2 && view == null) {
                    i += i3;
                    view = childAt;
                }
            }
            childAt = view;
            i += i3;
            view = childAt;
        }
        return view;
    }

    public View a(View view, int i, m mVar, q qVar) {
        eT();
        if (getChildCount() == 0) {
            return null;
        }
        int aY = aY(i);
        if (aY == Integer.MIN_VALUE) {
            return null;
        }
        View e;
        eV();
        if (aY == -1) {
            e = e(mVar, qVar);
        } else {
            e = d(mVar, qVar);
        }
        if (e == null) {
            return null;
        }
        View eY;
        eV();
        a(aY, (int) (0.33333334f * ((float) this.Xp.fl())), false, qVar);
        this.Xo.XF = Integer.MIN_VALUE;
        this.Xo.WR = false;
        a(mVar, this.Xo, qVar, true);
        if (aY == -1) {
            eY = eY();
        } else {
            eY = eZ();
        }
        if (eY == e || !eY.isFocusable()) {
            return null;
        }
        return eY;
    }

    public boolean eQ() {
        return this.Xy == null && this.Xq == this.Xt;
    }
}
