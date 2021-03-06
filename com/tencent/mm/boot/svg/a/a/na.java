package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class na extends c {
    private final int height = JsApiOpenWeRunSetting.CTRL_INDEX;
    private final int width = JsApiOpenWeRunSetting.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return JsApiOpenWeRunSetting.CTRL_INDEX;
            case 1:
                return JsApiOpenWeRunSetting.CTRL_INDEX;
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
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(228.0f, 0.0f);
                h.lineTo(228.0f, 228.0f);
                h.lineTo(0.0f, 228.0f);
                h.lineTo(0.0f, 0.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                h.moveTo(81.9f, 51.52f);
                h.cubicTo(80.59f, 54.6f, 79.27f, 57.71f, 78.65f, 61.02f);
                h.cubicTo(73.07f, 61.09f, 67.48f, 60.88f, 61.9f, 61.06f);
                h.cubicTo(57.69f, 60.97f, 53.94f, 64.73f, 54.05f, 68.94f);
                h.cubicTo(53.93f, 85.6f, 54.02f, 102.26f, 54.01f, 118.91f);
                h.cubicTo(54.04f, 135.28f, 53.99f, 151.65f, 53.99f, 168.02f);
                h.cubicTo(53.28f, 178.64f, 62.26f, 188.73f, 72.95f, 188.95f);
                h.cubicTo(86.92f, 189.09f, 100.9f, 188.94f, 114.87f, 189.01f);
                h.cubicTo(103.56f, 177.33f, 99.78f, 159.0f, 105.98f, 143.9f);
                h.cubicTo(110.23f, 132.75f, 119.51f, 124.03f, 130.47f, 119.55f);
                h.cubicTo(133.62f, 118.96f, 136.65f, 117.7f, 139.87f, 117.37f);
                h.cubicTo(152.1f, 115.63f, 164.78f, 119.78f, 174.01f, 127.9f);
                h.cubicTo(173.95f, 108.23f, 174.08f, 88.56f, 173.94f, 68.9f);
                h.cubicTo(174.04f, 64.68f, 170.26f, 60.93f, 166.04f, 61.06f);
                h.cubicTo(160.49f, 60.91f, 154.92f, 61.06f, 149.37f, 61.05f);
                h.cubicTo(148.33f, 55.47f, 145.67f, 50.36f, 142.4f, 45.78f);
                h.cubicTo(134.57f, 35.85f, 121.41f, 30.45f, 108.88f, 32.4f);
                h.cubicTo(97.44f, 33.88f, 87.25f, 41.38f, 81.9f, 51.52f);
                h.lineTo(81.9f, 51.52f);
                h.close();
                h.moveTo(156.17f, 139.12f);
                h.cubicTo(150.77f, 141.93f, 153.05f, 151.46f, 159.01f, 151.89f);
                h.cubicTo(162.92f, 152.07f, 165.04f, 147.41f, 163.99f, 144.07f);
                h.cubicTo(163.35f, 140.71f, 159.64f, 137.46f, 156.17f, 139.12f);
                h.lineTo(156.17f, 139.12f);
                h.close();
                h.moveTo(124.47f, 147.62f);
                h.cubicTo(119.22f, 150.42f, 121.29f, 159.62f, 127.06f, 160.35f);
                h.cubicTo(130.47f, 160.75f, 132.87f, 157.17f, 132.54f, 154.06f);
                h.cubicTo(132.56f, 150.13f, 128.55f, 145.76f, 124.47f, 147.62f);
                h.lineTo(124.47f, 147.62f);
                h.close();
                h.moveTo(122.58f, 174.43f);
                h.cubicTo(128.87f, 186.78f, 145.37f, 192.26f, 157.73f, 185.89f);
                h.cubicTo(167.18f, 181.52f, 173.07f, 171.29f, 172.93f, 160.99f);
                h.cubicTo(156.12f, 165.4f, 139.36f, 169.96f, 122.58f, 174.43f);
                h.lineTo(122.58f, 174.43f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(89.56f, 52.35f);
                h.cubicTo(94.15f, 45.43f, 101.6f, 40.38f, 109.89f, 39.31f);
                h.cubicTo(118.41f, 37.98f, 127.29f, 40.89f, 133.65f, 46.64f);
                h.cubicTo(137.78f, 50.5f, 140.74f, 55.53f, 142.14f, 61.01f);
                h.cubicTo(123.38f, 61.02f, 104.62f, 61.03f, 85.86f, 61.01f);
                h.cubicTo(86.67f, 57.96f, 87.89f, 55.03f, 89.56f, 52.35f);
                h.lineTo(89.56f, 52.35f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                float[] a3 = c.a(c, 1.0f, 0.0f, 53.0f, 0.0f, 1.0f, 60.0f);
                d.reset();
                d.setValues(a3);
                canvas.concat(d);
                g2 = c.a(g, looper);
                g2.setColor(-23226);
                canvas.save();
                Paint a4 = c.a(g2, looper);
                h = c.h(looper);
                h.moveTo(1.01f, 58.91f);
                h.cubicTo(24.33f, 59.22f, 47.66f, 58.91f, 70.99f, 59.07f);
                h.cubicTo(73.15f, 59.17f, 75.3f, 59.43f, 77.47f, 59.55f);
                h.cubicTo(66.51f, 64.03f, 57.23f, 72.75f, 52.98f, 83.9f);
                h.cubicTo(46.78f, 99.0f, 50.56f, 117.33f, 61.87f, 129.01f);
                h.cubicTo(47.9f, 128.94f, 33.92f, 129.09f, 19.95f, 128.95f);
                h.cubicTo(9.26f, 128.73f, 0.28f, 118.64f, 0.99f, 108.02f);
                h.cubicTo(0.99f, 91.65f, 1.04f, 75.28f, 1.01f, 58.91f);
                h.close();
                h.moveTo(8.9f, 1.06f);
                h.cubicTo(14.48f, 0.88f, 107.49f, 0.91f, 113.04f, 1.06f);
                h.cubicTo(117.26f, 0.93f, 121.04f, 4.68f, 120.94f, 8.9f);
                h.cubicTo(121.08f, 28.56f, 120.95f, 48.23f, 121.01f, 67.9f);
                h.cubicTo(111.78f, 59.78f, 99.1f, 55.63f, 86.87f, 57.37f);
                h.cubicTo(83.65f, 57.7f, 80.62f, 58.96f, 77.47f, 59.55f);
                h.cubicTo(75.3f, 59.43f, 73.15f, 59.17f, 70.99f, 59.07f);
                h.cubicTo(47.66f, 58.91f, 24.33f, 59.22f, 1.01f, 58.91f);
                h.cubicTo(1.02f, 42.26f, 0.93f, 25.6f, 1.05f, 8.94f);
                h.cubicTo(0.94f, 4.73f, 4.69f, 0.97f, 8.9f, 1.06f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a4);
                canvas.restore();
                canvas.save();
                a2 = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(1.01f, 58.91f);
                h.cubicTo(24.33f, 59.22f, 47.66f, 58.91f, 70.99f, 59.07f);
                h.cubicTo(73.15f, 59.17f, 75.3f, 59.43f, 77.47f, 59.55f);
                h.cubicTo(66.51f, 64.03f, 57.23f, 72.75f, 52.98f, 83.9f);
                h.cubicTo(46.78f, 99.0f, 50.56f, 117.33f, 61.87f, 129.01f);
                h.cubicTo(47.9f, 128.94f, 33.92f, 129.09f, 19.95f, 128.95f);
                h.cubicTo(9.26f, 128.73f, 0.28f, 118.64f, 0.99f, 108.02f);
                h.cubicTo(0.99f, 91.65f, 1.04f, 75.28f, 1.01f, 58.91f);
                h.close();
                h.moveTo(8.9f, 1.06f);
                h.cubicTo(14.48f, 0.88f, 107.49f, 0.91f, 113.04f, 1.06f);
                h.cubicTo(117.26f, 0.93f, 121.04f, 4.68f, 120.94f, 8.9f);
                h.cubicTo(121.08f, 28.56f, 120.95f, 48.23f, 121.01f, 67.9f);
                h.cubicTo(111.78f, 59.78f, 99.1f, 55.63f, 86.87f, 57.37f);
                h.cubicTo(83.65f, 57.7f, 80.62f, 58.96f, 77.47f, 59.55f);
                h.cubicTo(75.3f, 59.43f, 73.15f, 59.17f, 70.99f, 59.07f);
                h.cubicTo(47.66f, 58.91f, 24.33f, 59.22f, 1.01f, 58.91f);
                h.cubicTo(1.02f, 42.26f, 0.93f, 25.6f, 1.05f, 8.94f);
                h.cubicTo(0.94f, 4.73f, 4.69f, 0.97f, 8.9f, 1.06f);
                h.close();
                Paint g3 = c.g(looper);
                g3.setFlags(385);
                g3.setStyle(Style.FILL);
                Paint g4 = c.g(looper);
                g4.setFlags(385);
                g4.setStyle(Style.STROKE);
                g3.setColor(WebView.NIGHT_MODE_COLOR);
                g4.setStrokeWidth(1.0f);
                g4.setStrokeCap(Cap.BUTT);
                g4.setStrokeJoin(Join.MITER);
                g4.setStrokeMiter(4.0f);
                g4.setPathEffect(null);
                float[] a5 = c.a(a3, 121.08f, 0.0f, 0.28f, 0.0f, 129.09f, 0.88f);
                d.reset();
                d.setValues(a5);
                WeChatSVGRenderC2Java.setLinearGradient(a2, 0.5f, 0.0f, 0.5f, 1.0f, new int[]{-20658, -23226}, new float[]{0.0f, 1.0f}, d, 0);
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a4 = c.a(g, looper);
                a4.setColor(-22969);
                a3 = c.a(a5, 1.0f, 0.0f, 153.0f, 0.0f, 1.0f, 138.0f);
                d.reset();
                d.setValues(a3);
                canvas.concat(d);
                canvas.save();
                a4 = c.a(a4, looper);
                h = c.h(looper);
                h.moveTo(3.17f, 1.12f);
                h.cubicTo(6.64f, -0.54f, 10.35f, 2.71f, 10.99f, 6.07f);
                h.cubicTo(12.04f, 9.41f, 9.92f, 14.07f, 6.01f, 13.89f);
                h.cubicTo(0.05f, 13.46f, -2.23f, 3.93f, 3.17f, 1.12f);
                h.lineTo(3.17f, 1.12f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a4);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a4 = c.a(g, looper);
                a4.setColor(-23482);
                a3 = c.a(a3, 1.0f, 0.0f, 121.0f, 0.0f, 1.0f, 147.0f);
                d.reset();
                d.setValues(a3);
                canvas.concat(d);
                canvas.save();
                a4 = c.a(a4, looper);
                h = c.h(looper);
                h.moveTo(3.47f, 0.62f);
                h.cubicTo(7.55f, -1.24f, 11.56f, 3.13f, 11.54f, 7.06f);
                h.cubicTo(11.87f, 10.17f, 9.47f, 13.75f, 6.06f, 13.35f);
                h.cubicTo(0.29f, 12.62f, -1.78f, 3.42f, 3.47f, 0.62f);
                h.lineTo(3.47f, 0.62f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a4);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a4 = c.a(g, looper);
                a4.setColor(-24252);
                a3 = c.a(a3, 1.0f, 0.0f, 122.0f, 0.0f, 1.0f, 160.0f);
                d.reset();
                d.setValues(a3);
                canvas.concat(d);
                canvas.save();
                a4 = c.a(a4, looper);
                h = c.h(looper);
                h.moveTo(0.58f, 14.43f);
                h.cubicTo(17.36f, 9.96f, 34.12f, 5.4f, 50.93f, 0.99f);
                h.cubicTo(51.07f, 11.29f, 45.18f, 21.52f, 35.73f, 25.89f);
                h.cubicTo(23.37f, 32.26f, 6.87f, 26.78f, 0.58f, 14.43f);
                h.lineTo(0.58f, 14.43f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a4);
                canvas.restore();
                canvas.restore();
                g2 = c.a(g, looper);
                g2.setColor(-2565928);
                canvas.save();
                a4 = c.a(g2, looper);
                h = c.h(looper);
                h.moveTo(149.96889f, 66.49903f);
                h.cubicTo(149.17722f, 47.31203f, 133.37628f, 32.0f, 114.0f, 32.0f);
                h.cubicTo(94.62372f, 32.0f, 78.822784f, 47.31203f, 78.03111f, 66.49903f);
                h.lineTo(78.03111f, 66.49905f);
                h.lineTo(78.0f, 66.49905f);
                h.lineTo(78.0f, 77.49905f);
                h.cubicTo(78.0f, 79.43257f, 79.567f, 81.0f, 81.5f, 81.0f);
                h.cubicTo(83.433f, 81.0f, 85.0f, 79.43257f, 85.0f, 77.49905f);
                h.lineTo(85.0f, 68.00984f);
                h.cubicTo(85.0f, 51.989204f, 97.98374f, 39.001915f, 114.0f, 39.001915f);
                h.cubicTo(130.01625f, 39.001915f, 143.0f, 51.989204f, 143.0f, 68.00984f);
                h.lineTo(143.0f, 77.49905f);
                h.cubicTo(143.0f, 79.43257f, 144.567f, 81.0f, 146.5f, 81.0f);
                h.cubicTo(148.433f, 81.0f, 150.0f, 79.43257f, 150.0f, 77.49905f);
                h.lineTo(150.0f, 66.49905f);
                h.lineTo(149.96889f, 66.49905f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a4);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(149.96889f, 66.49903f);
                h.cubicTo(149.17722f, 47.31203f, 133.37628f, 32.0f, 114.0f, 32.0f);
                h.cubicTo(94.62372f, 32.0f, 78.822784f, 47.31203f, 78.03111f, 66.49903f);
                h.lineTo(78.03111f, 66.49905f);
                h.lineTo(78.0f, 66.49905f);
                h.lineTo(78.0f, 77.49905f);
                h.cubicTo(78.0f, 79.43257f, 79.567f, 81.0f, 81.5f, 81.0f);
                h.cubicTo(83.433f, 81.0f, 85.0f, 79.43257f, 85.0f, 77.49905f);
                h.lineTo(85.0f, 68.00984f);
                h.cubicTo(85.0f, 51.989204f, 97.98374f, 39.001915f, 114.0f, 39.001915f);
                h.cubicTo(130.01625f, 39.001915f, 143.0f, 51.989204f, 143.0f, 68.00984f);
                h.lineTo(143.0f, 77.49905f);
                h.cubicTo(143.0f, 79.43257f, 144.567f, 81.0f, 146.5f, 81.0f);
                h.cubicTo(148.433f, 81.0f, 150.0f, 79.43257f, 150.0f, 77.49905f);
                h.lineTo(150.0f, 66.49905f);
                h.lineTo(149.96889f, 66.49905f);
                h.close();
                g3 = c.g(looper);
                g3.setFlags(385);
                g3.setStyle(Style.FILL);
                g4 = c.g(looper);
                g4.setFlags(385);
                g4.setStyle(Style.STROKE);
                g3.setColor(WebView.NIGHT_MODE_COLOR);
                g4.setStrokeWidth(1.0f);
                g4.setStrokeCap(Cap.BUTT);
                g4.setStrokeJoin(Join.MITER);
                g4.setStrokeMiter(4.0f);
                g4.setPathEffect(null);
                float[] a6 = c.a(a3, 150.0f, 0.0f, 78.0f, 0.0f, 81.0f, 32.0f);
                d.reset();
                d.setValues(a6);
                WeChatSVGRenderC2Java.setLinearGradient(g, 0.5f, 0.0f, 0.5f, 1.0f, new int[]{-285618, -2524112}, new float[]{0.0f, 1.0f}, d, 0);
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
