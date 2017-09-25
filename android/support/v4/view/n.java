package android.support.v4.view;

import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

final class n {

    static class a implements OnActionExpandListener {
        private b xh;

        public a(b bVar) {
            this.xh = bVar;
        }

        public final boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.xh.onMenuItemActionExpand(menuItem);
        }

        public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.xh.onMenuItemActionCollapse(menuItem);
        }
    }

    interface b {
        boolean onMenuItemActionCollapse(MenuItem menuItem);

        boolean onMenuItemActionExpand(MenuItem menuItem);
    }

    public static MenuItem a(MenuItem menuItem, b bVar) {
        return menuItem.setOnActionExpandListener(new a(bVar));
    }
}
