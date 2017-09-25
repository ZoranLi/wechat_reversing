package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
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

public final class ol extends c {
    private final int height = h.CTRL_INDEX;
    private final int width = 285;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 285;
            case 1:
                return h.CTRL_INDEX;
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
                canvas.saveLayerAlpha(null, 25, 4);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(228.0f, 94.73752f);
                h.lineTo(228.0f, 12.0f);
                h.lineTo(12.0f, 12.0f);
                h.lineTo(12.0f, 119.51874f);
                h.lineTo(80.73831f, 55.335876f);
                h.lineTo(162.56027f, 130.40851f);
                h.lineTo(150.84477f, 106.321465f);
                h.lineTo(184.2155f, 80.51195f);
                h.lineTo(206.87204f, 100.85361f);
                h.cubicTo(187.48631f, 110.75349f, 174.0f, 131.23582f, 174.0f, 155.24074f);
                h.cubicTo(174.0f, 166.45111f, 177.2164f, 176.99875f, 182.76556f, 186.00002f);
                h.lineTo(5.9924946f, 186.0f);
                h.cubicTo(2.6953125f, 186.0f, 0.0f, 183.3119f, 0.0f, 179.99596f);
                h.lineTo(0.0f, 6.004041f);
                h.cubicTo(0.0f, 2.6830428f, 2.6829312f, 1.364242E-12f, 5.9924946f, 1.364242E-12f);
                h.lineTo(234.0075f, 1.364242E-12f);
                h.cubicTo(237.30469f, 1.364242E-12f, 240.0f, 2.6881008f, 240.0f, 6.004041f);
                h.lineTo(240.0f, 94.85917f);
                h.cubicTo(237.78893f, 94.62174f, 235.54f, 94.5f, 233.25926f, 94.5f);
                h.cubicTo(231.48848f, 94.5f, 229.73422f, 94.58025f, 228.0f, 94.73752f);
                h.lineTo(228.0f, 94.73752f);
                h.close();
                h.moveTo(283.0f, 155.11111f);
                h.cubicTo(283.0f, 127.16133f, 260.83865f, 105.0f, 232.88889f, 105.0f);
                h.cubicTo(206.16133f, 105.0f, 184.0f, 127.16133f, 184.0f, 155.11111f);
                h.cubicTo(184.0f, 181.83867f, 206.16133f, 204.0f, 232.88889f, 204.0f);
                h.cubicTo(260.83865f, 204.0f, 283.0f, 181.83867f, 283.0f, 155.11111f);
                h.close();
                h.moveTo(233.5f, 178.58653f);
                h.cubicTo(235.98528f, 178.58653f, 238.0f, 176.55244f, 238.0f, 174.04327f);
                h.cubicTo(238.0f, 171.53409f, 235.98528f, 169.5f, 233.5f, 169.5f);
                h.cubicTo(231.01472f, 169.5f, 229.0f, 171.53409f, 229.0f, 174.04327f);
                h.cubicTo(229.0f, 176.55244f, 231.01472f, 178.58653f, 233.5f, 178.58653f);
                h.close();
                h.moveTo(230.34857f, 129.0f);
                h.cubicTo(229.52448f, 129.0f, 228.88528f, 129.6712f, 228.92096f, 130.50104f);
                h.lineTo(230.32753f, 163.21475f);
                h.cubicTo(230.36992f, 164.20071f, 231.20103f, 165.0f, 232.19511f, 165.0f);
                h.lineTo(234.80493f, 165.0f);
                h.cubicTo(235.79398f, 165.0f, 236.63025f, 164.19762f, 236.67252f, 163.21475f);
                h.lineTo(238.07909f, 130.50104f);
                h.cubicTo(238.11473f, 129.67204f, 237.47571f, 129.0f, 236.65147f, 129.0f);
                h.lineTo(230.34857f, 129.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
