package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.map.b;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class ox extends c {
    private final int height = b.CTRL_INDEX;
    private final int width = b.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return b.CTRL_INDEX;
            case 1:
                return b.CTRL_INDEX;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.d(looper);
                c.c(looper);
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
                Paint a = c.a(g, looper);
                a.setColor(-10589839);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(64.55f, 0.0f);
                h.lineTo(70.3f, 0.0f);
                h.cubicTo(86.56f, 0.74f, 102.48f, 7.43f, 114.19f, 18.78f);
                h.cubicTo(126.68f, 30.59f, 134.15f, 47.34f, 135.0f, 64.49f);
                h.lineTo(135.0f, 70.32f);
                h.cubicTo(134.22f, 87.76f, 126.52f, 104.8f, 113.7f, 116.69f);
                h.cubicTo(102.11f, 127.71f, 86.51f, 134.18f, 70.57f, 135.0f);
                h.lineTo(64.68f, 135.0f);
                h.cubicTo(48.42f, 134.25f, 32.49f, 127.56f, 20.79f, 116.2f);
                h.cubicTo(8.3f, 104.4f, 0.86f, 87.65f, 0.0f, 70.53f);
                h.lineTo(0.0f, 64.73f);
                h.cubicTo(0.78f, 47.27f, 8.46f, 30.2f, 21.31f, 18.3f);
                h.cubicTo(32.92f, 7.27f, 48.57f, 0.79f, 64.55f, 0.0f);
                h.lineTo(64.55f, 0.0f);
                h.close();
                h.moveTo(57.57f, 3.76f);
                h.cubicTo(42.77f, 6.03f, 28.87f, 13.67f, 19.03f, 24.97f);
                h.cubicTo(8.86f, 36.44f, 3.07f, 51.66f, 3.01f, 66.99f);
                h.cubicTo(2.83f, 82.17f, 8.26f, 97.33f, 18.07f, 108.92f);
                h.cubicTo(28.27f, 121.18f, 43.18f, 129.42f, 59.01f, 131.44f);
                h.cubicTo(73.12f, 133.33f, 87.84f, 130.41f, 100.1f, 123.15f);
                h.cubicTo(112.86f, 115.71f, 122.92f, 103.74f, 128.0f, 89.86f);
                h.cubicTo(133.51f, 75.09f, 133.3f, 58.28f, 127.43f, 43.65f);
                h.cubicTo(121.49f, 28.59f, 109.62f, 15.99f, 94.96f, 9.14f);
                h.cubicTo(83.41f, 3.65f, 70.2f, 1.81f, 57.57f, 3.76f);
                h.lineTo(57.57f, 3.76f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(52.64f, 42.68f);
                h.cubicTo(60.99f, 35.84f, 74.0f, 35.84f, 82.36f, 42.67f);
                h.cubicTo(90.3f, 48.74f, 93.47f, 59.94f, 90.25f, 69.35f);
                h.cubicTo(86.23f, 81.43f, 77.11f, 90.99f, 67.54f, 99.01f);
                h.cubicTo(58.06f, 91.23f, 49.2f, 81.82f, 44.99f, 70.09f);
                h.cubicTo(41.41f, 60.53f, 44.46f, 48.9f, 52.64f, 42.68f);
                h.lineTo(52.64f, 42.68f);
                h.close();
                h.moveTo(63.25f, 50.28f);
                h.cubicTo(57.51f, 52.32f, 54.12f, 59.12f, 56.0f, 64.93f);
                h.cubicTo(57.68f, 71.09f, 64.79f, 74.99f, 70.89f, 73.01f);
                h.cubicTo(77.08f, 71.35f, 80.99f, 64.21f, 79.01f, 58.11f);
                h.cubicTo(77.27f, 51.6f, 69.49f, 47.69f, 63.25f, 50.28f);
                h.lineTo(63.25f, 50.28f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
