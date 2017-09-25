package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.e.a.gl;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class GameJsApiOperateGameCenterMsg extends a {
    public static final int CTRL_BYTE = 174;
    public static final String NAME = "operateGameCenterMsg";

    private static class OperateGameCenterMsgTask extends GWMainProcessTask {
        public static Creator<OperateGameCenterMsgTask> CREATOR = new Creator<OperateGameCenterMsgTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new OperateGameCenterMsgTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new OperateGameCenterMsgTask[i];
            }
        };
        public String fLE;
        public Runnable iMD;
        public int ou;
        public String result;

        public final void PM() {
            b glVar = new gl();
            glVar.fLJ.ou = this.ou;
            glVar.fLJ.fLE = this.fLE;
            com.tencent.mm.sdk.b.a.urY.m(glVar);
            this.result = glVar.fLK.fLL;
            SL();
        }

        public final void SK() {
            if (this.iMD != null) {
                this.iMD.run();
            }
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

        public OperateGameCenterMsgTask(Parcel parcel) {
            f(parcel);
        }
    }

    public final void a(final d dVar, JSONObject jSONObject, final int i) {
        String str = null;
        w.i("MicroMsg.GameJsApiOperateGameCenterMsg", "invoke");
        if (jSONObject == null) {
            w.i("MicroMsg.GameJsApiOperateGameCenterMsg", "data is null");
            dVar.x(i, a.d("getGameMessages:fail_invalid_data", null));
            return;
        }
        int optInt = jSONObject.optInt("cmd");
        JSONObject optJSONObject = jSONObject.optJSONObject("param");
        final GWMainProcessTask operateGameCenterMsgTask = new OperateGameCenterMsgTask();
        operateGameCenterMsgTask.ou = optInt;
        if (optJSONObject != null) {
            str = optJSONObject.toString();
        }
        operateGameCenterMsgTask.fLE = str;
        operateGameCenterMsgTask.iMD = new Runnable(this) {
            final /* synthetic */ GameJsApiOperateGameCenterMsg mkM;

            public final void run() {
                operateGameCenterMsgTask.SN();
                Map hashMap = new HashMap();
                hashMap.put("result", bg.mz(operateGameCenterMsgTask.result));
                dVar.x(i, a.d("getGameMessages:ok", hashMap));
            }
        };
        operateGameCenterMsgTask.SM();
        GameWebViewMainProcessService.a(operateGameCenterMsgTask);
    }
}
