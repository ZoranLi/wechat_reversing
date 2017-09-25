package com.tencent.mm.sandbox;

import android.os.Process;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;

public final class c {
    private static c upJ = null;
    private static Map<Integer, Boolean> upK = new HashMap();

    public static void f(int i, Object obj) {
        w.i("MicroMsg.SandBoxCore", "regLifeCycle, id=" + i + ", class=%s", obj.getClass().getName());
        upK.put(Integer.valueOf(i), Boolean.valueOf(true));
        w.i("MicroMsg.SandBoxCore", "regLifeCycle, map size=" + upK.size());
    }

    public static void g(int i, Object obj) {
        w.i("MicroMsg.SandBoxCore", "unregLifeCycle, id=" + i + ", class=%s", obj.getClass().getName());
        upK.remove(Integer.valueOf(i));
        w.i("MicroMsg.SandBoxCore", "unregLifeCycle, map size=" + upK.size());
        if (upK.size() == 0) {
            Process.killProcess(Process.myPid());
            w.w("MicroMsg.SandBoxCore", "Sandbox exit Now.");
            w.bIQ();
        }
    }
}
