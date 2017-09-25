package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.game.gamewebview.b.a.a;
import com.tencent.mm.plugin.game.gamewebview.b.a.c;
import com.tencent.mm.plugin.game.gamewebview.b.a.d;
import com.tencent.mm.plugin.game.gamewebview.b.a.e;
import com.tencent.mm.plugin.game.gamewebview.b.b;
import com.tencent.mm.plugin.game.gamewebview.ui.i;
import com.tencent.mm.plugin.game.gamewebview.ui.i.AnonymousClass3;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;

public class GameMMToClientEvent extends GWMainProcessTask {
    public static Creator<GameMMToClientEvent> CREATOR = new Creator<GameMMToClientEvent>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new GameMMToClientEvent(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GameMMToClientEvent[i];
        }
    };
    private static GameMMToClientEvent mjt;
    private int iKo;
    private String iKp;
    public Object iKq;
    public Bundle lHw;
    int mjs;

    private static GameMMToClientEvent azh() {
        if (mjt == null) {
            synchronized (GameMMToClientEvent.class) {
                if (mjt == null) {
                    mjt = new GameMMToClientEvent();
                }
            }
        }
        return mjt;
    }

    public static void np(int i) {
        azh().iKo = 1;
        azh().mjs = i;
        GameWebViewMainProcessService.a(azh());
    }

    public static void nq(int i) {
        azh().iKo = 2;
        azh().mjs = i;
        GameWebViewMainProcessService.a(azh());
    }

    public final void PM() {
        switch (this.iKo) {
            case 1:
                a.a(this.mjs, this);
                return;
            case 2:
                a.nr(this.mjs);
                return;
            default:
                return;
        }
    }

    public final void SK() {
        int i = this.lHw.getInt("mm_to_client_notify_type");
        w.i("MicroMsg.GameMMToClientEvent", "notifyType = " + i);
        switch (i) {
            case 1:
                String string = this.lHw.getString("js_event_name");
                if (!bg.mA(string)) {
                    if (b.mls == null || b.mls.size() == 0) {
                        b.mls = new HashMap();
                        b.a(new c());
                        b.a(new com.tencent.mm.plugin.game.gamewebview.b.a.b());
                        b.a(new e());
                        b.a(new d());
                        b.a(new a());
                    }
                    com.tencent.mm.plugin.game.gamewebview.b.a aVar = (com.tencent.mm.plugin.game.gamewebview.b.a) b.mls.get(string);
                    if (aVar != null) {
                        aVar.i(this.mjs, this.lHw);
                        return;
                    }
                    return;
                }
                return;
            case 2:
                com.tencent.mm.plugin.game.gamewebview.ui.d ns = com.tencent.mm.plugin.game.gamewebview.model.a.ns(this.mjs);
                if (ns != null) {
                    String string2 = this.lHw.getString("file_path");
                    String string3 = this.lHw.getString("result");
                    int i2 = this.lHw.getInt("code_type");
                    int i3 = this.lHw.getInt("code_version");
                    if (ns.mmX != null) {
                        i iVar = ns.mmX;
                        w.d("MicroMsg.GameWebViewMenuListHelper", "result: " + string3);
                        if (iVar.iYM != null && string2 != null && string2.equals(iVar.iYM.rZF)) {
                            if (iVar.iYM != null) {
                                iVar.iYM.bxd();
                            }
                            iVar.iYK = i2;
                            iVar.iYL = i3;
                            if (string3 != null && iVar.iYI != null) {
                                new ae().post(new AnonymousClass3(iVar, string3));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void f(Parcel parcel) {
        this.iKo = parcel.readInt();
        this.mjs = parcel.readInt();
        this.lHw = parcel.readBundle(getClass().getClassLoader());
        try {
            this.iKp = parcel.readString();
            if (!bg.mA(this.iKp)) {
                Class cls = Class.forName(this.iKp);
                if (cls != null) {
                    this.iKq = parcel.readParcelable(cls.getClassLoader());
                }
            }
        } catch (Exception e) {
            w.e("MicroMsg.GameMMToClientEvent", "can't parcel data ex: " + e.getMessage());
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.iKo);
        parcel.writeInt(this.mjs);
        parcel.writeBundle(this.lHw);
        if (!bg.mA(this.iKp) && this.iKq != null) {
            parcel.writeString(this.iKp);
            parcel.writeParcelable((Parcelable) this.iKq, i);
        }
    }

    public int describeContents() {
        return 0;
    }

    public GameMMToClientEvent(Parcel parcel) {
        f(parcel);
    }
}
