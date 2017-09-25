package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.bd.a;
import com.tencent.mm.sdk.platformtools.w;

public abstract class d extends c {
    protected a laA = null;
    private short laB = (short) -1;
    private short laC = (short) -1;

    protected abstract a ah(byte[] bArr);

    public d(long j, int i, int i2, byte[] bArr) {
        w.i("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", "onDeviceRequest deviceId = " + j + " seq = " + i + " cmdId = " + i2);
        this.jUL = j;
        this.laB = (short) i2;
        this.laC = (short) i;
        ah(bArr);
    }

    public final short aoP() {
        return this.laB;
    }

    public final short aoQ() {
        return this.laC;
    }

    public final a aoS() {
        return this.laA;
    }

    public final byte[] aoR() {
        try {
            return this.laz.toByteArray();
        } catch (Throwable e) {
            w.e("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", "mResp.toByteArray() Failed!!! %s", new Object[]{e.getMessage()});
            w.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", e, "", new Object[0]);
            return null;
        }
    }
}
