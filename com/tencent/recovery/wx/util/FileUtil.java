package com.tencent.recovery.wx.util;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtil {
    public static byte[] c(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        int i = 0;
        while (true) {
            try {
                i = inputStream.read(bArr, 0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            } catch (IOException e) {
            }
            if (i <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    public static String E(File file) {
        InputStream fileInputStream;
        InputStream inputStream;
        Throwable th;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                String str = new String(c(fileInputStream));
                try {
                    fileInputStream.close();
                    return str;
                } catch (IOException e) {
                    return str;
                }
            } catch (Exception e2) {
                inputStream = fileInputStream;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            inputStream = null;
            if (inputStream != null) {
                inputStream.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }
}
