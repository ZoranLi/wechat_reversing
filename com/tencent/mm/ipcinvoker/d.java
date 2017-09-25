package com.tencent.mm.ipcinvoker;

import android.content.Context;
import android.os.Process;
import junit.framework.Assert;

public final class d {
    public static Context gVO;
    private static String gVP;

    public static Context getContext() {
        Assert.assertNotNull("IPCInvoker not initialize.", gVO);
        return gVO;
    }

    public static boolean dS(String str) {
        return str != null && str.equals(up());
    }

    public static String up() {
        if (gVP == null || gVP.length() == 0) {
            gVP = com.tencent.mm.loader.stub.d.q(gVO, Process.myPid());
        }
        return gVP;
    }
}
