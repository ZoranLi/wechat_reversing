package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class adu extends c {
    private final int height = 64;
    private final int width = 38;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 38;
            case 1:
                return 64;
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
                g = c.a(g, looper);
                g.setColor(-1);
                canvas.save();
                g2 = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(38.0f, 0.0f);
                h.lineTo(38.0f, 3.1230671f);
                h.lineTo(0.0f, 3.1230671f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                canvas.drawPath(h, g2);
                canvas.restore();
                canvas.save();
                g2 = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(3.9542723f, 13.915369f);
                h.lineTo(5.7826085f, 15.157895f);
                h.lineTo(0.0f, 15.157895f);
                h.lineTo(0.0f, 6.965601f);
                h.lineTo(38.0f, 6.965601f);
                h.lineTo(38.0f, 15.157895f);
                h.lineTo(32.217392f, 15.157895f);
                h.lineTo(34.045727f, 13.915369f);
                h.lineTo(34.924232f, 13.915369f);
                h.lineTo(34.924232f, 10.105263f);
                h.lineTo(3.0557573f, 10.105263f);
                h.lineTo(3.0557573f, 13.915369f);
                h.lineTo(3.9542723f, 13.915369f);
                h.close();
                h.moveTo(32.217392f, 15.157895f);
                h.lineTo(38.0f, 15.157895f);
                h.lineTo(28.086956f, 22.37594f);
                h.lineTo(28.086956f, 64.0f);
                h.lineTo(9.913043f, 64.0f);
                h.lineTo(9.913043f, 22.37594f);
                h.lineTo(0.0f, 15.157895f);
                h.lineTo(5.7826085f, 15.157895f);
                h.lineTo(13.217391f, 20.210526f);
                h.lineTo(24.782608f, 20.210526f);
                h.lineTo(32.217392f, 15.157895f);
                h.close();
                h.moveTo(13.062004f, 20.210526f);
                h.lineTo(24.988686f, 20.210526f);
                h.lineTo(24.988686f, 60.93955f);
                h.lineTo(13.062004f, 60.93955f);
                h.lineTo(13.062004f, 20.210526f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g2);
                canvas.restore();
                canvas.save();
                Paint a = c.a(g, looper);
                Path h2 = c.h(looper);
                h2.moveTo(19.0f, 27.022888f);
                h2.cubicTo(20.368706f, 27.022888f, 21.47826f, 25.816298f, 21.47826f, 24.421053f);
                h2.cubicTo(21.47826f, 23.025806f, 20.368706f, 21.894737f, 19.0f, 21.894737f);
                h2.cubicTo(17.631294f, 21.894737f, 16.52174f, 23.025806f, 16.52174f, 24.421053f);
                h2.cubicTo(16.52174f, 25.816298f, 17.631294f, 27.022888f, 19.0f, 27.022888f);
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
