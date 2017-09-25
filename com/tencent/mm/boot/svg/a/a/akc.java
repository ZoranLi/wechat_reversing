package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

public final class akc extends c {
    private final int height = 27;
    private final int width = 42;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 42;
            case 1:
                return 27;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix d = c.d(looper);
                float[] c = c.c(looper);
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
                c = c.a(c, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, DownloadHelper.SAVE_FATOR);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                g2 = c.a(g, looper);
                g2.setColor(-1);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.5f);
                h.lineTo(26.0f, 0.5f);
                h.lineTo(26.0f, 24.5f);
                h.lineTo(0.0f, 24.5f);
                h.lineTo(0.0f, 0.5f);
                h.close();
                h.moveTo(2.0f, 2.5f);
                h.lineTo(2.0f, 22.5f);
                h.lineTo(24.0f, 22.5f);
                h.lineTo(24.0f, 2.5f);
                h.lineTo(2.0f, 2.5f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g2);
                canvas.restore();
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 27.363636f, 0.0f, 1.0f, 1.090909f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.restore();
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-1);
                Path h2 = c.h(looper);
                h2.moveTo(31.008236f, 11.565939f);
                h2.lineTo(31.002834f, 13.579968f);
                h2.lineTo(39.986187f, 19.714403f);
                h2.lineTo(39.997097f, 5.3252935f);
                h2.lineTo(31.008236f, 11.565939f);
                h2.close();
                h2.moveTo(29.011042f, 10.51777f);
                h2.lineTo(42.0f, DownloadHelper.SAVE_FATOR);
                h2.lineTo(41.983315f, 23.5f);
                h2.lineTo(29.0f, 14.634123f);
                h2.lineTo(29.011042f, 10.51777f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 1);
                canvas.drawPath(h2, a);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
