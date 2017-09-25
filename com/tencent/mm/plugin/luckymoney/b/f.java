package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.sdk.platformtools.w;
import java.util.HashSet;
import java.util.Set;

public final class f {
    private Object lock = new Object();
    private Set<String> nmE = new HashSet();

    public final boolean zJ(String str) {
        boolean z = false;
        synchronized (this.lock) {
            if (this.nmE.contains(str)) {
                w.i("MicroMsg.LuckyMoneyMsg", "has contains msg, %s", new Object[]{str});
            } else {
                z = this.nmE.add(str);
            }
        }
        return z;
    }

    public final void zK(String str) {
        synchronized (this.lock) {
            this.nmE.remove(str);
        }
    }
}
