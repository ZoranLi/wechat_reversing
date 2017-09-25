package com.tencent.mm.plugin.talkroom.component;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.tencent.mm.sdk.platformtools.w;

public class TalkRoomService extends Service {
    private g qXC;

    static {
        w.i("MicroMsg.TalkRoomService", Thread.currentThread().getId());
    }

    public void onCreate() {
        w.d("MicroMsg.TalkRoomService", "onCreate~~~threadID:" + Thread.currentThread());
        super.onCreate();
        if (VERSION.SDK_INT < 18) {
            startForeground(9999, new Notification());
        }
        if (this.qXC == null) {
            this.qXC = new g();
        }
    }

    public void onDestroy() {
        w.d("MicroMsg.TalkRoomService", "onDestroy~~~ threadID:" + Thread.currentThread());
        super.onDestroy();
    }

    public boolean onUnbind(Intent intent) {
        w.d("MicroMsg.TalkRoomService", "onUnbind~~~ threadID:" + Thread.currentThread());
        return super.onUnbind(intent);
    }

    public IBinder onBind(Intent intent) {
        w.d("MicroMsg.TalkRoomService", "onBind~~~ threadID:" + Thread.currentThread());
        return this.qXC;
    }

    public void onRebind(Intent intent) {
        w.d("MicroMsg.TalkRoomService", "onRebind~~~ threadID:" + Thread.currentThread());
        super.onRebind(intent);
    }
}
