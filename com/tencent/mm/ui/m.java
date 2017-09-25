package com.tencent.mm.ui;

import android.support.v7.app.ActionBar;
import android.support.v7.view.f;
import android.support.v7.view.g;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.ui.b.b;
import com.tencent.mm.ui.b.b.a;

public final class m extends l implements a {
    private ActionBar Gx;
    public q uUu = null;
    public b uUv;

    public final ActionMode startActionMode(Callback callback) {
        com.tencent.mm.ui.b.a aVar = this.uUv;
        Object aVar2 = new f.a(aVar.qb, callback);
        if (aVar.GP != null) {
            aVar.GP.finish();
        }
        android.support.v7.view.b.a aVar3 = new a(aVar, aVar2);
        ActionBar cP = aVar.cP();
        if (cP != null) {
            aVar.GP = cP.a(aVar3);
        }
        android.support.v7.view.b bVar = aVar.GP;
        return bVar != null ? aVar2.b(bVar) : null;
    }

    protected final int getLayoutId() {
        if (this.uUu != null) {
            return this.uUu.getLayoutId();
        }
        return -1;
    }

    protected final void bE(View view) {
        if (this.uUu != null) {
            this.uUu.bE(view);
        }
    }

    protected final String aFO() {
        if (this.uUu != null) {
            return this.uUu.aFO();
        }
        return null;
    }

    protected final View bQa() {
        if (this.uUu != null) {
            return this.uUu.bQa();
        }
        return null;
    }

    public final void bit() {
        if (this.uUu != null) {
            this.uUu.bit();
        }
    }

    protected final void SC() {
        if (this.uUu != null) {
            q.SC();
        }
    }

    protected final String getClassName() {
        return this.uUu.getClass().getName();
    }

    protected final boolean bPO() {
        return false;
    }

    public final ActionBar cP() {
        if (this.Gx == null) {
            this.Gx = this.uUv.bRu();
        }
        return this.Gx;
    }

    public final boolean bQe() {
        return true;
    }

    public final void aQ() {
        this.uUv.aQ();
    }

    public final boolean c(Menu menu) {
        if (this.uUu != null) {
            this.uUu.onPrepareOptionsMenu(menu);
        }
        return true;
    }

    public final boolean d(Menu menu) {
        q qVar = this.uUu;
        com.tencent.mm.ui.b.a aVar = this.uUv;
        if (aVar.iP == null) {
            ActionBar cP = aVar.cP();
            if (cP != null) {
                aVar.iP = new g(cP.getThemedContext());
            } else {
                aVar.iP = new g(aVar.qb);
            }
        }
        qVar.onCreateOptionsMenu(menu, aVar.iP);
        return true;
    }

    public final boolean j(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }
}
