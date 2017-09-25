package android.support.v4.b;

import android.graphics.Bitmap;
import android.os.Build.VERSION;

public final class a {
    static final b tJ;

    interface b {
        int b(Bitmap bitmap);
    }

    static class a implements b {
        a() {
        }

        public int b(Bitmap bitmap) {
            return bitmap.getRowBytes() * bitmap.getHeight();
        }
    }

    static class c extends a {
        c() {
        }

        public int b(Bitmap bitmap) {
            return bitmap.getByteCount();
        }
    }

    static class d extends c {
        d() {
        }
    }

    static class e extends d {
        e() {
        }

        public final int b(Bitmap bitmap) {
            return bitmap.getAllocationByteCount();
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 19) {
            tJ = new e();
        } else if (i >= 18) {
            tJ = new d();
        } else if (i >= 12) {
            tJ = new c();
        } else {
            tJ = new a();
        }
    }

    public static int b(Bitmap bitmap) {
        return tJ.b(bitmap);
    }
}
