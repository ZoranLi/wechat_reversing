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

public final class va extends c {
    private final int height = 138;
    private final int width = 138;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 138;
            case 1:
                return 138;
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
                g2 = c.a(g2, looper);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(138.0f, 0.0f);
                h.lineTo(138.0f, 138.0f);
                h.lineTo(0.0f, 138.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                canvas.drawPath(h, g2);
                canvas.restore();
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-1);
                Path h2 = c.h(looper);
                h2.moveTo(50.543278f, 90.04454f);
                h2.lineTo(53.041294f, 91.67629f);
                h2.cubicTo(57.280224f, 94.44525f, 62.87948f, 95.92082f, 69.52f, 95.92082f);
                h2.cubicTo(87.80456f, 95.92082f, 102.0f, 83.83496f, 102.0f, 68.50467f);
                h2.cubicTo(102.0f, 52.329258f, 87.46037f, 39.0f, 69.52f, 39.0f);
                h2.cubicTo(50.67776f, 39.0f, 36.0f, 52.210297f, 36.0f, 68.50467f);
                h2.cubicTo(36.0f, 73.42558f, 37.42558f, 77.22104f, 41.231678f, 82.927864f);
                h2.lineTo(42.85777f, 85.36601f);
                h2.lineTo(40.05615f, 93.80527f);
                h2.lineTo(50.543278f, 90.04454f);
                h2.close();
                h2.moveTo(35.2f, 101.92082f);
                h2.cubicTo(32.567047f, 102.34957f, 31.283272f, 100.9991f, 32.08f, 98.78806f);
                h2.lineTo(36.24f, 86.257f);
                h2.cubicTo(32.320972f, 80.380844f, 30.0f, 75.34051f, 30.0f, 68.50467f);
                h2.cubicTo(30.0f, 48.779522f, 47.46108f, 33.0f, 69.52f, 33.0f);
                h2.cubicTo(90.53892f, 33.0f, 108.0f, 48.779522f, 108.0f, 68.50467f);
                h2.cubicTo(108.0f, 87.70929f, 90.53892f, 101.92082f, 69.52f, 101.92082f);
                h2.cubicTo(61.798603f, 101.92082f, 55.05305f, 100.15708f, 49.76f, 96.69955f);
                h2.lineTo(35.2f, 101.92082f);
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
