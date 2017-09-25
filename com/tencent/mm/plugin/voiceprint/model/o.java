package com.tencent.mm.plugin.voiceprint.model;

import android.os.Looper;
import com.tencent.mm.e.a.rm;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.w;

public final class o {
    public k rcL;
    public aj rcM;
    public int rcN;
    public int rcO;

    public o() {
        this.rcL = null;
        this.rcM = null;
        this.rcN = 0;
        this.rcO = 0;
        this.rcL = new k();
        this.rcM = new aj(Looper.getMainLooper(), new a(this) {
            final /* synthetic */ o rcP;

            {
                this.rcP = r1;
            }

            public final boolean oQ() {
                this.rcP.rcN += 100;
                this.rcP.rcO += (this.rcP.rcL.getMaxAmplitude() * 100) / 100;
                if (this.rcP.rcN < 3000) {
                    return true;
                }
                boolean z;
                o oVar = this.rcP;
                w.d("MicroMsg.VoicePrintNoiseDetector", "onDetectFinish");
                oVar.rcL.oX();
                oVar.rcM.KH();
                oVar.rcO /= 30;
                if (oVar.rcO >= 30) {
                    z = true;
                } else {
                    z = false;
                }
                w.d("MicroMsg.VoicePrintNoiseDetector", "average amplitude: %d, hasNoise:%b", new Object[]{Integer.valueOf(oVar.rcO), Boolean.valueOf(z)});
                b rmVar = new rm();
                rmVar.fYx.fYy = z;
                com.tencent.mm.sdk.b.a.urY.m(rmVar);
                return false;
            }
        }, true);
    }

    public final void reset() {
        this.rcL.oX();
        w.d("MicroMsg.VoicePrintNoiseDetector", "stop record");
        this.rcM.KH();
        this.rcN = 0;
        this.rcO = 0;
    }
}
