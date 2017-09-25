package com.tencent.mm.plugin.auto.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public class MMAutoMessageHeardReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String i = s.i(intent, "key_username");
        if (i != null) {
            w.i("MicroMsg.auto.MMAutoMessageHeardReceiver", "username %s heard", i);
            ap.getNotification().cancelNotification(i);
            ap.yY();
            c.wW().Ro(i);
        }
    }
}
