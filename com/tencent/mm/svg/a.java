package com.tencent.mm.svg;

import android.os.Looper;
import java.util.HashMap;
import java.util.LinkedList;

final class a<T> {
    private HashMap<Looper, LinkedList<T>> uMK = new HashMap();
    private LinkedList<T> uML = new LinkedList();

    a() {
    }

    protected final synchronized T bNS() {
        T t;
        t = null;
        if (this.uML.size() != 0) {
            t = this.uML.poll();
        }
        return t;
    }

    protected final synchronized void a(Looper looper, T t) {
        LinkedList linkedList;
        if (this.uMK.containsKey(looper)) {
            linkedList = (LinkedList) this.uMK.get(looper);
        } else {
            linkedList = new LinkedList();
            this.uMK.put(looper, linkedList);
        }
        linkedList.add(t);
    }

    protected final synchronized void a(Looper looper) {
        if (this.uMK.containsKey(looper)) {
            this.uML.addAll((LinkedList) this.uMK.remove(looper));
        }
    }
}
