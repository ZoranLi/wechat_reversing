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

public final class or extends c {
    private final int height = 90;
    private final int width = 90;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                Paint a = c.a(g, looper);
                a.setColor(-13917627);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 9.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(60.0f, 69.37356f);
                h.cubicTo(60.0f, 70.83989f, 58.791004f, 72.0f, 57.29963f, 72.0f);
                h.lineTo(2.7003715f, 72.0f);
                h.cubicTo(1.2114124f, 72.0f, 0.0f, 70.824104f, 0.0f, 69.37356f);
                h.lineTo(0.0f, 2.6264412f);
                h.cubicTo(0.0f, 1.1601105f, 1.2089975f, 0.0f, 2.7003715f, 0.0f);
                h.lineTo(41.11628f, 0.0f);
                h.lineTo(60.0f, 18.327272f);
                h.lineTo(60.0f, 69.37356f);
                h.close();
                h.moveTo(42.0f, 6.0f);
                h.lineTo(56.0f, 19.0f);
                h.lineTo(42.0f, 19.0f);
                h.lineTo(42.0f, 6.0f);
                h.close();
                h.moveTo(9.0f, 38.0f);
                h.lineTo(33.0f, 38.0f);
                h.lineTo(33.0f, 41.0f);
                h.lineTo(9.0f, 41.0f);
                h.lineTo(9.0f, 38.0f);
                h.close();
                h.moveTo(9.0f, 47.0f);
                h.lineTo(51.0f, 47.0f);
                h.lineTo(51.0f, 50.0f);
                h.lineTo(9.0f, 50.0f);
                h.lineTo(9.0f, 47.0f);
                h.close();
                h.moveTo(9.0f, 56.0f);
                h.lineTo(51.0f, 56.0f);
                h.lineTo(51.0f, 59.0f);
                h.lineTo(9.0f, 59.0f);
                h.lineTo(9.0f, 56.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
