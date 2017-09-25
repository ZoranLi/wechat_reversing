package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Build.VERSION;
import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.smtt.sdk.QbSdk;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class ah extends k {
    private static final int CTRL_INDEX = 97;
    private static final String NAME = "getPublicLibVersion";

    ah() {
    }

    public final String a(m mVar, JSONObject jSONObject) {
        return pm(mVar.ivH);
    }

    public final String a(com.tencent.mm.plugin.appbrand.g.m mVar) {
        return pm(mVar.ivH);
    }

    private String pm(String str) {
        boolean z = true;
        AppBrandSysConfig mY = b.mY(str);
        if (mY == null) {
            return d("fail", null);
        }
        Map hashMap = new HashMap();
        hashMap.put("appDebug", Boolean.valueOf(mY.iFk.izV != 0));
        hashMap.put("appMd5", bg.mz(mY.iFk.izZ));
        hashMap.put("appVersion", Integer.valueOf(mY.iFk.izW));
        String str2 = "libDebug";
        if (mY.iFl.izV == 0) {
            z = false;
        }
        hashMap.put(str2, Boolean.valueOf(z));
        hashMap.put("libMd5", bg.mz(mY.iFl.izZ));
        hashMap.put("libVersion", Integer.valueOf(mY.iFl.izW));
        hashMap.put("clientVersion", Integer.valueOf(d.sYN));
        hashMap.put("system", "android");
        hashMap.put("systemVersion", Integer.valueOf(VERSION.SDK_INT));
        hashMap.put("x5Version", Integer.valueOf(QbSdk.getTbsVersion(ab.getContext())));
        return d("ok", hashMap);
    }
}
