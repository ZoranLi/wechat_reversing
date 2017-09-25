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

public final class ajd extends c {
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
                g.setColor(-1);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(46.62213f, 76.7455f);
                h.cubicTo(46.62213f, 76.7455f, 27.0f, 57.136356f, 27.0f, 41.21418f);
                h.cubicTo(27.0f, 29.446882f, 36.40202f, 20.0f, 48.304348f, 20.0f);
                h.cubicTo(59.59798f, 20.0f, 69.0f, 29.446882f, 69.0f, 41.21418f);
                h.cubicTo(69.0f, 57.136356f, 49.37787f, 76.7455f, 49.37787f, 76.7455f);
                h.cubicTo(48.628487f, 77.53978f, 47.383106f, 77.54187f, 46.62213f, 76.7455f);
                h.close();
                h.moveTo(48.0f, 48.0905f);
                h.cubicTo(51.865993f, 48.0905f, 55.0f, 44.94636f, 55.0f, 41.067875f);
                h.cubicTo(55.0f, 37.189384f, 51.865993f, 34.04525f, 48.0f, 34.04525f);
                h.cubicTo(44.134007f, 34.04525f, 41.0f, 37.189384f, 41.0f, 41.067875f);
                h.cubicTo(41.0f, 44.94636f, 44.134007f, 48.0905f, 48.0f, 48.0905f);
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
