package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.permission.c;
import java.util.HashMap;

final class g {
    final HashMap<Integer, a> iKV = new HashMap();

    private static class a {
        String data;
        c iKW;
        b iKX;
        String path;
        long startTime;

        a(c cVar, b bVar, String str, long j, String str2) {
            this.iKW = cVar;
            this.iKX = bVar;
            this.data = str;
            this.startTime = j;
            this.path = str2;
        }
    }

    g() {
    }

    public final void y(int i, String str) {
        a aVar = (a) this.iKV.remove(Integer.valueOf(i));
        if (aVar != null) {
            com.tencent.mm.plugin.appbrand.report.a.a(aVar.iKW.getAppId(), aVar.path, aVar.iKX.getName(), aVar.data, c.a(aVar.iKW, aVar.iKX), System.currentTimeMillis() - aVar.startTime, str);
            this.iKV.remove(Integer.valueOf(i));
        }
    }
}
