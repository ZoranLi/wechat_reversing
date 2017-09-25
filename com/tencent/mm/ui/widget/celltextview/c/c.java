package com.tencent.mm.ui.widget.celltextview.c;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ImageSpan;
import com.tencent.mm.sdk.platformtools.w;

public final class c extends e {
    private int abH;
    private int wd;
    private ImageSpan wys;

    public c(Paint paint, String str, ImageSpan imageSpan, int i, int i2, float f) {
        super(paint, 2, str, f);
        this.wys = imageSpan;
        this.abH = i;
        this.wd = i2;
        this.wyB = f;
    }

    public final boolean caX() {
        return false;
    }

    public final float getWidth() {
        return (float) this.wys.getDrawable().getBounds().width();
    }

    public final int getLength() {
        int length = super.getLength();
        if (length < 2) {
            return 2;
        }
        return length;
    }

    public final void a(Canvas canvas, RectF rectF, float f, float f2) {
        cba();
        int width = (int) (rectF.left + ((rectF.width() - ((float) this.wys.getDrawable().getBounds().width())) / 2.0f));
        w.i("ImageCell", "[draw] rect:%s drawX:%s drawY:%s", rectF, Integer.valueOf(width), Float.valueOf(((rectF.top + ((float) ((int) (((rectF.height() - wyD.descent()) - wyD.ascent()) / 2.0f)))) + ((wyD.getFontMetrics().bottom - wyD.getFontMetrics().top) / 2.0f)) - ((float) (this.wys.getDrawable().getBounds().height() / 2))));
        this.wys.draw(canvas, "", this.abH, this.wd, (float) width, (int) rectF.top, (int) r1, (int) rectF.bottom, wyD);
    }

    public final float Cy(int i) {
        return (float) (this.wys.getDrawable().getBounds().height() + i);
    }

    public final e caY() {
        return new c(this.fu, this.jqT, this.wys, this.abH, this.wd, this.wyB);
    }
}
