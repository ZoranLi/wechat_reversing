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

public final class cn extends c {
    private final int height = 41;
    private final int width = 47;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 47;
            case 1:
                return 41;
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
                Paint a = c.a(g2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, -126.0f, 0.0f, 1.0f, -1631.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 127.0f, 0.0f, 1.0f, 1631.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                Paint a2 = c.a(a, looper);
                a2.setColor(-10526881);
                a2.setStrokeWidth(6.0f);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                Path h = c.h(looper);
                h.moveTo(0.27375567f, 36.99819f);
                h.cubicTo(-0.9820049f, 39.20833f, 0.05327524f, 41.0f, 2.6142578f, 41.0f);
                h.lineTo(43.385742f, 41.0f);
                h.cubicTo(45.934128f, 41.0f, 46.981197f, 39.20691f, 45.726246f, 36.99819f);
                h.lineTo(25.273756f, 1.00181f);
                h.cubicTo(24.017996f, -1.2083286f, 21.981197f, -1.2069088f, 20.726244f, 1.00181f);
                h.lineTo(0.27375567f, 36.99819f);
                h.close();
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(g, looper);
                a3.setColor(-10526881);
                h = c.h(looper);
                h.moveTo(22.22413f, 14.0f);
                h.cubicTo(21.548061f, 14.0f, 21.041523f, 14.548094f, 21.093502f, 15.234215f);
                h.lineTo(22.120932f, 28.7963f);
                h.cubicTo(22.14619f, 29.129715f, 22.437256f, 29.4f, 22.777334f, 29.4f);
                h.lineTo(22.722666f, 29.4f);
                h.cubicTo(23.059927f, 29.4f, 23.353582f, 29.132704f, 23.379068f, 28.7963f);
                h.lineTo(24.406498f, 15.234215f);
                h.cubicTo(24.458138f, 14.552577f, 23.953125f, 14.0f, 23.27587f, 14.0f);
                h.lineTo(22.22413f, 14.0f);
                h.close();
                h.moveTo(23.0f, 35.0f);
                h.cubicTo(24.10457f, 35.0f, 25.0f, 34.10457f, 25.0f, 33.0f);
                h.cubicTo(25.0f, 31.89543f, 24.10457f, 31.0f, 23.0f, 31.0f);
                h.cubicTo(21.89543f, 31.0f, 21.0f, 31.89543f, 21.0f, 33.0f);
                h.cubicTo(21.0f, 34.10457f, 21.89543f, 35.0f, 23.0f, 35.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
