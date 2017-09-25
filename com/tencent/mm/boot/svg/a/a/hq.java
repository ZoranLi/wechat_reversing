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

public final class hq extends c {
    private final int height = 63;
    private final int width = 63;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 63;
            case 1:
                return 63;
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
                g = c.a(g2, looper);
                g.setStrokeWidth(1.0f);
                g.setStrokeCap(Cap.SQUARE);
                Paint a = c.a(g, looper);
                a.setColor(-1);
                a.setStrokeWidth(7.5f);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 13.5f, 0.0f, 1.0f, 13.5f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                g = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(0.6666667f, 0.6666667f);
                h.lineTo(14.956543f, 14.956543f);
                h.lineTo(35.333332f, 35.333332f);
                WeChatSVGRenderC2Java.setFillType(h, 1);
                canvas.drawPath(h, g);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                c = c.a(c, -1.0f, 0.0f, 36.0f, 0.0f, 1.0f, 0.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                Path h2 = c.h(looper);
                h2.moveTo(0.6666667f, 0.6666667f);
                h2.lineTo(14.956543f, 14.956543f);
                h2.lineTo(35.333332f, 35.333332f);
                WeChatSVGRenderC2Java.setFillType(h2, 1);
                canvas.drawPath(h2, a);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
