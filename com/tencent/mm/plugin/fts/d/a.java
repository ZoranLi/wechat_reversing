package com.tencent.mm.plugin.fts.d;

import com.tencent.mm.plugin.fts.d.h.b;

public abstract class a implements b {
    public /* synthetic */ int compareTo(Object obj) {
        b bVar = (b) obj;
        if (getPriority() < bVar.getPriority()) {
            return -1;
        }
        return getPriority() > bVar.getPriority() ? 1 : 0;
    }
}
