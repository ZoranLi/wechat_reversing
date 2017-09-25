package com.tencent.d.b.f;

import com.tencent.d.b.b.a;

abstract class c extends d {
    c() {
    }

    protected static void dk(String str, int i) {
        com.tencent.d.a.c.c.d("Soter.BaseSoterPrepareKeyTask", "soter: marking preference. key: %s, status: %d", new Object[]{str, Integer.valueOf(i)});
        synchronized (a.class) {
            if (a.cfM().cfP() != null) {
                a.cfM().cfP().edit().putInt(str, i).apply();
            }
        }
    }
}
