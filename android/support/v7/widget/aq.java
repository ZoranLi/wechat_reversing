package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ai;
import android.support.v4.view.an;
import android.support.v4.view.z;
import android.support.v7.a.a.a;
import android.support.v7.a.a.e;
import android.support.v7.a.a.f;
import android.support.v7.a.a.i;
import android.support.v7.a.a.k;
import android.support.v7.view.menu.l;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;

public final class aq implements u {
    public Callback HJ;
    private ActionMenuPresenter Rz;
    private final h Um;
    private Drawable afA;
    private int afr;
    private View afs;
    private Drawable aft;
    private Drawable afu;
    private boolean afv;
    private CharSequence afw;
    public boolean afx;
    private int afy;
    private int afz;
    public Toolbar gz;
    private Drawable jQ;
    private View kD;
    public CharSequence uI;
    private CharSequence uJ;

    public aq(Toolbar toolbar) {
        this(toolbar, true, i.KS, e.Jg);
    }

    private aq(Toolbar toolbar, boolean z, int i, int i2) {
        Drawable drawable;
        Toolbar toolbar2;
        Context context;
        CharSequence charSequence = null;
        this.afy = 0;
        this.afz = 0;
        this.gz = toolbar;
        this.uI = toolbar.aeY;
        this.uJ = toolbar.aeZ;
        this.afv = this.uI != null;
        if (toolbar.aeJ != null) {
            drawable = toolbar.aeJ.getDrawable();
        } else {
            drawable = null;
        }
        this.afu = drawable;
        ap a = ap.a(toolbar.getContext(), null, k.aV, a.actionBarStyle);
        CharSequence text = a.getText(k.Lo);
        if (!TextUtils.isEmpty(text)) {
            this.afv = true;
            j(text);
        }
        CharSequence text2 = a.getText(k.Lm);
        if (!TextUtils.isEmpty(text2)) {
            this.uJ = text2;
            if ((this.afr & 8) != 0) {
                this.gz.setSubtitle(text2);
            }
        }
        Drawable drawable2 = a.getDrawable(k.Lk);
        if (drawable2 != null) {
            setLogo(drawable2);
        }
        drawable2 = a.getDrawable(k.Lj);
        if (this.afu == null && drawable2 != null) {
            setIcon(drawable2);
        }
        drawable2 = a.getDrawable(k.Li);
        if (drawable2 != null) {
            this.afu = drawable2;
            hc();
        }
        setDisplayOptions(a.getInt(k.Le, 0));
        int resourceId = a.getResourceId(k.Ld, 0);
        if (resourceId != 0) {
            setCustomView(LayoutInflater.from(this.gz.getContext()).inflate(resourceId, this.gz, false));
            setDisplayOptions(this.afr | 16);
        }
        resourceId = a.getLayoutDimension(k.Lg, 0);
        if (resourceId > 0) {
            LayoutParams layoutParams = this.gz.getLayoutParams();
            layoutParams.height = resourceId;
            this.gz.setLayoutParams(layoutParams);
        }
        resourceId = a.getDimensionPixelOffset(k.Lc, -1);
        int dimensionPixelOffset = a.getDimensionPixelOffset(k.Lb, -1);
        if (resourceId >= 0 || dimensionPixelOffset >= 0) {
            this.gz.aeX.ac(Math.max(resourceId, 0), Math.max(dimensionPixelOffset, 0));
        }
        resourceId = a.getResourceId(k.Lp, 0);
        if (resourceId != 0) {
            toolbar2 = this.gz;
            context = this.gz.getContext();
            toolbar2.aeP = resourceId;
            if (toolbar2.aeH != null) {
                toolbar2.aeH.setTextAppearance(context, resourceId);
            }
        }
        resourceId = a.getResourceId(k.Ln, 0);
        if (resourceId != 0) {
            toolbar2 = this.gz;
            context = this.gz.getContext();
            toolbar2.aeQ = resourceId;
            if (toolbar2.aeI != null) {
                toolbar2.aeI.setTextAppearance(context, resourceId);
            }
        }
        resourceId = a.getResourceId(k.Ll, 0);
        if (resourceId != 0) {
            this.gz.setPopupTheme(resourceId);
        }
        a.aeG.recycle();
        this.Um = h.ey();
        if (i != this.afz) {
            this.afz = i;
            if (TextUtils.isEmpty(this.gz.getNavigationContentDescription())) {
                int i3 = this.afz;
                if (i3 != 0) {
                    charSequence = this.gz.getContext().getString(i3);
                }
                this.afw = charSequence;
                hb();
            }
        }
        this.afw = this.gz.getNavigationContentDescription();
        drawable = this.Um.a(this.gz.getContext(), i2, false);
        if (this.afA != drawable) {
            this.afA = drawable;
            hc();
        }
        this.gz.setNavigationOnClickListener(new OnClickListener(this) {
            final android.support.v7.view.menu.a afB = new android.support.v7.view.menu.a(this.afC.gz.getContext(), this.afC.uI);
            final /* synthetic */ aq afC;

            {
                this.afC = r4;
            }

            public final void onClick(View view) {
                if (this.afC.HJ != null && this.afC.afx) {
                    this.afC.HJ.onMenuItemSelected(0, this.afB);
                }
            }
        });
    }

