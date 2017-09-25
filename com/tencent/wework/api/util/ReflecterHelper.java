package com.tencent.wework.api.util;

import java.lang.reflect.Constructor;

public final class ReflecterHelper {
    public static Object newInstance(String str) {
        Constructor declaredConstructor = Class.forName(str).getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        return declaredConstructor.newInstance(null);
    }
}
