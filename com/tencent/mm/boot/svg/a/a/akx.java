package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class akx extends c {
    private final int height = 12;
    private final int width = 22;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 22;
            case 1:
                return 12;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix d = c.d(looper);
                float[] c = c.c(looper);
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
                g = c.a(g2, looper);
                g.setStrokeWidth(1.0f);
                g.setStrokeCap(Cap.ROUND);
                g.setStrokeJoin(Join.MITER);
                g = c.a(g, looper);
                g.setColor(-2697514);
                g.setStrokeWidth(4.0f);
                canvas.save();
                Paint a = c.a(g, looper);
                c = c.a(c, 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 12.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                Path h = c.h(looper);
                h.moveTo(2.0f, 2.0f);
                h.lineTo(10.705484f, 10.0f);
                h.lineTo(20.0f, 2.0f);
                WeChatSVGRenderC2Java.setFillType(h, 1);
                canvas.drawPath(h, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
