package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.plugin.exdevice.i.e;
import com.tencent.mm.plugin.exdevice.i.f;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.w;

public final class a extends com.tencent.mm.plugin.exdevice.service.i.a {
    private static a lar = null;

    private static class a implements Runnable {
        private long jUL = -1;
        private int las = -1;
        private int lau = -1;
        private int lav;
        private byte[] law = null;

        public a(int i, long j, int i2, int i3, byte[] bArr) {
            this.jUL = j;
            this.las = i2;
            this.lau = i3;
            this.law = bArr;
            this.lav = i;
        }

        public final void aoO() {
            if (this.jUL == -1 || this.las == -1 || this.lau == -1) {
                w.e("MicroMsg.RequestProcessThread", "invalid arguments, do nothing");
                return;
            }
            switch (this.lau) {
                case CdnLogic.MediaType_FAVORITE_FILE /*10001*/:
                    u.apV().a(new e(this.lav, this.jUL, this.las, this.lau, this.law));
                    return;
                case CdnLogic.MediaType_FAVORITE_VIDEO /*10002*/:
                    k aoU = k.aoU();
                    aoU.mHandler.obtainMessage(1, this.lav, 0, new f(this.jUL, this.las, this.lau, this.law)).sendToTarget();
                    return;
                case 10003:
                    u.apV().a(new f(this.lav, this.jUL, this.las, this.lau, this.law));
                    return;
                default:
                    w.e("MicroMsg.RequestProcessThread", "unknown cmdId = %d, do nothing", new Object[]{Integer.valueOf(this.lau)});
                    return;
            }
        }

        public final void run() {
            aoO();
        }
    }

    private a() {
    }

    public static a aoN() {
        if (lar != null) {
            return lar;
        }
        a aVar = new a();
        lar = aVar;
        return aVar;
    }

    public final void a(int i, long j, int i2, int i3, byte[] bArr) {
        int i4;
        String str = "MicroMsg.exdevice.DeviceRequestManager";
        String str2 = "------onDeviceRequest------ errorCode = %d, deviceId = %d, seq = %d, cmdId = %d, datalength = %d";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Long.valueOf(j);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(i3);
        objArr[4] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        w.i(str, str2, objArr);
        if (i == 0) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        com.tencent.mm.plugin.exdevice.g.a.k(j, i4);
        if (b.aj(bArr) == null) {
            w.e("MicroMsg.exdevice.DeviceRequestManager", "dataIn is null!!! Just leave without process data");
            return;
        }
        w.d("MicroMsg.exdevice.DeviceRequestManager", "data dump = %s", new Object[]{b.aj(bArr)});
        new a(i, j, i2, i3, bArr).aoO();
    }
}
