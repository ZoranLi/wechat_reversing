package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import org.json.JSONObject;

public final class b extends a {
    private static final int CTRL_INDEX = 245;
    private static final String NAME = "reportPageData";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        AppBrandSysConfig mY = com.tencent.mm.plugin.appbrand.b.mY(mVar.ivH);
        AppBrandStatObject mZ = com.tencent.mm.plugin.appbrand.b.mZ(mVar.ivH);
        MainProcessTask reportTask = new ReportTask();
        if (mY != null) {
            reportTask.appId = mY.appId;
            reportTask.username = mY.fCJ;
            reportTask.iPk = mY.iFk.izV;
            reportTask.fWF = mY.iFk.izW;
            reportTask.iRt = mY.iFl.izW;
        }
        if (mZ != null) {
            reportTask.scene = mZ.scene;
            reportTask.fWL = mZ.fWL;
        }
        com.tencent.mm.plugin.appbrand.g.m b = d.b(mVar);
        if (b != null) {
            reportTask.fCO = b.jde.jdU;
        }
        reportTask.iTT = jSONObject.toString();
        AppBrandMainProcessService.a(reportTask);
        mVar.x(i, d("ok", null));
    }
}
