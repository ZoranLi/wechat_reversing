package com.tencent.mm.sdk.platformtools;

import java.util.HashMap;

public final class bc {
    private static final HashMap<String, String> uvN = new HashMap();

    public static String getProperty(String str) {
        return (String) uvN.get(str);
    }

    public static void setProperty(String str, String str2) {
        uvN.put(str, str2);
    }
}
