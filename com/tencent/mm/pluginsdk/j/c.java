package com.tencent.mm.pluginsdk.j;

import com.tencent.mm.sdk.platformtools.w;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public final class c extends InputStream {
    private final ByteBuffer sEP;

    public c(ByteBuffer byteBuffer) {
        this.sEP = byteBuffer;
    }

    public final int available() {
        return this.sEP.remaining();
    }

    public final int read() {
        return this.sEP.hasRemaining() ? this.sEP.get() & 255 : -1;
    }

    public final int read(byte[] bArr, int i, int i2) {
        if (!this.sEP.hasRemaining()) {
            return -1;
        }
        int min = Math.min(i2, this.sEP.remaining());
        this.sEP.get(bArr, i, min);
        return min;
    }

    public final void close() {
        super.close();
        ByteBuffer byteBuffer = this.sEP;
        if (byteBuffer.getClass().getName().equals("java.nio.DirectByteBuffer")) {
            try {
                Method declaredMethod = byteBuffer.getClass().getDeclaredMethod("free", new Class[0]);
                boolean isAccessible = declaredMethod.isAccessible();
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(byteBuffer, new Object[0]);
                declaredMethod.setAccessible(isAccessible);
            } catch (Exception e) {
                w.d("MicroMsg.ByteBufferBackedInputStream", "free ByteBuffer, exp = %s", new Object[]{e});
            }
        }
        System.gc();
    }
}
