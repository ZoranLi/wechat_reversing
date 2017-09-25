package com.tencent.mm.plugin.appbrand.report;

import android.content.Context;
import android.os.HandlerThread;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.regex.Pattern;

public final class a {
    private static HandlerThread jfQ;
    private static ae jfR = new ae(jfQ.getLooper());
    private static Pattern jfS = Pattern.compile(".*\"errMsg\":\"[^:]+:([^\"]+)\".*");

    static {
        HandlerThread cE = e.cE("app_brand_report_thread", 1);
        jfQ = cE;
        cE.start();
    }

    public static String bz(Context context) {
        String str;
        if (!am.isConnected(context)) {
            str = "offline";
        } else if (am.isWifi(context)) {
            str = "wifi";
        } else if (am.is4G(context)) {
            str = "4g";
        } else if (am.is3G(context)) {
            str = "3g";
        } else if (am.is2G(context)) {
            str = "2g";
        } else {
            str = "unknown";
        }
        w.i("MicroMsg.AppBrandReporterManager", "get networkType %s", new Object[]{str});
        return str;
    }

    public static void a(int i, String str, String str2, int i2, String str3, String str4) {
        w.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, appid %s, appversion %d, appidlist %snearbyAppIdCount %s, nearbyAppIdList %s", new Object[]{Integer.valueOf(13533), Integer.valueOf(i), bg.mz(str), Integer.valueOf(0), str2, Integer.valueOf(i2), str3});
        g.oUh.i(13533, new Object[]{Integer.valueOf(i), bg.mz(str), Integer.valueOf(0), str2, Integer.valueOf(i2), str3, Integer.valueOf(0), str4});
    }

    public static void a(String str, int i, int i2, int i3, String str2) {
        w.d("MicroMsg.AppBrandReporterManager", "stev report(%s), appId %s, appVersion %s, appState : %d, eventId %d, scene %d, sceneId %s", new Object[]{Integer.valueOf(13801), str, Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str2});
        g.oUh.i(13801, new Object[]{str, Integer.valueOf(0), Integer.valueOf(i), Long.valueOf(bg.Ny()), Integer.valueOf(i2), Integer.valueOf(i3), str2});
    }

    public static void b(String str, String str2, int i, int i2, int i3) {
        AppBrandStatObject mZ = b.mZ(str);
        if (mZ == null) {
            mZ = new AppBrandStatObject();
            w.i("MicroMsg.AppBrandReporterManager", "statObject is Null!");
        }
        String str3 = "";
        if (!bg.mA(str2) && str2.contains(".html")) {
            str3 = str2.substring(0, str2.lastIndexOf(".html") + 5);
        }
        String str4 = "";
        try {
            str4 = p.encode(bg.mz(str3), "UTF-8");
        } catch (Throwable e) {
            w.e("MicroMsg.AppBrandReporterManager", "encode page path error!");
            w.printErrStackTrace("MicroMsg.AppBrandReporterManager", e, "", new Object[0]);
        }
        String mz = bg.mz(mZ.fCN);
        String mz2 = bg.mz(l.ns(str).ixn);
        if (mZ.scene == 0) {
            mZ.scene = 1000;
        }
        String bz = bz(ab.getContext());
        if (bg.mA(bz)) {
            bz = "unknown";
        }
        long Ny = bg.Ny();
        w.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote %s, sessionId %s, appid %s, appversion %d, appState %d, usedState %d, pagePath %s, networkType %s, eventId %d,eventRusult %d, eventPercent %d, installCostTime %s, eventTime %s", new Object[]{Integer.valueOf(13537), Integer.valueOf(mZ.scene), mz, mz2, str, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(mZ.jfY), str3, bz, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(i3), Long.valueOf(Ny)});
        g.oUh.i(13537, new Object[]{Integer.valueOf(mZ.scene), mz, mz2, str, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(mZ.jfY), str4, bz, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(i3), Long.valueOf(Ny)});
    }

