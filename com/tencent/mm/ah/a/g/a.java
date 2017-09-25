package com.tencent.mm.ah.a.g;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.ah.a.c;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import java.io.IOException;

public final class a {
    public static Bitmap a(c cVar, String str, int i, int i2) {
        if (i > 0 && i2 > 0) {
            return d.d(str, i2, i, false);
        }
        if (cVar == null || cVar.width <= 0 || cVar.width <= 0) {
            return d.Pg(str);
        }
        return d.O(str, cVar.width, cVar.height);
    }

    public static Bitmap b(c cVar, String str, int i, int i2) {
        int i3 = 0;
        Options Pe = d.Pe(str);
        if (Pe == null || (Pe.outWidth < Pe.outHeight * 2 && Pe.outWidth * 2 > Pe.outHeight)) {
            return d.d(str, i2, i, false);
        }
        if (i > 0 && i2 > 0) {
            return d.d(str, i2, i, true);
        }
        if (cVar != null && cVar.width > 0 && cVar.width > 0) {
            return d.d(str, cVar.height, cVar.width, true);
        }
        int i4;
        if (cVar == null || cVar.Bf() == null) {
            w.w("MicroMsg.imageloader.ImageLoaderUtils", "crop bitmap cant not un set width or height");
            i4 = 0;
        } else {
            i4 = cVar.Bf().getMeasuredWidth();
            i3 = cVar.Bf().getMeasuredHeight();
        }
        return d.d(str, i3, i4, true);
    }

    public static Bitmap a(c cVar, byte[] bArr, int i, int i2, boolean z, float f, boolean z2) {
        Bitmap decodeByteArray;
        if (i > 0 && i2 > 0) {
            decodeByteArray = d.decodeByteArray(bArr, i, i2);
        } else if (cVar == null || cVar.width <= 0 || cVar.width <= 0) {
            decodeByteArray = d.bd(bArr);
        } else {
            decodeByteArray = d.decodeByteArray(bArr, cVar.width, cVar.height);
        }
        if (z) {
            decodeByteArray = d.a(d.decodeByteArray(bArr, i, i2), i, i2, false, true);
        }
        if (f > 0.0f) {
            decodeByteArray = d.c(decodeByteArray, f);
        }
        if (z2) {
            return d.M(decodeByteArray);
        }
        return decodeByteArray;
    }

    public static Bitmap c(c cVar, String str, int i, int i2) {
        if (i > 0 && i2 > 0) {
            return d.P(str, i, i2);
        }
        if (cVar != null) {
            try {
                if (cVar.width > 0 && cVar.width > 0) {
                    return d.P(str, cVar.width, cVar.height);
                }
            } catch (IOException e) {
                w.e("MicroMsg.imageloader.ImageLoaderUtils", "get bitmap from assert failed. :%s", e.toString());
                return null;
            }
        }
        return d.P(str, 0, 0);
    }

    public static Bitmap a(c cVar, int i, int i2, int i3) {
        if (i2 > 0 && i3 > 0) {
            return d.V(i, i2, i3);
        }
        if (cVar == null || cVar.width <= 0 || cVar.width <= 0) {
            return d.yp(i);
        }
        return d.V(i, cVar.width, cVar.height);
    }
}
