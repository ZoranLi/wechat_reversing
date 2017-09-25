package com.tencent.mm.ap;

import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetBackgroundAudioState;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.m;

public final class s implements e {
    private static s hOr;
    private int hNR = 3;
    private boolean hpL = false;

    public static s Ia() {
        if (hOr == null) {
            hOr = new s();
        }
        return hOr;
    }

    public final void update() {
        if (!this.hpL && h.vI().isSDCardAvailable()) {
            release();
            this.hpL = true;
            h.vH().gXC.a((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (e) this);
            h.vH().gXC.a((int) JsApiSetBackgroundAudioState.CTRL_INDEX, (e) this);
            h.vH().gXC.a(new k(8), 0);
        }
    }

    private void release() {
        this.hpL = false;
        h.vH().gXC.b((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (e) this);
        h.vH().gXC.b((int) JsApiSetBackgroundAudioState.CTRL_INDEX, (e) this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if ((kVar instanceof m) && ((m) kVar).BQ() == 8) {
            int type = kVar.getType();
            if (type == JsApiGetBackgroundAudioState.CTRL_INDEX) {
                if (i == 0 && i2 == 0) {
                    HW();
                    m[] gl = t.Ic().gl(8);
                    if (gl == null || gl.length == 0) {
                        w.i("MicroMsg.RegionCodeUpdater", "error no pkg found.");
                        release();
                        return;
                    }
                    m mVar = gl[0];
                    w.i("MicroMsg.RegionCodeUpdater", "dkregcode Pkg id:" + mVar.id + " version:" + mVar.version + " status:" + mVar.status + " type:" + mVar.fKL);
                    if (5 != mVar.status) {
                        release();
                        return;
                    }
                    h.vH().gXC.a(new j(mVar.id, 8), 0);
                    return;
                }
                type = this.hNR - 1;
                this.hNR = type;
                if (type <= 0) {
                    h.vI().vr().set(81937, Long.valueOf(((bg.Nz() - 604800000) + 3600000) / 1000));
                    this.hNR = 3;
                }
                release();
                return;
            } else if (type == JsApiSetBackgroundAudioState.CTRL_INDEX) {
                if (i == 0 && i2 == 0) {
                    HW();
                }
                release();
                return;
            } else {
                return;
            }
        }
        w.d("MicroMsg.RegionCodeUpdater", "another scene");
    }

    private static void HW() {
        h.vI().vr().set(81937, Long.valueOf(bg.Ny()));
    }
}
