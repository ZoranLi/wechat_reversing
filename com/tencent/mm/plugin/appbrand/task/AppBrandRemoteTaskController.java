package com.tencent.mm.plugin.appbrand.task;

import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Process;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import junit.framework.Assert;

public class AppBrandRemoteTaskController extends MainProcessTask {
    public static final Creator<AppBrandRemoteTaskController> CREATOR = new Creator<AppBrandRemoteTaskController>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppBrandRemoteTaskController appBrandRemoteTaskController = new AppBrandRemoteTaskController();
            appBrandRemoteTaskController.f(parcel);
            return appBrandRemoteTaskController;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandRemoteTaskController[i];
        }
    };
    private static long jhB;
    public String ivH;
    public b iwM = null;
    public c iwY = null;
    public long jhA;
    public int jhw;
    public String jhx;
    public int jhy = a.jhD;
    public int jhz;

    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] jhC = new int[a.WF().length];

        static {
            try {
                jhC[a.jhE - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                jhC[a.jhF - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                jhC[a.jhG - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                jhC[a.jhI - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                jhC[a.jhM - 1] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                jhC[a.jhN - 1] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                jhC[a.jhH - 1] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                jhC[a.jhJ - 1] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                jhC[a.jhL - 1] = 9;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    private enum a {
        ;

        public static int[] WF() {
            return (int[]) jhO.clone();
        }

        static {
            jhD = 1;
            jhE = 2;
            jhF = 3;
            jhG = 4;
            jhH = 5;
            jhI = 6;
            jhJ = 7;
            jhK = 8;
            jhL = 9;
            jhM = 10;
            jhN = 11;
            jhO = new int[]{jhD, jhE, jhF, jhG, jhH, jhI, jhJ, jhK, jhL, jhM, jhN};
        }
    }

    public interface b {
        void finish();
    }

    public interface c {
        void a(AppBrandRemoteTaskController appBrandRemoteTaskController);

        void finish();
    }

    public final void am(String str, int i) {
        this.jhy = a.jhE;
        this.ivH = str;
        this.jhw = i;
        AppBrandMainProcessService.a((MainProcessTask) this);
    }

    final void qH(String str) {
        this.jhy = a.jhG;
        this.ivH = str;
        WE();
        SL();
    }

    public final void PM() {
        switch (AnonymousClass2.jhC[this.jhy - 1]) {
            case 1:
                WD();
                synchronized (AppBrandRemoteTaskController.class) {
                    if (jhB == 0) {
                        long currentTimeMillis = System.currentTimeMillis();
                        jhB = currentTimeMillis;
                        Editor edit = MultiProcessSharedPreferences.getSharedPreferences(ab.getContext(), "pref_appbrand_process", 4).edit();
                        edit.putLong("on_wxa_process_connected_time", currentTimeMillis);
                        edit.commit();
                        w.v("MicroMsg.AppBrandReporter", "update timestamp(%s)", new Object[]{Long.valueOf(currentTimeMillis)});
                    }
                    this.jhA = jhB;
                }
                SL();
                return;
            case 2:
                WD();
                return;
            case 3:
                WE();
                return;
            case 4:
                b.ir(this.jhz);
                return;
            case 5:
                b.qI(this.ivH);
                return;
            case 6:
                b.WG();
                return;
            default:
                return;
        }
    }

    private void WD() {
        c qL = b.qL(this.jhx);
        if (qL != null) {
            qL.a(this.ivH, this.jhw, this);
            b.a(qL);
        }
    }

    private void WE() {
        if (b.bf(this.ivH, this.jhx) != null) {
            b.qN(this.ivH);
        }
    }

    public final void SK() {
        switch (AnonymousClass2.jhC[this.jhy - 1]) {
            case 3:
                this.iwM.finish();
                return;
            case 7:
                switch (this.jhz) {
                    case 0:
                        com.tencent.mm.modelappbrand.b.gI(ab.um());
                        this.iwY.finish();
                        Process.killProcess(Process.myPid());
                        return;
                    case 1:
                        this.iwY.a(this);
                        return;
                    default:
                        return;
                }
            case 8:
                Assert.assertTrue("AppBrand Test Assert", false);
                return;
            case 9:
                i.onNetworkChange();
                return;
            default:
                return;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.ivH);
        parcel.writeInt(this.jhw);
        parcel.writeString(this.jhx);
        parcel.writeInt(this.jhy == 0 ? -1 : this.jhy - 1);
        parcel.writeInt(this.jhz);
        parcel.writeLong(this.jhA);
    }

    public final void f(Parcel parcel) {
        this.ivH = parcel.readString();
        this.jhw = parcel.readInt();
        this.jhx = parcel.readString();
        int readInt = parcel.readInt();
        this.jhy = readInt == -1 ? 0 : a.WF()[readInt];
        this.jhz = parcel.readInt();
        this.jhA = parcel.readLong();
    }
}
