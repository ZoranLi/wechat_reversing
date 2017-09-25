package com.tencent.mm.plugin.a;

import com.tencent.mm.sdk.platformtools.w;
import java.io.InputStream;

public final class b {
    public long ilE = -1;
    public long ilF = -1;
    public long ilG = -1;
    public a ilH = null;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long mC(java.lang.String r14) {
        /*
        r13 = this;
        r0 = -1;
        r12 = 0;
        r2 = com.tencent.mm.plugin.a.c.mA(r14);
        if (r2 == 0) goto L_0x0013;
    L_0x0009:
        r2 = "MicroMsg.AtomParsers";
        r3 = "calc moov atom location but filepath is null.";
        com.tencent.mm.sdk.platformtools.w.w(r2, r3);
    L_0x0012:
        return r0;
    L_0x0013:
        r8 = new java.io.File;
        r8.<init>(r14);
        r3 = 0;
        r4 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x00b8, all -> 0x00dd }
        r4.<init>(r14);	 Catch:{ Exception -> 0x00b8, all -> 0x00dd }
        r2 = r8.length();	 Catch:{ Exception -> 0x00f7, all -> 0x00f2 }
        r13.ilG = r2;	 Catch:{ Exception -> 0x00f7, all -> 0x00f2 }
        r2 = r13.h(r4);	 Catch:{ Exception -> 0x00f7, all -> 0x00f2 }
        if (r2 != 0) goto L_0x007d;
    L_0x002a:
        r2 = "MicroMsg.AtomParsers";
        r3 = "has no atom, this file may be not mp4";
        com.tencent.mm.sdk.platformtools.w.w(r2, r3);	 Catch:{ Exception -> 0x00f7, all -> 0x00f2 }
        r2 = r0;
    L_0x0034:
        r4.close();	 Catch:{ IOException -> 0x00ab }
    L_0x0037:
        r13.ilE = r2;
        r13.ilF = r0;
        r0 = "MicroMsg.AtomParsers";
        r1 = new java.lang.StringBuilder;
        r4 = "calc moov atom location moovAtomLocation : ";
        r1.<init>(r4);
        r1 = r1.append(r2);
        r4 = " moovSize : ";
        r1 = r1.append(r4);
        r4 = r13.ilF;
        r1 = r1.append(r4);
        r4 = " file length : ";
        r1 = r1.append(r4);
        r4 = r8.length();
        r6 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r4 = r4 / r6;
        r1 = r1.append(r4);
        r4 = " K file path: ";
        r1 = r1.append(r4);
        r1 = r1.append(r14);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.w.i(r0, r1);
        r0 = r2;
        goto L_0x0012;
    L_0x007d:
        r3 = r2.ND();	 Catch:{ Exception -> 0x00f7, all -> 0x00f2 }
        if (r3 == 0) goto L_0x008b;
    L_0x0083:
        r6 = r2.ilD;	 Catch:{ Exception -> 0x00f7, all -> 0x00f2 }
        r0 = r2.getSize();	 Catch:{ Exception -> 0x00fc, all -> 0x00f2 }
        r2 = r6;
        goto L_0x0034;
    L_0x008b:
        r3 = r2.NE();	 Catch:{ Exception -> 0x00f7, all -> 0x00f2 }
        if (r3 == 0) goto L_0x009c;
    L_0x0091:
        r2 = "MicroMsg.AtomParsers";
        r3 = "it is the final atom, but can not find moov atom.";
        com.tencent.mm.sdk.platformtools.w.w(r2, r3);	 Catch:{ Exception -> 0x00f7, all -> 0x00f2 }
        r2 = r0;
        goto L_0x0034;
    L_0x009c:
        r6 = r2.getSize();	 Catch:{ Exception -> 0x00f7, all -> 0x00f2 }
        r10 = 0;
        r3 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1));
        if (r3 <= 0) goto L_0x0101;
    L_0x00a6:
        r2 = r2.NF();	 Catch:{ Exception -> 0x00f7, all -> 0x00f2 }
        goto L_0x0034;
    L_0x00ab:
        r4 = move-exception;
        r5 = "MicroMsg.AtomParsers";
        r6 = "";
        r7 = new java.lang.Object[r12];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x0037;
    L_0x00b8:
        r2 = move-exception;
        r4 = r2;
        r5 = r3;
        r2 = r0;
    L_0x00bc:
        r6 = "MicroMsg.AtomParsers";
        r7 = "";
        r9 = 0;
        r9 = new java.lang.Object[r9];	 Catch:{ all -> 0x00f4 }
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r6, r4, r7, r9);	 Catch:{ all -> 0x00f4 }
        if (r5 == 0) goto L_0x0037;
    L_0x00ca:
        r5.close();	 Catch:{ IOException -> 0x00cf }
        goto L_0x0037;
    L_0x00cf:
        r4 = move-exception;
        r5 = "MicroMsg.AtomParsers";
        r6 = "";
        r7 = new java.lang.Object[r12];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x0037;
    L_0x00dd:
        r0 = move-exception;
        r4 = r3;
    L_0x00df:
        if (r4 == 0) goto L_0x00e4;
    L_0x00e1:
        r4.close();	 Catch:{ IOException -> 0x00e5 }
    L_0x00e4:
        throw r0;
    L_0x00e5:
        r1 = move-exception;
        r2 = "MicroMsg.AtomParsers";
        r3 = "";
        r4 = new java.lang.Object[r12];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r2, r1, r3, r4);
        goto L_0x00e4;
    L_0x00f2:
        r0 = move-exception;
        goto L_0x00df;
    L_0x00f4:
        r0 = move-exception;
        r4 = r5;
        goto L_0x00df;
    L_0x00f7:
        r2 = move-exception;
        r5 = r4;
        r4 = r2;
        r2 = r0;
        goto L_0x00bc;
    L_0x00fc:
        r2 = move-exception;
        r5 = r4;
        r4 = r2;
        r2 = r6;
        goto L_0x00bc;
    L_0x0101:
        r2 = r0;
        goto L_0x0034;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.a.b.mC(java.lang.String):long");
    }

    private a h(InputStream inputStream) {
        Throwable e;
        if (0 < 0) {
            w.w("MicroMsg.AtomParsers", "find Moov Atom, but parameter is error.");
            return null;
        }
        a aVar = null;
        a aVar2;
        try {
            if (inputStream.skip(0) < 0) {
                return null;
            }
            long j = 0;
            byte[] bArr = new byte[8];
            int read = inputStream.read(bArr, 0, 8);
            while (read >= 8) {
                try {
                    int l = c.l(bArr, 0);
                    int l2 = c.l(bArr, 4);
                    long j2 = 0;
                    if (l == 1) {
                        if (inputStream.read(bArr, 0, 8) < 8) {
                            break;
                        }
                        j2 = c.I(bArr);
                    }
                    this.ilH = aVar;
                    aVar2 = new a(l, j, l2, j2);
                    try {
                        if (aVar2.ND() || aVar2.NE()) {
                            return aVar2;
                        }
                        long j3;
                        if (l > 1) {
                            j3 = (long) (l - 8);
                            j += (long) l;
                        } else if (j2 <= 0) {
                            return aVar2;
                        } else {
                            j += j2;
                            j3 = (j2 - 8) - 8;
                        }
                        if (inputStream.skip(j3) < j3) {
                            return aVar2;
                        }
                        aVar = aVar2;
                        read = inputStream.read(bArr, 0, 8);
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable e3) {
                    e = e3;
                    aVar2 = aVar;
                }
            }
            return aVar;
        } catch (Throwable e32) {
            e = e32;
            aVar2 = null;
            w.printErrStackTrace("MicroMsg.AtomParsers", e, "", new Object[0]);
            return aVar2;
        }
    }
}
