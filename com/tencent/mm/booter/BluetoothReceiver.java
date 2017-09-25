package com.tencent.mm.booter;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.compatible.b.e;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.util.Set;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
public class BluetoothReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null && !bg.mA(intent.getAction())) {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter == null) {
                w.d("MicroMsg.BluetoothReceiver", "getDefaultAdapter == null");
                return;
            }
            Set bondedDevices = defaultAdapter.getBondedDevices();
            if (bondedDevices == null || bondedDevices.size() == 0) {
                w.d("MicroMsg.BluetoothReceiver", "getBondedDevices == null");
            } else if (!bg.mA(intent.getAction())) {
                w.d("MicroMsg.BluetoothReceiver", "dkbt action :" + intent.getAction());
                if (ap.zb()) {
                    int intExtra;
                    try {
                        intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
                    } catch (Throwable e) {
                        w.e("MicroMsg.BluetoothReceiver", "%s", bg.g(e));
                        intExtra = 0;
                    }
                    w.d("MicroMsg.BluetoothReceiver", "dkbt  action :" + intent.getAction() + " state:" + intExtra + " isBluetoothScoOn :" + ap.yZ().qI() + " " + ap.yZ().qM());
                    if (intent.getAction().equalsIgnoreCase("android.media.SCO_AUDIO_STATE_CHANGED")) {
                        w.d("MicroMsg.BluetoothReceiver", "just STATE_CHANGED not real STATE_UPDATED" + intent.getAction());
                    } else if (intExtra == 1) {
                        w.d("MicroMsg.BluetoothReceiver", "sco connected!");
                        w.i("MicroMsg.MMAudioManager", "dkbt bluetoothStartSucc %s", ap.yZ().qM());
                        e.gNt = true;
                        r0.ea(1);
                    } else if (intExtra == 0) {
                        w.d("MicroMsg.BluetoothReceiver", "sco disconnected!getStopBluetoothInBR = %s", Integer.valueOf(p.gRl.gPL));
                        if (p.gRl.gPL == 1) {
                            ap.yZ().qH();
                        }
                        ap.yZ().qF();
                    }
                }
            }
        }
    }
}
