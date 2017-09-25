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

public final class ku extends c {
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
                Paint a = c.a(g, looper);
                a.setColor(-9473160);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 8.0f, 0.0f, 1.0f, 17.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(77.0f, 49.0f);
                h.lineTo(46.0f, 49.0f);
                h.lineTo(35.0f, 49.0f);
                h.lineTo(3.0f, 49.0f);
                h.lineTo(3.0f, 3.0f);
                h.lineTo(77.0f, 3.0f);
                h.lineTo(77.0f, 49.0f);
                h.close();
                h.moveTo(48.513f, 60.0f);
                h.lineTo(32.487f, 60.0f);
                h.lineTo(38.0f, 58.162f);
                h.lineTo(38.0f, 52.0f);
                h.lineTo(43.0f, 52.0f);
                h.lineTo(43.0f, 58.162f);
                h.lineTo(48.513f, 60.0f);
                h.close();
                h.moveTo(77.129f, 0.0f);
                h.lineTo(2.871f, 0.0f);
                h.cubicTo(1.289f, 0.0f, 0.0f, 1.285f, 0.0f, 2.87f);
                h.lineTo(0.0f, 49.13f);
                h.cubicTo(0.0f, 50.715f, 1.285f, 52.0f, 2.871f, 52.0f);
                h.lineTo(35.0f, 52.0f);
                h.lineTo(35.0f, 56.0f);
                h.lineTo(23.0f, 60.0f);
                h.lineTo(23.0f, 63.0f);
                h.lineTo(58.0f, 63.0f);
                h.lineTo(58.0f, 60.0f);
                h.lineTo(46.0f, 56.0f);
                h.lineTo(46.0f, 52.0f);
                h.lineTo(77.129f, 52.0f);
                h.cubicTo(78.711f, 52.0f, 80.0f, 50.715f, 80.0f, 49.13f);
                h.lineTo(80.0f, 2.87f);
                h.cubicTo(80.0f, 1.285f, 78.715f, 0.0f, 77.129f, 0.0f);
                h.lineTo(77.129f, 0.0f);
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
