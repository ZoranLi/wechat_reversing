package android.support.v7.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.c.a.b;
import android.support.v4.view.d;
import android.support.v4.view.m.e;
import android.support.v7.view.menu.m.a;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;

public final class h implements b {
    static String QV;
    static String QW;
    static String QX;
    static String QY;
    final int PA;
    private CharSequence PB;
    private Intent PC;
    private char PD;
    private char PE;
    private Drawable PF;
    private int PG = 0;
    private OnMenuItemClickListener PH;
    private final int Py;
    private final int Pz;
    private p QN;
    private Runnable QO;
    int QP = 0;
    private View QQ;
    public d QR;
    private e QS;
    private boolean QT = false;
    ContextMenuInfo QU;
    public f dW;
    private final int dX;
    private CharSequence uI;
    private int uf = 16;

    public final /* synthetic */ MenuItem setActionView(int i) {
        Context context = this.dW.mContext;
        aK(LayoutInflater.from(context).inflate(i, new LinearLayout(context), false));
        return this;
    }

    public final /* synthetic */ MenuItem setActionView(View view) {
        return aK(view);
    }

    public final /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    h(f fVar, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.dW = fVar;
        this.dX = i2;
        this.Py = i;
        this.Pz = i3;
        this.PA = i4;
        this.uI = charSequence;
        this.QP = i5;
    }

    public final boolean dD() {
        if ((this.PH != null && this.PH.onMenuItemClick(this)) || this.dW.b(this.dW.dC(), (MenuItem) this)) {
            return true;
        }
        if (this.QO != null) {
            this.QO.run();
            return true;
        }
        if (this.PC != null) {
            try {
                this.dW.mContext.startActivity(this.PC);
                return true;
            } catch (ActivityNotFoundException e) {
            }
        }
        if (this.QR == null || !this.QR.onPerformDefaultAction()) {
            return false;
        }
        return true;
    }

    public final boolean isEnabled() {
        return (this.uf & 16) != 0;
    }

    public final MenuItem setEnabled(boolean z) {
        if (z) {
            this.uf |= 16;
        } else {
            this.uf &= -17;
        }
        this.dW.h(false);
        return this;
    }

    public final int getGroupId() {
        return this.Py;
    }

    @CapturedViewProperty
    public final int getItemId() {
        return this.dX;
    }

    public final int getOrder() {
        return this.Pz;
    }

    public final Intent getIntent() {
        return this.PC;
    }

    public final MenuItem setIntent(Intent intent) {
        this.PC = intent;
        return this;
    }

    public final char getAlphabeticShortcut() {
        return this.PE;
    }

    public final MenuItem setAlphabeticShortcut(char c) {
        if (this.PE != c) {
            this.PE = Character.toLowerCase(c);
            this.dW.h(false);
        }
        return this;
    }

    public final char getNumericShortcut() {
        return this.PD;
    }

    public final MenuItem setNumericShortcut(char c) {
        if (this.PD != c) {
            this.PD = c;
            this.dW.h(false);
        }
        return this;
    }

    public final MenuItem setShortcut(char c, char c2) {
        this.PD = c;
        this.PE = Character.toLowerCase(c2);
        this.dW.h(false);
        return this;
    }

    final char dE() {
        return this.dW.dt() ? this.PE : this.PD;
    }

    final boolean dF() {
        return this.dW.du() && dE() != '\u0000';
    }

    public final SubMenu getSubMenu() {
        return this.QN;
    }

    public final boolean hasSubMenu() {
        return this.QN != null;
    }

    public final void b(p pVar) {
        this.QN = pVar;
        pVar.setHeaderTitle(getTitle());
    }

    @CapturedViewProperty
    public final CharSequence getTitle() {
        return this.uI;
    }

    final CharSequence a(a aVar) {
        return (aVar == null || !aVar.A()) ? getTitle() : getTitleCondensed();
    }

    public final MenuItem setTitle(CharSequence charSequence) {
        this.uI = charSequence;
        this.dW.h(false);
        if (this.QN != null) {
            this.QN.setHeaderTitle(charSequence);
        }
        return this;
    }

