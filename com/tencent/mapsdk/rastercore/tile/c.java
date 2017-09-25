package com.tencent.mapsdk.rastercore.tile;

import java.util.Locale;

public final class c {
    private static String a = (Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry());

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(java.net.URL r8) {
        /*
        r1 = 0;
        if (r8 != 0) goto L_0x0004;
    L_0x0003:
        return r1;
    L_0x0004:
        r0 = android.net.Proxy.getDefaultHost();	 Catch:{ Exception -> 0x00e5, all -> 0x00fa }
        if (r0 == 0) goto L_0x0145;
    L_0x000a:
        r0 = new java.net.Proxy;	 Catch:{ Exception -> 0x00e5, all -> 0x00fa }
        r2 = java.net.Proxy.Type.HTTP;	 Catch:{ Exception -> 0x00e5, all -> 0x00fa }
        r3 = new java.net.InetSocketAddress;	 Catch:{ Exception -> 0x00e5, all -> 0x00fa }
        r4 = android.net.Proxy.getDefaultHost();	 Catch:{ Exception -> 0x00e5, all -> 0x00fa }
        r5 = android.net.Proxy.getDefaultPort();	 Catch:{ Exception -> 0x00e5, all -> 0x00fa }
        r3.<init>(r4, r5);	 Catch:{ Exception -> 0x00e5, all -> 0x00fa }
        r0.<init>(r2, r3);	 Catch:{ Exception -> 0x00e5, all -> 0x00fa }
    L_0x001e:
        if (r0 == 0) goto L_0x00a5;
    L_0x0020:
        r0 = r8.openConnection(r0);	 Catch:{ Exception -> 0x00e5, all -> 0x00fa }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x00e5, all -> 0x00fa }
        r5 = r0;
    L_0x0027:
        r0 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r5.setConnectTimeout(r0);	 Catch:{ Exception -> 0x011d, all -> 0x010d }
        r0 = 15000; // 0x3a98 float:2.102E-41 double:7.411E-320;
        r5.setReadTimeout(r0);	 Catch:{ Exception -> 0x011d, all -> 0x010d }
        r0 = "Accept-Encoding";
        r2 = "gzip, deflate";
        r5.setRequestProperty(r0, r2);	 Catch:{ Exception -> 0x011d, all -> 0x010d }
        r0 = "User-Agent";
        r2 = "QmapSdk/1.2.8.29dc259 Android";
        r5.setRequestProperty(r0, r2);	 Catch:{ Exception -> 0x011d, all -> 0x010d }
        r0 = "Accept-Language";
        r2 = a;	 Catch:{ Exception -> 0x011d, all -> 0x010d }
        r5.setRequestProperty(r0, r2);	 Catch:{ Exception -> 0x011d, all -> 0x010d }
        r0 = r5.getResponseCode();	 Catch:{ Exception -> 0x011d, all -> 0x010d }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r0 != r2) goto L_0x0140;
    L_0x0053:
        r4 = r5.getInputStream();	 Catch:{ Exception -> 0x011d, all -> 0x010d }
        r0 = r5.getContentType();	 Catch:{ Exception -> 0x0123, all -> 0x0111 }
        r0 = r0.toLowerCase();	 Catch:{ Exception -> 0x0123, all -> 0x0111 }
        r0 = r0.trim();	 Catch:{ Exception -> 0x0123, all -> 0x0111 }
        r2 = "text";
        r0 = r0.contains(r2);	 Catch:{ Exception -> 0x0123, all -> 0x0111 }
        if (r0 == 0) goto L_0x00ae;
    L_0x006c:
        r3 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x0123, all -> 0x0111 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x0123, all -> 0x0111 }
        r2 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0129, all -> 0x0114 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0129, all -> 0x0114 }
        r0 = r2.readLine();	 Catch:{ Exception -> 0x012f, all -> 0x0116 }
        r0 = r0.toLowerCase();	 Catch:{ Exception -> 0x012f, all -> 0x0116 }
        r0 = r0.trim();	 Catch:{ Exception -> 0x012f, all -> 0x0116 }
        if (r0 == 0) goto L_0x013d;
    L_0x0084:
        r6 = "0";
        r0 = r0.equals(r6);	 Catch:{ Exception -> 0x012f, all -> 0x0116 }
        if (r0 == 0) goto L_0x013d;
    L_0x008d:
        r0 = 1;
        r0 = new byte[r0];	 Catch:{ Exception -> 0x012f, all -> 0x0116 }
        r6 = 0;
        r7 = -1;
        r0[r6] = r7;	 Catch:{ Exception -> 0x012f, all -> 0x0116 }
    L_0x0094:
        r1 = r0;
    L_0x0095:
        if (r5 == 0) goto L_0x009a;
    L_0x0097:
        r5.disconnect();
    L_0x009a:
        com.tencent.mapsdk.rastercore.d.a.a(r2);
        com.tencent.mapsdk.rastercore.d.a.a(r3);
        com.tencent.mapsdk.rastercore.d.a.a(r4);
        goto L_0x0003;
    L_0x00a5:
        r0 = r8.openConnection();	 Catch:{ Exception -> 0x00e5, all -> 0x00fa }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x00e5, all -> 0x00fa }
        r5 = r0;
        goto L_0x0027;
    L_0x00ae:
        r0 = "gzip";
        r2 = "Content-Encoding";
        r2 = r5.getHeaderField(r2);	 Catch:{ Exception -> 0x0123, all -> 0x0111 }
        r0 = r0.equalsIgnoreCase(r2);	 Catch:{ Exception -> 0x0123, all -> 0x0111 }
        if (r0 == 0) goto L_0x013b;
    L_0x00be:
        r2 = new java.util.zip.GZIPInputStream;	 Catch:{ Exception -> 0x0123, all -> 0x0111 }
        r2.<init>(r4);	 Catch:{ Exception -> 0x0123, all -> 0x0111 }
    L_0x00c3:
        r0 = com.tencent.mapsdk.rastercore.d.a.a(r2);	 Catch:{ Exception -> 0x0135, all -> 0x0119 }
        r3 = 0;
        r4 = r0.length;	 Catch:{ Exception -> 0x00d1, all -> 0x0119 }
        android.graphics.BitmapFactory.decodeByteArray(r0, r3, r4);	 Catch:{ Exception -> 0x00d1, all -> 0x0119 }
        r3 = r1;
        r4 = r2;
        r2 = r1;
        r1 = r0;
        goto L_0x0095;
    L_0x00d1:
        r0 = move-exception;
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0135, all -> 0x0119 }
        r4 = "decoder bitmap error:";
        r3.<init>(r4);	 Catch:{ Exception -> 0x0135, all -> 0x0119 }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x0135, all -> 0x0119 }
        r3.append(r0);	 Catch:{ Exception -> 0x0135, all -> 0x0119 }
        r3 = r1;
        r4 = r2;
        r2 = r1;
        goto L_0x0095;
    L_0x00e5:
        r0 = move-exception;
        r0 = r1;
        r2 = r1;
        r3 = r1;
        r4 = r1;
    L_0x00ea:
        if (r4 == 0) goto L_0x00ef;
    L_0x00ec:
        r4.disconnect();
    L_0x00ef:
        com.tencent.mapsdk.rastercore.d.a.a(r0);
        com.tencent.mapsdk.rastercore.d.a.a(r2);
        com.tencent.mapsdk.rastercore.d.a.a(r3);
        goto L_0x0003;
    L_0x00fa:
        r0 = move-exception;
        r3 = r1;
        r4 = r1;
        r5 = r1;
    L_0x00fe:
        if (r5 == 0) goto L_0x0103;
    L_0x0100:
        r5.disconnect();
    L_0x0103:
        com.tencent.mapsdk.rastercore.d.a.a(r1);
        com.tencent.mapsdk.rastercore.d.a.a(r3);
        com.tencent.mapsdk.rastercore.d.a.a(r4);
        throw r0;
    L_0x010d:
        r0 = move-exception;
        r3 = r1;
        r4 = r1;
        goto L_0x00fe;
    L_0x0111:
        r0 = move-exception;
        r3 = r1;
        goto L_0x00fe;
    L_0x0114:
        r0 = move-exception;
        goto L_0x00fe;
    L_0x0116:
        r0 = move-exception;
        r1 = r2;
        goto L_0x00fe;
    L_0x0119:
        r0 = move-exception;
        r3 = r1;
        r4 = r2;
        goto L_0x00fe;
    L_0x011d:
        r0 = move-exception;
        r0 = r1;
        r2 = r1;
        r3 = r1;
        r4 = r5;
        goto L_0x00ea;
    L_0x0123:
        r0 = move-exception;
        r0 = r1;
        r2 = r1;
        r3 = r4;
        r4 = r5;
        goto L_0x00ea;
    L_0x0129:
        r0 = move-exception;
        r0 = r1;
        r2 = r3;
        r3 = r4;
        r4 = r5;
        goto L_0x00ea;
    L_0x012f:
        r0 = move-exception;
        r0 = r2;
        r2 = r3;
        r3 = r4;
        r4 = r5;
        goto L_0x00ea;
    L_0x0135:
        r0 = move-exception;
        r0 = r1;
        r3 = r2;
        r4 = r5;
        r2 = r1;
        goto L_0x00ea;
    L_0x013b:
        r2 = r4;
        goto L_0x00c3;
    L_0x013d:
        r0 = r1;
        goto L_0x0094;
    L_0x0140:
        r2 = r1;
        r3 = r1;
        r4 = r1;
        goto L_0x0095;
    L_0x0145:
        r0 = r1;
        goto L_0x001e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.rastercore.tile.c.a(java.net.URL):byte[]");
    }
}
