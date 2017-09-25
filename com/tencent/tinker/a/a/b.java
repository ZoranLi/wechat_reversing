package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class b extends a<b> {
    public int[] xbt;

    public final /* synthetic */ int compareTo(Object obj) {
        b bVar = (b) obj;
        int length = this.xbt.length;
        int length2 = bVar.xbt.length;
        if (length != length2) {
            return c.eD(length, length2);
        }
        for (length2 = 0; length2 < length; length2++) {
            if (this.xbt[length2] != bVar.xbt[length2]) {
                return c.eD(this.xbt[length2], bVar.xbt[length2]);
            }
        }
        return 0;
    }

    public b(int i, int[] iArr) {
        super(i);
        this.xbt = iArr;
    }
}
