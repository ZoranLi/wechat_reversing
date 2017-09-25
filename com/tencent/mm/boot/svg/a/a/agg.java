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

public final class agg extends c {
    private final int height = 186;
    private final int width = 186;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 186;
            case 1:
                return 186;
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
                g.setColor(-5065805);
                canvas.save();
                g2 = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(186.0f, 0.0f);
                h.lineTo(186.0f, 186.0f);
                h.lineTo(0.0f, 186.0f);
                h.lineTo(0.0f, 0.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                h.moveTo(3.0f, 3.0f);
                h.lineTo(3.0f, 183.0f);
                h.lineTo(183.0f, 183.0f);
                h.lineTo(183.0f, 3.0f);
                h.lineTo(3.0f, 3.0f);
                h.lineTo(3.0f, 3.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g2);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                Path h2 = c.h(looper);
                h2.moveTo(90.0f, 33.0f);
                h2.lineTo(96.0f, 33.0f);
                h2.lineTo(96.0f, 90.0f);
                h2.lineTo(153.0f, 90.0f);
                h2.lineTo(153.0f, 96.0f);
                h2.lineTo(96.0f, 96.0f);
                h2.lineTo(96.0f, 153.0f);
                h2.lineTo(90.0f, 153.0f);
                h2.lineTo(90.0f, 96.0f);
                h2.lineTo(33.0f, 96.0f);
                h2.lineTo(33.0f, 90.0f);
                h2.lineTo(90.0f, 90.0f);
                h2.lineTo(90.0f, 33.0f);
                h2.lineTo(90.0f, 33.0f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, g);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
