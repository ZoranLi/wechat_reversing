package com.tencent.mm.bh;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.svg.b.b;

public final class c {
    com.tencent.mm.svg.a.a upv = new com.tencent.mm.svg.a.a();

    public static class a implements com.tencent.mm.compatible.f.a.a {
        com.tencent.mm.svg.a.a upv = new com.tencent.mm.svg.a.a();

        public final Bitmap decodeResource(Resources resources, int i, Options options) {
            if (!this.upv.d(resources, i)) {
                return null;
            }
            float f = 0.0f;
            if (options != null) {
                f = ((float) options.inDensity) / 160.0f;
            }
            return com.tencent.mm.svg.a.a.b(resources, i, f);
        }
    }

    static {
        com.tencent.mm.compatible.f.a.a(new a());
        b.kb(ab.getContext().getSharedPreferences("wechat_svg_debug", 4).getBoolean("open_tag", false));
    }

    public final Drawable c(Resources resources, int i) {
        if (this.upv.d(resources, i)) {
            return com.tencent.mm.svg.a.a.c(resources, i);
        }
        return null;
    }

    public static void jL(boolean z) {
        ab.getContext().getSharedPreferences("wechat_svg_debug", 4).edit().putBoolean("open_tag", z).commit();
        b.kb(z);
    }
}
