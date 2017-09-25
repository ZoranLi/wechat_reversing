package com.tencent.mm.kiss.widget.textview;

import android.text.Layout.Alignment;
import android.text.TextPaint;

public final class e {
    private final d[] haH = new d[3];
    private final Object mLock = new Object();
    private int wg;

    public final d vX() {
        d dVar = null;
        synchronized (this.mLock) {
            if (this.wg > 0) {
                int i = this.wg - 1;
                dVar = this.haH[i];
                this.haH[i] = null;
                this.wg--;
            }
        }
        return dVar;
    }

    public final boolean a(d dVar) {
        synchronized (this.mLock) {
            boolean z;
            for (int i = 0; i < this.wg; i++) {
                if (this.haH[i] == dVar) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (z) {
                throw new IllegalStateException("Already in the pool!");
            }
            dVar.hau = null;
            dVar.hav = null;
            dVar.haw = 0;
            dVar.hax = 0;
            dVar.hay = new TextPaint();
            dVar.width = 0;
            dVar.haz = Alignment.ALIGN_NORMAL;
            dVar.gravity = 51;
            dVar.haA = null;
            dVar.haB = 0;
            dVar.maxLines = Integer.MAX_VALUE;
            dVar.haC = null;
            dVar.haD = 0.0f;
            dVar.haE = 1.0f;
            dVar.haF = false;
            dVar.maxLength = 0;
            dVar.haG = null;
            if (this.wg < this.haH.length) {
                this.haH[this.wg] = dVar;
                this.wg++;
                return true;
            }
            return false;
        }
    }
}
