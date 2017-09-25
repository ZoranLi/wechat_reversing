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

public final class aeb extends c {
    private final int height = 71;
    private final int width = 71;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 71;
            case 1:
                return 71;
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
                Path h = c.h(looper);
                h.moveTo(85.5f, 0.0f);
                h.cubicTo(132.72035f, 0.0f, 171.0f, 38.27965f, 171.0f, 85.5f);
                h.cubicTo(171.0f, 132.72035f, 132.72035f, 171.0f, 85.5f, 171.0f);
                h.cubicTo(38.27965f, 171.0f, 0.0f, 132.72035f, 0.0f, 85.5f);
                h.cubicTo(0.0f, 38.27965f, 38.27965f, 0.0f, 85.5f, 0.0f);
                h.close();
                g = c.a(g, looper);
                g.setColor(-11119016);
                canvas.save();
                Paint a = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(0.0f, 6.99323f);
                h.cubicTo(0.0f, 5.8923993f, 0.89770234f, 5.0f, 1.9917458f, 5.0f);
                h.lineTo(69.008255f, 5.0f);
                h.cubicTo(70.10827f, 5.0f, 71.0f, 5.8954434f, 71.0f, 6.99323f);
                h.lineTo(71.0f, 69.00677f);
                h.cubicTo(71.0f, 70.1076f, 70.102295f, 71.0f, 69.008255f, 71.0f);
                h.lineTo(1.9917458f, 71.0f);
                h.cubicTo(0.89173496f, 71.0f, 0.0f, 70.10455f, 0.0f, 69.00677f);
                h.lineTo(0.0f, 6.99323f);
                h.close();
                h.moveTo(3.0f, 8.0f);
                h.lineTo(68.0f, 8.0f);
                h.lineTo(68.0f, 68.0f);
                h.lineTo(3.0f, 68.0f);
                h.lineTo(3.0f, 8.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                g2 = c.a(g, looper);
                Path h2 = c.h(looper);
                h2.moveTo(0.0f, 26.0f);
                h2.lineTo(71.0f, 26.0f);
                h2.lineTo(71.0f, 29.0f);
                h2.lineTo(0.0f, 29.0f);
                h2.lineTo(0.0f, 26.0f);
                h2.close();
                canvas.drawPath(h2, g2);
                canvas.restore();
                canvas.save();
                g2 = c.a(g, looper);
                h2 = c.h(looper);
                h2.moveTo(12.0f, 39.0f);
                h2.lineTo(23.0f, 39.0f);
                h2.lineTo(23.0f, 42.0f);
                h2.lineTo(12.0f, 42.0f);
                h2.lineTo(12.0f, 39.0f);
                h2.close();
                canvas.drawPath(h2, g2);
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                float[] a2 = c.a(c, -1.8369701E-16f, -1.0f, 22.60606f, 1.0f, -1.8369701E-16f, -8.621212f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                h2 = c.h(looper);
                h2.moveTo(8.621212f, 5.6060605f);
                h2.lineTo(22.621212f, 5.6060605f);
                h2.lineTo(22.621212f, 8.60606f);
                h2.lineTo(8.621212f, 8.60606f);
                h2.lineTo(8.621212f, 5.6060605f);
                h2.close();
                canvas.drawPath(h2, a);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(g, looper);
                a2 = c.a(a2, -1.8369701E-16f, -1.0f, 62.60606f, 1.0f, -1.8369701E-16f, -48.621212f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                h = c.h(looper);
                h.moveTo(48.621212f, 5.6060605f);
                h.lineTo(62.621212f, 5.6060605f);
                h.lineTo(62.621212f, 8.60606f);
                h.lineTo(48.621212f, 8.60606f);
                h.lineTo(48.621212f, 5.6060605f);
                h.close();
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.save();
                g2 = c.a(g, looper);
                h2 = c.h(looper);
                h2.moveTo(12.0f, 53.0f);
                h2.lineTo(23.0f, 53.0f);
                h2.lineTo(23.0f, 56.0f);
                h2.lineTo(12.0f, 56.0f);
                h2.lineTo(12.0f, 53.0f);
                h2.close();
                canvas.drawPath(h2, g2);
                canvas.restore();
                canvas.save();
                g2 = c.a(g, looper);
                h2 = c.h(looper);
                h2.moveTo(30.0f, 39.0f);
                h2.lineTo(41.0f, 39.0f);
                h2.lineTo(41.0f, 42.0f);
                h2.lineTo(30.0f, 42.0f);
                h2.lineTo(30.0f, 39.0f);
                h2.close();
                canvas.drawPath(h2, g2);
                canvas.restore();
                canvas.save();
                g2 = c.a(g, looper);
                h2 = c.h(looper);
                h2.moveTo(30.0f, 53.0f);
                h2.lineTo(41.0f, 53.0f);
                h2.lineTo(41.0f, 56.0f);
                h2.lineTo(30.0f, 56.0f);
                h2.lineTo(30.0f, 53.0f);
                h2.close();
                canvas.drawPath(h2, g2);
                canvas.restore();
                canvas.save();
                g2 = c.a(g, looper);
                h2 = c.h(looper);
                h2.moveTo(48.0f, 39.0f);
                h2.lineTo(59.0f, 39.0f);
                h2.lineTo(59.0f, 42.0f);
                h2.lineTo(48.0f, 42.0f);
                h2.lineTo(48.0f, 39.0f);
                h2.close();
                canvas.drawPath(h2, g2);
                canvas.restore();
                canvas.save();
                g2 = c.a(g, looper);
                h2 = c.h(looper);
                h2.moveTo(48.0f, 53.0f);
                h2.lineTo(59.0f, 53.0f);
                h2.lineTo(59.0f, 56.0f);
                h2.lineTo(48.0f, 56.0f);
                h2.lineTo(48.0f, 53.0f);
                h2.close();
                canvas.drawPath(h2, g2);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
