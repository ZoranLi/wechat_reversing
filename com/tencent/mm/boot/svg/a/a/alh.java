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

public final class alh extends c {
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
                c = c.a(c, 1.0f, 0.0f, -249.0f, 0.0f, 1.0f, -128.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 249.0f, 0.0f, 1.0f, 128.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-9276814);
                Path h = c.h(looper);
                h.moveTo(80.0f, 38.0f);
                h.lineTo(80.0f, 46.0f);
                h.cubicTo(81.59742f, 46.5f, 83.5f, 48.403057f, 84.0f, 50.0f);
                h.lineTo(84.0f, 77.0f);
                h.cubicTo(83.5f, 78.59742f, 81.59742f, 80.5f, 80.0f, 81.0f);
                h.lineTo(53.0f, 81.0f);
                h.cubicTo(51.402584f, 80.5f, 49.5f, 78.59742f, 49.0f, 77.0f);
                h.lineTo(41.0f, 77.0f);
                h.cubicTo(41.0f, 83.29178f, 46.70822f, 89.0f, 53.0f, 89.0f);
                h.lineTo(80.0f, 89.0f);
                h.cubicTo(86.29178f, 89.0f, 92.0f, 83.29178f, 92.0f, 77.0f);
                h.lineTo(92.0f, 50.0f);
                h.cubicTo(92.0f, 43.70822f, 86.29178f, 38.0f, 80.0f, 38.0f);
                h.moveTo(16.0f, 56.0f);
                h.lineTo(16.0f, 17.0f);
                h.cubicTo(16.0f, 14.912758f, 17.912758f, 13.0f, 20.0f, 13.0f);
                h.lineTo(59.0f, 13.0f);
                h.cubicTo(61.087242f, 13.0f, 63.0f, 14.912758f, 63.0f, 17.0f);
                h.lineTo(63.0f, 56.0f);
                h.cubicTo(63.0f, 58.087242f, 61.087242f, 60.0f, 59.0f, 60.0f);
                h.lineTo(20.0f, 60.0f);
                h.cubicTo(17.912758f, 60.0f, 16.0f, 58.087242f, 16.0f, 56.0f);
                h.moveTo(71.0f, 56.0f);
                h.lineTo(71.0f, 17.0f);
                h.cubicTo(71.0f, 10.641533f, 65.35893f, 5.0f, 59.0f, 5.0f);
                h.lineTo(20.0f, 5.0f);
                h.cubicTo(13.641067f, 5.0f, 8.0f, 10.641533f, 8.0f, 17.0f);
                h.lineTo(8.0f, 56.0f);
                h.cubicTo(8.0f, 62.358932f, 13.641067f, 68.0f, 20.0f, 68.0f);
                h.lineTo(59.0f, 68.0f);
                h.cubicTo(65.35893f, 68.0f, 71.0f, 62.358932f, 71.0f, 56.0f);
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
