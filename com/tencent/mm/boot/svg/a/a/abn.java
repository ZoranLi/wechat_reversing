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

public final class abn extends c {
    private final int height = 79;
    private final int width = 66;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 66;
            case 1:
                return 79;
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
                h.moveTo(10.536117f, 55.789783f);
                h.cubicTo(4.649229f, 49.98656f, 1.0f, 41.91944f, 1.0f, 33.0f);
                h.cubicTo(1.0f, 15.326888f, 15.326888f, 1.0f, 33.0f, 1.0f);
                h.cubicTo(50.67311f, 1.0f, 65.0f, 15.326888f, 65.0f, 33.0f);
                h.cubicTo(65.0f, 41.959976f, 61.317528f, 50.059868f, 55.383484f, 55.868763f);
                h.lineTo(55.435028f, 55.92031f);
                h.lineTo(32.92031f, 78.43503f);
                h.lineTo(10.405592f, 55.92031f);
                h.lineTo(10.536117f, 55.789783f);
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
