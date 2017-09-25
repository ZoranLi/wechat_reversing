package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@TargetApi(18)
public final class b extends a {
    private static final int CTRL_INDEX = 181;
    private static final String NAME = "closeBLEConnection";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            w.e("MicroMsg.JsApiCloseBLEConnection", "JsApiCloseBLEConnection data is null");
            mVar.x(i, d("fail:data is null", null));
            return;
        }
        w.i("MicroMsg.JsApiCloseBLEConnection", "closeBLEConnection!");
        String optString = jSONObject.optString("deviceId");
        w.i("MicroMsg.JsApiCloseBLEConnection", "closeBLEConnection with deviceId : " + optString);
        Map hashMap = new HashMap();
        if (f.ep(18)) {
            w.e("MicroMsg.JsApiCloseBLEConnection", "API version is below 18!");
            hashMap.put("errCode", Integer.valueOf(10009));
            mVar.x(i, d("fail", hashMap));
        } else if (a.iRD) {
            BluetoothManager bluetoothManager = (BluetoothManager) mVar.mContext.getSystemService("bluetooth");
            if (bluetoothManager == null) {
                w.e("MicroMsg.JsApiCloseBLEConnection", "bluetoothManager is null!");
                hashMap.put("errCode", Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
                mVar.x(i, d("fail", hashMap));
                return;
            }
            BluetoothAdapter adapter = bluetoothManager.getAdapter();
            if (adapter == null || !adapter.isEnabled()) {
                w.e("MicroMsg.JsApiCloseBLEConnection", "adapter is null or not enabled!");
                hashMap.put("errCode", Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
                mVar.x(i, d("fail", hashMap));
                return;
            }
            BluetoothGatt bluetoothGatt = (BluetoothGatt) a.f(mVar).fS("key_bluetooth_gatt" + optString);
            if (bluetoothGatt == null) {
                w.e("MicroMsg.JsApiCloseBLEConnection", "get bluetoothGatt failed, bluetoothGatt is null!");
                hashMap.put("errCode", Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
                mVar.x(i, d("fail", hashMap));
                return;
            }
            bluetoothGatt.disconnect();
            bluetoothGatt.close();
            hashMap.put("errCode", Integer.valueOf(0));
            mVar.x(i, d("ok", hashMap));
        } else {
            w.e("MicroMsg.JsApiCloseBLEConnection", "bluetooth is not init!");
            hashMap.put("errCode", Integer.valueOf(10000));
            mVar.x(i, d("fail", hashMap));
        }
    }
}
