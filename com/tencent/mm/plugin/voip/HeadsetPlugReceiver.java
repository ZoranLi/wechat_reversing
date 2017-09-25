package com.tencent.mm.plugin.voip;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.sdk.platformtools.w;

public class HeadsetPlugReceiver extends BroadcastReceiver {
    private a rer = null;

    public interface a {
        void eY(boolean z);
    }

    public void onReceive(Context context, Intent intent) {
        w.d("MicroMsg.HeadsetPlugReceiver", "headset onReceive %s  %d", new Object[]{intent.getAction(), Integer.valueOf(intent.getIntExtra("state", 0))});
        if (intent.getAction() != null && intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
            if (intent.getIntExtra("state", 0) == 0) {
                if (this.rer != null) {
                    this.rer.eY(false);
                }
            } else if (intent.getIntExtra("state", 0) == 1 && this.rer != null) {
                this.rer.eY(true);
            }
        }
    }

    public final void a(Context context, a aVar) {
        this.rer = aVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        context.registerReceiver(this, intentFilter);
    }

    public final void cS(Context context) {
        try {
            context.unregisterReceiver(this);
        } catch (Exception e) {
            w.e("MicroMsg.HeadsetPlugReceiver", "unregisterReceiver(HeadsetPlugReceiver.this) error:%s", new Object[]{e.getMessage()});
        }
        this.rer = null;
    }
}
