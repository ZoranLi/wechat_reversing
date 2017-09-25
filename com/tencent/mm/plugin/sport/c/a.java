package com.tencent.mm.plugin.sport.c;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.mm.e.a.pq;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import com.tencent.mm.plugin.appbrand.jsapi.share.f;
import com.tencent.mm.plugin.sport.service.SportService;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ba;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.Calendar;

public final class a {
    public c<pq> qRk = new c<pq>(this) {
        final /* synthetic */ a qRq;

        {
            this.qRq = r2;
            this.usg = pq.class.getName().hashCode();
        }

        private boolean a(pq pqVar) {
            long bmq;
            boolean dQ;
            switch (pqVar.fWA.action) {
                case 1:
                case 2:
                case 3:
                    f.bmu();
                    if (a.bmo()) {
                        this.qRq.bmr();
                        bmq = this.qRq.bmq();
                        if (pqVar.fWA.action == 1) {
                            dQ = this.qRq.dQ(bmq);
                        } else if (k.t(this.qRq.bmp(), bmq)) {
                            dQ = this.qRq.dQ(bmq);
                        } else {
                            dQ = false;
                        }
                        w.i("MicroMsg.Sport.DeviceStepManager", "upload step %d %d %b", new Object[]{Integer.valueOf(pqVar.fWA.action), Long.valueOf(bmq), Boolean.valueOf(dQ)});
                        break;
                    }
                    break;
                case 4:
                case 5:
                    f.bmu();
                    if (a.bmo()) {
                        this.qRq.bmr();
                        bmq = this.qRq.bmq();
                        a aVar = this.qRq;
                        if (aVar.qRn == 0) {
                            aVar.qRn = h.F(3, 0);
                        }
                        boolean s = k.s(aVar.qRn, System.currentTimeMillis());
                        if (k.t(this.qRq.bmp(), bmq) || s) {
                            dQ = this.qRq.dQ(bmq);
                        } else {
                            dQ = false;
                        }
                        w.i("MicroMsg.Sport.DeviceStepManager", "upload step %d %d result %b timeCondition %b stepCountCondition %b", new Object[]{Integer.valueOf(pqVar.fWA.action), Long.valueOf(bmq), Boolean.valueOf(dQ), Boolean.valueOf(s), Boolean.valueOf(r5)});
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    public e qRl;
    private long qRm;
    long qRn;
    public com.tencent.mm.plugin.sport.a.a qRo;
    private ServiceConnection qRp = new ServiceConnection(this) {
        final /* synthetic */ a qRq;

        {
            this.qRq = r1;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            w.i("MicroMsg.Sport.DeviceStepManager", "onServiceConnected %s", new Object[]{componentName.toShortString()});
            this.qRq.qRo = com.tencent.mm.plugin.sport.a.a.a.Q(iBinder);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            w.i("MicroMsg.Sport.DeviceStepManager", "onServiceDisconnected %s", new Object[]{componentName.toShortString()});
            this.qRq.qRo = null;
        }
    };

    public a() {
        this.qRk.bIy();
    }

    public static boolean bmo() {
        return k.cR(ab.getContext()) && k.bmm();
    }

    public final boolean dQ(long j) {
        if (this.qRl != null) {
            h.vd().c(this.qRl);
        }
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        long timeInMillis = instance.getTimeInMillis();
        w.i("MicroMsg.Sport.DeviceStepManager", "update device Step time: %s stepCount: %s", new Object[]{k.aq(System.currentTimeMillis()), Long.valueOf(j)});
        this.qRl = new e("", "gh_43f2581f6fd6", (int) (timeInMillis / 1000), (int) (r6 / 1000), (int) j, ba.bMW(), 1);
        h.vd().a(this.qRl, 0);
        long currentTimeMillis = System.currentTimeMillis();
        this.qRn = currentTimeMillis;
        h.G(3, currentTimeMillis);
        this.qRm = j;
        h.G(4, this.qRm);
        return true;
    }

    public final long bmp() {
        if (this.qRm == 0) {
            this.qRm = h.F(4, 0);
        }
        return this.qRm;
    }

    public final long bmq() {
        long bmi;
        long currentTimeMillis = System.currentTimeMillis();
        String str = "";
        if (this.qRo != null) {
            try {
                bmi = this.qRo.bmi();
                try {
                    str = "exdevice";
                } catch (RemoteException e) {
                }
            } catch (RemoteException e2) {
                bmi = -1;
            }
        } else {
            bmi = -1;
        }
        if (bmi == -1) {
            long bJU = bg.bJU() / 10000;
            long uu = h.uu(f.CTRL_INDEX);
            bmi = h.uu(bh.CTRL_INDEX);
            if (uu == bJU) {
                str = "mm";
            } else {
                str = "unknow";
                bmi = 0;
            }
        }
        w.i("MicroMsg.Sport.DeviceStepManager", "get today step from %s process %d use time %d", new Object[]{str, Long.valueOf(bmi), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return bmi;
    }

    public final void bmr() {
        if (!k.cR(ab.getContext())) {
            try {
                if (this.qRo != null) {
                    ab.getContext().unbindService(this.qRp);
                }
                ab.getContext().stopService(new Intent(ab.getContext(), SportService.class));
            } catch (Exception e) {
            }
            this.qRo = null;
        } else if (this.qRo != null) {
            w.i("MicroMsg.Sport.DeviceStepManager", "Not need bind");
        } else {
            w.i("MicroMsg.Sport.DeviceStepManager", "start to bind sport aidl");
            try {
                Intent intent = new Intent(ab.getContext(), SportService.class);
                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                ab.getContext().bindService(intent, this.qRp, 1);
            } catch (Exception e2) {
            }
        }
    }
}
