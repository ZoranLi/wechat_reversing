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

public final class ly extends c {
    private final int height = 108;
    private final int width = 108;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 108;
            case 1:
                return 108;
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
                g2.setColor(-14187817);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(108.0f, 0.0f);
                h.lineTo(108.0f, 108.0f);
                h.lineTo(0.0f, 108.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 1);
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g2);
                canvas.restore();
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-1);
                Path h2 = c.h(looper);
                h2.moveTo(44.842228f, 55.012318f);
                h2.cubicTo(48.8724f, 61.21774f, 42.65363f, 63.91184f, 39.652912f, 65.62255f);
                h2.cubicTo(28.882536f, 71.76532f, 24.0f, 74.14615f, 24.0f, 77.34148f);
                h2.lineTo(24.0f, 81.33677f);
                h2.cubicTo(24.0f, 82.823204f, 25.016039f, 84.0f, 26.608969f, 84.0f);
                h2.lineTo(81.39103f, 84.0f);
                h2.cubicTo(82.98396f, 84.0f, 84.0f, 82.823204f, 84.0f, 81.33677f);
                h2.lineTo(84.0f, 77.34148f);
                h2.cubicTo(84.0f, 74.14615f, 79.11746f, 71.76532f, 68.347084f, 65.62255f);
                h2.cubicTo(65.346375f, 63.91184f, 59.1276f, 61.21774f, 63.157772f, 55.012318f);
                h2.cubicTo(66.19963f, 50.327835f, 68.79518f, 48.31566f, 68.79518f, 40.414963f);
                h2.cubicTo(68.79518f, 32.215527f, 62.99678f, 24.0f, 54.0f, 24.0f);
                h2.cubicTo(45.00322f, 24.0f, 39.20482f, 32.215527f, 39.20482f, 40.414963f);
                h2.cubicTo(39.20482f, 48.31566f, 41.80037f, 50.327835f, 44.842228f, 55.012318f);
                h2.close();
                h2.moveTo(49.0f, 76.71384f);
                h2.lineTo(54.0f, 83.0f);
                h2.lineTo(59.0f, 76.71384f);
                h2.lineTo(54.0f, 61.0f);
                h2.lineTo(49.0f, 76.71384f);
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
