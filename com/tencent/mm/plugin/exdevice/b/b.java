package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.bd.a;
import com.tencent.mm.sdk.platformtools.w;

public final class b extends d {
    public b(long j, int i, int i2, byte[] bArr) {
        super(j, i, i2, bArr);
        w.i("MicroMsg.exdevice.ExDeviceCmdAuth", "ExDeviceCmdAuth deviceId = " + j + " seq = " + i + " cmdId = " + i2);
    }

    public final void a(int i, String str, byte[] bArr) {
        w.i("MicroMsg.exdevice.ExDeviceCmdAuth", "------setAuthResponse------ret = " + i + "errMsg = " + str);
        a bVar = new com.tencent.mm.plugin.exdevice.e.b();
        bVar.lfi = J(i, str);
        bVar.leP = com.tencent.mm.bd.b.aU(bArr);
        this.laz = bVar;
        this.lax = (short) 20001;
    }

    protected final a ah(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            w.e("MicroMsg.exdevice.ExDeviceCmdAuth", "paras body is null");
            return null;
        }
        a aVar = new com.tencent.mm.plugin.exdevice.e.a();
        try {
            aVar.aD(bArr);
            this.laA = aVar;
            w.i("MicroMsg.exdevice.ExDeviceCmdAuth", "------AuthRequest------ ClientVersion = " + aVar.leI + " DeviceName = " + aVar.jNn + " Language = " + aVar.leO + " TimeZone = " + aVar.leN);
            return aVar;
        } catch (Throwable e) {
            w.e("MicroMsg.exdevice.ExDeviceCmdAuth", "AuthRequest.parseFrom Failed!!! %s", new Object[]{e.getMessage()});
            w.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdAuth", e, "", new Object[0]);
            return null;
        }
    }
}
