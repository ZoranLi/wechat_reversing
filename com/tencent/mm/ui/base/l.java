package com.tencent.mm.ui.base;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class l implements ContextMenu {
    public CharSequence Qz;
    public List<MenuItem> vla = new ArrayList();

    public final boolean bSk() {
        return this.vla.size() == 0;
    }

    public final MenuItem add(int i, int i2, int i3, int i4) {
        MenuItem mVar = new m(i2, i);
        mVar.setTitle(i4);
        this.vla.add(mVar);
        return mVar;
    }

    public final MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        MenuItem mVar = new m(i2, i);
        mVar.setTitle(charSequence);
        this.vla.add(mVar);
        return mVar;
    }

    public final MenuItem add(int i) {
        MenuItem mVar = new m(0, 0);
        mVar.setTitle(i);
        this.vla.add(mVar);
        return mVar;
    }

    public final MenuItem add(CharSequence charSequence) {
        MenuItem mVar = new m(0, 0);
        mVar.setTitle(charSequence);
        this.vla.add(mVar);
        return mVar;
    }

    public final MenuItem W(int i, int i2, int i3) {
        MenuItem mVar = new m(i, 0);
        mVar.setTitle(i2);
        mVar.setIcon(i3);
        this.vla.add(mVar);
        return mVar;
    }

    public final MenuItem a(int i, CharSequence charSequence, CharSequence charSequence2, Drawable drawable, boolean z) {
        MenuItem mVar = new m(i, 0);
        mVar.setTitle(charSequence);
        mVar.pgM = charSequence2;
        mVar.setIcon(drawable);
        mVar.uff = z;
        this.vla.add(mVar);
        return mVar;
    }

    public final MenuItem dX(int i, int i2) {
        MenuItem mVar = new m(i, 0);
        mVar.setTitle(i2);
        this.vla.add(mVar);
        return mVar;
    }

    public final MenuItem e(int i, CharSequence charSequence) {
        MenuItem mVar = new m(i, 0);
        mVar.setTitle(charSequence);
        this.vla.add(mVar);
        return mVar;
    }

    public final MenuItem a(int i, CharSequence charSequence, int i2) {
        MenuItem mVar = new m(i, 0);
        mVar.setTitle(charSequence);
        mVar.setIcon(i2);
        this.vla.add(mVar);
        return mVar;
    }

    public final MenuItem a(int i, int i2, CharSequence charSequence) {
        MenuItem mVar = new m(i, 0);
        CharSequence spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new ForegroundColorSpan(i2), 0, spannableString.length(), 0);
        mVar.setTitle(spannableString);
        this.vla.add(mVar);
        return mVar;
    }

    public final SubMenu addSubMenu(CharSequence charSequence) {
        return null;
    }

    public final SubMenu addSubMenu(int i) {
        return null;
    }

    public final SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return null;
    }

    public final SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return null;
    }

    public final int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        return 0;
    }

    public final void removeItem(int i) {
        Collection arrayList = new ArrayList();
        for (MenuItem menuItem : this.vla) {
            if (menuItem.getItemId() == i) {
                arrayList.add(menuItem);
            }
        }
        this.vla.removeAll(arrayList);
    }

    public final void removeGroup(int i) {
    }

    public final void clear() {
        for (MenuItem menuItem : this.vla) {
            ((m) menuItem).vld = null;
            ((m) menuItem).setOnMenuItemClickListener(null);
        }
        this.vla.clear();
        this.Qz = null;
    }

    public final void setGroupCheckable(int i, boolean z, boolean z2) {
    }

    public final void setGroupVisible(int i, boolean z) {
    }

    public final void setGroupEnabled(int i, boolean z) {
    }

    public final boolean hasVisibleItems() {
        return false;
    }

    public final MenuItem findItem(int i) {
        for (MenuItem menuItem : this.vla) {
            if (menuItem.getItemId() == i) {
                return menuItem;
            }
        }
        return null;
    }

    public final int size() {
        return this.vla == null ? 0 : this.vla.size();
    }

    public final MenuItem getItem(int i) {
        return (MenuItem) this.vla.get(i);
    }

    public final void close() {
    }

    public final boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return false;
    }

    public final boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return false;
    }

    public final boolean performIdentifierAction(int i, int i2) {
        return false;
    }

    public final void setQwertyMode(boolean z) {
    }

    public final ContextMenu setHeaderTitle(int i) {
        if (i > 0) {
            return setHeaderTitle(ab.getContext().getString(i));
        }
        return this;
    }

    public final ContextMenu setHeaderTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.Qz = charSequence;
        }
        return this;
    }

    public final ContextMenu setHeaderIcon(int i) {
        return this;
    }

    public final ContextMenu setHeaderIcon(Drawable drawable) {
        return this;
    }

    public final ContextMenu setHeaderView(View view) {
        return this;
    }

    public final void clearHeader() {
    }
}
