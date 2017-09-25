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
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

public final class ahp extends c {
    private final int height = 42;
    private final int width = 42;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 42;
            case 1:
                return 42;
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
                a.setColor(-4210753);
                a2.setColor(-4210753);
                a2.setStrokeWidth(DownloadHelper.SAVE_FATOR);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a3 = c.a(a, looper);
                Paint a4 = c.a(a2, looper);
                Path h = c.h(looper);
                h.moveTo(16.837944f, 33.589672f);
                h.cubicTo(7.7312255f, 33.589672f, 0.26877472f, 26.054348f, 0.26877472f, 16.858696f);
                h.cubicTo(0.26877472f, 7.6630435f, 7.7312255f, 0.12771739f, 16.837944f, 0.12771739f);
                h.cubicTo(25.944664f, 0.12771739f, 33.407116f, 7.6630435f, 33.407116f, 16.858696f);
                h.cubicTo(33.407116f, 26.182066f, 25.944664f, 33.589672f, 16.837944f, 33.589672f);
                h.close();
                h.moveTo(16.837944f, 1.4048913f);
                h.cubicTo(8.363636f, 1.4048913f, 1.5335969f, 8.30163f, 1.5335969f, 16.858696f);
                h.cubicTo(1.5335969f, 25.41576f, 8.363636f, 32.3125f, 16.837944f, 32.3125f);
                h.cubicTo(25.312254f, 32.3125f, 32.142292f, 25.41576f, 32.142292f, 16.858696f);
                h.cubicTo(32.142292f, 8.429348f, 25.18577f, 1.4048913f, 16.837944f, 1.4048913f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 1);
                canvas.drawPath(h, a3);
                canvas.drawPath(h, a4);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                a = c.a(a2, looper);
                h = c.h(looper);
                h.moveTo(39.35178f, 40.23098f);
                h.cubicTo(39.225296f, 40.23098f, 38.972332f, 40.23098f, 38.845848f, 40.10326f);
                h.lineTo(27.841898f, 28.991848f);
                h.cubicTo(27.588932f, 28.736412f, 27.588932f, 28.35326f, 27.841898f, 28.097826f);
                h.cubicTo(28.094862f, 27.842392f, 28.474308f, 27.842392f, 28.727272f, 28.097826f);
                h.lineTo(39.731224f, 39.20924f);
                h.cubicTo(39.984188f, 39.464672f, 39.984188f, 39.847828f, 39.731224f, 40.10326f);
                h.cubicTo(39.604744f, 40.23098f, 39.47826f, 40.23098f, 39.35178f, 40.23098f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 1);
                canvas.drawPath(h, a3);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
