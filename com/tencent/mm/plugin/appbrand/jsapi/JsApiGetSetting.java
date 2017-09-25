package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.protocal.c.bpr;
import com.tencent.mm.protocal.c.bps;
import com.tencent.mm.protocal.c.dq;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.k;
import com.tencent.mm.y.u;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiGetSetting extends a {
    public static final int CTRL_INDEX = 236;
    public static final String NAME = "getSetting";

    private static final class GetSettingTask extends MainProcessTask {
        public static final Creator<GetSettingTask> CREATOR = new Creator<GetSettingTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new GetSettingTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetSettingTask[i];
            }
        };
        public int iLf;
        public String iNZ;
        public String ivH;
        public m iwq;

        public GetSettingTask(Parcel parcel) {
            f(parcel);
        }

        public final void SK() {
            w.i("MicroMsg.JsApiGetSetting", "runInClientProcess");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errMsg", "getSetting:ok");
                jSONObject.put("authSetting", new JSONArray(bg.mz(this.iNZ)));
            } catch (JSONException e) {
                w.e("MicroMsg.JsApiGetSetting", "set json error!");
            }
            this.iwq.x(this.iLf, jSONObject.toString());
            d.aO(this);
        }

        public final void PM() {
            a aVar = new a();
            aVar.hsm = new bpr();
            aVar.hsn = new bps();
            aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp_getauthinfo";
            aVar.hsl = 1196;
            aVar.hso = 0;
            aVar.hsp = 0;
            com.tencent.mm.bd.a com_tencent_mm_protocal_c_bpr = new bpr();
            com_tencent_mm_protocal_c_bpr.appId = this.ivH;
            aVar.hsm = com_tencent_mm_protocal_c_bpr;
            u.a(aVar.BE(), new u.a(this) {
                final /* synthetic */ GetSettingTask iOa;

                {
                    this.iOa = r1;
                }

                public final int a(int i, int i2, String str, b bVar, k kVar) {
                    w.d("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                    if (i == 0 && i2 == 0) {
                        bps com_tencent_mm_protocal_c_bps = (bps) bVar.hsk.hsr;
                        if (com_tencent_mm_protocal_c_bps == null) {
                            w.e("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq failed, response is null!");
                        } else {
                            int i3 = com_tencent_mm_protocal_c_bps.unT.errCode;
                            String str2 = com_tencent_mm_protocal_c_bps.unT.fPf;
                            if (i3 == 0) {
                                LinkedList linkedList = com_tencent_mm_protocal_c_bps.unU;
                                JSONArray jSONArray = new JSONArray();
                                Iterator it = linkedList.iterator();
                                while (it.hasNext()) {
                                    dq dqVar = (dq) it.next();
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("scope", dqVar.scope);
                                        jSONObject.put("state", dqVar.state);
                                        jSONObject.put("desc", dqVar.thc);
                                        jSONArray.put(jSONObject);
                                    } catch (Exception e) {
                                        w.e("MicroMsg.JsApiGetSetting", "parse json failed : %s", new Object[]{e.getMessage()});
                                    }
                                }
                                this.iOa.iNZ = jSONArray.toString();
                                w.d("MicroMsg.JsApiGetSetting", "authInfo %s", new Object[]{jSONArray});
                            } else {
                                w.e("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq error %s", new Object[]{str2});
                            }
                        }
                        this.iOa.SL();
                    }
                    return 0;
                }
            }, true);
        }

        public final void f(Parcel parcel) {
            this.iNZ = parcel.readString();
            this.ivH = parcel.readString();
            this.iLf = parcel.readInt();
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.iNZ);
            parcel.writeString(this.ivH);
            parcel.writeInt(this.iLf);
        }
    }

    public final void a(m mVar, JSONObject jSONObject, int i) {
        MainProcessTask getSettingTask = new GetSettingTask();
        getSettingTask.ivH = mVar.ivH;
        getSettingTask.iLf = i;
        getSettingTask.iwq = mVar;
        d.aN(getSettingTask);
        AppBrandMainProcessService.a(getSettingTask);
    }
}
