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

public final class dn extends c {
    private final int height = 40;
    private final int width = 44;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 44;
            case 1:
                return 40;
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
                a.setColor(-9074981);
                c = c.a(c, 1.0f, 0.0f, -298.0f, 0.0f, 1.0f, -661.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(322.0f, 663.0f);
                h.cubicTo(320.0f, 664.0f, 316.5f, 668.1991f, 317.0f, 672.0f);
                h.lineTo(317.0f, 689.0f);
                h.cubicTo(316.5f, 691.797f, 313.4775f, 695.2222f, 310.0f, 695.0f);
                h.cubicTo(306.02176f, 695.2222f, 303.0f, 691.797f, 303.0f, 689.0f);
                h.cubicTo(303.0f, 686.67645f, 305.0f, 683.0f, 307.0f, 683.0f);
                h.cubicTo(309.0f, 683.0f, 311.0f, 681.0f, 310.0f, 679.0f);
                h.cubicTo(309.0f, 677.0f, 306.0f, 677.87036f, 305.0f, 678.0f);
                h.cubicTo(304.0f, 678.12964f, 300.0f, 681.0f, 299.0f, 683.0f);
                h.cubicTo(298.0f, 685.0f, 298.0f, 686.8411f, 298.0f, 689.0f);
                h.cubicTo(298.0f, 694.9784f, 302.7195f, 701.0f, 310.0f, 701.0f);
                h.cubicTo(312.23026f, 701.0f, 315.0f, 700.0f, 317.0f, 699.0f);
                h.cubicTo(319.0f, 698.0f, 322.5f, 692.8009f, 322.0f, 689.0f);
                h.lineTo(322.0f, 672.0f);
                h.cubicTo(322.5f, 669.203f, 325.52176f, 666.7778f, 329.0f, 667.0f);
                h.cubicTo(332.9775f, 666.7778f, 337.0f, 669.203f, 337.0f, 672.0f);
                h.cubicTo(337.0f, 674.41455f, 335.0f, 677.0f, 332.0f, 678.0f);
                h.cubicTo(329.0f, 679.0f, 328.0f, 680.0f, 329.0f, 682.0f);
                h.cubicTo(330.0f, 684.0f, 333.0f, 683.0f, 334.0f, 683.0f);
                h.cubicTo(335.0f, 683.0f, 339.0f, 680.0f, 340.0f, 678.0f);
                h.cubicTo(341.0f, 676.0f, 342.0f, 674.1589f, 342.0f, 672.0f);
                h.cubicTo(342.0f, 666.0216f, 336.2805f, 661.0f, 329.0f, 661.0f);
                h.cubicTo(326.76974f, 661.0f, 324.0f, 662.0f, 322.0f, 663.0f);
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
