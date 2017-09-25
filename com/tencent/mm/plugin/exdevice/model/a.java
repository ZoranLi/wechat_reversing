package com.tencent.mm.plugin.exdevice.model;

import android.os.Bundle;
import com.tencent.mm.e.a.dm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.w;

public final class a extends com.tencent.mm.plugin.exdevice.service.n.a {
    private static final a laS = new a();

    private a() {
    }

    public static a aoY() {
        return laS;
    }

    public final Bundle g(int i, Bundle bundle) {
        w.i("MicroMsg.exdevice.ExDeviceInvokerHandler", "onExdeviceInvoke, action code = %d", new Object[]{Integer.valueOf(i)});
        if (bundle != null) {
            switch (i) {
                case 0:
                    if (bundle != null) {
                        int i2 = bundle.getInt("key_state");
                        w.i("MicroMsg.exdevice.ExDeviceInvokerHandler", "handleOnBluetoothStateChange, state = %d", new Object[]{Integer.valueOf(i2)});
                        if (-1 != i2) {
                            b dmVar = new dm();
                            dmVar.fHu.fHv = i2;
                            if (!com.tencent.mm.sdk.b.a.urY.m(dmVar)) {
                                w.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "EventCenter.instance.publish failed!!!");
                                break;
                            }
                        }
                        w.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "invalid state, just leave!!!");
                        break;
                    }
                    w.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "null == aData");
                    break;
                    break;
                default:
                    break;
            }
        }
        w.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "null == aData");
        return null;
    }
}
