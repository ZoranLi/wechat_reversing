package com.tencent.mm.plugin.mmsight.model;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class c extends OrientationEventListener {
    public int nBA = -1;
    private long nBB = 0;
    private long nBC = 0;
    public a nBD;
    public int nBz = -1;
    public int orientation = -1;

    public interface a {
        void pC(int i);
    }

    public c(Context context) {
        super(context, 2);
    }

    public final void onOrientationChanged(int i) {
        if (!j.nCI) {
            return;
        }
        if (bg.aB(this.nBC) < 2000) {
            w.v("MicroMsg.DeviceOrientationListener", "onOrientationChanged, not reach DETECT_THRESHOLD");
        } else if (Math.abs(this.nBz - i) >= 30 || bg.aB(this.nBB) >= 300) {
            this.nBz = i;
            this.nBB = bg.NA();
            if (i <= 60 || i >= e.CTRL_INDEX) {
                if (i <= 30 || i >= 330) {
                    this.orientation = 0;
                }
            } else if (i < 30 || i > ck.CTRL_INDEX) {
                if (i < 120 || i > 240) {
                    if (i >= h.CTRL_INDEX && i <= 330 && i >= 240 && i <= e.CTRL_INDEX) {
                        this.orientation = 270;
                    }
                } else if (i >= ck.CTRL_INDEX && i <= h.CTRL_INDEX) {
                    this.orientation = 180;
                }
            } else if (i >= 60 && i <= 120) {
                this.orientation = 90;
            }
            if (this.nBD != null) {
                this.nBD.pC(this.orientation);
            }
        }
    }

    public final void enable() {
        w.i("MicroMsg.DeviceOrientationListener", "enable, config isEnableLandscapeMode: %s", new Object[]{Boolean.valueOf(j.nCI)});
        if (j.nCI) {
            super.enable();
            this.nBC = bg.NA();
        }
    }

    public final int getOrientation() {
        if (j.nCI) {
            return this.orientation;
        }
        return 0;
    }

    public final boolean aKK() {
        if (!j.nCI) {
            return false;
        }
        w.i("MicroMsg.DeviceOrientationListener", "isLandscape, tickToNow: %s, orientation: %s", new Object[]{Long.valueOf(bg.aB(this.nBC)), Integer.valueOf(this.orientation)});
        if (bg.aB(this.nBC) < 2000 || this.orientation < 0) {
            return false;
        }
        if (this.orientation == 90 || this.orientation == 270) {
            return true;
        }
        return false;
    }
}
