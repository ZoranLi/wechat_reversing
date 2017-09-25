package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothManager;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.q.b;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

@TargetApi(18)
public final class j extends a {
    private static final int CTRL_INDEX = 186;
    private static final String NAME = "notifyBLECharacteristicValueChanged";
    protected static final UUID iRL = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");

    public final void a(m mVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            w.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "JsApiNotifyBLECharacteristicValueChanged data is null");
            mVar.x(i, d("fail:data is null", null));
            return;
        }
        w.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "notifyBLECharacteristicValueChanged!");
        Map hashMap = new HashMap();
        if (f.ep(18)) {
            w.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "API version is below 18!");
            hashMap.put("errCode", Integer.valueOf(10009));
            mVar.x(i, d("fail", hashMap));
        } else if (a.iRD) {
            BluetoothManager bluetoothManager = (BluetoothManager) mVar.mContext.getSystemService("bluetooth");
            if (bluetoothManager == null) {
                w.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "bluetoothManager is null!");
                hashMap.put("errCode", Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
                mVar.x(i, d("fail", hashMap));
                return;
            }
            BluetoothAdapter adapter = bluetoothManager.getAdapter();
            if (adapter == null || !adapter.isEnabled()) {
                w.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "adapter is null or not enabled!");
                hashMap.put("errCode", Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
                mVar.x(i, d("fail", hashMap));
                return;
            }
            String optString = jSONObject.optString("deviceId");
            String optString2 = jSONObject.optString("serviceId");
            String optString3 = jSONObject.optString("characteristicId");
            boolean optBoolean = jSONObject.optBoolean("state");
            w.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", " notifyBLECharacteristicValueChanged deviceID : " + optString + ",serviceId : " + optString2 + ", characteristicId : " + optString3 + ",state : " + optBoolean);
            b f = a.f(mVar);
            BluetoothGatt bluetoothGatt = (BluetoothGatt) f.fS("key_bluetooth_gatt" + optString);
            if (bluetoothGatt == null) {
                w.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "get bluetoothGatt failed, bluetoothGatt is null!");
                hashMap.put("errCode", Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
                mVar.x(i, d("fail", hashMap));
                return;
            }
            BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) f.fS(optString + optString2 + optString3);
            if (bluetoothGattCharacteristic == null) {
                w.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "get characteristics failed !");
                hashMap.put("errCode", Integer.valueOf(10005));
                mVar.x(i, d("fail", hashMap));
                return;
            }
            int properties = bluetoothGattCharacteristic.getProperties();
            if ((properties & 16) == 0 && (properties & 32) == 0) {
                w.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "not support notify and not support indicate...");
                hashMap.put("errCode", Integer.valueOf(10007));
                mVar.x(i, d("fail", hashMap));
                return;
            }
            boolean characteristicNotification = bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, optBoolean);
            w.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "setCharacteristicNotification，state: " + optBoolean + ",suc?" + characteristicNotification);
            BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(iRL);
            if (descriptor == null) {
                w.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "Can not get configure descriptor");
                mVar.x(i, d("fail", hashMap));
                return;
            }
            w.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "Configure descriptor permissions: " + descriptor.getPermissions());
            if ((properties & 16) != 0 && (properties & 32) == 0) {
                w.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "support notify. not support indicate...");
                descriptor.setValue(optBoolean ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
                w.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "writeDescriptor isWriteDescriptorSuc:" + bluetoothGatt.writeDescriptor(descriptor));
            } else if ((properties & 16) != 0 || (properties & 32) == 0) {
                w.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "support both notify and indicate...");
                descriptor.setValue(optBoolean ? BluetoothGattDescriptor.ENABLE_INDICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
                w.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "writeDescriptor isWriteDescriptorSuc:" + bluetoothGatt.writeDescriptor(descriptor));
            } else {
                w.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "not support notify .support indicate...");
                descriptor.setValue(optBoolean ? BluetoothGattDescriptor.ENABLE_INDICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
                w.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "writeDescriptor isWriteDescriptorSuc:" + bluetoothGatt.writeDescriptor(descriptor));
            }
            if (characteristicNotification) {
                hashMap.put("errCode", Integer.valueOf(0));
                mVar.x(i, d("ok", hashMap));
                return;
            }
            w.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "setCharacteristicNotification failed!");
            hashMap.put("errCode", Integer.valueOf(10008));
            mVar.x(i, d("fail", hashMap));
        } else {
            w.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "bluetooth is not init!");
            hashMap.put("errCode", Integer.valueOf(10000));
            mVar.x(i, d("fail", hashMap));
        }
    }
}
