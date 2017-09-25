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

public final class nk extends c {
    private final int height = 27;
    private final int width = 27;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 27;
            case 1:
                return 27;
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
                Paint a = c.a(g, looper);
                a.setColor(-772816);
                Path h = c.h(looper);
                h.moveTo(27.0f, 13.666667f);
                h.cubicTo(27.0f, 6.044f, 20.956f, 0.0f, 13.333333f, 0.0f);
                h.cubicTo(6.044f, 0.0f, 0.0f, 6.044f, 0.0f, 13.666667f);
                h.cubicTo(0.0f, 20.956f, 6.044f, 27.0f, 13.333333f, 27.0f);
                h.cubicTo(20.956f, 27.0f, 27.0f, 20.956f, 27.0f, 13.666667f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-1);
                h = c.h(looper);
                h.moveTo(13.5f, 6.0f);
                h.cubicTo(14.334203f, 6.0f, 14.962531f, 6.674437f, 14.916311f, 7.5063977f);
                h.lineTo(14.5f, 15.0f);
                h.lineTo(12.5f, 15.0f);
                h.lineTo(12.083689f, 7.5063977f);
                h.cubicTo(12.037581f, 6.6764627f, 12.671573f, 6.0f, 13.5f, 6.0f);
                h.close();
                h.moveTo(13.5f, 20.0f);
                h.cubicTo(12.671573f, 20.0f, 12.0f, 19.328426f, 12.0f, 18.5f);
                h.cubicTo(12.0f, 17.671574f, 12.671573f, 17.0f, 13.5f, 17.0f);
                h.cubicTo(14.328427f, 17.0f, 15.0f, 17.671574f, 15.0f, 18.5f);
                h.cubicTo(15.0f, 19.328426f, 14.328427f, 20.0f, 13.5f, 20.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
