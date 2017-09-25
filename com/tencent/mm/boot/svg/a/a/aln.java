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

public final class aln extends c {
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
                g = c.a(g2, looper);
                g.setStrokeWidth(1.0f);
                g.setStrokeCap(Cap.ROUND);
                g.setStrokeJoin(Join.MITER);
                g = c.a(g, looper);
                g.setColor(-9473160);
                g.setStrokeWidth(3.139535f);
                canvas.save();
                Paint a = c.a(g, looper);
                c = c.a(c, 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 90.25581f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                Path h = c.h(looper);
                h.moveTo(21.0f, 59.255814f);
                h.lineTo(45.069767f, 31.0f);
                h.lineTo(69.139534f, 59.255814f);
                WeChatSVGRenderC2Java.setFillType(h, 1);
                canvas.drawPath(h, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
