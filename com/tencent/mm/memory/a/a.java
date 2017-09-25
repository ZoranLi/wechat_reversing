package com.tencent.mm.memory.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import com.tencent.mm.memory.i;
import com.tencent.mm.memory.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;

public class a extends Drawable implements i {
    public static final Paint hgY;
    private static final ae hgZ = new ae(Looper.getMainLooper());
    boolean DEBUG = false;
    public n hha;
    private Runnable hhb = new Runnable(this) {
        final /* synthetic */ a hhc;

        {
            this.hhc = r1;
        }

        public final void run() {
            w.d("MicroMsg.MaskBitmapDrawable", "refresh tag=%s", this.hhc.tag);
            this.hhc.invalidateSelf();
        }
    };
    protected String tag;

    static {
        Paint paint = new Paint();
        hgY = paint;
        paint.setAntiAlias(true);
        hgY.setFilterBitmap(false);
        hgY.setColor(-1118482);
    }

    public a(String str, n nVar) {
        this.tag = str;
        this.hha = nVar;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        n nVar = this.hha;
        if (nVar == null || nVar.isRecycled()) {
            canvas.drawColor(-1118482);
            return;
        }
        canvas.drawBitmap(nVar.bitmap, null, bounds, hgY);
    }

    public final void ws() {
        if (this.hha != null) {
            this.hha.ws();
        }
    }

    public final void wt() {
        if (this.hha != null) {
            this.hha.wt();
        }
    }

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getIntrinsicWidth() {
        if (this.hha == null) {
            return 0;
        }
        n nVar = this.hha;
        if (nVar == null || nVar.isRecycled()) {
            return 0;
        }
        return nVar.bitmap.getWidth();
    }

    public int getIntrinsicHeight() {
        if (this.hha == null) {
            return 0;
        }
        n nVar = this.hha;
        if (nVar == null || nVar.isRecycled()) {
            return 0;
        }
        return nVar.bitmap.getHeight();
    }

    public final n wB() {
        if (this.hha != null) {
            return this.hha;
        }
        return null;
    }

    public String toString() {
        if (!this.DEBUG) {
            return super.toString();
        }
        String str = super.toString() + " code: " + hashCode();
        if (this.hha != null) {
            return str + this.hha;
        }
        return str;
    }
}
