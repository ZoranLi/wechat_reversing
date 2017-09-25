package com.tencent.mm.plugin.appbrand.dynamic;

import android.view.View;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class e {
    private static e iGJ;
    public Map<String, WeakReference<View>> iGK = new ConcurrentHashMap();

    private e() {
    }

    public static e RQ() {
        if (iGJ == null) {
            synchronized (e.class) {
                if (iGJ == null) {
                    iGJ = new e();
                }
            }
        }
        return iGJ;
    }

    public final View oz(String str) {
        if (bg.mA(str)) {
            w.w("MicroMsg.DynamicPageViewMgr", "get view from manager failed, key is null or nil.");
            return null;
        }
        WeakReference weakReference = (WeakReference) this.iGK.get(str);
        return weakReference != null ? (View) weakReference.get() : null;
    }
}
