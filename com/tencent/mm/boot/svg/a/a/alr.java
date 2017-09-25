package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.ao;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class alr extends c {
    private final int height = 72;
    private final int width = 72;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                c = c.a(c, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 4.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.saveLayerAlpha(null, ao.CTRL_INDEX, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(31.0f, 0.0f);
                h.cubicTo(33.46594f, 1.5626858f, 35.15624f, 3.6262326f, 37.0f, 6.0f);
                h.cubicTo(29.64526f, 12.992331f, 22.293955f, 20.395054f, 15.0f, 28.0f);
                h.cubicTo(32.385746f, 28.008139f, 49.688816f, 27.938019f, 67.0f, 28.0f);
                h.cubicTo(67.01189f, 30.642668f, 67.001884f, 33.307247f, 67.0f, 36.0f);
                h.cubicTo(49.678814f, 36.001877f, 32.375744f, 35.951794f, 15.0f, 36.0f);
                h.cubicTo(22.27395f, 43.614964f, 29.795286f, 50.917515f, 37.0f, 59.0f);
                h.cubicTo(35.15624f, 60.353733f, 33.36592f, 62.16685f, 32.0f, 64.0f);
                h.cubicTo(20.97372f, 53.421818f, 10.531868f, 42.65331f, 0.0f, 32.0f);
                h.cubicTo(10.401845f, 21.266552f, 21.02373f, 10.778525f, 31.0f, 0.0f);
                h.lineTo(31.0f, 0.0f);
                h.lineTo(31.0f, 0.0f);
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
