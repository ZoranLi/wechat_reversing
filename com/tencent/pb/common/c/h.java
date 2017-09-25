package com.tencent.pb.common.c;

import com.google.a.a.e;
import com.tencent.pb.common.b.a;
import com.tencent.pb.common.b.a.a.c;
import com.tencent.pb.common.b.a.a.u;
import com.tencent.pb.common.b.f;
import java.util.ArrayList;
import java.util.HashMap;

public final class h {
    private static Object sP = new Object();
    private static HashMap<String, String> wPc = new HashMap();

    public static void w(int i, int i2, String str) {
        if (str == null) {
            d.k("gyz", "addEmergencyRecord value is null");
            return;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(i);
            stringBuffer.append("---");
            stringBuffer.append(i2);
            synchronized (sP) {
                String str2 = (String) wPc.get(stringBuffer.toString());
                if (str2 != null && str2.length() > 0) {
                    StringBuffer stringBuffer2 = new StringBuffer(str2);
                    stringBuffer2.append("---");
                    stringBuffer2.append(str);
                    str = stringBuffer2.toString();
                }
                wPc.put(stringBuffer.toString(), str);
            }
        } catch (Throwable th) {
            d.k("gyz", th);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void an(java.util.ArrayList<com.tencent.pb.common.b.a.a.u> r13) {
        /*
        r12 = 2;
        r11 = 1;
        r2 = 0;
        r1 = sP;
        monitor-enter(r1);
        r0 = wPc;	 Catch:{ all -> 0x0097 }
        r0 = r0.keySet();	 Catch:{ all -> 0x0097 }
        if (r0 == 0) goto L_0x0014;
    L_0x000e:
        r3 = r0.size();	 Catch:{ all -> 0x0097 }
        if (r3 > 0) goto L_0x0016;
    L_0x0014:
        monitor-exit(r1);	 Catch:{ all -> 0x0097 }
    L_0x0015:
        return;
    L_0x0016:
        monitor-exit(r1);	 Catch:{ all -> 0x0097 }
        r3 = new java.lang.StringBuffer;
        r3.<init>();
        r4 = r0.iterator();
    L_0x0020:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x0015;
    L_0x0026:
        r0 = r4.next();
        r0 = (java.lang.String) r0;
        r1 = "---";
        r1 = r0.split(r1);
        r5 = r1.length;
        if (r5 < r12) goto L_0x0020;
    L_0x0036:
        r5 = r1[r2];
        r6 = r1[r11];
        r1 = sP;
        monitor-enter(r1);
        r7 = wPc;	 Catch:{ all -> 0x009a }
        r0 = r7.get(r0);	 Catch:{ all -> 0x009a }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x009a }
        monitor-exit(r1);	 Catch:{ all -> 0x009a }
        if (r0 == 0) goto L_0x0020;
    L_0x0048:
        r1 = r0.length();
        if (r1 == 0) goto L_0x0020;
    L_0x004e:
        r1 = "---";
        r7 = r0.split(r1);
        if (r7 == 0) goto L_0x0020;
    L_0x0057:
        r0 = r7.length;
        if (r0 == 0) goto L_0x0020;
    L_0x005a:
        r8 = r7.length;
        r1 = r2;
    L_0x005c:
        if (r1 >= r8) goto L_0x0020;
    L_0x005e:
        r0 = r7[r1];
        if (r0 == 0) goto L_0x0093;
    L_0x0062:
        r9 = r0.length();
        if (r9 == 0) goto L_0x0093;
    L_0x0068:
        r9 = "%";
        r9 = r0.split(r9);
        r10 = r9.length;
        if (r10 != r12) goto L_0x0074;
    L_0x0072:
        r0 = r9[r11];
    L_0x0074:
        r9 = new com.tencent.pb.common.b.a.a$u;
        r9.<init>();
        r9.wMV = r5;
        r3.setLength(r2);
        r3.append(r6);
        r10 = "%";
        r3.append(r10);
        r3.append(r0);
        r0 = r3.toString();
        r9.wMW = r0;
        r13.add(r9);
    L_0x0093:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x005c;
    L_0x0097:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0097 }
        throw r0;
    L_0x009a:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x009a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.pb.common.c.h.an(java.util.ArrayList):void");
    }

    public static void QZ() {
        synchronized (sP) {
            wPc.clear();
        }
    }

    public static void cdl() {
        if (com.tencent.pb.common.b.h.isNetworkConnected()) {
            e cVar;
            ArrayList arrayList = new ArrayList();
            an(arrayList);
            if (arrayList.size() > 0) {
                cVar = new c();
                u[] uVarArr = new u[arrayList.size()];
                arrayList.toArray(uVarArr);
                cVar.wLH = uVarArr;
            } else {
                cVar = null;
            }
            if (cVar == null) {
                d.k("StatisticsUtil", "reportStatisticsData CSClientReportReq is null");
                return;
            }
            d.k("yunying", "reportStatisticsData");
            int a = f.ccT().a(new a() {
                public final void df(String str, int i) {
                    if ("CsCmd.Cmd_CSClientReportReq".equals(str)) {
                        if (i == 0) {
                            h.QZ();
                        }
                        d.k("yunying", "reportStatisticsData isCommonData:  errCode: " + i);
                    }
                }
            }, "CsCmd.Cmd_CSClientReportReq", cVar);
            d.d("StatisticsUtil", "reportStatisticsData start ret: ", Integer.valueOf(a));
            return;
        }
        d.k("StatisticsUtil", "reportStatisticsData network is false");
    }
}
