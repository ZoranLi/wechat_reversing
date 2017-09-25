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

public final class cz extends c {
    private final int height = 60;
    private final int width = 64;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 64;
            case 1:
                return 60;
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
                a.setColor(WebView.NIGHT_MODE_COLOR);
                c = c.a(c, 1.0f, 0.0f, -194.0f, 0.0f, 1.0f, -102.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(224.36317f, 150.10246f);
                h.lineTo(204.89511f, 161.91656f);
                h.lineTo(210.11502f, 139.75056f);
                h.lineTo(192.86317f, 124.88609f);
                h.lineTo(215.55734f, 123.000854f);
                h.lineTo(224.36317f, 102.0f);
                h.lineTo(233.16902f, 123.000854f);
                h.lineTo(255.86317f, 124.88609f);
                h.lineTo(238.61133f, 139.75056f);
                h.lineTo(243.83125f, 161.91656f);
                h.lineTo(224.36317f, 150.10246f);
                h.close();
                h.moveTo(224.24213f, 144.04645f);
                h.lineTo(235.99782f, 151.18034f);
                h.lineTo(232.8458f, 137.7955f);
                h.lineTo(243.26324f, 128.81966f);
                h.lineTo(229.5595f, 127.681274f);
                h.lineTo(224.24213f, 115.0f);
                h.lineTo(218.92476f, 127.681274f);
                h.lineTo(205.221f, 128.81966f);
                h.lineTo(215.63844f, 137.7955f);
                h.lineTo(212.48642f, 151.18034f);
                h.lineTo(224.24213f, 144.04645f);
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
