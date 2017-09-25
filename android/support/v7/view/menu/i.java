package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.view.m.e;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

@TargetApi(14)
public class i extends c<android.support.v4.c.a.b> implements MenuItem {
    public Method Ra;

    class a extends android.support.v4.view.d {
        final ActionProvider Rb;
        final /* synthetic */ i Rc;

        public a(i iVar, Context context, ActionProvider actionProvider) {
            this.Rc = iVar;
            super(context);
            this.Rb = actionProvider;
        }

        public final View onCreateActionView() {
            return this.Rb.onCreateActionView();
        }

        public final boolean onPerformDefaultAction() {
            return this.Rb.onPerformDefaultAction();
        }

        public final boolean hasSubMenu() {
            return this.Rb.hasSubMenu();
        }

        public final void onPrepareSubMenu(SubMenu subMenu) {
            this.Rb.onPrepareSubMenu(this.Rc.a(subMenu));
        }
    }

    static class b extends FrameLayout implements android.support.v7.view.c {
        final CollapsibleActionView Rd;

        b(View view) {
            super(view.getContext());
            this.Rd = (CollapsibleActionView) view;
            addView(view);
        }

        public final void onActionViewExpanded() {
            this.Rd.onActionViewExpanded();
        }

        public final void onActionViewCollapsed() {
            this.Rd.onActionViewCollapsed();
        }
    }

    private class c extends d<OnActionExpandListener> implements e {
        final /* synthetic */ i Rc;

        c(i iVar, OnActionExpandListener onActionExpandListener) {
            this.Rc = iVar;
            super(onActionExpandListener);
        }

        public final boolean onMenuItemActionExpand(MenuItem menuItem) {
            return ((OnActionExpandListener) this.PY).onMenuItemActionExpand(this.Rc.f(menuItem));
        }

