package com.tencent.mm.ui.widget;

import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

public final class j {
    private static LinkedList<WeakReference<a>> wxz = new LinkedList();

    public interface a {
        void O(float f);

        boolean VJ();

        void d(boolean z, int i);
    }

    public static void a(a aVar) {
        w.d("MicroMsg.SwipeBackHelper", "pushCallback size %d, %s", Integer.valueOf(wxz.size()), aVar);
        wxz.add(0, new WeakReference(aVar));
    }

    public static boolean b(a aVar) {
        w.d("MicroMsg.SwipeBackHelper", "popCallback size %d, %s", Integer.valueOf(wxz.size()), aVar);
        if (aVar == null) {
            return true;
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < wxz.size(); i++) {
            if (aVar == ((WeakReference) wxz.get(i)).get()) {
                wxz.remove(i);
                w.d("MicroMsg.SwipeBackHelper", "popCallback directly, index %d", Integer.valueOf(i));
                break;
            }
            linkedList.add(0, Integer.valueOf(i));
        }
        if (aVar.VJ() || linkedList.size() != r4) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) wxz.remove(((Integer) it.next()).intValue());
                String str = "MicroMsg.SwipeBackHelper";
                String str2 = "popCallback, popup %s";
                Object[] objArr = new Object[1];
                objArr[0] = weakReference != null ? weakReference.get() : "NULL-CALLBACK";
                w.d(str, str2, objArr);
            }
            return linkedList.isEmpty();
        }
        w.d("MicroMsg.SwipeBackHelper", "popCallback Fail! Maybe Top Activity");
        return false;
    }

    public static void ax(float f) {
        if (wxz.size() <= 0) {
            w.w("MicroMsg.SwipeBackHelper", "notifySwipe callback stack empty!, scrollParent:%f", Float.valueOf(f));
            return;
        }
        a aVar = (a) ((WeakReference) wxz.get(0)).get();
        if (aVar == null) {
            w.w("MicroMsg.SwipeBackHelper", "notifySwipe null, scrollParent:%f", Float.valueOf(f));
            return;
        }
        aVar.O(f);
        w.v("MicroMsg.SwipeBackHelper", "notifySwipe scrollParent:%f, callback:%s ", Float.valueOf(f), aVar);
    }

    public static void u(boolean z, int i) {
        if (wxz.size() <= 0) {
            w.w("MicroMsg.SwipeBackHelper", "notifySettle callback stack empty!, open:%B, speed:%d", Boolean.valueOf(z), Integer.valueOf(i));
            return;
        }
        a aVar = (a) ((WeakReference) wxz.get(0)).get();
        if (aVar == null) {
            w.w("MicroMsg.SwipeBackHelper", "notifySettle null, open:%B, speed:%d", Boolean.valueOf(z), Integer.valueOf(i));
            return;
        }
        aVar.d(z, i);
        w.v("MicroMsg.SwipeBackHelper", "notifySettle, open:%B speed:%d callback:%s", Boolean.valueOf(z), Integer.valueOf(i), aVar);
    }
}
