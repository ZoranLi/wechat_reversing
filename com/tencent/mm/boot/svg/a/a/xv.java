package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class xv extends c {
    private final int height = h.CTRL_INDEX;
    private final int width = h.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return h.CTRL_INDEX;
            case 1:
                return h.CTRL_INDEX;
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
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, -335.0f, 0.0f, 1.0f, -284.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 335.0f, 0.0f, 1.0f, 284.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                Paint a = c.a(g, looper);
                a.setColor(-2565928);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(0.0f, 12.0f);
                h.cubicTo(0.0f, 5.3725824f, 5.3725824f, 0.0f, 12.0f, 0.0f);
                h.lineTo(198.0f, 0.0f);
                h.cubicTo(204.62741f, 0.0f, 210.0f, 5.3725824f, 210.0f, 12.0f);
                h.lineTo(210.0f, 198.0f);
                h.cubicTo(210.0f, 204.62741f, 204.62741f, 210.0f, 198.0f, 210.0f);
                h.lineTo(12.0f, 210.0f);
                h.cubicTo(5.3725824f, 210.0f, 0.0f, 204.62741f, 0.0f, 198.0f);
                h.lineTo(0.0f, 12.0f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(g, looper);
                a2.setColor(-1);
                h = c.h(looper);
                h.moveTo(157.64894f, 92.3088f);
                h.lineTo(144.74844f, 105.2093f);
                h.lineTo(138.95433f, 99.41519f);
                h.lineTo(151.85483f, 86.514694f);
                h.cubicTo(159.84056f, 78.52897f, 159.70537f, 65.69745f, 151.70346f, 57.695538f);
                h.cubicTo(143.70525f, 49.697327f, 130.86548f, 49.56299f, 122.88431f, 57.544167f);
                h.lineTo(97.083305f, 83.34517f);
                h.cubicTo(89.09758f, 91.33089f, 89.232765f, 104.162415f, 97.23468f, 112.16432f);
                h.lineTo(91.50112f, 117.89788f);
                h.cubicTo(80.298676f, 106.695435f, 80.20087f, 88.6394f, 91.2892f, 77.55106f);
                h.lineTo(117.0902f, 51.75006f);
                h.cubicTo(128.17189f, 40.668373f, 146.23703f, 40.761997f, 157.43701f, 51.961983f);
                h.cubicTo(168.63947f, 63.16443f, 168.73727f, 81.22047f, 157.64894f, 92.3088f);
                h.close();
                h.moveTo(51.753483f, 117.08678f);
                h.lineTo(64.653984f, 104.18628f);
                h.lineTo(70.44809f, 109.980385f);
                h.lineTo(57.54759f, 122.88088f);
                h.cubicTo(49.56187f, 130.86661f, 49.697052f, 143.69812f, 57.698963f, 151.70004f);
                h.cubicTo(65.697174f, 159.69824f, 78.53694f, 159.83258f, 86.51812f, 151.85141f);
                h.lineTo(112.31912f, 126.05041f);
                h.cubicTo(120.30484f, 118.06469f, 120.16966f, 105.23316f, 112.16775f, 97.231255f);
                h.lineTo(117.901306f, 91.497696f);
                h.cubicTo(129.10376f, 102.70014f, 129.20155f, 120.75618f, 118.11323f, 131.84451f);
                h.lineTo(92.312225f, 157.64552f);
                h.cubicTo(81.23054f, 168.7272f, 63.165394f, 168.63358f, 51.965405f, 157.4336f);
                h.cubicTo(40.76296f, 146.23114f, 40.665154f, 128.17511f, 51.753483f, 117.08678f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
