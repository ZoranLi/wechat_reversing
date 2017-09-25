package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.c.a.b;
import android.support.v4.view.d;
import android.support.v4.view.m.e;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

public final class a implements b {
    private final int PA;
    private CharSequence PB;
    private Intent PC;
    private char PD;
    private char PE;
    private Drawable PF;
    private int PG = 0;
    private OnMenuItemClickListener PH;
    private final int Py;
    private final int Pz;
    private final int dX;
    private Context mContext;
    private CharSequence uI;
    private int uf = 16;

    public final /* synthetic */ MenuItem setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    public a(Context context, CharSequence charSequence) {
        this.mContext = context;
        this.dX = 16908332;
        this.Py = 0;
        this.Pz = 0;
        this.PA = 0;
        this.uI = charSequence;
    }

    public final char getAlphabeticShortcut() {
        return this.PE;
    }

    public final int getGroupId() {
        return this.Py;
    }

    public final Drawable getIcon() {
        return this.PF;
    }

    public final Intent getIntent() {
        return this.PC;
    }

    public final int getItemId() {
        return this.dX;
    }

    public final ContextMenuInfo getMenuInfo() {
        return null;
    }

    public final char getNumericShortcut() {
        return this.PD;
    }

    public final int getOrder() {
        return this.PA;
    }

    public final SubMenu getSubMenu() {
        return null;
    }

    public final CharSequence getTitle() {
        return this.uI;
    }

    public final CharSequence getTitleCondensed() {
        return this.PB != null ? this.PB : this.uI;
    }

    public final boolean hasSubMenu() {
        return false;
    }

    public final boolean isCheckable() {
        return (this.uf & 1) != 0;
    }

    public final boolean isChecked() {
        return (this.uf & 2) != 0;
    }

    public final boolean isEnabled() {
        return (this.uf & 16) != 0;
    }

    public final boolean isVisible() {
        return (this.uf & 8) == 0;
    }

    public final MenuItem setAlphabeticShortcut(char c) {
        this.PE = c;
        return this;
    }

    public final MenuItem setCheckable(boolean z) {
        this.uf = (z ? 1 : 0) | (this.uf & -2);
        return this;
    }

    public final MenuItem setChecked(boolean z) {
        this.uf = (z ? 2 : 0) | (this.uf & -3);
        return this;
    }

    public final MenuItem setEnabled(boolean z) {
        this.uf = (z ? 16 : 0) | (this.uf & -17);
        return this;
    }

    public final MenuItem setIcon(Drawable drawable) {
        this.PF = drawable;
        this.PG = 0;
        return this;
    }

    public final MenuItem setIcon(int i) {
        this.PG = i;
        this.PF = android.support.v4.content.a.a(this.mContext, i);
        return this;
    }

    public final MenuItem setIntent(Intent intent) {
        this.PC = intent;
        return this;
    }

    public final MenuItem setNumericShortcut(char c) {
        this.PD = c;
        return this;
    }

    public final MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.PH = onMenuItemClickListener;
        return this;
    }

    public final MenuItem setShortcut(char c, char c2) {
        this.PD = c;
        this.PE = c2;
        return this;
    }

    public final MenuItem setTitle(CharSequence charSequence) {
        this.uI = charSequence;
        return this;
    }

    public final MenuItem setTitle(int i) {
        this.uI = this.mContext.getResources().getString(i);
        return this;
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.PB = charSequence;
        return this;
    }

    public final MenuItem setVisible(boolean z) {
        this.uf = (z ? 0 : 8) | (this.uf & 8);
        return this;
    }

    public final void setShowAsAction(int i) {
    }

    public final View getActionView() {
        return null;
    }

    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public final d bv() {
        return null;
    }

    public final b a(d dVar) {
        throw new UnsupportedOperationException();
    }

    public final boolean expandActionView() {
        return false;
    }

    public final boolean collapseActionView() {
        return false;
    }

    public final boolean isActionViewExpanded() {
        return false;
    }

    public final MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public final b a(e eVar) {
        return this;
    }
}
