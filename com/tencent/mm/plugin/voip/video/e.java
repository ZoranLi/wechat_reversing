package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.View;
import com.tencent.mm.bg.a;

public final class e extends View {
    public int fg;
    private Paint fu = new Paint();
    private RectF jxM;
    private Matrix mMatrix;
    public int roT;
    public int roU;
    public int roV;

    public e(Context context) {
        super(context);
        this.fu.setStyle(Style.STROKE);
        this.fu.setColor(-65536);
        this.fu.setStrokeWidth((float) a.fromDPToPix(getContext(), 3));
        this.mMatrix = new Matrix();
    }

    protected final void onDraw(Canvas canvas) {
        if (this.jxM != null) {
            canvas.save();
            canvas.rotate(0.0f);
            canvas.drawRect(this.jxM, this.fu);
            canvas.restore();
        }
    }
}
