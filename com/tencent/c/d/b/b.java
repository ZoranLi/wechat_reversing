package com.tencent.c.d.b;

import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;

public final class b {
    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
            }
        }
    }

    public static long b(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[Downloads.RECV_BUFFER_SIZE];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }
}
