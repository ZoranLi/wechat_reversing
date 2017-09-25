package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import junit.framework.Assert;

public final class a extends j implements com.tencent.mm.x.d.a {

    public interface a {
        void doInvalidate();

        Drawable getDrawable();

        void setImageDrawable(Drawable drawable);
    }

    public static class b {
        public static com.tencent.mm.pluginsdk.ui.j.a owB;

        public static com.tencent.mm.pluginsdk.ui.j.a bEa() {
            Assert.assertTrue(owB != null);
            return owB;
        }

        public static void a(ImageView imageView, String str) {
            if (imageView == null) {
                w.e("MicroMsg.AvatarDrawable", "imageView is null");
                return;
            }
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof a)) {
                drawable = new a(str);
            } else {
                drawable = (a) drawable;
            }
            drawable.MD(str);
            imageView.setImageDrawable(drawable);
            imageView.invalidate();
        }

        public static void m(ImageView imageView, String str) {
            a(imageView, str, 0.5f, false);
        }

        public static void n(ImageView imageView, String str) {
            a(imageView, str, 0.5f, true);
        }

        public static void a(ImageView imageView, String str, float f, boolean z) {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof b)) {
                drawable = new b(str, f);
                drawable.jm(z);
            } else {
                drawable = (b) drawable;
            }
            drawable.MD(str);
            imageView.setImageDrawable(drawable);
            imageView.invalidate();
        }

        public static void b(ImageView imageView, String str, boolean z) {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof a)) {
                drawable = new a(str);
            } else {
                drawable = (a) drawable;
            }
            drawable.MD(str);
            imageView.setImageDrawable(drawable);
            imageView.invalidate();
        }

        public static void a(a aVar, String str) {
            Drawable drawable = aVar.getDrawable();
            if (drawable == null || !(drawable instanceof a)) {
                drawable = new a(str);
            } else {
                drawable = (a) drawable;
            }
            drawable.MD(str);
            aVar.setImageDrawable(drawable);
            aVar.doInvalidate();
        }

        public static void g(ImageView imageView, String str, int i) {
            if (imageView != null) {
                Drawable drawable = imageView.getDrawable();
                if (drawable == null || !(drawable instanceof c)) {
                    drawable = new c(str);
                } else {
                    drawable = (c) drawable;
                }
                if (drawable.sIk != i || drawable.sIj == null || drawable.sIj.kcf == null || drawable.sIj.kcf.isRecycled()) {
                    drawable.sIk = i;
                    Bitmap yp = d.yp(i);
                    if (drawable.sIj != null) {
                        drawable.sIj.kcf = yp;
                    }
                }
                drawable.MD(str);
                imageView.setImageDrawable(drawable);
                imageView.invalidate();
            }
        }
    }

    private a(String str) {
        super(b.owB, str);
    }

    private a(String str, byte b) {
        super(b.owB, str, false);
    }

    public final void ho(String str) {
        super.ho(str);
    }
}
