package com.tencent.mm.u;

import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.w;

public final class h {
    public static int xI() {
        if (com.tencent.mm.kernel.h.vG().uV()) {
            int i;
            Cursor bLM = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().bLM();
            if (bLM == null || bLM.getCount() <= 0) {
                i = 0;
            } else {
                bLM.moveToFirst();
                i = bLM.getInt(0);
            }
            if (bLM == null) {
                return i;
            }
            bLM.close();
            return i;
        }
        w.w("MicroMsg.BottleConversationLogic", "get Bottle Total Conversation Unread, but has not set uin");
        return 0;
    }
}
