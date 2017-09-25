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

public final class afy extends c {
    private final int height = 96;
    private final int width = 584;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 584;
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
                g.setColor(419430400);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(0.0f, 9.00051f);
                h.cubicTo(0.0f, 4.0296655f, 4.0212784f, 0.0f, 8.997707f, 0.0f);
                h.lineTo(575.0023f, 0.0f);
                h.cubicTo(579.9716f, 0.0f, 584.0f, 4.0326095f, 584.0f, 9.00051f);
                h.lineTo(584.0f, 76.99949f);
                h.cubicTo(584.0f, 81.97034f, 579.9787f, 86.0f, 575.0023f, 86.0f);
                h.lineTo(8.997707f, 86.0f);
                h.cubicTo(4.028411f, 86.0f, 0.0f, 81.96739f, 0.0f, 76.99949f);
                h.lineTo(0.0f, 9.00051f);
                h.close();
                h.moveTo(113.04867f, 96.0f);
                h.lineTo(104.0f, 86.0f);
                h.lineTo(122.09733f, 86.0f);
                h.lineTo(113.04867f, 96.0f);
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
