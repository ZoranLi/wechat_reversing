package com.tencent.mm.plugin.appbrand.ui;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.launching.c;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

public final class AppBrandPreInitTask extends MainProcessTask {
    public static final Creator<AppBrandPreInitTask> CREATOR = new Creator<AppBrandPreInitTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppBrandPreInitTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandPreInitTask[i];
        }
    };
    private String appId;
    private int iPk;
    private transient a jiQ;
    public AppBrandInitConfig jiR;
    public AppBrandStatObject jiS;

    public interface a {
        void a(AppBrandInitConfig appBrandInitConfig);
    }

    public AppBrandPreInitTask(String str, int i, AppBrandStatObject appBrandStatObject, a aVar) {
        this.appId = str;
        this.iPk = i;
        this.jiS = appBrandStatObject;
        this.jiQ = aVar;
    }

    public final void SK() {
        if (this.jiQ != null) {
            this.jiQ.a(this.jiR);
        }
        SN();
    }

    public final void PM() {
        d.vL().D(new c(this.appId, this.iPk, this.jiS, new com.tencent.mm.plugin.appbrand.launching.c.a(this) {
            final /* synthetic */ AppBrandPreInitTask jiT;

            {
                this.jiT = r1;
            }

            public final void b(AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
                this.jiT.jiR = appBrandInitConfig;
                this.jiT.jiS = appBrandStatObject;
                this.jiT.SL();
            }
        }));
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeInt(this.iPk);
        parcel.writeParcelable(this.jiR, i);
        parcel.writeParcelable(this.jiS, i);
    }

    public final void f(Parcel parcel) {
        this.appId = parcel.readString();
        this.iPk = parcel.readInt();
        this.jiR = (AppBrandInitConfig) parcel.readParcelable(AppBrandInitConfig.class.getClassLoader());
        this.jiS = (AppBrandStatObject) parcel.readParcelable(AppBrandStatObject.class.getClassLoader());
    }

    public AppBrandPreInitTask(Parcel parcel) {
        f(parcel);
    }
}
