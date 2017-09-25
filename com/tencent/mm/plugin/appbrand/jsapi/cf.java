package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.protocal.c.awc;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import org.json.JSONObject;

public final class cf extends a {
    public static final int CTRL_INDEX = 205;
    public static final String NAME = "setUserAutoFillData";

    public final void a(final m mVar, JSONObject jSONObject, final int i) {
        if (jSONObject == null) {
            w.e("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData data is invalid");
            mVar.x(i, d("fail:data is invalid", null));
            return;
        }
        String optString = jSONObject.optString("dataList");
        w.i("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData appId:%s, dataList:%s", new Object[]{mVar.ivH, optString});
        a aVar = new a();
        aVar.hsm = new awc();
        aVar.hsn = new awd();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/saveinfo";
        aVar.hsl = 1180;
        aVar.hso = 0;
        aVar.hsp = 0;
        b BE = aVar.BE();
        awc com_tencent_mm_protocal_c_awc = (awc) BE.hsj.hsr;
        com_tencent_mm_protocal_c_awc.fTO = r2;
        com_tencent_mm_protocal_c_awc.tHM = optString;
        com.tencent.mm.ipcinvoker.wx_extension.b.a(BE, new com.tencent.mm.ipcinvoker.wx_extension.b.a(this) {
            final /* synthetic */ cf iPU;

            public final void a(int i, int i2, String str, b bVar) {
                if (i == 0 && i2 == 0 && bVar.hsk.hsr != null) {
                    w.i("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData success");
                    mVar.x(i, this.iPU.d("ok", null));
                    return;
                }
                w.e("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData SaveUserAutoFillInfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hsk.hsr});
                mVar.x(i, this.iPU.d("fail:cgi fail", null));
            }
        });
    }
}
