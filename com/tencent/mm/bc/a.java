package com.tencent.mm.bc;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bm;
import com.tencent.mm.u.c;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class a {
    private static final Map<Integer, Integer> sYz = new HashMap();

    public static void run() {
        ap.yY();
        if ((bg.az(bg.a((Long) c.vr().get(66819, null), 0)) * 1000 > 1800000 ? 1 : null) != null) {
            ND("");
        }
    }

    public static void xU(int i) {
        sYz.put(Integer.valueOf(i), Integer.valueOf(bg.f((Integer) sYz.get(Integer.valueOf(i))) + 1));
    }

    public static String bGQ() {
        String str = "[a=" + (ap.yY() == null ? "0" : "1") + " ";
        if (ap.yY() == null) {
            return str;
        }
        StringBuilder append = new StringBuilder().append(str).append("c=");
        ap.yY();
        return append.append(c.vr() == null ? "0" : "1").append(" ").toString() + "u=" + (ap.zb() ? "1" : "0") + "]";
    }

    public static void ND(String str) {
        String str2 = str + bGQ();
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : sYz.entrySet()) {
            if (!(entry == null || entry.getKey() == null || entry.getValue() == null || ((Integer) entry.getValue()).intValue() == 0)) {
                stringBuilder.append(entry.getKey());
                stringBuilder.append('=');
                stringBuilder.append(entry.getValue());
                stringBuilder.append(',');
            }
        }
        sYz.clear();
        if (stringBuilder.length() > 0) {
            w.d("MicroMsg.PostTaskFMessageCardStat", "append fmesage card click");
            bm.n(10, stringBuilder.toString());
        }
        w.d("MicroMsg.PostTaskFMessageCardStat", "dkfm :" + (str2 + bGQ()));
        try {
            ap.yY();
            c.vr().set(66819, Long.valueOf(bg.Ny()));
        } catch (Exception e) {
            w.e("MicroMsg.PostTaskFMessageCardStat", "e:" + e.getMessage());
        }
    }
}
