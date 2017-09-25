package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.bluetooth.BluetoothAdapter;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g extends a {
    private static final int CTRL_INDEX = 175;
    private static final String NAME = "getBluetoothAdapterState";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        boolean z = true;
        w.i("MicroMsg.JsApiGetBluetoothAdapterState", "getBluetoothAdapterState!");
        Map hashMap = new HashMap();
        if (f.ep(18)) {
            w.e("MicroMsg.JsApiGetBluetoothAdapterState", "API version is below 18!");
            hashMap.put("errCode", Integer.valueOf(10009));
            mVar.x(i, d("fail", hashMap));
        } else if (a.iRD) {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter == null) {
                hashMap.put("available", Boolean.valueOf(false));
                hashMap.put("discovering", Boolean.valueOf(false));
                mVar.x(i, d("ok", hashMap));
                return;
            }
            boolean z2 = defaultAdapter.isEnabled();
            if (!defaultAdapter.isDiscovering()) {
                z = false;
            }
            w.i("MicroMsg.JsApiGetBluetoothAdapterState", "availableState : " + z2 + ",discoveringState : " + z);
            hashMap.put("available", Boolean.valueOf(z2));
            hashMap.put("discovering", Boolean.valueOf(z));
            mVar.x(i, d("ok", hashMap));
        } else {
            w.e("MicroMsg.JsApiGetBluetoothAdapterState", "bluetooth is not init!");
            hashMap.put("errCode", Integer.valueOf(10000));
            mVar.x(i, d("fail", hashMap));
        }
    }
}
