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

public final class adk extends c {
    private final int height = 63;
    private final int width = 63;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 63;
            case 1:
                return 63;
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
                a.setColor(-1);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 3.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 18.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(5.0f, 5.0f);
                h.lineTo(5.0f, 34.0f);
                h.lineTo(34.0f, 34.0f);
                h.lineTo(34.0f, 5.0f);
                h.lineTo(5.0f, 5.0f);
                h.close();
                h.moveTo(0.0f, 1.5049495f);
                h.cubicTo(0.0f, 0.67378885f, 0.676918f, 0.0f, 1.5049495f, 0.0f);
                h.lineTo(37.495052f, 0.0f);
                h.cubicTo(38.32621f, 0.0f, 39.0f, 0.676918f, 39.0f, 1.5049495f);
                h.lineTo(39.0f, 37.495052f);
                h.cubicTo(39.0f, 38.32621f, 38.323082f, 39.0f, 37.495052f, 39.0f);
                h.lineTo(1.5049495f, 39.0f);
                h.cubicTo(0.67378885f, 39.0f, 0.0f, 38.323082f, 0.0f, 37.495052f);
                h.lineTo(0.0f, 1.5049495f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 1);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(52.925938f, 23.0f);
                h.cubicTo(52.974922f, 22.49169f, 53.0f, 21.976135f, 53.0f, 21.454546f);
                h.cubicTo(53.0f, 12.919235f, 46.28427f, 6.0f, 38.0f, 6.0f);
                h.cubicTo(35.866688f, 6.0f, 33.837387f, 6.4588375f, 32.0f, 7.285953f);
                h.lineTo(32.0f, 10.252686f);
                h.cubicTo(33.60105f, 9.50638f, 35.378433f, 9.090909f, 37.25f, 9.090909f);
                h.cubicTo(44.29163f, 9.090909f, 50.0f, 14.9722595f, 50.0f, 22.227272f);
                h.cubicTo(50.0f, 22.486673f, 49.992702f, 22.744318f, 49.978306f, 23.0f);
                h.lineTo(52.925938f, 23.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path h2 = c.h(looper);
                h2.moveTo(35.0f, 0.0f);
                h2.lineTo(26.0f, 7.4431515f);
                h2.lineTo(34.865273f, 15.0f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 1);
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
