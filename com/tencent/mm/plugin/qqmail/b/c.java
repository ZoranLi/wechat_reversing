package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;

public final class c {
    public e ozj;

    public c(String str) {
        this.ozj = new e(str, 10);
    }

    public final d bw(String str, int i) {
        byte[] readFromFile = e.readFromFile(this.ozj.ozt + bx(str, i));
        if (readFromFile == null || readFromFile.length == 0) {
            return null;
        }
        try {
            return (d) new d().aD(readFromFile);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.DraftBoxMgr", e, "", new Object[0]);
            return null;
        }
    }

    public static String bx(String str, int i) {
        if (str != null && str.length() != 0) {
            return str + "_" + i;
        }
        StringBuilder stringBuilder = new StringBuilder();
        ap.yY();
        return stringBuilder.append(com.tencent.mm.u.c.vr().get(9, null)).toString();
    }
}
