package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.map.f;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class ahr extends c {
    private final int height = f.CTRL_INDEX;
    private final int width = 111;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 111;
            case 1:
                return f.CTRL_INDEX;
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
                a.setColor(-8092540);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 38.0f, 0.0f, 1.0f, 56.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(2.6086957f, 0.0f);
                h.lineTo(2.6086957f, 31.296522f);
                h.lineTo(0.0f, 31.296522f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(31.304348f, 0.0f);
                h.lineTo(31.304348f, 2.6080434f);
                h.lineTo(0.0f, 2.6080434f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(2.6086957f, 4.5479107f);
                h.lineTo(29.363997f, 31.296522f);
                h.lineTo(31.304348f, 29.356655f);
                h.lineTo(4.549048f, 2.6080434f);
                h.lineTo(2.6086957f, 2.6080434f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 1);
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
