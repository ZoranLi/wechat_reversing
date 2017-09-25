package com.tencent.mm.plugin.sns.lucky.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.Color;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;

public final class a {
    public static n dq(String str, String str2) {
        int argb = Color.argb(51, 255, 255, 255);
        n EI = i.EI(str);
        if (EI != null) {
            return a(EI.ww(), str2, argb, 55);
        }
        w.e("MicroMsg.BlurHelper", "returnBitmap error1 ");
        return null;
    }

    public static n a(Bitmap bitmap, String str, int i, int i2) {
        n g = n.g(d.c(bitmap, i2));
        if (g == null) {
            w.e("MicroMsg.BlurHelper", "returnBitmap error2 ");
        }
        if (g != null) {
            new Canvas(g.ww()).drawColor(i);
        }
        try {
            d.a(g.ww(), 70, CompressFormat.JPEG, str, false);
        } catch (Throwable e) {
            w.e("MicroMsg.BlurHelper", "error for exception " + e.getMessage());
            w.printErrStackTrace("MicroMsg.BlurHelper", e, "", new Object[0]);
        }
        w.i("MicroMsg.BlurHelper", "blur done bitmap  " + g);
        return g;
    }
}
