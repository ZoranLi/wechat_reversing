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

public final class alx extends c {
    private final int height = 696;
    private final int width = 540;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 540;
            case 1:
                return 696;
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
                canvas.saveLayerAlpha(null, 51, 4);
                Paint a = c.a(g, looper);
                a.setColor(-1);
                canvas.save();
                c = c.a(c, 0.70710677f, 0.70710677f, 0.10347748f, -0.70710677f, 0.70710677f, 314.05887f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                Paint a2 = c.a(a, looper);
                a2.setColor(-1);
                Path h = c.h(looper);
                h.moveTo(338.17682f, 421.62106f);
                h.lineTo(105.54254f, 421.62106f);
                h.cubicTo(69.57901f, 369.38614f, -1.5916157E-12f, 314.71432f, -1.5916157E-12f, 224.86458f);
                h.cubicTo(-1.5916157E-12f, 100.6753f, 99.32996f, 1.3195332E-12f, 221.85968f, 1.364242E-12f);
                h.cubicTo(344.3894f, 1.3704833E-12f, 443.71936f, 100.6753f, 443.71936f, 224.86458f);
                h.cubicTo(443.71936f, 314.71432f, 374.14035f, 369.38614f, 338.17682f, 421.62106f);
                h.close();
                h.moveTo(144.20879f, 451.20853f);
                h.lineTo(299.51056f, 451.20853f);
                h.cubicTo(305.63705f, 451.20853f, 310.60355f, 456.17606f, 310.60355f, 462.3038f);
                h.lineTo(310.60355f, 469.70065f);
                h.cubicTo(310.60355f, 475.82843f, 305.63705f, 480.79596f, 299.51056f, 480.79596f);
                h.lineTo(144.20879f, 480.79596f);
                h.cubicTo(138.0823f, 480.79596f, 133.11581f, 475.82843f, 133.11581f, 469.70065f);
                h.lineTo(133.11581f, 462.3038f);
                h.cubicTo(133.11581f, 456.17606f, 138.0823f, 451.20853f, 144.20879f, 451.20853f);
                h.close();
                h.moveTo(166.39476f, 510.3834f);
                h.lineTo(277.3246f, 510.3834f);
                h.cubicTo(283.45108f, 510.3834f, 288.41757f, 515.35095f, 288.41757f, 521.4787f);
                h.lineTo(288.41757f, 528.87555f);
                h.cubicTo(288.41757f, 535.0033f, 283.45108f, 539.9708f, 277.3246f, 539.9708f);
                h.lineTo(166.39476f, 539.9708f);
                h.cubicTo(160.26828f, 539.9708f, 155.30177f, 535.0033f, 155.30177f, 528.87555f);
                h.lineTo(155.30177f, 521.4787f);
                h.cubicTo(155.30177f, 515.35095f, 160.26828f, 510.3834f, 166.39476f, 510.3834f);
                h.close();
                h.moveTo(228.58931f, 274.01355f);
                h.cubicTo(234.95694f, 286.75146f, 253.13435f, 286.75146f, 259.50198f, 274.01355f);
                h.lineTo(288.41757f, 216.17035f);
                h.lineTo(317.33316f, 274.01355f);
                h.cubicTo(321.60043f, 282.54987f, 331.97977f, 286.0106f, 340.51608f, 281.74335f);
                h.cubicTo(349.0524f, 277.47607f, 352.51312f, 267.09674f, 348.24585f, 258.56042f);
                h.lineTo(303.87393f, 169.7981f);
                h.cubicTo(297.5063f, 157.06018f, 279.32886f, 157.06018f, 272.96124f, 169.7981f);
                h.lineTo(244.04565f, 227.64131f);
                h.lineTo(215.13005f, 169.7981f);
                h.cubicTo(208.76242f, 157.06018f, 190.58499f, 157.06018f, 184.21736f, 169.7981f);
                h.lineTo(155.30177f, 227.64131f);
                h.lineTo(126.386185f, 169.7981f);
                h.cubicTo(122.11892f, 161.2618f, 111.73958f, 157.80106f, 103.20328f, 162.06831f);
                h.cubicTo(94.66697f, 166.33559f, 91.20623f, 176.71492f, 95.473495f, 185.25122f);
                h.lineTo(139.84543f, 274.01355f);
                h.cubicTo(146.21306f, 286.75146f, 164.39049f, 286.75146f, 170.75812f, 274.01355f);
                h.lineTo(199.6737f, 216.17035f);
                h.lineTo(228.58931f, 274.01355f);
                h.close();
                canvas.saveLayerAlpha(null, 127, 4);
                g = c.a(a2, looper);
                WeChatSVGRenderC2Java.setFillType(h, 1);
                canvas.drawPath(h, g);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
