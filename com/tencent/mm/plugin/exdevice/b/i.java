package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;
import com.tencent.mm.plugin.exdevice.e.c;
import com.tencent.mm.plugin.exdevice.e.h;
import com.tencent.mm.sdk.platformtools.w;
import java.io.IOException;
import junit.framework.Assert;

public final class i extends j {
    public i(byte[] bArr, int i, long j) {
        a hVar = new h();
        hVar.lfg = new c();
        hVar.jMQ = new b(bArr);
        hVar.jOc = i;
        this.laz = hVar;
        this.jUL = j;
    }

    public final byte[] aoR() {
        Assert.assertNotNull(this.laz);
        try {
            return this.laz.toByteArray();
        } catch (IOException e) {
            w.e("MicroMsg.exdevice.ExDevicePushManufacturerSvrSendData", "mResp.toByteArray() Failed!!! %s", new Object[]{e.getMessage()});
            return null;
        }
    }
}
