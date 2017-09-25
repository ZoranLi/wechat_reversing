package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@TargetApi(18)
public final class e extends a {
    private static final int CTRL_INDEX = 183;
    private static final String NAME = "getBLEDeviceCharacteristics";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            w.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "getBLEDeviceCharacteristics data is null");
            mVar.x(i, d("fail:data is null", null));
            return;
        }
        w.i("MicroMsg.JsApiGetBLEDeviceCharacteristics", "getBLEDeviceCharacteristics data %s", new Object[]{jSONObject.toString()});
        Map hashMap = new HashMap();
        if (f.ep(18)) {
            w.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "API version is below 18!");
            hashMap.put("errCode", Integer.valueOf(10009));
            mVar.x(i, d("fail", hashMap));
            return;
        }
        String optString = jSONObject.optString("deviceId");
        String optString2 = jSONObject.optString("serviceId");
        w.i("MicroMsg.JsApiGetBLEDeviceCharacteristics", "try to get characteristics with deviceId : " + optString + ", and serviceId : " + optString2);
        if (a.iRD) {
            BluetoothManager bluetoothManager = (BluetoothManager) mVar.mContext.getSystemService("bluetooth");
            if (bluetoothManager == null) {
                w.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "bluetoothManager is null!");
                hashMap.put("errCode", Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
                mVar.x(i, d("fail", hashMap));
                return;
            }
            BluetoothAdapter adapter = bluetoothManager.getAdapter();
            if (adapter == null || !adapter.isEnabled()) {
                w.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "adapter is null or not enabled!");
                hashMap.put("errCode", Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
                mVar.x(i, d("fail", hashMap));
                return;
            }
            JSONArray jSONArray = (JSONArray) a.f(mVar).fS(("key_bluetooth_gatt_service" + optString + optString2).hashCode());
            if (jSONArray == null || jSONArray.length() <= 0) {
                w.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "not found services");
                hashMap.put("errCode", Integer.valueOf(10005));
                mVar.x(i, d("fail", hashMap));
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("errMsg", getName() + ":ok");
                jSONObject2.put("characteristics", jSONArray);
                jSONObject2.put("errCode", 0);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.JsApiGetBLEDeviceCharacteristics", e, "", new Object[0]);
            }
            w.i("MicroMsg.JsApiGetBLEDeviceCharacteristics", "retJson %s", new Object[]{jSONObject2.toString()});
            mVar.x(i, jSONObject2.toString());
            return;
        }
        w.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "bluetooth is not init!");
        hashMap.put("errCode", Integer.valueOf(10000));
        mVar.x(i, d("fail", hashMap));
    }
}
