package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel;

import android.os.Looper;
import com.tencent.mm.a.e;
import com.tencent.mm.e.a.qg;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.backup.b.f;
import com.tencent.mm.plugin.backup.bakoldlogic.a.d;
import com.tencent.mm.plugin.backup.g.a;
import com.tencent.mm.plugin.zero.b.b;
import com.tencent.mm.protocal.c.ei;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class k {
    public static int jBq;
    private boolean htv;
    private boolean jCK = false;
    final int jCN;
    private long jCO = 0;
    public b jCQ = ((b) h.h(b.class));
    private c<qg> jCR;
    public d jJM;
    private long jJW = 0;
    public int jKA = 0;
    public int jKB = 0;
    public int jKC = 0;
    public int jKD = 0;
    public final List<String> jKz;
    private Object lock = new Object();

    public k(List<String> list, int i) {
        w.i("MicroMsg.RecoverMerger", "new RecoverMerger, msgDataIdList size:%d, totalSession:%d", new Object[]{Integer.valueOf(list.size()), Integer.valueOf(i)});
        this.jKz = list;
        this.jCN = i;
    }

    public final synchronized void ace() {
        if (this.jCK) {
            w.e("MicroMsg.RecoverMerger", "hasStartMerge , return");
        } else {
            this.jCK = true;
            w.i("MicroMsg.RecoverMerger", "start merge and call pause sync");
            jBq = -22;
            if (this.jCR == null) {
                this.jCR = new c<qg>(this) {
                    final /* synthetic */ k jKE;

                    {
                        this.jKE = r2;
                        this.usg = qg.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        if (this.jKE.jCQ.bCi().zY()) {
                            this.jKE.aau();
                            w.i("MicroMsg.RecoverMerger", "sync pause and start init tempdb");
                            StringBuilder stringBuilder = new StringBuilder();
                            ap.yY();
                            e.d(new File(stringBuilder.append(com.tencent.mm.u.c.vo()).append(".tem").toString()));
                            stringBuilder = new StringBuilder();
                            ap.yY();
                            e.d(new File(stringBuilder.append(com.tencent.mm.u.c.vp()).append(".tem").toString()));
                            a.abC().a(new a.a(this) {
                                final /* synthetic */ AnonymousClass1 jKF;

                                {
                                    this.jKF = r1;
                                }

                                public final void run() {
                                    k kVar = this.jKF.jKE;
                                    ap.yY();
                                    com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uFA, Boolean.valueOf(true));
                                    kVar.jKA = kVar.getItemCount();
                                    w.i("MicroMsg.RecoverMerger", "readFromSdcard start, sessionSize:%d , itemCnt:%d", new Object[]{Integer.valueOf(kVar.jCN), Integer.valueOf(kVar.jKA)});
                                    com.tencent.mm.sdk.f.e.d(new Runnable(kVar) {
                                        final /* synthetic */ k jKE;

                                        {
                                            this.jKE = r1;
                                        }

                                        public final void run() {
                                            Throwable e;
                                            Looper.prepare();
                                            f.reset();
                                            f.aaw();
                                            com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.c cVar = new com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.c();
                                            cVar.begin();
                                            HashMap hashMap = new HashMap();
                                            HashSet hashSet = new HashSet();
                                            int i = 0;
                                            for (String str : this.jKE.jKz) {
                                                String str2 = com.tencent.mm.plugin.backup.a.h.aan() + "backupItem/" + d.rD(str2) + str2;
                                                int a;
                                                try {
                                                    long Nz = bg.Nz();
                                                    a = this.jKE.a(str2, hashMap, cVar, hashSet);
                                                    this.jKE.jKC = (int) (bg.aA(Nz) + ((long) this.jKE.jKC));
                                                    if (a < 0) {
                                                        cVar.end();
                                                        w.w("MicroMsg.RecoverMerger", "Thread has been canceled");
                                                        return;
                                                    }
                                                    a += i;
                                                    try {
                                                        this.jKE.bF(a, this.jKE.jKA);
                                                        w.i("MicroMsg.RecoverMerger", "recover has done,  msgsuccItem:%d, dealCount:%d, totalCnt:%d", new Object[]{Integer.valueOf(a), Integer.valueOf(this.jKE.jKD), Integer.valueOf(this.jKE.jKA)});
                                                        i = a;
                                                    } catch (Exception e2) {
                                                        e = e2;
                                                        w.printErrStackTrace("MicroMsg.RecoverMerger", e, "recoverFromSdcard MMThread.run():", new Object[0]);
                                                        i = a;
                                                    }
                                                } catch (Throwable e3) {
                                                    Throwable th = e3;
                                                    a = i;
                                                    e = th;
                                                    w.printErrStackTrace("MicroMsg.RecoverMerger", e, "recoverFromSdcard MMThread.run():", new Object[0]);
                                                    i = a;
                                                }
                                            }
                                            this.jKE.jKB = hashSet.size();
                                            com.tencent.mm.plugin.backup.g.d.d(hashMap);
                                            w.i("MicroMsg.RecoverMerger", "build temDB finish!");
                                            cVar.end();
                                            this.jKE.bF(100, 100);
                                            w.bIP();
                                            a.abC().n(new Runnable(this) {
                                                final /* synthetic */ AnonymousClass2 jKG;

                                                {
                                                    this.jKG = r1;
                                                }

                                                public final void run() {
                                                    w.i("MicroMsg.RecoverMerger", "readFromSdcard end");
                                                    w.bIP();
                                                    if (k.jBq != -22 || this.jKG.jKE.jJM == null) {
                                                        w.i("MicroMsg.RecoverMerger", "operatorCallback is null");
                                                    } else {
                                                        this.jKG.jKE.jJM.aac();
                                                    }
                                                    this.jKG.jKE.jCQ.bCi().zU();
                                                    this.jKG.jKE.aau();
                                                    w.i("MicroMsg.RecoverMerger", "recover ok and restart sync");
                                                    ap.yY();
                                                    com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uFA, Boolean.valueOf(false));
                                                    this.jKG.jKE.aat();
                                                }
                                            });
                                            Looper.loop();
                                        }
                                    }, "RecoverMerger_recoverFromSdcard", 1).start();
                                }
                            }, true, -22);
                        }
                        return false;
                    }
                };
                com.tencent.mm.sdk.b.a.urY.b(this.jCR);
            }
            this.jCQ.bCi().O(3600000);
        }
    }

    public final int getItemCount() {
        int i = 0;
        for (String str : this.jKz) {
            try {
                i = ((ei) new ei().aD(e.d(com.tencent.mm.plugin.backup.a.h.aan() + "backupItem/" + d.rD(str) + str, 0, -1))).jNe.size() + i;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.RecoverMerger", e, "getItemCount: ", new Object[0]);
            }
        }
        return i;
    }

    public final void bF(final int i, final int i2) {
        if (this.jJW == 0 || bg.aB(this.jJW) >= 100) {
            this.jJW = bg.NA();
            if (!this.htv && this.jJM != null) {
                af.v(new Runnable(this) {
                    final /* synthetic */ k jKE;

                    public final void run() {
                        if (this.jKE.jJM != null) {
                            this.jKE.jJM.bE(i, i2);
                        } else {
                            w.e("MicroMsg.RecoverMerger", "operatorCallback is null.");
                        }
                    }
                });
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(java.lang.String r11, java.util.HashMap<java.lang.String, java.lang.Integer> r12, com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.c r13, java.util.HashSet<java.lang.String> r14) {
        /*
        r10 = this;
        r4 = java.lang.System.currentTimeMillis();
        r0 = 0;
        r1 = -1;
        r2 = com.tencent.mm.a.e.d(r11, r0, r1);
        r0 = new com.tencent.mm.protocal.c.ei;	 Catch:{ Exception -> 0x0054 }
        r0.<init>();	 Catch:{ Exception -> 0x0054 }
        r0 = r0.aD(r2);	 Catch:{ Exception -> 0x0054 }
        r0 = (com.tencent.mm.protocal.c.ei) r0;	 Catch:{ Exception -> 0x0054 }
        r1 = r0.jNe;
        r3 = r1.iterator();
    L_0x001b:
        r1 = r3.hasNext();
        if (r1 == 0) goto L_0x00c6;
    L_0x0021:
        r1 = r3.next();
        r1 = (com.tencent.mm.protocal.c.eh) r1;
        r2 = r10.lock;
        monitor-enter(r2);
        r6 = r10.htv;	 Catch:{ all -> 0x00b5 }
        if (r6 == 0) goto L_0x0076;
    L_0x002e:
        r0 = com.tencent.mm.plugin.report.service.g.oUh;	 Catch:{ all -> 0x00b5 }
        r1 = 11790; // 0x2e0e float:1.6521E-41 double:5.825E-320;
        r3 = 2;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x00b5 }
        r4 = 0;
        r5 = 0;
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x00b5 }
        r3[r4] = r5;	 Catch:{ all -> 0x00b5 }
        r4 = 1;
        r5 = 0;
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x00b5 }
        r3[r4] = r5;	 Catch:{ all -> 0x00b5 }
        r0.i(r1, r3);	 Catch:{ all -> 0x00b5 }
        r0 = "MicroMsg.RecoverMerger";
        r1 = "backupImp canceled";
        com.tencent.mm.sdk.platformtools.w.i(r0, r1);	 Catch:{ all -> 0x00b5 }
        r0 = -1;
        monitor-exit(r2);	 Catch:{ all -> 0x00b5 }
    L_0x0053:
        return r0;
    L_0x0054:
        r0 = move-exception;
        r1 = r0;
        r3 = "MicroMsg.RecoverMerger";
        r4 = "read mmPath errr %s, %s, len:%d";
        r0 = 3;
        r5 = new java.lang.Object[r0];
        r0 = 0;
        r5[r0] = r11;
        r0 = 1;
        r5[r0] = r1;
        r6 = 2;
        if (r2 != 0) goto L_0x0074;
    L_0x0068:
        r0 = 0;
    L_0x0069:
        r0 = java.lang.Integer.valueOf(r0);
        r5[r6] = r0;
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r1, r4, r5);
        r0 = 0;
        goto L_0x0053;
    L_0x0074:
        r0 = r2.length;
        goto L_0x0069;
    L_0x0076:
        r6 = r10.jCO;	 Catch:{ all -> 0x00b5 }
        r6 = com.tencent.mm.sdk.platformtools.bg.aA(r6);	 Catch:{ all -> 0x00b5 }
        r8 = 1800000; // 0x1b7740 float:2.522337E-39 double:8.89318E-318;
        r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r6 <= 0) goto L_0x0095;
    L_0x0083:
        r6 = r10.jCQ;	 Catch:{ all -> 0x00b5 }
        r6 = r6.bCi();	 Catch:{ all -> 0x00b5 }
        r8 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
        r6.O(r8);	 Catch:{ all -> 0x00b5 }
        r6 = com.tencent.mm.sdk.platformtools.bg.Nz();	 Catch:{ all -> 0x00b5 }
        r10.jCO = r6;	 Catch:{ all -> 0x00b5 }
    L_0x0095:
        monitor-exit(r2);	 Catch:{ all -> 0x00b5 }
        r2 = new java.util.HashMap;	 Catch:{ Exception -> 0x00b8 }
        r2.<init>();	 Catch:{ Exception -> 0x00b8 }
        com.tencent.mm.plugin.backup.e.a.b.a(r1, r12, r14, r2);	 Catch:{ Exception -> 0x00b8 }
    L_0x009e:
        r2 = r10.jKD;
        r2 = r2 + 1;
        r10.jKD = r2;
        r2 = r10.jKD;
        r6 = r10.jKA;
        r10.bF(r2, r6);
        r1 = r1.jOc;
        com.tencent.mm.plugin.backup.b.f.jh(r1);
        r13.abQ();
        goto L_0x001b;
    L_0x00b5:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x00b5 }
        throw r0;
    L_0x00b8:
        r2 = move-exception;
        r6 = "MicroMsg.RecoverMerger";
        r7 = "readFromSdcard err";
        r8 = 0;
        r8 = new java.lang.Object[r8];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r6, r2, r7, r8);
        goto L_0x009e;
    L_0x00c6:
        com.tencent.mm.plugin.backup.b.f.aav();
        r1 = "MicroMsg.RecoverMerger";
        r2 = new java.lang.StringBuilder;
        r3 = "read item time ";
        r2.<init>(r3);
        r6 = java.lang.System.currentTimeMillis();
        r4 = r6 - r4;
        r2 = r2.append(r4);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.w.d(r1, r2);
        r0 = r0.jNe;
        r0 = r0.size();
        goto L_0x0053;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.k.a(java.lang.String, java.util.HashMap, com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.c, java.util.HashSet):int");
    }

    public final void cancel() {
        synchronized (this.lock) {
            w.i("MicroMsg.RecoverMerger", "cancel");
            this.htv = true;
            this.jCQ.bCi().zU();
            aau();
            w.i("MicroMsg.RecoverMerger", "recover cancel and restart sync");
            aat();
        }
    }

    public final void aat() {
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
        this.jJM = null;
        this.jCK = false;
        this.jKA = 0;
        this.jKB = 0;
        this.jKC = 0;
    }

    public final void aau() {
        if (this.jCR != null) {
            com.tencent.mm.sdk.b.a.urY.c(this.jCR);
            this.jCR = null;
        }
    }
}
