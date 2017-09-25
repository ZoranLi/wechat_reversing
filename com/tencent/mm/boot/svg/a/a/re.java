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

public final class re extends c {
    private final int height = 14;
    private final int width = 57;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 57;
            case 1:
                return 14;
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
                c.a(g2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-3684404);
                c = c.a(c, 1.0f, 0.0f, -799.0f, 0.0f, 1.0f, -836.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 203.0f, 0.0f, 1.0f, 793.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 596.4823f, 0.0f, 1.0f, 43.304348f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(6.4615383f, 0.0f);
                h.cubicTo(10.030148f, 0.0f, 12.923077f, 2.9101489f, 12.923077f, 6.5f);
                h.cubicTo(12.923077f, 10.089851f, 10.030148f, 13.0f, 6.4615383f, 13.0f);
                h.cubicTo(2.892929f, 13.0f, 0.0f, 10.089851f, 0.0f, 6.5f);
                h.cubicTo(0.0f, 2.9101489f, 2.892929f, 0.0f, 6.4615383f, 0.0f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(28.0f, 0.0f);
                h.cubicTo(31.56861f, 0.0f, 34.46154f, 2.9101489f, 34.46154f, 6.5f);
                h.cubicTo(34.46154f, 10.089851f, 31.56861f, 13.0f, 28.0f, 13.0f);
                h.cubicTo(24.43139f, 13.0f, 21.538462f, 10.089851f, 21.538462f, 6.5f);
                h.cubicTo(21.538462f, 2.9101489f, 24.43139f, 0.0f, 28.0f, 0.0f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(49.53846f, 0.0f);
                h.cubicTo(53.10707f, 0.0f, 56.0f, 2.9101489f, 56.0f, 6.5f);
                h.cubicTo(56.0f, 10.089851f, 53.10707f, 13.0f, 49.53846f, 13.0f);
                h.cubicTo(45.96985f, 13.0f, 43.07692f, 10.089851f, 43.07692f, 6.5f);
                h.cubicTo(43.07692f, 2.9101489f, 45.96985f, 0.0f, 49.53846f, 0.0f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
