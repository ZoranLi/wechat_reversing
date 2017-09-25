package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class aiv extends c {
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
                c.d(looper);
                c.c(looper);
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
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(96.0f, 0.0f);
                h.lineTo(96.0f, 96.0f);
                h.lineTo(0.0f, 96.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-15028967);
                h = c.h(looper);
                h.moveTo(46.279175f, 21.000214f);
                h.lineTo(46.279175f, 44.5821f);
                h.lineTo(33.04137f, 33.706234f);
                h.lineTo(31.0f, 36.192547f);
                h.lineTo(45.37214f, 47.999035f);
                h.lineTo(31.0f, 59.806595f);
                h.lineTo(33.04137f, 62.292908f);
                h.lineTo(46.279175f, 51.41704f);
                h.lineTo(46.279175f, 75.0f);
                h.lineTo(64.73941f, 59.746555f);
                h.lineTo(50.43911f, 47.999035f);
                h.lineTo(64.73941f, 36.251514f);
                h.lineTo(46.279175f, 21.000214f);
                h.close();
                h.moveTo(49.495617f, 27.828722f);
                h.lineTo(59.68102f, 36.244007f);
                h.lineTo(49.495617f, 44.61212f);
                h.lineTo(49.495617f, 27.828722f);
                h.close();
                h.moveTo(49.495617f, 51.38595f);
                h.lineTo(59.68102f, 59.75299f);
                h.lineTo(49.495617f, 68.16935f);
                h.lineTo(49.495617f, 51.38595f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
