package com.tencent.mm.u;

import com.tencent.mm.network.j;

public final class bc {
    public static a hnv = null;

    public interface a {
        j zB();
    }

    public static j a(j jVar) {
        return hnv == null ? jVar : hnv.zB();
    }
}
