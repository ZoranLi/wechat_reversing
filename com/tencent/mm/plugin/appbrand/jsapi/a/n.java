package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class n extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 177;
    private static final String NAME = "stopBluetoothDevicesDiscovery";

    private static class a extends e {
        private static final int CTRL_INDEX = 189;
        private static final String NAME = "onBluetoothAdapterStateChange";
    }

    public final void a(m mVar, JSONObject jSONObject, int i) {
        w.i("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "stopBluetoothDevicesDiscovery!");
        Map hashMap = new HashMap();
        if (f.ep(18)) {
            w.e("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "API version is below 18!");
            hashMap.put("errCode", Integer.valueOf(10009));
            mVar.x(i, d("fail", hashMap));
        } else if (a.iRD) {
            BluetoothManager bluetoothManager = (BluetoothManager) mVar.mContext.getSystemService("bluetooth");
            if (bluetoothManager == null) {
                w.e("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "bluetoothManager is null!");
                hashMap.put("isDiscovering", Boolean.valueOf(false));
                hashMap.put("errCode", Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
                mVar.x(i, d("fail", hashMap));
                return;
            }
            BluetoothAdapter adapter = bluetoothManager.getAdapter();
            if (adapter == null || !adapter.isEnabled()) {
                w.e("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "bluetoothAdapter is null or not enable!");
                hashMap.put("isDiscovering", Boolean.valueOf(false));
                hashMap.put("errCode", Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
                mVar.x(i, d("fail", hashMap));
                return;
            }
            com.tencent.mm.plugin.appbrand.jsapi.a.m.a aVar = (com.tencent.mm.plugin.appbrand.jsapi.a.m.a) a.f(mVar).fS("key_bluetooth_le_scaner");
            if (aVar == null) {
                w.e("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "bluetoothLEScaner is null!");
                hashMap.put("isDiscovering", Boolean.valueOf(false));
                mVar.x(i, d("fail", hashMap));
                return;
            }
            adapter.stopLeScan(aVar);
            hashMap.put("isDiscovering", Boolean.valueOf(false));
            mVar.x(i, d("ok", hashMap));
            a aVar2 = new a();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("available", true);
                jSONObject2.put("discovering", false);
            } catch (JSONException e) {
                w.e("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "put JSON data error : %s", new Object[]{e});
            }
            w.i("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "OnBluetoothAdapterStateChange %s", new Object[]{jSONObject2.toString()});
            e ad = aVar2.ad(mVar.ivH, mVar.hashCode());
            ad.mData = jSONObject2.toString();
            ad.SR();
        } else {
            w.e("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "bluetooth is not init!");
            hashMap.put("errCode", Integer.valueOf(10000));
            mVar.x(i, d("fail", hashMap));
        }
    }
}
