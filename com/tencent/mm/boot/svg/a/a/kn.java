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

public final class kn extends c {
    private final int height = 245;
    private final int width = 357;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 357;
            case 1:
                return 245;
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
                g2 = c.a(g, looper);
                g2.setColor(WebView.NIGHT_MODE_COLOR);
                Path h = c.h(looper);
                h.moveTo(20.0f, 0.0f);
                h.lineTo(21.0f, 0.0f);
                h.lineTo(21.0f, 245.0f);
                h.lineTo(20.0f, 245.0f);
                h.lineTo(20.0f, 0.0f);
                h.close();
                canvas.drawPath(h, g2);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(WebView.NIGHT_MODE_COLOR);
                Path h2 = c.h(looper);
                h2.moveTo(335.0f, 0.0f);
                h2.lineTo(336.0f, 0.0f);
                h2.lineTo(336.0f, 245.0f);
                h2.lineTo(335.0f, 245.0f);
                h2.lineTo(335.0f, 0.0f);
                h2.close();
                canvas.drawPath(h2, g);
                canvas.restore();
                canvas.save();
                g = c.a(a, looper);
                g.setColor(WebView.NIGHT_MODE_COLOR);
                g.setStrokeWidth(3.0f);
                h2 = c.h(looper);
                h2.moveTo(8.790844f, DownloadHelper.SAVE_FATOR);
                h2.lineTo(1.506977f, 243.5f);
                h2.lineTo(355.493f, 243.5f);
                h2.lineTo(348.20917f, DownloadHelper.SAVE_FATOR);
                h2.lineTo(8.790844f, DownloadHelper.SAVE_FATOR);
                h2.close();
                canvas.drawPath(h2, g);
                canvas.restore();
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(WebView.NIGHT_MODE_COLOR);
                c = c.a(c, 1.0f, 0.0f, 37.0f, 0.0f, 1.0f, 25.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                g = c.a(a2, looper);
                h2 = c.h(looper);
                h2.moveTo(-0.5f, -0.5f);
                h2.lineTo(285.5f, -0.5f);
                h2.lineTo(285.5f, 192.5f);
                h2.lineTo(-0.5f, 192.5f);
                h2.lineTo(-0.5f, -0.5f);
                h2.close();
                canvas.drawPath(h2, g);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                a.setStrokeWidth(2.0f);
                c = c.a(c, 1.0f, 0.0f, 134.0f, 0.0f, 1.0f, 97.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path h3 = c.h(looper);
                h3.moveTo(1.0f, 3.0f);
                h3.cubicTo(1.0f, 1.8954304f, 1.8954304f, 1.0f, 3.0f, 1.0f);
                h3.lineTo(66.0f, 1.0f);
                h3.cubicTo(67.10457f, 1.0f, 68.0f, 1.8954304f, 68.0f, 3.0f);
                h3.lineTo(68.0f, 49.0f);
                h3.cubicTo(68.0f, 50.10457f, 67.10457f, 51.0f, 66.0f, 51.0f);
                h3.lineTo(3.0f, 51.0f);
                h3.cubicTo(1.8954304f, 51.0f, 1.0f, 50.10457f, 1.0f, 49.0f);
                h3.lineTo(1.0f, 3.0f);
                h3.close();
                canvas.drawPath(h3, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                h3 = c.h(looper);
                h3.moveTo(99.0f, 50.07509f);
                h3.lineTo(99.0f, 2.0108225f);
                h3.lineTo(75.39577f, 19.873486f);
                h3.cubicTo(75.21011f, 20.013983f, 75.0f, 20.437353f, 75.0f, 20.675142f);
                h3.lineTo(75.0f, 32.730263f);
                h3.cubicTo(75.0f, 32.953712f, 75.21011f, 33.357872f, 75.39602f, 33.488506f);
                h3.lineTo(99.0f, 50.07509f);
                h3.close();
                canvas.drawPath(h3, a3);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
