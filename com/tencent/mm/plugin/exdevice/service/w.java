package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.service.k.a;

public class w extends a {
    public void a(long j, int i, int i2, int i3, long j2) {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.exdevice.OnStateChangeCallBack", "onStateChange, deviceId = %s, oldSate = %d, newState = %d, errCode = %d, profileType = %d", new Object[]{b.bG(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)});
    }
}
