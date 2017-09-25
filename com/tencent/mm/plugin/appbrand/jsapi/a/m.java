package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.ParcelUuid;
import android.util.Base64;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class m extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 176;
    private static final String NAME = "startBluetoothDevicesDiscovery";
    public boolean iRO;
    public JSONObject iRP;

    public class a implements LeScanCallback {
        private Map<String, JSONObject> iRG;
        public com.tencent.mm.plugin.appbrand.m iRQ;
        private aj iRR = null;
        public final ParcelUuid iRS = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
        final /* synthetic */ m iRT;

        public a(m mVar, com.tencent.mm.plugin.appbrand.m mVar2) {
            this.iRT = mVar;
            this.iRQ = mVar2;
            this.iRG = a.Tx();
            this.iRR = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
                final /* synthetic */ a iRU;

                {
                    this.iRU = r1;
                }

                public final boolean oQ() {
                    c cVar = new c();
                    Map Tx = a.Tx();
                    JSONArray jSONArray = new JSONArray();
                    for (String str : Tx.keySet()) {
                        jSONArray.put(Tx.get(str));
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("devices", jSONArray);
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.JsApiStartBluetoothDevicesDiscovery", e, "", new Object[0]);
                    }
                    if (jSONArray.length() > 0 && a.iRD) {
                        e ad = cVar.ad(this.iRU.iRQ.ivH, this.iRU.iRQ.hashCode());
                        ad.mData = jSONObject.toString();
                        ad.SR();
                        a.TC();
                        w.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", " run OnBluetoothDeviceFoundEvent in onTimerExpired!");
                    }
                    return true;
                }
            }, false);
        }

        public final void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            a(bluetoothDevice, i, bArr);
        }

        private synchronized void a(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            if (bluetoothDevice == null) {
                w.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "scan device null,return..");
            } else {
                String mz = bg.mz(bluetoothDevice.getName());
                String address = bluetoothDevice.getAddress();
                w.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "onLeScan for deviceId : " + address + ",name : " + mz);
                if (!bg.mA(address)) {
                    this.iRT.iRO = this.iRT.iRP.optBoolean("allowDuplicatesKey");
                    if (this.iRT.iRO || !this.iRG.containsKey(address)) {
                        Object str;
                        List<ParcelUuid> arrayList = new ArrayList();
                        String K = K(bArr);
                        byte[] a = a(bArr, arrayList);
                        if (a != null) {
                            str = new String(Base64.encode(a, 2));
                        } else {
                            str = null;
                        }
                        JSONArray jSONArray = new JSONArray();
                        for (ParcelUuid uuid : arrayList) {
                            jSONArray.put(uuid.getUuid().toString().toUpperCase());
                        }
                        synchronized (this) {
                            if (this.iRT.iRO || !this.iRG.containsKey(address)) {
                                c cVar = new c();
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("deviceId", address);
                                    jSONObject.put("name", mz);
                                    jSONObject.put("RSSI", i);
                                    jSONObject.put("advertisData", str);
                                    jSONObject.put("advertisServiceUUIDs", jSONArray);
                                    jSONObject.put("localName", K);
                                    this.iRG.put(address, jSONObject);
                                } catch (JSONException e) {
                                    w.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", new Object[]{e});
                                }
                                int optInt = this.iRT.iRP.optInt("interval");
                                JSONArray jSONArray2 = new JSONArray();
                                jSONArray2.put(jSONObject);
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put("devices", jSONArray2);
                                } catch (Throwable e2) {
                                    w.printErrStackTrace("MicroMsg.JsApiStartBluetoothDevicesDiscovery", e2, "", new Object[0]);
                                }
                                if (optInt > 0) {
                                    if (this.iRR.bJq()) {
                                        long j = (long) optInt;
                                        this.iRR.v(j, j);
                                        w.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "start timer interval %s", new Object[]{Integer.valueOf(optInt)});
                                    }
                                } else if (a.iRD) {
                                    e ad = cVar.ad(this.iRQ.ivH, this.iRQ.hashCode());
                                    ad.mData = jSONObject2.toString();
                                    ad.SR();
                                } else {
                                    w.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "bluetooth is not init,return...");
                                }
                            } else {
                                w.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "DuplicatesKey,deviceId : " + address);
                            }
                        }
                    }
                }
            }
        }

        private static String K(byte[] bArr) {
            if (bArr == null) {
                return "";
            }
            String str = "";
            int i = 0;
            while (i < bArr.length) {
                int i2 = i + 1;
                i = bArr[i] & 255;
                if (i == 0) {
                    return str;
                }
                i--;
                int i3 = i2 + 1;
                switch (bArr[i2] & 255) {
                    case 8:
                    case 9:
                        str = new String(c(bArr, i3, i));
                        break;
                    default:
                        break;
                }
                i += i3;
            }
            return str;
        }

        private byte[] a(byte[] bArr, List<ParcelUuid> list) {
            byte[] bArr2 = null;
            if (bArr != null) {
                int i = 0;
                while (i < bArr.length) {
                    int i2 = i + 1;
                    i = bArr[i] & 255;
                    if (i != 0) {
                        byte[] bArr3;
                        int i3 = i - 1;
                        int i4 = i2 + 1;
                        switch (bArr[i2] & 255) {
                            case 2:
                            case 3:
                                a(bArr, i4, i3, 2, list);
                                bArr3 = bArr2;
                                break;
                            case 4:
                            case 5:
                                a(bArr, i4, i3, 4, list);
                                bArr3 = bArr2;
                                break;
                            case 6:
                            case 7:
                                a(bArr, i4, i3, 16, list);
                                bArr3 = bArr2;
                                break;
                            case 8:
                            case 9:
                                bArr3 = bArr2;
                                break;
                            case 255:
                                bArr3 = c(bArr, i4, i3);
                                break;
                            default:
                                bArr3 = bArr2;
                                break;
                        }
                        bArr2 = bArr3;
                        i = i4 + i3;
                    }
                }
            }
            return bArr2;
        }

        private static byte[] c(byte[] bArr, int i, int i2) {
            Object obj = new byte[i2];
            System.arraycopy(bArr, i, obj, 0, i2);
            return obj;
        }

        private int a(byte[] bArr, int i, int i2, int i3, List<ParcelUuid> list) {
            while (i2 > 0) {
                byte[] c = c(bArr, i, i3);
                int length = c.length;
                if (length == 2 || length == 4 || length == 16) {
                    Object parcelUuid;
                    if (length == 16) {
                        ByteBuffer order = ByteBuffer.wrap(c).order(ByteOrder.LITTLE_ENDIAN);
                        parcelUuid = new ParcelUuid(new UUID(order.getLong(8), order.getLong(0)));
                    } else {
                        long j;
                        if (length == 2) {
                            j = ((long) ((c[1] & 255) << 8)) + ((long) (c[0] & 255));
                        } else {
                            j = ((long) ((c[3] & 255) << 24)) + ((((long) (c[0] & 255)) + ((long) ((c[1] & 255) << 8))) + ((long) ((c[2] & 255) << 16)));
                        }
                        parcelUuid = new ParcelUuid(new UUID(this.iRS.getUuid().getMostSignificantBits() + (j << 32), this.iRS.getUuid().getLeastSignificantBits()));
                    }
                    list.add(parcelUuid);
                    i2 -= i3;
                    i += i3;
                } else {
                    throw new IllegalArgumentException("uuidBytes length invalid - " + length);
                }
            }
            return i;
        }
    }

    private static class b extends e {
        private static final int CTRL_INDEX = 189;
        private static final String NAME = "onBluetoothAdapterStateChange";
    }

    private static class c extends e {
        private static final int CTRL_INDEX = 190;
        private static final String NAME = "onBluetoothDeviceFound";
    }

    public final void a(com.tencent.mm.plugin.appbrand.m mVar, JSONObject jSONObject, int i) {
        if (jSONObject != null) {
            w.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "startBluetoothDevicesDiscovery data %s", new Object[]{jSONObject.toString()});
        }
        this.iRP = jSONObject;
        Map hashMap = new HashMap();
        if (f.ep(18)) {
            w.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "API version is below 18!");
            hashMap.put("errCode", Integer.valueOf(10009));
            mVar.x(i, d("fail", hashMap));
        } else if (a.iRD) {
            BluetoothManager bluetoothManager = (BluetoothManager) mVar.mContext.getSystemService("bluetooth");
            if (bluetoothManager == null) {
                w.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "bluetoothManager is null!");
                hashMap.put("isDiscovering", Boolean.valueOf(false));
                hashMap.put("errCode", Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
                mVar.x(i, d("fail", hashMap));
                return;
            }
            BluetoothAdapter adapter = bluetoothManager.getAdapter();
            if (adapter == null || !adapter.isEnabled()) {
                w.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "bluetoothAdapter is null!");
                hashMap.put("isDiscovering", Boolean.valueOf(false));
                hashMap.put("errCode", Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
                mVar.x(i, d("fail", hashMap));
                return;
            }
            if (!(VERSION.RELEASE.equals("6.0") || VERSION.RELEASE.equals("6.0.0") || VERSION.SDK_INT < 23)) {
                LocationManager locationManager = (LocationManager) ab.getContext().getSystemService("location");
                if (locationManager != null) {
                    boolean isProviderEnabled = locationManager.isProviderEnabled("gps");
                    w.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "isGPSEnable " + isProviderEnabled + ", isNetworkEnable" + locationManager.isProviderEnabled(TencentLocation.NETWORK_PROVIDER));
                }
            }
            com.tencent.mm.u.q.b f = a.f(mVar);
            LeScanCallback leScanCallback = (a) f.fS("key_bluetooth_le_scaner");
            if (leScanCallback == null) {
                w.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "bluetoothLEScaner is null!");
                leScanCallback = new a(this, mVar);
                f.l("key_bluetooth_le_scaner", leScanCallback);
            }
            if (adapter.isEnabled()) {
                boolean startLeScan;
                UUID[] uuidArr = null;
                if (this.iRP.has("services")) {
                    List arrayList = new ArrayList();
                    try {
                        JSONArray jSONArray = new JSONArray(this.iRP.optString("services"));
                        uuidArr = new UUID[jSONArray.length()];
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            String toUpperCase = jSONArray.getString(i2).toUpperCase();
                            arrayList.add(toUpperCase);
                            w.d("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "servicesUuid %s", new Object[]{toUpperCase});
                            uuidArr[i2] = UUID.fromString(toUpperCase);
                        }
                    } catch (JSONException e) {
                        w.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "get uuid error!");
                        hashMap.put("isDiscovering", Boolean.valueOf(false));
                        hashMap.put("errCode", Integer.valueOf(10004));
                        mVar.x(i, d("fail", hashMap));
                        return;
                    }
                }
                if (uuidArr == null || uuidArr.length <= 0) {
                    startLeScan = adapter.startLeScan(leScanCallback);
                } else {
                    startLeScan = adapter.startLeScan(uuidArr, leScanCallback);
                }
                if (startLeScan) {
                    hashMap.put("isDiscovering", Boolean.valueOf(true));
                    hashMap.put("errCode", Integer.valueOf(0));
                    mVar.x(i, d("ok", hashMap));
                    b bVar = new b();
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("available", true);
                        jSONObject2.put("discovering", true);
                    } catch (JSONException e2) {
                        w.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", new Object[]{e2});
                    }
                    w.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothAdapterStateChange %s", new Object[]{jSONObject2.toString()});
                    e ad = bVar.ad(mVar.ivH, mVar.hashCode());
                    ad.mData = jSONObject2.toString();
                    ad.SR();
                    return;
                }
                w.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "startLeScan fail...");
                hashMap.put("isDiscovering", Boolean.valueOf(false));
                hashMap.put("errCode", Integer.valueOf(10008));
                mVar.x(i, d("fail", hashMap));
                return;
            }
            hashMap.put("isDiscovering", Boolean.valueOf(false));
            hashMap.put("errCode", Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
            mVar.x(i, d("fail", hashMap));
        } else {
            w.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "bluetooth is not init!");
            hashMap.put("errCode", Integer.valueOf(10000));
            mVar.x(i, d("fail", hashMap));
        }
    }
}