        public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return ((OnActionExpandListener) this.PY).onMenuItemActionCollapse(this.Rc.f(menuItem));
        }
    }

    private class d extends d<OnMenuItemClickListener> implements OnMenuItemClickListener {
        final /* synthetic */ i Rc;

        d(i iVar, OnMenuItemClickListener onMenuItemClickListener) {
            this.Rc = iVar;
            super(onMenuItemClickListener);
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            return ((OnMenuItemClickListener) this.PY).onMenuItemClick(this.Rc.f(menuItem));
        }
    }

    i(Context context, android.support.v4.c.a.b bVar) {
        super(context, bVar);
    }

    public int getItemId() {
        return ((android.support.v4.c.a.b) this.PY).getItemId();
    }

    public int getGroupId() {
        return ((android.support.v4.c.a.b) this.PY).getGroupId();
    }

    public int getOrder() {
        return ((android.support.v4.c.a.b) this.PY).getOrder();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((android.support.v4.c.a.b) this.PY).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((android.support.v4.c.a.b) this.PY).setTitle(i);
        return this;
    }

    public CharSequence getTitle() {
        return ((android.support.v4.c.a.b) this.PY).getTitle();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((android.support.v4.c.a.b) this.PY).setTitleCondensed(charSequence);
        return this;
    }

    public CharSequence getTitleCondensed() {
        return ((android.support.v4.c.a.b) this.PY).getTitleCondensed();
    }

    public MenuItem setIcon(Drawable drawable) {
        ((android.support.v4.c.a.b) this.PY).setIcon(drawable);
        return this;
    }

    public MenuItem setIcon(int i) {
        ((android.support.v4.c.a.b) this.PY).setIcon(i);
        return this;
    }

    public Drawable getIcon() {
        return ((android.support.v4.c.a.b) this.PY).getIcon();
    }

    public MenuItem setIntent(Intent intent) {
        ((android.support.v4.c.a.b) this.PY).setIntent(intent);
        return this;
    }

    public Intent getIntent() {
        return ((android.support.v4.c.a.b) this.PY).getIntent();
    }

    public MenuItem setShortcut(char c, char c2) {
        ((android.support.v4.c.a.b) this.PY).setShortcut(c, c2);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        ((android.support.v4.c.a.b) this.PY).setNumericShortcut(c);
        return this;
    }

    public char getNumericShortcut() {
        return ((android.support.v4.c.a.b) this.PY).getNumericShortcut();
    }

    public MenuItem setAlphabeticShortcut(char c) {
        ((android.support.v4.c.a.b) this.PY).setAlphabeticShortcut(c);
        return this;
    }

    public char getAlphabeticShortcut() {
        return ((android.support.v4.c.a.b) this.PY).getAlphabeticShortcut();
    }

    public MenuItem setCheckable(boolean z) {
        ((android.support.v4.c.a.b) this.PY).setCheckable(z);
        return this;
    }

    public boolean isCheckable() {
        return ((android.support.v4.c.a.b) this.PY).isCheckable();
    }

    public MenuItem setChecked(boolean z) {
        ((android.support.v4.c.a.b) this.PY).setChecked(z);
        return this;
    }

    public boolean isChecked() {
        return ((android.support.v4.c.a.b) this.PY).isChecked();
    }

    public MenuItem setVisible(boolean z) {
        return ((android.support.v4.c.a.b) this.PY).setVisible(z);
    }

    public boolean isVisible() {
        return ((android.support.v4.c.a.b) this.PY).isVisible();
    }

    public MenuItem setEnabled(boolean z) {
        ((android.support.v4.c.a.b) this.PY).setEnabled(z);
        return this;
    }

    public boolean isEnabled() {
        return ((android.support.v4.c.a.b) this.PY).isEnabled();
    }

    public boolean hasSubMenu() {
        return ((android.support.v4.c.a.b) this.PY).hasSubMenu();
    }

    public SubMenu getSubMenu() {
        return a(((android.support.v4.c.a.b) this.PY).getSubMenu());
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        ((android.support.v4.c.a.b) this.PY).setOnMenuItemClickListener(onMenuItemClickListener != null ? new d(this, onMenuItemClickListener) : null);
        return this;
    }

    public ContextMenuInfo getMenuInfo() {
        return ((android.support.v4.c.a.b) this.PY).getMenuInfo();
    }

    public void setShowAsAction(int i) {
        ((android.support.v4.c.a.b) this.PY).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((android.support.v4.c.a.b) this.PY).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new b(view);
        }
        ((android.support.v4.c.a.b) this.PY).setActionView(view);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((android.support.v4.c.a.b) this.PY).setActionView(i);
        View actionView = ((android.support.v4.c.a.b) this.PY).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((android.support.v4.c.a.b) this.PY).setActionView(new b(actionView));
        }
        return this;
    }

    public View getActionView() {
        View actionView = ((android.support.v4.c.a.b) this.PY).getActionView();
        if (actionView instanceof b) {
            return (View) ((b) actionView).Rd;
        }
        return actionView;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((android.support.v4.c.a.b) this.PY).a(actionProvider != null ? a(actionProvider) : null);
        return this;
    }

    public ActionProvider getActionProvider() {
        android.support.v4.view.d bv = ((android.support.v4.c.a.b) this.PY).bv();
        if (bv instanceof a) {
            return ((a) bv).Rb;
        }
        return null;
    }

    public boolean expandActionView() {
        return ((android.support.v4.c.a.b) this.PY).expandActionView();
    }

    public boolean collapseActionView() {
        return ((android.support.v4.c.a.b) this.PY).collapseActionView();
    }

    public boolean isActionViewExpanded() {
        return ((android.support.v4.c.a.b) this.PY).isActionViewExpanded();
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        ((android.support.v4.c.a.b) this.PY).a(onActionExpandListener != null ? new c(this, onActionExpandListener) : null);
        return this;
    }

    a a(ActionProvider actionProvider) {
        return new a(this, this.mContext, actionProvider);
    }
}
