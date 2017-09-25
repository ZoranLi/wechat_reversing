package com.tencent.mm.ipcinvoker.e;

import com.tencent.mm.sdk.platformtools.w;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class b {
    public static <T> T c(String str, Class<?> cls) {
        T t = null;
        if (str == null || str.length() == 0) {
            w.e("IPC.ReflectUtil", "newInstance failed, class is null or nil.");
        } else if (cls == null) {
            w.e("IPC.ReflectUtil", "newInstance failed, parent class is null.");
        } else {
            try {
                Class cls2 = Class.forName(str);
                if (cls.isAssignableFrom(cls2)) {
                    Constructor declaredConstructor = cls2.getDeclaredConstructor(new Class[0]);
                    declaredConstructor.setAccessible(true);
                    t = declaredConstructor.newInstance(new Object[0]);
                } else {
                    w.e("IPC.ReflectUtil", "%s isAssignableFrom %s return false", cls, cls2);
                }
            } catch (ClassNotFoundException e) {
                w.e("IPC.ReflectUtil", "reflect error : %s", e);
            } catch (IllegalAccessException e2) {
                w.e("IPC.ReflectUtil", "reflect error : %s", e2);
            } catch (InstantiationException e3) {
                w.e("IPC.ReflectUtil", "reflect error : %s", e3);
            } catch (NoSuchMethodException e4) {
                w.e("IPC.ReflectUtil", "reflect error : %s", e4);
            } catch (InvocationTargetException e5) {
                w.e("IPC.ReflectUtil", "reflect error : %s", e5);
            }
        }
        return t;
    }

    public static <T> T b(Class<?> cls, Class<?> cls2) {
        T t = null;
        if (cls == null) {
            w.e("IPC.ReflectUtil", "newInstance failed, class is null or nil.");
        } else if (cls2 == null) {
            w.e("IPC.ReflectUtil", "newInstance failed, parent class is null.");
        } else {
            try {
                if (cls2.isAssignableFrom(cls)) {
                    Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
                    declaredConstructor.setAccessible(true);
                    t = declaredConstructor.newInstance(new Object[0]);
                } else {
                    w.e("IPC.ReflectUtil", "%s isAssignableFrom %s return false", cls2, cls);
                }
            } catch (IllegalAccessException e) {
                w.e("IPC.ReflectUtil", "reflect error : %s", e);
            } catch (InstantiationException e2) {
                w.e("IPC.ReflectUtil", "reflect error : %s", e2);
            } catch (NoSuchMethodException e3) {
                w.e("IPC.ReflectUtil", "reflect error : %s", e3);
            } catch (InvocationTargetException e4) {
                w.e("IPC.ReflectUtil", "reflect error : %s", e4);
            }
        }
        return t;
    }

    public static <T> T e(Class<?> cls) {
        T t = null;
        if (cls == null) {
            w.e("IPC.ReflectUtil", "newInstance failed, class is null or nil.");
        } else {
            try {
                Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                t = declaredConstructor.newInstance(new Object[0]);
            } catch (IllegalAccessException e) {
                w.e("IPC.ReflectUtil", "reflect error : %s", e);
            } catch (InstantiationException e2) {
                w.e("IPC.ReflectUtil", "reflect error : %s", e2);
            } catch (NoSuchMethodException e3) {
                w.e("IPC.ReflectUtil", "reflect error : %s", e3);
            } catch (InvocationTargetException e4) {
                w.e("IPC.ReflectUtil", "reflect error : %s", e4);
            }
        }
        return t;
    }
}
