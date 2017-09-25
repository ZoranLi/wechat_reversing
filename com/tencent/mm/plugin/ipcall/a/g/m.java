package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.platformtools.w;

public final class m {
    public static k b(k kVar) {
        if (kVar == null) {
            return null;
        }
        w.d("MicroMsg.IPCallRecordStorageLogic", "recordCancelCall, localId: %d", new Object[]{Long.valueOf(kVar.uxb)});
        if (kVar.uxb == -1) {
            return kVar;
        }
        kVar.field_status = 7;
        i.aEo().a(kVar);
        return kVar;
    }

    public static k a(k kVar, long j) {
        if (kVar == null) {
            return null;
        }
        w.d("MicroMsg.IPCallRecordStorageLogic", "recordSelfShutdownCall, localId: %d, talkTime: %d", new Object[]{Long.valueOf(kVar.uxb), Long.valueOf(j)});
        if (kVar.uxb == -1) {
            return kVar;
        }
        kVar.field_status = 4;
        kVar.field_duration = j;
        i.aEo().a(kVar);
        return kVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<com.tencent.mm.plugin.ipcall.a.g.k> aEQ() {
        /*
        r8 = java.lang.System.currentTimeMillis();
        r0 = com.tencent.mm.plugin.ipcall.a.i.aEo();
        r1 = java.util.Calendar.getInstance();
        r2 = 6;
        r3 = -30;
        r1.add(r2, r3);
        r6 = r1.getTimeInMillis();
        r0 = r0.gUz;
        r1 = "IPCallRecord";
        r2 = com.tencent.mm.plugin.ipcall.a.g.l.mRf;
        r3 = "calltime>=?";
        r4 = 1;
        r4 = new java.lang.String[r4];
        r5 = 0;
        r6 = java.lang.String.valueOf(r6);
        r4[r5] = r6;
        r5 = "addressId, phonenumber";
        r6 = 0;
        r7 = "calltime desc";
        r0 = r0.query(r1, r2, r3, r4, r5, r6, r7);
        r1 = r0.getCount();
        r2 = 30;
        if (r1 >= r2) goto L_0x01b4;
    L_0x003d:
        r0.close();
        r0 = com.tencent.mm.plugin.ipcall.a.i.aEo();
        r0 = r0.gUz;
        r1 = "IPCallRecord";
        r2 = com.tencent.mm.plugin.ipcall.a.g.l.mRf;
        r3 = 0;
        r4 = 0;
        r5 = "addressId, phonenumber";
        r6 = 0;
        r7 = "calltime desc";
        r0 = r0.query(r1, r2, r3, r4, r5, r6, r7);
        r1 = r0;
    L_0x0059:
        r2 = java.lang.System.currentTimeMillis();
        r0 = "MicroMsg.IPCallRecordStorageLogic";
        r4 = "finish query used %dms";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r2 = r2 - r8;
        r2 = java.lang.Long.valueOf(r2);
        r5[r6] = r2;
        com.tencent.mm.sdk.platformtools.w.d(r0, r4, r5);
        r4 = new java.util.HashMap;
        r4.<init>();
        r5 = new java.util.ArrayList;
        r5.<init>();
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x00cd }
        if (r0 == 0) goto L_0x01af;
    L_0x0081:
        r0 = r1.isAfterLast();	 Catch:{ Exception -> 0x00cd }
        if (r0 != 0) goto L_0x01af;
    L_0x0087:
        r0 = r5.size();	 Catch:{ Exception -> 0x00cd }
        r2 = 30;
        if (r0 > r2) goto L_0x01af;
    L_0x008f:
        r6 = new com.tencent.mm.plugin.ipcall.a.g.k;	 Catch:{ Exception -> 0x00cd }
        r6.<init>();	 Catch:{ Exception -> 0x00cd }
        r6.b(r1);	 Catch:{ Exception -> 0x00cd }
        r2 = r6.field_addressId;	 Catch:{ Exception -> 0x00cd }
        r10 = -1;
        r0 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
        if (r0 == 0) goto L_0x00fd;
    L_0x009f:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00cd }
        r0.<init>();	 Catch:{ Exception -> 0x00cd }
        r2 = r6.field_addressId;	 Catch:{ Exception -> 0x00cd }
        r0 = r0.append(r2);	 Catch:{ Exception -> 0x00cd }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00cd }
        r0 = r4.containsKey(r0);	 Catch:{ Exception -> 0x00cd }
        if (r0 != 0) goto L_0x00c9;
    L_0x00b4:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00cd }
        r0.<init>();	 Catch:{ Exception -> 0x00cd }
        r2 = r6.field_addressId;	 Catch:{ Exception -> 0x00cd }
        r0 = r0.append(r2);	 Catch:{ Exception -> 0x00cd }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00cd }
        r4.put(r0, r6);	 Catch:{ Exception -> 0x00cd }
        r5.add(r6);	 Catch:{ Exception -> 0x00cd }
    L_0x00c9:
        r1.moveToNext();	 Catch:{ Exception -> 0x00cd }
        goto L_0x0081;
    L_0x00cd:
        r0 = move-exception;
        r2 = "MicroMsg.IPCallRecordStorageLogic";
        r3 = "getRecentRecordGroupByUser error: %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0152 }
        r6 = 0;
        r0 = r0.getMessage();	 Catch:{ all -> 0x0152 }
        r4[r6] = r0;	 Catch:{ all -> 0x0152 }
        com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);	 Catch:{ all -> 0x0152 }
        r1.close();
    L_0x00e4:
        r0 = java.lang.System.currentTimeMillis();
        r2 = "MicroMsg.IPCallRecordStorageLogic";
        r3 = "getRecentRecordGroupByUser, used: %dms";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r6 = 0;
        r0 = r0 - r8;
        r0 = java.lang.Long.valueOf(r0);
        r4[r6] = r0;
        com.tencent.mm.sdk.platformtools.w.d(r2, r3, r4);
        return r5;
    L_0x00fd:
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ Exception -> 0x00cd }
        r2 = r6.field_phonenumber;	 Catch:{ Exception -> 0x00cd }
        r0 = com.tencent.mm.plugin.ipcall.b.a.aj(r0, r2);	 Catch:{ Exception -> 0x00cd }
        r2 = com.tencent.mm.plugin.ipcall.a.i.aEn();	 Catch:{ Exception -> 0x00cd }
        r7 = r2.yu(r0);	 Catch:{ Exception -> 0x00cd }
        if (r7 == 0) goto L_0x019d;
    L_0x0111:
        r0 = com.tencent.mm.plugin.ipcall.a.i.aEo();	 Catch:{ Exception -> 0x00cd }
        r2 = r0.gUz;	 Catch:{ Exception -> 0x00cd }
        r2 = r2 instanceof com.tencent.mm.bj.g;	 Catch:{ Exception -> 0x00cd }
        if (r2 == 0) goto L_0x0157;
    L_0x011b:
        r0 = r0.gUz;	 Catch:{ Exception -> 0x00cd }
        r0 = (com.tencent.mm.bj.g) r0;	 Catch:{ Exception -> 0x00cd }
        r2 = -1;
        r2 = r0.cs(r2);	 Catch:{ Exception -> 0x00cd }
    L_0x0125:
        r0 = com.tencent.mm.plugin.ipcall.a.i.aEo();	 Catch:{ Exception -> 0x00cd }
        r10 = r6.field_phonenumber;	 Catch:{ Exception -> 0x00cd }
        r0 = r0.yx(r10);	 Catch:{ Exception -> 0x00cd }
        r10 = r0.moveToFirst();	 Catch:{ Exception -> 0x00cd }
        if (r10 == 0) goto L_0x015a;
    L_0x0135:
        r10 = r0.isAfterLast();	 Catch:{ Exception -> 0x00cd }
        if (r10 != 0) goto L_0x015a;
    L_0x013b:
        r10 = new com.tencent.mm.plugin.ipcall.a.g.k;	 Catch:{ Exception -> 0x00cd }
        r10.<init>();	 Catch:{ Exception -> 0x00cd }
        r10.b(r0);	 Catch:{ Exception -> 0x00cd }
        r12 = r7.uxb;	 Catch:{ Exception -> 0x00cd }
        r10.field_addressId = r12;	 Catch:{ Exception -> 0x00cd }
        r11 = com.tencent.mm.plugin.ipcall.a.i.aEo();	 Catch:{ Exception -> 0x00cd }
        r11.a(r10);	 Catch:{ Exception -> 0x00cd }
        r0.moveToNext();	 Catch:{ Exception -> 0x00cd }
        goto L_0x0135;
    L_0x0152:
        r0 = move-exception;
        r1.close();
        throw r0;
    L_0x0157:
        r2 = -1;
        goto L_0x0125;
    L_0x015a:
        r0 = com.tencent.mm.plugin.ipcall.a.i.aEo();	 Catch:{ Exception -> 0x00cd }
        r7 = r0.gUz;	 Catch:{ Exception -> 0x00cd }
        r7 = r7 instanceof com.tencent.mm.bj.g;	 Catch:{ Exception -> 0x00cd }
        if (r7 == 0) goto L_0x0171;
    L_0x0164:
        r10 = -1;
        r7 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
        if (r7 == 0) goto L_0x0171;
    L_0x016a:
        r0 = r0.gUz;	 Catch:{ Exception -> 0x00cd }
        r0 = (com.tencent.mm.bj.g) r0;	 Catch:{ Exception -> 0x00cd }
        r0.aD(r2);	 Catch:{ Exception -> 0x00cd }
    L_0x0171:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00cd }
        r0.<init>();	 Catch:{ Exception -> 0x00cd }
        r2 = r6.field_addressId;	 Catch:{ Exception -> 0x00cd }
        r0 = r0.append(r2);	 Catch:{ Exception -> 0x00cd }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00cd }
        r0 = r4.containsKey(r0);	 Catch:{ Exception -> 0x00cd }
        if (r0 != 0) goto L_0x00c9;
    L_0x0186:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00cd }
        r0.<init>();	 Catch:{ Exception -> 0x00cd }
        r2 = r6.field_addressId;	 Catch:{ Exception -> 0x00cd }
        r0 = r0.append(r2);	 Catch:{ Exception -> 0x00cd }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00cd }
        r4.put(r0, r6);	 Catch:{ Exception -> 0x00cd }
        r5.add(r6);	 Catch:{ Exception -> 0x00cd }
        goto L_0x00c9;
    L_0x019d:
        r0 = r6.field_phonenumber;	 Catch:{ Exception -> 0x00cd }
        r0 = r4.containsKey(r0);	 Catch:{ Exception -> 0x00cd }
        if (r0 != 0) goto L_0x00c9;
    L_0x01a5:
        r0 = r6.field_phonenumber;	 Catch:{ Exception -> 0x00cd }
        r4.put(r0, r6);	 Catch:{ Exception -> 0x00cd }
        r5.add(r6);	 Catch:{ Exception -> 0x00cd }
        goto L_0x00c9;
    L_0x01af:
        r1.close();
        goto L_0x00e4;
    L_0x01b4:
        r1 = r0;
        goto L_0x0059;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ipcall.a.g.m.aEQ():java.util.ArrayList<com.tencent.mm.plugin.ipcall.a.g.k>");
    }
}
