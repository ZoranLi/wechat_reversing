package com.tencent.mm.plugin.appbrand.jsapi.c;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class c extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 221;
    private static final String NAME = "startBeaconDiscovery";
    public static BroadcastReceiver iRM;
    private JSONObject iRP;
    UUID[] iSt = null;
    m iwq;

    public class a implements LeScanCallback {
        private m iRQ;
        final /* synthetic */ c iSu;

        public a(c cVar, m mVar) {
            this.iSu = cVar;
            this.iRQ = mVar;
        }

        public final void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            if (bg.bm(bArr)) {
                w.e("MicroMsg.JsApiStartBeaconDiscovery", "valueByte is null or nil");
                return;
            }
            Object obj = null;
            int i2 = 2;
            while (i2 <= 5) {
                if ((bArr[i2 + 2] & 255) == 2 && (bArr[i2 + 3] & 255) == 21) {
                    obj = 1;
                    break;
                }
                i2++;
            }
            if (obj != null) {
                int i3;
                int i4;
                Object obj2 = new byte[16];
                System.arraycopy(bArr, i2 + 4, obj2, 0, 16);
                StringBuilder stringBuilder = new StringBuilder();
                for (int i5 = 0; i5 < 16; i5++) {
                    i3 = obj2[i5] & 255;
                    if (i3 < 16) {
                        stringBuilder.append("0");
                    }
                    stringBuilder.append(Integer.toHexString(i3));
                }
                String toUpperCase = stringBuilder.toString().toUpperCase(Locale.US);
                UUID fromString = UUID.fromString(toUpperCase.substring(0, 8) + "-" + toUpperCase.substring(8, 12) + "-" + toUpperCase.substring(12, 16) + "-" + toUpperCase.substring(16, 20) + "-" + toUpperCase.substring(20, 32));
                obj = null;
                for (UUID equals : this.iSu.iSt) {
                    if (equals.equals(fromString)) {
                        obj = 1;
                        break;
                    }
                }
                if (obj != null) {
                    double d;
                    i3 = ((bArr[i2 + 20] & 255) * 256) + (bArr[i2 + 21] & 255);
                    i4 = ((bArr[i2 + 22] & 255) * 256) + (bArr[i2 + 23] & 255);
                    byte b = bArr[i2 + 24];
                    double d2 = (double) i;
                    if (d2 == 0.0d) {
                        d = -1.0d;
                    } else {
                        d = (d2 * 1.0d) / ((double) b);
                        d = d < 1.0d ? Math.pow(d, 10.0d) : (Math.pow(d, 9.9476d) * 0.92093d) + 0.54992d;
                    }
                    String address = bluetoothDevice.getAddress();
                    Map TD = a.TD();
                    c cVar = new c();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("uuid", fromString);
                        jSONObject.put("major", i3);
                        jSONObject.put("minor", i4);
                        jSONObject.put("proximity", 0);
                        jSONObject.put("accuracy", d);
                        jSONObject.put("rssi", i);
                        TD.put(address, jSONObject);
                    } catch (JSONException e) {
                        w.e("MicroMsg.JsApiStartBeaconDiscovery", "put JSON data error : %s", new Object[]{e});
                    }
                    JSONArray jSONArray = new JSONArray();
                    for (JSONObject jSONObject2 : TD.values()) {
                        if (jSONObject2 != null) {
                            jSONArray.put(jSONObject2);
                        }
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.put("beacons", jSONArray);
                    } catch (JSONException e2) {
                        w.e("MicroMsg.JsApiStartBeaconDiscovery", "put res JSON data error : %s", new Object[]{e2});
                    }
                    e ad = cVar.ad(this.iRQ.ivH, this.iRQ.hashCode());
                    ad.mData = jSONObject3.toString();
                    ad.SR();
                }
            }
        }
    }

    private static class b extends e {
        private static final int CTRL_INDEX = 225;
        private static final String NAME = "onBeaconServiceChanged";
    }

    private static class c extends e {
        private static final int CTRL_INDEX = 224;
        private static final String NAME = "onBeaconUpdated";
    }

    public final void a(final m mVar, JSONObject jSONObject, int i) {
        this.iwq = mVar;
        w.d("MicroMsg.JsApiStartBeaconDiscovery", "startBeaconDiscovery data %s", new Object[]{jSONObject});
        this.iRP = jSONObject;
        Map hashMap = new HashMap();
        if (f.ep(18)) {
            w.e("MicroMsg.JsApiStartBeaconDiscovery", "API version is below 18!");
            hashMap.put("errCode", Integer.valueOf(11000));
            mVar.x(i, d("fail", hashMap));
            return;
        }
        BluetoothManager bluetoothManager = (BluetoothManager) mVar.mContext.getSystemService("bluetooth");
        if (bluetoothManager == null) {
            w.e("MicroMsg.JsApiStartBeaconDiscovery", "bluetoothManager is null!");
            hashMap.put("errCode", Integer.valueOf(11001));
            mVar.x(i, d("fail", hashMap));
            return;
        }
        BluetoothAdapter adapter = bluetoothManager.getAdapter();
        if (adapter == null) {
            w.e("MicroMsg.JsApiStartBeaconDiscovery", "bluetoothAdapter is null!");
            hashMap.put("errCode", Integer.valueOf(11001));
            mVar.x(i, d("fail", hashMap));
            return;
        }
        String h = a.h(mVar);
        com.tencent.mm.u.q.b fO = q.yC().fO(h);
        if (adapter.isDiscovering() || fO != null) {
            w.e("MicroMsg.JsApiStartBeaconDiscovery", "bluetoothAdapter is Discovering!");
            hashMap.put("errCode", Integer.valueOf(11003));
            mVar.x(i, d("fail", hashMap));
            return;
        }
        fO = q.yC().n(h, true);
        LeScanCallback leScanCallback = (a) fO.fS("key_bluetooth_le_scaner");
        if (leScanCallback == null) {
            w.e("MicroMsg.JsApiStartBeaconDiscovery", "bluetoothLEScaner is null!");
            leScanCallback = new a(this, mVar);
            fO.l("key_bluetooth_le_scaner", leScanCallback);
        }
        if (adapter.isEnabled()) {
            if (this.iRP.has("uuids")) {
                List arrayList = new ArrayList();
                try {
                    JSONArray jSONArray = new JSONArray(this.iRP.optString("uuids"));
                    this.iSt = new UUID[jSONArray.length()];
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        String string = jSONArray.getString(i2);
                        arrayList.add(string);
                        w.d("MicroMsg.JsApiStartBeaconDiscovery", "uuid %s", new Object[]{string});
                        this.iSt[i2] = UUID.fromString(string);
                    }
                } catch (JSONException e) {
                    w.e("MicroMsg.JsApiStartBeaconDiscovery", "get uuid error!");
                    hashMap.put("errCode", Integer.valueOf(11001));
                    mVar.x(i, d("fail", hashMap));
                    return;
                }
            }
            if (this.iSt == null || this.iSt.length <= 0) {
                hashMap.put("errCode", Integer.valueOf(11001));
                mVar.x(i, d("fail", hashMap));
                return;
            }
            a.TE();
            adapter.startLeScan(leScanCallback);
            hashMap.put("errCode", Integer.valueOf(0));
            mVar.x(i, d("ok", hashMap));
            b bVar = new b();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("available", true);
                jSONObject2.put("discovering", true);
            } catch (JSONException e2) {
                w.e("MicroMsg.JsApiStartBeaconDiscovery", "put JSON data error : %s", new Object[]{e2});
            }
            w.d("MicroMsg.JsApiStartBeaconDiscovery", "onBeaconServiceChanged %s", new Object[]{jSONObject2.toString()});
            e ad = bVar.ad(mVar.ivH, mVar.hashCode());
            ad.mData = jSONObject2.toString();
            ad.SR();
            if (iRM == null) {
                iRM = new BroadcastReceiver(this) {
                    final /* synthetic */ c iSu;

                    {
                        this.iSu = r1;
                    }

                    public final void onReceive(Context context, Intent intent) {
                        if (intent == null) {
                            w.i("MicroMsg.JsApiStartBeaconDiscovery", "Receive intent failed");
                            return;
                        }
                        boolean z;
                        int i;
                        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                        if (defaultAdapter != null) {
                            int state = defaultAdapter.getState();
                            if (state == 12 || state == 11) {
                                z = true;
                                i = 1;
                            } else if (state == 10 || state == 13) {
                                z = false;
                                i = 1;
                            } else {
                                z = false;
                                i = 0;
                            }
                            w.i("MicroMsg.JsApiStartBeaconDiscovery", "bluetoothAdapter state: %s", new Object[]{Integer.valueOf(state)});
                        } else {
                            z = false;
                            i = 0;
                        }
                        if (i != 0) {
                            b bVar = new b();
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("available", z);
                                jSONObject.put("discovering", false);
                            } catch (JSONException e) {
                                w.e("MicroMsg.JsApiStartBeaconDiscovery", "put JSON data error : %s", new Object[]{e});
                            }
                            w.i("MicroMsg.JsApiStartBeaconDiscovery", "OnBeaconServiceChangedEvent %s", new Object[]{jSONObject.toString()});
                            if (this.iSu.iwq != null) {
                                e ad = bVar.ad(this.iSu.iwq.ivH, this.iSu.iwq.hashCode());
                                ad.mData = jSONObject.toString();
                                ad.SR();
                            }
                        }
                        if (this.iSu.iwq != null && c.iRM != null) {
                            this.iSu.iwq.mContext.unregisterReceiver(c.iRM);
                            c.iRM = null;
                        }
                    }
                };
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            mVar.mContext.registerReceiver(iRM, intentFilter);
            com.tencent.mm.plugin.appbrand.e.a(mVar.ivH, new com.tencent.mm.plugin.appbrand.e.b(this) {
                final /* synthetic */ c iSu;

                public final void onDestroy() {
                    w.i("MicroMsg.JsApiStartBeaconDiscovery", "onDestroy");
                    com.tencent.mm.plugin.appbrand.e.b(mVar.ivH, this);
                    if (this.iSu.iwq != null && c.iRM != null) {
                        this.iSu.iwq.mContext.unregisterReceiver(c.iRM);
                    }
                }
            });
            return;
        }
        hashMap.put("errCode", Integer.valueOf(11001));
        mVar.x(i, d("fail", hashMap));
    }
}
