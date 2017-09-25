package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;

final class b {
    static void a(Intent intent, a aVar, au auVar, ah ahVar) {
        String str;
        int i;
        Bundle bundle;
        String bUg = aVar.bUg();
        String a = ahVar.a(aVar, auVar);
        Bundle bundle2 = new Bundle();
        if (aVar.vBH) {
            str = "stat_scene";
            i = 2;
            bundle = bundle2;
        } else {
            str = "stat_scene";
            if (o.eV(bUg)) {
                i = 7;
                bundle = bundle2;
            } else {
                i = 1;
                bundle = bundle2;
            }
        }
        bundle.putInt(str, i);
        bundle2.putString("stat_msg_id", "msg_" + Long.toString(auVar.field_msgSvrId));
        bundle2.putString("stat_chat_talker_username", bUg);
        bundle2.putString("stat_send_msg_user", a);
        intent.putExtra("_stat_obj", bundle2);
    }
}
