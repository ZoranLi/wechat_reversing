package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class b implements e {
    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.exdevice.ExDeviceMessageService", "onScenend, errType = %d, errCode = %d, errMsg = ", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
    }
}
