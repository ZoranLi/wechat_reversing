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

public final class di extends c {
    private final int height = 75;
    private final int width = 63;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 63;
            case 1:
                return 75;
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
                c = c.a(c, 1.0f, 0.0f, -366.0f, 0.0f, 1.0f, -536.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 377.0f, 0.0f, 1.0f, 537.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(0.0f, 3.0846448f);
                h.cubicTo(0.0f, 1.8420041f, 1.0073593f, 0.83464485f, 2.25f, 0.83464485f);
                h.lineTo(4.6465516f, 0.83464485f);
                h.cubicTo(5.8891926f, 0.83464485f, 6.8965516f, 1.8420041f, 6.8965516f, 3.0846448f);
                h.lineTo(6.8965516f, 69.939705f);
                h.cubicTo(6.8965516f, 71.18234f, 5.8891926f, 72.189705f, 4.6465516f, 72.189705f);
                h.lineTo(2.25f, 72.189705f);
                h.cubicTo(1.0073593f, 72.189705f, 0.0f, 71.18234f, 0.0f, 69.939705f);
                h.lineTo(0.0f, 3.0846448f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(33.103447f, 3.0880115f);
                h.cubicTo(33.103447f, 1.8435115f, 34.106266f, 0.83464485f, 35.361637f, 0.83464485f);
                h.lineTo(37.74181f, 0.83464485f);
                h.cubicTo(38.988976f, 0.83464485f, 40.0f, 1.8433424f, 40.0f, 3.0880115f);
                h.lineTo(40.0f, 69.93634f);
                h.cubicTo(40.0f, 71.18084f, 38.99718f, 72.189705f, 37.74181f, 72.189705f);
                h.lineTo(35.361637f, 72.189705f);
                h.cubicTo(34.114475f, 72.189705f, 33.103447f, 71.18101f, 33.103447f, 69.93634f);
                h.lineTo(33.103447f, 3.0880115f);
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
