package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.plugin.scanner.a.a.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class k {
    public static LinkedList<String> bj(List<a> list) {
        LinkedList<String> linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            List list2 = ((a) list.get(i)).hSY;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                a aVar = (a) list2.get(i2);
                if (a(aVar)) {
                    linkedList.add(aVar.arH);
                }
            }
        }
        return linkedList;
    }

    public static Map<String, a> bk(List<String> list) {
        Map<String, a> hashMap = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            String str = (String) list.get(i);
            w.d("MicroMsg.ProductUpdateLogic", "toUpdateXmlList info: i=" + i + ";" + bg.mz(str));
            a k = a.k(bh.q(str, "action"), ".action");
            if (!(k == null || k.showType == 2)) {
                hashMap.put(k.arH, k);
            }
        }
        return hashMap;
    }

    public static boolean b(List<a> list, Map<String, a> map) {
        if (map == null || map.size() <= 0 || list == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                List list2 = ((a) list.get(i)).hSY;
                int i2 = 0;
                boolean z2 = false;
                boolean z3 = z;
                while (i2 < list2.size()) {
                    a aVar = (a) list2.get(i2);
                    if (a(aVar)) {
                        a aVar2 = (a) map.get(aVar.arH);
                        if (aVar2 != null) {
                            w.i("MicroMsg.ProductUpdateLogic", "Updating action , info: key=" + aVar.arH);
                            list2.remove(i2);
                            list2.add(i2, aVar2);
                            z2 = true;
                            z3 = true;
                        }
                        z = z2;
                        z2 = z3;
                    } else {
                        z = true;
                        z2 = z3;
                    }
                    i2++;
                    z3 = z2;
                    z2 = z;
                }
                ((a) list.get(i)).oVL = z2;
                z = z3;
            }
        }
        return z;
    }

    public static boolean a(a aVar) {
        return !bg.mA(aVar.arH);
    }
}
