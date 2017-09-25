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

public final class abj extends c {
    private final int height = 120;
    private final int width = 120;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                g = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(76.0f, 81.0f);
                h.lineTo(91.0f, 81.0f);
                h.lineTo(91.0f, 85.0f);
                h.lineTo(76.0f, 85.0f);
                h.lineTo(76.0f, 89.0f);
                h.lineTo(72.0f, 89.0f);
                h.lineTo(72.0f, 77.0f);
                h.lineTo(76.0f, 77.0f);
                h.lineTo(76.0f, 81.0f);
                h.close();
                h.moveTo(68.0f, 81.0f);
                h.lineTo(28.0f, 81.0f);
                h.lineTo(28.0f, 85.0f);
                h.lineTo(68.0f, 85.0f);
                h.lineTo(68.0f, 81.0f);
                h.close();
                h.moveTo(50.0f, 60.0f);
                h.lineTo(91.0f, 60.0f);
                h.lineTo(91.0f, 64.0f);
                h.lineTo(50.0f, 64.0f);
                h.lineTo(50.0f, 68.0f);
                h.lineTo(46.0f, 68.0f);
                h.lineTo(46.0f, 56.0f);
                h.lineTo(50.0f, 56.0f);
                h.lineTo(50.0f, 60.0f);
                h.close();
                h.moveTo(42.0f, 60.0f);
                h.lineTo(28.0f, 60.0f);
                h.lineTo(28.0f, 64.0f);
                h.lineTo(42.0f, 64.0f);
                h.lineTo(42.0f, 60.0f);
                h.close();
                h.moveTo(76.0f, 39.0f);
                h.lineTo(90.0f, 39.0f);
                h.lineTo(90.0f, 43.0f);
                h.lineTo(76.0f, 43.0f);
                h.lineTo(76.0f, 47.0f);
                h.lineTo(72.0f, 47.0f);
                h.lineTo(72.0f, 35.0f);
                h.lineTo(76.0f, 35.0f);
                h.lineTo(76.0f, 39.0f);
                h.close();
                h.moveTo(68.0f, 39.0f);
                h.lineTo(28.0f, 39.0f);
                h.lineTo(28.0f, 43.0f);
                h.lineTo(68.0f, 43.0f);
                h.lineTo(68.0f, 39.0f);
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
