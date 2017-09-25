package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public final class e extends Canvas {
    public Bitmap mBitmap;

    public e(Bitmap bitmap) {
        super(bitmap);
        this.mBitmap = bitmap;
    }

    public final void setBitmap(Bitmap bitmap) {
        super.setBitmap(bitmap);
        this.mBitmap = bitmap;
    }
}
