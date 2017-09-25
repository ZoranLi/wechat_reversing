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

public final class dj extends c {
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
                c = c.a(c, 1.0f, 0.0f, -367.0f, 0.0f, 1.0f, -369.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 367.0f, 0.0f, 1.0f, 369.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(45.0f, 43.282814f);
                h.lineTo(29.594316f, 27.877132f);
                h.cubicTo(28.999725f, 27.28254f, 28.054962f, 27.287527f, 27.469177f, 27.873312f);
                h.cubicTo(26.879307f, 28.463182f, 26.8851f, 29.410557f, 27.472996f, 29.998453f);
                h.lineTo(43.474545f, 46.0f);
                h.lineTo(29.50325f, 46.0f);
                h.cubicTo(28.665436f, 46.0f, 28.0f, 46.671574f, 28.0f, 47.5f);
                h.cubicTo(28.0f, 48.3342f, 28.673029f, 49.0f, 29.50325f, 49.0f);
                h.lineTo(46.49675f, 49.0f);
                h.cubicTo(46.49729f, 49.0f, 46.497833f, 49.0f, 46.498375f, 49.0f);
                h.cubicTo(46.498917f, 49.0f, 46.49946f, 49.0f, 46.5f, 49.0f);
                h.cubicTo(46.916557f, 49.0f, 47.291122f, 48.83218f, 47.561768f, 48.560772f);
                h.cubicTo(47.834072f, 48.288242f, 48.0f, 47.913677f, 48.0f, 47.5f);
                h.cubicTo(48.0f, 47.49946f, 48.0f, 47.498917f, 48.0f, 47.498375f);
                h.cubicTo(48.0f, 47.497833f, 48.0f, 47.49729f, 48.0f, 47.49675f);
                h.lineTo(48.0f, 30.50325f);
                h.cubicTo(48.0f, 29.665436f, 47.328426f, 29.0f, 46.5f, 29.0f);
                h.cubicTo(45.6658f, 29.0f, 45.0f, 29.673029f, 45.0f, 30.50325f);
                h.lineTo(45.0f, 43.282814f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(3.0f, 5.3031335f);
                h.lineTo(18.595417f, 20.89855f);
                h.cubicTo(19.190008f, 21.493141f, 20.13477f, 21.488155f, 20.720556f, 20.902369f);
                h.cubicTo(21.310427f, 20.312498f, 21.304632f, 19.365126f, 20.716738f, 18.77723f);
                h.lineTo(4.939507f, 3.0f);
                h.lineTo(18.49675f, 3.0f);
                h.cubicTo(19.334564f, 3.0f, 20.0f, 2.328427f, 20.0f, DownloadHelper.SAVE_FATOR);
                h.cubicTo(20.0f, 0.66579723f, 19.326971f, 0.0f, 18.49675f, 0.0f);
                h.lineTo(1.5032506f, 0.0f);
                h.cubicTo(1.5027087f, 0.0f, 1.5021669f, 2.809642E-7f, 1.5016251f, 8.427533E-7f);
                h.cubicTo(1.5010837f, 2.840145E-7f, 1.5005419f, 0.0f, DownloadHelper.SAVE_FATOR, 0.0f);
                h.cubicTo(1.0863218f, 0.0f, 0.7117559f, 0.16592918f, 0.44039288f, 0.43639413f);
                h.cubicTo(0.16592893f, 0.71175647f, 0.0f, 1.0863222f, 0.0f, DownloadHelper.SAVE_FATOR);
                h.cubicTo(0.0f, 1.5005419f, 2.840145E-7f, 1.5010837f, 8.519021E-7f, 1.5016255f);
                h.cubicTo(2.809642E-7f, 1.5021669f, 0.0f, 1.5027087f, 0.0f, 1.5032506f);
                h.lineTo(0.0f, 18.49675f);
                h.cubicTo(0.0f, 19.326971f, 0.66579723f, 20.0f, DownloadHelper.SAVE_FATOR, 20.0f);
                h.cubicTo(2.328427f, 20.0f, 3.0f, 19.334564f, 3.0f, 18.49675f);
                h.lineTo(3.0f, 5.3031335f);
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
