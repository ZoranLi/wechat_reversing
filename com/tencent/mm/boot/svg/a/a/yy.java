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

public final class yy extends c {
    private final int height = 73;
    private final int width = 68;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 68;
            case 1:
                return 73;
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
                a.setColor(-757915);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 9.45f, 0.0f, 1.0f, 6.75f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(0.0f, 2.533342f);
                h.cubicTo(0.0f, 1.1342157f, 1.1371257f, 0.0f, 2.5456994f, 0.0f);
                h.lineTo(47.4043f, 0.0f);
                h.cubicTo(48.810253f, 0.0f, 49.95f, 1.1335528f, 49.95f, 2.533342f);
                h.lineTo(49.95f, 56.866657f);
                h.cubicTo(49.95f, 58.265785f, 48.812874f, 59.4f, 47.4043f, 59.4f);
                h.lineTo(2.5456994f, 59.4f);
                h.cubicTo(1.1397485f, 59.4f, 0.0f, 58.26645f, 0.0f, 56.866657f);
                h.lineTo(0.0f, 2.533342f);
                h.close();
                h.moveTo(4.2814283f, 4.242857f);
                h.lineTo(45.66857f, 4.242857f);
                h.lineTo(45.66857f, 55.157143f);
                h.lineTo(4.2814283f, 55.157143f);
                h.lineTo(4.2814283f, 4.242857f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(24.975f, 21.214287f);
                h.cubicTo(27.733664f, 21.214287f, 29.970001f, 23.430477f, 29.970001f, 26.164286f);
                h.cubicTo(29.970001f, 28.898094f, 27.733664f, 31.114285f, 24.975f, 31.114285f);
                h.cubicTo(22.216337f, 31.114285f, 19.98f, 28.898094f, 19.98f, 26.164286f);
                h.cubicTo(19.98f, 23.430477f, 22.216337f, 21.214287f, 24.975f, 21.214287f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(32.8229f, 26.016615f);
                h.cubicTo(42.771538f, 23.7808f, 49.95f, 17.410063f, 49.95f, 9.9f);
                h.cubicTo(49.95f, 7.916405f, 49.449215f, 6.0122924f, 48.528873f, 4.242857f);
                h.lineTo(45.262028f, 4.242857f);
                h.cubicTo(45.528664f, 5.0701585f, 45.66857f, 5.96271f, 45.66857f, 6.9225564f);
                h.cubicTo(45.66857f, 13.030636f, 40.002968f, 20.055094f, 32.067444f, 22.827524f);
                h.cubicTo(32.532673f, 23.796925f, 32.801483f, 24.876797f, 32.8229f, 26.016615f);
                h.close();
                h.moveTo(17.1271f, 26.016615f);
                h.cubicTo(7.178464f, 23.7808f, 0.0f, 17.410063f, 0.0f, 9.9f);
                h.cubicTo(0.0f, 7.916405f, 0.5007839f, 6.0122924f, 1.421125f, 4.242857f);
                h.lineTo(4.6879735f, 4.242857f);
                h.cubicTo(4.4213357f, 5.0701585f, 4.2814283f, 5.96271f, 4.2814283f, 6.9225564f);
                h.cubicTo(4.2814283f, 13.030636f, 9.947033f, 20.055094f, 17.882557f, 22.827524f);
                h.cubicTo(17.417328f, 23.796925f, 17.148516f, 24.876797f, 17.1271f, 26.016615f);
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
