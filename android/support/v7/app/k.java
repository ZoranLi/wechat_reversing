package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v4.view.z;
import android.support.v7.view.menu.f;
import android.support.v7.widget.u;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;
import java.util.ArrayList;

final class k extends ActionBar {
    public u HI;
    public Callback HJ;
    private boolean HK;
    private boolean HL;
    private ArrayList<Object> HM;
    private final Runnable HN;

    private final class a implements android.support.v7.view.menu.l.a {
        private boolean GZ;
        final /* synthetic */ k HO;

        public a(k kVar) {
            this.HO = kVar;
        }

        public final boolean d(f fVar) {
            if (this.HO.HJ == null) {
                return false;
            }
            this.HO.HJ.onMenuOpened(108, fVar);
            return true;
        }

        public final void a(f fVar, boolean z) {
            if (!this.GZ) {
                this.GZ = true;
                this.HO.HI.dismissPopupMenus();
                if (this.HO.HJ != null) {
                    this.HO.HJ.onPanelClosed(108, fVar);
                }
                this.GZ = false;
            }
        }
    }

    private final class b implements android.support.v7.view.menu.f.a {
        final /* synthetic */ k HO;

        public b(k kVar) {
            this.HO = kVar;
        }

        public final boolean a(f fVar, MenuItem menuItem) {
            return false;
        }

        public final void b(f fVar) {
            if (this.HO.HJ == null) {
                return;
            }
            if (this.HO.HI.isOverflowMenuShowing()) {
                this.HO.HJ.onPanelClosed(108, fVar);
            } else if (this.HO.HJ.onPreparePanel(0, null, fVar)) {
                this.HO.HJ.onMenuOpened(108, fVar);
            }
        }
    }

    public final void setCustomView(View view) {
        LayoutParams layoutParams = new ActionBar.LayoutParams(-2, -2);
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
        this.HI.setCustomView(view);
    }

    public final void setCustomView(int i) {
        setCustomView(LayoutInflater.from(this.HI.getContext()).inflate(i, this.HI.eI(), false));
    }

    public final void setIcon(int i) {
        this.HI.setIcon(i);
    }

    public final void setLogo(Drawable drawable) {
        this.HI.setLogo(drawable);
    }

    public final void setElevation(float f) {
        z.g(this.HI.eI(), f);
    }

    public final Context getThemedContext() {
        return this.HI.getContext();
    }

    public final void w(boolean z) {
    }

    public final void x(boolean z) {
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public final void e(CharSequence charSequence) {
        this.HI.e(charSequence);
    }

    public final boolean requestFocus() {
        ViewGroup eI = this.HI.eI();
        if (eI == null || eI.hasFocus()) {
            return false;
        }
        eI.requestFocus();
        return true;
    }

    public final void setDisplayOptions(int i) {
        setDisplayOptions(i, -1);
    }

    private void setDisplayOptions(int i, int i2) {
        this.HI.setDisplayOptions((this.HI.getDisplayOptions() & (i2 ^ -1)) | (i & i2));
    }

    public final void cJ() {
        setDisplayOptions(0, 2);
    }

    public final void setDisplayHomeAsUpEnabled(boolean z) {
        setDisplayOptions(z ? 4 : 0, 4);
    }

    public final void cK() {
        setDisplayOptions(0, 8);
    }

    public final void cL() {
        setDisplayOptions(16, 16);
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.HI.setBackgroundDrawable(drawable);
    }

    public final View getCustomView() {
        return this.HI.getCustomView();
    }

    public final CharSequence getTitle() {
        return this.HI.getTitle();
    }

    public final int getDisplayOptions() {
        return this.HI.getDisplayOptions();
    }

    public final int getHeight() {
        return this.HI.getHeight();
    }

    public final void show() {
        this.HI.setVisibility(0);
    }

    public final void hide() {
        this.HI.setVisibility(8);
    }

    public final boolean isShowing() {
        return this.HI.getVisibility() == 0;
    }

    public final boolean cM() {
        this.HI.eI().removeCallbacks(this.HN);
        z.a(this.HI.eI(), this.HN);
        return true;
    }

    public final boolean collapseActionView() {
        if (!this.HI.hasExpandedActionView()) {
            return false;
        }
        this.HI.collapseActionView();
        return true;
    }

    public final boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        if (!this.HK) {
            this.HI.a(new a(this), new b(this));
            this.HK = true;
        }
        Menu menu = this.HI.getMenu();
        if (menu != null) {
            boolean z;
            if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1) {
                z = true;
            } else {
                z = false;
            }
            menu.setQwertyMode(z);
            menu.performShortcut(i, keyEvent, 0);
        }
        return true;
    }

    final void onDestroy() {
        this.HI.eI().removeCallbacks(this.HN);
    }

    public final void y(boolean z) {
        if (z != this.HL) {
            this.HL = z;
            int size = this.HM.size();
            for (int i = 0; i < size; i++) {
                this.HM.get(i);
            }
        }
    }
}
