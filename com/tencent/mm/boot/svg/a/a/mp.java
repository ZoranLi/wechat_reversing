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

public final class mp extends c {
    private final int height = 63;
    private final int width = 63;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 63;
            case 1:
                return 63;
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
                g.setColor(-1);
                canvas.save();
                Paint a = c.a(g, looper);
                c = c.a(c, 0.70710677f, -0.70710677f, 31.39409f, 0.70710677f, 0.70710677f, -12.125177f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                Path h = c.h(looper);
                h.moveTo(25.405478f, 12.6148405f);
                h.lineTo(25.645857f, 54.121506f);
                h.lineTo(30.480642f, 63.385418f);
                h.lineTo(35.31543f, 54.121506f);
                h.lineTo(35.21498f, 12.6148405f);
                h.lineTo(25.405478f, 12.6148405f);
                h.close();
                h.moveTo(25.389639f, 9.879872f);
                h.lineTo(25.351372f, 3.272119f);
                h.cubicTo(25.341805f, 1.6204139f, 26.683146f, 0.28144225f, 28.343227f, 0.28144225f);
                h.lineTo(32.175957f, 0.28144225f);
                h.cubicTo(33.83788f, 0.28144225f, 35.188385f, 1.6257602f, 35.19237f, 3.272119f);
                h.lineTo(35.208363f, 9.879872f);
                h.lineTo(25.389639f, 9.879872f);
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
