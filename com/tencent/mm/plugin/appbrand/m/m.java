package com.tencent.mm.plugin.appbrand.m;

import com.tencent.mm.sdk.platformtools.w;
import java.lang.reflect.Method;

public final class m {
    public static <T> T a(Class<?> cls, String str, Object obj, Class<?>[] clsArr, Object[] objArr, T t) {
        if (obj == null) {
            throw new IllegalArgumentException("instance cannot be null");
        }
        Method method = null;
        Class<?> cls2 = obj.getClass();
        while (cls2 != null) {
            try {
                Method declaredMethod = cls2.getDeclaredMethod(str, clsArr);
                cls2 = cls2.getSuperclass();
                method = declaredMethod;
            } catch (Exception e) {
                if (cls == cls2) {
                    try {
                        method = cls2.getDeclaredMethod(str, clsArr);
                    } catch (Exception e2) {
                    } catch (Throwable th) {
                        cls2.getSuperclass();
                    }
                }
                cls2 = cls2.getSuperclass();
            } catch (Throwable th2) {
                cls2.getSuperclass();
            }
        }
        if (method != null) {
            try {
                method.setAccessible(true);
                t = method.invoke(obj, objArr);
            } catch (Throwable e3) {
                w.printErrStackTrace("MicroMsg.ReflectUtil", e3, "", new Object[0]);
            }
        }
        return t;
    }

    public static <T> T a(String str, Object obj, Class<?>[] clsArr, Object[] objArr, T t) {
        return a(null, str, obj, clsArr, objArr, t);
    }

    public static <T> T e(String str, Object obj, T t) {
        return a(null, str, obj, null, null, t);
    }
}
