package com.tencent.smtt.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class h {
    private static OutputStream wWC = null;

    public static synchronized void a(File file, String str, byte[] bArr, String str2) {
        byte[] bArr2 = null;
        synchronized (h.class) {
            byte[] fg = fg(str, str2);
            if (fg != null) {
                str2 = null;
                bArr2 = fg;
            }
            try {
                file.getParentFile().mkdirs();
                if (file.isFile() && file.exists() && file.length() > 2097152) {
                    file.delete();
                    file.createNewFile();
                }
                if (wWC == null) {
                    wWC = new BufferedOutputStream(new FileOutputStream(file, true));
                }
                if (str2 != null) {
                    wWC.write(str2.getBytes());
                } else {
                    wWC.write(bArr);
                    wWC.write(bArr2);
                    wWC.write(new byte[]{(byte) 10, (byte) 10});
                }
                if (wWC != null) {
                    try {
                        wWC.flush();
                    } catch (Throwable th) {
                    }
                }
            } catch (Throwable th2) {
            }
        }
    }

    public static String cfm() {
        return String.valueOf(System.currentTimeMillis());
    }

    private static byte[] fg(String str, String str2) {
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            Cipher instance = Cipher.getInstance("RC4");
            instance.init(1, new SecretKeySpec(str.getBytes("UTF-8"), "RC4"));
            return instance.update(bytes);
        } catch (Throwable th) {
            new StringBuilder("encrypt exception:").append(th.getMessage());
            return null;
        }
    }

    private static byte[] fh(String str, String str2) {
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            Cipher instance = Cipher.getInstance("RC4");
            instance.init(1, new SecretKeySpec(str.getBytes("UTF-8"), "RC4"));
            return instance.update(bytes);
        } catch (Throwable th) {
            new StringBuilder("encrypt exception:").append(th.getMessage());
            return null;
        }
    }

    public static byte[] fi(String str, String str2) {
        try {
            Object fh = fh(str, str2);
            String format = String.format("%03d", new Object[]{Integer.valueOf(fh.length)});
            Object obj = new byte[(fh.length + 3)];
            obj[0] = (byte) format.charAt(0);
            obj[1] = (byte) format.charAt(1);
            obj[2] = (byte) format.charAt(2);
            System.arraycopy(fh, 0, obj, 3, fh.length);
            return obj;
        } catch (Exception e) {
            return null;
        }
    }
}
