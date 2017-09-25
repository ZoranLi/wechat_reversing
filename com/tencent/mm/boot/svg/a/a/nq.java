package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class nq extends c {
    private final int height = 30;
    private final int width = 24;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 24;
            case 1:
                return 30;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.d(looper);
                c.c(looper);
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
                Path h = c.h(looper);
                h.moveTo(22.0f, 14.999688f);
                h.lineTo(7.130435f, 29.999374f);
                h.lineTo(3.826087f, 26.666111f);
                h.lineTo(15.391304f, 14.999688f);
                h.lineTo(3.0f, 3.3332639f);
                h.lineTo(6.304348f, 0.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 1);
                canvas.saveLayerAlpha(null, 51, 4);
                g = c.a(g, looper);
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g);
                canvas.restore();
                Path h2 = c.h(looper);
                h2.moveTo(0.0f, 0.0f);
                h2.lineTo(24.0f, 0.0f);
                h2.lineTo(24.0f, 30.0f);
                h2.lineTo(0.0f, 30.0f);
                h2.lineTo(0.0f, 0.0f);
                h2.close();
                c.f(looper);
                break;
        }
        return 0;
    }
}