    public final ViewGroup eI() {
        return this.gz;
    }

    public final Context getContext() {
        return this.gz.getContext();
    }

    public final boolean hasExpandedActionView() {
        Toolbar toolbar = this.gz;
        return (toolbar.afj == null || toolbar.afj.afn == null) ? false : true;
    }

    public final void collapseActionView() {
        this.gz.collapseActionView();
    }

    public final void b(Callback callback) {
        this.HJ = callback;
    }

    public final void e(CharSequence charSequence) {
        if (!this.afv) {
            j(charSequence);
        }
    }

    public final CharSequence getTitle() {
        return this.gz.aeY;
    }

    private void j(CharSequence charSequence) {
        this.uI = charSequence;
        if ((this.afr & 8) != 0) {
            this.gz.setTitle(charSequence);
        }
    }

    public final void setIcon(int i) {
        setIcon(i != 0 ? this.Um.a(this.gz.getContext(), i, false) : null);
    }

    private void setIcon(Drawable drawable) {
        this.jQ = drawable;
        ha();
    }

    public final void setLogo(Drawable drawable) {
        this.aft = drawable;
        ha();
    }

    private void ha() {
        Drawable drawable = null;
        if ((this.afr & 2) != 0) {
            drawable = (this.afr & 1) != 0 ? this.aft != null ? this.aft : this.jQ : this.jQ;
        }
        this.gz.setLogo(drawable);
    }

    public final boolean dT() {
        Toolbar toolbar = this.gz;
        return toolbar.getVisibility() == 0 && toolbar.Ry != null && toolbar.Ry.SC;
    }

    public final boolean isOverflowMenuShowing() {
        return this.gz.isOverflowMenuShowing();
    }

