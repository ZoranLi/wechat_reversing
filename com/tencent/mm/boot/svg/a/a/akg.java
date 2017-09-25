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

public final class akg extends c {
    private final int height = 70;
    private final int width = 120;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 70;
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
                g = c.a(g2, looper);
                g.setStrokeWidth(1.0f);
                g = c.a(g, looper);
                g.setColor(-9473160);
                g.setStrokeWidth(5.0f);
                canvas.save();
                g = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(24.0f, 17.0f);
                h.lineTo(60.0f, 53.0f);
                h.lineTo(96.0f, 17.0f);
                WeChatSVGRenderC2Java.setFillType(h, 1);
                canvas.drawPath(h, g);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
