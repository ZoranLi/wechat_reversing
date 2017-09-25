package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.os.Build.VERSION;
import android.util.Log;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class h extends a {
    private static final int CTRL_INDEX = 178;
    private static final String NAME = "getBluetoothDevices";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        w.i("MicroMsg.JsApiGetBluetoothDevices", "getBluetoothDevices!");
        Map hashMap = new HashMap();
        if (f.ep(18)) {
            w.e("MicroMsg.JsApiGetBluetoothDevices", "API version is below 18!");
            hashMap.put("errCode", Integer.valueOf(10009));
            mVar.x(i, d("fail", hashMap));
        } else if (a.iRD) {
            BluetoothManager bluetoothManager = (BluetoothManager) mVar.mContext.getSystemService("bluetooth");
            if (bluetoothManager == null) {
                w.e("MicroMsg.JsApiGetBluetoothDevices", "bluetoothManager is null!");
                hashMap.put("errCode", Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
                mVar.x(i, d("fail", hashMap));
                return;
            }
            BluetoothAdapter adapter = bluetoothManager.getAdapter();
            if (adapter == null || !adapter.isEnabled()) {
                w.e("MicroMsg.JsApiGetBluetoothDevices", "adapter is null or not enabled!");
                hashMap.put("errCode", Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
                mVar.x(i, d("fail", hashMap));
                return;
            }
            hashMap = a.Tx();
            if (VERSION.SDK_INT >= 18 && bluetoothManager != null) {
                List<BluetoothDevice> connectedDevices = bluetoothManager.getConnectedDevices(7);
                if (connectedDevices != null) {
                    for (BluetoothDevice bluetoothDevice : connectedDevices) {
                        String address = bluetoothDevice.getAddress();
                        if (!hashMap.containsKey(address)) {
                            JSONObject jSONObject2 = new JSONObject();
                            JSONArray jSONArray = new JSONArray();
                            try {
                                jSONObject2.put("deviceId", address);
                                jSONObject2.put("name", bluetoothDevice.getName());
                                jSONObject2.put("RSSI", 0);
                                jSONObject2.put("advertisData", "");
                                jSONObject2.put("advertisServiceUUIDs", jSONArray);
                                hashMap.put(address, jSONObject2);
                            } catch (JSONException e) {
                                w.e("MicroMsg.JsApiGetBluetoothDevices", "put JSON data error : %s", new Object[]{e});
                            }
                        }
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            for (String str : hashMap.keySet()) {
                jSONArray2.put(hashMap.get(str));
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("errMsg", getName() + ":ok");
                jSONObject3.put("devices", jSONArray2);
            } catch (Throwable e2) {
                w.e("MicroMsg.JsApiGetBluetoothDevices", "put json value error : %s", new Object[]{Log.getStackTraceString(e2)});
            }
            w.i("MicroMsg.JsApiGetBluetoothDevices", "retJson %s", new Object[]{jSONObject3});
            mVar.x(i, jSONObject3.toString());
        } else {
            w.e("MicroMsg.JsApiGetBluetoothDevices", "bluetooth is not init!");
            hashMap.put("errCode", Integer.valueOf(10000));
            mVar.x(i, d("fail", hashMap));
        }
    }
}
