package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.o;
import java.io.File;
import java.io.InputStream;
import java.util.Map;

public final class CacheManager {
    @Deprecated
    public static boolean cacheDisabled() {
        ac cfb = ac.cfb();
        if (cfb != null && cfb.cfc()) {
            return ((Boolean) cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cacheDisabled", new Class[0], new Object[0])).booleanValue();
        }
        Object fl = o.fl("android.webkit.CacheManager", "cacheDisabled");
        return fl == null ? false : ((Boolean) fl).booleanValue();
    }

    public static InputStream getCacheFile(String str, boolean z) {
        ac cfb = ac.cfb();
        if (cfb == null || !cfb.cfc()) {
            return null;
        }
        Object invokeStaticMethod = cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCacheFile", new Class[]{String.class, Boolean.TYPE}, new Object[]{str, Boolean.valueOf(z)});
        return invokeStaticMethod == null ? null : (InputStream) invokeStaticMethod;
    }

    public static Object getCacheFile(String str, Map<String, String> map) {
        ac cfb = ac.cfb();
        if (cfb != null && cfb.cfc()) {
            return cfb.cfd().cff();
        }
        try {
            return o.a(Class.forName("android.webkit.CacheManager"), "getCacheFile", new Class[]{String.class, Map.class}, new Object[]{str, map});
        } catch (Exception e) {
            return null;
        }
    }

    @Deprecated
    public static File getCacheFileBaseDir() {
        ac cfb = ac.cfb();
        return (cfb == null || !cfb.cfc()) ? (File) o.fl("android.webkit.CacheManager", "getCacheFileBaseDir") : (File) cfb.cfd().cff();
    }
}
