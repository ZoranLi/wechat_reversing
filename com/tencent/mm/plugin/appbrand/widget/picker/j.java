package com.tencent.mm.plugin.appbrand.widget.picker;

import com.tencent.mm.sdk.platformtools.bg;

public final class j {
    public static boolean jb(int i) {
        return i >= 0 && i <= 59;
    }

    public static boolean jc(int i) {
        return i >= 0 && i <= 23;
    }

    public static int[] rw(String str) {
        if (bg.mA(str)) {
            return null;
        }
        String[] split = str.split(":");
        if (split == null || split.length != 2) {
            return null;
        }
        int rx = rx(split[0]);
        int rx2 = rx(split[1]);
        if (!jc(rx) || !jb(rx2)) {
            return null;
        }
        return new int[]{rx, rx2};
    }

    private static int rx(String str) {
        try {
            return Integer.parseInt(str, 10);
        } catch (Exception e) {
            return -1;
        }
    }
}
