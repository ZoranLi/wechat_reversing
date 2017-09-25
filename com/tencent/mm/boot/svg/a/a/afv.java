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

public final class afv extends c {
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
                canvas.saveLayerAlpha(null, 76, 4);
                g = c.a(g, looper);
                g.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                g = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(15.84375f, 13.5f);
                h.lineTo(26.0f, 3.34375f);
                h.lineTo(23.65625f, 1.0f);
                h.lineTo(13.5f, 11.15625f);
                h.lineTo(3.34375f, 1.0f);
                h.lineTo(1.0f, 3.34375f);
                h.lineTo(11.15625f, 13.5f);
                h.lineTo(1.0f, 23.65625f);
                h.lineTo(3.34375f, 26.0f);
                h.lineTo(13.5f, 15.84375f);
                h.lineTo(23.65625f, 26.0f);
                h.lineTo(26.0f, 23.65625f);
                h.lineTo(15.84375f, 13.5f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 1);
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
