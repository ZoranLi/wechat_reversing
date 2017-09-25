package com.tencent.mm.booter;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Process;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class MMReceivers {

    public static class AlarmReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            if (context != null && intent != null) {
                boolean booleanExtra = intent.getBooleanExtra("MMBoot_Bump", false);
                w.i("MicroMsg.AlarmReceiver", "[ALARM NOTIFICATION] bump:" + booleanExtra);
                if (booleanExtra) {
                    ap(context);
                } else if (!b.r(context, "alarm")) {
                    as(context);
                    w.bIP();
                }
            }
        }

        public static void ap(Context context) {
            long bIS = z.bIS();
            w.d("MicroMsg.AlarmReceiver", "bumper comes, next=" + bIS);
            if (bIS <= 1860000) {
                if (bIS < 30000) {
                    bIS = 30000;
                }
                w.w("MicroMsg.AlarmReceiver", "reset bumper, interval=" + bIS);
                AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
                if (alarmManager == null) {
                    w.e("MicroMsg.AlarmReceiver", "keep bumper failed, null am");
                    return;
                }
                alarmManager.set(0, bIS + System.currentTimeMillis(), PendingIntent.getBroadcast(context, 1, new Intent(context, AlarmReceiver.class).putExtra("MMBoot_Bump", true), SQLiteDatabase.CREATE_IF_NECESSARY));
            }
        }

        public static void aq(Context context) {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (alarmManager == null) {
                w.e("MicroMsg.AlarmReceiver", "stop bumper failed, null am");
                return;
            }
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 1, new Intent(context, AlarmReceiver.class).putExtra("MMBoot_Bump", true), SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            if (broadcast != null) {
                alarmManager.cancel(broadcast);
                broadcast.cancel();
            }
        }

        public static void ar(Context context) {
            w.w("MicroMsg.AlarmReceiver", "keep awaker");
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (alarmManager == null) {
                w.e("MicroMsg.AlarmReceiver", "keep awaker failed, null am");
                return;
            }
            int i = com.tencent.mm.network.z.MJ() ? 300000 : 900000;
            alarmManager.setRepeating(0, System.currentTimeMillis() + ((long) i), (long) i, PendingIntent.getBroadcast(context, 0, new Intent(context, AlarmReceiver.class), SQLiteDatabase.CREATE_IF_NECESSARY));
        }

        public static void as(Context context) {
            w.w("MicroMsg.AlarmReceiver", "stop awaker");
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (alarmManager == null) {
                w.e("MicroMsg.AlarmReceiver", "keep awaker failed, null am");
                return;
            }
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent(context, AlarmReceiver.class), SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            if (broadcast != null) {
                alarmManager.cancel(broadcast);
                broadcast.cancel();
            }
        }
    }

    @JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public static class BootReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            if (context != null) {
                new StringBuilder("system booted, pid=").append(Process.myPid());
                if (!b.r(context, "auto")) {
                    AlarmReceiver.as(context);
                    w.bIP();
                }
            }
        }
    }

    @JgClassChecked(author = 20, fComment = "checked", lastDate = "20140819", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public static class ConnectionReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            if (context != null) {
                w.i("MicroMsg.ConnectionReceiver", "onReceive threadID: " + Thread.currentThread().getId());
                if (!b.r(context, "connection")) {
                    AlarmReceiver.as(context);
                    w.bIP();
                } else if (com.tencent.mm.network.z.MN() != null) {
                    NetworkInfo activeNetworkInfo;
                    try {
                        activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                    } catch (Exception e) {
                        w.i("MicroMsg.ConnectionReceiver", "getActiveNetworkInfo failed.");
                        activeNetworkInfo = null;
                    }
                    com.tencent.mm.network.z.a MN;
                    if (activeNetworkInfo == null || activeNetworkInfo.getState() != State.CONNECTED) {
                        w.i("MicroMsg.ConnectionReceiver", "NetworkAvailable: false");
                        MN = com.tencent.mm.network.z.MN();
                        if (activeNetworkInfo != null) {
                            activeNetworkInfo.getTypeName();
                        }
                        if (activeNetworkInfo != null) {
                            activeNetworkInfo.getSubtypeName();
                        }
                        MN.av(false);
                        return;
                    }
                    w.i("MicroMsg.ConnectionReceiver", "NetworkAvailable: true");
                    MN = com.tencent.mm.network.z.MN();
                    activeNetworkInfo.getTypeName();
                    activeNetworkInfo.getSubtypeName();
                    MN.av(true);
                }
            }
        }
    }

    public static class ExdeviceProcessReceiver extends BroadcastReceiver {
        private static a gJO = null;

        public static void a(a aVar) {
            gJO = aVar;
        }

        public void onReceive(Context context, Intent intent) {
            if (gJO != null) {
                gJO.onReceive(context, intent);
            }
        }
    }

    public static class SandBoxProcessReceiver extends BroadcastReceiver {
        private static a gJO = null;

        public static void a(a aVar) {
            gJO = aVar;
        }

        public void onReceive(Context context, Intent intent) {
            if (gJO != null) {
                gJO.onReceive(context, intent);
            }
        }
    }

    public static class ToolsProcessReceiver extends BroadcastReceiver {
        private static a gJO = null;

        public static void a(a aVar) {
            gJO = aVar;
        }

        public void onReceive(Context context, Intent intent) {
            if (gJO != null) {
                gJO.onReceive(context, intent);
            }
        }
    }

    public interface a {
        void onReceive(Context context, Intent intent);
    }
}
