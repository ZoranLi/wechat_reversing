package com.tencent.mm.pluginsdk.j;

import com.tencent.mm.sdk.a.b;
import java.util.concurrent.ConcurrentHashMap;

public final class m {
    public static m sET = new m("default");
    private boolean lPM = false;
    private ConcurrentHashMap<String, Integer> sEQ = new ConcurrentHashMap();
    private ConcurrentHashMap<String, Long> sER = new ConcurrentHashMap();
    private String sES = "";

    public m(String str) {
        if (b.bIu()) {
            this.lPM = true;
        }
        this.sES = str;
    }

    public final void Mn(String str) {
        if (this.lPM) {
            int intValue;
            long longValue;
            if (this.sEQ.containsKey(str)) {
                intValue = ((Integer) this.sEQ.get(str)).intValue();
            } else {
                intValue = 0;
            }
            int i = intValue + 1;
            this.sEQ.put(str, Integer.valueOf(i));
            if (this.sER.containsKey(str)) {
                longValue = ((Long) this.sER.get(str)).longValue();
            } else {
                longValue = 0;
            }
            if (System.currentTimeMillis() - longValue > 1000) {
                new StringBuilder().append(this.sES).append("user get fps ").append(i).append(" fpswraper: ").append(str);
                this.sEQ.put(str, Integer.valueOf(0));
                this.sER.put(str, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }
}
