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

public final class agv extends c {
    private final int height = 42;
    private final int width = 42;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 42;
            case 1:
                return 42;
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
                g.setColor(-1973791);
                canvas.save();
                g = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(21.0f, 33.0f);
                h.lineTo(9.244295f, 39.18034f);
                h.lineTo(11.489435f, 26.09017f);
                h.lineTo(1.9788697f, 16.81966f);
                h.lineTo(15.122148f, 14.90983f);
                h.lineTo(21.0f, 3.0f);
                h.lineTo(26.877853f, 14.90983f);
                h.lineTo(40.02113f, 16.81966f);
                h.lineTo(30.510565f, 26.09017f);
                h.lineTo(32.755707f, 39.18034f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 1);
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
