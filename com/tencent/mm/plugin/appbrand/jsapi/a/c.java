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
import org.json.JSONObject;

@TargetApi(18)
public final class c extends a {
    private static final int CTRL_INDEX = 174;
    private static final String NAME = "closeBluetoothAdapter";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        w.i("MicroMsg.JsApiCloseBluetoothAdapter", "closeBluetoothAdapter!");
        Map hashMap = new HashMap();
        if (f.ep(18)) {
            w.e("MicroMsg.JsApiCloseBluetoothAdapter", "API version is below 18!");
            hashMap.put("errCode", Integer.valueOf(10009));
            mVar.x(i, d("fail", hashMap));
        } else if (a.iRD) {
            BluetoothManager bluetoothManager = (BluetoothManager) mVar.mContext.getSystemService("bluetooth");
            if (bluetoothManager == null) {
                w.e("MicroMsg.JsApiCloseBluetoothAdapter", "bluetoothManager is null!");
                hashMap.put("errCode", Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
                mVar.x(i, d("fail", hashMap));
            } else if (mVar.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
                BluetoothAdapter adapter = bluetoothManager.getAdapter();
                if (adapter == null || !adapter.isEnabled()) {
                    w.e("MicroMsg.JsApiCloseBluetoothAdapter", "bluetoothAdapter is null!");
                    hashMap.put("errCode", Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
                    mVar.x(i, d("fail", hashMap));
                    return;
                }
                if (adapter.isDiscovering()) {
                    adapter.cancelDiscovery();
                }
                if (k.iRM != null) {
                    w.i("MicroMsg.JsApiCloseBluetoothAdapter", "unregisterReceiver");
                    try {
                        mVar.mContext.unregisterReceiver(k.iRM);
                        k.iRM = null;
                    } catch (Exception e) {
                        w.e("MicroMsg.JsApiCloseBluetoothAdapter", "unregisterReceiver error!");
                    }
                }
                a.Ty();
                a.TB();
                a.g(mVar);
                a.iRD = false;
                a.d(null);
                a.hN(0);
                w.i("MicroMsg.JsApiCloseBluetoothAdapter", "closeBluetoothAdapter end with success!");
                mVar.x(i, d("ok", null));
            } else {
                w.e("MicroMsg.JsApiCloseBluetoothAdapter", "not support ble feature!");
                hashMap.put("errCode", Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
                mVar.x(i, d("fail", hashMap));
            }
        } else {
            w.e("MicroMsg.JsApiCloseBluetoothAdapter", "bluetooth is not init!");
            hashMap.put("errCode", Integer.valueOf(10000));
            mVar.x(i, d("fail", hashMap));
        }
    }
}
