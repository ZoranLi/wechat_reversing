package com.tencent.mm.plugin.freewifi.a;

import java.net.HttpURLConnection;

public final class a {
    private static final int lSw = b.lRu.avU();
    private static final int lSx = b.lRu.avV();

    public interface a {
        void d(HttpURLConnection httpURLConnection);

        void h(Exception exception);
    }

    private static class b {
        public static a lSy = new a();
    }

    public static a awi() {
        return b.lSy;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r5, com.tencent.mm.plugin.freewifi.a.a.a r6) {
        /*
        r3 = 0;
        r0 = "MicroMsg.FreeWifi.HttpTemplate";
        r1 = "method=request, desc=it starts a http GET request. url=%s.";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r2[r3] = r5;
        com.tencent.mm.sdk.platformtools.w.i(r0, r1, r2);
        r0 = com.tencent.mm.plugin.freewifi.m.wx(r5);
        if (r0 == 0) goto L_0x0016;
    L_0x0015:
        return;
    L_0x0016:
        r1 = 0;
        r0 = new java.net.URL;	 Catch:{ Exception -> 0x006e }
        r0.<init>(r5);	 Catch:{ Exception -> 0x006e }
        r0 = r0.openConnection();	 Catch:{ Exception -> 0x006e }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x006e }
        if (r0 == 0) goto L_0x0045;
    L_0x0024:
        r1 = lSw;	 Catch:{ Exception -> 0x0050, all -> 0x0062 }
        r0.setConnectTimeout(r1);	 Catch:{ Exception -> 0x0050, all -> 0x0062 }
        r1 = lSx;	 Catch:{ Exception -> 0x0050, all -> 0x0062 }
        r0.setReadTimeout(r1);	 Catch:{ Exception -> 0x0050, all -> 0x0062 }
        r1 = "User-Agent";
        r2 = com.tencent.mm.plugin.freewifi.h.b.lRu;	 Catch:{ Exception -> 0x0050, all -> 0x0062 }
        r2 = r2.getUserAgent();	 Catch:{ Exception -> 0x0050, all -> 0x0062 }
        r0.setRequestProperty(r1, r2);	 Catch:{ Exception -> 0x0050, all -> 0x0062 }
        r1 = 0;
        r0.setUseCaches(r1);	 Catch:{ Exception -> 0x0050, all -> 0x0062 }
        r1 = 0;
        r0.setInstanceFollowRedirects(r1);	 Catch:{ Exception -> 0x0050, all -> 0x0062 }
        r6.d(r0);	 Catch:{ IOException -> 0x004b, Exception -> 0x005d, all -> 0x0062 }
    L_0x0045:
        if (r0 == 0) goto L_0x0015;
    L_0x0047:
        r0.disconnect();
        goto L_0x0015;
    L_0x004b:
        r1 = move-exception;
        r6.h(r1);	 Catch:{ Exception -> 0x0050, all -> 0x0062 }
        goto L_0x0045;
    L_0x0050:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x0054:
        r6.h(r0);	 Catch:{ all -> 0x006c }
        if (r1 == 0) goto L_0x0015;
    L_0x0059:
        r1.disconnect();
        goto L_0x0015;
    L_0x005d:
        r1 = move-exception;
        r6.h(r1);	 Catch:{ Exception -> 0x0050, all -> 0x0062 }
        goto L_0x0045;
    L_0x0062:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x0066:
        if (r1 == 0) goto L_0x006b;
    L_0x0068:
        r1.disconnect();
    L_0x006b:
        throw r0;
    L_0x006c:
        r0 = move-exception;
        goto L_0x0066;
    L_0x006e:
        r0 = move-exception;
        goto L_0x0054;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.a.a.a(java.lang.String, com.tencent.mm.plugin.freewifi.a.a$a):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r13, java.lang.String r14, com.tencent.mm.plugin.freewifi.a.a.a r15) {
        /*
        r0 = "MicroMsg.FreeWifi.HttpTemplate";
        r1 = "method=requestPost, desc=it starts a http POST request. url=%s, postParams=%s.";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r2[r3] = r13;
        r3 = 1;
        r2[r3] = r14;
        com.tencent.mm.sdk.platformtools.w.i(r0, r1, r2);
        r0 = com.tencent.mm.plugin.freewifi.m.wx(r13);
        if (r0 != 0) goto L_0x001e;
    L_0x0018:
        r0 = com.tencent.mm.plugin.freewifi.m.wx(r14);
        if (r0 == 0) goto L_0x001f;
    L_0x001e:
        return;
    L_0x001f:
        if (r14 == 0) goto L_0x002a;
    L_0x0021:
        r0 = "";
        r0 = r0.equalsIgnoreCase(r14);
        if (r0 == 0) goto L_0x00ba;
    L_0x002a:
        r0 = "";
        r1 = r0;
    L_0x002e:
        r0 = "MicroMsg.FreeWifi.HttpTemplate";
        r2 = "method=requestPost, desc=it extracts PostParams. url=%s, postParams=%s";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r3[r4] = r13;
        r4 = 1;
        r3[r4] = r1;
        com.tencent.mm.sdk.platformtools.w.i(r0, r2, r3);
        r2 = 0;
        r0 = new java.net.URL;	 Catch:{ Exception -> 0x01a8, all -> 0x01a3 }
        r0.<init>(r13);	 Catch:{ Exception -> 0x01a8, all -> 0x01a3 }
        r0 = r0.openConnection();	 Catch:{ Exception -> 0x01a8, all -> 0x01a3 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x01a8, all -> 0x01a3 }
        if (r0 == 0) goto L_0x00b3;
    L_0x004e:
        r2 = lSw;	 Catch:{ Exception -> 0x0186, all -> 0x019a }
        r0.setConnectTimeout(r2);	 Catch:{ Exception -> 0x0186, all -> 0x019a }
        r2 = lSx;	 Catch:{ Exception -> 0x0186, all -> 0x019a }
        r0.setReadTimeout(r2);	 Catch:{ Exception -> 0x0186, all -> 0x019a }
        r2 = "User-Agent";
        r3 = com.tencent.mm.plugin.freewifi.h.b.lRu;	 Catch:{ Exception -> 0x0186, all -> 0x019a }
        r3 = r3.getUserAgent();	 Catch:{ Exception -> 0x0186, all -> 0x019a }
        r0.setRequestProperty(r2, r3);	 Catch:{ Exception -> 0x0186, all -> 0x019a }
        r2 = 0;
        r0.setInstanceFollowRedirects(r2);	 Catch:{ Exception -> 0x0186, all -> 0x019a }
        r2 = 1;
        r0.setDoOutput(r2);	 Catch:{ Exception -> 0x0186, all -> 0x019a }
        r2 = "POST";
        r0.setRequestMethod(r2);	 Catch:{ Exception -> 0x0186, all -> 0x019a }
        r2 = "Content-Type";
        r3 = "application/x-www-form-urlencoded";
        r0.setRequestProperty(r2, r3);	 Catch:{ Exception -> 0x0186, all -> 0x019a }
        r2 = "charset";
        r3 = "utf-8";
        r0.setRequestProperty(r2, r3);	 Catch:{ Exception -> 0x0186, all -> 0x019a }
        r2 = 0;
        r0.setUseCaches(r2);	 Catch:{ Exception -> 0x0186, all -> 0x019a }
        r2 = "UTF-8";
        r2 = java.nio.charset.Charset.forName(r2);	 Catch:{ Exception -> 0x0186, all -> 0x019a }
        r1 = r1.getBytes(r2);	 Catch:{ Exception -> 0x0186, all -> 0x019a }
        r2 = "Content-Length";
        r3 = r1.length;	 Catch:{ Exception -> 0x0186, all -> 0x019a }
        r3 = java.lang.Integer.toString(r3);	 Catch:{ Exception -> 0x0186, all -> 0x019a }
        r0.setRequestProperty(r2, r3);	 Catch:{ Exception -> 0x0186, all -> 0x019a }
        r2 = new java.io.DataOutputStream;	 Catch:{ Exception -> 0x0186, all -> 0x019a }
        r3 = r0.getOutputStream();	 Catch:{ Exception -> 0x0186, all -> 0x019a }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0186, all -> 0x019a }
        r2.write(r1);	 Catch:{ Exception -> 0x0186, all -> 0x019a }
        r2.flush();	 Catch:{ Exception -> 0x0186, all -> 0x019a }
        r2.close();	 Catch:{ Exception -> 0x0186, all -> 0x019a }
        r15.d(r0);	 Catch:{ IOException -> 0x0180, Exception -> 0x0194, all -> 0x019a }
    L_0x00b3:
        if (r0 == 0) goto L_0x001e;
    L_0x00b5:
        r0.disconnect();
        goto L_0x001e;
    L_0x00ba:
        r2 = "";
        r0 = "&";
        r5 = r14.split(r0);
        r0 = 1;
        r4 = r0;
    L_0x00c6:
        r0 = 10;
        if (r4 > r0) goto L_0x017d;
    L_0x00ca:
        r0 = new java.lang.StringBuilder;
        r1 = "key";
        r0.<init>(r1);
        r0 = r0.append(r4);
        r6 = r0.toString();
        r0 = new java.lang.StringBuilder;
        r1 = "value";
        r0.<init>(r1);
        r0 = r0.append(r4);
        r7 = r0.toString();
        r3 = 0;
        r1 = 0;
        r8 = r5.length;
        r0 = 0;
        r12 = r0;
        r0 = r1;
        r1 = r3;
        r3 = r12;
    L_0x00f2:
        if (r3 >= r8) goto L_0x0130;
    L_0x00f4:
        r9 = r5[r3];
        r10 = r9.indexOf(r6);
        if (r10 < 0) goto L_0x0114;
    L_0x00fc:
        r10 = "=";
        r10 = r9.split(r10);
        r10 = r10.length;
        r11 = 2;
        if (r10 != r11) goto L_0x0114;
    L_0x0107:
        r1 = "=";
        r1 = r9.split(r1);
        r9 = 1;
        r1 = r1[r9];
    L_0x0111:
        r3 = r3 + 1;
        goto L_0x00f2;
    L_0x0114:
        r10 = r9.indexOf(r7);
        if (r10 < 0) goto L_0x0111;
    L_0x011a:
        r10 = "=";
        r10 = r9.split(r10);
        r10 = r10.length;
        r11 = 2;
        if (r10 != r11) goto L_0x0111;
    L_0x0125:
        r0 = "=";
        r0 = r9.split(r0);
        r9 = 1;
        r0 = r0[r9];
        goto L_0x0111;
    L_0x0130:
        if (r1 == 0) goto L_0x017d;
    L_0x0132:
        if (r0 == 0) goto L_0x017d;
    L_0x0134:
        r3 = 1;
        if (r4 != r3) goto L_0x0159;
    L_0x0137:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r2 = r3.append(r2);
        r1 = r2.append(r1);
        r2 = "=";
        r1 = r1.append(r2);
        r0 = r1.append(r0);
        r0 = r0.toString();
    L_0x0153:
        r1 = r4 + 1;
        r4 = r1;
        r2 = r0;
        goto L_0x00c6;
    L_0x0159:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r2 = r3.append(r2);
        r3 = "&";
        r2 = r2.append(r3);
        r1 = r2.append(r1);
        r2 = "=";
        r1 = r1.append(r2);
        r0 = r1.append(r0);
        r0 = r0.toString();
        goto L_0x0153;
    L_0x017d:
        r1 = r2;
        goto L_0x002e;
    L_0x0180:
        r1 = move-exception;
        r15.h(r1);	 Catch:{ Exception -> 0x0186, all -> 0x019a }
        goto L_0x00b3;
    L_0x0186:
        r1 = move-exception;
        r12 = r1;
        r1 = r0;
        r0 = r12;
    L_0x018a:
        r15.h(r0);	 Catch:{ all -> 0x01a5 }
        if (r1 == 0) goto L_0x001e;
    L_0x018f:
        r1.disconnect();
        goto L_0x001e;
    L_0x0194:
        r1 = move-exception;
        r15.h(r1);	 Catch:{ Exception -> 0x0186, all -> 0x019a }
        goto L_0x00b3;
    L_0x019a:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
    L_0x019d:
        if (r2 == 0) goto L_0x01a2;
    L_0x019f:
        r2.disconnect();
    L_0x01a2:
        throw r0;
    L_0x01a3:
        r0 = move-exception;
        goto L_0x019d;
    L_0x01a5:
        r0 = move-exception;
        r2 = r1;
        goto L_0x019d;
    L_0x01a8:
        r0 = move-exception;
        r1 = r2;
        goto L_0x018a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.a.a.a(java.lang.String, java.lang.String, com.tencent.mm.plugin.freewifi.a.a$a):void");
    }
}
