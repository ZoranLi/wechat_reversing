package com.tencent.mm.loader.stub;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public final class b {
    public static final boolean e(File file) {
        int i = 0;
        if (file == null || !file.exists() || !file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return false;
        }
        while (i < listFiles.length) {
            listFiles[i].delete();
            i++;
        }
        return true;
    }

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

    public static boolean deleteFile(String str) {
        if (str == null) {
            return true;
        }
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return true;
    }
}
