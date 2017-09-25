package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;
import com.tencent.mm.plugin.exdevice.e.k;
import com.tencent.mm.plugin.exdevice.e.l;
import com.tencent.mm.sdk.platformtools.w;

public final class f extends d {
    public f(long j, int i, int i2, byte[] bArr) {
        super(j, i, i2, bArr);
        w.i("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "ExDeviceCmdSendDataToManufacturer deviceId = " + j + " seq = " + i + " cmdId = " + i2);
    }

    public final void b(int i, String str, byte[] bArr) {
        w.i("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "setSendDataToManufacturerResponse ret = " + i + str);
        a lVar = new l();
        lVar.lfi = J(i, str);
        if (bArr == null) {
            bArr = new byte[0];
        }
        lVar.jMQ = new b(bArr);
        this.laz = lVar;
        this.lax = (short) 20002;
    }

    protected final a ah(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            w.e("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "data is null");
            return null;
        }
        a kVar = new k();
        try {
            kVar.aD(bArr);
            this.laA = kVar;
            w.i("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "SendDataToManufacturerSvrRequest cmd has been received");
            return kVar;
        } catch (Throwable e) {
            w.e("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "SendDataToManufacturerSvrRequest.parseFrom Failed!!! %s", new Object[]{e.getMessage()});
            w.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", e, "", new Object[0]);
            return null;
        }
    }
}
