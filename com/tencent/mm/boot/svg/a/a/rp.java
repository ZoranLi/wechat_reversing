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

public final class rp extends c {
    private final int height = 40;
    private final int width = 46;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 46;
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
                a.setColor(-16896);
                c = c.a(c, 1.0f, 0.0f, -149.0f, 0.0f, 1.0f, -661.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(151.0733f, 700.02264f);
                h.lineTo(151.0733f, 700.02264f);
                h.cubicTo(150.70924f, 700.02264f, 150.3521f, 699.9233f, 150.04036f, 699.7353f);
                h.cubicTo(149.09451f, 699.1648f, 148.7902f, 697.93555f, 149.36069f, 696.98975f);
                h.lineTo(149.36069f, 696.98975f);
                h.lineTo(170.08609f, 662.6272f);
                h.cubicTo(170.25401f, 662.34875f, 170.48732f, 662.1155f, 170.76575f, 661.9475f);
                h.cubicTo(171.7116f, 661.377f, 172.94083f, 661.68134f, 173.5113f, 662.6272f);
                h.lineTo(173.5113f, 662.6272f);
                h.lineTo(194.2367f, 696.98975f);
                h.cubicTo(194.42471f, 697.30145f, 194.52408f, 697.6586f, 194.52408f, 698.02264f);
                h.cubicTo(194.52408f, 699.12726f, 193.62866f, 700.02264f, 192.52408f, 700.02264f);
                h.lineTo(151.0733f, 700.02264f);
                h.close();
                h.moveTo(169.61902f, 675.9917f);
                h.lineTo(170.2866f, 687.9688f);
                h.lineTo(173.31001f, 687.9688f);
                h.lineTo(173.9776f, 675.9917f);
                h.cubicTo(174.0237f, 675.16455f, 173.39055f, 674.45667f, 172.5634f, 674.4105f);
                h.cubicTo(172.5356f, 674.409f, 172.50777f, 674.4082f, 172.47992f, 674.4082f);
                h.lineTo(171.1167f, 674.4082f);
                h.cubicTo(170.28827f, 674.4082f, 169.6167f, 675.0798f, 169.6167f, 675.9082f);
                h.cubicTo(169.6167f, 675.93604f, 169.61748f, 675.96387f, 169.61902f, 675.9917f);
                h.close();
                h.moveTo(171.79831f, 695.50244f);
                h.cubicTo(173.05064f, 695.50244f, 174.06586f, 694.4906f, 174.06586f, 693.2424f);
                h.cubicTo(174.06586f, 691.99414f, 173.05064f, 690.98224f, 171.79831f, 690.98224f);
                h.cubicTo(170.54597f, 690.98224f, 169.53076f, 691.99414f, 169.53076f, 693.2424f);
                h.cubicTo(169.53076f, 694.4906f, 170.54597f, 695.50244f, 171.79831f, 695.50244f);
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
