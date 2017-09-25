package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.cs;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class za extends c {
    private final int height = 73;
    private final int width = 68;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 68;
            case 1:
                return 73;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.d(looper);
                c.c(looper);
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
                canvas.saveLayerAlpha(null, cs.CTRL_INDEX, 4);
                g = c.a(g, looper);
                g.setColor(-12414890);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(19.8f, 13.5f);
                h.lineTo(7.014761f, 13.5f);
                h.cubicTo(5.1207285f, 13.5f, 3.6f, 15.027811f, 3.6f, 16.91246f);
                h.lineTo(3.6f, 29.7f);
                h.lineTo(7.2f, 29.7f);
                h.lineTo(7.2f, 20.517391f);
                h.cubicTo(7.2f, 18.630018f, 8.731914f, 17.1f, 10.622746f, 17.1f);
                h.lineTo(19.8f, 17.1f);
                h.lineTo(19.8f, 13.5f);
                h.close();
                h.moveTo(47.7f, 13.5f);
                h.lineTo(60.485237f, 13.5f);
                h.cubicTo(62.37116f, 13.5f, 63.9f, 15.027175f, 63.9f, 16.91246f);
                h.lineTo(63.9f, 29.7f);
                h.lineTo(60.3f, 29.7f);
                h.lineTo(60.3f, 20.517391f);
                h.cubicTo(60.3f, 18.629005f, 58.767586f, 17.1f, 56.877254f, 17.1f);
                h.lineTo(47.7f, 17.1f);
                h.lineTo(47.7f, 13.5f);
                h.close();
                h.moveTo(63.9f, 43.2f);
                h.lineTo(63.9f, 55.987537f);
                h.cubicTo(63.9f, 57.87219f, 62.379272f, 59.4f, 60.485237f, 59.4f);
                h.lineTo(47.7f, 59.4f);
                h.lineTo(47.7f, 55.8f);
                h.lineTo(56.877254f, 55.8f);
                h.cubicTo(58.768085f, 55.8f, 60.3f, 54.26998f, 60.3f, 52.38261f);
                h.lineTo(60.3f, 43.2f);
                h.lineTo(63.9f, 43.2f);
                h.close();
                h.moveTo(19.8f, 59.4f);
                h.lineTo(7.014761f, 59.4f);
                h.cubicTo(5.1288404f, 59.4f, 3.6f, 57.872826f, 3.6f, 55.987537f);
                h.lineTo(3.6f, 43.2f);
                h.lineTo(7.2f, 43.2f);
                h.lineTo(7.2f, 52.38261f);
                h.cubicTo(7.2f, 54.270996f, 8.732416f, 55.8f, 10.622746f, 55.8f);
                h.lineTo(19.8f, 55.8f);
                h.lineTo(19.8f, 59.4f);
                h.close();
                h.moveTo(20.108116f, 36.142143f);
                h.cubicTo(19.937948f, 35.946686f, 19.946568f, 35.64093f, 20.131533f, 35.45503f);
                h.lineTo(20.838032f, 34.74497f);
                h.cubicTo(21.021133f, 34.560947f, 21.341198f, 34.526764f, 21.565907f, 34.677326f);
                h.lineTo(28.990614f, 39.65209f);
                h.cubicTo(29.209509f, 39.79875f, 29.55232f, 39.78469f, 29.761065f, 39.61685f);
                h.lineTo(49.556328f, 23.700794f);
                h.cubicTo(49.76294f, 23.53467f, 50.077003f, 23.547306f, 50.261967f, 23.733206f);
                h.lineTo(50.968468f, 24.443266f);
                h.cubicTo(51.151566f, 24.627289f, 51.159294f, 24.928797f, 50.980556f, 25.12167f);
                h.cubicTo(50.980556f, 25.12167f, 44.03342f, 32.66838f, 40.34348f, 35.788235f);
                h.cubicTo(37.325737f, 39.566574f, 29.73397f, 46.481808f, 29.73397f, 46.481808f);
                h.cubicTo(29.54232f, 46.65754f, 29.251432f, 46.644333f, 29.07884f, 46.44609f);
                h.lineTo(20.108116f, 36.142143f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
