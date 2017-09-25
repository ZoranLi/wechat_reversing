package com.tencent.mm.plugin.freewifi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiManager;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class c {
    public WifiManager aPM;
    public Activity activity;
    public boolean connected = false;
    public Condition fuI;
    public long hto;
    public Lock lQU;
    public BroadcastReceiver lQX;
    public boolean lRb = false;
    public String lRc;
    public String ssid;

    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] lRf = new int[SupplicantState.values().length];

        static {
            try {
                lRf[SupplicantState.ASSOCIATED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                lRf[SupplicantState.ASSOCIATING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                lRf[SupplicantState.AUTHENTICATING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                lRf[SupplicantState.COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                lRf[SupplicantState.DISCONNECTED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                lRf[SupplicantState.DORMANT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                lRf[SupplicantState.FOUR_WAY_HANDSHAKE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                lRf[SupplicantState.GROUP_HANDSHAKE.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                lRf[SupplicantState.INACTIVE.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                lRf[SupplicantState.INTERFACE_DISABLED.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                lRf[SupplicantState.INVALID.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                lRf[SupplicantState.SCANNING.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                lRf[SupplicantState.UNINITIALIZED.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
        }
    }

    public interface a {
        void mF(int i);

        void onSuccess();
    }

    class AnonymousClass1 implements a {
        final /* synthetic */ a lRd;
        final /* synthetic */ c lRe;

        public AnonymousClass1(c cVar, a aVar) {
            this.lRe = cVar;
            this.lRd = aVar;
        }

        public final void onSuccess() {
            w.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "sessionKey=%s, step=%d, desc=Connect ssid succeeded. ", new Object[]{m.y(this.lRe.activity.getIntent()), Integer.valueOf(m.z(this.lRe.activity.getIntent()))});
            this.lRd.onSuccess();
        }

        public final void mF(int i) {
            w.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "sessionKey=%s, step=%d, desc=Connect ssid failed. errorcode=%d", new Object[]{m.y(this.lRe.activity.getIntent()), Integer.valueOf(m.z(this.lRe.activity.getIntent())), Integer.valueOf(i)});
            this.lRd.mF(i);
        }
    }

    public c(String str, Activity activity, String str2) {
        this.activity = activity;
        this.hto = 30000;
        this.ssid = str;
        this.lRc = str2;
        this.lQU = new ReentrantLock();
        this.fuI = this.lQU.newCondition();
        this.aPM = (WifiManager) ab.getContext().getSystemService("wifi");
    }

    public final void avP() {
        try {
            this.activity.unregisterReceiver(this.lQX);
        } catch (IllegalArgumentException e) {
        }
    }
}
