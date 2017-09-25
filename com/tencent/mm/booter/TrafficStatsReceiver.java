package com.tencent.mm.booter;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.database.SQLiteDatabase;

public class TrafficStatsReceiver extends BroadcastReceiver {
    private long mLastTime = -1;

    public void onReceive(Context context, Intent intent) {
        w.d("MicroMsg.TrafficStats", "onRecieve");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        bf.update();
        if (this.mLastTime >= 0) {
            long j = elapsedRealtime - this.mLastTime;
            long bJL = bf.bJL() + bf.bJK();
            long bJJ = bf.bJJ() + bf.bJI();
            long bJP = bf.bJP() + bf.bJO();
            long bJP2 = bf.bJP() + bf.bJO();
            w.i("MicroMsg.TrafficStats", "Time: %d ms, System - [Mobile: %d, Wifi: %d, Speed: %.2f], WeChat - [Mobile: %d, Wifi: %d, Speed: %.2f]", Long.valueOf(j), Long.valueOf(bJL), Long.valueOf(bJJ), Double.valueOf(((double) (bJL + bJJ)) / ((double) (j / 1000))), Long.valueOf(bJP), Long.valueOf(bJP2), Double.valueOf(((double) (bJP + bJP2)) / ((double) (j / 1000))));
        }
        this.mLastTime = elapsedRealtime;
    }

    public static void at(Context context) {
        ((AlarmManager) context.getSystemService("alarm")).setRepeating(3, SystemClock.elapsedRealtime(), 300000, PendingIntent.getBroadcast(context, 1, new Intent("com.tencent.mm.TrafficStatsReceiver"), SQLiteDatabase.CREATE_IF_NECESSARY));
        w.i("MicroMsg.TrafficStats", "Register alarm, interval: %d ms", Long.valueOf(300000));
    }

    public static void au(Context context) {
        ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, 1, new Intent("com.tencent.mm.TrafficStatsReceiver"), SQLiteDatabase.CREATE_IF_NECESSARY));
    }
}
