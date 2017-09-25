package com.google.android.gms.c;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import com.tencent.smtt.sdk.WebView;

public final class k {
    public static Bitmap c(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int i;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width >= height) {
            width = (height - width) / 2;
            int i2 = height;
            height = 0;
            i = i2;
        } else {
            height = (width - height) / 2;
            i = width;
            width = 0;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(WebView.NIGHT_MODE_COLOR);
        canvas.drawCircle((float) (i / 2), (float) (i / 2), (float) (i / 2), paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, (float) width, (float) height, paint);
        return createBitmap;
    }
}
