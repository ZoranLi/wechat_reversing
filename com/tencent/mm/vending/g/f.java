package com.tencent.mm.vending.g;

import java.util.Stack;

final class f {
    private static f wDx;
    ThreadLocal<Stack<c>> wDy = new ThreadLocal();

    private f() {
    }

    static {
        wDx = null;
        wDx = new f();
    }

    public static f cbI() {
        return wDx;
    }
}
