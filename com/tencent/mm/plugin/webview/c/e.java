package com.tencent.mm.plugin.webview.c;

import com.tencent.mm.sdk.platformtools.bg;
import java.util.Map;

public final class e {
    public static String o(Map<String, Object> map, String str) {
        if (map.containsKey(str)) {
            return map.get(str) != null ? map.get(str).toString() : "";
        } else {
            return "";
        }
    }

    public static boolean q(Map<String, Object> map, String str) {
        boolean z = false;
        String o = o(map, str);
        if (!bg.mA(o)) {
            try {
                z = Boolean.valueOf(o).booleanValue();
            } catch (Exception e) {
            }
        }
        return z;
    }

    public static int c(Map<String, Object> map, String str, int i) {
        String o = o(map, str);
        if (!bg.mA(o)) {
            try {
                i = Integer.valueOf(o).intValue();
            } catch (Exception e) {
            }
        }
        return i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final org.json.JSONObject a(com.tencent.mm.plugin.fts.a.a.i r11, java.lang.String r12, java.util.List<java.lang.String> r13) {
        /*
        r5 = 0;
        r2 = 0;
        r1 = 1;
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.wR();
        r3 = r11.lZO;
        r8 = r0.Rc(r3);
        r0 = r11.lZO;
        r4 = com.tencent.mm.u.n.eK(r0);
        r0 = r11.hPr;
        switch(r0) {
            case 1: goto L_0x012f;
            case 2: goto L_0x012c;
            case 3: goto L_0x0069;
            case 4: goto L_0x0086;
            case 5: goto L_0x0136;
            case 6: goto L_0x0133;
            case 7: goto L_0x0072;
            case 8: goto L_0x001b;
            case 9: goto L_0x001b;
            case 10: goto L_0x001b;
            case 11: goto L_0x0106;
            case 12: goto L_0x001b;
            case 13: goto L_0x001b;
            case 14: goto L_0x001b;
            case 15: goto L_0x0097;
            case 16: goto L_0x00b3;
            case 17: goto L_0x00f4;
            case 18: goto L_0x00e2;
            default: goto L_0x001b;
        };
    L_0x001b:
        r3 = r2;
        r6 = r2;
        r0 = r5;
        r7 = r5;
        r5 = r2;
    L_0x0020:
        if (r6 == 0) goto L_0x0127;
    L_0x0022:
        if (r3 == 0) goto L_0x0118;
    L_0x0024:
        r1 = com.tencent.mm.as.d.a(r4, r13, r2, r12);
    L_0x0028:
        if (r5 == 0) goto L_0x0041;
    L_0x002a:
        if (r3 == 0) goto L_0x011e;
    L_0x002c:
        r0 = com.tencent.mm.as.d.a(r0, r13, r2, r12);
    L_0x0030:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2 = r2.append(r7);
        r0 = r2.append(r0);
        r0 = r0.toString();
    L_0x0041:
        r2 = new org.json.JSONObject;
        r2.<init>();
        r3 = "nickName";
        r4 = com.tencent.mm.u.n.c(r8);	 Catch:{ JSONException -> 0x0124 }
        r2.put(r3, r4);	 Catch:{ JSONException -> 0x0124 }
        r3 = "userName";
        r4 = r11.lZO;	 Catch:{ JSONException -> 0x0124 }
        r2.put(r3, r4);	 Catch:{ JSONException -> 0x0124 }
        if (r6 == 0) goto L_0x0060;
    L_0x005a:
        r3 = "nickNameHighlight";
        r2.put(r3, r1);	 Catch:{ JSONException -> 0x0124 }
    L_0x0060:
        if (r5 == 0) goto L_0x0068;
    L_0x0062:
        r1 = "extraHighlight";
        r2.put(r1, r0);	 Catch:{ JSONException -> 0x0124 }
    L_0x0068:
        return r2;
    L_0x0069:
        r0 = r1;
    L_0x006a:
        r3 = r1;
    L_0x006b:
        r6 = r1;
        r7 = r5;
        r10 = r0;
        r0 = r5;
        r5 = r2;
        r2 = r10;
        goto L_0x0020;
    L_0x0072:
        r0 = r1;
    L_0x0073:
        r3 = r1;
    L_0x0074:
        r5 = r8.field_nickname;
        r6 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r7 = com.tencent.mm.R.l.ePI;
        r6 = r6.getString(r7);
        r7 = r6;
        r6 = r2;
        r2 = r0;
        r0 = r5;
        r5 = r1;
        goto L_0x0020;
    L_0x0086:
        r0 = r8.gkK;
        r3 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r5 = com.tencent.mm.R.l.ePE;
        r5 = r3.getString(r5);
        r3 = r2;
        r6 = r2;
        r7 = r5;
        r5 = r1;
        goto L_0x0020;
    L_0x0097:
        r0 = r8.pA();
        r3 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r3 == 0) goto L_0x00a3;
    L_0x00a1:
        r0 = r8.field_username;
    L_0x00a3:
        r3 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r5 = com.tencent.mm.R.l.ePM;
        r5 = r3.getString(r5);
        r3 = r2;
        r6 = r2;
        r7 = r5;
        r5 = r1;
        goto L_0x0020;
    L_0x00b3:
        r3 = r11.content;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r3);
        if (r0 != 0) goto L_0x012a;
    L_0x00bb:
        r0 = "​";
        r6 = r3.split(r0);
        r7 = r6.length;
        r5 = r2;
    L_0x00c4:
        if (r5 >= r7) goto L_0x012a;
    L_0x00c6:
        r0 = r6[r5];
        r9 = r0.startsWith(r12);
        if (r9 == 0) goto L_0x00de;
    L_0x00ce:
        r3 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r5 = com.tencent.mm.R.l.ePH;
        r5 = r3.getString(r5);
        r3 = r2;
        r6 = r2;
        r7 = r5;
        r5 = r1;
        goto L_0x0020;
    L_0x00de:
        r0 = r5 + 1;
        r5 = r0;
        goto L_0x00c4;
    L_0x00e2:
        r0 = r11.content;
        r3 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r5 = com.tencent.mm.R.l.ePJ;
        r5 = r3.getString(r5);
        r3 = r2;
        r6 = r2;
        r7 = r5;
        r5 = r1;
        goto L_0x0020;
    L_0x00f4:
        r0 = r11.content;
        r3 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r5 = com.tencent.mm.R.l.ePD;
        r5 = r3.getString(r5);
        r3 = r2;
        r6 = r2;
        r7 = r5;
        r5 = r1;
        goto L_0x0020;
    L_0x0106:
        r0 = r11.mar;
        r3 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r5 = com.tencent.mm.R.l.ePL;
        r5 = r3.getString(r5);
        r3 = r2;
        r6 = r2;
        r7 = r5;
        r5 = r1;
        goto L_0x0020;
    L_0x0118:
        r1 = com.tencent.mm.as.d.b(r4, r13, r12);
        goto L_0x0028;
    L_0x011e:
        r0 = com.tencent.mm.as.d.b(r0, r13, r12);
        goto L_0x0030;
    L_0x0124:
        r0 = move-exception;
        goto L_0x0068;
    L_0x0127:
        r1 = r4;
        goto L_0x0028;
    L_0x012a:
        r0 = r3;
        goto L_0x00ce;
    L_0x012c:
        r0 = r2;
        goto L_0x006a;
    L_0x012f:
        r0 = r2;
        r3 = r2;
        goto L_0x006b;
    L_0x0133:
        r0 = r2;
        goto L_0x0073;
    L_0x0136:
        r0 = r2;
        r3 = r2;
        goto L_0x0074;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.c.e.a(com.tencent.mm.plugin.fts.a.a.i, java.lang.String, java.util.List):org.json.JSONObject");
    }
}
