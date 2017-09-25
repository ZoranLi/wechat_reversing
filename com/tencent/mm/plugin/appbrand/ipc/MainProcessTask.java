package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashSet;
import java.util.Set;

public abstract class MainProcessTask implements Parcelable {
    private static final Set<Object> iKx = new HashSet();
    Messenger iKy;
    public String iKz = (Process.myPid() + hashCode());

    public abstract void PM();

    public void SK() {
    }

    public void f(Parcel parcel) {
    }

    public void writeToParcel(Parcel parcel, int i) {
    }

    public int describeContents() {
        return 0;
    }

    public final boolean SL() {
        if (this.iKy == null) {
            return false;
        }
        Message obtain = Message.obtain();
        obtain.setData(AppBrandMainProcessService.a(this, false));
        try {
            this.iKy.send(obtain);
            return true;
        } catch (Exception e) {
            w.e("MicroMsg.MainProcessTask", e.getMessage());
            return false;
        }
    }

    public final void SM() {
        iKx.add(this);
    }

    public final void SN() {
        iKx.remove(this);
    }
}
