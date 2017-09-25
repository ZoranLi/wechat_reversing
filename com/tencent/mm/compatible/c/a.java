package com.tencent.mm.compatible.c;

import android.media.AudioManager;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class a {
    public static boolean a(AudioManager audioManager) {
        if (ap.oS()) {
            return false;
        }
        w.i("MicroMsg.BluetoothUtil", "stop DeviceInfo mCommonInfo getStartBluetoothSco:%s,getStopBluetoothInBU:%s ", Integer.valueOf(p.gRl.gPN), Integer.valueOf(p.gRl.gPM));
        if ((p.gRl.gPM == 1 || p.gRl.gPN == -1) && audioManager.isBluetoothScoOn()) {
            w.i("MicroMsg.BluetoothUtil", "BluetoothUtil stopBluetoothSco stack: %s", bg.bJZ());
            audioManager.stopBluetoothSco();
        }
        return true;
    }
}
