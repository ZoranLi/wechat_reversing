package com.tencent.mm.ipcinvoker;

import java.util.HashMap;
import java.util.Map;

public class j {
    private static j gVX;
    Map<String, BaseIPCService> gVY = new HashMap();

    private j() {
    }

    public static j uq() {
        if (gVX == null) {
            synchronized (j.class) {
                if (gVX == null) {
                    gVX = new j();
                }
            }
        }
        return gVX;
    }

    public final BaseIPCService dW(String str) {
        return (BaseIPCService) this.gVY.get(str);
    }
}
