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

public final class abh extends c {
    private final int height = 44;
    private final int width = 54;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 54;
            case 1:
                return 44;
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
                a.setColor(-1);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 0.5f, 0.0f, 1.0f, 0.5f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(0.5f, 0.5f);
                h.lineTo(46.5f, 0.5f);
                h.lineTo(46.5f, 36.5f);
                h.lineTo(0.5f, 36.5f);
                h.lineTo(0.5f, 0.5f);
                h.close();
                h.moveTo(42.5f, 2.5f);
                h.lineTo(42.5f, 32.5f);
                h.lineTo(3.5f, 32.5f);
                h.lineTo(3.5f, 2.5f);
                h.lineTo(42.5f, 2.5f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(51.0f, 42.5f);
                h.lineTo(52.5f, 42.5f);
                h.lineTo(52.5f, 7.5f);
                h.lineTo(49.5f, 7.5f);
                h.lineTo(49.5f, 39.5f);
                h.lineTo(5.5f, 39.5f);
                h.lineTo(5.5f, 42.5f);
                h.lineTo(51.0f, 42.5f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(36.170597f, 14.009804f);
                h.lineTo(28.390347f, 19.793558f);
                h.lineTo(15.891026f, 9.5f);
                h.lineTo(0.5576923f, 22.578432f);
                h.lineTo(0.5576923f, 32.5f);
                h.lineTo(46.557693f, 32.5f);
                h.lineTo(46.557693f, 22.578432f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 1);
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
