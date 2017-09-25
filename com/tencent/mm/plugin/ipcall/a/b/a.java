package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.model.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;

public final class a {
    public boolean fOV = false;
    public b mOt = null;
    public final Object mOu = new Object();
    public int mOv = 0;
    public boolean mOw = false;

    class a implements Runnable {
        final /* synthetic */ a mOx;
        private b mOy = null;

        public a(a aVar, b bVar) {
            this.mOx = aVar;
            this.mOy = bVar;
        }

        public final void run() {
            if (this.mOy != null) {
                this.mOy.boZ();
                this.mOy.boW();
                this.mOy = null;
                this.mOx.mOw = false;
            }
            ap.yZ().setMode(0);
        }
    }

    public final void eW(boolean z) {
        w.i("MicroMsg.IPCallAudioPlayer", "setSpeakerPhoneOn, old isSpeakerPhoneOn: %b, new isSpeakerPhoneOn: %b", new Object[]{Boolean.valueOf(this.mOw), Boolean.valueOf(z)});
        ap.yZ().aB(z);
        com.tencent.mm.plugin.ipcall.a.c.a aEi = i.aEi();
        if ((z ? aEi.mOV.pQ(401) : aEi.mOV.pQ(402)) < 0) {
            w.e("MicroMsg.IPCallEngineManager", "setSpeakerPhoneOn, failed, ret: %d", new Object[]{Integer.valueOf(z ? aEi.mOV.pQ(401) : aEi.mOV.pQ(402))});
        }
        if (z != this.mOw) {
            this.mOw = z;
            if (this.mOt != null && this.mOt.res) {
                this.mOt.ib(z);
            }
        }
    }

    public static boolean qN() {
        return ap.yZ().gNq.isSpeakerphoneOn();
    }
}
