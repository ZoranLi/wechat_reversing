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

public final class gq extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                g.setColor(-8617851);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(41.0f, 65.0f);
                h.cubicTo(28.297495f, 65.0f, 18.0f, 54.702503f, 18.0f, 42.0f);
                h.cubicTo(18.0f, 29.297495f, 28.297495f, 19.0f, 41.0f, 19.0f);
                h.cubicTo(53.702503f, 19.0f, 64.0f, 29.297495f, 64.0f, 42.0f);
                h.cubicTo(64.0f, 54.702503f, 53.702503f, 65.0f, 41.0f, 65.0f);
                h.lineTo(41.0f, 65.0f);
                h.close();
                h.moveTo(85.0f, 78.0f);
                h.lineTo(66.0f, 61.0f);
                h.cubicTo(70.123146f, 55.956898f, 72.5f, 49.400074f, 73.0f, 42.0f);
                h.cubicTo(72.5f, 25.006767f, 58.508797f, 11.0f, 41.0f, 11.0f);
                h.cubicTo(23.991203f, 11.0f, 10.0f, 25.006767f, 10.0f, 42.0f);
                h.cubicTo(10.0f, 59.562756f, 23.991203f, 73.56952f, 41.0f, 74.0f);
                h.cubicTo(48.358334f, 73.56952f, 54.908794f, 71.18956f, 60.0f, 67.0f);
                h.lineTo(77.0f, 86.0f);
                h.lineTo(85.0f, 78.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
