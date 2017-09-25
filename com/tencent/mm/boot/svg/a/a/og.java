package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class og extends c {
    private final int height = 84;
    private final int width = 84;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 84;
            case 1:
                return 84;
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
                a.setColor(-5460820);
                c = c.a(c, 1.0f, 0.0f, 8.0f, 0.0f, 1.0f, 12.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(46.01f, 0.02f);
                h.cubicTo(53.35f, 6.17f, 60.67f, 12.34f, 68.0f, 18.5f);
                h.cubicTo(60.7f, 24.7f, 53.34f, 30.82f, 46.01f, 36.98f);
                h.cubicTo(45.99f, 33.31f, 46.0f, 29.65f, 46.0f, 25.98f);
                h.cubicTo(39.1f, 26.16f, 31.55f, 26.35f, 25.78f, 30.64f);
                h.cubicTo(21.98f, 33.45f, 19.95f, 37.86f, 17.97f, 42.0f);
                h.cubicTo(18.18f, 31.95f, 21.11f, 20.88f, 29.61f, 14.67f);
                h.cubicTo(34.25f, 11.05f, 40.35f, 10.71f, 46.0f, 11.03f);
                h.cubicTo(46.0f, 7.36f, 45.99f, 3.69f, 46.01f, 0.02f);
                h.lineTo(46.01f, 0.02f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(1.0f, 14.9f);
                h.cubicTo(0.7f, 13.12f, 1.87f, 10.94f, 3.88f, 11.05f);
                h.cubicTo(9.91f, 10.9f, 15.95f, 11.07f, 21.98f, 10.99f);
                h.cubicTo(20.17f, 13.1f, 18.65f, 15.45f, 17.47f, 17.98f);
                h.cubicTo(14.32f, 18.01f, 11.16f, 18.0f, 8.0f, 18.0f);
                h.lineTo(8.0f, 52.0f);
                h.lineTo(54.0f, 52.0f);
                h.lineTo(54.0f, 40.15f);
                h.cubicTo(56.32f, 38.16f, 58.65f, 36.2f, 60.99f, 34.24f);
                h.cubicTo(60.96f, 41.53f, 61.08f, 48.82f, 60.95f, 56.1f);
                h.cubicTo(61.01f, 58.07f, 58.92f, 59.33f, 57.12f, 59.0f);
                h.cubicTo(39.38f, 58.97f, 21.62f, 59.07f, 3.88f, 58.95f);
                h.cubicTo(1.87f, 59.05f, 0.69f, 56.86f, 1.0f, 55.07f);
                h.lineTo(1.0f, 14.9f);
                h.lineTo(1.0f, 14.9f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
