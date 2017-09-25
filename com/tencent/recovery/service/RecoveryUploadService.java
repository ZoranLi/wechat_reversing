package com.tencent.recovery.service;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.recovery.log.RecoveryFileLog;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.option.OptionFactory;
import com.tencent.recovery.util.Util;
import com.tencent.wcdb.database.SQLiteDatabase;

public class RecoveryUploadService extends IntentService {
    private static final String TAG = "Recovery.RecoveryUploadService";

    public RecoveryUploadService() {
        super(RecoveryUploadService.class.getName());
    }

    public static synchronized void startAlarm(Context context, String str) {
        synchronized (RecoveryUploadService.class) {
            if (!Util.mA(str)) {
                CommonOptions fq = OptionFactory.fq(context);
                SharedPreferences sharedPreferences = context.getSharedPreferences("recovery-info", 0);
                long j = sharedPreferences.getLong("KeyLastUploadTime", 0);
                long currentTimeMillis = System.currentTimeMillis();
                RecoveryLog.i(TAG, "startAlarm %s lastUploadTime %s", str, Util.eY(j));
                Intent intent = new Intent();
                intent.setClassName(context, str);
                intent.putExtra("KeyReportUploadClassName", str);
                PendingIntent service = PendingIntent.getService(context, 1000001, intent, SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                if (service == null || currentTimeMillis - j > fq.wQx) {
                    if (service != null) {
                        service.cancel();
                        RecoveryLog.i(TAG, "startAlarm cancel preIntent", new Object[0]);
                    }
                    sharedPreferences.edit().putLong("KeyLastUploadTime", currentTimeMillis).commit();
                    try {
                        ((AlarmManager) context.getSystemService("alarm")).set(0, (fq.wQx + currentTimeMillis) - 2000, PendingIntent.getService(context, 1000001, intent, 134217728));
                    } catch (Throwable e) {
                        RecoveryLog.printErrStackTrace(TAG, e, "alarmManager.setAlarm", new Object[0]);
                    }
                    RecoveryLog.i(TAG, "startAlarm pendingIntent success: %d will report %s", Integer.valueOf(r2.hashCode()), Util.eY(j));
                } else {
                    RecoveryLog.i(TAG, "already set alarm", new Object[0]);
                }
            }
        }
    }

    public static void cancelAlarm(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName(context, str);
        intent.putExtra("KeyReportUploadClassName", str);
        PendingIntent service = PendingIntent.getService(context, 1000001, intent, SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
        if (service != null) {
            service.cancel();
        }
    }

    public static void startAlarmAfter(Context context, String str, long j) {
        if (!Util.mA(str)) {
            RecoveryLog.i(TAG, "startAlarmAfter %s %d", str, Long.valueOf(j));
            Intent intent = new Intent();
            intent.setClassName(context, str);
            intent.putExtra("KeyReportUploadClassName", str);
            PendingIntent service = PendingIntent.getService(context, 1000001, intent, SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            if (service != null) {
                service.cancel();
            }
            try {
                ((AlarmManager) context.getSystemService("alarm")).set(0, (System.currentTimeMillis() + j) - 2000, PendingIntent.getService(context, 1000001, intent, 134217728));
            } catch (Throwable e) {
                RecoveryLog.printErrStackTrace(TAG, e, "alarmManager.setAlarm", new Object[0]);
            }
            RecoveryLog.i(TAG, "startAlarmAfter pendingIntent:%d %s", Integer.valueOf(service.hashCode()), Util.eY(r2));
        }
    }

    protected void onHandleIntent(Intent intent) {
        RecoveryLog.i(TAG, "RecoveryUploadReceiver.onHandleIntent", new Object[0]);
        boolean tryToUploadData = tryToUploadData();
        String stringExtra = intent.getStringExtra("KeyReportUploadClassName");
        if (Util.mA(stringExtra)) {
            stringExtra = getClass().getName();
        }
        cancelAlarm(this, stringExtra);
        if (!tryToUploadData) {
            startAlarmAfter(this, stringExtra, OptionFactory.fq(this).wQx);
        }
        RecoveryLog.i(TAG, "RecoveryUploadReceiver.uploadDataResult %b", Boolean.valueOf(tryToUploadData));
        if (RecoveryLog.cdy() instanceof RecoveryFileLog) {
            RecoveryLog.i(TAG, "send broadcast action", new Object[0]);
            RecoveryLog.cdx();
            Intent intent2 = new Intent();
            intent2.setPackage(getPackageName());
            intent2.setAction("com.tecent.recovery.intent.action.LOG");
            sendBroadcast(intent2);
        }
        stopSelf();
    }

    public boolean tryToUploadData() {
        return true;
    }
}
