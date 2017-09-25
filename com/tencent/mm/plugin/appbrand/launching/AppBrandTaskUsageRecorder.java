package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.c.bpp;
import com.tencent.mm.protocal.c.bqp;
import com.tencent.mm.protocal.c.bqv;

public final class AppBrandTaskUsageRecorder {

    private static final class LaunchCheckParams implements Parcelable {
        public static final Creator<LaunchCheckParams> CREATOR = new Creator<LaunchCheckParams>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new LaunchCheckParams(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new LaunchCheckParams[i];
            }
        };
        final AppBrandInitConfig iZv;
        final AppBrandStatObject iZw;
        final boolean iZx = true;
        final int izW;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.iZv, i);
            parcel.writeParcelable(this.iZw, i);
            parcel.writeInt(this.izW);
        }

        public LaunchCheckParams(AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject, int i) {
            this.iZv = appBrandInitConfig;
            this.iZw = appBrandStatObject;
            this.izW = i;
        }

        LaunchCheckParams(Parcel parcel) {
            this.iZv = (AppBrandInitConfig) parcel.readParcelable(AppBrandInitConfig.class.getClassLoader());
            this.iZw = (AppBrandStatObject) parcel.readParcelable(AppBrandStatObject.class.getClassLoader());
            this.izW = parcel.readInt();
        }
    }

    private static final class UpdateTask extends MainProcessTask {
        public static final Creator<UpdateTask> CREATOR = new Creator<UpdateTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new UpdateTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new UpdateTask[i];
            }
        };
        LaunchCheckParams iZy;

        public final void PM() {
            bqp com_tencent_mm_protocal_c_bqp;
            bqv com_tencent_mm_protocal_c_bqv = null;
            this.iZy.getClass();
            AppBrandLaunchReferrer appBrandLaunchReferrer = this.iZy.iZv.iEK;
            if (appBrandLaunchReferrer == null || 1 != appBrandLaunchReferrer.iEL) {
                com_tencent_mm_protocal_c_bqp = null;
            } else {
                com_tencent_mm_protocal_c_bqp = new bqp();
                com_tencent_mm_protocal_c_bqp.tLD = appBrandLaunchReferrer.appId;
            }
            if (appBrandLaunchReferrer != null && 2 == appBrandLaunchReferrer.iEL) {
                com_tencent_mm_protocal_c_bqv = new bqv();
                com_tencent_mm_protocal_c_bqv.teQ = appBrandLaunchReferrer.appId;
                com_tencent_mm_protocal_c_bqv.msN = appBrandLaunchReferrer.url;
            }
            bpp com_tencent_mm_protocal_c_bpp = new bpp();
            com_tencent_mm_protocal_c_bpp.tLJ = this.iZy.iZv.izM;
            com_tencent_mm_protocal_c_bpp.tkv = this.iZy.izW;
            com_tencent_mm_protocal_c_bpp.tdM = this.iZy.iZw.scene;
            com_tencent_mm_protocal_c_bpp.tOg = this.iZy.iZv.iEI;
            com_tencent_mm_protocal_c_bpp.tOf = 1;
            com_tencent_mm_protocal_c_bpp.tOe = this.iZy.iZw.fWL;
            new f(this.iZy.iZv.appId, false, com_tencent_mm_protocal_c_bpp, com_tencent_mm_protocal_c_bqv, com_tencent_mm_protocal_c_bqp).UZ();
        }

        public UpdateTask(LaunchCheckParams launchCheckParams) {
            this.iZy = launchCheckParams;
        }

        UpdateTask(Parcel parcel) {
            f(parcel);
        }

        public final int describeContents() {
            return 0;
        }

        public final void f(Parcel parcel) {
            this.iZy = (LaunchCheckParams) parcel.readParcelable(LaunchCheckParams.class.getClassLoader());
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.iZy, i);
        }
    }
}
