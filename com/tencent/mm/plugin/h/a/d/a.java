package com.tencent.mm.plugin.h.a.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;

public final class a {
    public final a jUD;
    public final BroadcastReceiver jUE = new BroadcastReceiver(this) {
        final /* synthetic */ a jUF;

        {
            this.jUF = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent == null) {
                w.e("McroMsg.exdevice.BluetoohtStateMonitor", "null == intent");
            } else if (intent.getAction().equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                w.i("McroMsg.exdevice.BluetoohtStateMonitor", "onReceive, action = " + intent.getAction());
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                if (10 == intExtra || 12 == intExtra) {
                    this.jUF.jUD.jN(intExtra);
                }
            }
        }
    };

    public interface a {
        void jN(int i);
    }

    public a(a aVar) {
        w.i("McroMsg.exdevice.BluetoohtStateMonitor", "register BluetoothState receiver");
        this.jUD = aVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        ab.getContext().registerReceiver(this.jUE, intentFilter);
    }
}
