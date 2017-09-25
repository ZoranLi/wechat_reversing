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

public final class eh extends c {
    private final int height = 100;
    private final int width = 100;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 100;
            case 1:
                return 100;
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
                Paint a = c.a(g, looper);
                a.setColor(-9473160);
                a.setStrokeWidth(6.0f);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 59.0f, 0.0f, 1.0f, 38.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(0.0f, 1.9734219f);
                h.cubicTo(0.0f, 0.8835311f, 0.8835311f, 0.0f, 1.9734219f, 0.0f);
                h.lineTo(28.026579f, 0.0f);
                h.cubicTo(29.11647f, 0.0f, 30.0f, 0.8835311f, 30.0f, 1.9734219f);
                h.lineTo(30.0f, 46.026577f);
                h.cubicTo(30.0f, 47.116467f, 29.11647f, 48.0f, 28.026579f, 48.0f);
                h.lineTo(1.9734219f, 48.0f);
                h.cubicTo(0.8835311f, 48.0f, 0.0f, 47.116467f, 0.0f, 46.026577f);
                h.lineTo(0.0f, 1.9734219f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(69.0f, 35.0f);
                h.lineTo(69.0f, 15.980916f);
                h.cubicTo(69.0f, 14.886887f, 68.12216f, 14.0f, 67.02344f, 14.0f);
                h.lineTo(24.976562f, 14.0f);
                h.cubicTo(23.884937f, 14.0f, 23.0f, 14.88437f, 23.0f, 15.981961f);
                h.lineTo(23.0f, 84.018036f);
                h.cubicTo(23.0f, 85.11265f, 23.873781f, 86.0f, 24.969942f, 86.0f);
                h.lineTo(56.0f, 86.0f);
                canvas.drawPath(h, a2);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
