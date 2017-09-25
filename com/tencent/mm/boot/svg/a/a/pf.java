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

public final class pf extends c {
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
                h.moveTo(64.3f, 0.0f);
                h.lineTo(70.33f, 0.0f);
                h.cubicTo(86.35f, 0.75f, 102.06f, 7.25f, 113.7f, 18.31f);
                h.cubicTo(126.44f, 30.12f, 134.09f, 47.01f, 135.0f, 64.32f);
                h.lineTo(135.0f, 70.32f);
                h.cubicTo(134.22f, 87.75f, 126.53f, 104.78f, 113.72f, 116.67f);
                h.cubicTo(102.17f, 127.67f, 86.61f, 134.13f, 70.72f, 135.0f);
                h.lineTo(64.63f, 135.0f);
                h.cubicTo(48.62f, 134.25f, 32.92f, 127.74f, 21.28f, 116.68f);
                h.cubicTo(8.55f, 104.88f, 0.93f, 88.0f, 0.0f, 70.7f);
                h.lineTo(0.0f, 64.71f);
                h.cubicTo(0.79f, 47.24f, 8.48f, 30.17f, 21.34f, 18.28f);
                h.cubicTo(32.89f, 7.31f, 48.43f, 0.87f, 64.3f, 0.0f);
                h.lineTo(64.3f, 0.0f);
                h.close();
                h.moveTo(57.53f, 3.77f);
                h.cubicTo(42.74f, 6.04f, 28.85f, 13.69f, 19.02f, 24.98f);
                h.cubicTo(9.09f, 36.21f, 3.31f, 51.0f, 3.03f, 65.99f);
                h.cubicTo(2.6f, 81.5f, 8.04f, 97.07f, 18.06f, 108.91f);
                h.cubicTo(28.44f, 121.4f, 43.71f, 129.71f, 59.86f, 131.54f);
                h.cubicTo(73.46f, 133.18f, 87.57f, 130.37f, 99.45f, 123.53f);
                h.cubicTo(112.28f, 116.24f, 122.47f, 104.41f, 127.72f, 90.62f);
                h.cubicTo(133.42f, 75.88f, 133.41f, 59.02f, 127.68f, 44.29f);
                h.cubicTo(121.91f, 29.17f, 110.18f, 16.45f, 95.6f, 9.44f);
                h.cubicTo(83.88f, 3.71f, 70.41f, 1.77f, 57.53f, 3.77f);
                h.lineTo(57.53f, 3.77f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(39.39f, 50.47f);
                h.cubicTo(40.75f, 49.66f, 42.45f, 50.14f, 43.95f, 49.98f);
                h.cubicTo(55.32f, 50.06f, 66.69f, 49.92f, 78.05f, 50.04f);
                h.cubicTo(80.05f, 49.9f, 81.29f, 52.08f, 81.0f, 53.87f);
                h.cubicTo(81.01f, 63.3f, 81.01f, 72.73f, 81.0f, 82.15f);
                h.cubicTo(81.28f, 83.92f, 80.07f, 86.09f, 78.08f, 85.95f);
                h.cubicTo(65.99f, 86.06f, 53.9f, 85.97f, 41.8f, 86.0f);
                h.cubicTo(40.0f, 86.34f, 37.93f, 84.99f, 38.04f, 83.03f);
                h.cubicTo(37.92f, 73.7f, 38.05f, 64.36f, 37.98f, 55.02f);
                h.cubicTo(38.0f, 53.42f, 37.8f, 51.43f, 39.39f, 50.47f);
                h.lineTo(39.39f, 50.47f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(84.0f, 64.11f);
                h.cubicTo(89.32f, 59.76f, 94.61f, 55.37f, 99.97f, 51.07f);
                h.cubicTo(100.02f, 61.68f, 100.02f, 72.29f, 99.97f, 82.89f);
                h.cubicTo(94.57f, 79.15f, 89.33f, 75.2f, 84.0f, 71.36f);
                h.lineTo(84.0f, 64.11f);
                h.lineTo(84.0f, 64.11f);
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
