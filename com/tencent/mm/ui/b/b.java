package com.tencent.mm.ui.b;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.view.menu.f;
import android.support.v7.widget.u;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

public final class b extends a implements android.support.v7.view.menu.f.a, android.support.v7.view.menu.l.a {
    public ViewGroup Fa;
    private boolean GU;
    private f dW;
    public a veH;
    public boolean veI;
    private final Runnable veJ = new Runnable(this) {
        final /* synthetic */ b veK;

        {
            this.veK = r1;
        }

        public final void run() {
            android.support.v7.view.menu.f.a aVar = this.veK;
            Context context = aVar.qb;
            ActionBar cP = aVar.cP();
            if (cP != null) {
                context = cP.getThemedContext();
            }
            f fVar = new f(context);
            fVar.a(aVar);
            if (this.veK.veH != null) {
                this.veK.veH.d(fVar);
                this.veK.veH.c(fVar);
                this.veK.e(fVar);
            } else {
                this.veK.e(null);
            }
            fVar.h(true);
            this.veK.veI = false;
        }
    };

    public interface a {
        boolean c(Menu menu);

        boolean d(Menu menu);

        boolean j(MenuItem menuItem);
    }

    public b(Activity activity, a aVar) {
        super(activity);
        this.veH = aVar;
    }

    public final ActionBar bRu() {
        if (!this.GU) {
            this.GU = true;
            aQ();
        }
        if (this.Gx == null) {
            this.Gx = new d(this.qb, this.Fa);
        }
        return this.Gx;
    }

    public final boolean a(f fVar, MenuItem menuItem) {
        if (this.veH != null) {
            return this.veH.j(menuItem);
        }
        return false;
    }

    public final void b(f fVar) {
        if (this.Gx != null) {
            u uVar = ((d) this.Gx).HI;
            if (uVar != null && uVar.dT()) {
                if (uVar.isOverflowMenuShowing()) {
                    uVar.hideOverflowMenu();
                    return;
                } else if (uVar.getVisibility() == 0) {
                    uVar.showOverflowMenu();
                    return;
                } else {
                    return;
                }
            }
        }
        fVar.close();
    }

    public final void a(f fVar, boolean z) {
    }

    public final boolean d(f fVar) {
        return false;
    }

    public final void aQ() {
        if (!this.veI) {
            this.veI = true;
            this.veJ.run();
        }
    }

    public final void e(f fVar) {
        if (fVar != this.dW) {
            this.dW = fVar;
            if (this.Gx != null) {
                ((d) this.Gx).HI.a((Menu) fVar, (android.support.v7.view.menu.l.a) this);
            }
        }
    }
}
