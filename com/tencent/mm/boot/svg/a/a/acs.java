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

public final class acs extends c {
    private final int height = 60;
    private final int width = 60;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                a.setColor(WebView.NIGHT_MODE_COLOR);
                c = c.a(c, 1.0f, 0.0f, -305.0f, 0.0f, 1.0f, -141.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 305.0f, 0.0f, 1.0f, 141.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(60.0f, 0.0f);
                h.lineTo(60.0f, 60.0f);
                h.lineTo(0.0f, 60.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-5592406);
                h = c.h(looper);
                h.moveTo(6.0f, 30.0f);
                h.cubicTo(6.0f, 43.2f, 16.8f, 54.0f, 30.0f, 54.0f);
                h.cubicTo(43.2f, 54.0f, 54.0f, 43.2f, 54.0f, 30.0f);
                h.cubicTo(54.0f, 16.8f, 43.2f, 6.0f, 30.0f, 6.0f);
                h.cubicTo(16.8f, 6.0f, 6.0f, 16.8f, 6.0f, 30.0f);
                h.close();
                h.moveTo(10.0f, 30.0f);
                h.cubicTo(10.0f, 19.0f, 19.0f, 10.0f, 30.0f, 10.0f);
                h.cubicTo(41.0f, 10.0f, 50.0f, 19.0f, 50.0f, 30.0f);
                h.cubicTo(50.0f, 41.0f, 41.0f, 50.0f, 30.0f, 50.0f);
                h.cubicTo(19.0f, 50.0f, 10.0f, 41.0f, 10.0f, 30.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
