package com.tencent.mm.plugin.sns.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.SystemClock;
import com.tencent.mm.memory.a.a;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.data.i;
import java.util.HashMap;
import java.util.Map;

public final class ah extends a {
    int alpha = 255;
    long mix;
    boolean miy = false;
    private Map<String, Boolean> pWV = new HashMap();

    public ah(String str, n nVar, long j) {
        super(str, nVar);
        if (j != 0) {
            this.mix = j;
            this.pWV.put(str, Boolean.valueOf(true));
            this.miy = true;
        } else if (!this.pWV.containsKey(str)) {
            this.mix = SystemClock.uptimeMillis();
            this.pWV.put(str, Boolean.valueOf(true));
            this.miy = true;
        }
    }

    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        Bitmap wx = this.hha.wx();
        if (i.k(wx)) {
            if (this.miy) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mix)) / 150.0f;
                if (this.mix == 0) {
                    uptimeMillis = 0.0f;
                }
                if (uptimeMillis >= 1.0f) {
                    this.miy = false;
                } else {
                    hgY.setAlpha((int) (uptimeMillis * ((float) this.alpha)));
                    canvas.drawBitmap(wx, null, bounds, hgY);
                    invalidateSelf();
                    return;
                }
            }
            hgY.setAlpha(this.alpha);
            canvas.drawBitmap(wx, null, bounds, hgY);
            return;
        }
        canvas.drawColor(-1118482);
        this.mix = 0;
    }
}
