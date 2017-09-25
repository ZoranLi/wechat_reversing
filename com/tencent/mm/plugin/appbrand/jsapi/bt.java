package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.protocal.c.bqe;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import org.json.JSONObject;

final class bt extends a {
    public static final int CTRL_INDEX = 108;
    public static final String NAME = "reportRealtimeAction";

    bt() {
    }

    public final void a(m mVar, JSONObject jSONObject, int i) {
        a(mVar.ivH, d.b(mVar), jSONObject);
        mVar.x(i, d("ok", null));
    }

    public final void a(com.tencent.mm.plugin.appbrand.g.m mVar, JSONObject jSONObject, int i) {
        a(mVar.ivH, mVar, jSONObject);
        mVar.x(i, d("ok", null));
    }

    private static void a(String str, com.tencent.mm.plugin.appbrand.g.m mVar, JSONObject jSONObject) {
        String optString = jSONObject.optString("actionData");
        String str2 = "";
        if (mVar != null) {
            String str3 = mVar.jde.jdU;
            if (!bg.mA(str3) && str3.contains(".html")) {
                str2 = str3.substring(0, str3.lastIndexOf(".html") + 5);
            }
        }
        bqe com_tencent_mm_protocal_c_bqe = new bqe();
        com_tencent_mm_protocal_c_bqe.jOc = 2;
        com_tencent_mm_protocal_c_bqe.mtb = str;
        com_tencent_mm_protocal_c_bqe.uoo = str2;
        com_tencent_mm_protocal_c_bqe.oTD = 0;
        com_tencent_mm_protocal_c_bqe.oTE = 0;
        com_tencent_mm_protocal_c_bqe.uop = optString;
        com_tencent_mm_protocal_c_bqe.uor = a.bz(ab.getContext());
        com_tencent_mm_protocal_c_bqe.uoq = l.ns(str).ixn;
        AppBrandStatObject mZ = b.mZ(str);
        if (mZ != null) {
            com_tencent_mm_protocal_c_bqe.rVD = mZ.scene;
            com_tencent_mm_protocal_c_bqe.uot = mZ.fCN;
            com_tencent_mm_protocal_c_bqe.fWL = mZ.fWL;
            com_tencent_mm_protocal_c_bqe.fWM = mZ.fWM;
        }
        AppBrandIDKeyBatchReport.a(com_tencent_mm_protocal_c_bqe);
    }
}
