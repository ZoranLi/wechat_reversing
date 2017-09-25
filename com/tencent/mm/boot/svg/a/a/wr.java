package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

public final class wr extends c {
    private final int height = 63;
    private final int width = 63;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 63;
            case 1:
                return 63;
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
                Paint a = c.a(g2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                Paint a2 = c.a(g, looper);
                g2 = c.a(a, looper);
                a2.setColor(16777215);
                g2.setColor(-1);
                g2.setStrokeWidth(2.0f);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                a = c.a(g2, looper);
                Path h = c.h(looper);
                h.moveTo(0.0f, DownloadHelper.SAVE_FATOR);
                h.cubicTo(0.0f, 0.6715728f, 0.6715728f, 0.0f, DownloadHelper.SAVE_FATOR, 0.0f);
                h.lineTo(37.5f, 0.0f);
                h.cubicTo(38.328426f, 0.0f, 39.0f, 0.6715728f, 39.0f, DownloadHelper.SAVE_FATOR);
                h.lineTo(39.0f, 37.5f);
                h.cubicTo(39.0f, 38.328426f, 38.328426f, 39.0f, 37.5f, 39.0f);
                h.lineTo(DownloadHelper.SAVE_FATOR, 39.0f);
                h.cubicTo(0.6715728f, 39.0f, 0.0f, 38.328426f, 0.0f, 37.5f);
                h.lineTo(0.0f, DownloadHelper.SAVE_FATOR);
                h.close();
                canvas.drawPath(h, a3);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                a2 = c.a(g, looper);
                a2.setColor(-1);
                Path h2 = c.h(looper);
                h2.moveTo(0.0f, 0.0f);
                h2.lineTo(20.0f, 0.0f);
                h2.lineTo(20.0f, 20.0f);
                h2.lineTo(0.0f, 20.0f);
                h2.lineTo(0.0f, 0.0f);
                h2.close();
                canvas.drawPath(h2, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(g, looper);
                a2.setColor(-1);
                h2 = c.h(looper);
                h2.moveTo(20.0f, 20.0f);
                h2.lineTo(39.5f, 20.0f);
                h2.lineTo(39.5f, 39.5f);
                h2.lineTo(20.0f, 39.5f);
                h2.lineTo(20.0f, 20.0f);
                h2.close();
                canvas.drawPath(h2, a2);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
