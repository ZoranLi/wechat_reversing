package com.tencent.mm.plugin.gesture.a;

import com.tencent.mm.sdk.platformtools.w;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;

public final class e {
    public long mHZ = -1;
    public long mIa = 0;

    public final byte[] toByteArray() {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeLong(this.mHZ);
            dataOutputStream.writeLong(this.mIa);
            dataOutputStream.close();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.TimeInfo", e, "", new Object[0]);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public final e au(byte[] bArr) {
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        try {
            this.mHZ = dataInputStream.readLong();
            this.mIa = dataInputStream.readLong();
            dataInputStream.close();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.TimeInfo", e, "", new Object[0]);
        }
        return this;
    }
}
