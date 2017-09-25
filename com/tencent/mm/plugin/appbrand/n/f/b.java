package com.tencent.mm.plugin.appbrand.n.f;

import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.w;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

public final class b {
    public static CodingErrorAction jpY = CodingErrorAction.REPORT;

    public static byte[] re(String str) {
        try {
            return str.getBytes("UTF8");
        } catch (UnsupportedEncodingException e) {
            w.e("MicroMsg.AppBrandNetWork.Charsetfunctions", e.toString());
            return new byte[0];
        }
    }

    public static byte[] rf(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e) {
            w.e("MicroMsg.AppBrandNetWork.Charsetfunctions", e.toString());
            return new byte[0];
        }
    }

    public static String q(byte[] bArr, int i) {
        try {
            return new String(bArr, 0, i, "ASCII");
        } catch (UnsupportedEncodingException e) {
            w.e("MicroMsg.AppBrandNetWork.Charsetfunctions", e.toString());
            return "";
        }
    }

    public static String m(ByteBuffer byteBuffer) {
        CharsetDecoder newDecoder = Charset.forName("UTF8").newDecoder();
        newDecoder.onMalformedInput(jpY);
        newDecoder.onUnmappableCharacter(jpY);
        try {
            byteBuffer.mark();
            String charBuffer = newDecoder.decode(byteBuffer).toString();
            byteBuffer.reset();
            return charBuffer;
        } catch (Throwable e) {
            throw new com.tencent.mm.plugin.appbrand.n.c.b(MMBitmapFactory.ERROR_IMAGE_SIZE_IS_TOO_LARGE, e);
        }
    }
}
