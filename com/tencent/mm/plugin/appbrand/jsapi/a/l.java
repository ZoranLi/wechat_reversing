package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothManager;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.q.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@TargetApi(18)
public final class l extends a {
    private static final int CTRL_INDEX = 185;
    private static final String NAME = "readBLECharacteristicValue";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            w.e("MicroMsg.JsApiReadBLECharacteristicValue", "JsApiReadBLECharacteristicValue data is null");
            mVar.x(i, d("fail:data is null", null));
            return;
        }
        w.i("MicroMsg.JsApiReadBLECharacteristicValue", "readBLECharacteristicValue data %s", new Object[]{jSONObject.toString()});
        Map hashMap = new HashMap();
        if (f.ep(18)) {
            w.e("MicroMsg.JsApiReadBLECharacteristicValue", "API version is below 18!");
            hashMap.put("errCode", Integer.valueOf(10009));
            mVar.x(i, d("fail", hashMap));
        } else if (a.iRD) {
            BluetoothManager bluetoothManager = (BluetoothManager) mVar.mContext.getSystemService("bluetooth");
            if (bluetoothManager == null) {
                w.e("MicroMsg.JsApiReadBLECharacteristicValue", "bluetoothManager is null!");
                hashMap.put("errCode", Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
                mVar.x(i, d("fail", hashMap));
                return;
            }
            BluetoothAdapter adapter = bluetoothManager.getAdapter();
            if (adapter == null || !adapter.isEnabled()) {
                w.e("MicroMsg.JsApiReadBLECharacteristicValue", "adapter is null or not enabled!");
                hashMap.put("errCode", Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
                mVar.x(i, d("fail", hashMap));
                return;
            }
            String optString = jSONObject.optString("deviceId");
            String optString2 = jSONObject.optString("serviceId");
            String optString3 = jSONObject.optString("characteristicId");
            b f = a.f(mVar);
            BluetoothGatt bluetoothGatt = (BluetoothGatt) f.fS("key_bluetooth_gatt" + optString);
            if (bluetoothGatt == null) {
                w.e("MicroMsg.JsApiReadBLECharacteristicValue", "get bluetoothGatt failed, bluetoothGatt is null!");
                hashMap.put("errCode", Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
                mVar.x(i, d("fail", hashMap));
                return;
            }
            BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) f.fS(optString + optString2 + optString3);
            if (bluetoothGattCharacteristic == null) {
                w.e("MicroMsg.JsApiReadBLECharacteristicValue", "get characteristics failed !");
                hashMap.put("errCode", Integer.valueOf(10005));
                mVar.x(i, d("fail", hashMap));
            } else if (bluetoothGatt.readCharacteristic(bluetoothGattCharacteristic)) {
                hashMap.put("errCode", Integer.valueOf(0));
                mVar.x(i, d("ok", hashMap));
            } else {
                hashMap.put("errCode", Integer.valueOf(10008));
                mVar.x(i, d("fail", hashMap));
            }
        } else {
            w.e("MicroMsg.JsApiReadBLECharacteristicValue", "bluetooth is not init!");
            hashMap.put("errCode", Integer.valueOf(10000));
            mVar.x(i, d("fail", hashMap));
        }
    }
}
