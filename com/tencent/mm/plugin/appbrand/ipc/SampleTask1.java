package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.w;

public class SampleTask1 extends MainProcessTask {
    public static final Creator<SampleTask1> CREATOR = new Creator<SampleTask1>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SampleTask1(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SampleTask1[i];
        }
    };
    public String iKA;
    public String iKB;

    public SampleTask1(Parcel parcel) {
        f(parcel);
    }

    public final void PM() {
        w.e("SampleTask", this.iKA);
        this.iKB = "String from Main Process";
        SL();
    }

    public final void SK() {
        w.e("SampleTask", this.iKB);
    }

    public final void f(Parcel parcel) {
        this.iKA = parcel.readString();
        this.iKB = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.iKA);
        parcel.writeString(this.iKB);
    }
}
