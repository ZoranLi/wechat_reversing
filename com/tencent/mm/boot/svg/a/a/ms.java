package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class ms extends c {
    private final int height = 81;
    private final int width = MMGIFException.D_GIF_ERR_NO_IMAG_DSCR;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return MMGIFException.D_GIF_ERR_NO_IMAG_DSCR;
            case 1:
                return 81;
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
                a.setColor(-2565928);
                c = c.a(c, 1.0f, 0.0f, -741.0f, 0.0f, 1.0f, -55.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 741.0f, 0.0f, 1.0f, 55.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(86.71151f, 34.642452f);
                h.cubicTo(85.82056f, 34.548286f, 84.91592f, 34.5f, 84.0f, 34.5f);
                h.cubicTo(75.91176f, 34.5f, 68.7032f, 38.265427f, 64.03162f, 44.138985f);
                h.cubicTo(62.99355f, 42.952747f, 62.684723f, 41.290863f, 63.354f, 39.4515f);
                h.cubicTo(64.314f, 36.816f, 66.8325f, 34.5915f, 69.906f, 33.561f);
                h.cubicTo(74.6715f, 31.824f, 78.0f, 27.861f, 78.0f, 23.25f);
                h.cubicTo(78.0f, 17.037f, 71.955f, 12.0f, 64.5f, 12.0f);
                h.cubicTo(57.0435f, 12.0f, 51.0f, 17.037f, 51.0f, 23.25f);
                h.lineTo(51.0f, 57.75f);
                h.cubicTo(51.0f, 66.048f, 46.1925f, 73.323f, 39.0f, 77.439f);
                h.cubicTo(35.079f, 79.6815f, 30.4605f, 81.0f, 25.5f, 81.0f);
                h.cubicTo(11.439f, 81.0f, 0.0f, 70.5705f, 0.0f, 57.75f);
                h.cubicTo(0.0f, 53.67f, 1.167f, 49.8375f, 3.1995f, 46.5f);
                h.cubicTo(6.3465f, 41.3355f, 11.589f, 37.3815f, 17.8695f, 35.5785f);
                h.cubicTo(17.8755f, 35.577f, 17.88f, 35.5755f, 17.8845f, 35.574f);
                h.cubicTo(18.9435f, 35.244f, 20.0415f, 35.061f, 21.1245f, 35.061f);
                h.cubicTo(25.4685f, 35.061f, 27.9225f, 37.995f, 26.604f, 41.616f);
                h.cubicTo(25.7115f, 44.0685f, 23.307f, 46.1805f, 20.5035f, 47.3055f);
                h.cubicTo(20.169f, 47.4165f, 19.8435f, 47.5425f, 19.5225f, 47.6745f);
                h.cubicTo(15.069f, 49.5135f, 12.0f, 53.328f, 12.0f, 57.75f);
                h.cubicTo(12.0f, 63.963f, 18.0435f, 69.0f, 25.5f, 69.0f);
                h.cubicTo(32.955f, 69.0f, 39.0f, 63.963f, 39.0f, 57.75f);
                h.lineTo(39.0f, 23.25f);
                h.cubicTo(39.0f, 14.952f, 43.8075f, 7.677f, 51.0f, 3.561f);
                h.cubicTo(54.921f, 1.3185f, 59.5395f, 0.0f, 64.5f, 0.0f);
                h.cubicTo(78.561f, 0.0f, 90.0f, 10.4295f, 90.0f, 23.25f);
                h.cubicTo(90.0f, 27.33f, 88.833f, 31.164f, 86.799f, 34.5f);
                h.cubicTo(86.77001f, 34.54759f, 86.74085f, 34.59507f, 86.71151f, 34.642452f);
                h.close();
                h.moveTo(105.0f, 60.0f);
                h.cubicTo(105.0f, 71.59822f, 95.59822f, 81.0f, 84.0f, 81.0f);
                h.cubicTo(72.40178f, 81.0f, 63.0f, 71.59822f, 63.0f, 60.0f);
                h.cubicTo(63.0f, 48.40178f, 72.40178f, 39.0f, 84.0f, 39.0f);
                h.cubicTo(95.59822f, 39.0f, 105.0f, 48.40178f, 105.0f, 60.0f);
                h.close();
                h.moveTo(81.30608f, 49.484344f);
                h.lineTo(83.0f, 66.0f);
                h.lineTo(85.0f, 66.0f);
                h.lineTo(86.69392f, 49.484344f);
                h.cubicTo(86.84651f, 47.996536f, 85.76411f, 46.66673f, 84.2763f, 46.514133f);
                h.cubicTo(84.1845f, 46.50472f, 84.09228f, 46.5f, 84.0f, 46.5f);
                h.cubicTo(82.50439f, 46.5f, 81.291954f, 47.712433f, 81.291954f, 49.208046f);
                h.cubicTo(81.291954f, 49.300327f, 81.29667f, 49.392544f, 81.30608f, 49.484344f);
                h.close();
                h.moveTo(84.0f, 75.0f);
                h.cubicTo(85.65685f, 75.0f, 87.0f, 73.65685f, 87.0f, 72.0f);
                h.cubicTo(87.0f, 70.34315f, 85.65685f, 69.0f, 84.0f, 69.0f);
                h.cubicTo(82.34315f, 69.0f, 81.0f, 70.34315f, 81.0f, 72.0f);
                h.cubicTo(81.0f, 73.65685f, 82.34315f, 75.0f, 84.0f, 75.0f);
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
