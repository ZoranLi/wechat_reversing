package com.tencent.mm.plugin.talkroom.model;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.sdk.platformtools.z.b;
import com.tencent.wcdb.database.SQLiteDatabase;

public class TalkRoomReceiver extends BroadcastReceiver {
    protected static void init() {
        z.a(new b() {
            public final void prepare() {
                TalkRoomReceiver.ap(ab.getContext());
            }

            public final void cancel() {
                TalkRoomReceiver.aq(ab.getContext());
            }
        });
    }

    public void onReceive(Context context, Intent intent) {
        w.i("MicroMsg.TalkRoomReceiver", "[ALARM NOTIFICATION] bump:" + intent.getBooleanExtra("MMBoot_Bump", false));
        ap(context);
    }

    public static void ap(Context context) {
        long bIS = z.bIS();
        w.d("MicroMsg.TalkRoomReceiver", "bumper comes, next=" + bIS);
        if (bIS <= 600000) {
            if (bIS < 30000) {
                bIS = 30000;
            }
            w.w("MicroMsg.TalkRoomReceiver", "reset bumper, interval:%d, now:%d", new Object[]{Long.valueOf(bIS), Long.valueOf(SystemClock.elapsedRealtime())});
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (alarmManager == null) {
                w.e("MicroMsg.TalkRoomReceiver", "keep bumper failed, null am");
                return;
            }
            alarmManager.set(2, bIS + r4, PendingIntent.getBroadcast(context, 1, new Intent(context, TalkRoomReceiver.class).putExtra("MMBoot_Bump", true), SQLiteDatabase.CREATE_IF_NECESSARY));
        }
    }

    public static void aq(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            w.e("MicroMsg.TalkRoomReceiver", "stop bumper failed, null am");
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 1, new Intent(context, TalkRoomReceiver.class).putExtra("MMBoot_Bump", true), SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            broadcast.cancel();
        }
    }
}
