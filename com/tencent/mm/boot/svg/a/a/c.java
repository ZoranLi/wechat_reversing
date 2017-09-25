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
import com.tencent.smtt.sdk.WebView;

public final class c extends com.tencent.mm.svg.c {
    private final int height = 480;
    private final int width = 480;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 480;
            case 1:
                return 480;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix d = com.tencent.mm.svg.c.d(looper);
                float[] c = com.tencent.mm.svg.c.c(looper);
                Paint g = com.tencent.mm.svg.c.g(looper);
                g.setFlags(385);
                g.setStyle(Style.FILL);
                Paint g2 = com.tencent.mm.svg.c.g(looper);
                g2.setFlags(385);
                g2.setStyle(Style.STROKE);
                g.setColor(WebView.NIGHT_MODE_COLOR);
                g2.setStrokeWidth(1.0f);
                g2.setStrokeCap(Cap.BUTT);
                g2.setStrokeJoin(Join.MITER);
                g2.setStrokeMiter(4.0f);
                g2.setPathEffect(null);
                com.tencent.mm.svg.c.a(g2, looper).setStrokeWidth(1.0f);
                Paint a = com.tencent.mm.svg.c.a(g, looper);
                a.setColor(-10197916);
                canvas.save();
                float[] a2 = com.tencent.mm.svg.c.a(c, 1.0f, 0.0f, 129.0f, 0.0f, 1.0f, 40.0f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                canvas.save();
                a = com.tencent.mm.svg.c.a(a, looper);
                Path h = com.tencent.mm.svg.c.h(looper);
                h.moveTo(52.88f, 2.34f);
                h.cubicTo(83.17f, -0.27f, 113.62f, -0.47f, 143.98f, 0.65f);
                h.cubicTo(164.16f, 1.66f, 184.48f, 2.9f, 204.2f, 7.55f);
                h.cubicTo(208.85f, 9.09f, 214.18f, 9.64f, 217.91f, 13.12f);
                h.cubicTo(220.31f, 15.36f, 220.97f, 18.86f, 221.01f, 22.01f);
                h.cubicTo(221.0f, 85.32f, 220.99f, 148.62f, 221.01f, 211.93f);
                h.cubicTo(216.39f, 210.99f, 211.71f, 210.37f, 207.0f, 210.15f);
                h.lineTo(207.0f, 39.0f);
                h.lineTo(15.0f, 39.0f);
                h.lineTo(15.0f, 349.0f);
                h.cubicTo(49.27f, 349.0f, 83.54f, 348.99f, 117.8f, 349.01f);
                h.cubicTo(129.91f, 372.37f, 152.15f, 390.17f, 177.61f, 396.85f);
                h.cubicTo(150.51f, 399.69f, 123.22f, 400.3f, 95.99f, 399.86f);
                h.cubicTo(76.6f, 399.47f, 57.18f, 398.54f, 37.94f, 395.97f);
                h.cubicTo(27.89f, 394.45f, 17.59f, 393.03f, 8.27f, 388.78f);
                h.cubicTo(3.72f, 386.8f, 0.61f, 382.03f, 0.99f, 377.02f);
                h.cubicTo(1.01f, 258.69f, 0.99f, 140.35f, 1.0f, 22.01f);
                h.cubicTo(0.73f, 17.32f, 3.13f, 12.48f, 7.65f, 10.71f);
                h.cubicTo(22.18f, 5.57f, 37.62f, 3.82f, 52.88f, 2.34f);
                h.lineTo(52.88f, 2.34f);
                h.close();
                h.moveTo(107.37f, 365.4f);
                h.cubicTo(100.42f, 367.88f, 99.38f, 378.51f, 105.75f, 382.26f);
                h.cubicTo(111.42f, 386.43f, 120.38f, 381.97f, 120.53f, 374.95f);
                h.cubicTo(121.31f, 368.17f, 113.58f, 362.48f, 107.37f, 365.4f);
                h.lineTo(107.37f, 365.4f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a = com.tencent.mm.svg.c.a(g, looper);
                a.setColor(-11286451);
                a2 = com.tencent.mm.svg.c.a(a2, 1.0f, 0.0f, 236.0f, 0.0f, 1.0f, 250.0f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                canvas.save();
                Paint a3 = com.tencent.mm.svg.c.a(a, looper);
                h = com.tencent.mm.svg.c.h(looper);
                h.moveTo(40.38f, 17.29f);
                h.cubicTo(57.58f, 5.08f, 78.95f, -1.01f, 100.0f, 0.15f);
                h.cubicTo(104.71f, 0.37f, 109.39f, 0.99f, 114.01f, 1.93f);
                h.cubicTo(135.63f, 6.26f, 155.53f, 18.47f, 169.23f, 35.74f);
                h.cubicTo(183.27f, 53.17f, 190.74f, 75.71f, 189.93f, 98.07f);
                h.cubicTo(189.38f, 116.69f, 183.18f, 135.1f, 172.29f, 150.23f);
                h.cubicTo(161.67f, 165.14f, 146.64f, 176.83f, 129.6f, 183.48f);
                h.cubicTo(110.95f, 190.83f, 89.98f, 191.94f, 70.61f, 186.85f);
                h.cubicTo(45.15f, 180.17f, 22.91f, 162.37f, 10.8f, 139.01f);
                h.cubicTo(0.55f, 119.56f, -2.54f, 96.47f, 2.14f, 75.0f);
                h.cubicTo(6.99f, 51.85f, 21.01f, 30.83f, 40.38f, 17.29f);
                h.lineTo(40.38f, 17.29f);
                h.close();
                h.moveTo(69.42f, 54.37f);
                h.cubicTo(64.32f, 63.42f, 66.44f, 74.11f, 66.0f, 84.0f);
                h.cubicTo(61.38f, 84.11f, 56.74f, 83.75f, 52.13f, 84.17f);
                h.cubicTo(50.68f, 84.92f, 51.1f, 86.64f, 50.98f, 87.97f);
                h.cubicTo(51.07f, 104.98f, 50.88f, 121.99f, 51.08f, 139.0f);
                h.cubicTo(50.87f, 140.62f, 52.67f, 141.15f, 53.95f, 140.98f);
                h.cubicTo(80.96f, 141.04f, 107.98f, 140.96f, 135.0f, 141.02f);
                h.cubicTo(136.44f, 140.99f, 139.11f, 141.2f, 138.92f, 139.01f);
                h.cubicTo(139.12f, 122.0f, 138.92f, 104.97f, 139.02f, 87.95f);
                h.cubicTo(138.9f, 86.62f, 139.3f, 84.91f, 137.87f, 84.16f);
                h.cubicTo(133.26f, 83.76f, 128.62f, 84.11f, 124.0f, 84.0f);
                h.cubicTo(123.92f, 77.96f, 124.16f, 71.93f, 123.88f, 65.9f);
                h.cubicTo(123.25f, 54.07f, 114.44f, 43.28f, 103.04f, 40.15f);
                h.cubicTo(90.29f, 36.19f, 75.49f, 42.52f, 69.42f, 54.37f);
                h.lineTo(69.42f, 54.37f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.save();
                a = com.tencent.mm.svg.c.a(a, looper);
                h = com.tencent.mm.svg.c.h(looper);
                h.moveTo(78.3f, 64.93f);
                h.cubicTo(79.7f, 55.97f, 89.18f, 49.4f, 98.07f, 51.29f);
                h.cubicTo(105.53f, 52.53f, 111.64f, 59.33f, 111.92f, 66.92f);
                h.cubicTo(112.13f, 72.6f, 111.93f, 78.3f, 112.0f, 84.0f);
                h.lineTo(78.0f, 84.0f);
                h.cubicTo(78.16f, 77.64f, 77.65f, 71.26f, 78.3f, 64.93f);
                h.lineTo(78.3f, 64.93f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                canvas.save();
                g = com.tencent.mm.svg.c.a(g, looper);
                g.setColor(-1);
                c = com.tencent.mm.svg.c.a(a2, 1.0f, 0.0f, 286.0f, 0.0f, 1.0f, 288.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a4 = com.tencent.mm.svg.c.a(g, looper);
                h = com.tencent.mm.svg.c.h(looper);
                h.moveTo(19.42f, 16.37f);
                h.cubicTo(25.49f, 4.52f, 40.29f, -1.81f, 53.04f, 2.15f);
                h.cubicTo(64.44f, 5.28f, 73.25f, 16.07f, 73.88f, 27.9f);
                h.cubicTo(74.16f, 33.93f, 73.92f, 39.96f, 74.0f, 46.0f);
                h.cubicTo(78.62f, 46.11f, 83.26f, 45.76f, 87.87f, 46.16f);
                h.cubicTo(89.3f, 46.91f, 88.9f, 48.62f, 89.02f, 49.95f);
                h.cubicTo(88.92f, 66.97f, 89.12f, 84.0f, 88.92f, 101.01f);
                h.cubicTo(89.11f, 103.2f, 86.44f, 102.99f, 85.0f, 103.02f);
                h.cubicTo(57.98f, 102.96f, 30.96f, 103.04f, 3.95f, 102.98f);
                h.cubicTo(2.67f, 103.15f, 0.87f, 102.62f, 1.08f, 101.0f);
                h.cubicTo(0.88f, 83.99f, 1.07f, 66.98f, 0.98f, 49.97f);
                h.cubicTo(1.1f, 48.64f, 0.68f, 46.92f, 2.13f, 46.17f);
                h.cubicTo(6.74f, 45.75f, 11.38f, 46.11f, 16.0f, 46.0f);
                h.cubicTo(16.44f, 36.11f, 14.32f, 25.42f, 19.42f, 16.37f);
                h.lineTo(19.42f, 16.37f);
                h.close();
                h.moveTo(28.3f, 26.93f);
                h.cubicTo(27.65f, 33.26f, 28.16f, 39.64f, 28.0f, 46.0f);
                h.lineTo(62.0f, 46.0f);
                h.cubicTo(61.93f, 40.3f, 62.13f, 34.6f, 61.92f, 28.92f);
                h.cubicTo(61.64f, 21.33f, 55.53f, 14.53f, 48.07f, 13.29f);
                h.cubicTo(39.18f, 11.4f, 29.7f, 17.97f, 28.3f, 26.93f);
                h.lineTo(28.3f, 26.93f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a4);
                canvas.restore();
                canvas.restore();
                com.tencent.mm.svg.c.f(looper);
                break;
        }
        return 0;
    }
}
