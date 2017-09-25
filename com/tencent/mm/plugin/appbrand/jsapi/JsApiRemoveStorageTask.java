package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.plugin.appbrand.appstorage.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

public class JsApiRemoveStorageTask extends MainProcessTask {
    public static final Creator<JsApiRemoveStorageTask> CREATOR = new Creator<JsApiRemoveStorageTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            JsApiRemoveStorageTask jsApiRemoveStorageTask = new JsApiRemoveStorageTask();
            jsApiRemoveStorageTask.f(parcel);
            return jsApiRemoveStorageTask;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiRemoveStorageTask[i];
        }
    };
    public String appId;
    public String arH;

    public final void PM() {
        b PQ = c.PQ();
        if (PQ != null) {
            PQ.aB(this.appId, this.arH);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.arH);
    }

    public final void f(Parcel parcel) {
        this.appId = parcel.readString();
        this.arH = parcel.readString();
    }
}
