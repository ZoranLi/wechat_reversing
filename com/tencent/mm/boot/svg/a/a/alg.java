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

public final class alg extends c {
    private final int height = 240;
    private final int width = 240;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 240;
            case 1:
                return 240;
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
                a.setColor(-15879408);
                c = c.a(c, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(95.55f, 0.86f);
                h.cubicTo(119.32f, -2.19f, 144.07f, 2.98f, 164.58f, 15.41f);
                h.cubicTo(186.83f, 28.72f, 204.03f, 50.3f, 211.85f, 75.04f);
                h.cubicTo(219.43f, 98.53f, 218.59f, 124.63f, 209.5f, 147.57f);
                h.cubicTo(199.91f, 172.1f, 180.97f, 192.79f, 157.4f, 204.55f);
                h.cubicTo(134.65f, 216.07f, 107.76f, 218.98f, 83.03f, 212.84f);
                h.cubicTo(56.39f, 206.36f, 32.6f, 189.18f, 17.92f, 166.03f);
                h.cubicTo(4.3f, 144.85f, -1.44f, 118.78f, 1.94f, 93.84f);
                h.cubicTo(4.98f, 69.99f, 16.41f, 47.37f, 33.67f, 30.65f);
                h.cubicTo(50.33f, 14.34f, 72.39f, 3.65f, 95.55f, 0.86f);
                h.lineTo(95.55f, 0.86f);
                h.close();
                h.moveTo(158.3f, 71.29f);
                h.cubicTo(138.2f, 94.33f, 118.23f, 117.5f, 98.19f, 140.6f);
                h.cubicTo(88.05f, 130.48f, 77.91f, 120.35f, 67.79f, 110.2f);
                h.cubicTo(66.69f, 109.14f, 65.53f, 108.0f, 63.96f, 107.72f);
                h.cubicTo(58.37f, 106.48f, 52.71f, 114.39f, 57.26f, 118.78f);
                h.cubicTo(69.36f, 131.0f, 81.57f, 143.12f, 93.73f, 155.3f);
                h.cubicTo(96.07f, 158.1f, 100.88f, 158.18f, 103.15f, 155.26f);
                h.cubicTo(124.54f, 130.6f, 145.9f, 105.9f, 167.3f, 81.25f);
                h.cubicTo(168.06f, 80.26f, 168.99f, 79.31f, 169.25f, 78.04f);
                h.cubicTo(170.72f, 72.43f, 162.64f, 66.64f, 158.3f, 71.29f);
                h.lineTo(158.3f, 71.29f);
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
