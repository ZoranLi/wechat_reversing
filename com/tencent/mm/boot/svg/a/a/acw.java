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

public final class acw extends c {
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
                Paint a = c.a(g, looper);
                a.setColor(-1);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(59.0f, 65.0f);
                h.lineTo(73.0f, 65.0f);
                h.lineTo(73.0f, 56.0f);
                h.lineTo(78.0f, 56.0f);
                h.lineTo(78.0f, 40.0f);
                h.lineTo(73.0f, 40.0f);
                h.lineTo(73.0f, 31.0f);
                h.lineTo(59.0f, 31.0f);
                h.lineTo(59.0f, 25.0f);
                h.lineTo(38.0f, 25.0f);
                h.lineTo(38.0f, 31.0f);
                h.lineTo(23.0f, 31.0f);
                h.lineTo(23.0f, 40.0f);
                h.lineTo(18.0f, 40.0f);
                h.lineTo(18.0f, 56.0f);
                h.lineTo(23.0f, 56.0f);
                h.lineTo(23.0f, 65.0f);
                h.lineTo(38.0f, 65.0f);
                h.lineTo(38.0f, 71.0f);
                h.lineTo(59.0f, 71.0f);
                h.lineTo(59.0f, 65.0f);
                h.close();
                h.moveTo(18.0f, 28.000444f);
                h.cubicTo(18.0f, 26.343344f, 19.337309f, 25.0f, 20.995937f, 25.0f);
                h.lineTo(75.00406f, 25.0f);
                h.cubicTo(76.658676f, 25.0f, 78.0f, 26.35178f, 78.0f, 28.000444f);
                h.lineTo(78.0f, 67.99956f);
                h.cubicTo(78.0f, 69.656654f, 76.66269f, 71.0f, 75.00406f, 71.0f);
                h.lineTo(20.995937f, 71.0f);
                h.cubicTo(19.341328f, 71.0f, 18.0f, 69.64822f, 18.0f, 67.99956f);
                h.lineTo(18.0f, 28.000444f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                g = c.a(a, looper);
                Path h2 = c.h(looper);
                h2.moveTo(37.75862f, 45.672413f);
                h2.lineTo(36.0f, 49.189655f);
                h2.lineTo(43.91379f, 58.86207f);
                h2.lineTo(61.5f, 37.75862f);
                h2.lineTo(59.74138f, 36.0f);
                h2.lineTo(43.91379f, 50.948277f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 1);
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, g);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
