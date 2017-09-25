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

public final class kk extends c {
    private final int height = 292;
    private final int width = 378;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 378;
            case 1:
                return 292;
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
                a.setColor(-13158344);
                canvas.save();
                float[] a2 = c.a(c, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 3.0f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(14.0f, 226.0f);
                h.lineTo(360.0f, 226.0f);
                h.lineTo(360.0f, 14.0f);
                h.lineTo(14.0f, 14.0f);
                h.lineTo(14.0f, 226.0f);
                h.close();
                h.moveTo(13.0f, 227.0f);
                h.lineTo(361.0f, 227.0f);
                h.lineTo(361.0f, 13.0f);
                h.lineTo(13.0f, 13.0f);
                h.lineTo(13.0f, 227.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.save();
                Paint a4 = c.a(a, looper);
                Path h2 = c.h(looper);
                h2.moveTo(371.0002f, 225.9932f);
                h2.cubicTo(371.0002f, 232.0622f, 366.0632f, 237.0002f, 359.9932f, 237.0002f);
                h2.lineTo(206.0002f, 237.0002f);
                h2.lineTo(206.0002f, 237.0002f);
                h2.lineTo(168.0002f, 237.0002f);
                h2.lineTo(168.0002f, 237.0002f);
                h2.lineTo(14.0062f, 237.0002f);
                h2.cubicTo(7.9382f, 237.0002f, 3.0002f, 232.0622f, 3.0002f, 225.9932f);
                h2.lineTo(3.0002f, 14.0072f);
                h2.cubicTo(3.0002f, 7.9372f, 7.9382f, 3.0002f, 14.0062f, 3.0002f);
                h2.lineTo(359.9932f, 3.0002f);
                h2.cubicTo(366.0632f, 3.0002f, 371.0002f, 7.9372f, 371.0002f, 14.0072f);
                h2.lineTo(371.0002f, 225.9932f);
                h2.close();
                h2.moveTo(256.0002f, 278.7302f);
                h2.lineTo(256.0002f, 284.0002f);
                h2.lineTo(118.0002f, 284.0002f);
                h2.lineTo(118.0002f, 278.7302f);
                h2.lineTo(171.0002f, 273.7302f);
                h2.lineTo(171.0002f, 240.0002f);
                h2.lineTo(203.0002f, 240.0002f);
                h2.lineTo(203.0002f, 273.7302f);
                h2.lineTo(256.0002f, 278.7302f);
                h2.close();
                h2.moveTo(359.9932f, 2.0E-4f);
                h2.lineTo(14.0072f, 2.0E-4f);
                h2.cubicTo(6.2762f, 2.0E-4f, 2.0E-4f, 6.2712f, 2.0E-4f, 14.0072f);
                h2.lineTo(2.0E-4f, 225.9932f);
                h2.cubicTo(2.0E-4f, 233.7342f, 6.2712f, 240.0002f, 14.0072f, 240.0002f);
                h2.lineTo(168.0002f, 240.0002f);
                h2.lineTo(168.0002f, 271.0002f);
                h2.lineTo(115.0002f, 276.0002f);
                h2.lineTo(115.0002f, 287.0002f);
                h2.lineTo(259.0002f, 287.0002f);
                h2.lineTo(259.0002f, 276.0002f);
                h2.lineTo(206.0002f, 271.0002f);
                h2.lineTo(206.0002f, 240.0002f);
                h2.lineTo(359.9932f, 240.0002f);
                h2.cubicTo(367.7242f, 240.0002f, 374.0002f, 233.7292f, 374.0002f, 225.9932f);
                h2.lineTo(374.0002f, 14.0072f);
                h2.cubicTo(374.0002f, 6.2652f, 367.7292f, 2.0E-4f, 359.9932f, 2.0E-4f);
                h2.lineTo(359.9932f, 2.0E-4f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a4);
                canvas.restore();
                canvas.restore();
                canvas.save();
                c = c.a(a2, 1.0f, 0.0f, 166.0f, 0.0f, 1.0f, 93.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a5 = c.a(a, looper);
                h2 = c.h(looper);
                h2.moveTo(43.0895f, 21.9691f);
                h2.lineTo(43.0895f, 49.9671f);
                h2.lineTo(3.0895f, 49.9651f);
                h2.lineTo(3.0895f, 21.9691f);
                h2.lineTo(3.0905f, 21.9671f);
                h2.lineTo(8.9995f, 21.9671f);
                h2.lineTo(8.9995f, 18.9671f);
                h2.lineTo(3.0905f, 18.9671f);
                h2.cubicTo(1.4415f, 18.9671f, 0.0895f, 20.3111f, 0.0895f, 21.9691f);
                h2.lineTo(0.0895f, 49.9651f);
                h2.cubicTo(0.0895f, 51.6241f, 1.4335f, 52.9671f, 3.0905f, 52.9671f);
                h2.lineTo(43.0895f, 52.9671f);
                h2.cubicTo(44.7385f, 52.9671f, 46.0895f, 51.6231f, 46.0895f, 49.9651f);
                h2.lineTo(46.0895f, 21.9691f);
                h2.cubicTo(46.0895f, 20.3101f, 44.7465f, 18.9671f, 43.0895f, 18.9671f);
                h2.lineTo(36.9995f, 18.9671f);
                h2.lineTo(36.9995f, 21.9691f);
                h2.lineTo(43.0895f, 21.9691f);
                h2.lineTo(43.0895f, 21.9691f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a5);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(12.0f, 19.0f);
                h.lineTo(34.0f, 19.0f);
                h.lineTo(34.0f, 18.967f);
                h.lineTo(12.0f, 18.967f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 1);
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.save();
                a5 = c.a(a, looper);
                h2 = c.h(looper);
                h2.moveTo(9.0f, 13.4978f);
                h2.lineTo(9.0f, 18.9668f);
                h2.lineTo(12.0f, 18.9668f);
                h2.lineTo(12.0f, 13.4978f);
                h2.cubicTo(12.0f, 7.7088f, 16.714f, 3.0008f, 22.508f, 3.0008f);
                h2.lineTo(23.492f, 3.0008f);
                h2.cubicTo(29.286f, 3.0008f, 34.0f, 7.7088f, 34.0f, 13.4978f);
                h2.lineTo(34.0f, 18.9668f);
                h2.lineTo(37.0f, 18.9668f);
                h2.lineTo(37.0f, 13.4978f);
                h2.cubicTo(37.0f, 6.0438f, 30.952f, -2.0E-4f, 23.492f, -2.0E-4f);
                h2.lineTo(22.508f, -2.0E-4f);
                h2.cubicTo(15.041f, -2.0E-4f, 9.0f, 6.0428f, 9.0f, 13.4978f);
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a5);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(37.0f, 22.0f);
                h.lineTo(37.0f, 21.969f);
                h.lineTo(9.0f, 21.967f);
                h.lineTo(9.0f, 22.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 1);
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(33.9997f, 19.0003f);
                h.lineTo(11.9997f, 19.0003f);
                h.lineTo(11.9997f, 18.9673f);
                h.lineTo(8.9997f, 18.9673f);
                h.lineTo(8.9997f, 21.9673f);
                h.lineTo(36.9997f, 21.9683f);
                h.lineTo(36.9997f, 18.9673f);
                h.lineTo(33.9997f, 18.9673f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 1);
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
