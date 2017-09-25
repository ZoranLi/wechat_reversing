package com.tencent.mm.sandbox.monitor;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import com.tencent.mm.modelrecovery.a;
import com.tencent.mm.sandbox.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.database.SQLiteDatabase;

public class ExceptionMonitorService extends Service {
    public static long hnT = 0;
    public static int upN = 0;
    private static ExceptionMonitorService upR = null;
    private long upO = 300000;
    private ae upP = new ae();
    private Runnable upQ = new Runnable(this) {
        final /* synthetic */ ExceptionMonitorService upT;

        {
            this.upT = r1;
        }

        public final void run() {
            w.d("MicroMsg.CrashMonitorService", "stopSelf");
            this.upT.stopSelf();
        }
    };
    private long upS;

    public void onCreate() {
        super.onCreate();
        upR = this;
        c.f(hashCode(), this);
        this.upP.postDelayed(this.upQ, this.upO);
    }

    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        k(intent);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        k(intent);
        return 1;
    }

    public void onDestroy() {
        super.onDestroy();
        upR = null;
        c.g(hashCode(), this);
        this.upP.removeCallbacks(this.upQ);
    }

    private void k(Intent intent) {
        if (intent != null) {
            this.upP.removeCallbacks(this.upQ);
            this.upP.postDelayed(this.upQ, this.upO);
            String action = intent.getAction();
            w.d("MicroMsg.CrashMonitorService", "dkcrash handleCommand action:" + action);
            try {
                String stringExtra = intent.getStringExtra("tag");
                if (stringExtra == null) {
                    stringExtra = "exception";
                }
                int intExtra = intent.getIntExtra("exceptionPid", 0);
                stringExtra.equals("exception");
                upN = intExtra;
                hnT = intent.getLongExtra("exceptionTime", SystemClock.elapsedRealtime());
                String stringExtra2 = intent.getStringExtra("exceptionMsg");
                String stringExtra3 = intent.getStringExtra("userName");
                boolean booleanExtra = intent.getBooleanExtra("exceptionWriteSdcard", true);
                w.d("MicroMsg.CrashMonitorService", "dkcrash handleCommand. action=" + action + " pid:" + intExtra + " tag=" + stringExtra + ", userName=" + stringExtra3 + ", message" + stringExtra2);
                if (!bg.mA(stringExtra2)) {
                    if (a.a(stringExtra3, stringExtra, new a(stringExtra3, stringExtra, bg.Ny(), stringExtra2, booleanExtra)) == 0) {
                        dR(this);
                    }
                    if (System.currentTimeMillis() - this.upS > 600000) {
                        this.upS = System.currentTimeMillis();
                        e.post(new Runnable(this) {
                            final /* synthetic */ ExceptionMonitorService upT;

                            {
                                this.upT = r1;
                            }

                            public final void run() {
                                a.If();
                            }
                        }, "RecoveryWriteLogThread");
                    }
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.CrashMonitorService", e, "", new Object[0]);
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public static void dR(Context context) {
        Intent intent = new Intent(context, CrashUploadAlarmReceiver.class);
        if (PendingIntent.getBroadcast(context, 0, intent, SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) == null) {
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 0);
            ((AlarmManager) context.getSystemService("alarm")).set(0, bg.Nz() + 1800000, broadcast);
            w.d("MicroMsg.CrashMonitorService", "dkcrash startAlarmMgr pendingIntent:%d %d", Integer.valueOf(broadcast.hashCode()), Long.valueOf(r2));
        }
    }
}
