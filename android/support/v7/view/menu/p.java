package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.f.a;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class p extends f implements SubMenu {
    public f Ru;
    private h Rv;

    public p(Context context, f fVar, h hVar) {
        super(context);
        this.Ru = fVar;
        this.Rv = hVar;
    }

    public void setQwertyMode(boolean z) {
        this.Ru.setQwertyMode(z);
    }

    public final boolean dt() {
        return this.Ru.dt();
    }

    public final boolean du() {
        return this.Ru.du();
    }

    public MenuItem getItem() {
        return this.Rv;
    }

    public final void a(a aVar) {
        this.Ru.a(aVar);
    }

    public final f dC() {
        return this.Ru;
    }

    final boolean b(f fVar, MenuItem menuItem) {
        return super.b(fVar, menuItem) || this.Ru.b(fVar, menuItem);
    }

    public SubMenu setIcon(Drawable drawable) {
        this.Rv.setIcon(drawable);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.Rv.setIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        super.k(drawable);
        return this;
    }

    public SubMenu setHeaderIcon(int i) {
        super.k(android.support.v4.content.a.a(this.mContext, i));
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.g(charSequence);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        super.g(this.mContext.getResources().getString(i));
        return this;
    }

    public SubMenu setHeaderView(View view) {
        super.a(null, null, view);
        return this;
    }

    public final boolean g(h hVar) {
        return this.Ru.g(hVar);
    }

    public final boolean h(h hVar) {
        return this.Ru.h(hVar);
    }

    public final String ds() {
        int itemId = this.Rv != null ? this.Rv.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.ds() + ":" + itemId;
    }
}
