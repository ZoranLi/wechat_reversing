package com.tencent.mm.plugin.game.gamewebview.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;

public class GameJsApiMMTask extends GWMainProcessTask {
    public static final Creator<GameJsApiMMTask> CREATOR = new Creator<GameJsApiMMTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new GameJsApiMMTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GameJsApiMMTask[i];
        }
    };
    public int iMH;
    public d mjK;
    public String mjL;
    public String mjM;
    public String mjN;

    public interface a {
        void pq(String str);
    }

    public final void PM() {
        Map azm = d.azm();
        if (azm != null) {
            c cVar = (c) azm.get(this.mjM);
            if (!(cVar instanceof e)) {
                ((a) cVar).a(ab.getContext(), this.mjL, new a(this) {
                    final /* synthetic */ GameJsApiMMTask mjT;

                    {
                        this.mjT = r1;
                    }

                    public final void pq(String str) {
                        this.mjT.mjN = str;
                        this.mjT.SL();
                    }
                });
            }
        }
    }

    public final void SK() {
        SN();
        if (this.mjK != null) {
            this.mjK.x(this.iMH, this.mjN);
        }
    }

    public final void f(Parcel parcel) {
        this.mjL = parcel.readString();
        this.mjM = parcel.readString();
        this.mjN = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mjL);
        parcel.writeString(this.mjM);
        parcel.writeString(this.mjN);
    }

    public GameJsApiMMTask(Parcel parcel) {
        f(parcel);
    }
}
