package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
public class InstallReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null) {
            String action = intent.getAction();
            w.i("MicroMsg.InstallReceiver", "action:[%s]", action);
            if (bg.mA(action) || !action.equals("com.android.vending.INSTALL_REFERRER")) {
                w.e("MicroMsg.InstallReceiver", "action is null or nil, or not the installed action");
                return;
            }
            action = "";
            try {
                action = intent.getStringExtra("referrer");
            } catch (Throwable e) {
                w.e("MicroMsg.InstallReceiver", "%s", bg.g(e));
            }
            w.i("MicroMsg.InstallReceiver", "get referer:[%s]", action);
            if (bg.mA(action)) {
                w.e("MicroMsg.InstallReceiver", "get referer is null or nil");
                return;
            }
            w.d("MicroMsg.InstallReceiver", "[PREF] write installreferer = " + action);
            context.getSharedPreferences(ab.bIX(), 0).edit().putString("installreferer", action).commit();
        }
    }
}
