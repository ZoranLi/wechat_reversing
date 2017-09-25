package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.c.ahj;
import com.tencent.mm.protocal.c.ahk;
import com.tencent.mm.protocal.c.bqo;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.k;
import com.tencent.mm.y.u;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiRefreshSession extends a {
    private static final int CTRL_INDEX = 118;
    private static final String NAME = "refreshSession";

    public static class RefreshSessionTask extends MainProcessTask {
        public static final Creator<RefreshSessionTask> CREATOR = new Creator<RefreshSessionTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new RefreshSessionTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new RefreshSessionTask[i];
            }
        };
        String appId;
        m iMG;
        int iMH;
        d iPg;
        public int iPh;
        public int iPi;
        public int iPj;
        public int iPk;
        int iPl;

        public RefreshSessionTask(Parcel parcel) {
            f(parcel);
        }

        public final void PM() {
            SM();
            a aVar = new a();
            aVar.hsm = new ahj();
            aVar.hsn = new ahk();
            aVar.uri = "/cgi-bin/mmbiz-bin/js-refreshsession";
            aVar.hsl = 1196;
            aVar.hso = 0;
            aVar.hsp = 0;
            com.tencent.mm.bd.a com_tencent_mm_protocal_c_ahj = new ahj();
            com_tencent_mm_protocal_c_ahj.mtb = this.appId;
            com_tencent_mm_protocal_c_ahj.tLJ = this.iPk;
            aVar.hsm = com_tencent_mm_protocal_c_ahj;
            if (this.iPl > 0) {
                com_tencent_mm_protocal_c_ahj.tLK = new bqo();
                com_tencent_mm_protocal_c_ahj.tLK.scene = this.iPl;
            }
            w.i("MicroMsg.JsApiRefreshSession", "refreshSession appId %s, versionType, statScene %d", new Object[]{this.appId, Integer.valueOf(this.iPk), Integer.valueOf(this.iPl)});
            u.a(aVar.BE(), new u.a(this) {
                final /* synthetic */ RefreshSessionTask iPm;

                {
                    this.iPm = r1;
                }

                public final int a(int i, int i2, String str, b bVar, k kVar) {
                    w.d("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                    if (i == 0 && i2 == 0) {
                        ahk com_tencent_mm_protocal_c_ahk = (ahk) bVar.hsk.hsr;
                        if (com_tencent_mm_protocal_c_ahk == null) {
                            this.iPm.iPj = 0;
                            w.e("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest failed, response is null!");
                            this.iPm.SL();
                        } else {
                            this.iPm.iPi = com_tencent_mm_protocal_c_ahk.tLL.fIz;
                            String str2 = com_tencent_mm_protocal_c_ahk.tLL.fIA;
                            if (this.iPm.iPi == 0) {
                                this.iPm.iPh = com_tencent_mm_protocal_c_ahk.tLT;
                                this.iPm.iPi = com_tencent_mm_protocal_c_ahk.tLL.fIz;
                                this.iPm.iPj = 1;
                                this.iPm.SL();
                            } else {
                                this.iPm.iPi = com_tencent_mm_protocal_c_ahk.tLL.fIz;
                                this.iPm.iPj = 2;
                                w.e("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest ERROR %s", new Object[]{str2});
                                this.iPm.SL();
                            }
                        }
                    } else {
                        this.iPm.iPj = 0;
                        this.iPm.SL();
                    }
                    return 0;
                }
            }, true);
        }

        public final void SK() {
            Map hashMap = new HashMap();
            switch (this.iPj) {
                case 1:
                    hashMap.put("expireIn", this.iPh);
                    hashMap.put("errCode", this.iPi);
                    this.iMG.x(this.iMH, this.iPg.d("ok", hashMap));
                    break;
                case 2:
                    hashMap.put("errCode", this.iPi);
                    this.iMG.x(this.iMH, this.iPg.d("fail", hashMap));
                    break;
                default:
                    hashMap.put("errCode", "-1");
                    this.iMG.x(this.iMH, this.iPg.d("fail", hashMap));
                    break;
            }
            SN();
        }

        public final void f(Parcel parcel) {
            this.iPh = parcel.readInt();
            this.iPi = parcel.readInt();
            this.iPj = parcel.readInt();
            this.iMH = parcel.readInt();
            this.appId = parcel.readString();
            this.iPk = parcel.readInt();
            this.iPl = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.iPh);
            parcel.writeInt(this.iPi);
            parcel.writeInt(this.iPj);
            parcel.writeInt(this.iMH);
            parcel.writeString(this.appId);
            parcel.writeInt(this.iPk);
            parcel.writeInt(this.iPl);
        }
    }

    public final void a(m mVar, JSONObject jSONObject, int i) {
        MainProcessTask refreshSessionTask = new RefreshSessionTask();
        AppBrandSysConfig mY = com.tencent.mm.plugin.appbrand.b.mY(mVar.ivH);
        if (mY != null) {
            refreshSessionTask.iPk = mY.iFk.izV;
        }
        String str = mVar.ivH;
        refreshSessionTask.iPg = this;
        refreshSessionTask.iMG = mVar;
        refreshSessionTask.iMH = i;
        refreshSessionTask.appId = str;
        AppBrandStatObject mZ = com.tencent.mm.plugin.appbrand.b.mZ(str);
        if (mZ != null) {
            refreshSessionTask.iPl = mZ.scene;
        }
        refreshSessionTask.SM();
        AppBrandMainProcessService.a(refreshSessionTask);
    }
}
