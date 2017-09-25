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

public final class op extends c {
    private final int height = 90;
    private final int width = 90;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                c = c.a(c, 1.0f, 0.0f, 5.0f, 0.0f, 1.0f, 15.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-13917627);
                a2.setStrokeWidth(3.0f);
                Path h = c.h(looper);
                h.moveTo(0.0f, 4.0f);
                h.cubicTo(0.0f, 1.7908609f, 1.7908609f, 0.0f, 4.0f, 0.0f);
                h.lineTo(76.0f, 0.0f);
                h.cubicTo(78.20914f, 0.0f, 80.0f, 1.7908609f, 80.0f, 4.0f);
                h.lineTo(80.0f, 56.0f);
                h.cubicTo(80.0f, 58.20914f, 78.20914f, 60.0f, 76.0f, 60.0f);
                h.lineTo(4.0f, 60.0f);
                h.cubicTo(1.7908609f, 60.0f, 0.0f, 58.20914f, 0.0f, 56.0f);
                h.lineTo(0.0f, 4.0f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(g, looper);
                a3.setColor(-13917627);
                Path h2 = c.h(looper);
                h2.moveTo(80.0f, 51.27833f);
                h2.lineTo(80.0f, 46.32595f);
                h2.lineTo(59.301716f, 28.110498f);
                h2.lineTo(49.087624f, 38.743828f);
                h2.lineTo(51.985447f, 46.32595f);
                h2.lineTo(25.728987f, 21.0f);
                h2.lineTo(0.0f, 46.32595f);
                h2.lineTo(0.0f, 51.27833f);
                h2.lineTo(2.0572917f, 57.15147f);
                h2.lineTo(3.7081473f, 59.3399f);
                h2.lineTo(74.262276f, 59.3399f);
                h2.lineTo(78.61886f, 57.389565f);
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a3);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
