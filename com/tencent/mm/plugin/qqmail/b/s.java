package com.tencent.mm.plugin.qqmail.b;

import android.util.Base64;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;

public final class s {
    r oAy;

    public s() {
        ap.yY();
        String str = (String) c.vr().get(282625, "");
        try {
            this.oAy = new r();
            this.oAy.aD(Base64.decode(str, 0));
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.ShareMailInfoMgr", e, "", new Object[0]);
            w.w("MicroMsg.ShareMailInfoMgr", "parse from config fail");
            this.oAy = new r();
        }
    }

    public final void CS(String str) {
        if (bg.mA(str)) {
            w.w("MicroMsg.ShareMailInfoMgr", "remove info fail, info is null");
            return;
        }
        for (int i = 0; i < this.oAy.nwX.size(); i++) {
            if (((q) this.oAy.nwX.get(i)).ozq.equals(str)) {
                this.oAy.nwX.remove(i);
                break;
            }
        }
        save();
    }

    static void CT(String str) {
        au auVar = new au();
        auVar.cH("qqmail");
        auVar.z(ay.gk("qqmail"));
        auVar.dw(0);
        auVar.setContent(String.format(ab.getContext().getString(R.l.eRa), new Object[]{str}));
        auVar.setType(1);
        auVar.dv(3);
        ap.yY();
        w.d("MicroMsg.ShareMailInfoMgr", "send mail fail, publish fail message, id: %d", new Object[]{Long.valueOf(c.wT().L(auVar))});
    }

    final void save() {
        try {
            w.d("MicroMsg.ShareMailInfoMgr", "save %s", new Object[]{Base64.encodeToString(this.oAy.toByteArray(), 0)});
            ap.yY();
            c.vr().set(282625, r0);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.ShareMailInfoMgr", e, "", new Object[0]);
            w.w("MicroMsg.ShareMailInfoMgr", "save to config fail");
        }
    }
}
