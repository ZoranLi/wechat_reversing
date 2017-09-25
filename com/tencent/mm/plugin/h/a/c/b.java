package com.tencent.mm.plugin.h.a.c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import com.tencent.mm.plugin.h.a.c.c.a;
import com.tencent.mm.plugin.h.a.c.c.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.w;

public final class b {
    public long jRv;
    public BluetoothDevice jRw;
    public long jUn;
    public a jUo = null;
    public com.tencent.mm.plugin.h.a.c.c.b jUp = null;
    public c jUq = null;
    public int mState = 0;

    public b(long j) {
        this.jUn = j;
        this.jRv = j;
        this.jRw = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(com.tencent.mm.plugin.h.a.e.a.aL(j));
    }

    public final void disconnect() {
        w.i("MicroMsg.exdevice.BluetoothChatSession", "disconnect");
        this.mState = 0;
        if (this.jUo != null) {
            this.jUo.disconnect();
            this.jUo = null;
        }
        if (this.jUp != null) {
            this.jUp.cancel();
            e.O(this.jUp);
            this.jUp = null;
        }
        if (this.jUq != null) {
            this.jUq.cancel();
            e.O(this.jUp);
            this.jUq = null;
        }
    }
}
