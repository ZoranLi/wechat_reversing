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

public final class aif extends c {
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
                g.setColor(-1);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(35.0f, 20.0f);
                h.lineTo(50.492165f, 20.0f);
                h.cubicTo(51.322575f, 20.0f, 52.0f, 19.326305f, 52.0f, 18.495262f);
                h.lineTo(52.0f, 13.504739f);
                h.cubicTo(52.0f, 12.668316f, 51.324917f, 12.0f, 50.492165f, 12.0f);
                h.lineTo(12.507836f, 12.0f);
                h.cubicTo(11.677424f, 12.0f, 11.0f, 12.673695f, 11.0f, 13.504739f);
                h.lineTo(11.0f, 18.495262f);
                h.cubicTo(11.0f, 19.331684f, 11.675081f, 20.0f, 12.507836f, 20.0f);
                h.lineTo(27.0f, 20.0f);
                h.lineTo(27.0f, 52.5052f);
                h.cubicTo(27.0f, 53.32327f, 27.673695f, 54.0f, 28.504738f, 54.0f);
                h.lineTo(33.495262f, 54.0f);
                h.cubicTo(34.331684f, 54.0f, 35.0f, 53.330753f, 35.0f, 52.5052f);
                h.lineTo(35.0f, 20.0f);
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
