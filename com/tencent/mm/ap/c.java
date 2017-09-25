package com.tencent.mm.ap;

import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetBackgroundAudioState;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class c implements e {
    private static c hNS;
    private int hNR = 3;
    private boolean hpL = false;

    public static c HV() {
        if (hNS == null) {
            hNS = new c();
        }
        return hNS;
    }

    public final void update() {
        w.i("MicroMsg.ConfigListUpdater", "isUpdateing : " + this.hpL);
        w.i("MicroMsg.ConfigListUpdater", "isSDCardAvailable : " + h.vI().isSDCardAvailable());
        if (!this.hpL && h.vI().isSDCardAvailable()) {
            release();
            this.hpL = true;
            h.vH().gXC.a((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (e) this);
            h.vH().gXC.a(new k(7), 0);
        }
    }

    private void release() {
        this.hpL = false;
        h.vH().gXC.b((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (e) this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == JsApiGetBackgroundAudioState.CTRL_INDEX) {
            w.i("MicroMsg.ConfigListUpdater", "getPackageList sceneEnd, %s, %s", Integer.valueOf(i), Integer.valueOf(i2));
            if (i == 0 && i2 == 0) {
                h.vI().vr().set(81938, Long.valueOf(bg.Ny()));
            } else {
                int i3 = this.hNR - 1;
                this.hNR = i3;
                if (i3 < 0) {
                    h.vI().vr().set(81938, Long.valueOf(((bg.Nz() - 86400000) + 3600000) / 1000));
                    this.hNR = 3;
                }
            }
            release();
        }
    }
}
