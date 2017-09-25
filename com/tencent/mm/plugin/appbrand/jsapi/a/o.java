package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothManager;
import android.util.Base64;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.q.b;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

@TargetApi(18)
public final class o extends a {
    private static final int CTRL_INDEX = 184;
    private static final String NAME = "writeBLECharacteristicValue";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            w.e("MicroMsg.JsApiWriteBLECharacteristicValue", "JsApiWriteBLECharacteristicValue data is null");
            mVar.x(i, d("fail:data is null", null));
            return;
        }
        w.i("MicroMsg.JsApiWriteBLECharacteristicValue", "writeBLECharacteristicValue data %s", new Object[]{jSONObject});
        Map hashMap = new HashMap();
        if (f.ep(18)) {
            w.e("MicroMsg.JsApiWriteBLECharacteristicValue", "API version is below 18!");
            hashMap.put("errCode", Integer.valueOf(10009));
            mVar.x(i, d("fail", hashMap));
        } else if (a.iRD) {
            BluetoothManager bluetoothManager = (BluetoothManager) mVar.mContext.getSystemService("bluetooth");
            if (bluetoothManager == null) {
                w.e("MicroMsg.JsApiWriteBLECharacteristicValue", "bluetoothManager is null!");
                hashMap.put("errCode", Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
                mVar.x(i, d("fail", hashMap));
                return;
            }
            BluetoothAdapter adapter = bluetoothManager.getAdapter();
            if (adapter == null || !adapter.isEnabled()) {
                w.e("MicroMsg.JsApiWriteBLECharacteristicValue", "bluetoothAdapter is null or not enable!");
                hashMap.put("errCode", Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
                mVar.x(i, d("fail", hashMap));
                return;
            }
            String optString = jSONObject.optString("deviceId");
            String optString2 = jSONObject.optString("serviceId");
            String optString3 = jSONObject.optString("characteristicId");
            String optString4 = jSONObject.optString(Columns.VALUE);
            b f = a.f(mVar);
            BluetoothGatt bluetoothGatt = (BluetoothGatt) f.fS("key_bluetooth_gatt" + optString);
            if (bluetoothGatt == null) {
                w.e("MicroMsg.JsApiWriteBLECharacteristicValue", "get bluetoothGatt failed, bluetoothGatt is null!");
                hashMap.put("errCode", Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
                mVar.x(i, d("fail", hashMap));
                return;
            }
            BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) f.fS(optString + optString2 + optString3);
            if (bluetoothGattCharacteristic == null) {
                w.e("MicroMsg.JsApiWriteBLECharacteristicValue", "get characteristics failed !");
                hashMap.put("errCode", Integer.valueOf(10005));
                mVar.x(i, d("fail", hashMap));
                return;
            }
            bluetoothGattCharacteristic.setValue(L(Base64.decode(optString4, 2)));
            a.d(mVar);
            a.hN(i);
            boolean writeCharacteristic = bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
            w.i("MicroMsg.JsApiWriteBLECharacteristicValue", "start write retWrite: " + writeCharacteristic);
            if (writeCharacteristic) {
                int properties = bluetoothGattCharacteristic.getProperties();
                if ((properties & 4) != 0 && (properties & 8) == 0) {
                    hashMap.put("errCode", Integer.valueOf(0));
                    mVar.x(i, d("ok", hashMap));
                    return;
                }
                return;
            }
            w.e("MicroMsg.JsApiWriteBLECharacteristicValue", "start write fail..");
            hashMap.put("errCode", Integer.valueOf(10008));
            mVar.x(i, d("fail", hashMap));
        } else {
            w.e("MicroMsg.JsApiWriteBLECharacteristicValue", "bluetooth is not init!");
            hashMap.put("errCode", Integer.valueOf(10000));
            mVar.x(i, d("fail", hashMap));
        }
    }

    private static byte[] L(byte[] bArr) {
        int i = 0;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        int i2;
        int length = bArr.length;
        if (bArr.length < length) {
            w.w("MicroMsg.JsApiWriteBLECharacteristicValue", "data length is shorter then print command length");
            length = bArr.length;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (i2 = 0; i2 < length; i2++) {
            int i3 = bArr[i2] & 255;
            if (i3 < 16) {
                stringBuilder.append("0");
            }
            stringBuilder.append(Integer.toHexString(i3));
        }
        String toUpperCase = stringBuilder.toString().toUpperCase(Locale.US);
        w.d("MicroMsg.JsApiWriteBLECharacteristicValue", "write data = %s", new Object[]{toUpperCase});
        if (toUpperCase == null || toUpperCase.equals("")) {
            return new byte[0];
        }
        i2 = toUpperCase.toUpperCase().length() / 2;
        char[] toCharArray = toUpperCase.toCharArray();
        byte[] bArr2 = new byte[i2];
        while (i < i2) {
            i3 = i * 2;
            bArr2[i] = (byte) (((byte) "0123456789ABCDEF".indexOf(toCharArray[i3 + 1])) | (((byte) "0123456789ABCDEF".indexOf(toCharArray[i3])) << 4));
            i++;
        }
        return bArr2;
    }
}
