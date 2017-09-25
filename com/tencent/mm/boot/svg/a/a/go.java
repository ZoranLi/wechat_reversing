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

public final class go extends c {
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
                h.moveTo(47.0f, 87.98775f);
                h.cubicTo(25.370693f, 87.45702f, 8.0f, 69.75708f, 8.0f, 48.0f);
                h.cubicTo(8.0f, 34.31184f, 14.875527f, 22.229542f, 25.36142f, 15.018275f);
                h.lineTo(31.139889f, 20.796743f);
                h.cubicTo(22.05139f, 26.441599f, 16.0f, 36.51411f, 16.0f, 48.0f);
                h.cubicTo(16.0f, 65.338554f, 29.789598f, 79.456375f, 47.0f, 79.98467f);
                h.lineTo(47.0f, 70.0f);
                h.lineTo(65.0f, 88.0f);
                h.lineTo(47.0f, 88.0f);
                h.lineTo(47.0f, 87.98775f);
                h.close();
                h.moveTo(47.0f, 8.012256f);
                h.cubicTo(47.332344f, 8.004101f, 47.66569f, 8.0f, 48.0f, 8.0f);
                h.cubicTo(70.09139f, 8.0f, 88.0f, 25.90861f, 88.0f, 48.0f);
                h.cubicTo(88.0f, 62.075714f, 80.72963f, 74.45335f, 69.73931f, 81.58246f);
                h.lineTo(63.921238f, 75.76438f);
                h.cubicTo(73.52948f, 70.24273f, 80.0f, 59.877f, 80.0f, 48.0f);
                h.cubicTo(80.0f, 30.326887f, 65.67311f, 16.0f, 48.0f, 16.0f);
                h.cubicTo(47.665443f, 16.0f, 47.332085f, 16.005135f, 47.0f, 16.015327f);
                h.lineTo(47.0f, 26.0f);
                h.lineTo(29.0f, 8.0f);
                h.lineTo(47.0f, 8.0f);
                h.lineTo(47.0f, 8.012256f);
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
