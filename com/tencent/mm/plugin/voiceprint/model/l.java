package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class l implements e {
    public int rcF;
    private String rcG;
    public int rcH;
    public a rcI;
    public int rcq;

    public interface a {
        void Hy(String str);

        void Hz(String str);

        void boz();

        void p(boolean z, int i);
    }

    public l() {
        this.rcF = 71;
        this.rcG = null;
        this.rcH = 0;
        this.rcq = 0;
        this.rcI = null;
        ap.vd().a(611, this);
        ap.vd().a(612, this);
    }

    public l(a aVar) {
        this();
        this.rcI = aVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.d("MicroMsg.VoicePrintCreateService", "onSceneEnd, errType:%d, errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 || i2 == 0) {
            if (kVar.getType() == 611) {
                d dVar = (d) kVar;
                this.rcH = dVar.rcj;
                this.rcG = dVar.rci;
                w.d("MicroMsg.VoicePrintCreateService", "onFinishGetText, resId:%d, voiceText==null:%b", new Object[]{Integer.valueOf(this.rcH), Boolean.valueOf(bg.mA(this.rcG))});
                if (this.rcI != null) {
                    if (this.rcF == 71) {
                        this.rcI.Hy(this.rcG);
                    } else if (this.rcF == 72) {
                        this.rcI.Hz(this.rcG);
                    }
                }
            }
            if (kVar.getType() == 612) {
                boolean z;
                f fVar = (f) kVar;
                if ((fVar.rcs == 72 && fVar.rct == 0) || fVar.rcs == 71) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    w.d("MicroMsg.VoicePrintCreateService", "onRegister, ok, step:%d", new Object[]{Integer.valueOf(fVar.rcs)});
                    this.rcq = fVar.rcq;
                    if (this.rcI != null) {
                        this.rcI.p(true, fVar.rcs);
                    }
                } else {
                    w.d("MicroMsg.VoicePrintCreateService", "onRegister, not ok, step:%d", new Object[]{Integer.valueOf(fVar.rcs)});
                    if (this.rcI != null) {
                        this.rcI.p(false, fVar.rcs);
                    }
                }
                if (z && fVar.rcs == 71 && this.rcI != null) {
                    this.rcI.Hz(this.rcG);
                }
            }
        } else if (this.rcI != null) {
            this.rcI.boz();
        }
    }
}
