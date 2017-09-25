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

public final class et extends c {
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
                c = c.a(c, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 17.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(45.0513f, 58.846f);
                h.lineTo(48.5133f, 60.0f);
                h.lineTo(32.4863f, 60.0f);
                h.lineTo(35.9483f, 58.846f);
                h.lineTo(38.0003f, 58.162f);
                h.lineTo(38.0003f, 56.0f);
                h.lineTo(38.0003f, 52.0f);
                h.lineTo(43.0003f, 52.0f);
                h.lineTo(43.0003f, 56.0f);
                h.lineTo(43.0003f, 58.162f);
                h.lineTo(45.0513f, 58.846f);
                h.close();
                h.moveTo(35.0003f, 49.0f);
                h.lineTo(3.0003f, 49.0f);
                h.lineTo(3.0003f, 3.0f);
                h.lineTo(77.0003f, 3.0f);
                h.lineTo(77.0003f, 18.0f);
                h.lineTo(80.0003f, 18.0f);
                h.lineTo(80.0003f, 2.87f);
                h.cubicTo(80.0003f, 1.285f, 78.7143f, 0.0f, 77.1293f, 0.0f);
                h.lineTo(2.8713f, 0.0f);
                h.cubicTo(1.2893f, 0.0f, 3.0E-4f, 1.285f, 3.0E-4f, 2.87f);
                h.lineTo(3.0E-4f, 49.13f);
                h.cubicTo(3.0E-4f, 50.715f, 1.2853f, 52.0f, 2.8713f, 52.0f);
                h.lineTo(35.0003f, 52.0f);
                h.lineTo(35.0003f, 56.0f);
                h.lineTo(23.0003f, 60.0f);
                h.lineTo(23.0003f, 63.0f);
                h.lineTo(58.0003f, 63.0f);
                h.lineTo(58.0003f, 60.0f);
                h.lineTo(46.0003f, 56.0f);
                h.lineTo(46.0003f, 52.0f);
                h.lineTo(61.5f, 52.0f);
                h.lineTo(61.5f, 49.0f);
                h.lineTo(46.0003f, 49.0f);
                h.lineTo(35.0003f, 49.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(68.0f, 59.028194f);
                h.lineTo(68.0f, 24.971806f);
                h.cubicTo(68.0f, 24.435892f, 68.40374f, 24.0f, 68.9f, 24.0f);
                h.lineTo(85.1f, 24.0f);
                h.cubicTo(85.59626f, 24.0f, 86.0f, 24.435892f, 86.0f, 24.971806f);
                h.lineTo(86.0f, 59.028194f);
                h.cubicTo(86.0f, 59.56411f, 85.59626f, 60.0f, 85.1f, 60.0f);
                h.lineTo(68.9f, 60.0f);
                h.cubicTo(68.40374f, 60.0f, 68.0f, 59.56411f, 68.0f, 59.028194f);
                h.lineTo(68.0f, 59.028194f);
                h.close();
                h.moveTo(87.18868f, 63.0f);
                h.cubicTo(88.18898f, 63.0f, 89.0f, 62.212334f, 89.0f, 61.242157f);
                h.lineTo(89.0f, 22.757843f);
                h.cubicTo(89.0f, 21.787004f, 88.18762f, 21.0f, 87.18868f, 21.0f);
                h.lineTo(66.81132f, 21.0f);
                h.cubicTo(65.81102f, 21.0f, 65.0f, 21.787664f, 65.0f, 22.757843f);
                h.lineTo(65.0f, 61.242157f);
                h.cubicTo(65.0f, 62.212994f, 65.81238f, 63.0f, 66.81132f, 63.0f);
                h.lineTo(87.18868f, 63.0f);
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
