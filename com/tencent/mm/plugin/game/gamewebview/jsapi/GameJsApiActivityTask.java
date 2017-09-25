package com.tencent.mm.plugin.game.gamewebview.jsapi;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Map;

public class GameJsApiActivityTask extends GameProcessActivityTask {
    public static final Creator<GameJsApiActivityTask> CREATOR = new Creator<GameJsApiActivityTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new GameJsApiActivityTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GameJsApiActivityTask[i];
        }
    };
    public int iMH;
    public d mjK;
    public String mjL;
    public String mjM;
    public String mjN;

    public final void a(Context context, final a aVar) {
        w.i("MicroMsg.GameJsApiActivityTask", "runInMainProcess, apiName = %s", new Object[]{this.mjM});
        Map azm = d.azm();
        if (azm != null) {
            c cVar = (c) azm.get(this.mjM);
            if (!(cVar instanceof e)) {
                ((a) cVar).a(context, this.mjL, new GameJsApiMMTask.a(this) {
                    final /* synthetic */ GameJsApiActivityTask mjO;

                    public final void pq(String str) {
                        this.mjO.mjN = str;
                        aVar.TP();
                    }
                });
            }
        }
    }

    public final void SK() {
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

    public GameJsApiActivityTask(Context context) {
        super(context);
    }

    public GameJsApiActivityTask(Parcel parcel) {
        f(parcel);
    }
}
