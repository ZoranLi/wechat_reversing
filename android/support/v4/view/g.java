package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.KeyEvent;
import com.tencent.mm.plugin.appbrand.jsapi.bd;
import com.tencent.mm.plugin.appbrand.jsapi.bg;
import com.tencent.wcdb.FileUtils;

public final class g {
    static final d wY;

    interface d {
        void b(KeyEvent keyEvent);

        boolean metaStateHasModifiers(int i, int i2);

        boolean metaStateHasNoModifiers(int i);
    }

    static class a implements d {
        a() {
        }

        private static int c(int i, int i2, int i3, int i4, int i5) {
            Object obj = 1;
            Object obj2 = (i2 & i3) != 0 ? 1 : null;
            int i6 = i4 | i5;
            if ((i2 & i6) == 0) {
                obj = null;
            }
            if (obj2 != null) {
                if (obj == null) {
                    return i & (i6 ^ -1);
                }
                throw new IllegalArgumentException("bad arguments");
            } else if (obj != null) {
                return i & (i3 ^ -1);
            } else {
                return i;
            }
        }

        public int normalizeMetaState(int i) {
            int i2;
            if ((i & bg.CTRL_INDEX) != 0) {
                i2 = i | 1;
            } else {
                i2 = i;
            }
            if ((i2 & 48) != 0) {
                i2 |= 2;
            }
            return i2 & bd.CTRL_INDEX;
        }

        public boolean metaStateHasModifiers(int i, int i2) {
            if (c(c(normalizeMetaState(i) & bd.CTRL_INDEX, i2, 1, 64, FileUtils.S_IWUSR), i2, 2, 16, 32) == i2) {
                return true;
            }
            return false;
        }

        public boolean metaStateHasNoModifiers(int i) {
            return (normalizeMetaState(i) & bd.CTRL_INDEX) == 0;
        }

        public void b(KeyEvent keyEvent) {
        }
    }

    static class b extends a {
        b() {
        }

        public final void b(KeyEvent keyEvent) {
            keyEvent.startTracking();
        }
    }

    static class c extends b {
        c() {
        }

        public final int normalizeMetaState(int i) {
            return KeyEvent.normalizeMetaState(i);
        }

        public final boolean metaStateHasModifiers(int i, int i2) {
            return KeyEvent.metaStateHasModifiers(i, i2);
        }

        public final boolean metaStateHasNoModifiers(int i) {
            return KeyEvent.metaStateHasNoModifiers(i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            wY = new c();
        } else {
            wY = new a();
        }
    }

    public static boolean a(KeyEvent keyEvent, int i) {
        return wY.metaStateHasModifiers(keyEvent.getMetaState(), i);
    }

    public static boolean a(KeyEvent keyEvent) {
        return wY.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    public static void b(KeyEvent keyEvent) {
        wY.b(keyEvent);
    }
}
