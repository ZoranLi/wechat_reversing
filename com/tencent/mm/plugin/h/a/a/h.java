package com.tencent.mm.plugin.h.a.a;

import com.tencent.mm.plugin.exdevice.j.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Arrays;

public final class h extends j {
    private static final byte[] jQP = new byte[]{(byte) 76, (byte) 0, (byte) 2, (byte) 21};
    private byte[] jQQ = null;
    public byte[] jQR = null;
    public short jQS = (short) -1;
    public short jQT = (short) -1;
    public int jQU = 0;

    final boolean W(byte[] bArr) {
        if (bg.bm(bArr)) {
            w.e("MicroMsg.exdevice.IBeaconTLVSectionB", "valueByte is null or nil");
            return false;
        } else if (26 != this.mLength) {
            w.d("MicroMsg.exdevice.IBeaconTLVSectionB", "IBEACON_TLV_SECTION_B_LENGTH != mLength(%d) ", new Object[]{Integer.valueOf(this.mLength)});
            return false;
        } else {
            a aVar = new a(bArr.length);
            aVar.v(bArr, bArr.length);
            byte[] bArr2 = new byte[4];
            aVar.u(bArr2, 4);
            if (Arrays.equals(bArr2, jQP)) {
                this.jQQ = bArr2;
                this.jQR = new byte[16];
                aVar.u(this.jQR, 16);
                try {
                    this.jQS = aVar.readShort();
                    this.jQT = aVar.readShort();
                    bArr2 = new byte[1];
                    aVar.u(bArr2, 1);
                    this.jQU = bArr2[0];
                    return true;
                } catch (Throwable e) {
                    w.d("MicroMsg.exdevice.IBeaconTLVSectionB", "Read major/minor from autobuffer failed!!!");
                    w.printErrStackTrace("MicroMsg.exdevice.IBeaconTLVSectionB", e, "", new Object[0]);
                    return false;
                }
            }
            w.d("MicroMsg.exdevice.IBeaconTLVSectionB", "Cannot find ibeacon cookies!!!");
            return false;
        }
    }
}
