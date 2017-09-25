package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.e.a.ev;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class JsApiStopPlayVoice extends a {
    public static final int CTRL_INDEX = 35;
    public static final String NAME = "stopVoice";

    private static class StopPlayVoice extends MainProcessTask {
        public static final Creator<StopPlayVoice> CREATOR = new Creator<StopPlayVoice>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new StopPlayVoice();
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StopPlayVoice[i];
            }
        };

        public final void PM() {
            af.v(new Runnable(this) {
                final /* synthetic */ StopPlayVoice iQi;

                {
                    this.iQi = r1;
                }

                public final void run() {
                    b evVar = new ev();
                    evVar.fJa.op = 2;
                    a.urY.m(evVar);
                }
            });
        }
    }

    public final void a(m mVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("localId");
        w.i("MicroMsg.JsApiStopPlayVoice", "doStopVoice, appId : %s, localId : %s", new Object[]{mVar.ivH, optString});
        AppBrandMainProcessService.a(new StopPlayVoice());
        mVar.x(i, d("ok", null));
        JsApiStartPlayVoice.iPW = null;
    }

    public static void Tk() {
        if (!bg.mA(JsApiStartPlayVoice.iPW)) {
            AppBrandMainProcessService.a(new StopPlayVoice());
            JsApiStartPlayVoice.iPW = null;
        }
    }
}
