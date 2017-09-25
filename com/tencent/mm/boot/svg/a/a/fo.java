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

public final class fo extends c {
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
                g = c.a(g, looper);
                g.setColor(-8617851);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(48.0f, 80.0f);
                h.lineTo(44.0f, 76.0f);
                h.lineTo(48.0f, 64.0f);
                h.lineTo(52.0f, 76.0f);
                h.lineTo(48.0f, 80.0f);
                h.close();
                h.moveTo(78.666664f, 72.46489f);
                h.lineTo(78.666664f, 72.44444f);
                h.lineTo(58.234665f, 65.333336f);
                h.lineTo(58.666668f, 65.333336f);
                h.cubicTo(58.666668f, 65.333336f, 56.0f, 64.88355f, 56.0f, 62.666668f);
                h.lineTo(56.0f, 64.55556f);
                h.lineTo(56.0f, 64.55556f);
                h.lineTo(56.0f, 61.333332f);
                h.cubicTo(56.0f, 59.977333f, 57.333332f, 58.666668f, 57.333332f, 58.666668f);
                h.lineTo(57.319557f, 58.666668f);
                h.cubicTo(63.177776f, 54.190224f, 67.138664f, 45.516445f, 67.13022f, 35.05378f);
                h.cubicTo(67.11867f, 21.260445f, 58.55467f, 12.0f, 48.0f, 12.0f);
                h.cubicTo(37.44533f, 12.0f, 28.896444f, 21.260445f, 28.908f, 35.05378f);
                h.cubicTo(28.916445f, 45.514668f, 32.88978f, 54.189335f, 38.753777f, 58.666668f);
                h.lineTo(38.666668f, 58.666668f);
                h.cubicTo(38.666668f, 58.666668f, 40.0f, 59.977333f, 40.0f, 61.333332f);
                h.lineTo(40.0f, 62.666668f);
                h.cubicTo(40.0f, 64.88355f, 37.333332f, 65.333336f, 37.333332f, 65.333336f);
                h.lineTo(37.765335f, 65.333336f);
                h.lineTo(17.333334f, 72.44444f);
                h.lineTo(17.333334f, 72.46489f);
                h.cubicTo(14.228f, 73.564445f, 12.0f, 76.51822f, 12.0f, 80.0f);
                h.lineTo(12.0f, 84.0f);
                h.lineTo(84.0f, 84.0f);
                h.lineTo(84.0f, 80.0f);
                h.cubicTo(84.0f, 76.51822f, 81.77155f, 73.564445f, 78.666664f, 72.46489f);
                h.lineTo(78.666664f, 72.46489f);
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
