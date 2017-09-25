package com.tencent.mm.protocal;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;
import java.util.List;

public final class n {
    public String host = "";
    public String naK = "";
    private int port = 80;
    private int type = 0;

    public static class a {
        public final int[] sZI = null;
        public final int[] sZJ;
        public final int sZK;
        public final int sZL;

        public a(int[] iArr, int i, int i2) {
            this.sZJ = iArr;
            this.sZK = i;
            this.sZL = i2;
        }
    }

    public n(int i, String str, int i2, String str2) {
        this.type = i;
        this.naK = str;
        this.port = i2;
        this.host = str2;
    }

    public final String toString() {
        return this.type + "," + this.naK + "," + this.port + "," + this.host;
    }

    private static n NI(String str) {
        String[] split = str.split(",");
        if (split.length < 4) {
            return null;
        }
        n nVar = new n();
        try {
            nVar.type = bg.getInt(split[0], 0);
            nVar.naK = bg.mz(split[1]);
            nVar.port = bg.getInt(split[2], 0);
            nVar.host = bg.mz(split[3]);
            return nVar;
        } catch (Throwable e) {
            w.e("MicroMsg.MMBuiltInIP", "exception:%s", bg.g(e));
            return null;
        }
    }

    public static String bT(List<n> list) {
        String str = "";
        for (n nVar : list) {
            str = str + nVar.toString() + "|";
        }
        return str;
    }

    public static List<n> NJ(String str) {
        List linkedList = new LinkedList();
        if (!bg.mA(str)) {
            try {
                for (String NI : str.split("\\|")) {
                    n NI2 = NI(NI);
                    if (NI2 != null) {
                        linkedList.add(NI2);
                    }
                }
            } catch (Throwable e) {
                w.d("MicroMsg.MMBuiltInIP", "unserialize split failed str[%s]", str);
                w.e("MicroMsg.MMBuiltInIP", "exception:%s", bg.g(e));
            }
        }
        return linkedList;
    }

    public static a et(String str, String str2) {
        w.d("MicroMsg.MMBuiltInIP", "parsing network control params:");
        w.d("MicroMsg.MMBuiltInIP", "ports = " + str);
        w.d("MicroMsg.MMBuiltInIP", "timeouts = " + str2);
        int[] PU = bg.PU(str);
        int[] PU2 = bg.PU(str2);
        if (PU2 == null || PU2.length < 2) {
            PU2 = new int[]{0, 0};
            w.e("MicroMsg.MMBuiltInIP", "invalid timeouts");
        }
        return new a(PU, (int) (((long) PU2[0]) * 1000), (int) (((long) PU2[1]) * 1000));
    }
}
