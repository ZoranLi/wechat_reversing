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

public final class dg extends c {
    private final int height = 75;
    private final int width = 72;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 75;
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
                c = c.a(c, 1.0f, 0.0f, -482.0f, 0.0f, 1.0f, -537.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 482.0f, 0.0f, 1.0f, 537.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(29.0f, 26.032377f);
                h.lineTo(4.2026215f, 1.2349988f);
                h.cubicTo(3.2408514f, 0.2732287f, 1.6913689f, 0.2762538f, 0.7338114f, 1.2338114f);
                h.cubicTo(-0.23042212f, 2.1980448f, -0.22321457f, 3.7444081f, 0.7349988f, 4.7026215f);
                h.lineTo(25.532377f, 29.5f);
                h.lineTo(5.754876f, 29.5f);
                h.cubicTo(4.4981537f, 29.5f, 3.5f, 30.507359f, 3.5f, 31.75f);
                h.cubicTo(3.5f, 33.001305f, 4.5095425f, 34.0f, 5.754876f, 34.0f);
                h.lineTo(31.245125f, 34.0f);
                h.cubicTo(31.245937f, 34.0f, 31.24675f, 34.0f, 31.247562f, 34.0f);
                h.cubicTo(31.248375f, 34.0f, 31.249187f, 34.0f, 31.25f, 34.0f);
                h.cubicTo(31.874836f, 34.0f, 32.436684f, 33.748272f, 32.842648f, 33.34116f);
                h.cubicTo(33.251106f, 32.932365f, 33.5f, 32.370518f, 33.5f, 31.75f);
                h.cubicTo(33.5f, 31.749187f, 33.5f, 31.748375f, 33.5f, 31.747562f);
                h.cubicTo(33.5f, 31.74675f, 33.5f, 31.745937f, 33.5f, 31.745125f);
                h.lineTo(33.5f, 6.254876f);
                h.cubicTo(33.5f, 4.9981537f, 32.49264f, 4.0f, 31.25f, 4.0f);
                h.cubicTo(29.998695f, 4.0f, 29.0f, 5.0095425f, 29.0f, 6.254876f);
                h.lineTo(29.0f, 26.032377f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(44.0f, 49.468422f);
                h.lineTo(67.828835f, 73.29726f);
                h.cubicTo(68.79079f, 74.25921f, 70.34059f, 74.25615f, 71.29837f, 73.29837f);
                h.cubicTo(72.262825f, 72.333916f, 72.25565f, 70.787224f, 71.29726f, 69.828835f);
                h.lineTo(47.468422f, 46.0f);
                h.lineTo(67.245125f, 46.0f);
                h.cubicTo(68.50185f, 46.0f, 69.5f, 44.99264f, 69.5f, 43.75f);
                h.cubicTo(69.5f, 42.498695f, 68.490456f, 41.5f, 67.245125f, 41.5f);
                h.lineTo(41.754875f, 41.5f);
                h.cubicTo(41.754063f, 41.5f, 41.75325f, 41.5f, 41.752438f, 41.5f);
                h.cubicTo(41.751625f, 41.5f, 41.750813f, 41.5f, 41.75f, 41.5f);
                h.cubicTo(41.129482f, 41.5f, 40.567635f, 41.748894f, 40.16059f, 42.15459f);
                h.cubicTo(39.748894f, 42.567635f, 39.5f, 43.129482f, 39.5f, 43.75f);
                h.cubicTo(39.5f, 43.750813f, 39.5f, 43.751625f, 39.5f, 43.752438f);
                h.cubicTo(39.5f, 43.75325f, 39.5f, 43.754063f, 39.5f, 43.754875f);
                h.lineTo(39.5f, 69.245125f);
                h.cubicTo(39.5f, 70.490456f, 40.498695f, 71.5f, 41.75f, 71.5f);
                h.cubicTo(42.99264f, 71.5f, 44.0f, 70.50185f, 44.0f, 69.245125f);
                h.lineTo(44.0f, 49.468422f);
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
