package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ax.a;
import com.tencent.mm.sdk.platformtools.w;

public class GameKeepPageTopTask extends GWMainProcessTask {
    public static final Creator<GameKeepPageTopTask> CREATOR = new Creator<GameKeepPageTopTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new GameKeepPageTopTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GameKeepPageTopTask[i];
        }
    };
    public boolean mjr;
    public String title;
    public int type;
    public String url;
    public String username;

    public final void PM() {
        w.i("MicroMsg.GameKeepPageTopTask", "type = " + this.type);
        a aVar;
        switch (this.type) {
            case 1:
                aVar = a.idS;
                this.mjr = a.LZ();
                aVar = a.idS;
                this.url = a.Ma();
                return;
            case 2:
                aVar = a.idS;
                a.p(this.url, this.title, this.username);
                return;
            default:
                return;
        }
    }

    public final void f(Parcel parcel) {
        boolean z = true;
        this.type = parcel.readInt();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.mjr = z;
        this.url = parcel.readString();
        this.title = parcel.readString();
        this.username = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeByte((byte) (this.mjr ? 1 : 0));
        parcel.writeString(this.url);
        parcel.writeString(this.title);
        parcel.writeString(this.username);
    }

    public int describeContents() {
        return 0;
    }

    public GameKeepPageTopTask(Parcel parcel) {
        f(parcel);
    }
}
