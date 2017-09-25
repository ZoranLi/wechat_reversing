package com.tencent.smtt.sdk;

import android.content.Context;
import java.lang.reflect.Field;

public class CookieSyncManager {
    private static android.webkit.CookieSyncManager wSQ;
    private static CookieSyncManager wSR;
    private static boolean wSS = false;

    private CookieSyncManager(Context context) {
        ac cfb = ac.cfb();
        if (cfb != null && cfb.cfc()) {
            cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_createInstance", new Class[]{Context.class}, context);
            wSS = true;
        }
    }

    public static synchronized CookieSyncManager createInstance(Context context) {
        CookieSyncManager cookieSyncManager;
        synchronized (CookieSyncManager.class) {
            wSQ = android.webkit.CookieSyncManager.createInstance(context);
            if (wSR == null || !wSS) {
                wSR = new CookieSyncManager(context.getApplicationContext());
            }
            cookieSyncManager = wSR;
        }
        return cookieSyncManager;
    }

    public static synchronized CookieSyncManager getInstance() {
        CookieSyncManager cookieSyncManager;
        synchronized (CookieSyncManager.class) {
            if (wSR == null) {
                throw new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
            }
            cookieSyncManager = wSR;
        }
        return cookieSyncManager;
    }

    public void startSync() {
        ac cfb = ac.cfb();
        if (cfb == null || !cfb.cfc()) {
            wSQ.startSync();
            try {
                Field declaredField = Class.forName("android.webkit.WebSyncManager").getDeclaredField("mSyncThread");
                declaredField.setAccessible(true);
                ((Thread) declaredField.get(wSQ)).setUncaughtExceptionHandler(new SQLiteUncaughtExceptionHandler());
                return;
            } catch (Exception e) {
                return;
            }
        }
        cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_startSync", new Class[0], new Object[0]);
    }

    public void stopSync() {
        ac cfb = ac.cfb();
        if (cfb == null || !cfb.cfc()) {
            wSQ.stopSync();
        } else {
            cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_stopSync", new Class[0], new Object[0]);
        }
    }

    public void sync() {
        ac cfb = ac.cfb();
        if (cfb == null || !cfb.cfc()) {
            wSQ.sync();
        } else {
            cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_Sync", new Class[0], new Object[0]);
        }
    }
}
