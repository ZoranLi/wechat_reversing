package com.tencent.mm.plugin.webview.wepkg.downloader;

import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class d {
    private static Object lock = new Object();
    public static d spq;
    HashMap<String, c> spr = new HashMap();

    public static d bAt() {
        if (spq == null) {
            synchronized (lock) {
                if (spq == null) {
                    spq = new d();
                }
            }
        }
        return spq;
    }

    public final boolean KA(String str) {
        if (this.spr.containsKey(str)) {
            this.spr.remove(str);
        }
        return true;
    }

    private boolean a(c cVar) {
        if (!this.spr.containsKey(cVar.sph.spE)) {
            return false;
        }
        cVar.spn = true;
        try {
            if (cVar.spj != null) {
                cVar.spj.disconnect();
            }
            if (cVar.spi != null) {
                cVar.spi.cancel(false);
            }
        } catch (Exception e) {
            w.i("MicroMsg.Wepkg.WePkgDownloadTask", "stop, " + e.getMessage());
        }
        this.spr.remove(cVar.sph.spE);
        return true;
    }

    public final boolean bAu() {
        if (this.spr == null || this.spr.size() == 0) {
            return false;
        }
        Collection<c> values = this.spr.values();
        ArrayList arrayList = new ArrayList();
        for (c add : values) {
            c add2;
            arrayList.add(add2);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            add2 = (c) it.next();
            if (add2.sph.spJ) {
                a(add2);
            }
        }
        arrayList.clear();
        return true;
    }
}
