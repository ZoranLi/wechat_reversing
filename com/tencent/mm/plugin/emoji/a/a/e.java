package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.mm.protocal.c.pn;

public final class e {
    public static boolean a(pn pnVar) {
        if (pnVar == null) {
            return false;
        }
        return bO(pnVar.tva, 1);
    }

    public static boolean b(pn pnVar) {
        if (!(pnVar == null ? false : bO(pnVar.tuZ, 4))) {
            if (!(pnVar == null ? false : bO(pnVar.tuZ, 8))) {
                return false;
            }
        }
        return true;
    }

    public static boolean lo(int i) {
        return bO(i, 4) || bO(i, 8);
    }

    public static boolean bO(int i, int i2) {
        return (i & i2) == i2;
    }
}
