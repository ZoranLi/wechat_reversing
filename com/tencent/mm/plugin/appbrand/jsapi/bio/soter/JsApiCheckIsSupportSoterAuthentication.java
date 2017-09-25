package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.e.a.he;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiCheckIsSupportSoterAuthentication extends a {
    public static final int CTRL_INDEX = 276;
    public static final String NAME = "checkIsSupportSoterAuthentication";
    private GetIsSupportSoterTask iRz = null;

    private static class GetIsSupportSoterTask extends MainProcessTask {
        public static final Creator<GetIsSupportSoterTask> CREATOR = new Creator<GetIsSupportSoterTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new GetIsSupportSoterTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetIsSupportSoterTask[i];
            }
        };
        private int iLf = -1;
        private JsApiCheckIsSupportSoterAuthentication iRA;
        private int iRB = 0;
        private m iwq = null;

        public final void SK() {
            super.SK();
            w.d("MicroMsg.GetIsSupportSoterTask", "hy: callback. supportMode: %d", new Object[]{Integer.valueOf(this.iRB)});
            Map hashMap = new HashMap(2);
            hashMap.put("supportMode", a.hM(this.iRB));
            this.iwq.x(this.iLf, this.iRA.d("ok", hashMap));
            d.aO(this);
        }

        public final void PM() {
            b heVar = new he();
            com.tencent.mm.sdk.b.a.urY.m(heVar);
            this.iRB = heVar.fME.fMF;
            w.i("MicroMsg.GetIsSupportSoterTask", "hy: supportMode: %d", new Object[]{Integer.valueOf(this.iRB)});
            SL();
        }

        public GetIsSupportSoterTask(m mVar, int i, JsApiCheckIsSupportSoterAuthentication jsApiCheckIsSupportSoterAuthentication) {
            this.iwq = mVar;
            this.iLf = i;
            this.iRA = jsApiCheckIsSupportSoterAuthentication;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.iRB);
        }

        protected GetIsSupportSoterTask(Parcel parcel) {
            f(parcel);
        }

        public final void f(Parcel parcel) {
            super.f(parcel);
            this.iRB = parcel.readInt();
        }
    }

    public final void a(m mVar, JSONObject jSONObject, int i) {
        w.i("MicroMsg.JsApiCheckIsSupportSoterAuthentication", "hy: subapp start do check is support soter authentication");
        this.iRz = new GetIsSupportSoterTask(mVar, i, this);
        d.aN(this.iRz);
        AppBrandMainProcessService.a(this.iRz);
    }
}
