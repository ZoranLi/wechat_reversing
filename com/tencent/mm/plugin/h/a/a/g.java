package com.tencent.mm.plugin.h.a.a;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class g extends j {
    private byte jQO = (byte) 0;

    final boolean W(byte[] bArr) {
        if (bg.bm(bArr)) {
            w.e("MicroMsg.exdevice.IBeaconTLVSectionA", "valueByte is null or nil");
            return false;
        } else if (2 != this.mLength) {
            w.d("MicroMsg.exdevice.IBeaconTLVSectionA", "IBEACON_TLV_SECTION_A_LENGTH != mLength(%d)", new Object[]{Integer.valueOf(this.mLength)});
            return false;
        } else {
            this.jQO = bArr[0];
            return true;
        }
    }
}
