package com.tencent.mm.plugin.h.a.c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.UUID;
import junit.framework.Assert;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
public final class a {
    public static final UUID jUi = UUID.fromString("e5b152ed-6b46-09e9-4678-665e9a972cbc");
    public static final UUID jUj = UUID.fromString("e5b152ed-6b46-09e9-4678-665e9a972cbc");
    public final BroadcastReceiver iRM = new BroadcastReceiver(this) {
        final /* synthetic */ a jUm;

        {
            this.jUm = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                w.i("MicroMsg.exdevice.BluetoothChatManager", "------onReceive------ action  = " + action);
                BluetoothDevice bluetoothDevice;
                if ("android.bluetooth.device.action.FOUND".equals(action)) {
                    bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    if (bluetoothDevice.getBondState() != 12) {
                        this.jUm.jUk.br(bluetoothDevice.getAddress(), bluetoothDevice.getName());
                    }
                } else if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(action)) {
                    this.jUm.jUk.acX();
                } else if ("android.bluetooth.adapter.action.SCAN_MODE_CHANGED".equals(action)) {
                    a aVar;
                    switch (intent.getIntExtra("android.bluetooth.adapter.extra.SCAN_MODE", -1)) {
                        case 20:
                        case 21:
                            aVar = this.jUm.jUk;
                            return;
                        case 23:
                            aVar = this.jUm.jUk;
                            return;
                        default:
                            return;
                    }
                } else if ("android.bluetooth.device.action.ACL_DISCONNECTED".equals(action)) {
                    String address = ((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")).getAddress();
                    if (this.jUm.jRd.containsKey(Long.valueOf(com.tencent.mm.plugin.exdevice.j.b.vx(address)))) {
                        w.i("MicroMsg.exdevice.BluetoothChatManager", "------ACTION_ACL_DISCONNECTED------ device name = %s, device Mac = %s", new Object[]{bluetoothDevice.getName(), address});
                        if (this.jUm.jUk != null) {
                            this.jUm.jUk.e(com.tencent.mm.plugin.exdevice.j.b.vx(address), false);
                        }
                    }
                }
            }
        }
    };
    public BluetoothAdapter jQw;
    public HashMap<Long, b> jRd = new HashMap();
    public a jUk;
    public Context jUl;
    private Runnable lw;
    public ae mHandler;
    public boolean mIsInit = false;

    public static abstract class a {
        public void d(long j, long j2, long j3) {
        }

        public void br(String str, String str2) {
        }

        public void acX() {
        }

        public void e(long j, boolean z) {
        }

        public void b(long j, byte[] bArr) {
        }

        public void f(long j, boolean z) {
        }

        public void b(long j, int i, String str) {
        }
    }

    private final class b implements Runnable {
        private long jRo = 0;
        private long jRp = 0;
        final /* synthetic */ a jUm;

        public b(a aVar, long j, long j2) {
            this.jUm = aVar;
            this.jRo = j;
            this.jRp = j2;
        }

        public final void run() {
            a aVar = this.jUm;
            b bVar = new b(this.jRo);
            long j = bVar.jRv;
            b bVar2 = (b) aVar.jRd.remove(Long.valueOf(j));
            if (bVar2 != null) {
                bVar2.disconnect();
            }
            aVar.jRd.put(Long.valueOf(j), bVar);
            if (this.jUm.jUk != null) {
                this.jUm.jUk.d(j, this.jRo, this.jRp);
            }
        }
    }

    public a(af afVar) {
        this.mHandler = new ae(afVar.nJF.getLooper());
        this.lw = new Runnable(this) {
            final /* synthetic */ a jUm;

            {
                this.jUm = r1;
            }

            public final void run() {
                if (this.jUm.jQw.isDiscovering()) {
                    this.jUm.jQw.cancelDiscovery();
                }
            }
        };
    }

    public final boolean adk() {
        Assert.assertTrue(this.mIsInit);
        if (this.jQw == null) {
            return false;
        }
        return true;
    }

    private boolean adl() {
        if (!this.jQw.isDiscovering()) {
            return true;
        }
        if (this.jQw.cancelDiscovery()) {
            this.mHandler.removeCallbacks(this.lw);
            return true;
        }
        w.e("MicroMsg.exdevice.BluetoothChatManager", "mAdapter.cancelDiscovery Failed!!!");
        return false;
    }

    public final boolean cT(boolean z) {
        w.i("MicroMsg.exdevice.BluetoothChatManager", "scanDevices" + (z ? "true" : "false"));
        Assert.assertTrue(this.mIsInit);
        if (!adk()) {
            w.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
            return false;
        } else if (!z) {
            return adl();
        } else {
            if (this.jQw.isDiscovering() && !adl()) {
                return false;
            }
            if (this.jQw.startDiscovery()) {
                this.mHandler.postDelayed(this.lw, 10000);
                return true;
            }
            w.e("MicroMsg.exdevice.BluetoothChatManager", "mAdapter.startDiscovery() Failed");
            return false;
        }
    }
}
