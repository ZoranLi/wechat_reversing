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

public final class ahc extends c {
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
                canvas.save();
                g2 = c.a(g, looper);
                g2.setColor(-1710619);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(144.0f, 0.0f);
                h.lineTo(144.0f, 146.0f);
                h.lineTo(0.0f, 146.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                canvas.drawPath(h, g2);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(WebView.NIGHT_MODE_COLOR);
                Path h2 = c.h(looper);
                h2.moveTo(59.612698f, 75.461945f);
                h2.lineTo(95.98885f, 75.461945f);
                h2.lineTo(95.98885f, 69.461945f);
                h2.lineTo(59.357864f, 69.461945f);
                h2.lineTo(75.57716f, 53.24264f);
                h2.lineTo(71.334526f, 49.0f);
                h2.lineTo(48.0f, 72.334526f);
                h2.lineTo(50.12132f, 74.45584f);
                h2.lineTo(71.334526f, 95.669044f);
                h2.lineTo(75.57716f, 91.42641f);
                h2.lineTo(59.612698f, 75.461945f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, g);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
