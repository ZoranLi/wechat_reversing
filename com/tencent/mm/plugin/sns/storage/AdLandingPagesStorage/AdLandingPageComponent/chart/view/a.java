package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.c;

public final class a extends View {
    private c qhi;

    public a(Context context, c cVar) {
        super(context);
        this.qhi = cVar;
    }

    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        int min = (int) (((double) (((float) Math.min(height, width)) / 2.0f)) * 0.8d);
        width = (int) (((float) width) / 2.0f);
        height = (int) (((float) height) / 2.0f);
        Bitmap bitmap = this.qhi.qgQ;
        if (bitmap != null) {
            min = (int) (((float) (min * 2)) + (this.qhi.qgR * 2.0f));
            int width2 = (bitmap.getWidth() * min) / bitmap.getHeight();
            canvas.drawBitmap(Bitmap.createScaledBitmap(bitmap, width2, min, false), (float) (width - (width2 >>> 1)), (float) (height - (min >>> 1)), null);
        }
    }
}
