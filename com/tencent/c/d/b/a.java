package com.tencent.c.d.b;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public final class a {
    private static final byte[] wSj = new byte[]{Byte.MAX_VALUE, (byte) 69, (byte) 76, (byte) 70};

    public static boolean Vc(String str) {
        Throwable th;
        byte[] bArr = new byte[wSj.length];
        Closeable fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                if (fileInputStream.read(bArr, 0, wSj.length) != bArr.length) {
                    throw new IOException("Read bytes less than " + bArr.length);
                }
                for (int i = 0; i < wSj.length; i++) {
                    if (wSj[i] != bArr[i]) {
                        b.c(fileInputStream);
                        return false;
                    }
                }
                b.c(fileInputStream);
                return true;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            b.c(fileInputStream);
            throw th;
        }
    }

    public static byte[] Ve(String str) {
        Closeable byteArrayOutputStream;
        Throwable th;
        Closeable closeable = null;
        try {
            Closeable fileInputStream = new FileInputStream(str);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(fileInputStream.available());
                try {
                    b.b(fileInputStream, byteArrayOutputStream);
                    byte[] toByteArray = byteArrayOutputStream.toByteArray();
                    if (toByteArray == null) {
                        toByteArray = "".getBytes();
                    }
                    b.c(fileInputStream);
                    b.c(byteArrayOutputStream);
                    return toByteArray;
                } catch (Throwable th2) {
                    th = th2;
                    closeable = fileInputStream;
                    b.c(closeable);
                    b.c(byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
                closeable = fileInputStream;
                b.c(closeable);
                b.c(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            b.c(closeable);
            b.c(byteArrayOutputStream);
            throw th;
        }
    }

    public static byte[] di(String str, int i) {
        Closeable closeable;
        Throwable th;
        int i2 = 0;
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        Closeable fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                int read;
                Object obj = new byte[i];
                do {
                    read = fileInputStream.read(obj, i2, i - i2);
                    if (read == -1) {
                        break;
                    }
                    i2 += read;
                } while (i2 < i);
                read = i2;
                if (read == 0) {
                    b.c(fileInputStream);
                    return null;
                }
                byte[] bArr;
                if (read < i) {
                    bArr = new byte[read];
                    System.arraycopy(obj, 0, bArr, 0, read);
                } else {
                    Object obj2 = obj;
                }
                b.c(fileInputStream);
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                b.c(fileInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            b.c(fileInputStream);
            throw th;
        }
    }
}
