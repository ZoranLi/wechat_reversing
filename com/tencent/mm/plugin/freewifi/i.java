package com.tencent.mm.plugin.freewifi;

import com.tencent.mm.plugin.freewifi.g.b;
import com.tencent.mm.plugin.freewifi.model.j;

public final class i {
    private b lRk = j.awD();

    private static class a {
        public static i lRv = new i();
    }

    public final synchronized long mB(String str) {
        long j = 0;
        synchronized (this) {
            if (!m.wx(str)) {
                try {
                    String wN = this.lRk.wN(str);
                    if (!m.wx(wN)) {
                        j = Long.valueOf(wN).longValue();
                    }
                } catch (Exception e) {
                }
            }
        }
        return j;
    }

    public final synchronized int getInt(String str, int i) {
        if (!m.wx(str)) {
            try {
                String wN = this.lRk.wN(str);
                if (!m.wx(wN)) {
                    i = Integer.valueOf(wN).intValue();
                }
            } catch (Exception e) {
            }
        }
        return i;
    }

    public final synchronized void t(String str, long j) {
        this.lRk.cg(str, String.valueOf(j));
    }

    public final synchronized void aU(String str, int i) {
        this.lRk.cg(str, String.valueOf(i));
    }
}
