package com.tencent.mm.plugin.exdevice.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.a.g;
import com.tencent.mm.bb.d;
import com.tencent.mm.protocal.c.aen;
import com.tencent.mm.protocal.c.aeo;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ag.b.a;
import com.tencent.mm.x.b;

public final class f {

    static class AnonymousClass1 implements a {
        final /* synthetic */ long kDm;
        final /* synthetic */ Runnable lcs;

        public AnonymousClass1(long j, Runnable runnable) {
            this.kDm = j;
            this.lcs = runnable;
        }

        public final void p(String str, boolean z) {
            if (z) {
                w.v("MicroMsg.exdevice.ExdeviceLogic", "getContact suc; cost=" + (bg.Nz() - this.kDm) + " ms");
                b.u(str, 3);
                if (this.lcs != null) {
                    this.lcs.run();
                    return;
                }
                return;
            }
            w.w("MicroMsg.exdevice.ExdeviceLogic", "getContact failed");
        }
    }

    public static boolean S(Context context, String str) {
        if (bg.mA(str)) {
            w.i("MicroMsg.exdevice.ExdeviceLogic", "Jump to webview failed, url is null or nil.");
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        d.b(context, "webview", ".ui.tools.WebViewUI", intent);
        return true;
    }

    public static void a(com.tencent.mm.plugin.exdevice.h.b bVar, aen com_tencent_mm_protocal_c_aen, aeo com_tencent_mm_protocal_c_aeo) {
        if (com_tencent_mm_protocal_c_aeo != null) {
            bVar.field_connProto = com_tencent_mm_protocal_c_aeo.tJF;
            bVar.field_connStrategy = com_tencent_mm_protocal_c_aeo.tJG;
            bVar.field_closeStrategy = com_tencent_mm_protocal_c_aeo.tJH;
            bVar.field_mac = com.tencent.mm.plugin.exdevice.j.b.vx(com.tencent.mm.plugin.exdevice.j.b.vy(com_tencent_mm_protocal_c_aeo.tiU));
            bVar.field_authKey = com_tencent_mm_protocal_c_aeo.thm;
            bVar.field_brandName = com_tencent_mm_protocal_c_aeo.tJE;
            bVar.bO(com_tencent_mm_protocal_c_aeo.hAI);
            bVar.w(com_tencent_mm_protocal_c_aeo.gtW);
            bVar.cC(com_tencent_mm_protocal_c_aeo.tJN);
            bVar.cB(com_tencent_mm_protocal_c_aeo.tJM);
            bVar.cA(com_tencent_mm_protocal_c_aeo.tJL);
            bVar.dD(com_tencent_mm_protocal_c_aeo.tJO);
            bVar.cy(com_tencent_mm_protocal_c_aeo.muU);
            bVar.dE(com_tencent_mm_protocal_c_aeo.gtV);
            bVar.cz(com_tencent_mm_protocal_c_aeo.msF);
            bVar.cD(com_tencent_mm_protocal_c_aeo.gtX);
            bVar.cE(com_tencent_mm_protocal_c_aeo.gtY);
            bVar.cF(com_tencent_mm_protocal_c_aeo.gtZ);
            bVar.cG(com_tencent_mm_protocal_c_aeo.gua);
        }
        if (com_tencent_mm_protocal_c_aen != null) {
            bVar.field_deviceID = com_tencent_mm_protocal_c_aen.jNm;
            bVar.field_deviceType = com_tencent_mm_protocal_c_aen.thD;
            bVar.field_md5Str = g.n(new String(com_tencent_mm_protocal_c_aen.thD + com_tencent_mm_protocal_c_aen.jNm).getBytes());
            if (bg.mA(bVar.field_brandName)) {
                bVar.field_brandName = com_tencent_mm_protocal_c_aen.thD;
            }
        }
    }

    public static boolean b(com.tencent.mm.plugin.exdevice.h.b bVar) {
        return bVar != null && (bVar.gtW & 1) == 1;
    }
}
