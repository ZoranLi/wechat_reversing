package com.tencent.c.d.b;

import android.text.TextUtils;
import com.tencent.c.e.g;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class e {
    private static Field a(Class<?> cls, String str) {
        if (cls == null) {
            return null;
        }
        try {
            Field declaredField = cls.getDeclaredField(str);
            if (declaredField == null) {
                return null;
            }
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable th) {
            g.i(th);
            return null;
        }
    }

    private static Class<?> p(String str, Object obj) {
        Class<?> cls;
        try {
            cls = Class.forName(str);
        } catch (Throwable th) {
            g.i(th);
            return null;
        }
        if (cls == null) {
            return null;
        }
        return cls;
    }

    public static Object b(Class<?> cls, String str, Object obj) {
        Object obj2 = null;
        try {
            Field a = a(cls, str);
            if (a != null) {
                obj2 = a.get(obj);
            }
        } catch (Throwable th) {
            g.i(th);
        }
        return obj2;
    }

    public static Object fd(String str, String str2) {
        Object obj = null;
        try {
            obj = b(p(str, null), str2, null);
        } catch (Throwable th) {
            g.i(th);
        }
        return obj;
    }

    private static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls == null) {
            return null;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            if (declaredMethod == null) {
                return null;
            }
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable th) {
            g.i(th);
            return null;
        }
    }

    public static Method a(String str, String str2, Class<?>... clsArr) {
        Method method = null;
        try {
            method = a(p(str, null), str2, (Class[]) clsArr);
        } catch (Throwable th) {
            g.i(th);
        }
        return method;
    }
}
