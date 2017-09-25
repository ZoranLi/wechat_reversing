package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;

public final class e {
    public static void a(String str, String str2, String str3, String str4, long j, long j2, int i, int i2, int i3) {
        AppBrandSysConfig mY = b.mY(str);
        if (mY != null) {
            int i4 = mY.iFk.izW;
            int i5 = mY.iFk.izV + 1;
            String bz = a.bz(ab.getContext());
            g.oUh.i(14510, new Object[]{str, Integer.valueOf(i4), Integer.valueOf(i5), bz, str2, str4, str3, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            StringBuilder stringBuilder = new StringBuilder("report kv_14510{");
            stringBuilder.append("appId='").append(str).append('\'').append(", appVersion=").append(i4).append(", appState=").append(i5).append(", networkType='").append(bz).append('\'').append(", functionName='").append(str2).append('\'').append(", url='").append(str4).append('\'').append(", method='").append(str3).append('\'').append(", sentsize=").append(j).append(", receivedsize=").append(j2).append(", statusCode=").append(i).append(", result=").append(i2).append(", costtime=").append(i3).append('}');
            w.d("MicroMsg.AppBrand.Report.kv_14510", stringBuilder.toString());
            return;
        }
        w.w("MicroMsg.AppBrand.Report.kv_14510", "kv_14510 report config is null. %s", new Object[]{str});
    }
}
