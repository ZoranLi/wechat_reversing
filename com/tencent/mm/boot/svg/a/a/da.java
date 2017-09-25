package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
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

public final class da extends c {
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
                g2 = c.a(g, looper);
                g2.setColor(-2565928);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(144.0f, 0.0f);
                h.lineTo(144.0f, 144.0f);
                h.lineTo(0.0f, 144.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                canvas.saveLayerAlpha(null, 0, 4);
                canvas.drawPath(h, c.a(g2, looper));
                canvas.restore();
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-1);
                Path h2 = c.h(looper);
                h2.moveTo(72.0f, 102.0f);
                h2.cubicTo(55.431458f, 102.0f, 42.0f, 88.56854f, 42.0f, 72.0f);
                h2.cubicTo(42.0f, 55.431458f, 55.431458f, 42.0f, 72.0f, 42.0f);
                h2.cubicTo(88.56854f, 42.0f, 102.0f, 55.431458f, 102.0f, 72.0f);
                h2.cubicTo(102.0f, 88.56854f, 88.56854f, 102.0f, 72.0f, 102.0f);
                h2.close();
                h2.moveTo(72.0f, 96.0f);
                h2.cubicTo(85.25484f, 96.0f, 96.0f, 85.25484f, 96.0f, 72.0f);
                h2.cubicTo(96.0f, 58.745167f, 85.25484f, 48.0f, 72.0f, 48.0f);
                h2.cubicTo(72.0f, 64.35864f, 72.0f, 82.30664f, 72.0f, 96.0f);
                h2.close();
                h2.moveTo(3.0f, 69.0f);
                h2.lineTo(30.0f, 69.0f);
                h2.lineTo(30.0f, 75.0f);
                h2.lineTo(3.0f, 75.0f);
                h2.lineTo(3.0f, 69.0f);
                h2.close();
                h2.moveTo(69.0f, 3.0f);
                h2.lineTo(75.0f, 3.0f);
                h2.lineTo(75.0f, 30.0f);
                h2.lineTo(69.0f, 30.0f);
                h2.lineTo(69.0f, 3.0f);
                h2.close();
                h2.moveTo(69.0f, 114.0f);
                h2.lineTo(75.0f, 114.0f);
                h2.lineTo(75.0f, 141.0f);
                h2.lineTo(69.0f, 141.0f);
                h2.lineTo(69.0f, 114.0f);
                h2.close();
                h2.moveTo(114.0f, 69.0f);
                h2.lineTo(141.0f, 69.0f);
                h2.lineTo(141.0f, 75.0f);
                h2.lineTo(114.0f, 75.0f);
                h2.lineTo(114.0f, 69.0f);
                h2.close();
                h2.moveTo(25.330952f, 21.088312f);
                h2.lineTo(44.422836f, 40.180195f);
                h2.lineTo(40.180195f, 44.422836f);
                h2.lineTo(21.088312f, 25.330952f);
                h2.lineTo(25.330952f, 21.088312f);
                h2.close();
                h2.moveTo(118.669044f, 21.088312f);
                h2.lineTo(122.91169f, 25.330952f);
                h2.lineTo(103.8198f, 44.422836f);
                h2.lineTo(99.57716f, 40.180195f);
                h2.lineTo(118.669044f, 21.088312f);
                h2.close();
                h2.moveTo(40.180195f, 99.57716f);
                h2.lineTo(44.422836f, 103.8198f);
                h2.lineTo(25.330952f, 122.91169f);
                h2.lineTo(21.088312f, 118.669044f);
                h2.lineTo(40.180195f, 99.57716f);
                h2.close();
                h2.moveTo(103.8198f, 99.57716f);
                h2.lineTo(122.91169f, 118.669044f);
                h2.lineTo(118.669044f, 122.91169f);
                h2.lineTo(99.57716f, 103.8198f);
                h2.lineTo(103.8198f, 99.57716f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
