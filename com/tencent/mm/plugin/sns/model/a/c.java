package com.tencent.mm.plugin.sns.model.a;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.t;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.a.b.a;
import com.tencent.mm.sdk.platformtools.w;

public final class c extends b {
    private long pYY = 0;
    private int pYZ = 0;

    public c(a aVar, a aVar2) {
        super(aVar, aVar2);
    }

    public final String FK(String str) {
        return str;
    }

    public final boolean bfw() {
        return false;
    }

    public final t b(t tVar) {
        this.pYY = FileOp.ki(this.pYD.getPath() + this.pYD.bfv());
        if (this.pYY > 0) {
            w.i("MicroMsg.SnsDownloadAdSight", "appendHttpArg range " + this.pYY);
            tVar.setRequestProperty("RANGE", "bytes=" + this.pYY + "-");
        }
        return tVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.io.InputStream r14, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r15) {
        /*
        r13 = this;
        r1 = 0;
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r5 = new byte[r0];	 Catch:{ Exception -> 0x012e }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x012e }
        r0.<init>();	 Catch:{ Exception -> 0x012e }
        r2 = r13.pYD;	 Catch:{ Exception -> 0x012e }
        r2 = r2.getPath();	 Catch:{ Exception -> 0x012e }
        r0 = r0.append(r2);	 Catch:{ Exception -> 0x012e }
        r2 = r13.pYD;	 Catch:{ Exception -> 0x012e }
        r2 = r2.bfv();	 Catch:{ Exception -> 0x012e }
        r0 = r0.append(r2);	 Catch:{ Exception -> 0x012e }
        r6 = r0.toString();	 Catch:{ Exception -> 0x012e }
        r0 = com.tencent.mm.modelsfs.f.kq(r6);	 Catch:{ Exception -> 0x012e }
        r2 = com.tencent.mm.modelsfs.FileOp.ki(r0);	 Catch:{ Exception -> 0x012e }
        r0 = "MicroMsg.SnsDownloadAdSight";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x012e }
        r7 = "getdatabegin ";
        r4.<init>(r7);	 Catch:{ Exception -> 0x012e }
        r2 = r4.append(r2);	 Catch:{ Exception -> 0x012e }
        r2 = r2.toString();	 Catch:{ Exception -> 0x012e }
        com.tencent.mm.sdk.platformtools.w.i(r0, r2);	 Catch:{ Exception -> 0x012e }
        r1 = com.tencent.mm.modelsfs.FileOp.kg(r6);	 Catch:{ Exception -> 0x012e }
        r4 = 1;
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x012e }
        r0 = r13.pYO;	 Catch:{ Exception -> 0x012e }
        r7 = "";
        r0.value = r7;	 Catch:{ Exception -> 0x012e }
        r0 = 0;
        r12 = r0;
        r0 = r4;
        r4 = r12;
    L_0x0054:
        r7 = r14.read(r5);	 Catch:{ Exception -> 0x012e }
        r8 = -1;
        if (r7 == r8) goto L_0x00e5;
    L_0x005b:
        r8 = r13.pYR;	 Catch:{ Exception -> 0x012e }
        r10 = 0;
        r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r4 != 0) goto L_0x006b;
    L_0x0063:
        r8 = r13.pYS;	 Catch:{ Exception -> 0x012e }
        r8 = com.tencent.mm.sdk.platformtools.bg.aA(r8);	 Catch:{ Exception -> 0x012e }
        r13.pYR = r8;	 Catch:{ Exception -> 0x012e }
    L_0x006b:
        r4 = r13.pYP;	 Catch:{ Exception -> 0x012e }
        if (r7 <= r4) goto L_0x0077;
    L_0x006f:
        r13.pYP = r7;	 Catch:{ Exception -> 0x012e }
        r8 = com.tencent.mm.sdk.platformtools.bg.Ny();	 Catch:{ Exception -> 0x012e }
        r13.pYQ = r8;	 Catch:{ Exception -> 0x012e }
    L_0x0077:
        r4 = com.tencent.mm.plugin.sns.model.ae.xv();	 Catch:{ Exception -> 0x012e }
        r4 = com.tencent.mm.plugin.sns.data.i.EN(r4);	 Catch:{ Exception -> 0x012e }
        if (r4 != 0) goto L_0x00a5;
    L_0x0081:
        r0 = "MicroMsg.SnsDownloadAdSight";
        r2 = "read data";
        com.tencent.mm.sdk.platformtools.w.i(r0, r2);	 Catch:{ Exception -> 0x012e }
        r1.close();	 Catch:{ Exception -> 0x012e }
        r14.close();	 Catch:{ Exception -> 0x012e }
        if (r1 == 0) goto L_0x0095;
    L_0x0092:
        r1.close();	 Catch:{ IOException -> 0x0097 }
    L_0x0095:
        r0 = 0;
    L_0x0096:
        return r0;
    L_0x0097:
        r0 = move-exception;
        r1 = "MicroMsg.SnsDownloadAdSight";
        r2 = "";
        r3 = 0;
        r3 = new java.lang.Object[r3];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r1, r0, r2, r3);
        goto L_0x0095;
    L_0x00a5:
        r4 = 0;
        r1.write(r5, r4, r7);	 Catch:{ Exception -> 0x012e }
        r4 = r13.pYX;	 Catch:{ Exception -> 0x012e }
        r4 = r4 + r7;
        r13.pYX = r4;	 Catch:{ Exception -> 0x012e }
        r4 = r13.pYX;	 Catch:{ Exception -> 0x012e }
        r7 = r13.pYZ;	 Catch:{ Exception -> 0x012e }
        r4 = r4 - r7;
        r7 = 409600; // 0x64000 float:5.73972E-40 double:2.023693E-318;
        r7 = r7 * r0;
        if (r4 <= r7) goto L_0x00d3;
    L_0x00b9:
        r4 = com.tencent.mm.plugin.sns.model.ae.beG();	 Catch:{ Exception -> 0x012e }
        r7 = r13.pYD;	 Catch:{ Exception -> 0x012e }
        r7 = r7.mediaId;	 Catch:{ Exception -> 0x012e }
        r8 = com.tencent.mm.plugin.sns.model.ae.ayz();	 Catch:{ Exception -> 0x012e }
        r9 = new com.tencent.mm.plugin.sns.model.b$3;	 Catch:{ Exception -> 0x012e }
        r9.<init>(r4, r7, r6);	 Catch:{ Exception -> 0x012e }
        r8.post(r9);	 Catch:{ Exception -> 0x012e }
        r4 = r13.pYX;	 Catch:{ Exception -> 0x012e }
        r13.pYZ = r4;	 Catch:{ Exception -> 0x012e }
        r0 = r0 + 1;
    L_0x00d3:
        r4 = 1;
        r7 = r13.pYX;	 Catch:{ Exception -> 0x012e }
        r8 = r13.pYO;	 Catch:{ Exception -> 0x012e }
        r7 = com.tencent.mm.plugin.sns.model.a.b.a(r7, r2, r8);	 Catch:{ Exception -> 0x012e }
        if (r7 == 0) goto L_0x0054;
    L_0x00de:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x012e }
        r4 = 0;
        goto L_0x0054;
    L_0x00e5:
        r1.close();	 Catch:{ Exception -> 0x012e }
        r1 = 0;
        if (r4 == 0) goto L_0x00f4;
    L_0x00eb:
        r0 = r13.pYX;	 Catch:{ Exception -> 0x012e }
        r2 = 0;
        r4 = r13.pYO;	 Catch:{ Exception -> 0x012e }
        com.tencent.mm.plugin.sns.model.a.b.a(r0, r2, r4);	 Catch:{ Exception -> 0x012e }
    L_0x00f4:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r13.pYD;
        r1 = r1.getPath();
        r0 = r0.append(r1);
        r1 = r13.pYD;
        r1 = r1.bfv();
        r0 = r0.append(r1);
        r0 = r0.toString();
        r0 = com.tencent.mm.modelsfs.FileOp.ki(r0);
        r2 = "MicroMsg.SnsDownloadAdSight";
        r3 = new java.lang.StringBuilder;
        r4 = "getdataend2  ";
        r3.<init>(r4);
        r0 = r3.append(r0);
        r0 = r0.toString();
        com.tencent.mm.sdk.platformtools.w.i(r2, r0);
        r0 = 1;
        goto L_0x0096;
    L_0x012e:
        r0 = move-exception;
        r2 = "MicroMsg.SnsDownloadAdSight";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x016e }
        r4 = "snscdndownload fail : ";
        r3.<init>(r4);	 Catch:{ all -> 0x016e }
        r4 = r0.getMessage();	 Catch:{ all -> 0x016e }
        r3 = r3.append(r4);	 Catch:{ all -> 0x016e }
        r3 = r3.toString();	 Catch:{ all -> 0x016e }
        r4 = 0;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x016e }
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r2, r0, r3, r4);	 Catch:{ all -> 0x016e }
        r2 = "MicroMsg.SnsDownloadAdSight";
        r3 = "";
        r4 = 0;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x016e }
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r2, r0, r3, r4);	 Catch:{ all -> 0x016e }
        if (r1 == 0) goto L_0x015d;
    L_0x015a:
        r1.close();	 Catch:{ IOException -> 0x0160 }
    L_0x015d:
        r0 = 0;
        goto L_0x0096;
    L_0x0160:
        r0 = move-exception;
        r1 = "MicroMsg.SnsDownloadAdSight";
        r2 = "";
        r3 = 0;
        r3 = new java.lang.Object[r3];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r1, r0, r2, r3);
        goto L_0x015d;
    L_0x016e:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0174;
    L_0x0171:
        r1.close();	 Catch:{ IOException -> 0x0175 }
    L_0x0174:
        throw r0;
    L_0x0175:
        r1 = move-exception;
        r2 = "MicroMsg.SnsDownloadAdSight";
        r3 = "";
        r4 = 0;
        r4 = new java.lang.Object[r4];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r2, r1, r3, r4);
        goto L_0x0174;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.model.a.c.a(java.io.InputStream, java.util.Map):boolean");
    }

    public final boolean bfx() {
        long ki = FileOp.ki(this.pYD.getPath() + this.pYD.bfv());
        w.i("MicroMsg.SnsDownloadAdSight", "preceeData  downloadLen " + ki + " " + this.pYU);
        if (ki < ((long) this.pYU) + this.pYY) {
            return false;
        }
        FileOp.h(this.pYD.getPath(), this.pYD.bfv(), i.k(this.fVV));
        return true;
    }

    protected final int bfy() {
        return 4;
    }
}
