package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;

public final class b implements com.tencent.mm.compatible.b.e.a, com.tencent.mm.plugin.voip.HeadsetPlugReceiver.a {
    boolean fOV = false;
    com.tencent.mm.compatible.util.b ict = new com.tencent.mm.compatible.util.b(ab.getContext());
    HeadsetPlugReceiver mOC = new HeadsetPlugReceiver();
    boolean mOG = false;
    boolean mOH = false;
    com.tencent.mm.plugin.voip.model.b mOt = null;
    final Object mOu = new Object();
    private int nOR;

    class a implements Runnable {
        private com.tencent.mm.plugin.voip.model.b mOy = null;
        final /* synthetic */ b nOS;

        public a(b bVar, com.tencent.mm.plugin.voip.model.b bVar2) {
            this.nOS = bVar;
            this.mOy = bVar2;
        }

        public final void run() {
            if (this.mOy != null) {
                this.mOy.boZ();
                this.mOy.boW();
                this.mOy = null;
                ap.yZ().qS();
                ap.yZ().setMode(0);
            }
        }
    }

    public final void eW(boolean z) {
        w.i("MicroMsg.MT.MultiTalkAudioPlayer", "setSpeakerPhoneOn, isSpeakerPhoneOn: %b", new Object[]{Boolean.valueOf(z)});
        ap.yZ().aB(z);
        if (this.mOt != null && this.mOt.res) {
            this.mOt.ib(z);
        }
    }

    public final void eY(boolean z) {
        boolean z2 = false;
        if (this.mOH != z) {
            this.mOH = z;
            w.i("MicroMsg.MT.MultiTalkAudioPlayer", "onHeadsetState: isHeadsetPlugged" + z);
            boolean z3 = o.aNn().mNu.brA() ? !this.mOH : false;
            if (!this.mOG) {
                z2 = z3;
            }
            eW(z2);
            o.aNn().fT(z2);
        }
    }

    public final void cW(int i) {
        w.i("MicroMsg.MT.MultiTalkAudioPlayer", "onBluetoothHeadsetStateChange, status: %d", new Object[]{Integer.valueOf(i)});
        boolean aMz;
        switch (i) {
            case 1:
                if (i != this.nOR) {
                    this.mOG = true;
                    eW(false);
                    o.aNn().fT(false);
                    break;
                }
                break;
            case 2:
                if (i != this.nOR) {
                    this.mOG = false;
                    aMz = aMz();
                    eW(aMz);
                    o.aNn().fT(aMz);
                    break;
                }
                break;
            case 3:
                this.mOG = true;
                ap.yZ().qG();
                break;
            case 4:
                if (i != this.nOR) {
                    this.mOG = false;
                    ap.yZ().qH();
                    aMz = aMz();
                    eW(aMz);
                    o.aNn().fT(aMz);
                    break;
                }
                break;
        }
        this.nOR = i;
    }

    private boolean aMz() {
        return o.aNn().mNu.brA() && !this.mOH;
    }
}
