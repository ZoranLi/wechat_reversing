package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.protocal.c.xa;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.SERVICESCHECK})
public class BakOldUSBService extends Service implements e {
    private boolean jGO = false;
    private int jJE = -1;

    public IBinder onBind(Intent intent) {
        w.i("MicroMsg.BakOldUSBService", "onBind()");
        return null;
    }

    public void onCreate() {
        w.i("MicroMsg.BakOldUSBService", "onCreate()");
        super.onCreate();
        ap.vd().a(595, this);
        b.a(1, this);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        int i3 = 1;
        w.i("MicroMsg.BakOldUSBService", "onStartCommand() scene：%d", new Object[]{Integer.valueOf(this.jJE)});
        if (intent == null) {
            w.w("MicroMsg.BakOldUSBService", "onStartCommand intent is null");
        } else {
            String stringExtra = intent.getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL);
            if (bg.mA(stringExtra)) {
                w.e("MicroMsg.BakOldUSBService", "onStartCommand url is null");
                stopSelf();
            } else {
                this.jGO = intent.getBooleanExtra("isFromWifi", false);
                w.i("MicroMsg.BakOldUSBService", "Broadcast url:%s, isFromWifi:%b", new Object[]{stringExtra, Boolean.valueOf(this.jGO)});
                a.acg().aci().zO();
                c aci = a.acg().aci();
                if (this.jGO) {
                    i3 = 2;
                }
                aci.jLz = i3;
                if (ap.za()) {
                    ap.vd().a(new com.tencent.mm.plugin.backup.bakoldlogic.c.e(stringExtra), 0);
                } else {
                    w.e("MicroMsg.BakOldUSBService", "onStartCommand not in Login state");
                    Intent className = new Intent().setClassName(this, "com.tencent.mm.ui.LauncherUI");
                    className.addFlags(335544320);
                    className.putExtra("nofification_type", "back_to_pcmgr_notification");
                    startActivity(className);
                }
            }
        }
        return 2;
    }

    public void onDestroy() {
        ap.vd().b(595, this);
        b.b(1, this);
        super.onDestroy();
        w.i("MicroMsg.BakOldUSBService", "onDestroy thread:" + Thread.currentThread().getName());
    }

    private boolean abP() {
        return this.jJE == 0 || this.jJE == 1;
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2 = "MicroMsg.BakOldUSBService";
        String str3 = "summerbak onSceneEnd [%d, %d, %s] [%s] backupScene[%d]";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = str;
        objArr[3] = kVar == null ? "" : kVar.getClass().getSimpleName();
        objArr[4] = Integer.valueOf(this.jJE);
        w.i(str2, str3, objArr);
        if (kVar instanceof b) {
            w.d("MicroMsg.BakOldUSBService", "summerback BackupBaseScene type[%d], backupScene[%d]", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(this.jJE)});
            if (kVar.getType() == 1 && i == 0 && i2 == 0) {
                boolean z;
                Intent className = new Intent().setClassName(this, "com.tencent.mm.ui.LauncherUI");
                className.addFlags(335544320);
                className.putExtra("nofification_type", "back_to_pcmgr_notification");
                str3 = "newPCBackup";
                if (abP()) {
                    z = false;
                } else {
                    z = true;
                }
                className.putExtra(str3, z);
                startActivity(className);
            }
            stopSelf();
        } else if (!(kVar instanceof com.tencent.mm.plugin.backup.bakoldlogic.c.e)) {
        } else {
            if (i == 0 && i2 == 0) {
                xa acy = ((com.tencent.mm.plugin.backup.bakoldlogic.c.e) kVar).acy();
                a.acg().jBm = acy.ID;
                a.acg().jBn = acy.tib;
                a.acg().jBo = acy.tic;
                this.jJE = acy.tdM;
                w.d("MicroMsg.BakOldUSBService", "summerbak getconnetinfo type: %d, scene: %d isFromWifi:%b", new Object[]{Integer.valueOf(acy.jOc), Integer.valueOf(acy.tdM), Boolean.valueOf(this.jGO)});
                if (!this.jGO && acy.jOc == 1) {
                    w.e("MicroMsg.BakOldUSBService", "broast from usb but type is wifi, url may be fake!!!!");
                    stopSelf();
                    return;
                } else if (abP()) {
                    a.acg().ach().bn(acy.thT, acy.thU);
                    b.a(a.acg().ach());
                    b.a(a.acg().acj());
                    b.jg(1);
                    a.acg().acj().b(acy.jOc, acy.thS);
                    return;
                } else {
                    w.d("MicroMsg.BakOldUSBService", "summerbak onSceneEnd need todo for new scene:% ", new Object[]{Integer.valueOf(this.jJE)});
                    return;
                }
            }
            a.acg().aci().jLA = 2;
            a.acg().aci().zO();
            if (i == 4 && i2 == -2011) {
                w.i("MicroMsg.BakOldUSBService", "getConnect info: INVALID URL");
            } else {
                w.i("MicroMsg.BakOldUSBService", "getConnect info other error");
            }
            a.acg().ach();
            com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.acp();
            stopSelf();
        }
    }

    public boolean stopService(Intent intent) {
        w.i("MicroMsg.BakOldUSBService", "stopService.");
        return super.stopService(intent);
    }
}
