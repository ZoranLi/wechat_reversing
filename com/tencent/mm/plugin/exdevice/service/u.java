package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.plugin.exdevice.model.c;

public final class u {
    private static u lgN = null;
    private c lgO;
    private f lgP;

    private static u apT() {
        if (lgN == null) {
            lgN = new u();
        }
        return lgN;
    }

    public static f apU() {
        if (apT().lgP == null) {
            apT().lgP = new f();
        }
        return apT().lgP;
    }

    public static void a(m mVar) {
        apV().laU = mVar;
    }

    public static c apV() {
        if (apT().lgO == null) {
            u apT = apT();
            if (c.laT == null) {
                c.laT = new c();
            }
            apT.lgO = c.laT;
        }
        return apT().lgO;
    }
}
