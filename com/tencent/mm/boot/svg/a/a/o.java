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

public final class o extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                g = c.a(g, looper);
                g.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint a = c.a(g, looper);
                c = c.a(c, 0.70710677f, -0.70710677f, 48.0f, 0.70710677f, 0.70710677f, -19.882248f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                Path h = c.h(looper);
                h.moveTo(46.0f, 46.0f);
                h.lineTo(18.0f, 46.0f);
                h.lineTo(18.0f, 50.0f);
                h.lineTo(46.0f, 50.0f);
                h.lineTo(46.0f, 78.0f);
                h.lineTo(50.0f, 78.0f);
                h.lineTo(50.0f, 50.0f);
                h.lineTo(78.0f, 50.0f);
                h.lineTo(78.0f, 46.0f);
                h.lineTo(50.0f, 46.0f);
                h.lineTo(50.0f, 18.0f);
                h.lineTo(46.0f, 18.0f);
                h.lineTo(46.0f, 46.0f);
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
