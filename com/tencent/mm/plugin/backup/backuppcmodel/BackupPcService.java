package com.tencent.mm.plugin.backup.backuppcmodel;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.IBinder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.backup.a.e;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.SERVICESCHECK})
public class BackupPcService extends Service {
    private boolean jGO = false;
    private boolean jGP = false;

    public void onCreate() {
        w.i("MicroMsg.BackupPcService", "onCreate.");
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        w.i("MicroMsg.BackupPcService", "onStartCommand.");
        if (intent == null) {
            w.w("MicroMsg.BackupPcService", "onStartCommand intent is null");
        } else {
            final String stringExtra = intent.getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL);
            if (bg.mA(stringExtra)) {
                w.e("MicroMsg.BackupPcService", "onStartCommand url is null");
                stopSelf();
            } else if (stringExtra.contains("mm.gj.qq.com")) {
                w.i("MicroMsg.BackupPcService", "onStartCommand url from gj stop and start BakOldUSBService");
                startService(new Intent(this, BakOldUSBService.class).putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, intent.getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL)).putExtra("isFromWifi", true));
                stopSelf();
            } else {
                this.jGO = intent.getBooleanExtra("isFromWifi", false);
                this.jGP = intent.getBooleanExtra("isMove", false);
                w.i("MicroMsg.BackupPcService", "onStartCommand Broadcast url:%s, isFromWifi:%b, isMove:%b", new Object[]{stringExtra, Boolean.valueOf(this.jGO), Boolean.valueOf(this.jGP)});
                if (this.jGP || ap.za()) {
                    af.v(new Runnable(this) {
                        final /* synthetic */ BackupPcService jGQ;

                        public final void run() {
                            c abe = b.abd().abe();
                            w.w("MicroMsg.BackupPcProcessMgr", "~~~~~~~~~~~~  start by url:%s", new Object[]{stringExtra});
                            e.jg(1);
                            ap.yY();
                            abe.jGx = ((Integer) c.vr().get(a.uFu, Integer.valueOf(0))).intValue();
                            b.abd();
                            Editor edit = b.aaj().edit();
                            edit.putInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0);
                            edit.putInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0);
                            edit.putLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0);
                            edit.putLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0);
                            edit.commit();
                            abe.jGy = true;
                            ap.vd().a(595, abe.jEb);
                            ap.vd().a(new com.tencent.mm.plugin.backup.f.e(r2), 0);
                        }
                    });
                } else {
                    w.e("MicroMsg.BackupPcService", "onStartCommand onStartCommand not in Login state");
                    Intent className = new Intent().setClassName(this, "com.tencent.mm.ui.LauncherUI");
                    className.addFlags(335544320);
                    className.putExtra("nofification_type", "back_to_pcmgr_notification");
                    startActivity(className);
                }
            }
        }
        return 2;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onDestroy() {
        super.onDestroy();
        w.i("MicroMsg.BackupPcService", "onDestroy thread:" + Thread.currentThread().getName());
    }
}
