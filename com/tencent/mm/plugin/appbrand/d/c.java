package com.tencent.mm.plugin.appbrand.d;

import com.tencent.mm.plugin.fts.a.a;

public final class c extends a {
    protected final void tR() {
        if (tS()) {
            i(-104, 1);
        }
    }

    protected final String getTableName() {
        return "WeApp";
    }

    public final String getName() {
        return "FTS5WeAppStorage";
    }

    public final int getType() {
        return 512;
    }

    public final int getPriority() {
        return 512;
    }

    protected final boolean tS() {
        return !cb(-104, 1);
    }
}
