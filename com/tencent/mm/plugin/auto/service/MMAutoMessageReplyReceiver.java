package com.tencent.mm.plugin.auto.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ag;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.o;

public class MMAutoMessageReplyReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String i = s.i(intent, "key_username");
        if (i != null) {
            Bundle resultsFromIntent = ag.getResultsFromIntent(intent);
            CharSequence charSequence = resultsFromIntent != null ? resultsFromIntent.getCharSequence("key_voice_reply_text") : null;
            if (charSequence == null) {
                w.i("MicroMsg.auto.MMAutoMessageReplyReceiver", "username %s reply null", i);
                return;
            }
            w.i("MicroMsg.auto.MMAutoMessageReplyReceiver", "username %s reply %s", i, charSequence.toString());
            d.aJW().A(i, charSequence.toString(), o.fG(i));
        }
    }
}
