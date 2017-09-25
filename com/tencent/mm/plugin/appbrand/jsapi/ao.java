package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.protocal.c.acd;
import com.tencent.mm.protocal.c.ace;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ao extends a {
    public static final int CTRL_INDEX = 204;
    public static final String NAME = "getUserAutoFillData";

    public final void a(final m mVar, JSONObject jSONObject, final int i) {
        if (jSONObject == null) {
            w.e("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData data is invalid");
            mVar.x(i, d("fail:data is invalid", null));
            return;
        }
        LinkedList linkedList = new LinkedList();
        JSONArray optJSONArray = jSONObject.optJSONArray("fields");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                linkedList.add(optJSONArray.optString(i2));
            }
        }
        if (linkedList.size() == 0) {
            w.e("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData fields is empty");
            mVar.x(i, d("fail:fields is empty", null));
            return;
        }
        w.i("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData appId:%s, data:%s", new Object[]{mVar.ivH, jSONObject.toString()});
        a aVar = new a();
        aVar.hsm = new acd();
        aVar.hsn = new ace();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo";
        aVar.hsl = 1191;
        aVar.hso = 0;
        aVar.hsp = 0;
        b BE = aVar.BE();
        acd com_tencent_mm_protocal_c_acd = (acd) BE.hsj.hsr;
        com_tencent_mm_protocal_c_acd.tHL = linkedList;
        com_tencent_mm_protocal_c_acd.fTO = r3;
        com_tencent_mm_protocal_c_acd.tHK = false;
        com_tencent_mm_protocal_c_acd.cGa = 1;
        com.tencent.mm.ipcinvoker.wx_extension.b.a(BE, new com.tencent.mm.ipcinvoker.wx_extension.b.a(this) {
            final /* synthetic */ ao iOk;

            public final void a(int i, int i2, String str, b bVar) {
                if (i == 0 && i2 == 0 && bVar.hsk.hsr != null) {
                    Object obj;
                    ace com_tencent_mm_protocal_c_ace = (ace) bVar.hsk.hsr;
                    w.i("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData success");
                    Map hashMap = new HashMap();
                    Object obj2 = com_tencent_mm_protocal_c_ace.tHM;
                    String str2 = com_tencent_mm_protocal_c_ace.tHN;
                    int i3 = com_tencent_mm_protocal_c_ace.thx;
                    Collection collection = com_tencent_mm_protocal_c_ace.tHO;
                    w.i("MicroMsg.JsApiGetUserAutoFillData", "auth_info:%s, auth_status:%d", new Object[]{str2, Integer.valueOf(i3)});
                    w.i("MicroMsg.JsApiGetUserAutoFillData", "user_info_json:%s", new Object[]{obj2});
                    if (obj2 == null) {
                        obj2 = "";
                    }
                    if (obj2 == null) {
                        obj = "";
                    } else {
                        String str3 = str2;
                    }
                    hashMap.put("userData", obj2);
                    hashMap.put("authStatus", Integer.valueOf(i3));
                    hashMap.put("authInfo", obj);
                    if (collection != null && collection.size() > 0) {
                        hashMap.put("authGroupList", new JSONArray(collection));
                        w.i("MicroMsg.JsApiGetUserAutoFillData", "authGroupList:%s", new Object[]{new JSONArray(collection).toString()});
                    }
                    mVar.x(i, this.iOk.d("ok", hashMap));
                    return;
                }
                w.e("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hsk.hsr});
                mVar.x(i, this.iOk.d("fail:cgi fail", null));
            }
        });
    }
}
