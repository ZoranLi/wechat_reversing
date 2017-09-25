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

public final class aai extends c {
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
                Paint a = c.a(g, looper);
                a.setColor(-1);
                c = c.a(c, 1.0f, 0.0f, 17.0f, 0.0f, 1.0f, 17.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(25.0f, 9.0f);
                h.cubicTo(25.83167f, 6.2045083f, 25.801733f, 2.6180365f, 28.0f, 0.0f);
                h.cubicTo(30.392475f, 0.007881897f, 33.845512f, -0.7193749f, 35.0f, 2.0f);
                h.cubicTo(36.081005f, 4.1522493f, 36.47022f, 6.6827044f, 37.0f, 9.0f);
                h.cubicTo(38.82547f, 9.771055f, 40.52205f, 10.468425f, 42.0f, 11.0f);
                h.cubicTo(44.933155f, 9.800942f, 47.46804f, 7.2406f, 51.0f, 7.0f);
                h.cubicTo(52.328243f, 8.366354f, 53.795284f, 9.771055f, 55.0f, 11.0f);
                h.cubicTo(54.703453f, 14.632717f, 52.238422f, 17.123323f, 51.0f, 20.0f);
                h.cubicTo(51.55979f, 21.506788f, 52.25838f, 23.190437f, 53.0f, 25.0f);
                h.cubicTo(55.86112f, 25.840443f, 59.453873f, 25.830479f, 62.0f, 28.0f);
                h.cubicTo(62.09854f, 30.02466f, 62.10852f, 31.957369f, 62.0f, 34.0f);
                h.cubicTo(59.483814f, 36.181435f, 55.86112f, 36.15155f, 53.0f, 37.0f);
                h.cubicTo(52.268364f, 38.811516f, 51.56977f, 40.505127f, 51.0f, 42.0f);
                h.cubicTo(52.058784f, 44.251f, 53.445988f, 46.24348f, 54.0f, 48.0f);
                h.cubicTo(55.68148f, 51.21473f, 52.57774f, 53.416428f, 51.0f, 55.0f);
                h.cubicTo(47.368244f, 54.63184f, 44.883255f, 52.191048f, 42.0f, 51.0f);
                h.cubicTo(40.51207f, 51.533527f, 38.82547f, 52.230896f, 37.0f, 53.0f);
                h.cubicTo(36.160843f, 55.807407f, 36.220722f, 59.44369f, 34.0f, 62.0f);
                h.cubicTo(31.5701f, 61.994072f, 28.107084f, 62.711365f, 27.0f, 60.0f);
                h.cubicTo(25.92149f, 57.82978f, 25.532276f, 55.309284f, 25.0f, 53.0f);
                h.cubicTo(23.177025f, 52.230896f, 21.480446f, 51.533527f, 20.0f, 51.0f);
                h.cubicTo(17.10926f, 52.20101f, 14.624271f, 54.651768f, 11.0f, 55.0f);
                h.cubicTo(9.754092f, 53.804962f, 8.336949f, 52.310596f, 7.0f, 51.0f);
                h.cubicTo(7.1393647f, 47.46886f, 9.784032f, 44.908516f, 11.0f, 42.0f);
                h.cubicTo(10.432724f, 40.495163f, 9.734132f, 38.811516f, 9.0f, 37.0f);
                h.cubicTo(6.141377f, 36.16151f, 2.5486217f, 36.171474f, -3.5527137E-15f, 34.0f);
                h.cubicTo(-0.106025174f, 31.977293f, -0.106025174f, 30.034622f, -3.5527137E-15f, 28.0f);
                h.cubicTo(2.528662f, 25.820517f, 6.141377f, 25.850405f, 9.0f, 25.0f);
                h.cubicTo(9.734132f, 23.190437f, 10.432724f, 21.506788f, 11.0f, 20.0f);
                h.cubicTo(9.784032f, 17.15321f, 7.338962f, 14.682529f, 7.0f, 12.0f);
                h.cubicTo(8.127373f, 9.79098f, 9.684233f, 8.326504f, 11.0f, 7.0f);
                h.cubicTo(14.574372f, 7.2406f, 17.07932f, 9.820868f, 20.0f, 11.0f);
                h.cubicTo(21.480446f, 10.478388f, 23.177025f, 9.771055f, 25.0f, 9.0f);
                h.lineTo(25.0f, 9.0f);
                h.close();
                h.moveTo(28.0f, 19.0f);
                h.cubicTo(22.47933f, 20.029234f, 18.395445f, 25.014368f, 18.0f, 31.0f);
                h.cubicTo(17.271624f, 38.053955f, 23.924242f, 45.2157f, 31.0f, 45.0f);
                h.cubicTo(39.075756f, 45.2157f, 45.72838f, 38.053955f, 45.0f, 31.0f);
                h.cubicTo(44.604557f, 22.296116f, 35.634056f, 16.027084f, 28.0f, 19.0f);
                h.lineTo(28.0f, 19.0f);
                h.close();
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
