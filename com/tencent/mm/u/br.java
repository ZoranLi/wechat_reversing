package com.tencent.mm.u;

import com.tencent.mm.sdk.platformtools.w;
import java.util.HashSet;
import java.util.Set;

public final class br {
    public boolean aJi = false;
    public Set<a> hop = new HashSet();

    public interface a {
        boolean Aa();
    }

    public final boolean a(a aVar) {
        if (!this.aJi) {
            return this.hop.add(aVar);
        }
        w.e("MicroMsg.UninitForUEH", "add , is running , forbid add");
        return false;
    }

    public final boolean b(a aVar) {
        if (!this.aJi) {
            return this.hop.remove(aVar);
        }
        w.e("MicroMsg.UninitForUEH", "remove , is running , forbid remove");
        return false;
    }
}
