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

public final class ajh extends c {
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
                g2 = c.a(g, looper);
                g2.setColor(0);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(96.0f, 0.0f);
                h.lineTo(96.0f, 96.0f);
                h.lineTo(0.0f, 96.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                canvas.drawPath(h, g2);
                canvas.restore();
                canvas.save();
                float[] a = c.a(c, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 21.0f);
                d.reset();
                d.setValues(a);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(g, looper);
                a2.setColor(-499359);
                Path h2 = c.h(looper);
                h2.moveTo(27.0f, 0.0f);
                h2.cubicTo(41.91169f, 0.0f, 54.0f, 12.088311f, 54.0f, 27.0f);
                h2.cubicTo(54.0f, 41.91169f, 41.91169f, 54.0f, 27.0f, 54.0f);
                h2.cubicTo(12.088311f, 54.0f, 0.0f, 41.91169f, 0.0f, 27.0f);
                h2.cubicTo(0.0f, 12.088311f, 12.088311f, 0.0f, 27.0f, 0.0f);
                h2.close();
                canvas.drawPath(h2, a2);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-1);
                c = c.a(a, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 13.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a3 = c.a(g, looper);
                h2 = c.h(looper);
                h2.moveTo(3.0f, 24.0f);
                h2.cubicTo(4.6568546f, 24.0f, 6.0f, 25.343145f, 6.0f, 27.0f);
                h2.cubicTo(6.0f, 28.656855f, 4.6568546f, 30.0f, 3.0f, 30.0f);
                h2.cubicTo(1.3431456f, 30.0f, 0.0f, 28.656855f, 0.0f, 27.0f);
                h2.cubicTo(0.0f, 25.343145f, 1.3431456f, 24.0f, 3.0f, 24.0f);
                h2.close();
                canvas.drawPath(h2, a3);
                canvas.restore();
                canvas.save();
                Paint a4 = c.a(g, looper);
                Path h3 = c.h(looper);
                h3.moveTo(0.49475262f, 0.0f);
                h3.lineTo(5.4947524f, 0.0f);
                h3.lineTo(4.7095985f, 20.212122f);
                h3.lineTo(1.3290199f, 20.212122f);
                h3.close();
                WeChatSVGRenderC2Java.setFillType(h3, 1);
                WeChatSVGRenderC2Java.setFillType(h3, 1);
                canvas.drawPath(h3, a4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
