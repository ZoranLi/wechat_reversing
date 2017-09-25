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

public final class tr extends c {
    private final int height = 60;
    private final int width = 60;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                a.setColor(-16139513);
                c = c.a(c, 1.0f, 0.0f, -345.0f, 0.0f, 1.0f, -473.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 40.0f, 0.0f, 1.0f, 403.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 305.0f, 0.0f, 1.0f, 70.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(60.0f, 30.37037f);
                h.cubicTo(60.0f, 46.56889f, 46.56889f, 60.0f, 29.62963f, 60.0f);
                h.cubicTo(13.431111f, 60.0f, 0.0f, 46.56889f, 0.0f, 30.37037f);
                h.cubicTo(0.0f, 13.431111f, 13.431111f, 0.0f, 29.62963f, 0.0f);
                h.cubicTo(46.56889f, 0.0f, 60.0f, 13.431111f, 60.0f, 30.37037f);
                h.close();
                h.moveTo(15.577749f, 32.460346f);
                h.lineTo(24.47927f, 41.67298f);
                h.cubicTo(24.862179f, 42.06927f, 25.488976f, 42.073776f, 25.882545f, 41.686443f);
                h.lineTo(46.24788f, 21.643913f);
                h.cubicTo(46.63556f, 21.26238f, 46.64444f, 20.630444f, 46.25456f, 20.2454f);
                h.lineTo(45.93083f, 19.92568f);
                h.cubicTo(45.543224f, 19.542885f, 44.883877f, 19.512583f, 44.46322f, 19.863024f);
                h.lineTo(25.932226f, 35.30084f);
                h.cubicTo(25.518642f, 35.64539f, 24.817387f, 35.66468f, 24.381721f, 35.33077f);
                h.lineTo(17.411554f, 29.988533f);
                h.cubicTo(16.979122f, 29.657099f, 16.359636f, 29.7419f, 16.035114f, 30.183472f);
                h.lineTo(15.474698f, 30.946018f);
                h.cubicTo(15.1507f, 31.386875f, 15.196312f, 32.06558f, 15.577749f, 32.460346f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
