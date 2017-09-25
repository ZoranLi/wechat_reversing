package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.TextView;

public final class r {
    static final f EF;

    interface f {
        void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4);

        int c(TextView textView);
    }

    static class b implements f {
        b() {
        }

        public void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawables(drawable, null, null, null);
        }

        public int c(TextView textView) {
            if (!s.EJ) {
                s.EI = s.n("mMaxMode");
                s.EJ = true;
            }
            if (s.EI != null && s.a(s.EI, textView) == 1) {
                if (!s.EH) {
                    s.EG = s.n("mMaximum");
                    s.EH = true;
                }
                if (s.EG != null) {
                    return s.a(s.EG, textView);
                }
            }
            return -1;
        }
    }

    static class e extends b {
        e() {
        }

        public final int c(TextView textView) {
            return textView.getMaxLines();
        }
    }

    static class c extends e {
        c() {
        }

        public void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            Object obj = textView.getLayoutDirection() == 1 ? 1 : null;
            Drawable drawable5 = obj != null ? null : drawable;
            if (obj == null) {
                drawable = null;
            }
            textView.setCompoundDrawables(drawable5, null, drawable, null);
        }
    }

    static class d extends c {
        d() {
        }

        public final void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelative(drawable, null, null, null);
        }
    }

    static class a extends d {
        a() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            EF = new a();
        } else if (i >= 18) {
            EF = new d();
        } else if (i >= 17) {
            EF = new c();
        } else if (i >= 16) {
            EF = new e();
        } else {
            EF = new b();
        }
    }

    public static void a(TextView textView, Drawable drawable) {
        EF.a(textView, drawable, null, null, null);
    }

    public static int c(TextView textView) {
        return EF.c(textView);
    }
}
