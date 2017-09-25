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

public final class pq extends c {
    private final int height = 108;
    private final int width = 108;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 108;
            case 1:
                return 108;
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
                Paint a = c.a(g, looper);
                a.setColor(-16384);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 17.0f, 0.0f, 1.0f, 17.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(24.38938f, 14.313926f);
                h.lineTo(24.378096f, 14.307363f);
                h.lineTo(34.425114f, 4.2603464f);
                h.cubicTo(36.105576f, 2.5798845f, 38.822918f, 2.5798845f, 40.50338f, 4.2603464f);
                h.lineTo(50.550396f, 14.307363f);
                h.lineTo(39.609516f, 20.671665f);
                h.cubicTo(38.322353f, 21.458263f, 36.677647f, 21.458263f, 35.318974f, 20.671665f);
                h.lineTo(24.41391f, 14.328196f);
                h.lineTo(24.449606f, 26.964458f);
                h.cubicTo(24.449606f, 28.501902f, 23.627253f, 29.932081f, 22.268581f, 30.718681f);
                h.lineTo(11.291947f, 37.011475f);
                h.lineTo(7.6449876f, 23.245989f);
                h.cubicTo(7.037161f, 20.9577f, 8.395832f, 18.597902f, 10.68412f, 17.990076f);
                h.lineTo(24.38938f, 14.313926f);
                h.close();
                h.moveTo(24.41391f, 59.658997f);
                h.lineTo(35.318974f, 53.31553f);
                h.cubicTo(36.677647f, 52.52893f, 38.322353f, 52.52893f, 39.64527f, 53.31553f);
                h.lineTo(50.586147f, 59.67983f);
                h.lineTo(40.50338f, 69.726845f);
                h.cubicTo(38.822918f, 71.40731f, 36.105576f, 71.40731f, 34.425114f, 69.726845f);
                h.lineTo(24.378096f, 59.67983f);
                h.lineTo(24.38938f, 59.673267f);
                h.lineTo(10.68412f, 55.997116f);
                h.cubicTo(8.395832f, 55.38929f, 7.037161f, 53.02949f, 7.6449876f, 50.741203f);
                h.lineTo(11.327702f, 37.011475f);
                h.lineTo(22.304335f, 43.304268f);
                h.cubicTo(23.627253f, 44.05511f, 24.449606f, 45.48529f, 24.449606f, 47.022736f);
                h.lineTo(24.41391f, 59.658997f);
                h.close();
                h.moveTo(52.695663f, 43.268513f);
                h.lineTo(63.6723f, 36.97572f);
                h.lineTo(67.35501f, 50.70545f);
                h.cubicTo(67.96284f, 52.993736f, 66.604164f, 55.353535f, 64.31588f, 55.96136f);
                h.lineTo(50.586147f, 59.644077f);
                h.lineTo(50.550396f, 46.98698f);
                h.cubicTo(50.51464f, 45.48529f, 51.336994f, 44.05511f, 52.695663f, 43.268513f);
                h.close();
                h.moveTo(50.550396f, 26.964458f);
                h.lineTo(50.586147f, 14.307363f);
                h.lineTo(64.31588f, 17.990076f);
                h.cubicTo(66.604164f, 18.597902f, 67.96284f, 20.9577f, 67.35501f, 23.245989f);
                h.lineTo(63.6723f, 36.97572f);
                h.lineTo(52.695663f, 30.682926f);
                h.cubicTo(51.336994f, 29.932081f, 50.51464f, 28.501902f, 50.550396f, 26.964458f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 1);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
