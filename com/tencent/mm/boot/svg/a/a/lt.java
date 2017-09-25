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

public final class lt extends c {
    private final int height = com.tencent.mm.plugin.appbrand.jsapi.map.c.CTRL_INDEX;
    private final int width = com.tencent.mm.plugin.appbrand.jsapi.map.c.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return com.tencent.mm.plugin.appbrand.jsapi.map.c.CTRL_INDEX;
            case 1:
                return com.tencent.mm.plugin.appbrand.jsapi.map.c.CTRL_INDEX;
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
                g2 = c.a(g, looper);
                g2.setColor(-1118482);
                canvas.save();
                Paint a = c.a(g2, looper);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(140.0f, 0.0f);
                h.lineTo(140.0f, 140.0f);
                h.lineTo(0.0f, 140.0f);
                h.lineTo(0.0f, 0.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                h.moveTo(45.81284f, 48.32145f);
                h.cubicTo(43.507927f, 53.37232f, 44.71574f, 59.12193f, 42.853695f, 64.27262f);
                h.cubicTo(40.629303f, 70.75091f, 35.747723f, 76.260956f, 35.22434f, 83.30821f);
                h.cubicTo(35.05323f, 86.81188f, 34.32854f, 91.20395f, 36.905212f, 93.988914f);
                h.cubicTo(40.04553f, 94.2185f, 42.129005f, 91.293785f, 44.36346f, 89.54694f);
                h.cubicTo(45.73232f, 92.9408f, 47.825863f, 95.96534f, 49.98986f, 98.91002f);
                h.cubicTo(47.785603f, 100.28753f, 44.28294f, 101.15596f, 43.970924f, 104.190475f);
                h.cubicTo(43.85014f, 107.11519f, 47.17163f, 108.452774f, 49.49667f, 109.23136f);
                h.cubicTo(56.451668f, 110.73864f, 64.433304f, 110.199615f, 69.99931f, 105.34838f);
                h.cubicTo(75.726364f, 110.199615f, 83.86904f, 110.87839f, 90.93475f, 109.11158f);
                h.cubicTo(93.14908f, 108.30304f, 96.33972f, 107.02535f, 95.98744f, 104.140564f);
                h.cubicTo(95.725746f, 101.03618f, 92.06204f, 100.17773f, 89.78733f, 98.86011f);
                h.cubicTo(92.3338f, 96.08512f, 94.36696f, 92.8909f, 95.836464f, 89.427155f);
                h.cubicTo(98.000465f, 91.293785f, 100.33557f, 94.79745f, 103.636925f, 93.76931f);
                h.cubicTo(105.5493f, 90.21573f, 104.99572f, 85.95344f, 104.6535f, 82.100395f);
                h.cubicTo(103.76778f, 74.41429f, 97.50727f, 68.644714f, 96.42024f, 61.028484f);
                h.cubicTo(95.8264f, 56.67635f, 95.92705f, 52.14454f, 94.13546f, 48.041954f);
                h.cubicTo(90.8341f, 39.187954f, 82.49012f, 32.260475f, 72.94839f, 31.21237f);
                h.cubicTo(61.272858f, 29.58531f, 49.667778f, 37.501003f, 45.81284f, 48.32145f);
                h.lineTo(45.81284f, 48.32145f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-4934220);
                float[] a2 = c.a(c, 1.0f, 0.0f, 35.0f, 0.0f, 1.0f, 30.0f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                canvas.save();
                Paint a3 = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(10.812839f, 18.321447f);
                h.cubicTo(14.667778f, 7.5010047f, 26.272856f, -0.4146892f, 37.94839f, 1.2123702f);
                h.cubicTo(47.49012f, 2.2604759f, 55.834103f, 9.187956f, 59.13546f, 18.041954f);
                h.cubicTo(60.927048f, 22.144539f, 60.826397f, 26.676348f, 61.42024f, 31.028482f);
                h.cubicTo(62.50727f, 38.64472f, 68.76778f, 44.41429f, 69.6535f, 52.1004f);
                h.cubicTo(69.99572f, 55.953434f, 70.5493f, 60.215733f, 68.636925f, 63.76931f);
                h.cubicTo(65.33557f, 64.79745f, 63.00046f, 61.29378f, 60.836464f, 59.42716f);
                h.cubicTo(59.366955f, 62.890896f, 57.333805f, 66.08512f, 54.78733f, 68.86011f);
                h.cubicTo(57.062046f, 70.17773f, 60.725746f, 71.03618f, 60.987442f, 74.140564f);
                h.cubicTo(61.339718f, 77.02535f, 58.14908f, 78.30304f, 55.934753f, 79.11158f);
                h.cubicTo(48.86904f, 80.87839f, 40.726364f, 80.199615f, 34.999313f, 75.34838f);
                h.cubicTo(29.433302f, 80.199615f, 21.451666f, 80.73864f, 14.496672f, 79.23136f);
                h.cubicTo(12.17163f, 78.452774f, 8.850142f, 77.11519f, 8.970922f, 74.190475f);
                h.cubicTo(9.282942f, 71.15596f, 12.785602f, 70.28753f, 14.9898615f, 68.91002f);
                h.cubicTo(12.825862f, 65.96534f, 10.732318f, 62.940807f, 9.363462f, 59.54694f);
                h.cubicTo(7.129007f, 61.29378f, 5.045528f, 64.2185f, 1.9052117f, 63.98891f);
                h.cubicTo(-0.67145795f, 61.203945f, 0.053230368f, 56.811882f, 0.22433734f, 53.308216f);
                h.cubicTo(0.74772334f, 46.260952f, 5.6293044f, 40.75091f, 7.853695f, 34.272617f);
                h.cubicTo(9.715741f, 29.12193f, 8.507928f, 23.37232f, 10.812839f, 18.321447f);
                h.lineTo(10.812839f, 18.321447f);
                h.close();
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
