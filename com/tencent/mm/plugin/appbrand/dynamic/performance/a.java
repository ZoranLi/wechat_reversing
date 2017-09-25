package com.tencent.mm.plugin.appbrand.dynamic.performance;

import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a {
    private static a iIj;
    public Map<String, List<IPCDynamicPageView>> iIk = new ConcurrentHashMap();
    public Map<String, a> iIl = new ConcurrentHashMap();

    public interface a {
        void a(String str, IPCDynamicPageView iPCDynamicPageView);
    }

    private a() {
    }

    public static a Si() {
        if (iIj == null) {
            synchronized (a.class) {
                if (iIj == null) {
                    iIj = new a();
                }
            }
        }
        return iIj;
    }

    public final boolean b(String str, IPCDynamicPageView iPCDynamicPageView) {
        if (str == null || str.length() == 0 || iPCDynamicPageView == null) {
            return false;
        }
        List list = (List) this.iIk.get(str);
        if (list == null) {
            return false;
        }
        boolean remove;
        synchronized (list) {
            remove = list.remove(iPCDynamicPageView);
        }
        if (list.isEmpty()) {
            this.iIk.remove(str);
        }
        return remove;
    }

    public final boolean c(String str, IPCDynamicPageView iPCDynamicPageView) {
        if (str == null || str.length() == 0 || iPCDynamicPageView == null) {
            return false;
        }
        List list;
        List list2 = (List) this.iIk.get(str);
        if (list2 == null) {
            LinkedList linkedList = new LinkedList();
            this.iIk.put(str, linkedList);
            list = linkedList;
        } else {
            list = list2;
        }
        if (list.contains(iPCDynamicPageView)) {
            synchronized (list) {
                list.remove(iPCDynamicPageView);
                list.add(iPCDynamicPageView);
            }
            return true;
        }
        boolean add = list.add(iPCDynamicPageView);
        if (list.size() > 4) {
            synchronized (list) {
                if (list.size() > 4) {
                    IPCDynamicPageView T = T(list);
                    if (T != null) {
                        a aVar = (a) this.iIl.get(str);
                        if (aVar != null) {
                            aVar.a(str, T);
                        }
                    }
                }
            }
        }
        return add;
    }

    private static IPCDynamicPageView T(List<IPCDynamicPageView> list) {
        for (int i = 0; i < list.size(); i++) {
            if (((IPCDynamicPageView) list.get(i)).isPaused()) {
                return (IPCDynamicPageView) list.remove(i);
            }
        }
        return null;
    }
}
