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

public final class qz extends c {
    private final int height = 76;
    private final int width = 76;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 76;
            case 1:
                return 76;
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
                a.setColor(-11184811);
                c = c.a(c, 1.0f, 0.0f, -529.0f, 0.0f, 1.0f, -427.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 534.0f, 0.0f, 1.0f, 434.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(64.0f, 10.0f);
                h.lineTo(64.0f, 10.0f);
                h.cubicTo(64.0f, 9.882686f, 63.991978f, 9.8073f, 63.984455f, 9.774971f);
                h.cubicTo(63.995667f, 9.823138f, 64.027534f, 9.904926f, 64.09329f, 10.0147295f);
                h.cubicTo(64.411995f, 10.546919f, 65.079636f, 11.0f, 66.0f, 11.0f);
                h.lineTo(56.0f, 11.0f);
                h.lineTo(59.0f, 8.0f);
                h.lineTo(59.0f, 58.0f);
                h.cubicTo(59.0f, 58.130436f, 59.051327f, 58.22705f, 59.27441f, 58.38821f);
                h.cubicTo(59.773357f, 58.748653f, 60.693993f, 59.0f, 62.0f, 59.0f);
                h.cubicTo(63.33438f, 59.0f, 64.0f, 58.45092f, 64.0f, 58.0f);
                h.lineTo(64.0f, 10.0f);
                h.close();
                h.moveTo(67.0f, 10.0f);
                h.lineTo(67.0f, 10.0f);
                h.lineTo(67.0f, 58.0f);
                h.cubicTo(67.0f, 60.186752f, 64.95295f, 62.0f, 62.0f, 62.0f);
                h.cubicTo(58.047047f, 62.0f, 56.0f, 60.186752f, 56.0f, 58.0f);
                h.lineTo(56.0f, 8.0f);
                h.lineTo(66.0f, 8.0f);
                h.cubicTo(66.44552f, 8.0f, 67.0f, 8.595759f, 67.0f, 10.0f);
                h.lineTo(67.0f, 10.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(58.110535f, 62.0f);
                h.cubicTo(56.9593f, 60.32874f, 56.270737f, 58.518147f, 55.99838f, 56.32013f);
                h.lineTo(55.97561f, 56.13638f);
                h.lineTo(55.97561f, 55.951218f);
                h.lineTo(55.97561f, 3.0243902f);
                h.lineTo(55.97561f, 2.755022f);
                h.lineTo(56.023594f, 2.4899626f);
                h.cubicTo(56.01672f, 2.5279436f, 56.08146f, 2.764993f, 56.26943f, 2.9529014f);
                h.cubicTo(56.336334f, 3.0197873f, 56.385796f, 3.049719f, 56.39374f, 3.0524664f);
                h.cubicTo(56.30831f, 3.0229237f, 56.15949f, 3.0f, 55.951218f, 3.0f);
                h.lineTo(3.0243902f, 3.0f);
                h.cubicTo(2.8651917f, 3.0f, 3.0f, 2.8653867f, 3.0f, 3.0243902f);
                h.lineTo(3.0f, 55.951218f);
                h.cubicTo(3.0f, 57.929375f, 4.0706234f, 59.0f, 6.0487804f, 59.0f);
                h.lineTo(59.831577f, 59.0f);
                h.cubicTo(60.363014f, 60.123505f, 61.09911f, 61.07564f, 62.0f, 62.0f);
                h.lineTo(58.110535f, 62.0f);
                h.lineTo(58.110535f, 62.0f);
                h.close();
                h.moveTo(58.97561f, 55.951218f);
                h.lineTo(58.97561f, 55.951218f);
                h.cubicTo(59.304348f, 58.60424f, 60.388535f, 60.346558f, 62.0f, 62.0f);
                h.lineTo(6.0487804f, 62.0f);
                h.cubicTo(2.4137692f, 62.0f, 0.0f, 59.58623f, 0.0f, 55.951218f);
                h.lineTo(0.0f, 3.0243902f);
                h.cubicTo(0.0f, 1.2053713f, 1.2115004f, 0.0f, 3.0243902f, 0.0f);
                h.lineTo(55.951218f, 0.0f);
                h.cubicTo(58.094494f, 0.0f, 59.304348f, 1.2085422f, 58.97561f, 3.0243902f);
                h.lineTo(58.97561f, 55.951218f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(9.0f, 26.5f);
                h.cubicTo(9.0f, 25.671574f, 9.895431f, 25.0f, 11.0f, 25.0f);
                h.lineTo(28.0f, 25.0f);
                h.cubicTo(29.10457f, 25.0f, 30.0f, 25.671574f, 30.0f, 26.5f);
                h.lineTo(30.0f, 26.5f);
                h.cubicTo(30.0f, 27.328426f, 29.10457f, 28.0f, 28.0f, 28.0f);
                h.lineTo(11.0f, 28.0f);
                h.cubicTo(9.895431f, 28.0f, 9.0f, 27.328426f, 9.0f, 26.5f);
                h.lineTo(9.0f, 26.5f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(9.0f, 18.5f);
                h.cubicTo(9.0f, 17.671574f, 9.895431f, 17.0f, 11.0f, 17.0f);
                h.lineTo(28.0f, 17.0f);
                h.cubicTo(29.10457f, 17.0f, 30.0f, 17.671574f, 30.0f, 18.5f);
                h.lineTo(30.0f, 18.5f);
                h.cubicTo(30.0f, 19.328426f, 29.10457f, 20.0f, 28.0f, 20.0f);
                h.lineTo(11.0f, 20.0f);
                h.cubicTo(9.895431f, 20.0f, 9.0f, 19.328426f, 9.0f, 18.5f);
                h.lineTo(9.0f, 18.5f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(10.493433f, 9.0f);
                h.lineTo(28.506567f, 9.0f);
                h.cubicTo(29.331367f, 9.0f, 30.0f, 9.665797f, 30.0f, 10.5f);
                h.cubicTo(30.0f, 11.328427f, 29.325077f, 12.0f, 28.506567f, 12.0f);
                h.lineTo(10.493433f, 12.0f);
                h.cubicTo(9.6686325f, 12.0f, 9.0f, 11.334203f, 9.0f, 10.5f);
                h.cubicTo(9.0f, 9.671573f, 9.674923f, 9.0f, 10.493433f, 9.0f);
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
