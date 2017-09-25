package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class BindServiceTask extends GWMainProcessTask {
    public static final Creator<BindServiceTask> CREATOR = new Creator<BindServiceTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BindServiceTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BindServiceTask[i];
        }
    };
    public Runnable iMD;

    public final void PM() {
        SL();
    }

    public final void SK() {
        if (this.iMD != null) {
            this.iMD.run();
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
    }

    public final void f(Parcel parcel) {
    }

    public BindServiceTask(Parcel parcel) {
    }
}
