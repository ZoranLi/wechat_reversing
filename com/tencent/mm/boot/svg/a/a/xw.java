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

public final class xw extends c {
    private final int height = 279;
    private final int width = 279;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 279;
            case 1:
                return 279;
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
                c = c.a(c, 1.0f, 0.0f, -17.0f, 0.0f, 1.0f, -250.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                float[] a = c.a(c, 1.0f, 0.0f, 17.0f, 0.0f, 1.0f, 250.0f);
                d.reset();
                d.setValues(a);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(g, looper);
                a2.setColor(-15683841);
                Path h = c.h(looper);
                h.moveTo(279.0f, 141.22223f);
                h.cubicTo(279.0f, 62.454666f, 216.54533f, 0.0f, 137.77777f, 0.0f);
                h.cubicTo(62.454666f, 0.0f, 0.0f, 62.454666f, 0.0f, 141.22223f);
                h.cubicTo(0.0f, 216.54533f, 62.454666f, 279.0f, 137.77777f, 279.0f);
                h.cubicTo(216.54533f, 279.0f, 279.0f, 216.54533f, 279.0f, 141.22223f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-1);
                c = c.a(a, 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 279.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                h = c.h(looper);
                h.moveTo(134.99942f, 70.5f);
                h.lineTo(144.00058f, 70.5f);
                h.cubicTo(145.65565f, 70.5f, 147.03334f, 71.843925f, 147.07448f, 73.50175f);
                h.lineTo(149.42552f, 168.25435f);
                h.cubicTo(149.46655f, 169.90797f, 148.15945f, 171.2561f, 146.5058f, 171.2561f);
                h.lineTo(132.4942f, 171.2561f);
                h.cubicTo(130.8433f, 171.2561f, 129.53334f, 169.91217f, 129.57448f, 168.25435f);
                h.lineTo(131.92552f, 73.50175f);
                h.cubicTo(131.96655f, 71.84813f, 133.34288f, 70.5f, 134.99942f, 70.5f);
                h.close();
                h.moveTo(139.5f, 208.5f);
                h.cubicTo(132.87259f, 208.5f, 127.5f, 203.12741f, 127.5f, 196.5f);
                h.cubicTo(127.5f, 189.87259f, 132.87259f, 184.5f, 139.5f, 184.5f);
                h.cubicTo(146.12741f, 184.5f, 151.5f, 189.87259f, 151.5f, 196.5f);
                h.cubicTo(151.5f, 203.12741f, 146.12741f, 208.5f, 139.5f, 208.5f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
