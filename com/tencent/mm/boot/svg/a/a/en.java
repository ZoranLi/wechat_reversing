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

public final class en extends c {
    private final int height = 372;
    private final int width = 438;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 438;
            case 1:
                return 372;
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
                a.setColor(WebView.NIGHT_MODE_COLOR);
                c = c.a(c, 1.0f, 0.0f, 120.0f, 0.0f, 1.0f, 6.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(13.0f, 114.0f);
                h.lineTo(13.0f, 39.0f);
                h.lineTo(185.0f, 39.0f);
                h.lineTo(185.0f, 312.0f);
                h.lineTo(13.0f, 312.0f);
                h.lineTo(13.0f, 219.46962f);
                h.lineTo(14.5f, 219.46962f);
                h.lineTo(14.5f, 310.5f);
                h.lineTo(183.5f, 310.5f);
                h.lineTo(183.5f, 40.5f);
                h.lineTo(14.5f, 40.5f);
                h.lineTo(14.5f, 114.0f);
                h.lineTo(13.0f, 114.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path h2 = c.h(looper);
                h2.moveTo(0.0f, 114.0f);
                h2.lineTo(0.0f, 15.991757f);
                h2.cubicTo(0.0f, 7.1708655f, 7.160596f, 0.0f, 15.993638f, 0.0f);
                h2.lineTo(182.00636f, 0.0f);
                h2.cubicTo(190.8361f, 0.0f, 198.0f, 7.1597533f, 198.0f, 15.991757f);
                h2.lineTo(198.0f, 344.00824f);
                h2.cubicTo(198.0f, 352.82913f, 190.8394f, 360.0f, 182.00636f, 360.0f);
                h2.lineTo(15.993638f, 360.0f);
                h2.cubicTo(7.1638985f, 360.0f, 0.0f, 352.84024f, 0.0f, 344.00824f);
                h2.lineTo(0.0f, 219.46962f);
                h2.lineTo(3.0f, 219.46962f);
                h2.lineTo(3.0f, 344.00754f);
                h2.cubicTo(3.0f, 351.18307f, 8.824723f, 357.0f, 16.008371f, 357.0f);
                h2.lineTo(181.99162f, 357.0f);
                h2.cubicTo(189.17595f, 357.0f, 195.0f, 351.18747f, 195.0f, 344.00754f);
                h2.lineTo(195.0f, 15.992457f);
                h2.cubicTo(195.0f, 8.816921f, 189.17528f, 3.0f, 181.99162f, 3.0f);
                h2.lineTo(16.008371f, 3.0f);
                h2.cubicTo(8.824047f, 3.0f, 3.0f, 8.812543f, 3.0f, 15.992457f);
                h2.lineTo(3.0f, 114.0f);
                h2.lineTo(7.1054274E-15f, 114.0f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a3);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(86.0f, 18.0f);
                h.lineTo(112.0f, 18.0f);
                h.lineTo(112.0f, 21.0f);
                h.lineTo(86.0f, 21.0f);
                h.lineTo(86.0f, 18.0f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a3 = c.a(g, looper);
                a3.setColor(WebView.NIGHT_MODE_COLOR);
                h2 = c.h(looper);
                h2.moveTo(60.651176f, 249.89926f);
                h2.lineTo(60.595497f, 225.46962f);
                h2.lineTo(33.888363f, 225.46962f);
                h2.cubicTo(27.33306f, 225.46962f, 22.0f, 220.17123f, 22.0f, 213.65854f);
                h2.lineTo(22.0f, 131.81108f);
                h2.cubicTo(22.0f, 125.298386f, 27.33306f, 120.0f, 33.888363f, 120.0f);
                h2.lineTo(160.11163f, 120.0f);
                h2.cubicTo(166.66695f, 120.0f, 172.0f, 125.298386f, 172.0f, 131.81108f);
                h2.lineTo(172.0f, 213.65854f);
                h2.cubicTo(172.0f, 220.17123f, 166.66695f, 225.46962f, 160.11163f, 225.46962f);
                h2.lineTo(97.138374f, 225.46962f);
                h2.lineTo(69.358574f, 253.56952f);
                h2.cubicTo(68.354385f, 254.50647f, 67.109116f, 254.99985f, 65.80787f, 255.0f);
                h2.cubicTo(62.971363f, 255.0003f, 60.6581f, 252.7121f, 60.651176f, 249.89926f);
                h2.close();
                h2.moveTo(63.58853f, 247.54555f);
                h2.lineTo(63.608063f, 222.6283f);
                h2.lineTo(36.50444f, 222.48622f);
                h2.cubicTo(28.85407f, 222.5878f, 25.13076f, 218.84735f, 25.09161f, 211.1126f);
                h2.lineTo(25.0f, 134.37363f);
                h2.cubicTo(25.132122f, 125.48259f, 30.013842f, 122.979996f, 36.41283f, 123.0f);
                h2.lineTo(157.58717f, 123.0f);
                h2.cubicTo(167.20503f, 123.0f, 169.02705f, 128.21953f, 169.0f, 134.37363f);
                h2.lineTo(169.09161f, 211.1126f);
                h2.cubicTo(169.11636f, 218.63168f, 166.0281f, 222.59373f, 157.67879f, 222.48622f);
                h2.lineTo(95.95168f, 222.58171f);
                h2.lineTo(68.555214f, 250.40294f);
                h2.cubicTo(67.59119f, 251.30519f, 66.85377f, 251.84087f, 65.63155f, 251.84087f);
                h2.cubicTo(63.608063f, 251.86566f, 63.595177f, 250.2542f, 63.58853f, 247.54555f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(g, looper);
                a3.setColor(-564640);
                h2 = c.h(looper);
                h2.moveTo(130.0f, 171.40741f);
                h2.cubicTo(130.0f, 152.77422f, 115.22578f, 138.0f, 96.59259f, 138.0f);
                h2.cubicTo(78.77422f, 138.0f, 64.0f, 152.77422f, 64.0f, 171.40741f);
                h2.cubicTo(64.0f, 189.22578f, 78.77422f, 204.0f, 96.59259f, 204.0f);
                h2.cubicTo(115.22578f, 204.0f, 130.0f, 189.22578f, 130.0f, 171.40741f);
                h2.close();
                h2.moveTo(127.0f, 171.37038f);
                h2.cubicTo(127.0f, 154.4311f, 113.568886f, 141.0f, 96.62963f, 141.0f);
                h2.cubicTo(80.431114f, 141.0f, 67.0f, 154.4311f, 67.0f, 171.37038f);
                h2.cubicTo(67.0f, 187.5689f, 80.431114f, 201.0f, 96.62963f, 201.0f);
                h2.cubicTo(113.568886f, 201.0f, 127.0f, 187.5689f, 127.0f, 171.37038f);
                h2.close();
                h2.moveTo(97.07629f, 156.97f);
                h2.cubicTo(95.41943f, 156.97f, 94.14113f, 158.31671f, 94.22063f, 159.96783f);
                h2.lineTo(94.931946f, 174.74138f);
                h2.cubicTo(95.011665f, 176.39705f, 96.41936f, 177.73923f, 98.06692f, 177.73923f);
                h2.lineTo(96.085655f, 177.73923f);
                h2.cubicTo(97.737335f, 177.73923f, 99.14113f, 176.3925f, 99.22063f, 174.74138f);
                h2.lineTo(99.931946f, 159.96783f);
                h2.cubicTo(100.011665f, 158.31218f, 98.729774f, 156.97f, 97.07629f, 156.97f);
                h2.close();
                h2.moveTo(97.07629f, 186.97f);
                h2.cubicTo(98.73314f, 186.97f, 100.07629f, 185.67851f, 100.07629f, 184.08537f);
                h2.cubicTo(100.07629f, 182.49225f, 98.73314f, 181.20076f, 97.07629f, 181.20076f);
                h2.cubicTo(95.41943f, 181.20076f, 94.07629f, 182.49225f, 94.07629f, 184.08537f);
                h2.cubicTo(94.07629f, 185.67851f, 95.41943f, 186.97f, 97.07629f, 186.97f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a3);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}