    public final MenuItem setTitle(int i) {
        return setTitle(this.dW.mContext.getString(i));
    }

    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.PB != null ? this.PB : this.uI;
        if (VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) {
            return charSequence;
        }
        return charSequence.toString();
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.PB = charSequence;
        this.dW.h(false);
        return this;
    }

    public final Drawable getIcon() {
        if (this.PF != null) {
            return this.PF;
        }
        if (this.PG == 0) {
            return null;
        }
        Drawable a = android.support.v7.widget.h.ey().a(this.dW.mContext, this.PG, false);
        this.PG = 0;
        this.PF = a;
        return a;
    }

    public final MenuItem setIcon(Drawable drawable) {
        this.PG = 0;
        this.PF = drawable;
        this.dW.h(false);
        return this;
    }

    public final MenuItem setIcon(int i) {
        this.PF = null;
        this.PG = i;
        this.dW.h(false);
        return this;
    }

    public final boolean isCheckable() {
        return (this.uf & 1) == 1;
    }

    public final MenuItem setCheckable(boolean z) {
        int i = this.uf;
        this.uf = (z ? 1 : 0) | (this.uf & -2);
        if (i != this.uf) {
            this.dW.h(false);
        }
        return this;
    }

    public final void E(boolean z) {
        this.uf = (z ? 4 : 0) | (this.uf & -5);
    }

    public final boolean dG() {
        return (this.uf & 4) != 0;
    }

    public final boolean isChecked() {
        return (this.uf & 2) == 2;
    }

    public final MenuItem setChecked(boolean z) {
        if ((this.uf & 4) != 0) {
            f fVar = this.dW;
            int groupId = getGroupId();
            int size = fVar.eh.size();
            for (int i = 0; i < size; i++) {
                h hVar = (h) fVar.eh.get(i);
                if (hVar.getGroupId() == groupId && hVar.dG() && hVar.isCheckable()) {
                    hVar.F(hVar == this);
                }
            }
        } else {
            F(z);
        }
        return this;
    }

    private void F(boolean z) {
        int i;
        int i2 = this.uf;
        int i3 = this.uf & -3;
        if (z) {
            i = 2;
        } else {
            i = 0;
        }
        this.uf = i | i3;
        if (i2 != this.uf) {
            this.dW.h(false);
        }
    }

    public final boolean isVisible() {
        if (this.QR == null || !this.QR.overridesItemVisibility()) {
            if ((this.uf & 8) != 0) {
                return false;
            }
            return true;
        } else if ((this.uf & 8) == 0 && this.QR.isVisible()) {
            return true;
        } else {
            return false;
        }
    }

    final boolean G(boolean z) {
        int i = this.uf;
        this.uf = (z ? 0 : 8) | (this.uf & -9);
        if (i != this.uf) {
            return true;
        }
        return false;
    }

    public final MenuItem setVisible(boolean z) {
        if (G(z)) {
            this.dW.dx();
        }
        return this;
    }

    public final MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.PH = onMenuItemClickListener;
        return this;
    }

    public final String toString() {
        return this.uI != null ? this.uI.toString() : null;
    }

    public final ContextMenuInfo getMenuInfo() {
        return this.QU;
    }

    public final boolean dH() {
        return (this.uf & 32) == 32;
    }

    public final boolean dI() {
        return (this.QP & 1) == 1;
    }

    public final boolean dJ() {
        return (this.QP & 2) == 2;
    }

    public final void H(boolean z) {
        if (z) {
            this.uf |= 32;
        } else {
            this.uf &= -33;
        }
    }

    public final void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.QP = i;
                this.dW.dy();
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    private b aK(View view) {
        this.QQ = view;
        this.QR = null;
        if (view != null && view.getId() == -1 && this.dX > 0) {
            view.setId(this.dX);
        }
        this.dW.dy();
        return this;
    }

    public final View getActionView() {
        if (this.QQ != null) {
            return this.QQ;
        }
        if (this.QR == null) {
            return null;
        }
        this.QQ = this.QR.onCreateActionView(this);
        return this.QQ;
    }

    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public final d bv() {
        return this.QR;
    }

    public final b a(d dVar) {
        if (this.QR != null) {
            d dVar2 = this.QR;
            dVar2.wx = null;
            dVar2.ww = null;
        }
        this.QQ = null;
        this.QR = dVar;
        this.dW.h(true);
        if (this.QR != null) {
            this.QR.a(new d.b(this) {
                final /* synthetic */ h QZ;

                {
                    this.QZ = r1;
                }

                public final void bJ() {
                    this.QZ.dW.dx();
                }
            });
        }
        return this;
    }

    public final boolean expandActionView() {
        if (!dK()) {
            return false;
        }
        if (this.QS == null || this.QS.onMenuItemActionExpand(this)) {
            return this.dW.g(this);
        }
        return false;
    }

    public final boolean collapseActionView() {
        if ((this.QP & 8) == 0) {
            return false;
        }
        if (this.QQ == null) {
            return true;
        }
        if (this.QS == null || this.QS.onMenuItemActionCollapse(this)) {
            return this.dW.h(this);
        }
        return false;
    }

    public final b a(e eVar) {
        this.QS = eVar;
        return this;
    }

    public final boolean dK() {
        if ((this.QP & 8) == 0) {
            return false;
        }
        if (this.QQ == null && this.QR != null) {
            this.QQ = this.QR.onCreateActionView(this);
        }
        if (this.QQ != null) {
            return true;
        }
        return false;
    }

    public final void I(boolean z) {
        this.QT = z;
        this.dW.h(false);
    }

    public final boolean isActionViewExpanded() {
        return this.QT;
    }

    public final MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
    }
}
