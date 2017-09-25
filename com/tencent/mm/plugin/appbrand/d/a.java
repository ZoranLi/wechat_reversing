package com.tencent.mm.plugin.appbrand.d;

import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;
import java.util.List;

final class a implements com.tencent.mm.sdk.e.j.a {
    a() {
    }

    public final void a(String str, l lVar) {
        if (c.PW() == null) {
            w.w("MicroMsg.AppBrandSearchStorageChangeListener", "onNotifyChange by SysConfigStorage, but sLayoutStorage is null.");
            return;
        }
        List linkedList;
        switch (lVar.uxq) {
            case 2:
            case 3:
                linkedList = new LinkedList();
                if (!"batch".equals(str)) {
                    linkedList.addAll(c.PW().nT(lVar.obj.toString()));
                } else if (lVar.obj != null && (lVar.obj instanceof List)) {
                    for (String nT : (List) lVar.obj) {
                        linkedList.addAll(c.PW().nT(nT));
                    }
                } else {
                    return;
                }
                if (!linkedList.isEmpty()) {
                    c.PW().a("batch", 3, linkedList);
                    return;
                }
                return;
            case 5:
                linkedList = new LinkedList();
                if (!"batch".equals(str)) {
                    linkedList.addAll(c.PW().nT(lVar.obj.toString()));
                } else if (lVar.obj != null && (lVar.obj instanceof List)) {
                    for (String nT2 : (List) lVar.obj) {
                        linkedList.addAll(c.PW().nT(nT2));
                    }
                } else {
                    return;
                }
                if (!linkedList.isEmpty()) {
                    c.PW().a("batch", 5, linkedList);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
