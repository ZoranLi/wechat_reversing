package com.tencent.mm.plugin.photoedit.b;

import android.graphics.Canvas;
import android.graphics.Path;
import android.view.MotionEvent;
import com.tencent.mm.plugin.photoedit.cache.b;
import com.tencent.mm.sdk.platformtools.w;

public final class d extends b<b> {
    private float aed;
    private float aee;
    private Path mU = new Path();
    private boolean ojV = false;
    private float ojW;
    private float ojX;
    private boolean okr = true;
    private float oks;
    public int sl = 1;

    public d(com.tencent.mm.plugin.photoedit.c.b bVar) {
        super(bVar);
    }

    public final void a(com.tencent.mm.plugin.photoedit.d.b bVar) {
        super.a(bVar);
        boolean aRQ = aRQ();
        this.oks = ((b) aRW()).okW;
        if (0.0f == this.oks) {
            this.oks = this.ojz.aSw();
            ((b) aRW()).okW = this.oks;
        }
        w.i("MicroMsg.DoodleArtist", "[onAlive] isReset:%s", new Object[]{Boolean.valueOf(aRQ)});
    }

    public final a aRO() {
        return a.ojo;
    }

    protected final boolean y(MotionEvent motionEvent) {
        float[] z = z(motionEvent.getX(), motionEvent.getY());
        switch (motionEvent.getActionMasked()) {
            case 0:
                if (this.ojw.contains((int) z[0], (int) z[1])) {
                    float f = z[0];
                    this.ojW = f;
                    this.aed = f;
                    float f2 = z[1];
                    this.ojX = f2;
                    this.aee = f2;
                    this.okr = true;
                } else {
                    this.okr = false;
                }
                this.ojV = false;
                break;
            case 1:
            case 5:
                if (this.okr && this.ojV) {
                    b bVar = (b) aRW();
                    com.tencent.mm.plugin.photoedit.f.b bVar2 = new com.tencent.mm.plugin.photoedit.f.b(new Path(this.mU), this.oks / this.ojz.aSw(), this.sl);
                    if (bVar.okR != null) {
                        bVar.okR.push(bVar2);
                    }
                    b(false, new Object[0]);
                    aRU();
                }
                this.mU.reset();
                this.ojV = false;
                this.okr = false;
                break;
            case 2:
                if (!this.okr || !this.ojV) {
                    if (this.okr && !this.ojV) {
                        this.mU.moveTo(z[0], z[1]);
                        this.ojV = true;
                        break;
                    }
                }
                this.ojW = this.aed;
                this.ojX = this.aee;
                this.aed = z[0];
                this.aee = z[1];
                this.mU.quadTo(this.ojW, this.ojX, (this.aed + this.ojW) / 2.0f, (this.aee + this.ojX) / 2.0f);
                aRR();
                break;
                break;
        }
        return this.okr;
    }

    public final void g(Canvas canvas) {
        canvas.save();
        canvas.clipRect(this.ojw);
        w.d("MicroMsg.DoodleArtist", "mRawScale:%s InitScale:%s", new Object[]{Float.valueOf(this.oks), Float.valueOf(this.ojz.aSw())});
        new com.tencent.mm.plugin.photoedit.f.b(this.mU, this.oks / this.ojz.aSw(), this.sl).j(canvas);
        canvas.restore();
    }
}
