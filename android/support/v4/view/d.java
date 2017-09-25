package android.support.v4.view;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class d {
    private final Context mContext;
    public a ww;
    public b wx;

    public interface a {
        void q(boolean z);
    }

    public interface b {
        void bJ();
    }

    public abstract View onCreateActionView();

    public d(Context context) {
        this.mContext = context;
    }

    public View onCreateActionView(MenuItem menuItem) {
        return onCreateActionView();
    }

    public boolean overridesItemVisibility() {
        return false;
    }

    public boolean isVisible() {
        return true;
    }

    public boolean onPerformDefaultAction() {
        return false;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public void onPrepareSubMenu(SubMenu subMenu) {
    }

    public final void p(boolean z) {
        if (this.ww != null) {
            this.ww.q(z);
        }
    }

    public void a(b bVar) {
        if (this.wx != null) {
            new StringBuilder("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ").append(getClass().getSimpleName()).append(" instance while it is still in use somewhere else?");
        }
        this.wx = bVar;
    }
}
