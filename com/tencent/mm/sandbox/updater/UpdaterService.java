package com.tencent.mm.sandbox.updater;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.sandbox.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20141015", reviewer = 20, vComment = {EType.RECEIVERCHECK})
public class UpdaterService extends Service {
    private static UpdaterService urI = null;
    static final long urK = 1800000;
    private boolean hML = false;
    Map<Integer, a> urJ = new HashMap();
    private aj urL = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ UpdaterService urN;

        {
            this.urN = r1;
        }

        public final boolean oQ() {
            return !this.urN.bIr();
        }
    }, true);
    private a urM = null;

    @JgClassChecked(author = 20, fComment = "checked", lastDate = "20141015", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    static final class a extends BroadcastReceiver {
        a() {
        }

        public final void onReceive(Context context, Intent intent) {
            if (UpdaterService.bIq() != null) {
                UpdaterService bIq = UpdaterService.bIq();
                boolean isWifi = am.isWifi(context);
                if (bIq.urJ.size() > 0) {
                    for (a jM : bIq.urJ.values()) {
                        jM.jM(isWifi);
                    }
                }
            }
        }
    }

    public static void cj() {
        w.i("MicroMsg.UpdaterService", "UpdaterService stopInstance()");
        if (urI != null) {
            urI.bIr();
        }
    }

    public static UpdaterService bIq() {
        return urI;
    }

    public void onCreate() {
        super.onCreate();
        w.i("MicroMsg.UpdaterService", "onCreate");
        c.f(hashCode(), this);
        urI = this;
        this.urJ.put(Integer.valueOf(0), a.urH);
        this.urJ.put(Integer.valueOf(1), d.bHV());
        this.urJ.put(Integer.valueOf(2), d.bHV());
        MMActivity.et(this);
        aj ajVar = this.urL;
        long j = urK;
        ajVar.v(j, j);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.urM = new a();
        registerReceiver(this.urM, intentFilter);
    }

    public void onStart(Intent intent, int i) {
        w.i("MicroMsg.UpdaterService", "onStart intent = %s", intent);
        k(intent);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        w.i("MicroMsg.UpdaterService", "onStartCommand intent = %s", intent);
        if (intent != null) {
            if (intent.getBooleanExtra("intent_extra_run_in_foreground", false)) {
                w.i("MicroMsg.UpdaterService", "runServiceInForground");
                startForeground(0, new Builder(this).setTicker("updater service running forground").setWhen(System.currentTimeMillis()).setContentTitle("Updater Service").setContentText("updater service running forground").setContentIntent(PendingIntent.getService(this, 0, new Intent(), 0)).getNotification());
                this.hML = true;
            } else if (VERSION.SDK_INT < 18 && !this.hML) {
                startForeground(-1314, new Notification());
                this.hML = true;
            }
        }
        k(intent);
        return 2;
    }

    public void onDestroy() {
        w.i("MicroMsg.UpdaterService", "onDestroy");
        this.urL.KH();
        if (this.urM != null) {
            unregisterReceiver(this.urM);
        }
        if (this.hML) {
            stopForeground(true);
        }
        for (a onDestroy : this.urJ.values()) {
            onDestroy.onDestroy();
        }
        this.urJ.clear();
        urI = null;
        c.g(hashCode(), this);
        super.onDestroy();
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    private void k(Intent intent) {
        if (intent != null) {
            w.i("MicroMsg.UpdaterService", "handleCommand, downloadType = %d", Integer.valueOf(intent.getIntExtra("intent_extra_download_type", 0)));
            a aVar = (a) this.urJ.get(Integer.valueOf(r0));
            if (aVar != null) {
                w.i("MicroMsg.UpdaterService", "handleCommand ret = %b", Boolean.valueOf(aVar.ab(intent)));
                if (!aVar.ab(intent)) {
                    bIr();
                }
            }
        }
    }

    private boolean bIr() {
        if (this.urJ.size() > 0) {
            for (a isBusy : this.urJ.values()) {
                if (isBusy.isBusy()) {
                    w.i("MicroMsg.UpdaterService", "checkAndTryStopSelf, dont stop, some download mgr still busy");
                    return false;
                }
            }
        }
        w.i("MicroMsg.UpdaterService", "checkAndTryStopSelf, UpdaterService killed self");
        af.f(new Runnable(this) {
            final /* synthetic */ UpdaterService urN;

            {
                this.urN = r1;
            }

            public final void run() {
                if (this.urN.urJ.size() > 0) {
                    for (a isBusy : this.urN.urJ.values()) {
                        if (isBusy.isBusy()) {
                            w.i("MicroMsg.UpdaterService", "checkAndTryStopSelf2, dont stop, some download mgr still busy");
                            return;
                        }
                    }
                }
                if (com.tencent.mm.pluginsdk.model.w.a.bCN()) {
                    w.i("TBSDownloadMgr", "is still busy");
                } else {
                    this.urN.stopSelf();
                }
            }
        }, 10000);
        return true;
    }
}
