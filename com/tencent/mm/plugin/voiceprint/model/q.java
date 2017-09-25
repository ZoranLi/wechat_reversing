package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class q implements e {
    public String rcG;
    public int rcH;
    public a rcX;
    private String rck;
    private int rcq;

    public interface a {
        void HA(String str);

        void boz();

        void ia(boolean z);
    }

    public q() {
        this.rcX = null;
        this.rcH = -1;
        this.rcG = null;
        this.rck = null;
        this.rcq = 0;
        ap.vd().a(611, this);
        ap.vd().a(613, this);
    }

    public q(a aVar) {
        this();
        this.rcX = aVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.d("MicroMsg.VoicePrintUnLockService", "onSceneEnd, errType:%d, errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 || i2 == 0) {
            if (kVar.getType() == 611) {
                d dVar = (d) kVar;
                this.rcH = dVar.rcj;
                this.rcG = dVar.rci;
                this.rck = dVar.rck;
                w.d("MicroMsg.VoicePrintUnLockService", "onGetVoiceText, resId:%d, verifyKey:%s, voiceText==null:%b", new Object[]{Integer.valueOf(this.rcH), this.rck, Boolean.valueOf(bg.mA(this.rcG))});
                if (this.rcX != null) {
                    this.rcX.HA(this.rcG);
                }
            }
            if (kVar.getType() != 613) {
                return;
            }
            if (((j) kVar).rct == 0) {
                w.d("MicroMsg.VoicePrintUnLockService", "onVerify, success");
                if (this.rcX != null) {
                    this.rcX.ia(true);
                    return;
                }
                return;
            }
            w.d("MicroMsg.VoicePrintUnLockService", "onVerify, failed");
            if (this.rcX != null) {
                this.rcX.ia(false);
            }
        } else if (this.rcX != null) {
            this.rcX.boz();
        }
    }
}
