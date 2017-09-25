package com.tencent.mm.plugin.appbrand.m;

import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;

public final class a {
    public static String convertStreamToString(InputStream inputStream) {
        Closeable inputStreamReader = new InputStreamReader(inputStream);
        String str = new char[Downloads.RECV_BUFFER_SIZE];
        StringWriter stringWriter = new StringWriter();
        while (true) {
            try {
                int read = inputStreamReader.read(str);
                if (-1 == read) {
                    break;
                }
                stringWriter.write(str, 0, read);
            } catch (Exception e) {
                stringWriter = "MicroMsg.AppBrandIOUtil";
                w.e(stringWriter, "convertStreamToString: read, %s", new Object[]{e.getMessage()});
                str = "";
                return str;
            } finally {
                bg.g(inputStreamReader);
                bg.g(inputStream);
            }
        }
        return stringWriter.toString();
    }

    public static String qT(String str) {
        InputStream inputStream = null;
        try {
            inputStream = ab.getContext().getAssets().open(str);
        } catch (Throwable e) {
            w.e("MicroMsg.AppBrandIOUtil", "openRead file( %s ) failed, exp = %s", new Object[]{str, bg.g(e)});
        }
        if (inputStream == null) {
            return "";
        }
        return convertStreamToString(inputStream);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] i(java.io.InputStream r5) {
        /*
        r1 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r0 = new java.io.ByteArrayOutputStream;
        r0.<init>();
        r1 = new byte[r1];
    L_0x0009:
        r2 = 0;
        r3 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r2 = r5.read(r1, r2, r3);	 Catch:{ Exception -> 0x0018 }
        r3 = -1;
        if (r2 == r3) goto L_0x0036;
    L_0x0013:
        r3 = 0;
        r0.write(r1, r3, r2);	 Catch:{ Exception -> 0x0018 }
        goto L_0x0009;
    L_0x0018:
        r0 = move-exception;
        r1 = "MicroMsg.AppBrandIOUtil";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0071 }
        r3 = "readPkgCertificate: ";
        r2.<init>(r3);	 Catch:{ all -> 0x0071 }
        r0 = r2.append(r0);	 Catch:{ all -> 0x0071 }
        r0 = r0.toString();	 Catch:{ all -> 0x0071 }
        com.tencent.mm.sdk.platformtools.w.e(r1, r0);	 Catch:{ all -> 0x0071 }
        r0 = 0;
        r0 = new byte[r0];	 Catch:{ all -> 0x0071 }
        r5.close();	 Catch:{ Exception -> 0x0059 }
    L_0x0035:
        return r0;
    L_0x0036:
        r0.flush();	 Catch:{ Exception -> 0x0018 }
        r5.close();	 Catch:{ Exception -> 0x0041 }
    L_0x003c:
        r0 = r0.toByteArray();
        goto L_0x0035;
    L_0x0041:
        r1 = move-exception;
        r2 = "MicroMsg.AppBrandIOUtil";
        r3 = new java.lang.StringBuilder;
        r4 = "close: ";
        r3.<init>(r4);
        r1 = r3.append(r1);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.w.e(r2, r1);
        goto L_0x003c;
    L_0x0059:
        r1 = move-exception;
        r2 = "MicroMsg.AppBrandIOUtil";
        r3 = new java.lang.StringBuilder;
        r4 = "close: ";
        r3.<init>(r4);
        r1 = r3.append(r1);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.w.e(r2, r1);
        goto L_0x0035;
    L_0x0071:
        r0 = move-exception;
        r5.close();	 Catch:{ Exception -> 0x0076 }
    L_0x0075:
        throw r0;
    L_0x0076:
        r1 = move-exception;
        r2 = "MicroMsg.AppBrandIOUtil";
        r3 = new java.lang.StringBuilder;
        r4 = "close: ";
        r3.<init>(r4);
        r1 = r3.append(r1);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.w.e(r2, r1);
        goto L_0x0075;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.m.a.i(java.io.InputStream):byte[]");
    }
}
