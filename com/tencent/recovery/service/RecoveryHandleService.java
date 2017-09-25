package com.tencent.recovery.service;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.tencent.recovery.RecoveryLogic;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryData;
import com.tencent.recovery.model.RecoveryHandleItem;
import com.tencent.recovery.model.RecoveryHandleResult;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.option.OptionFactory;
import com.tencent.recovery.util.Util;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;

public class RecoveryHandleService extends IntentService {
    private static volatile boolean fBn;

    public static class InnerService extends Service {
        public void onCreate() {
            super.onCreate();
            try {
                startForeground(-1119860829, new Notification());
            } catch (Throwable th) {
                RecoveryLog.e("Recovery.RecoveryHandleService", "InnerService set service for push exception:%s.", th);
            }
            stopSelf();
        }

        public void onDestroy() {
            stopForeground(true);
            super.onDestroy();
        }

        public IBinder onBind(Intent intent) {
            return null;
        }
    }

    public RecoveryHandleService() {
        super(RecoveryHandleService.class.getName());
    }

    public void onCreate() {
        RecoveryLog.i("Recovery.RecoveryHandleService", "onCreate", new Object[0]);
        super.onCreate();
    }

    public void onDestroy() {
        RecoveryLog.i("Recovery.RecoveryHandleService", "onDestroy", new Object[0]);
        RecoveryLog.cdx();
        super.onDestroy();
    }

    protected final void onHandleIntent(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra("KeyIsRetry", false);
        int fs = Util.fs(this);
        String stringExtra = intent.getStringExtra("KeyReportUploadClassName");
        String stringExtra2 = intent.getStringExtra("KeyReportHandleClassName");
        RecoveryData recoveryData = (RecoveryData) intent.getParcelableExtra("KeyRecoveryData");
        if (recoveryData == null || recoveryData.processName == null) {
            RecoveryLog.i("Recovery.RecoveryHandleService", "recoveryData is null %b %d %s %s", Boolean.valueOf(booleanExtra), Integer.valueOf(fs), stringExtra, stringExtra2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Intent intent2 = new Intent();
        intent2.setClassName(this, stringExtra2);
        PendingIntent service = PendingIntent.getService(this, 1000002, intent2, SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
        if (service != null) {
            service.cancel();
        }
        if (fBn) {
            RecoveryLog.i("Recovery.RecoveryHandleService", "handle already running", new Object[0]);
            try {
                a(recoveryData, arrayList, booleanExtra);
            } catch (Throwable e) {
                RecoveryLog.printErrStackTrace("Recovery.RecoveryHandleService", e, "alreadyRunning", new Object[0]);
            }
        } else {
            fBn = true;
            RecoveryLog.i("Recovery.RecoveryHandleService", "try to increase recovery process priority", new Object[0]);
            try {
                Notification notification = new Notification();
                if (VERSION.SDK_INT < 18) {
                    startForeground(-1119860829, notification);
                } else {
                    startForeground(-1119860829, notification);
                    startService(new Intent(this, InnerService.class));
                }
            } catch (Throwable th) {
                RecoveryLog.i("Recovery.RecoveryHandleService", "try to increase recovery process priority error:" + th, new Object[0]);
            }
            RecoveryLog.i("Recovery.RecoveryHandleService", "start to handle %s's exception uuid: %s threadId: %d", recoveryData.processName, recoveryData.mry, Long.valueOf(Thread.currentThread().getId()));
            RecoveryHandleResult recoveryHandleResult = new RecoveryHandleResult();
            try {
                recoveryHandleResult = a(this, recoveryData, arrayList, booleanExtra);
            } catch (Throwable e2) {
                RecoveryLog.printErrStackTrace("Recovery.RecoveryHandleService", e2, "handle", new Object[0]);
            }
            if (recoveryHandleResult.wQt && !booleanExtra) {
                Intent intent3 = new Intent();
                intent3.setClassName(this, stringExtra2);
                intent3.putExtra("KeyReportUploadClassName", stringExtra);
                intent3.putExtra("KeyReportHandleClassName", stringExtra2);
                intent3.putExtra("KeyRecoveryData", recoveryData);
                intent3.putExtra("KeyIsRetry", true);
                PendingIntent service2 = PendingIntent.getService(this, 1000002, intent3, SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                if (service2 != null) {
                    service2.cancel();
                }
                CommonOptions fq = OptionFactory.fq(this);
                long currentTimeMillis = (System.currentTimeMillis() + fq.wQy) - 2000;
                ((AlarmManager) getSystemService("alarm")).set(0, currentTimeMillis, PendingIntent.getService(this, 1000002, intent3, 0));
                RecoveryLog.i("Recovery.RecoveryHandleService", "startAlarm pendingIntent success: %d will retry %s", Integer.valueOf(r2.hashCode()), Util.eY(currentTimeMillis));
            }
            RecoveryLog.i("Recovery.RecoveryHandleService", "handle recoveryHandleResult %s", recoveryHandleResult);
        }
        RecoveryLogic.a((Context) this, arrayList, stringExtra);
        fBn = false;
        stopSelf();
    }

    public void a(RecoveryData recoveryData, ArrayList<RecoveryHandleItem> arrayList, boolean z) {
    }

    public RecoveryHandleResult a(Context context, RecoveryData recoveryData, ArrayList<RecoveryHandleItem> arrayList, boolean z) {
        return new RecoveryHandleResult();
    }
}
