package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class afz extends c {
    private final int height = 162;
    private final int width = h.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return h.CTRL_INDEX;
            case 1:
                return 162;
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
                g2.setColor(-4284563);
                canvas.save();
                Paint a = c.a(g2, looper);
                Path h = c.h(looper);
                h.moveTo(139.15747f, 1.3074749f);
                h.cubicTo(138.74416f, 0.58537644f, 137.73692f, 0.0f, 136.90393f, 0.0f);
                h.lineTo(73.09608f, 0.0f);
                h.cubicTo(72.26479f, 0.0f, 71.25955f, 0.5789027f, 70.84252f, 1.3074749f);
                h.lineTo(53.248386f, 32.045467f);
                h.cubicTo(52.835064f, 32.767567f, 51.836205f, 33.35294f, 50.9994f, 33.35294f);
                h.lineTo(4.498816f, 33.35294f);
                h.cubicTo(2.0141885f, 33.35294f, 0.0f, 35.37368f, 0.0f, 37.856125f);
                h.lineTo(0.0f, 157.49681f);
                h.cubicTo(0.0f, 159.98386f, 2.0111012f, 162.0f, 4.5077453f, 162.0f);
                h.lineTo(205.49225f, 162.0f);
                h.cubicTo(207.98181f, 162.0f, 210.0f, 159.97926f, 210.0f, 157.49681f);
                h.lineTo(210.0f, 37.856125f);
                h.cubicTo(210.0f, 35.369087f, 207.99011f, 33.35294f, 205.50119f, 33.35294f);
                h.lineTo(159.0006f, 33.35294f);
                h.cubicTo(158.17184f, 33.35294f, 157.16864f, 32.77404f, 156.75162f, 32.045467f);
                h.lineTo(139.15747f, 1.3074749f);
                h.close();
                h.moveTo(105.0f, 147.70589f);
                h.cubicTo(136.63086f, 147.70589f, 162.27272f, 122.1071f, 162.27272f, 90.52941f);
                h.cubicTo(162.27272f, 58.951717f, 136.63086f, 33.35294f, 105.0f, 33.35294f);
                h.cubicTo(73.36915f, 33.35294f, 47.727272f, 58.951717f, 47.727272f, 90.52941f);
                h.cubicTo(47.727272f, 122.1071f, 73.36915f, 147.70589f, 105.0f, 147.70589f);
                h.close();
                h.moveTo(105.0f, 133.41176f);
                h.cubicTo(128.72314f, 133.41176f, 147.95454f, 114.212685f, 147.95454f, 90.52941f);
                h.cubicTo(147.95454f, 66.846146f, 128.72314f, 47.64706f, 105.0f, 47.64706f);
                h.cubicTo(81.27686f, 47.64706f, 62.045456f, 66.846146f, 62.045456f, 90.52941f);
                h.cubicTo(62.045456f, 114.212685f, 81.27686f, 133.41176f, 105.0f, 133.41176f);
                h.close();
                h.moveTo(14.318182f, 14.294118f);
                h.lineTo(14.318182f, 23.82353f);
                h.lineTo(42.954544f, 23.82353f);
                h.lineTo(42.954544f, 14.294118f);
                h.lineTo(14.318182f, 14.294118f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(139.15747f, 1.3074749f);
                h.cubicTo(138.74416f, 0.58537644f, 137.73692f, 0.0f, 136.90393f, 0.0f);
                h.lineTo(73.09608f, 0.0f);
                h.cubicTo(72.26479f, 0.0f, 71.25955f, 0.5789027f, 70.84252f, 1.3074749f);
                h.lineTo(53.248386f, 32.045467f);
                h.cubicTo(52.835064f, 32.767567f, 51.836205f, 33.35294f, 50.9994f, 33.35294f);
                h.lineTo(4.498816f, 33.35294f);
                h.cubicTo(2.0141885f, 33.35294f, 0.0f, 35.37368f, 0.0f, 37.856125f);
                h.lineTo(0.0f, 157.49681f);
                h.cubicTo(0.0f, 159.98386f, 2.0111012f, 162.0f, 4.5077453f, 162.0f);
                h.lineTo(205.49225f, 162.0f);
                h.cubicTo(207.98181f, 162.0f, 210.0f, 159.97926f, 210.0f, 157.49681f);
                h.lineTo(210.0f, 37.856125f);
                h.cubicTo(210.0f, 35.369087f, 207.99011f, 33.35294f, 205.50119f, 33.35294f);
                h.lineTo(159.0006f, 33.35294f);
                h.cubicTo(158.17184f, 33.35294f, 157.16864f, 32.77404f, 156.75162f, 32.045467f);
                h.lineTo(139.15747f, 1.3074749f);
                h.close();
                h.moveTo(105.0f, 147.70589f);
                h.cubicTo(136.63086f, 147.70589f, 162.27272f, 122.1071f, 162.27272f, 90.52941f);
                h.cubicTo(162.27272f, 58.951717f, 136.63086f, 33.35294f, 105.0f, 33.35294f);
                h.cubicTo(73.36915f, 33.35294f, 47.727272f, 58.951717f, 47.727272f, 90.52941f);
                h.cubicTo(47.727272f, 122.1071f, 73.36915f, 147.70589f, 105.0f, 147.70589f);
                h.close();
                h.moveTo(105.0f, 133.41176f);
                h.cubicTo(128.72314f, 133.41176f, 147.95454f, 114.212685f, 147.95454f, 90.52941f);
                h.cubicTo(147.95454f, 66.846146f, 128.72314f, 47.64706f, 105.0f, 47.64706f);
                h.cubicTo(81.27686f, 47.64706f, 62.045456f, 66.846146f, 62.045456f, 90.52941f);
                h.cubicTo(62.045456f, 114.212685f, 81.27686f, 133.41176f, 105.0f, 133.41176f);
                h.close();
                h.moveTo(14.318182f, 14.294118f);
                h.lineTo(14.318182f, 23.82353f);
                h.lineTo(42.954544f, 23.82353f);
                h.lineTo(42.954544f, 14.294118f);
                h.lineTo(14.318182f, 14.294118f);
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
                float[] a2 = c.a(c, 210.0f, 0.0f, 0.0f, 0.0f, 162.0f, 0.0f);
                d.reset();
                d.setValues(a2);
                WeChatSVGRenderC2Java.setLinearGradient(a, 0.7940693f, 0.8090447f, 0.08431214f, 0.07970222f, new int[]{-4284307, -3429513}, new float[]{0.0f, 1.0f}, d, 0);
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
