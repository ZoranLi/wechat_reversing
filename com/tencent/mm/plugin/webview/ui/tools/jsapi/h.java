package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.w;

public final class h {
    private static final SparseArray<g> smJ = new SparseArray();
    private static volatile g smK = null;

    private h() {
    }

    @Deprecated
    public static g bzS() {
        if (smK == null) {
            smK = new g(0);
        }
        return smK;
    }

    public static g wH(int i) {
        g gVar;
        synchronized (h.class) {
            if (smJ.get(i) == null) {
                smJ.put(i, new g(i));
            }
            gVar = (g) smJ.get(i);
            smK = gVar;
        }
        return gVar;
    }

    public static void detach() {
        w.i("MicroMsg.MsgHandlerHolder", "detach");
        synchronized (h.class) {
            for (int i = 0; i < smJ.size(); i++) {
                g gVar = (g) smJ.valueAt(i);
                int keyAt = smJ.keyAt(i);
                if (gVar != null) {
                    a.rYG.vX(keyAt);
                }
            }
            smJ.clear();
        }
        if (smK != null) {
            a.rYG.vX(0);
            smK = null;
        }
    }
}
