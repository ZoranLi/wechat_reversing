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

public final class ado extends c {
    private final int height = 46;
    private final int width = 41;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 41;
            case 1:
                return 46;
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
                c = c.a(c, 1.0f, 0.0f, -520.0f, 0.0f, 1.0f, -1837.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 520.0f, 0.0f, 1.0f, 1837.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(g, looper);
                a2.setColor(-1686720);
                Path h = c.h(looper);
                h.moveTo(12.0f, DownloadHelper.SAVE_FATOR);
                h.cubicTo(12.0f, 0.6715728f, 12.671573f, 0.0f, 13.5f, 0.0f);
                h.lineTo(26.5f, 0.0f);
                h.cubicTo(27.328426f, 0.0f, 28.0f, 0.6715728f, 28.0f, DownloadHelper.SAVE_FATOR);
                h.lineTo(28.0f, 4.3489656f);
                h.cubicTo(28.0f, 5.177393f, 27.328426f, 5.8489656f, 26.5f, 5.8489656f);
                h.lineTo(13.5f, 5.8489656f);
                h.cubicTo(12.671573f, 5.8489656f, 12.0f, 5.177393f, 12.0f, 4.3489656f);
                h.lineTo(12.0f, DownloadHelper.SAVE_FATOR);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                Paint a3 = c.a(a, looper);
                a3.setColor(-1686720);
                a3.setStrokeWidth(10.0f);
                canvas.save();
                a2 = c.a(a3, looper);
                h = c.h(looper);
                h.moveTo(3.0f, 7.0f);
                h.cubicTo(3.0f, 5.8954306f, 3.8954306f, 5.0f, 5.0f, 5.0f);
                h.lineTo(36.0f, 5.0f);
                h.cubicTo(37.10457f, 5.0f, 38.0f, 5.8954306f, 38.0f, 7.0f);
                h.lineTo(38.0f, 44.0f);
                h.cubicTo(38.0f, 45.10457f, 37.10457f, 46.0f, 36.0f, 46.0f);
                h.lineTo(5.0f, 46.0f);
                h.cubicTo(3.8954306f, 46.0f, 3.0f, 45.10457f, 3.0f, 44.0f);
                h.lineTo(3.0f, 7.0f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(g, looper);
                a2.setColor(-1686720);
                h = c.h(looper);
                h.moveTo(14.0f, 16.5f);
                h.cubicTo(14.0f, 15.671573f, 14.671573f, 15.0f, 15.5f, 15.0f);
                h.lineTo(15.5f, 15.0f);
                h.cubicTo(16.328426f, 15.0f, 17.0f, 15.671573f, 17.0f, 16.5f);
                h.lineTo(17.0f, 33.5f);
                h.cubicTo(17.0f, 34.328426f, 16.328426f, 35.0f, 15.5f, 35.0f);
                h.lineTo(15.5f, 35.0f);
                h.cubicTo(14.671573f, 35.0f, 14.0f, 34.328426f, 14.0f, 33.5f);
                h.lineTo(14.0f, 16.5f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(g, looper);
                a2.setColor(-1686720);
                h = c.h(looper);
                h.moveTo(24.0f, 16.5f);
                h.cubicTo(24.0f, 15.671573f, 24.671574f, 15.0f, 25.5f, 15.0f);
                h.lineTo(25.5f, 15.0f);
                h.cubicTo(26.328426f, 15.0f, 27.0f, 15.671573f, 27.0f, 16.5f);
                h.lineTo(27.0f, 33.5f);
                h.cubicTo(27.0f, 34.328426f, 26.328426f, 35.0f, 25.5f, 35.0f);
                h.lineTo(25.5f, 35.0f);
                h.cubicTo(24.671574f, 35.0f, 24.0f, 34.328426f, 24.0f, 33.5f);
                h.lineTo(24.0f, 16.5f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(g, looper);
                a2.setColor(-1686720);
                h = c.h(looper);
                h.moveTo(0.0f, 6.5f);
                h.cubicTo(0.0f, 5.6715727f, 0.6715728f, 5.0f, DownloadHelper.SAVE_FATOR, 5.0f);
                h.lineTo(39.5f, 5.0f);
                h.cubicTo(40.328426f, 5.0f, 41.0f, 5.6715727f, 41.0f, 6.5f);
                h.lineTo(41.0f, 6.5f);
                h.cubicTo(41.0f, 7.3284273f, 40.328426f, 8.0f, 39.5f, 8.0f);
                h.lineTo(DownloadHelper.SAVE_FATOR, 8.0f);
                h.cubicTo(0.6715728f, 8.0f, 0.0f, 7.3284273f, 0.0f, 6.5f);
                h.lineTo(0.0f, 6.5f);
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
