package com.tencent.mm.ab;

import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ab;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public final class d extends ab {
    public final void transfer(int i) {
        w.d("MicroMsg.VerifyFlagDataTransfer", "the previous version is %d", Integer.valueOf(i));
        if (eX(i)) {
            long currentTimeMillis = System.currentTimeMillis();
            ap.yY();
            if (bg.f((Integer) c.vr().get(86017, null)) == 3) {
                w.w("MicroMsg.VerifyFlagDataTransfer", "check old contact not exist");
                return;
            }
            ap.yY();
            c.wO().eE("rcontact", "update rcontact set verifyflag=0 where verifyflag is null;");
            ap.yY();
            Cursor c = c.wR().c("@all.weixin.android", "", null);
            c.moveToFirst();
            while (!c.isAfterLast()) {
                x xVar = new x();
                xVar.b(c);
                ap.yY();
                c.wR().c(xVar.field_username, xVar);
                c.moveToNext();
            }
            c.close();
            w.d("MicroMsg.VerifyFlagDataTransfer", "update verifyflag from the beginning to update finish use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            ap.yY();
            c.vr().set(86017, Integer.valueOf(3));
            w.d("MicroMsg.VerifyFlagDataTransfer", "update verifyflag use time " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            return;
        }
        w.w("MicroMsg.VerifyFlagDataTransfer", "do not need transfer");
    }

    public final boolean eX(int i) {
        return i != 0 && i < 604176383;
    }

    public final String getTag() {
        return "MicroMsg.VerifyFlagDataTransfer";
    }
}
