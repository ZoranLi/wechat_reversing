package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.map.f;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class ain extends c {
    private final int height = f.CTRL_INDEX;
    private final int width = f.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return f.CTRL_INDEX;
            case 1:
                return f.CTRL_INDEX;
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
                c = c.a(c, -1.0f, 1.2246469E-16f, 120.0f, -1.2246469E-16f, -1.0f, 120.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, -2.4492937E-16f, 1.175661E-14f, 2.4492937E-16f, 1.0f, -1.4210855E-14f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(96.0f, 0.0f);
                h.lineTo(96.0f, 96.0f);
                h.lineTo(0.0f, 96.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                canvas.restore();
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-9473160);
                float[] a2 = c.a(c, -1.0f, 1.2246469E-16f, 96.0f, -1.2246469E-16f, -1.0f, 76.0f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                Path h2 = c.h(looper);
                h2.moveTo(26.0f, 22.998102f);
                h2.cubicTo(26.0f, 21.89458f, 26.886707f, 21.0f, 27.998102f, 21.0f);
                h2.lineTo(32.0019f, 21.0f);
                h2.cubicTo(33.10542f, 21.0f, 34.0f, 21.886707f, 34.0f, 22.998102f);
                h2.lineTo(34.0f, 27.001898f);
                h2.cubicTo(34.0f, 28.10542f, 33.113293f, 29.0f, 32.0019f, 29.0f);
                h2.lineTo(27.998102f, 29.0f);
                h2.cubicTo(26.89458f, 29.0f, 26.0f, 28.113293f, 26.0f, 27.001898f);
                h2.lineTo(26.0f, 22.998102f);
                h2.close();
                h2.moveTo(26.0f, 34.9981f);
                h2.cubicTo(26.0f, 33.89458f, 26.886707f, 33.0f, 27.998102f, 33.0f);
                h2.lineTo(32.0019f, 33.0f);
                h2.cubicTo(33.10542f, 33.0f, 34.0f, 33.886707f, 34.0f, 34.9981f);
                h2.lineTo(34.0f, 39.0019f);
                h2.cubicTo(34.0f, 40.10542f, 33.113293f, 41.0f, 32.0019f, 41.0f);
                h2.lineTo(27.998102f, 41.0f);
                h2.cubicTo(26.89458f, 41.0f, 26.0f, 40.113293f, 26.0f, 39.0019f);
                h2.lineTo(26.0f, 34.9981f);
                h2.close();
                h2.moveTo(50.0f, 22.998102f);
                h2.cubicTo(50.0f, 21.89458f, 50.886707f, 21.0f, 51.9981f, 21.0f);
                h2.lineTo(56.0019f, 21.0f);
                h2.cubicTo(57.10542f, 21.0f, 58.0f, 21.886707f, 58.0f, 22.998102f);
                h2.lineTo(58.0f, 27.001898f);
                h2.cubicTo(58.0f, 28.10542f, 57.113293f, 29.0f, 56.0019f, 29.0f);
                h2.lineTo(51.9981f, 29.0f);
                h2.cubicTo(50.89458f, 29.0f, 50.0f, 28.113293f, 50.0f, 27.001898f);
                h2.lineTo(50.0f, 22.998102f);
                h2.close();
                h2.moveTo(50.0f, 34.9981f);
                h2.cubicTo(50.0f, 33.89458f, 50.886707f, 33.0f, 51.9981f, 33.0f);
                h2.lineTo(56.0019f, 33.0f);
                h2.cubicTo(57.10542f, 33.0f, 58.0f, 33.886707f, 58.0f, 34.9981f);
                h2.lineTo(58.0f, 39.0019f);
                h2.cubicTo(58.0f, 40.10542f, 57.113293f, 41.0f, 56.0019f, 41.0f);
                h2.lineTo(51.9981f, 41.0f);
                h2.cubicTo(50.89458f, 41.0f, 50.0f, 40.113293f, 50.0f, 39.0019f);
                h2.lineTo(50.0f, 34.9981f);
                h2.close();
                h2.moveTo(38.0f, 22.998102f);
                h2.cubicTo(38.0f, 21.89458f, 38.886707f, 21.0f, 39.9981f, 21.0f);
                h2.lineTo(44.0019f, 21.0f);
                h2.cubicTo(45.10542f, 21.0f, 46.0f, 21.886707f, 46.0f, 22.998102f);
                h2.lineTo(46.0f, 27.001898f);
                h2.cubicTo(46.0f, 28.10542f, 45.113293f, 29.0f, 44.0019f, 29.0f);
                h2.lineTo(39.9981f, 29.0f);
                h2.cubicTo(38.89458f, 29.0f, 38.0f, 28.113293f, 38.0f, 27.001898f);
                h2.lineTo(38.0f, 22.998102f);
                h2.close();
                h2.moveTo(38.0f, 34.9981f);
                h2.cubicTo(38.0f, 33.89458f, 38.886707f, 33.0f, 39.9981f, 33.0f);
                h2.lineTo(44.0019f, 33.0f);
                h2.cubicTo(45.10542f, 33.0f, 46.0f, 33.886707f, 46.0f, 34.9981f);
                h2.lineTo(46.0f, 39.0019f);
                h2.cubicTo(46.0f, 40.10542f, 45.113293f, 41.0f, 44.0019f, 41.0f);
                h2.lineTo(39.9981f, 41.0f);
                h2.cubicTo(38.89458f, 41.0f, 38.0f, 40.113293f, 38.0f, 39.0019f);
                h2.lineTo(38.0f, 34.9981f);
                h2.close();
                h2.moveTo(62.0f, 22.998102f);
                h2.cubicTo(62.0f, 21.89458f, 62.886707f, 21.0f, 63.9981f, 21.0f);
                h2.lineTo(68.0019f, 21.0f);
                h2.cubicTo(69.10542f, 21.0f, 70.0f, 21.886707f, 70.0f, 22.998102f);
                h2.lineTo(70.0f, 27.001898f);
                h2.cubicTo(70.0f, 28.10542f, 69.1133f, 29.0f, 68.0019f, 29.0f);
                h2.lineTo(63.9981f, 29.0f);
                h2.cubicTo(62.89458f, 29.0f, 62.0f, 28.113293f, 62.0f, 27.001898f);
                h2.lineTo(62.0f, 22.998102f);
                h2.close();
                h2.moveTo(62.0f, 34.9981f);
                h2.cubicTo(62.0f, 33.89458f, 62.886707f, 33.0f, 63.9981f, 33.0f);
                h2.lineTo(68.0019f, 33.0f);
                h2.cubicTo(69.10542f, 33.0f, 70.0f, 33.886707f, 70.0f, 34.9981f);
                h2.lineTo(70.0f, 39.0019f);
                h2.cubicTo(70.0f, 40.10542f, 69.1133f, 41.0f, 68.0019f, 41.0f);
                h2.lineTo(63.9981f, 41.0f);
                h2.cubicTo(62.89458f, 41.0f, 62.0f, 40.113293f, 62.0f, 39.0019f);
                h2.lineTo(62.0f, 34.9981f);
                h2.close();
                h2.moveTo(34.0f, 48.9981f);
                h2.cubicTo(34.0f, 47.89458f, 34.8999f, 47.0f, 35.991245f, 47.0f);
                h2.lineTo(60.008755f, 47.0f);
                h2.cubicTo(61.10849f, 47.0f, 62.0f, 47.886707f, 62.0f, 48.9981f);
                h2.lineTo(62.0f, 53.0019f);
                h2.cubicTo(62.0f, 54.10542f, 61.1001f, 55.0f, 60.008755f, 55.0f);
                h2.lineTo(35.991245f, 55.0f);
                h2.cubicTo(34.89151f, 55.0f, 34.0f, 54.113293f, 34.0f, 53.0019f);
                h2.lineTo(34.0f, 48.9981f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a);
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                a.setColor(419430400);
                a2 = c.a(a2, 1.0f, -2.4492937E-16f, 9.307316E-15f, 2.4492937E-16f, 1.0f, -1.4210855E-14f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                h2 = c.h(looper);
                h2.moveTo(7.0f, 13.0f);
                h2.cubicTo(7.0f, 9.686291f, 9.686291f, 7.0f, 13.0f, 7.0f);
                h2.lineTo(83.0f, 7.0f);
                h2.cubicTo(86.313705f, 7.0f, 89.0f, 9.686291f, 89.0f, 13.0f);
                h2.lineTo(89.0f, 63.0f);
                h2.cubicTo(89.0f, 66.313705f, 86.313705f, 69.0f, 83.0f, 69.0f);
                h2.lineTo(13.0f, 69.0f);
                h2.cubicTo(9.686291f, 69.0f, 7.0f, 66.313705f, 7.0f, 63.0f);
                h2.lineTo(7.0f, 13.0f);
                h2.close();
                canvas.drawPath(h2, a);
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                a.setColor(-9473160);
                h2 = c.h(looper);
                h2.moveTo(7.0f, 13.001155f);
                h2.cubicTo(7.0f, 9.686809f, 9.681666f, 7.0f, 12.996433f, 7.0f);
                h2.lineTo(83.00356f, 7.0f);
                h2.cubicTo(86.31531f, 7.0f, 89.0f, 9.683963f, 89.0f, 13.001155f);
                h2.lineTo(89.0f, 62.998844f);
                h2.cubicTo(89.0f, 66.313194f, 86.31834f, 69.0f, 83.00356f, 69.0f);
                h2.lineTo(12.996433f, 69.0f);
                h2.cubicTo(9.684694f, 69.0f, 7.0f, 66.31604f, 7.0f, 62.998844f);
                h2.lineTo(7.0f, 13.001155f);
                h2.close();
                h2.moveTo(9.0f, 13.009459f);
                h2.cubicTo(9.0f, 10.795095f, 10.794424f, 9.0f, 13.002277f, 9.0f);
                h2.lineTo(82.99772f, 9.0f);
                h2.cubicTo(85.20812f, 9.0f, 87.0f, 10.799425f, 87.0f, 13.009459f);
                h2.lineTo(87.0f, 62.99054f);
                h2.cubicTo(87.0f, 65.2049f, 85.205574f, 67.0f, 82.99772f, 67.0f);
                h2.lineTo(13.002277f, 67.0f);
                h2.cubicTo(10.791881f, 67.0f, 9.0f, 65.20058f, 9.0f, 62.99054f);
                h2.lineTo(9.0f, 13.009459f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-9473160);
                c = c.a(a2, 1.0f, -2.4492937E-16f, 2.0880946E-14f, 2.4492937E-16f, 1.0f, -1.4210855E-14f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                h2 = c.h(looper);
                h2.moveTo(39.0f, 80.0f);
                h2.lineTo(57.0f, 80.0f);
                h2.lineTo(48.0f, 90.50586f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 1);
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, g);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
