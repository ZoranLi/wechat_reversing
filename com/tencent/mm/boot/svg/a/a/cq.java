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

public final class cq extends c {
    private final int height = 30;
    private final int width = 30;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 30;
            case 1:
                return 30;
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
                a.setColor(-9074981);
                c = c.a(c, 1.0f, 0.0f, -350.0f, 0.0f, 1.0f, -661.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(372.0f, 661.0f);
                h.cubicTo(369.8465f, 661.0f, 368.307f, 661.45575f, 367.0f, 662.0f);
                h.cubicTo(364.6025f, 663.65375f, 363.0f, 666.1686f, 363.0f, 669.0f);
                h.lineTo(363.0f, 681.0f);
                h.cubicTo(363.0f, 683.11066f, 360.985f, 684.85187f, 359.0f, 685.0f);
                h.cubicTo(356.0145f, 684.85187f, 354.0f, 683.11066f, 354.0f, 681.0f);
                h.cubicTo(354.0f, 679.4344f, 355.023f, 678.1158f, 357.0f, 677.0f);
                h.cubicTo(356.6145f, 677.43445f, 356.723f, 677.39087f, 357.0f, 677.0f);
                h.cubicTo(357.769f, 676.9636f, 358.5705f, 676.2336f, 359.0f, 675.0f);
                h.cubicTo(359.3075f, 674.1341f, 358.4895f, 673.1199f, 357.0f, 673.0f);
                h.cubicTo(356.6805f, 673.1199f, 356.3145f, 673.1831f, 356.0f, 673.0f);
                h.cubicTo(355.96f, 673.2977f, 355.9585f, 673.2982f, 356.0f, 673.0f);
                h.cubicTo(353.863f, 673.922f, 352.1155f, 675.2888f, 351.0f, 677.0f);
                h.cubicTo(350.389f, 678.2278f, 350.0f, 679.5526f, 350.0f, 681.0f);
                h.cubicTo(350.0f, 685.3947f, 353.813f, 689.0f, 359.0f, 689.0f);
                h.cubicTo(360.1535f, 689.0f, 361.693f, 688.54425f, 363.0f, 688.0f);
                h.cubicTo(365.3975f, 686.34625f, 367.0f, 683.8314f, 367.0f, 681.0f);
                h.lineTo(367.0f, 669.0f);
                h.cubicTo(367.0f, 666.88934f, 369.0145f, 665.14813f, 372.0f, 665.0f);
                h.cubicTo(373.985f, 665.14813f, 376.0f, 666.88934f, 376.0f, 669.0f);
                h.cubicTo(376.0f, 670.631f, 374.8905f, 672.0009f, 373.0f, 673.0f);
                h.cubicTo(372.2775f, 672.9576f, 371.438f, 673.7265f, 371.0f, 675.0f);
                h.cubicTo(370.681f, 675.88306f, 371.495f, 676.8931f, 373.0f, 677.0f);
                h.cubicTo(373.263f, 676.8931f, 373.593f, 676.835f, 374.0f, 677.0f);
                h.cubicTo(373.967f, 676.72565f, 374.019f, 676.70905f, 374.0f, 677.0f);
                h.cubicTo(376.152f, 676.0661f, 377.889f, 674.7034f, 379.0f, 673.0f);
                h.cubicTo(379.611f, 671.77277f, 380.0f, 670.4474f, 380.0f, 669.0f);
                h.cubicTo(380.0f, 664.6053f, 376.187f, 661.0f, 372.0f, 661.0f);
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
