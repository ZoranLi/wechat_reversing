package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class n implements e {
    public String jia = null;
    private String rcG = null;
    public int rcH = -1;
    public String rcJ = null;
    public a rcK = null;
    public String rcw = null;

    public interface a {
        void HA(String str);

        void boB();

        void boz();

        void hZ(boolean z);
    }

    public n() {
        ap.vd().a(618, this);
        ap.vd().a(616, this);
        ap.vd().a(617, this);
    }

    public final void boA() {
        ap.vd().a(new g(this.rcJ), 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.d("MicroMsg.VoicePrintLoginService", "onSceneEnd, errType:%d, errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 || i2 == 0) {
            if (kVar.getType() == 618) {
                this.rcJ = ((e) kVar).kwg;
                w.d("MicroMsg.VoicePrintLoginService", "onGetTicket, loginTicket==null:%b", new Object[]{Boolean.valueOf(bg.mA(this.rcJ))});
                if (!bg.mA(this.rcJ)) {
                    boA();
                }
            }
            if (kVar.getType() == 616) {
                g gVar = (g) kVar;
                this.rcH = gVar.rcj;
                this.rcG = gVar.rci;
                w.d("MicroMsg.VoicePrintLoginService", "onFinishGetText, resId:%d, voiceText==null:%b", new Object[]{Integer.valueOf(this.rcH), Boolean.valueOf(bg.mA(this.rcG))});
                if (this.rcK != null) {
                    this.rcK.HA(this.rcG);
                }
            }
            if (kVar.getType() == 617) {
                h hVar = (h) kVar;
                if (hVar.rct == 0) {
                    w.d("MicroMsg.VoicePrintLoginService", "onFinishVerify, success");
                    this.rcw = hVar.rcw;
                    if (this.rcK != null) {
                        this.rcK.hZ(true);
                        return;
                    }
                    return;
                }
                w.d("MicroMsg.VoicePrintLoginService", "onFinishVerify, failed");
                if (this.rcK != null) {
                    this.rcK.hZ(false);
                }
            }
        } else if (i2 == -34 && kVar.getType() == 617) {
            w.d("MicroMsg.VoicePrintLoginService", "blocked by limit");
            if (this.rcK != null) {
                this.rcK.boB();
            }
        } else if (this.rcK != null) {
            this.rcK.boz();
        }
    }
}
