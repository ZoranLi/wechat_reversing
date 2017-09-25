package com.tencent.mm.kernel;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class g {
    private static volatile boolean gYH = true;

    private static class a implements InvocationHandler {
        public int level = 0;

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            Class returnType = method.getReturnType();
            if (returnType.equals(Integer.TYPE)) {
                return Integer.valueOf(0);
            }
            if (returnType.equals(Long.TYPE)) {
                return Long.valueOf(0);
            }
            if (returnType.equals(Double.TYPE)) {
                return Double.valueOf(0.0d);
            }
            if (returnType.equals(Float.TYPE)) {
                return Float.valueOf(0.0f);
            }
            if (returnType.equals(Short.TYPE)) {
                return Integer.valueOf(0);
            }
            if (returnType.equals(Byte.TYPE)) {
                return Integer.valueOf(0);
            }
            if (returnType.equals(Character.TYPE)) {
                return Integer.valueOf(0);
            }
            if (returnType.equals(Boolean.TYPE)) {
                return Boolean.valueOf(false);
            }
            if (returnType.equals(Boolean.class)) {
                return Boolean.valueOf(false);
            }
            if (returnType.isInterface()) {
                return g.a(returnType, this.level + 1);
            }
            return null;
        }
    }

    private interface b {
    }

    public static <T> T l(Class<T> cls) {
        if (gYH) {
            return a(cls, 0);
        }
        return null;
    }

    public static <T> T a(Class<T> cls, int i) {
        T t = null;
        if (gYH) {
            if (i > 3) {
                j.e("MMSkeleton.DummyMode", "dummy level > 3, return null.", new Object[0]);
            } else if (cls.isInterface()) {
                try {
                    InvocationHandler aVar = new a();
                    aVar.level = i;
                    j.i("MMSkeleton.DummyMode", "dummy level %s", Integer.valueOf(i));
                    t = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls, b.class}, aVar);
                } catch (Throwable th) {
                    j.printErrStackTrace("MMSkeleton.DummyMode", th, "", new Object[0]);
                }
            }
        }
        return t;
    }
}
