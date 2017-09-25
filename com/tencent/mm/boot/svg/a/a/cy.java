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

public final class cy extends c {
    private final int height = 66;
    private final int width = 66;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 66;
            case 1:
                return 66;
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
                c = c.a(c, 1.0f, 0.0f, -196.0f, 0.0f, 1.0f, -118.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 196.0f, 0.0f, 1.0f, 118.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-1686720);
                Path h = c.h(looper);
                h.moveTo(33.0f, 66.0f);
                h.cubicTo(51.225395f, 66.0f, 66.0f, 51.225395f, 66.0f, 33.0f);
                h.cubicTo(66.0f, 14.774603f, 51.225395f, 0.0f, 33.0f, 0.0f);
                h.cubicTo(14.774603f, 0.0f, 0.0f, 14.774603f, 0.0f, 33.0f);
                h.cubicTo(0.0f, 51.225395f, 14.774603f, 66.0f, 33.0f, 66.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                a.setColor(-1);
                h = c.h(looper);
                h.moveTo(11.0f, 33.5f);
                h.cubicTo(11.0f, 31.567003f, 12.567003f, 30.0f, 14.5f, 30.0f);
                h.lineTo(51.5f, 30.0f);
                h.cubicTo(53.433f, 30.0f, 55.0f, 31.567003f, 55.0f, 33.5f);
                h.lineTo(55.0f, 33.5f);
                h.cubicTo(55.0f, 35.433f, 53.433f, 37.0f, 51.5f, 37.0f);
                h.lineTo(14.5f, 37.0f);
                h.cubicTo(12.567003f, 37.0f, 11.0f, 35.433f, 11.0f, 33.5f);
                h.lineTo(11.0f, 33.5f);
                h.close();
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
