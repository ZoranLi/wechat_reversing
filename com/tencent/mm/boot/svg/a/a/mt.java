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

public final class mt extends c {
    private final int height = 100;
    private final int width = 100;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 100;
            case 1:
                return 100;
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
                g.setColor(-4210753);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(47.0f, 0.0f);
                h.lineTo(53.0f, 0.0f);
                h.lineTo(53.0f, 47.0f);
                h.lineTo(100.0f, 47.0f);
                h.lineTo(100.0f, 53.0f);
                h.lineTo(53.0f, 53.0f);
                h.lineTo(53.0f, 100.0f);
                h.lineTo(47.0f, 100.0f);
                h.lineTo(47.0f, 53.0f);
                h.lineTo(0.0f, 53.0f);
                h.lineTo(0.0f, 47.0f);
                h.lineTo(47.0f, 47.0f);
                h.cubicTo(47.01f, 31.33f, 47.0f, 15.67f, 47.0f, 0.0f);
                h.lineTo(47.0f, 0.0f);
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
