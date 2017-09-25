package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class i extends e {
    private static final int CTRL_INDEX = 153;
    private static final String NAME = "onNetworkStatusChange";
    private static i iKZ;
    private static HashSet<String> iLa = new HashSet();

    public static synchronized void pe(String str) {
        synchronized (i.class) {
            iLa.add(str);
        }
    }

    public static synchronized void nm(String str) {
        synchronized (i.class) {
            iLa.remove(str);
        }
    }

    public static synchronized void onNetworkChange() {
        synchronized (i.class) {
            HashMap hashMap = new HashMap();
            Context context = ab.getContext();
            boolean isConnected = am.isConnected(context);
            hashMap.put("isConnected", Boolean.valueOf(isConnected));
            if (!isConnected) {
                hashMap.put("networkType", "none");
            } else if (am.is2G(context)) {
                hashMap.put("networkType", "2g");
            } else if (am.is3G(context)) {
                hashMap.put("networkType", "3g");
            } else if (am.is4G(context)) {
                hashMap.put("networkType", "4g");
            } else if (am.isWifi(context)) {
                hashMap.put("networkType", "wifi");
            } else {
                hashMap.put("networkType", "unknown");
            }
            Iterator it = iLa.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (iKZ == null) {
                    iKZ = new i();
                }
                iKZ.ad(str, 0).q(hashMap).SR();
            }
        }
    }
}
