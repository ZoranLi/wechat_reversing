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

public final class zk extends c {
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
                Paint a = c.a(g, looper);
                a.setColor(-1);
                c = c.a(c, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 18.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(21.14f, 1.2f);
                h.cubicTo(25.04f, 0.82f, 28.99f, 0.82f, 32.89f, 1.2f);
                h.cubicTo(33.54f, 2.09f, 34.15f, 3.01f, 34.7f, 3.97f);
                h.cubicTo(40.12f, 4.19f, 45.57f, 3.66f, 50.97f, 4.21f);
                h.cubicTo(53.78f, 5.17f, 52.77f, 8.74f, 53.09f, 11.0f);
                h.lineTo(0.91f, 11.0f);
                h.cubicTo(1.23f, 8.75f, 0.21f, 5.22f, 2.98f, 4.22f);
                h.cubicTo(8.39f, 3.65f, 13.86f, 4.2f, 19.3f, 3.97f);
                h.cubicTo(19.84f, 3.0f, 20.46f, 2.07f, 21.14f, 1.2f);
                h.lineTo(21.14f, 1.2f);
                h.lineTo(21.14f, 1.2f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(38.983093f, 49.0f);
                h.lineTo(39.0f, 49.0f);
                h.lineTo(39.0f, 25.0f);
                h.lineTo(38.983974f, 25.0f);
                h.cubicTo(38.98398f, 24.998188f, 38.983982f, 24.996376f, 38.983982f, 24.994562f);
                h.cubicTo(38.983982f, 23.89054f, 38.089172f, 22.99555f, 36.985374f, 22.99555f);
                h.cubicTo(35.881573f, 22.99555f, 34.986767f, 23.89054f, 34.986767f, 24.994562f);
                h.cubicTo(34.986767f, 25.072788f, 34.99126f, 25.149965f, 35.0f, 25.22585f);
                h.lineTo(35.0f, 48.828903f);
                h.cubicTo(34.99126f, 48.904785f, 34.986767f, 48.981964f, 34.986767f, 49.06019f);
                h.cubicTo(34.986767f, 50.16421f, 35.881573f, 51.0592f, 36.985374f, 51.0592f);
                h.cubicTo(38.089172f, 51.0592f, 38.983982f, 50.16421f, 38.983982f, 49.06019f);
                h.cubicTo(38.983982f, 49.040054f, 38.983685f, 49.01999f, 38.983093f, 49.0f);
                h.lineTo(38.983093f, 49.0f);
                h.close();
                h.moveTo(18.983091f, 49.0f);
                h.lineTo(19.0f, 49.0f);
                h.lineTo(19.0f, 25.0f);
                h.lineTo(18.983973f, 25.0f);
                h.cubicTo(18.983978f, 24.998188f, 18.98398f, 24.996376f, 18.98398f, 24.994562f);
                h.cubicTo(18.98398f, 23.89054f, 18.089174f, 22.99555f, 16.985374f, 22.99555f);
                h.cubicTo(15.881574f, 22.99555f, 14.986767f, 23.89054f, 14.986767f, 24.994562f);
                h.cubicTo(14.986767f, 25.072788f, 14.99126f, 25.149965f, 15.0f, 25.22585f);
                h.lineTo(15.0f, 48.828903f);
                h.cubicTo(14.99126f, 48.904785f, 14.986767f, 48.981964f, 14.986767f, 49.06019f);
                h.cubicTo(14.986767f, 50.16421f, 15.881574f, 51.0592f, 16.985374f, 51.0592f);
                h.cubicTo(18.089174f, 51.0592f, 18.98398f, 50.16421f, 18.98398f, 49.06019f);
                h.cubicTo(18.98398f, 49.040054f, 18.983683f, 49.01999f, 18.983091f, 49.0f);
                h.lineTo(18.983091f, 49.0f);
                h.lineTo(18.983091f, 49.0f);
                h.close();
                h.moveTo(28.983091f, 49.0f);
                h.lineTo(29.0f, 49.0f);
                h.lineTo(29.0f, 25.0f);
                h.lineTo(28.983973f, 25.0f);
                h.cubicTo(28.983978f, 24.998188f, 28.98398f, 24.996376f, 28.98398f, 24.994562f);
                h.cubicTo(28.98398f, 23.89054f, 28.089174f, 22.99555f, 26.985374f, 22.99555f);
                h.cubicTo(25.881573f, 22.99555f, 24.986767f, 23.89054f, 24.986767f, 24.994562f);
                h.cubicTo(24.986767f, 25.072788f, 24.991259f, 25.149965f, 25.0f, 25.22585f);
                h.lineTo(25.0f, 48.828903f);
                h.cubicTo(24.991259f, 48.904785f, 24.986767f, 48.981964f, 24.986767f, 49.06019f);
                h.cubicTo(24.986767f, 50.16421f, 25.881573f, 51.0592f, 26.985374f, 51.0592f);
                h.cubicTo(28.089174f, 51.0592f, 28.98398f, 50.16421f, 28.98398f, 49.06019f);
                h.cubicTo(28.98398f, 49.040054f, 28.983683f, 49.01999f, 28.983091f, 49.0f);
                h.lineTo(28.983091f, 49.0f);
                h.lineTo(28.983091f, 49.0f);
                h.close();
                h.moveTo(47.98549f, 14.0f);
                h.cubicTo(47.965504f, 28.023064f, 48.01547f, 42.056126f, 47.9755f, 56.07919f);
                h.cubicTo(48.175358f, 57.828323f, 47.146076f, 59.987255f, 45.12748f, 59.8973f);
                h.cubicTo(33.395657f, 60.087208f, 21.653841f, 59.93728f, 9.912025f, 59.967266f);
                h.cubicTo(8.113279f, 60.207146f, 5.9747696f, 59.117687f, 6.094686f, 57.058704f);
                h.cubicTo(5.8948255f, 42.715797f, 6.084693f, 28.352901f, 6.014742f, 14.0f);
                h.lineTo(47.98549f, 14.0f);
                h.lineTo(47.98549f, 14.0f);
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
