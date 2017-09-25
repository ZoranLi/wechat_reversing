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

public final class hv extends c {
    private final int height = 28;
    private final int width = 36;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 36;
            case 1:
                return 28;
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
                g = c.a(g2, looper);
                g.setStrokeWidth(1.0f);
                g.setStrokeCap(Cap.ROUND);
                g.setStrokeJoin(Join.MITER);
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-10258787);
                a.setStrokeWidth(2.0f);
                c = c.a(c, 1.0f, 0.0f, -573.0f, 0.0f, 1.0f, -727.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 140.0f, 0.0f, 1.0f, 722.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                float[] a2 = c.a(c, 1.0f, 0.0f, 434.0f, 0.0f, 1.0f, 6.0f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(4.5945945f, 13.324325f);
                h.cubicTo(4.5945945f, 6.4324327f, 10.2f, 0.827027f, 17.091892f, 0.827027f);
                h.cubicTo(21.962162f, 0.827027f, 26.18919f, 3.5837839f, 28.302702f, 7.718919f);
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.save();
                Paint a4 = c.a(a, looper);
                Path h2 = c.h(looper);
                h2.moveTo(10.383783f, 9.372973f);
                h2.lineTo(4.5945945f, 13.324325f);
                h2.lineTo(0.64324325f, 7.5351353f);
                WeChatSVGRenderC2Java.setFillType(h2, 1);
                canvas.drawPath(h2, a4);
                canvas.restore();
                canvas.save();
                c = c.a(a2, 1.0f, 0.0f, 5.513514f, 0.0f, 1.0f, 12.864865f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a5 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(24.075676f, 0.0f);
                h.cubicTo(24.075676f, 6.891892f, 18.47027f, 12.497297f, 11.578379f, 12.497297f);
                h.cubicTo(6.708108f, 12.497297f, 2.3891892f, 9.648648f, 0.36756757f, 5.5135136f);
                canvas.drawPath(h, a5);
                canvas.restore();
                canvas.save();
                a4 = c.a(a, looper);
                h2 = c.h(looper);
                h2.moveTo(18.194595f, 3.9513514f);
                h2.lineTo(24.075676f, 0.0f);
                h2.lineTo(28.027027f, 5.881081f);
                WeChatSVGRenderC2Java.setFillType(h2, 1);
                canvas.drawPath(h2, a4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
