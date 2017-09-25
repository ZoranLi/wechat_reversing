package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.a.g;
import com.tencent.mm.plugin.backup.bakoldlogic.a.c;
import com.tencent.mm.plugin.backup.bakoldlogic.c.a;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.f;
import com.tencent.mm.y.k;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class d implements f {
    private boolean fKF = false;
    private Random gVa = new Random();
    private boolean htv = false;
    List<String> jJK = new LinkedList();
    public HashSet<String> jJL = new HashSet();
    e jJN;
    boolean jJO = false;
    private long jJP;
    private long jJQ;
    int jJR;
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.d jLG;
    public int jLH = 0;
    public Object lock = new Object();

    public final void pause() {
        w.i("MicroMsg.BakPCServer", "pause");
        this.fKF = true;
    }

    public final void resume() {
        w.i("MicroMsg.BakPCServer", "resume");
        this.fKF = false;
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
    }

    public final void cancel() {
        w.i("MicroMsg.BakPCServer", "cancel");
        this.htv = true;
        b.b(5, this.jJN);
        this.jLG = null;
        this.jJO = false;
        this.jJR = 0;
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean l(java.lang.String r15, java.lang.String r16, int r17) {
        /*
        r14 = this;
        r3 = new com.tencent.mm.pointers.PLong;
        r3.<init>();
        r0 = com.tencent.mm.plugin.backup.g.a.abC();
        r0 = r0.abD();
        r0 = r0.wT();
        r13 = r0.Ar(r15);
        r7 = new java.util.LinkedList;
        r7.<init>();
        r4 = new java.util.LinkedList;
        r4.<init>();
        r0 = r13.moveToFirst();	 Catch:{ all -> 0x0071 }
        if (r0 == 0) goto L_0x017d;
    L_0x0025:
        r12 = r7;
        r11 = r17;
    L_0x0028:
        r0 = r13.isAfterLast();	 Catch:{ all -> 0x0071 }
        if (r0 != 0) goto L_0x017c;
    L_0x002e:
        r1 = r14.lock;	 Catch:{ all -> 0x0071 }
        monitor-enter(r1);	 Catch:{ all -> 0x0071 }
        r0 = r14.jJL;	 Catch:{ all -> 0x006e }
        r0 = r0.size();	 Catch:{ all -> 0x006e }
        r2 = 10;
        if (r0 <= r2) goto L_0x0040;
    L_0x003b:
        r0 = r14.lock;	 Catch:{ InterruptedException -> 0x01d2 }
        r0.wait();	 Catch:{ InterruptedException -> 0x01d2 }
    L_0x0040:
        r0 = r14.fKF;	 Catch:{ all -> 0x006e }
        if (r0 == 0) goto L_0x004d;
    L_0x0044:
        r0 = r14.htv;	 Catch:{ all -> 0x006e }
        if (r0 != 0) goto L_0x004d;
    L_0x0048:
        r0 = r14.lock;	 Catch:{ InterruptedException -> 0x0060 }
        r0.wait();	 Catch:{ InterruptedException -> 0x0060 }
    L_0x004d:
        r0 = r14.htv;	 Catch:{ all -> 0x006e }
        if (r0 == 0) goto L_0x0076;
    L_0x0051:
        r0 = "MicroMsg.BakPCServer";
        r2 = "backupImp cancel";
        com.tencent.mm.sdk.platformtools.w.i(r0, r2);	 Catch:{ all -> 0x006e }
        monitor-exit(r1);	 Catch:{ all -> 0x006e }
        r13.close();
        r0 = 0;
    L_0x005f:
        return r0;
    L_0x0060:
        r0 = move-exception;
        r2 = "MicroMsg.BakPCServer";
        r5 = "";
        r6 = 0;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x006e }
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r2, r0, r5, r6);	 Catch:{ all -> 0x006e }
        goto L_0x004d;
    L_0x006e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x006e }
        throw r0;	 Catch:{ all -> 0x0071 }
    L_0x0071:
        r0 = move-exception;
        r13.close();
        throw r0;
    L_0x0076:
        monitor-exit(r1);	 Catch:{ all -> 0x006e }
        r0 = new com.tencent.mm.storage.au;	 Catch:{ all -> 0x0071 }
        r0.<init>();	 Catch:{ all -> 0x0071 }
        r0.b(r13);	 Catch:{ all -> 0x0071 }
        r10 = 0;
        r1 = 0;
        r5 = 0;
        if (r11 <= 0) goto L_0x00e2;
    L_0x0084:
        r6 = 1;
    L_0x0085:
        r7 = 0;
        r8 = 0;
        r2 = r16;
        r0 = com.tencent.mm.plugin.backup.e.a.a.a(r0, r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ Exception -> 0x00e4 }
        r1 = r11 + -1;
    L_0x0090:
        if (r0 == 0) goto L_0x0095;
    L_0x0092:
        r12.add(r0);	 Catch:{ all -> 0x0071 }
    L_0x0095:
        r2 = r4.iterator();	 Catch:{ all -> 0x0071 }
    L_0x0099:
        r0 = r2.hasNext();	 Catch:{ all -> 0x0071 }
        if (r0 == 0) goto L_0x010a;
    L_0x009f:
        r0 = r2.next();	 Catch:{ all -> 0x0071 }
        r0 = (com.tencent.mm.plugin.backup.h.u) r0;	 Catch:{ all -> 0x0071 }
        r5 = new com.tencent.mm.plugin.backup.bakoldlogic.c.b;	 Catch:{ all -> 0x0071 }
        r6 = r0.mediaId;	 Catch:{ all -> 0x0071 }
        r7 = 2;
        r8 = 0;
        r9 = r0.path;	 Catch:{ all -> 0x0071 }
        r10 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg();	 Catch:{ all -> 0x0071 }
        r11 = r10.jBs;	 Catch:{ all -> 0x0071 }
        r10 = r14;
        r5.<init>(r6, r7, r8, r9, r10, r11);	 Catch:{ all -> 0x0071 }
        r6 = r14.lock;	 Catch:{ all -> 0x0071 }
        monitor-enter(r6);	 Catch:{ all -> 0x0071 }
        r5.abt();	 Catch:{ all -> 0x00df }
        r5 = r14.jJL;	 Catch:{ all -> 0x00df }
        r0 = r0.mediaId;	 Catch:{ all -> 0x00df }
        r5.add(r0);	 Catch:{ all -> 0x00df }
        r0 = "MicroMsg.BakPCServer";
        r5 = "backupChatMsg now: size:%d";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x00df }
        r8 = 0;
        r9 = r14.jJL;	 Catch:{ all -> 0x00df }
        r9 = r9.size();	 Catch:{ all -> 0x00df }
        r9 = java.lang.Integer.valueOf(r9);	 Catch:{ all -> 0x00df }
        r7[r8] = r9;	 Catch:{ all -> 0x00df }
        com.tencent.mm.sdk.platformtools.w.i(r0, r5, r7);	 Catch:{ all -> 0x00df }
        monitor-exit(r6);	 Catch:{ all -> 0x00df }
        goto L_0x0099;
    L_0x00df:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x00df }
        throw r0;	 Catch:{ all -> 0x0071 }
    L_0x00e2:
        r6 = 0;
        goto L_0x0085;
    L_0x00e4:
        r0 = move-exception;
        r1 = "MicroMsg.BakPCServer";
        r2 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0071 }
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r1, r0, r2, r5);	 Catch:{ all -> 0x0071 }
        r1 = "MicroMsg.BakPCServer";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0071 }
        r5 = "backupChatMsg %s";
        r2.<init>(r5);	 Catch:{ all -> 0x0071 }
        r0 = r2.append(r0);	 Catch:{ all -> 0x0071 }
        r0 = r0.toString();	 Catch:{ all -> 0x0071 }
        com.tencent.mm.sdk.platformtools.w.f(r1, r0);	 Catch:{ all -> 0x0071 }
        r0 = r10;
        r1 = r11;
        goto L_0x0090;
    L_0x010a:
        r4.clear();	 Catch:{ all -> 0x0071 }
        r6 = r3.value;	 Catch:{ all -> 0x0071 }
        r8 = 262144; // 0x40000 float:3.67342E-40 double:1.295163E-318;
        r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r0 <= 0) goto L_0x0173;
    L_0x0116:
        r0 = "MicroMsg.BakPCServer";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0071 }
        r5 = "limitSize ";
        r2.<init>(r5);	 Catch:{ all -> 0x0071 }
        r6 = r3.value;	 Catch:{ all -> 0x0071 }
        r2 = r2.append(r6);	 Catch:{ all -> 0x0071 }
        r2 = r2.toString();	 Catch:{ all -> 0x0071 }
        com.tencent.mm.sdk.platformtools.w.d(r0, r2);	 Catch:{ all -> 0x0071 }
        r0 = r14.gVa;	 Catch:{ all -> 0x0071 }
        r6 = a(r0);	 Catch:{ all -> 0x0071 }
        r5 = new com.tencent.mm.plugin.backup.bakoldlogic.c.b;	 Catch:{ all -> 0x0071 }
        r7 = 1;
        r9 = "";
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg();	 Catch:{ all -> 0x0071 }
        r11 = r0.jBs;	 Catch:{ all -> 0x0071 }
        r8 = r12;
        r10 = r14;
        r5.<init>(r6, r7, r8, r9, r10, r11);	 Catch:{ all -> 0x0071 }
        r2 = r14.lock;	 Catch:{ all -> 0x0071 }
        monitor-enter(r2);	 Catch:{ all -> 0x0071 }
        r5.abt();	 Catch:{ all -> 0x0179 }
        r0 = r14.jJL;	 Catch:{ all -> 0x0179 }
        r0.add(r6);	 Catch:{ all -> 0x0179 }
        r0 = "MicroMsg.BakPCServer";
        r5 = "backupChatMsg now: size:%d";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x0179 }
        r7 = 0;
        r8 = r14.jJL;	 Catch:{ all -> 0x0179 }
        r8 = r8.size();	 Catch:{ all -> 0x0179 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ all -> 0x0179 }
        r6[r7] = r8;	 Catch:{ all -> 0x0179 }
        com.tencent.mm.sdk.platformtools.w.i(r0, r5, r6);	 Catch:{ all -> 0x0179 }
        monitor-exit(r2);	 Catch:{ all -> 0x0179 }
        r12 = new java.util.LinkedList;	 Catch:{ all -> 0x0071 }
        r12.<init>();	 Catch:{ all -> 0x0071 }
        r6 = 0;
        r3.value = r6;	 Catch:{ all -> 0x0071 }
    L_0x0173:
        r13.moveToNext();	 Catch:{ all -> 0x0071 }
        r11 = r1;
        goto L_0x0028;
    L_0x0179:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0179 }
        throw r0;	 Catch:{ all -> 0x0071 }
    L_0x017c:
        r7 = r12;
    L_0x017d:
        r0 = r3.value;	 Catch:{ all -> 0x0071 }
        r4 = 0;
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 <= 0) goto L_0x01c9;
    L_0x0185:
        r0 = r14.gVa;	 Catch:{ all -> 0x0071 }
        r5 = a(r0);	 Catch:{ all -> 0x0071 }
        r4 = new com.tencent.mm.plugin.backup.bakoldlogic.c.b;	 Catch:{ all -> 0x0071 }
        r6 = 1;
        r8 = "";
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg();	 Catch:{ all -> 0x0071 }
        r10 = r0.jBs;	 Catch:{ all -> 0x0071 }
        r9 = r14;
        r4.<init>(r5, r6, r7, r8, r9, r10);	 Catch:{ all -> 0x0071 }
        r1 = r14.lock;	 Catch:{ all -> 0x0071 }
        monitor-enter(r1);	 Catch:{ all -> 0x0071 }
        r4.abt();	 Catch:{ all -> 0x01cf }
        r0 = r14.jJL;	 Catch:{ all -> 0x01cf }
        r0.add(r5);	 Catch:{ all -> 0x01cf }
        r0 = "MicroMsg.BakPCServer";
        r2 = "backupChatMsg now: size:%d";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x01cf }
        r5 = 0;
        r6 = r14.jJL;	 Catch:{ all -> 0x01cf }
        r6 = r6.size();	 Catch:{ all -> 0x01cf }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x01cf }
        r4[r5] = r6;	 Catch:{ all -> 0x01cf }
        com.tencent.mm.sdk.platformtools.w.i(r0, r2, r4);	 Catch:{ all -> 0x01cf }
        monitor-exit(r1);	 Catch:{ all -> 0x01cf }
        r0 = 0;
        r3.value = r0;	 Catch:{ all -> 0x0071 }
        r0 = new java.util.LinkedList;	 Catch:{ all -> 0x0071 }
        r0.<init>();	 Catch:{ all -> 0x0071 }
    L_0x01c9:
        r13.close();
        r0 = 1;
        goto L_0x005f;
    L_0x01cf:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x01cf }
        throw r0;	 Catch:{ all -> 0x0071 }
    L_0x01d2:
        r0 = move-exception;
        goto L_0x0040;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.d.l(java.lang.String, java.lang.String, int):boolean");
    }

    public final void abV() {
        if (this.jJO && !this.htv) {
            synchronized (this.lock) {
                if (this.jJL.isEmpty()) {
                    a.acg().ach().jLS = c.jJm;
                    a.acg().ach().jLT = c.jJc;
                    b.b(5, this.jJN);
                    new a(5).abt();
                    c aci = a.acg().aci();
                    aci.jLC++;
                    if (this.jLG != null) {
                        this.jLG.abW();
                    } else {
                        w.i("MicroMsg.BakPCServer", "operatorCallback is null");
                    }
                    cancel();
                    w.i("MicroMsg.BakPCServer", "send backup finish cmd");
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
            com.tencent.mm.plugin.backup.bakoldlogic.c.b.setProgress(this.jJR);
            if (!this.fKF && !this.htv && this.jLG != null && this.jJR >= 0 && this.jJR <= 100) {
                this.jLG.jC(this.jJR);
            }
        }
    }
}
