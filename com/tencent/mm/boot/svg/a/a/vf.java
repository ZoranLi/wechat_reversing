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

public final class vf extends c {
    private final int height = 56;
    private final int width = 40;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 40;
            case 1:
                return 56;
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
                g.setColor(-8355712);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(0.53f, 0.0f);
                h.cubicTo(4.16f, 3.26f, 8.39f, 5.74f, 12.27f, 8.67f);
                h.cubicTo(21.58f, 15.0f, 30.72f, 21.59f, 40.0f, 27.97f);
                h.lineTo(40.0f, 27.98f);
                h.cubicTo(26.85f, 37.4f, 13.29f, 46.35f, 0.36f, 56.0f);
                h.lineTo(0.0f, 56.0f);
                h.lineTo(0.0f, 0.0f);
                h.lineTo(0.0f, 0.0f);
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
