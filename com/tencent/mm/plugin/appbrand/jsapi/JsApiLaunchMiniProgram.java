package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.LaunchBroadCast;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import junit.framework.Assert;
import org.json.JSONObject;

public final class JsApiLaunchMiniProgram extends a {
    public static final int CTRL_INDEX = 166;
    public static final String NAME = "launchMiniProgram";

    class AnonymousClass2 implements a {
        final /* synthetic */ int iHi;
        final /* synthetic */ m iLg;
        final /* synthetic */ JsApiLaunchMiniProgram iOp;
        final /* synthetic */ String iOq;
        final /* synthetic */ int iOr;

        AnonymousClass2(JsApiLaunchMiniProgram jsApiLaunchMiniProgram, String str, int i, m mVar, int i2) {
            this.iOp = jsApiLaunchMiniProgram;
            this.iOq = str;
            this.iOr = i;
            this.iLg = mVar;
            this.iHi = i2;
        }

        public final void aF(Object obj) {
            if (obj instanceof LaunchBroadCast) {
                LaunchBroadCast launchBroadCast = (LaunchBroadCast) obj;
                if (this.iOq.equals(launchBroadCast.appId) && this.iOr == launchBroadCast.iPk) {
                    MMToClientEvent.b(this);
                    this.iLg.x(this.iHi, this.iOp.d(launchBroadCast.fYp ? "ok" : "fail", null));
                }
            }
        }
    }

    private static final class LaunchPreconditionTask extends MainProcessTask {
        public static final Creator<LaunchPreconditionTask> CREATOR = new Creator<LaunchPreconditionTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new LaunchPreconditionTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new LaunchPreconditionTask[i];
            }
        };
        public String iOs;
        public int iOt;
        public int iOu = a.FAIL.ordinal();

        enum a {
            FAIL("fail"),
            FAIL_MORE_THAN_ONE_TASK("fail can not launch more than 1 mini program"),
            OK("ok");
            
            public final String fEr;

            private a(String str) {
                this.fEr = str;
            }

            public static a hK(int i) {
                for (a aVar : values()) {
                    if (i == aVar.ordinal()) {
                        return aVar;
                    }
                }
                return null;
            }
        }

        public final void f(Parcel parcel) {
            this.iOs = parcel.readString();
            this.iOt = parcel.readInt();
            this.iOu = parcel.readInt();
        }

        public final void PM() {
            b.qM(this.iOs);
            this.iOu = a.OK.ordinal();
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.iOs);
            parcel.writeInt(this.iOt);
            parcel.writeInt(this.iOu);
        }

        LaunchPreconditionTask() {
        }

        LaunchPreconditionTask(Parcel parcel) {
            f(parcel);
        }
    }

    public final void a(m mVar, JSONObject jSONObject, int i) {
        int i2 = 1;
        final String optString = jSONObject.optString("appId", null);
        if (bg.mA(optString)) {
            mVar.x(i, d("fail:invalid data", null));
        } else if (optString.equals(mVar.ivH)) {
            mVar.x(i, d("fail target appId is the same as the caller appId", null));
        } else {
            final String optString2 = jSONObject.optString("path", null);
            final String optString3 = jSONObject.optString("extraData", null);
            if (!(com.tencent.mm.plugin.appbrand.b.mY(mVar.ivH).iFk.izV == 1 && jSONObject.optBoolean("isDev", false))) {
                i2 = 0;
            }
            final m mVar2 = mVar;
            final int i3 = i;
            af.v(new Runnable(this) {
                final /* synthetic */ JsApiLaunchMiniProgram iOp;

                public final void run() {
                    d dVar = this.iOp;
                    m mVar = mVar2;
                    String str = optString;
                    int i = i2;
                    String str2 = optString2;
                    String str3 = optString3;
                    int i2 = i3;
                    MainProcessTask launchPreconditionTask = new LaunchPreconditionTask();
                    launchPreconditionTask.iOs = str;
                    launchPreconditionTask.iOt = i;
                    if (AppBrandMainProcessService.b(launchPreconditionTask)) {
                        a hK = a.hK(launchPreconditionTask.iOu);
                        if (hK == null) {
                            hK = a.FAIL;
                        }
                        if (a.OK != hK) {
                            mVar.x(i2, dVar.d(hK.fEr, null));
                            return;
                        }
                        mVar.ixr.iwG = true;
                        e.a(mVar.ivH, c.LAUNCH_MINI_PROGRAM);
                        MMToClientEvent.a(new AnonymousClass2(dVar, str, i, mVar, i2));
                        if (mVar.mContext != null && (mVar.mContext instanceof Activity) && !((Activity) mVar.mContext).isFinishing()) {
                            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                            appBrandStatObject.scene = 1037;
                            AppBrandStatObject mZ = com.tencent.mm.plugin.appbrand.b.mZ(mVar.ivH);
                            if (mZ != null) {
                                appBrandStatObject.fWK = mZ.fWK;
                            }
                            String str4 = "";
                            com.tencent.mm.plugin.appbrand.g.m b = d.b(mVar);
                            if (b != null) {
                                str4 = b.jde.jdV;
                            }
                            StringBuilder stringBuilder = new StringBuilder(mVar.ivH);
                            stringBuilder.append(":");
                            stringBuilder.append(bg.mz(p.encode(str4)));
                            appBrandStatObject.fCN = stringBuilder.toString();
                            AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
                            appBrandLaunchReferrer.appId = mVar.ivH;
                            appBrandLaunchReferrer.iEM = str3;
                            appBrandLaunchReferrer.iEL = 1;
                            appBrandLaunchReferrer.url = str4;
                            AppBrandLaunchProxyUI.a(mVar.mContext, null, str, str2, i, -1, appBrandStatObject, appBrandLaunchReferrer, null);
                            Assert.assertTrue(true);
                            return;
                        }
                        return;
                    }
                    mVar.x(i2, dVar.d("fail precondition error", null));
                }
            });
        }
    }
}
