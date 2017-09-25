package com.tencent.mm.plugin.appbrand.h;

import com.tencent.mm.a.e;
import com.tencent.mm.as.n;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

public final class d {
    public static boolean be(String str, String str2) {
        InputStream open;
        OutputStream outputStream = null;
        try {
            open = ab.getContext().getAssets().open(str2);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.WxaFTSSearchLogic", e, "", new Object[0]);
            open = null;
        }
        if (open == null) {
            w.e("MicroMsg.WxaFTSSearchLogic", "file inputStream is null.");
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        file.getParentFile().mkdirs();
        try {
            outputStream = new FileOutputStream(file);
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.WxaFTSSearchLogic", e2, "", new Object[0]);
        }
        if (outputStream != null) {
            try {
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (true) {
                    int read = open.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    outputStream.write(bArr, 0, read);
                }
                return true;
            } catch (Throwable e22) {
                w.printErrStackTrace("MicroMsg.WxaFTSSearchLogic", e22, "", new Object[0]);
                return false;
            } finally {
                e.b(open);
                e.a(outputStream);
            }
        } else {
            e.b(open);
            return false;
        }
    }

    public static String m(Map<String, String> map) {
        return n.m(map);
    }
}
