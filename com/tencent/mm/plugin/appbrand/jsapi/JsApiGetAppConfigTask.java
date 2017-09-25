package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.config.k.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

class JsApiGetAppConfigTask extends MainProcessTask {
    public static final Creator<JsApiGetAppConfigTask> CREATOR = new Creator<JsApiGetAppConfigTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new JsApiGetAppConfigTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiGetAppConfigTask[i];
        }
    };
    public String appId;
    public String arH;
    public Runnable iMD;
    public int type;
    public String value;

    public JsApiGetAppConfigTask(Parcel parcel) {
        f(parcel);
    }

    public final void PM() {
        k.a(this.appId, this.type, 0, new c(this) {
            final /* synthetic */ JsApiGetAppConfigTask iME;

            {
                this.iME = r1;
            }

            public final void nE(String str) {
                this.iME.value = str;
                this.iME.SL();
            }
        }, true);
    }

    public final void SK() {
        if (this.iMD != null) {
            this.iMD.run();
        }
    }

    public final void f(Parcel parcel) {
        this.appId = parcel.readString();
        this.arH = parcel.readString();
        this.value = parcel.readString();
        this.type = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.arH);
        parcel.writeString(this.value);
        parcel.writeInt(this.type);
    }
}
