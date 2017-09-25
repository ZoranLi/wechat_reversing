package com.tencent.mm.plugin.sport.service;

import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.os.Process;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import com.tencent.mm.plugin.appbrand.jsapi.share.f;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.plugin.sport.a.a.a;
import com.tencent.mm.plugin.sport.c.c;
import com.tencent.mm.plugin.sport.c.h;
import com.tencent.mm.plugin.sport.c.j;
import com.tencent.mm.plugin.sport.c.k;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public class SportService extends Service implements c {
    private SensorManager hVM;
    private j qRJ;
    private boolean qRK = false;
    private final a qRL = new a(this) {
        final /* synthetic */ SportService qRM;

        {
            this.qRM = r1;
        }

        public final long bmi() {
            try {
                long bJU = bg.bJU() / 10000;
                long uu = h.uu(f.CTRL_INDEX);
                long uu2 = h.uu(bh.CTRL_INDEX);
                int bmy = (int) j.bmy();
                if (j.bmz() == bJU) {
                    w.i("MicroMsg.Sport.SportService", "cacheTime %s cacheStep:%s", new Object[]{Long.valueOf(j.bmz()), Integer.valueOf(bmy)});
                    return (long) bmy;
                } else if (uu == bJU) {
                    w.i("MicroMsg.Sport.SportService", "saveTime %s saveStep:%s", new Object[]{Long.valueOf(uu), Long.valueOf(uu2)});
                    return (long) ((int) uu2);
                } else {
                    w.i("MicroMsg.Sport.SportService", "getStepCount:0, new day");
                    w.i("MicroMsg.Sport.SportService", "saveTime:%s, cacheTime: %S, beginOfToday:%s", new Object[]{Long.valueOf(uu), Long.valueOf(r8), Long.valueOf(bJU)});
                    return 0;
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.Sport.SportService", e, "exception in :exdevice getTodayDeviceStepCount", new Object[0]);
                return 0;
            }
        }

        public final void Hh(String str) {
            com.tencent.mm.plugin.sport.c.f.Hi(str);
            if (!this.qRM.bmD()) {
                this.qRM.stopSelf();
            }
        }

        public final void bmj() {
        }

        public final void D(int i, long j) {
            ((PluginSport) com.tencent.mm.kernel.h.j(PluginSport.class)).getSportFileStorage().setLong(i, j);
        }

        public final long getLong(int i, long j) {
            return ((PluginSport) com.tencent.mm.kernel.h.j(PluginSport.class)).getSportFileStorage().getLong(i, j);
        }

        public final void bmk() {
            ((PluginSport) com.tencent.mm.kernel.h.j(PluginSport.class)).getSportFileStorage().reset();
            Process.killProcess(Process.myPid());
        }
    };
    private Sensor sensor;

    public void onCreate() {
        super.onCreate();
        w.i("MicroMsg.Sport.SportService", "onCreate");
        this.qRK = k.cR(this);
        w.i("MicroMsg.Sport.SportService", "isSupportDeviceStep %b", new Object[]{Boolean.valueOf(this.qRK)});
        if (this.qRK) {
            bmB();
            return;
        }
        w.i("MicroMsg.Sport.SportService", "stop self");
        stopSelf();
    }

    public IBinder onBind(Intent intent) {
        return this.qRL;
    }

    private boolean bmB() {
        try {
            if (this.hVM == null) {
                this.hVM = (SensorManager) getSystemService("sensor");
            }
            if (this.qRJ == null) {
                this.qRJ = new j();
                this.qRJ.qRI = this;
            }
            if (this.hVM == null || !getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter")) {
                w.i("MicroMsg.Sport.SportService", "no step sensor");
                return false;
            }
            this.sensor = this.hVM.getDefaultSensor(19);
            if (this.sensor == null) {
                w.i("MicroMsg.Sport.SportService", " TYPE_STEP_COUNTER sensor null");
                return false;
            }
            boolean registerListener = this.hVM.registerListener(this.qRJ, this.sensor, com.tencent.mm.plugin.sport.c.f.bmv().optInt("stepCounterRateUs", 60000));
            if (!registerListener) {
                bmC();
            }
            w.i("MicroMsg.Sport.SportService", "registerDetector() ok.(result : %s)", new Object[]{Boolean.valueOf(registerListener)});
            return registerListener;
        } catch (Exception e) {
            w.e("MicroMsg.Sport.SportService", "Exception in registerDetector %s", new Object[]{e.getMessage()});
        }
    }

    private void bmC() {
        try {
            if (this.hVM == null) {
                this.hVM = (SensorManager) getSystemService("sensor");
            }
            this.hVM.unregisterListener(this.qRJ);
            w.i("MicroMsg.Sport.SportService", "unregisterDetector() success!");
        } catch (Exception e) {
            w.e("MicroMsg.Sport.SportService", "Exception in unregisterDetector %s", new Object[]{e.getMessage()});
        }
    }

    public void onDestroy() {
        w.i("MicroMsg.Sport.SportService", "onDestroy");
        if (this.qRK) {
            bmC();
        }
    }

    public final boolean bmD() {
        this.qRK = k.cR(this);
        if (!this.qRK) {
            return false;
        }
        bmC();
        return bmB();
    }

    public final void bmt() {
        bmC();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        w.i("MicroMsg.Sport.SportService", "onStartCommand");
        try {
            if (this.qRK) {
                if (this.qRJ != null) {
                    this.qRJ.qRI = this;
                }
                if (bmD()) {
                    return 1;
                }
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Sport.SportService", e, "Exception onStartCommand %s", new Object[0]);
        }
        return super.onStartCommand(intent, i, i2);
    }
}
