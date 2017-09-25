package com.tencent.mm.plugin.base.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.comm.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.g;

public class ShortcutBroadCastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            w.e("MicroMsg.ShortcutBroadCastReceiver", "alvinluo shortcut receiver intent is null");
        } else {
            g.bl(context, context.getString(a.g.dDk));
        }
    }
}
