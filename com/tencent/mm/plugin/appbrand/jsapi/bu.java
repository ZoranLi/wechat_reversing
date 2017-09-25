package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.base.ReportSubmitFormTask;
import com.tencent.mm.plugin.appbrand.l;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class bu extends a {
    public static final int CTRL_INDEX = 66;
    public static final String NAME = "reportSubmitForm";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        MainProcessTask reportSubmitFormTask = new ReportSubmitFormTask(mVar.ivH);
        reportSubmitFormTask.type = 1;
        reportSubmitFormTask.iRo = System.currentTimeMillis();
        reportSubmitFormTask.iGe = mVar.jde.jdV;
        AppBrandMainProcessService.a(reportSubmitFormTask);
        Map hashMap = new HashMap();
        hashMap.put("formId", reportSubmitFormTask.iRo);
        l nt = l.nt(mVar.ivH);
        if (nt != null) {
            nt.ixo = reportSubmitFormTask.iRo;
        }
        mVar.x(i, d("ok", hashMap));
    }
}
