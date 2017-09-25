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

public final class hp extends c {
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
                g2 = c.a(g, looper);
                g2.setColor(-4284563);
                canvas.save();
                Paint a = c.a(g2, looper);
                Path h = c.h(looper);
                h.moveTo(66.36202f, 28.0f);
                h.lineTo(76.99543f, 28.0f);
                h.cubicTo(79.20043f, 28.0f, 81.0f, 29.79529f, 81.0f, 32.00989f);
                h.lineTo(81.0f, 71.990105f);
                h.cubicTo(81.0f, 74.20595f, 79.20709f, 76.0f, 76.99543f, 76.0f);
                h.lineTo(19.00457f, 76.0f);
                h.cubicTo(16.79957f, 76.0f, 15.0f, 74.20471f, 15.0f, 71.990105f);
                h.lineTo(15.0f, 32.00989f);
                h.cubicTo(15.0f, 29.794052f, 16.792908f, 28.0f, 19.00457f, 28.0f);
                h.lineTo(29.637974f, 28.0f);
                h.lineTo(36.0f, 22.0f);
                h.lineTo(60.0f, 22.0f);
                h.lineTo(66.36202f, 28.0f);
                h.close();
                h.moveTo(48.0f, 70.0f);
                h.cubicTo(59.045696f, 70.0f, 68.0f, 61.045696f, 68.0f, 50.0f);
                h.cubicTo(68.0f, 38.954304f, 59.045696f, 30.0f, 48.0f, 30.0f);
                h.cubicTo(36.954304f, 30.0f, 28.0f, 38.954304f, 28.0f, 50.0f);
                h.cubicTo(28.0f, 61.045696f, 36.954304f, 70.0f, 48.0f, 70.0f);
                h.close();
                h.moveTo(48.0f, 63.0f);
                h.cubicTo(55.179703f, 63.0f, 61.0f, 57.179703f, 61.0f, 50.0f);
                h.cubicTo(61.0f, 42.820297f, 55.179703f, 37.0f, 48.0f, 37.0f);
                h.cubicTo(40.820297f, 37.0f, 35.0f, 42.820297f, 35.0f, 50.0f);
                h.cubicTo(35.0f, 57.179703f, 40.820297f, 63.0f, 48.0f, 63.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(66.36202f, 28.0f);
                h.lineTo(76.99543f, 28.0f);
                h.cubicTo(79.20043f, 28.0f, 81.0f, 29.79529f, 81.0f, 32.00989f);
                h.lineTo(81.0f, 71.990105f);
                h.cubicTo(81.0f, 74.20595f, 79.20709f, 76.0f, 76.99543f, 76.0f);
                h.lineTo(19.00457f, 76.0f);
                h.cubicTo(16.79957f, 76.0f, 15.0f, 74.20471f, 15.0f, 71.990105f);
                h.lineTo(15.0f, 32.00989f);
                h.cubicTo(15.0f, 29.794052f, 16.792908f, 28.0f, 19.00457f, 28.0f);
                h.lineTo(29.637974f, 28.0f);
                h.lineTo(36.0f, 22.0f);
                h.lineTo(60.0f, 22.0f);
                h.lineTo(66.36202f, 28.0f);
                h.close();
                h.moveTo(48.0f, 70.0f);
                h.cubicTo(59.045696f, 70.0f, 68.0f, 61.045696f, 68.0f, 50.0f);
                h.cubicTo(68.0f, 38.954304f, 59.045696f, 30.0f, 48.0f, 30.0f);
                h.cubicTo(36.954304f, 30.0f, 28.0f, 38.954304f, 28.0f, 50.0f);
                h.cubicTo(28.0f, 61.045696f, 36.954304f, 70.0f, 48.0f, 70.0f);
                h.close();
                h.moveTo(48.0f, 63.0f);
                h.cubicTo(55.179703f, 63.0f, 61.0f, 57.179703f, 61.0f, 50.0f);
                h.cubicTo(61.0f, 42.820297f, 55.179703f, 37.0f, 48.0f, 37.0f);
                h.cubicTo(40.820297f, 37.0f, 35.0f, 42.820297f, 35.0f, 50.0f);
                h.cubicTo(35.0f, 57.179703f, 40.820297f, 63.0f, 48.0f, 63.0f);
                h.close();
                Paint g3 = c.g(looper);
                g3.setFlags(385);
                g3.setStyle(Style.FILL);
                Paint g4 = c.g(looper);
                g4.setFlags(385);
                g4.setStyle(Style.STROKE);
                g3.setColor(WebView.NIGHT_MODE_COLOR);
                g4.setStrokeWidth(1.0f);
                g4.setStrokeCap(Cap.BUTT);
                g4.setStrokeJoin(Join.MITER);
                g4.setStrokeMiter(4.0f);
                g4.setPathEffect(null);
                float[] a2 = c.a(c, 81.0f, 0.0f, 15.0f, 0.0f, 76.0f, 22.0f);
                d.reset();
                d.setValues(a2);
                WeChatSVGRenderC2Java.setLinearGradient(a, 0.7940693f, 0.8090447f, 0.08431214f, 0.07970222f, new int[]{-4679064, -2112619}, new float[]{0.0f, 1.0f}, d, 0);
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}