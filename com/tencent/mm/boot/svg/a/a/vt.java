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

public final class vt extends c {
    private final int height = 46;
    private final int width = 46;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 46;
            case 1:
                return 46;
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
                canvas.saveLayerAlpha(null, 64, 4);
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-1);
                c = c.a(c, 1.0f, 0.0f, -996.0f, 0.0f, 1.0f, -265.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, -1.0f, 0.0f, 1.0f, 216.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                a = c.a(a, looper);
                c = c.a(c, 0.70710677f, -0.70710677f, 350.08917f, 0.70710677f, 0.70710677f, -700.3372f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                Path h = c.h(looper);
                h.moveTo(1018.4283f, 70.42826f);
                h.lineTo(990.4264f, 70.42826f);
                h.lineTo(990.4264f, 74.42455f);
                h.lineTo(1018.4283f, 74.42455f);
                h.lineTo(1018.4283f, 102.42641f);
                h.lineTo(1022.42456f, 102.42641f);
                h.lineTo(1022.42456f, 74.42455f);
                h.lineTo(1050.4264f, 74.42455f);
                h.lineTo(1050.4264f, 70.42826f);
                h.lineTo(1022.42456f, 70.42826f);
                h.lineTo(1022.42456f, 42.426407f);
                h.lineTo(1018.4283f, 42.426407f);
                h.lineTo(1018.4283f, 70.42826f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
