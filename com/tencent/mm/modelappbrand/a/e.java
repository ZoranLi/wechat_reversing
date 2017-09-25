package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.sdk.platformtools.d;

public final class e implements f {
    public static final e hqF = new e();

    public final Bitmap i(Bitmap bitmap) {
        if (bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return bitmap;
        }
        return d.a(bitmap, false, (float) (bitmap.getWidth() / 2), false);
    }

    public final String Bc() {
        return "WxaIcon";
    }
}
