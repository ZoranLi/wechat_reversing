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

public final class zt extends c {
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
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-12206054);
                c = c.a(c, 1.0f, 0.0f, 17.0f, 0.0f, 1.0f, 20.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(30.9995f, 0.0f);
                h.cubicTo(13.878777f, 0.0f, 0.0f, 11.798211f, 0.0f, 26.35247f);
                h.cubicTo(0.0f, 33.18859f, 3.0619507f, 39.415703f, 8.08287f, 44.09879f);
                h.cubicTo(6.80389f, 48.17186f, 4.4279284f, 56.0f, 4.4279284f, 56.0f);
                h.lineTo(17.250721f, 49.972893f);
                h.cubicTo(21.394655f, 51.719925f, 26.06058f, 52.70594f, 31.0005f, 52.70594f);
                h.cubicTo(48.121223f, 52.70594f, 62.0f, 40.90773f, 62.0f, 26.35147f);
                h.cubicTo(61.999f, 11.798211f, 48.120224f, 0.0f, 30.9995f, 0.0f);
                h.lineTo(30.9995f, 0.0f);
                h.lineTo(30.9995f, 0.0f);
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
