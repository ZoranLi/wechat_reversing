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

public final class ug extends c {
    private final int height = 30;
    private final int width = 30;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 30;
            case 1:
                return 30;
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
                g.setColor(-1158579);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(13.68f, 0.0f);
                h.lineTo(16.09f, 0.0f);
                h.cubicTo(23.29f, 0.5f, 29.35f, 6.53f, 30.0f, 13.69f);
                h.lineTo(30.0f, 16.12f);
                h.cubicTo(29.49f, 23.29f, 23.49f, 29.33f, 16.34f, 30.0f);
                h.lineTo(13.89f, 30.0f);
                h.cubicTo(6.7f, 29.49f, 0.65f, 23.47f, 0.0f, 16.32f);
                h.lineTo(0.0f, 13.88f);
                h.cubicTo(0.52f, 6.7f, 6.53f, 0.66f, 13.68f, 0.0f);
                h.lineTo(13.68f, 0.0f);
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
