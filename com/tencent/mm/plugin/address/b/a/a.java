package com.tencent.mm.plugin.address.b.a;

import com.tencent.mm.plugin.o.a.b;
import java.util.Iterator;

public final class a {
    public com.tencent.mm.plugin.o.a.a isX = new com.tencent.mm.plugin.o.a.a();

    public final b hl(int i) {
        Iterator it = this.isX.mLV.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.mLW == i) {
                return bVar;
            }
        }
        return null;
    }
}
