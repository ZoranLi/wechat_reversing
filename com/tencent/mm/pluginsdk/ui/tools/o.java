package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.sdk.platformtools.w;

public final class o {
    int hTj;
    int hTk;
    d iWX = d.DEFAULT;
    int jYp;
    int jYq;
    public boolean sWN;
    int sXy;
    int sXz;

    final void reset() {
        this.jYq = 0;
        this.jYp = 0;
        this.hTj = 0;
        this.hTk = 0;
        this.sXz = 0;
        this.sXy = 0;
    }

    public final void a(d dVar) {
        w.i("MicroMsg.ViewSizeCache", "set scale type old[%s] new[%s]", this.iWX, dVar);
        this.iWX = dVar;
        reset();
    }

    final boolean r(int i, int i2, int i3, int i4) {
        if (this.jYp == i && this.jYq == i2 && this.hTk == i3 && this.hTj == i4) {
            return true;
        }
        this.jYp = i;
        this.jYq = i2;
        this.hTk = i3;
        this.hTj = i4;
        float f = (((float) this.hTk) * 1.0f) / ((float) this.hTj);
        float f2 = (((float) this.jYp) * 1.0f) / ((float) this.jYq);
        if (this.iWX != d.DEFAULT) {
            if (this.iWX == d.CONTAIN) {
                if (this.jYp < this.jYq) {
                    this.sXz = (int) (((float) this.jYp) / f);
                    this.sXy = this.jYp;
                    if (this.sXz > this.jYq) {
                        this.sXy = (int) (((float) this.jYq) * f);
                        this.sXz = this.jYq;
                    }
                } else {
                    this.sXy = (int) (((float) this.jYq) * f);
                    this.sXz = this.jYq;
                    if (this.sXy > this.jYp) {
                        this.sXz = (int) (((float) this.jYp) / f);
                        this.sXy = this.jYp;
                    }
                }
            } else if (this.iWX == d.FILL) {
                this.sXz = this.jYq;
                this.sXy = this.jYp;
            } else if (this.iWX == d.COVER) {
                if (this.jYp > this.jYq) {
                    this.sXz = (int) (((float) this.jYp) / f);
                    this.sXy = this.jYp;
                    if (this.sXz < this.jYq) {
                        this.sXy = (int) (((float) this.jYq) * f);
                        this.sXz = this.jYq;
                    }
                } else {
                    this.sXy = (int) (((float) this.jYq) * f);
                    this.sXz = this.jYq;
                    if (this.sXy < this.jYp) {
                        this.sXz = (int) (((float) this.jYp) / f);
                        this.sXy = this.jYp;
                    }
                }
            }
            w.d("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", Integer.valueOf(this.jYp), Integer.valueOf(this.jYq), Integer.valueOf(this.hTk), Integer.valueOf(this.hTj), Integer.valueOf(this.sXy), Integer.valueOf(this.sXz), Float.valueOf(f2), Float.valueOf(f));
            return false;
        }
        if (this.sWN) {
            if (((double) Math.abs(f - f2)) > 0.05d) {
                if (this.jYp < this.jYq) {
                    this.sXz = (int) (((float) this.jYp) / f);
                    this.sXy = this.jYp;
                } else {
                    this.sXy = (int) (((float) this.jYq) * f);
                    this.sXz = this.jYq;
                }
            } else if (this.jYp > this.jYq) {
                this.sXz = (int) (((float) this.jYp) / f);
                this.sXy = this.jYp;
            } else {
                this.sXy = (int) (((float) this.jYq) * f);
                this.sXz = this.jYq;
            }
        } else if (this.jYp < this.jYq) {
            this.sXz = (int) (((float) this.jYp) / f);
            this.sXy = this.jYp;
        } else {
            this.sXy = (int) (((float) this.jYq) * f);
            this.sXz = this.jYq;
        }
        w.d("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", Integer.valueOf(this.jYp), Integer.valueOf(this.jYq), Integer.valueOf(this.hTk), Integer.valueOf(this.hTj), Integer.valueOf(this.sXy), Integer.valueOf(this.sXz), Float.valueOf(f2), Float.valueOf(f));
        return false;
    }
}
