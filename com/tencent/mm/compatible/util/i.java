package com.tencent.mm.compatible.util;

import java.security.PrivilegedAction;

public final class i implements PrivilegedAction {
    private String gSQ;
    private String gSR;

    public i(String str) {
        this.gSQ = str;
    }

    public final Object run() {
        Object property = System.getProperty(this.gSQ);
        return property == null ? this.gSR : property;
    }
}
