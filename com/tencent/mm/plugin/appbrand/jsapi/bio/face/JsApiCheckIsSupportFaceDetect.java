package com.tencent.mm.plugin.appbrand.jsapi.bio.face;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.e.a.hd;
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

public final class JsApiCheckIsSupportFaceDetect extends a {
    public static final int CTRL_INDEX = 214;
    public static final String NAME = "checkIsSupportFacialRecognition";
    private GetIsSupportFaceTask iRr = null;

    private static class GetIsSupportFaceTask extends MainProcessTask {
        public static final Creator<GetIsSupportFaceTask> CREATOR = new Creator<GetIsSupportFaceTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new GetIsSupportFaceTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetIsSupportFaceTask[i];
            }
        };
        private int errCode = -1;
        private String fPf = "not returned";
        private boolean fXh = false;
        private int iLf = -1;
        private JsApiCheckIsSupportFaceDetect iRs;
        private int iRt = -1;
        private m iwq = null;

        public final void SK() {
            super.SK();
            w.d("MicroMsg.GetIsSupportFaceTask", "hy: callback. isSupport: %b, errCode: %d, errMsg: %s, libVersion: %d", new Object[]{Boolean.valueOf(this.fXh), Integer.valueOf(this.errCode), this.fPf, Integer.valueOf(this.iRt)});
            Map hashMap = new HashMap(3);
            hashMap.put("errCode", Integer.valueOf(this.errCode));
            hashMap.put("libVersionCode", Integer.valueOf(this.iRt));
            if (this.errCode == 0) {
                this.iwq.x(this.iLf, this.iRs.d("ok", hashMap));
            } else {
                this.iwq.x(this.iLf, this.iRs.d("fail " + this.fPf, hashMap));
            }
            d.aO(this);
        }

        public final void PM() {
            b hdVar = new hd();
            com.tencent.mm.sdk.b.a.urY.m(hdVar);
            this.fXh = hdVar.fMz.fMA;
            this.errCode = hdVar.fMz.fMB;
            this.fPf = hdVar.fMz.fMC;
            this.iRt = hdVar.fMz.fMD;
            w.i("MicroMsg.GetIsSupportFaceTask", "hy: is support: %b, errCode: %d, errMsg: %s, ilbVersion: %d", new Object[]{Boolean.valueOf(this.fXh), Integer.valueOf(this.errCode), this.fPf, Integer.valueOf(this.iRt)});
            SL();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.fXh ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.errCode);
            parcel.writeString(this.fPf);
            parcel.writeInt(this.iRt);
        }

        public GetIsSupportFaceTask(m mVar, int i, JsApiCheckIsSupportFaceDetect jsApiCheckIsSupportFaceDetect) {
            this.iwq = mVar;
            this.iLf = i;
            this.iRs = jsApiCheckIsSupportFaceDetect;
        }

        protected GetIsSupportFaceTask(Parcel parcel) {
            f(parcel);
        }

        public final void f(Parcel parcel) {
            super.f(parcel);
            this.fXh = parcel.readByte() != (byte) 0;
            this.errCode = parcel.readInt();
            this.fPf = parcel.readString();
            this.iRt = parcel.readInt();
        }
    }

    public final void a(m mVar, JSONObject jSONObject, int i) {
        w.i("MicroMsg.JsApiCheckIsSupportFaceDetect", "hy: subapp start do check is support face detect");
        this.iRr = new GetIsSupportFaceTask(mVar, i, this);
        d.aN(this.iRr);
        AppBrandMainProcessService.a(this.iRr);
    }
}
