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

public final class afl extends c {
    private final int height = 129;
    private final int width = 129;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 129;
            case 1:
                return 129;
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
                c = c.a(c, 1.0f, 0.0f, 13.0f, 0.0f, 1.0f, 13.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-1150121);
                float[] a2 = c.a(c, 1.0f, 0.0f, 31.0f, 0.0f, 1.0f, 0.0f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                canvas.save();
                a = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(1.0f, 3.8065174f);
                h.cubicTo(12.045206f, -0.7156839f, 24.602074f, -1.1991264f, 36.0f, 2.3058314f);
                h.cubicTo(35.798447f, 14.20053f, 35.46588f, 26.09523f, 35.19378f, 38.0f);
                h.cubicTo(23.795855f, 26.608887f, 12.387849f, 15.217773f, 1.0f, 3.8065174f);
                h.lineTo(1.0f, 3.8065174f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                a.setColor(-9676047);
                a2 = c.a(a2, 1.0f, 0.0f, 70.0f, 0.0f, 1.0f, 4.0f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                canvas.save();
                a = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(1.0240741f, 0.0f);
                h.cubicTo(12.452677f, 4.1678624f, 21.496967f, 13.53802f, 27.0f, 24.213774f);
                h.cubicTo(18.388306f, 32.52941f, 9.676009f, 40.74462f, 1.0140136f, 49.0f);
                h.cubicTo(1.0039533f, 32.659973f, 0.98383254f, 16.329987f, 1.0240741f, 0.0f);
                h.lineTo(1.0240741f, 0.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                a.setColor(-16384);
                a2 = c.a(a2, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 5.0f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                canvas.save();
                a = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(0.0f, 25.98406f);
                h.cubicTo(4.1862326f, 14.546246f, 13.542512f, 5.4925656f, 24.22393f, 0.0f);
                h.cubicTo(32.526123f, 8.621115f, 40.737965f, 17.322708f, 49.0f, 25.98406f);
                h.cubicTo(32.666668f, 25.994122f, 16.333334f, 26.01424f, 0.0f, 25.98406f);
                h.lineTo(0.0f, 25.98406f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                a.setColor(-10970130);
                a2 = c.a(a2, 1.0f, 0.0f, 64.0f, 0.0f, 1.0f, 31.0f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                canvas.save();
                a = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(0.0f, 35.192852f);
                h.cubicTo(11.398648f, 23.781782f, 22.797297f, 12.390891f, 34.216137f, 1.0f);
                h.cubicTo(38.719055f, 12.057941f, 39.19358f, 24.59902f, 35.690186f, 36.0f);
                h.cubicTo(23.796824f, 35.788124f, 11.90346f, 35.465263f, 0.0f, 35.192852f);
                h.lineTo(0.0f, 35.192852f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                a.setColor(-1124019);
                a2 = c.a(a2, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 35.0f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                canvas.save();
                a = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(2.276762f, 1.0f);
                h.cubicTo(14.184508f, 1.2217742f, 26.092255f, 1.5443548f, 38.0f, 1.8165323f);
                h.cubicTo(26.616114f, 13.207662f, 15.242303f, 24.618952f, 3.8382685f, 36.0f);
                h.cubicTo(-0.6951373f, 24.951612f, -1.2089233f, 12.40121f, 2.276762f, 1.0f);
                h.lineTo(2.276762f, 1.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                a.setColor(-5117108);
                a2 = c.a(a2, 1.0f, 0.0f, 5.0f, 0.0f, 1.0f, 48.0f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                canvas.save();
                a = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(27.987633f, 1.0f);
                h.cubicTo(27.947277f, 17.333334f, 28.078432f, 33.666668f, 27.917011f, 50.0f);
                h.cubicTo(23.518278f, 49.399876f, 19.815678f, 46.80935f, 16.264406f, 44.348846f);
                h.cubicTo(9.9185295f, 39.65789f, 4.369671f, 33.616657f, 1.0f, 26.455194f);
                h.cubicTo(10.049685f, 18.033476f, 18.968214f, 9.471729f, 27.987633f, 1.0f);
                h.lineTo(27.987633f, 1.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                a.setColor(-10818218);
                a2 = c.a(a2, 1.0f, 0.0f, 37.0f, 0.0f, 1.0f, 64.0f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                canvas.save();
                a = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(0.8420746f, 0.0f);
                h.cubicTo(11.907926f, 11.243707f, 22.924242f, 22.527784f, 34.0f, 33.751305f);
                h.cubicTo(23.33042f, 38.343662f, 11.174826f, 39.352974f, 0.0f, 36.092903f);
                h.cubicTo(0.2972028f, 24.061935f, 0.5547786f, 12.030968f, 0.8420746f, 0.0f);
                h.lineTo(0.8420746f, 0.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-11083026);
                c = c.a(a2, 1.0f, 0.0f, 51.0f, 0.0f, 1.0f, 70.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a3 = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(0.0f, 1.004426f);
                h.cubicTo(15.663328f, 0.99446756f, 31.326656f, 1.004426f, 47.0f, 1.004426f);
                h.cubicTo(42.41317f, 11.610118f, 34.160877f, 20.502966f, 23.965694f, 26.0f);
                h.cubicTo(15.973791f, 17.664822f, 7.981888f, 9.349562f, 0.0f, 1.004426f);
                h.lineTo(0.0f, 1.004426f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
