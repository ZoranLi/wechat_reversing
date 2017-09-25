package com.tencent.mm.plugin.appbrand.widget.d;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.mm.bg.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class b extends Drawable {
    public float abw = 0.0f;
    public final Paint fu = new Paint(1);
    private final RectF jxM = new RectF();
    private float jxN = ((float) a.fromDPToPix(ab.getContext(), 3));
    private final Path mU = new Path();

    public final void draw(Canvas canvas) {
        float width = this.jxM.width();
        float height = this.jxM.height();
        float f = this.jxM.left;
        float f2 = this.jxM.top;
        float f3 = this.jxM.right;
        float f4 = this.jxM.bottom;
        width = Math.min(this.abw, Math.min(width, height) * 0.5f);
        canvas.drawRoundRect(new RectF(f + this.jxN, f2 + this.jxN, f3 - this.jxN, f4 - this.jxN), width, width, this.fu);
        canvas.drawPath(this.mU, this.fu);
    }

    public final void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.jxM.set((float) i, (float) i2, (float) i3, (float) i4);
        float f = (float) ((i + i3) / 2);
        this.mU.moveTo(f, (float) i4);
        this.mU.lineTo(f - this.jxN, ((float) i4) - this.jxN);
        this.mU.lineTo(f + this.jxN, ((float) i4) - this.jxN);
        this.mU.close();
    }

    public final void setAlpha(int i) {
        this.fu.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.fu.setColorFilter(colorFilter);
    }

    public final int getOpacity() {
        return -3;
    }
}
