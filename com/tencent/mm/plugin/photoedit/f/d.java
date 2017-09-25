package com.tencent.mm.plugin.photoedit.f;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;

public final class d implements Cloneable {
    private static int omx = com.tencent.mm.plugin.photoedit.g.a.ad(12.0f);
    private static Paint omy;
    private float gj;
    private Path mU;
    private LinkedList<b> okJ;
    public a okK;

    public enum a {
        ONE,
        TWO
    }

    public static class b {
        public float centerX;
        public float centerY;
        public int color = 0;
        public float omC = 0.0f;
        public float rotation = 0.0f;

        public b(float f, int i, float f2, float f3, float f4) {
            this.omC = f;
            this.color = i;
            this.rotation = f2;
            this.centerX = f3;
            this.centerY = f4;
        }
    }

    static {
        Paint paint = new Paint();
        omy = paint;
        paint.setAntiAlias(true);
        omy.setStyle(Style.STROKE);
        omy.setColor(-16776961);
        omy.setStrokeCap(Cap.ROUND);
    }

    public d(a aVar, Path path, float f) {
        this.okK = aVar;
        this.mU = path;
        this.gj = f;
        omy.setStrokeWidth(((float) com.tencent.mm.plugin.photoedit.g.a.ad(34.0f)) * f);
    }

    public d(a aVar, LinkedList<b> linkedList, float f) {
        this.okK = aVar;
        this.okJ = linkedList;
        this.gj = f;
        omy.setStrokeWidth(((float) com.tencent.mm.plugin.photoedit.g.a.ad(34.0f)) * f);
    }

    public final void a(Canvas canvas, Object... objArr) {
        if (this.okK == a.ONE) {
            Bitmap bitmap = (Bitmap) objArr[0];
            if (bitmap != null && !bitmap.isRecycled()) {
                canvas.saveLayer(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight(), null, 31);
                canvas.drawColor(0, Mode.CLEAR);
                canvas.drawPath(this.mU, omy);
                omy.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, omy);
                omy.setXfermode(null);
                canvas.restore();
            }
        } else if (this.okK == a.TWO && this.okJ.size() > 0) {
            b bVar = (b) this.okJ.getLast();
            float f = bVar.omC;
            int i = bVar.color;
            int random = (int) (Math.random() * 100.0d);
            float f2 = ((float) omx) * f;
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(ab.getContext().getResources(), R.g.bhg, options);
            options.inSampleSize = com.tencent.mm.plugin.photoedit.g.a.a(options, Math.round((((float) options.outWidth) * f) * 0.7f), Math.round((((float) options.outHeight) * f) * 0.7f));
            options.inJustDecodeBounds = false;
            Bitmap decodeResource = BitmapFactory.decodeResource(ab.getContext().getResources(), R.g.bhg, options);
            w.i("MicroMsg.MosaicItem", "%s", Float.valueOf(f * 0.7f));
            omy.setStyle(Style.FILL);
            omy.setColorFilter(new LightingColorFilter(i, 1));
            float width = bVar.centerX - ((float) (decodeResource.getWidth() / 2));
            f = bVar.centerY - ((float) (decodeResource.getHeight() / 2));
            if (random > 0 && random <= 20) {
                width += f2;
                f += f2;
            } else if (80 < random) {
                width -= f2;
                f -= f2;
            }
            canvas.save();
            canvas.rotate(-bVar.rotation, bVar.centerX, bVar.centerY);
            canvas.drawBitmap(decodeResource, width, f, omy);
            canvas.restore();
            omy.setStyle(Style.STROKE);
            omy.setColorFilter(null);
        }
    }

    public static void clear() {
    }
}
