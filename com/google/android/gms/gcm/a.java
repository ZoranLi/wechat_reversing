package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.google.android.gms.iid.d;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class a {
    public static int asX = 5000000;
    public static int asY = 6500000;
    public static int asZ = 7000000;
    static a ata;
    private static final AtomicInteger atd = new AtomicInteger(1);
    private PendingIntent atb;
    Map<String, Handler> atc = Collections.synchronizedMap(new HashMap());
    public final BlockingQueue<Intent> ate = new LinkedBlockingQueue();
    final Messenger atf = new Messenger(new Handler(this, Looper.getMainLooper()) {
        final /* synthetic */ a atg;

        public final void handleMessage(Message message) {
            if (message != null) {
                Object obj = message.obj;
            }
            Intent intent = (Intent) message.obj;
            if ("com.google.android.c2dm.intent.REGISTRATION".equals(intent.getAction())) {
                this.atg.ate.add(intent);
                return;
            }
            boolean sendMessage;
            a aVar = this.atg;
            Object stringExtra = intent.getStringExtra("In-Reply-To");
            if (stringExtra == null && intent.hasExtra("error")) {
                stringExtra = intent.getStringExtra("google.message_id");
            }
            if (stringExtra != null) {
                Handler handler = (Handler) aVar.atc.remove(stringExtra);
                if (handler != null) {
                    Message obtain = Message.obtain();
                    obtain.obj = intent;
                    sendMessage = handler.sendMessage(obtain);
                    if (!sendMessage) {
                        intent.setPackage(this.atg.context.getPackageName());
                        this.atg.context.sendBroadcast(intent);
                    }
                }
            }
            sendMessage = false;
            if (!sendMessage) {
                intent.setPackage(this.atg.context.getPackageName());
                this.atg.context.sendBroadcast(intent);
            }
        }
    });
    public Context context;

    public static synchronized a D(Context context) {
        a aVar;
        synchronized (a.class) {
            if (ata == null) {
                aVar = new a();
                ata = aVar;
                aVar.context = context.getApplicationContext();
            }
            aVar = ata;
        }
        return aVar;
    }

    public static int E(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(d.I(context), 0).versionCode;
        } catch (NameNotFoundException e) {
            return -1;
        }
    }

    public static String d(Intent intent) {
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            return null;
        }
        String stringExtra = intent.getStringExtra("message_type");
        return stringExtra == null ? "gcm" : stringExtra;
    }

    private synchronized void e(Intent intent) {
        if (this.atb == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.atb = PendingIntent.getBroadcast(this.context, 0, intent2, 0);
        }
        intent.putExtra("app", this.atb);
    }

    @Deprecated
    private Intent i(Bundle bundle) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        } else if (E(this.context) < 0) {
            throw new IOException("Google Play Services missing");
        } else {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage(d.I(this.context));
            e(intent);
            intent.putExtra("google.message_id", "google.rpc" + String.valueOf(atd.getAndIncrement()));
            intent.putExtras(bundle);
            intent.putExtra("google.messenger", this.atf);
            this.context.startService(intent);
            try {
                return (Intent) this.ate.poll(30000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                throw new IOException(e.getMessage());
            }
        }
    }

    public final void a(String str, String str2, Bundle bundle) {
        if (str == null) {
            throw new IllegalArgumentException("Missing 'to'");
        }
        Intent intent = new Intent("com.google.android.gcm.intent.SEND");
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        e(intent);
        intent.setPackage(d.I(this.context));
        intent.putExtra("google.to", str);
        intent.putExtra("google.message_id", str2);
        intent.putExtra("google.ttl", Long.toString(0));
        intent.putExtra("google.delay", Integer.toString(-1));
        if (d.I(this.context).contains(".gsf")) {
            Bundle bundle2 = new Bundle();
            for (String str3 : bundle.keySet()) {
                Object obj = bundle.get(str3);
                if (obj instanceof String) {
                    bundle2.putString("gcm." + str3, (String) obj);
                }
            }
            bundle2.putString("google.to", str);
            bundle2.putString("google.message_id", str2);
            com.google.android.gms.iid.a.G(this.context).b("GCM", "upstream", bundle2);
            return;
        }
        this.context.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
    }

    @Deprecated
    public final synchronized String b(String... strArr) {
        String d;
        Object obj = null;
        synchronized (this) {
            String stringBuilder = new StringBuilder(strArr[0]).toString();
            Bundle bundle = new Bundle();
            if (d.I(this.context).contains(".gsf")) {
                bundle.putString("legacy.sender", stringBuilder);
                com.google.android.gms.iid.a G = com.google.android.gms.iid.a.G(this.context);
                String str = "GCM";
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    throw new IOException("MAIN_THREAD");
                }
                Object obj2 = 1;
                d = com.google.android.gms.iid.a.kF() ? null : com.google.android.gms.iid.a.atr.d(G.atu, stringBuilder, str);
                if (d == null) {
                    if (bundle.getString("ttl") != null) {
                        obj2 = null;
                    }
                    if (!"jwt".equals(bundle.getString(Columns.TYPE))) {
                        obj = obj2;
                    }
                    d = G.b(stringBuilder, str, bundle);
                    if (!(d == null || r0 == null)) {
                        com.google.android.gms.iid.a.atr.a(G.atu, stringBuilder, str, d, com.google.android.gms.iid.a.atw);
                    }
                }
            } else {
                bundle.putString("sender", stringBuilder);
                Intent i = i(bundle);
                String str2 = "registration_id";
                if (i == null) {
                    throw new IOException("SERVICE_NOT_AVAILABLE");
                }
                d = i.getStringExtra(str2);
                if (d == null) {
                    String stringExtra = i.getStringExtra("error");
                    if (stringExtra != null) {
                        throw new IOException(stringExtra);
                    }
                    throw new IOException("SERVICE_NOT_AVAILABLE");
                }
            }
        }
        return d;
    }
}
