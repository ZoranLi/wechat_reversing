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

public final class afs extends c {
    private final int height = 36;
    private final int width = 22;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 22;
            case 1:
                return 36;
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
                h.moveTo(10.0f, 0.0f);
                h.lineTo(11.59f, 0.0f);
                h.cubicTo(14.44f, 4.26f, 18.06f, 8.06f, 22.0f, 11.34f);
                h.lineTo(22.0f, 11.75f);
                h.cubicTo(19.0f, 11.97f, 16.0f, 12.05f, 13.0f, 12.02f);
                h.cubicTo(13.05f, 20.01f, 12.89f, 28.01f, 13.09f, 36.0f);
                h.lineTo(9.0f, 36.0f);
                h.lineTo(9.0f, 12.03f);
                h.cubicTo(6.0f, 12.04f, 3.0f, 11.98f, 0.0f, 11.77f);
                h.lineTo(0.0f, 11.38f);
                h.cubicTo(3.84f, 8.02f, 7.68f, 4.33f, 10.39f, 0.0f);
                h.lineTo(10.0f, 0.0f);
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
