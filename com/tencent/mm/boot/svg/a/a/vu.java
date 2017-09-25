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

public final class vu extends c {
    private final int height = 69;
    private final int width = 80;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 80;
            case 1:
                return 69;
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
                a.setColor(-16896);
                c = c.a(c, 1.0f, 0.0f, -67.0f, 0.0f, 1.0f, -264.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(67.541016f, 329.11725f);
                h.lineTo(104.7274f, 265.6061f);
                h.cubicTo(105.979546f, 263.46756f, 108.01863f, 263.46173f, 109.27419f, 265.6061f);
                h.lineTo(146.46057f, 329.11725f);
                h.cubicTo(147.71272f, 331.2558f, 146.71822f, 333.0f, 144.23167f, 333.0f);
                h.lineTo(69.76992f, 333.0f);
                h.cubicTo(67.28949f, 333.0f, 66.28545f, 331.26163f, 67.541016f, 329.11725f);
                h.close();
                h.moveTo(105.08408f, 288.09476f);
                h.cubicTo(104.25631f, 288.09476f, 103.6169f, 288.77545f, 103.654755f, 289.5901f);
                h.lineTo(104.72356f, 312.58853f);
                h.lineTo(109.276726f, 312.58853f);
                h.lineTo(110.34553f, 289.5901f);
                h.cubicTo(110.3839f, 288.76425f, 109.73518f, 288.09476f, 108.9162f, 288.09476f);
                h.lineTo(105.08408f, 288.09476f);
                h.close();
                h.moveTo(107.00014f, 323.47464f);
                h.cubicTo(108.88612f, 323.47464f, 110.415016f, 321.95157f, 110.415016f, 320.07272f);
                h.cubicTo(110.415016f, 318.1939f, 108.88612f, 316.67084f, 107.00014f, 316.67084f);
                h.cubicTo(105.11416f, 316.67084f, 103.585266f, 318.1939f, 103.585266f, 320.07272f);
                h.cubicTo(103.585266f, 321.95157f, 105.11416f, 323.47464f, 107.00014f, 323.47464f);
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
