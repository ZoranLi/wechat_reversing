package com.tencent.mm.compatible.loader;

public final class a {
    private static Object[] gRS = new Object[0];
    private static Object[] gRT = new Object[73];

    public static int P(int i) {
        int i2 = i * 4;
        for (int i3 = 4; i3 < 32; i3++) {
            if (i2 <= (1 << i3) - 12) {
                i2 = (1 << i3) - 12;
                break;
            }
        }
        return i2 / 4;
    }

    public static <T> boolean a(T[] tArr, T t) {
        for (Object obj : tArr) {
            if (obj == null) {
                if (t == null) {
                    return true;
                }
            } else if (t != null && obj.equals(t)) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }
}
