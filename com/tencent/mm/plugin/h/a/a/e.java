package com.tencent.mm.plugin.h.a.a;

import com.tencent.mm.plugin.exdevice.j.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class e {
    private final g jQp = new g();
    public final h jQq = new h();

    public final boolean V(byte[] bArr) {
        if (bg.bm(bArr)) {
            w.e("MicroMsg.exdevice.IBeaconProtocal", "dataIn is null or nil");
            return false;
        }
        a aVar = new a(bArr.length);
        aVar.v(bArr, bArr.length);
        boolean a = this.jQp.a(aVar);
        if (a) {
            a = this.jQq.a(aVar);
            if (a) {
                return a;
            }
            w.d("MicroMsg.exdevice.IBeaconProtocal", "mSectionB.ParseTLV Failed!!!");
            return a;
        }
        w.d("MicroMsg.exdevice.IBeaconProtocal", "mSectionA.ParseTLV Failed!!!");
        return a;
    }
}
