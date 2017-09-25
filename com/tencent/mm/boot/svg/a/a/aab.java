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

public final class aab extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                c = c.a(c, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 27.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(7.0f, 1.0f);
                h.cubicTo(10.526494f, -1.3853347f, 15.476821f, 1.5766289f, 14.0f, 5.0f);
                h.cubicTo(7.392988f, 12.569689f, 5.9232f, 23.522991f, 11.0f, 32.0f);
                h.cubicTo(11.93504f, 34.386837f, 14.650065f, 36.63316f, 14.0f, 40.0f);
                h.cubicTo(12.914899f, 42.31854f, 8.964845f, 42.795635f, 7.0f, 41.0f);
                h.cubicTo(-2.6607683f, 29.516495f, -2.181046f, 11.8341675f, 7.0f, 1.0f);
                h.lineTo(7.0f, 1.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(51.0f, 2.0f);
                h.cubicTo(51.81792f, -0.5502939f, 54.604008f, -0.16187043f, 57.0f, 1.0f);
                h.cubicTo(66.176994f, 11.769702f, 66.65665f, 29.467869f, 57.0f, 41.0f);
                h.cubicTo(55.236748f, 42.504955f, 51.83833f, 42.504955f, 51.0f, 40.0f);
                h.cubicTo(49.133884f, 38.062984f, 50.82799f, 35.712524f, 52.0f, 34.0f);
                h.cubicTo(57.3901f, 26.250925f, 57.51256f, 15.444786f, 52.0f, 8.0f);
                h.cubicTo(50.99128f, 6.013067f, 48.960392f, 3.782122f, 51.0f, 2.0f);
                h.lineTo(51.0f, 2.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(18.0f, 7.0f);
                h.cubicTo(20.819609f, 5.5211906f, 24.681755f, 10.051395f, 22.0f, 13.0f);
                h.cubicTo(19.615078f, 16.237059f, 18.668661f, 20.876305f, 20.0f, 25.0f);
                h.cubicTo(20.695332f, 26.992579f, 23.085274f, 28.112738f, 23.0f, 30.0f);
                h.cubicTo(22.989677f, 33.426064f, 19.060612f, 35.21039f, 17.0f, 33.0f);
                h.cubicTo(11.584872f, 25.703897f, 11.508394f, 14.214823f, 18.0f, 7.0f);
                h.lineTo(18.0f, 7.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(43.0f, 7.0f);
                h.cubicTo(44.48336f, 6.7782235f, 45.84865f, 6.9965997f, 47.0f, 8.0f);
                h.cubicTo(51.157063f, 13.766257f, 52.436428f, 22.223366f, 49.0f, 29.0f);
                h.cubicTo(48.130505f, 30.958408f, 47.366707f, 33.916412f, 45.0f, 34.0f);
                h.cubicTo(41.762325f, 34.36309f, 39.67142f, 29.975716f, 42.0f, 28.0f);
                h.cubicTo(45.82001f, 23.791702f, 45.01802f, 16.972414f, 42.0f, 13.0f);
                h.cubicTo(40.20608f, 11.02663f, 41.218117f, 7.979292f, 43.0f, 7.0f);
                h.lineTo(43.0f, 7.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(30.0f, 13.0f);
                h.cubicTo(35.026703f, 11.379892f, 41.03034f, 16.427767f, 40.0f, 22.0f);
                h.cubicTo(39.239254f, 27.1483f, 31.95484f, 29.994547f, 28.0f, 26.0f);
                h.cubicTo(23.189528f, 23.102068f, 24.520334f, 15.15836f, 30.0f, 13.0f);
                h.lineTo(30.0f, 13.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
