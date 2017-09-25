package com.tencent.mm.memory;

import com.tencent.mm.sdk.platformtools.w;
import java.util.NavigableMap;

public abstract class a<T> extends e<T, Integer> {
    public /* synthetic */ Object a(Comparable comparable) {
        return b((Integer) comparable);
    }

    public synchronized T b(Integer num) {
        T t;
        NavigableMap subMap = this.hgC.subMap(num, true, Integer.valueOf(Integer.MAX_VALUE), true);
        if (!(subMap == null || subMap.isEmpty())) {
            for (Integer intValue : subMap.keySet()) {
                d dVar = (d) subMap.get(Integer.valueOf(intValue.intValue()));
                if (dVar.size() > 0) {
                    T pop = dVar.pop();
                    this.hgC.put(dVar.wm(), dVar);
                    t = pop;
                    break;
                }
            }
            t = null;
            if (t != null) {
                J(at(t));
            }
        }
        t = null;
        return t;
    }

    public synchronized T c(Integer num) {
        T t;
        d dVar = (d) this.hgC.get(num);
        if (dVar == null || dVar.size() <= 0) {
            String str = "MicroMsg.BiggerThanPool";
            String str2 = "BiggerThanPool getExactSize cannot get %s size count %d";
            Object[] objArr = new Object[2];
            objArr[0] = num;
            int size = dVar == null ? -1 : dVar.hgA == null ? -1 : dVar.hgA.size();
            objArr[1] = Integer.valueOf(size);
            w.d(str, str2, objArr);
            t = null;
        } else {
            T pop = dVar.pop();
            this.hgC.put(dVar.wm(), dVar);
            J(at(pop));
            t = pop;
        }
        return t;
    }
}
