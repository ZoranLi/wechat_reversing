package com.tencent.mm.modelvoice;

import com.tencent.mm.c.b.a;
import com.tencent.mm.c.b.c;
import com.tencent.mm.c.b.g;
import com.tencent.mm.c.c.d;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.h;

public final class k implements a {
    private static int icd = 100;
    c.a fAe = new c.a(this) {
        final /* synthetic */ k icf;

        {
            this.icf = r1;
        }

        public final void d(byte[] bArr, int i) {
            int i2 = 0;
            if (this.icf.ice != null) {
                this.icf.ice.a(new g.a(bArr, i), 0, false);
            }
            k kVar = this.icf;
            while (i2 < i / 2) {
                short s = (short) ((bArr[i2 * 2] & 255) | (bArr[(i2 * 2) + 1] << 8));
                if (s > kVar.fzh) {
                    kVar.fzh = s;
                }
                i2++;
            }
        }

        public final void ax(int i, int i2) {
        }
    };
    int fzh = 0;
    public c fzv;
    public d ice;
    private String mFileName = null;
    public int mStatus = 0;

    public final boolean bw(String str) {
        if (bg.mA(this.mFileName)) {
            this.mStatus = 1;
            this.fzh = 0;
            this.fzv = new c(16000, 0);
            this.fzv.fzT = -19;
            if (p.gRl.gPY > 0) {
                this.fzv.r(p.gRl.gPY, true);
            } else {
                this.fzv.r(5, false);
            }
            this.fzv.as(false);
            this.fzv.fAe = this.fAe;
            this.ice = new d();
            if (!this.ice.bz(str)) {
                w.e("MicroMsg.SpeexRecorder", "init speex writer failed");
                clean();
                this.mStatus = -1;
                return false;
            } else if (this.fzv.pf()) {
                this.mFileName = str;
                return true;
            } else {
                w.e("MicroMsg.SpeexRecorder", "start record failed");
                clean();
                this.mStatus = -1;
                return false;
            }
        }
        w.e("MicroMsg.SpeexRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
        return false;
    }

    public final void a(h.a aVar) {
    }

    public final boolean oX() {
        this.mFileName = null;
        this.mStatus = 0;
        clean();
        return true;
    }

    public final int getStatus() {
        return this.mStatus;
    }

    private void clean() {
        if (this.fzv != null) {
            this.fzv.oX();
            this.fzv = null;
        }
        if (this.ice != null) {
            this.ice.ps();
            this.ice = null;
        }
    }

    public final int getMaxAmplitude() {
        int i = this.fzh;
        this.fzh = 0;
        if (i > icd) {
            icd = i;
        }
        return (i * 100) / icd;
    }

    public final int oY() {
        return this.fzv.fAj;
    }
}