    public static void a(String str, String str2, int i, String str3, long j, int i2, int i3) {
        AppBrandStatObject mZ = b.mZ(str);
        if (mZ == null) {
            w.e("MicroMsg.AppBrandReporterManager", "statObject is Null!");
            return;
        }
        String str4 = "";
        if (!bg.mA(str2)) {
            if (str2.contains(".html")) {
                str4 = str2.substring(0, str2.lastIndexOf(".html") + 5);
            }
        }
        String str5 = "";
        try {
            str5 = p.encode(bg.mz(str4), "UTF-8");
        } catch (Throwable e) {
            w.e("MicroMsg.AppBrandReporterManager", "encode page path error!");
            w.printErrStackTrace("MicroMsg.AppBrandReporterManager", e, "", new Object[0]);
        }
        AppBrandSysConfig mY = b.mY(str);
        int i4 = mY == null ? 0 : mY.iFk.izW;
        int i5 = mY == null ? 0 : mY.iFk.izV + 1;
        String mz = bg.mz(str3);
        String mz2 = bg.mz(mZ.fCN);
        String mz3 = bg.mz(l.ns(str).ixn);
        if (mZ.scene == 0) {
            mZ.scene = 1000;
        }
        int i6 = mZ.fWL;
        String str6 = mZ.fWM;
        w.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote : %s, sessionId : %s, appid : %s, appversion : %d, appState : %d, usedState : %d, pagePath : %s, action : %d, actionNote : %s,actionTime : %s, actionResult : %d, actionErrorcode : %d, preScene : %d, preSceneNote : %s", new Object[]{Integer.valueOf(13539), Integer.valueOf(mZ.scene), mz2, mz3, str, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(mZ.jfY), str4, Integer.valueOf(i), mz, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i6), str6});
        g.oUh.i(13539, new Object[]{Integer.valueOf(mZ.scene), mz2, mz3, str, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(mZ.jfY), str5, Integer.valueOf(i), mz, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i6), str6});
    }

    public static void a(String str, String str2, int i, int i2, String str3, String str4, int i3, String str5, long j, int i4, int i5) {
        int i6 = 3;
        if (!bg.mA(str)) {
            String str6 = "";
            if (!bg.mA(str4)) {
                if (str4.contains(".html")) {
                    String str7 = str4;
                    str6 = str7.substring(0, str4.lastIndexOf(".html") + 5);
                }
            }
            String str8 = "";
            try {
                str8 = p.encode(bg.mz(str6), "UTF-8");
            } catch (Throwable e) {
                w.e("MicroMsg.AppBrandReporterManager", "encode page path error!");
                w.printErrStackTrace("MicroMsg.AppBrandReporterManager", e, "", new Object[0]);
            }
            String mz = bg.mz(str3);
            String mz2 = bg.mz(str5);
            String mz3 = bg.mz(str2);
            if (i > 0) {
                i6 = i - 1;
                boolean V = c.PW().V(str, i6);
                if (c.PX().U(str, i6)) {
                    i6 = 1;
                } else if (V) {
                    i6 = 2;
                } else {
                    i6 = 3;
                }
            }
            w.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote %s, appid %s, appversion %d, appState %d, usedState %d, pagePath %s, action %d, actionNote %s,actionTime %s, actionResult %d, actionErrorcode %d", new Object[]{Integer.valueOf(13540), Integer.valueOf(i2), mz, mz3, Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(i6), str6, Integer.valueOf(i3), mz2, Long.valueOf(j), Integer.valueOf(i4), Integer.valueOf(i5)});
            g.oUh.i(13540, new Object[]{Integer.valueOf(i2), mz, mz3, Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(i6), str8, Integer.valueOf(i3), mz2, Long.valueOf(j), Integer.valueOf(i4), Integer.valueOf(i5)});
        }
    }

    public static void a(String str, String str2, String str3, String str4, int i, long j, String str5) {
        final String str6 = str;
        final String str7 = str2;
        final String str8 = str3;
        final String str9 = str4;
        final int i2 = i;
        final long j2 = j;
        final String str10 = str5;
        jfR.post(new Runnable() {
            public final void run() {
                a.b(str6, str7, str8, str9, i2, j2, str10);
            }
        });
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, int r23, long r24, java.lang.String r26) {
        /*
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r19);
        if (r1 == 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r9 = com.tencent.mm.plugin.appbrand.b.mZ(r19);
        if (r9 != 0) goto L_0x0017;
    L_0x000d:
        r1 = "MicroMsg.AppBrandReporterManager";
        r2 = "statObject is Null!";
        com.tencent.mm.sdk.platformtools.w.e(r1, r2);
        goto L_0x0006;
    L_0x0017:
        r1 = 9;
        r2 = new java.lang.String[r1];
        r1 = 0;
        r3 = "updateMap";
        r2[r1] = r3;
        r1 = 1;
        r3 = "addMapMarkers";
        r2[r1] = r3;
        r1 = 2;
        r3 = "addMapLines";
        r2[r1] = r3;
        r1 = 3;
        r3 = "addMapCircles";
        r2[r1] = r3;
        r1 = 4;
        r3 = "addMapControls";
        r2[r1] = r3;
        r1 = 5;
        r3 = "moveToMapLocation";
        r2[r1] = r3;
        r1 = 6;
        r3 = "getMapCenterLocation";
        r2[r1] = r3;
        r1 = 7;
        r3 = "drawCanvas";
        r2[r1] = r3;
        r1 = 8;
        r3 = "updateCanvas";
        r2[r1] = r3;
        r1 = 0;
    L_0x0053:
        r3 = 9;
        if (r1 >= r3) goto L_0x0064;
    L_0x0057:
        r3 = r2[r1];
        r0 = r21;
        r3 = r0.equals(r3);
        if (r3 != 0) goto L_0x0006;
    L_0x0061:
        r1 = r1 + 1;
        goto L_0x0053;
    L_0x0064:
        r1 = "";
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r22);
        if (r2 != 0) goto L_0x00d7;
    L_0x006d:
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r21);
        if (r2 != 0) goto L_0x00d7;
    L_0x0073:
        r2 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x02b8 }
        r0 = r22;
        r2.<init>(r0);	 Catch:{ JSONException -> 0x02b8 }
        r3 = "url";
        r3 = r2.has(r3);	 Catch:{ JSONException -> 0x02b8 }
        if (r3 == 0) goto L_0x0275;
    L_0x0083:
        r3 = "openLink";
        r0 = r21;
        r3 = r0.equals(r3);	 Catch:{ JSONException -> 0x02b8 }
        if (r3 != 0) goto L_0x00d0;
    L_0x008e:
        r3 = "redirectTo";
        r0 = r21;
        r3 = r0.equals(r3);	 Catch:{ JSONException -> 0x02b8 }
        if (r3 != 0) goto L_0x00d0;
    L_0x0099:
        r3 = "navigateTo";
        r0 = r21;
        r3 = r0.equals(r3);	 Catch:{ JSONException -> 0x02b8 }
        if (r3 != 0) goto L_0x00d0;
    L_0x00a4:
        r3 = "request";
        r0 = r21;
        r3 = r0.equals(r3);	 Catch:{ JSONException -> 0x02b8 }
        if (r3 != 0) goto L_0x00d0;
    L_0x00af:
        r3 = "connectSocket";
        r0 = r21;
        r3 = r0.equals(r3);	 Catch:{ JSONException -> 0x02b8 }
        if (r3 != 0) goto L_0x00d0;
    L_0x00ba:
        r3 = "uploadFile";
        r0 = r21;
        r3 = r0.equals(r3);	 Catch:{ JSONException -> 0x02b8 }
        if (r3 != 0) goto L_0x00d0;
    L_0x00c5:
        r3 = "downloadFile";
        r0 = r21;
        r3 = r0.equals(r3);	 Catch:{ JSONException -> 0x02b8 }
        if (r3 == 0) goto L_0x0275;
    L_0x00d0:
        r3 = "url";
        r1 = r2.optString(r3);	 Catch:{ JSONException -> 0x02b8 }
    L_0x00d7:
        r2 = "";
        r3 = com.tencent.mm.sdk.platformtools.bg.mA(r20);
        if (r3 != 0) goto L_0x00fd;
    L_0x00e0:
        r3 = ".html";
        r0 = r20;
        r3 = r0.contains(r3);
        if (r3 == 0) goto L_0x00fd;
    L_0x00eb:
        r2 = 0;
        r3 = ".html";
        r0 = r20;
        r3 = r0.lastIndexOf(r3);
        r3 = r3 + 5;
        r0 = r20;
        r2 = r0.substring(r2, r3);
    L_0x00fd:
        r3 = "";
        r4 = com.tencent.mm.sdk.platformtools.bg.mz(r2);	 Catch:{ UnsupportedEncodingException -> 0x037f }
        r5 = "UTF-8";
        r3 = com.tencent.mm.compatible.util.p.encode(r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x037f }
    L_0x010b:
        r4 = "";
        r5 = com.tencent.mm.sdk.platformtools.bg.mz(r1);	 Catch:{ UnsupportedEncodingException -> 0x0397 }
        r6 = "UTF-8";
        r4 = com.tencent.mm.compatible.util.p.encode(r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x0397 }
    L_0x0119:
        r10 = com.tencent.mm.sdk.platformtools.bg.mz(r21);
        r5 = com.tencent.mm.sdk.platformtools.bg.mA(r26);
        if (r5 != 0) goto L_0x03af;
    L_0x0123:
        r5 = jfS;
        r0 = r26;
        r5 = r5.matcher(r0);
        r6 = r5.matches();
        if (r6 == 0) goto L_0x03af;
    L_0x0131:
        r6 = 1;
        r5 = r5.group(r6);
        r5 = com.tencent.mm.sdk.platformtools.bg.mz(r5);
    L_0x013a:
        r6 = com.tencent.mm.sdk.platformtools.bg.mA(r5);
        if (r6 != 0) goto L_0x03b4;
    L_0x0140:
        r6 = "ok";
        r6 = r5.startsWith(r6);
        if (r6 != 0) goto L_0x03b4;
    L_0x0149:
        r6 = "fail";
        r6 = r5.startsWith(r6);
        if (r6 == 0) goto L_0x03b4;
    L_0x0152:
        r6 = 2;
    L_0x0153:
        r7 = r9.fCN;
        r11 = com.tencent.mm.sdk.platformtools.bg.mz(r7);
        r7 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r12 = bz(r7);
        r7 = r9.scene;
        if (r7 != 0) goto L_0x0169;
    L_0x0165:
        r7 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r9.scene = r7;
    L_0x0169:
        r13 = com.tencent.mm.plugin.appbrand.b.mY(r19);
        if (r13 != 0) goto L_0x03b7;
    L_0x016f:
        r7 = 0;
        r8 = r7;
    L_0x0171:
        if (r13 != 0) goto L_0x03be;
    L_0x0173:
        r7 = 0;
    L_0x0174:
        r13 = "MicroMsg.AppBrandReporterManager";
        r14 = "stev report(%s), scene : %s, sceneNote %s, appId %s, appVersion %d, appState %d, pagePath %s, networkType %s, functionName %s, keyParam %s, result %d, permissionValue %d, errorCode %d, costTime %s, errCode %d, errMsg %s, usedState %d";
        r15 = 17;
        r15 = new java.lang.Object[r15];
        r16 = 0;
        r17 = 13542; // 0x34e6 float:1.8976E-41 double:6.6906E-320;
        r17 = java.lang.Integer.valueOf(r17);
        r15[r16] = r17;
        r16 = 1;
        r0 = r9.scene;
        r17 = r0;
        r17 = java.lang.Integer.valueOf(r17);
        r15[r16] = r17;
        r16 = 2;
        r15[r16] = r11;
        r16 = 3;
        r15[r16] = r19;
        r16 = 4;
        r17 = java.lang.Integer.valueOf(r8);
        r15[r16] = r17;
        r16 = 5;
        r17 = java.lang.Integer.valueOf(r7);
        r15[r16] = r17;
        r16 = 6;
        r15[r16] = r2;
        r2 = 7;
        r15[r2] = r12;
        r2 = 8;
        r15[r2] = r10;
        r2 = 9;
        r15[r2] = r1;
        r1 = 10;
        r2 = java.lang.Integer.valueOf(r6);
        r15[r1] = r2;
        r1 = 11;
        r2 = java.lang.Integer.valueOf(r23);
        r15[r1] = r2;
        r1 = 12;
        r2 = 0;
        r2 = java.lang.Integer.valueOf(r2);
        r15[r1] = r2;
        r1 = 13;
        r2 = java.lang.Long.valueOf(r24);
        r15[r1] = r2;
        r1 = 14;
        r2 = 0;
        r2 = java.lang.Integer.valueOf(r2);
        r15[r1] = r2;
        r1 = 15;
        r15[r1] = r5;
        r1 = 16;
        r2 = r9.jfY;
        r2 = java.lang.Integer.valueOf(r2);
        r15[r1] = r2;
        com.tencent.mm.sdk.platformtools.w.d(r13, r14, r15);
        r1 = com.tencent.mm.plugin.report.service.g.oUh;
        r2 = 13542; // 0x34e6 float:1.8976E-41 double:6.6906E-320;
        r13 = 18;
        r13 = new java.lang.Object[r13];
        r14 = 0;
        r15 = r9.scene;
        r15 = java.lang.Integer.valueOf(r15);
        r13[r14] = r15;
        r14 = 1;
        r13[r14] = r11;
        r11 = 2;
        r13[r11] = r19;
        r11 = 3;
        r8 = java.lang.Integer.valueOf(r8);
        r13[r11] = r8;
        r8 = 4;
        r7 = java.lang.Integer.valueOf(r7);
        r13[r8] = r7;
        r7 = 5;
        r13[r7] = r3;
        r3 = 6;
        r13[r3] = r12;
        r3 = 7;
        r13[r3] = r10;
        r3 = 8;
        r13[r3] = r4;
        r3 = 9;
        r4 = java.lang.Integer.valueOf(r6);
        r13[r3] = r4;
        r3 = 10;
        r4 = java.lang.Integer.valueOf(r23);
        r13[r3] = r4;
        r3 = 11;
        r4 = 0;
        r4 = java.lang.Integer.valueOf(r4);
        r13[r3] = r4;
        r3 = 12;
        r4 = java.lang.Long.valueOf(r24);
        r13[r3] = r4;
        r3 = 13;
        r4 = 0;
        r4 = java.lang.Integer.valueOf(r4);
        r13[r3] = r4;
        r3 = 14;
        r13[r3] = r5;
        r3 = 15;
        r4 = r9.jfY;
        r4 = java.lang.Integer.valueOf(r4);
        r13[r3] = r4;
        r3 = 16;
        r4 = r9.fWL;
        r4 = java.lang.Integer.valueOf(r4);
        r13[r3] = r4;
        r3 = 17;
        r4 = r9.fWM;
        r13[r3] = r4;
        r1.i(r2, r13);
        goto L_0x0006;
    L_0x0275:
        r3 = "authorize";
        r0 = r21;
        r3 = r0.equals(r3);	 Catch:{ JSONException -> 0x02b8 }
        if (r3 == 0) goto L_0x02d6;
    L_0x0280:
        r3 = new org.json.JSONArray;	 Catch:{ Exception -> 0x02a2 }
        r4 = "scope";
        r2 = r2.optString(r4);	 Catch:{ Exception -> 0x02a2 }
        r3.<init>(r2);	 Catch:{ Exception -> 0x02a2 }
        r4 = new java.util.LinkedList;	 Catch:{ JSONException -> 0x02b8 }
        r4.<init>();	 Catch:{ JSONException -> 0x02b8 }
        r2 = 0;
    L_0x0292:
        r5 = r3.length();	 Catch:{ JSONException -> 0x02b8 }
        if (r2 >= r5) goto L_0x02d0;
    L_0x0298:
        r5 = r3.optString(r2);	 Catch:{ JSONException -> 0x02b8 }
        r4.add(r5);	 Catch:{ JSONException -> 0x02b8 }
        r2 = r2 + 1;
        goto L_0x0292;
    L_0x02a2:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandReporterManager";
        r4 = "Exception %s";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ JSONException -> 0x02b8 }
        r6 = 0;
        r2 = r2.getMessage();	 Catch:{ JSONException -> 0x02b8 }
        r5[r6] = r2;	 Catch:{ JSONException -> 0x02b8 }
        com.tencent.mm.sdk.platformtools.w.e(r3, r4, r5);	 Catch:{ JSONException -> 0x02b8 }
        goto L_0x0006;
    L_0x02b8:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandReporterManager";
        r4 = "get keyParam error!";
        com.tencent.mm.sdk.platformtools.w.e(r3, r4);
        r3 = "MicroMsg.AppBrandReporterManager";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x00d7;
    L_0x02d0:
        r1 = r4.toString();	 Catch:{ JSONException -> 0x02b8 }
        goto L_0x00d7;
    L_0x02d6:
        r3 = "shareAppMessage";
        r0 = r21;
        r3 = r0.equals(r3);	 Catch:{ JSONException -> 0x02b8 }
        if (r3 == 0) goto L_0x0301;
    L_0x02e1:
        r2 = r2.toString();	 Catch:{ UnsupportedEncodingException -> 0x02f2 }
        r2 = com.tencent.mm.sdk.platformtools.bg.mz(r2);	 Catch:{ UnsupportedEncodingException -> 0x02f2 }
        r3 = "UTF-8";
        r1 = com.tencent.mm.compatible.util.p.encode(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x02f2 }
        goto L_0x00d7;
    L_0x02f2:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandReporterManager";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];	 Catch:{ JSONException -> 0x02b8 }
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);	 Catch:{ JSONException -> 0x02b8 }
        goto L_0x00d7;
    L_0x0301:
        r3 = "requestPayment";
        r0 = r21;
        r3 = r0.equals(r3);	 Catch:{ JSONException -> 0x02b8 }
        if (r3 == 0) goto L_0x0315;
    L_0x030c:
        r3 = "package";
        r1 = r2.optString(r3);	 Catch:{ JSONException -> 0x02b8 }
        goto L_0x00d7;
    L_0x0315:
        r3 = "reportSubmitForm";
        r0 = r21;
        r3 = r0.equals(r3);	 Catch:{ JSONException -> 0x02b8 }
        if (r3 == 0) goto L_0x0328;
    L_0x0320:
        r2 = com.tencent.mm.plugin.appbrand.l.ns(r19);	 Catch:{ JSONException -> 0x02b8 }
        r1 = r2.ixo;	 Catch:{ JSONException -> 0x02b8 }
        goto L_0x00d7;
    L_0x0328:
        r3 = "makePhoneCall";
        r0 = r21;
        r3 = r0.equals(r3);	 Catch:{ JSONException -> 0x02b8 }
        if (r3 == 0) goto L_0x033c;
    L_0x0333:
        r3 = "phoneNumber";
        r1 = r2.optString(r3);	 Catch:{ JSONException -> 0x02b8 }
        goto L_0x00d7;
    L_0x033c:
        r3 = "chooseVideo";
        r0 = r21;
        r3 = r0.equals(r3);	 Catch:{ JSONException -> 0x02b8 }
        if (r3 == 0) goto L_0x0350;
    L_0x0347:
        r3 = "maxDuration";
        r1 = r2.optString(r3);	 Catch:{ JSONException -> 0x02b8 }
        goto L_0x00d7;
    L_0x0350:
        r3 = "updateHTMLWebView";
        r0 = r21;
        r3 = r0.equals(r3);	 Catch:{ JSONException -> 0x02b8 }
        if (r3 == 0) goto L_0x00d7;
    L_0x035b:
        r3 = "src";
        r1 = r2.optString(r3);	 Catch:{ JSONException -> 0x02b8 }
        r3 = "src";
        r2 = r2.optString(r3);	 Catch:{ Exception -> 0x0372 }
        r3 = "UTF-8";
        r1 = com.tencent.mm.compatible.util.p.encode(r2, r3);	 Catch:{ Exception -> 0x0372 }
        goto L_0x00d7;
    L_0x0372:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandReporterManager";
        r2 = r2.toString();	 Catch:{ JSONException -> 0x02b8 }
        com.tencent.mm.sdk.platformtools.w.e(r3, r2);	 Catch:{ JSONException -> 0x02b8 }
        goto L_0x00d7;
    L_0x037f:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandReporterManager";
        r6 = "encode page path error!";
        com.tencent.mm.sdk.platformtools.w.e(r5, r6);
        r5 = "MicroMsg.AppBrandReporterManager";
        r6 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x010b;
    L_0x0397:
        r5 = move-exception;
        r6 = "MicroMsg.AppBrandReporterManager";
        r7 = "encode keyParam path error!";
        com.tencent.mm.sdk.platformtools.w.e(r6, r7);
        r6 = "MicroMsg.AppBrandReporterManager";
        r7 = "";
        r8 = 0;
        r8 = new java.lang.Object[r8];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r6, r5, r7, r8);
        goto L_0x0119;
    L_0x03af:
        r5 = "";
        goto L_0x013a;
    L_0x03b4:
        r6 = 1;
        goto L_0x0153;
    L_0x03b7:
        r7 = r13.iFk;
        r7 = r7.izW;
        r8 = r7;
        goto L_0x0171;
    L_0x03be:
        r7 = r13.iFk;
        r7 = r7.izV;
        r7 = r7 + 1;
        goto L_0x0174;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.report.a.b(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, long, java.lang.String):void");
    }

    public static void al(String str, int i) {
        w(str, i, 0);
    }

    public static void w(String str, int i, int i2) {
        if (!"@LibraryAppId".equals(str)) {
            int i3;
            Object obj;
            int i4;
            int i5 = 1000;
            String str2 = "";
            int i6 = 0;
            int i7 = 0;
            if (!bg.mA(str)) {
                AppBrandStatObject mZ = b.mZ(str);
                if (mZ != null) {
                    i7 = mZ.scene == 0 ? 1000 : mZ.scene;
                    str2 = bg.mz(mZ.fCN);
                    i5 = i7;
                    i7 = mZ.jfY;
                }
                AppBrandSysConfig mY = b.mY(str);
                if (!(mY == null || mY.iFk == null)) {
                    i6 = mY.iFk.izW;
                }
                if (!(i2 != 0 || mY == null || mY.iFk == null)) {
                    i2 = mY.iFk.izV + 1;
                    i3 = i6;
                    i6 = i5;
                    obj = str2;
                    i4 = i3;
                    w.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %s, sceneNote %s, appId %s, appVersion %s, appState %s, usedState %s, pagetype %s, targetAction %s", new Object[]{Integer.valueOf(13541), Integer.valueOf(i6), obj, str, Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i7), Integer.valueOf(i), Integer.valueOf(3)});
                    g.oUh.i(13541, new Object[]{Integer.valueOf(i6), obj, str, Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i7), Integer.valueOf(i), Integer.valueOf(3), ""});
                }
            }
            i3 = i6;
            i6 = i5;
            String str3 = str2;
            i4 = i3;
            w.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %s, sceneNote %s, appId %s, appVersion %s, appState %s, usedState %s, pagetype %s, targetAction %s", new Object[]{Integer.valueOf(13541), Integer.valueOf(i6), obj, str, Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i7), Integer.valueOf(i), Integer.valueOf(3)});
            g.oUh.i(13541, new Object[]{Integer.valueOf(i6), obj, str, Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i7), Integer.valueOf(i), Integer.valueOf(3), ""});
        }
    }

    public static void d(long j, boolean z) {
        int i = j <= 2000 ? z ? 8 : 1 : j <= 3000 ? z ? 9 : 2 : j <= 4000 ? z ? 10 : 3 : j <= 5000 ? z ? 11 : 4 : j <= 6000 ? z ? 12 : 5 : z ? 13 : 6;
        g.oUh.a(367, (long) i, 1, false);
        if (z) {
            g.oUh.a(367, 7, 1, false);
        } else {
            g.oUh.a(367, 0, 1, false);
        }
        w.v("MicroMsg.AppBrandReporterManager", "startApp cost %s msec(hasDownload : %b).", new Object[]{Long.valueOf(j), Boolean.valueOf(z)});
    }

    public static void Ws() {
        int bKf = bg.bKf();
        w.i("MicroMsg.AppBrandReporterManager", "report now process mem : %d", new Object[]{Integer.valueOf(bg.bKf())});
        if (bKf <= 90) {
            bKf = 2;
        } else if (bKf <= 130) {
            bKf = 3;
        } else if (bKf <= 170) {
            bKf = 4;
        } else if (bKf <= h.CTRL_INDEX) {
            bKf = 5;
        } else {
            bKf = 6;
        }
        g.oUh.a(386, 1, 1, false);
        g.oUh.a(386, (long) bKf, 1, false);
    }

    public static void cc(boolean z) {
        g.oUh.n(482, 482, 1, z ? 2 : 3);
    }

    public static void b(String str, int i, int i2, int i3, int i4) {
        g.oUh.i(14369, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(1)});
    }
}
