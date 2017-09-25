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

public final class ahe extends c {
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
                g2 = c.a(g2, looper);
                g2.setStrokeWidth(1.0f);
                Paint a = c.a(g, looper);
                Paint a2 = c.a(g2, looper);
                a.setColor(-8092540);
                a2.setColor(-8092540);
                a2.setStrokeWidth(0.6086956f);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 36.0f, 0.0f, 1.0f, 55.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                g = c.a(a, looper);
                g2 = c.a(a2, looper);
                Path h = c.h(looper);
                h.moveTo(32.162163f, 34.0f);
                h.lineTo(34.0f, 32.162163f);
                h.lineTo(1.8378378f, 0.0f);
                h.lineTo(0.0f, 1.8378378f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 1);
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g);
                canvas.drawPath(h, g2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                a2 = c.a(a2, looper);
                c = c.a(c, -1.0f, 0.0f, 34.0f, 0.0f, 1.0f, 0.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                Path h2 = c.h(looper);
                h2.moveTo(32.162163f, 34.0f);
                h2.lineTo(34.0f, 32.162163f);
                h2.lineTo(1.8378378f, 0.0f);
                h2.lineTo(0.0f, 1.8378378f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 1);
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a);
                canvas.drawPath(h2, a2);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
