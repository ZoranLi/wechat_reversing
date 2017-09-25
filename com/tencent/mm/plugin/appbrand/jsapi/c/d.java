package com.tencent.mm.plugin.appbrand.jsapi.c;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.q;
import com.tencent.mm.u.q.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class d extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 222;
    private static final String NAME = "stopBeaconDiscovery";

    private static class a extends e {
        private static final int CTRL_INDEX = 225;
        private static final String NAME = "onBeaconServiceChanged";
    }

    public final void a(m mVar, JSONObject jSONObject, int i) {
        w.i("MicroMsg.JsApiStopBeaconDiscovery", "stopBeaconDiscovery!");
        Map hashMap = new HashMap();
        if (f.ep(18)) {
            w.e("MicroMsg.JsApiStopBeaconDiscovery", "API version is below 18!");
            hashMap.put("errCode", Integer.valueOf(11000));
            mVar.x(i, d("fail", hashMap));
            return;
        }
        BluetoothManager bluetoothManager = (BluetoothManager) mVar.mContext.getSystemService("bluetooth");
        if (bluetoothManager == null) {
            w.e("MicroMsg.JsApiStopBeaconDiscovery", "bluetoothManager is null!");
            mVar.x(i, d("fail", hashMap));
            return;
        }
        BluetoothAdapter adapter = bluetoothManager.getAdapter();
        if (adapter == null) {
            w.e("MicroMsg.JsApiStopBeaconDiscovery", "bluetoothAdapter is null!");
            mVar.x(i, d("fail", hashMap));
            return;
        }
        b fP = q.yC().fP(a.h(mVar));
        if (fP == null) {
            w.e("MicroMsg.JsApiStopBeaconDiscovery", "keyValueSet is null.");
            mVar.x(i, d("fail", hashMap));
            return;
        }
        com.tencent.mm.plugin.appbrand.jsapi.c.c.a aVar = (com.tencent.mm.plugin.appbrand.jsapi.c.c.a) fP.fS("key_bluetooth_le_scaner");
        if (aVar == null) {
            w.e("MicroMsg.JsApiStopBeaconDiscovery", "bluetoothLEScaner is null!");
            mVar.x(i, d("fail", hashMap));
            return;
        }
        a.TE();
        adapter.stopLeScan(aVar);
        fP.recycle();
        mVar.x(i, d("ok", hashMap));
        a aVar2 = new a();
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (adapter.isEnabled()) {
                jSONObject2.put("available", true);
            } else {
                jSONObject2.put("available", false);
            }
            jSONObject2.put("discovering", false);
        } catch (JSONException e) {
            w.e("MicroMsg.JsApiStopBeaconDiscovery", "put JSON data error : %s", new Object[]{e});
        }
        w.i("MicroMsg.JsApiStopBeaconDiscovery", "OnBeaconServiceChangedEvent %s", new Object[]{jSONObject2.toString()});
        e ad = aVar2.ad(mVar.ivH, mVar.hashCode());
        ad.mData = jSONObject2.toString();
        ad.SR();
    }
}
