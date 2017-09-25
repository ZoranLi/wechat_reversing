package com.tencent.pb.common.c;

import java.lang.reflect.Field;

public final class f {
    public static Class<?> wPa;

    private static boolean UU(String str) {
        Class cls = null;
        try {
            cls = Class.forName(str);
        } catch (ClassNotFoundException e) {
        }
        wPa = cls;
        return cls != null;
    }

    private static final Field getField(String str) {
        Field field = null;
        try {
            field = wPa.getDeclaredField(str);
            field.setAccessible(true);
            return field;
        } catch (SecurityException e) {
            return field;
        } catch (NoSuchFieldException e2) {
            return field;
        }
    }

    public static Object fb(String str, String str2) {
        Object obj = null;
        UU(str);
        Field field = getField(str2);
        if (field != null) {
            try {
                obj = field.get(null);
            } catch (IllegalArgumentException e) {
            } catch (IllegalAccessException e2) {
            }
        }
        return obj;
    }
}
