package com.tencent.mm.plugin.appbrand;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.report.service.g;

public class ReportStorageSizeTask extends MainProcessTask {
    public static final Creator<ReportStorageSizeTask> CREATOR = new Creator<ReportStorageSizeTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            ReportStorageSizeTask reportStorageSizeTask = new ReportStorageSizeTask();
            reportStorageSizeTask.f(parcel);
            return reportStorageSizeTask;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ReportStorageSizeTask[i];
        }
    };
    public String appId;

    public final void PM() {
        if (c.PQ() != null) {
            g.oUh.i(14073, new Object[]{this.appId, "", "", r0.nI(this.appId)[1], Long.valueOf(com.tencent.mm.plugin.appbrand.appstorage.c.nN(this.appId)), Long.valueOf(com.tencent.mm.plugin.appbrand.appstorage.c.nO(this.appId))});
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
    }

    public final void f(Parcel parcel) {
        this.appId = parcel.readString();
    }
}
