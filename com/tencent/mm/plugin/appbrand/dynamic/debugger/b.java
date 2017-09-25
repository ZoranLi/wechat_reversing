package com.tencent.mm.plugin.appbrand.dynamic.debugger;

import com.tencent.mm.modelappbrand.LogInfo;
import com.tencent.mm.modelappbrand.i.a;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    private static final Map<String, List<a>> gWj = new ConcurrentHashMap();
    private static final Map<String, DebuggerInfo> iHM = new ConcurrentHashMap();

    public static DebuggerInfo oE(String str) {
        return (DebuggerInfo) iHM.get(str);
    }

    public static void a(String str, DebuggerInfo debuggerInfo) {
        iHM.put(str, debuggerInfo);
    }

    public static boolean c(String str, a aVar) {
        if (bg.mA(str) || aVar == null) {
            return false;
        }
        List list = (List) gWj.get(str);
        if (list == null) {
            list = new LinkedList();
            gWj.put(str, list);
        } else if (list.contains(aVar)) {
            return true;
        }
        return list.add(aVar);
    }

    public static boolean d(String str, a aVar) {
        if (bg.mA(str) || aVar == null) {
            return false;
        }
        List list = (List) gWj.get(str);
        if (list == null) {
            return false;
        }
        boolean remove = list.remove(aVar);
        if (list.isEmpty()) {
            gWj.remove(str);
        }
        return remove;
    }

    public static void a(String str, ArrayList<LogInfo> arrayList) {
        if (!bg.mA(str) && arrayList != null && !arrayList.isEmpty()) {
            List list = (List) gWj.get(str);
            if (list != null) {
                for (a y : new LinkedList(list)) {
                    y.y(arrayList);
                }
            }
        }
    }

    public static void ab(String str, int i) {
        if (!bg.mA(str)) {
            List list = (List) gWj.get(str);
            if (list != null) {
                for (a fq : new LinkedList(list)) {
                    fq.fq(i);
                }
            }
        }
    }
}
