package com.tencent.mm.plugin.appbrand.performance;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Process;
import android.util.SparseArray;
import android.view.Choreographer.FrameCallback;
import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetStorageInfoTask;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.appbrand.ui.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.q;

@SuppressLint({"DefaultLocale"})
public final class AppBrandPerformanceManager {
    private static SparseArray<a> jeD = new SparseArray();

    private static class a implements Runnable {
        volatile boolean AK = true;
        public final String ivH;
        public volatile double jeF = 0.0d;
        private volatile int jeG = 4;
        volatile boolean jeH = false;
        private c jeI;
        d jeJ;
        com.tencent.mm.plugin.appbrand.performance.d.a jeK = new com.tencent.mm.plugin.appbrand.performance.d.a(this) {
            final /* synthetic */ a jeL;

            {
                this.jeL = r1;
            }

            public final void e(double d) {
                if (Math.round(this.jeL.jeF) != Math.round(d)) {
                    this.jeL.jeF = d;
                    AppBrandPerformanceManager.g(this.jeL.ivH, 303, Math.round(this.jeL.jeF) + " fps");
                    a.a(this.jeL.ivH, "Hardware", "FPS", this.jeL.jeF);
                }
            }
        };

        public a(String str) {
            this.ivH = str;
            this.jeI = new c(Process.myPid());
            if (Wg()) {
                this.jeJ = new d();
                this.jeJ.jfb = 100;
                this.jeJ.jeK = this.jeK;
            }
        }

        static boolean Wg() {
            return VERSION.SDK_INT >= 16;
        }

        public final void run() {
            if (this.AK) {
                double Wh = this.jeI.Wh();
                AppBrandPerformanceManager.g(this.ivH, 101, ((int) Wh) + "%");
                a.a(this.ivH, "Hardware", "CPU", Wh);
                int bKf = bg.bKf();
                AppBrandPerformanceManager.g(this.ivH, 102, bKf + "m");
                a.a(this.ivH, "Hardware", "MEMORY", (double) bKf);
                this.jeG++;
                if (this.jeG >= 4) {
                    this.jeG = 0;
                    final MainProcessTask jsApiGetStorageInfoTask = new JsApiGetStorageInfoTask();
                    jsApiGetStorageInfoTask.appId = this.ivH;
                    jsApiGetStorageInfoTask.iMD = new Runnable(this) {
                        final /* synthetic */ a jeL;

                        public final void run() {
                            AppBrandPerformanceManager.g(this.jeL.ivH, 401, bg.ay((long) jsApiGetStorageInfoTask.size));
                            jsApiGetStorageInfoTask.SN();
                        }
                    };
                    jsApiGetStorageInfoTask.SM();
                    AppBrandMainProcessService.a(jsApiGetStorageInfoTask);
                }
                d.vL().e(this, 3000);
            }
        }
    }

