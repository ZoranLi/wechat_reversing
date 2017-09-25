package com.google.android.gms.iid;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import com.google.android.gms.gcm.a;
import java.io.IOException;

public class InstanceIDListenerService extends Service {
    static String ACTION = "action";
    private static String asV = "gcm.googleapis.com/refresh";
    private static String atA = "CMD";
    private static String atz = "google.com/iid";
    int atB;
    int atC;
    MessengerCompat atx = new MessengerCompat(new Handler(this, Looper.getMainLooper()) {
        final /* synthetic */ InstanceIDListenerService atD;

        public final void handleMessage(Message message) {
            InstanceIDListenerService.a(this.atD, message, MessengerCompat.c(message));
        }
    });
    BroadcastReceiver aty = new BroadcastReceiver(this) {
        final /* synthetic */ InstanceIDListenerService atD;

        {
            this.atD = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            if (Log.isLoggable("InstanceID", 3)) {
                intent.getStringExtra("registration_id");
                new StringBuilder("Received GSF callback using dynamic receiver: ").append(intent.getExtras());
            }
            this.atD.f(intent);
            this.atD.stop();
        }
    };

    static void H(Context context) {
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.setPackage(context.getPackageName());
        intent.putExtra(atA, "SYNC");
        context.startService(intent);
    }

    static void a(Context context, e eVar) {
        eVar.kI();
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.putExtra(atA, "RST");
        intent.setPackage(context.getPackageName());
        context.startService(intent);
    }

    static /* synthetic */ void a(InstanceIDListenerService instanceIDListenerService, Message message, int i) {
        d.I(instanceIDListenerService);
        instanceIDListenerService.getPackageManager();
        if (i == d.atJ || i == d.atI) {
            instanceIDListenerService.f((Intent) message.obj);
        } else {
            new StringBuilder("Message from unexpected caller ").append(i).append(" mine=").append(d.atI).append(" appid=").append(d.atJ);
        }
    }

    public final void f(Intent intent) {
        a G;
        String stringExtra = intent.getStringExtra("subtype");
        if (stringExtra == null) {
            G = a.G(this);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("subtype", stringExtra);
            G = a.a(this, bundle);
        }
        String stringExtra2 = intent.getStringExtra(atA);
        if (intent.getStringExtra("error") == null && intent.getStringExtra("registration_id") == null) {
            if (Log.isLoggable("InstanceID", 3)) {
                new StringBuilder("Service command ").append(stringExtra).append(" ").append(stringExtra2).append(" ").append(intent.getExtras());
            }
            if (intent.getStringExtra("unregistered") != null) {
                a.kD().ac(stringExtra == null ? "" : stringExtra);
                a.kE().i(intent);
                return;
            } else if (asV.equals(intent.getStringExtra("from"))) {
                a.kD().ac(stringExtra);
                return;
            } else if ("RST".equals(stringExtra2)) {
                G.atv = 0;
                a.atr.ab(G.atu + "|");
                G.att = null;
                return;
            } else if ("RST_FULL".equals(stringExtra2)) {
                if (!a.kD().isEmpty()) {
                    a.kD().kI();
                    return;
                }
                return;
            } else if ("SYNC".equals(stringExtra2)) {
                a.kD().ac(stringExtra);
                return;
            } else if ("PING".equals(stringExtra2)) {
                try {
                    a.D(this).a(atz, d.kH(), intent.getExtras());
                    return;
                } catch (IOException e) {
                    return;
                }
            } else {
                return;
            }
        }
        if (Log.isLoggable("InstanceID", 3)) {
            a.kE().i(intent);
        } else {
            a.kE().i(intent);
        }
    }

    public IBinder onBind(Intent intent) {
        return (intent == null || !"com.google.android.gms.iid.InstanceID".equals(intent.getAction())) ? null : this.atx.getBinder();
    }

    public void onCreate() {
        IntentFilter intentFilter = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
        intentFilter.addCategory(getPackageName());
        registerReceiver(this.aty, intentFilter, "com.google.android.c2dm.permission.RECEIVE", null);
    }

    public void onDestroy() {
        unregisterReceiver(this.aty);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this) {
            this.atB++;
            if (i2 > this.atC) {
                this.atC = i2;
            }
        }
        if (intent == null) {
            stop();
            return 2;
        }
        try {
            if ("com.google.android.gms.iid.InstanceID".equals(intent.getAction())) {
                if (VERSION.SDK_INT <= 18) {
                    Intent intent2 = (Intent) intent.getParcelableExtra("GSF");
                    if (intent2 != null) {
                        startService(intent2);
                        return 1;
                    }
                }
                f(intent);
            }
            stop();
            if (intent.getStringExtra("from") != null) {
                WakefulBroadcastReceiver.c(intent);
            }
            return 2;
        } finally {
            stop();
        }
    }

    final void stop() {
        synchronized (this) {
            this.atB--;
            if (this.atB == 0) {
                stopSelf(this.atC);
            }
            if (Log.isLoggable("InstanceID", 3)) {
                new StringBuilder("Stop ").append(this.atB).append(" ").append(this.atC);
            }
        }
    }
}
