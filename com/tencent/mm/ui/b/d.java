package com.tencent.mm.ui.b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ai;
import android.support.v4.view.am;
import android.support.v4.view.an;
import android.support.v4.view.ao;
import android.support.v4.view.z;
import android.support.v7.a.a.k;
import android.support.v7.app.ActionBar;
import android.support.v7.view.b;
import android.support.v7.view.g;
import android.support.v7.view.h;
import android.support.v7.view.menu.f;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.u;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class d extends ActionBar implements android.support.v7.widget.ActionBarOverlayLayout.a {
    private static final Interpolator Ia = new AccelerateInterpolator();
    private static final Interpolator Ib = new DecelerateInterpolator();
    private static final boolean Ic = (VERSION.SDK_INT >= 14);
    public u HI;
    private boolean HL;
    private ArrayList<Object> HM = new ArrayList();
    final ao IA = new ao(this) {
        final /* synthetic */ d veM;

        {
            this.veM = r1;
        }

        public final void bZ() {
            ((View) this.veM.If.getParent()).invalidate();
        }
    };
    private Context Id;
    public ActionBarContainer If;
    public ActionBarContextView Ig;
    public View Ih;
    private boolean Ik;
    b Im;
    android.support.v7.view.b.a In;
    private int Ip = 0;
    public boolean Iq = true;
    public boolean Ir;
    public boolean Is;
    private boolean It;
    private boolean Iu = true;
    public h Iv;
    private boolean Iw;
    final am Iy = new an(this) {
        final /* synthetic */ d veM;

        {
            this.veM = r1;
        }

        public final void q(View view) {
            if (this.veM.Iq && this.veM.Ih != null) {
                z.c(this.veM.Ih, 0.0f);
                z.c(this.veM.If, 0.0f);
            }
            this.veM.If.setVisibility(8);
            this.veM.If.J(false);
            this.veM.Iv = null;
            d dVar = this.veM;
            if (dVar.In != null) {
                dVar.In.a(dVar.Im);
                dVar.Im = null;
                dVar.In = null;
            }
        }
    };
    final am Iz = new an(this) {
        final /* synthetic */ d veM;

        {
            this.veM = r1;
        }

        public final void q(View view) {
            this.veM.Iv = null;
            this.veM.If.requestLayout();
        }
    };
    public Context mContext;
    private Activity qb;
    a veL;

    public class a extends b implements android.support.v7.view.menu.f.a {
        private final Context IC;
        private android.support.v7.view.b.a IE;
        private WeakReference<View> IF;
        private final f dW;
        final /* synthetic */ d veM;

        public a(d dVar, Context context, android.support.v7.view.b.a aVar) {
            this.veM = dVar;
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
            if (this.veM.veL == this) {
                if (d.a(this.veM.Ir, this.veM.Is, false)) {
                    this.IE.a(this);
                } else {
                    this.veM.Im = this;
                    this.veM.In = this.IE;
                }
                this.IE = null;
                this.veM.C(false);
                this.veM.Ig.dN();
                this.veM.HI.eI().sendAccessibilityEvent(32);
                this.veM.veL = null;
            }
        }

        public final void invalidate() {
            if (this.veM.veL == this) {
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
            this.veM.Ig.setCustomView(view);
            this.IF = new WeakReference(view);
        }

        public final void setSubtitle(CharSequence charSequence) {
            this.veM.Ig.setSubtitle(charSequence);
        }

        public final void setTitle(CharSequence charSequence) {
            this.veM.Ig.setTitle(charSequence);
        }

        public final void setTitle(int i) {
            setTitle(this.veM.mContext.getResources().getString(i));
        }

        public final void setSubtitle(int i) {
            setSubtitle(this.veM.mContext.getResources().getString(i));
        }

        public final CharSequence getTitle() {
            return this.veM.Ig.uI;
        }

        public final CharSequence getSubtitle() {
            return this.veM.Ig.uJ;
        }

        public final void setTitleOptionalHint(boolean z) {
            super.setTitleOptionalHint(z);
            this.veM.Ig.K(z);
        }

        public final boolean isTitleOptional() {
            return this.veM.Ig.RW;
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
                this.veM.Ig.showOverflowMenu();
            }
        }
    }

    public d(Activity activity, ViewGroup viewGroup) {
        u uVar;
        this.qb = activity;
        View findViewById = viewGroup.findViewById(android.support.v7.a.a.f.JL);
        if (findViewById instanceof u) {
            uVar = (u) findViewById;
        } else if (findViewById instanceof Toolbar) {
            uVar = ((Toolbar) findViewById).gZ();
        } else {
            throw new IllegalStateException(new StringBuilder("Can't make a decor toolbar out of ").append(findViewById).toString() != null ? findViewById.getClass().getSimpleName() : "null");
        }
        this.HI = uVar;
        this.Ig = (ActionBarContextView) viewGroup.findViewById(android.support.v7.a.a.f.JQ);
        this.If = (ActionBarContainer) viewGroup.findViewById(android.support.v7.a.a.f.JN);
        if (this.HI == null || this.Ig == null || this.If == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        boolean z;
        this.mContext = this.HI.getContext();
        if ((this.HI.getDisplayOptions() & 4) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.Ik = true;
        }
        android.support.v7.view.a.n(this.mContext).df();
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(null, k.aV, android.support.v7.a.a.a.actionBarStyle, 0);
        obtainStyledAttributes.getBoolean(k.Lh, false);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(k.Lf, 0);
        if (dimensionPixelSize != 0) {
            setElevation((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
        this.Ih = null;
    }

    public final void setElevation(float f) {
        z.g(this.If, f);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        LayoutParams layoutParams = this.HI.eI().getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = com.tencent.mm.compatible.util.a.e(this.qb);
        }
        this.HI.eI().setLayoutParams(layoutParams);
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
        if (this.veL != null) {
            this.veL.finish();
        }
        this.Ig.dO();
        b aVar2 = new a(this, this.Ig.getContext(), aVar);
        if (!aVar2.dd()) {
            return null;
        }
        aVar2.invalidate();
        this.Ig.c(aVar2);
        C(true);
        this.Ig.sendAccessibilityEvent(32);
        this.veL = aVar2;
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
        ai r;
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
                    return;
                }
                z.d(this.If, 1.0f);
                z.c(this.If, 0.0f);
                if (this.Iq && this.Ih != null) {
                    z.c(this.Ih, 0.0f);
                }
                this.Iz.q(null);
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
        return this.Iu && (height == 0 || height > 0);
    }

    public final void C(boolean z) {
        ai c;
        ai c2;
        if (z) {
            if (!this.It) {
                this.It = true;
                B(false);
            }
        } else if (this.It) {
            this.It = false;
            B(false);
        }
        if (z) {
            c = this.HI.c(8, 100);
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
