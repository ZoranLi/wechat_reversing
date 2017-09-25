package com.tencent.mm.ap;

import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetBackgroundAudioState;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.m;

public final class i implements e {
    public i() {
        h.vH().gXC.a((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (e) this);
        h.vH().gXC.a((int) JsApiSetBackgroundAudioState.CTRL_INDEX, (e) this);
        h.vH().gXC.a(new k(5), 0);
    }

    private void release() {
        h.vH().gXC.b((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (e) this);
        h.vH().gXC.b((int) JsApiSetBackgroundAudioState.CTRL_INDEX, (e) this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if ((kVar instanceof m) && ((m) kVar).BQ() == 5) {
            int type = kVar.getType();
            if (type == JsApiGetBackgroundAudioState.CTRL_INDEX) {
                if (i == 0 && i2 == 0) {
                    HW();
                    m[] gl = t.Ic().gl(5);
                    if (gl == null || gl.length == 0) {
                        w.i("MicroMsg.LangPackageUpdater", "error no pkg found.");
                        release();
                        return;
                    }
                    m mVar = gl[0];
                    w.i("MicroMsg.LangPackageUpdater", "dkregcode Pkg id:" + mVar.id + " version:" + mVar.version + " status:" + mVar.status + " type:" + mVar.fKL);
                    if (5 != mVar.status) {
                        release();
                        return;
                    }
                    h.vH().gXC.a(new j(mVar.id, 5), 0);
                    return;
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
        w.d("MicroMsg.LangPackageUpdater", "another scene");
    }

    private static void HW() {
        h.vI().vr().set(81939, Long.valueOf(bg.Nz()));
    }
}
