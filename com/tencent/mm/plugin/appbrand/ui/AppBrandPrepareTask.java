package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.HandlerThread;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorAction;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;
import java.util.Locale;

public final class AppBrandPrepareTask extends MainProcessTask {
    public static final Creator<AppBrandPrepareTask> CREATOR = new Creator<AppBrandPrepareTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppBrandPrepareTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandPrepareTask[i];
        }
    };
    private String ivH;
    private int jhw;
    private int jiU = 0;
    private int jiV;
    private String jiW;
    private boolean jiX;
    private String jiY;
    private AppBrandLaunchReferrer jiZ;
    private int jis;
    public AppBrandSysConfig jja;
    public AppBrandLaunchErrorAction jjb;
    public volatile transient a jjc;
    private volatile transient WeakReference<MMActivity> jjd;

    public interface a {
        void PD();

        void b(AppBrandSysConfig appBrandSysConfig);
    }

    public AppBrandPrepareTask(MMActivity mMActivity, String str, int i, int i2, int i3, String str2, AppBrandLaunchReferrer appBrandLaunchReferrer) {
        this.jjd = new WeakReference(mMActivity);
        this.ivH = str;
        this.jhw = i;
        this.jiV = i2;
        this.jis = i3;
        this.jiW = str2;
        this.jiZ = appBrandLaunchReferrer;
    }

    public AppBrandPrepareTask(Parcel parcel) {
        f(parcel);
    }

    public final void PM() {
        if (!bg.mA(this.ivH)) {
            d.aN(this);
            HandlerThread Qu = e.Qu(String.format(Locale.US, "AppLaunchPrepareProcess[%s %d]", new Object[]{r0.appId, Integer.valueOf(new com.tencent.mm.plugin.appbrand.launching.e(this, this.ivH, this.jhw, this.jiV, this.jis, this.jiW, this.jiZ) {
                final /* synthetic */ AppBrandPrepareTask jje;

                public final void UV() {
                    this.jje.it(1);
                }

                public final void a(AppBrandSysConfig appBrandSysConfig, AppBrandLaunchErrorAction appBrandLaunchErrorAction) {
                    this.jje.jja = appBrandSysConfig;
                    if (this.jje.jja != null) {
                        AppBrandSysConfig appBrandSysConfig2 = this.jje.jja;
                        h.vG();
                        appBrandSysConfig2.uin = com.tencent.mm.kernel.a.uH();
                    }
                    this.jje.jjb = appBrandLaunchErrorAction;
                    this.jje.it(2);
                }
            }.iPk)}));
            Qu.start();
            new ae(Qu.getLooper()).post(new com.tencent.mm.plugin.appbrand.launching.e.AnonymousClass1(r0, Qu));
        }
    }

    public final void SK() {
        w.i("MicroMsg.AppBrandPrepareTask", "runInClientProcess, event = %d", new Object[]{Integer.valueOf(this.jiU)});
        switch (this.jiU) {
            case 1:
                if (this.jjc != null) {
                    this.jjc.PD();
                    return;
                }
                return;
            case 2:
                if (this.jja == null && this.jjb == null) {
                    g.oUh.a(369, 3, 1, false);
                    com.tencent.mm.plugin.appbrand.report.a.b(this.ivH, 0, this.jhw, 369, 3);
                }
                if (this.jjc != null) {
                    if (this.jja != null) {
                        w.i("MicroMsg.AppBrandPrepareTask", "runInClientProcess, prepare done, appPkg [%d | %s], libPkg [%d | %s]", new Object[]{Integer.valueOf(this.jja.iFk.izW), bg.ev(this.jja.iFk.izX), Integer.valueOf(this.jja.iFl.izW), bg.ev(this.jja.iFl.izX)});
                    } else {
                        w.i("MicroMsg.AppBrandPrepareTask", "runInClientProcess, config null");
                    }
                    this.jjc.b(this.jja);
                    if (!(this.jjb == null || this.jjd == null)) {
                        Context context = (MMActivity) this.jjd.get();
                        if (context != null) {
                            AppBrandLaunchErrorAction appBrandLaunchErrorAction = this.jjb;
                            if (context != null) {
                                if (context.isFinishing() || context.uSW) {
                                    context = new ContextWrapper(context);
                                }
                                appBrandLaunchErrorAction.by(context);
                            }
                        }
                    }
                } else {
                    w.e("MicroMsg.AppBrandPrepareTask", "runInClientProcess, prepare done, but callback is null");
                }
                d.aO(this);
                return;
            default:
                return;
        }
    }

    public final void f(Parcel parcel) {
        this.ivH = parcel.readString();
        this.jhw = parcel.readInt();
        this.jiY = parcel.readString();
        this.jiX = parcel.readByte() != (byte) 0;
        this.jiV = parcel.readInt();
        this.jis = parcel.readInt();
        this.jiU = parcel.readInt();
        this.jiW = parcel.readString();
        this.jiZ = (AppBrandLaunchReferrer) parcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader());
        this.jjb = (AppBrandLaunchErrorAction) parcel.readParcelable(AppBrandLaunchErrorAction.class.getClassLoader());
        this.jja = (AppBrandSysConfig) parcel.readParcelable(AppBrandSysConfig.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.ivH);
        parcel.writeInt(this.jhw);
        parcel.writeString(this.jiY);
        parcel.writeByte(this.jiX ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.jiV);
        parcel.writeInt(this.jis);
        parcel.writeInt(this.jiU);
        parcel.writeString(this.jiW);
        parcel.writeParcelable(this.jiZ, i);
        parcel.writeParcelable(this.jjb, i);
        parcel.writeParcelable(this.jja, i);
    }

    public final void it(int i) {
        this.jiU = i;
        switch (i) {
            case 2:
                d.aO(this);
                break;
        }
        SL();
    }
}
