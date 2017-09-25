package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.q.b;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class f extends a {
    private static final int CTRL_INDEX = 182;
    private static final String NAME = "getBLEDeviceServices";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            w.e("MicroMsg.JsApiGetBLEDeviceServices", "JsApiGetBLEDeviceServices data is null");
            mVar.x(i, d("fail:data is null", null));
            return;
        }
        w.i("MicroMsg.JsApiGetBLEDeviceServices", "getBLEDeviceServices data %s", new Object[]{jSONObject.toString()});
        Map hashMap = new HashMap();
        if (com.tencent.mm.compatible.util.f.ep(18)) {
            w.e("MicroMsg.JsApiGetBLEDeviceServices", "API version is below 18!");
            hashMap.put("errCode", Integer.valueOf(10009));
            mVar.x(i, d("fail", hashMap));
            return;
        }
        String optString = jSONObject.optString("deviceId");
        if (a.iRD) {
            BluetoothManager bluetoothManager = (BluetoothManager) mVar.mContext.getSystemService("bluetooth");
            if (bluetoothManager == null) {
                w.e("MicroMsg.JsApiGetBLEDeviceServices", "bluetoothManager is null!");
                hashMap.put("errCode", Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
                mVar.x(i, d("fail", hashMap));
                return;
            }
            BluetoothAdapter adapter = bluetoothManager.getAdapter();
            if (adapter == null || !adapter.isEnabled()) {
                w.e("MicroMsg.JsApiGetBLEDeviceServices", "adapter is null or not enabled!");
                hashMap.put("errCode", Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
                mVar.x(i, d("fail", hashMap));
                return;
            }
            b f = a.f(mVar);
            w.i("MicroMsg.JsApiGetBLEDeviceServices", "try getBleDeviceServices with deviceId : " + optString);
            Map map = (Map) f.fS("key_bluetooth_services_uuid" + optString);
            if (map == null || map.size() <= 0) {
                w.e("MicroMsg.JsApiGetBLEDeviceServices", "not found services");
                hashMap.put("errCode", Integer.valueOf(10004));
                mVar.x(i, d("fail", hashMap));
                return;
            }
            JSONArray jSONArray = new JSONArray();
            for (Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                boolean f2 = bg.f((Boolean) entry.getValue());
                if (bg.mA(str)) {
                    w.e("MicroMsg.JsApiGetBLEDeviceServices", "get uuid is null");
                    break;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("uuid", str);
                    jSONObject2.put("isPrimary", f2);
                    jSONArray.put(jSONObject2);
                } catch (JSONException e) {
                    w.e("MicroMsg.JsApiGetBLEDeviceServices", "JSONException %s", new Object[]{e.getMessage()});
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("errMsg", getName() + ":ok");
                jSONObject3.put("services", jSONArray);
                jSONObject3.put("errCode", 0);
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.JsApiGetBLEDeviceServices", e2, "", new Object[0]);
            }
            w.i("MicroMsg.JsApiGetBLEDeviceServices", "retJson %s", new Object[]{jSONObject3.toString()});
            mVar.x(i, jSONObject3.toString());
            return;
        }
        w.e("MicroMsg.JsApiGetBLEDeviceServices", "bluetooth is not init!");
        hashMap.put("errCode", Integer.valueOf(10000));
        mVar.x(i, d("fail", hashMap));
    }
}
