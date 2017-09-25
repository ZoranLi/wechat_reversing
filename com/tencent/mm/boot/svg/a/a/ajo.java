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

public final class ajo extends c {
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
                g = c.a(g, looper);
                g.setColor(-14624737);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(21.0f, 21.0f);
                h.lineTo(43.5f, 21.0f);
                h.lineTo(43.5f, 21.127842f);
                h.cubicTo(51.115696f, 22.108934f, 57.0f, 28.61729f, 57.0f, 36.5f);
                h.cubicTo(57.0f, 44.209316f, 51.37172f, 50.604076f, 44.0f, 51.79944f);
                h.lineTo(44.0f, 52.0f);
                h.lineTo(20.0f, 52.0f);
                h.lineTo(20.0f, 46.0f);
                h.lineTo(44.0f, 46.0f);
                h.lineTo(44.0f, 46.16791f);
                h.cubicTo(47.53181f, 44.624798f, 50.0f, 41.10064f, 50.0f, 37.0f);
                h.cubicTo(50.0f, 32.07876f, 46.445118f, 27.987804f, 41.763157f, 27.15494f);
                h.lineTo(41.763157f, 27.0f);
                h.lineTo(21.0f, 27.0f);
                h.lineTo(21.0f, 32.99984f);
                h.cubicTo(21.0f, 34.664913f, 19.933712f, 35.176052f, 18.61838f, 34.159657f);
                h.lineTo(6.88162f, 25.090343f);
                h.cubicTo(5.5572495f, 24.066965f, 5.5662875f, 22.42605f, 6.88162f, 21.409657f);
                h.lineTo(18.61838f, 12.3403425f);
                h.cubicTo(19.94275f, 11.316965f, 21.0f, 11.843217f, 21.0f, 13.500159f);
                h.lineTo(21.0f, 21.0f);
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
