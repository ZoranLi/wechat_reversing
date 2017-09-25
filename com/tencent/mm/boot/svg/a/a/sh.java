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

public final class sh extends c {
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
                g2.setColor(-12889439);
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
                c = c.a(c, 1.0f, 0.0f, 37.0f, 0.0f, 1.0f, 20.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h2 = c.h(looper);
                h2.moveTo(33.02322f, 0.0123782605f);
                h2.lineTo(22.661959f, 0.0123782605f);
                h2.cubicTo(9.465719f, -0.11790832f, 7.7802663f, 7.9406996f, 7.7802663f, 16.662235f);
                h2.lineTo(7.7802663f, 23.004126f);
                h2.lineTo(1.9549693f, 23.004126f);
                h2.cubicTo(0.8093274f, 22.87384f, -0.12272003f, 23.789677f, 0.01320356f, 24.920105f);
                h2.lineTo(0.01320356f, 36.415977f);
                h2.cubicTo(-0.12272003f, 37.546406f, 0.80932754f, 38.462246f, 1.9549693f, 38.33196f);
                h2.lineTo(7.7802663f, 38.33196f);
                h2.lineTo(7.7802663f, 67.07164f);
                h2.cubicTo(7.659877f, 68.20207f, 8.58804f, 69.117905f, 9.733683f, 68.987625f);
                h2.lineTo(21.597872f, 68.987625f);
                h2.cubicTo(22.743513f, 69.117905f, 23.671677f, 68.20207f, 23.306625f, 67.07164f);
                h2.lineTo(23.314392f, 38.33196f);
                h2.lineTo(33.02322f, 38.33196f);
                h2.cubicTo(34.16886f, 38.462246f, 35.10091f, 37.546406f, 34.964985f, 36.415977f);
                h2.lineTo(34.964985f, 24.920105f);
                h2.cubicTo(35.10091f, 23.789677f, 34.16886f, 22.87384f, 33.02322f, 23.004126f);
                h2.lineTo(23.30274f, 23.004126f);
                h2.lineTo(23.314392f, 17.25619f);
                h2.cubicTo(23.691093f, 14.807568f, 23.691093f, 15.206092f, 25.994028f, 15.34021f);
                h2.lineTo(32.941666f, 15.34021f);
                h2.cubicTo(33.481476f, 15.221419f, 34.05624f, 15.286563f, 34.460125f, 14.899535f);
                h2.cubicTo(34.864014f, 14.512507f, 35.097027f, 13.983697f, 34.9611f, 13.424232f);
                h2.lineTo(34.9611f, 1.9283571f);
                h2.cubicTo(35.10091f, 0.7979297f, 34.16886f, -0.11790832f, 33.02322f, 0.0123782605f);
                h2.close();
                h2.moveTo(30.94553f, 11.293663f);
                h2.lineTo(26.075583f, 11.109729f);
                h2.cubicTo(20.044458f, 11.109729f, 19.539598f, 14.340069f, 19.539598f, 17.647049f);
                h2.lineTo(19.524065f, 24.912441f);
                h2.cubicTo(19.524065f, 25.45658f, 19.741543f, 25.977726f, 20.129896f, 26.364754f);
                h2.cubicTo(20.51825f, 26.74795f, 21.04641f, 26.962538f, 21.59787f, 26.962538f);
                h2.lineTo(31.081455f, 26.962538f);
                h2.lineTo(31.081455f, 34.365883f);
                h2.lineTo(21.605639f, 34.365883f);
                h2.cubicTo(20.459995f, 34.365883f, 19.531832f, 35.28172f, 19.527948f, 36.412148f);
                h2.lineTo(19.524065f, 65.15566f);
                h2.lineTo(11.663797f, 65.15566f);
                h2.lineTo(11.663797f, 36.415977f);
                h2.cubicTo(11.663797f, 35.285553f, 10.883207f, 34.369713f, 9.733683f, 34.369713f);
                h2.lineTo(3.8967347f, 34.369713f);
                h2.lineTo(3.8967347f, 26.966372f);
                h2.lineTo(9.733683f, 26.966372f);
                h2.cubicTo(10.285144f, 26.966372f, 10.813304f, 26.751781f, 11.201657f, 26.368586f);
                h2.cubicTo(11.590011f, 25.981558f, 11.659914f, 25.460411f, 11.659914f, 24.916273f);
                h2.lineTo(11.659914f, 16.658403f);
                h2.cubicTo(11.659914f, 8.067154f, 13.419154f, 3.9746227f, 22.658075f, 3.9746227f);
                h2.lineTo(30.941647f, 3.9746227f);
                h2.lineTo(30.941647f, 11.293663f);
                h2.lineTo(30.94553f, 11.293663f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a2);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
