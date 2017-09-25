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

public final class alw extends c {
    private final int height = 265;
    private final int width = 222;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 222;
            case 1:
                return 265;
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
                canvas.saveLayerAlpha(null, 25, 4);
                Paint a = c.a(g, looper);
                a.setColor(-1);
                canvas.save();
                c = c.a(c, 0.6293204f, -0.777146f, 114.51628f, 0.777146f, 0.6293204f, 1.1047013f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(129.8682f, 161.8563f);
                h.lineTo(40.530926f, 161.8563f);
                h.cubicTo(26.720047f, 141.8038f, 1.1368684E-12f, 120.81583f, 1.1368684E-12f, 86.32336f);
                h.cubicTo(1.1368684E-12f, 38.648285f, 38.14514f, -1.409827E-12f, 85.199554f, -1.3926638E-12f);
                h.cubicTo(132.25397f, -1.3902678E-12f, 170.39911f, 38.648285f, 170.39911f, 86.32336f);
                h.cubicTo(170.39911f, 120.81583f, 143.67906f, 141.8038f, 129.8682f, 161.8563f);
                h.close();
                h.moveTo(55.37971f, 173.21463f);
                h.lineTo(115.0194f, 173.21463f);
                h.cubicTo(117.37212f, 173.21463f, 119.27938f, 175.12161f, 119.27938f, 177.47401f);
                h.lineTo(119.27938f, 180.3136f);
                h.cubicTo(119.27938f, 182.66599f, 117.37212f, 184.57297f, 115.0194f, 184.57297f);
                h.lineTo(55.37971f, 184.57297f);
                h.cubicTo(53.026993f, 184.57297f, 51.11973f, 182.66599f, 51.11973f, 180.3136f);
                h.lineTo(51.11973f, 177.47401f);
                h.cubicTo(51.11973f, 175.12161f, 53.026993f, 173.21463f, 55.37971f, 173.21463f);
                h.close();
                h.moveTo(63.899666f, 195.9313f);
                h.lineTo(106.49944f, 195.9313f);
                h.cubicTo(108.852165f, 195.9313f, 110.75942f, 197.83829f, 110.75942f, 200.19069f);
                h.lineTo(110.75942f, 203.03027f);
                h.cubicTo(110.75942f, 205.38266f, 108.852165f, 207.28964f, 106.49944f, 207.28964f);
                h.lineTo(63.899666f, 207.28964f);
                h.cubicTo(61.546947f, 207.28964f, 59.63969f, 205.38266f, 59.63969f, 203.03027f);
                h.lineTo(59.63969f, 200.19069f);
                h.cubicTo(59.63969f, 197.83829f, 61.546947f, 195.9313f, 63.899666f, 195.9313f);
                h.close();
                h.moveTo(87.99253f, 105.08893f);
                h.cubicTo(90.35236f, 109.80792f, 97.08666f, 109.80792f, 99.446495f, 105.08893f);
                h.lineTo(110.75942f, 82.46626f);
                h.lineTo(122.07235f, 105.08893f);
                h.cubicTo(123.65404f, 108.25185f, 127.500305f, 109.5337f, 130.66322f, 107.95201f);
                h.cubicTo(133.82616f, 106.37032f, 135.108f, 102.524055f, 133.52632f, 99.36113f);
                h.lineTo(116.486404f, 65.286125f);
                h.cubicTo(114.12657f, 60.567127f, 107.39227f, 60.567127f, 105.03244f, 65.286125f);
                h.lineTo(93.71951f, 87.90878f);
                h.lineTo(82.406586f, 65.286125f);
                h.cubicTo(80.04675f, 60.567127f, 73.31245f, 60.567127f, 70.95262f, 65.286125f);
                h.lineTo(59.63969f, 87.90878f);
                h.lineTo(48.32676f, 65.286125f);
                h.cubicTo(46.745075f, 62.1232f, 42.898808f, 60.84135f, 39.73588f, 62.42304f);
                h.cubicTo(36.572956f, 64.00472f, 35.29111f, 67.85099f, 36.872795f, 71.013916f);
                h.lineTo(53.91271f, 105.08893f);
                h.cubicTo(56.272537f, 109.80792f, 63.00684f, 109.80792f, 65.36667f, 105.08893f);
                h.lineTo(76.6796f, 82.46626f);
                h.lineTo(87.99253f, 105.08893f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 1);
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
