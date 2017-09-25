package com.tencent.mm.ui.chatting;

import android.os.Bundle;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ah.a;

final class cb implements a {
    cb() {
    }

    public final void a(a aVar, int i, En_5b8fbb1e.a aVar2, au auVar) {
        b bVar = (b) aVar;
        bVar.suV.setText(auVar.field_content);
        Object bundle = new Bundle();
        bundle.putString("chatroom_name", aVar2.bUg());
        bundle.putLong("msg_id", auVar.field_msgId);
        if ((auVar.field_flag & 8) != 0) {
            h.a(bVar.suV, 1, false, bundle);
            bVar.suV.setClickable(true);
        } else {
            h.a(bVar.suV, bundle);
        }
        bVar.suV.invalidate();
    }
}
