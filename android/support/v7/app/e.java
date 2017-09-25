package android.support.v7.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.view.g;
import android.support.v7.view.i;
import android.support.v7.view.menu.f;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;

abstract class e extends d {
    final Window Fe;
    boolean GA;
    boolean GB;
    boolean GC;
    boolean GD;
    final Callback Gu = this.Fe.getCallback();
    final Callback Gv;
    final c Gw;
    ActionBar Gx;
    boolean Gy;
    boolean Gz;
    MenuInflater iP;
    final Context mContext;
    CharSequence uI;

    class a extends i {
        final /* synthetic */ e GE;

        a(e eVar, Callback callback) {
            this.GE = eVar;
            super(callback);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.GE.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || this.GE.onKeyShortcut(keyEvent.getKeyCode(), keyEvent);
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof f)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        public void onContentChanged() {
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            f fVar;
            if (menu instanceof f) {
                fVar = (f) menu;
            } else {
                fVar = null;
            }
            if (i == 0 && fVar == null) {
                return false;
            }
            if (fVar != null) {
                fVar.QJ = true;
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (fVar == null) {
                return onPreparePanel;
            }
            fVar.QJ = false;
            return onPreparePanel;
        }

        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            this.GE.as(i);
            return true;
        }

        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            this.GE.ar(i);
        }
    }

    abstract void ar(int i);

    abstract boolean as(int i);

    abstract void cU();

    abstract boolean dispatchKeyEvent(KeyEvent keyEvent);

    abstract void f(CharSequence charSequence);

    abstract boolean onKeyShortcut(int i, KeyEvent keyEvent);

    e(Context context, Window window, c cVar) {
        this.mContext = context;
        this.Fe = window;
        this.Gw = cVar;
        if (this.Gu instanceof a) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.Gv = a(this.Gu);
        this.Fe.setCallback(this.Gv);
    }

    Callback a(Callback callback) {
        return new a(this, callback);
    }

    public final ActionBar cP() {
        cU();
        return this.Gx;
    }

    public final MenuInflater getMenuInflater() {
        if (this.iP == null) {
            cU();
            this.iP = new g(this.Gx != null ? this.Gx.getThemedContext() : this.mContext);
        }
        return this.iP;
    }

    final Context cV() {
        Context context = null;
        ActionBar cP = cP();
        if (cP != null) {
            context = cP.getThemedContext();
        }
        if (context == null) {
            return this.mContext;
        }
        return context;
    }

    public void onDestroy() {
        this.GD = true;
    }

    public boolean cS() {
        return false;
    }

    public final void setTitle(CharSequence charSequence) {
        this.uI = charSequence;
        f(charSequence);
    }

    public void onSaveInstanceState(Bundle bundle) {
    }
}
