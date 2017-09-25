package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel;

import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.f;
import com.tencent.mm.y.k;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class b implements f {
    boolean fKF = false;
    private Random gVa = new Random();
    boolean htv = false;
    List<String> jJK = new LinkedList();
    public HashSet<String> jJL = new HashSet();
    d jJM;
    e jJN;
    boolean jJO = false;
    long jJP;
    long jJQ;
    int jJR;
    int jJS = 0;
    int jJT = 0;
    int jJU = 0;
    long jJV = 0;
    private long jJW = 0;
    private long jJX = 0;
    public Object lock = new Object();

    public final void cancel() {
        w.i("MicroMsg.BakUploadPackerMove", "cancel");
        this.htv = true;
        com.tencent.mm.plugin.backup.f.b.b(6, this.jJN);
        this.jJM = null;
        this.jJO = false;
        this.jJR = 0;
        this.jJU = 0;
        this.jJV = 0;
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean l(java.lang.String r19, java.lang.String r20, int r21) {
        /*
        r18 = this;
        r5 = new com.tencent.mm.pointers.PLong;
        r5.<init>();
        r2 = java.lang.System.currentTimeMillis();
        r4 = com.tencent.mm.plugin.backup.g.a.abC();
        r4 = r4.abD();
        r4 = r4.wT();
        r0 = r19;
        r15 = r4.Ar(r0);
        r0 = r18;
        r4 = r0.jJS;
        r6 = (long) r4;
        r8 = java.lang.System.currentTimeMillis();
        r2 = r8 - r2;
        r2 = r2 + r6;
        r2 = (int) r2;
        r0 = r18;
        r0.jJS = r2;
        r9 = new java.util.LinkedList;
        r9.<init>();
        r6 = new java.util.LinkedList;
        r6.<init>();
        r2 = r15.moveToFirst();	 Catch:{ all -> 0x0096 }
        if (r2 == 0) goto L_0x01e7;
    L_0x003c:
        r13 = r9;
        r14 = r21;
    L_0x003f:
        r2 = r15.isAfterLast();	 Catch:{ all -> 0x0096 }
        if (r2 != 0) goto L_0x01e6;
    L_0x0045:
        r0 = r18;
        r3 = r0.lock;	 Catch:{ all -> 0x0096 }
        monitor-enter(r3);	 Catch:{ all -> 0x0096 }
        r0 = r18;
        r2 = r0.jJL;	 Catch:{ all -> 0x0093 }
        r2 = r2.size();	 Catch:{ all -> 0x0093 }
        r4 = 8;
        if (r2 <= r4) goto L_0x005d;
    L_0x0056:
        r0 = r18;
        r2 = r0.lock;	 Catch:{ InterruptedException -> 0x0250 }
        r2.wait();	 Catch:{ InterruptedException -> 0x0250 }
    L_0x005d:
        r0 = r18;
        r2 = r0.fKF;	 Catch:{ all -> 0x0093 }
        if (r2 == 0) goto L_0x0070;
    L_0x0063:
        r0 = r18;
        r2 = r0.htv;	 Catch:{ all -> 0x0093 }
        if (r2 != 0) goto L_0x0070;
    L_0x0069:
        r0 = r18;
        r2 = r0.lock;	 Catch:{ InterruptedException -> 0x0085 }
        r2.wait();	 Catch:{ InterruptedException -> 0x0085 }
    L_0x0070:
        r0 = r18;
        r2 = r0.htv;	 Catch:{ all -> 0x0093 }
        if (r2 == 0) goto L_0x009b;
    L_0x0076:
        r2 = "MicroMsg.BakUploadPackerMove";
        r4 = "backupImp cancel";
        com.tencent.mm.sdk.platformtools.w.i(r2, r4);	 Catch:{ all -> 0x0093 }
        monitor-exit(r3);	 Catch:{ all -> 0x0093 }
        r15.close();
        r2 = 0;
    L_0x0084:
        return r2;
    L_0x0085:
        r2 = move-exception;
        r4 = "MicroMsg.BakUploadPackerMove";
        r7 = "";
        r8 = 0;
        r8 = new java.lang.Object[r8];	 Catch:{ all -> 0x0093 }
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r4, r2, r7, r8);	 Catch:{ all -> 0x0093 }
        goto L_0x0070;
    L_0x0093:
        r2 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0093 }
        throw r2;	 Catch:{ all -> 0x0096 }
    L_0x0096:
        r2 = move-exception;
        r15.close();
        throw r2;
    L_0x009b:
        monitor-exit(r3);	 Catch:{ all -> 0x0093 }
        r2 = new com.tencent.mm.storage.au;	 Catch:{ all -> 0x0096 }
        r2.<init>();	 Catch:{ all -> 0x0096 }
        r2.b(r15);	 Catch:{ all -> 0x0096 }
        r12 = 0;
        r16 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x013c }
        r3 = 0;
        r7 = 0;
        if (r14 <= 0) goto L_0x0139;
    L_0x00ad:
        r8 = 1;
    L_0x00ae:
        r9 = 0;
        r10 = 0;
        r4 = r20;
        r3 = com.tencent.mm.plugin.backup.e.a.a.a(r2, r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ Exception -> 0x013c }
        r0 = r18;
        r2 = r0.jJT;	 Catch:{ Exception -> 0x024d }
        r8 = (long) r2;	 Catch:{ Exception -> 0x024d }
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x024d }
        r10 = r10 - r16;
        r8 = r8 + r10;
        r2 = (int) r8;	 Catch:{ Exception -> 0x024d }
        r0 = r18;
        r0.jJT = r2;	 Catch:{ Exception -> 0x024d }
        r2 = r14 + -1;
        r4 = r2;
    L_0x00cb:
        if (r3 == 0) goto L_0x00d0;
    L_0x00cd:
        r13.add(r3);	 Catch:{ all -> 0x0096 }
    L_0x00d0:
        r0 = r18;
        r2 = r0.jJU;	 Catch:{ all -> 0x0096 }
        r3 = r6.size();	 Catch:{ all -> 0x0096 }
        r2 = r2 + r3;
        r0 = r18;
        r0.jJU = r2;	 Catch:{ all -> 0x0096 }
        r3 = r6.iterator();	 Catch:{ all -> 0x0096 }
    L_0x00e1:
        r2 = r3.hasNext();	 Catch:{ all -> 0x0096 }
        if (r2 == 0) goto L_0x0163;
    L_0x00e7:
        r2 = r3.next();	 Catch:{ all -> 0x0096 }
        r2 = (com.tencent.mm.plugin.backup.h.u) r2;	 Catch:{ all -> 0x0096 }
        r7 = new com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.h;	 Catch:{ all -> 0x0096 }
        r8 = r2.mediaId;	 Catch:{ all -> 0x0096 }
        r9 = 2;
        r10 = 0;
        r11 = r2.path;	 Catch:{ all -> 0x0096 }
        r12 = r18;
        r7.<init>(r8, r9, r10, r11, r12);	 Catch:{ all -> 0x0096 }
        r0 = r18;
        r8 = r0.jJV;	 Catch:{ all -> 0x0096 }
        r10 = r7.jHw;	 Catch:{ all -> 0x0096 }
        r10 = r10.jOh;	 Catch:{ all -> 0x0096 }
        r10 = (long) r10;	 Catch:{ all -> 0x0096 }
        r8 = r8 + r10;
        r0 = r18;
        r0.jJV = r8;	 Catch:{ all -> 0x0096 }
        r0 = r18;
        r8 = r0.lock;	 Catch:{ all -> 0x0096 }
        monitor-enter(r8);	 Catch:{ all -> 0x0096 }
        r7.abt();	 Catch:{ all -> 0x0136 }
        r0 = r18;
        r7 = r0.jJL;	 Catch:{ all -> 0x0136 }
        r2 = r2.mediaId;	 Catch:{ all -> 0x0136 }
        r7.add(r2);	 Catch:{ all -> 0x0136 }
        r2 = "MicroMsg.BakUploadPackerMove";
        r7 = "backupChatMsg now: size:%d";
        r9 = 1;
        r9 = new java.lang.Object[r9];	 Catch:{ all -> 0x0136 }
        r10 = 0;
        r0 = r18;
        r11 = r0.jJL;	 Catch:{ all -> 0x0136 }
        r11 = r11.size();	 Catch:{ all -> 0x0136 }
        r11 = java.lang.Integer.valueOf(r11);	 Catch:{ all -> 0x0136 }
        r9[r10] = r11;	 Catch:{ all -> 0x0136 }
        com.tencent.mm.sdk.platformtools.w.i(r2, r7, r9);	 Catch:{ all -> 0x0136 }
        monitor-exit(r8);	 Catch:{ all -> 0x0136 }
        goto L_0x00e1;
    L_0x0136:
        r2 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x0136 }
        throw r2;	 Catch:{ all -> 0x0096 }
    L_0x0139:
        r8 = 0;
        goto L_0x00ae;
    L_0x013c:
        r2 = move-exception;
        r3 = r12;
    L_0x013e:
        r4 = "MicroMsg.BakUploadPackerMove";
        r7 = "";
        r8 = 0;
        r8 = new java.lang.Object[r8];	 Catch:{ all -> 0x0096 }
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r4, r2, r7, r8);	 Catch:{ all -> 0x0096 }
        r4 = "MicroMsg.BakUploadPackerMove";
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0096 }
        r8 = "backupChatMsg %s";
        r7.<init>(r8);	 Catch:{ all -> 0x0096 }
        r2 = r7.append(r2);	 Catch:{ all -> 0x0096 }
        r2 = r2.toString();	 Catch:{ all -> 0x0096 }
        com.tencent.mm.sdk.platformtools.w.f(r4, r2);	 Catch:{ all -> 0x0096 }
        r4 = r14;
        goto L_0x00cb;
    L_0x0163:
        r6.clear();	 Catch:{ all -> 0x0096 }
        r2 = r5.value;	 Catch:{ all -> 0x0096 }
        r8 = 262144; // 0x40000 float:3.67342E-40 double:1.295163E-318;
        r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r2 <= 0) goto L_0x01dd;
    L_0x016f:
        r2 = "MicroMsg.BakUploadPackerMove";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0096 }
        r7 = "limitSize ";
        r3.<init>(r7);	 Catch:{ all -> 0x0096 }
        r8 = r5.value;	 Catch:{ all -> 0x0096 }
        r3 = r3.append(r8);	 Catch:{ all -> 0x0096 }
        r3 = r3.toString();	 Catch:{ all -> 0x0096 }
        com.tencent.mm.sdk.platformtools.w.d(r2, r3);	 Catch:{ all -> 0x0096 }
        r0 = r18;
        r2 = r0.gVa;	 Catch:{ all -> 0x0096 }
        r8 = a(r2);	 Catch:{ all -> 0x0096 }
        r7 = new com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.h;	 Catch:{ all -> 0x0096 }
        r9 = 1;
        r11 = "";
        r10 = r13;
        r12 = r18;
        r7.<init>(r8, r9, r10, r11, r12);	 Catch:{ all -> 0x0096 }
        r0 = r18;
        r2 = r0.jJV;	 Catch:{ all -> 0x0096 }
        r9 = r7.jHw;	 Catch:{ all -> 0x0096 }
        r9 = r9.jOh;	 Catch:{ all -> 0x0096 }
        r10 = (long) r9;	 Catch:{ all -> 0x0096 }
        r2 = r2 + r10;
        r0 = r18;
        r0.jJV = r2;	 Catch:{ all -> 0x0096 }
        r0 = r18;
        r3 = r0.lock;	 Catch:{ all -> 0x0096 }
        monitor-enter(r3);	 Catch:{ all -> 0x0096 }
        r7.abt();	 Catch:{ all -> 0x01e3 }
        r0 = r18;
        r2 = r0.jJL;	 Catch:{ all -> 0x01e3 }
        r2.add(r8);	 Catch:{ all -> 0x01e3 }
        r2 = "MicroMsg.BakUploadPackerMove";
        r7 = "backupChatMsg now: size:%d";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ all -> 0x01e3 }
        r9 = 0;
        r0 = r18;
        r10 = r0.jJL;	 Catch:{ all -> 0x01e3 }
        r10 = r10.size();	 Catch:{ all -> 0x01e3 }
        r10 = java.lang.Integer.valueOf(r10);	 Catch:{ all -> 0x01e3 }
        r8[r9] = r10;	 Catch:{ all -> 0x01e3 }
        com.tencent.mm.sdk.platformtools.w.i(r2, r7, r8);	 Catch:{ all -> 0x01e3 }
        monitor-exit(r3);	 Catch:{ all -> 0x01e3 }
        r13 = new java.util.LinkedList;	 Catch:{ all -> 0x0096 }
        r13.<init>();	 Catch:{ all -> 0x0096 }
        r2 = 0;
        r5.value = r2;	 Catch:{ all -> 0x0096 }
    L_0x01dd:
        r15.moveToNext();	 Catch:{ all -> 0x0096 }
        r14 = r4;
        goto L_0x003f;
    L_0x01e3:
        r2 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x01e3 }
        throw r2;	 Catch:{ all -> 0x0096 }
    L_0x01e6:
        r9 = r13;
    L_0x01e7:
        r2 = r5.value;	 Catch:{ all -> 0x0096 }
        r6 = 0;
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 <= 0) goto L_0x0244;
    L_0x01ef:
        r0 = r18;
        r2 = r0.gVa;	 Catch:{ all -> 0x0096 }
        r7 = a(r2);	 Catch:{ all -> 0x0096 }
        r6 = new com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.h;	 Catch:{ all -> 0x0096 }
        r8 = 1;
        r10 = "";
        r11 = r18;
        r6.<init>(r7, r8, r9, r10, r11);	 Catch:{ all -> 0x0096 }
        r0 = r18;
        r2 = r0.jJV;	 Catch:{ all -> 0x0096 }
        r4 = r6.jHw;	 Catch:{ all -> 0x0096 }
        r4 = r4.jOh;	 Catch:{ all -> 0x0096 }
        r8 = (long) r4;	 Catch:{ all -> 0x0096 }
        r2 = r2 + r8;
        r0 = r18;
        r0.jJV = r2;	 Catch:{ all -> 0x0096 }
        r0 = r18;
        r3 = r0.lock;	 Catch:{ all -> 0x0096 }
        monitor-enter(r3);	 Catch:{ all -> 0x0096 }
        r6.abt();	 Catch:{ all -> 0x024a }
        r0 = r18;
        r2 = r0.jJL;	 Catch:{ all -> 0x024a }
        r2.add(r7);	 Catch:{ all -> 0x024a }
        r2 = "MicroMsg.BakUploadPackerMove";
        r4 = "backupChatMsg now: size:%d";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x024a }
        r7 = 0;
        r0 = r18;
        r8 = r0.jJL;	 Catch:{ all -> 0x024a }
        r8 = r8.size();	 Catch:{ all -> 0x024a }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ all -> 0x024a }
        r6[r7] = r8;	 Catch:{ all -> 0x024a }
        com.tencent.mm.sdk.platformtools.w.i(r2, r4, r6);	 Catch:{ all -> 0x024a }
        monitor-exit(r3);	 Catch:{ all -> 0x024a }
        r2 = 0;
        r5.value = r2;	 Catch:{ all -> 0x0096 }
        r2 = new java.util.LinkedList;	 Catch:{ all -> 0x0096 }
        r2.<init>();	 Catch:{ all -> 0x0096 }
    L_0x0244:
        r15.close();
        r2 = 1;
        goto L_0x0084;
    L_0x024a:
        r2 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x024a }
        throw r2;	 Catch:{ all -> 0x0096 }
    L_0x024d:
        r2 = move-exception;
        goto L_0x013e;
    L_0x0250:
        r2 = move-exception;
        goto L_0x005d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.b.l(java.lang.String, java.lang.String, int):boolean");
    }

    public final void abV() {
        if (this.jJO && !this.htv) {
            synchronized (this.lock) {
                if (this.jJL.isEmpty()) {
                    com.tencent.mm.plugin.backup.f.b.b(6, this.jJN);
                    if (this.jJM != null) {
                        this.jJM.abW();
                    } else {
                        w.i("MicroMsg.BakUploadPackerMove", "operatorCallback is null");
                    }
                    cancel();
                    w.i("MicroMsg.BakUploadPackerMove", "send backup finish cmd");
                }
            }
        }
    }

    private static String a(Random random) {
        return g.n((bg.NA() + random.nextDouble()).getBytes());
    }

    public final void a(int i, int i2, k kVar) {
        this.jJQ += (long) i;
        int i3 = this.jJP == 0 ? 0 : (int) ((this.jJQ * 100) / this.jJP);
        if (i3 > this.jJR) {
            this.jJR = i3;
            h.setProgress(this.jJR);
        }
        if (this.jJW == 0 || bg.aB(this.jJW) >= 100) {
            this.jJW = bg.NA();
            if (this.jJX == 0) {
                this.jJX = bg.NA();
            }
            if (this.jJQ > this.jJP) {
                this.jJQ = this.jJP;
            }
            if (this.jJQ == 0) {
                this.jJQ = 1;
            }
            int i4 = ((int) (((this.jJW - this.jJX) * (this.jJP - this.jJQ)) / this.jJQ)) / 1000;
            if (!this.fKF && !this.htv && this.jJM != null && this.jJR >= 0 && this.jJR <= 100) {
                this.jJM.b(this.jJQ, this.jJP, i4);
            }
        }
    }
}
