package com.tencent.mm.ui.b;

import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.view.b;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public abstract class a {
    public b GP = null;
    public ActionBar Gx;
    public MenuInflater iP;
    public final Activity qb;

    class a implements android.support.v7.view.b.a {
        private android.support.v7.view.b.a Hk;
        final /* synthetic */ a veG;

        public a(a aVar, android.support.v7.view.b.a aVar2) {
            this.veG = aVar;
            this.Hk = aVar2;
        }

        public final boolean a(b bVar, Menu menu) {
            return this.Hk.a(bVar, menu);
        }

        public final boolean b(b bVar, Menu menu) {
            return this.Hk.b(bVar, menu);
        }

        public final boolean a(b bVar, MenuItem menuItem) {
            return this.Hk.a(bVar, menuItem);
        }

        public final void a(b bVar) {
            this.Hk.a(bVar);
            this.veG.GP = null;
        }
    }

    abstract ActionBar bRu();

    public a(Activity activity) {
        this.qb = activity;
    }

    public final ActionBar cP() {
        if (this.Gx == null) {
            this.Gx = bRu();
        }
        return this.Gx;
    }
}
