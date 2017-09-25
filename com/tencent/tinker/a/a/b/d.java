package com.tencent.tinker.a.a.b;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public final class d {
    public static byte[] g(InputStream inputStream) {
        return b(inputStream, WXMediaMessage.THUMB_LENGTH_LIMIT);
    }

    public static byte[] b(InputStream inputStream, int i) {
        if (i <= 0) {
            i = WXMediaMessage.THUMB_LENGTH_LIMIT;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i);
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }
}
