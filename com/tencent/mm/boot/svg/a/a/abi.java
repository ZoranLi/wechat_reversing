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

public final class abi extends c {
    private final int height = 24;
    private final int width = 30;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 30;
            case 1:
                return 24;
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
                g2 = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(26.0f, 0.0f);
                h.lineTo(26.0f, 20.0f);
                h.lineTo(0.0f, 20.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                h.moveTo(24.0f, 2.0f);
                h.lineTo(2.0f, 2.0f);
                h.lineTo(2.0f, 17.0f);
                h.lineTo(24.0f, 17.0f);
                h.lineTo(24.0f, 2.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g2);
                canvas.restore();
                canvas.save();
                g2 = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(28.0f, 23.0f);
                h.lineTo(29.0f, 23.0f);
                h.lineTo(29.0f, 3.0f);
                h.lineTo(27.0f, 3.0f);
                h.lineTo(27.0f, 21.0f);
                h.lineTo(3.0f, 21.0f);
                h.lineTo(3.0f, 23.0f);
                h.lineTo(28.0f, 23.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g2);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                Path h2 = c.h(looper);
                h2.moveTo(19.784946f, 8.898396f);
                h2.lineTo(15.462585f, 11.916007f);
                h2.lineTo(8.518518f, 6.5454545f);
                h2.lineTo(0.0f, 13.368984f);
                h2.lineTo(0.0f, 18.545454f);
                h2.lineTo(25.555555f, 18.545454f);
                h2.lineTo(25.555555f, 13.368984f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 1);
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, g);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
