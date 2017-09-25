package com.tencent.mm.plugin.hp.tinker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;

public final class a {
    public Handler handler = new Handler(Looper.getMainLooper());

    class AnonymousClass2 extends BroadcastReceiver {
        final /* synthetic */ Runnable iwT;
        final /* synthetic */ a mLE;
        final /* synthetic */ long mLF = 6000;

        AnonymousClass2(a aVar, Runnable runnable, long j) {
            this.mLE = aVar;
            this.iwT = runnable;
        }

        public final void onReceive(Context context, Intent intent) {
            if ("android.intent.action.SCREEN_OFF".equals(intent == null ? "" : intent.getAction())) {
                com.tencent.tinker.lib.e.a.i("Tinker.ScreenOffRetryPatch", "ScreenOffRetryPatch screen off now, send message now", new Object[0]);
                this.mLE.handler.postDelayed(this.iwT, this.mLF);
                return;
            }
            com.tencent.tinker.lib.e.a.i("Tinker.ScreenOffRetryPatch", "ScreenOffRetryPatch screen on, remove pending runnable and receive", new Object[0]);
            this.mLE.handler.removeCallbacks(this.iwT);
            context.unregisterReceiver(this);
        }
    }

    public interface a {
        void aDi();
    }

    public a(Context context, final a aVar) {
        Boolean aY = aY(context);
        com.tencent.tinker.lib.e.a.i("Tinker.ScreenOffRetryPatch", "try post ScreenOffRetryPatch delay time: %d, screen: %b", new Object[]{Long.valueOf(6000), aY});
        IntentFilter intentFilter = new IntentFilter();
        Runnable anonymousClass1 = new Runnable(this) {
            final /* synthetic */ a mLE;

            public final void run() {
                if (aVar != null) {
                    com.tencent.tinker.lib.e.a.i("Tinker.ScreenOffRetryPatch", "ScreenOffRetryPatch runnable try to start", new Object[0]);
                    aVar.aDi();
                }
            }
        };
        if (aY == null || aY.booleanValue()) {
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
        } else {
            com.tencent.tinker.lib.e.a.i("Tinker.ScreenOffRetryPatch", "screen is just off now, we can send message directly", new Object[0]);
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            this.handler.postDelayed(anonymousClass1, 6000);
        }
        context.registerReceiver(new AnonymousClass2(this, anonymousClass1, 6000), intentFilter);
    }

    private static Boolean aY(Context context) {
        try {
            return (Boolean) PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager) context.getSystemService("power"), new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }
}
