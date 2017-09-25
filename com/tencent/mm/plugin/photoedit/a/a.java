package com.tencent.mm.plugin.photoedit.a;

import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.mm.plugin.photoedit.b.c;
import com.tencent.mm.sdk.platformtools.w;

public final class a extends b {
    public ValueAnimator oiP;
    public c oiQ;
    public float oiR;
    public float oiS;
    public float oiT;
    public float oiU;
    public float oiV;
    public Rect oiW;
    public RectF oiX;
    public Matrix oiY;
    public long oiZ = 0;

    public a(c cVar) {
        this.oiQ = cVar;
        this.oiY = new Matrix();
        this.oiX = new RectF();
    }

    public final void cancel() {
        w.d("MicroMsg.CropActionUpAnim", "[cancel]");
        if (this.oiP != null) {
            this.oiP.cancel();
        }
    }
}
