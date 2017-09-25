package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.appbrand.media.a;
import com.tencent.mm.sdk.platformtools.bg;
import org.json.JSONObject;

final class JsApiStopRecordVoice extends a {
    public static final int CTRL_INDEX = 32;
    public static final String NAME = "stopRecord";

    private static class StopRecordVoice extends MainProcessTask {
        public static final Creator<StopRecordVoice> CREATOR = new Creator<StopRecordVoice>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new StopRecordVoice();
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StopRecordVoice[i];
            }
        };

        public final void PM() {
            d.vL().D(new Runnable(this) {
                final /* synthetic */ StopRecordVoice iQj;

                {
                    this.iQj = r1;
                }

                public final void run() {
                    a.hX(1);
                }
            });
        }
    }

    JsApiStopRecordVoice() {
    }

    public final void a(m mVar, JSONObject jSONObject, int i) {
        if (d.b(mVar) != null) {
            d.b(mVar).qq(null);
        }
        if (!bg.mA(JsApiStartRecordVoice.iQb)) {
            AppBrandMainProcessService.a(new StopRecordVoice());
        }
        mVar.x(i, d("ok", null));
        JsApiStartRecordVoice.iQb = null;
    }
}
