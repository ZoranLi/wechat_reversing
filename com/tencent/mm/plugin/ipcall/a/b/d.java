package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class d implements com.tencent.mm.sdk.platformtools.SensorController.a {
    public SensorController jXn = new SensorController(ab.getContext());
    public ax jXr = new ax(ab.getContext());
    public long jXs = -1;
    private boolean jXx = false;
    public a mOS = null;

    public interface a {
        void eX(boolean z);
    }

    public final void cU(final boolean z) {
        boolean z2 = true;
        w.i("MicroMsg.IPCallSensorManager", "onSensorEvent, isON:" + z + "  hasSkip:" + this.jXx + " tick:" + bg.aB(this.jXs) + "  lt:" + this.jXs);
        if (this.jXx) {
            if (z) {
                z2 = false;
            }
            this.jXx = z2;
        } else if (z || this.jXs == -1 || bg.aB(this.jXs) <= 400) {
            this.jXx = false;
            w.i("MicroMsg.IPCallSensorManager", "onSensorEvent, isNeedOffScreen: %b", new Object[]{Boolean.valueOf(z)});
            new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
                final /* synthetic */ d mOT;

                public final boolean oQ() {
                    if (z) {
                        w.i("MicroMsg.IPCallSensorManager", "light screen");
                        if (this.mOT.mOS != null) {
                            this.mOT.mOS.eX(false);
                        }
                    } else {
                        w.i("MicroMsg.IPCallSensorManager", "off screen");
                        if (this.mOT.mOS != null) {
                            this.mOT.mOS.eX(true);
                        }
                    }
                    return false;
                }
            }, false).v(50, 50);
        } else {
            this.jXx = true;
        }
    }
}