    public final boolean dU() {
        Toolbar toolbar = this.gz;
        if (toolbar.Ry != null) {
            boolean z;
            ActionMenuView actionMenuView = toolbar.Ry;
            if (actionMenuView.Tb != null) {
                ActionMenuPresenter actionMenuPresenter = actionMenuView.Tb;
                z = actionMenuPresenter.SQ != null || actionMenuPresenter.isOverflowMenuShowing();
                if (z) {
                    z = true;
                    if (z) {
                        return true;
                    }
                }
            }
            z = false;
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final boolean showOverflowMenu() {
        return this.gz.showOverflowMenu();
    }

    public final boolean hideOverflowMenu() {
        Toolbar toolbar = this.gz;
        if (toolbar.Ry != null) {
            ActionMenuView actionMenuView = toolbar.Ry;
            boolean z = actionMenuView.Tb != null && actionMenuView.Tb.hideOverflowMenu();
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final void dV() {
        this.afx = true;
    }

    public final void a(Menu menu, l.a aVar) {
        if (this.Rz == null) {
            this.Rz = new ActionMenuPresenter(this.gz.getContext());
            this.Rz.dX = f.JR;
        }
        this.Rz.dV = aVar;
        this.gz.a((android.support.v7.view.menu.f) menu, this.Rz);
    }

    public final void dismissPopupMenus() {
        Toolbar toolbar = this.gz;
        if (toolbar.Ry != null) {
            toolbar.Ry.dismissPopupMenus();
        }
    }

    public final int getDisplayOptions() {
        return this.afr;
    }

    public final void setDisplayOptions(int i) {
        int i2 = this.afr ^ i;
        this.afr = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    hc();
                    hb();
                } else {
                    this.gz.setNavigationIcon(null);
                }
            }
            if ((i2 & 3) != 0) {
                ha();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.gz.setTitle(this.uI);
                    this.gz.setSubtitle(this.uJ);
                } else {
                    this.gz.setTitle(null);
                    this.gz.setSubtitle(null);
                }
            }
            if ((i2 & 16) != 0 && this.kD != null) {
                if ((i & 16) != 0) {
                    this.gz.addView(this.kD);
                } else {
                    this.gz.removeView(this.kD);
                }
            }
        }
    }

    public final void b(ai aiVar) {
        if (this.afs != null && this.afs.getParent() == this.gz) {
            this.gz.removeView(this.afs);
        }
        this.afs = aiVar;
        if (aiVar != null && this.afy == 2) {
            this.gz.addView(this.afs, 0);
            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.afs.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.gravity = 8388691;
            aiVar.abO = true;
        }
    }

    public final void N(boolean z) {
        Toolbar toolbar = this.gz;
        toolbar.afk = z;
        toolbar.requestLayout();
    }

    public final int getNavigationMode() {
        return this.afy;
    }

    public final void setCustomView(View view) {
        if (!(this.kD == null || (this.afr & 16) == 0)) {
            this.gz.removeView(this.kD);
        }
        this.kD = view;
        if (view != null && (this.afr & 16) != 0) {
            this.gz.addView(this.kD);
        }
    }

    public final View getCustomView() {
        return this.kD;
    }

    public final ai c(final int i, long j) {
        return z.V(this.gz).p(i == 0 ? 1.0f : 0.0f).c(j).a(new an(this) {
            private boolean RE = false;
            final /* synthetic */ aq afC;

            public final void p(View view) {
                this.afC.gz.setVisibility(0);
            }

            public final void q(View view) {
                if (!this.RE) {
                    this.afC.gz.setVisibility(i);
                }
            }

            public final void as(View view) {
                this.RE = true;
            }
        });
    }

    private void hb() {
        if ((this.afr & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.afw)) {
            Toolbar toolbar = this.gz;
            int i = this.afz;
            toolbar.setNavigationContentDescription(i != 0 ? toolbar.getContext().getText(i) : null);
            return;
        }
        this.gz.setNavigationContentDescription(this.afw);
    }

    private void hc() {
        if ((this.afr & 4) != 0) {
            this.gz.setNavigationIcon(this.afu != null ? this.afu : this.afA);
        }
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.gz.setBackgroundDrawable(drawable);
    }

    public final int getHeight() {
        return this.gz.getHeight();
    }

    public final void setVisibility(int i) {
        this.gz.setVisibility(i);
    }

    public final int getVisibility() {
        return this.gz.getVisibility();
    }

    public final void a(l.a aVar, android.support.v7.view.menu.f.a aVar2) {
        Toolbar toolbar = this.gz;
        toolbar.Tc = aVar;
        toolbar.Td = aVar2;
        if (toolbar.Ry != null) {
            toolbar.Ry.a(aVar, aVar2);
        }
    }

    public final Menu getMenu() {
        return this.gz.getMenu();
    }
}
