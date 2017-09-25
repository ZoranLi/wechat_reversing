package com.tencent.smtt.sdk;

import android.webkit.URLUtil;

public final class x {
    public static boolean isHttpsUrl(String str) {
        ac cfb = ac.cfb();
        if (cfb == null || !cfb.cfc()) {
            return URLUtil.isHttpsUrl(str);
        }
        Object invokeStaticMethod = cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsHttpsUrl", new Class[]{String.class}, str);
        return invokeStaticMethod == null ? false : ((Boolean) invokeStaticMethod).booleanValue();
    }
}
