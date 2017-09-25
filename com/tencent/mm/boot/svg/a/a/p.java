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

public final class p extends c {
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
                g.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(48.0f, 30.0f);
                h.cubicTo(45.238575f, 30.0f, 43.0f, 27.761423f, 43.0f, 25.0f);
                h.cubicTo(43.0f, 22.238577f, 45.238575f, 20.0f, 48.0f, 20.0f);
                h.cubicTo(50.761425f, 20.0f, 53.0f, 22.238577f, 53.0f, 25.0f);
                h.cubicTo(53.0f, 27.761423f, 50.761425f, 30.0f, 48.0f, 30.0f);
                h.close();
                h.moveTo(48.0f, 53.0f);
                h.cubicTo(45.238575f, 53.0f, 43.0f, 50.761425f, 43.0f, 48.0f);
                h.cubicTo(43.0f, 45.238575f, 45.238575f, 43.0f, 48.0f, 43.0f);
                h.cubicTo(50.761425f, 43.0f, 53.0f, 45.238575f, 53.0f, 48.0f);
                h.cubicTo(53.0f, 50.761425f, 50.761425f, 53.0f, 48.0f, 53.0f);
                h.close();
                h.moveTo(48.0f, 76.0f);
                h.cubicTo(45.238575f, 76.0f, 43.0f, 73.76142f, 43.0f, 71.0f);
                h.cubicTo(43.0f, 68.23858f, 45.238575f, 66.0f, 48.0f, 66.0f);
                h.cubicTo(50.761425f, 66.0f, 53.0f, 68.23858f, 53.0f, 71.0f);
                h.cubicTo(53.0f, 73.76142f, 50.761425f, 76.0f, 48.0f, 76.0f);
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
