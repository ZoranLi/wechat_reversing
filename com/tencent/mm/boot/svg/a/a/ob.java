package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.map.b;
import com.tencent.mm.plugin.appbrand.jsapi.map.i;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class ob extends c {
    private final int height = i.CTRL_INDEX;
    private final int width = b.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return b.CTRL_INDEX;
            case 1:
                return i.CTRL_INDEX;
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
                Paint a = c.a(g2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-13917627);
                a2.setStrokeWidth(5.0f);
                Path h = c.h(looper);
                h.moveTo(31.0099f, 39.0f);
                h.cubicTo(29.347578f, 39.0f, 28.0f, 40.348312f, 28.0f, 41.996197f);
                h.lineTo(28.0f, 94.0038f);
                h.cubicTo(28.0f, 95.658554f, 29.34304f, 97.0f, 31.009615f, 97.0f);
                h.lineTo(92.99039f, 97.0f);
                h.cubicTo(94.65255f, 97.0f, 96.0f, 95.66286f, 96.0f, 94.00549f);
                h.lineTo(96.0f, 82.128204f);
                h.cubicTo(96.0f, 73.74312f, 106.0f, 68.32172f, 106.0f, 64.28205f);
                h.cubicTo(106.0f, 59.21164f, 106.0f, 42.009247f, 106.0f, 42.009247f);
                h.cubicTo(106.0f, 40.347286f, 104.662575f, 39.0f, 102.990105f, 39.0f);
                h.lineTo(31.0099f, 39.0f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(g, looper);
                a3.setColor(-13917627);
                Path h2 = c.h(looper);
                h2.moveTo(37.0f, 48.0f);
                h2.lineTo(37.0f, 54.0f);
                h2.lineTo(45.0f, 54.0f);
                h2.lineTo(45.0f, 48.0f);
                h2.lineTo(37.0f, 48.0f);
                h2.close();
                h2.moveTo(49.0f, 48.0f);
                h2.lineTo(49.0f, 54.0f);
                h2.lineTo(57.0f, 54.0f);
                h2.lineTo(57.0f, 48.0f);
                h2.lineTo(49.0f, 48.0f);
                h2.close();
                h2.moveTo(61.0f, 48.0f);
                h2.lineTo(61.0f, 54.0f);
                h2.lineTo(69.0f, 54.0f);
                h2.lineTo(69.0f, 48.0f);
                h2.lineTo(61.0f, 48.0f);
                h2.close();
                h2.moveTo(73.0f, 48.0f);
                h2.lineTo(73.0f, 54.0f);
                h2.lineTo(81.0f, 54.0f);
                h2.lineTo(81.0f, 48.0f);
                h2.lineTo(73.0f, 48.0f);
                h2.close();
                h2.moveTo(85.0f, 48.0f);
                h2.lineTo(85.0f, 54.0f);
                h2.lineTo(93.0f, 54.0f);
                h2.lineTo(93.0f, 48.0f);
                h2.lineTo(85.0f, 48.0f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(g, looper);
                a3.setColor(-13917627);
                h2 = c.h(looper);
                h2.moveTo(37.0f, 82.0f);
                h2.lineTo(37.0f, 88.0f);
                h2.lineTo(45.0f, 88.0f);
                h2.lineTo(45.0f, 82.0f);
                h2.lineTo(37.0f, 82.0f);
                h2.close();
                h2.moveTo(49.0f, 82.0f);
                h2.lineTo(49.0f, 88.0f);
                h2.lineTo(57.0f, 88.0f);
                h2.lineTo(57.0f, 82.0f);
                h2.lineTo(49.0f, 82.0f);
                h2.close();
                h2.moveTo(61.0f, 82.0f);
                h2.lineTo(61.0f, 88.0f);
                h2.lineTo(69.0f, 88.0f);
                h2.lineTo(69.0f, 82.0f);
                h2.lineTo(61.0f, 82.0f);
                h2.close();
                h2.moveTo(73.0f, 82.0f);
                h2.lineTo(73.0f, 88.0f);
                h2.lineTo(81.0f, 88.0f);
                h2.lineTo(81.0f, 82.0f);
                h2.lineTo(73.0f, 82.0f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a3);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
