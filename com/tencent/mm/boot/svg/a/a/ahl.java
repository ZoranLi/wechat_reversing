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

public final class ahl extends c {
    private final int height = 42;
    private final int width = 42;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 42;
            case 1:
                return 42;
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
                g2 = c.a(g2, looper);
                g2.setStrokeWidth(1.0f);
                Paint a = c.a(g, looper);
                Paint a2 = c.a(g2, looper);
                a.setColor(-4210753);
                a2.setColor(-4210753);
                a2.setStrokeWidth(0.5f);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a3 = c.a(a, looper);
                a = c.a(a2, looper);
                Path h = c.h(looper);
                h.moveTo(20.0f, 40.0f);
                h.cubicTo(8.954305f, 40.0f, 0.0f, 31.045694f, 0.0f, 20.0f);
                h.cubicTo(0.0f, 8.954305f, 8.954305f, 0.0f, 20.0f, 0.0f);
                h.cubicTo(31.045694f, 0.0f, 40.0f, 8.954305f, 40.0f, 20.0f);
                h.cubicTo(40.0f, 31.045694f, 31.045694f, 40.0f, 20.0f, 40.0f);
                h.close();
                h.moveTo(20.0f, 25.384615f);
                h.cubicTo(22.97384f, 25.384615f, 25.384615f, 22.97384f, 25.384615f, 20.0f);
                h.cubicTo(25.384615f, 17.02616f, 22.97384f, 14.615385f, 20.0f, 14.615385f);
                h.cubicTo(17.02616f, 14.615385f, 14.615385f, 17.02616f, 14.615385f, 20.0f);
                h.cubicTo(14.615385f, 22.97384f, 17.02616f, 25.384615f, 20.0f, 25.384615f);
                h.close();
                h.moveTo(2.841629f, 13.025641f);
                h.lineTo(20.217196f, 13.025641f);
                h.lineTo(11.095022f, 3.7104073f);
                h.cubicTo(7.4411893f, 5.695587f, 4.4904046f, 8.919444f, 2.841629f, 13.025641f);
                h.close();
                h.moveTo(19.806938f, 1.5384616f);
                h.cubicTo(17.431908f, 1.5384616f, 15.042355f, 2.0230188f, 12.856712f, 2.841629f);
                h.lineTo(25.333334f, 15.438914f);
                h.lineTo(25.333334f, 2.40724f);
                h.cubicTo(23.70856f, 1.8235183f, 21.855545f, 1.5384616f, 19.806938f, 1.5384616f);
                h.close();
                h.moveTo(1.5384616f, 20.217196f);
                h.cubicTo(1.5384616f, 22.586182f, 2.0253615f, 24.979147f, 2.8461537f, 27.167421f);
                h.lineTo(15.48718f, 14.666667f);
                h.lineTo(2.4102564f, 14.666667f);
                h.cubicTo(1.8229419f, 16.312695f, 1.5384616f, 18.162403f, 1.5384616f, 20.217196f);
                h.close();
                h.moveTo(13.025641f, 37.15837f);
                h.lineTo(13.025641f, 19.782804f);
                h.lineTo(3.7104073f, 28.904978f);
                h.cubicTo(5.695056f, 32.564972f, 8.915772f, 35.512318f, 13.025641f, 37.15837f);
                h.close();
                h.moveTo(20.217196f, 38.46154f);
                h.cubicTo(22.583342f, 38.46154f, 24.97778f, 37.974f, 27.167421f, 37.15837f);
                h.lineTo(14.666667f, 24.561087f);
                h.lineTo(14.666667f, 37.592762f);
                h.cubicTo(16.31146f, 38.177578f, 18.159653f, 38.46154f, 20.217196f, 38.46154f);
                h.close();
                h.moveTo(37.15837f, 26.923077f);
                h.lineTo(19.782804f, 26.923077f);
                h.lineTo(28.904978f, 36.289593f);
                h.cubicTo(32.56479f, 34.306225f, 35.51124f, 31.088493f, 37.15837f, 26.923077f);
                h.close();
                h.moveTo(38.46154f, 20.217196f);
                h.cubicTo(38.46154f, 17.845076f, 37.973f, 15.454035f, 37.153847f, 13.266969f);
                h.lineTo(24.512821f, 25.384615f);
                h.lineTo(37.589745f, 25.384615f);
                h.cubicTo(38.175034f, 24.120005f, 38.46154f, 22.268494f, 38.46154f, 20.217196f);
                h.close();
                h.moveTo(26.97436f, 3.2518854f);
                h.lineTo(26.97436f, 20.62745f);
                h.lineTo(36.289593f, 11.505279f);
                h.cubicTo(34.305107f, 7.851749f, 31.083288f, 4.901771f, 26.97436f, 3.2518854f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
