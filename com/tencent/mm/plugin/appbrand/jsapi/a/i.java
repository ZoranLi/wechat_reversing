package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
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
public final class i extends a {
    private static final int CTRL_INDEX = 179;
    private static final String NAME = "getConnectedBluetoothDevices";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        w.i("MicroMsg.JsApiGetConnectedBluetoothDevices", "getConnectedBluetoothDevices!");
        Map hashMap = new HashMap();
        if (f.ep(18)) {
            w.e("MicroMsg.JsApiGetConnectedBluetoothDevices", "API version is below 18!");
            hashMap.put("errCode", Integer.valueOf(10009));
            mVar.x(i, d("fail", hashMap));
        } else if (a.iRD) {
            BluetoothManager bluetoothManager = (BluetoothManager) mVar.mContext.getSystemService("bluetooth");
            if (bluetoothManager == null) {
                w.e("MicroMsg.JsApiGetConnectedBluetoothDevices", "bluetoothManager is null!");
                hashMap.put("errCode", Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
                mVar.x(i, d("fail", hashMap));
                return;
            }
            BluetoothAdapter adapter = bluetoothManager.getAdapter();
            if (adapter == null || !adapter.isEnabled()) {
                w.e("MicroMsg.JsApiGetConnectedBluetoothDevices", "adapter is null or not enabled!");
                hashMap.put("errCode", Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
                mVar.x(i, d("fail", hashMap));
                return;
            }
            List<BluetoothDevice> connectedDevices = bluetoothManager.getConnectedDevices(7);
            if (connectedDevices == null) {
                w.e("MicroMsg.JsApiGetConnectedBluetoothDevices", "bluetoothDevices is empty!");
                mVar.x(i, d("fail", null));
                return;
            }
            JSONArray jSONArray = new JSONArray();
            for (BluetoothDevice bluetoothDevice : connectedDevices) {
                String address = bluetoothDevice.getAddress();
                String name = bluetoothDevice.getName();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("deviceId", address);
                    jSONObject2.put("name", name);
                    jSONArray.put(jSONObject2);
                } catch (JSONException e) {
                    w.e("MicroMsg.JsApiGetConnectedBluetoothDevices", "put JSON data error : %s", new Object[]{e});
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("errMsg", getName() + ":ok");
                jSONObject3.put("devices", jSONArray);
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.JsApiGetConnectedBluetoothDevices", e2, "", new Object[0]);
            }
            w.i("MicroMsg.JsApiGetConnectedBluetoothDevices", "retJson %s", new Object[]{jSONObject3.toString()});
            mVar.x(i, jSONObject3.toString());
        } else {
            w.e("MicroMsg.JsApiGetConnectedBluetoothDevices", "bluetooth is not init!");
            hashMap.put("errCode", Integer.valueOf(10000));
            mVar.x(i, d("fail", hashMap));
        }
    }
}
