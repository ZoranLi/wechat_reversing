package com.tencent.mm.plugin.welab;

import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.w;

public final class e {

    public static class a {
        public int action;
        public String fTO;
        public long hTv;
        public String ssR;
        public boolean ssS;
    }

    public static void a(a aVar) {
        int i;
        d dVar = new d();
        dVar.n("expid", aVar.ssR + ",");
        dVar.n("appid", aVar.fTO + ",");
        dVar.n("action", aVar.action + ",");
        dVar.n("timestamp", aVar.hTv + ",");
        String str = "hasRedPoint";
        StringBuilder stringBuilder = new StringBuilder();
        if (aVar.ssS) {
            i = 1;
        } else {
            i = 0;
        }
        dVar.n(str, stringBuilder.append(i).append(",").toString());
        w.i("WelabReporter", "report " + dVar.JG());
        g.oUh.i(14206, new Object[]{dVar});
    }

    public static void o(String str, int i, boolean z) {
        a aVar = new a();
        aVar.fTO = str;
        aVar.action = i;
        aVar.hTv = System.currentTimeMillis();
        aVar.ssR = b.bAG().KU(str).field_expId;
        aVar.ssS = z;
        a(aVar);
    }
}
