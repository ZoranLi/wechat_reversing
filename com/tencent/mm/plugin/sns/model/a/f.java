package com.tencent.mm.plugin.sns.model.a;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.a.b.a;

public final class f extends b {
    public f(a aVar, a aVar2) {
        super(aVar, aVar2);
    }

    public final String FK(String str) {
        return str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.io.InputStream r11, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r12) {
        /*
        r10 = this;
        r0 = "MicroMsg.SnsDownloadSight";
        r1 = "download sight. %s ";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = r10.pYD;
        r5 = r5.getPath();
        r4 = r4.append(r5);
        r5 = r10.pYD;
        r5 = r5.bfv();
        r4 = r4.append(r5);
        r4 = r4.toString();
        r4 = com.tencent.mm.modelsfs.f.kq(r4);
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.w.i(r0, r1, r2);
        r1 = 0;
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r4 = new byte[r0];	 Catch:{ Exception -> 0x00d9 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00d9 }
        r0.<init>();	 Catch:{ Exception -> 0x00d9 }
        r2 = r10.pYD;	 Catch:{ Exception -> 0x00d9 }
        r2 = r2.getPath();	 Catch:{ Exception -> 0x00d9 }
        r0 = r0.append(r2);	 Catch:{ Exception -> 0x00d9 }
        r2 = r10.pYD;	 Catch:{ Exception -> 0x00d9 }
        r2 = r2.bfv();	 Catch:{ Exception -> 0x00d9 }
        r0 = r0.append(r2);	 Catch:{ Exception -> 0x00d9 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00d9 }
        r0 = com.tencent.mm.modelsfs.f.kq(r0);	 Catch:{ Exception -> 0x00d9 }
        r1 = com.tencent.mm.modelsfs.FileOp.gQ(r0);	 Catch:{ Exception -> 0x00d9 }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00d9 }
        r0 = r10.pYO;	 Catch:{ Exception -> 0x00d9 }
        r5 = "";
        r0.value = r5;	 Catch:{ Exception -> 0x00d9 }
        r0 = 0;
    L_0x0066:
        r5 = r11.read(r4);	 Catch:{ Exception -> 0x00d9 }
        r6 = -1;
        if (r5 == r6) goto L_0x00c8;
    L_0x006d:
        r0 = r10.pYP;	 Catch:{ Exception -> 0x00d9 }
        if (r5 <= r0) goto L_0x0079;
    L_0x0071:
        r10.pYP = r5;	 Catch:{ Exception -> 0x00d9 }
        r6 = com.tencent.mm.sdk.platformtools.bg.Ny();	 Catch:{ Exception -> 0x00d9 }
        r10.pYQ = r6;	 Catch:{ Exception -> 0x00d9 }
    L_0x0079:
        r6 = r10.pYR;	 Catch:{ Exception -> 0x00d9 }
        r8 = 0;
        r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r0 != 0) goto L_0x0089;
    L_0x0081:
        r6 = r10.pYS;	 Catch:{ Exception -> 0x00d9 }
        r6 = com.tencent.mm.sdk.platformtools.bg.aA(r6);	 Catch:{ Exception -> 0x00d9 }
        r10.pYR = r6;	 Catch:{ Exception -> 0x00d9 }
    L_0x0089:
        r0 = com.tencent.mm.plugin.sns.model.ae.xv();	 Catch:{ Exception -> 0x00d9 }
        r0 = com.tencent.mm.plugin.sns.data.i.EN(r0);	 Catch:{ Exception -> 0x00d9 }
        if (r0 != 0) goto L_0x00ae;
    L_0x0093:
        r1.close();	 Catch:{ Exception -> 0x00d9 }
        r11.close();	 Catch:{ Exception -> 0x00d9 }
        if (r1 == 0) goto L_0x009e;
    L_0x009b:
        r1.close();	 Catch:{ IOException -> 0x00a0 }
    L_0x009e:
        r0 = 0;
    L_0x009f:
        return r0;
    L_0x00a0:
        r0 = move-exception;
        r1 = "MicroMsg.SnsDownloadSight";
        r2 = "";
        r3 = 0;
        r3 = new java.lang.Object[r3];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r1, r0, r2, r3);
        goto L_0x009e;
    L_0x00ae:
        r0 = 0;
        r1.write(r4, r0, r5);	 Catch:{ Exception -> 0x00d9 }
        r0 = r10.pYX;	 Catch:{ Exception -> 0x00d9 }
        r0 = r0 + r5;
        r10.pYX = r0;	 Catch:{ Exception -> 0x00d9 }
        r0 = 1;
        r5 = r10.pYX;	 Catch:{ Exception -> 0x00d9 }
        r6 = r10.pYO;	 Catch:{ Exception -> 0x00d9 }
        r5 = com.tencent.mm.plugin.sns.model.a.b.a(r5, r2, r6);	 Catch:{ Exception -> 0x00d9 }
        if (r5 == 0) goto L_0x0066;
    L_0x00c2:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00d9 }
        r0 = 0;
        goto L_0x0066;
    L_0x00c8:
        r1.close();	 Catch:{ Exception -> 0x00d9 }
        r1 = 0;
        if (r0 == 0) goto L_0x00d7;
    L_0x00ce:
        r0 = r10.pYX;	 Catch:{ Exception -> 0x00d9 }
        r2 = 0;
        r4 = r10.pYO;	 Catch:{ Exception -> 0x00d9 }
        com.tencent.mm.plugin.sns.model.a.b.a(r0, r2, r4);	 Catch:{ Exception -> 0x00d9 }
    L_0x00d7:
        r0 = 1;
        goto L_0x009f;
    L_0x00d9:
        r0 = move-exception;
        r2 = "MicroMsg.SnsDownloadSight";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0118 }
        r4 = "snscdndownload fail : ";
        r3.<init>(r4);	 Catch:{ all -> 0x0118 }
        r4 = r0.getMessage();	 Catch:{ all -> 0x0118 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0118 }
        r3 = r3.toString();	 Catch:{ all -> 0x0118 }
        r4 = 0;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0118 }
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r2, r0, r3, r4);	 Catch:{ all -> 0x0118 }
        r2 = "MicroMsg.SnsDownloadSight";
        r3 = "";
        r4 = 0;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0118 }
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r2, r0, r3, r4);	 Catch:{ all -> 0x0118 }
        if (r1 == 0) goto L_0x0108;
    L_0x0105:
        r1.close();	 Catch:{ IOException -> 0x010a }
    L_0x0108:
        r0 = 0;
        goto L_0x009f;
    L_0x010a:
        r0 = move-exception;
        r1 = "MicroMsg.SnsDownloadSight";
        r2 = "";
        r3 = 0;
        r3 = new java.lang.Object[r3];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r1, r0, r2, r3);
        goto L_0x0108;
    L_0x0118:
        r0 = move-exception;
        if (r1 == 0) goto L_0x011e;
    L_0x011b:
        r1.close();	 Catch:{ IOException -> 0x011f }
    L_0x011e:
        throw r0;
    L_0x011f:
        r1 = move-exception;
        r2 = "MicroMsg.SnsDownloadSight";
        r3 = "";
        r4 = 0;
        r4 = new java.lang.Object[r4];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r2, r1, r3, r4);
        goto L_0x011e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.model.a.f.a(java.io.InputStream, java.util.Map):boolean");
    }

    public final boolean bfx() {
        FileOp.h(this.pYD.getPath(), this.pYD.bfv(), i.j(this.fVV));
        return true;
    }

    protected final int bfy() {
        return 2;
    }
}
