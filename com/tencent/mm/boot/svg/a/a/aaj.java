package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class aaj extends c {
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
                c.d(looper);
                c.c(looper);
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
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(16.0f, 22.0f);
                h.cubicTo(15.747877f, 20.113762f, 16.916676f, 17.966154f, 19.0f, 18.0f);
                h.cubicTo(27.60569f, 17.91621f, 36.306747f, 18.066044f, 45.0f, 18.0f);
                h.cubicTo(45.06774f, 23.380123f, 44.897915f, 28.754135f, 45.0f, 34.0f);
                h.cubicTo(44.977833f, 35.59651f, 46.396374f, 37.03491f, 48.0f, 37.0f);
                h.cubicTo(53.249332f, 37.09484f, 58.623806f, 36.94501f, 64.0f, 37.0f);
                h.cubicTo(63.938343f, 49.67083f, 64.0782f, 62.356697f, 64.0f, 75.0f);
                h.cubicTo(64.018265f, 77.05032f, 61.88046f, 78.26897f, 60.0f, 78.0f);
                h.cubicTo(46.366405f, 77.91936f, 32.670483f, 78.01925f, 19.0f, 78.0f);
                h.cubicTo(16.966625f, 78.029236f, 15.737887f, 75.89162f, 16.0f, 74.0f);
                h.cubicTo(16.02759f, 56.69301f, 16.02759f, 39.292393f, 16.0f, 22.0f);
                h.lineTo(16.0f, 22.0f);
                h.close();
                h.moveTo(22.0f, 48.0f);
                h.lineTo(22.0f, 51.0f);
                h.lineTo(42.0f, 51.0f);
                h.lineTo(42.0f, 48.0f);
                h.lineTo(22.0f, 48.0f);
                h.lineTo(22.0f, 48.0f);
                h.close();
                h.moveTo(22.0f, 56.0f);
                h.lineTo(22.0f, 59.0f);
                h.lineTo(48.0f, 59.0f);
                h.lineTo(48.0f, 56.0f);
                h.lineTo(22.0f, 56.0f);
                h.lineTo(22.0f, 56.0f);
                h.close();
                h.moveTo(22.0f, 64.0f);
                h.lineTo(22.0f, 67.0f);
                h.lineTo(48.0f, 67.0f);
                h.lineTo(48.0f, 64.0f);
                h.lineTo(22.0f, 64.0f);
                h.lineTo(22.0f, 64.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(48.0f, 18.0f);
                h.cubicTo(53.348984f, 23.320744f, 58.669502f, 28.65147f, 64.0f, 34.0f);
                h.cubicTo(59.008896f, 33.872387f, 54.00781f, 34.161884f, 49.0f, 34.0f);
                h.cubicTo(48.80708f, 33.61284f, 48.35788f, 33.12369f, 48.0f, 33.0f);
                h.cubicTo(47.848785f, 27.93272f, 48.118305f, 22.961369f, 48.0f, 18.0f);
                h.lineTo(48.0f, 18.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
