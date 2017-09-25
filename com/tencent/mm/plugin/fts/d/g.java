package com.tencent.mm.plugin.fts.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

public interface g {

    public static class a extends BitmapDrawable {
        public static void a(Resources resources, Bitmap bitmap, ImageView imageView) {
            imageView.setImageDrawable(new a(resources, bitmap));
            imageView.postInvalidate();
        }

        private a(Resources resources, Bitmap bitmap) {
            super(resources, bitmap);
        }

        public final void draw(Canvas canvas) {
            if (getBitmap() != null && !getBitmap().isRecycled()) {
                super.draw(canvas);
            }
        }
    }

    Bitmap a(String str, String str2, boolean z, int i, int i2);

    String a(ImageView imageView, String str, String str2, boolean z, int i, int i2);

    void a(Context context, ImageView imageView, String str, String str2, boolean z, int i, int i2);

    void axX();

    void axY();

    boolean axZ();

    void aya();

    void ayb();

    void ayc();
}
