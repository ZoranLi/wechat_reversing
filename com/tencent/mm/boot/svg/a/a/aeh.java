package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
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

public final class aeh extends c {
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
                canvas.save();
                g2 = c.a(g, looper);
                g2.setColor(-1710619);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(144.0f, 0.0f);
                h.lineTo(144.0f, 146.0f);
                h.lineTo(0.0f, 146.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                canvas.drawPath(h, g2);
                canvas.restore();
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                Path h2 = c.h(looper);
                h2.moveTo(67.462845f, 72.00018f);
                h2.lineTo(49.3112f, 53.848534f);
                h2.cubicTo(48.899487f, 53.43682f, 48.89414f, 52.760975f, 49.30799f, 52.347126f);
                h2.lineTo(52.346096f, 49.30795f);
                h2.cubicTo(52.7546f, 48.899445f, 53.432587f, 48.896236f, 53.848576f, 49.312225f);
                h2.lineTo(72.00022f, 67.46281f);
                h2.lineTo(90.1508f, 49.312225f);
                h2.cubicTo(90.56358f, 48.899445f, 91.239426f, 48.89517f, 91.65435f, 49.30795f);
                h2.lineTo(94.69138f, 52.347126f);
                h2.cubicTo(95.09989f, 52.75456f, 95.104164f, 53.433613f, 94.68818f, 53.848534f);
                h2.lineTo(76.53653f, 72.00018f);
                h2.lineTo(94.68818f, 90.151825f);
                h2.cubicTo(95.09989f, 90.56354f, 95.10523f, 91.23939f, 94.69138f, 91.654305f);
                h2.lineTo(91.65435f, 94.69241f);
                h2.cubicTo(91.244774f, 95.100914f, 90.56679f, 95.104126f, 90.1508f, 94.68921f);
                h2.lineTo(72.00022f, 76.53649f);
                h2.lineTo(53.848576f, 94.68921f);
                h2.cubicTo(53.436863f, 95.100914f, 52.759945f, 95.105194f, 52.346096f, 94.69241f);
                h2.lineTo(49.30799f, 91.654305f);
                h2.cubicTo(48.899487f, 91.244736f, 48.89628f, 90.56675f, 49.3112f, 90.151825f);
                h2.lineTo(67.462845f, 72.00018f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
