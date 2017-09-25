package com.google.android.gms.analytics.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.analytics.internal.m.AnonymousClass1;
import com.google.android.gms.common.internal.w;

class g extends BroadcastReceiver {
    static final String ahJ = g.class.getName();
    final q ahK;
    boolean ahL;
    boolean ahM;

    g(q qVar) {
        w.Z(qVar);
        this.ahK = qVar;
    }

    void hD() {
        this.ahK.ig();
        this.ahK.ii();
    }

    boolean hE() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.ahK.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (SecurityException e) {
            return false;
        }
    }

    public void onReceive(Context context, Intent intent) {
        hD();
        String action = intent.getAction();
        this.ahK.ig().d("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean hE = hE();
            if (this.ahM != hE) {
                this.ahM = hE;
                n ii = this.ahK.ii();
                ii.d("Network connectivity status changed", Boolean.valueOf(hE));
                ii.ahK.ih().c(new AnonymousClass1(ii, hE));
            }
        } else if (!"com.google.analytics.RADIO_POWERED".equals(action)) {
            this.ahK.ig().f("NetworkBroadcastReceiver received unknown action", action);
        } else if (!intent.hasExtra(ahJ)) {
            m ii2 = this.ahK.ii();
            ii2.C("Radio powered up");
            ii2.hX();
        }
    }

    public final void unregister() {
        if (this.ahL) {
            this.ahK.ig().C("Unregistering connectivity change receiver");
            this.ahL = false;
            this.ahM = false;
            try {
                this.ahK.mContext.unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.ahK.ig().g("Failed to unregister the network broadcast receiver", e);
            }
        }
    }
}
