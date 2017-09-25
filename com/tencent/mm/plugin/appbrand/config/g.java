package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.sdk.platformtools.w;

public enum g {
    ;

    public static int oe(String str) {
        int i;
        WxaAttributes e = c.PR().e(str, "dynamicInfo");
        String str2 = "MicroMsg.AppServiceSettingMMManager";
        String str3 = "readAppFileStorageMaxSizeInBytes, appId = %s, MaxLocalstorageSize = %d";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (e == null) {
            i = -1;
        } else {
            i = e.RI().iFW.iFY;
        }
        objArr[1] = Integer.valueOf(i);
        w.i(str2, str3, objArr);
        if (e != null) {
            i = e.RI().iFW.iFY;
        } else {
            i = 5;
        }
        return i * 1048576;
    }
}
