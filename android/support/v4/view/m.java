package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.MenuItem;
import android.view.View;

public final class m {
    static final d xe;

    interface d {
        MenuItem a(MenuItem menuItem, e eVar);

        MenuItem a(MenuItem menuItem, View view);

        View a(MenuItem menuItem);

        void a(MenuItem menuItem, int i);

        MenuItem b(MenuItem menuItem, int i);

        boolean b(MenuItem menuItem);

        boolean c(MenuItem menuItem);

        boolean d(MenuItem menuItem);
    }

    public interface e {
        boolean onMenuItemActionCollapse(MenuItem menuItem);

        boolean onMenuItemActionExpand(MenuItem menuItem);
    }

    static class a implements d {
        a() {
        }

        public final void a(MenuItem menuItem, int i) {
        }

        public final MenuItem a(MenuItem menuItem, View view) {
            return menuItem;
        }

        public final MenuItem b(MenuItem menuItem, int i) {
            return menuItem;
        }

        public final View a(MenuItem menuItem) {
            return null;
        }

        public final boolean b(MenuItem menuItem) {
            return false;
        }

        public final boolean c(MenuItem menuItem) {
            return false;
        }

        public final boolean d(MenuItem menuItem) {
            return false;
        }

        public final MenuItem a(MenuItem menuItem, e eVar) {
            return menuItem;
        }
    }

    static class b implements d {
        b() {
        }

        public final void a(MenuItem menuItem, int i) {
            menuItem.setShowAsAction(i);
        }

        public final MenuItem a(MenuItem menuItem, View view) {
            return menuItem.setActionView(view);
        }

        public final MenuItem b(MenuItem menuItem, int i) {
            return menuItem.setActionView(i);
        }

        public final View a(MenuItem menuItem) {
            return menuItem.getActionView();
        }

        public boolean b(MenuItem menuItem) {
            return false;
        }

        public boolean c(MenuItem menuItem) {
            return false;
        }

        public boolean d(MenuItem menuItem) {
            return false;
        }

        public MenuItem a(MenuItem menuItem, e eVar) {
            return menuItem;
        }
    }

    static class c extends b {
        c() {
        }

        public final boolean b(MenuItem menuItem) {
            return menuItem.expandActionView();
        }

        public final boolean c(MenuItem menuItem) {
            return menuItem.collapseActionView();
        }

        public final boolean d(MenuItem menuItem) {
            return menuItem.isActionViewExpanded();
        }

        public final MenuItem a(MenuItem menuItem, final e eVar) {
            if (eVar == null) {
                return n.a(menuItem, null);
            }
            return n.a(menuItem, new b(this) {
                final /* synthetic */ c xg;

                public final boolean onMenuItemActionExpand(MenuItem menuItem) {
                    return eVar.onMenuItemActionExpand(menuItem);
                }

                public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
                    return eVar.onMenuItemActionCollapse(menuItem);
                }
            });
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 14) {
            xe = new c();
        } else if (i >= 11) {
            xe = new b();
        } else {
            xe = new a();
        }
    }

    public static void a(MenuItem menuItem, int i) {
        if (menuItem instanceof android.support.v4.c.a.b) {
            ((android.support.v4.c.a.b) menuItem).setShowAsAction(i);
        } else {
            xe.a(menuItem, i);
        }
    }

    public static MenuItem a(MenuItem menuItem, View view) {
        if (menuItem instanceof android.support.v4.c.a.b) {
            return ((android.support.v4.c.a.b) menuItem).setActionView(view);
        }
        return xe.a(menuItem, view);
    }

    public static MenuItem b(MenuItem menuItem, int i) {
        if (menuItem instanceof android.support.v4.c.a.b) {
            return ((android.support.v4.c.a.b) menuItem).setActionView(i);
        }
        return xe.b(menuItem, i);
    }

    public static View a(MenuItem menuItem) {
        if (menuItem instanceof android.support.v4.c.a.b) {
            return ((android.support.v4.c.a.b) menuItem).getActionView();
        }
        return xe.a(menuItem);
    }

    public static MenuItem a(MenuItem menuItem, d dVar) {
        if (menuItem instanceof android.support.v4.c.a.b) {
            return ((android.support.v4.c.a.b) menuItem).a(dVar);
        }
        return menuItem;
    }

    public static boolean b(MenuItem menuItem) {
        if (menuItem instanceof android.support.v4.c.a.b) {
            return ((android.support.v4.c.a.b) menuItem).expandActionView();
        }
        return xe.b(menuItem);
    }

    public static boolean c(MenuItem menuItem) {
        if (menuItem instanceof android.support.v4.c.a.b) {
            return ((android.support.v4.c.a.b) menuItem).collapseActionView();
        }
        return xe.c(menuItem);
    }

    public static boolean d(MenuItem menuItem) {
        if (menuItem instanceof android.support.v4.c.a.b) {
            return ((android.support.v4.c.a.b) menuItem).isActionViewExpanded();
        }
        return xe.d(menuItem);
    }

    public static MenuItem a(MenuItem menuItem, e eVar) {
        if (menuItem instanceof android.support.v4.c.a.b) {
            return ((android.support.v4.c.a.b) menuItem).a(eVar);
        }
        return xe.a(menuItem, eVar);
    }
}
