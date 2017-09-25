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

public final class ou extends c {
    private final int height = 90;
    private final int width = 90;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                Paint a = c.a(g2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 20.0f, 0.0f, 1.0f, 10.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(g, looper);
                a2.setColor(-9473160);
                Path h = c.h(looper);
                h.moveTo(24.0f, 60.0f);
                h.lineTo(27.0f, 60.0f);
                h.lineTo(27.0f, 67.0f);
                h.lineTo(24.0f, 67.0f);
                h.lineTo(24.0f, 60.0f);
                h.close();
                h.moveTo(9.437293f, 67.0f);
                h.cubicTo(8.643497f, 67.0f, 8.0f, 67.63622f, 8.0f, 68.44727f);
                h.lineTo(8.0f, 68.55273f);
                h.cubicTo(8.0f, 69.352036f, 8.637368f, 70.0f, 9.437293f, 70.0f);
                h.lineTo(41.562706f, 70.0f);
                h.cubicTo(42.356503f, 70.0f, 43.0f, 69.36378f, 43.0f, 68.55273f);
                h.lineTo(43.0f, 68.44727f);
                h.cubicTo(43.0f, 67.647964f, 42.362633f, 67.0f, 41.562706f, 67.0f);
                h.lineTo(9.437293f, 67.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                a2.setColor(-9473160);
                a2.setStrokeWidth(3.0f);
                a2.setStrokeCap(Cap.ROUND);
                a2.setStrokeJoin(Join.MITER);
                h = c.h(looper);
                h.moveTo(0.0f, 25.0f);
                h.lineTo(0.0f, 34.03155f);
                h.cubicTo(0.0f, 48.373528f, 11.4167385f, 60.0f, 25.5f, 60.0f);
                h.lineTo(25.5f, 60.0f);
                h.cubicTo(39.58326f, 60.0f, 51.0f, 48.373528f, 51.0f, 34.03155f);
                h.lineTo(51.0f, 25.0f);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                a2.setColor(-9473160);
                a2.setStrokeWidth(3.0f);
                h = c.h(looper);
                h.moveTo(11.0f, 21.6f);
                h.cubicTo(11.0f, 9.670649f, 17.49187f, 0.0f, 25.5f, 0.0f);
                h.lineTo(25.5f, 0.0f);
                h.cubicTo(33.50813f, 0.0f, 40.0f, 9.670649f, 40.0f, 21.6f);
                h.lineTo(40.0f, 28.4f);
                h.cubicTo(40.0f, 40.329353f, 33.50813f, 50.0f, 25.5f, 50.0f);
                h.lineTo(25.5f, 50.0f);
                h.cubicTo(17.49187f, 50.0f, 11.0f, 40.329353f, 11.0f, 28.4f);
                h.lineTo(11.0f, 21.6f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
