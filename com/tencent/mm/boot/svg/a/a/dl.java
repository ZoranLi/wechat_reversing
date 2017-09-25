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

public final class dl extends c {
    private final int height = 50;
    private final int width = 50;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 50;
            case 1:
                return 50;
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
                Paint a = c.a(g, looper);
                a.setColor(-1);
                c = c.a(c, 1.0f, 0.0f, -289.0f, 0.0f, 1.0f, -369.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 302.0f, 0.0f, 1.0f, 370.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(0.0f, DownloadHelper.SAVE_FATOR);
                h.cubicTo(0.0f, 0.6715728f, 0.6715728f, 0.0f, DownloadHelper.SAVE_FATOR, 0.0f);
                h.lineTo(2.5f, 0.0f);
                h.cubicTo(3.3284273f, 0.0f, 4.0f, 0.6715728f, 4.0f, DownloadHelper.SAVE_FATOR);
                h.lineTo(4.0f, 46.5f);
                h.cubicTo(4.0f, 47.328426f, 3.3284273f, 48.0f, 2.5f, 48.0f);
                h.lineTo(DownloadHelper.SAVE_FATOR, 48.0f);
                h.cubicTo(0.6715728f, 48.0f, 0.0f, 47.328426f, 0.0f, 46.5f);
                h.lineTo(0.0f, DownloadHelper.SAVE_FATOR);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(20.0f, DownloadHelper.SAVE_FATOR);
                h.cubicTo(20.0f, 0.6715728f, 20.671574f, 0.0f, 21.5f, 0.0f);
                h.lineTo(22.5f, 0.0f);
                h.cubicTo(23.328426f, 0.0f, 24.0f, 0.6715728f, 24.0f, DownloadHelper.SAVE_FATOR);
                h.lineTo(24.0f, 46.5f);
                h.cubicTo(24.0f, 47.328426f, 23.328426f, 48.0f, 22.5f, 48.0f);
                h.lineTo(21.5f, 48.0f);
                h.cubicTo(20.671574f, 48.0f, 20.0f, 47.328426f, 20.0f, 46.5f);
                h.lineTo(20.0f, DownloadHelper.SAVE_FATOR);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
