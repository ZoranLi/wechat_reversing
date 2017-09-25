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

public final class rn extends c {
    private final int height = 24;
    private final int width = 39;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 39;
            case 1:
                return 24;
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
                canvas.saveLayerAlpha(null, 198, 4);
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-9408138);
                c = c.a(c, 1.0f, 0.0f, -991.0f, 0.0f, 1.0f, -1857.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                a = c.a(a, looper);
                c = c.a(c, 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 3737.4177f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                Path h = c.h(looper);
                h.moveTo(991.0f, 1876.2609f);
                h.lineTo(1010.26086f, 1857.0f);
                h.lineTo(1030.0183f, 1876.7574f);
                h.lineTo(1026.3582f, 1880.4176f);
                h.lineTo(1010.26086f, 1864.3204f);
                h.lineTo(994.6602f, 1879.9211f);
                h.lineTo(991.0f, 1876.2609f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
