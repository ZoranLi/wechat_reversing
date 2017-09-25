package com.tencent.mm.ipcinvoker.extension;

import com.tencent.mm.ipcinvoker.e.b;
import junit.framework.Assert;

public final class e<T> {
    private T gWm;
    private Class<T> gWn;

    public e(Class<T> cls) {
        Assert.assertNotNull(cls);
        this.gWn = cls;
    }

    public final T get() {
        if (this.gWm == null) {
            synchronized (this) {
                if (this.gWm == null) {
                    this.gWm = b.e(this.gWn);
                }
            }
        }
        return this.gWm;
    }
}
