package com.tencent.mm.plugin.ipcall;

import com.tencent.mm.i.g;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public final class d {
    public static boolean aDM() {
        if (!ap.zb()) {
            return false;
        }
        if (g.sV().getInt("WCOEntranceSwitch", 0) > 0) {
            ap.yY();
            c.vr().a(a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN, Boolean.valueOf(true));
            return true;
        }
        ap.yY();
        c.vr().a(a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN, Boolean.valueOf(false));
        return false;
    }
}
