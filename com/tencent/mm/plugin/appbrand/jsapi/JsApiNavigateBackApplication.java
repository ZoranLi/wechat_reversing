package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Resp;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import org.json.JSONObject;

public final class JsApiNavigateBackApplication extends a {
    private static final int CTRL_INDEX = 288;
    private static final String NAME = "navigateBackApplication";

    private static final class NavigateBackAppTask extends MainProcessTask {
        public static final Creator<NavigateBackAppTask> CREATOR = new Creator<NavigateBackAppTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                NavigateBackAppTask navigateBackAppTask = new NavigateBackAppTask();
                navigateBackAppTask.f(parcel);
                return navigateBackAppTask;
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new NavigateBackAppTask[i];
            }
        };
        public String appId;
        public String data;

        public NavigateBackAppTask(String str, String str2) {
            this.appId = str;
            this.data = str2;
        }

        public final void PM() {
            f aJ = g.aJ(this.appId, true);
            if (aJ != null) {
                Bundle bundle = new Bundle();
                Resp resp = new Resp(bundle);
                resp.extMsg = this.data;
                resp.openId = aJ.field_openId;
                Args args = new Args();
                args.targetPkgName = aJ.field_packageName;
                resp.toBundle(bundle);
                args.bundle = bundle;
                p.aa(bundle);
                p.ab(bundle);
                MMessageActV2.send(ab.getContext(), args);
            }
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.appId);
            parcel.writeString(this.data);
        }

        public final void f(Parcel parcel) {
            this.appId = parcel.readString();
            this.data = parcel.readString();
        }
    }

    public final void a(m mVar, JSONObject jSONObject, int i) {
        AppBrandLaunchReferrer appBrandLaunchReferrer = mVar.ixr.iwn.iEK;
        if (bg.mA(appBrandLaunchReferrer.appId) || appBrandLaunchReferrer.iEL != 4) {
            mVar.x(i, d("fail:not from opensdk", null));
            return;
        }
        String str;
        JSONObject optJSONObject = jSONObject.optJSONObject("extraData");
        String str2 = appBrandLaunchReferrer.appId;
        if (optJSONObject == null) {
            str = "{}";
        } else {
            str = optJSONObject.toString();
        }
        AppBrandMainProcessService.a(new NavigateBackAppTask(str2, str));
        mVar.x(i, d("ok", null));
    }
}
