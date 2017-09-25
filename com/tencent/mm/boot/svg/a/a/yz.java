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

public final class yz extends c {
    private final int height = 42;
    private final int width = 33;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 33;
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
                c.a(g2, looper).setStrokeWidth(1.0f);
                g = c.a(g, looper);
                g.setColor(-16036);
                canvas.save();
                Paint a = c.a(g, looper);
                c = c.a(c, 6.123234E-17f, -1.0f, 37.0f, 1.0f, 6.123234E-17f, 4.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                Path h = c.h(looper);
                h.moveTo(-4.0f, 13.0f);
                h.lineTo(6.0f, 13.0f);
                h.lineTo(17.0f, 5.0f);
                h.lineTo(20.0f, 5.0f);
                h.lineTo(20.0f, 36.0f);
                h.lineTo(17.0f, 36.0f);
                h.lineTo(6.0f, 28.0f);
                h.lineTo(-4.0f, 28.0f);
                h.lineTo(-4.0f, 13.0f);
                h.close();
                h.moveTo(27.0f, 19.0f);
                h.lineTo(37.0f, 19.0f);
                h.lineTo(37.0f, 22.0f);
                h.lineTo(27.0f, 22.0f);
                h.lineTo(27.0f, 19.0f);
                h.close();
                h.moveTo(27.0f, 12.0f);
                h.lineTo(37.0f, 8.0f);
                h.lineTo(37.0f, 11.0f);
                h.lineTo(27.0f, 15.0f);
                h.lineTo(27.0f, 12.0f);
                h.close();
                h.moveTo(37.0f, 29.0f);
                h.lineTo(27.0f, 25.0f);
                h.lineTo(27.0f, 28.0f);
                h.lineTo(37.0f, 32.0f);
                h.lineTo(37.0f, 29.0f);
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
