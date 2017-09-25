package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class GameJsApiGetOpenDeviceId extends a {
    public static final int CTRL_BYTE = 227;
    public static final String NAME = "getOpenDeviceId";

    private static class GetDeviceIdTask extends GWMainProcessTask {
        public static final Creator<GetDeviceIdTask> CREATOR = new Creator<GetDeviceIdTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new GetDeviceIdTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetDeviceIdTask[i];
            }
        };
        public String fwJ;
        public String mkt;

        public final void PM() {
            this.fwJ = p.rA();
            this.mkt = p.rB();
        }

        public final void f(Parcel parcel) {
            this.fwJ = parcel.readString();
            this.mkt = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.fwJ);
            parcel.writeString(this.mkt);
        }

        public GetDeviceIdTask(Parcel parcel) {
            f(parcel);
        }
    }

    public final void a(d dVar, JSONObject jSONObject, int i) {
        w.i("MicroMsg.GameJsApiGetOpenDeviceId", "invoke");
        GWMainProcessTask getDeviceIdTask = new GetDeviceIdTask();
        GameWebViewMainProcessService.b(getDeviceIdTask);
        String azO = dVar.azO();
        if (bg.mA(getDeviceIdTask.fwJ) || bg.mA(getDeviceIdTask.mkt) || bg.mA(azO)) {
            dVar.x(i, a.d("getOpenDeviceId:fail", null));
            return;
        }
        String Pq = aa.Pq(aa.Pq(azO + getDeviceIdTask.fwJ));
        String Pq2 = aa.Pq(aa.Pq(azO + getDeviceIdTask.mkt));
        Map hashMap = new HashMap();
        hashMap.put("deviceid", Pq);
        hashMap.put("newDeviceId", Pq2);
        dVar.x(i, a.d("getOpenDeviceId:ok", hashMap));
    }
}
