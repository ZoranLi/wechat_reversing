package com.tencent.mm.plugin.webview.wepkg.model;

import android.os.Parcel;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessTask;

public abstract class BaseWepkgProcessTask extends WepkgMainProcessTask {
    public boolean fDU = false;

    public abstract void k(Parcel parcel);

    public abstract void v(Parcel parcel, int i);

    public final void f(Parcel parcel) {
        this.fDU = parcel.readByte() != (byte) 0;
        k(parcel);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (this.fDU ? 1 : 0));
        v(parcel, i);
    }
}
