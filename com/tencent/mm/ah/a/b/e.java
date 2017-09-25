package com.tencent.mm.ah.a.b;

import com.tencent.mm.a.g;
import com.tencent.mm.ah.a.c.k;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public final class e implements k {
    public final boolean ac(String str, String str2) {
        if (bg.mA(str2)) {
            w.w("MicroMsg.DefaultImageMD5CheckListener", "hy: filePath is null. check failed");
            return false;
        } else if (bg.mA(str)) {
            w.w("MicroMsg.DefaultImageMD5CheckListener", "hy: target md5 is null or nill. check failed");
            return false;
        } else {
            String aV = g.aV(str2);
            if (bg.mA(aV) || !aV.equals(str)) {
                w.w("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check failed. original is %s, target is %s", aV, str);
                return false;
            }
            w.i("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check success");
            return true;
        }
    }

    public final boolean j(String str, byte[] bArr) {
        if (bg.mA(str)) {
            w.w("MicroMsg.DefaultImageMD5CheckListener", "hy: target md5 is null or nill. check failed");
            return false;
        }
        String bj = aa.bj(bArr);
        if (bg.mA(bj) || !bj.equals(str)) {
            w.w("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check failed. original is %s, target is %s", bj, str);
            return false;
        }
        w.i("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check success");
        return true;
    }

    public final boolean a(String str, InputStream inputStream) {
        if (inputStream == null) {
            w.w("MicroMsg.DefaultImageMD5CheckListener", "hy: inputStream is null. check failed");
            return false;
        } else if (bg.mA(str)) {
            w.w("MicroMsg.DefaultImageMD5CheckListener", "hy: target md5 is null or nill. check failed");
            return false;
        } else {
            try {
                String bj = aa.bj(a(inputStream, true));
                if (bg.mA(bj) || !bj.equals(str)) {
                    w.w("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check failed. original is %s, target is %s", bj, str);
                    return false;
                }
                w.i("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check success");
                return true;
            } catch (Exception e) {
                w.w("MicroMsg.DefaultImageMD5CheckListener", "hy: exception: " + e.toString());
                return false;
            }
        }
    }

    public static byte[] g(InputStream inputStream) {
        return a(inputStream, false);
    }

    public static byte[] a(InputStream inputStream, boolean z) {
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
        bArr = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        if (!z) {
            inputStream.close();
        }
        return bArr;
    }
}
