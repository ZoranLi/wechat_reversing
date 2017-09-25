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

public final class db extends c {
    private final int height = 62;
    private final int width = 55;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 55;
            case 1:
                return 62;
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
                c.a(g2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-1);
                c = c.a(c, 1.0f, 0.0f, -377.0f, 0.0f, 1.0f, -393.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(377.0f, 449.61288f);
                h.cubicTo(377.0f, 453.58984f, 379.7965f, 455.20892f, 383.24622f, 453.2292f);
                h.lineTo(428.73413f, 427.1242f);
                h.cubicTo(432.1838f, 425.14447f, 432.1838f, 421.9347f, 428.73413f, 419.95496f);
                h.lineTo(383.24622f, 393.84995f);
                h.cubicTo(379.7965f, 391.87024f, 377.0f, 393.4976f, 377.0f, 397.46625f);
                h.lineTo(377.0f, 449.61288f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 1);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
