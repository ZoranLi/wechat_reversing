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

public final class gm extends c {
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
                c = c.a(c, 1.0f, 0.0f, 7.0f, 0.0f, 1.0f, 10.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-13032);
                Path h = c.h(looper);
                h.moveTo(80.04755f, 28.325209f);
                h.lineTo(56.156776f, 25.964645f);
                h.cubicTo(54.329502f, 25.794123f, 53.919743f, 25.509708f, 53.34809f, 24.029768f);
                h.lineTo(43.131153f, 1.436689f);
                h.cubicTo(42.196808f, -0.47889635f, 40.668846f, -0.47889635f, 39.735756f, 1.436689f);
                h.lineTo(28.844881f, 24.029768f);
                h.cubicTo(28.10255f, 25.28193f, 27.759935f, 25.565722f, 25.960896f, 25.736866f);
                h.lineTo(2.8181033f, 28.325209f);
                h.cubicTo(0.69213665f, 28.536808f, 0.21711986f, 29.913439f, 1.76265f, 31.384047f);
                h.lineTo(19.921844f, 48.020016f);
                h.cubicTo(20.777754f, 48.817863f, 20.79156f, 49.157665f, 20.549345f, 50.254242f);
                h.lineTo(15.893301f, 74.66893f);
                h.cubicTo(15.499859f, 76.76437f, 16.692736f, 77.6033f, 18.542603f, 76.53722f);
                h.lineTo(39.269524f, 64.60993f);
                h.cubicTo(40.725323f, 63.699436f, 42.067543f, 63.672676f, 43.495102f, 64.55392f);
                h.lineTo(64.322426f, 76.53722f);
                h.cubicTo(66.173546f, 77.6033f, 67.37081f, 76.76189f, 66.98364f, 74.66831f);
                h.lineTo(63.421963f, 55.188213f);
                h.cubicTo(65.55483f, 54.46878f, 67.621185f, 53.588158f, 68.85673f, 52.591778f);
                h.lineTo(68.35536f, 52.689487f);
                h.cubicTo(66.16225f, 53.104595f, 64.444786f, 53.42386f, 63.106956f, 53.669064f);
                h.cubicTo(63.014088f, 52.996304f, 63.002163f, 52.988216f, 63.002163f, 52.988216f);
                h.lineTo(62.52464f, 50.28785f);
                h.cubicTo(62.335133f, 49.07365f, 62.52464f, 48.654808f, 63.44016f, 47.781654f);
                h.lineTo(81.07351f, 31.351685f);
                h.cubicTo(82.63599f, 29.90037f, 82.174774f, 28.536808f, 80.04755f, 28.325209f);
                h.lineTo(80.04755f, 28.325209f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                a.setColor(-1);
                h = c.h(looper);
                h.moveTo(15.39444f, 33.37369f);
                h.cubicTo(15.39444f, 33.37369f, 37.508133f, 28.2163f, 62.77564f, 32.517963f);
                h.cubicTo(62.856586f, 32.531654f, 62.796974f, 32.706535f, 62.877293f, 32.72147f);
                h.cubicTo(62.877293f, 32.72147f, 55.036694f, 38.18817f, 47.961014f, 43.054306f);
                h.cubicTo(42.398235f, 46.880497f, 37.30796f, 50.276646f, 36.87248f, 50.75025f);
                h.cubicTo(36.87248f, 50.75025f, 36.560608f, 50.806263f, 36.962208f, 51.00666f);
                h.cubicTo(37.262154f, 51.156025f, 37.981266f, 51.21577f, 37.981266f, 51.21577f);
                h.cubicTo(37.981266f, 51.21577f, 56.060143f, 53.18239f, 68.62267f, 52.667084f);
                h.cubicTo(68.62267f, 52.667084f, 50.095764f, 58.072792f, 22.619463f, 54.425217f);
                h.cubicTo(22.619463f, 54.425217f, 22.295673f, 54.306347f, 22.56236f, 54.132713f);
                h.cubicTo(24.73037f, 52.718117f, 43.409134f, 39.430378f, 48.48435f, 35.899178f);
                h.cubicTo(48.48435f, 35.899178f, 48.836372f, 35.622856f, 48.522625f, 35.565598f);
                h.cubicTo(48.772995f, 35.611652f, 45.382618f, 34.984947f, 40.362f, 34.538727f);
                h.cubicTo(33.066067f, 33.89086f, 22.360306f, 33.546703f, 15.55759f, 33.412277f);
                h.cubicTo(15.4885645f, 33.409786f, 15.460955f, 33.37307f, 15.39444f, 33.37369f);
                h.lineTo(15.39444f, 33.37369f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
