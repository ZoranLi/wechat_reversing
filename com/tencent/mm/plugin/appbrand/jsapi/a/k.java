package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.appbrand.e.b;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class k extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 173;
    private static final String NAME = "openBluetoothAdapter";
    public static BroadcastReceiver iRM;

    private static class a extends e {
        private static final int CTRL_INDEX = 189;
        private static final String NAME = "onBluetoothAdapterStateChange";
    }

    public final void a(final m mVar, JSONObject jSONObject, int i) {
        w.i("MicroMsg.JsApiOpenBluetoothAdapter", "openBluetoothAdapter!");
        Map hashMap = new HashMap();
        if (f.ep(18)) {
            w.e("MicroMsg.JsApiOpenBluetoothAdapter", "API version is below 18!");
            hashMap.put("errCode", Integer.valueOf(10009));
            mVar.x(i, d("fail", hashMap));
            return;
        }
        BluetoothManager bluetoothManager = (BluetoothManager) mVar.mContext.getSystemService("bluetooth");
        if (bluetoothManager == null) {
            w.e("MicroMsg.JsApiOpenBluetoothAdapter", "bluetoothManager is null!");
            mVar.x(i, d("fail", null));
        } else if (mVar.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            BluetoothAdapter adapter = bluetoothManager.getAdapter();
            if (adapter == null) {
                w.e("MicroMsg.JsApiOpenBluetoothAdapter", "bluetoothAdapter is null!");
                mVar.x(i, d("fail", null));
                return;
            }
            if (iRM == null) {
                iRM = new BroadcastReceiver(this) {
                    final /* synthetic */ k iRN;

                    public final void onReceive(Context context, Intent intent) {
                        if (intent == null) {
                            w.i("MicroMsg.JsApiOpenBluetoothAdapter", "Receive intent failed");
                            return;
                        }
                        boolean z;
                        int i;
                        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                        if (defaultAdapter != null) {
                            int state = defaultAdapter.getState();
                            if (state == 12) {
                                z = true;
                                i = 1;
                            } else if (state == 10) {
                                z = false;
                                i = 1;
                            } else {
                                z = false;
                                i = 0;
                            }
                            w.i("MicroMsg.JsApiOpenBluetoothAdapter", "bluetoothAdapter state: %s", new Object[]{Integer.valueOf(state)});
                        } else {
                            z = false;
                            i = 0;
                        }
                        if (i == 0) {
                            return;
                        }
                        if (a.iRD) {
                            a aVar = new a();
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("available", z);
                                jSONObject.put("discovering", false);
                            } catch (JSONException e) {
                                w.e("MicroMsg.JsApiOpenBluetoothAdapter", "put JSON data error : %s", new Object[]{e});
                            }
                            w.i("MicroMsg.JsApiOpenBluetoothAdapter", "OnBluetoothAdapterStateChange %s", new Object[]{jSONObject.toString()});
                            if (mVar != null) {
                                e ad = aVar.ad(mVar.ivH, mVar.hashCode());
                                ad.mData = jSONObject.toString();
                                ad.SR();
                                return;
                            }
                            return;
                        }
                        w.e("MicroMsg.JsApiOpenBluetoothAdapter", "bluetooth is not init,return...");
                    }
                };
                w.i("MicroMsg.JsApiOpenBluetoothAdapter", "registerReceiver");
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
                mVar.mContext.registerReceiver(iRM, intentFilter);
            }
            com.tencent.mm.plugin.appbrand.e.a(mVar.ivH, new b(this) {
                final /* synthetic */ k iRN;

                public final void onResume() {
                }

                public final void a(c cVar) {
                }

                public final void onDestroy() {
                    w.i("MicroMsg.JsApiOpenBluetoothAdapter", "lifecycle destroy...");
                    if (mVar != null) {
                        if (k.iRM != null) {
                            w.i("MicroMsg.JsApiOpenBluetoothAdapter", "unregisterReceiver");
                            mVar.mContext.unregisterReceiver(k.iRM);
                            k.iRM = null;
                        }
                        com.tencent.mm.plugin.appbrand.e.b(mVar.ivH, this);
                    }
                }
            });
            if (adapter.isEnabled()) {
                a.iRD = true;
                mVar.x(i, d("ok", null));
                return;
            }
            w.e("MicroMsg.JsApiOpenBluetoothAdapter", "bluetoothAdapter not enabled!");
            a.iRD = true;
            hashMap.put("errCode", Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
            mVar.x(i, d("fail", hashMap));
        } else {
            w.e("MicroMsg.JsApiOpenBluetoothAdapter", "not support ble feature!");
            mVar.x(i, d("fail", null));
        }
    }
}
