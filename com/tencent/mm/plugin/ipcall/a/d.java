package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.ap.j;
import com.tencent.mm.ap.k;
import com.tencent.mm.ap.m;
import com.tencent.mm.ap.t;
import com.tencent.mm.e.a.cg;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetBackgroundAudioState;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import java.io.File;

public final class d implements e {
    private static d mMH = null;
    private boolean hpL = false;
    c mMI = new c<cg>(this) {
        final /* synthetic */ d mMJ;

        {
            this.mMJ = r2;
            this.usg = cg.class.getName().hashCode();
        }

        private boolean a(cg cgVar) {
            if (cgVar instanceof cg) {
                w.d("MicroMsg.IPCallCoutryConfigUpdater", "detect DynamicConfigUpdatedEvent");
                ap.yY();
                int intValue = ((Integer) com.tencent.mm.u.c.vr().get(a.uBx, Integer.valueOf(0))).intValue();
                int i = g.sV().getInt("WeChatOutCountryCodeRestrictionPackageID", 0);
                w.d("MicroMsg.IPCallCoutryConfigUpdater", "oldConfig: %d, newConfig: %d", new Object[]{Integer.valueOf(intValue), Integer.valueOf(i)});
                if (intValue != i) {
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(a.uBx, Integer.valueOf(i));
                    t.Ic().gk(26);
                    c aDT = c.aDT();
                    w.d("MicroMsg.IPCallCountryCodeConfig", "deleteRestrictionCountryConfigIfExist, path: %s", new Object[]{com.tencent.mm.compatible.util.e.hgq + "ipcallCountryCodeConfig.cfg"});
                    try {
                        File file = new File(com.tencent.mm.compatible.util.e.hgq + "ipcallCountryCodeConfig.cfg");
                        if (file.exists()) {
                            file.delete();
                        }
                        aDT.isInit = false;
                        aDT.mMG.clear();
                    } catch (Exception e) {
                        w.e("MicroMsg.IPCallCountryCodeConfig", "deleteRestrictionCountryConfigIfExist, error: %s", new Object[]{e.getMessage()});
                    }
                    this.mMJ.eQ(true);
                }
            }
            return false;
        }
    };
    private int retryCount = 0;

    private d() {
    }

    public static d aDX() {
        if (mMH == null) {
            mMH = new d();
        }
        return mMH;
    }

    public final void eQ(boolean z) {
        if (!ap.zb()) {
            w.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate, acc not ready");
        } else if (this.hpL) {
            w.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate updating");
        } else {
            w.d("MicroMsg.IPCallCoutryConfigUpdater", "tryupdate, isForce: %b", new Object[]{Boolean.valueOf(z)});
            if (!z) {
                ap.yY();
                long longValue = ((Long) com.tencent.mm.u.c.vr().get(a.uBy, Long.valueOf(0))).longValue();
                long currentTimeMillis = System.currentTimeMillis();
                if (longValue != 0 && Math.abs(currentTimeMillis - longValue) < 86400000) {
                    w.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate, not reach the update time limit");
                    return;
                }
            }
            w.i("MicroMsg.IPCallCoutryConfigUpdater", "try update now");
            this.hpL = true;
            ap.vd().a(JsApiGetBackgroundAudioState.CTRL_INDEX, this);
            ap.vd().a(JsApiSetBackgroundAudioState.CTRL_INDEX, this);
            aDY();
        }
    }

    private static void aDY() {
        boolean z;
        m[] gl = t.Ic().gl(26);
        if (gl == null || gl.length <= 0) {
            z = false;
        } else {
            z = true;
        }
        ap.vd().a(new k(z), 0);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        w.d("MicroMsg.IPCallCoutryConfigUpdater", "onSceneEnd, errType: %d, errCode: %d, isUpdating: %b", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.hpL)});
        if (this.hpL) {
            boolean z;
            if (i == 0 || i2 == 0) {
                z = true;
            } else {
                z = false;
            }
            w.d("MicroMsg.IPCallCoutryConfigUpdater", "onSceneEnd, isSuccess: %b", new Object[]{Boolean.valueOf(z)});
            if (kVar.getType() == JsApiGetBackgroundAudioState.CTRL_INDEX) {
                if (z) {
                    w.d("MicroMsg.IPCallCoutryConfigUpdater", "get package list success, start download");
                    m[] gl = t.Ic().gl(26);
                    if (gl == null || gl.length == 0) {
                        w.d("MicroMsg.IPCallCoutryConfigUpdater", "do not exist package info");
                        aDZ();
                        return;
                    }
                    w.d("MicroMsg.IPCallCoutryConfigUpdater", "infos.length: %d", new Object[]{Integer.valueOf(gl.length)});
                    m mVar = gl[0];
                    w.d("MicroMsg.IPCallCoutryConfigUpdater", "stored info type: %d, id: %d, version: %d, status: %d, name: %s", new Object[]{Integer.valueOf(mVar.fKL), Integer.valueOf(mVar.id), Integer.valueOf(mVar.version), Integer.valueOf(mVar.status), mVar.HX()});
                    if (mVar.status == 3) {
                        w.d("MicroMsg.IPCallCoutryConfigUpdater", "downloading this package, ignore");
                    } else if (mVar.status != 5) {
                        w.d("MicroMsg.IPCallCoutryConfigUpdater", "already download this package");
                        c.aDT().eP(true);
                        aDZ();
                    } else {
                        ap.vd().a(new j(mVar.id, 26), 0);
                    }
                } else if (this.retryCount < 3) {
                    this.retryCount++;
                    aDY();
                    w.d("MicroMsg.IPCallCoutryConfigUpdater", "retry get package list, retryCount: %d", new Object[]{Integer.valueOf(this.retryCount)});
                } else {
                    w.e("MicroMsg.IPCallCoutryConfigUpdater", "reach retry limit");
                }
            } else if (kVar.getType() == JsApiSetBackgroundAudioState.CTRL_INDEX && z) {
                w.d("MicroMsg.IPCallCoutryConfigUpdater", "download package success");
                c.aDT().eP(true);
                aDZ();
            }
        }
    }

    private void aDZ() {
        this.hpL = false;
        this.retryCount = 0;
        long currentTimeMillis = System.currentTimeMillis();
        ap.yY();
        com.tencent.mm.u.c.vr().a(a.uBy, Long.valueOf(currentTimeMillis));
    }
}
