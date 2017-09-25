package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.plugin.appbrand.launching.o;
import com.tencent.mm.protocal.c.asd;
import com.tencent.mm.protocal.c.bpu;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;

public enum d {
    ;

    public static void bF(final boolean z) {
        e.post(new Runnable() {
            public final void run() {
                d.bG(z);
            }
        }, "WxaCommLibVersionChecker");
    }

    private static void a(int i, int i2, String str, bpu com_tencent_mm_protocal_c_bpu, boolean z) {
        if (h.vG().uV() && z) {
            h.vI().vr().a(a.uEa, Long.valueOf(86400 + bg.Ny()));
        }
        if (i != 0 || i2 != 0) {
            w.e("MicroMsg.WxaCommLibVersionChecker", "onResp, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        } else if (com_tencent_mm_protocal_c_bpu == null) {
            w.e("MicroMsg.WxaCommLibVersionChecker", "onResp, null response");
        } else if (c.PY() != null) {
            w.i("MicroMsg.WxaCommLibVersionChecker", "onResp, updateRet = %b, version = %d, forceUpdate = %d, md5 = %s, url = %s", new Object[]{Boolean.valueOf(c.PY().a(com_tencent_mm_protocal_c_bpu)), Integer.valueOf(com_tencent_mm_protocal_c_bpu.version), Integer.valueOf(com_tencent_mm_protocal_c_bpu.tWA), com_tencent_mm_protocal_c_bpu.fFW, com_tencent_mm_protocal_c_bpu.url});
            if (c.PY().a(com_tencent_mm_protocal_c_bpu)) {
                e.post(new Runnable() {
                    public final void run() {
                        new o.a().bY(true);
                    }
                }, "WxaCommLibUpdate");
            }
        } else {
            w.e("MicroMsg.WxaCommLibVersionChecker", "onResp, null storage");
        }
    }

    public static void a(asd com_tencent_mm_protocal_c_asd) {
        if (com_tencent_mm_protocal_c_asd != null) {
            bpu com_tencent_mm_protocal_c_bpu = new bpu();
            com_tencent_mm_protocal_c_bpu.url = com_tencent_mm_protocal_c_asd.url;
            com_tencent_mm_protocal_c_bpu.fFW = com_tencent_mm_protocal_c_asd.fFW;
            com_tencent_mm_protocal_c_bpu.version = com_tencent_mm_protocal_c_asd.version;
            com_tencent_mm_protocal_c_bpu.tWA = com_tencent_mm_protocal_c_asd.tWA;
            a(0, 0, null, com_tencent_mm_protocal_c_bpu, false);
        }
    }
}
