package com.tencent.mm.plugin.h.a.a;

import com.tencent.mm.plugin.exdevice.j.a;
import com.tencent.mm.sdk.platformtools.w;

public abstract class j {
    protected byte jQV = (byte) 0;
    protected byte[] jQW = null;
    protected int mLength = -1;

    abstract boolean W(byte[] bArr);

    public final boolean a(a aVar) {
        if (aVar.getSize() == 0) {
            w.w("MicroMsg.exdevice.TLVBase", "autoBuffer is null or nil");
            return false;
        }
        byte[] bArr = new byte[1];
        aVar.u(bArr, 1);
        byte b = bArr[0];
        if (b + 1 > aVar.getSize()) {
            w.w("MicroMsg.exdevice.TLVBase", "lengthInt(%d) + 1 > autoBuffer.getSize()(%d)", new Object[]{Integer.valueOf(b), Integer.valueOf(aVar.getSize())});
            return false;
        } else if (b <= (byte) 1) {
            w.w("MicroMsg.exdevice.TLVBase", "length(%d) <= 1", new Object[]{Integer.valueOf(b)});
            return false;
        } else {
            this.mLength = b;
            aVar.u(bArr, 1);
            this.jQV = bArr[0];
            this.jQW = new byte[(this.mLength - 1)];
            aVar.u(this.jQW, this.jQW.length);
            return W(this.jQW);
        }
    }
}
