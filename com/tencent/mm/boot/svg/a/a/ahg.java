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

public final class ahg extends c {
    private final int height = 42;
    private final int width = 42;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 42;
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
                g2 = c.a(g2, looper);
                g2.setStrokeWidth(1.0f);
                Paint a = c.a(g, looper);
                Paint a2 = c.a(g2, looper);
                a.setColor(-4210753);
                a2.setColor(-4210753);
                a2.setStrokeWidth(1.2f);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a3 = c.a(a, looper);
                Paint a4 = c.a(a2, looper);
                Path h = c.h(looper);
                h.moveTo(20.06508f, 39.519398f);
                h.cubicTo(9.131414f, 39.519398f, 0.36045057f, 30.628284f, 0.36045057f, 19.814768f);
                h.cubicTo(0.36045057f, 8.881102f, 9.251564f, 0.11013767f, 20.06508f, 0.11013767f);
                h.cubicTo(30.998749f, 0.11013767f, 39.76971f, 9.001251f, 39.76971f, 19.814768f);
                h.cubicTo(39.76971f, 30.628284f, 30.998749f, 39.519398f, 20.06508f, 39.519398f);
                h.close();
                h.moveTo(20.06508f, 1.1914893f);
                h.cubicTo(9.852315f, 1.1914893f, 1.5619525f, 9.481853f, 1.5619525f, 19.694618f);
                h.cubicTo(1.5619525f, 29.907385f, 9.852315f, 38.197746f, 20.06508f, 38.197746f);
                h.cubicTo(30.277847f, 38.197746f, 38.56821f, 29.907385f, 38.56821f, 19.694618f);
                h.cubicTo(38.56821f, 9.481853f, 30.277847f, 1.1914893f, 20.06508f, 1.1914893f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.drawPath(h, a4);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                a = c.a(a2, looper);
                h = c.h(looper);
                h.moveTo(25.83229f, 27.26408f);
                h.cubicTo(25.712141f, 27.26408f, 25.47184f, 27.14393f, 25.35169f, 27.023779f);
                h.lineTo(19.58448f, 20.055069f);
                h.cubicTo(19.46433f, 19.93492f, 19.46433f, 19.814768f, 19.46433f, 19.694618f);
                h.lineTo(19.46433f, 8.1602f);
                h.cubicTo(19.46433f, 7.79975f, 19.70463f, 7.559449f, 20.06508f, 7.559449f);
                h.cubicTo(20.425531f, 7.559449f, 20.665833f, 7.79975f, 20.665833f, 8.1602f);
                h.lineTo(20.665833f, 19.454317f);
                h.lineTo(26.312891f, 26.182728f);
                h.cubicTo(26.553192f, 26.423029f, 26.43304f, 26.78348f, 26.192741f, 27.023779f);
                h.cubicTo(26.07259f, 27.26408f, 25.95244f, 27.26408f, 25.83229f, 27.26408f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
