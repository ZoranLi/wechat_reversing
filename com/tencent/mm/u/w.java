package com.tencent.mm.u;

import com.tencent.mm.e.b.af;
import com.tencent.mm.j.a;
import com.tencent.mm.storage.x;

public final class w {
    public static void yF() {
        for (x xVar : o.yz()) {
            if (!(xVar == null || ((int) xVar.gTQ) == 0 || xVar.field_showHead != 32)) {
                xVar.dc(xVar.sZ());
                com.tencent.mm.sdk.platformtools.w.d("MicroMsg.HardCodeUpdateTask", "contact to updatefavour " + xVar.field_username);
                ap.yY();
                c.wR().a(xVar.field_username, xVar);
            }
        }
        for (String str : o.hly) {
            af Rc = c.wR().Rc(str);
            if (Rc != null && (((int) Rc.gTQ) != 0 || a.ez(Rc.field_type))) {
                Rc.tl();
                c.wR().a(str, Rc);
            }
        }
    }
}
