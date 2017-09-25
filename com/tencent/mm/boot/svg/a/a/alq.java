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

public final class alq extends c {
    private final int height = 90;
    private final int width = 90;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
            case 1:
                return 90;
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
                g.setStrokeCap(Cap.ROUND);
                g.setStrokeJoin(Join.MITER);
                g = c.a(g, looper);
                g.setColor(-3618616);
                g.setStrokeWidth(3.139535f);
                canvas.save();
                g = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(20.930233f, 59.65116f);
                h.lineTo(45.0f, 31.39535f);
                h.lineTo(69.06977f, 59.65116f);
                WeChatSVGRenderC2Java.setFillType(h, 1);
                canvas.drawPath(h, g);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
