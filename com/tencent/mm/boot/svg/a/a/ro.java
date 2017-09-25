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

public final class ro extends c {
    private final int height = 33;
    private final int width = 33;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 33;
            case 1:
                return 33;
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
                a.setColor(-1);
                c = c.a(c, 1.0f, 0.0f, -226.0f, 0.0f, 1.0f, -665.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                a = c.a(a, looper);
                c = c.a(c, 0.70710677f, -0.70710677f, 553.11835f, 0.70710677f, 0.70710677f, 28.051147f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                Path h = c.h(looper);
                h.moveTo(244.19849f, 680.1985f);
                h.lineTo(244.19849f, 660.6985f);
                h.lineTo(241.19849f, 660.6985f);
                h.lineTo(241.19849f, 680.1985f);
                h.lineTo(221.69849f, 680.1985f);
                h.lineTo(221.69849f, 683.1985f);
                h.lineTo(241.19849f, 683.1985f);
                h.lineTo(241.19849f, 702.6985f);
                h.lineTo(244.19849f, 702.6985f);
                h.lineTo(244.19849f, 683.1985f);
                h.lineTo(263.6985f, 683.1985f);
                h.lineTo(263.6985f, 680.1985f);
                h.lineTo(244.19849f, 680.1985f);
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
