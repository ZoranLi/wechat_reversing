package com.tencent.mm.plugin.appbrand.jsapi;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.protocal.c.ny;
import com.tencent.mm.protocal.c.nz;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import org.json.JSONObject;

public final class v extends a {
    public static final int CTRL_INDEX = 206;
    public static final String NAME = "deleteUserAutoFillData";

    public final void a(final m mVar, JSONObject jSONObject, final int i) {
        if (jSONObject == null) {
            w.e("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData data is invalid");
            mVar.x(i, d("fail:data is invalid", null));
            return;
        }
        Object optString = jSONObject.optString("groupKey");
        int optInt = jSONObject.optInt("groupId", 0);
        if (TextUtils.isEmpty(optString)) {
            w.e("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData groupKey is invalid");
            mVar.x(i, d("fail:groupKey is invalid", null));
            return;
        }
        w.i("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData appId:%s, groupId:%d, groupKey:%s", new Object[]{mVar.ivH, Integer.valueOf(optInt), optString});
        a aVar = new a();
        aVar.hsm = new ny();
        aVar.hsn = new nz();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/deleteinfo";
        aVar.hsl = 1194;
        aVar.hso = 0;
        aVar.hsp = 0;
        b BE = aVar.BE();
        ny nyVar = (ny) BE.hsj.hsr;
        nyVar.ttE = optString;
        nyVar.fTO = r3;
        nyVar.ttF = optInt;
        nyVar.cGa = 1;
        com.tencent.mm.ipcinvoker.wx_extension.b.a(BE, new com.tencent.mm.ipcinvoker.wx_extension.b.a(this) {
            final /* synthetic */ v iMp;

            public final void a(int i, int i2, String str, b bVar) {
                if (i == 0 && i2 == 0 && bVar.hsk.hsr != null) {
                    w.i("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData success");
                    mVar.x(i, this.iMp.d("ok", null));
                    return;
                }
                w.e("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hsk.hsr});
                mVar.x(i, this.iMp.d("fail:cgi fail", null));
            }
        });
    }
}
