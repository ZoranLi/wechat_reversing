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

public final class br extends c {
    private final int height = 61;
    private final int width = 68;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 68;
            case 1:
                return 61;
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
                c = c.a(c, 1.0f, 0.0f, -296.0f, 0.0f, 1.0f, -485.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 295.0f, 0.0f, 1.0f, 485.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(53.0f, 31.0f);
                h.lineTo(59.0f, 31.0f);
                h.lineTo(38.0f, 9.956522f);
                h.lineTo(36.0f, 8.043478f);
                h.lineTo(12.0f, 31.0f);
                h.lineTo(17.0f, 31.0f);
                h.lineTo(17.0f, 55.04348f);
                h.lineTo(53.0f, 55.04348f);
                h.lineTo(53.0f, 31.0f);
                h.close();
                h.moveTo(59.0f, 37.0f);
                h.lineTo(59.0f, 59.001785f);
                h.cubicTo(59.0f, 60.10537f, 58.10506f, 61.0f, 56.99861f, 61.0f);
                h.lineTo(13.0013895f, 61.0f);
                h.cubicTo(11.896052f, 61.0f, 11.0f, 60.105663f, 11.0f, 59.001785f);
                h.lineTo(11.0f, 37.0f);
                h.lineTo(3.993048f, 37.0f);
                h.cubicTo(0.68317896f, 37.0f, -0.102572955f, 35.102573f, 2.2484722f, 32.75153f);
                h.lineTo(33.17487f, 1.825131f);
                h.cubicTo(34.735146f, 0.26485425f, 37.228786f, 0.29705298f, 38.750225f, 1.9030144f);
                h.lineTo(67.870346f, 32.640915f);
                h.cubicTo(70.15109f, 35.04837f, 69.322586f, 37.0f, 66.00695f, 37.0f);
                h.lineTo(59.0f, 37.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path h2 = c.h(looper);
                h2.moveTo(40.0f, 42.0f);
                h2.lineTo(40.0f, 58.0f);
                h2.lineTo(30.0f, 58.0f);
                h2.lineTo(30.0f, 42.0f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 1);
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
