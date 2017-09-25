package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.platformtools.a.a;
import com.tencent.mm.plugin.gif.MMGIFException;

public class BorderNumView extends View {
    private static int uOk = 22;
    private static int uOl = MMGIFException.D_GIF_ERR_NO_IMAG_DSCR;
    private static int uOm = 100;
    private Context context = null;
    private Paint fu;
    private int uOj = 100;

    public BorderNumView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    public BorderNumView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        init();
    }

    private void init() {
        this.fu = new Paint();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.uOj < 100) {
            uOk += 15;
        }
        if (this.uOj >= 1000) {
            uOm -= 20;
        }
        float a = (float) a.a(this.context, (float) uOk);
        float a2 = (float) a.a(this.context, (float) uOl);
        String str = this.uOj;
        this.fu.setAntiAlias(true);
        this.fu.setTextSize((float) uOm);
        this.fu.setColor(-11491572);
        this.fu.setStyle(Style.STROKE);
        this.fu.setStrokeWidth(8.0f);
        canvas.drawText(str, a, a2, this.fu);
        this.fu.setTextSize((float) uOm);
        this.fu.setColor(-1770573);
        this.fu.setStyle(Style.FILL);
        this.fu.setStrokeWidth(8.0f);
        canvas.drawText(str, a, a2, this.fu);
    }
}
