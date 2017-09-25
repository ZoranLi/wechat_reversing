package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.am;
import android.support.v4.view.an;
import android.support.v4.view.ao;
import android.support.v4.view.z;
import android.support.v7.a.a.k;
import android.support.v7.view.b;
import android.support.v7.view.g;
import android.support.v7.view.h;
import android.support.v7.view.menu.f;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ai;
import android.support.v7.widget.u;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class n extends ActionBar implements android.support.v7.widget.ActionBarOverlayLayout.a {
    static final /* synthetic */ boolean $assertionsDisabled = (!n.class.desiredAssertionStatus());
    private static final Interpolator Ia = new AccelerateInterpolator();
    private static final Interpolator Ib = new DecelerateInterpolator();
    private static final boolean Ic;
    public u HI;
    private boolean HL;
    private ArrayList<Object> HM = new ArrayList();
    final ao IA = new ao(this) {
        final /* synthetic */ n IB;

        {
            this.IB = r1;
        }

        public final void bZ() {
            ((View) this.IB.If.getParent()).invalidate();
        }
    };
    private Context Id;
    public ActionBarOverlayLayout Ie;
    public ActionBarContainer If;
    public ActionBarContextView Ig;
    public View Ih;
    public ai Ii;
    private int Ij = -1;
    private boolean Ik;
    a Il;
    b Im;
    android.support.v7.view.b.a In;
    private boolean Io;
    private int Ip = 0;
    public boolean Iq = true;
    public boolean Ir;
    public boolean Is;
    private boolean It;
    private boolean Iu = true;
    public h Iv;
    private boolean Iw;
    boolean Ix;
    final am Iy = new an(this) {
        final /* synthetic */ n IB;

        {
            this.IB = r1;
        }

        public final void q(View view) {
            if (this.IB.Iq && this.IB.Ih != null) {
                z.c(this.IB.Ih, 0.0f);
                z.c(this.IB.If, 0.0f);
            }
            this.IB.If.setVisibility(8);
            this.IB.If.J(false);
            this.IB.Iv = null;
            n nVar = this.IB;
            if (nVar.In != null) {
                nVar.In.a(nVar.Im);
                nVar.Im = null;
                nVar.In = null;
            }
            if (this.IB.Ie != null) {
                z.Z(this.IB.Ie);
            }
        }
    };
    final am Iz = new an(this) {
        final /* synthetic */ n IB;

        {
            this.IB = r1;
        }

        public final void q(View view) {
            this.IB.Iv = null;
            this.IB.If.requestLayout();
        }
    };
    private ArrayList<Object> jT = new ArrayList();
    public Context mContext;
    private Dialog oL;
    private Activity qb;

    public class a extends b implements android.support.v7.view.menu.f.a {
        final /* synthetic */ n IB;
        private final Context IC;
        private android.support.v7.view.b.a IE;
        private WeakReference<View> IF;
        private final f dW;

        public a(n nVar, Context context, android.support.v7.view.b.a aVar) {
            this.IB = nVar;
            this.IC = context;
            this.IE = aVar;
            f fVar = new f(context);
            this.dW = fVar;
            this.dW.a((android.support.v7.view.menu.f.a) this);
        }

        public final MenuInflater getMenuInflater() {
            return new g(this.IC);
        }

        public final Menu getMenu() {
            return this.dW;
        }

        public final void finish() {
            if (this.IB.Il == this) {
                if (n.a(this.IB.Ir, this.IB.Is, false)) {
                    this.IE.a(this);
                } else {
                    this.IB.Im = this;
                    this.IB.In = this.IE;
                }
                this.IE = null;
                this.IB.C(false);
                this.IB.Ig.dN();
                this.IB.HI.eI().sendAccessibilityEvent(32);
                this.IB.Ie.setHideOnContentScrollEnabled(this.IB.Ix);
                this.IB.Il = null;
            }
        }

        public final void invalidate() {
            if (this.IB.Il == this) {
                this.dW.dv();
                try {
                    this.IE.b(this, this.dW);
                } finally {
                    this.dW.dw();
                }
            }
        }

        public final boolean dd() {
            this.dW.dv();
            try {
                boolean a = this.IE.a((b) this, this.dW);
                return a;
            } finally {
                this.dW.dw();
            }
        }

        public final void setCustomView(View view) {
            this.IB.Ig.setCustomView(view);
            this.IF = new WeakReference(view);
        }

        public final void setSubtitle(CharSequence charSequence) {
            this.IB.Ig.setSubtitle(charSequence);
        }

        public final void setTitle(CharSequence charSequence) {
            this.IB.Ig.setTitle(charSequence);
        }

        public final void setTitle(int i) {
            setTitle(this.IB.mContext.getResources().getString(i));
        }

        public final void setSubtitle(int i) {
            setSubtitle(this.IB.mContext.getResources().getString(i));
        }

        public final CharSequence getTitle() {
            return this.IB.Ig.uI;
        }

        public final CharSequence getSubtitle() {
            return this.IB.Ig.uJ;
        }

        public final void setTitleOptionalHint(boolean z) {
            super.setTitleOptionalHint(z);
            this.IB.Ig.K(z);
        }

        public final boolean isTitleOptional() {
            return this.IB.Ig.RW;
        }

        public final View getCustomView() {
            return this.IF != null ? (View) this.IF.get() : null;
        }

        public final boolean a(f fVar, MenuItem menuItem) {
            if (this.IE != null) {
                return this.IE.a((b) this, menuItem);
            }
            return false;
        }

        public final void b(f fVar) {
            if (this.IE != null) {
                invalidate();
                this.IB.Ig.showOverflowMenu();
            }
        }
    }

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 14) {
            z = false;
        }
        Ic = z;
    }

    public n(Activity activity, boolean z) {
        this.qb = activity;
        View decorView = activity.getWindow().getDecorView();
        aJ(decorView);
        if (!z) {
            this.Ih = decorView.findViewById(16908290);
        }
    }

    public n(Dialog dialog) {
        this.oL = dialog;
        aJ(dialog.getWindow().getDecorView());
    }

    private void aJ(View view) {
        View view2;
        u uVar;
        this.Ie = (ActionBarOverlayLayout) view.findViewById(android.support.v7.a.a.f.JZ);
        if (this.Ie != null) {
            view2 = this.Ie;
            view2.Sr = this;
            if (view2.getWindowToken() != null) {
                view2.Sr.onWindowVisibilityChanged(view2.Sb);
                if (view2.Sk != 0) {
                    view2.onWindowSystemUiVisibilityChanged(view2.Sk);
                    z.Z(view2);
                }
            }
        }
        view2 = view.findViewById(android.support.v7.a.a.f.JL);
        if (view2 instanceof u) {
            uVar = (u) view2;
        } else if (view2 instanceof Toolbar) {
            uVar = ((Toolbar) view2).gZ();
        } else {
            throw new IllegalStateException(new StringBuilder("Can't make a decor toolbar out of ").append(view2).toString() != null ? view2.getClass().getSimpleName() : "null");
        }
        this.HI = uVar;
        this.Ig = (ActionBarContextView) view.findViewById(android.support.v7.a.a.f.JQ);
        this.If = (ActionBarContainer) view.findViewById(android.support.v7.a.a.f.JN);
        if (this.HI == null || this.Ig == null || this.If == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.mContext = this.HI.getContext();
        if ((this.HI.getDisplayOptions() & 4) != 0) {
            this.Ik = true;
        }
        android.support.v7.view.a n = android.support.v7.view.a.n(this.mContext);
        n.df();
        z(n.de());
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(null, k.aV, android.support.v7.a.a.a.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(k.Lh, false)) {
            if (this.Ie.Sg) {
                this.Ix = true;
                this.Ie.setHideOnContentScrollEnabled(true);
            } else {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(k.Lf, 0);
        if (dimensionPixelSize != 0) {
            setElevation((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    public final void setElevation(float f) {
        z.g(this.If, f);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        z(android.support.v7.view.a.n(this.mContext).de());
    }

    private void z(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        this.Io = z;
        if (this.Io) {
            this.If.a(null);
            this.HI.b(this.Ii);
        } else {
            this.HI.b(null);
            this.If.a(this.Ii);
        }
        if (this.HI.getNavigationMode() == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.Ii != null) {
            if (z2) {
                this.Ii.setVisibility(0);
                if (this.Ie != null) {
                    z.Z(this.Ie);
                }
            } else {
                this.Ii.setVisibility(8);
            }
        }
        u uVar = this.HI;
        if (this.Io || !z2) {
            z3 = false;
        } else {
            z3 = true;
        }
        uVar.N(z3);
        ActionBarOverlayLayout actionBarOverlayLayout = this.Ie;
        if (this.Io || !z2) {
            z4 = false;
        }
        actionBarOverlayLayout.Sh = z4;
    }

    public final void onWindowVisibilityChanged(int i) {
        this.Ip = i;
    }

    public final void x(boolean z) {
        this.Iw = z;
        if (!z && this.Iv != null) {
            this.Iv.cancel();
        }
    }

    public final void y(boolean z) {
        if (z != this.HL) {
            this.HL = z;
            int size = this.HM.size();
            for (int i = 0; i < size; i++) {
                this.HM.get(i);
            }
        }
    }

    public final void setCustomView(int i) {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(i, this.HI.eI(), false));
    }

    public final void cJ() {
        setDisplayOptions(0, 2);
    }

    public final void setDisplayHomeAsUpEnabled(boolean z) {
        setDisplayOptions(z ? 4 : 0, 4);
    }

    public final void cK() {
        setDisplayOptions(0, 8);
    }

    public final void cL() {
        setDisplayOptions(16, 16);
    }

    public final void e(CharSequence charSequence) {
        this.HI.e(charSequence);
    }

    public final boolean requestFocus() {
        ViewGroup eI = this.HI.eI();
        if (eI == null || eI.hasFocus()) {
            return false;
        }
        eI.requestFocus();
        return true;
    }

    public final void setDisplayOptions(int i) {
        if ((i & 4) != 0) {
            this.Ik = true;
        }
        this.HI.setDisplayOptions(i);
    }

    private void setDisplayOptions(int i, int i2) {
        int displayOptions = this.HI.getDisplayOptions();
        if ((i2 & 4) != 0) {
            this.Ik = true;
        }
        this.HI.setDisplayOptions((displayOptions & (i2 ^ -1)) | (i & i2));
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.If.l(drawable);
    }

    public final View getCustomView() {
        return this.HI.getCustomView();
    }

    public final CharSequence getTitle() {
        return this.HI.getTitle();
    }

    public final int getDisplayOptions() {
        return this.HI.getDisplayOptions();
    }

    public final b a(android.support.v7.view.b.a aVar) {
        if (this.Il != null) {
            this.Il.finish();
        }
        this.Ie.setHideOnContentScrollEnabled(false);
        this.Ig.dO();
        b aVar2 = new a(this, this.Ig.getContext(), aVar);
        if (!aVar2.dd()) {
            return null;
        }
        aVar2.invalidate();
        this.Ig.c(aVar2);
        C(true);
        this.Ig.sendAccessibilityEvent(32);
        this.Il = aVar2;
        return aVar2;
    }

    public final int getHeight() {
        return this.If.getHeight();
    }

    public final void A(boolean z) {
        this.Iq = z;
    }

    public final void show() {
        if (this.Ir) {
            this.Ir = false;
            B(false);
        }
    }

    public final void da() {
        if (this.Is) {
            this.Is = false;
            B(true);
        }
    }

    public final void hide() {
        if (!this.Ir) {
            this.Ir = true;
            B(false);
        }
    }

    public final void db() {
        if (!this.Is) {
            this.Is = true;
            B(true);
        }
    }

    public static boolean a(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        if (z || z2) {
            return false;
        }
        return true;
    }

    private void B(boolean z) {
        float f;
        h hVar;
        android.support.v4.view.ai r;
        if (a(this.Ir, this.Is, this.It)) {
            if (!this.Iu) {
                this.Iu = true;
                if (this.Iv != null) {
                    this.Iv.cancel();
                }
                this.If.setVisibility(0);
                if (this.Ip == 0 && Ic && (this.Iw || z)) {
                    z.c(this.If, 0.0f);
                    f = (float) (-this.If.getHeight());
                    if (z) {
                        int[] iArr = new int[]{0, 0};
                        this.If.getLocationInWindow(iArr);
                        f -= (float) iArr[1];
                    }
                    z.c(this.If, f);
                    hVar = new h();
                    r = z.V(this.If).r(0.0f);
                    r.a(this.IA);
                    hVar.a(r);
                    if (this.Iq && this.Ih != null) {
                        z.c(this.Ih, f);
                        hVar.a(z.V(this.Ih).r(0.0f));
                    }
                    hVar.c(Ib);
                    hVar.dk();
                    hVar.b(this.Iz);
                    this.Iv = hVar;
                    hVar.start();
                } else {
                    z.d(this.If, 1.0f);
                    z.c(this.If, 0.0f);
                    if (this.Iq && this.Ih != null) {
                        z.c(this.Ih, 0.0f);
                    }
                    this.Iz.q(null);
                }
                if (this.Ie != null) {
                    z.Z(this.Ie);
                }
            }
        } else if (this.Iu) {
            this.Iu = false;
            if (this.Iv != null) {
                this.Iv.cancel();
            }
            if (this.Ip == 0 && Ic && (this.Iw || z)) {
                z.d(this.If, 1.0f);
                this.If.J(true);
                hVar = new h();
                f = (float) (-this.If.getHeight());
                if (z) {
                    int[] iArr2 = new int[]{0, 0};
                    this.If.getLocationInWindow(iArr2);
                    f -= (float) iArr2[1];
                }
                r = z.V(this.If).r(f);
                r.a(this.IA);
                hVar.a(r);
                if (this.Iq && this.Ih != null) {
                    hVar.a(z.V(this.Ih).r(f));
                }
                hVar.c(Ia);
                hVar.dk();
                hVar.b(this.Iy);
                this.Iv = hVar;
                hVar.start();
                return;
            }
            this.Iy.q(null);
        }
    }

    public final boolean isShowing() {
        int height = this.If.getHeight();
        return this.Iu && (height == 0 || this.Ie.dR() < height);
    }

    public final void C(boolean z) {
        android.support.v4.view.ai c;
        android.support.v4.view.ai c2;
        if (z) {
            if (!this.It) {
                this.It = true;
                if (this.Ie != null) {
                    ActionBarOverlayLayout.dP();
                }
                B(false);
            }
        } else if (this.It) {
            this.It = false;
            if (this.Ie != null) {
                ActionBarOverlayLayout.dP();
            }
            B(false);
        }
        if (z) {
            c = this.HI.c(4, 100);
            c2 = this.Ig.c(0, 200);
        } else {
            c2 = this.HI.c(0, 200);
            c = this.Ig.c(8, 100);
        }
        h hVar = new h();
        hVar.a(c, c2);
        hVar.start();
    }

    public final Context getThemedContext() {
        if (this.Id == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(android.support.v7.a.a.a.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.Id = new ContextThemeWrapper(this.mContext, i);
            } else {
                this.Id = this.mContext;
            }
        }
        return this.Id;
    }

    public final void dc() {
        if (this.Iv != null) {
            this.Iv.cancel();
            this.Iv = null;
        }
    }

    public final boolean collapseActionView() {
        if (this.HI == null || !this.HI.hasExpandedActionView()) {
            return false;
        }
        this.HI.collapseActionView();
        return true;
    }

    public final void setCustomView(View view) {
        this.HI.setCustomView(view);
    }

    public final void setIcon(int i) {
        this.HI.setIcon(i);
    }

    public final void setLogo(Drawable drawable) {
        this.HI.setLogo(drawable);
    }

    public final void w(boolean z) {
        if (!this.Ik) {
            setDisplayHomeAsUpEnabled(z);
        }
    }
}
