package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.e.a.gi;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class GameJsApiGetGameCommInfo extends a {
    public static final int CTRL_BYTE = 241;
    public static final String NAME = "getGameCommInfo";

    private static class GetGameCommInfoTask extends GWMainProcessTask {
        public static final Creator<GetGameCommInfoTask> CREATOR = new Creator<GetGameCommInfoTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new GetGameCommInfoTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetGameCommInfoTask[i];
            }
        };
        public String fLE;
        public int ou;
        public String result;

        public final void PM() {
            b giVar = new gi();
            giVar.fLC.ou = this.ou;
            giVar.fLC.fLE = this.fLE;
            giVar.fLC.context = ab.getContext();
            com.tencent.mm.sdk.b.a.urY.m(giVar);
            this.result = giVar.fLD.result;
        }

        public final void f(Parcel parcel) {
            this.ou = parcel.readInt();
            this.fLE = parcel.readString();
            this.result = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.ou);
            parcel.writeString(this.fLE);
            parcel.writeString(this.result);
        }

        public GetGameCommInfoTask(Parcel parcel) {
            f(parcel);
        }
    }

    public final void a(d dVar, JSONObject jSONObject, int i) {
        w.i("MicroMsg.GameJsApiGetGameCommInfo", "invoke");
        if (jSONObject == null) {
            w.e("MicroMsg.GameJsApiGetGameCommInfo", "data is null");
            dVar.x(i, a.d("getGameCommInfo:fail_invalid_data", null));
            return;
        }
        GWMainProcessTask getGameCommInfoTask = new GetGameCommInfoTask();
        getGameCommInfoTask.ou = jSONObject.optInt("cmd", 0);
        getGameCommInfoTask.fLE = jSONObject.optString("param");
        GameWebViewMainProcessService.b(getGameCommInfoTask);
        Map hashMap = new HashMap();
        hashMap.put("gameRegionName", getGameCommInfoTask.result);
        dVar.x(i, a.d("getGameCommInfo:ok", hashMap));
    }
}
