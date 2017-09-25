package com.tencent.mm.plugin.messenger.foundation.a.a;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.ae;

public final class a {
    public static long a(ae aeVar, int i, long j) {
        if (aeVar == null) {
            return 0;
        }
        if (j == 0) {
            j = bg.Nz();
        }
        switch (i) {
            case 2:
                return a(aeVar, j) | 4611686018427387904L;
            case 3:
                return a(aeVar, j) & -4611686018427387905L;
            case 4:
                return a(aeVar, j) & 4611686018427387904L;
            case 5:
                return a(aeVar, j) | 1152921504606846976L;
            case 6:
                return a(aeVar, j) & -1152921504606846977L;
            case 7:
                return a(aeVar, j) & 1152921504606846976L;
            default:
                return a(aeVar, j);
        }
    }

    public static long a(ae aeVar, long j) {
        return (aeVar.field_flag & -72057594037927936L) | (72057594037927935L & j);
    }
}
