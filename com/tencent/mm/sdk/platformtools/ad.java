package com.tencent.mm.sdk.platformtools;

import java.util.HashSet;
import java.util.Set;

public final class ad {
    private static Set<String> utb = new HashSet();

    public static boolean Pt(String str) {
        if (Pv(str)) {
            w.d("MicroMsg.MMEntryLock", "locked-" + str);
            return false;
        }
        w.d("MicroMsg.MMEntryLock", "lock-" + str);
        return utb.add(str);
    }

    public static void Pu(String str) {
        utb.remove(str);
        w.d("MicroMsg.MMEntryLock", "unlock-" + str);
    }

    public static boolean Pv(String str) {
        return utb.contains(str);
    }
}
