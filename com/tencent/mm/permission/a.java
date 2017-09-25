package com.tencent.mm.permission;

import com.tencent.mm.ap.j;
import com.tencent.mm.ap.k;
import com.tencent.mm.ap.t;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetBackgroundAudioState;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.e;
import com.tencent.mm.y.m;

public final class a implements e {
    private static a ihk;
    private boolean ihl = false;
    private int ihm = 3;

    public static a Nh() {
        if (ihk == null) {
            ihk = new a();
        }
        return ihk;
    }

    public final void Ni() {
        if (ap.zb()) {
            if (!this.ihl) {
                ap.yY();
                if (c.isSDCardAvailable()) {
                    ap.yY();
                    if (bg.Nz() - ((Long) c.vr().get(327944, Long.valueOf(0))).longValue() >= 86400000) {
                        release();
                        this.ihl = true;
                        ap.vd().a(new k(23), 0);
                        ap.vd().a((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (e) this);
                        ap.vd().a((int) JsApiSetBackgroundAudioState.CTRL_INDEX, (e) this);
                        return;
                    }
                    return;
                }
            }
            w.e("MicroMsg.PermissionConfigUpdater", "not to update, isUpdating: %s", Boolean.valueOf(this.ihl));
        }
    }

    private void release() {
        this.ihl = false;
        ap.vd().b((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (e) this);
        ap.vd().b((int) JsApiSetBackgroundAudioState.CTRL_INDEX, (e) this);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        if ((kVar instanceof m) && ((m) kVar).BQ() == 23) {
            int type = kVar.getType();
            if (JsApiGetBackgroundAudioState.CTRL_INDEX == type) {
                if (i == 0 && i2 == 0) {
                    HW();
                    com.tencent.mm.ap.m[] gl = t.Ic().gl(23);
                    if (gl == null || gl.length == 0) {
                        w.i("MicroMsg.PermissionConfigUpdater", "error no pkg found.");
                        release();
                        return;
                    }
                    com.tencent.mm.ap.m mVar = gl[0];
                    w.i("MicroMsg.PermissionConfigUpdater", "permission, pkgId: %d, version: %d, status: %d, type: %d", Integer.valueOf(mVar.id), Integer.valueOf(mVar.version), Integer.valueOf(mVar.status), Integer.valueOf(mVar.fKL));
                    if (5 != mVar.status) {
                        release();
                        return;
                    }
                    ap.vd().a(new j(mVar.id, 23), 0);
                    return;
                }
                type = this.ihm - 1;
                this.ihm = type;
                if (type <= 0) {
                    if (ap.zb()) {
                        ap.yY();
                        c.vr().set(327944, Long.valueOf((bg.Nz() - 86400000) + 3600000));
                    }
                    this.ihm = 3;
                }
                release();
                return;
            } else if (JsApiSetBackgroundAudioState.CTRL_INDEX == type) {
                if (i == 0 && i2 == 0) {
                    HW();
                }
                release();
                return;
            } else {
                return;
            }
        }
        w.d("MicroMsg.PermissionConfigUpdater", "another scene");
    }

    private static void HW() {
        if (ap.zb()) {
            ap.yY();
            c.vr().set(327944, Long.valueOf(bg.Nz()));
        }
    }
}
