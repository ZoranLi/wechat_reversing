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

public final class si extends c {
    private final int height = 108;
    private final int width = 108;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 108;
            case 1:
                return 108;
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
                g2.setColor(-14187817);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(108.0f, 0.0f);
                h.lineTo(108.0f, 108.0f);
                h.lineTo(0.0f, 108.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                canvas.drawPath(h, g2);
                canvas.restore();
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-1);
                c = c.a(c, 1.0f, 0.0f, 22.0f, 0.0f, 1.0f, 32.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h2 = c.h(looper);
                h2.moveTo(60.154037f, 3.58796f);
                h2.lineTo(60.154037f, 40.412003f);
                h2.lineTo(3.845964f, 40.40884f);
                h2.lineTo(3.845964f, 3.58796f);
                h2.lineTo(60.154037f, 3.58796f);
                h2.close();
                h2.moveTo(0.0f, 2.3516667f);
                h2.lineTo(0.0f, 41.64496f);
                h2.cubicTo(0.0f, 42.94329f, 1.0471251f, 43.996597f, 2.3367088f, 43.99667f);
                h2.lineTo(61.66312f, 44.0f);
                h2.cubicTo(62.953594f, 44.000072f, 64.0f, 42.948074f, 64.0f, 41.64831f);
                h2.lineTo(64.0f, 2.3517354f);
                h2.cubicTo(64.0f, 1.0533575f, 62.95285f, 0.0f, 61.663208f, 0.0f);
                h2.lineTo(2.3367934f, 0.0f);
                h2.cubicTo(1.046383f, 0.0f, 0.0f, 1.0519472f, 0.0f, 2.3516667f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 1);
                canvas.drawPath(h2, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path h3 = c.h(looper);
                h3.moveTo(2.9155135f, 0.0f);
                h3.lineTo(-3.5527137E-15f, 2.9199913f);
                h3.lineTo(32.030815f, 35.0f);
                h3.lineTo(62.492252f, 4.491779f);
                h3.lineTo(63.02122f, 2.0014334f);
                h3.lineTo(61.084488f, 0.061725732f);
                h3.lineTo(32.030815f, 29.160017f);
                h3.close();
                WeChatSVGRenderC2Java.setFillType(h3, 1);
                WeChatSVGRenderC2Java.setFillType(h3, 1);
                canvas.drawPath(h3, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                h3 = c.h(looper);
                h3.moveTo(2.874115f, 43.0f);
                h3.lineTo(23.0f, 22.874115f);
                h3.lineTo(20.125885f, 20.0f);
                h3.lineTo(0.0f, 40.125885f);
                h3.close();
                WeChatSVGRenderC2Java.setFillType(h3, 1);
                WeChatSVGRenderC2Java.setFillType(h3, 1);
                canvas.drawPath(h3, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                h3 = c.h(looper);
                h3.moveTo(63.0f, 41.125885f);
                h3.lineTo(42.874115f, 21.0f);
                h3.lineTo(40.0f, 23.874115f);
                h3.lineTo(60.125885f, 44.0f);
                h3.close();
                WeChatSVGRenderC2Java.setFillType(h3, 1);
                WeChatSVGRenderC2Java.setFillType(h3, 1);
                canvas.drawPath(h3, a3);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
