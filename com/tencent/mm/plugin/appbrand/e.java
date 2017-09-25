package com.tencent.mm.plugin.appbrand;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class e {
    private static Map<String, a> ivO = new HashMap();
    private static Map<String, c> ivP = new HashMap();
    private static Map<String, Set<b>> ivQ = new ConcurrentHashMap();

    public enum a {
        ivR,
        ON_CREATE,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY
    }

    public static class b {
        public void onDestroy() {
        }

        public void a(c cVar) {
        }

        public void onResume() {
        }
    }

    public enum c {
        CLOSE,
        BACK,
        HIDE,
        HANG,
        HOME_PRESSED,
        LAUNCH_NATIVE_PAGE,
        LAUNCH_MINI_PROGRAM
    }

    public static void a(String str, b bVar) {
        if (str != null && bVar != null) {
            if (!ivQ.containsKey(str)) {
                ivQ.put(str, Collections.newSetFromMap(new ConcurrentHashMap()));
            }
            ((Set) ivQ.get(str)).add(bVar);
        }
    }

    private static Iterator<b> nc(String str) {
        Set set = (Set) ivQ.get(str);
        if (set == null) {
            set = new HashSet();
        }
        return set.iterator();
    }

    public static void nd(String str) {
        Iterator nc = nc(str);
        while (nc.hasNext()) {
            nc.next();
        }
    }

    public static void ne(String str) {
        Iterator nc = nc(str);
        while (nc.hasNext()) {
            ((b) nc.next()).onDestroy();
        }
    }

    public static void nf(String str) {
        Iterator nc = nc(str);
        while (nc.hasNext()) {
            ((b) nc.next()).a(nk(str));
        }
    }

    public static void ng(String str) {
        Iterator nc = nc(str);
        while (nc.hasNext()) {
            ((b) nc.next()).onResume();
        }
    }

    public static void nh(String str) {
        Iterator nc = nc(str);
        while (nc.hasNext()) {
            nc.next();
        }
    }

    public static void b(String str, b bVar) {
        if (bVar != null) {
            Set set = (Set) ivQ.get(str);
            if (set != null && !set.isEmpty()) {
                set.remove(bVar);
            }
        }
    }

    public static void ni(String str) {
        ivQ.remove(str);
    }

    public static void nj(String str) {
        a(str, c.HIDE);
    }

    public static c nk(String str) {
        c cVar = (c) ivP.get(str);
        if (cVar == null) {
            return c.HIDE;
        }
        return cVar;
    }

    public static void a(String str, c cVar) {
        if (!TextUtils.isEmpty(str)) {
            ivP.put(str, cVar);
        }
    }

    public static void a(String str, a aVar) {
        if (!TextUtils.isEmpty(str)) {
            ivO.put(str, aVar);
        }
    }

    public static a nl(String str) {
        a aVar = (a) ivO.get(str);
        if (aVar == null) {
            return a.ivR;
        }
        return aVar;
    }
}
