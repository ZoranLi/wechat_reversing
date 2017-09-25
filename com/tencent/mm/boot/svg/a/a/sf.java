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

public final class sf extends c {
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
                Paint a = c.a(g2, looper);
                a.setStrokeWidth(1.0f);
                Paint a2 = c.a(g, looper);
                a2.setColor(-8617594);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                Path h = c.h(looper);
                h.moveTo(96.0f, 48.0f);
                h.cubicTo(96.0f, 74.50967f, 74.50967f, 96.0f, 48.0f, 96.0f);
                h.cubicTo(21.490332f, 96.0f, 0.0f, 74.50967f, 0.0f, 48.0f);
                h.cubicTo(0.0f, 21.490332f, 21.490332f, 0.0f, 48.0f, 0.0f);
                h.cubicTo(74.50967f, 0.0f, 96.0f, 21.490332f, 96.0f, 48.0f);
                h.close();
                h.moveTo(2.2325583f, 48.0f);
                h.cubicTo(2.2325583f, 73.27666f, 22.72334f, 93.76744f, 48.0f, 93.76744f);
                h.cubicTo(73.27666f, 93.76744f, 93.76744f, 73.27666f, 93.76744f, 48.0f);
                h.cubicTo(93.76744f, 22.72334f, 73.27666f, 2.2325583f, 48.0f, 2.2325583f);
                h.cubicTo(22.72334f, 2.2325583f, 2.2325583f, 22.72334f, 2.2325583f, 48.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 1);
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.save();
                a2 = c.a(a2, looper);
                a = c.a(a, looper);
                a.setColor(-8617594);
                a.setStrokeWidth(2.0f);
                h = c.h(looper);
                h.moveTo(61.0f, 51.0f);
                h.cubicTo(59.552845f, 51.154545f, 58.8374f, 50.327274f, 60.0f, 49.0f);
                h.cubicTo(59.672085f, 48.436363f, 60.506775f, 47.727272f, 62.0f, 48.0f);
                h.cubicTo(65.03794f, 46.663635f, 67.54201f, 43.945454f, 68.0f, 41.0f);
                h.cubicTo(67.54201f, 36.736362f, 63.845528f, 33.545456f, 60.0f, 33.0f);
                h.cubicTo(54.544716f, 33.545456f, 50.84824f, 36.736362f, 51.0f, 41.0f);
                h.lineTo(51.0f, 58.0f);
                h.cubicTo(50.84824f, 64.27273f, 45.482384f, 69.0f, 39.0f, 69.0f);
                h.cubicTo(32.365852f, 69.0f, 27.0f, 64.27273f, 27.0f, 58.0f);
                h.cubicTo(27.0f, 53.163635f, 31.17344f, 48.79091f, 37.0f, 48.0f);
                h.cubicTo(38.20867f, 47.96364f, 38.80488f, 49.618183f, 38.0f, 50.0f);
                h.cubicTo(37.759224f, 50.496105f, 37.373985f, 51.390907f, 36.0f, 51.0f);
                h.cubicTo(32.96206f, 52.454544f, 30.457994f, 55.172726f, 30.0f, 58.0f);
                h.cubicTo(30.457994f, 62.263638f, 34.154472f, 65.454544f, 38.0f, 66.0f);
                h.cubicTo(43.455284f, 65.454544f, 47.15176f, 62.263638f, 47.0f, 58.0f);
                h.lineTo(47.0f, 41.0f);
                h.cubicTo(47.15176f, 34.727272f, 52.517616f, 30.0f, 59.0f, 30.0f);
                h.cubicTo(65.63415f, 30.0f, 71.0f, 34.727272f, 71.0f, 41.0f);
                h.cubicTo(71.0f, 45.954544f, 66.82656f, 50.20909f, 61.0f, 51.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.drawPath(h, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
