package com.tencent.mm.cache;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;

public interface a {

    public static class a {
        private static Map<String, a> gMP = new HashMap();

        public static void a(String str, a aVar) {
            gMP.put(str, aVar);
        }

        private static a dq(String str) {
            return (a) gMP.get(str);
        }

        public static <T> T x(String str, String str2) {
            return a(dq(str), str2, null);
        }

        public static <T> void a(String str, String str2, T t) {
            a dq = dq(str);
            if (dq == null) {
                w.e("MicroMsg.ICacheService.Factory", "null service");
            } else {
                dq.m(str2, t);
            }
        }

        public static <T> void y(String str, String str2) {
            a(dq(str), str2);
        }

        private static <T> T a(a aVar, String str, T t) {
            T t2 = null;
            if (aVar == null) {
                w.e("MicroMsg.ICacheService.Factory", "null service");
            } else {
                try {
                    t2 = aVar.get(str);
                } catch (Throwable e) {
                    w.e("MicroMsg.ICacheService.Factory", "cast failed, different type ?");
                    w.e("MicroMsg.ICacheService.Factory", "exception:%s", bg.g(e));
                }
            }
            return t2;
        }

        private static <T> T a(a aVar, String str) {
            T t = null;
            if (aVar == null) {
                w.e("MicroMsg.ICacheService.Factory", "null service");
            } else {
                try {
                    t = aVar.remove(str);
                } catch (Throwable e) {
                    w.e("MicroMsg.ICacheService.Factory", "cast failed, different type ?");
                    w.e("MicroMsg.ICacheService.Factory", "exception:%s", bg.g(e));
                }
            }
            return t;
        }
    }

    Object get(Object obj);

    void m(Object obj, Object obj2);

    Object remove(Object obj);
}
