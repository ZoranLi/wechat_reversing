package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.base.model.d;
import com.tencent.mm.plugin.base.model.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public class AddShortcutTask extends GWMainProcessTask {
    public static final Creator<AddShortcutTask> CREATOR = new Creator<AddShortcutTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AddShortcutTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AddShortcutTask[i];
        }
    };
    public String appId;
    public Runnable iMD;
    public boolean success;
    public String username;

    public final void PM() {
        if (bg.mA(this.appId) || bg.mA(this.username)) {
            w.e("MicroMsg.AddShortcutTask", "appid or username is null");
            this.success = false;
            return;
        }
        d.a(ab.getContext(), this.username, this.appId, new a(this) {
            final /* synthetic */ AddShortcutTask mjo;

            {
                this.mjo = r1;
            }

            public final void cQ(boolean z) {
                this.mjo.success = z;
                this.mjo.SL();
            }
        });
    }

    public final void SK() {
        if (this.iMD != null) {
            this.iMD.run();
        }
    }

    public int describeContents() {
        return 0;
    }

    public final void f(Parcel parcel) {
        boolean z = true;
        this.username = parcel.readString();
        this.appId = parcel.readString();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.success = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.username);
        parcel.writeString(this.appId);
        parcel.writeByte((byte) (this.success ? 1 : 0));
    }

    public AddShortcutTask(Parcel parcel) {
        f(parcel);
    }
}
