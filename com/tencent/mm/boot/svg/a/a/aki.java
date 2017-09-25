package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.k;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class aki extends c {
    private final int height = k.CTRL_BYTE;
    private final int width = k.CTRL_BYTE;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return k.CTRL_BYTE;
            case 1:
                return k.CTRL_BYTE;
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
                g2 = c.a(g, looper);
                g2.setColor(-13917627);
                canvas.save();
                Paint a = c.a(g2, looper);
                Path h = c.h(looper);
                h.moveTo(94.5f, 0.45215607f);
                h.cubicTo(146.4412f, 0.45215607f, 188.54785f, 42.558807f, 188.54785f, 94.5f);
                h.cubicTo(188.54785f, 146.4412f, 146.4412f, 188.54785f, 94.5f, 188.54785f);
                h.cubicTo(42.558807f, 188.54785f, 0.45215607f, 146.4412f, 0.45215607f, 94.5f);
                h.cubicTo(0.45215607f, 42.558807f, 42.558807f, 0.45215607f, 94.5f, 0.45215607f);
                h.close();
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-1);
                h = c.h(looper);
                h.moveTo(73.00249f, 72.605316f);
                h.lineTo(67.42785f, 69.406975f);
                h.lineTo(64.84446f, 73.8535f);
                h.cubicTo(56.051033f, 88.9887f, 59.218388f, 107.78604f, 71.60051f, 118.51587f);
                h.lineTo(65.47644f, 129.0566f);
                h.lineTo(76.6257f, 135.45328f);
                h.lineTo(82.74977f, 124.91256f);
                h.lineTo(82.74977f, 124.91256f);
                h.cubicTo(98.29174f, 130.20367f, 116.257065f, 123.530815f, 125.05048f, 108.395615f);
                h.lineTo(127.63388f, 103.94909f);
                h.lineTo(122.05925f, 100.75075f);
                h.lineTo(119.47585f, 105.19727f);
                h.cubicTo(111.18062f, 119.475f, 93.6396f, 124.46423f, 80.63803f, 117.004814f);
                h.cubicTo(66.5463f, 108.919945f, 62.12385f, 91.32957f, 70.41909f, 77.05184f);
                h.lineTo(73.00249f, 72.605316f);
                h.lineTo(73.00249f, 72.605316f);
                h.lineTo(73.00249f, 72.605316f);
                h.close();
                h.moveTo(118.84387f, 49.994183f);
                h.cubicTo(108.99176f, 44.341713f, 96.38864f, 47.70522f, 90.71172f, 57.476303f);
                h.lineTo(77.0684f, 80.95914f);
                h.cubicTo(71.383545f, 90.74387f, 74.75962f, 103.25695f, 84.61389f, 108.91067f);
                h.cubicTo(94.466f, 114.56313f, 107.06912f, 111.19963f, 112.74604f, 101.42854f);
                h.lineTo(126.38937f, 77.94571f);
                h.cubicTo(132.07422f, 68.16097f, 128.69815f, 55.647892f, 118.84387f, 49.994183f);
                h.lineTo(118.84387f, 49.994183f);
                h.close();
                h.moveTo(64.33125f, 132.80655f);
                h.cubicTo(64.250336f, 131.96338f, 64.78417f, 131.62376f, 65.5296f, 132.05144f);
                h.lineTo(73.98914f, 136.90495f);
                h.cubicTo(74.731895f, 137.33109f, 74.702484f, 137.96323f, 73.93026f, 138.3138f);
                h.lineTo(66.64218f, 141.62236f);
                h.cubicTo(65.86691f, 141.9743f, 65.17252f, 141.57278f, 65.09193f, 140.73293f);
                h.lineTo(64.33125f, 132.80655f);
                h.lineTo(64.33125f, 132.80655f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
