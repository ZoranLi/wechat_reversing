package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.pw;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class JsApiMakeVoIPCall extends a {
    public static final int CTRL_INDEX = 154;
    public static final String NAME = "makeVoIPCall";
    private int iLf;
    private m iwq;

    private static class StartVoIPCall extends MainProcessTask {
        public static final Creator<StartVoIPCall> CREATOR = new Creator<StartVoIPCall>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new StartVoIPCall(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StartVoIPCall[i];
            }
        };
        private d iMF;
        private m iMG;
        private int iMH;
        public c iOz = new c<pw>(this) {
            final /* synthetic */ StartVoIPCall iOA;

            {
                this.iOA = r2;
                this.usg = pw.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                pw pwVar = (pw) bVar;
                if (pwVar != null && (pwVar instanceof pw)) {
                    this.iOA.status = pwVar.fWW.status;
                    a.urY.c(this.iOA.iOz);
                    this.iOA.SL();
                }
                return false;
            }
        };
        public int status;

        public StartVoIPCall(d dVar, m mVar, int i) {
            this.iMF = dVar;
            this.iMG = mVar;
            this.iMH = i;
        }

        public StartVoIPCall(Parcel parcel) {
            f(parcel);
        }

        public final void PM() {
            a.urY.b(this.iOz);
        }

        public final void SK() {
            SN();
            w.i("MicroMsg.JsApiMakeVoIPCall", "makeVoIPCall = %d", new Object[]{Integer.valueOf(this.status)});
            if (this.status == 1) {
                this.iMG.x(this.iMH, this.iMF.d("cancel", null));
            } else if (this.status == 2) {
                this.iMG.x(this.iMH, this.iMF.d("ok", null));
            } else if (this.status == 3) {
                this.iMG.x(this.iMH, this.iMF.d("fail:network error", null));
            } else if (this.status == 4) {
                this.iMG.x(this.iMH, this.iMF.d("fail:param not match", null));
            } else {
                this.iMG.x(this.iMH, this.iMF.d("fail:unknow", null));
            }
        }

        public final void f(Parcel parcel) {
            this.status = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.status);
        }
    }

    public final void a(m mVar, JSONObject jSONObject, int i) {
        this.iwq = mVar;
        this.iLf = i;
        String optString = jSONObject.optString("context");
        String optString2 = jSONObject.optString("avatarUrl");
        boolean optBoolean = jSONObject.optBoolean("showOther");
        boolean optBoolean2 = jSONObject.optBoolean("allowBackCamera");
        String optString3 = jSONObject.optString("toUserName");
        AppBrandSysConfig mY = com.tencent.mm.plugin.appbrand.b.mY(mVar.ivH);
        if (bg.mA(optString3) && mY != null) {
            optString3 = mY.fCJ;
        }
        if (bg.mA(mVar.ivH) || bg.mA(optString3)) {
            w.e("MicroMsg.JsApiMakeVoIPCall", "appId or toUserName invalid!");
            mVar.x(i, d("fail", null));
            return;
        }
        w.d("MicroMsg.JsApiMakeVoIPCall", "allowBackCamera: %s, showOther: %s, avatarUrl: %s, context: %s, toUserName: %s", new Object[]{Boolean.valueOf(optBoolean2), Boolean.valueOf(optBoolean), optString2, optString, optString3});
        MainProcessTask startVoIPCall = new StartVoIPCall(this, mVar, i);
        startVoIPCall.SM();
        AppBrandMainProcessService.a(startVoIPCall);
        Intent intent = new Intent();
        intent.putExtra("voipCSBizId", optString3);
        intent.putExtra("voipCSAppId", mVar.ivH);
        intent.putExtra("voipCSAllowBackCamera", optBoolean2 ? "1" : "0");
        intent.putExtra("voipCSShowOther", optBoolean ? "1" : "0");
        intent.putExtra("voipCSAvatarUrl", optString2);
        intent.putExtra("voipCSContext", optString);
        d.b(mVar.mContext, "voip_cs", ".ui.VoipCSMainUI", intent);
    }
}
