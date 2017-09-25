package com.tencent.mm.plugin.sport;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.booter.MMReceivers.ExdeviceProcessReceiver;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.plugin.sport.b.b;
import com.tencent.mm.plugin.sport.c.a;
import com.tencent.mm.plugin.sport.c.f;
import com.tencent.mm.plugin.sport.c.g;
import com.tencent.mm.plugin.sport.c.h;
import com.tencent.mm.plugin.sport.c.i;
import com.tencent.mm.plugin.sport.c.k;
import com.tencent.mm.plugin.sport.service.SportService;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.Calendar;
import java.util.Random;

public class PluginSport extends d implements c, a {
    private g qRc;
    private b qRd;
    public a qRe;
    private com.tencent.mm.plugin.sport.c.b qRf;
    private f.a qRg = new f.a(this) {
        final /* synthetic */ PluginSport qRh;

        {
            this.qRh = r1;
        }

        public final void bmh() {
            if (this.qRh.qRe != null) {
                this.qRh.qRe.bmr();
            }
            if (k.cR(ab.getContext()) && k.bmm()) {
                Context context = ab.getContext();
                AlarmManager alarmManager = (AlarmManager) ab.getContext().getSystemService("alarm");
                Calendar instance = Calendar.getInstance();
                instance.set(12, 0);
                instance.set(13, 0);
                instance.set(14, 0);
                Random random = new Random();
                instance.set(11, 6);
                long timeInMillis = instance.getTimeInMillis() + ((long) random.nextInt(1800000));
                instance.set(11, 12);
                long timeInMillis2 = instance.getTimeInMillis() + ((long) random.nextInt(1800000));
                instance.set(11, 18);
                long timeInMillis3 = instance.getTimeInMillis() + ((long) random.nextInt(1800000));
                instance.set(11, 21);
                long timeInMillis4 = instance.getTimeInMillis() + ((long) random.nextInt(1800000));
                instance.set(11, 24);
                long timeInMillis5 = instance.getTimeInMillis() + ((long) random.nextInt(1800000));
                Intent intent = new Intent(context, SportService.class);
                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                try {
                    alarmManager.setRepeating(0, timeInMillis, 86400000, PendingIntent.getService(context, 20481, intent, 134217728));
                    alarmManager.setRepeating(0, timeInMillis2, 86400000, PendingIntent.getService(context, 20482, intent, 134217728));
                    alarmManager.setRepeating(0, timeInMillis3, 86400000, PendingIntent.getService(context, 20483, intent, 134217728));
                    alarmManager.setRepeating(0, timeInMillis4, 86400000, PendingIntent.getService(context, 20484, intent, 134217728));
                    alarmManager.setRepeating(0, timeInMillis5, 86400000, PendingIntent.getService(context, 20485, intent, 134217728));
                    w.i("MicroMsg.Sport.SportAlarmLogic", "start sport alarm %s %s %s %s %s", new Object[]{k.aq(timeInMillis), k.aq(timeInMillis2), k.aq(timeInMillis3), k.aq(timeInMillis4), k.aq(timeInMillis5)});
                    return;
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.Sport.SportAlarmLogic", e, "startSportAlarm", new Object[0]);
                    return;
                }
            }
            Context context2 = ab.getContext();
            w.i("MicroMsg.Sport.SportAlarmLogic", "stop sport alarm");
            Intent intent2 = new Intent(context2, SportService.class);
            try {
                PendingIntent service = PendingIntent.getService(context2, 20481, intent2, 134217728);
                if (service != null) {
                    service.cancel();
                }
                service = PendingIntent.getService(context2, 20482, intent2, 134217728);
                if (service != null) {
                    service.cancel();
                }
                service = PendingIntent.getService(context2, 20483, intent2, 134217728);
                if (service != null) {
                    service.cancel();
                }
                service = PendingIntent.getService(context2, 20484, intent2, 134217728);
                if (service != null) {
                    service.cancel();
                }
                PendingIntent service2 = PendingIntent.getService(context2, 20485, intent2, 134217728);
                if (service2 != null) {
                    service2.cancel();
                }
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.Sport.SportAlarmLogic", e2, "stopSportAlarm", new Object[0]);
            }
        }
    };

    public void installed() {
        alias(a.class);
    }

    public void dependency() {
        dependsOn(com.tencent.mm.plugin.zero.a.d.class);
    }

    public void configure(e eVar) {
        ExdeviceProcessReceiver.a(new i());
    }

    public void execute(e eVar) {
        if (this.qRc == null) {
            this.qRc = h.bmx();
        }
        if (eVar.ej("")) {
            this.qRd = new com.tencent.mm.plugin.sport.b.c();
            com.tencent.mm.kernel.h.a(b.class, new com.tencent.mm.kernel.c.c(this.qRd));
        }
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.f fVar) {
        this.qRe = new a();
        this.qRf = new com.tencent.mm.plugin.sport.c.b();
        f.a(this.qRg);
        this.qRg.bmh();
    }

    public g getSportFileStorage() {
        if (this.qRc == null) {
            this.qRc = h.bmx();
        }
        return this.qRc;
    }

    public a getDeviceStepManager() {
        return this.qRe;
    }

    public com.tencent.mm.plugin.sport.c.b getExtApiStepManager() {
        return this.qRf;
    }

    public void onAccountRelease() {
        f.a(null);
        if (this.qRe != null) {
            a aVar = this.qRe;
            aVar.qRk.dead();
            if (aVar.qRl != null) {
                com.tencent.mm.kernel.h.vd().c(aVar.qRl);
            }
            this.qRe = null;
        }
        if (this.qRf != null) {
            com.tencent.mm.plugin.sport.c.b bVar = this.qRf;
            bVar.qRr.dead();
            bVar.qRk.dead();
            if (bVar.qRl != null) {
                com.tencent.mm.kernel.h.vd().c(bVar.qRl);
            }
            this.qRf = null;
        }
    }
}
