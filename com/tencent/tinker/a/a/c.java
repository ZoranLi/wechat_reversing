package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.t.a.a;

public final class c extends a<c> {
    public int[] xbu;

    public final /* synthetic */ int compareTo(Object obj) {
        c cVar = (c) obj;
        int length = this.xbu.length;
        int length2 = cVar.xbu.length;
        if (length != length2) {
            return com.tencent.tinker.a.a.b.c.eD(length, length2);
        }
        for (length2 = 0; length2 < length; length2++) {
            if (this.xbu[length2] != cVar.xbu[length2]) {
                return com.tencent.tinker.a.a.b.c.eD(this.xbu[length2], cVar.xbu[length2]);
            }
        }
        return 0;
    }

    public c(int i, int[] iArr) {
        super(i);
        this.xbu = iArr;
    }
}
