package com.tencent.mm.ipcinvoker;

import com.tencent.mm.ipcinvoker.c.a;
import com.tencent.mm.ipcinvoker.e.b;
import com.tencent.mm.ipcinvoker.extension.e;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class n {
    private static Map<String, e> gWj = new ConcurrentHashMap();

    public static <T> T b(String str, Class<?> cls) {
        try {
            Class cls2 = Class.forName(str);
            if (!cls.isAssignableFrom(cls2)) {
                w.e("IPC.ObjectStore", "%s isAssignableFrom %s return false", cls, cls2);
                return null;
            } else if (!cls2.isAnnotationPresent(a.class)) {
                return b.c(str, cls);
            } else {
                e eVar = (e) gWj.get(str);
                if (eVar == null) {
                    eVar = new e(cls2);
                    gWj.put(str, eVar);
                }
                return eVar.get();
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static <T> T a(Class<?> cls, Class<?> cls2) {
        try {
            if (!cls2.isAssignableFrom(cls)) {
                w.e("IPC.ObjectStore", "%s isAssignableFrom %s return false", cls2, cls);
                return null;
            } else if (!cls.isAnnotationPresent(a.class)) {
                return b.b(cls, cls2);
            } else {
                String name = cls.getName();
                e eVar = (e) gWj.get(name);
                if (eVar == null) {
                    eVar = new e(cls);
                    gWj.put(name, eVar);
                }
                return eVar.get();
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static <T> T c(String str, Class<?> cls) {
        return b.c(str, cls);
    }
}