    private static class GetPkgDownloadCostTask extends MainProcessTask {
        public static final Creator<GetPkgDownloadCostTask> CREATOR = new Creator<GetPkgDownloadCostTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                GetPkgDownloadCostTask getPkgDownloadCostTask = new GetPkgDownloadCostTask();
                getPkgDownloadCostTask.f(parcel);
                return getPkgDownloadCostTask;
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetPkgDownloadCostTask[i];
            }
        };
        public String ivH;
        private long jeE;

        public final void PM() {
            w.d("MicroMsg.AppBrandPerformanceManager", "try to get pkg download cost in main process.");
            String str = this.ivH + "_PkgDownloadCost";
            String str2 = c.PV().get(str, null);
            if (str2 != null) {
                c.PV().aL(str, null);
                try {
                    this.jeE = Long.parseLong(str2);
                } catch (Exception e) {
                    w.e("MicroMsg.AppBrandPerformanceManager", "GetPkgDownloadCost error.");
                }
            }
            SL();
        }

        public final void SK() {
            w.d("MicroMsg.AppBrandPerformanceManager", "received pkg download cost from main process: %d ms", new Object[]{Long.valueOf(this.jeE)});
            if (this.jeE != 0) {
                AppBrandPerformanceManager.b(this.ivH, bh.CTRL_INDEX, this.jeE);
            }
            SN();
        }

        public final void f(Parcel parcel) {
            this.ivH = parcel.readString();
            this.jeE = parcel.readLong();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.ivH);
            parcel.writeLong(this.jeE);
        }
    }

    private static class SetAppPerformanceModeTask extends MainProcessTask {
        public static final Creator<SetAppPerformanceModeTask> CREATOR = new Creator<SetAppPerformanceModeTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                SetAppPerformanceModeTask setAppPerformanceModeTask = new SetAppPerformanceModeTask();
                setAppPerformanceModeTask.f(parcel);
                return setAppPerformanceModeTask;
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SetAppPerformanceModeTask[i];
            }
        };
        public String ivH;
        public boolean mEnable;

        public final void PM() {
            c.PV().aL(this.ivH + "_PerformancePanelEnabled", this.mEnable ? "1" : "0");
        }

        public final void f(Parcel parcel) {
            this.ivH = parcel.readString();
            this.mEnable = parcel.readByte() != (byte) 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.ivH);
            parcel.writeByte(this.mEnable ? (byte) 1 : (byte) 0);
        }
    }

    public static final void qx(String str) {
        w.d("MicroMsg.AppBrandPerformanceManager", "startMonitoring, appId: %s", new Object[]{str});
        a aVar = (a) jeD.get(str.hashCode());
        if (aVar == null) {
            aVar = new a(str);
            jeD.put(str.hashCode(), aVar);
        }
        aVar.AK = true;
        d.vL().D(aVar);
        if (a.Wg() && aVar.jeJ != null) {
            FrameCallback frameCallback = aVar.jeJ;
            frameCallback.AK = true;
            frameCallback.jeY.postFrameCallback(frameCallback);
        }
        if (!aVar.jeH) {
            MainProcessTask getPkgDownloadCostTask = new GetPkgDownloadCostTask();
            getPkgDownloadCostTask.ivH = aVar.ivH;
            AppBrandMainProcessService.a(getPkgDownloadCostTask);
            aVar.jeH = true;
        }
    }

    public static final void qy(String str) {
        w.d("MicroMsg.AppBrandPerformanceManager", "stopMonitoring, appId: %s", new Object[]{str});
        a aVar = (a) jeD.get(str.hashCode());
        if (aVar != null) {
            aVar.AK = false;
            if (a.Wg() && aVar.jeJ != null) {
                FrameCallback frameCallback = aVar.jeJ;
                frameCallback.AK = false;
                frameCallback.jeZ = 0;
                frameCallback.jfa = 0;
                frameCallback.jeY.removeFrameCallback(frameCallback);
            }
        }
    }

    public static final void qz(String str) {
        w.d("MicroMsg.AppBrandPerformanceManager", "enablePanel for AppId %s", new Object[]{str});
        MainProcessTask setAppPerformanceModeTask = new SetAppPerformanceModeTask();
        setAppPerformanceModeTask.ivH = str;
        setAppPerformanceModeTask.mEnable = true;
        AppBrandMainProcessService.a(setAppPerformanceModeTask);
    }

    public static final void qA(String str) {
        w.d("MicroMsg.AppBrandPerformanceManager", "disablePanel for AppId %s", new Object[]{str});
        MainProcessTask setAppPerformanceModeTask = new SetAppPerformanceModeTask();
        setAppPerformanceModeTask.ivH = str;
        setAppPerformanceModeTask.mEnable = false;
        AppBrandMainProcessService.a(setAppPerformanceModeTask);
    }

    public static final boolean qB(String str) {
        AppBrandSysConfig mY = b.mY(str);
        if (mY != null && mY.iES && mY.iFk.izV == 1) {
            return true;
        }
        return false;
    }

    public static final void b(String str, int i, long j) {
        g(str, i, String.format("%d ms", new Object[]{Long.valueOf(j)}));
    }

    public static final void g(String str, int i, String str2) {
        e na = b.na(str);
        if (na == null) {
            q.yC().n(str.hashCode() + "performance_data", true).l(String.valueOf(i), str2);
        } else {
            na.D(i, str2);
        }
    }

    public static final void z(String str, String str2, String str3) {
        e na = b.na(str);
        if (na == null) {
            q.yC().n(str.hashCode() + "performance_custom_data", true).l(str2, str3);
        } else {
            na.bi(str2, str3);
        }
    }

    public static final void qC(String str) {
        e na = b.na(str);
        q.b fP = q.yC().fP(str.hashCode() + "performance_data");
        if (na == null) {
            w.e("MicroMsg.AppBrandPerformanceManager", "insertCachedPerformanceData panel is not ready.");
        } else if (fP == null) {
            w.d("MicroMsg.AppBrandPerformanceManager", "insertCachedPerformanceData cache is empty.");
        } else {
            for (String str2 : fP.yD()) {
                String str3 = (String) fP.get(str2);
                if (str3 != null) {
                    na.D(Integer.valueOf(str2).intValue(), str3);
                }
            }
        }
        qD(str);
    }

    private static final void qD(String str) {
        e na = b.na(str);
        q.b fP = q.yC().fP(str.hashCode() + "performance_custom_data");
        if (na == null) {
            w.e("MicroMsg.AppBrandPerformanceManager", "insertCachedCustomData panel is not ready.");
        } else if (fP == null) {
            w.d("MicroMsg.AppBrandPerformanceManager", "insertCachedCustomData cache is empty.");
        } else {
            for (String str2 : fP.yD()) {
                String str3 = (String) fP.get(str2);
                if (str3 != null) {
                    na.bi(str2, str3);
                }
            }
        }
    }

    public static final void aj(String str, int i) {
        c.PV().aL(str + "_PkgDownloadCost", String.valueOf(i));
    }
}
