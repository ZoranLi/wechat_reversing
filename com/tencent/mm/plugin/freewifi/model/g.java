package com.tencent.mm.plugin.freewifi.model;

import android.content.Intent;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.net.HttpURLConnection;
import java.net.URL;

public final class g {
    public int lTq = 5;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String lSE;
        final /* synthetic */ int lSt;
        final /* synthetic */ b lTr;
        final /* synthetic */ g lTs;
        final /* synthetic */ Intent val$intent;

        AnonymousClass1(g gVar, String str, Intent intent, b bVar, int i) {
            this.lTs = gVar;
            this.lSE = str;
            this.val$intent = intent;
            this.lTr = bVar;
            this.lSt = i;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r10 = this;
            r9 = 3;
            r8 = 2;
            r7 = 0;
            r6 = 1;
            r0 = r10.lTs;
            r0 = r0.lTq;
        L_0x0008:
            r1 = r0 + -1;
            if (r0 <= 0) goto L_0x00c0;
        L_0x000c:
            r0 = "MicroMsg.FreeWifi.FreeWifiNetwork";
            r2 = "now retry count = %d";
            r3 = new java.lang.Object[r6];
            r4 = java.lang.Integer.valueOf(r1);
            r3[r7] = r4;
            com.tencent.mm.sdk.platformtools.w.i(r0, r2, r3);
            r0 = r10.lSE;
            r2 = r10.val$intent;
            com.tencent.mm.plugin.freewifi.model.g.a(r0, r6, r2);
            r0 = com.tencent.mm.i.g.sW();
            r0 = r0.sH();
            r2 = "MicroMsg.FreeWifi.FreeWifiNetwork";
            r3 = "get check url from cinfig : %s";
            r4 = new java.lang.Object[r6];
            r4[r7] = r0;
            com.tencent.mm.sdk.platformtools.w.i(r2, r3, r4);
            r2 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
            if (r2 == 0) goto L_0x0052;
        L_0x003f:
            r0 = "MicroMsg.FreeWifi.FreeWifiNetwork";
            r2 = "get check url from config failed, use the default url : %s";
            r3 = new java.lang.Object[r6];
            r4 = "http://10.1.0.6/redirect";
            r3[r7] = r4;
            com.tencent.mm.sdk.platformtools.w.i(r0, r2, r3);
            r0 = "http://10.1.0.6/redirect";
        L_0x0052:
            r2 = com.tencent.mm.plugin.freewifi.model.g.wK(r0);
            r3 = "MicroMsg.FreeWifi.FreeWifiNetwork";
            r4 = "get location from url : %s, %s";
            r5 = new java.lang.Object[r8];
            r5[r7] = r0;
            r5[r6] = r2;
            com.tencent.mm.sdk.platformtools.w.i(r3, r4, r5);
            r3 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
            if (r3 == 0) goto L_0x0084;
        L_0x006b:
            r3 = "MicroMsg.FreeWifi.FreeWifiNetwork";
            r4 = "get location from url failed : %s, %s";
            r5 = new java.lang.Object[r8];
            r5[r7] = r0;
            r5[r6] = r2;
            com.tencent.mm.sdk.platformtools.w.e(r3, r4, r5);
            r2 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
            java.lang.Thread.sleep(r2);	 Catch:{ Exception -> 0x0081 }
            r0 = r1;
            goto L_0x0008;
        L_0x0081:
            r0 = move-exception;
            r0 = r1;
            goto L_0x0008;
        L_0x0084:
            r0 = "auth=";
            r0 = com.tencent.mm.plugin.freewifi.model.g.cf(r2, r0);
            r1 = "MicroMsg.FreeWifi.FreeWifiNetwork";
            r3 = "get apauthmessage from location : %s, %s";
            r4 = new java.lang.Object[r8];
            r4[r7] = r0;
            r4[r6] = r2;
            com.tencent.mm.sdk.platformtools.w.i(r1, r3, r4);
            r1 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
            if (r1 == 0) goto L_0x00b4;
        L_0x00a0:
            r1 = "MicroMsg.FreeWifi.FreeWifiNetwork";
            r3 = "get apauth message from location failed : %s";
            r4 = new java.lang.Object[r6];
            r4[r7] = r2;
            com.tencent.mm.sdk.platformtools.w.e(r1, r3, r4);
            r1 = r10.lSE;
            r2 = r10.val$intent;
            com.tencent.mm.plugin.freewifi.model.g.a(r1, r9, r2);
        L_0x00b4:
            r1 = r10.lTr;
            if (r1 == 0) goto L_0x00bf;
        L_0x00b8:
            r1 = r10.lTr;
            r2 = r10.lSt;
            r1.aV(r0, r2);
        L_0x00bf:
            return;
        L_0x00c0:
            r0 = r10.lTr;
            if (r0 == 0) goto L_0x00cc;
        L_0x00c4:
            r0 = r10.lTr;
            r1 = 0;
            r2 = r10.lSt;
            r0.aV(r1, r2);
        L_0x00cc:
            r0 = r10.lSE;
            r1 = r10.val$intent;
            com.tencent.mm.plugin.freewifi.model.g.a(r0, r9, r1);
            goto L_0x00bf;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.model.g.1.run():void");
        }
    }

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ String lSE;
        final /* synthetic */ g lTs;
        final /* synthetic */ String lTt;
        final /* synthetic */ a lTu = null;
        final /* synthetic */ Intent val$intent;

        AnonymousClass2(g gVar, String str, String str2, Intent intent, a aVar) {
            this.lTs = gVar;
            this.lTt = str;
            this.lSE = str2;
            this.val$intent = intent;
        }

        public final void run() {
            String wK = g.wK(this.lTt);
            w.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get redirect location from loginurl : %s, %s", new Object[]{wK, this.lTt});
            if (!bg.mA(wK)) {
                String cf = g.cf(wK, "res=");
                w.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get connect result from location : %s, %s", new Object[]{cf, wK});
                if (!bg.mA(cf) && (cf.startsWith("success") || cf.startsWith("already"))) {
                    g.a(this.lSE, 2, this.val$intent);
                    j.awC().wQ(this.lSE);
                    return;
                }
            }
            g.a(this.lSE, 3, this.val$intent);
        }
    }

    public interface a {
    }

    public interface b {
        void aV(String str, int i);
    }

    public static String cf(String str, String str2) {
        if (bg.mA(str)) {
            w.e("MicroMsg.FreeWifi.FreeWifiNetwork", "null or nil header");
            return null;
        }
        String[] split;
        String[] split2 = str.split("\\?");
        if (str2.length() > 0) {
            split = split2[1].split("&");
        } else {
            split = split2;
        }
        if (split == null || split.length <= 0) {
            return null;
        }
        for (String str3 : split) {
            if (str3.startsWith(str2)) {
                return str3.substring(str2.length());
            }
        }
        return null;
    }

    public static String wK(String str) {
        HttpURLConnection httpURLConnection;
        Exception exception;
        Throwable th;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection2 != null) {
                try {
                    httpURLConnection2.setConnectTimeout(30000);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    int responseCode = httpURLConnection2.getResponseCode();
                    w.i("MicroMsg.FreeWifi.FreeWifiNetwork", "code : %d, location : %s", new Object[]{Integer.valueOf(responseCode), httpURLConnection2.getHeaderField("Location")});
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return r1;
                } catch (Exception e) {
                    Exception exception2 = e;
                    httpURLConnection = httpURLConnection2;
                    exception = exception2;
                    try {
                        w.e("MicroMsg.FreeWifi.FreeWifiNetwork", "get recirect location failed : %s", new Object[]{exception.getMessage()});
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    httpURLConnection = httpURLConnection2;
                    th = th4;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            return null;
        } catch (Exception e2) {
            exception = e2;
            httpURLConnection = null;
            w.e("MicroMsg.FreeWifi.FreeWifiNetwork", "get recirect location failed : %s", new Object[]{exception.getMessage()});
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return null;
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    public static void a(String str, int i, Intent intent) {
        w.i("MicroMsg.FreeWifi.FreeWifiNetwork", "update ssid  : %s to new state : %d", new Object[]{str, Integer.valueOf(i)});
        if (i == 3) {
            w.e("MicroMsg.FreeWifi.FreeWifiNetwork", "new state is connect failed, update local freewifiinfo expired time to now");
            c wO = j.awC().wO(str);
            if (wO != null) {
                wO.field_expiredTime = bg.Ny() - 10;
                boolean c = j.awC().c(wO, new String[0]);
                w.i("MicroMsg.FreeWifi.FreeWifiNetwork", "update local freewifi info expired time : ssid is : %s, now time is : %d, update ret : %b", new Object[]{str, Long.valueOf(wO.field_expiredTime), Boolean.valueOf(c)});
            }
        }
        d.a(str, i, intent);
    }
}
