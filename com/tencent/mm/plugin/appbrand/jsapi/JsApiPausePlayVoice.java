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
import org.json.JSONObject;

public final class JsApiPausePlayVoice extends a {
    public static final int CTRL_INDEX = 34;
    public static final String NAME = "pauseVoice";
    private PausePlayVoice iPe;

    private static class PausePlayVoice extends MainProcessTask {
        public static final Creator<PausePlayVoice> CREATOR = new Creator<PausePlayVoice>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                PausePlayVoice pausePlayVoice = new PausePlayVoice();
                pausePlayVoice.f(parcel);
                return pausePlayVoice;
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new PausePlayVoice[i];
            }
        };

        public final void PM() {
            af.v(new Runnable(this) {
                final /* synthetic */ PausePlayVoice iPf;

                {
                    this.iPf = r1;
                }

                public final void run() {
                    b evVar = new ev();
                    evVar.fJa.op = 4;
                    a.urY.m(evVar);
                }
            });
        }
    }

    public final void a(m mVar, JSONObject jSONObject, int i) {
        this.iPe = new PausePlayVoice();
        AppBrandMainProcessService.a(this.iPe);
        mVar.x(i, d("ok", null));
    }
}
