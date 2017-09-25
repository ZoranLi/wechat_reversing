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

public final class dx extends c {
    private final int height = 45;
    private final int width = 45;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 45;
            case 1:
                return 45;
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
                c = c.a(c, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 6.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-11048043);
                a2.setStrokeWidth(3.0f);
                Path h = c.h(looper);
                h.moveTo(DownloadHelper.SAVE_FATOR, 4.5f);
                h.cubicTo(DownloadHelper.SAVE_FATOR, 2.8431456f, 2.8431456f, DownloadHelper.SAVE_FATOR, 4.5f, DownloadHelper.SAVE_FATOR);
                h.lineTo(40.5f, DownloadHelper.SAVE_FATOR);
                h.cubicTo(42.156853f, DownloadHelper.SAVE_FATOR, 43.5f, 2.8431456f, 43.5f, 4.5f);
                h.lineTo(43.5f, 28.5f);
                h.cubicTo(43.5f, 30.156855f, 42.156853f, 31.5f, 40.5f, 31.5f);
                h.lineTo(4.5f, 31.5f);
                h.cubicTo(2.8431456f, 31.5f, DownloadHelper.SAVE_FATOR, 30.156855f, DownloadHelper.SAVE_FATOR, 28.5f);
                h.lineTo(DownloadHelper.SAVE_FATOR, 4.5f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(g, looper);
                a2.setColor(-11048043);
                h = c.h(looper);
                h.moveTo(6.0f, 17.0f);
                h.cubicTo(6.0f, 16.447716f, 6.4477153f, 16.0f, 7.0f, 16.0f);
                h.lineTo(11.0f, 16.0f);
                h.cubicTo(11.552285f, 16.0f, 12.0f, 16.447716f, 12.0f, 17.0f);
                h.lineTo(12.0f, 21.0f);
                h.cubicTo(12.0f, 21.552284f, 11.552285f, 22.0f, 11.0f, 22.0f);
                h.lineTo(7.0f, 22.0f);
                h.cubicTo(6.4477153f, 22.0f, 6.0f, 21.552284f, 6.0f, 21.0f);
                h.lineTo(6.0f, 17.0f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(g, looper);
                a3.setColor(-11048043);
                Path h2 = c.h(looper);
                h2.moveTo(6.0f, 9.0f);
                h2.lineTo(39.0f, 9.0f);
                h2.lineTo(39.0f, 12.0f);
                h2.lineTo(6.0f, 12.0f);
                h2.lineTo(6.0f, 9.0f);
                h2.close();
                canvas.drawPath(h2, a3);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
