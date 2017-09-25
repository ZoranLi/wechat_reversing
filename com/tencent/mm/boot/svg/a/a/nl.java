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

public final class nl extends c {
    private final int height = 53;
    private final int width = 53;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 53;
            case 1:
                return 53;
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
                c = c.a(c, 1.0f, 0.0f, 0.434783f, 0.0f, 1.0f, 0.391304f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-16896);
                Path h = c.h(looper);
                h.moveTo(52.173912f, 26.27763f);
                h.cubicTo(52.173912f, 11.621121f, 40.494686f, 0.0f, 25.764894f, 0.0f);
                h.cubicTo(11.679227f, 0.0f, 0.0f, 11.621121f, 0.0f, 26.27763f);
                h.cubicTo(0.0f, 40.29322f, 11.679227f, 51.91434f, 25.764894f, 51.91434f);
                h.cubicTo(40.494686f, 51.91434f, 52.173912f, 40.29322f, 52.173912f, 26.27763f);
                h.lineTo(52.173912f, 26.27763f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                a.setColor(-1);
                h = c.h(looper);
                h.moveTo(23.805798f, 13.323138f);
                h.lineTo(23.805798f, 13.323138f);
                h.cubicTo(23.804459f, 13.294402f, 23.80379f, 13.265638f, 23.80379f, 13.23687f);
                h.cubicTo(23.80379f, 12.213226f, 24.633615f, 11.383399f, 25.657259f, 11.383399f);
                h.lineTo(25.657259f, 11.383399f);
                h.lineTo(27.465271f, 11.383399f);
                h.cubicTo(27.494038f, 11.383399f, 27.522802f, 11.384069f, 27.551538f, 11.385408f);
                h.cubicTo(28.574074f, 11.433053f, 29.364378f, 12.300605f, 29.316732f, 13.323138f);
                h.lineTo(29.316732f, 13.323138f);
                h.lineTo(28.500492f, 30.840899f);
                h.cubicTo(28.47699f, 31.345303f, 28.0612f, 31.74217f, 27.556248f, 31.74217f);
                h.lineTo(27.556248f, 31.74217f);
                h.lineTo(25.566282f, 31.74217f);
                h.cubicTo(25.06133f, 31.74217f, 24.64554f, 31.345303f, 24.622036f, 30.840899f);
                h.lineTo(23.805798f, 13.323138f);
                h.lineTo(23.805798f, 13.323138f);
                h.close();
                h.moveTo(26.561264f, 40.790512f);
                h.cubicTo(24.989546f, 40.790512f, 23.715414f, 39.52455f, 23.715414f, 37.962906f);
                h.cubicTo(23.715414f, 36.401264f, 24.989546f, 35.1353f, 26.561264f, 35.1353f);
                h.cubicTo(28.132984f, 35.1353f, 29.407114f, 36.401264f, 29.407114f, 37.962906f);
                h.cubicTo(29.407114f, 39.52455f, 28.132984f, 40.790512f, 26.561264f, 40.790512f);
                h.lineTo(26.561264f, 40.790512f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
