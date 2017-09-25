package com.tencent.mars.comm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.TreeMap;

public class Alarm extends BroadcastReceiver {
    private static final String KEXTRA_ID = "ID";
    private static final String KEXTRA_PID = "PID";
    private static final String TAG = "MicroMsg.Alarm";
    private static Alarm bc_alarm = null;
    private static TreeMap<Long, AlarmRecord> gPendingAlarms = new TreeMap();
    private static WakerLock wakerlock = null;

    private static class AlarmRecord implements Comparable<AlarmRecord> {
        final long id;
        PendingIntent pendingIntent;
        long waitTime;

        public int compareTo(AlarmRecord alarmRecord) {
            return (int) (this.id - alarmRecord.id);
        }

        AlarmRecord(long j, long j2, PendingIntent pendingIntent) {
            this.id = j;
            this.waitTime = j2;
            this.pendingIntent = pendingIntent;
        }
    }

    private native void onAlarm(long j);

    public static void resetAlarm(Context context) {
        synchronized (gPendingAlarms) {
            for (AlarmRecord alarmRecord : gPendingAlarms.values()) {
                cancelAlarmMgr(context, alarmRecord.pendingIntent);
            }
            gPendingAlarms.clear();
            if (bc_alarm != null) {
                context.unregisterReceiver(bc_alarm);
                bc_alarm = null;
            }
        }
    }

    public static boolean start(long j, int i, Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (i < 0) {
            w.e(TAG, "id:%d, after:%d", Long.valueOf(j), Integer.valueOf(i));
            return false;
        } else if (context == null) {
            w.e(TAG, "null==context, id:%d, after:%d", Long.valueOf(j), Integer.valueOf(i));
            return false;
        } else {
            synchronized (gPendingAlarms) {
                if (wakerlock == null) {
                    wakerlock = new WakerLock(context);
                    w.i(TAG, "start new wakerlock");
                }
                if (bc_alarm == null) {
                    bc_alarm = new Alarm();
                    context.registerReceiver(bc_alarm, new IntentFilter("ALARM_ACTION(" + String.valueOf(Process.myPid()) + ")"));
                }
                if (gPendingAlarms.containsKey(Long.valueOf(j))) {
                    w.e(TAG, "id exist=%d", Long.valueOf(j));
                    return false;
                }
                if (i >= 0) {
                    elapsedRealtime += (long) i;
                }
                PendingIntent alarmMgr = setAlarmMgr(j, elapsedRealtime, context);
                if (alarmMgr == null) {
                    return false;
                }
                gPendingAlarms.put(Long.valueOf(j), new AlarmRecord(j, elapsedRealtime, alarmMgr));
                w.i(TAG, "Alarm.start [id: %d, after: %d, size: %d]", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(gPendingAlarms.size()));
                return true;
            }
        }
    }

    public static boolean stop(long j, Context context) {
        w.i(TAG, "Alarm.stop [id: %d]", Long.valueOf(j));
        if (context == null) {
            w.e(TAG, "context==null");
            return false;
        }
        synchronized (gPendingAlarms) {
            if (wakerlock == null) {
                wakerlock = new WakerLock(context);
                w.i(TAG, "stop new wakerlock");
            }
            if (bc_alarm == null) {
                bc_alarm = new Alarm();
                context.registerReceiver(bc_alarm, new IntentFilter());
                w.i(TAG, "stop new Alarm");
            }
            AlarmRecord alarmRecord = (AlarmRecord) gPendingAlarms.remove(Long.valueOf(j));
            if (alarmRecord != null) {
                cancelAlarmMgr(context, alarmRecord.pendingIntent);
                return true;
            }
            return false;
        }
    }

    private static PendingIntent setAlarmMgr(long j, long j2, Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            w.e(TAG, "am == null");
            return null;
        }
        Intent intent = new Intent();
        intent.setAction("ALARM_ACTION(" + String.valueOf(Process.myPid()) + ")");
        intent.putExtra(KEXTRA_ID, j);
        intent.putExtra(KEXTRA_PID, Process.myPid());
        PendingIntent broadcast = PendingIntent.getBroadcast(context, (int) j, intent, SQLiteDatabase.CREATE_IF_NECESSARY);
        alarmManager.set(2, j2, broadcast);
        return broadcast;
    }

    private static boolean cancelAlarmMgr(Context context, PendingIntent pendingIntent) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            w.e(TAG, "am == null");
            return false;
        } else if (pendingIntent == null) {
            w.e(TAG, "pendingIntent == null");
            return false;
        } else {
            alarmManager.cancel(pendingIntent);
            pendingIntent.cancel();
            return true;
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null) {
            long longExtra = intent.getLongExtra(KEXTRA_ID, 0);
            int intExtra = intent.getIntExtra(KEXTRA_PID, 0);
            if (0 != longExtra && intExtra != 0) {
                if (intExtra != Process.myPid()) {
                    w.w(TAG, "onReceive id:%d, pid:%d, mypid:%d", Long.valueOf(longExtra), Integer.valueOf(intExtra), Integer.valueOf(Process.myPid()));
                    return;
                }
                synchronized (gPendingAlarms) {
                    if (((AlarmRecord) gPendingAlarms.remove(Long.valueOf(longExtra))) != null) {
                        w.i(TAG, "Alarm.onReceive [id: %d, delta miss time: %d, size: %d]", Long.valueOf(longExtra), Long.valueOf(SystemClock.elapsedRealtime() - ((AlarmRecord) gPendingAlarms.remove(Long.valueOf(longExtra))).waitTime), Integer.valueOf(gPendingAlarms.size()));
                        if (wakerlock != null) {
                            wakerlock.lock(200, "Alarm.onReceive");
                        }
                        onAlarm(longExtra);
                    } else {
                        w.e(TAG, "onReceive not found id:%d, pid:%d, gPendingAlarms.size:%d", Long.valueOf(longExtra), Integer.valueOf(intExtra), Integer.valueOf(gPendingAlarms.size()));
                    }
                }
            }
        }
    }
}
