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

public final class tq extends c {
    private final int height = 1227;
    private final int width = 750;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 750;
            case 1:
                return 1227;
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
                c = c.a(c, 1.0f, 0.0f, -2000.0f, 0.0f, 1.0f, -904.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.restore();
                Paint a = c.a(g, looper);
                a.setColor(-16352813);
                Path h = c.h(looper);
                h.moveTo(68.52344f, 1227.0f);
                h.lineTo(849.0469f, 270.4297f);
                h.lineTo(5.891446E-14f, 92.80469f);
                h.lineTo(0.0f, 1227.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 1);
                canvas.saveLayerAlpha(null, 69, 4);
                a = c.a(a, looper);
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                a = c.a(g, looper);
                a.setColor(-13648396);
                h = c.h(looper);
                h.moveTo(801.0469f, -5.0f);
                h.lineTo(-62.109375f, 268.08594f);
                h.lineTo(-62.109375f, 550.77344f);
                h.lineTo(785.65625f, 1216.5469f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 1);
                canvas.saveLayerAlpha(null, 39, 4);
                a = c.a(a, looper);
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                a = c.a(g, looper);
                a.setColor(-16473373);
                h = c.h(looper);
                h.moveTo(-88.0f, 1110.8438f);
                h.lineTo(903.0781f, 1334.7344f);
                h.lineTo(855.39844f, 564.83594f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 1);
                canvas.saveLayerAlpha(null, 103, 4);
                a = c.a(a, looper);
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
