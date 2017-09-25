package com.tencent.mm.plugin.webview.wepkg.ipc;

import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashSet;
import java.util.Set;

public abstract class WepkgMainProcessTask implements Parcelable {
    private static final Set<Object> iKx = new HashSet();
    Messenger iKy;
    int mTaskId;

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

    public final void vM() {
        if (this.iKy != null) {
            Message obtain = Message.obtain();
            obtain.what = this.mTaskId;
            obtain.setData(WepkgMainProcessService.c(this));
            try {
                this.iKy.send(obtain);
            } catch (Exception e) {
                w.e("MicroMsg.Wepkg.WepkgMainProcessTask", e.getMessage());
            }
        }
    }

    public final void SM() {
        iKx.add(this);
    }

    public final void SN() {
        iKx.remove(this);
    }
}
