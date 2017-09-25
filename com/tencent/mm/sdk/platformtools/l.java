package com.tencent.mm.sdk.platformtools;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.PowerManager;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.List;

public final class l {
    private static BroadcastReceiver lQX = null;
    public static int usA = -1;
    public static int usz = 0;

    public static boolean dY(Context context) {
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            return VERSION.SDK_INT >= 20 ? powerManager.isInteractive() : powerManager.isScreenOn();
        } catch (Throwable e) {
            w.e("MicroMsg.GreenManUtil", "isScreenOn ERROR use isScreenOn e:%s", bg.g(e));
            return false;
        }
    }

    public static synchronized boolean dZ(Context context) {
        boolean z = false;
        synchronized (l.class) {
            if (lQX == null) {
                lQX = new BroadcastReceiver() {
                    public final void onReceive(Context context, Intent intent) {
                        if (intent != null) {
                            try {
                                l.usA = intent.getIntExtra(DownloadInfo.STATUS, -1);
                                l.usz = intent.getIntExtra("plugged", 0);
                            } catch (Throwable th) {
                            }
                            w.i("MicroMsg.GreenManUtil", "isCharging BroadcastReceiver thread:%d status:%d plugged:%d", Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(l.usA), Integer.valueOf(l.usz));
                        }
                    }
                };
                try {
                    Intent registerReceiver = context.registerReceiver(lQX, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                    usA = registerReceiver.getIntExtra(DownloadInfo.STATUS, -1);
                    usz = registerReceiver.getIntExtra("plugged", 0);
                } catch (Throwable th) {
                }
            }
            if (usA == 2 || usz == 1 || usz == 2 || (VERSION.SDK_INT >= 17 && usz == 4)) {
                z = true;
            }
        }
        return z;
    }

    public static boolean cB(Context context) {
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.startsWith("com.tencent.mm")) {
                return true;
            }
        }
        return false;
    }
}
