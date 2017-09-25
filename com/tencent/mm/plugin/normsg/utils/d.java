package com.tencent.mm.plugin.normsg.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RecentTaskInfo;
import android.os.Build.VERSION;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.reflect.Field;
import java.util.List;

public final class d {
    public static boolean nZP;

    static {
        nZP = false;
        long nanoTime = System.nanoTime();
        try {
            nZP = false;
            if (VERSION.SDK_INT < 21) {
                nZP = false;
            } else {
                Field declaredField = RecentTaskInfo.class.getDeclaredField("instanceId");
                declaredField.setAccessible(true);
                List recentTasks = ((ActivityManager) ab.getContext().getApplicationContext().getSystemService("activity")).getRecentTasks(1, 2);
                if (recentTasks == null || recentTasks.size() == 0) {
                    nZP = false;
                } else if (declaredField.getInt((RecentTaskInfo) recentTasks.get(0)) > 0) {
                    nZP = true;
                }
            }
            w.i("MicroMsg.NormalMsgSource.QSDTH", "QSDT, result: %b, time: %d ns", new Object[]{Boolean.valueOf(nZP), Long.valueOf(System.nanoTime() - nanoTime)});
        } catch (Throwable th) {
            w.i("MicroMsg.NormalMsgSource.QSDTH", "QSDT, result: %b, time: %d ns", new Object[]{Boolean.valueOf(nZP), Long.valueOf(System.nanoTime() - nanoTime)});
        }
    }
}
