package com.tencent.mm.plugin.photoedit.f;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import com.tencent.mm.plugin.photoedit.g.a;

public final class b implements Cloneable {
    private static Paint omg;
    private float gj = 1.0f;
    private Path mU;
    private float mw = ((float) a.ad(5.0f));
    private int sl;

    static {
        Paint paint = new Paint();
        omg = paint;
        paint.setAntiAlias(true);
        omg.setStyle(Style.STROKE);
        omg.setStrokeCap(Cap.ROUND);
    }

    public b(Path path, float f, int i) {
        this.mU = path;
        this.gj = f;
        this.sl = i;
    }

    public final void j(Canvas canvas) {
        omg.setColor(this.sl);
        omg.setStrokeWidth(this.mw * this.gj);
        if (!this.mU.isEmpty()) {
            canvas.drawPath(this.mU, omg);
        }
    }

    public static void clear() {
    }
}
