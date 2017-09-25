package com.tencent.mm.plugin.offline;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public abstract class a<T> {
    protected List<WeakReference<T>> obn = new ArrayList();

    public final void bg(T t) {
        if (this.obn != null) {
            this.obn = new ArrayList();
        }
        if (t != null) {
            this.obn.add(new WeakReference(t));
        }
    }

    public final void bh(T t) {
        if (this.obn != null && t != null) {
            for (int i = 0; i < this.obn.size(); i++) {
                WeakReference weakReference = (WeakReference) this.obn.get(i);
                if (weakReference != null) {
                    Object obj = weakReference.get();
                    if (obj != null && obj.equals(t)) {
                        weakReference.clear();
                        this.obn.remove(weakReference);
                    }
                }
            }
        }
    }
}
