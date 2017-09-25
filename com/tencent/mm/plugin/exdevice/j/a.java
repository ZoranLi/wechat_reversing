package com.tencent.mm.plugin.exdevice.j;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.w;
import java.io.IOException;
import java.nio.ByteBuffer;
import junit.framework.Assert;

public final class a {
    private final int lpH = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
    private ByteBuffer lpI;
    private ByteBuffer lpJ;

    public a(int i) {
        boolean z;
        boolean z2 = true;
        w.d("MicroMsg.exdevice.AutoBuffer", "******AutoBuffer****** capacity = " + i);
        Assert.assertTrue(i >= 0);
        this.lpJ = ByteBuffer.allocate(i);
        this.lpI = this.lpJ.asReadOnlyBuffer();
        if (this.lpJ != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (this.lpI == null) {
            z2 = false;
        }
        Assert.assertTrue(z2);
    }

    public final int getSize() {
        w.d("MicroMsg.exdevice.AutoBuffer", "size = " + this.lpJ.position());
        return this.lpJ.position();
    }

    public final short readShort() {
        if (getSize() <= 1) {
            throw new IOException("There is only one byte in array");
        }
        short s = this.lpI.getShort();
        w.d("MicroMsg.exdevice.AutoBuffer", "getShort = " + s);
        return s;
    }

    public final void u(byte[] bArr, int i) {
        boolean z;
        boolean z2 = true;
        Assert.assertTrue(true);
        Assert.assertTrue(i >= 0);
        if (bArr.length >= 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (bArr.length >= i + 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (this.lpI.remaining() < i) {
            z2 = false;
        }
        Assert.assertTrue(z2);
        w.d("MicroMsg.exdevice.AutoBuffer", "readByte dstOffset = 0" + " byteCount = " + i);
        this.lpI.get(bArr, 0, i);
    }

    public final void v(byte[] bArr, int i) {
        boolean z = true;
        Assert.assertTrue(true);
        Assert.assertTrue(i >= 0);
        if (bArr == null) {
            z = false;
        }
        Assert.assertTrue(z);
        w.d("MicroMsg.exdevice.AutoBuffer", "writeByte srcOffset = 0" + " byteCount = " + i);
        if (i > this.lpJ.remaining()) {
            w.d("MicroMsg.exdevice.AutoBuffer", "byteCount > mWriteStream.remaining() Recalloc");
            w.d("MicroMsg.exdevice.AutoBuffer", "getCapacity = " + this.lpJ.capacity());
            ByteBuffer allocate = ByteBuffer.allocate((this.lpJ.capacity() + i) + WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            int position = this.lpI.position();
            allocate.put(this.lpJ.array());
            allocate.put(bArr, 0, i);
            this.lpJ = allocate;
            this.lpI = allocate.asReadOnlyBuffer();
            this.lpI.position(position);
            return;
        }
        this.lpJ.put(bArr, 0, i);
    }
}
