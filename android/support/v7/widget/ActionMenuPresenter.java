package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ae;
import android.support.v7.a.a.g;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.k;
import android.support.v7.view.menu.m;
import android.support.v7.view.menu.p;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

final class ActionMenuPresenter extends android.support.v7.view.menu.b implements android.support.v4.view.d.a {
    private Drawable SA;
    private boolean SB;
    private boolean SC;
    private boolean SD;
    private int SE;
    private int SF;
    int SG;
    boolean SH;
    private boolean SI;
    private boolean SJ;
    boolean SK;
    private int SL;
    private final SparseBooleanArray SM = new SparseBooleanArray();
    private View SN;
    public e SO;
    public a SP;
    public c SQ;
    private b SR;
    final f SS = new f(this);
    int ST;
    public d Sz;

    private static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public int SZ;

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.SZ = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.SZ);
        }
    }

    private class c implements Runnable {
        final /* synthetic */ ActionMenuPresenter SU;
        private e SV;

        public c(ActionMenuPresenter actionMenuPresenter, e eVar) {
            this.SU = actionMenuPresenter;
            this.SV = eVar;
        }

        public final void run() {
            android.support.v7.view.menu.f fVar = this.SU.dW;
            if (fVar.Qr != null) {
                fVar.Qr.b(fVar);
            }
            View view = (View) this.SU.PV;
            if (!(view == null || view.getWindowToken() == null || !this.SV.dL())) {
                this.SU.SO = this.SV;
            }
            this.SU.SQ = null;
        }
    }

    private class b extends android.support.v7.view.menu.ActionMenuItemView.b {
        final /* synthetic */ ActionMenuPresenter SU;

        public b(ActionMenuPresenter actionMenuPresenter) {
            this.SU = actionMenuPresenter;
        }

        public final ListPopupWindow do() {
            return this.SU.SP != null ? this.SU.SP.Rm : null;
        }
    }

    private class f implements android.support.v7.view.menu.l.a {
        final /* synthetic */ ActionMenuPresenter SU;

        public f(ActionMenuPresenter actionMenuPresenter) {
            this.SU = actionMenuPresenter;
        }

        public final boolean d(android.support.v7.view.menu.f fVar) {
            if (fVar == null) {
                return false;
            }
            this.SU.ST = ((p) fVar).getItem().getItemId();
            android.support.v7.view.menu.l.a aVar = this.SU.dV;
            return aVar != null ? aVar.d(fVar) : false;
        }

        public final void a(android.support.v7.view.menu.f fVar, boolean z) {
            if (fVar instanceof p) {
                ((p) fVar).Ru.D(false);
            }
            android.support.v7.view.menu.l.a aVar = this.SU.dV;
            if (aVar != null) {
                aVar.a(fVar, z);
            }
        }
    }

    private class a extends k {
        private p QN;
        final /* synthetic */ ActionMenuPresenter SU;

        public a(ActionMenuPresenter actionMenuPresenter, Context context, p pVar) {
            boolean z = false;
            this.SU = actionMenuPresenter;
            super(context, pVar, null, false, android.support.v7.a.a.a.actionOverflowMenuStyle);
            this.QN = pVar;
            if (!((h) pVar.getItem()).dH()) {
                this.hz = actionMenuPresenter.Sz == null ? (View) actionMenuPresenter.PV : actionMenuPresenter.Sz;
            }
            this.QM = actionMenuPresenter.SS;
            int size = pVar.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = pVar.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
            }
            this.Qh = z;
        }

        public final void onDismiss() {
            super.onDismiss();
            this.SU.SP = null;
            this.SU.ST = 0;
        }
    }

    private class d extends AppCompatImageView implements android.support.v7.widget.ActionMenuView.a {
        final /* synthetic */ ActionMenuPresenter SU;
        private final float[] SW = new float[2];

        public d(final ActionMenuPresenter actionMenuPresenter, Context context) {
            this.SU = actionMenuPresenter;
            super(context, null, android.support.v7.a.a.a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            setOnTouchListener(new android.support.v7.widget.ListPopupWindow.b(this, this) {
                final /* synthetic */ d SY;

                public final ListPopupWindow do() {
                    if (this.SY.SU.SO == null) {
                        return null;
                    }
                    return this.SY.SU.SO.Rm;
                }

                public final boolean dp() {
                    this.SY.SU.showOverflowMenu();
                    return true;
                }

                public final boolean ea() {
                    if (this.SY.SU.SQ != null) {
                        return false;
                    }
                    this.SY.SU.hideOverflowMenu();
                    return true;
                }
            });
        }

        public final boolean performClick() {
            if (!super.performClick()) {
                playSoundEffect(0);
                this.SU.showOverflowMenu();
            }
            return true;
        }

        public final boolean dm() {
            return false;
        }

        public final boolean dn() {
            return false;
        }

        protected final boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                width = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                height = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                android.support.v4.b.a.a.a(background, width - max, height - max, width + max, height + max);
            }
            return frame;
        }
    }

    private class e extends k {
        final /* synthetic */ ActionMenuPresenter SU;

        public e(ActionMenuPresenter actionMenuPresenter, Context context, android.support.v7.view.menu.f fVar, View view) {
            this.SU = actionMenuPresenter;
            super(context, fVar, view, true, android.support.v7.a.a.a.actionOverflowMenuStyle);
            this.QM = actionMenuPresenter.SS;
        }

        public final void onDismiss() {
            super.onDismiss();
            if (this.SU.dW != null) {
                this.SU.dW.close();
            }
            this.SU.SO = null;
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, android.support.v7.a.a.h.KB, android.support.v7.a.a.h.KA);
    }

    public final void a(Context context, android.support.v7.view.menu.f fVar) {
        boolean z = true;
        super.a(context, fVar);
        Resources resources = context.getResources();
        android.support.v7.view.a n = android.support.v7.view.a.n(context);
        if (!this.SD) {
            if (VERSION.SDK_INT < 19 && ae.b(ViewConfiguration.get(n.mContext))) {
                z = false;
            }
            this.SC = z;
        }
        if (!this.SJ) {
            this.SE = n.mContext.getResources().getDisplayMetrics().widthPixels / 2;
        }
        if (!this.SH) {
            this.SG = n.mContext.getResources().getInteger(g.Ky);
        }
        int i = this.SE;
        if (this.SC) {
            if (this.Sz == null) {
                this.Sz = new d(this, this.PR);
                if (this.SB) {
                    this.Sz.setImageDrawable(this.SA);
                    this.SA = null;
                    this.SB = false;
                }
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.Sz.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.Sz.getMeasuredWidth();
        } else {
            this.Sz = null;
        }
        this.SF = i;
        this.SL = (int) (56.0f * resources.getDisplayMetrics().density);
        this.SN = null;
    }

    public final void dX() {
        this.SC = true;
        this.SD = true;
    }

    public final m c(ViewGroup viewGroup) {
        m c = super.c(viewGroup);
        ((ActionMenuView) c).a(this);
        return c;
    }

    public final View a(h hVar, View view, ViewGroup viewGroup) {
        View actionView = hVar.getActionView();
        if (actionView == null || hVar.dK()) {
            actionView = super.a(hVar, view, viewGroup);
        }
        actionView.setVisibility(hVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(ActionMenuView.c(layoutParams));
        }
        return actionView;
    }

    public final void a(h hVar, android.support.v7.view.menu.m.a aVar) {
        aVar.a(hVar);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.PI = (ActionMenuView) this.PV;
        if (this.SR == null) {
            this.SR = new b(this);
        }
        actionMenuItemView.PK = this.SR;
    }

    public final boolean e(h hVar) {
        return hVar.dH();
    }

    public final void f(boolean z) {
        int i;
        int i2 = 1;
        int i3 = 0;
        ((View) this.PV).getParent();
        super.f(z);
        ((View) this.PV).requestLayout();
        if (this.dW != null) {
            android.support.v7.view.menu.f fVar = this.dW;
            fVar.dA();
            ArrayList arrayList = fVar.Qu;
            int size = arrayList.size();
            for (i = 0; i < size; i++) {
                android.support.v4.view.d dVar = ((h) arrayList.get(i)).QR;
                if (dVar != null) {
                    dVar.ww = this;
                }
            }
        }
        ArrayList dB = this.dW != null ? this.dW.dB() : null;
        if (this.SC && dB != null) {
            i = dB.size();
            if (i == 1) {
                int i4;
                if (((h) dB.get(0)).isActionViewExpanded()) {
                    i4 = 0;
                } else {
                    i4 = 1;
                }
                i3 = i4;
            } else {
                if (i <= 0) {
                    i2 = 0;
                }
                i3 = i2;
            }
        }
        if (i3 != 0) {
            if (this.Sz == null) {
                this.Sz = new d(this, this.PR);
            }
            ViewGroup viewGroup = (ViewGroup) this.Sz.getParent();
            if (viewGroup != this.PV) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.Sz);
                }
                ((ActionMenuView) this.PV).addView(this.Sz, ActionMenuView.ec());
            }
        } else if (this.Sz != null && this.Sz.getParent() == this.PV) {
            ((ViewGroup) this.PV).removeView(this.Sz);
        }
        ((ActionMenuView) this.PV).SC = this.SC;
    }

    public final boolean c(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.Sz) {
            return false;
        }
        return super.c(viewGroup, i);
    }

    public final boolean a(p pVar) {
        if (!pVar.hasVisibleItems()) {
            return false;
        }
        View view;
        p pVar2 = pVar;
        while (pVar2.Ru != this.dW) {
            pVar2 = (p) pVar2.Ru;
        }
        h item = pVar2.getItem();
        ViewGroup viewGroup = (ViewGroup) this.PV;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if ((childAt instanceof android.support.v7.view.menu.m.a) && ((android.support.v7.view.menu.m.a) childAt).z() == item) {
                    view = childAt;
                    break;
                }
            }
        }
        view = null;
        if (view == null) {
            if (this.Sz == null) {
                return false;
            }
            view = this.Sz;
        }
        this.ST = pVar.getItem().getItemId();
        this.SP = new a(this, this.mContext, pVar);
        this.SP.hz = view;
        if (this.SP.dL()) {
            super.a(pVar);
            return true;
        }
        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }

    public final boolean showOverflowMenu() {
        if (!this.SC || isOverflowMenuShowing() || this.dW == null || this.PV == null || this.SQ != null || this.dW.dB().isEmpty()) {
            return false;
        }
        this.SQ = new c(this, new e(this, this.mContext, this.dW, this.Sz));
        ((View) this.PV).post(this.SQ);
        super.a(null);
        return true;
    }

    public final boolean hideOverflowMenu() {
        if (this.SQ == null || this.PV == null) {
            k kVar = this.SO;
            if (kVar == null) {
                return false;
            }
            kVar.dismiss();
            return true;
        }
        ((View) this.PV).removeCallbacks(this.SQ);
        this.SQ = null;
        return true;
    }

    public final boolean dY() {
        return hideOverflowMenu() | dZ();
    }

    public final boolean dZ() {
        if (this.SP == null) {
            return false;
        }
        this.SP.dismiss();
        return true;
    }

    public final boolean isOverflowMenuShowing() {
        return this.SO != null && this.SO.isShowing();
    }

    public final boolean B() {
        int i;
        ArrayList dz = this.dW.dz();
        int size = dz.size();
        int i2 = this.SG;
        int i3 = this.SF;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.PV;
        int i4 = 0;
        int i5 = 0;
        Object obj = null;
        int i6 = 0;
        while (i6 < size) {
            h hVar = (h) dz.get(i6);
            if (hVar.dJ()) {
                i4++;
            } else if (hVar.dI()) {
                i5++;
            } else {
                obj = 1;
            }
            if (this.SK && hVar.isActionViewExpanded()) {
                i = 0;
            } else {
                i = i2;
            }
            i6++;
            i2 = i;
        }
        if (this.SC && (r4 != null || i4 + i5 > i2)) {
            i2--;
        }
        i6 = i2 - i4;
        SparseBooleanArray sparseBooleanArray = this.SM;
        sparseBooleanArray.clear();
        if (this.SI) {
            int i7 = i3 / this.SL;
            i5 = ((i3 % this.SL) / i7) + this.SL;
            i = i7;
        } else {
            i5 = 0;
            i = 0;
        }
        i2 = 0;
        int i8 = 0;
        i4 = i;
        while (i8 < size) {
            h hVar2 = (h) dz.get(i8);
            View a;
            int i9;
            if (hVar2.dJ()) {
                a = a(hVar2, this.SN, viewGroup);
                if (this.SN == null) {
                    this.SN = a;
                }
                if (this.SI) {
                    i = i4 - ActionMenuView.d(a, i5, i4, makeMeasureSpec, 0);
                } else {
                    a.measure(makeMeasureSpec, makeMeasureSpec);
                    i = i4;
                }
                i4 = a.getMeasuredWidth();
                i9 = i3 - i4;
                if (i2 != 0) {
                    i4 = i2;
                }
                i2 = hVar2.getGroupId();
                if (i2 != 0) {
                    sparseBooleanArray.put(i2, true);
                }
                hVar2.H(true);
                i7 = i9;
                i2 = i6;
            } else if (hVar2.dI()) {
                boolean z;
                int groupId = hVar2.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId);
                boolean z3 = (i6 > 0 || z2) && i3 > 0 && (!this.SI || i4 > 0);
                if (z3) {
                    a = a(hVar2, this.SN, viewGroup);
                    if (this.SN == null) {
                        this.SN = a;
                    }
                    if (this.SI) {
                        int d = ActionMenuView.d(a, i5, i4, makeMeasureSpec, 0);
                        i4 -= d;
                        if (d == 0) {
                            i = 0;
                        }
                    } else {
                        a.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    i9 = a.getMeasuredWidth();
                    i3 -= i9;
                    if (i2 == 0) {
                        i2 = i9;
                    }
                    if (this.SI) {
                        z = i & (i3 >= 0 ? 1 : 0);
                        i9 = i4;
                    } else {
                        z = i & (i3 + i2 > 0 ? 1 : 0);
                        i9 = i4;
                    }
                } else {
                    z = z3;
                    i9 = i4;
                }
                if (z && groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                    i = i6;
                } else if (z2) {
                    sparseBooleanArray.put(groupId, false);
                    i4 = i6;
                    for (i6 = 0; i6 < i8; i6++) {
                        hVar = (h) dz.get(i6);
                        if (hVar.getGroupId() == groupId) {
                            if (hVar.dH()) {
                                i4++;
                            }
                            hVar.H(false);
                        }
                    }
                    i = i4;
                } else {
                    i = i6;
                }
                if (z) {
                    i--;
                }
                hVar2.H(z);
                i4 = i2;
                i7 = i3;
                i2 = i;
                i = i9;
            } else {
                hVar2.H(false);
                i = i4;
                i7 = i3;
                i4 = i2;
                i2 = i6;
            }
            i8++;
            i3 = i7;
            i6 = i2;
            i2 = i4;
            i4 = i;
        }
        return true;
    }

    public final void a(android.support.v7.view.menu.f fVar, boolean z) {
        dY();
        super.a(fVar, z);
    }

    public final Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState();
        savedState.SZ = this.ST;
        return savedState;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            if (savedState.SZ > 0) {
                MenuItem findItem = this.dW.findItem(savedState.SZ);
                if (findItem != null) {
                    a((p) findItem.getSubMenu());
                }
            }
        }
    }

    public final void q(boolean z) {
        if (z) {
            super.a(null);
        } else {
            this.dW.D(false);
        }
    }

    public final void a(ActionMenuView actionMenuView) {
        this.PV = actionMenuView;
        actionMenuView.dW = this.dW;
    }
}
