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

public final class xr extends c {
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
                Paint a = c.a(g, looper);
                a.setColor(-9473160);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 20.0f, 0.0f, 1.0f, 16.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(53.0f, 46.7158f);
                h.cubicTo(53.0f, 48.5108f, 51.705f, 50.4728f, 49.974f, 51.3188f);
                h.cubicTo(49.355f, 51.5178f, 46.938f, 52.0728f, 46.36f, 52.1898f);
                h.cubicTo(45.499f, 52.3608f, 44.713f, 52.1748f, 44.02f, 51.6328f);
                h.cubicTo(43.17f, 50.9718f, 42.587f, 49.8498f, 42.534f, 48.7778f);
                h.cubicTo(42.435f, 46.7368f, 43.718f, 45.0968f, 44.979f, 44.8438f);
                h.lineTo(50.365f, 43.7648f);
                h.cubicTo(51.329f, 43.5708f, 52.227f, 43.1428f, 53.0f, 42.5478f);
                h.lineTo(53.0f, 46.7158f);
                h.close();
                h.moveTo(13.471f, 55.4638f);
                h.cubicTo(13.471f, 57.2588f, 12.174f, 59.2228f, 10.446f, 60.0668f);
                h.cubicTo(9.822f, 60.2678f, 7.39f, 60.8258f, 6.832f, 60.9378f);
                h.cubicTo(5.972f, 61.1088f, 5.185f, 60.9208f, 4.489f, 60.3808f);
                h.cubicTo(3.641f, 59.7188f, 3.058f, 58.5988f, 3.006f, 57.5248f);
                h.cubicTo(2.906f, 55.4858f, 4.187f, 53.8458f, 5.449f, 53.5928f);
                h.lineTo(10.835f, 52.5128f);
                h.cubicTo(11.8f, 52.3198f, 12.697f, 51.8908f, 13.471f, 51.2958f);
                h.lineTo(13.471f, 55.4638f);
                h.close();
                h.moveTo(13.161f, 9.3678f);
                h.lineTo(13.161f, 13.2228f);
                h.lineTo(13.178f, 13.2188f);
                h.lineTo(13.178f, 45.9798f);
                h.cubicTo(13.178f, 47.6388f, 11.86f, 49.2478f, 10.245f, 49.5708f);
                h.lineTo(4.859f, 50.6508f);
                h.cubicTo(2.161f, 51.1918f, -0.164f, 54.1378f, 0.009f, 57.6718f);
                h.cubicTo(0.182f, 61.2058f, 3.328f, 64.6998f, 7.421f, 63.8788f);
                h.cubicTo(7.847f, 63.7938f, 11.11f, 63.0668f, 11.626f, 62.8268f);
                h.cubicTo(14.405f, 61.5358f, 16.471f, 58.5378f, 16.471f, 55.4638f);
                h.lineTo(16.471f, 52.1628f);
                h.lineTo(16.471f, 12.4988f);
                h.lineTo(52.708f, 4.5748f);
                h.lineTo(52.708f, 37.2318f);
                h.cubicTo(52.708f, 38.8898f, 51.389f, 40.4988f, 49.775f, 40.8228f);
                h.lineTo(44.388f, 41.9028f);
                h.cubicTo(41.691f, 42.4438f, 39.365f, 45.3898f, 39.539f, 48.9238f);
                h.cubicTo(39.712f, 52.4568f, 42.857f, 55.9518f, 46.951f, 55.1308f);
                h.cubicTo(47.377f, 55.0448f, 50.639f, 54.3188f, 51.156f, 54.0788f);
                h.cubicTo(53.934f, 52.7868f, 56.0f, 49.7898f, 56.0f, 46.7158f);
                h.lineTo(56.0f, 43.4148f);
                h.lineTo(56.0f, 3.3078f);
                h.lineTo(56.0f, -2.0E-4f);
                h.lineTo(13.161f, 9.3678f);
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
