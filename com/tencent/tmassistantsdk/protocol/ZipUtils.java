package com.tencent.tmassistantsdk.protocol;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.w;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class ZipUtils {
    private static final String TAG = "ZipUtils";

    public static byte[] zip(byte[] bArr) {
        Throwable e;
        Deflater deflater = new Deflater();
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            try {
                deflater.setLevel(9);
                deflater.setInput(bArr);
                deflater.finish();
                byte[] bArr2 = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (!deflater.finished()) {
                    byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
                }
                deflater.end();
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable e2) {
                    w.printErrStackTrace(TAG, e2, "", new Object[0]);
                }
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th) {
                e2 = th;
                deflater.end();
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable e3) {
                        w.printErrStackTrace(TAG, e3, "", new Object[0]);
                    }
                }
                throw e2;
            }
        } catch (Throwable th2) {
            e2 = th2;
            byteArrayOutputStream = null;
            deflater.end();
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            throw e2;
        }
    }

    public static byte[] unzip(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable e;
        Throwable th;
        Throwable th2;
        Inflater inflater = new Inflater();
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            try {
                byte[] bArr2 = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                inflater.setInput(bArr);
                while (!inflater.finished()) {
                    byteArrayOutputStream.write(bArr2, 0, inflater.inflate(bArr2));
                }
                inflater.end();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                }
            } catch (DataFormatException e3) {
                e = e3;
                try {
                    w.printErrStackTrace(TAG, e, "", new Object[0]);
                    inflater.end();
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    return byteArrayOutputStream.toByteArray();
                } catch (Throwable e5) {
                    th = e5;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    th2 = th;
                    inflater.end();
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th22) {
            th = th22;
            byteArrayOutputStream = null;
            e5 = th;
            w.printErrStackTrace(TAG, e5, "", new Object[0]);
            inflater.end();
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th3) {
            th22 = th3;
            inflater.end();
            if (byteArrayOutputStream2 != null) {
                byteArrayOutputStream2.close();
            }
            throw th22;
        }
        return byteArrayOutputStream.toByteArray();
    }
}
