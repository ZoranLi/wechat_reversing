package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.sdk.platformtools.w;

public enum h {
    ;

    public static long of(String str) {
        long j;
        AppBrandSysConfig mY = b.mY(str);
        String str2 = "MicroMsg.AppServiceSettingRemoteManager";
        String str3 = "getMaxFileStorageSize, (null == config) = %b, MaxFileStorageSize = %d";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(mY == null);
        objArr[1] = Long.valueOf(mY == null ? -1 : mY.iEZ);
        w.i(str2, str3, objArr);
        if (mY == null || mY.iEZ <= 0) {
            j = 10;
        } else {
            j = mY.iEZ;
        }
        return j * 1048576;
    }
}
