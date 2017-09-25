package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.util.Base64;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class d extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 180;
    private static final String NAME = "createBLEConnection";

    private class a extends BluetoothGattCallback {
        private int iLf;
        private WeakReference<m> iRJ;
        final /* synthetic */ d iRK;
        private String ivH;

        private a(d dVar, m mVar, int i) {
            this.iRK = dVar;
            this.iRJ = new WeakReference(mVar);
            this.ivH = mVar.ivH;
            this.iLf = i;
        }

        private void pq(String str) {
            if (this.iRJ.get() != null) {
                ((m) this.iRJ.get()).x(this.iLf, str);
            }
        }

        public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            boolean z;
            if (i2 == 2) {
                w.i("MicroMsg.JsApiCreateBLEConnection", "Attempting to start service discovery");
                bluetoothGatt.discoverServices();
                z = true;
            } else {
                if (i2 == 0) {
                    bluetoothGatt.close();
                    w.e("MicroMsg.JsApiCreateBLEConnection", "device not connected!");
                    Map hashMap = new HashMap();
                    hashMap.put("errCode", Integer.valueOf(10003));
                    pq(this.iRK.d("fail", hashMap));
                }
                z = false;
            }
            c cVar = new c();
            JSONObject jSONObject = new JSONObject();
            String address = bluetoothGatt.getDevice().getAddress();
            if (z) {
                Map Tx = a.Tx();
                if (!Tx.containsKey(address)) {
                    JSONObject jSONObject2 = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    try {
                        jSONObject2.put("deviceId", address);
                        jSONObject2.put("name", bluetoothGatt.getDevice().getName());
                        jSONObject2.put("RSSI", 0);
                        jSONObject2.put("advertisData", "");
                        jSONObject2.put("advertisServiceUUIDs", jSONArray);
                        jSONObject2.put("localName", "");
                        Tx.put(address, jSONObject2);
                    } catch (JSONException e) {
                        w.e("MicroMsg.JsApiCreateBLEConnection", "put JSON data error : %s", new Object[]{e});
                    }
                }
            }
            w.i("MicroMsg.JsApiCreateBLEConnection", "onConnectionStateChange with deviceId : " + address);
            try {
                jSONObject.put("deviceId", address);
                jSONObject.put("connected", z);
            } catch (JSONException e2) {
                w.e("MicroMsg.JsApiCreateBLEConnection", "put JSON data error : %s", new Object[]{e2});
            }
            w.i("MicroMsg.JsApiCreateBLEConnection", "deviceId %s, state %s", new Object[]{address, Boolean.valueOf(z)});
            if (a.iRD) {
                e ad = cVar.ad(this.ivH, 0);
                ad.mData = jSONObject.toString();
                ad.SR();
                return;
            }
            w.e("MicroMsg.JsApiCreateBLEConnection", "bluetooth is not init,return...");
        }

        public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            if (this.iRJ.get() != null) {
                Map hashMap;
                if (i == 0) {
                    String address = bluetoothGatt.getDevice().getAddress();
                    w.i("MicroMsg.JsApiCreateBLEConnection", "onServicesDiscovered GATT_SUCCESS with deviceId : " + address);
                    com.tencent.mm.u.q.b f = a.f((m) this.iRJ.get());
                    Map hashMap2 = new HashMap();
                    for (BluetoothGattService bluetoothGattService : bluetoothGatt.getServices()) {
                        boolean z = bluetoothGattService.getType() == 0;
                        String toUpperCase = bluetoothGattService.getUuid().toString().toUpperCase();
                        hashMap2.put(toUpperCase, Boolean.valueOf(z));
                        w.i("MicroMsg.JsApiCreateBLEConnection", "type %s, serviceId %s", new Object[]{Boolean.valueOf(z), toUpperCase});
                        String str = ("key_bluetooth_gatt_service" + address + toUpperCase).hashCode();
                        List<BluetoothGattCharacteristic> characteristics = bluetoothGattService.getCharacteristics();
                        JSONArray jSONArray = new JSONArray();
                        if (characteristics != null) {
                            for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
                                String toUpperCase2 = bluetoothGattCharacteristic.getUuid().toString().toUpperCase();
                                int properties = bluetoothGattCharacteristic.getProperties();
                                try {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("read", (properties & 2) != 0);
                                    String str2 = "write";
                                    z = ((properties & 8) == 0 && (properties & 4) == 0) ? false : true;
                                    jSONObject.put(str2, z);
                                    jSONObject.put("notify", (properties & 16) != 0);
                                    jSONObject.put("indicate", (properties & 32) != 0);
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("uuid", toUpperCase2);
                                    jSONObject2.put("properties", jSONObject);
                                    jSONArray.put(jSONObject2);
                                } catch (JSONException e) {
                                    w.e("MicroMsg.JsApiCreateBLEConnection", "JSONException %s", new Object[]{e.getMessage()});
                                }
                                f.l(address + toUpperCase + toUpperCase2, bluetoothGattCharacteristic);
                            }
                        }
                        w.i("MicroMsg.JsApiCreateBLEConnection", "jsonArray %s", new Object[]{jSONArray.toString()});
                        f.l(str, jSONArray);
                    }
                    f.l("key_bluetooth_services_uuid" + address, hashMap2);
                    hashMap = new HashMap();
                    hashMap.put("errCode", Integer.valueOf(0));
                    pq(this.iRK.d("ok", hashMap));
                    return;
                }
                w.i("MicroMsg.JsApiCreateBLEConnection", "onServicesDiscovered fail..");
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(10006));
                pq(this.iRK.d("fail", hashMap));
            }
        }

        public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (i == 0) {
                b bVar = new b();
                String str = new String(Base64.encode(bluetoothGattCharacteristic.getValue(), 2));
                String toUpperCase = bluetoothGattCharacteristic.getUuid().toString().toUpperCase();
                String address = bluetoothGatt.getDevice().getAddress();
                String toUpperCase2 = bluetoothGattCharacteristic.getService().getUuid().toString().toUpperCase();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(Columns.VALUE, str);
                    jSONObject.put("serviceId", toUpperCase2);
                    jSONObject.put("characteristicId", toUpperCase);
                    jSONObject.put("deviceId", address);
                } catch (JSONException e) {
                    w.e("MicroMsg.JsApiCreateBLEConnection", "put JSON data error : %s", new Object[]{e});
                }
                w.i("MicroMsg.JsApiCreateBLEConnection", "read value %s, serviceId %s, uuid %s, deviceId %s", new Object[]{str, toUpperCase2, toUpperCase, address});
                if (a.iRD) {
                    e ad = bVar.ad(this.ivH, 0);
                    ad.mData = jSONObject.toString();
                    ad.SR();
                    return;
                }
                w.e("MicroMsg.JsApiCreateBLEConnection", "bluetooth is not init,return...");
            }
        }

        public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            b bVar = new b();
            String str = new String(Base64.encode(bluetoothGattCharacteristic.getValue(), 2));
            String toUpperCase = bluetoothGattCharacteristic.getUuid().toString().toUpperCase();
            String address = bluetoothGatt.getDevice().getAddress();
            String toUpperCase2 = bluetoothGattCharacteristic.getService().getUuid().toString().toUpperCase();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Columns.VALUE, str);
                jSONObject.put("serviceId", toUpperCase2);
                jSONObject.put("characteristicId", toUpperCase);
                jSONObject.put("deviceId", address);
            } catch (JSONException e) {
                w.e("MicroMsg.JsApiCreateBLEConnection", "put JSON data error : %s", new Object[]{e});
            }
            w.i("MicroMsg.JsApiCreateBLEConnection", "value %s, serviceId %s, uuid %s, deviceId %s", new Object[]{str, toUpperCase2, toUpperCase, address});
            if (a.iRD) {
                e ad = bVar.ad(this.ivH, 0);
                ad.mData = jSONObject.toString();
                ad.SR();
                return;
            }
            w.e("MicroMsg.JsApiCreateBLEConnection", "bluetooth is not init,return...");
        }

        public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            String str = new String(bluetoothGattCharacteristic.getValue());
            String name = bluetoothGatt.getDevice().getName();
            String toUpperCase = bluetoothGattCharacteristic.getUuid().toString().toUpperCase();
            w.i("MicroMsg.JsApiCreateBLEConnection", "write name %s, uuid %s, value %s, status %s", new Object[]{name, toUpperCase, str, Integer.valueOf(i)});
            if (!a.iRD) {
                w.e("MicroMsg.JsApiCreateBLEConnection", "bluetooth is not init,return...");
            } else if (i == 0) {
                a.Tz().x(a.TA(), "{\"errCode\":0,\"errMsg\":\"writeBLECharacteristicValue:ok\"}");
            } else {
                a.Tz().x(a.TA(), "{\"errCode\":10008,\"errMsg\":\"writeBLECharacteristicValue:fail\"}");
            }
        }

        public final void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
        }
    }

    private static class b extends e {
        private static final int CTRL_INDEX = 187;
        private static final String NAME = "onBLECharacteristicValueChange";
    }

    private static class c extends e {
        private static final int CTRL_INDEX = 188;
        private static final String NAME = "onBLEConnectionStateChanged";
    }

    public final void a(m mVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            w.e("MicroMsg.JsApiCreateBLEConnection", "JsApiCreateBLEConnection data is null");
            mVar.x(i, d("fail:data is null", null));
            return;
        }
        w.i("MicroMsg.JsApiCreateBLEConnection", "createBLEConnection data %s", new Object[]{jSONObject.toString()});
        Map hashMap;
        if (f.ep(18)) {
            w.e("MicroMsg.JsApiCreateBLEConnection", "API version is below 18!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10009));
            mVar.x(i, d("fail", hashMap));
        } else if (a.iRD) {
            String optString = jSONObject.optString("deviceId");
            BluetoothManager bluetoothManager = (BluetoothManager) mVar.mContext.getSystemService("bluetooth");
            if (bluetoothManager == null) {
                w.e("MicroMsg.JsApiCreateBLEConnection", "bluetoothManager is null!");
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
                mVar.x(i, d("fail", hashMap));
                return;
            }
            BluetoothAdapter adapter = bluetoothManager.getAdapter();
            if (adapter == null) {
                w.e("MicroMsg.JsApiCreateBLEConnection", "bluetoothAdapter is null!");
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
                mVar.x(i, d("fail", hashMap));
            } else if (adapter.isEnabled()) {
                w.i("MicroMsg.JsApiCreateBLEConnection", " get bluetoothDevice with deviceId : " + optString);
                try {
                    BluetoothDevice remoteDevice = adapter.getRemoteDevice(optString);
                    if (remoteDevice == null) {
                        w.e("MicroMsg.JsApiCreateBLEConnection", "bluetoothDevice is null!");
                        hashMap = new HashMap();
                        hashMap.put("errCode", Integer.valueOf(CdnLogic.MediaType_FAVORITE_VIDEO));
                        mVar.x(i, d("fail", hashMap));
                        return;
                    }
                    com.tencent.mm.u.q.b f = a.f(mVar);
                    BluetoothGatt connectGatt = remoteDevice.connectGatt(mVar.mContext, false, new a(mVar, i));
                    if (connectGatt == null) {
                        w.e("MicroMsg.JsApiCreateBLEConnection", "bluetoothGatt is null!");
                        hashMap = new HashMap();
                        hashMap.put("errCode", Integer.valueOf(10003));
                        mVar.x(i, d("fail", hashMap));
                        return;
                    }
                    f.l("key_bluetooth_gatt" + optString, connectGatt);
                } catch (IllegalArgumentException e) {
                    w.e("MicroMsg.JsApiCreateBLEConnection", "macAddress is wrong!");
                    hashMap = new HashMap();
                    hashMap.put("errCode", Integer.valueOf(CdnLogic.MediaType_FAVORITE_VIDEO));
                    mVar.x(i, d("fail", hashMap));
                }
            } else {
                hashMap = new HashMap();
                hashMap.put("isDiscovering", Boolean.valueOf(false));
                hashMap.put("errCode", Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
                mVar.x(i, d("fail", hashMap));
            }
        } else {
            w.e("MicroMsg.JsApiCreateBLEConnection", "bluetooth is not init!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10000));
            mVar.x(i, d("fail", hashMap));
        }
    }
}
