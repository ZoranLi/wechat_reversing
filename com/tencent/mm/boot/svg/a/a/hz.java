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

public final class hz extends c {
    private final int height = 69;
    private final int width = 69;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 69;
            case 1:
                return 69;
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
                c = c.a(c, 1.0f, 0.0f, -66.0f, 0.0f, 1.0f, -459.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 72.0f, 0.0f, 1.0f, 465.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-1);
                a2.setStrokeWidth(3.0f);
                Path h = c.h(looper);
                h.moveTo(28.5f, DownloadHelper.SAVE_FATOR);
                h.cubicTo(43.41169f, DownloadHelper.SAVE_FATOR, 55.5f, 13.588311f, 55.5f, 28.5f);
                h.cubicTo(55.5f, 43.41169f, 43.41169f, 55.5f, 28.5f, 55.5f);
                h.cubicTo(13.588311f, 55.5f, DownloadHelper.SAVE_FATOR, 43.41169f, DownloadHelper.SAVE_FATOR, 28.5f);
                h.cubicTo(DownloadHelper.SAVE_FATOR, 13.588311f, 13.588311f, DownloadHelper.SAVE_FATOR, 28.5f, DownloadHelper.SAVE_FATOR);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(g, looper);
                a2.setColor(-1);
                h = c.h(looper);
                h.moveTo(39.81111f, 30.250793f);
                h.lineTo(23.24421f, 39.717594f);
                h.lineTo(23.24421f, 39.717594f);
                h.cubicTo(22.524933f, 40.12861f, 21.60865f, 39.878716f, 21.197636f, 39.15944f);
                h.cubicTo(21.068123f, 38.932793f, 21.0f, 38.67627f, 21.0f, 38.41523f);
                h.lineTo(21.0f, 18.692726f);
                h.lineTo(21.0f, 18.692726f);
                h.cubicTo(21.0f, 17.8643f, 21.671574f, 17.192726f, 22.5f, 17.192726f);
                h.cubicTo(22.778942f, 17.192726f, 23.052357f, 17.270508f, 23.289532f, 17.41733f);
                h.lineTo(39.856434f, 27.67303f);
                h.lineTo(39.856434f, 27.67303f);
                h.cubicTo(40.560818f, 28.109077f, 40.778347f, 29.033579f, 40.3423f, 29.73796f);
                h.cubicTo(40.21073f, 29.950493f, 40.028137f, 30.126778f, 39.81111f, 30.250793f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
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
