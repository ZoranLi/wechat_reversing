package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

class JsApiGetContactMessageCountTask extends MainProcessTask {
    public static final Creator<JsApiGetContactMessageCountTask> CREATOR = new Creator<JsApiGetContactMessageCountTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new JsApiGetContactMessageCountTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiGetContactMessageCountTask[i];
        }
    };
    public int fCK;
    public Runnable iMD;
    public String username;

    public JsApiGetContactMessageCountTask(Parcel parcel) {
        f(parcel);
    }

    public final void PM() {
        ap.yY();
        aj Rm = c.wW().Rm(this.username);
        if (Rm == null) {
            this.fCK = -1;
            SL();
            return;
        }
        this.fCK = Rm.field_unReadCount;
        SL();
    }

    public final void SK() {
        if (this.iMD != null) {
            this.iMD.run();
        }
    }

    public final void f(Parcel parcel) {
        this.username = parcel.readString();
        this.fCK = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.username);
        parcel.writeInt(this.fCK);
    }
}
