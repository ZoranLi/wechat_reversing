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

public final class la extends c {
    private final int height = f.CTRL_INDEX;
    private final int width = f.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return f.CTRL_INDEX;
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
                g2 = c.a(g, looper);
                g2.setColor(-14187817);
                canvas.save();
                g2 = c.a(g2, looper);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(144.0f, 0.0f);
                h.lineTo(144.0f, 144.0f);
                h.lineTo(0.0f, 144.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                canvas.drawPath(h, g2);
                canvas.restore();
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-1);
                Path h2 = c.h(looper);
                h2.moveTo(61.621193f, 73.14729f);
                h2.cubicTo(66.18872f, 80.1801f, 59.140778f, 83.23341f, 55.739967f, 85.172226f);
                h2.cubicTo(43.53354f, 92.134026f, 38.0f, 94.832306f, 38.0f, 98.453674f);
                h2.lineTo(38.0f, 102.981674f);
                h2.cubicTo(38.0f, 104.6663f, 39.151512f, 106.0f, 40.95683f, 106.0f);
                h2.lineTo(103.04317f, 106.0f);
                h2.cubicTo(104.84849f, 106.0f, 106.0f, 104.6663f, 106.0f, 102.981674f);
                h2.lineTo(106.0f, 98.453674f);
                h2.cubicTo(106.0f, 94.832306f, 100.46646f, 92.134026f, 88.26003f, 85.172226f);
                h2.cubicTo(84.85922f, 83.23341f, 77.81128f, 80.1801f, 82.37881f, 73.14729f);
                h2.cubicTo(85.82625f, 67.83821f, 88.767876f, 65.55775f, 88.767876f, 56.603626f);
                h2.cubicTo(88.767876f, 47.310932f, 82.19635f, 38.0f, 72.0f, 38.0f);
                h2.cubicTo(61.80365f, 38.0f, 55.23213f, 47.310932f, 55.23213f, 56.603626f);
                h2.cubicTo(55.23213f, 65.55775f, 58.17375f, 67.83821f, 61.621193f, 73.14729f);
                h2.close();
                h2.moveTo(66.0f, 97.856636f);
                h2.lineTo(71.5f, 105.0f);
                h2.lineTo(77.0f, 97.856636f);
                h2.lineTo(71.5f, 80.0f);
                h2.lineTo(66.0f, 97.856636f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a);
                canvas.restore();
                g2 = c.a(g, looper);
                g2.setColor(-16608256);
                canvas.save();
                g2 = c.a(g2, looper);
                h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(144.0f, 0.0f);
                h.lineTo(144.0f, 144.0f);
                h.lineTo(0.0f, 144.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                canvas.drawPath(h, g2);
                canvas.restore();
                g = c.a(g, looper);
                g.setColor(-328966);
                canvas.save();
                float[] a2 = c.a(c, 1.0f, 0.0f, 31.0f, 0.0f, 1.0f, 39.0f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                canvas.save();
                Paint a3 = c.a(g, looper);
                h2 = c.h(looper);
                h2.moveTo(32.0f, 44.0f);
                h2.lineTo(32.0f, 53.677307f);
                h2.cubicTo(32.0f, 56.064663f, 33.92523f, 58.0f, 36.31028f, 58.0f);
                h2.lineTo(61.0f, 58.0f);
                h2.lineTo(69.31494f, 64.651955f);
                h2.cubicTo(70.245575f, 65.39646f, 71.0f, 65.03501f, 71.0f, 63.835083f);
                h2.lineTo(71.0f, 58.0f);
                h2.lineTo(77.68408f, 58.0f);
                h2.cubicTo(80.067696f, 58.0f, 82.0f, 56.065983f, 82.0f, 53.677307f);
                h2.lineTo(82.0f, 23.322693f);
                h2.cubicTo(82.0f, 20.935335f, 80.07058f, 19.0f, 77.67205f, 19.0f);
                h2.lineTo(57.0f, 19.0f);
                h2.lineTo(57.0f, 39.672432f);
                h2.cubicTo(57.0f, 42.06248f, 55.062813f, 44.0f, 52.683216f, 44.0f);
                h2.lineTo(32.0f, 44.0f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(g, looper);
                h2 = c.h(looper);
                h2.moveTo(49.672234f, 0.0f);
                h2.cubicTo(52.062393f, 0.0f, 54.0f, 1.9362065f, 54.0f, 4.3102264f);
                h2.lineTo(54.0f, 36.689774f);
                h2.cubicTo(54.0f, 39.070248f, 52.06081f, 41.0f, 49.689583f, 41.0f);
                h2.lineTo(23.0f, 41.0f);
                h2.lineTo(13.670663f, 48.633095f);
                h2.cubicTo(12.747981f, 49.388016f, 12.0f, 49.036842f, 12.0f, 47.844276f);
                h2.lineTo(12.0f, 41.0f);
                h2.lineTo(4.315322f, 41.0f);
                h2.cubicTo(1.9320353f, 41.0f, 0.0f, 39.063793f, 0.0f, 36.689774f);
                h2.lineTo(0.0f, 4.3102264f);
                h2.cubicTo(0.0f, 1.929754f, 1.9378097f, 0.0f, 4.327765f, 0.0f);
                h2.lineTo(49.672234f, 0.0f);
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
