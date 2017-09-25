package com.tencent.mm.plugin.appbrand.share;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.sdk.platformtools.d;
import junit.framework.Assert;

public final class b implements f {
    private int RQ;
    private int aar;

    public b(int i, int i2) {
        boolean z;
        boolean z2 = true;
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertFalse(z);
        if (i2 != 0) {
            z2 = false;
        }
        Assert.assertFalse(z2);
        this.aar = i;
        this.RQ = i2;
    }

    public final Bitmap i(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = ((float) this.RQ) / ((float) this.aar);
        Bitmap createBitmap = d.createBitmap(this.aar, this.RQ, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Rect rect = new Rect();
        rect.left = 0;
        rect.top = 0;
        if (f <= ((float) height) / ((float) width)) {
            rect.right = width;
            rect.bottom = (int) (((float) width) * f);
        } else {
            rect.right = (int) (((float) height) / f);
            rect.bottom = height;
        }
        Rect rect2 = new Rect();
        rect2.left = 0;
        rect2.top = 0;
        rect2.right = this.aar;
        rect2.bottom = this.RQ;
        canvas.drawBitmap(bitmap, rect, rect2, null);
        return createBitmap;
    }

    public final String Bc() {
        return getClass().getName();
    }
}
