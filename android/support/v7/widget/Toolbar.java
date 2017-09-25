package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.m;
import android.support.v4.view.o;
import android.support.v4.view.z;
import android.support.v7.a.a.k;
import android.support.v7.view.c;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.l;
import android.support.v7.view.menu.p;
import android.support.v7.widget.ActionMenuView.d;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private boolean RC;
    private boolean RD;
    private Context Rx;
    ActionMenuView Ry;
    private int Ta;
    android.support.v7.view.menu.l.a Tc;
    android.support.v7.view.menu.f.a Td;
    private final h Um;
    TextView aeH;
    TextView aeI;
    ImageButton aeJ;
    private ImageView aeK;
    private Drawable aeL;
    private CharSequence aeM;
    private ImageButton aeN;
    View aeO;
    int aeP;
    int aeQ;
    private int aeR;
    private int aeS;
    private int aeT;
    private int aeU;
    private int aeV;
    private int aeW;
    final ag aeX;
    public CharSequence aeY;
    CharSequence aeZ;
    private int afa;
    private int afb;
    private final ArrayList<View> afc;
    final ArrayList<View> afd;
    private final int[] afe;
    private b aff;
    private final d afg;
    private aq afh;
    private ActionMenuPresenter afi;
    a afj;
    boolean afk;
    private final Runnable afl;
    private int tW;

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int afp;
        boolean afq;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.afp = parcel.readInt();
            this.afq = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.afp);
            parcel.writeInt(this.afq ? 1 : 0);
        }
    }

    public interface b {
        boolean ee();
    }

    public static class LayoutParams extends android.support.v7.app.ActionBar.LayoutParams {
        int afo;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.afo = 0;
        }

        public LayoutParams() {
            super(-2, -2);
            this.afo = 0;
            this.gravity = 8388627;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((android.support.v7.app.ActionBar.LayoutParams) layoutParams);
            this.afo = 0;
            this.afo = layoutParams.afo;
        }

        public LayoutParams(android.support.v7.app.ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
            this.afo = 0;
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super((android.view.ViewGroup.LayoutParams) marginLayoutParams);
            this.afo = 0;
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.afo = 0;
        }
    }

    private class a implements l {
        final /* synthetic */ Toolbar afm;
        h afn;
        f dW;

        public a(Toolbar toolbar) {
            this.afm = toolbar;
        }

        public final void a(Context context, f fVar) {
            if (!(this.dW == null || this.afn == null)) {
                this.dW.h(this.afn);
            }
            this.dW = fVar;
        }

        public final void f(boolean z) {
            Object obj = null;
            if (this.afn != null) {
                if (this.dW != null) {
                    int size = this.dW.size();
                    for (int i = 0; i < size; i++) {
                        if (this.dW.getItem(i) == this.afn) {
                            obj = 1;
                            break;
                        }
                    }
                }
                if (obj == null) {
                    c(this.afn);
                }
            }
        }

        public final boolean a(p pVar) {
            return false;
        }

        public final void a(f fVar, boolean z) {
        }

        public final boolean B() {
            return false;
        }

        public final boolean b(h hVar) {
            Toolbar.b(this.afm);
            if (this.afm.aeN.getParent() != this.afm) {
                this.afm.addView(this.afm.aeN);
            }
            this.afm.aeO = hVar.getActionView();
            this.afn = hVar;
            if (this.afm.aeO.getParent() != this.afm) {
                android.view.ViewGroup.LayoutParams gY = Toolbar.gY();
                gY.gravity = 8388611 | (this.afm.aeR & MMGIFException.D_GIF_ERR_IMAGE_DEFECT);
                gY.afo = 2;
                this.afm.aeO.setLayoutParams(gY);
                this.afm.addView(this.afm.aeO);
            }
            Toolbar toolbar = this.afm;
            for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = toolbar.getChildAt(childCount);
                if (!(((LayoutParams) childAt.getLayoutParams()).afo == 2 || childAt == toolbar.Ry)) {
                    toolbar.removeViewAt(childCount);
                    toolbar.afd.add(childAt);
                }
            }
            this.afm.requestLayout();
            hVar.I(true);
            if (this.afm.aeO instanceof c) {
                ((c) this.afm.aeO).onActionViewExpanded();
            }
            return true;
        }

        public final boolean c(h hVar) {
            if (this.afm.aeO instanceof c) {
                ((c) this.afm.aeO).onActionViewCollapsed();
            }
            this.afm.removeView(this.afm.aeO);
            this.afm.removeView(this.afm.aeN);
            this.afm.aeO = null;
            Toolbar toolbar = this.afm;
            for (int size = toolbar.afd.size() - 1; size >= 0; size--) {
                toolbar.addView((View) toolbar.afd.get(size));
            }
            toolbar.afd.clear();
            this.afn = null;
            this.afm.requestLayout();
            hVar.I(false);
            return true;
        }

        public final int getId() {
            return 0;
        }

        public final Parcelable onSaveInstanceState() {
            return null;
        }

        public final void onRestoreInstanceState(Parcelable parcelable) {
        }
    }

    static /* synthetic */ void b(Toolbar toolbar) {
        if (toolbar.aeN == null) {
            toolbar.aeN = new ImageButton(toolbar.getContext(), null, android.support.v7.a.a.a.IK);
            toolbar.aeN.setImageDrawable(toolbar.aeL);
            toolbar.aeN.setContentDescription(toolbar.aeM);
            android.view.ViewGroup.LayoutParams layoutParams = new LayoutParams();
            layoutParams.gravity = 8388611 | (toolbar.aeR & MMGIFException.D_GIF_ERR_IMAGE_DEFECT);
            layoutParams.afo = 2;
            toolbar.aeN.setLayoutParams(layoutParams);
            toolbar.aeN.setOnClickListener(new OnClickListener(toolbar) {
                final /* synthetic */ Toolbar afm;

                {
                    this.afm = r1;
                }

                public final void onClick(View view) {
                    this.afm.collapseActionView();
                }
            });
        }
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return f(layoutParams);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.a.a.a.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aeX = new ag();
        this.tW = 8388627;
        this.afc = new ArrayList();
        this.afd = new ArrayList();
        this.afe = new int[2];
        this.afg = new d(this) {
            final /* synthetic */ Toolbar afm;

            {
                this.afm = r1;
            }

            public final boolean ee() {
                if (this.afm.aff != null) {
                    return this.afm.aff.ee();
                }
                return false;
            }
        };
        this.afl = new Runnable(this) {
            final /* synthetic */ Toolbar afm;

            {
                this.afm = r1;
            }

            public final void run() {
                this.afm.showOverflowMenu();
            }
        };
        ap a = ap.a(getContext(), attributeSet, k.dD, i);
        this.aeP = a.getResourceId(k.NR, 0);
        this.aeQ = a.getResourceId(k.NJ, 0);
        this.tW = a.aeG.getInteger(k.Nv, this.tW);
        this.aeR = 48;
        int dimensionPixelOffset = a.getDimensionPixelOffset(k.NQ, 0);
        this.aeW = dimensionPixelOffset;
        this.aeV = dimensionPixelOffset;
        this.aeU = dimensionPixelOffset;
        this.aeT = dimensionPixelOffset;
        dimensionPixelOffset = a.getDimensionPixelOffset(k.NO, -1);
        if (dimensionPixelOffset >= 0) {
            this.aeT = dimensionPixelOffset;
        }
        dimensionPixelOffset = a.getDimensionPixelOffset(k.NN, -1);
        if (dimensionPixelOffset >= 0) {
            this.aeU = dimensionPixelOffset;
        }
        dimensionPixelOffset = a.getDimensionPixelOffset(k.NP, -1);
        if (dimensionPixelOffset >= 0) {
            this.aeV = dimensionPixelOffset;
        }
        dimensionPixelOffset = a.getDimensionPixelOffset(k.NM, -1);
        if (dimensionPixelOffset >= 0) {
            this.aeW = dimensionPixelOffset;
        }
        this.aeS = a.getDimensionPixelSize(k.NE, -1);
        dimensionPixelOffset = a.getDimensionPixelOffset(k.NB, Integer.MIN_VALUE);
        int dimensionPixelOffset2 = a.getDimensionPixelOffset(k.Ny, Integer.MIN_VALUE);
        int dimensionPixelSize = a.getDimensionPixelSize(k.Nz, 0);
        int dimensionPixelSize2 = a.getDimensionPixelSize(k.NA, 0);
        ag agVar = this.aeX;
        agVar.abK = false;
        if (dimensionPixelSize != Integer.MIN_VALUE) {
            agVar.abI = dimensionPixelSize;
            agVar.abF = dimensionPixelSize;
        }
        if (dimensionPixelSize2 != Integer.MIN_VALUE) {
            agVar.abJ = dimensionPixelSize2;
            agVar.abG = dimensionPixelSize2;
        }
        if (!(dimensionPixelOffset == Integer.MIN_VALUE && dimensionPixelOffset2 == Integer.MIN_VALUE)) {
            this.aeX.ac(dimensionPixelOffset, dimensionPixelOffset2);
        }
        this.aeL = a.getDrawable(k.Nx);
        this.aeM = a.getText(k.Nw);
        CharSequence text = a.getText(k.NL);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        text = a.getText(k.NI);
        if (!TextUtils.isEmpty(text)) {
            setSubtitle(text);
        }
        this.Rx = getContext();
        setPopupTheme(a.getResourceId(k.NH, 0));
        Drawable drawable = a.getDrawable(k.NG);
        if (drawable != null) {
            setNavigationIcon(drawable);
        }
        text = a.getText(k.NF);
        if (!TextUtils.isEmpty(text)) {
            setNavigationContentDescription(text);
        }
        drawable = a.getDrawable(k.NC);
        if (drawable != null) {
            setLogo(drawable);
        }
        text = a.getText(k.ND);
        if (!TextUtils.isEmpty(text)) {
            if (!TextUtils.isEmpty(text)) {
                gV();
            }
            if (this.aeK != null) {
                this.aeK.setContentDescription(text);
            }
        }
        if (a.hasValue(k.NS)) {
            dimensionPixelOffset = a.bH(k.NS);
            this.afa = dimensionPixelOffset;
            if (this.aeH != null) {
                this.aeH.setTextColor(dimensionPixelOffset);
            }
        }
        if (a.hasValue(k.NK)) {
            dimensionPixelOffset = a.bH(k.NK);
            this.afb = dimensionPixelOffset;
            if (this.aeI != null) {
                this.aeI.setTextColor(dimensionPixelOffset);
            }
        }
        a.aeG.recycle();
        this.Um = h.ey();
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

    public void onRtlPropertiesChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        ag agVar = this.aeX;
        if (i != 1) {
            z = false;
        }
        if (z != agVar.gd) {
            agVar.gd = z;
            if (!agVar.abK) {
                agVar.abF = agVar.abI;
                agVar.abG = agVar.abJ;
            } else if (z) {
                agVar.abF = agVar.wd != Integer.MIN_VALUE ? agVar.wd : agVar.abI;
                agVar.abG = agVar.abH != Integer.MIN_VALUE ? agVar.abH : agVar.abJ;
            } else {
                agVar.abF = agVar.abH != Integer.MIN_VALUE ? agVar.abH : agVar.abI;
                agVar.abG = agVar.wd != Integer.MIN_VALUE ? agVar.wd : agVar.abJ;
            }
        }
    }

    public final boolean isOverflowMenuShowing() {
        if (this.Ry != null) {
            ActionMenuView actionMenuView = this.Ry;
            boolean z = actionMenuView.Tb != null && actionMenuView.Tb.isOverflowMenuShowing();
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final boolean showOverflowMenu() {
        if (this.Ry != null) {
            ActionMenuView actionMenuView = this.Ry;
            boolean z = actionMenuView.Tb != null && actionMenuView.Tb.showOverflowMenu();
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final void a(f fVar, ActionMenuPresenter actionMenuPresenter) {
        if (fVar != null || this.Ry != null) {
            gW();
            f fVar2 = this.Ry.dW;
            if (fVar2 != fVar) {
                if (fVar2 != null) {
                    fVar2.b(this.afi);
                    fVar2.b(this.afj);
                }
                if (this.afj == null) {
                    this.afj = new a(this);
                }
                actionMenuPresenter.SK = true;
                if (fVar != null) {
                    fVar.a((l) actionMenuPresenter, this.Rx);
                    fVar.a(this.afj, this.Rx);
                } else {
                    actionMenuPresenter.a(this.Rx, null);
                    this.afj.a(this.Rx, null);
                    actionMenuPresenter.f(true);
                    this.afj.f(true);
                }
                this.Ry.setPopupTheme(this.Ta);
                this.Ry.a(actionMenuPresenter);
                this.afi = actionMenuPresenter;
            }
        }
    }

    public final void setLogo(Drawable drawable) {
        if (drawable != null) {
            gV();
            if (!bv(this.aeK)) {
                e(this.aeK, true);
            }
        } else if (this.aeK != null && bv(this.aeK)) {
            removeView(this.aeK);
            this.afd.remove(this.aeK);
        }
        if (this.aeK != null) {
            this.aeK.setImageDrawable(drawable);
        }
    }

    private void gV() {
        if (this.aeK == null) {
            this.aeK = new ImageView(getContext());
        }
    }

    public final void collapseActionView() {
        h hVar = this.afj == null ? null : this.afj.afn;
        if (hVar != null) {
            hVar.collapseActionView();
        }
    }

    public final void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.aeH == null) {
                Context context = getContext();
                this.aeH = new TextView(context);
                this.aeH.setSingleLine();
                this.aeH.setEllipsize(TruncateAt.END);
                if (this.aeP != 0) {
                    this.aeH.setTextAppearance(context, this.aeP);
                }
                if (this.afa != 0) {
                    this.aeH.setTextColor(this.afa);
                }
            }
            if (!bv(this.aeH)) {
                e(this.aeH, true);
            }
        } else if (this.aeH != null && bv(this.aeH)) {
            removeView(this.aeH);
            this.afd.remove(this.aeH);
        }
        if (this.aeH != null) {
            this.aeH.setText(charSequence);
        }
        this.aeY = charSequence;
    }

    public final void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.aeI == null) {
                Context context = getContext();
                this.aeI = new TextView(context);
                this.aeI.setSingleLine();
                this.aeI.setEllipsize(TruncateAt.END);
                if (this.aeQ != 0) {
                    this.aeI.setTextAppearance(context, this.aeQ);
                }
                if (this.afb != 0) {
                    this.aeI.setTextColor(this.afb);
                }
            }
            if (!bv(this.aeI)) {
                e(this.aeI, true);
            }
        } else if (this.aeI != null && bv(this.aeI)) {
            removeView(this.aeI);
            this.afd.remove(this.aeI);
        }
        if (this.aeI != null) {
            this.aeI.setText(charSequence);
        }
        this.aeZ = charSequence;
    }

    public final CharSequence getNavigationContentDescription() {
        return this.aeJ != null ? this.aeJ.getContentDescription() : null;
    }

    public final void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            gX();
        }
        if (this.aeJ != null) {
            this.aeJ.setContentDescription(charSequence);
        }
    }

    public final void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            gX();
            if (!bv(this.aeJ)) {
                e(this.aeJ, true);
            }
        } else if (this.aeJ != null && bv(this.aeJ)) {
            removeView(this.aeJ);
            this.afd.remove(this.aeJ);
        }
        if (this.aeJ != null) {
            this.aeJ.setImageDrawable(drawable);
        }
    }

    public final void setNavigationOnClickListener(OnClickListener onClickListener) {
        gX();
        this.aeJ.setOnClickListener(onClickListener);
    }

    public final Menu getMenu() {
        gW();
        if (this.Ry.dW == null) {
            f fVar = (f) this.Ry.getMenu();
            if (this.afj == null) {
                this.afj = new a(this);
            }
            this.Ry.Tb.SK = true;
            fVar.a(this.afj, this.Rx);
        }
        return this.Ry.getMenu();
    }

    private void gW() {
        if (this.Ry == null) {
            this.Ry = new ActionMenuView(getContext());
            this.Ry.setPopupTheme(this.Ta);
            this.Ry.Th = this.afg;
            this.Ry.a(this.Tc, this.Td);
            android.view.ViewGroup.LayoutParams layoutParams = new LayoutParams();
            layoutParams.gravity = 8388613 | (this.aeR & MMGIFException.D_GIF_ERR_IMAGE_DEFECT);
            this.Ry.setLayoutParams(layoutParams);
            e(this.Ry, false);
        }
    }

    private void gX() {
        if (this.aeJ == null) {
            this.aeJ = new ImageButton(getContext(), null, android.support.v7.a.a.a.IK);
            android.view.ViewGroup.LayoutParams layoutParams = new LayoutParams();
            layoutParams.gravity = 8388611 | (this.aeR & MMGIFException.D_GIF_ERR_IMAGE_DEFECT);
            this.aeJ.setLayoutParams(layoutParams);
        }
    }

    private void e(View view, boolean z) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams();
        } else if (checkLayoutParams(layoutParams)) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        } else {
            layoutParams = f(layoutParams);
        }
        layoutParams.afo = 1;
        if (!z || this.aeO == null) {
            addView(view, layoutParams);
            return;
        }
        view.setLayoutParams(layoutParams);
        this.afd.add(view);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        if (!(this.afj == null || this.afj.afn == null)) {
            savedState.afp = this.afj.afn.getItemId();
        }
        savedState.afq = isOverflowMenuShowing();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            Menu menu = this.Ry != null ? this.Ry.dW : null;
            if (!(savedState.afp == 0 || this.afj == null || menu == null)) {
                MenuItem findItem = menu.findItem(savedState.afp);
                if (findItem != null) {
                    m.b(findItem);
                }
            }
            if (savedState.afq) {
                removeCallbacks(this.afl);
                post(this.afl);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.afl);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int d = o.d(motionEvent);
        if (d == 0) {
            this.RC = false;
        }
        if (!this.RC) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (d == 0 && !onTouchEvent) {
                this.RC = true;
            }
        }
        if (d == 1 || d == 3) {
            this.RC = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int d = o.d(motionEvent);
        if (d == 9) {
            this.RD = false;
        }
        if (!this.RD) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (d == 9 && !onHoverEvent) {
                this.RD = true;
            }
        }
        if (d == 10 || d == 3) {
            this.RD = false;
        }
        return true;
    }

    private void i(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + 0, marginLayoutParams.height);
        int mode = MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i4 >= 0) {
            if (mode != 0) {
                i4 = Math.min(MeasureSpec.getSize(childMeasureSpec2), i4);
            }
            childMeasureSpec2 = MeasureSpec.makeMeasureSpec(i4, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private int a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + max) + i2, marginLayoutParams.width), getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int max;
        int combineMeasuredStates;
        int i5;
        Object obj;
        int[] iArr = this.afe;
        if (at.bw(this)) {
            i3 = 0;
            i4 = 1;
        } else {
            i3 = 1;
            i4 = 0;
        }
        int i6 = 0;
        if (bs(this.aeJ)) {
            i(this.aeJ, i, 0, i2, this.aeS);
            i6 = this.aeJ.getMeasuredWidth() + bt(this.aeJ);
            max = Math.max(0, this.aeJ.getMeasuredHeight() + bu(this.aeJ));
            combineMeasuredStates = at.combineMeasuredStates(0, z.N(this.aeJ));
            i5 = max;
        } else {
            combineMeasuredStates = 0;
            i5 = 0;
        }
        if (bs(this.aeN)) {
            i(this.aeN, i, 0, i2, this.aeS);
            i6 = this.aeN.getMeasuredWidth() + bt(this.aeN);
            i5 = Math.max(i5, this.aeN.getMeasuredHeight() + bu(this.aeN));
            combineMeasuredStates = at.combineMeasuredStates(combineMeasuredStates, z.N(this.aeN));
        }
        ag agVar = this.aeX;
        int i7 = agVar.gd ? agVar.abG : agVar.abF;
        int max2 = Math.max(i7, i6) + 0;
        iArr[i4] = Math.max(0, i7 - i6);
        i6 = 0;
        if (bs(this.Ry)) {
            i(this.Ry, i, max2, i2, this.aeS);
            i6 = this.Ry.getMeasuredWidth() + bt(this.Ry);
            i5 = Math.max(i5, this.Ry.getMeasuredHeight() + bu(this.Ry));
            combineMeasuredStates = at.combineMeasuredStates(combineMeasuredStates, z.N(this.Ry));
        }
        agVar = this.aeX;
        i7 = agVar.gd ? agVar.abF : agVar.abG;
        max2 += Math.max(i7, i6);
        iArr[i3] = Math.max(0, i7 - i6);
        if (bs(this.aeO)) {
            max2 += a(this.aeO, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.aeO.getMeasuredHeight() + bu(this.aeO));
            combineMeasuredStates = at.combineMeasuredStates(combineMeasuredStates, z.N(this.aeO));
        }
        if (bs(this.aeK)) {
            max2 += a(this.aeK, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.aeK.getMeasuredHeight() + bu(this.aeK));
            combineMeasuredStates = at.combineMeasuredStates(combineMeasuredStates, z.N(this.aeK));
        }
        i4 = getChildCount();
        i3 = 0;
        int i8 = combineMeasuredStates;
        int i9 = i5;
        while (i3 < i4) {
            View childAt = getChildAt(i3);
            if (((LayoutParams) childAt.getLayoutParams()).afo == 0 && bs(childAt)) {
                max2 += a(childAt, i, max2, i2, 0, iArr);
                max = Math.max(i9, childAt.getMeasuredHeight() + bu(childAt));
                i6 = at.combineMeasuredStates(i8, z.N(childAt));
                i7 = max;
            } else {
                i6 = i8;
                i7 = i9;
            }
            i3++;
            i8 = i6;
            i9 = i7;
        }
        i7 = 0;
        i6 = 0;
        int i10 = this.aeV + this.aeW;
        max = this.aeT + this.aeU;
        if (bs(this.aeH)) {
            a(this.aeH, i, max2 + max, i2, i10, iArr);
            i7 = bt(this.aeH) + this.aeH.getMeasuredWidth();
            i6 = this.aeH.getMeasuredHeight() + bu(this.aeH);
            i8 = at.combineMeasuredStates(i8, z.N(this.aeH));
        }
        if (bs(this.aeI)) {
            i7 = Math.max(i7, a(this.aeI, i, max2 + max, i2, i10 + i6, iArr));
            i6 += this.aeI.getMeasuredHeight() + bu(this.aeI);
            i8 = at.combineMeasuredStates(i8, z.N(this.aeI));
        }
        i6 = Math.max(i9, i6) + (getPaddingTop() + getPaddingBottom());
        max = z.resolveSizeAndState(Math.max((i7 + max2) + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, WebView.NIGHT_MODE_COLOR & i8);
        i6 = z.resolveSizeAndState(Math.max(i6, getSuggestedMinimumHeight()), i2, i8 << 16);
        if (this.afk) {
            max2 = getChildCount();
            for (i7 = 0; i7 < max2; i7++) {
                View childAt2 = getChildAt(i7);
                if (bs(childAt2) && childAt2.getMeasuredWidth() > 0 && childAt2.getMeasuredHeight() > 0) {
                    obj = null;
                    break;
                }
            }
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            i6 = 0;
        }
        setMeasuredDimension(max, i6);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Object obj;
        int i5;
        int i6;
        int i7;
        int measuredHeight;
        int paddingTop;
        int measuredWidth;
        if (z.J(this) == 1) {
            obj = 1;
        } else {
            obj = null;
        }
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop2 = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i8 = width - paddingRight;
        int[] iArr = this.afe;
        iArr[1] = 0;
        iArr[0] = 0;
        int U = z.U(this);
        if (!bs(this.aeJ)) {
            i5 = paddingLeft;
        } else if (obj != null) {
            i8 = b(this.aeJ, i8, iArr, U);
            i5 = paddingLeft;
        } else {
            i5 = a(this.aeJ, paddingLeft, iArr, U);
        }
        if (bs(this.aeN)) {
            if (obj != null) {
                i8 = b(this.aeN, i8, iArr, U);
            } else {
                i5 = a(this.aeN, i5, iArr, U);
            }
        }
        if (bs(this.Ry)) {
            if (obj != null) {
                i5 = a(this.Ry, i5, iArr, U);
            } else {
                i8 = b(this.Ry, i8, iArr, U);
            }
        }
        iArr[0] = Math.max(0, this.aeX.abF - i5);
        iArr[1] = Math.max(0, this.aeX.abG - ((width - paddingRight) - i8));
        i5 = Math.max(i5, this.aeX.abF);
        i8 = Math.min(i8, (width - paddingRight) - this.aeX.abG);
        if (bs(this.aeO)) {
            if (obj != null) {
                i8 = b(this.aeO, i8, iArr, U);
            } else {
                i5 = a(this.aeO, i5, iArr, U);
            }
        }
        if (!bs(this.aeK)) {
            i6 = i8;
            i7 = i5;
        } else if (obj != null) {
            i6 = b(this.aeK, i8, iArr, U);
            i7 = i5;
        } else {
            i6 = i8;
            i7 = a(this.aeK, i5, iArr, U);
        }
        boolean bs = bs(this.aeH);
        boolean bs2 = bs(this.aeI);
        i5 = 0;
        if (bs) {
            LayoutParams layoutParams = (LayoutParams) this.aeH.getLayoutParams();
            i5 = (layoutParams.bottomMargin + (layoutParams.topMargin + this.aeH.getMeasuredHeight())) + 0;
        }
        if (bs2) {
            layoutParams = (LayoutParams) this.aeI.getLayoutParams();
            measuredHeight = (layoutParams.bottomMargin + (layoutParams.topMargin + this.aeI.getMeasuredHeight())) + i5;
        } else {
            measuredHeight = i5;
        }
        if (bs || bs2) {
            layoutParams = (LayoutParams) (bs ? this.aeH : this.aeI).getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) (bs2 ? this.aeI : this.aeH).getLayoutParams();
            Object obj2 = ((!bs || this.aeH.getMeasuredWidth() <= 0) && (!bs2 || this.aeI.getMeasuredWidth() <= 0)) ? null : 1;
            switch (this.tW & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                case 48:
                    paddingTop = (layoutParams.topMargin + getPaddingTop()) + this.aeV;
                    break;
                case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*80*/:
                    paddingTop = (((height - paddingBottom) - layoutParams2.bottomMargin) - this.aeW) - measuredHeight;
                    break;
                default:
                    paddingTop = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                    if (paddingTop < layoutParams.topMargin + this.aeV) {
                        i8 = layoutParams.topMargin + this.aeV;
                    } else {
                        measuredHeight = (((height - paddingBottom) - measuredHeight) - paddingTop) - paddingTop2;
                        if (measuredHeight < layoutParams.bottomMargin + this.aeW) {
                            i8 = Math.max(0, paddingTop - ((layoutParams2.bottomMargin + this.aeW) - measuredHeight));
                        } else {
                            i8 = paddingTop;
                        }
                    }
                    paddingTop = paddingTop2 + i8;
                    break;
            }
            if (obj != null) {
                i8 = (obj2 != null ? this.aeT : 0) - iArr[1];
                i5 = i6 - Math.max(0, i8);
                iArr[1] = Math.max(0, -i8);
                if (bs) {
                    layoutParams = (LayoutParams) this.aeH.getLayoutParams();
                    measuredWidth = i5 - this.aeH.getMeasuredWidth();
                    i6 = this.aeH.getMeasuredHeight() + paddingTop;
                    this.aeH.layout(measuredWidth, paddingTop, i5, i6);
                    paddingTop = i6 + layoutParams.bottomMargin;
                    i6 = measuredWidth - this.aeU;
                } else {
                    i6 = i5;
                }
                if (bs2) {
                    layoutParams = (LayoutParams) this.aeI.getLayoutParams();
                    measuredWidth = layoutParams.topMargin + paddingTop;
                    this.aeI.layout(i5 - this.aeI.getMeasuredWidth(), measuredWidth, i5, this.aeI.getMeasuredHeight() + measuredWidth);
                    measuredWidth = i5 - this.aeU;
                    i8 = layoutParams.bottomMargin;
                    i8 = measuredWidth;
                } else {
                    i8 = i5;
                }
                if (obj2 != null) {
                    i8 = Math.min(i6, i8);
                } else {
                    i8 = i5;
                }
                i6 = i8;
            } else {
                i8 = (obj2 != null ? this.aeT : 0) - iArr[0];
                i7 += Math.max(0, i8);
                iArr[0] = Math.max(0, -i8);
                if (bs) {
                    layoutParams = (LayoutParams) this.aeH.getLayoutParams();
                    i5 = this.aeH.getMeasuredWidth() + i7;
                    measuredWidth = this.aeH.getMeasuredHeight() + paddingTop;
                    this.aeH.layout(i7, paddingTop, i5, measuredWidth);
                    i8 = layoutParams.bottomMargin + measuredWidth;
                    measuredWidth = i5 + this.aeU;
                    i5 = i8;
                } else {
                    measuredWidth = i7;
                    i5 = paddingTop;
                }
                if (bs2) {
                    layoutParams = (LayoutParams) this.aeI.getLayoutParams();
                    i5 += layoutParams.topMargin;
                    paddingTop = this.aeI.getMeasuredWidth() + i7;
                    this.aeI.layout(i7, i5, paddingTop, this.aeI.getMeasuredHeight() + i5);
                    i5 = this.aeU + paddingTop;
                    i8 = layoutParams.bottomMargin;
                    i8 = i5;
                } else {
                    i8 = i7;
                }
                if (obj2 != null) {
                    i7 = Math.max(measuredWidth, i8);
                }
            }
        }
        a(this.afc, 3);
        int size = this.afc.size();
        measuredWidth = i7;
        for (i5 = 0; i5 < size; i5++) {
            measuredWidth = a((View) this.afc.get(i5), measuredWidth, iArr, U);
        }
        a(this.afc, 5);
        i7 = this.afc.size();
        i5 = 0;
        measuredHeight = i6;
        while (i5 < i7) {
            i6 = b((View) this.afc.get(i5), measuredHeight, iArr, U);
            i5++;
            measuredHeight = i6;
        }
        a(this.afc, 1);
        List list = this.afc;
        i6 = iArr[0];
        i7 = iArr[1];
        paddingTop2 = list.size();
        size = i6;
        paddingTop = i7;
        i6 = 0;
        i7 = 0;
        while (i6 < paddingTop2) {
            View view = (View) list.get(i6);
            layoutParams = (LayoutParams) view.getLayoutParams();
            size = layoutParams.leftMargin - size;
            i8 = layoutParams.rightMargin - paddingTop;
            paddingBottom = Math.max(0, size);
            int max = Math.max(0, i8);
            size = Math.max(0, -size);
            paddingTop = Math.max(0, -i8);
            i6++;
            i7 += (view.getMeasuredWidth() + paddingBottom) + max;
        }
        i8 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (i7 / 2);
        i5 = i8 + i7;
        if (i8 < measuredWidth) {
            i8 = measuredWidth;
        } else if (i5 > measuredHeight) {
            i8 -= i5 - measuredHeight;
        }
        paddingLeft = this.afc.size();
        measuredWidth = 0;
        i5 = i8;
        while (measuredWidth < paddingLeft) {
            i8 = a((View) this.afc.get(measuredWidth), i5, iArr, U);
            measuredWidth++;
            i5 = i8;
        }
        this.afc.clear();
    }

    private int a(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        i3 = p(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, i3, max + measuredWidth, view.getMeasuredHeight() + i3);
        return (layoutParams.rightMargin + measuredWidth) + max;
    }

    private int b(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        i3 = p(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, i3, max, view.getMeasuredHeight() + i3);
        return max - (layoutParams.leftMargin + measuredWidth);
    }

    private int p(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int i3 = layoutParams.gravity & MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
        switch (i3) {
            case 16:
            case 48:
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*80*/:
                break;
            default:
                i3 = this.tW & MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
                break;
        }
        switch (i3) {
            case 48:
                return getPaddingTop() - i2;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*80*/:
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin) - i2;
            default:
                int i4;
                i3 = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                i2 = (((height - i3) - paddingBottom) - measuredHeight) / 2;
                if (i2 < layoutParams.topMargin) {
                    i4 = layoutParams.topMargin;
                } else {
                    measuredHeight = (((height - paddingBottom) - measuredHeight) - i2) - i3;
                    i4 = measuredHeight < layoutParams.bottomMargin ? Math.max(0, i2 - (layoutParams.bottomMargin - measuredHeight)) : i2;
                }
                return i4 + i3;
        }
    }

    private void a(List<View> list, int i) {
        int i2 = 1;
        int i3 = 0;
        if (z.J(this) != 1) {
            i2 = 0;
        }
        int childCount = getChildCount();
        int absoluteGravity = android.support.v4.view.f.getAbsoluteGravity(i, z.J(this));
        list.clear();
        LayoutParams layoutParams;
        if (i2 != 0) {
            for (i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.afo == 0 && bs(childAt) && bI(layoutParams.gravity) == absoluteGravity) {
                    list.add(childAt);
                }
            }
            return;
        }
        while (i3 < childCount) {
            View childAt2 = getChildAt(i3);
            layoutParams = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams.afo == 0 && bs(childAt2) && bI(layoutParams.gravity) == absoluteGravity) {
                list.add(childAt2);
            }
            i3++;
        }
    }

    private int bI(int i) {
        int J = z.J(this);
        int absoluteGravity = android.support.v4.view.f.getAbsoluteGravity(i, J) & 7;
        switch (absoluteGravity) {
            case 1:
            case 3:
            case 5:
                return absoluteGravity;
            default:
                return J == 1 ? 5 : 3;
        }
    }

    private boolean bs(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private static int bt(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return android.support.v4.view.l.b(marginLayoutParams) + android.support.v4.view.l.a(marginLayoutParams);
    }

    private static int bu(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    private static LayoutParams f(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof android.support.v7.app.ActionBar.LayoutParams) {
            return new LayoutParams((android.support.v7.app.ActionBar.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    protected static LayoutParams gY() {
        return new LayoutParams();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public final u gZ() {
        if (this.afh == null) {
            this.afh = new aq(this);
        }
        return this.afh;
    }

    private boolean bv(View view) {
        return view.getParent() == this || this.afd.contains(view);
    }
}
