package com.tencent.mm.plugin.h.a.e;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.w;

public final class a {
    public static boolean bL(Context context) {
        w.i("MicroMsg.exdevice.BluetoothSDKUtil", "isBLESupported, ret = %b", new Object[]{Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le"))});
        return context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    public static boolean adk() {
        boolean z;
        if (BluetoothAdapter.getDefaultAdapter() != null) {
            z = true;
        } else {
            z = false;
        }
        w.i("MicroMsg.exdevice.BluetoothSDKUtil", "isSupportBC: %b", new Object[]{Boolean.valueOf(z)});
        return z;
    }

    public static boolean adm() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            return false;
        }
        w.i("MicroMsg.exdevice.BluetoothSDKUtil", "isBluetoothOpen: %b", new Object[]{Boolean.valueOf(defaultAdapter.isEnabled())});
        return defaultAdapter.isEnabled();
    }

    @Deprecated
    public static String aL(long j) {
        return b.bG(j);
    }
}
