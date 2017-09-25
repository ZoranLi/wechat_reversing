package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class ahi extends c {
    private final int height = 24;
    private final int width = 14;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 14;
            case 1:
                return 24;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix d = c.d(looper);
                float[] c = c.c(looper);
                Paint g = c.g(looper);
                g.setFlags(385);
                g.setStyle(Style.FILL);
                Paint g2 = c.g(looper);
                g2.setFlags(385);
                g2.setStyle(Style.STROKE);
                g.setColor(WebView.NIGHT_MODE_COLOR);
                g2.setStrokeWidth(1.0f);
                g2.setStrokeCap(Cap.BUTT);
                g2.setStrokeJoin(Join.MITER);
                g2.setStrokeMiter(4.0f);
                g2.setPathEffect(null);
                g = c.a(g2, looper);
                g.setStrokeWidth(1.0f);
                g.setStrokeCap(Cap.SQUARE);
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-7039852);
                a.setStrokeWidth(1.3333334f);
                c = c.a(c, 1.0f, 0.0f, -297.0f, 0.0f, 1.0f, -1097.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(309.1949f, 1109.0f);
                h.lineTo(309.33334f, 1108.8616f);
                h.lineTo(309.09744f, 1108.6256f);
                h.lineTo(298.70767f, 1098.2358f);
                h.lineTo(298.47177f, 1098.0f);
                h.lineTo(298.0f, 1098.4718f);
                h.lineTo(298.2359f, 1098.7076f);
                h.lineTo(308.52823f, 1109.0f);
                h.lineTo(298.2359f, 1119.2924f);
                h.lineTo(298.0f, 1119.5282f);
                h.lineTo(298.47177f, 1120.0f);
                h.lineTo(298.70767f, 1119.7642f);
                h.lineTo(309.09744f, 1109.3744f);
                h.lineTo(309.33334f, 1109.1384f);
                h.lineTo(309.1949f, 1109.0f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
