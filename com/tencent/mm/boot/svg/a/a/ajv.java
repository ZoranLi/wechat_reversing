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

public final class ajv extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                float[] a = c.a(c, 1.0f, 0.0f, 13.0f, 0.0f, 1.0f, 13.0f);
                d.reset();
                d.setValues(a);
                canvas.concat(d);
                Paint a2 = c.a(g, looper);
                a2.setColor(-2603989);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                Path h = c.h(looper);
                h.moveTo(5.3f, 1.27f);
                h.cubicTo(23.86f, 0.64f, 42.5f, 1.17f, 61.09f, 1.0f);
                h.cubicTo(64.55f, 0.58f, 68.06f, 3.32f, 67.96f, 6.91f);
                h.cubicTo(68.02f, 25.29f, 68.04f, 43.68f, 67.95f, 62.05f);
                h.cubicTo(68.09f, 65.66f, 64.55f, 68.44f, 61.08f, 68.0f);
                h.cubicTo(43.04f, 67.97f, 25.0f, 68.06f, 6.96f, 67.96f);
                h.cubicTo(3.79f, 68.07f, 0.96f, 65.23f, 1.04f, 62.07f);
                h.cubicTo(0.94f, 44.03f, 1.03f, 25.99f, 0.99f, 7.95f);
                h.cubicTo(0.72f, 5.07f, 2.4f, 2.01f, 5.3f, 1.27f);
                h.lineTo(5.3f, 1.27f);
                h.close();
                h.moveTo(29.0f, 8.97f);
                h.cubicTo(22.26f, 10.71f, 17.07f, 18.36f, 19.85f, 25.17f);
                h.cubicTo(21.77f, 30.46f, 27.73f, 32.84f, 33.01f, 32.22f);
                h.cubicTo(32.1f, 34.88f, 32.92f, 37.5f, 34.54f, 39.66f);
                h.cubicTo(29.02f, 40.04f, 22.96f, 40.74f, 18.68f, 44.65f);
                h.cubicTo(15.73f, 47.26f, 14.46f, 51.93f, 16.58f, 55.44f);
                h.cubicTo(19.11f, 59.71f, 24.39f, 61.19f, 29.04f, 61.46f);
                h.cubicTo(35.32f, 61.82f, 42.32f, 60.5f, 46.74f, 55.67f);
                h.cubicTo(49.75f, 52.48f, 50.77f, 47.34f, 48.54f, 43.44f);
                h.cubicTo(46.49f, 39.88f, 42.63f, 38.04f, 39.9f, 35.12f);
                h.cubicTo(38.9f, 34.03f, 39.19f, 32.23f, 40.15f, 31.21f);
                h.cubicTo(42.52f, 28.58f, 46.03f, 26.66f, 46.91f, 22.97f);
                h.cubicTo(48.39f, 18.27f, 46.03f, 13.4f, 42.37f, 10.46f);
                h.cubicTo(45.62f, 11.0f, 48.58f, 9.74f, 51.23f, 7.96f);
                h.cubicTo(43.83f, 8.25f, 36.24f, 7.08f, 29.0f, 8.97f);
                h.lineTo(29.0f, 8.97f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(a2, looper);
                h = c.h(looper);
                h.moveTo(30.39f, 10.46f);
                h.cubicTo(37.68f, 9.08f, 41.32f, 18.06f, 40.97f, 24.02f);
                h.cubicTo(41.1f, 28.74f, 35.38f, 31.73f, 31.38f, 29.6f);
                h.cubicTo(27.25f, 27.37f, 25.62f, 22.34f, 25.41f, 17.92f);
                h.cubicTo(25.14f, 14.69f, 27.06f, 11.17f, 30.39f, 10.46f);
                h.lineTo(30.39f, 10.46f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.save();
                a2 = c.a(a2, looper);
                h = c.h(looper);
                h.moveTo(28.36f, 42.65f);
                h.cubicTo(31.79f, 41.97f, 36.04f, 40.46f, 39.05f, 43.01f);
                h.cubicTo(41.67f, 45.0f, 45.06f, 47.3f, 44.93f, 51.0f);
                h.cubicTo(45.04f, 54.16f, 42.63f, 56.84f, 39.72f, 57.75f);
                h.cubicTo(35.53f, 59.02f, 30.82f, 58.82f, 26.8f, 57.05f);
                h.cubicTo(23.72f, 55.7f, 21.3f, 52.47f, 21.88f, 48.99f);
                h.cubicTo(22.26f, 45.66f, 25.35f, 43.49f, 28.36f, 42.65f);
                h.lineTo(28.36f, 42.65f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-1);
                c = c.a(a, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 7.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a4 = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(14.0f, 1.97f);
                h.cubicTo(21.24f, 0.08f, 28.83f, 1.25f, 36.23f, 0.96f);
                h.cubicTo(33.58f, 2.74f, 30.62f, 4.0f, 27.37f, 3.46f);
                h.cubicTo(31.03f, 6.4f, 33.39f, 11.27f, 31.91f, 15.97f);
                h.cubicTo(31.03f, 19.66f, 27.52f, 21.58f, 25.15f, 24.21f);
                h.cubicTo(24.19f, 25.23f, 23.9f, 27.03f, 24.9f, 28.12f);
                h.cubicTo(27.63f, 31.04f, 31.49f, 32.88f, 33.54f, 36.44f);
                h.cubicTo(35.77f, 40.34f, 34.75f, 45.48f, 31.74f, 48.67f);
                h.cubicTo(27.32f, 53.5f, 20.32f, 54.82f, 14.04f, 54.46f);
                h.cubicTo(9.39f, 54.19f, 4.11f, 52.71f, 1.58f, 48.44f);
                h.cubicTo(-0.54f, 44.93f, 0.73f, 40.26f, 3.68f, 37.65f);
                h.cubicTo(7.96f, 33.74f, 14.02f, 33.04f, 19.54f, 32.66f);
                h.cubicTo(17.92f, 30.5f, 17.1f, 27.88f, 18.01f, 25.22f);
                h.cubicTo(12.73f, 25.84f, 6.77f, 23.46f, 4.85f, 18.17f);
                h.cubicTo(2.07f, 11.36f, 7.26f, 3.71f, 14.0f, 1.97f);
                h.lineTo(14.0f, 1.97f);
                h.close();
                h.moveTo(15.39f, 3.46f);
                h.cubicTo(12.06f, 4.17f, 10.14f, 7.69f, 10.41f, 10.92f);
                h.cubicTo(10.62f, 15.34f, 12.25f, 20.37f, 16.38f, 22.6f);
                h.cubicTo(20.38f, 24.73f, 26.1f, 21.74f, 25.97f, 17.02f);
                h.cubicTo(26.32f, 11.06f, 22.68f, 2.08f, 15.39f, 3.46f);
                h.lineTo(15.39f, 3.46f);
                h.close();
                h.moveTo(13.36f, 35.65f);
                h.cubicTo(10.35f, 36.49f, 7.26f, 38.66f, 6.88f, 41.99f);
                h.cubicTo(6.3f, 45.47f, 8.72f, 48.7f, 11.8f, 50.05f);
                h.cubicTo(15.82f, 51.82f, 20.53f, 52.02f, 24.72f, 50.75f);
                h.cubicTo(27.63f, 49.84f, 30.04f, 47.16f, 29.93f, 44.0f);
                h.cubicTo(30.06f, 40.3f, 26.67f, 38.0f, 24.05f, 36.01f);
                h.cubicTo(21.04f, 33.46f, 16.79f, 34.97f, 13.36f, 35.65f);
                h.lineTo(13.36f, 35.65f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
