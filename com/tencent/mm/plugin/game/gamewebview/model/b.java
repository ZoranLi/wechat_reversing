package com.tencent.mm.plugin.game.gamewebview.model;

import java.util.HashMap;

public final class b {
    private static HashMap<String, String> mlw = new HashMap();

    public static void cj(String str, String str2) {
        mlw.put(str, str2);
    }

    public static String xz(String str) {
        return (String) mlw.get(str);
    }

    public static void xA(String str) {
        mlw.remove(str);
    }
}
