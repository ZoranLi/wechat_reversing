package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.ui.j;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;

public final class b implements com.tencent.mm.compatible.b.e.a, com.tencent.mm.plugin.ipcall.a.b.d.a, com.tencent.mm.plugin.voip.HeadsetPlugReceiver.a {
    public MMActivity fCi;
    public com.tencent.mm.compatible.util.b ict = new com.tencent.mm.compatible.util.b(ab.getContext());
    public c mOA = new c();
    public d mOB = new d();
    public HeadsetPlugReceiver mOC = new HeadsetPlugReceiver();
    public j mOD;
    private boolean mOE = false;
    public a mOF;
    public boolean mOG = false;
    public boolean mOH = false;
    public long mOI = 0;
    public a mOz = new a();

    public interface a {
        void eZ(boolean z);

        void fa(boolean z);
    }

    public final void a(j jVar) {
        this.mOD = jVar;
        if (jVar != null) {
            i.aEm().aDI();
        }
    }

    public final void aEz() {
        c cVar = this.mOA;
        if (cVar.fOV) {
            w.d("MicroMsg.IPCallRecorder", "startRecorder, already start");
            return;
        }
        w.i("MicroMsg.IPCallRecorder", "start record");
        cVar.fOV = true;
        cVar.mOL = i.aEk().mOz.mOv;
        if (cVar.mOL <= 10) {
            if (cVar.mOL <= 0) {
                w.e("MicroMsg.IPCallRecorder", "playDelayInMs<=0");
                i.aEj().aEH();
            }
            cVar.mOL = 92;
        }
        synchronized (cVar.mOK) {
            e.post(new Runnable(cVar) {
                final /* synthetic */ c mOQ;

                {
                    this.mOQ = r1;
                }

                public final void run() {
                    try {
                        c cVar = this.mOQ;
                        cVar.mOJ = new com.tencent.mm.c.b.c(v2protocal.nON, 6);
                        cVar.mOJ.cY(20);
                        cVar.mOJ.at(true);
                        cVar.mOJ.pe();
                        cVar.mOJ.fzT = -19;
                        cVar.mOJ.r(1, false);
                        cVar.mOJ.as(true);
                        cVar.mOJ.fAe = cVar.mOP;
                        if (cVar.mOJ.pf()) {
                            cVar.mOJ.au(cVar.kmK);
                            return;
                        }
                        w.e("MicroMsg.IPCallRecorder", "start record failed");
                        if (cVar.mOJ.fzJ != 13) {
                            i.aEj().aEH();
                        }
                    } catch (Exception e) {
                        w.e("MicroMsg.IPCallRecorder", "start record error: %s", new Object[]{e.getMessage()});
                        i.aEj().aEH();
                    }
                }
            }, "IPCallRecorder_startRecord");
        }
    }

    public final void eW(boolean z) {
        this.mOz.eW(z);
    }

    public final void eX(boolean z) {
        boolean z2 = true;
        w.i("MicroMsg.IPCallDeviceManager", "onScreenDistanceChange, isClose: %b", new Object[]{Boolean.valueOf(z)});
        if (this.fCi != null) {
            MMActivity mMActivity = this.fCi;
            if (z) {
                z2 = false;
            }
            mMActivity.cV(z2);
        }
        if (!i.aEl().aEc()) {
            return;
        }
        if (z) {
            this.mOE = a.qN();
            this.mOz.eW(false);
            return;
        }
        this.mOz.eW(this.mOE);
    }

    public final void cW(int i) {
        w.i("MicroMsg.IPCallDeviceManager", "onAudioStatChange, status: %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case 1:
                this.mOG = true;
                if (this.mOF != null && !this.mOH) {
                    this.mOF.fa(true);
                    return;
                }
                return;
            case 2:
            case 4:
                this.mOG = false;
                if (this.mOF != null && !this.mOH) {
                    this.mOF.fa(false);
                    return;
                }
                return;
            case 3:
                ap.yZ().qG();
                if (ap.yZ().qI() && this.mOF != null) {
                    this.mOF.eZ(true);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void eY(boolean z) {
        w.i("MicroMsg.IPCallDeviceManager", "onHeadsetState, on: %b", new Object[]{Boolean.valueOf(z)});
        if (this.mOF != null && z != this.mOH) {
            this.mOH = z;
            if (!this.mOG) {
                this.mOF.eZ(z);
            }
        }
    }

    public final int aEA() {
        a aVar = this.mOz;
        return (aVar.mOt == null || !aVar.fOV) ? -1 : aVar.mOt.bpb();
    }
}
