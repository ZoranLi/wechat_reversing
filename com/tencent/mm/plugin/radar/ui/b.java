package com.tencent.mm.plugin.radar.ui;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mm.pluginsdk.ui.j;

public final class b extends j implements com.tencent.mm.x.d.a {

    public static class a {
        public static com.tencent.mm.pluginsdk.ui.j.a owB;

        public static void a(ImageView imageView, String str) {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof b)) {
                drawable = new b(str);
            } else {
                drawable = (b) drawable;
            }
            drawable.MD(str);
            imageView.setImageDrawable(drawable);
        }
    }

    private b(String str) {
        super(a.owB, str);
    }

    public final void ho(String str) {
        super.ho(str);
    }
}
