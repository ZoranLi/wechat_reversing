package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class jq extends c {
    private final int height = 62;
    private final int width = 62;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 62;
            case 1:
                return 62;
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
                g = c.a(g2, looper);
                g.setStrokeWidth(1.0f);
                g = c.a(g, looper);
                g.setColor(-11776948);
                g.setStrokeWidth(3.0f);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(12.5f, 51.5f);
                h.lineTo(12.5f, 50.833168f);
                h.cubicTo(12.604213f, 50.756973f, 12.7130165f, 50.673367f, 12.825878f, 50.581997f);
                h.cubicTo(13.609306f, 49.947758f, 14.377914f, 49.098545f, 15.08248f, 48.008003f);
                h.cubicTo(17.25971f, 44.638042f, 18.415026f, 39.67215f, 18.092539f, 32.831554f);
                h.cubicTo(18.56658f, 22.598658f, 22.709154f, 17.582647f, 28.795002f, 16.286835f);
                h.lineTo(31.072823f, 15.801835f);
                h.lineTo(29.689184f, 13.928539f);
                h.cubicTo(29.419085f, 13.562856f, 29.272728f, 13.127208f, 29.272728f, 12.666667f);
                h.cubicTo(29.272728f, 11.47552f, 30.26446f, 10.5f, 31.5f, 10.5f);
                h.cubicTo(32.735542f, 10.5f, 33.727272f, 11.47552f, 33.727272f, 12.666667f);
                h.cubicTo(33.727272f, 13.127208f, 33.580914f, 13.562856f, 33.310818f, 13.928539f);
                h.lineTo(31.927177f, 15.801835f);
                h.lineTo(34.204998f, 16.286835f);
                h.cubicTo(40.290844f, 17.582647f, 44.43342f, 22.598658f, 44.90746f, 32.831554f);
                h.cubicTo(44.584972f, 39.67215f, 45.740288f, 44.638042f, 47.91752f, 48.008003f);
                h.cubicTo(48.622086f, 49.098545f, 49.390694f, 49.947758f, 50.17412f, 50.581997f);
                h.cubicTo(50.286983f, 50.673367f, 50.395786f, 50.756973f, 50.5f, 50.833168f);
                h.lineTo(50.5f, 51.5f);
                h.lineTo(12.5f, 51.5f);
                h.close();
                canvas.drawPath(h, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
