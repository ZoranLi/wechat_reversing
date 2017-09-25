package com.tencent.mm.storage;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;

public final class ba extends j {
    private t uKL = null;

    public ba(t tVar) {
        this.uKL = tVar;
    }

    public final void bMT() {
        int i;
        String str = (String) this.uKL.get(77825, null);
        w.i("MicroMsg.ServerConfigInfoStorage", "hy: readConfig xml " + str);
        if (!bg.mA(str)) {
            super.Qr(str);
        }
        if (bg.mA(str)) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            str = w.hgq + "deviceconfig.cfg";
            if (e.aO(str)) {
                byte[] d = e.d(str, 0, -1);
                if (bg.bm(d)) {
                    i = -2;
                } else {
                    String str2 = new String(d, Charset.defaultCharset());
                    if (bg.mA(str2)) {
                        i = -3;
                    } else {
                        w.i("MicroMsg.ServerConfigInfoStorage", "hy: read from file: %s", str2);
                        RW(str2);
                        i = 0;
                    }
                }
            } else {
                i = -1;
            }
        } else {
            w.i("MicroMsg.ServerConfigInfoStorage", "hy: got conf from db");
            i = 0;
        }
        w.i("MicroMsg.ServerConfigInfoStorage", "hy: read from local retcode: %d", Integer.valueOf(i));
    }

    public final String bMU() {
        String str = (String) this.uKL.get(77825, null);
        w.d("MicroMsg.ServerConfigInfoStorage", "getInfoByKey xml " + str + " key 77825");
        return str;
    }

    public final int RW(String str) {
        w.d("MicroMsg.ServerConfigInfoStorage", "dkconf info:[%s] ", str);
        this.uKL.set(77825, str);
        RY(str);
        super.Qr(str);
        return 0;
    }

    public static String bMV() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Object obj = Build.FINGERPRINT;
        if (obj != null) {
            obj = obj.replace("/", ":");
        }
        linkedHashMap.put("fingerprint", obj);
        linkedHashMap.put("manufacturer", Build.MANUFACTURER);
        linkedHashMap.put("device", Build.DEVICE);
        linkedHashMap.put("model", Build.MODEL);
        linkedHashMap.put("product", Build.PRODUCT);
        linkedHashMap.put("board", Build.BOARD);
        linkedHashMap.put("release", VERSION.RELEASE);
        linkedHashMap.put("codename", VERSION.CODENAME);
        linkedHashMap.put("incremental", VERSION.INCREMENTAL);
        linkedHashMap.put("display", Build.DISPLAY);
        String a = bg.a(linkedHashMap);
        w.d("MicroMsg.ServerConfigInfoStorage", "getLocalFingerprint  " + a);
        return a;
    }

    public static String bMW() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<deviceinfo>");
        stringBuffer.append("<MANUFACTURER name=\"");
        stringBuffer.append(Build.MANUFACTURER);
        stringBuffer.append("\">");
        stringBuffer.append("<MODEL name=\"");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("\">");
        stringBuffer.append("<VERSION_RELEASE name=\"");
        stringBuffer.append(VERSION.RELEASE);
        stringBuffer.append("\">");
        stringBuffer.append("<VERSION_INCREMENTAL name=\"");
        stringBuffer.append(VERSION.INCREMENTAL);
        stringBuffer.append("\">");
        stringBuffer.append("<DISPLAY name=\"");
        stringBuffer.append(Build.DISPLAY);
        stringBuffer.append("\">");
        stringBuffer.append("</DISPLAY></VERSION_INCREMENTAL></VERSION_RELEASE></MODEL></MANUFACTURER></deviceinfo>");
        w.d("MicroMsg.ServerConfigInfoStorage", "getFingerprint  " + stringBuffer.toString());
        return stringBuffer.toString();
    }

    public static boolean RX(String str) {
        if (bg.mA(str)) {
            return false;
        }
        try {
            if (bh.q(str, "deviceinfoconfig") == null || !h.vG().uV()) {
                return false;
            }
            h.vJ();
            h.vI().vs().RW(str);
            return true;
        } catch (Throwable e) {
            w.e("MicroMsg.ServerConfigInfoStorage", "exception:%s", bg.g(e));
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean RY(java.lang.String r9) {
        /*
        r0 = 1;
        r4 = 0;
        r1 = new java.io.File;
        r2 = com.tencent.mm.storage.w.hgq;
        r1.<init>(r2);
        r2 = r1.exists();
        if (r2 != 0) goto L_0x0012;
    L_0x000f:
        r1.mkdirs();
    L_0x0012:
        r3 = 0;
        r1 = "MicroMsg.ServerConfigInfoStorage";
        r2 = "writeConfigToLocalFile, path: %s, info:%s";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0073 }
        r6 = 0;
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0073 }
        r7.<init>();	 Catch:{ Exception -> 0x0073 }
        r8 = com.tencent.mm.storage.w.hgq;	 Catch:{ Exception -> 0x0073 }
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x0073 }
        r8 = "deviceconfig.cfg";
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x0073 }
        r7 = r7.toString();	 Catch:{ Exception -> 0x0073 }
        r5[r6] = r7;	 Catch:{ Exception -> 0x0073 }
        r6 = 1;
        r5[r6] = r9;	 Catch:{ Exception -> 0x0073 }
        com.tencent.mm.sdk.platformtools.w.i(r1, r2, r5);	 Catch:{ Exception -> 0x0073 }
        r2 = new java.io.FileWriter;	 Catch:{ Exception -> 0x0073 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0073 }
        r1.<init>();	 Catch:{ Exception -> 0x0073 }
        r5 = com.tencent.mm.storage.w.hgq;	 Catch:{ Exception -> 0x0073 }
        r1 = r1.append(r5);	 Catch:{ Exception -> 0x0073 }
        r5 = "deviceconfig.cfg";
        r1 = r1.append(r5);	 Catch:{ Exception -> 0x0073 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0073 }
        r2.<init>(r1);	 Catch:{ Exception -> 0x0073 }
        r2.write(r9);	 Catch:{ Exception -> 0x00c1, all -> 0x00be }
        r2.close();	 Catch:{ Exception -> 0x00c6, all -> 0x00be }
        r2.close();	 Catch:{ IOException -> 0x0060 }
    L_0x005f:
        return r0;
    L_0x0060:
        r1 = move-exception;
        r2 = "MicroMsg.ServerConfigInfoStorage";
        r3 = "exception:%s";
        r5 = new java.lang.Object[r0];
        r1 = com.tencent.mm.sdk.platformtools.bg.g(r1);
        r5[r4] = r1;
        com.tencent.mm.sdk.platformtools.w.e(r2, r3, r5);
        goto L_0x005f;
    L_0x0073:
        r1 = move-exception;
        r2 = r1;
        r1 = r4;
    L_0x0076:
        r5 = "MicroMsg.ServerConfigInfoStorage";
        r6 = "exception:%s";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x00a4 }
        r8 = 0;
        r2 = com.tencent.mm.sdk.platformtools.bg.g(r2);	 Catch:{ all -> 0x00a4 }
        r7[r8] = r2;	 Catch:{ all -> 0x00a4 }
        com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);	 Catch:{ all -> 0x00a4 }
        if (r3 == 0) goto L_0x00cb;
    L_0x008b:
        r3.close();	 Catch:{ IOException -> 0x0090 }
        r0 = r1;
        goto L_0x005f;
    L_0x0090:
        r2 = move-exception;
        r3 = "MicroMsg.ServerConfigInfoStorage";
        r5 = "exception:%s";
        r0 = new java.lang.Object[r0];
        r2 = com.tencent.mm.sdk.platformtools.bg.g(r2);
        r0[r4] = r2;
        com.tencent.mm.sdk.platformtools.w.e(r3, r5, r0);
        r0 = r1;
        goto L_0x005f;
    L_0x00a4:
        r1 = move-exception;
    L_0x00a5:
        if (r3 == 0) goto L_0x00aa;
    L_0x00a7:
        r3.close();	 Catch:{ IOException -> 0x00ab }
    L_0x00aa:
        throw r1;
    L_0x00ab:
        r2 = move-exception;
        r3 = "MicroMsg.ServerConfigInfoStorage";
        r5 = "exception:%s";
        r0 = new java.lang.Object[r0];
        r2 = com.tencent.mm.sdk.platformtools.bg.g(r2);
        r0[r4] = r2;
        com.tencent.mm.sdk.platformtools.w.e(r3, r5, r0);
        goto L_0x00aa;
    L_0x00be:
        r1 = move-exception;
        r3 = r2;
        goto L_0x00a5;
    L_0x00c1:
        r1 = move-exception;
        r3 = r2;
        r2 = r1;
        r1 = r4;
        goto L_0x0076;
    L_0x00c6:
        r1 = move-exception;
        r3 = r2;
        r2 = r1;
        r1 = r0;
        goto L_0x0076;
    L_0x00cb:
        r0 = r1;
        goto L_0x005f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.ba.RY(java.lang.String):boolean");
    }
}
