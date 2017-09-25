package com.tencent.mm.ah;

import android.graphics.Bitmap;
import com.tencent.mm.a.f;
import com.tencent.mm.cache.a;

final class i implements a {
    private f<String, Bitmap> hGs = new f(5);

    i() {
    }

    public final void m(Object obj, Object obj2) {
        this.hGs.k((String) obj, (Bitmap) obj2);
    }

    public final Object get(Object obj) {
        return this.hGs.get((String) obj);
    }

    public final Object remove(Object obj) {
        this.hGs.remove((String) obj);
        return null;
    }
}
