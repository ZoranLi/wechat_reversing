package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.plugin.appbrand.appstorage.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import java.util.ArrayList;

public class JsApiGetStorageInfoTask extends MainProcessTask {
    public static final Creator<JsApiGetStorageInfoTask> CREATOR = new Creator<JsApiGetStorageInfoTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            JsApiGetStorageInfoTask jsApiGetStorageInfoTask = new JsApiGetStorageInfoTask();
            jsApiGetStorageInfoTask.f(parcel);
            return jsApiGetStorageInfoTask;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiGetStorageInfoTask[i];
        }
    };
    public int aIo;
    public String appId;
    public Runnable iMD;
    public ArrayList<String> iOf;
    public int size;

    public final void PM() {
        b PQ = c.PQ();
        if (PQ == null) {
            SL();
            return;
        }
        Object[] nI = PQ.nI(this.appId);
        this.iOf = (ArrayList) nI[0];
        this.size = (int) Math.ceil(((Integer) nI[1]).doubleValue() / 1000.0d);
        this.aIo = (int) Math.ceil(((Integer) nI[2]).doubleValue() / 1000.0d);
        SL();
    }

    public final void SK() {
        if (this.iMD != null) {
            this.iMD.run();
        }
    }

    public final void f(Parcel parcel) {
        this.appId = parcel.readString();
        this.iOf = parcel.createStringArrayList();
        this.size = parcel.readInt();
        this.aIo = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeStringList(this.iOf);
        parcel.writeInt(this.size);
        parcel.writeInt(this.aIo);
    }
}
